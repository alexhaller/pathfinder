package com.pathfinder.view.components;

import static com.pathfinder.view.components.KeyboardId.*;

import java.util.ArrayList;
import java.util.List;

import com.pathfinder.util.translation.TranslationKeys;
import com.pathfinder.util.translation.Translator;
import com.pathfinder.util.translation.TranslatorSpec;
import com.pathfinder.view.listener.KeyboardViewListenerSpec;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * View for the Keyboard
 * 
 * @author max
 * 
 */
public class Keyboard extends CustomComponent implements KeyboardSpec,
		ClickListener {
	private final TranslatorSpec translator = Translator.getInstance();

	private final Button deleteButton = createButton(DELETE);
	private final Button spaceButton = createButton(SPACE);

	final VerticalLayout layout = new VerticalLayout();
	final HorizontalLayout row1 = new HorizontalLayout();
	final HorizontalLayout row2 = new HorizontalLayout();
	final HorizontalLayout row3 = new HorizontalLayout();
	final HorizontalLayout row4 = new HorizontalLayout();

	/* Only the presenter registers one listener... */
	List<KeyboardViewListenerSpec> listeners = new ArrayList<KeyboardViewListenerSpec>();

	public Keyboard() {
		buildLayout();
	}

	private void buildLayout() {
		row1.setPrimaryStyleName("keyboard-row");
		row2.setPrimaryStyleName("keyboard-row");
		row3.setPrimaryStyleName("keyboard-row");
		row4.setPrimaryStyleName("keyboard-row");

		// The operations for the Keyboard in the order they appear on the
		// screen (left to right, top to bottom)
		KeyboardId[] firstRow = new KeyboardId[] { ONE, TWO, THREE, FOUR, FIVE,
				SIX, SEVEN, EIGHT, NINE, ZERO };
		KeyboardId[] secondRow = new KeyboardId[] { Q, W, E, R, T, Z, U, I, O,
				P, UE, LEFT };
		KeyboardId[] thirdRow = new KeyboardId[] { A, S, D, F, G, H, J, K, L,
				OE, AE, RIGHT };
		KeyboardId[] fourthRow = new KeyboardId[] { Y, X, C, V, B, N, M };

		for (KeyboardId id : firstRow) {
			row1.addComponent(createButton(id));
		}
		row1.addComponent(deleteButton);

		for (KeyboardId id : secondRow) {
			row2.addComponent(createButton(id));
		}

		for (KeyboardId id : thirdRow) {
			row3.addComponent(createButton(id));
		}

		for (KeyboardId id : fourthRow) {
			row4.addComponent(createButton(id));
		}
		row4.addComponent(spaceButton, 4);

		layout.addComponent(row1);
		layout.addComponent(row2);
		layout.addComponent(row3);
		layout.addComponent(row4);

		setCompositionRoot(layout);
	}

	/**
	 * Creates a new Button with label as specified in id and this class as
	 * listener
	 * 
	 * @param id
	 *            Keyboard ID with label
	 * @return New Button as specified above
	 */
	private Button createButton(KeyboardId id) {
		Button newButton = new Button();
		newButton.setData(id);
		newButton.addClickListener(this);

		switch (id) {
		case SPACE:
			newButton.setPrimaryStyleName("keyboard-space");
			newButton.setCaption(translator.translate(TranslationKeys.SPACE));
			break;
		case DELETE:
			newButton.setPrimaryStyleName("keyboard-delete");
			newButton.setCaption(translator.translate(TranslationKeys.DELETE));
			break;
		default:
			newButton.setPrimaryStyleName("keyboard-button");
			newButton.setCaption(id.getLabel());
			break;
		}

		return newButton;
	}

	@Override
	public void addKeyboardViewListener(KeyboardViewListenerSpec listener) {
		listeners.add(listener);
	}

	/**
	 * Relay button clicks to the presenter with an implementation-independent
	 * event
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		for (KeyboardViewListenerSpec listener : listeners)
			listener.buttonClick((KeyboardId) event.getButton().getData());
	}

	@Override
	public List<KeyboardViewListenerSpec> getKeyboardViewListener() {
		return listeners;
	}

	@Override
	public void updateTranslations() {
		deleteButton.setCaption(translator.translate(TranslationKeys.DELETE));
		spaceButton.setCaption(translator.translate(TranslationKeys.SPACE));
	}
}