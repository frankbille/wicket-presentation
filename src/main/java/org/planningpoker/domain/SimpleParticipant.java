package org.planningpoker.domain;


public class SimpleParticipant implements Participant {
	private static final long serialVersionUID = 1L;

	private String name;
	private Status status;
	
	public SimpleParticipant(String name, Status status) {
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public Status getStatus() {
		return status;
	}

}
