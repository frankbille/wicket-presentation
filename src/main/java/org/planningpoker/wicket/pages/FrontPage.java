package org.planningpoker.wicket.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.planningpoker.domain.Participant;
import org.planningpoker.domain.SimpleParticipant;
import org.planningpoker.domain.Participant.Status;
import org.planningpoker.wicket.components.ParticipantsComponent;

public class FrontPage extends WebPage {

	private boolean showParticipants = false;
	
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
		
		final ParticipantsComponent participantsComponent = new ParticipantsComponent("participants", participantsModel) {
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isVisible() {
				return showParticipants;
			}
		};
		participantsComponent.setOutputMarkupId(true);
		participantsComponent.setOutputMarkupPlaceholderTag(true);
		add(participantsComponent);
		
		// Link
		AjaxFallbackLink<Void> participantsLink = new AjaxFallbackLink<Void>("participantsLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				showParticipants = showParticipants == false;
				
				if (target != null) {
					target.addComponent(this);
					target.addComponent(participantsComponent);
				}
			}
		};
		participantsComponent.setOutputMarkupId(true);
		add(participantsLink);
		
		participantsLink.add(new Label("label", new AbstractReadOnlyModel<String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return showParticipants ? "Hide participants" : "Show participants";
			}
		}));
	}
	
}
