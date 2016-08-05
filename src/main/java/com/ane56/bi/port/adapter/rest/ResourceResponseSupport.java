package com.ane56.bi.port.adapter.rest;

public abstract class ResourceResponseSupport {

	protected RestResultResponse buildErrorRestResultResponse(Exception ex) {
		Throwable reason = ex.getCause();

		if (reason == null) {
			reason = ex;
		}

		RestResultResponse response;

		if (reason instanceof IllegalArgumentException || reason instanceof IllegalStateException) {
			response = new RestResultResponse(RestResultStatus.ERROR, new ErrorResult(reason.getMessage()));
		} else {
			response = new RestResultResponse(RestResultStatus.ERROR, new ErrorResult(ex.getMessage()));
		}

		return response;
	}

	protected RestResultResponse buildSuccessRestResultResponse(Object aResult) {
		return new RestResultResponse(RestResultStatus.SUCCESS, aResult);
	}

	protected RestResultResponse buildSuccessRestResultResponse() {
		return this.buildSuccessRestResultResponse("");
	}

	protected RestResultResponse buildErrorRestResultResponse(String aResult) {
		return new RestResultResponse(RestResultStatus.ERROR, new ErrorResult(aResult));
	}

	protected RestResultResponse buildErrorRestResultResponse(String aResult, ErrorType errorType) {
		return new RestResultResponse(RestResultStatus.ERROR, new ErrorResult(aResult, errorType.getType()));
	}

	protected RestResultResponse buildErrorRestResultResponse() {
		return this.buildErrorRestResultResponse("");
	}

	protected RestResultResponse buildErrorRestResultResponse(Object aResult) {
		return new RestResultResponse(RestResultStatus.ERROR, aResult);
	}

}
