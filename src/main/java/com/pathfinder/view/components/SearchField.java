package com.pathfinder.view.components;

import com.pathfinder.util.translation.TranslationKeys;
import com.pathfinder.util.translation.Translator;
import com.pathfinder.util.translation.TranslatorSpec;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class SearchField extends CustomComponent implements SearchFieldSpec {
	private final TranslatorSpec translator = Translator.getInstance();

	private final HorizontalLayout layout = new HorizontalLayout();
	private final Button magnifierButton = new Button();
	private final Button deleteAllButton = new Button();
	private final TextField searchField = new TextField();

	private final ThemeResource deleteResource = new ThemeResource(
			"icon/DeleteAll.png");
	private final ThemeResource magnifierResource = new ThemeResource(
			"icon/Magnifier.png");

	public SearchField() {
		this.init();
		this.setStyles();
		this.buildLayout();
		setCompositionRoot(layout);
	}

	private void init() {
		magnifierButton.setEnabled(false);
		magnifierButton.setIcon(magnifierResource);
		deleteAllButton.setIcon(deleteResource);
		searchField.setInputPrompt(translator
				.translate(TranslationKeys.SEARCH_PROMP));
		searchField.setBuffered(false);
		searchField.setMaxLength(200);
		searchField.setImmediate(true);
	}

	private void setStyles() {
		layout.setPrimaryStyleName("search");
		searchField.setPrimaryStyleName("searchfield");
		magnifierButton.setPrimaryStyleName("search-icon");
		deleteAllButton.setPrimaryStyleName("delete-icon");
	}

	private void buildLayout() {
		layout.addComponent(magnifierButton);
		layout.addComponent(searchField);
		layout.addComponent(deleteAllButton);
	}

	@Override
	public void addSearchFieldValueChangeListener(ValueChangeListener listener) {
		searchField.addValueChangeListener(listener);
	}

	@Override
	public void addMagnifierClickListener(ClickListener listener) {
		magnifierButton.addClickListener(listener);
	}

	@Override
	public void addDeleteAllClickListener(ClickListener listener) {
		deleteAllButton.addClickListener(listener);
	}

	@Override
	public void focusSearchField() {
		searchField.focus();
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
	public Button getMagnifierButton() {
		return magnifierButton;
	}

	@Override
	public Button getDeleteAllButton() {
		return deleteAllButton;
	}

	@Override
	public TextField getSearchField() {
		return searchField;
	}

	@Override
	public void updateTranslations() {
		searchField.setInputPrompt(translator
				.translate(TranslationKeys.SEARCH_PROMP));
	}
}