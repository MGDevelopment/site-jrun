/**
 * $Log: GastosEnvioDAO.java,v $
 * Revision 1.20  2006/09/14 18:24:39  omsartori
 * Promociones II
 *
 * Revision 1.19  2005/03/24 15:25:03  omsartori
 * - Bug campo de gastos no grabado corregido
 * - Medio de cobro Rio Net Banking
 *
 * Revision 1.18  2005/03/15 12:28:00  omsartori
 * -Categoria (3,7,2,0 ) para Cheque obsequio
 * -Correccion del calculo del 5% para recargo EFCO
 * -Reemplazo de 7 x 10% en Afiliados libros
 * -Cambio en barra de titulos.
 * -Bug en lista de deseos.
 * -Eliminacion de jscript en combo convinado de localidades
 *
 * Revision 1.17  2004/10/05 21:27:57  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.16  2004/09/10 15:12:54  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.15  2003/12/04 17:19:11  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.14  2003/11/27 01:57:41  GPistoia
 * -Gasto de envio no tenia impuestos
 *
 * Revision 1.13  2003/10/03 16:29:04  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.12  2003/09/19 19:48:59  GPistoia
 * -Gasto de envio local y exterior cerrado
 * -Soporte de back despues de confirma compra.
 *
 * Revision 1.11  2003/09/17 15:13:37  GPistoia
 * -Incidente de link en promociones.
 * -Importe minimo de 0.01 para cualquier producto.
 *
 * Revision 1.10  2003/09/15 22:30:53  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.9  2003/09/11 18:08:43  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.8  2003/08/21 17:48:26  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.7  2003/08/08 20:13:42  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 * Revision 1.6  2003/08/07 18:10:19  GPistoia
 * -Modificaciones en articulos DAO y EJB
 *
 * Revision 1.5  2003/08/06 21:28:21  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.4  2003/08/04 22:17:51  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.3  2003/08/02 16:58:09  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.2  2003/07/30 15:18:01  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.1  2003/07/26 19:06:07  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel;

import javax.ejb.FinderException;
import javax.naming.NamingException;


public class GastosEnvioDAO extends ArticuloDAO {

	/***
	 * Crea el gasto de envio porque en comercial es un articulo más
	 */
	public GastosEnvioDAO(int idArticulo, int cantidad) throws NamingException, FinderException {
		super(idArticulo, cantidad);
	}

	public void setPrecio(double precio) {
		precio = Convert.round(Math.max(precio, Globals.IMPORTE_MINIMO_AFIP));
		this.precioOriginal = precio;
		this.precioPromocionSinImpuestos = precio;
		// Idem a ArticuloBean solo que salen de lugares diferentes
		this.precioConImpuesto = Convert.round(Convert.aplicarPorcentaje(precio, tasaImpuestoGeneral + tasaImpuestoVideo));
		this.precioConDescuento = Convert.round(Convert.aplicarPorcentaje(precioConImpuesto, porcentajeDescuento));
		this.precioSitio = precioConDescuento;
	}

	public void agregarRecargo(double recargo) {
		//this.precioSitio += recargo;
		TmkLogger.debug("RECARGO POR EFECTIVO " + recargo);
		this.precioOriginal = precioOriginal  +  (recargo - (recargo * 21 / 121));
		this.precioPromocionSinImpuestos = (precioPromocionSinImpuestos > 0.01)? precioPromocionSinImpuestos + (recargo - (recargo * 21 / 121)) : precioPromocionSinImpuestos;
		this.precioConImpuesto = Convert.round(Convert.aplicarPorcentaje(precioOriginal, tasaImpuestoGeneral + tasaImpuestoVideo));
		this.precioConDescuento = Convert.round(Convert.aplicarPorcentaje(precioConImpuesto, porcentajeDescuento));
		this.precioSitio = precioConDescuento;
	}

	public boolean esGastoBasico() {
		return (this.id == Globals.GASTO_ENVIO_BASICO_MERC_EXTERIOR ||
					this.id == Globals.GASTO_ENVIO_BASICO_MERC_LOCAL);
	}
	
	public String toString() {
		return titulo + " por " + precioSitio;
	}

}
