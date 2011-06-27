/**
 * $Log: EstadoItemOrdenDAO.java,v $
 * Revision 1.12  2005/01/25 15:52:16  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.11  2004/06/15 20:56:13  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.10  2004/06/09 18:49:45  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.9  2004/02/27 13:44:19  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.8  2003/12/04 17:19:11  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.7  2003/10/12 22:11:23  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.6  2003/10/07 14:52:16  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.5  2003/09/17 19:32:06  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.4  2003/09/16 18:58:47  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.3  2003/09/11 18:08:43  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.2  2003/09/05 19:56:26  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.1  2003/09/04 21:39:28  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 */
package com.tmk.kernel;

import java.io.Serializable;

public class EstadoItemOrdenDAO implements Serializable {

	private String id;
	private String nombre;

	public EstadoItemOrdenDAO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = Convert.toJavaScript(nombre, false);
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean equals(Object other) {
		return (super.equals(other)) ||
		        ((other instanceof EstadoItemOrdenDAO) && (((EstadoItemOrdenDAO) other)).id.equalsIgnoreCase(id));
	}

	public String toString() {
		return "Estado del item de la Orden (" + id + ") " + nombre;
	}

	public static EstadoItemOrdenDAO buscaEstadoItemOrden(String clave) {
		for (int i = 0; i < Globals.ESTADOS_ITEM_ORDENES.length; i++) {
			if (Globals.ESTADOS_ITEM_ORDENES[i].getId().equalsIgnoreCase(clave)) {
				return Globals.ESTADOS_ITEM_ORDENES[i];
			}
		}
		return new EstadoItemOrdenDAO(clave, "Estado a verificar");
	}

	static {
		new Daemon(Daemon.AHORA, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {

				try {
					Globals.ESTADOS_ITEM_ORDENES = DBUtil.cargarEstadosItemDeOrden();

					Globals.ESTADOS_ITEM_ORDENES_APROBADO  = buscaEstadoItemOrden(DBUtil.getParameterString("ESTADOS_ITEM_ORDENES_APROBADO"));
					Globals.ESTADOS_ITEM_ORDENES_RECHAZADO = buscaEstadoItemOrden(DBUtil.getParameterString("ESTADOS_ITEM_ORDENES_RECHAZADO"));

				} catch (Exception e) {
					Globals.ESTADOS_ITEM_ORDENES = null;
				}
			}

			protected String getMensaje() {
				return Globals.ESTADOS_ITEM_ORDENES.length + " estados de item de orden.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento();
			}
		};
	}
}
