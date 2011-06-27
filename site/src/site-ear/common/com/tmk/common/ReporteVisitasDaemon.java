/**
 * $Log: ReporteVisitasDaemon.java,v $
 * Revision 1.2  2006/01/31 15:51:26  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.1  2004/08/03 15:46:53  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.3  2004/06/30 18:22:53  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.2  2004/06/15 20:56:02  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.1  2004/05/14 19:16:44  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.13  2004/03/25 18:18:46  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.12  2004/02/27 13:44:13  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.11  2004/02/16 20:22:49  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.10  2004/02/11 19:32:47  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.9  2003/12/22 22:26:48  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.8  2003/12/15 22:07:52  GPistoia
 * -Envio de mails de pedidos especiales
 * -Metodo de pago en la aprobacion/rechazo de orden
 *
 * Revision 1.7  2003/12/11 20:52:02  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.6  2003/12/04 17:19:05  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/11/26 15:36:51  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.4  2003/11/19 18:55:22  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.3  2003/10/23 19:05:10  GPistoia
 * -Correccion de Mas vendidos
 * -Site.xml generado en español
 * -Agregado de direccion de mail para estadisticas
 *
 * Revision 1.2  2003/10/14 00:20:36  GPistoia
 * Dentro de treinta minutos
 *
 * Revision 1.1  2003/10/13 21:43:26  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 */
package com.tmk.common;

import com.tmk.kernel.*;

public class ReporteVisitasDaemon extends Daemon {

	public ReporteVisitasDaemon() {
		super(Daemon.UN_MINUTO, Daemon.UN_DIA - Daemon.CINCO_MINUTOS);
        //super(Daemon.UN_MINUTO * 8, Daemon.UN_DIA - Daemon.CINCO_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {

		// Hace la consulta para enviarla en caso de error
		int cantidadDeVisitas = DBUtil.cantidadDeVisitasDesdeUnDiaAtras();

		// Llama a la pagina de generacion del listado de visitas
		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        Globals.MAIL_REPORTE_DE_VISITAS,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Visitas",
		        "La cantidad de visitas del último día son " + Convert.toString(cantidadDeVisitas),
		        "/mailing/reporteDeVisitas.jsp");
	}

	protected String getMensaje() {
		return "Reporte de Visitas";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento()) || (!Globals.esHorarioDeReporte(17, 00, false));
	}

}
