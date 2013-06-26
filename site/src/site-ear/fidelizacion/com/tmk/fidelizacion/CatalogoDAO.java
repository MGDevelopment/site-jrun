/**
 * $Log: CatalogoDAO.java,v $
 * Revision 1.5  2006/03/30 14:42:39  omsartori
 * - catalogo extra nuevo (deshabilitado:falta diseño)
 * - Correccion de orden interpretes
 * - Resaltado de busqueda
 * - recordar las palabras  en busquedas fallidas o sin resultados
 *
 * Revision 1.4  2004/11/30 22:19:15  oGPistoia
 * - Aplicacion de las reglas de estados de articulos
 * - Agregado de las novedades en el catalogo de eXtra
 *
 * Revision 1.3  2004/06/15 20:56:05  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.2  2004/06/09 18:49:21  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.1  2004/05/04 18:09:30  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;

import java.util.Vector;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogoDAO {

	private int id;
	private String nombre;
	private String categoria;
	private Date fechaInicio;

	private ItemDeCatalogoDAO items[];
	private ItemDeCatalogoDAO itemsDescripcion[];
	private ItemDeCatalogoDAO itemsPesos[];


	public CatalogoDAO(int id, String nombre, String categoria, Date fechaInicio) {
		super();
		this.id = id;
		this.nombre = Convert.toJavaScript(nombre, true);
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
	}

	public synchronized static void clearCaches() {
		if (Globals.CATALOGOS != null) {
		//	for (int i = 0; i < Globals.CATALOGOS.length; i++) {
			//	Globals.CATALOGOS[i].clearCache();
		//	}
		Globals.CATALOGOS.clearCache();
		}
	}

	public synchronized void clearCache() {
		items = null;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public ItemDeCatalogoDAO[] getItems() {
		if (items == null) {
			Vector temp = new Vector();
			for (int i = 0; i < Globals.ITEMS_CATALOGOS.length; i++) {
				ItemDeCatalogoDAO itemsDAO = Globals.ITEMS_CATALOGOS[i];
				if (itemsDAO.getIdCatalogo() == id) {
					temp.add(itemsDAO);
				}
			}

			items = (ItemDeCatalogoDAO[]) temp.toArray(new ItemDeCatalogoDAO[temp.size()]);
		}

		return items;
	}

	public ItemDeCatalogoDAO[] getItemsPesos() {
		if (itemsPesos == null) {
			Vector temp = new Vector();
			for (int i = 0; i < Globals.ITEMS_CATALOGOS_PESOS.length; i++) {
				ItemDeCatalogoDAO itemsDAO = Globals.ITEMS_CATALOGOS_PESOS[i];
				if (itemsDAO.getIdCatalogo() == id) {
					temp.add(itemsDAO);
				}
			}
			itemsPesos = (ItemDeCatalogoDAO[]) temp.toArray(new ItemDeCatalogoDAO[temp.size()]);
		}
		return itemsPesos;
	}

	public ItemDeCatalogoDAO[] getItemsDescripcion() {
			if (itemsDescripcion == null) {
				Vector temp = new Vector();
				for (int i = 0; i < Globals.ITEMS_CATALOGOS_DESCRIPCION.length; i++) {
					ItemDeCatalogoDAO itemsDAO = Globals.ITEMS_CATALOGOS_DESCRIPCION[i];
					if (itemsDAO.getIdCatalogo() == id) {
						temp.add(itemsDAO);
					}
				}
				itemsDescripcion = (ItemDeCatalogoDAO[]) temp.toArray(new ItemDeCatalogoDAO[temp.size()]);
			}
			return itemsDescripcion;
		}


	public ItemDeCatalogoDAO[] getItemsNovedad() {
		Vector temp = new Vector();
		for (int i = 0; i < Globals.ITEMS_CATALOGOS.length; i++) {
			ItemDeCatalogoDAO itemsDAO = Globals.ITEMS_CATALOGOS[i];
			if ((itemsDAO.getIdCatalogo() == id) && (itemsDAO.esNovedad())) {
				temp.add(itemsDAO);
			}
		}
		return (ItemDeCatalogoDAO[]) temp.toArray(new ItemDeCatalogoDAO[temp.size()]);
	}

	/*public static final CatalogoDAO getCatalogo(int clave) {
		for (int i = 0; i < Globals.CATALOGOS.length; i++) {
			if (Globals.CATALOGOS[i].getId() == clave) {
				return Globals.CATALOGOS[i];
			}
		}
		return Globals.SIN_CATALOGO;
	}*/

	/*public static final CatalogoDAO getCatalogo(Integer clave) {
		return (clave == null) ? null : getCatalogo(clave.intValue());
	}*/

	public String toString() {
		return "Catalogo (" + id + ") " + nombre + " desde el " + Convert.toString(fechaInicio);
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof CatalogoDAO) &&
		        (id == ((CatalogoDAO) other).id));
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.SEIS_HORAS) {
			protected void ejecutarTarea() throws Exception {
				final Vector catalogo = new Vector();
				DBUtil.getIdDescripcion(
				        "SELECT ID_CATALOGO, DESCRIPCION, ID_CATEGORIA, HABILITADO_FECHA FROM FDN_CATALOGOS WHERE HABILITADO = 'SI'",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        catalogo.add(
						                new CatalogoDAO(
						                        resultSet.getInt("ID_CATALOGO"),
						                        resultSet.getString("DESCRIPCION"),
						                        resultSet.getString("ID_CATEGORIA"),
						                        resultSet.getDate("HABILITADO_FECHA")));
					        }
				        });
				// FIX mgoldsman 12/07/2011
				if (catalogo != null && !catalogo.isEmpty()) {
					Globals.CATALOGOS = (CatalogoDAO)catalogo.get(0); //(CatalogoDAO[]) catalogo.toArray(new CatalogoDAO[catalogo.size()]);
					CatalogoDAO.clearCaches();
				}
			}

			protected String getMensaje() {
				//return Globals.CATALOGOS.length + " catalogo(s).";
				return "se cargo el catalogo";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
			}
		};
	}

}
