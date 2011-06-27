/**
 * $Log: SistemaTVDAO.java,v $
 * Revision 1.2  2004/06/15 20:56:09  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.1  2004/06/09 18:49:32  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.*;

import java.util.Vector;

public class SistemaTVDAO {

	private String id;
	private String nombre;

	public SistemaTVDAO(String id, String nombre) {
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
		return "Sistemas de TV (" + id + ") " + nombre;
	}

	public static SistemaTVDAO get(String key) {
		for (int i = 0; i < Globals.SISTEMA_TV.length; i++) {
			SistemaTVDAO temp = Globals.SISTEMA_TV[i];
			if (temp.getId().equalsIgnoreCase(key)) {
				return temp;
			}
		}
		return Globals.SISTEMA_TV_NINGUNO;
	}

	public static String getDomain() {
		return "FDN_TV_PAGO";
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Vector temp = DBUtil.cargarDatosGenericos(getDomain(), true);
				SistemaTVDAO daos[] = new SistemaTVDAO[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					Pair peer = (Pair) temp.get(i);
					daos[i] = new SistemaTVDAO(peer.getValue1().toString(), peer.getValue2().toString());
				}
				Globals.SISTEMA_TV = daos;
			}

			protected String getMensaje() {
				return Globals.SISTEMA_TV.length + " sistemas de tv.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
			}
		};

	}
}
