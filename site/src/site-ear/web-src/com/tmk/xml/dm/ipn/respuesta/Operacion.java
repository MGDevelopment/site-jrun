package com.tmk.xml.dm.ipn.respuesta;

public class Operacion {
	public final static String ESTADO_PENDIENTE_DE_PAGO = "1";
	public final static String ESTADO_ACREDITADO = "2";
	public final static String ESTADO_CANCELADO = "3";
	
	public final static String MEDIO_FONDOS_DM = "1";
	public final static String MEDIO_RED_PAGO = "2";
	public final static String MEDIO_TARJETA_CREDITO = "3";
	public final static String MEDIO_TRANSFERENCIA = "4";
	
	
	String id;
	String fecha;
	String estado;
	String monto;
	String montoNeto;
	String metodoPago;
	
	public String getId() {
		return id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getMonto() {
		return monto;
	}
	
	public String getMontoNeto() {
		return montoNeto;
	}
	
	public String getMetodoPago() {
		return metodoPago;
	}
}
