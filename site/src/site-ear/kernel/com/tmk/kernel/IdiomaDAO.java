/**
 * $Log: IdiomaDAO.java,v $
 * Revision 1.19  2005/01/25 15:52:17  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.18  2004/06/15 20:56:15  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.17  2004/06/09 18:49:47  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.16  2003/12/04 17:19:13  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.15  2003/11/07 15:32:58  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.14  2003/10/12 22:11:25  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.13  2003/10/07 14:52:18  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.12  2003/09/17 19:32:07  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.11  2003/09/16 18:58:45  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.10  2003/09/11 18:08:44  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.9  2003/09/05 19:56:28  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.8  2003/08/29 17:54:22  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.7  2003/08/27 18:43:51  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.6  2003/08/12 16:25:27  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.5  2003/08/11 14:26:43  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.4  2003/08/06 21:28:21  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.3  2003/08/02 16:58:11  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.2  2003/07/30 15:18:02  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.1  2003/07/26 19:06:08  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel;

import java.util.Vector;

public class IdiomaDAO {

	private String id;
	private String nombre;

	public IdiomaDAO(String id, String nombre) {
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

	public boolean consultarEnFidelizacion() {
		return (Convert.toString(Globals.FDN_FORMULARIO_IDIOMAS).indexOf(id) >= 0);

	}

	public String toString() {
		return "Idioma (" + id + ") " + nombre;
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof IdiomaDAO) &&
		        (id.equals(((IdiomaDAO) other).id)));
	}

	public static String getDomain() {
		return "IDIOMA";
	}

	public static IdiomaDAO buscaIdioma(String clave) {
		for (int i = 0; i < Globals.IDIOMAS.length; i++) {
			if (Globals.IDIOMAS[i].getId().equalsIgnoreCase(clave)) {
				return Globals.IDIOMAS[i];
			}
		}
		return null;
	}

	static {
		new Daemon(Daemon.VEINTE_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Vector temp = DBUtil.cargarDatosGenericos(getDomain(), true);
				IdiomaDAO idioma[] = new IdiomaDAO[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					Pair peer = (Pair) temp.get(i);
					idioma[i] = new IdiomaDAO(peer.getValue1().toString(), peer.getValue2().toString());
				}
				Globals.IDIOMAS = idioma;
			}

			protected String getMensaje() {
				return Globals.IDIOMAS.length + " idiomas.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento();
			}
		};
	}
}
