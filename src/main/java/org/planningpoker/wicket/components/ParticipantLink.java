package org.planningpoker.wicket.components;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.planningpoker.domain.Participant;
import org.planningpoker.wicket.pages.ParticipantPage;

public class ParticipantLink extends Link<Participant> {
	private static final long serialVersionUID = 1L;

	public ParticipantLink(String id, IModel<Participant> model) {
		super(id, model);
	}

	@Override
	public void onClick() {
		setResponsePage(new ParticipantPage(getModelObject()));
	}

}
