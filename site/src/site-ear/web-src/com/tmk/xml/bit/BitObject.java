package com.tmk.xml.bit;

/***
 * @see Usado como atributo dentro de ShortUrl para convertir de json a Objeto 
 * @see la respuesta devuelta por la api de <i>http://api.bit.ly/shorten</i>
 * @author oClopez
 * @version 0.1
 */

public class BitObject {
	private String hash;
	private String shortKeywordUrl;
	private String shortUrl;
	private String userHash;
	private String shortCNAMEUrl;
	
	public BitObject() {	
	}
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getShortKeyWordUrl() {
		return shortKeywordUrl;
	}
	public void setShortKeyWordUrl(String shortKeyWordUrl) {
		this.shortKeywordUrl = shortKeyWordUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getUserHash() {
		return userHash;
	}
	public void setUserHash(String userHash) {
		this.userHash = userHash;
	}

	public String getShortKeywordUrl() {
		return shortKeywordUrl;
	}

	public void setShortKeywordUrl(String shortKeywordUrl) {
		this.shortKeywordUrl = shortKeywordUrl;
	}

	public String getShortCNAMEUrl() {
		return shortCNAMEUrl;
	}

	public void setShortCNAMEUrl(String shortCNAMEUrl) {
		this.shortCNAMEUrl = shortCNAMEUrl;
	}
	
}
