/**
 * $Log: ReporteDeMedioDeCobroDaemon.java,v $
 * Revision 1.7  2006/01/31 15:51:25  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.6  2005/01/12 13:59:41  omsartori
 * - Reporte de socios registrados se modificó para que sean socios que no hayan comprado
 * - Reporte de medio de cobro pasó de mensual a diario con el mes actual, se mejoró la performance de los qrys
 * - Reporte de compras por socios se mejoró la performance del qry
 * - Reporte de alianzas se modificó el horario
 *
 * Revision 1.5  2005/01/05 18:26:04  oGPistoia
 * - Correccion de los reportes de totales
 *
 * Revision 1.4  2005/01/04 15:29:17  oGPistoia
 * - Cambio de la orden de FAX a TARJETA (visa, mast, etc) en la intranet
 * - Generación de la tapa protegida vencida en background
 * - Reporte de HBRio, Compras y socios
 *
 * Revision 1.3  2005/01/04 12:58:00  omsartori
 * - Corrección de pausa en reportes
 *
 * Revision 1.2  2005/01/03 12:10:30  omsartori
 * Cambio or por and en pausa de reportes
 *
 * Revision 1.1  2004/12/30 15:25:48  omsartori
 * - Reporte de Seguimiento de RIO HB con un demonio
 * - Reemplacé Date por Calendar en los reportes
 *
 */

package com.tmk.common;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.Globals;

import java.util.Vector;

public class ReporteDeMedioDeCobroDaemon extends Daemon {

	static public Vector primerasCompras;
	static public Vector repeticion;
	static public Vector total;

	public ReporteDeMedioDeCobroDaemon() {
		super(Daemon.CINCO_MINUTOS , Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {

		primerasCompras = DBUtil.primerasComprasPorMedioDePago();
		repeticion = DBUtil.repeticionPorMedioDePago();
		total = DBUtil.totalPorMedioDePago();

		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        Globals.MAIL_REPORTE_DE_CLIENTES_INSTITUCIONALES,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Seguimiento de RIO HB",
		        "No se generó el reporte de seguimiento de RIO HB, se procesará más tarde.",
		        "/mailing/seguimientoRIOHB.jsp");
	}

	protected String getMensaje() {
		return "Reporte de Seguimiento de RIO HB";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento())
		       || (!Globals.esHorarioDeReporte(23, 50, false));        // Que llegue al final del dia todos los dias
	}

}
