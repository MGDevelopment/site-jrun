/**
 * $Log: TarjetaDePuntajeDAO.java,v $
 * Revision 1.2  2004/06/15 20:56:09  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.1  2004/06/09 18:49:40  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.*;

import java.util.Vector;

public class TarjetaDePuntajeDAO {

	private String id;
	private String nombre;

	public TarjetaDePuntajeDAO(String id, String nombre) {
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
		return "Tarjeta de puntaje (" + id + ") " + nombre;
	}

	public static TarjetaDePuntajeDAO get(String key) {
		for (int i = 0; i < Globals.TARJETAS_DE_PUNTAJE.length; i++) {
			TarjetaDePuntajeDAO temp = Globals.TARJETAS_DE_PUNTAJE[i];
			if (temp.getId().equalsIgnoreCase(key)) {
				return temp;
			}
		}
		return null;
	}

	public static String getDomain() {
		return "FDN_TARJ_PUNTAJE";
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Vector temp = DBUtil.cargarDatosGenericos(getDomain(), true);
				TarjetaDePuntajeDAO daos[] = new TarjetaDePuntajeDAO[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					Pair peer = (Pair) temp.get(i);
					daos[i] = new TarjetaDePuntajeDAO(peer.getValue1().toString(), peer.getValue2().toString());
				}
				Globals.TARJETAS_DE_PUNTAJE = daos;
			}

			protected String getMensaje() {
				return Globals.TARJETAS_DE_PUNTAJE.length + " tarjetas de puntaje.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
			}
		};

	}
}
