/**
 * $Log: Comentario.java,v $
 * Revision 1.12  2009/03/25 15:11:25  oClopez
 * mi cuenta testeado.
 *
 * Revision 1.11  2009/03/23 12:33:12  oClopez
 * no message
 *
 * Revision 1.10  2009/03/20 19:02:46  oClopez
 * cambio viernes
 *
 * Revision 1.9  2008/05/30 16:05:50  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.8  2008/04/09 20:20:17  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.7  2007/01/22 17:43:20  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.6  2004/11/18 17:04:55  omsartori
 * - Componentes genéricos, en inicio, lista de deseos y resultado de busqueda.
 *
 * Revision 1.5  2004/11/03 13:08:08  omsartori
 * - archivos iniciales para Dromo
 * - Eliminación de footer.jsp de los jsp de compra
 *
 * Revision 1.4  2004/09/24 20:19:43  omsartori
 * - Capitalización de titulo en reporte de comentarios
 * - Mailto en reporte de comentarios
 * - Edición de comentarios por parte del socio autor
 * - Nickname para firmar comentarios
 *
 * Revision 1.2  2004/09/07 16:15:36  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.1  2004/08/09 13:41:49  omsartori
 * - Comentario para articulos desde la web
 * - Aprobación de comentarios desde la intranet
 * - Ancla para extensiones en detalle de articulo
 *
 */

package com.tmk.controllers.comentario;

import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ComentarioService;
import com.tmk.src.socio.SocioPK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.common.ComentarioClass;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.intranet.usuario.PublicacionHelper;

public class Comentario extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//idSeccion necesario para evitar el bug de que explota si no esta
			int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0);
			
			// articulo elegido
			int idArticulo = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ARTICULO.toUpperCase()), 0);
			if(idArticulo == 0 )
				idArticulo = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ARTICULO), 0);
			if (idArticulo == 0) {
				response.sendRedirect("/index.jsp");
				return;
			}

			// Obtiene el articulo
			//ArticuloLocal articuloLocal = Contenido.getArticulo(idArticulo.intValue());

			// Id de comentario solo si es una edición
			int idComentario = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ID_COMENTARIO.toUpperCase()), 0);

			// id de Socio del Comentario solo si es una edición
			int idSocio = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_SOCIO), 0);

			// id de Sucrsal del socio del Comentario solo si es una edición
			int idSucursal = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_SUCURSAL.toUpperCase()), 0);

			boolean esCarga = (idComentario == 0 && idSocio == 0 && idSucursal == 0);
			boolean esEdicion = (idComentario != 0 && idSocio != 0 && idSucursal != 0);

			// los parametros no están completos
			if (esCarga == esEdicion) {
				response.sendRedirect("/index.jsp");
				return;
			}

			StringBuffer parametrosUrl = new StringBuffer("");
			parametrosUrl.append("&idSeccion="+idSeccion);
			if (esEdicion) {
				parametrosUrl.append("&");
				parametrosUrl.append(ComentarioHelper.CAMPO_ID_COMENTARIO.toUpperCase());
				parametrosUrl.append("=");
				parametrosUrl.append(idComentario);
				parametrosUrl.append("&");
				parametrosUrl.append(ComentarioHelper.CAMPO_SOCIO);
				parametrosUrl.append("=");
				parametrosUrl.append(idSocio);
				parametrosUrl.append("&");
				parametrosUrl.append(ComentarioHelper.CAMPO_SUCURSAL.toUpperCase());
				parametrosUrl.append("=");
				parametrosUrl.append(idSucursal);
			}


			// Si no esta logueado lo envia a esa pagina
			SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
			if (socioPK == null) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, ComentarioHelper.SERVLET_ + idArticulo + parametrosUrl.toString());
				response.sendRedirect("/miCuenta");
				return;
			} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, ComentarioHelper.SERVLET_ + idArticulo + parametrosUrl.toString());
				response.sendRedirect(MainHelper.PAGE_REGISTRO_SOCIO_CADENA);
				//TmkLogger.debug("es socio TMK");
				return;
			}

			if (esEdicion) {
				/*SocioPK socioPKcom = new SocioPK(idSucursal, idSocio);
				if (!socioPKcom.equals(socioPK)) {
					response.sendRedirect(ComentarioHelper.PAGINA_ANTERIOR + idArticulo);
					TmkLogger.info("Comentarios: el socio del comentario es distinto del logueado.");
					return;
				}*/
			}

			// Socio actual
			/*SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");
			SocioLocal socioLocal = socioLocalHome.findByPrimaryKey(socioPK);*/

			// campos cargados
			String textoComentario = request.getParameter(ComentarioHelper.CAMPO_COMENTARIO);
			int evaluacion = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_EVALUACION), 0);
			String nickName = (Convert.toBoolean(request.getParameter(ComentarioHelper.CAMPO_USO_NICKNAME), false)) ? request.getParameter(ComentarioHelper.CAMPO_NICKNAME) : null;

			// Si no tiene los datos minimos, los pide
			if ((textoComentario == null) || ("".equals(textoComentario.trim()))
			        || (evaluacion == 0)) {
				request.getSession().setAttribute("URL_REDIRECT", ComentarioHelper.SERVLET_ + idArticulo );
				response.sendRedirect(ComentarioHelper.PAGINA_DATOS_ + idArticulo + parametrosUrl);
				return;
			}

			String estado = "N"; //Nueva, siempre comienza en este estado
			//ComentarioLocalHome comentarioLocalHome = (ComentarioLocalHome) DBUtil.getHome("Comentario");

			if (esEdicion) {
				/*ComentarioPK comPK = new ComentarioPK(idArticulo, idComentario);
				ComentarioLocal comentario = comentarioLocalHome.findByPrimaryKey(comPK);
				comentario.setCOMENTARIO(textoComentario);
				comentario.setEVALUACION(Convert.toNumber(evaluacion, new Integer(1)));
				comentario.setNICKNAME(nickName);
				comentario.setESTADO(estado);
				comentario.setFECHA(new Timestamp(new Date().getTime()));
				TmkLogger.error("COMENTARIOS] El comentario se edito exitosamente");
*/
			} else {
				// graba el Comentario en la tabla
				ComentarioClass comentario = new ComentarioClass(idArticulo, DBUtil.getSequenceValue("COMENTARIO_ARTICULOS_SEQ").intValue(),
						textoComentario, evaluacion, new Timestamp(new Date().getTime()), estado, socioPK.ID_SUCURSAL.intValue(),
						socioPK.ID_SOCIO.intValue(), nickName, "");
				if (!comentario.agregar()) {
					throw new Exception("Error al grabar el comentario ");
				}
				//Bloque para postear directamente en twitter
				ComentarioService servicio = ServiceLocator.getComentarioService();
				ComentarioArticulos comentarioDBO = servicio.getComentarioByPK(comentario.getIdComentario(),comentario.getIdArticulo());
				try {
					PublicacionHelper.publicarComentarioEnTwitter(comentarioDBO);
				}catch(Exception e) {
					StringBuffer sb = new StringBuffer("No se pudo postear en Twitter");
					sb.append(" id_comentario = ").append(comentarioDBO.getId_comentario());
					sb.append(" id_articulo = ").append(comentarioDBO.getId_articulo());
					sb.append(" id_socio = ").append(comentarioDBO.getSocio().getId_socio());
					sb.append(" id_sucursal = ").append(comentarioDBO.getSocio().getId_sucursal());
					TmkLogger.error(sb.toString());
				}
				//fin bloque
				
				/*
				comentarioLocalHome.create(
				        articuloLocal.getID_ARTICULO(),
				        DBUtil.getSequenceValue("COMENTARIO_ARTICULOS_SEQ"),
				        textoComentario,
				        Convert.toNumber(evaluacion, new Integer(1)),
				        new Timestamp(new Date().getTime()),
				        Estado,
				        socioLocal.getID_SUCURSAL(),
				        socioLocal.getID_SOCIO(),
				        nickName

				);*/
				TmkLogger.debug("COMENTARIOS] El comentario se grabo exitosamente");
			}
			request.getSession().setAttribute("URL_REDIRECT",ComentarioHelper.PAGINA_ANTERIOR + idArticulo);
			response.sendRedirect(ComentarioHelper.PAGINA_CONFIRMACION + "?idArticulo=" + idArticulo);

		} catch (Exception e) {
			TmkLogger.error("COMENTARIOS] No se pudo grabar el comentario.");
			response.sendRedirect("/errorPage/errorPage.jsp");
			return;
		}
	}
}