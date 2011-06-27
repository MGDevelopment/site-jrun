package com.tmk.soa.servicios.implementation;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.interfaces.ModeloBuilderServices;

public class ModeloBuilderServiceImp implements ModeloBuilderServices{

	public Object getModelo(Class modelo, HttpServletRequest request) throws Exception{
		Object obj = Class.forName(modelo.getName()).newInstance();		
		Field[] fields = modelo.getDeclaredFields();
		
		//recorro los fields del objeto
		for(int i=0;i<fields.length;i++) {
			Field field = fields[i];
			field.setAccessible(true);
			boolean continuo = true;
			//recorro las claves del request, para ver  cuando conicida con el del field
			Enumeration claves = request.getParameterNames();
			while(claves.hasMoreElements() && continuo) {
				String clave = (String)claves.nextElement();
				if(field.getName().equals(clave)) {
					setField(obj, field, field.getType().toString(),(Object)request.getParameter(clave));
					continuo = false;;
				}				
			}		
		}
		return obj;
	}
	
	private void setField(Object obj,Field field, String columnClassName, Object value) throws Exception {
			if (columnClassName.equals("byte[]")) {
				field.set(obj, (byte[])value);
			} else if (columnClassName.endsWith("Integer")) {
				field.set(obj, new Integer(value.toString()));
			} else if (columnClassName.endsWith("BigDecimal")) {
				field.set(obj, (Integer)value);
			} else if (columnClassName.endsWith("String")) {
				field.set(obj, (String)value);
			} else if (columnClassName.endsWith("Timestamp")) {
				field.set(obj, (Timestamp)value);
			} else if (columnClassName.endsWith("Time")) {
				field.set(obj, (Time)value);
			} else if (columnClassName.endsWith("Short")) {
				field.set(obj, (Short)value);
			} else if (columnClassName.endsWith("Long")) {
				field.set(obj, (Long)value);
			} else if (columnClassName.endsWith("Float")) {
				field.set(obj, (Float)value);
			} else if (columnClassName.endsWith("Double")) {
				field.set(obj, (Double)value);
			} else if (columnClassName.endsWith("Date")) {
				field.set(obj, (Date)value);
			} else if (columnClassName.endsWith("Boolean")) {
				//Boolean aux = new Boolean(value.toString()); 
				field.set(obj, new Boolean(value.toString()));
			} else {
				TmkLogger.debug(columnClassName);
				field.set(obj, (Object)value);
			}
		}	
}
