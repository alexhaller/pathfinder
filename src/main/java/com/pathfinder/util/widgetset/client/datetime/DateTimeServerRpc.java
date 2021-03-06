package com.pathfinder.util.widgetset.client.datetime;

import com.vaadin.shared.communication.ServerRpc;

/**
 * A handler for RPC-calls must implement these methods so that the client can
 * interact with the server
 * 
 * @author tim
 * 
 */
public interface DateTimeServerRpc extends ServerRpc {

	/**
	 * Synchronizing current time in the widget with the current server time
	 */
	void synchronizeWithServertime();

	/**
	 * Updates format for date and time according to current locale
	 */
	void updateDateTimeFormatter();

	void goBackToHomeScreen();

}
