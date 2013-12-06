package com.pathfinder.view.layout;

import com.pathfinder.view.components.SearchField;
import com.pathfinder.view.components.TreeStructure;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class SearchPanel extends CustomComponent implements SearchPanelSpec {

	private TreeStructure treeStructure = new TreeStructure();
//	private Keyboard keyboard = new Keyboard();
	private SearchField searchField = new SearchField();

	private VerticalLayout layout = new VerticalLayout();

	public SearchPanel() {
		this.buildLayout();
		this.setCompositionRoot(layout);
	}

	@Override
	public void buildLayout() {
		this.layout.addComponent(treeStructure);
//		this.layout.addComponent(keyboard);
		this.layout.addComponent(searchField);
	}

	@Override
	public void destroyLayout() {
		layout.removeAllComponents();
	}
}