/**
 * $Log: ReporteEstadisticasDaemon.java,v $
 * Revision 1.12  2009/03/20 18:23:49  msartori
 * - Meta Tags 
 * - Detalle y paginas derivadas 
 * - Buscador 
 *
 * Revision 1.11  2008/12/03 12:40:41  msartori
 * - Mesa Interactiva
 * - Vencimiento cheque obsequio por parametro
 * - Version 1.3 de xstream
 *
 * Revision 1.10  2008/04/09 20:19:04  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.9  2008/01/24 20:28:02  msartori
 * no message
 *
 * Revision 1.8  2007/12/18 20:10:27  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.7  2006/09/14 18:24:35  omsartori
 * Promociones II
 *
 * Revision 1.6  2006/01/31 15:51:25  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.5  2005/12/29 17:45:10  omsartori
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
 * Revision 1.4  2004/08/03 15:46:52  oGPistoia
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

import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;

public class ReporteEstadisticasDaemon extends Daemon {

	public ReporteEstadisticasDaemon() {
		super(Daemon.UN_MINUTO * 2, Daemon.UNA_HORA - Daemon.CINCO_MINUTOS);
        //super(Daemon.UN_MINUTO * 6, Daemon.UNA_HORA - Daemon.CINCO_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {
		String [] receptoresEstadisticasCompletas = {"rmiranda@ilhsa.com", 
				"dwainer@ilhsa.com", "laguirre@ilhsa.com","clopez@ilhsa.com", "dwinnik@ilhsa.com"};
		String [] receptoresOrdenesDelDia = {"rmiranda@ilhsa.com", 
				"dwainer@ilhsa.com", "laguirre@ilhsa.com","dwinnik@ilhsa.com"};//,
		String [] receptoresOrdenesPosiblesFraudes = {"rmiranda@ilhsa.com",
				"laguirre@ilhsa.com","dwinnik@ilhsa.com"};//,
		String [] receptoresOrdenesSimilares = {"rmiranda@ilhsa.com",
				"laguirre@ilhsa.com","gspotorno@ilhsa.com", "dwinnik@ilhsa.com"};//,
		String [] receptoresOrdenesRetrasadas = {"rmiranda@ilhsa.com",
				"laguirre@ilhsa.com", "dwainer@ilhsa.com", "dwinnik@ilhsa.com"};//,
		// Llama a la rutina de envio de mail que genera las ordenes

		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        receptoresEstadisticasCompletas,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Estadisticas",
		        "El reporte actual no pudo completarse. El próximo reporte de ordenes llegará en una hora.",
		        "/mailing/estadisticasCompletas.jsp");
		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        receptoresOrdenesDelDia,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Ordenes del Dia",
		        "El reporte actual no pudo completarse. El próximo reporte de ordenes llegará en una hora.",
		        "/mailing/estadisticasOrdenesDelDia.jsp");
		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        receptoresOrdenesPosiblesFraudes,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte Ordenes con posible fraude",
		        "El reporte actual no pudo completarse. El próximo reporte de ordenes llegará en una hora.",
		        "/mailing/estadisticasOrdenesPosiblesFraudes.jsp");
		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        receptoresOrdenesSimilares,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte Ordenes Similares",
		        "El reporte actual no pudo completarse. El próximo reporte de ordenes llegará en una hora.",
		        "/mailing/estadisticasOrdenesSimilares.jsp");
		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        receptoresOrdenesRetrasadas,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte Ordenes Retrasadas",
		        "El reporte actual no pudo completarse. El próximo reporte de ordenes llegará en una hora.",
		        "/mailing/estadisticasOrdenesRetrasadas.jsp");
	}


	protected String getMensaje() {
		return "Reporte de Estadisticas y Ordenes";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento()) || (!Globals.esHorarioDeReporte(23, 45, true));
	}

}
