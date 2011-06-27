package com.tmk.controllers.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.controllers.MainHelper;
import com.tmk.kernel.TmkLogger;

public class LoginFilter extends Filter {
	
	public LoginFilter() {
		super();
	}
	
	public LoginFilter(String successTarget, String failureTarget) {
		super(successTarget, failureTarget);
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws FilterException {
		this.state = (request.getSession().getAttribute(MainHelper.SESSION_SOCIOPK) != null)? SUCCESS: FAILURE;
		setTarget();
		TmkLogger.info(toString());
	}
	
	public String getName() {
		return "LoginFilter";
	}
}
