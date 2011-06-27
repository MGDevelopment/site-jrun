/**
 * $Log: ReporteEstadisticasTemporalesDaemon.java,v $
 * Revision 1.2  2006/01/31 15:51:26  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.1  2005/12/29 17:45:10  omsartori
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
 */
package com.tmk.common;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;

public class ReporteEstadisticasTemporalesDaemon extends Daemon {

	public ReporteEstadisticasTemporalesDaemon() {
		//super(Daemon.DOS_MINUTOS, Daemon.UNA_HORA - Daemon.CINCO_MINUTOS);
        super(Daemon.UN_MINUTO, Daemon.UNA_HORA - Daemon.CINCO_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {
		// Llama a la rutina de envio de mail que genera las ordenes
		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        Globals.MAIL_REPORTE_DE_ESTADISTICA_ORDENES,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Estadisticas Temporales",
		        "El reporte actual no pudo completarse. El próximo reporte de estadisticas Temporales llegará en una hora.",
		        "/mailing/estadisticas.jsp");
	}

	protected String getMensaje() {
		return "Reporte de Estadisticas Temporales";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento()) || (!Globals.esHorarioDeReporte(23, 55, true));
	}

}
