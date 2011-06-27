package com.tmk.xml.dm.ipn.respuesta;

public class Reporte {
	public final static String ESTADO_CORRECTO = "1";
	public final static String ESTADO_XML_MAL_FORMADO = "2";
	public final static String ESTADO_NRO_DE_CUENTA_INVALIDO = "3";
	public final static String ESTADO_CLAVE_INVALIDA = "4";
	public final static String ESTADO_TIPO_DE_CONSULTA_INVALIDO = "5";
	public final static String ESTADO_ID_OPERACION_INVALIDO = "6";
	public final static String ESTADO_NRO_DE_CUENTA_O_CLAVE_INVALIDO = "7";
	public final static String ESTADO_SIN_OPERACIONES = "8";
	
	String estadoReporte;
	Detalle detalle;
	
	public String getEstadoReporte() {
		return this.estadoReporte;
	}
	
	public Detalle getDetalle() {
		return detalle;
	}
	
	public boolean esReporteCorrecto() {
		return Reporte.ESTADO_CORRECTO.equals(this.estadoReporte) || Reporte.ESTADO_ID_OPERACION_INVALIDO.equals(this.estadoReporte);
	}
	
/*
 * <REPORTE>
<ESTADOREPORTE></ ESTADOREPORTE >
<DETALLE>
<OPERACIONES>
<OPERACIÓN>
<ID></ID>
<FECHA></FECHA>
<ESTADO></ESTADO>
<COMPRADOR>
<EMAIL></EMAIL>
<DIRECCION></DIRECCION>
<COMENTARIO></COMENTARIO>
</COMPRADOR>
<MONTO></MONTO>
<MONTONETO></MONTONETO>
<METODOPAGO></METODOPAGO>
<ITEMS>
<ITEM>
<DESCRIPCION></DESCRIPCION>
<MONEDA></MONEDA>
<PRECIOUNITARIO></PRECIOUNITARIO>
<CANTIDAD></CANTIDAD>
</ITEM>
</ITEMS>
</OPERACIÓN>
</OPERACIONES>
</DETALLE>
</REPORTE>
 * 
 * */
}
