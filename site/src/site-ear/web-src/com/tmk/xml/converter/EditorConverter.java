package com.tmk.xml.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.tmk.kernel.Convert;

public class EditorConverter implements SingleValueConverter {

	public Object fromString(String name) {
		return name;
	}

	public String toString(Object obj) {
		try {
			return Convert.corregir(obj.toString().toUpperCase().replaceAll("\\[MUS]", ""), true);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean canConvert(Class type) {
		return type.equals(String.class);
	}

}
