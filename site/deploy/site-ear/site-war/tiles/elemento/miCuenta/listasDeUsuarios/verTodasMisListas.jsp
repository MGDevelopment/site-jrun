
<%@page import="com.tmk.kernel.Convert"%><%@page import="com.tmk.kernel.TmkLogger"%>
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

<%
	SocioPK socioPk = (SocioPK)session.getAttribute("Registracion.socioPK");
	Template template = (Template)ServiceLocator.getTemplateService().getTemplate("tmpListasDeUnUsuario");
	Collection listas = null;
	boolean esSocioTMK = Convert.toBoolean((Boolean)session.getAttribute("socioTMK"), false);
	try {
		listas = ServiceLocator.getListasTmkServices().findBySocio(socioPk,esSocioTMK);
		Iterator it = listas.iterator();
		Vector<Hashtable<String,Object>> vec = new Vector<Hashtable<String,Object>>();
		while(it.hasNext()) {
			ListasTmk lista = (ListasTmk)it.next();
			Hashtable<String,Object> hash = new Hashtable<String,Object>();
			hash.put("idLista",lista.getId_lista());
			hash.put("listaTitulo",lista.getTitulo());
			hash.put("publica",!lista.getPublico().equals("S")?"(privada)":"");
			//muestro la cantidad de articulos
			if(lista.getListaTmkArticulos() != null) {
				hash.put("cantiadDeArticulos",""+lista.getListaTmkArticulos().length);
				hash.put("textoCantidadArticulo","items");
			}else{
				hash.put("cantiadDeArticulos","0");
				hash.put("textoCantidadArticulo","item");
			}
			vec.add(hash);
		}
		template.setParam("listas",vec);
	}catch(Exception e) {
		TmkLogger.debug(e);
	}finally {
		template.setParam("hayListas",(listas!=null));
	}
	out.println(template.output());
%>