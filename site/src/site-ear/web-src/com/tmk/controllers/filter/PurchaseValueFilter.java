package com.tmk.controllers.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
import com.tmk.controllers.MainHelper;

public class PurchaseValueFilter extends Filter {
	private double value;
	private OrdenDAO orden = null;
	public PurchaseValueFilter(double value) {
		this.value = value;
	}

	public PurchaseValueFilter(String successTarget, String failureTarget, double value) {
		super(successTarget, failureTarget);
		this.value = value;
	}

	public PurchaseValueFilter(double value, OrdenDAO orden) {
		this.orden = orden;
		this.value = value;
	}

	public PurchaseValueFilter(String successTarget, String failureTarget, double value, OrdenDAO orden) {
		super(successTarget, failureTarget);
		this.orden = orden;
		this.value = value;
	}

	
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws FilterException {
		OrdenDAO orden = (OrdenDAO)request.getSession().getAttribute(MainHelper.SESSION_ORDEN);
		if (orden != null) {
			this.state = (orden.totalSitioCompleto() >= value)? SUCCESS: FAILURE;
		} else if (this.orden!= null) {  	
			this.state = (this.orden.totalSitioCompleto() >= value)? SUCCESS: FAILURE;
		} else {
			this.state = FAILURE;
		}
		setTarget();
		TmkLogger.info(toString());
	}

	public String getName() {
		return "PurchaseValueFilter";
	}

}
