package com.tmk.xml.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class RFC822DateConverter implements SingleValueConverter {
	private Locale locale = new  Locale("es", "ES");
	public RFC822DateConverter(Locale locale) {
		this.locale = locale;
	}
		
	public Object fromString(String arg0) {
		return null;
	}

	public String toString(Object arg0) {
		SimpleDateFormat RFC822DateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", locale);
		
		return RFC822DateFormat.format((Date)arg0);
	}

	public boolean canConvert(Class type) {
		return type.equals(Date.class);
	}

}
