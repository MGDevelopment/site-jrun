package com.tmk.xml.feed;

public class Title {
	private String text;
	private String type;

	public Title(String text, String type) {
		this.text = text;
		this.type = type;
	}

	public String toString() {
		return text;
	}

	public String getType(){
		return type;
	}

}
