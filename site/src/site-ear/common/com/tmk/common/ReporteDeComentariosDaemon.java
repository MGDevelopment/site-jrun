/**
 * $Log: ReporteDeComentariosDaemon.java,v $
 * Revision 1.6  2008/12/03 12:40:40  msartori
 * - Mesa Interactiva
 * - Vencimiento cheque obsequio por parametro
 * - Version 1.3 de xstream
 *
 * Revision 1.5  2008/09/02 19:42:15  msartori
 * - DBO select soportando campos hijos DBO y campos hijos array de DBO
 *
 * Revision 1.4  2006/01/31 15:51:25  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.3  2005/01/18 19:46:03  oGPistoia
 * - Nuevo EJB de Proveedores
 * - Busqueda por Proveedor
 * - Modificaciones en los reportes
 * - Cambios en clientes institucionales
 *
 * Revision 1.2  2004/09/10 15:12:47  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 */
package com.tmk.common;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;

public class ReporteDeComentariosDaemon extends Daemon {

	public ReporteDeComentariosDaemon() {
		super(Daemon.CINCO_MINUTOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {
		String [] receptores = new String[] {	"rmiranda@ilhsa.com",
												"laguirre@ilhsa.com",
												"ppirillo@ilhsa.com",
												"dwainer@ilhsa.com"
											};

		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        receptores,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Comentarios sobre Artículos",
		        "No se genero el listado de comentarios sobre artículos, se procesará más tarde.",
		        "/mailing/comentarios.jsp");
	}

	protected String getMensaje() {
		return "Reporte de Comentarios sobre Artículos";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento())
                || (!Globals.esHorarioDeReporte(8, 20, false));
	}

}
