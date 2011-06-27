package com.tmk.xml.feed;

public class Link {
	String rel;
	String type;
	String href;
	
	public Link(String rel, String type, String href) {
		this.rel = rel;
		this.type = type;
		this.href = href;
	}
}
