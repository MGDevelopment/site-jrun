package com.tmk.xml.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.tmk.kernel.Convert;

public class CapitalizarDescripcionConverter implements SingleValueConverter {

    public String toString(Object obj) {
    	return Convert.corregir(obj.toString(), true);
    }

    public Object fromString(String name) {
        return name;
    }

    public boolean canConvert(Class type) {
        return type.equals(String.class);
    }
}