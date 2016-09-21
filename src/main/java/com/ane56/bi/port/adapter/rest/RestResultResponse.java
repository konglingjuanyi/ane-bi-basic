package com.ane56.bi.port.adapter.rest;

public class RestResultResponse {
	
	private RestResultStatus status;
	private Object result;

	public RestResultResponse(RestResultStatus status, Object result) {
		this.status = status;
		this.result = result;
	}

	public RestResultResponse() {
		// TODO Auto-generated constructor stub
	}

	public RestResultStatus getStatus() {
		return status;
	}

	public Object getResult() {
		return result;
	}

	public void setStatus(RestResultStatus status) {
		this.status = status;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
