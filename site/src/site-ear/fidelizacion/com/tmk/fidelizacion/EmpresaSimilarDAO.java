/**
 * $Log: EmpresaSimilarDAO.java,v $
 * Revision 1.2  2004/06/15 20:56:06  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.1  2004/06/09 18:49:24  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.*;

import java.util.Vector;

public class EmpresaSimilarDAO {

	private String id;
	private String nombre;

	public EmpresaSimilarDAO(String id, String nombre) {
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
		return "Cliente de Empresa (" + id + ") " + nombre;
	}

	public static EmpresaSimilarDAO get(String key) {
		for (int i = 0; i < Globals.EMPRESAS_SIMILARES.length; i++) {
			EmpresaSimilarDAO temp = Globals.EMPRESAS_SIMILARES[i];
			if (temp.getId().equalsIgnoreCase(key)) {
				return temp;
			}
		}
		return Globals.EMPRESA_SIMILAR_OTRA;
	}

	public static String getDomain() {
		return "FDN_COMPRAS";
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Vector temp = DBUtil.cargarDatosGenericos(getDomain(), true);
				EmpresaSimilarDAO daos[] = new EmpresaSimilarDAO[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					Pair peer = (Pair) temp.get(i);
					daos[i] = new EmpresaSimilarDAO(peer.getValue1().toString(), peer.getValue2().toString());
				}
				Globals.EMPRESAS_SIMILARES = daos;
			}

			protected String getMensaje() {
				return Globals.EMPRESAS_SIMILARES.length + " empresas cargadas.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
			}
		};

	}
}
