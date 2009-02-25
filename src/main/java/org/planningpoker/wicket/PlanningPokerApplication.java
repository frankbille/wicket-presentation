package org.planningpoker.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.planningpoker.wicket.pages.CountPage;

/**
 * Wicket application
 */
public class PlanningPokerApplication extends WebApplication {

	public static PlanningPokerApplication get() {
		return (PlanningPokerApplication) WebApplication.get();
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return CountPage.class;
	}

}
