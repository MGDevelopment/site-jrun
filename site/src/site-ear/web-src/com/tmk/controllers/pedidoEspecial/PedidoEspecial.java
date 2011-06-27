/**
 * $Log: PedidoEspecial.java,v $
 * Revision 1.24  2009/03/26 20:29:51  oClopez
 * buscador avanzado
 *
 * Revision 1.23  2008/08/06 14:16:01  msartori
 * Cambio manual de uso extranet
 * Comentarios visibles en articulo con ajax
 * Carga de comentarios fuera de https
 * Correcciones en generadores de feed de wishlist y comentarios
 * Metodos getALL y getALL con params en DBO
 *
 * Revision 1.22  2007/09/03 13:42:20  msartori
 * no message
 *
 * Revision 1.21  2005/09/22 18:38:51  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.20  2005/01/07 17:46:59  oGFritz
 * - Corrección del buscador por un error de js
 * - Reporte de compras por alianzas agregado
 * - Agregado de combo para opinionar sobre el pedido especial
 * -
 *
 * Revision 1.19  2004/05/04 18:11:08  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.18  2004/03/04 18:52:56  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.17  2003/12/04 17:21:29  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.16  2003/11/26 15:38:15  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.15  2003/10/23 19:05:58  GPistoia
 * -Correccion de Mas vendidos
 * -Site.xml generado en español
 * -Agregado de direccion de mail para estadisticas
 *
 * Revision 1.14  2003/10/21 21:54:33  SLizardo
 * Cierre Incidentes
 *
 * Revision 1.13  2003/10/14 08:53:31  GPistoia
 * -Mail configurable en pedido especial
 *
 * Revision 1.12  2003/10/13 21:43:41  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.11  2003/10/07 14:56:27  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.10  2003/10/06 14:05:40  SLizardo
 * Update Socios
 *
 * Revision 1.9  2003/10/03 16:30:28  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.8  2003/09/29 17:21:04  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.7  2003/09/26 15:24:47  SLizardo
 * String => StringBuffer
 *
 * Revision 1.6  2003/09/04 21:40:03  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.5  2003/09/01 13:54:59  GPistoia
 * -Impuestos, biografia, critica, y otros metodos para detalle.
 * -Promocion Historica
 * -Probabilidad es la misma tabla disponibilidad
 *
 * Revision 1.4  2003/08/25 20:46:34  SLizardo
 * Optimize Imports
 *
 * Revision 1.3  2003/08/22 14:04:03  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.2  2003/08/21 21:16:57  SLizardo
 * no message
 *
 * Revision 1.1  2003/08/19 19:27:29  GPistoia
 * -Pedido especial terminado
 * -Logo configurable
 * -Configuracion del sitio
 *
 * Revision 1.1  2003/08/15 16:00:16  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 */
package com.tmk.controllers.pedidoEspecial;

//import com.tmk.articulo.ArticuloLocal;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.socio.Socios2;
import com.tmk.common.PedidoEspecialLocalHome;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.*;
//import com.tmk.setup.Contenido;
//import com.tmk.socio.SocioLocal;
//import com.tmk.socio.SocioLocalHome;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
//import com.tmk.kernel.CryptUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.net.URLEncoder;

public class PedidoEspecial extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// articulo elegido
			Integer idArticulo = Convert.toNumber(request.getParameter(PedidoEspecialHelper.CAMPO_ARTICULO), (Integer) null);
			if (idArticulo == null) {
				response.sendRedirect("/index.jsp");
				return;
			}

			// Obtiene el articulo
			//ArticuloLocal articuloLocal = Contenido.getArticulo(idArticulo.intValue());
			Articulo articuloLocal = ServiceLocator.getArticuloService().getArticuloParaChequearDisponibilidad(idArticulo);

			// Si no esta logueado lo envia a esa pagina
			SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
			if (socioPK == null) {
				request.getSession().setAttribute("URL_REDIRECT", PedidoEspecialHelper.SERVLET_ + idArticulo );
				response.sendRedirect("/miCuenta");
				return;
			} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, PedidoEspecialHelper.SERVLET_ + idArticulo);
				//request.getSession().setAttribute(MainHelper.REFERER, REFERER);
				response.sendRedirect(MainHelper.PAGE_REGISTRO_SOCIO_CADENA);
				return;
			}

			// Socio actual
			//SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");
			//SocioLocal socioLocal = socioLocalHome.findByPrimaryKey(socioPK);
			Socios2 socioLocal = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);

			// campos cargados
			String telefono = request.getParameter(PedidoEspecialHelper.CAMPO_TELEFONO);
			String horario = request.getParameter(PedidoEspecialHelper.CAMPO_HORARIO);
			String comentario = request.getParameter(PedidoEspecialHelper.CAMPO_COMENTARIO);
			Integer id_consulta = Convert.toNumber(request.getParameter(PedidoEspecialHelper.CAMPO_ID_CONSULTA), new Integer(0));
			Integer id_opinion =  Convert.toNumber(request.getParameter(PedidoEspecialHelper.CAMPO_ID_OPINION), new Integer(0));

			// Si no tiene los datos minimos, los pide
			if ((telefono == null) || ("".equals(telefono.trim())) || (horario == null) || ("".equals(horario.trim()))) {
				request.getSession().setAttribute("URL_REDIRECT", PedidoEspecialHelper.SERVLET_ + idArticulo);
				response.sendRedirect(PedidoEspecialHelper.PAGINA_DATOS_ + idArticulo);
				return;
			}

			// NO USAR ACENTOS EN EL HEADER
			String subject = "Pedido Especial";

			// COMPONE EL CUERPO DEL MAIL
			String emailBody = generarBody(articuloLocal, socioLocal, telefono, horario, comentario);

			// Link con el mail
			String pagina =
			        "/mailing/pedidoEspecial.jsp?" +
			        PedidoEspecialHelper.CAMPO_SUCURSAL + "=" + socioPK.ID_SUCURSAL + "&" +
			        PedidoEspecialHelper.CAMPO_SOCIO + "=" + socioPK.ID_SOCIO + "&" +
			        PedidoEspecialHelper.CAMPO_ARTICULO + "=" + idArticulo + "&" +
			        PedidoEspecialHelper.CAMPO_TELEFONO + "=" + URLEncoder.encode(telefono, "UTF8") + "&" +
			        PedidoEspecialHelper.CAMPO_HORARIO + "=" + URLEncoder.encode(horario, "UTF8") + "&" +
			        PedidoEspecialHelper.CAMPO_COMENTARIO + "=" + URLEncoder.encode(comentario, "UTF8");

			// PRIMERO LO MANDA AL CALL CENTER PARA ASEGURAR QUE LA RUTINA DE MAIL ANDA
			MailUtil.sendMail(
			        //socioLocal.getEMAIL(),
					socioLocal.getlogin(),
			        Globals.MAIL_CALL_CENTER,
			        subject + " (codigo: " + idArticulo + ")",
			        emailBody,
			        pagina);

			// AHORA LO MANDA AL USUARIO FINAL
			MailUtil.sendMail(
			        Globals.MAIL_CALL_CENTER,
			        //socioLocal.getEMAIL(),
			        socioLocal.getlogin(),
			        subject,
			        emailBody,
			        pagina);

			response.sendRedirect(PedidoEspecialHelper.PAGINA_CONFIRMACION);

			// graba el pedido especial en la tabla
			PedidoEspecialLocalHome pedidoEspecialLocalHome = (PedidoEspecialLocalHome) DBUtil.getHome("PedidoEspecial");
			pedidoEspecialLocalHome.create(
			        //socioLocal.getID_SUCURSAL(),
					socioLocal.getId_sucursal(),
			        //socioLocal.getID_SOCIO(),
					socioLocal.getId_socio(),
			        //articuloLocal.getID_ARTICULO(),
					articuloLocal.getId_articulo(),
			        new Date(),
			        telefono,
			        horario,
			        comentario,
			        //articuloLocal.getID_DISPONIBILIDAD(),
			        articuloLocal.getDisponibilidad().getIdDisponibilidad(),
			        DBUtil.getSequenceValue("PEDIDO_ESPECIAL_SEQ"),
			        id_consulta,
			        id_opinion);

		//} catch (Exception e) {
		}catch (Exception e) {
			// Si no lo pudo grabar no importa porque se supone que esta el mail
			TmkLogger.error("Hubo problemas para reportar el pedido del artículo.");
			response.sendRedirect("/errorPage/errorPage.jsp");
			return;
		}
	}

	//private String generarBody(ArticuloLocal articuloLocal, SocioLocal socioLocal, String telefono, String horario, String comentario) {
	private String generarBody(Articulo  articuloLocal, Socios2  socioLocal, String telefono, String horario, String comentario) {

		StringBuffer result = new StringBuffer();
		result.append("Registración del pedido a nombre de ");
		//result.append(Convert.etiqueta(socioLocal.getSEXO()));
		result.append(Convert.etiqueta(socioLocal.getSexo()));
		//result.append(Convert.nombreCompleto(socioLocal.getNOMBRES(), socioLocal.getAPELLIDOS())).append(Globals.ENTER);
		result.append(Convert.nombreCompleto(socioLocal.getNombres(), socioLocal.getApellidos())).append(Globals.ENTER);
		result.append(Globals.ENTER);

		result.append("Datos de Contacto").append(Globals.ENTER);
		result.append("---------------- ").append(Globals.ENTER);
		result.append(" Teléfono: ").append(telefono).append(Globals.ENTER);
		result.append(" Horario: ").append(horario).append(Globals.ENTER);
		result.append(" Comentario: ").append(comentario).append(Globals.ENTER);
		result.append(Globals.ENTER);

		result.append("Datos del Producto ").append(Globals.ENTER);
		result.append("------------------ ").append(Globals.ENTER);
		result.append(" Título: ").append(Convert.corregir(articuloLocal.getTitulo(), true)).append(Globals.ENTER);
		result.append(" Disponibilidad/Probabilidad: ").append(articuloLocal.getDisponibilidad().getDescripcion()).append(Globals.ENTER);
		if (articuloLocal.getCategoria_seccion().intValue() == Globals.SECCION_LIBRO) {
			result.append(" ISBN: ").append(articuloLocal.getISBN()).append(Globals.ENTER);
		} else {
			result.append(" Código: ").append(articuloLocal.getISBN()).append(Globals.ENTER);
		}
		result.append(Globals.ENTER);

		result.append(Globals.ENTER);
		result.append("Su pedido será atendido a la brevedad.").append(Globals.ENTER);
		result.append("Muchas Gracias.").append(Globals.ENTER);

		return result.toString();

	}
}
