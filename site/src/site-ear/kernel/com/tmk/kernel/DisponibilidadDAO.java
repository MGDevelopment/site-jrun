/**
 * $Log: DisponibilidadDAO.java,v $
 * Revision 1.22  2007/09/03 13:41:22  msartori
 * no message
 *
 * Revision 1.21  2006/10/09 13:05:36  omsartori
 * -Google Analitics SSL
 * -Docs EMPro 14,16
 * -Correccion bug de nota de regalo
 * -Reordenamiento de articulos luego de promo
 * -Mejora en seleccion de gasto de envio
 *
 * Revision 1.20  2006/09/28 14:57:32  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.19  2005/01/25 15:52:15  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.18  2004/09/10 15:12:53  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.17  2004/06/15 20:56:13  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.16  2004/06/09 18:49:44  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.15  2003/12/04 17:19:09  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.14  2003/11/07 15:32:57  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.13  2003/10/12 22:11:23  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.12  2003/10/07 14:52:15  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.11  2003/09/17 19:32:05  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.10  2003/09/16 18:58:48  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.9  2003/09/11 18:08:42  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.8  2003/09/09 13:28:31  GPistoia
 * -Cambio en tabla Disponibilidad
 * -Cambio en package Promocion
 * -Lista de paises-provincias-localidades
 *
 * Revision 1.7  2003/09/05 19:56:25  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.6  2003/09/04 21:39:27  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.5  2003/09/02 19:08:28  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.4  2003/08/29 17:54:21  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.3  2003/08/27 18:43:50  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.2  2003/08/12 16:25:25  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.1  2003/08/08 20:13:42  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 */
package com.tmk.kernel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DisponibilidadDAO {

	private int id;
	private String nombre;
	private boolean estaDisponible;

	public DisponibilidadDAO(int id, String nombre, boolean estaDisponible) {
		super();
		this.id = id;
		this.nombre = Convert.toJavaScript(nombre, false);
		this.estaDisponible = estaDisponible;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "Disponibilidad (" + id + ") " + nombre + " esta disponible: " + Convert.toString(estaDisponible);
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof DisponibilidadDAO) &&
		        (id == ((DisponibilidadDAO) other).id));
	}

	public boolean estaDisponible() {
		return estaDisponible;
	}

	public static DisponibilidadDAO buscaDisponibilidad(int idDisponibilidad) {
		for (int i = 0; i < Globals.DISPONIBILIDADES.length; i++) {
			if (Globals.DISPONIBILIDADES[i].getId() == idDisponibilidad) {
				return Globals.DISPONIBILIDADES[i];
			}
		}
		return Globals.DISPONIBILIDAD_DESCONOCIDA;
	}

	public static DisponibilidadDAO buscaDisponibilidad(Integer idDisponibilidad) {
		return (idDisponibilidad == null)
		        ? Globals.DISPONIBILIDAD_DESCONOCIDA
		        : buscaDisponibilidad(idDisponibilidad.intValue());
	}

	static {
		new Daemon(Daemon.DIEZ_SEGUNDOS, Daemon.UNA_HORA) {
			protected void ejecutarTarea() throws Exception {
				final Vector disponibilidades = new Vector();
				// WHERE ID_ESQUEMA = 'PROD'"
				DBUtil.getIdDescripcion(
				        "SELECT ID_DISPONIBILIDAD, DESCRIPCION, PEDIDO_ESPECIAL FROM DISPONIBILIDADES WHERE ID_ESQUEMA = 'PROD'",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        disponibilidades.add(
						                new DisponibilidadDAO(
						                        resultSet.getInt("ID_DISPONIBILIDAD"),
						                        resultSet.getString("DESCRIPCION"),
						                        "N".equalsIgnoreCase(resultSet.getString("PEDIDO_ESPECIAL"))));
					        }
				        });
				Globals.DISPONIBILIDADES = (DisponibilidadDAO[]) disponibilidades.toArray(new DisponibilidadDAO[disponibilidades.size()]);
			}

			protected String getMensaje() {
				return Globals.DISPONIBILIDADES.length + " disponibilidades.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento();
			}
		};
	}

}
