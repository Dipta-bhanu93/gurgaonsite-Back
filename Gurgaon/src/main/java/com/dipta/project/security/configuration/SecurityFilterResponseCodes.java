package com.dipta.project.security.configuration;

public enum SecurityFilterResponseCodes {

	RESPSTATUS("STATUS"),
	LOGIN_SUCCESS("LOGIN_SUCCESS"),
	LOGIN_FAILURE("LOGIN_FAILURE"),
	FORBIDDEN("FORBIDDEN"),
	LOGOUT_SUCCESS("LOGOUT_SUCCESS");
	
	String responseString;
	
	private SecurityFilterResponseCodes(String responseString) {
		this.responseString = responseString;
	}

	public String getResponseString() {
		return responseString;
	}

	
	
	
}
