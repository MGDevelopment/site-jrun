<%@page import="com.tmk.soa.servicios.ConstantesService"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.tmk.bus.articulo.Articulo"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@page import="com.tmk.bus.listas.ListasTmkArticulos"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tmk.bus.listas.ListasTmk"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="java.util.Vector"%>

<%
	SocioPK socioPk = (SocioPK)session.getAttribute("Registracion.socioPK");
	Template template = (Template)ServiceLocator.getTemplateService().getTemplate("tmpListaDeUsuario");
	boolean socioTMK = Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false);
	ListasTmk lista = null;
	try {
		Integer idLista = Convert.toNumber(request.getParameter("idLista"),0);
		lista = ServiceLocator.getListasTmkServices().findByPk(idLista,socioTMK);
		template.setParam("idLista",lista.getId_lista());
		//marco si es ´publica o privada 
		template.setParam("checkedListaPublica"+lista.getPublico(),"checked");
		template.setParam("listaTitulo",lista.getTitulo());
		template.setParam("listaDescripcion",lista.getDescripcion());
		//calificacion de la lista 
		Vector vecCalificacion = ServiceLocator.getComentarioService().getEstrellasByCalificacion(
			ServiceLocator.getListasTmkServices().getCalificacionDeLista(lista.getListasTmkCalificaciones()),
			ConstantesService.getInstance().getEstrellas("estrellasGrandes")
		);
		template.setParam("listaCalificacion", vecCalificacion);
		//marco como check cual es la categoria principal de la lista
		template.setParam("checked"+lista.getCategoria_seccion(), "checked");
		
		if(lista.getListaTmkArticulos()!= null ) {
			ListasTmkArticulos[] articulos = lista.getListaTmkArticulos();
			Vector<Hashtable<String,Object>> vecArticulos = new Vector<Hashtable<String,Object>>(articulos.length);
			for(int i=0;i<articulos.length;i++) {
				//ListasTmkArticulos articulo = articulos[i];
				Hashtable<String,Object> hash = new Hashtable<String,Object>();
				Articulo articulo = ServiceLocator.getArticuloService().getArticuloParaCarrito(articulos[i].getId_articulo());
				hash.put("articuloIdArticulo",articulo.getId_articulo());
				hash.put("articuloTitulo",articulo.getTitulo());
				hash.put("articuloComentario",(articulos[i].getComentario()!=null)?articulos[i].getComentario():"");
				hash.put("idLista",lista.getId_lista());
				vecArticulos.add(hash);
			}
			template.setParam("articulosDeLaLista",vecArticulos);
			template.setParam("hayArticulos",(lista.getListaTmkArticulos()!=null));
		}
		template.setParam("hayListas",(lista!=null));
	}catch(Exception e) {
		TmkLogger.debug(e);
	}
	out.println(template.output());
%>