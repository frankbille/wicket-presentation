package org.planningpoker.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.planningpoker.domain.Participant;

public class ParticipantPage extends WebPage {

	public ParticipantPage(Participant participant) {
		add(new Label("name", participant.getName()));
	}
	
}
