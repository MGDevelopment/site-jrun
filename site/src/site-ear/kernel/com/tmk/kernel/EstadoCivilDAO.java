/**
 * $Log: EstadoCivilDAO.java,v $
 * Revision 1.21  2004/06/15 20:56:13  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.20  2004/06/09 18:49:44  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.19  2003/12/11 20:52:05  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.18  2003/12/04 17:19:10  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.17  2003/11/07 15:32:57  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.16  2003/11/03 20:57:51  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.15  2003/10/12 22:11:23  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.14  2003/10/07 14:52:16  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.13  2003/09/17 19:32:05  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.12  2003/09/16 18:58:47  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.11  2003/09/11 18:08:42  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.10  2003/09/05 19:56:26  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.9  2003/09/04 21:39:28  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.8  2003/08/29 17:54:21  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.7  2003/08/27 18:43:50  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.6  2003/08/12 16:25:26  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.5  2003/08/11 14:26:42  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.4  2003/08/06 21:28:20  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.3  2003/08/02 16:58:06  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.2  2003/07/30 15:18:00  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.1  2003/07/28 19:21:27  GPistoia
 * -Controlador de registracion
 *
 */
package com.tmk.kernel;

import java.util.Vector;

public class EstadoCivilDAO {

	private String id;
	private String nombre;

	public EstadoCivilDAO(String id, String nombre) {
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

	public String toString() {
		return "Estado Civil (" + id + ") " + nombre;
	}

	public static EstadoCivilDAO getEstadoCivil(String key) {
		for (int i = 0; i < Globals.ESTADOS_CIVILES.length; i++) {
			EstadoCivilDAO temp = Globals.ESTADOS_CIVILES[i];
			if (temp.getId().equalsIgnoreCase(key)) {
				return temp;
			}
		}
		return Globals.ESTADO_CIVIL_SOLTERO;
	}

	static {
		new Daemon(Daemon.DIEZ_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Vector temp = DBUtil.cargarDatosGenericos("ESTADO_CIVIL", false);
				EstadoCivilDAO estadoCivil[] = new EstadoCivilDAO[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					Pair peer = (Pair) temp.get(i);
					estadoCivil[i] = new EstadoCivilDAO(peer.getValue1().toString(), peer.getValue2().toString());
				}
				Globals.ESTADOS_CIVILES = estadoCivil;
			}

			protected String getMensaje() {
				return Globals.ESTADOS_CIVILES.length + " estados civiles.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento();
			}
		};

	}
}
