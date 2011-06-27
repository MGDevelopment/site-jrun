/**
 * $Log: ReporteDeComprasPorSociosDaemon.java,v $
 * Revision 1.12  2006/01/31 15:51:25  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.11  2005/08/16 16:08:07  omsartori
 * - Cambios estéticos en home
 * - Posibilidad de incluir un file html en el destacado de las home
 * - Yahoo agregado al seguimiento
 * - Se agregaron las palabras de búsqueda al reporte de seguimiento.
 *
 * Revision 1.10  2005/05/26 14:43:41  omsartori
 * - Mail de tarjetas verificadas.
 * - Pais de facturacion y tarjeta extra para reporte de compras por socios.
 * - Se elimino el cambio de modo en el revitalizer
 * - Cambio de la leyenda de entrega y tel de contacto en la compra y ayuda
 * - Vigencia del referido
 * - Promocion no acumulable con referido
 *
 * Revision 1.9  2005/03/17 15:57:06  omsartori
 * - se cambio el plazo para enviar los reportes de socios registrados y compras por socios de 2 a 5 dias
 * - el reporte de compras por socios tiene en cuenta todos los socios que hayan comprado, no solo los registrados en el mes anterior
 *
 * Revision 1.8  2005/01/18 19:46:03  oGPistoia
 * - Nuevo EJB de Proveedores
 * - Busqueda por Proveedor
 * - Modificaciones en los reportes
 * - Cambios en clientes institucionales
 *
 * Revision 1.7  2005/01/12 13:59:48  omsartori
 * - Reporte de socios registrados se modificó para que sean socios que no hayan comprado
 * - Reporte de medio de cobro pasó de mensual a diario con el mes actual, se mejoró la performance de los qrys
 * - Reporte de compras por socios se mejoró la performance del qry
 * - Reporte de alianzas se modificó el horario
 *
 * Revision 1.6  2005/01/05 18:26:03  oGPistoia
 * - Correccion de los reportes de totales
 *
 * Revision 1.5  2005/01/04 15:29:17  oGPistoia
 * - Cambio de la orden de FAX a TARJETA (visa, mast, etc) en la intranet
 * - Generación de la tapa protegida vencida en background
 * - Reporte de HBRio, Compras y socios
 *
 * Revision 1.4  2005/01/04 12:58:06  omsartori
 * - Corrección de pausa en reportes
 *
 * Revision 1.3  2005/01/03 12:10:39  omsartori
 * Cambio or por and en pausa de reportes
 *
 * Revision 1.2  2004/12/30 15:25:44  omsartori
 * - Reporte de Seguimiento de RIO HB con un demonio
 * - Reemplacé Date por Calendar en los reportes
 *
 * Revision 1.1  2004/12/27 15:41:39  omsartori
 * - chequeo de direcciones que no se deben modificar
 * - reporte de compras por socio con un demonio
 * - reporte de socios registrados con un demonio
 *
 */
package com.tmk.common;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.DBUtil;

import java.util.Vector;
import java.util.Calendar;

public class ReporteDeComprasPorSociosDaemon extends Daemon {

	static public Vector comprasPorSocios;

	public ReporteDeComprasPorSociosDaemon() {
		super(Daemon.CINCO_MINUTOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
		//super(Daemon.UN_MINUTO, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {

		comprasPorSocios = DBUtil.comprasPorSocios();

		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        Globals.MAIL_REPORTE_DE_SOCIOS,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Compras por Socios en el mes anterior",
		        "No se genero el listado de compras por socios en el mes anterior, se procesará más tarde.",
		        "/mailing/comprasPorSocios.jsp");
	}

	protected String getMensaje() {
		return "Reporte de Compras por socios en el mes anterior";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento())
			|| (!Globals.esHorarioDeReporte(8, 30, false))
		    || (Calendar.getInstance().get(Calendar.DATE) > 2);   // Para que llegue del 1 al 2*/
	}

}
