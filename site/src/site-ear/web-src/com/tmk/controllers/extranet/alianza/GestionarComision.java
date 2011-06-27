/**
 * $Log: GestionarComision.java,v $
 * Revision 1.2  2004/02/13 20:51:08  NRodriguez
 * - Manejo de estados de liquidacion en la extranet
 *
 * Revision 1.1  2004/02/03 03:07:13  NRodriguez
 * - nueva extranet
 *
 */
package com.tmk.controllers.extranet.alianza;

import com.tmk.kernel.*;
import com.tmk.controllers.extranet.alianza.AlianzaHelper;
import com.tmk.controllers.extranet.reporte.ReporteHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.util.Date;

public class GestionarComision extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLiquidacion = 0;
		Integer idAlianza = Convert.toNumber(request.getParameter(AlianzaHelper.ID_ALIANZA), (Integer) null);
		boolean gestionOK = false;
		StringBuffer url = new StringBuffer(ReporteHelper.HOME_REPORTES).append("gestionComision.jsp?");

		if (idAlianza != null) {
			try {
				Connection conn = DBUtil.buildConnection();
				try {

					CallableStatement cs = conn.prepareCall("{call PA_LIQUIDACION_ALIANZAS.pr_liquidar_comisiones_alianza (?, ?, ?, ?)}");
					try {
						int index = 0;
						cs.setInt(++index, idAlianza.intValue());
						cs.setDate(++index, new java.sql.Date(new Date().getTime()));
						cs.setString(++index, "D");
						cs.registerOutParameter(++index, java.sql.Types.INTEGER);
						cs.execute();
						idLiquidacion = cs.getInt(4);
						TmkLogger.debug("La clave para el reporte es " + idLiquidacion);

						gestionOK = true;

						MailUtil.sendMail(
                            Globals.MAIL_MAILER,
							Globals.MAIL_ALIANZAS,
                            Globals.NOMBRE_DEL_SITIO + " - Gestion de comision",
                            "La alianza " + idAlianza + " ha pedido cobrar su comision. El id del reporte es " + idLiquidacion,
                            "La alianza " + idAlianza + " ha pedido cobrar su comision. El id del reporte es " + idLiquidacion);

					} finally {
						cs.close();
					}
				} finally {
					conn.close();
				}
			} catch (Exception e) {
				TmkLogger.error("No se pudo ejecutar el reporte de comisiones cobradas. " + e.getMessage());
				gestionOK = false;
			}
		} else {
			gestionOK = false;
		}

		url.append(AlianzaHelper.GESTION_COMISION).append("=").append((gestionOK ? "SI" : "NO"));
		url.append("&").append(ReporteHelper.ID_LIQUIDACION).append("=").append(idLiquidacion);
		response.sendRedirect(url.toString());
	}
}