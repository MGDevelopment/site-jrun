/**
 * $Log: TelefonoCelularDAO.java,v $
 * Revision 1.2  2004/06/15 20:56:10  oGPistoia
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

public class TelefonoCelularDAO {

	private String id;
	private String nombre;

	public TelefonoCelularDAO(String id, String nombre) {
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
		return "Telefono celular (" + id + ") " + nombre;
	}

	public static TelefonoCelularDAO get(String key) {
		for (int i = 0; i < Globals.TELEFONOS_CELULARES.length; i++) {
			TelefonoCelularDAO temp = Globals.TELEFONOS_CELULARES[i];
			if (temp.getId().equalsIgnoreCase(key)) {
				return temp;
			}
		}
		return null;
	}

	public static String getDomain() {
		return "FDN_CELULAR";
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Vector temp = DBUtil.cargarDatosGenericos(getDomain(), false);
				TelefonoCelularDAO daos[] = new TelefonoCelularDAO[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					Pair peer = (Pair) temp.get(i);
					daos[i] = new TelefonoCelularDAO(peer.getValue1().toString(), peer.getValue2().toString());
				}
				Globals.TELEFONOS_CELULARES = daos;
			}

			protected String getMensaje() {
				return Globals.TELEFONOS_CELULARES.length + " telefonos celulares.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
			}
		};

	}
}
