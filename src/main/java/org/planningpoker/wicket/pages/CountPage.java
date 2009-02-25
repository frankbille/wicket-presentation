package org.planningpoker.wicket.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;

public class CountPage extends WebPage {

	public static class Counter {
		private int count;

		public int getCount() {
			return count;
		}
		
		public void increase() {
			count++;
			System.out.println(count);
		}
		
		public void decrease() {
			count--;
			System.out.println(count);
		}
	}
	
	private Counter counter;
	
	public CountPage() {
		counter = new Counter();
		
		// Count label
		final Label countLabel = new Label("count", new PropertyModel<Integer>(counter, "count"));
		countLabel.setOutputMarkupId(true);
		add(countLabel);
		
		// Decrease link
		add(new AjaxFallbackLink<Void>("decrease") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				counter.decrease();

				if (target != null) {
					target.addComponent(countLabel);
				}
			}
		});
		
		// Increase label
		add(new AjaxFallbackLink<Void>("increase") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				counter.increase();

				if (target != null) {
					target.addComponent(countLabel);
				}
			}
		});
	}
	
}
