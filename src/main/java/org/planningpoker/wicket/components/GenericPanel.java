package org.planningpoker.wicket.components;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class GenericPanel<T> extends Panel {
	private static final long serialVersionUID = 1L;

	public GenericPanel(String id, IModel<T> model) {
		super(id, model);
	}
	
	@SuppressWarnings("unchecked")
	public IModel<T> getModel() {
		return (IModel<T>) getDefaultModel();
	}
	
	@SuppressWarnings("unchecked")
	public T getModelObject() {
		return (T) getDefaultModelObject();
	}

}
