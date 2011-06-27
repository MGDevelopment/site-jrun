/**
 * 
 */
package com.tmk.seguridad;

/**
 * @author omsartori
 *
 */

import java.net.URLEncoder;
import java.net.URLDecoder;
import com.tmk.kernel.CryptUtil;

public final class EncripcionURL {
	
	public static final String ISO88591 = "ISO-8859-1";
	public static final String UTF8 = "UTF-8";
	private static final String DEFAULT_CHARSET = ISO88591;
	
	// encripta y url encodea;
	public static String encriptar (String texto, String charset) throws Exception {
		try {
			return URLEncoder.encode((new String(CryptUtil.encriptar(texto.getBytes(charset)), charset)), charset);
		} catch (Exception e) {
			throw new Exception("EXCEPTION] com.tmk.seguridad.EncripcionURL.encriptar(" + texto + ", " + charset + ") " + "exception:" + e.toString());
		}
	}
	
	// desencodea de url y desencripta;	
	public static String desEncriptar (String texto, String charset) throws Exception {
		try {
			return new String(CryptUtil.desEncriptar(URLDecoder.decode(texto, charset).getBytes(charset)), charset);
		} catch (Exception e) {
			throw new Exception("EXCEPTION] com.tmk.seguridad.EncripcionURL.desEncriptar(" + texto + ", " + charset + ") " + "exception:" + e.toString());
		}
	}
	
	//encripta y url encodea;
	public static String encriptar (String texto) throws Exception {
		return encriptar(texto, DEFAULT_CHARSET);
	}
	
	//desencodea de url y desencripta;	
	public static String desEncriptar (String texto) throws Exception {
		return desEncriptar(texto, DEFAULT_CHARSET);
	}
} 
