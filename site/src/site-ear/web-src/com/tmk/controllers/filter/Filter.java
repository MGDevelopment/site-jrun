package com.tmk.controllers.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class Filter {
	
	private String successTarget;
	private String failureTarget;
	private String target = null;
	protected static final int INITIAL = 0;
	protected static final int SUCCESS = 1;
	protected static final int FAILURE = -1;
	protected int state;
	
	public Filter() {
		state = INITIAL;
	}
	
	public Filter(String successTarget, String failureTarget) {
		this();
		this.successTarget = successTarget;
		this.failureTarget = failureTarget;
	}
	
	public boolean isInitial() {
		return (state == INITIAL);
	}
	
	public boolean isSuccess() {
		return (state == SUCCESS);
	}
	
	public boolean isFailure() {
		return (state == FAILURE);
	}

	public String getStateString() {
		return (isInitial())? "INITIAL": (isSuccess())? "SUCCESS":"FAILURE";
	}
	
	public void setTarget() {
		target = (isSuccess())? successTarget: failureTarget;
	}
	
	public String getTarget() {
		return target;
	}
	
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws FilterException;
	
	public abstract String getName();
	
	public String toString() {
		return "FILTER " + this.getName() + ":" + getStateString();
	}
}
