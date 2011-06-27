package com.tmk.controllers.listas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.listas.ListasTmk;
import com.tmk.dbo.DBO;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.view.model.ListasTmkForm;
import com.tmk.xml.Resultado;
import com.tmk.xml.converter.TimestampConverter;

public class CrearListas extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");
		
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		ListasTmkForm modelo = null;
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		if(socioPk == null) {
			Resultado res = new Resultado(true,new String[]{"No puedes crear la lista, no estás logueado"},null);
			xstream.alias("resultado", Resultado.class);					
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
			return ;
		}else{
			try {
				modelo = (ListasTmkForm) ServiceLocator.getModeloBuilderService().getModelo(ListasTmkForm.class,request);
			
				ListasTmk lista =  new ListasTmk();
				lista.setPublico(modelo.getPublica());
				lista.setTitulo(modelo.getTitulo());
				lista.setDescripcion(modelo.getDescripcion());
				lista.setCategoria_seccion(Integer.parseInt(modelo.getCategoria_seccion()));
				lista.setId_lista(DBUtil.getSequenceValue("LIST_TMK_ID_SEC"));
				lista.setId_socio(socioPk.ID_SOCIO);
				lista.setId_sucursal_socio(socioPk.ID_SUCURSAL);
				ServiceLocator.getListasTmkServices().insert(lista);
								
				xstream.alias("resultado", ListasTmk.class);				
				xstream.omitField(DBO.class,"seteado");
				xstream.registerConverter(new TimestampConverter());
				response.getWriter().print(xstream.toXML(lista));
			} catch (Exception e) {
				TmkLogger.error("Creando lista para socio pk="+socioPk.toString());
				Resultado res = new Resultado(false,new String[]{"Error interno, intente mas tarde."},null);
				res.setFallaSistema(true);
				xstream.alias("resultado", Resultado.class);					
				response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
				return ;
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
