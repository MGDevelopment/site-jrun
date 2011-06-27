/**
 * $Log: ReglasDePuntosDAO.java,v $
 * Revision 1.4  2007/04/26 18:32:11  omsartori
 * no message
 *
 * Revision 1.3  2004/09/23 18:44:42  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.2  2004/06/15 20:56:08  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.1  2004/06/09 18:49:31  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;

import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReglasDePuntosDAO {

	private int id;
	private String nombre;
	private int puntos;

	public ReglasDePuntosDAO(int id, String nombre, int puntos) {
		super();
		this.id = id;
		this.nombre = Convert.toJavaScript(nombre, true);
		this.puntos = puntos;
	}

	public int getId() {
		return id;
	}

	public Integer getIdRegla() {
		return new Integer(id);
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public static final ReglasDePuntosDAO getRegla(int clave) {
		for (int i = 0; i < Globals.REGLAS_DE_PUNTOS.length; i++) {
			if (Globals.REGLAS_DE_PUNTOS[i].getId() == clave) {
				return Globals.REGLAS_DE_PUNTOS[i];
			}
		}
		return null; // Puede no recornar ninguna regla
	}

	public String toString() {
		return "Regla " + id + ": " + nombre + " da " + Convert.toString(puntos) + " puntos";
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof ReglasDePuntosDAO) &&
		        (id == ((ReglasDePuntosDAO) other).id));
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UNA_HORA) {
			protected void ejecutarTarea() throws Exception {
				final Vector temp = new Vector();
				DBUtil.getIdDescripcion(
				        "SELECT r.id_regla id, r.descripcion, rp.puntos" +
						" FROM fdn_reglas r, fdn_reglas_puntos rp" +
						" WHERE r.id_regla = rp.id_regla" +
						"   AND NVL (vigencia_desde, SYSDATE) <= TRUNC (SYSDATE)" +
						"   AND NVL (vigencia_hasta, SYSDATE) >= TRUNC (SYSDATE)" +
						"   AND habilitado = 'SI'",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        temp.add(
						                new ReglasDePuntosDAO(
						                        resultSet.getInt("id"),
						                        resultSet.getString("descripcion"),
						                        resultSet.getInt("puntos")));
					        }
				        });
				Globals.REGLAS_DE_PUNTOS = (ReglasDePuntosDAO[]) temp.toArray(new ReglasDePuntosDAO[temp.size()]);
				Globals.REGLA_FDN_POR_ADHESION = getRegla(Globals.FDN_REGLA_ADHESION_FIDELIZACION);
				Globals.REGLA_FDN_POR_DATOS_COMPLEMENTARIOS = getRegla(Globals.FDN_REGLA_ADHESION_COMPLEMENTARIOS);
				Globals.REGLA_FDN_POR_ACTUALIZACION = getRegla(Globals.FDN_REGLA_ACTUALIZACION);
			}

			protected String getMensaje() {
				return Globals.REGLAS_DE_PUNTOS.length + " reglas, " + Globals.REGLA_FDN_POR_ADHESION +
				        ", " + Globals.REGLA_FDN_POR_DATOS_COMPLEMENTARIOS;
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
			}
		};
	}

}
