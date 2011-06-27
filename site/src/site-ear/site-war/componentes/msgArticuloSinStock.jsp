<%@ page import="com.tmk.kernel.Globals"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
<link href="/estilos/seccion_inicio.css" rel="stylesheet" type="text/css" />
<script src="/js/ajax.js" type="text/javascript"></script>
<script src="/js/popUp.js" type="text/javascript"></script>
<script src="/js/carrito.js" type="text/javascript"></script>

</head>
<body onload="MM_preloadImages('/imagenes/inicio/b-libros-over.gif','/imagenes/inicio/b-pasatiempos-over.gif','/imagenes/inicio/b-musica-over.gif','/imagenes/inicio/b-peliculas-over.gif')">
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0" class="Gtablaprincipal">
  <tr>
    <td><table width="740" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="183" valign="middle">
        <!-- Logo -->
        <%@include file="/componentes/comunes/logo.jsp"%>
        <!-- Logo -->
        </td>
        <td width="557" valign="middle">
        <!-- Login -->
        <%
       	String loginPage = "/componentes/comunes/login.jsp?idSeccion=" + Globals.SECCION_HOME;
       	%>
       	<jsp:include page="<%=loginPage%>"/>
        <!-- Login -->
        </td>
      </tr>
      <% String urlMenuSecciones = "/componentes/inicio/menuSecciones.jsp";%>
	  	 <jsp:include page="<%=urlMenuSecciones%>"/>   
      <tr>
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="modulobuscadorcarrito">
          <tr>
            <td width="575"><jsp:include page="/componentes/inicio/buscador.jsp"/></td>
            <td width="165">
           	<!-- Carrito -->
            <% String pageCarrito = "/componentes/comunes/carrito.jsp?idSeccion=" + Globals.SECCION_HOME;%>
			<jsp:include page="<%=pageCarrito%>"/>	
          	<!-- Carrito -->
            </td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2"><% String urlBannerTop = "/componentes/comunes/bannerTop.jsp?idSeccion=" + Globals.SECCION_HOME ;%>
			<jsp:include page="<%=urlBannerTop%>"/>
		</td>
      </tr>
      <tr>
        <td colspan="2">
        	<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
          <tr>
            <td  class="Gbarraizquierda" width="139"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top">
                <!-- ARBOL -->
            	<%
            	//String arbolPage = "/componentes/inicio/arbolCategoriaInicio.jsp";
            	String arbolPage = "/contenidosEstaticos/homes/arbolCategorias" + Globals.SECCION_HOME + ".html";
            	%>
            	<jsp:include page="<%=arbolPage%>"/>
                <!-- ARBOL -->                 
                </td>
              </tr>
              <tr>
                  <%
           		String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + Globals.SECCION_HOME;
           	   %>                           
                <jsp:include page="<%=urlInstitucionalLeft%>"/> 
              </tr>
            </table></td>
            <td class="Gcentro" width="422">
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td class="titulosceldas"></td>
                  </tr>
                  <tr>
					<td class="moduloayuda"><table align="center"  cellpadding="0">
						<tr valign="middle">
							<td>&nbsp;</td>																			
							<td><img src="/imagenes/miCuenta/baliza.gif"></td>
							<td ><div class="FTtit01">El articulo seleccionado se encuentra momentaneamente sin stock.<br>
								Disculpe las molestias.</td>
						</tr>
		 			</table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <!-- ultimos visitados -->
                <td>
                <%
            	String ultimosVisitadosPage = "/componentes/comunes/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            	%>
            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
                </td>
                 <!-- ultimos visitados -->
              </tr>
            </table></td>
            <td class="Gbarraderecha" width="162">
            <!-- top -->
            <%
            	//String topPage = "/componentes/inicio/top.jsp";
                String topPage = "/contenidosEstaticos/homes/top" + Globals.SECCION_HOME + ".html";
            	%>
            	<jsp:include page="<%=topPage%>"/>
            <!-- top -->
            </td>
          </tr>
          <tr>
            <td colspan="3"><div align="center">
                 <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion="+ Globals.SECCION_HOME;%>
				 <jsp:include page="<%=urlInstitucional%>"/>   
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<%=Globals.getGoogleAnalytics()%>
</body>
</html>