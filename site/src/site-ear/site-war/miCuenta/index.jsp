<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.controllers.MainHelper"%>

<%
	MainHelper.controlDeModo(request, response);
	boolean hayQueRedireccionar = (session.getAttribute("urlRedirect") != null);

	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
	String opMenuIzq = Convert.toString(request.getParameter("seccionMiCuenta"), "1");
    SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
    String subMenu = request.getParameter("subMenu");
%>

<%if(socioPK != null){
	//System.out.println("Esta logueado");
	if(opMenuIzq.equals("1") || opMenuIzq.equals("2")){ 
		response.sendRedirect("/miCuenta/modificarSocio.jsp");
	%>
		<%--<tiles:insert definition="seccion.general.modificar.datos"/>--%>
<% 	}else if(opMenuIzq.equals("3")){ 
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
%>	
		<tiles:insert definition="seccion.general.domicilio"/>
<% 	}else if(opMenuIzq.equals("5")){ %>
		<tiles:insert definition="seccion.general.recuperar"/> 		
<%  }else if(opMenuIzq.equals("6")){ %>	
		<tiles:insert definition="seccion.general.lista.deseo"/>
<% 	}else  if(opMenuIzq.equals("7")){
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
	%>
		<tiles:insert definition="seccion.general.modificar.lista.deseo"/>
<%	}else if(opMenuIzq.equals("8")){ %>
		<tiles:insert definition="seccion.general.clave.enviada"/>
<%	}else if(opMenuIzq.equals("9")){ 
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
%>
		<tiles:insert definition="seccion.general.agregar.domicilio"/>
<%  }else if(opMenuIzq.equals("10")){
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
%>
		<tiles:insert definition="seccion.general.lista.direccion.envio"/>
<%	}else if(opMenuIzq.equals("11")){ %>
		<tiles:insert definition="seccion.general.referidos"/>
<%	}else if(opMenuIzq.equals("11A")){ %>
		<tiles:insert definition="seccion.general.referidos"/>
<%	}else if(opMenuIzq.equals("12")){ %>
		<tiles:insert definition="seccion.general.tarjetas"/>
<%	}else if(opMenuIzq.equals("13")){ %>
		<tiles:insert definition="seccion.general.promo.historicas"/>
<%	}else if(opMenuIzq.equals("14")){ %>
		<tiles:insert definition="seccion.general.mis.ordenes"/>
<%	}else if(opMenuIzq.equals("15")){ 
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
%>
		<tiles:insert definition="seccion.general.modificar.domicilio.deseo"/>
<%	}else if(opMenuIzq.equals("16")){ %>
		<tiles:insert definition="seccion.general.enviar.correo"/>
<%	}else if(opMenuIzq.equals("LOGIN") ){ %>
		<tiles:insert definition="seccion.general.modificar.datos"/>
<%  }else if(opMenuIzq.equals("REG_OK") ){ %>
		<tiles:insert definition="seccion.general.registrotmk.ok"/>
<%	}	

}else {
	if(opMenuIzq.equals("LOGIN") ){ %>
		<tiles:insert definition="seccion.general.registroTMK"/>
<%	}else if(opMenuIzq.equals("5")){ %>
		<tiles:insert definition="seccion.general.recuperar"/> 		
<%  }else if(opMenuIzq.equals("8")){ %>
		<tiles:insert definition="seccion.general.clave.enviada"/>
<%	}
	else{
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));		
	%>	
		<tiles:insert definition="seccion.general.micuenta"/>
<%	 } 
}%>		