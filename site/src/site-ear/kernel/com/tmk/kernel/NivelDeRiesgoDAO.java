/**
 * $Log: NivelDeRiesgoDAO.java,v $
 * Revision 1.12  2005/01/25 15:52:18  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.11  2004/06/15 20:56:16  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.10  2004/06/09 18:49:48  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.9  2003/12/04 17:19:14  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.8  2003/10/07 14:52:19  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.7  2003/09/17 19:32:08  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.6  2003/09/16 18:58:43  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.5  2003/09/11 18:08:45  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.4  2003/09/05 19:56:29  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.3  2003/09/02 19:08:29  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.2  2003/08/29 17:54:23  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.1  2003/08/27 18:43:52  GPistoia
 * -Comienzo Fraude
 *
 */
package com.tmk.kernel;

public class NivelDeRiesgoDAO {

	private int id;
	private String nombre;

	public NivelDeRiesgoDAO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = Convert.toJavaScript(nombre, false);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "Nivel de Riesgo (" + id + ") " + nombre;
	}

	public static NivelDeRiesgoDAO buscaNivelDeRiesgo(int clave) {
		for (int i = 0; i < Globals.NIVELES_DE_RIESGO.length; i++) {
			if (Globals.NIVELES_DE_RIESGO[i].getId() == clave) {
				return Globals.NIVELES_DE_RIESGO[i];
			}
		}
		return null;
	}

	public static NivelDeRiesgoDAO buscaNivelDeRiesgo(Integer clave) {
		return (clave == null) ? Globals.NIVEL_DE_RIESGO_NO_DISPONIBLE : buscaNivelDeRiesgo(clave.intValue());
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof NivelDeRiesgoDAO) &&
		        (id == ((NivelDeRiesgoDAO) other).id));
	}

	static {
		new Daemon(Daemon.DIEZ_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Globals.NIVELES_DE_RIESGO = DBUtil.cargarNivelesDeRiesgo();
			}

			protected String getMensaje() {
				return Globals.NIVELES_DE_RIESGO.length + " niveles de riesgo.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento();
			}
		};
	}

}
