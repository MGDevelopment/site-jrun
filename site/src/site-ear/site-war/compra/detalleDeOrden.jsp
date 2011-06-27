<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.DBUtil,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.orden.OrdenLocal"
                 %>
<%@page import="com.tmk.orden.OrdenDAO"%>

<%
	//en caso de que haya quedado el mensaje de error en la sesion la elimino
	session.removeAttribute("msgError");
	
	SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
	if (socioPK == null) {
		response.sendRedirect("/miCuenta/");
		return;
	}

	int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);

	try {
		OrdenLocalHome ordenLH = (OrdenLocalHome)DBUtil.getHome("Orden");
		OrdenLocal orden = ordenLH.findByPrimaryKey(new Integer (idOrden));
		if (!orden.getID_SOCIO().equals(socioPK.ID_SOCIO) || !orden.getID_SUCURSAL_SOCIO().equals(socioPK.ID_SUCURSAL)) {
			response.sendRedirect("/miCuenta/");
			return;
		}
	} catch (Exception e) {
        response.sendRedirect("/miCuenta/");
		return;
	}
%>
<%	
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA)); 
%>
<tiles:insert definition="seccion.general.compra.detalle"/>
