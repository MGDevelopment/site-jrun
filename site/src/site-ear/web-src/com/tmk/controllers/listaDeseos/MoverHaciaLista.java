/**
 * @author Lizardo Santiago
 *
 * $Log: MoverHaciaLista.java,v $
 * Revision 1.20  2009/03/20 19:02:47  oClopez
 * cambio viernes
 *
 * Revision 1.19  2009/03/04 12:55:05  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.18  2008/05/30 16:06:03  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.17  2007/10/18 20:07:01  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.16  2006/09/14 18:25:02  omsartori
 * Promociones II
 *
 * Revision 1.15  2004/07/08 20:19:05  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.14  2003/12/04 17:21:29  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.13  2003/10/28 01:40:25  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 * Revision 1.12  2003/10/03 21:50:25  SLizardo
 * EJB de ListaDeDeseos actualizado.
 *
 */
package com.tmk.controllers.listaDeseos;

//import com.tmk.bus.articulo.CarritoListaDeseos;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;
import com.tmk.orden.OrdenDAO;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public final class MoverHaciaLista extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		//compravacion para evitar que intenten agrear algo  la lista de deseos sin ser socioTMK
		Integer ID_ARTICULO = Convert.toNumber(request.getParameter("ID_ARTICULO"), (Integer)null);

		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");

		int posicionEnLista = Convert.toNumber(request.getParameter("posicionEnLista"), 0);

		if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {		
			request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/compra/carrito.jsp");
			response.sendRedirect(MainHelper.PAGE_REGISTRO_SOCIO_CADENA );
			TmkLogger.info("REFERIDOS] No hay socio referente. ES SOCIO TMK Redireccion a registroSocioCadena");
			return;
		}
		if(socioPK == null) {
			session.setAttribute("URL_REDIRECT", "/MoverHaciaLista?ID_ARTICULO="+ID_ARTICULO);
			if(request.getSession().getAttribute("_DISPACHER") == null)
				response.sendRedirect("/miCuenta/index.jsp");
			else
				response.sendRedirect("/rediseo/miCuenta/");
			return;
		}

		try
		{
			Integer ID_SUCURSAL_SOCIO_COMPRADOR = null;
			Integer ID_SOCIO_COMPRADOR = null;
			Integer ESTADO = new Integer(0);

			TmkLogger.debug("Agregando Producto ("+ID_ARTICULO+") a la LDD del Socio ("+socioPK.ID_SUCURSAL+"::"+socioPK.ID_SOCIO+")");

			try
			{
				TmkLogger.debug("Agregando Producto ("+ID_ARTICULO+") a la LDD del Socio ("+socioPK.ID_SUCURSAL+"::"+socioPK.ID_SOCIO+")");

				ServiceLocator.getCarritoListaDeseosService().create(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO, ID_ARTICULO, ID_SUCURSAL_SOCIO_COMPRADOR, ID_SOCIO_COMPRADOR, ESTADO);
				OrdenDAO ordenDAO = (OrdenDAO)session.getAttribute("ordenDAO");
				ordenDAO.removeArticuloByPos(posicionEnLista);				
			}
			catch (DuplicateException ce){
				TmkLogger.error(ce.toString() + ce.getMessage());
			}
		}catch (Exception ne){
			TmkLogger.error(ne.toString() +  ne.getMessage());
		}

		if(request.getSession().getAttribute("_DISPACHER") == null){
			String REFERER = request.getHeader("REFERER");
			response.sendRedirect(REFERER);
		}else{
			response.sendRedirect("/compra/?seccionCompra=confirmacion");
		}
	}
}
