/**
 * @author Lizardo Santiago
 *
 * $Log: DireccionLista.java,v $
 * Revision 1.5  2009/03/04 12:55:05  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.4  2007/01/22 17:43:21  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.3  2003/10/03 21:50:24  SLizardo
 * EJB de ListaDeDeseos actualizado.
 *
 */
package com.tmk.controllers.listaDeseos;

//import com.tmk.listaDeseos.ListaDeseosLocal;
//import com.tmk.listaDeseos.ListaDeseosLocalHome;
import com.tmk.kernel.TmkLogger;
import com.tmk.src.listadeseos.ListaDeseosPK;
//import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.bus.articulo.ListaDeseos;
//import com.tmk.kernel.DBUtil;
//import com.tmk.kernel.TmkLogger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
//import javax.ejb.FinderException;
//import javax.naming.NamingException;
import java.io.IOException;

public final class DireccionLista extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String TIPO_DOMICILIO = request.getParameter("TIPO_DOMICILIO");

		HttpSession session = request.getSession();
		SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
		if(socioPK == null || TIPO_DOMICILIO == null || "".equals(TIPO_DOMICILIO)){
			response.sendRedirect("/miCuenta/");
		}			

		try {
			//DBO
			ListaDeseosPK listaPK = new ListaDeseosPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
			ListaDeseos listaDBO = new ListaDeseos(listaPK);
			listaDBO.setTipo_domicilio(TIPO_DOMICILIO);
			//ServiceLocator.getListaDeDeseosService().update(listaDBO);
			ServiceLocator.getDboService().update(listaDBO);
								
			//ListaDeseosLocalHome listaHome = (ListaDeseosLocalHome)DBUtil.getHome("ListaDeseos");
			//ListaDeseosPK listaPK = new ListaDeseosPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
			//ListaDeseosLocal lista = listaHome.findByPrimaryKey(listaPK);

			//lista.setTIPO_DOMICILIO(TIPO_DOMICILIO);
		} catch (DBOInexistenteException ae){
			TmkLogger.error(ae.getMessage());
		}
		//catch (AplicationException fe)
		catch (Exception fe) {
			TmkLogger.error(fe.getMessage());
		}

		if(request.getParameter("_DISPACHER") == null)
			response.sendRedirect("/listaDeseos/verListaPropia.jsp");
		else
			response.sendRedirect("/miCuenta/?seccionMiCuenta=6");
	}
}
