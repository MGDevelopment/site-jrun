package com.tmk.xml.converter;


import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.tmk.bus.categoria.CategoriaPK;
							 
/*El metodo fromString NO ES UTILIZABLE en esta clase por perdida de datos*/

public class CategoriaPKConverter implements SingleValueConverter {

    public String toString(Object obj) {
    	return (((CategoriaPK)obj).getPK()[((CategoriaPK)obj).getPK().length-1]).toString();
    	
    }

    public Object fromString(String name) {
        return null;
    }

    public boolean canConvert(Class type) {
        return type.equals(CategoriaPK.class);
    }
}