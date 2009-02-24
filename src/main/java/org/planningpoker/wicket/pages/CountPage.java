package org.planningpoker.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
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
		add(new Label("count", new PropertyModel<Integer>(counter, "count")));
		
		// Decrease link
		add(new Link<Void>("decrease") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				counter.decrease();
			}
		});
		
		// Increase label
		add(new Link<Void>("increase") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				counter.increase();
			}
		});
	}
	
}
