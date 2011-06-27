/**
 * $Log: DirectorioDaemon.java,v $
 * Revision 1.8  2007/11/15 13:52:51  msartori
 * Reescritura de URL para familias.
 * - Modificaciones en generacion de familias
 * - Modificaciones en site map
 * - Modificaciones en arbol
 *
 * Eliminacion EJB mas vendidos y categoria seccion.
 *
 * Revision 1.7  2007/01/23 17:32:21  oLSuarez
 * Rediseño del mapa de productos
 *
 * Revision 1.6  2007/01/22 17:23:21  oLSuarez
 * Correcciones
 *
 * Revision 1.5  2006/02/10 18:16:26  oDZurita
 * - corrección de la visualización de la disponibilidad de los articulos en el detalle.
 *
 * Revision 1.4  2006/02/09 16:15:37  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.3  2006/01/31 15:51:36  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.2  2005/12/29 17:45:27  omsartori
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
 * Revision 1.1  2005/09/29 12:45:31  omsartori
 * - Ejb reducido en orden y en resultados de busqueda
 * - Mapa de productos
 * - Promo dia de la madre, pagina de promo.
 * - Seguimiento EMPRO, visitas por canales, registraciones por canales
 *
 */



package com.tmk.setup;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.controllers.MainHelper;
import com.tmk.generacion.directorio.Directorio;
import java.util.Calendar;


public class DirectorioDaemon extends Daemon {
        private static DirectorioDaemon directorioDaemon = new DirectorioDaemon();
		public DirectorioDaemon() {
			//super(Daemon.CINCO_MINUTOS , Daemon.UNA_HORA);
			//super(Daemon.CINCO_MINUTOS, Daemon.UN_DIA*7 - Daemon.DIEZ_MINUTOS);
			super(Daemon.CINCO_SEGUNDOS * 10, Daemon.UN_DIA*7 - Daemon.DIEZ_MINUTOS);
		}

		public void ejecutarTarea() { //protected

		try {
			TmkLogger.debug("DIRECTORIO] Iniciando generacion...");
			Directorio.generarDirectorio();
			//grabarProximaCorrida();
			TmkLogger.debug("DIRECTORIO] Generacion Finalizada...");

			} catch (Exception e) {
                MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_WEBMASTER,
					Globals.NOMBRE_DEL_SITIO + " - Generacion de Directorio.",
					"No se genero el Directorio. Error: " + e.toString() + MainHelper.getMessage(e));
			}
		}

		protected String getMensaje() {
			return "Generacion de Directorio";
		}

		private static boolean esMomento() {
			Calendar ahora = Calendar.getInstance();
			/*Calendar prox = Calendar.getInstance();
			prox.setTime(Globals.DIRECTORIO_PROX_GEN);

			return (ahora.get(Calendar.YEAR) == prox.get(Calendar.YEAR) &&
			   ahora.get(Calendar.MONTH) == prox.get(Calendar.MONTH) &&
			   ahora.get(Calendar.DATE) == prox.get(Calendar.DATE) &&
			   ahora.get(Calendar.HOUR) == prox.get(Calendar.HOUR)) &&
			   ahora.get(Calendar.AM_PM) == prox.get(Calendar.AM_PM);*/
			return (ahora.get(Calendar.DATE) == 2 ||
					ahora.get(Calendar.DATE) == 9 ||
					ahora.get(Calendar.DATE) == 16 ||
					ahora.get(Calendar.DATE) == 23 )
					 && ahora.get(Calendar.HOUR_OF_DAY) == 16;
		}

/*		public static void grabarProximaCorrida() {
			Calendar prox = Calendar.getInstance();
			prox.set(Calendar.DATE, prox.get(Calendar.DATE) + Globals.DIRECTORIO_DIAS_GEN);
			Globals.SERVER.getDirectorio().setProximaGeneracion(prox.getTime());

			try{
				FileWriter file = new FileWriter (Globals.DIRECTORIO_APLICACION  + "\\setup\\server.xml");

            try {
				Marshaller marshaller = new Marshaller(file);
				marshaller.setEncoding("ISO-8859-1");
				marshaller.setNoNamespaceSchemaLocation("server.xsd");
				marshaller.marshal(Globals.SERVER);
			} finally{
                file.close();
			}
			} catch (Exception e) {

			}
		}*/

		protected boolean pausada() {

			return (Globals.baseDeDatosEnMantenimiento())
				|| (!esMomento());
		}

}

