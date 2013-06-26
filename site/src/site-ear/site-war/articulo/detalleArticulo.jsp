<%@page import="com.tmk.soa.dao.DAOFactory"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tmk.bus.articulo.Articulo"%>
<%@page import="java.lang.Exception"%>
<%@page import="com.tmk.soa.exceptions.AplicationException"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>


<%
	response.setStatus(301);
	String newLocation="";
	String idAlianza="";
	String idSeccion="";
	if((request.getParameter("isbn")!=null)&&(!request.getParameter("isbn").equals("")))
		newLocation="/buscar.do?claveDeBusqueda=porISBN&idSeccionPropia=1" +
					"&optSeleccionada=ISBN&idSeccion=1&seccionDeBusqueda=En%20Libros" +
					"&texto="+request.getParameter("isbn");
	else{
		try{
			Integer idArticulo=Integer.valueOf(request.getParameter("idArticulo"));
			Articulo articulo=ServiceLocator.getArticuloService().getDatosPrincipal(idArticulo);
			newLocation=articulo.getUrlDetalle();
			if(request.getParameter("ID_ALIANZA")!=null)
				idAlianza = request.getParameter("ID_ALIANZA");
				//newLocation=newLocation.replace(".htm", "--"+request.getParameter("ID_ALIANZA")+".htm");
			if(request.getParameter("ID_SECCION")!=null)
				idSeccion = request.getParameter("ID_SECCION");
							//newLocation=newLocation.replace(".htm", "--"+request.getParameter("ID_SECCION")+".htm");
			newLocation=newLocation.replace(".htm", ".htm?ID_ARTICULO="+request.getParameter("idArticulo")+
												     "&ID_ALIANZA="+idAlianza+"&ID_SECCION="+idSeccion);
		}catch(Exception e){
			TmkLogger.error(e);
			newLocation="/articulo/detalleArticuloRedireccionSEO.jsp";
		}
	}
	response.setHeader("Location", newLocation);
	response.setHeader("Connection", "close");
%> 


