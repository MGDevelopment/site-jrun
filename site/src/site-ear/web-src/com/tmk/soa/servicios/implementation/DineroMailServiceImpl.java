package com.tmk.soa.servicios.implementation;

import java.util.Iterator;
import java.util.Map;

import com.tmk.soa.servicios.interfaces.DineroMailService;
import com.tmk.util.HTML.Template;

/**
 * @see encapsua la funcionalidad de seteo de datos en la temaplate del formulario de dinero mail
 * @author oclopez
 *
 */
public class DineroMailServiceImpl implements DineroMailService {

	/**
	 * Con el map y la template setea los datos en el formulario de dinero mail  
	 */
	public void setParametros(Map<String, String> datos, Object tempalte) {
		Iterator<String> claves = datos.keySet().iterator();
		Iterator<String> valores = datos.values().iterator();
		while(claves.hasNext()) {
			String key = claves.next();  
			String valor = valores.next(); 
			((Template)tempalte).setParam(key, valor);
		}		
	}	
}
