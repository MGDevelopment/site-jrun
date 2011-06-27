/**
 * $Log: LocalidadDAO.java,v $
 * Revision 1.20  2005/12/29 17:45:11  omsartori
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
 * Revision 1.19  2004/06/15 20:56:15  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.18  2004/02/16 20:22:55  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.17  2004/02/11 19:32:53  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.16  2003/12/04 17:19:13  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.15  2003/11/07 15:32:59  GPistoia
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
 * Revision 1.12  2003/10/03 16:29:04  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.11  2003/09/23 13:55:12  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.10  2003/09/17 19:32:07  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.9  2003/09/16 18:58:44  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.8  2003/09/11 18:08:45  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.7  2003/09/08 15:24:47  GPistoia
 * -Mejoras de pais-provincia-localidad terminadas
 *
 * Revision 1.6  2003/09/08 13:54:38  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.5  2003/08/29 17:54:22  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.4  2003/08/27 18:43:51  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.3  2003/08/12 16:25:27  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.2  2003/08/06 21:28:21  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.1  2003/08/02 16:58:11  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 */
package com.tmk.kernel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class LocalidadDAO {

	private int idPais;
	private int idProvincia;
	private int idLocalidad;
	private String nombre;

	public LocalidadDAO(int idPais, int idProvincia, int idLocalidad, String nombre) {
		super();
		this.idPais = idPais;
		this.idProvincia = idProvincia;
		this.idLocalidad = idLocalidad;
		this.nombre = Convert.toJavaScript(nombre, true);
	}

	public int getId() {
		return idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdPais() {
		return idPais;
	}

	public PaisDAO getPais() {
		return PaisDAO.getPais(idPais);
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public ProvinciaDAO getProvincia() {
		return PaisDAO.getPais(idPais).getProvincia(idProvincia);
	}

	public synchronized static void clearCaches() {
		ProvinciaDAO.clearCaches();
	}

	public String toString() {
		return "Localidad (" + idPais + ":" + idProvincia + ":" + idLocalidad + ") " + nombre;
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof LocalidadDAO) &&
		        (idPais == ((LocalidadDAO) other).idPais) &&
		        (idProvincia == ((LocalidadDAO) other).idProvincia) &&
		        (idLocalidad == ((LocalidadDAO) other).idLocalidad));

	}

	static {
		new Daemon(Daemon.CINCO_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				final Vector localidades = new Vector();
				DBUtil.getIdDescripcion(
				        "SELECT ID_PAIS, ID_PROVINCIA, ID_LOCALIDAD, DESCRIPCION FROM LOCALIDADES WHERE HABILITADO_TEMATIKA = 'S' "
				        + " AND NOT (ID_PAIS = 300 AND ID_PROVINCIA = 401 AND ID_LOCALIDAD = 3210) ORDER BY DESCRIPCION ",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        localidades.add(
						                new LocalidadDAO(
						                        resultSet.getInt("ID_PAIS"),
						                        resultSet.getInt("ID_PROVINCIA"),
						                        resultSet.getInt("ID_LOCALIDAD"),
						                        resultSet.getString("DESCRIPCION")));
					        }
				        });
				for (int i = 0; i < Globals.PAISES.length; i++) {
					PaisDAO paisDAO = Globals.PAISES[i];
					ProvinciaDAO provincias[] = paisDAO.getProvincias();
					for (int j = 0; j < provincias.length; j++) {
						ProvinciaDAO provinciaDAO = provincias[j];
						LocalidadDAO nueva = new LocalidadDAO(provinciaDAO.getIdPais(), provinciaDAO.getId(), Globals.CODIGO_OTRA_LOCALIDAD, "OTRA LOCALIDAD");
						localidades.add(nueva);
					}
				}
				Globals.LOCALIDADES = (LocalidadDAO[]) localidades.toArray(new LocalidadDAO[localidades.size()]);
				LocalidadDAO.clearCaches();
			}

			protected String getMensaje() {
				return Globals.LOCALIDADES.length + " localidades.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (Globals.PROVINCIAS == null);
			}
		};

	}
}
