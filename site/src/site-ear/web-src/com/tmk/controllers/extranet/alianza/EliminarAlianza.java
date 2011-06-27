/**
 * @author Lizardo Santiago
 *
 * $Log: EliminarAlianza.java,v $
 * Revision 1.7  2007/04/26 18:32:49  omsartori
 * no message
 *
 * Revision 1.6  2003/12/04 17:21:25  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/11/11 14:31:42  JMembrives
 * agregado del campo PORC_COMISION_PARTICULAR en alta y modificacion.
 *
 * Revision 1.4  2003/10/27 22:02:12  NRodriguez
 * Correccion de la intranet/extranet
 *
 * Revision 1.2  2003/10/11 18:14:47  SLizardo
 * no message
 *
 * Revision 1.1  2003/09/05 14:51:53  NRodriguez
 * se movieron del package com.tmk.controllers.admin
 * a com.tmk.controllers.intranet.admin
 *
 * Revision 1.4  2003/09/01 15:33:32  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.3  2003/08/29 17:55:12  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.2  2003/08/25 20:46:08  SLizardo
 * Optimize Imports
 *
 * Revision 1.1  2003/07/28 17:18:54  SLizardo
 * *** empty log message ***
 *
 * Revision 1.1  2003/07/24 21:36:42  SLizardo
 * Version Inicial, borra una admin.
 *
 */
package com.tmk.controllers.extranet.alianza;

import com.tmk.admin.AlianzaLocal;
import com.tmk.admin.AlianzaLocalHome;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;

import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarAlianza extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer ID_ALIANZA = Convert.toNumber(request.getParameter("ID_ALIANZA"), (Integer)null);

			AlianzaLocalHome alianzaHome = (AlianzaLocalHome) DBUtil.getHome("Alianza");
			AlianzaLocal alianza = alianzaHome.findByPrimaryKey(ID_ALIANZA);
			alianza.setFECHA_BAJA(new java.util.Date());
		} catch (NamingException ne) {
			TmkLogger.error(ne.getMessage());
		} catch (FinderException fe) {
			TmkLogger.error(fe.getMessage());
		}

		response.sendRedirect("/236-TMK/alianzas/index.jsp");
	}
}
