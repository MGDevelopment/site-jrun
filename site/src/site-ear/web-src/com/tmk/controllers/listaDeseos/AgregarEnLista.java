/**
 * @author Lizardo Santiago
 *
 * $Log: AgregarEnLista.java,v $
 * Revision 1.16  2009/03/25 15:11:25  oClopez
 * mi cuenta testeado.
 *
 * Revision 1.15  2009/03/20 19:02:47  oClopez
 * cambio viernes
 *
 * Revision 1.14  2008/04/09 20:20:20  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.13  2005/09/22 18:38:50  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.12  2004/11/18 17:04:59  omsartori
 * - Componentes genéricos, en inicio, lista de deseos y resultado de busqueda.
 *
 * Revision 1.11  2004/07/08 20:19:04  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.10  2003/12/04 17:21:28  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.9  2003/10/13 04:08:50  SLizardo
 * no message
 *
 */
package com.tmk.controllers.listaDeseos;

//import com.tmk.bus.articulo.ListaDeseos;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.ShortCuts;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public final class AgregarEnLista extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();

		Integer ID_ARTICULO = Convert.toNumber(request.getParameter("ID_ARTICULO"), (Integer)null);

		String REFERER = Convert.toString(session.getAttribute(MainHelper.REFERER),Convert.toString(request.getHeader("REFERER"), "/index.jsp"));
		session.removeAttribute(MainHelper.REFERER);

        if (ID_ARTICULO == null) {
        	response.sendRedirect(REFERER);
	        return;
        }

		SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

		if(socioPK == null)	{
			session.setAttribute(MainHelper.URL_REDIRECT, "/AgregarEnLista?ID_ARTICULO="+ID_ARTICULO );
			session.setAttribute(MainHelper.REFERER, REFERER);
			response.sendRedirect("/miCuenta/index.jsp");
			return;
		} else {
			if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
				session.setAttribute(MainHelper.URL_REDIRECT, "/AgregarEnLista?ID_ARTICULO="+ID_ARTICULO );
				session.setAttribute(MainHelper.REFERER, REFERER);
				response.sendRedirect(MainHelper.PAGE_REGISTRO_SOCIO_CADENA);
				return;
			} else {
				ShortCuts.findListaBySocio(socioPK);
					
				Integer ID_SUCURSAL_SOCIO_COMPRADOR = null;
				Integer ID_SOCIO_COMPRADOR = null;
				Integer ESTADO = new Integer(0);

				TmkLogger.debug("Agregando Producto ("+ID_ARTICULO+") a la LDD del Socio ("+socioPK.ID_SUCURSAL+"::"+socioPK.ID_SOCIO+")");
				try{
					ServiceLocator.getCarritoListaDeseosService().create(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO, ID_ARTICULO, ID_SUCURSAL_SOCIO_COMPRADOR, ID_SOCIO_COMPRADOR, ESTADO);
				} catch (DuplicateException ne){
					TmkLogger.debug("El artículo: "+ID_ARTICULO+ " ya está en la lista socio:" + socioPK.ID_SOCIO + " sucursal:" + socioPK.ID_SUCURSAL);
				}
				catch (Exception ce){
					TmkLogger.debug("Error interno");
				}
			}
		}

		response.sendRedirect(REFERER);
		return;
	}
}

