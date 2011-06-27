/**
 * $Log: OcupacionDAO.java,v $
 * Revision 1.2  2004/06/15 20:56:08  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.1  2004/06/09 18:49:27  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.*;

import java.util.Vector;

/**
 * Por alguna razon crearon el programa y repitieron esto de la tabla de profesiones, muy inteligente por cierto
 */
public class OcupacionDAO {

	private String id;
	private String nombre;

	public OcupacionDAO(String id, String nombre) {
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
		return "Ocupacion (" + id + ") " + nombre;
	}

	public static OcupacionDAO get(String key) {
		for (int i = 0; i < Globals.OCUPACIONES.length; i++) {
			OcupacionDAO temp = Globals.OCUPACIONES[i];
			if (temp.getId().equalsIgnoreCase(key)) {
				return temp;
			}
		}
		return Globals.OCUPACION_OTRA;
	}

	public static String getDomain() {
		return "FDN_OCUPACION";
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Vector temp = DBUtil.cargarDatosGenericos(getDomain(), true);
				OcupacionDAO daos[] = new OcupacionDAO[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					Pair peer = (Pair) temp.get(i);
					daos[i] = new OcupacionDAO(peer.getValue1().toString(), peer.getValue2().toString());
				}
				Globals.OCUPACIONES = daos;
			}

			protected String getMensaje() {
				return Globals.OCUPACIONES.length + " ocupaciones.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
			}
		};

	}
}
