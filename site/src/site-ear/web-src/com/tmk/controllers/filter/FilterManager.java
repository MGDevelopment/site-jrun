package com.tmk.controllers.filter;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.kernel.TmkLogger;

public class FilterManager {
	private Vector filters = new Vector();
	
	public FilterManager() {
	}
	
	public void addFilter(Filter filter) {
		this.filters.add(filter);
	}
	
	public void executeFilters(HttpServletRequest request, HttpServletResponse response)
		throws FilterException {
		for (int i=0; i<filters.size(); i++) {
			Filter filter = (Filter)filters.get(i);
			filter.execute(request, response);
		}	
	}
	
	public String processTarget(HttpServletRequest request, HttpServletResponse response)  {
		StringBuffer filInfo = new StringBuffer("");
		for (int i=0; i<filters.size(); i++) {
			Filter filter = (Filter)filters.get(i);
			filInfo.append(filter.toString()).append(" ");
			if (filter.getTarget() != null) {
				return filter.getTarget();
			}
		}
		//no hay target establecido continua el proceso en el controller
		return null;
		
	}
	
	//retorna true si todos los filtros fueron exitosos
	//false si alguno fracaso
	public boolean getFiltersState() {
		for (int i=0; i<filters.size(); i++) {
			Filter filter = (Filter)filters.get(i);
			if (filter.isFailure()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean getStateByName(HttpServletRequest request, HttpServletResponse response, String filterName) throws FilterException  {
		for (int i=0; i<filters.size(); i++) {
			Filter filter = (Filter)filters.get(i);
			if (filter.getName().equals(filterName)) {
				if (filter.isSuccess()) {
					return true;
				} else {
					return false;
				}
			}
		}
		throw new FilterException ("FILTER NOT FOUND[" + filterName + "]: requestURL=" +
			request.getRequestURL());
	}
}
