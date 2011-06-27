package com.tmk.xml.dm.ipn.respuesta;

public class Detalle {
	private Operacion [] operaciones;
	
	public Operacion [] getOperaciones() {
		return this.operaciones;
	}
	
	public Operacion getOperacion(String id) throws Exception {
		for (int i=0; i<operaciones.length; i++) {
			if (operaciones[i].getId().equals(id)) {
				return operaciones[i];
			}
		}
		throw new Exception("No se encuentra la orden " + id + " en el reporte");
	}
	
	
}
