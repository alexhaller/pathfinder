package com.pathfinder.view;

import com.vaadin.ui.Component;

import de.vksi.c4j.ContractReference;

/**
 * ComponentSpec - Defines the methods for all component classes
 * 
 * @author alexh
 * 
 */
@ContractReference(ComponentSpecContract.class)
public interface ComponentSpec extends TranslatableSpec, DestroyableSpec, Component {

}