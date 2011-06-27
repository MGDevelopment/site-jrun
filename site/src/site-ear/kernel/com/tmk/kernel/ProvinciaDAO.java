/**
 * $Log: ProvinciaDAO.java,v $
 * Revision 1.22  2004/06/15 20:56:17  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.21  2004/02/16 20:22:58  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.20  2004/02/11 19:32:54  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.19  2003/12/04 17:19:15  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.18  2003/11/07 15:33:00  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.17  2003/10/12 22:11:27  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.16  2003/10/07 14:52:20  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.15  2003/10/03 16:29:06  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.14  2003/09/23 13:55:13  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.13  2003/09/17 19:32:09  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.12  2003/09/16 18:58:42  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.11  2003/09/11 18:08:46  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.10  2003/09/08 15:24:48  GPistoia
 * -Mejoras de pais-provincia-localidad terminadas
 *
 * Revision 1.9  2003/09/08 13:54:38  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.8  2003/09/05 19:56:31  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.7  2003/08/29 17:54:25  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.6  2003/08/27 18:43:53  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.5  2003/08/12 16:25:29  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.4  2003/08/06 21:28:23  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.3  2003/08/02 16:58:14  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.2  2003/07/30 15:18:03  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.1  2003/07/26 19:06:09  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProvinciaDAO {

	private int idPais;
	private int idProvincia;
	private String nombre;
	private LocalidadDAO localidades[];

	public ProvinciaDAO(int idPais, int idProvincia, String nombre) {
		super();
		this.idPais = idPais;
		this.idProvincia = idProvincia;
		this.nombre = Convert.toJavaScript(nombre, true);
	}

	public int getId() {
		return idProvincia;
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

	public synchronized static void clearCaches() {
		if (Globals.PROVINCIAS != null) {
			for (int i = 0; i < Globals.PROVINCIAS.length; i++) {
				Globals.PROVINCIAS[i].clearCache();
			}
			PaisDAO.clearCaches();
		}
	}

	public synchronized void clearCache() {
		localidades = null;
	}

	public synchronized LocalidadDAO[] getLocalidades() {
		if (localidades == null) {
			Vector temp = new Vector();
			for (int i = 0; i < Globals.LOCALIDADES.length; i++) {
				LocalidadDAO localidadDAO = Globals.LOCALIDADES[i];
				if ((localidadDAO.getIdPais() == idPais) && (localidadDAO.getIdProvincia() == idProvincia)) {
					temp.add(localidadDAO);
				}
			}
			localidades = (LocalidadDAO[]) temp.toArray(new LocalidadDAO[temp.size()]);
		}
		return localidades;
	}

	public LocalidadDAO getLocalidad(Integer localidad) {
		return (localidad == null) ? getOtraLocalidad() : getLocalidad(localidad.intValue());
	}

	public LocalidadDAO getLocalidad(int localidad) {
		LocalidadDAO temp[] = getLocalidades();
		for (int i = 0; i < temp.length; i++) {
			LocalidadDAO localidadDAO = temp[i];
			if (localidadDAO.getId() == localidad) {
				return localidadDAO;
			}
		}
		return getOtraLocalidad();
	}

	private LocalidadDAO getOtraLocalidad() {
		return new LocalidadDAO(idPais, idProvincia, Globals.CODIGO_OTRA_LOCALIDAD, "LOCALIDAD NO ESPECIFICADA");
	}

	public String toString() {
		return "Provincia (" + idPais + ":" + idProvincia + ") " + nombre;
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof ProvinciaDAO) &&
		        (idPais == ((ProvinciaDAO) other).idPais) &&
		        (idProvincia == ((ProvinciaDAO) other).idProvincia));
	}

	static {
		new Daemon(Daemon.CINCO_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				final Vector provincias = new Vector();
				DBUtil.getIdDescripcion(
				        "SELECT ID_PAIS, ID_PROVINCIA, DESCRIPCION FROM PROVINCIAS WHERE HABILITADO_TEMATIKA = 'S' ORDER BY DESCRIPCION",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        provincias.add(
						                new ProvinciaDAO(
						                        resultSet.getInt("ID_PAIS"),
						                        resultSet.getInt("ID_PROVINCIA"),
						                        resultSet.getString("DESCRIPCION")));
					        }
				        });
				for (int i = 0; i < Globals.PAISES.length; i++) {
					PaisDAO paisDAO = Globals.PAISES[i];
					if (paisDAO.getId() != Globals.ARGENTINA.getId()) {
						ProvinciaDAO nueva = new ProvinciaDAO(paisDAO.getId(), Globals.CODIGO_OTRA_PROVINCIA, "OTRA PROVINCIA");
						provincias.add(nueva);
					}
				}
				Globals.PROVINCIAS = (ProvinciaDAO[]) provincias.toArray(new ProvinciaDAO[provincias.size()]);
				ProvinciaDAO.clearCaches();
			}

			protected String getMensaje() {
				return Globals.PROVINCIAS.length + " provincias.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (Globals.PAISES == null);
			}
		};

	}

}
