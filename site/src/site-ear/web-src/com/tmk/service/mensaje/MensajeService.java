package com.tmk.service.mensaje;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.alianza.EstadisticaVisitas;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.xml.mensaje.Mensaje;
import com.tmk.xml.mensaje.Mensajes;

public class MensajeService {
	public static Mensajes mensajes = null;
	public static final String MSGUSR = "MSGUSR";
	public static final String VISUALIZAMSGUSR = "VISUALIZAMSGUSR";
	public static final String IDMSGUSRACTUAL = "IDMSGUSRACTUAL";
	public static final String RES_MENSAJE = "/recursos/leyendas/mensajes/msj.xml";

	//carga los mensajes del file system al inicio de la aplicacion y cada x tiempo
	public static void cargarMensajesDeUsuario() throws Exception {
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(Contenido.getServletContext().getRealPath(RES_MENSAJE));
			xstream.alias("mensajes", com.tmk.xml.mensaje.Mensajes.class);
			xstream.alias("lista", ArrayList.class);
			xstream.alias("mensaje", com.tmk.xml.mensaje.Mensaje.class);
			/*agrega el atributo fechaVencimiento a la tag mensaje*/
			xstream.useAttributeFor(com.tmk.xml.mensaje.Mensaje.class, "fechaVencimiento");						
			Mensajes mensajes = (Mensajes)xstream.fromXML(fis);
			mensajes.filtrar();
			MensajeService.mensajes = mensajes;
		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
			throw e;
		}
	}
	
	public static Mensajes getMensajeDeUsuario(HttpServletRequest request) {
		Mensajes mensajes = (Mensajes)request.getSession().getAttribute(MSGUSR);
		//chequeo si es https, no mostrar en el proceso de compras o zonas seguras.
		String referer = request.getRequestURL().toString();		
		if(referer.indexOf("https:") >= 0) {
			mensajes = null;
		}
		if (mensajes == null) {
			return new Mensajes();
		} else {
			return mensajes;
		}
	}

	private static void setMensajeDeUsuario(HttpServletRequest request, Mensajes mensajes) {
		request.getSession().setAttribute(MSGUSR, mensajes);
	}

	//levanta la cookie y compara con los mensajes actuales para obtener la lista
	public static void compileMensajeDeUsuario(HttpServletRequest request) {
		if (MensajeService.mensajes != null) {
			ArrayList aux = new ArrayList (Arrays.asList(MensajeService.mensajes.getMensajes()));
			Cookie cookie = EstadisticaVisitas.getCookie(MSGUSR, request);
			if (cookie != null) {
				String id[] = cookie.getValue().split(",");
				for (int j=0; j<id.length; j++) {
					for (int i=0; i<aux.size(); i++) {
						if (((Mensaje)aux.get(i)).getId().equals(id[j])) {
							aux.remove(i);
							break;
						}
					}
				}
			}
			Mensajes mensajes = new Mensajes(aux);
			setMensajeDeUsuario(request, mensajes);
		}
	}

	public static void compileMensajeDeUsuario(HttpServletRequest request, Cookie cookie) {
		if (MensajeService.mensajes != null) {
			ArrayList aux = new ArrayList (Arrays.asList(MensajeService.mensajes.getMensajes()));
			//Cookie cookie = EstadisticaVisitas.getCookie(MSGUSR, request);
			if (cookie != null) {
				String id[] = cookie.getValue().split(",");
				for (int j=0; j<id.length; j++) {
					for (int i=0; i<aux.size(); i++) {
						if (((Mensaje)aux.get(i)).getId().equals(id[j])) {
							aux.remove(i);
							break;
						}
					}
				}
			}
			Mensajes mensajes = new Mensajes(aux);
			setMensajeDeUsuario(request, mensajes);
		}
	}

	public static void setMensajeLeido(HttpServletRequest request, HttpServletResponse response, String id) {
		Cookie cookie = EstadisticaVisitas.getCookie(MSGUSR, request);
		if (cookie == null) {
			cookie = new Cookie(MSGUSR, id);
		} else {
			cookie.setValue(cookie.getValue() + "," + id);
		}
		cookie.setMaxAge(60 * 60 * 24 * 30);
		response.addCookie(cookie);
		compileMensajeDeUsuario(request, cookie);
	}

	public static boolean getVisualizaMensaje(HttpServletRequest request) {
		boolean retorno = true;
		Cookie cookie = EstadisticaVisitas.getCookie(VISUALIZAMSGUSR, request);
		if (cookie != null) {
			retorno = Convert.toBoolean(cookie.getValue(), true);
		}
		return retorno;
	}

	public static void setVisualizaMensaje(HttpServletRequest request, HttpServletResponse response, String visualiza) {
		Cookie cookie = EstadisticaVisitas.getCookie(VISUALIZAMSGUSR, request);
		if (cookie == null) {
			cookie = new Cookie(VISUALIZAMSGUSR, visualiza);
		} else {
			cookie.setValue(visualiza);
		}
		cookie.setMaxAge(60 * 60 * 24 * 30);
		response.addCookie(cookie);
	}

	public static void setMensajeActual(HttpServletRequest request, String id) {
		request.getSession().setAttribute(IDMSGUSRACTUAL, id);
	}

	public static String getMensajeActual(HttpServletRequest request) {
		return (String)request.getSession().getAttribute(IDMSGUSRACTUAL);
	}

}
