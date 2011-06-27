/**
 *comvierte un array de bytes a string (desencripta)
 */
package com.tmk.xml.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.tmk.kernel.CryptUtil;

/**
 * @author oClopez
 * @see convierte de un byte[] a String
*/
public class DesencriptarByteArrayConverter implements SingleValueConverter {

	public Object fromString(String arg0) {
		return null;
	}

	public String toString(Object array) {
		byte [] loginDesencriptado = CryptUtil.desEncriptar((byte[])array);
		try{
			if (loginDesencriptado != null) {
				return new String(loginDesencriptado);
			}
			else {
				throw new Exception("No se pudo desencriptar el login del socio ");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean canConvert(Class type) {
		return (type.equals(byte[].class));
	}

}
