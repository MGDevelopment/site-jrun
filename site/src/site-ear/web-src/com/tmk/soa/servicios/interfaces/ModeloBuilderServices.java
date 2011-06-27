package com.tmk.soa.servicios.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface ModeloBuilderServices {

	public Object getModelo(Class modelo,HttpServletRequest request) throws Exception;
	
}
