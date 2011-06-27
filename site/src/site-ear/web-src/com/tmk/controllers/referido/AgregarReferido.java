/**
 * $Log: AgregarReferido.java,v $
 * Revision 1.11  2009/03/27 21:00:26  oClopez
 * no message
 *
 * Revision 1.10  2009/03/11 20:01:52  oClopez
 * modificaciones y agregados
 *
 * Revision 1.9  2009/03/04 12:55:05  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.8  2008/04/09 20:20:21  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.7  2005/07/18 13:53:07  omsartori
 * - Modificaciones en referido
 * - ejb articulo reducido
 * - buscador de editor por id
 *
 * Revision 1.6  2005/06/28 16:37:46  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.5  2005/06/09 14:36:21  omsartori
 * - Referidos: banner de beneficios
 * - Posicionamiento: tags en resultado de busqueda
 *
 * Revision 1.4  2005/05/17 14:38:56  omsartori
 * - Posicionamiento tags en pags desde el home, tags por producto, nueva pagina de biografia
 * - Referido, interface de carga modificada a tres referidos independientes, guarda nombre ap y mail
 *
 * Revision 1.3  2005/04/26 17:32:09  omsartori
 * - Arreglado bug buscador rapido comilla simple.
 * - Arreglado bug buscador avanzado comilla simple.
 * - Referido circuito completo testeado.
 * - Posicionamiento: metas home, links producto a detalle y a buscador por categoria.
 *
 * Revision 1.2  2005/02/23 13:45:34  omsartori
 * - ingreso a referidos desde mi cuenta.
 * - recuperacion del referido si se cae la sesion
 * - reconocimiento del referente
 * - compra del referente
 *
 * Revision 1.1  2005/02/10 14:27:34  omsartori
 * - Habilitacion de referidos por xml
 * - Referidos: envio, reconocimiento y registro
 * - Cupones de referido y referente configurables por xml
 * - Cupon de registro configurable por xml
 *
 */
package com.tmk.controllers.referido;

import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.*;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.Socio2Service;
//import com.tmk.socio.SocioLocal;
//import com.tmk.socio.SocioLocalHome;
import com.tmk.src.socio.SocioPK;
import com.tmk.referido.ReferidoLocalHome;
//import com.tmk.util.ShortCuts;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Calendar;
import java.net.URLEncoder;


public class AgregarReferido extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//String _DISPACHER = request.getParameter("_DISPACHER");
            // Si no esta logueado lo envia a esa pagina
			SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
			if (socioPK == null) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, ReferidoManager.SERVLET);
				//response.sendRedirect(_DISPACHER==null ? "/miCuenta" : "/miCuenta");
				response.sendRedirect("/miCuenta");
				TmkLogger.info("REFERIDOS] No hay socio referente. Redireccion al login");
				return;
			} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
 				request.getSession().setAttribute(MainHelper.URL_REDIRECT, ReferidoManager.SERVLET);
				//response.sendRedirect(_DISPACHER == null ? MainHelper.PAGE_REGISTRO_SOCIO_CADENA : MainHelper.PAGE_REGISTRO_SOCIO_CADENA_REDISENO);
 				//response.sendRedirect(MainHelper.PAGE_REGISTRO_SOCIO_CADENA_REDISENO);
 				response.sendRedirect(MainHelper.PAGE_REGISTRO_SOCIO_CADENA);
				TmkLogger.info("REFERIDOS] No hay socio referente. ES SOCIO TMK Redireccion a registroSocioCadena");
				return;
			}

			//Datos que requiere el mail al referido
			String mailReferido1 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO1), null);
			String mailReferido2 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO2), null);
			String mailReferido3 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO3), null);
			String mailReferido4 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO4), null);
			String mailReferido5 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO5), null);

			String nombreReferido1 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO1), null);
			String nombreReferido2 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO2), null);
			String nombreReferido3 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO3), null);
			String nombreReferido4 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO4), null);
			String nombreReferido5 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO5), null);

			String apellidoReferido1 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO1), null);
			String apellidoReferido2 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO2), null);
			String apellidoReferido3 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO3), null);
			String apellidoReferido4 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO4), null);
			String apellidoReferido5 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO5), null);

            String comentarioReferido1 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO1), null);
			String comentarioReferido2 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO2), null);
			String comentarioReferido3 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO3), null);
			String comentarioReferido4 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO4), null);
			String comentarioReferido5 = Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO5), null);

			if (mailReferido1 == null || nombreReferido1 == null || apellidoReferido1 == null) {
				request.getSession().setAttribute("URL_REDIRECT", ReferidoManager.SERVLET);
				response.sendRedirect(ReferidoManager.PAGINA_DATOS);
				//TmkLogger.info("REFERIDOS] No tiene los datos minimos. Redireccion a pagina de carga");
				return;
			}

			// alguno de los referidos es un socio de tmk

			StringBuffer datos = new StringBuffer("");
			datos.append ("?");
			datos.append (ReferidoManager.CAMPO_MAIL_REFERIDO1);
			datos.append ("=");
			datos.append ((mailReferido1 != null)? URLEncoder.encode(mailReferido1, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_NOMBRE_REFERIDO1);
			datos.append ("=");
			datos.append ((nombreReferido1 != null)? URLEncoder.encode(nombreReferido1, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_APELLIDO_REFERIDO1);
			datos.append ("=");
			datos.append ((apellidoReferido1 != null)? URLEncoder.encode(apellidoReferido1, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_COMENTARIO_REFERIDO1);
			datos.append ("=");
			datos.append ((comentarioReferido1 != null)? URLEncoder.encode(comentarioReferido1, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_MAIL_REFERIDO2);
			datos.append ("=");
			datos.append ((mailReferido2 != null)? URLEncoder.encode(mailReferido2, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_NOMBRE_REFERIDO2);
			datos.append ("=");
			datos.append ((nombreReferido2 != null)? URLEncoder.encode(nombreReferido2, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_APELLIDO_REFERIDO2);
			datos.append ("=");
			datos.append ((apellidoReferido2 != null)? URLEncoder.encode(apellidoReferido2, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_COMENTARIO_REFERIDO2);
			datos.append ("=");
			datos.append ((comentarioReferido2 != null)? URLEncoder.encode(comentarioReferido2, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_MAIL_REFERIDO3);
			datos.append ("=");
			datos.append ((mailReferido3 != null)? URLEncoder.encode(mailReferido3, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_NOMBRE_REFERIDO3);
			datos.append ("=");
			datos.append ((nombreReferido3 != null)? URLEncoder.encode(nombreReferido3, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_APELLIDO_REFERIDO3);
			datos.append ("=");
			datos.append ((apellidoReferido3 != null)? URLEncoder.encode(apellidoReferido3, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_COMENTARIO_REFERIDO3);
			datos.append ("=");
			datos.append ((comentarioReferido3 != null)? URLEncoder.encode(comentarioReferido3, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_MAIL_REFERIDO4);
			datos.append ("=");
			datos.append ((mailReferido4 != null)? URLEncoder.encode(mailReferido4, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_NOMBRE_REFERIDO4);
			datos.append ("=");
			datos.append ((nombreReferido4 != null)? URLEncoder.encode(nombreReferido4, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_APELLIDO_REFERIDO4);
			datos.append ("=");
			datos.append ((apellidoReferido4 != null)? URLEncoder.encode(apellidoReferido4, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_COMENTARIO_REFERIDO4);
			datos.append ("=");
			datos.append ((comentarioReferido4 != null)? URLEncoder.encode(comentarioReferido4, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_MAIL_REFERIDO5);
			datos.append ("=");
			datos.append ((mailReferido5 != null)? URLEncoder.encode(mailReferido5, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_NOMBRE_REFERIDO5);
			datos.append ("=");
			datos.append ((nombreReferido5 != null)? URLEncoder.encode(nombreReferido5, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_APELLIDO_REFERIDO5);
			datos.append ("=");
			datos.append ((apellidoReferido5 != null)? URLEncoder.encode(apellidoReferido5, "ISO-8859-1"): "");
			datos.append ("&");
			datos.append (ReferidoManager.CAMPO_COMENTARIO_REFERIDO5);
			datos.append ("=");
			datos.append ((comentarioReferido5 != null)? URLEncoder.encode(comentarioReferido5, "ISO-8859-1"): "");

			//TmkLogger.debug(datos.toString());
	        boolean referidoError = false;
	        Socio2Service servicio = ServiceLocator.getSocioService(); 
	        
			//if (ShortCuts.findSocioByLogin(mailReferido1) != null) {
	        if (servicio.findSocioByLogin(mailReferido1) != null) {	        
				TmkLogger.info("REFERIDOS] El referido " + mailReferido1 + " ya es socio de TMK");
				request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO1, "El mail ingresado corresponde a un socio actual de " + Globals.NOMBRE_DEL_SITIO);
				referidoError = true;
			}

			//if (mailReferido2!=null && ShortCuts.findSocioByLogin(mailReferido2) != null) {
	        if (mailReferido2!=null && servicio.findSocioByLogin(mailReferido2) != null) {
				TmkLogger.info("REFERIDOS] El referido "  + mailReferido2 + " ya es socio de TMK");
				request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO2, "El mail ingresado corresponde a un socio actual de " + Globals.NOMBRE_DEL_SITIO);
				referidoError = true;
			}

			//if (mailReferido3!=null && ShortCuts.findSocioByLogin(mailReferido3) != null) {
	        if (mailReferido3!=null && servicio.findSocioByLogin(mailReferido3) != null) {	
				TmkLogger.info("REFERIDOS] El referido "  + mailReferido3 + " ya es socio de TMK");
				request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO3, "El mail ingresado corresponde a un socio actual de " + Globals.NOMBRE_DEL_SITIO);
				referidoError = true;
			}

			//if (mailReferido4!=null && ShortCuts.findSocioByLogin(mailReferido4) != null) {
	        if (mailReferido4!=null && servicio.findSocioByLogin(mailReferido4) != null) {
				TmkLogger.info("REFERIDOS] El referido "  + mailReferido4 + " ya es socio de TMK");
				request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO4, "El mail ingresado corresponde a un socio actual de " + Globals.NOMBRE_DEL_SITIO);
				referidoError = true;
			}

			//if (mailReferido5!=null && ShortCuts.findSocioByLogin(mailReferido5) != null) {
	        if (mailReferido5!=null && servicio.findSocioByLogin(mailReferido5) != null) {
				TmkLogger.info("REFERIDOS] El referido "  + mailReferido5 + " ya es socio de TMK");
				request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO5, "El mail ingresado corresponde a un socio actual de " + Globals.NOMBRE_DEL_SITIO);
				referidoError = true;
			}


			if (referidoError) {
				response.sendRedirect(response.encodeURL(ReferidoManager.PAGINA_DATOS + datos.toString()));
				return;
			}

			//SocioLocalHome socioLH = (SocioLocalHome) DBUtil.getHome("Socio");
			//SocioLocal socio = socioLH.findByPrimaryKey(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
			Socios2 socio = servicio.findByPrimaryKey(socioPK);

			Calendar fechaVencReferido = Calendar.getInstance();
			Date fechaActual = fechaVencReferido.getTime();
			fechaVencReferido.add(Calendar.DATE, Globals.VIGENCIA_DE_REFERIDO);


			//REFERIDO 1
            //grabo referido 1
            ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			Long codigoReferido1 = ReferidoManager.getCodigoReferido();

			referidoLH.create(//socio.getID_SOCIO(),
						 	  socio.getId_socio(),
			                  //socio.getID_SUCURSAL(),
							  socio.getId_sucursal(),
			                  null,
			                  null,
                              codigoReferido1,
                              null,
                              ReferidoManager.REFERENCIA_ENVIADA,
                              nombreReferido1,
                              apellidoReferido1,
                              mailReferido1,
                              new Timestamp(fechaActual.getTime()),
                              new Timestamp(fechaVencReferido.getTime().getTime()),
                              null,
                              Globals.CUPON_REFERIDO.getId(),
                              null,
                              Globals.CUPON_REFERIDO.getBeneficio(),
                              null
			);

			//mail referido 1
			StringBuffer params1 = new StringBuffer();
			params1.append("?");
			params1.append(ReferidoManager.CAMPO_CODIGO_REFERIDO);
			params1.append("=");
			params1.append(URLEncoder.encode(new String (codigoReferido1.toString()).replaceAll("\\.", ""), "ISO-8859-1"));
			params1.append("&");
			params1.append(ReferidoManager.CAMPO_COMENTARIO_REFERIDO1);
			params1.append("=");
			params1.append(URLEncoder.encode(Convert.toString(comentarioReferido1, ""), "ISO-8859-1"));
			params1.append("&");
			params1.append(ReferidoManager.NOMBRE_REFERENTE);
			params1.append("=");
            //params1.append(URLEncoder.encode(Convert.toString(socio.getNOMBRES(), ""), "ISO-8859-1"));
			params1.append(URLEncoder.encode(Convert.toString(socio.getNombres(), ""), "ISO-8859-1"));
			params1.append("&");
			params1.append(ReferidoManager.APELLIDO_REFERENTE);
			params1.append("=");
            //params1.append(URLEncoder.encode(Convert.toString(socio.getAPELLIDOS(), ""), "ISO-8859-1"));
			params1.append(URLEncoder.encode(Convert.toString(socio.getApellidos(), ""), "ISO-8859-1"));

			MailUtil.sendMail(Globals.MAIL_REFERIDOS,
							  mailReferido1,
							  //Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS()),
							  Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()),
							  comentarioReferido1,
							  ReferidoManager.PAGINA_MAIL_REFERIDO + params1.toString()
			);
			//TmkLogger.debug(ReferidoManager.PAGINA_MAIL_REFERIDO + params1.toString());
		    //REFERIDO 1


			//REFERIDO 2
            if (mailReferido2 != null) {
			    //grabo referido 2
				Long codigoReferido2 = ReferidoManager.getCodigoReferido();
				referidoLH.create(//socio.getID_SOCIO(),
								socio.getId_socio(),
								  //socio.getID_SUCURSAL(),
								socio.getId_sucursal(),
								  null,
								  null,
								  codigoReferido2,
								  null,
								  ReferidoManager.REFERENCIA_ENVIADA,
								  nombreReferido2,
								  apellidoReferido2,
								  mailReferido2,
								  new Timestamp(fechaActual.getTime()),
								  new Timestamp(fechaVencReferido.getTime().getTime()),
								  null,
								  Globals.CUPON_REFERIDO.getId(),
								  null,
								  Globals.CUPON_REFERIDO.getBeneficio(),
								  null
				);

	            //mail referido 2
				StringBuffer params2 = new StringBuffer();
				params2.append("?");
				params2.append(ReferidoManager.CAMPO_CODIGO_REFERIDO);
				params2.append("=");
				params2.append(URLEncoder.encode(new String (codigoReferido2.toString()).replaceAll("\\.", ""), "ISO-8859-1"));
			    params2.append("&");
				params2.append(ReferidoManager.CAMPO_COMENTARIO_REFERIDO1);
				params2.append("=");
				params2.append(URLEncoder.encode(Convert.toString(comentarioReferido2, ""), "ISO-8859-1"));
                params2.append("&");
				params2.append(ReferidoManager.NOMBRE_REFERENTE);
				params2.append("=");
				//params2.append(URLEncoder.encode(Convert.toString(socio.getNOMBRES(), ""), "ISO-8859-1"));
				params2.append(URLEncoder.encode(Convert.toString(socio.getNombres(), ""), "ISO-8859-1"));
				params2.append("&");
				params2.append(ReferidoManager.APELLIDO_REFERENTE);
				params2.append("=");
				//params2.append(URLEncoder.encode(Convert.toString(socio.getAPELLIDOS(), ""), "ISO-8859-1"));
				params2.append(URLEncoder.encode(Convert.toString(socio.getApellidos(), ""), "ISO-8859-1"));

				MailUtil.sendMail(Globals.MAIL_REFERIDOS,
								  mailReferido2,
								  //Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS()),
								  Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()),
								  comentarioReferido2,
								  ReferidoManager.PAGINA_MAIL_REFERIDO + params2.toString()
				);
	        //   TmkLogger.debug(ReferidoManager.PAGINA_MAIL_REFERIDO + params2.toString());
            }

			//REFERIDO 3
			//grabo referido 3
			if (mailReferido3 != null) {
				Long codigoReferido3 = ReferidoManager.getCodigoReferido();
				referidoLH.create(//socio.getID_SOCIO(),
								socio.getId_socio(),
								  //socio.getID_SUCURSAL(),
								socio.getId_sucursal(),
								  null,
								  null,
								  codigoReferido3,
								  null,
								  ReferidoManager.REFERENCIA_ENVIADA,
								  nombreReferido3,
								  apellidoReferido3,
								  mailReferido3,
								  new Timestamp(fechaActual.getTime()),
								  new Timestamp(fechaVencReferido.getTime().getTime()),
								  null,
								  Globals.CUPON_REFERIDO.getId(),
								  null,
								  Globals.CUPON_REFERIDO.getBeneficio(),
								  null
				);
				//mail referido 3
			   StringBuffer params3 = new StringBuffer();
			   params3.append("?");
			   params3.append(ReferidoManager.CAMPO_CODIGO_REFERIDO);
			   params3.append("=");
			   params3.append(URLEncoder.encode(new String (codigoReferido3.toString()).replaceAll("\\.", ""), "ISO-8859-1"));
			   params3.append("&");
			   params3.append(ReferidoManager.CAMPO_COMENTARIO_REFERIDO1);
			   params3.append("=");
			   params3.append(URLEncoder.encode(Convert.toString(comentarioReferido3, ""), "ISO-8859-1"));
    		   params3.append("&");
    		   params3.append(ReferidoManager.NOMBRE_REFERENTE);
			   params3.append("=");
			   //params3.append(URLEncoder.encode(Convert.toString(socio.getNOMBRES(), ""), "ISO-8859-1"));
			   params3.append(URLEncoder.encode(Convert.toString(socio.getNombres(), ""), "ISO-8859-1"));
			   params3.append("&");
			   params3.append(ReferidoManager.APELLIDO_REFERENTE);
			   params3.append("=");
			   //params3.append(URLEncoder.encode(Convert.toString(socio.getAPELLIDOS(), ""), "ISO-8859-1"));
			   params3.append(URLEncoder.encode(Convert.toString(socio.getApellidos(), ""), "ISO-8859-1"));

			   MailUtil.sendMail(Globals.MAIL_REFERIDOS,
					 mailReferido3,
					 //Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS()),
					 Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()),
					 comentarioReferido3,
					 ReferidoManager.PAGINA_MAIL_REFERIDO + params3.toString()
				);
            //    TmkLogger.debug(ReferidoManager.PAGINA_MAIL_REFERIDO + params3.toString());
			}
			//REFERIDO 3


			//REFERIDO 4
			//grabo referido 4
			if (mailReferido4 != null) {
				Long codigoReferido4 = ReferidoManager.getCodigoReferido();
				referidoLH.create(//socio.getID_SOCIO(),
								socio.getId_socio(),
								  //socio.getID_SUCURSAL(),
								socio.getId_sucursal(),
								  null,
								  null,
								  codigoReferido4,
								  null,
								  ReferidoManager.REFERENCIA_ENVIADA,
								  nombreReferido4,
								  apellidoReferido4,
								  mailReferido4,
								  new Timestamp(fechaActual.getTime()),
								  new Timestamp(fechaVencReferido.getTime().getTime()),
								  null,
								  Globals.CUPON_REFERIDO.getId(),
								  null,
								  Globals.CUPON_REFERIDO.getBeneficio(),
								  null
				);
				//mail referido 4
			   StringBuffer params4 = new StringBuffer();
			   params4.append("?");
			   params4.append(ReferidoManager.CAMPO_CODIGO_REFERIDO);
			   params4.append("=");
			   params4.append(URLEncoder.encode(new String (codigoReferido4.toString()).replaceAll("\\.", ""), "ISO-8859-1"));
			   params4.append("&");
			   params4.append(ReferidoManager.CAMPO_COMENTARIO_REFERIDO1);
			   params4.append("=");
			   params4.append(URLEncoder.encode(Convert.toString(comentarioReferido4, ""), "ISO-8859-1"));
    		   params4.append("&");
    		   params4.append(ReferidoManager.NOMBRE_REFERENTE);
			   params4.append("=");
			   //params4.append(URLEncoder.encode(Convert.toString(socio.getNOMBRES(), ""), "ISO-8859-1"));
			   params4.append(URLEncoder.encode(Convert.toString(socio.getNombres(), ""), "ISO-8859-1"));
			   params4.append("&");
			   params4.append(ReferidoManager.APELLIDO_REFERENTE);
			   params4.append("=");
			   //params4.append(URLEncoder.encode(Convert.toString(socio.getAPELLIDOS(), ""), "ISO-8859-1"));
			   params4.append(URLEncoder.encode(Convert.toString(socio.getApellidos(), ""), "ISO-8859-1"));

			   MailUtil.sendMail(Globals.MAIL_REFERIDOS,
					 mailReferido4,
					 //Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS()),
					 Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()),
					 comentarioReferido4,
					 ReferidoManager.PAGINA_MAIL_REFERIDO + params4.toString()
				);
            //    TmkLogger.debug(ReferidoManager.PAGINA_MAIL_REFERIDO + params4.toString());
			}
			//REFERIDO 4


			//REFERIDO 5
			//grabo referido 5
			if (mailReferido5 != null) {
				Long codigoReferido5 = ReferidoManager.getCodigoReferido();
				referidoLH.create(//socio.getID_SOCIO(),
								  //socio.getID_SUCURSAL(),
								socio.getId_socio(),
								socio.getId_sucursal(),
								  null,
								  null,
								  codigoReferido5,
								  null,
								  ReferidoManager.REFERENCIA_ENVIADA,
								  nombreReferido5,
								  apellidoReferido5,
								  mailReferido5,
								  new Timestamp(fechaActual.getTime()),
								  new Timestamp(fechaVencReferido.getTime().getTime()),
								  null,
								  Globals.CUPON_REFERIDO.getId(),
								  null,
								  Globals.CUPON_REFERIDO.getBeneficio(),
								  null
				);
				//mail referido 5
			   StringBuffer params5 = new StringBuffer();
			   params5.append("?");
			   params5.append(ReferidoManager.CAMPO_CODIGO_REFERIDO);
			   params5.append("=");
			   params5.append(URLEncoder.encode(new String (codigoReferido5.toString()).replaceAll("\\.", ""), "ISO-8859-1"));
			   params5.append("&");
			   params5.append(ReferidoManager.CAMPO_COMENTARIO_REFERIDO1);
			   params5.append("=");
			   params5.append(URLEncoder.encode(Convert.toString(comentarioReferido5, ""), "ISO-8859-1"));
    		   params5.append("&");
			   params5.append(ReferidoManager.NOMBRE_REFERENTE);
			   params5.append("=");
			   //params5.append(URLEncoder.encode(Convert.toString(socio.getNOMBRES(), ""), "ISO-8859-1"));
			   params5.append(URLEncoder.encode(Convert.toString(socio.getNombres(), ""), "ISO-8859-1"));
			   params5.append("&");
			   params5.append(ReferidoManager.APELLIDO_REFERENTE);
			   params5.append("=");
			   //params5.append(URLEncoder.encode(Convert.toString(socio.getAPELLIDOS(), ""), "ISO-8859-1"));
			   params5.append(URLEncoder.encode(Convert.toString(socio.getApellidos(), ""), "ISO-8859-1"));

			   MailUtil.sendMail(Globals.MAIL_REFERIDOS,
					 mailReferido5,
					 //Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS()),
					 Globals.NOMBRE_DEL_SITIO + " - Recomendación de " + Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()),
					 comentarioReferido5,
					 ReferidoManager.PAGINA_MAIL_REFERIDO + params5.toString()
				);
            //    TmkLogger.debug(ReferidoManager.PAGINA_MAIL_REFERIDO + params5.toString());
			}
			//REFERIDO 5

			request.getSession().setAttribute("URL_REDIRECT", ReferidoManager.PAGINA_ANTERIOR);
			//response.sendRedirect("/miCuenta/index.jsp?seccionMiCuenta=11A&opcionMenuReferido=2");
			response.sendRedirect("/referido/referidoConfirmado.jsp");

		} catch (Exception e) {

			TmkLogger.error("REFERIDOS] No se pudo grabar el referido. " + e.getMessage() + " " + e.toString());
			response.sendRedirect("/errorPage/errorPage.jsp");
			return;
		}
	}
}


