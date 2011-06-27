package com.tmk.soa.exceptions;

public class AplicationException extends Throwable {

	private Exception error;
	private String msjError;
	
	public AplicationException(String msjError) {
		super();
		this.msjError = msjError;		
	}
	public AplicationException(Exception e) {
		this.error = e;
	}
	public String getMsjError() {
		return this.msjError;
	}
	public Exception getError() {
		return error;
	}
	public void setError(Exception error) {
		this.error = error;
	}
	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}	
	@Override
	public String getMessage() {
		StringBuffer buString = new StringBuffer();
		if(error!=null){
			buString.append(error.getMessage());
		}if(msjError!=null){
			buString.append("-").append(msjError);
		}
		return buString.toString();
			
	}
	
}
