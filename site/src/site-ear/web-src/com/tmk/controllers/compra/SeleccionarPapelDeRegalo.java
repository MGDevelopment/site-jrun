/**
 * $Log: SeleccionarPapelDeRegalo.java,v $
 * Revision 1.16  2006/12/18 20:06:17  oLSuarez
 * Rediseño de las paginas del proceso de compras
 *
 * Revision 1.15  2006/10/09 13:05:52  omsartori
 * -Google Analitics SSL
 * -Docs EMPro 14,16
 * -Correccion bug de nota de regalo
 * -Reordenamiento de articulos luego de promo
 * -Mejora en seleccion de gasto de envio
 *
 * Revision 1.14  2006/09/14 18:25:01  omsartori
 * Promociones II
 *
 * Revision 1.13  2005/11/24 15:28:13  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.12  2004/10/08 22:50:23  oGPistoia
 * - Adaptaciones al diseño de eXtra III
 * - Bug en Nombre Receptor en componentes
 * - Interes de 0.01 por redondeo eliminado
 *
 * Revision 1.11  2004/09/29 14:35:03  omsartori
 * - reducción de 10 a 8 paginas en el buscador
 * - corrección de bug, perdida de criterio cuando se salta a producto con/sin stock en el buscador
 * - correccion de bug que impedía quitar el papel de regalo
 *
 * Revision 1.10  2004/01/08 20:30:23  GPistoia
 * - Retoques por release, antes del buscador
 *
 * Revision 1.9  2004/01/06 15:29:50  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.8  2003/11/14 19:36:18  GPistoia
 * -Correcion de problemas de flash seguro y no-seguro
 * -Categorias ordenadas alfabeticamente
 *
 * Revision 1.7  2003/08/25 20:46:29  SLizardo
 * Optimize Imports
 *
 * Revision 1.6  2003/08/14 14:40:01  SLizardo
 * Se actualizo el Logger (Globals. a TmkLogger.)
 *
 * Revision 1.5  2003/08/12 22:08:16  GPistoia
 * -Se borraron las paginas viejas
 * -Se agregaron las paginas nuevas
 * -Se actualizo el proyecto y elimino el disco V
 *
 * Revision 1.4  2003/08/12 16:26:11  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.3  2003/08/07 18:10:26  GPistoia
 * -Modificaciones en articulos DAO y EJB
 *
 * Revision 1.2  2003/08/06 21:29:28  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.1  2003/08/04 22:17:59  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.1  2003/08/02 16:58:34  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 */
package com.tmk.controllers.compra;

import com.tmk.controllers.carrito.CarritoUtil;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class SeleccionarPapelDeRegalo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");

		//chequeo que la orden no se anula
		if(ordenDAO == null){
			response.sendRedirect("/miCuenta");
			return;
		}
		// Ya paso por este pedido
		ordenDAO.setPedirPapelesYNotas(false);

		String[] posicionesEnLista = request.getParameterValues("posicionEnLista");
	
		// Busca el ID de papel de regalo para cada producto
		for (int i = 0; i < posicionesEnLista.length; i++) {
			
			//test
			int posicionEnLista = Convert.toNumber(posicionesEnLista[i], -1);
			String nota = request.getParameter(CompraHelper.CAMPO_MENSAJE + posicionEnLista);	

			if (posicionEnLista > -1) {

				Integer papel = Convert.toNumber(request.getParameter(CompraHelper.CAMPO_PAPEL + posicionEnLista), (Integer)null);

				TmkLogger.debug("nota en sel: " + nota);
					
				ArticuloDAO articuloDAO = (ArticuloDAO)ordenDAO.getArticulos().get(posicionEnLista);
		
				// El campo TEXTAREA no respeta maximo, asi que no queda otra que cortarlo					
				articuloDAO.setNota((nota == null) ? null : Convert.toString(nota, 1500)); 

					try {
						if (papel != null) {
							ArticuloDAO  papelDeRegalo = new ArticuloDAO(papel.intValue());
							papelDeRegalo.setCantidad(articuloDAO.getCantidad());
							articuloDAO.setPapelDeRegalo(papelDeRegalo);
							TmkLogger.debug("Articulo " + articuloDAO.getId());
							TmkLogger.debug("Papel " + articuloDAO.getPapelDeRegalo().getId());
						} else {
							articuloDAO.setPapelDeRegalo(null);
						}
		
						/*if (papel != null) {
							ArticuloDAO papelDAO = new ArticuloDAO(papel.intValue());
							articuloDAO.setPapelDeRegalo(papelDAO);
							// Se pidio que las notas lleguen asociadas al articulo, no al papel, porque los papeles se reutilizan
							//papelDAO.setNota(nota);
						}*/
		
					} catch (Exception e) {
						TmkLogger.error("No se pudo asociar el articulo " + papel + " con la nota " + nota);
					}
				}	
		}
		 //BLOQUE PARA CHEQUEO DE SI ES SUSCRIPCION SOLO SEA EN ARGETINA
        if(ordenDAO!=null && CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))){
        	//si el pais no es argentina indico con un mensaje de error
        	try{
	        	if(!ordenDAO.getDomicilioEnvio().getIdPais().equals(Globals.ARGENTINA.getId())||
	        			!ordenDAO.getDomicilioFacturacion().getIdPais().equals(Globals.ARGENTINA.getId())){
	        		session.setAttribute("errorEnDomicilioDeSuscripcion", "true");
	        		response.sendRedirect("/compra/domicilios.jsp?TIPO_DOMICILIO=EN");
	        		return;
	        	}else{
	        		//si esta Ok, elimino el msj.
	        		session.removeAttribute("errorEnDomicilioDeSuscripcion");
	        	}
        	}catch(Exception npe){
        		TmkLogger.info("Falta cargar direccion] " + npe);
        	}
        }
        //FIN BLOQUE VALIDACION PAIS
        //boolean esProcesoNuevo = request.getSession().getAttribute("procesoDeCompraNuevo")!=null && request.getSession().getAttribute("procesoDeCompraNuevo").equals("true");
        boolean esProcesoNuevo = ProcesoCompraUtilImp.getInstance().esProcesoNueo(request);
        if(esProcesoNuevo) {
        	request.setAttribute("seguir", ProcesoCompraUtil.ENTREGA);
        }
		CompraHelper.proximoEstado(request, response, ordenDAO);

	}

}
