/**
 * @author Lizardo Santiago
 *
 * $Log: ActualizarProductos.java,v $
 * Revision 1.20  2009/04/15 16:06:58  oClopez
 * version estable de desarrollo
 *
 * Revision 1.19  2009/04/08 15:48:00  oClopez
 * modificaciones sobre feed back
 *
 * Revision 1.18  2009/03/20 19:02:46  oClopez
 * cambio viernes
 *
 * Revision 1.17  2009/03/04 12:55:04  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.16  2008/05/30 16:05:45  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.15  2007/09/03 13:42:13  msartori
 * no message
 *
 * Revision 1.14  2006/12/18 20:06:17  oLSuarez
 * Rediseño de las paginas del proceso de compras
 *
 * Revision 1.13  2006/10/09 13:05:52  omsartori
 * -Google Analitics SSL
 * -Docs EMPro 14,16
 * -Correccion bug de nota de regalo
 * -Reordenamiento de articulos luego de promo
 * -Mejora en seleccion de gasto de envio
 *
 * Revision 1.12  2006/09/14 18:25:00  omsartori
 * Promociones II
 *
 * Revision 1.11  2005/11/24 15:28:12  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.10  2005/11/22 20:49:58  oDZurita
 * - se implemento en el detalle del articulo la busqueda por id de autor en los recomendados y en ver mas productos del autor.
 * - se implemento en las biografias la busqueda por id de autor
 * - correccion del nombre de la editorial del link al sitio
 * - correccion en el tamaño de las imagenes mostradas en la primer lista de las homes.
 *
 * Revision 1.9  2005/11/04 12:55:41  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 * Revision 1.7  2003/12/11 20:53:29  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.6  2003/10/21 22:05:41  GPistoia
 * -Arreglo de Formato
 * -Arreglo de recomendar solo disponibles
 * -Arreglo de recorrido por temas de solo disponibles.
 * -Arreglo solo 5 autores recomendados.
 *
 * Revision 1.5  2003/10/03 16:30:16  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.4  2003/09/19 19:49:08  GPistoia
 * -Gasto de envio local y exterior cerrado
 * -Soporte de back despues de confirma compra.
 *
 * Revision 1.3  2003/09/11 18:09:46  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.2  2003/09/08 13:54:43  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.1  2003/09/02 14:02:53  SLizardo
 * Actualizar Productos
 *
 */
package com.tmk.controllers.carrito;

import com.tmk.controllers.compra.CompraHelper;
//import com.tmk.controllers.CommonHelper;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Convert;
//import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
import com.tmk.src.socio.SocioPK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ActualizarProductos extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();

			SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");
			OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");

			// por si se confirmo la compra y hace back
			if (ordenDAO == null) response.sendRedirect(CompraHelper.PAGINA_HOME_SITIO);

			String[] ID_ARTICULOS = request.getParameterValues("ID_ARTICULO");
         	String[] CANTIDADES = request.getParameterValues("CANTIDAD");
			String[] posicionesEnLista = request.getParameterValues("posicionEnLista");

			//VALIDACION SUSCRIPCION QUID
			if(CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0)) && Integer.parseInt(CANTIDADES[0]) != 0){
				if(Integer.parseInt(CANTIDADES[0]) > 1){
					//si ya esta agregada la suscripcion
					request.getSession().setAttribute("msgError", "El carrito ya contiene una suscripcion Quid.");
				}else if(Integer.parseInt(CANTIDADES[0]) < 0 ){
					//si la cantidad es invalida
					request.getSession().setAttribute("msgError", "La cantidad es erronea.");
				}else{
					request.getSession().removeAttribute("msgError");
				}
				//response.sendRedirect(CompraHelper.PAGINA_CARRITO+"?param="+Math.random());
				response.sendRedirect(request.getHeader("REFERER"));
				return ;
			}else{
				request.getSession().removeAttribute("msgError");
			}
			//FIN VALIDACION
			
			//borro promos
			ordenDAO.eliminarPromos();
			//borro gastos de envio
			ordenDAO.eliminarGastosDeEnvio();

			boolean hayCambios = false;
			int cambiosEnLista = 0;
			for (int i = 0; i < ID_ARTICULOS.length; i++) {
				int posicionEnLista = Convert.toNumber(posicionesEnLista[i], 0);
                //AHORA VIENEN POR POSICION EN LA LISTA PROMOII
				ArticuloDAO articuloDAO = (ArticuloDAO)ordenDAO.getArticulos().get(posicionEnLista + cambiosEnLista);
                int cantidad = Convert.toNumber(CANTIDADES[i], articuloDAO.getCantidad());
				hayCambios = hayCambios || (cantidad != articuloDAO.getCantidad());

				if (hayCambios) {
					if (cantidad == 0) {
						ordenDAO.removeArticuloByPos(posicionEnLista + cambiosEnLista);
						cambiosEnLista--;
						TmkLogger.debug("CAMBIO EN LISTA " + cambiosEnLista);
					} else {
						((ArticuloDAO)ordenDAO.getArticulos().get(posicionEnLista + cambiosEnLista)).setCantidad(cantidad);
						if (((ArticuloDAO)ordenDAO.getArticulos().get(posicionEnLista + cambiosEnLista)).getPapelDeRegalo() != null) {
							((ArticuloDAO)ordenDAO.getArticulos().get(posicionEnLista + cambiosEnLista)).getPapelDeRegalo().setCantidad(cantidad);
						}
					}
				}
			}

			if (hayCambios) {
				// graba el carrito recien generado
				ordenDAO.grabarCarritoCompra(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
				// calcula gasto de envio y demas

			}
			CompraHelper.recalcularConceptosFacturables(ordenDAO, socioPK);
			// continua o cancela la compra si no tiene productos
			if (ordenDAO.tieneArticulos()) {
				
				if (ordenDAO.getMedioDeCobro() == null) {
					// si no tengo medio de cobro borro todo lo que tenga que ver con tarjeta
					ordenDAO.completarDatosTarjeta(null, null, 0, 0, null, null, 0, null);
					ordenDAO.setTarjetaPlanDAO(null);
				}
				response.sendRedirect(request.getHeader("REFERER"));
			} else {
				response.sendRedirect(CompraHelper.PAGINA_HOME_SITIO);
			}

		} catch (Exception e) {
			TmkLogger.debug(e.toString());
            TmkLogger.debug(request.getHeader("REFERER"));
            response.sendRedirect(request.getHeader("REFERER"));
		}
	}
}
