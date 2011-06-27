/**
 * $Log: MarcaDeCombustibleDAO.java,v $
 * Revision 1.2  2004/06/15 20:56:07  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.1  2004/06/09 18:49:25  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.*;

import java.util.Vector;

public class MarcaDeCombustibleDAO {

	private String id;
	private String nombre;

	public MarcaDeCombustibleDAO(String id, String nombre) {
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
		return "Marca de combustible (" + id + ") " + nombre;
	}

	public static MarcaDeCombustibleDAO get(String key) {
		for (int i = 0; i < Globals.MARCAS_DE_COMBUSTIBLE.length; i++) {
			MarcaDeCombustibleDAO temp = Globals.MARCAS_DE_COMBUSTIBLE[i];
			if (temp.getId().equalsIgnoreCase(key)) {
				return temp;
			}
		}
		return Globals.MARCAS_DE_COMBUSTIBLE_DEFECTO;
	}

	public static String getDomain() {
		return "FDN_MARCA_COMBUSTIBLE";
	}

	static {
		new Daemon(Daemon.TREINTA_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				Vector temp = DBUtil.cargarDatosGenericos(getDomain(), true);
				MarcaDeCombustibleDAO daos[] = new MarcaDeCombustibleDAO[temp.size()];
				for (int i = 0; i < temp.size(); i++) {
					Pair peer = (Pair) temp.get(i);
					daos[i] = new MarcaDeCombustibleDAO(peer.getValue1().toString(), peer.getValue2().toString());
				}
				Globals.MARCAS_DE_COMBUSTIBLE = daos;
			}

			protected String getMensaje() {
				return Globals.MARCAS_DE_COMBUSTIBLE.length + " marcas de combustible.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.FIDELIZACION_VIGENTE);
			}
		};

	}
}

