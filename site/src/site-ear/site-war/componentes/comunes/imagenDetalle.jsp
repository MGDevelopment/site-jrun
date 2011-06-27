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
	String atributoPrincipal = Convert.toString(request.getParameter("atributoPrincipal"), "");
	//Busco imagen chica
	String pathImgCh = ImageServer.obtenerNombreDeTapa(idArticulo, true, idSeccion, porcentajeDescuento, "", esNovedad);
	String pathImgGde = ImageServer.obtenerNombreDeTapa(idArticulo, false, idSeccion, porcentajeDescuento, "", esNovedad);	
	if (!atributoPrincipal.equals("")) {
		titulo = atributoPrincipal + " - " + titulo;
	}
	String textoH1 = request.getParameter("textoH1");
%>	
	<script language="javaScript">                 
	  function mostrarImagen()
	    {
	        window.open('/componentes/comunes/detalleTapa.jsp?idArticulo=<%= idArticulo %>&textoH1=<%=textoH1%>', '', 'toolbar=0,status=0,scrollbars=no,resizable=yes,width=30,height=30');
	    }                 
	</script>    
	
<%
	//si tengo imagen chica y grande, muestro la chica con el link a la grande
	if ( (pathImgCh != null && !"".equals(pathImgCh))) {
%>	
		<img src="<%=pathImgCh%>" width="<%=ancho %>" height="<%=alto %>" border="0" class="imagenPrincipal" alt="<%=titulo%>" title="<%=titulo%>"> 
<%	// si tengo solo imagen chica, muestro imagen chica
	} else  if ( (pathImgGde != null && !"".equals(pathImgGde)) ) {
%>		
  	  <img src="<%=pathImgGde%>" width="<%=ancho %>" height="<%=alto %>" border="0" class="imagenPrincipal" alt="<%=titulo%>"  title="<%=titulo%>">
<%	// si no tengo ninguna muestro la generica	
	} else {
		String tapaGenerica = ImageServer.nombreArticuloSinImagen(esNovedad, idSeccion);
%>
		<img src="<%=tapaGenerica%>" width="<%=ancho %>" height="<%=alto %>" border="0" class="imagenPrincipal" alt="<%=titulo%>"  title="<%=titulo%>">
<%
	}
%>	

