/**
 * @author Lizardo Santiago
 *
 * $Log: ActualizarLista.java,v $
 * Revision 1.18  2009/03/04 12:55:05  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.17  2007/01/22 17:43:20  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.16  2004/11/30 12:59:17  omsartori
 * - Corrección de ortografía en los msg de validación del form de registro.
 * - Unificación de msg entre el form de registro y el de modificación de datos
 * - Validación en el form de creación y modificación de Lista de Deseo.
 * - Validación en el form de envio por correo de la lista de Deseos.
 *
 * Revision 1.15  2004/11/18 17:04:58  omsartori
 * - Componentes genéricos, en inicio, lista de deseos y resultado de busqueda.
 *
 * Revision 1.14  2003/12/04 17:21:28  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.13  2003/11/03 20:57:21  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.12  2003/10/15 18:55:53  SLizardo
 * no message
 *
 * Revision 1.11  2003/10/13 04:08:50  SLizardo
 * no message
 *
 */
package com.tmk.controllers.listaDeseos;

import com.tmk.bus.articulo.ListaDeseos;
//import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;
//import com.tmk.listaDeseos.ListaDeseosLocal;
//import com.tmk.listaDeseos.ListaDeseosLocalHome;
import com.tmk.src.listadeseos.ListaDeseosPK;
//import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;

//import javax.ejb.FinderException;
//import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class ActualizarLista extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String DISPATCHER = (request.getParameter("_DISPACHER")==null)? "/listaDeseos/domicilios.jsp?TIPO_DOMICILIO=ENVI":request.getParameter("_DISPACHER");

		try {
			SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");

			Integer ID_SUCURSAL_SOCIO = socioPK.ID_SUCURSAL;
			Integer ID_SOCIO = socioPK.ID_SOCIO;

			String NOMBRES = Convert.toString(request.getParameter("NOMBRES"), "");
			String APELLIDOS = Convert.toString(request.getParameter("APELLIDOS"), "");
			Integer CUMPL_DIA = Convert.toNumber(request.getParameter("CUMPL_DIA"), new Integer(1));
			Integer CUMPL_MES = Convert.toNumber(request.getParameter("CUMPL_MES"), new Integer(1));
			String PALABRAS_CLAVES = Convert.toString(Convert.toString(request.getParameter("PALABRAS_CLAVES"), ""), 255);
			Integer PUBLICA = Convert.toNumber(request.getParameter("PUBLICA"), (Integer)null);
		
			//DBO
			ListaDeseosPK listaPK = new ListaDeseosPK(ID_SUCURSAL_SOCIO, ID_SOCIO);
			ListaDeseos listaDBO = ServiceLocator.getListaDeDeseosService().findByPrimaryKey(listaPK);
			
			/*ListaDeseosLocalHome listaHome = (ListaDeseosLocalHome)DBUtil.getHome("ListaDeseos");
			ListaDeseosPK listaPK = new ListaDeseosPK(ID_SUCURSAL_SOCIO, ID_SOCIO);
			ListaDeseosLocal lista = listaHome.findByPrimaryKey(listaPK);*/

			//if(lista.getPUBLICA().intValue() != 2)
			if(listaDBO.getPublica().intValue() != 2) {
				if(request.getParameter("_DISPACHER")==null) {
					DISPATCHER = "/listaDeseos/verListaPropia.jsp";
				}
			}

			/*lista.setNOMBRES(NOMBRES);
			lista.setAPELLIDOS(APELLIDOS);
			lista.setCUMPL_DIA(CUMPL_DIA);
			lista.setCUMPL_MES(CUMPL_MES);
			lista.setPALABRAS_CLAVES(PALABRAS_CLAVES);
			lista.setPUBLICA(PUBLICA);*/
			listaDBO.setNombres(NOMBRES);
			listaDBO.setApellidos(APELLIDOS);
			listaDBO.setCumpl_dia(CUMPL_DIA);
			listaDBO.setCumple_mes(CUMPL_MES );
			listaDBO.setPalabras_claves(PALABRAS_CLAVES);
			listaDBO.setPublica(PUBLICA);
			
			ServiceLocator.getDboService().update(listaDBO);			
		}
		catch (DBOInexistenteException ae)
		{
			TmkLogger.error(ae.toString());
		}
		
		catch (Exception fe)
		{
			TmkLogger.error(fe.toString());
		}

		response.sendRedirect(DISPATCHER);
	}
}