/**
 * $Log: ReporteDeReferidosCompraAprobadaDaemon.java,v $
 * Revision 1.3  2006/01/31 15:51:27  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.2  2005/09/22 18:38:28  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.1  2005/09/06 13:29:34  omsartori
 * - Reporte de Referidos
 * - Campos piso, depto, edificio en visualizacion de direcciones de envio/fact
 *
 */
package com.tmk.referido;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.Globals;

import java.util.Vector;
import java.util.Calendar;

public class ReporteDeReferidosCompraAprobadaDaemon extends Daemon {
	static public Vector referidosCompraAprobada;

		public ReporteDeReferidosCompraAprobadaDaemon() {
			//super(Daemon.DIEZ_MINUTOS + (UN_MINUTO * 15), Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
            super(Daemon.DIEZ_MINUTOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
			//super(Daemon.UN_MINUTO*5, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
		}

		protected void ejecutarTarea() {

		try {
			referidosCompraAprobada = ReporteReferido.referidosCompraAprobada();

			MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_REPORTE_DE_SOCIOS,
					Globals.NOMBRE_DEL_SITIO + " - Reporte de Referidos con Compra Aprobada.",
					"No se genero el listado de Referidos con Compra Aprobada.",
					"/mailing/referidosCompraAprobada.jsp");
			} catch (Exception e) {
				MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_WEBMASTER,
					Globals.NOMBRE_DEL_SITIO + " - Reporte de Referidos con Compra Aprobada.",
					"No se genero el listado de referidos con Compra Aprobada. Error: " + e.getMessage() + e.toString());
			}
		}

		protected String getMensaje() {
			return "Reporte de Referidos con Compra Aprobada";
		}

		protected boolean pausada() {
			return (Globals.baseDeDatosEnMantenimiento())
				|| (!Globals.esHorarioDeReporte(2, 30, false))
			    || (Calendar.getInstance().get(Calendar.DATE) > 2)
				|| (!Globals.referidoHabilitado());
		}

}

