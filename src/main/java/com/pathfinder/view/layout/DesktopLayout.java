package com.pathfinder.view.layout;

import java.util.Locale;

import com.pathfinder.model.FreeRoomModel;
import com.pathfinder.model.ResourceModel;
import com.pathfinder.util.widgetset.DateTime;
import com.pathfinder.view.components.AccordionView;
import com.pathfinder.view.components.AccordionViewSpec;
import com.pathfinder.view.components.AppointmentView;
import com.pathfinder.view.components.AppointmentViewSpec;
import com.pathfinder.view.components.DateTimeSpec;
import com.pathfinder.view.components.FreeRoomView;
import com.pathfinder.view.components.FreeRoomViewSpec;
import com.pathfinder.view.components.Keyboard;
import com.pathfinder.view.components.KeyboardSpec;
import com.pathfinder.view.components.MenuBar;
import com.pathfinder.view.components.MenuBarSpec;
import com.pathfinder.view.components.SearchField;
import com.pathfinder.view.components.SearchFieldSpec;
import com.pathfinder.view.container.DetailContainer;
import com.pathfinder.view.container.DetailContainerSpec;
import com.pathfinder.view.container.SearchPanel;
import com.pathfinder.view.container.SearchPanelSpec;
import com.pathfinder.view.listener.KeyboardViewListenerSpec;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Defines the main layout of the stele/desktop navigation
 * 
 * @author alexh
 * 
 */
public class DesktopLayout extends CustomComponent implements DesktopLayoutSpec {
	private final DateTimeSpec dateTime = new DateTime();
	private final FreeRoomViewSpec freeRoom = new FreeRoomView();
	private final AccordionViewSpec accordionView = new AccordionView();
	private final KeyboardSpec keyboard = new Keyboard();
	private final SearchFieldSpec searchField = new SearchField();
	private final SearchPanelSpec searchPanel = new SearchPanel(
			(AccordionView) accordionView, (Keyboard) keyboard,
			(SearchField) searchField);
	private final MenuBarSpec menuBar = new MenuBar();
	private final DetailContainerSpec detailContainer = new DetailContainer();
	private final AppointmentViewSpec appointmentView = new AppointmentView();

	private final VerticalLayout layout = new VerticalLayout();

	public DesktopLayout() {
		this.buildLayout();
		this.setCompositionRoot(layout);
	}

	private void buildLayout() {
		this.layout.addComponent(dateTime);
		this.layout.addComponent(freeRoom);
		this.layout.addComponent(searchPanel);
		this.layout.addComponent(detailContainer);
		this.layout.addComponent(appointmentView);
		this.layout.addComponent(menuBar);
	}

	@Override
	public void addKeyboardListener(KeyboardViewListenerSpec listener) {
		this.keyboard.addListener(listener);
	}

	@Override
	public void addItemClickListenerRoomTable(ItemClickListener listener) {
		this.accordionView.addItemClickListenerRoomTable(listener);
	}

	@Override
	public void addItemClickListenerCourseTable(ItemClickListener listener) {
		this.accordionView.addItemClickListenerCourseTable(listener);
	}

	@Override
	public void addItemClickListenerPersonTable(ItemClickListener listener) {
		this.accordionView.addItemClickListenerPersonTable(listener);
	}

	@Override
	public void addItemClickListenerPoiTable(ItemClickListener listener) {
		this.accordionView.addItemClickListenerPoiTable(listener);
	}

	@Override
	public void addClickListenerHomeButton(ClickListener listener) {
		menuBar.addClickListenerHomeButton(listener);
	}

	@Override
	public void addClickListenerAppointmentButton(ClickListener listener) {
		menuBar.addClickListenerAppointmentButton(listener);
	}

	@Override
	public void addClickListenerWheelChairButton(ClickListener listener) {
		menuBar.addClickListenerWheelChairButton(listener);
	}

	@Override
	public void addClickListenerBackButton(ClickListener listener) {
		menuBar.addClickListenerBackButton(listener);
	}

	@Override
	public void addDeleteAllClickListener(ClickListener listener) {
		this.searchField.addDeleteAllClickListener(listener);
	}

	@Override
	public void setRoomContainer(
			BeanItemContainer<ResourceModel> beanItemContainer) {
		accordionView.setRoomContainer(beanItemContainer);
	}

	@Override
	public void setCourseContainer(
			BeanItemContainer<ResourceModel> beanItemContainer) {
		accordionView.setCourseContainer(beanItemContainer);
	}

	@Override
	public void setPersonContainer(
			BeanItemContainer<ResourceModel> beanItemContainer) {
		accordionView.setPersonContainer(beanItemContainer);
	}

	@Override
	public void setPoiContainer(
			BeanItemContainer<ResourceModel> beanItemContainer) {
		accordionView.setPoiContainer(beanItemContainer);
	}

	@Override
	public void useFiltersForAllTables(String searchString) {
		accordionView.useFiltersForAllTables(searchString);
	}

	@Override
	public void hideAppointmentButton() {
		menuBar.hideAppointmentButton();
	}

	@Override
	public void showAppointmentButton() {
		menuBar.showAppointmentButton();
	}

	@Override
	public void switchToSearchView() {
		// Hiding
		appointmentView.hideAppointmentView();
		// TODO
		// detailContainer.hideDetailContainer();
		// detailContainer.removeDetails(...);

		// Adapting MenuBar
		menuBar.replaceHomeButtonWithWheelChairButton();
		menuBar.replaceBackButtonWithAppointmentButton();
		menuBar.hideAppointmentButton();

		// Showing
		freeRoom.showFreeRoomView();
		searchPanel.showSearchPanel();
	}

	@Override
	public void switchToDetailView(ResourceModel resource) {
		// Hiding
		appointmentView.hideAppointmentView();
		freeRoom.hideFreeRoomView();
		searchPanel.hideSearchPanel();

		// Adapting MenuBar
		menuBar.replaceWheelChairButtonWithHomeButton();
		if (resource.getLink() != null && !"".equals(resource.getLink())) {
			menuBar.showAppointmentButton();
		}

		// Showing
		detailContainer.addDetails(resource);
		detailContainer.showDetailContainer();
	}

	@Override
	public void switchToAppointmentView() {
		// Hiding
		freeRoom.hideFreeRoomView();
		searchPanel.hideSearchPanel();
		// TODO
		// detailContainer.hideDetailContainer();
		// detailContainer.removeDetails(...);

		// Adapting MenuBar
		menuBar.replaceAppointmentButtonWithBackButton();

		// Showing
		appointmentView.showAppointmentView();
	}

	@Override
	public void refreshFreeRooms(
			BeanItemContainer<FreeRoomModel> freeRoomContainer) {
		freeRoom.refreshFreeRooms(freeRoomContainer);
	}

	@Override
	public void setAppointmentUrl(String url) {
		appointmentView.setUrl(url);
	}

	@Override
	public void addClickListenerFlagPopup(Locale locale,
			com.vaadin.event.MouseEvents.ClickListener listener) {
		menuBar.addClickListenerFlagPopup(locale, listener);
	}

	@Override
	public void hideOpenLanguagePopup() {
		menuBar.hideOpenLanguagePopup();
	}

	@Override
	public TextField getSearchField() {
		return searchField.getSearchField();
	}

	@Override
	public void focusSearchField() {
		searchField.focusSearchField();
	}

	@Override
	public int getCursorPosition() {
		return searchField.getCursorPosition();
	}

	@Override
	public void setCursorPosition(int cursorPosition) {
		searchField.setCursorPosition(cursorPosition);
	}

	@Override
	public void updateTranslations() {
		dateTime.updateTranslations();
		freeRoom.updateTranslations();
		searchPanel.updateTranslations();
		detailContainer.updateTranslations();
		appointmentView.updateTranslations();
		menuBar.updateTranslations();
	}
}