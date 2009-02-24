package org.planningpoker.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.planningpoker.domain.Participant;
import org.planningpoker.domain.SimpleParticipant;
import org.planningpoker.domain.Participant.Status;
import org.planningpoker.wicket.components.ParticipantLink;

public class PokerPage extends WebPage {

	public PokerPage() {

		IModel<Participant> participantModel = new Model<Participant>(
				new SimpleParticipant("Frank Bille", Status.AVAILABLE));

		add(new ParticipantLink("ownerLink", participantModel));

	}

}
