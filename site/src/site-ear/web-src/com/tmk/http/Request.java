package com.tmk.http;

import java.io.Serializable;
import java.util.Hashtable;

public class Request implements Serializable {
	public final static String POST = "POST";
	public final static String GET = "GET";
	private String url;
	private String method;
	private Hashtable params = new Hashtable();
	/*Agregado para conexiones autenticadas por http*/
	private String authorization;

	public Request(String url, String method) {
		this.url = url;
		this.method = method;
	}

	public String getUrl (){
		return this.url;
	}

	public String getMethod (){
		return this.method;
	}

	public void addParam(String name, String value) {
		params.put(name, value);
	}

	public Hashtable getParams() {
		return this.params;
	}

	public void setAuthorization(String user, String pass) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		String userEncoded = encoder.encode((user+":"+pass).getBytes());
		userEncoded = "Basic " + userEncoded;
		authorization = userEncoded.replaceAll("\n", "");
	}

	public String getAuthorization() {
		return authorization;
	}

}


/*
public class Request implements Serializable {
	public final static String POST = "POST";
	public final static String GET = "GET";
	private String url;
	private String method;
	private Hashtable params = new Hashtable();

	public Request(String url, String method) {
		this.url = url;
		this.method = method;
	}

	public String getUrl (){
		return this.url;
	}

	public String getMethod (){
		return this.method;
	}

	public void addParam(String name, String value) {
		params.put(name, value);
	}

	public Hashtable getParams() {
		return this.params;
	}
}*/


