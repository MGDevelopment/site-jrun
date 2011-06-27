/**
 * $Log: ItemDeCatalogoDAO.java,v $
 * Revision 1.8  2007/03/07 17:49:17  olsuarez
 * Correccion del catalogo de productos extra! para que
 * habilitara el link al detalle, solo a los productos disponibles en el sitio.
 *
 * Revision 1.7  2007/02/16 18:40:42  omsartori
 * - schedule de generacion de ranking y top de familias
 * - correccion bug paginacion de lista de deseos
 * - filtro de palabras para buscador
 * - estadisticas de homes, biografias e indices
 * - correccion de bug de aprobacion de comentarios
 *
 * Revision 1.6  2007/01/04 18:52:11  omsartori
 * - Detalle de articulo y paginas derivadas
 *
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
 * Revision 1.3  2004/06/15 20:56:06  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.2  2004/06/09 18:49:25  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.1  2004/05/04 18:09:31  oGPistoia
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

public class ItemDeCatalogoDAO {

	private int idCatalogo;
	private int idArticulo;
	private int puntos;
	private double importeAdicional;
	private boolean hastaAgotarStock;
	private Date fecha;
    private int categoria;
	private String titulo;
	private boolean habilitadoTematika;


	public ItemDeCatalogoDAO(int idCatalogo, int idArticulo, int puntos, double importeAdicional,
	                         boolean hastaAgotarStock, Date fecha, int categoria, String titulo, boolean habilitadoTematika) {
		super();
		this.idCatalogo = idCatalogo;
		this.idArticulo = idArticulo;
		this.puntos = puntos;
		this.importeAdicional = importeAdicional;
		this.hastaAgotarStock = hastaAgotarStock;
		this.fecha = fecha;
		this.categoria = categoria;
		this.titulo = Convert.corregir (titulo, true);
		this.habilitadoTematika = habilitadoTematika;
	}

	public int getIdCatalogo() {
		return idCatalogo;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public int getPuntos() {
		return puntos;
	}

	public double getImporteAdicional() {
		return importeAdicional;
	}

	public boolean esHastaAgotarStock() {
		return hastaAgotarStock;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getCategoria() {
		return categoria;
	}

	public String getTitulo() {
		return titulo;
	}
	public boolean esHabilitadoTematika() {
		return habilitadoTematika;
	}

	public boolean esNovedad() {
		Date fechaLimite = new Date();
        fechaLimite.setMonth(fechaLimite.getMonth() - 1 /* Es novedad si tiene menos de 1 mes */);
		return fechaLimite.before(fecha);
	}

	public String toString() {
		return "Item de Catalogo (" + idCatalogo + "), Articulo (" + idArticulo + ") Puntos " + puntos + " importe " +
		        importeAdicional + " hasta agotar stock " + Convert.toString(hastaAgotarStock) + (esNovedad() ? " [Novedad]" : "");
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof ItemDeCatalogoDAO) &&
		        (idCatalogo == ((ItemDeCatalogoDAO) other).idCatalogo) &&
		        (idArticulo == ((ItemDeCatalogoDAO) other).idArticulo));
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.SEIS_HORAS) {
			protected void ejecutarTarea() throws Exception {
				final Vector items = new Vector();
				DBUtil.getIdDescripcion(
				        "SELECT a.HABILITADO_TEMATIKA,cat.ID_CATALOGO, cat.ID_ARTICULO, cat.PUNTOS, cat.IMPORTE_ADICIONAL," +
						" cat.HASTA_STK_CERO, GREATEST(cat.F_ALTA, NVL(cat.F_MODI, cat.F_ALTA)) FECHA," +
						" a.categoria_seccion, a.titulo" +
						" FROM FDN_ITEMS_CATALOGOS cat" +
						" INNER JOIN articulos a" +
						" ON cat.id_articulo = a.id_articulo" +
						" WHERE HABILITADO = 'SI' AND MUESTRA_TMK ='SI' ORDER BY PUNTOS, IMPORTE_ADICIONAL",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        items.add(
						                new ItemDeCatalogoDAO(
						                        resultSet.getInt("ID_CATALOGO"),
						                        resultSet.getInt("ID_ARTICULO"),
						                        resultSet.getInt("PUNTOS"),
						                        resultSet.getDouble("IMPORTE_ADICIONAL"),
						                        Convert.toBoolean(resultSet.getString("HASTA_STK_CERO"), false),
						                        resultSet.getDate("FECHA"),
						                        resultSet.getInt("CATEGORIA_SECCION"),
						                        resultSet.getString("TITULO"),
						                        Convert.toBoolean(resultSet.getString("HABILITADO_TEMATIKA"), false)));
					        } 
				        });
				Globals.ITEMS_CATALOGOS = (ItemDeCatalogoDAO[]) items.toArray(new ItemDeCatalogoDAO[items.size()]);

				final Vector itemsDescripcion = new Vector();
				DBUtil.getIdDescripcion(
				        "SELECT a.HABILITADO_TEMATIKA, cat.ID_CATALOGO, cat.ID_ARTICULO, cat.PUNTOS, cat.IMPORTE_ADICIONAL," +
						" cat.HASTA_STK_CERO, GREATEST(cat.F_ALTA, NVL(cat.F_MODI, cat.F_ALTA)) FECHA," +
						" a.categoria_seccion, a.titulo" +
						" FROM FDN_ITEMS_CATALOGOS cat" +
						" INNER JOIN articulos a" +
						" ON cat.id_articulo = a.id_articulo" +
						" WHERE HABILITADO = 'SI' AND MUESTRA_TMK ='SI' ORDER BY a.titulo, PUNTOS, IMPORTE_ADICIONAL",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        itemsDescripcion.add(
						                new ItemDeCatalogoDAO(
						                        resultSet.getInt("ID_CATALOGO"),
						                        resultSet.getInt("ID_ARTICULO"),
						                        resultSet.getInt("PUNTOS"),
						                        resultSet.getDouble("IMPORTE_ADICIONAL"),
						                        Convert.toBoolean(resultSet.getString("HASTA_STK_CERO"), false),
						                        resultSet.getDate("FECHA"),
						                        resultSet.getInt("CATEGORIA_SECCION"),
						                        resultSet.getString("TITULO"),
						                        Convert.toBoolean(resultSet.getString("HABILITADO_TEMATIKA"), false)));
					        }
				        });
				Globals.ITEMS_CATALOGOS_DESCRIPCION = (ItemDeCatalogoDAO[]) itemsDescripcion.toArray(new ItemDeCatalogoDAO[items.size()]);

				final Vector itemsPesos = new Vector();
				DBUtil.getIdDescripcion(
						"SELECT a.HABILITADO_TEMATIKA,cat.ID_CATALOGO, cat.ID_ARTICULO, cat.PUNTOS, cat.IMPORTE_ADICIONAL," +
						" cat.HASTA_STK_CERO, GREATEST(cat.F_ALTA, NVL(cat.F_MODI, cat.F_ALTA)) FECHA," +
						" a.categoria_seccion, a.titulo" +
						" FROM FDN_ITEMS_CATALOGOS cat" +
						" INNER JOIN articulos a" +
						" ON cat.id_articulo = a.id_articulo" +
						" WHERE HABILITADO = 'SI' AND MUESTRA_TMK ='SI' ORDER BY IMPORTE_ADICIONAL, puntos",
						new DBUtil.ResultSetObserver() {
							public void onRow(ResultSet resultSet) throws SQLException {
								itemsPesos.add(
										new ItemDeCatalogoDAO(
												resultSet.getInt("ID_CATALOGO"),
												resultSet.getInt("ID_ARTICULO"),
												resultSet.getInt("PUNTOS"),
												resultSet.getDouble("IMPORTE_ADICIONAL"),
												Convert.toBoolean(resultSet.getString("HASTA_STK_CERO"), false),
												resultSet.getDate("FECHA"),
												resultSet.getInt("CATEGORIA_SECCION"),
						                        resultSet.getString("TITULO"),
						                        Convert.toBoolean(resultSet.getString("HABILITADO_TEMATIKA"), false)));

							}
						});
				Globals.ITEMS_CATALOGOS_PESOS = (ItemDeCatalogoDAO[]) itemsPesos.toArray(new ItemDeCatalogoDAO[items.size()]);

				CatalogoDAO.clearCaches();
			}

			protected String getMensaje() {
				return Globals.ITEMS_CATALOGOS.length + " items de catalogo.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE) || (Globals.CATALOGOS == null);
			}
		};
	}

}
