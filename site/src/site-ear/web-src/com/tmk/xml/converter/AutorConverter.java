package com.tmk.xml.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.tmk.kernel.Convert;

public class AutorConverter implements SingleValueConverter {
	public String toString(Object obj) {
		try {
			return Convert.nombrePropio(obj.toString().toUpperCase().replaceAll("\\[MUS]", ""), false);
		} catch (Exception e) {
			return null;
		}
    }

    public Object fromString(String name) {
        return name;
    }

    public boolean canConvert(Class type) {
        return type.equals(String.class);
    }
}
