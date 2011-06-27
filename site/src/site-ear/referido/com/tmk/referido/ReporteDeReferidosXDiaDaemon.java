/**
 * $Log: ReporteDeReferidosXDiaDaemon.java,v $
 * Revision 1.2  2006/01/31 15:51:28  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.1  2005/09/06 13:29:35  omsartori
 * - Reporte de Referidos
 * - Campos piso, depto, edificio en visualizacion de direcciones de envio/fact
 *
 * Revision 1.1  2005/08/24 13:13:28  omsartori
 * - Modifcacion en homes.
 * - Referidos> cambio de direccion de envio
 *                      reporte de referidos por dia
 *
 */
package com.tmk.referido;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.Globals;

import java.util.Vector;


public class ReporteDeReferidosXDiaDaemon extends Daemon {

		static public Vector referidosXDia;

		public ReporteDeReferidosXDiaDaemon() {
			//super(Daemon.DIEZ_MINUTOS + (UN_MINUTO * 3), Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
            super(Daemon.DIEZ_MINUTOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
			//super(Daemon.UN_MINUTO, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
		}

		protected void ejecutarTarea() {

		try {
			referidosXDia = ReporteReferido.referidosXDia();

			MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_REPORTE_DE_SOCIOS,
					Globals.NOMBRE_DEL_SITIO + " - Reporte de Referidos por día.",
					"No se genero el listado de referidos por día.",
					"/mailing/referidosXDia.jsp");
			} catch (Exception e) {
				MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_WEBMASTER,
					Globals.NOMBRE_DEL_SITIO + " - Reporte de Referidos por día.",
					"No se genero el listado de referidos por día. Error: " + e.getMessage() + e.toString());
			}
		}

		protected String getMensaje() {
			return "Reporte de Referidos por Día";
		}

		protected boolean pausada() {
			return (Globals.baseDeDatosEnMantenimiento())
				|| (!Globals.esHorarioDeReporte(1, 0, false))
			    || (!Globals.referidoHabilitado());
		}

}



