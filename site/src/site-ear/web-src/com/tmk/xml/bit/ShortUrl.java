package com.tmk.xml.bit;
/***
 * @see Representa la respuesta json de la api de <i>http://api.bit.ly/shorten</i>
 * @see a objeto para poder obtener entre otras cosas la url corta que de un comentario
 * @author oClopez
 * @version 0.1
 */

public class ShortUrl {
	private Integer errorCode;
	private	String errorMessage;
	private Results results;
	private String statusCode;
	
	public Integer getErrorCode() {
		return errorCode;
	}	
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public Results getResult() {
		return this.results;
	}
		
}
