/**
 * $Log: EstadoOrdenDAO.java,v $
 * Revision 1.22  2008/05/30 16:03:13  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.21  2006/11/27 13:03:36  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.20  2005/01/25 15:52:16  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.19  2004/06/15 20:56:14  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.18  2004/06/09 18:49:45  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.17  2004/03/25 18:18:50  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.16  2004/02/27 13:44:19  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.15  2003/12/04 17:19:11  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.14  2003/10/23 19:05:12  GPistoia
 * -Correccion de Mas vendidos
 * -Site.xml generado en español
 * -Agregado de direccion de mail para estadisticas
 *
 * Revision 1.13  2003/10/12 22:11:24  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.12  2003/10/07 14:52:17  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.11  2003/09/17 19:32:06  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.10  2003/09/16 18:58:46  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.9  2003/09/15 22:30:53  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.8  2003/09/05 19:56:27  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.7  2003/09/02 19:08:28  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.6  2003/08/29 17:54:21  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.5  2003/08/27 18:43:50  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.4  2003/08/12 16:25:26  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.3  2003/08/06 21:28:20  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.2  2003/08/02 16:58:07  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.1  2003/07/30 15:18:00  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 */
package com.tmk.kernel;

import java.io.Serializable;

public class EstadoOrdenDAO implements Serializable {

	private String id;
	private String nombre;
	private String descripcion;

	public EstadoOrdenDAO(String id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = Convert.toJavaScript(nombre, false);
		this.descripcion = Convert.toJavaScript(descripcion + " (Código " + id + ")", false);
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean equals(Object other) {
		return (super.equals(other)) ||
		        ((other instanceof EstadoOrdenDAO) && (((EstadoOrdenDAO) other)).id.equalsIgnoreCase(id));
	}

	public EstadoItemOrdenDAO estadoItemsRelacionado() {
		if (id.equalsIgnoreCase(Globals.ESTADO_ORDEN_APROBADA.getId())) {
			return Globals.ESTADOS_ITEM_ORDENES_APROBADO;
		}
		if (id.equalsIgnoreCase(Globals.ESTADO_ORDEN_RECHAZADA.getId())) {
			return Globals.ESTADOS_ITEM_ORDENES_RECHAZADO;
		}
		return null;
	}

	public boolean esEstadoFinal() {
		return (id.equalsIgnoreCase(Globals.ESTADO_ORDEN_APROBADA.getId())) ||
		        (id.equalsIgnoreCase(Globals.ESTADO_ORDEN_RECHAZADA.getId()) ||
		        (id.equalsIgnoreCase(Globals.ESTADO_ORDEN_VALIDACION_PAGO.getId())));
	}

	public boolean esPagoTarjetaInvalido() {
		return (id.equalsIgnoreCase(Globals.ESTADO_ORDEN_VALIDACION_PAGO.getId()));
	}

	public String toString() {
		return "Estado de la Orden (" + id + ") " + nombre;
	}

	public static EstadoOrdenDAO buscaEstadoOrden(String clave) {
		for (int i = 0; i < Globals.ESTADOS_ORDENES.length; i++) {
			if (Globals.ESTADOS_ORDENES[i].getId().equalsIgnoreCase(clave)) {
				return Globals.ESTADOS_ORDENES[i];
			}
		}
		return new EstadoOrdenDAO(clave, "Estado a verificar", "El estado no esta definido: " + clave);
	}

	static {
		new Daemon(Daemon.AHORA, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				try {
					Globals.ESTADOS_ORDENES = DBUtil.cargarEstadosDeOrden();

					Globals.ESTADO_ORDEN_EN_GENERACION = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_EN_GENERACION"));
					Globals.ESTADO_ORDEN_A_CONTROL_FRAUDE = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_A_CONTROL_FRAUDE"));
					Globals.ESTADO_ORDEN_DATOS_A_COMPLETAR = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_DATOS_A_COMPLETAR"));
					Globals.ESTADO_ORDEN_APROBADA = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_APROBADA"));
					Globals.ESTADO_ORDEN_RECHAZADA = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_RECHAZADA"));
					Globals.ESTADO_ORDEN_INICIA_LOGISTICA = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_INICIA_LOGISTICA"));
					Globals.ESTADO_ORDEN_ENVIADA_LOGISTICA = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_ENVIADA_LOGISTICA"));
					Globals.ESTADO_ORDEN_VALIDACION_PAGO = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_VALIDACION_PAGO"));
					Globals.ESTADO_ORDEN_APROBACION_DIRECTA = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_APROBACION_DIRECTA"));
					//Globals.ESTADO_ORDEN_CUPON_DE_PAGO = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_CUPON_DE_PAGO"));
					//Globals.ESTADO_ORDEN_DM = buscaEstadoOrden(DBUtil.getParameterString("ESTADO_ORDEN_DM"));	
				} catch (Exception e) {
					// Si falla reintentara cancelando la asignacion
					Globals.ESTADOS_ORDENES = null;
				}
			}

			protected String getMensaje() {
				return Globals.ESTADOS_ORDENES.length + " estados de orden.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento();
			}
		};
	}
}
