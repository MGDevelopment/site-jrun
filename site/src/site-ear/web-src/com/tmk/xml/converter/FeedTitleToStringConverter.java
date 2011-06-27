package com.tmk.xml.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.tmk.xml.feed.Title;

public class FeedTitleToStringConverter implements Converter {


        public boolean canConvert(Class clazz) {
                return clazz.equals(Title.class);
        }

        public void marshal(Object value, HierarchicalStreamWriter writer,
                        MarshallingContext context) {
        	Title title = (Title) value;
        	writer.addAttribute("type", title.getType());
        	writer.setValue(title.toString());



        }

        public Object unmarshal(HierarchicalStreamReader reader,
                        UnmarshallingContext context) {
                return null;
        }



}

