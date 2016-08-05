package com.ane56.bi.port.adapter.rest;

public enum ErrorType {
	
	DEFAULT("0");

	private String type;

	private ErrorType(String value) {
		this.type = value;
	}

	public String getType() {
		return this.type;
	}

}
