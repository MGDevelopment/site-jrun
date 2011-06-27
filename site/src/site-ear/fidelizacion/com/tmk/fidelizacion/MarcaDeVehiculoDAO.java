/**
 * $Log: MarcaDeVehiculoDAO.java,v $
 * Revision 1.3  2004/09/07 16:14:28  omsartori
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

public class MarcaDeVehiculoDAO {

    private String id;
    private String nombre;
    private ModeloDeVehiculoDAO modelos[];

    public MarcaDeVehiculoDAO(String id, String nombre) {
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
        return "Marca de vehiculo (" + id + ") " + nombre;
    }

    public static MarcaDeVehiculoDAO get(String key) {
        for (int i = 0; i < Globals.MARCAS_DE_VEHICULOS.length; i++) {
            MarcaDeVehiculoDAO temp = Globals.MARCAS_DE_VEHICULOS[i];
            if (temp.getId().equalsIgnoreCase(key)) {
                return temp;
            }
        }
        return null;
    }

    public ModeloDeVehiculoDAO[] getModelos() {
        if (modelos == null) {
            Vector temp = new Vector();
            for (int i = 0; i < Globals.MODELOS_DE_VEHICULOS.length; i++) {
                ModeloDeVehiculoDAO modeloDAO = Globals.MODELOS_DE_VEHICULOS[i];
                if (modeloDAO.getIdMarca().equalsIgnoreCase(id)) {
                    temp.add(modeloDAO);
                }
            }
            modelos = (ModeloDeVehiculoDAO[]) temp.toArray(new ModeloDeVehiculoDAO[temp.size()]);
        }
        return modelos;
    }

    static {
        new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UN_DIA) {
            protected void ejecutarTarea() throws Exception {
                final Vector temp = new Vector();
                DBUtil.getIdDescripcion(
                        //where agregado para evitar id_marca que contengan comillas simples
                        "SELECT id_marca, descripcion FROM fdn_marcas_vehiculos WHERE id_marca NOT LIKE '%''%'",
                        new DBUtil.ResultSetObserver() {
                            public void onRow(ResultSet resultSet) throws SQLException {
                                temp.add(
                                        new MarcaDeVehiculoDAO(
                                                resultSet.getString("id_marca"),
                                                resultSet.getString("descripcion")));
                            }
                        });
                Globals.MARCAS_DE_VEHICULOS = (MarcaDeVehiculoDAO[]) temp.toArray(new MarcaDeVehiculoDAO[temp.size()]);
            }

            protected String getMensaje() {
                return Globals.MARCAS_DE_VEHICULOS.length + " marcas de vehiculos.";
            }

            protected boolean pausada() {
                return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
            }
        };

    }
}

