<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.*,
                 java.sql.Timestamp,
                 com.tmk.controllers.MainHelper" %>
<%--
				//com.tmk.socio.SocioLocalHome,
			    //com.tmk.socio.SocioLocal,
--%>                 
                 
<%
  MainHelper.controlDeModo(request, response);
  response.setDateHeader("Expires",-1);
  response.setHeader("Pragma","no-cache");
  if(request.getProtocol().equals("HTTP/1.1"))
  	response.setHeader("Cache-Control","no-cache");

  SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
  boolean esSocioTMK = Convert.toBoolean((Boolean)session.getAttribute("socioTMK"), false);
  String redirect = Convert.toString((String)session.getAttribute(MainHelper.URL_REDIRECT), "/");
  if (socioPK == null) {
  	response.sendRedirect("/miCuenta/index.jsp");
  	return;

  }
  if (!esSocioTMK) {
  	///ya es socio CADENA. Reenvio a modificar
  	response.sendRedirect("/miCuenta/modificarSocio.jsp");
  	return;
  }
%>
<%--
<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
%>
<tiles:insert definition="seccion.general.registro.cadena"/>
--%>
<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
%>
<tiles:insert definition="tiles.micuenta.registro.socio.cadena"/>