package com.tmk.xml.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.tmk.kernel.Convert;
import com.tmk.kernel.IdiomaDAO;

public class IdiomaConverter implements SingleValueConverter {

    public String toString(Object obj) {
    	return IdiomaDAO.buscaIdioma(obj.toString()).getNombre();
    }

    public Object fromString(String name) {
        return name;
    }

    public boolean canConvert(Class type) {
        return type.equals(String.class);
    }

}
