/**
 * $Log: ReporteDeReferenteBeneficioDaemon.java,v $
 * Revision 1.5  2006/10/12 14:59:05  omsartori
 * no message
 *
 * Revision 1.4  2006/01/31 15:51:27  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.3  2005/10/04 19:59:45  omsartori
 * - correccion reporte beneficios referente
 * - Seguimiento empro, visitas por canal
 *
 * Revision 1.2  2005/09/22 18:38:28  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.1  2005/09/06 13:29:33  omsartori
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

public class ReporteDeReferenteBeneficioDaemon extends Daemon {
	static public Vector referenteBeneficio;

		public ReporteDeReferenteBeneficioDaemon() {
            
            super(Daemon.DIEZ_MINUTOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
			//super(Daemon.UN_MINUTO, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
		}

		protected void ejecutarTarea() {

		try {
			referenteBeneficio = ReporteReferido.referenteBeneficio();

			MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_REPORTE_DE_SOCIOS,
					Globals.NOMBRE_DEL_SITIO + " - Reporte de Referente Beneficio.",
					"No se genero el listado de Beneficios de Referentes.",
					"/mailing/referenteBeneficio.jsp");
			} catch (Exception e) {
				MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_WEBMASTER,
					Globals.NOMBRE_DEL_SITIO + " - Reporte de Referente Beneficio.",
					"No se genero el listado de Beneficios de Referentes. Error: " + e.getMessage() + e.toString());
			}
		}

		protected String getMensaje() {
			return "Reporte de Beneficio de Referente";
		}

		protected boolean pausada() {
			
			return (Globals.baseDeDatosEnMantenimiento())
				|| (!Globals.esHorarioDeReporte(3, 0, false))
			    || (Calendar.getInstance().get(Calendar.DATE) > 2)
				|| (!Globals.referidoHabilitado());
		}

}

