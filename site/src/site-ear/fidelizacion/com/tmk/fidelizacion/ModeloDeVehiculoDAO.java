/**
 * $Log: ModeloDeVehiculoDAO.java,v $
 * Revision 1.4  2004/09/10 15:12:49  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.3  2004/09/07 16:14:29  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.2  2004/06/15 20:56:07  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.1  2004/06/09 18:49:26  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.*;

import java.util.Vector;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ModeloDeVehiculoDAO {

	private String idMarca;
	private String id;
	private String nombre;

	public ModeloDeVehiculoDAO(String marca, String id, String nombre) {
		super();
		this.idMarca = marca;
		this.id = id;
		this.nombre = Convert.toJavaScript(nombre, false);
	}

	public String getIdMarca() {
		return idMarca;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "Marca " + idMarca + ", modelo de vehiculo (" + id + ") " + nombre;
	}

	public static ModeloDeVehiculoDAO[] get(String marca) {
		Vector temp = new Vector();
		for (int i = 0; i < Globals.MODELOS_DE_VEHICULOS.length; i++) {
			ModeloDeVehiculoDAO item = Globals.MODELOS_DE_VEHICULOS[i];
			if (item.getIdMarca().equalsIgnoreCase(marca)) {
				temp.add(item);
			}
		}
		return (ModeloDeVehiculoDAO[]) temp.toArray(new ModeloDeVehiculoDAO[temp.size()]);
	}

	public static ModeloDeVehiculoDAO get(String marca, String key) {
		for (int i = 0; i < Globals.MODELOS_DE_VEHICULOS.length; i++) {
			ModeloDeVehiculoDAO temp = Globals.MODELOS_DE_VEHICULOS[i];
			if (temp.getIdMarca().equalsIgnoreCase(marca) && (temp.getId().equalsIgnoreCase(key))) {
				return temp;
			}
		}
		return null;
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				final Vector temp = new Vector();
				DBUtil.getIdDescripcion(
				        //where agregado para evitar id_modelo que contengan comillas simples
                        "SELECT id_marca, id_modelo, descripcion FROM fdn_modelos_vehiculos WHERE id_modelo NOT LIKE '%''%'",
                        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        temp.add(
						                new ModeloDeVehiculoDAO(
						                        resultSet.getString("id_marca"),
						                        resultSet.getString("id_modelo"),
						                        resultSet.getString("descripcion")));
					        }
				        });
				Globals.MODELOS_DE_VEHICULOS = (ModeloDeVehiculoDAO[]) temp.toArray(new ModeloDeVehiculoDAO[temp.size()]);
			}

			protected String getMensaje() {
				return Globals.MODELOS_DE_VEHICULOS.length + " modelos de vehiculos.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE) || (Globals.MARCAS_DE_VEHICULOS == null);
			}
		};

	}
}

