package com.tmk.controllers.listas;

import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.listas.ListasTmk;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
//import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.HTML.Template;

public class GetListasTmk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
				
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		boolean socioTMK = Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false);
		Template template = (Template)ServiceLocator.getTemplateService().getTemplate("tmpMisListas");
		try {
			if(socioPk != null) {
				Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
				Integer indice = Convert.toNumber(request.getParameter("indice"), 0);
				Collection listas = ServiceLocator.getListasTmkServices().findBySocio(socioPk,socioTMK);
				
				Vector<Hashtable<String, Object>> vecListas = new Vector<Hashtable<String, Object>>(4);
				Iterator it = listas.iterator();
				
				for(int i=0;it.hasNext();i++) {
					ListasTmk lista = (ListasTmk)it.next(); 
					Hashtable<String, Object> has =  new Hashtable<String, Object>();
					has.put("nombreLista", lista.getTitulo());
					has.put("nombreDeCheckBok", "lista"+i);//con este nombre se levantara despues el checkbox					
					has.put("idLista", lista.getId_lista());
					//determino si el articulo esta en la lista. 
					boolean estaEnLaLista = false;					
					for(int c=0;lista.getListaTmkArticulos()!=null && !estaEnLaLista && c < lista.getListaTmkArticulos().length;c++){
						estaEnLaLista = idArticulo.equals(lista.getListaTmkArticulos()[c].getId_articulo());
					}
					has.put("estaEnLista", estaEnLaLista);
					has.put("valorDeCheckBox", lista.getId_lista());
					vecListas.add(has);					
				}
				template.setParam("idArticulo", idArticulo);
				//template.setParam("cantidadDeListas", vecListas.size());
				template.setParam("nombreDeForm", "frmAddToList"+indice);
				template.setParam("listas", vecListas);		
			}
		} catch (Exception e) {
			TmkLogger.error("Error mostrando las listas" + e.getMessage());		
		}
		finally {
			response.getWriter().println(template.output().replaceAll("\n", "</br>"));
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
