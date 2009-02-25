package org.planningpoker.wicket.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
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
		add(new AjaxLink<Void>("decrease") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				counter.decrease();
			
				target.addComponent(countLabel);
			}
		});
		
		// Increase label
		add(new AjaxLink<Void>("increase") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				counter.increase();

				target.addComponent(countLabel);
			}
		});
	}
	
}
