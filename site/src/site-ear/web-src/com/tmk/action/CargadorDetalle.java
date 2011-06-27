package com.tmk.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.ControllerSupport;

public class CargadorDetalle extends ControllerSupport {

	public void perform(ComponentContext tileContext,
			HttpServletRequest request, HttpServletResponse response,
			ServletContext servletContext) 
			throws ServletException, IOException {
		
		request.setAttribute("valor", "test de alcance");		
	}	
}
