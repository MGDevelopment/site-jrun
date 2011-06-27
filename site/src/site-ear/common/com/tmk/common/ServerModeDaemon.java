/**
 * $Log: ServerModeDaemon.java,v $
 * Revision 1.21  2009/01/15 12:35:20  msartori
 * no message
 *
 * Revision 1.20  2008/12/03 12:40:41  msartori
 * - Mesa Interactiva
 * - Vencimiento cheque obsequio por parametro
 * - Version 1.3 de xstream
 *
 * Revision 1.19  2005/12/29 17:45:10  omsartori
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
 * Revision 1.18  2004/12/02 22:39:48  oGPistoia
 * - Queda aprobada la matriz de estados
 *
 * Revision 1.17  2004/12/02 22:21:55  oGPistoia
 * - PreRelease Agendas.
 * - Eliminacion de productos via XML porque se reemplaza por estado_articulos
 *
 * Revision 1.16  2004/09/23 18:44:39  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.15  2004/08/03 15:46:53  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.14  2004/07/05 15:43:13  oGPistoia
 * - Release 1.80 (y cambios menores)
 *
 * Revision 1.13  2004/06/15 20:56:03  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.12  2004/06/09 18:49:02  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.11  2004/05/04 18:09:29  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.10  2004/03/25 18:18:47  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.9  2004/03/04 18:51:39  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.8  2004/02/27 13:44:15  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.7  2004/02/16 20:22:51  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.6  2004/02/11 19:32:49  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.5  2003/12/22 22:26:50  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.4  2003/12/11 20:52:03  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.3  2003/12/04 17:19:07  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/11/26 15:36:52  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.1  2003/10/12 22:11:21  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 */
package com.tmk.common;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.server.Cronograma;
import com.tmk.kernel.server.InactividadItem;
import com.tmk.kernel.server.types.ModoType;
import org.exolab.castor.types.Time;

import java.util.Date;

public class ServerModeDaemon extends Daemon {

	public ServerModeDaemon() {
		super(Daemon.DIEZ_SEGUNDOS, Daemon.UN_SEGUNDO, Thread.MAX_PRIORITY);
	}

	private boolean esMayor(Date date, Time time) {
		if (date.getHours() > time.getHour()) return true;
		if (date.getHours() < time.getHour()) return false;
		if (date.getMinutes() > time.getMinute()) return true;
		if (date.getMinutes() < time.getMinute()) return false;
		if (date.getSeconds() > time.getSeconds()) return true;
		if (date.getSeconds() > time.getSeconds()) return false;
		return false;
	}

	protected Cronograma proximoACambiar(int minutosAntes) {
		// fechas de inactividad
		for (int i = 0; i < Globals.INACTIVIDAD.getInactividadItemCount(); i++) {
			// Fecha actual
			Date fecha = new Date();
			// una de esas fechas
			InactividadItem item = Globals.INACTIVIDAD.getInactividadItem(i);
			// si el dia es el mismo que hoy
			if (item.getCronograma().getDia().getType() + 1 == fecha.getDay()) {
				// y aun no paso la hora de vuelta atras
				if (!esMayor(fecha, item.getCronograma().getFin())) {
					// Mueve la fecha de inicio
					fecha.setMinutes(fecha.getMinutes() + minutosAntes);
					// ya paso la hora de cambio
					if (esMayor(fecha, item.getCronograma().getComienzo())) {
						// cambiaria al nuevo estado
						return item.getCronograma();
					}
				}
			}
		}
		return null;
	}

	protected void ejecutarTarea() throws Exception {

		// Si esta mal el server, entra en modo mantenimiento, si se puso a resetear, entra en ese modo
		ModoType modoFinal = (Globals.MODO_PRE_RESET) ? ModoType.MANTENIMIENTO : Globals.MODO_ELEGIDO;

		// Mostrar alerta de cambio de modo
		boolean antesDeCambioDeModo= false;

		// comprueba si cambia ahora
		Cronograma cronograma = proximoACambiar(0);
		if (cronograma == null) {
			// Calcular si en un rato empieza el cambio
			antesDeCambioDeModo = (proximoACambiar(Globals.MINUTOS_DE_ANTICIPACION) != null);

		} else {
			// Proximo modo
			modoFinal = cronograma.getModo();
		}

		// Si entro en modo reset, queda asi
		modoFinal = (ModoType.RESET.getType() == Globals.MODO_ACTUAL.getType()) ? ModoType.RESET : modoFinal;

		// si tiene que cambiar el estado
		if (modoFinal.getType() != Globals.MODO_ACTUAL.getType()) {

			StringBuffer message = new StringBuffer();
			message.append("Cambia de modo ").append(Globals.MODO_ACTUAL.toString().toUpperCase());
			message.append(" a " + modoFinal.toString().toUpperCase());
			if (cronograma != null) {
				message.append(" entre " + cronograma.getComienzo());
				message.append(" y " + cronograma.getFin());
				message.append(Globals.ENTER).append(Globals.MENSAJE_MODO);
			}

			// cambia
			Globals.MODO_ACTUAL = modoFinal;

			// Manda mail
			TmkLogger.info(message);
			MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_WEBMASTER, Globals.NOMBRE_DEL_SITIO + " - Cambio de Modo", message.toString());

		}

		// Mantenimiento de los mensajes
		Globals.MOSTRAR_MENSAJE = (Globals.sitioDisponible()) && (antesDeCambioDeModo || Globals.MODO_PRE_RESET);
		Globals.MENSAJE_MODO = (Globals.sitioDisponible()) ? Globals.MENSAJE_PREVIO : Globals.MENSAJE_MANTENIMIENTO;
		if (cronograma != null) {
			Globals.MENSAJE_MODO = Globals.MENSAJE_MODO + " (de " + cronograma.getComienzo() + " a " + cronograma.getFin() + ")";
		}
	}

	protected String getMensaje() {
		return null;
	}

	protected boolean pausada() {
		// Bloquea el cambio de modo si no tiene lo necesario para arrancar la aplicacion
		return  (Globals.getXmlLoader() == null) ||
		        (Globals.ARTICULO_DEFAULT == 0) ||
		        (Globals.TASA_DOLLAR <= 0.0) ||
		        (Globals.TASA_EURO <= 0.0) ||
		        (Globals.PAISES == null) ||
		        (Globals.PROVINCIAS == null) ||
		        (Globals.LOCALIDADES == null) ||
		        (Globals.IDIOMAS == null) ||
		        (Globals.TIPOS_DOCUMENTO == null) ||
		        (Globals.ESTADOS_CIVILES == null) ||
		        (Globals.PROFESIONES == null) ||
		        (Globals.MEDIOS_DE_COBRO == null) ||
		        (Globals.DISPONIBILIDADES == null) ||
		        (Globals.ESTADOS_ORDENES == null) ||
		        (Globals.ESTADOS_ITEM_ORDENES == null) ||
		        (Globals.NIVELES_DE_RIESGO == null) ||
		        (Globals.MESES == null) ||
		        (Globals.HABILITA_CUOTAS &&
		            ((Globals.TARJETAS_PLANES == null) ||
		             (Globals.TARJETAS_RANGOS == null) ||
		             (Globals.TARJETAS_DETALLE_ARTICULO.isEmpty()))) ||
		         !Globals.CATEGORIAS_LOADED ||
		        // Para fidelizacion
		        (Globals.FIDELIZACION_VIGENTE &&
		            ((Globals.CATALOGOS == null) ||
					 (Globals.ITEMS_CATALOGOS == null) ||
					 (Globals.REGLAS_DE_PUNTOS == null) ||
		             (Globals.REGLA_FDN_POR_ADHESION == null) ||
		             (Globals.REGLA_FDN_POR_DATOS_COMPLEMENTARIOS == null) ||
					 (Globals.ESTUDIOS == null) ||
					 (Globals.OCUPACIONES == null) ||
					 (Globals.EMPRESAS_SIMILARES == null) ||
					 (Globals.TARJETAS_DE_PUNTAJE == null) ||
					 (Globals.TELEFONOS_CELULARES == null) ||
					 (Globals.MARCAS_DE_VEHICULOS == null) ||
					 (Globals.MODELOS_DE_VEHICULOS == null) ||
					 (Globals.MARCAS_DE_COMBUSTIBLE == null) ||
					 (Globals.TIPOS_DE_COMBUSTIBLE == null) ||
					 (Globals.SISTEMA_TV == null) ||
					 (Globals.ACTIVIDADES_LABORALES == null)));  // Fin de fidelizacion

	}
}
