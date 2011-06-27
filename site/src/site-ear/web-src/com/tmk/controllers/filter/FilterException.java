package com.tmk.controllers.filter;


public class FilterException extends Exception {
	private StringBuffer message = new StringBuffer();
	
	public FilterException(String message) {
		super(message);
		this.message.append(message);
	}
	
	public String getMessage() {
		return message.toString();
	}
	
}
