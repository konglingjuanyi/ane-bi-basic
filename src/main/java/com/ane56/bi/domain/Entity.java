package com.ane56.bi.domain;

public abstract class Entity extends AssertionConcern implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long id;

	protected Entity() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
