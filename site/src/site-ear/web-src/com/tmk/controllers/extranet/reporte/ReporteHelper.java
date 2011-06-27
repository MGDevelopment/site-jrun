/**
 * $Log: ReporteHelper.java,v $
 * Revision 1.2  2004/02/13 20:50:28  NRodriguez
 * - Manejo de estados de liquidacion en la extranet
 *
 * Revision 1.1  2004/02/03 03:06:51  NRodriguez
 * - nueva extranet
 *
 */
package com.tmk.controllers.extranet.reporte;

public class ReporteHelper {
	public static final String HOME_REPORTES = "/extranet/reportes/";

	public static final String FECHA_DESDE = "fechaDesde";
	public static final String FECHA_HASTA = "fechaHasta";

	public static final String TIPO_REPORTE = "tipoReporte";

	public static final String ESTADO = "estado";
	public static final String ID_LIQUIDACION = "idLiquidacion";

	public static final int COBRADAS = 1;
	public static final int PENDIENTES = 2;

	public static final int REPORTE_VISITAS = 1;
	public static final int REPORTE_VENTAS = 2;
	public static final int REPORTE_PRODUCTO = 3;
	public static final int REPORTE_LIQUIDADAS = 4;
	public static final int REPORTE_COBRADAS = 5;
	public static final int REPORTE_LIQUIDABLES = 6;
}
