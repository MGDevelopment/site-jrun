package com.tmk.xml.converter;

import java.sql.Timestamp;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.tmk.kernel.Convert;

public class TimestampConverter implements SingleValueConverter {

    public String toString(Object obj) {
    	return Convert.toStringFromDDMMYYYY((Timestamp)obj);
    }

    public Object fromString(String name) {
        return Convert.toTimestampFromDDMMYYYY(name);
    }

    public boolean canConvert(Class type) {
        return type.equals(Timestamp.class);
    }
}
