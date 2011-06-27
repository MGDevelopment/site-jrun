/**
 * $Log: BusquedaPorAtributoPrincipal.java,v $
 * Revision 1.4  2007/02/02 21:04:56  oLSuarez
 * - Mapa de entrevistas
 * - Mapa de notas de prensa
 * Se agrego linksMapa.jsp
 *
 * Revision 1.3  2006/11/08 15:41:06  omsartori
 * Rediseño: Homes
 *                    Destacado
 *                    Ultimos Visitados
 *                    Arbol Categorias
 *                    Carrito
 *                    Logo y control de modo
 *
 * Revision 1.2  2005/12/29 17:45:26  omsartori
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
 * Revision 1.1  2005/07/26 14:13:39  omsartori
 * - Modificaciones en Articulo Reducido
 * - Tag de Precio para Articulo
 * - Buscador por id de autor
 * - Buscador generico por atributo principal (DROMO)
 * - Home> Articulo reemplazado por Articulo Reducido
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;

import java.util.Vector;

public class BusquedaPorAtributoPrincipal {
	public BusquedaGenerica buscador;
	
	public BusquedaPorAtributoPrincipal(String texto, Vector idAtributoPrincipal, Integer seccion,
	                       Integer registroInicial, Integer registroFinal,
	                       CriterioDAO criterio,
	                       boolean soloPedidoEspecial) {
		switch (seccion.intValue()) {
			case Globals.SECCION_LIBRO:
			case Globals.SECCION_REVISTAS:
			case Globals.SECCION_MUSICA:
			case Globals.SECCION_PELICULA: {
				try {
                    buscador = new BusquedaPorIDdeAutor(texto, idAtributoPrincipal, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
				} catch (Exception e) {
					TmkLogger.error("BUSQUEDA POR ATRIBUTO PRINCIPAL] " + e.getMessage());
				}break;
			}
			case Globals.SECCION_JUGUETES: {
			    try {
					buscador = new BusquedaPorIDdeEditorial (texto, (Integer)idAtributoPrincipal.get(0), seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
				} catch (Exception e) {
					TmkLogger.error("BUSQUEDA POR ATRIBUTO PRINCIPAL] " + e.getMessage());
				}break;
			}
			default: {
				TmkLogger.error("BUSQUEDA POR ATRIBUTO PRINCIPAL] Se intenta buscar en una categoria no habilitada");
			}

		}
	}
	/*
	public BusquedaPorAtributoPrincipal(String texto, Vector idAtributoPrincipal, Integer seccion,
            Integer registroInicial, Integer registroFinal,
            CriterioDAO criterio) {
		switch (seccion.intValue()) {
			//case Globals.SECCION_REVISTAS:
			//case Globals.SECCION_MUSICA:
			//case Globals.SECCION_PELICULA: 
			case Globals.SECCION_LIBRO:	{
				try {
			     buscador = new BusquedaPorIDdeAutor(texto, idAtributoPrincipal, seccion, registroInicial, registroFinal, criterio);
				} catch (Exception e) {
					TmkLogger.error("BUSQUEDA POR ATRIBUTO PRINCIPAL] " + e.getMessage());
				}break;
			}
		
			default: {
				TmkLogger.error("BUSQUEDA POR ATRIBUTO PRINCIPAL] Se intenta buscar en una categoria no habilitada");
			}
		}
	}*/
	
}
