package org.planningpoker.test;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Helper class to start the Planning poker application, using an embedded jetty
 * server.
 */
public class JettyStarter {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("wicket.configuration", "DEVELOPMENT");

		Server server = new Server(8080);
		server.addHandler(new WebAppContext("src/main/webapp", "/"));
		server.start();
	}

}
