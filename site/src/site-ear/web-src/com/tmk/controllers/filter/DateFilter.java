package com.tmk.controllers.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.kernel.TmkLogger;

import java.util.Calendar;

/*Tiene en cuenta las 00 hs tanto de comienzo como de fin*/
public class DateFilter extends Filter {
	Calendar start;
	Calendar end;
	Calendar now;
	
	//fecha y hora en formato DD/MM/YYYY 
	
	public DateFilter(String start, String end) {
		this.now = Calendar.getInstance();
		initValues(start, end);
	}
	
	public DateFilter(String start, String end, String successTarget, String failureTarget) {
		super(successTarget, failureTarget);
		this.now = Calendar.getInstance();
		initValues(start, end);
	}
	
	public DateFilter(Calendar start, Calendar end) {
		this.now = Calendar.getInstance();
		this.start = start;
		this.end = end;
	}
	
	public DateFilter(Calendar start, Calendar end, String successTarget, String failureTarget) {
		super(successTarget, failureTarget);
		this.now = Calendar.getInstance();
		this.start = start;
		this.end = end;
	}
	
//	public void execute(HttpServletRequest request, HttpServletResponse response)
	public void execute()
			throws FilterException {
		state = (now.after(this.start) && now.before(this.end))? SUCCESS: FAILURE;
		setTarget();
		TmkLogger.info(toString());
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws FilterException{
		this.execute();
	}

	public String getName() {
		return "DateFilter";
	}
	
	private void initValues(String start, String end) {
		this.start = Calendar.getInstance();
		this.end = Calendar.getInstance();
		start = start.replaceAll("\\D", "");
		end = end.replaceAll("\\D", "");
		this.start.set(new Integer(start.substring(4, 8)).intValue(),
				new Integer(start.substring(2, 4)).intValue()-1,
				new Integer(start.substring(0, 2)).intValue(), 0, 0, 0);
		this.end.set(new Integer(end.substring(4, 8)).intValue(),
				new Integer(end.substring(2, 4)).intValue()-1,
				new Integer(end.substring(0, 2)).intValue(), 0, 0, 0);
	}
}
