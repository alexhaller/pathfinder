package com.pathfinder.presenter;

import static de.vksi.c4j.Condition.ignored;
import static de.vksi.c4j.Condition.postCondition;
import static de.vksi.c4j.Condition.preCondition;

import com.pathfinder.model.ResourceModel;
import com.pathfinder.view.layout.DesktopLayoutSpec;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.MouseEvents.ClickListener;

import de.vksi.c4j.ClassInvariant;
import de.vksi.c4j.Target;

public class DesktopPresenterSpecContract implements DesktopPresenterSpec {

	@Target
	private DesktopPresenterSpec target;

	@ClassInvariant
	public void classInvariant() {
		// TODO: write invariants if required
	}

	@Override
	public void setRoomContainer(
			BeanItemContainer<ResourceModel> beanItemContainer) {
		if (preCondition()) {
			// TODO: write preconditions if required
		}
		if (postCondition()) {
			// TODO: write postconditions if required
		}
	}

	@Override
	public void setCourseContainer(
			BeanItemContainer<ResourceModel> beanItemContainer) {
		if (preCondition()) {
			// TODO: write preconditions if required
		}
		if (postCondition()) {
			// TODO: write postconditions if required
		}
	}

	@Override
	public void setPersonContainer(
			BeanItemContainer<ResourceModel> beanItemContainer) {
		if (preCondition()) {
			// TODO: write preconditions if required
		}
		if (postCondition()) {
			// TODO: write postconditions if required
		}
	}

	@Override
	public void setPoiContainer(
			BeanItemContainer<ResourceModel> beanItemContainer) {
		if (preCondition()) {
			// TODO: write preconditions if required
		}
		if (postCondition()) {
			// TODO: write postconditions if required
		}
	}

	@Override
	public DesktopLayoutSpec getDesktopLayoutView() {
		if (preCondition()) {
			// TODO: write preconditions if required
		}
		if (postCondition()) {
			// TODO: write postconditions if required
		}
		return ignored();
	}

	@Override
	public void refreshFreeRooms() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addKeybordKeyToSearchString(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteKeyFromSearchString() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearSearchString() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSearchString(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSearchString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCursorPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void switchToSearchView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToDetailView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToAppointmentView() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pathfinder.presenter.DesktopPresenterSpec#getUiClickListener()
	 */
	@Override
	public ClickListener getUiClickListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeWheelChairView() {
		// TODO Auto-generated method stub

	}
}