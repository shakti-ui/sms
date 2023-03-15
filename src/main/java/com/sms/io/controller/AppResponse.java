package com.sms.io.controller;

public class AppResponse {
	private String message;

	public AppResponse(String message) {
		super();
		this.message = message;
	}

	public AppResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
