package org.planningpoker.wicket.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.planningpoker.domain.Participant;
import org.planningpoker.domain.SimpleParticipant;
import org.planningpoker.domain.Participant.Status;
import org.planningpoker.wicket.components.ParticipantsComponent;

public class FrontPage extends WebPage {

	public FrontPage() {
		IModel<List<Participant>> participantsModel = new LoadableDetachableModel<List<Participant>>() {
			private static final long serialVersionUID = 1L;

			@Override
			protected List<Participant> load() {
				List<Participant> list = new ArrayList<Participant>();
				
				list.add(new SimpleParticipant("Frank Bille", Status.AVAILABLE));
				list.add(new SimpleParticipant("John Doe", Status.AVAILABLE));
				list.add(new SimpleParticipant("Jane Doe", Status.AWAY));
				list.add(new SimpleParticipant("Jacob Avlund", Status.DISCONNECTED));
				
				return list;
			}			
		};
		
		final ParticipantsComponent participantsComponent = new ParticipantsComponent("participants", participantsModel);
		add(participantsComponent);
	}
	
}
