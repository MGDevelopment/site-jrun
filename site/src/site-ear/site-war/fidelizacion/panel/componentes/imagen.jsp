<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.setup.ImageServer,
                 com.tmk.kernel.Globals" %>
                 
                    
<%
	int idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 1);
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), Globals.SECCION_LIBRO);
	int porcentajeDescuento = Convert.toNumber(request.getParameter("porcentajeDescuento"),0);
	int ancho = Convert.toNumber(request.getParameter("ancho"), 1);
	int alto = Convert.toNumber(request.getParameter("alto"), 1);
	String titulo = Convert.toString(request.getParameter("titulo"), "");
	boolean esNovedad = Convert.toBoolean(request.getParameter("esNovedad"), false);
	//Busco imagen chica
	String pathImgCh = ImageServer.obtenerNombreDeTapa(idArticulo, true, idSeccion, porcentajeDescuento, "", esNovedad);

%>

<%
	if ( (pathImgCh != null && !"".equals(pathImgCh))) {
%>	
		<a href="javascript:mostrarImagen('<%=pathImgCh%>')"><img src="<%=pathImgCh%>" width="<%=ancho %>" height="<%=alto %>" border="0" class="Gimagesproductos" alt="<%=titulo%>"> </a>
<%	
	} else {
		String tapaGenerica = ImageServer.nombreArticuloSinImagen(esNovedad, idSeccion);
%>
		<img src="<%=tapaGenerica%>" width="<%=ancho %>" height="<%=alto %>" border="0" class="Gimagesproductos" alt="<%=titulo%>">
<%
	}
%>	