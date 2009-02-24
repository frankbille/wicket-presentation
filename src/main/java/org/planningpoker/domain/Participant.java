package org.planningpoker.domain;

import java.io.Serializable;

public interface Participant extends Serializable {

	String getName();

	Status getStatus();

	public static enum Status {
		AVAILABLE, AWAY, DISCONNECTED
	}

}
