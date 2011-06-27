/**
 * $Log: OrdenEFCO.java,v $
 * Revision 1.1  2003/10/28 00:22:08  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.1  2003/10/10 18:42:40  NRodriguez
 * - Administracion de ordenes EFCO
 *
 */
package com.tmk.controllers.intranet.ordenes;

import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.DBUtil;
import com.tmk.orden.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrdenEFCO extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idOrden = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_ID_ORDEN_), Integer.MIN_VALUE);

		String telefono = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_TELEFONO));
		String horario = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_HORARIO));
		String comentario = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_COMENTARIO));

		StringBuffer parametros = new StringBuffer();

        parametros.append("?").append(OrdenesHelper.CAMPO_ID_ORDEN_).append("=").append(idOrden);

        try {
		    Integer orden = new Integer(idOrden);
			OrdenLocalHome ordenLocalHome = (OrdenLocalHome) DBUtil.getHome("Orden");
			OrdenLocal ordenLocal = ordenLocalHome.findByPrimaryKey(orden);


			ordenLocal.setTELEFONO(telefono);
			ordenLocal.setHR_CONTACTO(horario);
			ordenLocal.setCOMENTARIOS(comentario);

			parametros.append("&" + OrdenesHelper.CAMPO_INFORMACION + "=");
			parametros.append("Se actualizaron los datos correctamente");

		} catch (Exception e) {
            TmkLogger.error("&" + "No se pudo actualizar los datos de la orden " + idOrden);

			parametros.append(OrdenesHelper.CAMPO_ERROR + "=");
			parametros.append(e.getMessage());
		} finally {
            response.sendRedirect(OrdenesHelper.PAGINA_PAGO_EFCO + parametros.toString());
		}
	}
}
