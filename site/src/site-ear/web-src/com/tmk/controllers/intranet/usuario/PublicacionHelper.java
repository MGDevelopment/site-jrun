package com.tmk.controllers.intranet.usuario;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.http.ClientSocket;
import com.tmk.http.Request;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.xml.bit.BitObject;
import com.tmk.xml.bit.Results;
import com.tmk.xml.bit.ShortUrl;

public final class PublicacionHelper {
	/**
	 * @se postea un comentario en twitter.
	 * @param texto 
	 * @throws Exception si falla el logueo o si twiter esta bajo. 
	 */
	private static void publicacionTwitter(String texto) throws Exception{					
			Request req = new Request("http://twitter.com/statuses/update.json", Request.POST);
//			req.setAuthorization("msartori", "msart123");
			if (Globals.esModoRelease()) {
				req.setAuthorization("tematikacom", "comentwit");
			} else {
				req.setAuthorization("msartori", "msart123");
			}
		    req.addParam("status", texto);
			ClientSocket.sendRequest(req);					
	}
	
	/**
	 * @param urlLarga
	 * @return String
	 * @throws Exception
	 * @see obtiene una url corta desde el sitio <pre>http://api.bit.ly/shorten</pre> 
	 * @see para cada comentario que se postee en twitter
	 */
	private static String getUrlCorta(String urlLarga) throws Exception{	
		String jsonRespuesta= null ;
		Request req = new Request("http://api.bit.ly/shorten", Request.GET);
	    req.addParam("longUrl", urlLarga);
		req.addParam("version", "2.0.1");
		if (Globals.esModoRelease()) {
			req.setAuthorization("tematikacom", "comentwit");
		} else {
			req.setAuthorization("krloss", "13052007");
		}
		jsonRespuesta = ClientSocket.sendRequest(req);		
		jsonRespuesta = "{\"resultado\":" + jsonRespuesta+"}";		
		jsonRespuesta = jsonRespuesta.replaceAll(urlLarga, "bitObject");

		XStream xstream = new XStream(new JettisonMappedXmlDriver());	
		xstream.alias("resultado", ShortUrl.class);
		xstream.alias("results",Results.class);
		xstream.alias("bitObject",BitObject.class);
		xstream.omitField(BitObject.class, "shortCNAMEUrl");
		
		ShortUrl shortUrl = (ShortUrl)xstream.fromXML(jsonRespuesta);
		
		if(shortUrl.getErrorCode() == 0) {
			return shortUrl.getResult().getResults().getShortUrl();
		} else {
			TmkLogger.error("Codigo de error del api http://api.bit.ly/shorten -->" + shortUrl.getErrorCode());
			throw new Exception();
		}
		
	}
		

	/**
     * @see String retorna el texto en el formado xxxxxx dijo sobre xxxx texto...
     * @param comentario
     */
	private static String formatearTextoTwitter(ComentarioArticulos comentario) throws Exception {
		StringBuffer texto = new StringBuffer();		
		StringBuffer url = new StringBuffer("http://").append(Globals.DOMINIO_SITIO);
		comentario.getArticulo().setUrlDetalle();
		url.append(comentario.getArticulo().getUrlDetalle());
		texto.append(comentario.getSocio().getNombres().split(" ")[0]); //+ " " + comentario.getSocio().getApellidos());
		texto.append(" dijo sobre ");
		String titulo = Convert.corregir(comentario.getArticulo().getTitulo(), true)+":";
		texto.append((titulo.length() > 20) ? titulo.substring(0,17) + "..." : titulo);
		texto.append(" ");
		int resto = 140 - texto.toString().length();
		resto = resto - 25;
		texto.append((comentario.getComentario().length() > resto)? comentario.getComentario().substring(0, resto-3)+"...":comentario.getComentario());
		texto.append(" ");
		texto.append(getUrlCorta(url.toString()));
		

		return texto.toString();
	}   
	
	public static void publicarComentarioEnTwitter(ComentarioArticulos comentario) throws Exception{
		publicacionTwitter(formatearTextoTwitter(comentario));
	}
	/**
	 * @see elimina del un array de string las posiciones que son nulos
	 * @param obj
	 * @return String[] sin nulos
	*/
	/*public static String[] filtrarNulos(String[] obj) {
		int totalSinNulos = 0;
		int indice = 0;
		for(int i = 0;i < obj.length;i++) {
			if(obj[i]!=null)
				totalSinNulos ++;
		}
		String [] sinNulos = new String[totalSinNulos];
		for(int i = 0;(i < totalSinNulos && indice < totalSinNulos); i++) {
			if(obj[i] != null) {
				sinNulos[indice] = obj[i];
				indice ++;
			}
		}		
		return sinNulos;
	}*/
}
