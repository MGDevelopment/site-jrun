/**
 * $Log: EstadisticaVisitas.java,v $
 * Revision 1.31  2009/04/09 15:38:30  msartori
 * no message
 *
 * Revision 1.30  2009/01/15 12:35:44  msartori
 * no message
 *
 * Revision 1.29  2007/10/18 20:06:56  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.28  2007/09/03 13:42:11  msartori
 * no message
 *
 * Revision 1.27  2007/05/09 18:17:58  omsartori
 * * Busqueda de Inicio: Al aplicar un criterio de ordenamiento se mantiene la apertura de busquedas por sección, en la versión anterior la busqueda se acotaba a la última sección mostrada.
 * * Aprobación de Ordenes Intranet: Se agrego un chequeo para evitar la doble aprobación desde la intranet que genera movimientos duplicados en central.
 * * Validación de Formularios: Se agrego el foco de retorno en la validación de los siguientes formularios
 *                                             Carga de Comentarios
 *                                             Alta de Alianzas
 * * Orden de Autores: Se modificaron todas las consultas para mostrar en Tematika el mismo orden de autores que viene dado por comercial. (Se regenerarán los articulos involucrados luego de la implementación en productivo)
 * * Carrito de Compras: Se activo nuevamente el carrito de compras con tecnología ajax, que cambia de color cuando se agrega un artículo y evita la necesidad de recargar la página.
 * * Seguimiento de sesiones: Se corrigio la fecha de creación, ahora se toma la fecha dada por el servidor de aplicación para evitar diferencias con la fecha de base de datos.
 * * Directorio de acceso a intranet: Se modificó el directorio de acceso a intranet por requerimiento de seguridad junto con sus respectivos links, el directorio actual es /236-TMK
 *
 * Revision 1.26  2006/08/02 15:20:37  omsartori
 * - Mejoras en busquedas>
 *                    Reemplazo de ejb por 1 solo qry
 *                    Hints no necesarios en qry principales eliminados
 * - Banner promos e institucionales agregados en detalle de producto
 * - Indice agregado a las busquedas por palabra clave
 * - Correccion en resaltado> tags incompletos en el corte
 * - Componente de imagen libre de ejb y qrys
 * - Componente de cotizacion parametrizado por monedas y libre de ejb
 *
 * Revision 1.25  2006/03/22 15:01:00  omsartori
 * - Pantallas de primer capitulo, biografias, indice de contenidos -> rediseñadas
 * - Generador de imagenes nuevas
 * - Correcciones en la aplicacion para cambios en base por backup
 * - Correccion en generacion de directorio
 *
 * Revision 1.24  2006/02/09 16:15:35  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.23  2006/01/13 15:45:51  omsartori
 * -Doc 11 Empro
 *   -Tracking de Sessiones
 *
 * Revision 1.22  2005/12/29 17:45:25  omsartori
 * * Cambios Dromo
 *    Se quitaron los datos distribuidor, proveedor e isbn.
 *    Se agregaron los datos marca y fabricante.
 *    Se agregaron los buscadores por marca y fabricante, tanto por código como por palabra.
 *    Se modificó el orden de las tarjetas en el plan de pago del detalle artículo, ahora es VIS, AME, MAS, DIN.
 *    Se agregaron los campos:
 *    Tipo de documento.
 *    Nro de Documento.
 *    Rango horario de recepción del pedido.
 *    Estos campos son visibles en la orden del cliente y en el detalle de orden de la intranet de TMK. Y deben completarse obligatoriamente para órdenes que contengan artículos de Dromo.
 *
 * * Se filtró la localidad “ciudad autónoma de Buenos Aires” del listado de localidades válidas para tmk.
 *
 * * Doc Empro 10
 *
 * Revision 1.21  2005/10/11 16:04:46  omsartori
 * - Seguimiento EMPRO
 *     - Visitas x canal
 *     - Compras x canal
 *     - Registraciones x canal
 *     - Ingresos al detalle de articulo x canal
 * - Filtro de texto en formato de Articulo
 * - Campo adicional en la orden para envios a Brasil (CPF CNPJ)
 *
 * Revision 1.20  2005/10/04 19:59:55  omsartori
 * - correccion reporte beneficios referente
 * - Seguimiento empro, visitas por canal
 *
 * Revision 1.19  2005/09/29 12:45:26  omsartori
 * - Ejb reducido en orden y en resultados de busqueda
 * - Mapa de productos
 * - Promo dia de la madre, pagina de promo.
 * - Seguimiento EMPRO, visitas por canales, registraciones por canales
 *
 * Revision 1.18  2005/09/12 20:06:26  omsartori
 * - Promo Dia de la madre.
 *      - config por xml.
 *      - pantalla de carga.
 *      - validacion y grabacion.
 * - EJB reducido en homes de Categorias.
 *
 * Revision 1.17  2005/09/06 13:29:45  omsartori
 * - Reporte de Referidos
 * - Campos piso, depto, edificio en visualizacion de direcciones de envio/fact
 *
 * Revision 1.16  2005/08/29 12:30:14  omsartori
 * - Redireccionamiento de dominio configurable.
 * - Campo comentario agregado en mail de tarjetas verificadas.
 * - Correccion tamanio de imagenes en ranking.
 *
 * Revision 1.15  2005/08/16 16:09:23  omsartori
 * - Cambios estéticos en home
 * - Posibilidad de incluir un file html en el destacado de las home
 * - Yahoo agregado al seguimiento
 * - Se agregaron las palabras de búsqueda al reporte de seguimiento.
 *
 * Revision 1.14  2005/08/03 16:08:56  omsartori
 * - eMPro: Ranking, links a busqueda por atributo principal y por editorial/proveedor
 *                Resultado de busqueda, texto de busqueda explicito
 * - eMPro: Seguimiento google. Reporte de visita, login y registro
 * - Mejoras: Ejb de articulo reducido en ranking, acoplamiento eliminado,
 *                 se reemplazaron los archivos de detalle de cada seccion por uno unico
 *
 * Revision 1.13  2005/06/28 16:37:43  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.12  2005/02/10 14:27:34  omsartori
 * - Habilitacion de referidos por xml
 * - Referidos: envio, reconocimiento y registro
 * - Cupones de referido y referente configurables por xml
 * - Cupon de registro configurable por xml
 *
 * Revision 1.11  2004/10/22 15:55:35  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.10  2004/08/03 15:48:44  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.9  2004/06/30 18:23:38  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.8  2004/06/15 20:57:33  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.7  2004/04/12 20:19:13  oGPistoia
 * - Cambios en la registracion
 * - Mejoras para las alianzas
 *
 * Revision 1.6  2004/03/25 18:19:50  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.5  2004/02/27 13:44:53  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.4  2003/11/19 18:55:47  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.3  2003/11/13 20:11:48  GPistoia
 * -Cambio de direccion para generacion de mail por temas de firewall
 * -Extensibilidad en detalles de articulos para agregar html del usuario
 * -Mejora en pantalla de estado de ordenes
 * -Sincronizacion de estadisticas
 *
 * Revision 1.2  2003/10/29 19:57:30  GPistoia
 * -Correccion de queries con *
 * -Envio de mail a callcenter
 * -Correccion en promocion, nuevo campo
 * -Numero de tarjeta completo en detalle de orden
 *
 * Revision 1.1  2003/10/28 01:40:23  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 */
package com.tmk.controllers.alianza;

import com.tmk.kernel.*;
import com.tmk.service.mensaje.MensajeService;
import com.tmk.setup.Contenido;
import com.tmk.controllers.compra.CompraHelper;
import com.tmk.controllers.referido.ReferidoManager;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.naming.NamingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.sql.*;
import java.net.URLDecoder;

public final class EstadisticaVisitas {

	public static final String ES_VISITA_NUEVA = "ES_VISITA_NUEVA";
	public static final String REFERER_GOOGLE ="refererGoogle";
	public static final String REFERER_YAHOO ="refererYahoo";
    public static final String PALABRAS_CLAVE = "palabrasClave";

	public static final String ID_ALIANZA_SITIO = "ID_ALIANZA";    // Campo publicado, no cambiar
	public static final String ID_SECCION_SITIO = "ID_SECCION";	   // Campo publicado, no cambiar

	public static final String COOKIE_ID_ALIANZA = "COOKIE_ID_ALIANZA";
	public static final String COOKIE_ID_SECCION = "COOKIE_ID_SECCION";

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:00:00");

	private static long cantidadDeVisitas;
	private static long cantidadDeVisitasGoogle;
	private static long cantidadDeVisitasYahoo;
	private static long cantidadDeHits;

	private static long visitasARegistrar;

	private static long accesoAIndice;
	private static long accesoABiografia;

    public static final int paginaSeleccionDePapel = 1; /* /compra/papelDeRegalo.jsp*/
    public static final int paginaSeleccionDeDomicilio = 2; /* /compra/domicilios.jsp?TIPO_DOMICILIO=EN*/
    public static final int paginaSeleccionDeMedioDeCobro = 3; /* /compra/medioDeCobro.jsp*/
    public static final int paginaConfirmacion = 4; /* /compra/confirmacion.jsp*/
    public static final int paginaDetalleDeOrden = 5; /* /compra/detalleDeOrden.jsp*/

	public static final void mantenerEstadistica(HttpServletRequest request, HttpServletResponse response) {

		/* Redireccion de dominio*/
		try {

			String dominioActual = request.getRequestURL().toString();
			String protocolo = dominioActual.substring(0, dominioActual.indexOf("//")+2);
			String path = (request.getRequestURI() != null)? request.getRequestURI(): "";
			String qryString = (request.getQueryString() !=null)? request.getQueryString(): "";
			dominioActual = dominioActual.replaceAll(protocolo, "").replaceAll(path, "").replaceAll(qryString, "");



			for (int i=0; i< Globals.DOMINIO_SECUNDARIO.length; i++) {
				if (Globals.DOMINIO_SECUNDARIO[i].equals(dominioActual)) {
					StringBuffer url = new StringBuffer();
					url.append(protocolo + Globals.DOMINIO_PRINCIPAL).append(path).append((qryString!=null && !qryString.equals(""))?"?":"").append(qryString);
			        response.setHeader("Referer", request.getHeader("Referer"));
					response.sendRedirect(url.toString());
					return;
				}
			}
		} catch (Exception e) {
            TmkLogger.debug("Estadistica] redireccion " + request.getRequestURL().toString() + " " + e.getMessage());

		}
		/* Redireccion de dominio*/

		// cantidad de hits
		cantidadDeHits++;

		// toma la session
		HttpSession httpSession = request.getSession();

		// Se guarda el cupon para proponerlo despues
		httpSession.setAttribute(CompraHelper.PARAMETRO_CUPON,
		                         Convert.toString(request.getParameter(CompraHelper.PARAMETRO_CUPON),
		                                          (String) httpSession.getAttribute(CompraHelper.PARAMETRO_CUPON)));

		//si el codigo es valido

		if (ReferidoManager.esCodigoReferido(Convert.toString(request.getParameter(ReferidoManager.SESSION_CODIGO_REFERIDO)))) {
		// guardo el codigo del referido
			httpSession.setAttribute(ReferidoManager.SESSION_CODIGO_REFERIDO,
									 Convert.toString(request.getParameter(ReferidoManager.SESSION_CODIGO_REFERIDO),
													  (String) httpSession.getAttribute(ReferidoManager.SESSION_CODIGO_REFERIDO)));

		}
		// nunca entro en el sitio
		if (Convert.toBoolean(httpSession.getAttribute(ES_VISITA_NUEVA), true) && (Globals.sitioDisponible())) {
			//Mensaje
			MensajeService.compileMensajeDeUsuario(request);
			// Mantiene seteado la configuracion del servlet
			Contenido.setServletContext(httpSession.getServletContext());

            Integer idAlianza = Convert.toNumber(request.getParameter(ID_ALIANZA_SITIO), (Integer)null);
			Integer idSeccion = Convert.toNumber(request.getParameter(ID_SECCION_SITIO), (Integer)null);
			Integer idAlianzaCookie = null;
			Integer idSeccionCookie = null;
            String referer = request.getHeader("Referer");

			if (idAlianza == null) {
				referer = request.getHeader("Referer");
                if (referer != null) {
	                try {
						Vector vec = getCanales();
		                for (int i = 0; i< vec.size(); i++) {
							Vector fila = (Vector)vec.get(i);
							if (referer.indexOf((String)fila.get(1), 0) > -1) {
								idAlianza = (Integer)fila.get(0);
								idSeccion = new Integer(1);
							}
						}
	                } catch (Exception e) {
						TmkLogger.error("SEGIUMIENTO EmPro] Error en obtencion de alianza " + e.toString());
					}
                }
			}

			if (idAlianza == null) {
				Cookie cookieAlianza = getCookie(COOKIE_ID_ALIANZA, request);
				if (cookieAlianza != null) {
					cookieAlianza.setMaxAge(60 * 60 * 24 * 30);
					idAlianzaCookie = Convert.toNumber(cookieAlianza.getValue(), (Integer)null);
					idSeccionCookie = new Integer(1);
					response.addCookie(cookieAlianza);

				}
			}

			if (idAlianza != null || idAlianzaCookie != null) {
				Cookie cookieAlianza = new Cookie(COOKIE_ID_ALIANZA, Convert.toString(idAlianza, Convert.toString(idAlianzaCookie, null)));
				cookieAlianza.setMaxAge(60 * 60 * 24 * 30);
				response.addCookie(cookieAlianza);
			}

				if (referer != null) {
					if (referer.indexOf("google") != -1) {
						httpSession.setAttribute(REFERER_GOOGLE, new Boolean (true));
						cantidadDeVisitasGoogle++;
						int idx = referer.indexOf("q=");
						if (idx != -1) {
							try {
							String palabrasClave = referer.substring(idx+2);
							palabrasClave = palabrasClave.substring(0, (palabrasClave.indexOf("&")!=-1)? palabrasClave.indexOf("&"): palabrasClave.length());

							httpSession.setAttribute(PALABRAS_CLAVE, URLDecoder.decode(palabrasClave, "UTF-8"));
							} catch (Exception e) {
								TmkLogger.error("Estadistica] No se pudo guardar la palabra clave " + e.getMessage());
							}

						}
					} else {
						httpSession.setAttribute(REFERER_GOOGLE, new Boolean (false));
					}

					if (referer.indexOf("yahoo") != -1) {
						httpSession.setAttribute(REFERER_YAHOO, new Boolean (true));
						cantidadDeVisitasYahoo++;
						int idx = referer.indexOf("p=");
						if (idx != -1) {
							try {
							String palabrasClave = referer.substring(idx+2);
							palabrasClave = palabrasClave.substring(0, (palabrasClave.indexOf("&")!=-1)? palabrasClave.indexOf("&"): palabrasClave.length());

							httpSession.setAttribute(PALABRAS_CLAVE, URLDecoder.decode(palabrasClave, "UTF-8"));
							} catch (Exception e) {
								TmkLogger.error("Estadistica] No se pudo guardar la palabra clave " + e.getMessage());
							}
						}
					} else {
						httpSession.setAttribute(REFERER_YAHOO, new Boolean (false));
					}

				} else {
					httpSession.setAttribute(REFERER_GOOGLE, new Boolean (false));
					httpSession.setAttribute(REFERER_YAHOO, new Boolean (false));
				}
            // para seguimiento de canales

			// guarda que entro ya en el sitio antes
			httpSession.setAttribute(ES_VISITA_NUEVA, new Boolean(false));

			// cantidad de visitas
			cantidadDeVisitas++;
			TmkLogger.debug("Visitas: " + getCantidadDeVisitas() + ", Hits: " + getCantidadDeHits());

			httpSession.setAttribute(ID_ALIANZA_SITIO, idAlianza);
			httpSession.setAttribute(COOKIE_ID_ALIANZA, idAlianzaCookie);


			try {
				// registrar las visitas
				if (idAlianza == null && idAlianzaCookie == null) {
					// Programa para registrar la visita (descongestiona el acceso a la base)
					incrementarContador();
				} else {
					// Registra la visita inmediatamente por si falla al encontrar alianza-seccion
					if (idAlianza != null) {
						httpSession.setAttribute(ID_SECCION_SITIO, (idSeccion == null)? new Integer(1):idSeccion);
						grabarVisita(idAlianza, idSeccion, 1);
					} else {
						if (idAlianzaCookie != null) {
							grabarVisita(idAlianzaCookie, idSeccionCookie, 1);
							httpSession.setAttribute(COOKIE_ID_SECCION, (idSeccionCookie == null)? new Integer(1):idSeccionCookie);
						}
					}
				}


				// Setea la alianza



				TmkLogger.debug("Alianza: " + idAlianza + "-" + idSeccion + " cookie: " + idAlianzaCookie + "-" + idSeccionCookie);


			} catch (Exception e) {
				// log
				StringBuffer texto = new StringBuffer();
				texto.append(" No se pudo grabar en la tabla de visitas para Alianza: ").append(idAlianza).append(", Seccion ").append(idSeccion).append(".");
				texto.append(" Comunicarse con ");
				texto.append(Convert.toString(request.getHeader("Referer"), "la alianza"));
				texto.append(" para solucionar el link incorrecto.");
				TmkLogger.error(texto);
				MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_ALIANZAS,
				                  Globals.NOMBRE_DEL_SITIO + " - Alianzas", texto.toString());
			}
		}


	}



	public static final void flush() throws Exception {
		synchronized (DATE_FORMAT) {
			grabarVisita(null, null, visitasARegistrar);
			visitasARegistrar = 0;
		}
	}

	private static final void grabarVisita(Integer idAlianza, Integer idSeccion, long cantidadARegistrar) throws Exception {

		if (cantidadARegistrar <= 0) return;

		synchronized (DATE_FORMAT) {
			Connection conn = DBUtil.buildConnection();
			try {
				// genera la fecha como corresponde
				String date = DATE_FORMAT.format(new Date());

				Statement st = conn.createStatement();
				try {
					String igualAlianza = (idAlianza == null) ? "id_alianza IS NULL" : "id_alianza = " + idAlianza;
					String igualSeccion = (idSeccion == null) ? "id_seccion IS NULL" : "id_seccion = " + idSeccion;

					ResultSet rs = st.executeQuery(
							"SELECT id_alianza, id_seccion FROM visita_x_alianza_seccion" +
							"   WHERE " + igualAlianza +
							"       AND " + igualSeccion +
							"       AND fecha_visita = TO_DATE('" + date + "', 'DD/MM/RRRR HH24:MI:SS')");
					try {
						if (rs.next()) {
							st.executeUpdate(
									"UPDATE visita_x_alianza_seccion " +
									"   SET cant_visitas = cant_visitas + " + cantidadARegistrar +
									"   WHERE " + igualAlianza +
									"       AND " + igualSeccion +
									"       AND fecha_visita = TO_DATE('" + date + "', 'DD/MM/RRRR HH24:MI:SS')");
						} else {
							st.executeUpdate(
									"INSERT INTO visita_x_alianza_seccion (FECHA_VISITA, ID_ALIANZA, ID_SECCION, CANT_VISITAS) " +
									"   VALUES (TO_DATE('" + date + "', 'DD/MM/RRRR HH24:MI:SS'), " +
									idAlianza + ", " + idSeccion + ", " + cantidadARegistrar + ")");
						}

					} finally {
						rs.close();
					}

				} finally {
					st.close();
				}

			} finally {
				conn.close();
			}
		}
	}

	public static final long getCantidadDeVisitas() {
		return cantidadDeVisitas;
	}

	// va a tener que cambiar si se quiere hacer multicanal
	public static final long getCantidadDeVisitasGoogle(){
		return cantidadDeVisitasGoogle;
	}

	// Esto va por no ser multicanal
	public static final long getCantidadDeVisitasYahoo(){
		return cantidadDeVisitasYahoo;
	}

	public static final long getCantidadDeHits() {
		return cantidadDeHits;
	}

	private static final void incrementarContador() {
		synchronized (DATE_FORMAT) {
			visitasARegistrar++;
		}
	}


	//seguimiento empro
	private static Vector getCanales() throws SQLException, NamingException {
		Connection connection = DBUtil.buildConnection();
		Vector temp = new Vector();
		String qry;

		qry = "select id_alianza, palabra_clave " +
		      " from alianza where palabra_clave is not null";

		//System.out.println(qry);

		try {
			PreparedStatement statement = connection.prepareStatement(qry);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector(2);

						String palabras[] = resultSet.getString("palabra_clave").split("#");
						for (int i = 0; i<palabras.length; i++) {
							fila.add(new Integer(resultSet.getInt("id_alianza")));
							fila.add(palabras[i]);
						}
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}
    //seguimiento empro


    //seguimiento empro
	public static void setVisitaDetalle(Integer idArticulo, Integer idAlianza, Integer idSeccion, Integer idSocio, Integer idSucursal) throws SQLException, NamingException {
		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into visitas_articulos_detalle (id_articulo, id_alianza, id_seccion, id_socio, id_sucursal) " +
			  " values (?,?,?,?,?)");
			try {
				statement.setInt(1, idArticulo.intValue());
				if (idAlianza == null || idSeccion == null) {
					statement.setNull(2, Types.INTEGER);
					statement.setNull(3, Types.INTEGER);
				} else {
					statement.setInt(2, idAlianza.intValue());
					statement.setInt(3, idSeccion.intValue());
				}

				if (idSocio == null || idSucursal == null) {
					statement.setNull(4, Types.INTEGER);
					statement.setNull(5, Types.INTEGER);
				} else {
					statement.setInt(4, idSocio.intValue());
					statement.setInt(5, idSucursal.intValue());
				}

				statement.execute();
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}
	//seguimiento empro

    //seguimiento empro

	public static Cookie getCookie(String name, HttpServletRequest request) {
		if (request.getCookies() != null) {
			for (int i=0; i<request.getCookies().length; i++) {
				if (request.getCookies()[i].getName().equals(name)) {
					return request.getCookies()[i];
				}
			}
		}
		return null;
	}
    //seguimiento empro


	//seguimiento empro

	public static void grabarLogProcesoTransaccion(HttpServletRequest request, int pagina) throws Exception {
		Connection connection = DBUtil.buildConnection();
		String qry;

		qry = "INSERT INTO log_proceso_transaccion " +
		      " (id_session, fecha_creacion, id_pagina, fecha_visualizacion) VALUES " +
		      " (?, ?, ?, ?)";
		try {
			Date ahora = new Date();
			PreparedStatement statement = connection.prepareStatement(qry);
			statement.setString(1, request.getSession().getId());
			statement.setTimestamp(2, new java.sql.Timestamp(request.getSession().getCreationTime()));
			statement.setInt(3, pagina);
			statement.setTimestamp(4, new java.sql.Timestamp(ahora.getTime()));
			try {
				statement.execute();
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}
	//seguimiento empro

	//mas estadisticas
	public static void incrementarAccesoAIndices() {
		accesoAIndice++;
	}

	public static void incrementarAccesoABiografia() {
		accesoABiografia++;
	}

	public static long getAccesoAIndice() {
		return accesoAIndice;
	}

	public static long getAccesoABiografia() {
		return accesoABiografia;
	}


	//para guardar las visitas cada 2 minutos
	static {
		new Daemon(Daemon.UN_MINUTO, Daemon.DOS_MINUTOS) {
			protected void ejecutarTarea() throws Exception {
				flush();
			}

			protected String getMensaje() {
				return null;
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento();
			}
		};
	}







}
