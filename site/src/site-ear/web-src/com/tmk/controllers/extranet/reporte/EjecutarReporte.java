/**
 * $Log: EjecutarReporte.java,v $
 * Revision 1.2  2004/02/13 20:50:29  NRodriguez
 * - Manejo de estados de liquidacion en la extranet
 *
 * Revision 1.1  2004/02/03 03:06:52  NRodriguez
 * - nueva extranet
 *
 */
package com.tmk.controllers.extranet.reporte;

import com.tmk.kernel.Convert;
import com.tmk.controllers.extranet.reporte.ReporteHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class EjecutarReporte extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tipoReporte = Convert.toNumber(request.getParameter(ReporteHelper.TIPO_REPORTE), ReporteHelper.REPORTE_VISITAS);
		StringBuffer url = new StringBuffer(ReporteHelper.HOME_REPORTES);

		switch (tipoReporte) {
			case ReporteHelper.REPORTE_VISITAS:
				url.append("visitasPorDia.jsp?");
				break;
			case ReporteHelper.REPORTE_VENTAS:
				url.append("rankingVentas.jsp?");
				break;
			case ReporteHelper.REPORTE_PRODUCTO:
				url.append("ventasPorProducto.jsp?");
				break;
			case ReporteHelper.REPORTE_COBRADAS:
				url.append("comisionesLiquidadas.jsp?").append(ReporteHelper.ESTADO);
				url.append("=").append(ReporteHelper.COBRADAS);
				url.append("&");
				break;
			case ReporteHelper.REPORTE_LIQUIDADAS:
				url.append("comisionesLiquidadas.jsp?").append(ReporteHelper.ESTADO);
				url.append("=").append(ReporteHelper.PENDIENTES);
				url.append("&");
				break;
			case ReporteHelper.REPORTE_LIQUIDABLES:
				url.append("comisionesLiquidables.jsp");
				break;
		}

		if (tipoReporte != ReporteHelper.REPORTE_LIQUIDABLES) {
			url.append(ReporteHelper.FECHA_DESDE).append("=").append(request.getParameter(ReporteHelper.FECHA_DESDE));
			url.append("&");
			url.append(ReporteHelper.FECHA_HASTA).append("=").append(request.getParameter(ReporteHelper.FECHA_HASTA));
		}

		response.sendRedirect(url.toString());
	}
}
