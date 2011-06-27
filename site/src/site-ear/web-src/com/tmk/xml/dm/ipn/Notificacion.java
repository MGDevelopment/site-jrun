package com.tmk.xml.dm.ipn;

import com.tmk.xml.dm.cupon.Collection;

public class Notificacion {
	private Integer tipoNotificacion;
	private Operacion operaciones [];
	
	public Integer getTipoNotificacion() {
		return tipoNotificacion;
	}
	
	public boolean esNotificacionDeCambioDeEstado() {
		return new Integer (1).equals(this.tipoNotificacion);
	}
	
	public Operacion[] getOperaciones() {
		return this.operaciones;
	}
	
	public boolean tieneResultados() {
		return (operaciones != null );
	}
	
	/*public Operacion getCollection(String id) throws Exception {
		for (int i=0; i<operaciones.length; i++) {
			if (operaciones[i].getId().equals(id)) {
				return operaciones[i];
			}
		}
		throw new Exception("No se encuentra la operacion " + id + " en el reporte");
	}*/
}
