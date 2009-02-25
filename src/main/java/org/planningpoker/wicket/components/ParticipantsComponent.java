package org.planningpoker.wicket.components;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.planningpoker.domain.Participant;
import org.planningpoker.wicket.pages.ParticipantPage;

public class ParticipantsComponent extends GenericPanel<List<Participant>> {
	private static final long serialVersionUID = 1L;

	public ParticipantsComponent(String id, IModel<List<Participant>> model) {
		super(id, model);
		
		add(new ListView<Participant>("participants", model) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Participant> item) {
				Link<Participant> link = new Link<Participant>("participantLink", item.getModel()) {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new ParticipantPage(getModelObject()));
					}
				};
				item.add(link);
				
				link.add(new Label("name", item.getModelObject().getName()));
				
				item.add(new Label("status", item.getModelObject().getStatus().name()));
			}
		});
	}

}
