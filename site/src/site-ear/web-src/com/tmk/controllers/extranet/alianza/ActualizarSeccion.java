/**
 * @author Lizardo Santiago
 *
 * $Log: ActualizarSeccion.java,v $
 * Revision 1.8  2004/02/03 03:07:15  NRodriguez
 * - nueva extranet
 *
 * Revision 1.7  2003/12/04 17:21:24  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.6  2003/11/03 20:57:23  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.5  2003/10/27 22:02:10  NRodriguez
 * Correccion de la intranet/extranet
 *
 * Revision 1.3  2003/10/11 18:14:46  SLizardo
 * no message
 *
 * Revision 1.2  2003/10/03 16:30:20  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.1  2003/09/05 14:51:55  NRodriguez
 * se movieron del package com.tmk.controllers.admin
 * a com.tmk.controllers.intranet.admin
 *
 * Revision 1.1  2003/09/01 16:28:34  SLizardo
 * Administracion de Alianzas.
 *
 */
package com.tmk.controllers.extranet.alianza;

import com.tmk.admin.AlianzaSeccionLocal;
import com.tmk.admin.AlianzaSeccionLocalHome;
import com.tmk.admin.AlianzaSeccionPK;
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

public class ActualizarSeccion extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer ID_ALIANZA = Convert.toNumber(request.getParameter(AlianzaHelper.ID_ALIANZA), (Integer) null);
		Integer ID_SECCION = Convert.toNumber(request.getParameter(AlianzaHelper.ID_SECCION), (Integer) null);
		String SECCION_NOMBRE = request.getParameter(AlianzaHelper.NOMBRE_SECCION);

		try {
			AlianzaSeccionLocalHome seccionHome = (AlianzaSeccionLocalHome) DBUtil.getHome("AlianzaSeccion");
			AlianzaSeccionPK pk = new AlianzaSeccionPK(ID_ALIANZA, ID_SECCION);
			AlianzaSeccionLocal seccion = seccionHome.findByPrimaryKey(pk);

			seccion.setSECCION_NOMBRE(SECCION_NOMBRE);
		} catch (NamingException ne) {
			TmkLogger.error(ne.getMessage());
		} catch (FinderException fe) {
			TmkLogger.error(fe.getMessage());
		}

		response.sendRedirect(request.getHeader("REFERER"));
	}
}
