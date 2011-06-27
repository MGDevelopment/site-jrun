/**
 * $Log: HTMLUtil.java,v $
 * Revision 1.4  2009/04/07 19:56:41  msartori
 * no message
 *
 * Revision 1.3  2008/05/30 16:03:15  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.2  2005/11/09 12:19:01  omsartori
 * - Homes estaticas, deteccion de errores en la generacion de los componentes que permite continuar generando.
 *                                Aplicado al controlador de intranet y al proceso en back.
 *                                Mail de aviso detallado.
 *                                Inclusion de componentes generados en otros archivos.
 *
 * Revision 1.1  2003/12/04 17:19:12  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 */
package com.tmk.kernel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Herramientas para manejo de HTML
 */
public class HTMLUtil {

	/**
	 * Se conecta a una pagina y la baja como String
	 */

	public static String download(String page) throws Exception {
		try {

			URL url = new URL(page);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			uc.setFollowRedirects(true);

			if (uc.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream stream = uc.getInputStream();
				try {
					StringBuffer result = new StringBuffer();

					// baja el texto del html
					boolean continuar = true;
					do {
						int dato = stream.read();
						continuar = (dato != -1);
						if (continuar) result.append((char) dato);
					} while (continuar);

					// devuelve el resultado
					return result.toString();

				} finally {
					stream.close();
				}

			} else {
				String mensaje = "Error obtenido: " + uc.getResponseMessage() + ":" + uc.getResponseCode();
				//TmkLogger.debug(mensaje);
				throw new Exception(mensaje);
			}

		} catch (Exception e) {
			String mensaje = "No se pudo acceder a la pagina, error " + page + e.getMessage();
			TmkLogger.debug(mensaje);
			throw new Exception(mensaje);
		}
	}

	/*public static String sendPost(String strUrl, String params[]) throws Exception {
		StringBuffer retorno = new StringBuffer("");
		URL url;
	    HttpURLConnection urlConn;
	    DataOutputStream printout;
	    DataInputStream input;
	    url = new URL (strUrl);
	    // URL connection channel.
	    urlConn = (HttpURLConnection) url.openConnection();
	    // Let the run-time system (RTS) know that we want input.
	    urlConn.setDoInput (true);
	    // Let the RTS know that we want to do output.
	    urlConn.setDoOutput (true);
	    // No caching, we want the real thing.
	    urlConn.setUseCaches (false);
	    // Specify the content type.
	    urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    // Send POST output.
	    printout = new DataOutputStream (urlConn.getOutputStream ());
	    StringBuffer content = new StringBuffer("");
	    for (int i=0; i<params.length; i= i+2) {
	    	if (i!=0) {
	    		content.append("&").append(params[i]).append("=").append(URLEncoder.encode(params[i+1]));
	    	} else {
	    		content.append(params[i]).append("=").append(URLEncoder.encode(params[i+1]));
	    	}
	    }
	    printout.writeBytes (content.toString());
	    printout.flush ();
	    printout.close ();
	    // Get response data.
	    input = new DataInputStream (urlConn.getInputStream ());
	    String str;
	    while (null != ((str = input.readLine()))) {
	    	retorno.append(str);
	    }
	    input.close ();
	    return retorno.toString();
	}

	*/

}
