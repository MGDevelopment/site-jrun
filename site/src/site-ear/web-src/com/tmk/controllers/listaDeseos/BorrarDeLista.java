/**
 * @author Lizardo Santiago
 *
 * $Log: BorrarDeLista.java,v $
 * Revision 1.10  2009/03/25 15:11:26  oClopez
 * mi cuenta testeado.
 *
 * Revision 1.9  2007/01/22 17:43:20  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.8  2003/12/04 17:21:28  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.7  2003/11/03 20:57:22  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.6  2003/10/03 21:50:23  SLizardo
 * EJB de ListaDeDeseos actualizado.
 *
 */
package com.tmk.controllers.listaDeseos;
import com.tmk.bus.articulo.CarritoListaDeseos;
//import com.tmk.kernel.DBUtil;
//import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
//import com.tmk.listaDeseos.*;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
//import com.tmk.soa.servicios.interfaces.CarritoListaDeseosService;
import com.tmk.src.socio.SocioPK;
//import javax.ejb.FinderException;
//import javax.ejb.RemoveException;
//import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;

public class BorrarDeLista extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		if(socioPK == null) {
			response.sendRedirect("/miCuenta/");
		}
		try
		{
			Integer ID_ARTICULO = Convert.toNumber(request.getParameter("ID_ARTICULO"), (Integer)null);			

			CarritoListaDeseosPK carritoPK = new CarritoListaDeseosPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO, ID_ARTICULO);
			//para elminar solo necesito la pk
			CarritoListaDeseos carritoDBO = new CarritoListaDeseos(carritoPK);
			ServiceLocator.getDboService().delete(carritoDBO);
		}catch (DBOInexistenteException ne){
			TmkLogger.error(ne.getMessage());
		}
		catch (Exception fe) {
			TmkLogger.error(fe.getMessage());
		}
		response.sendRedirect("/listaDeseos/verListaPropia.jsp");
	}
}