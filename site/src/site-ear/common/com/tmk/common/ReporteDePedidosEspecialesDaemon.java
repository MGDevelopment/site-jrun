/**
 * $Log: ReporteDePedidosEspecialesDaemon.java,v $
 * Revision 1.11  2006/01/31 15:51:25  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.10  2005/01/18 19:46:04  oGPistoia
 * - Nuevo EJB de Proveedores
 * - Busqueda por Proveedor
 * - Modificaciones en los reportes
 * - Cambios en clientes institucionales
 *
 * Revision 1.9  2004/08/03 15:46:52  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.8  2004/07/12 19:52:00  oGPistoia
 * - Correccion del director en el detalle reducido del buscador
 * - Correccion del bug de AgregarProducto
 *
 * Revision 1.7  2004/06/30 18:22:52  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.6  2004/06/15 20:56:02  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.5  2004/04/06 22:21:25  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.4  2004/02/27 13:44:15  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.3  2004/02/11 19:32:48  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.2  2003/12/22 22:26:50  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.1  2003/12/15 22:07:53  GPistoia
 * -Envio de mails de pedidos especiales
 * -Metodo de pago en la aprobacion/rechazo de orden
 *
 */
package com.tmk.common;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;

public class ReporteDePedidosEspecialesDaemon extends Daemon {

	public ReporteDePedidosEspecialesDaemon() {
		super(Daemon.CINCO_MINUTOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
        //super(Daemon.DOS_MINUTOS + Daemon.UN_MINUTO , Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {
		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        Globals.MAIL_REPORTE_DE_PEDIDOS_ESPECIALES,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Pedidos Especiales",
		        "No se genero el listado de pedidos especiales, se procesará más tarde.",
		        "/mailing/pedidosEspeciales.jsp");
	}

	protected String getMensaje() {
		return "Reporte de Pedidos especiales";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento()) || (!Globals.esHorarioDeReporte(8, 10, false));
	}

}
