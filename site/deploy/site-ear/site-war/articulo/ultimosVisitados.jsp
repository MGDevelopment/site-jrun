<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert" %>
<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_LIBRO);
%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Ultimos visitados")%>

<script type="text/JavaScript">
<!--

function MM_preloadImages() { 
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

//-->
</script>
<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
<link href="/estilos/seccion_<%=Globals.seccion(idSeccion)%>.css" rel="stylesheet" type="text/css" />
<script src="/js/ajax.js" type="text/javascript"></script>
<script src="/js/popUp.js" type="text/javascript"></script>
<script src="/js/carrito.js" type="text/javascript"></script>

</head>

<body onload="MM_preloadImages('/imagenes/<%=Globals.seccion(idSeccion)%>/b-tmtk-over.gif','/imagenes/<%=Globals.seccion(idSeccion)%>/b-musica-over.gif','/imagenes/<%=Globals.seccion(idSeccion)%>/b-pasatiempos-over.gif','/imagenes/<%=Globals.seccion(idSeccion)%>/b-peliculas-over.gif')">
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0" class="Gtablaprincipal">
  <tr>
    <td><table width="740" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="183" valign="middle">        
		<!-- Logo -->
        <%
       	String logoPage = "/componentes/comunes/logo.jsp";
       	%>
       	<jsp:include page="<%=logoPage%>"/>
        <!-- Logo -->
        </td>
        <td width="557" valign="middle">
        <!-- Login -->
        <%
       	String loginPage = "/componentes/comunes/login.jsp?idSeccion=" + idSeccion;
       	%>
       	<jsp:include page="<%=loginPage%>"/>
        <!-- Login -->
        </td>        
      </tr>
      <% String urlMenuSecciones = "/componentes/" + Globals.seccion(idSeccion) + "/menuSecciones.jsp";%>
	  	 <jsp:include page="<%=urlMenuSecciones%>"/> 
	  <%if(idSeccion != Globals.SECCION_HOME){ %>
	  <tr>
        <td colspan="2"><div align="center">
          <table width="720" border="0" cellpadding="0" cellspacing="0" class="subcategorias">
            <tr>
              <td>
               <!-- LINK BUSQUEDA -->
	          <% String linkBusqueda = "/componentes/comunes/linkBusqueda.jsp?idSeccion=" + idSeccion;%>
			  	 <jsp:include page="<%=linkBusqueda%>"/>   
              <!-- LINK BUSQUEDA -->
              </td>
            </tr>
          </table>
        </div></td>
      </tr>
	  <%} %> 
      <tr>
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="modulobuscadorcarrito">
          <tr>
            <td width="575">
            <%String pageBuscador = "/componentes/" + Globals.seccion(idSeccion) + "/buscador.jsp";%>
            <jsp:include page="<%=pageBuscador%>"/></td>
            <td width="165">
            <!-- Carrito -->
            <% String pageCarrito = "/componentes/comunes/carrito.jsp?idSeccion=" + idSeccion;%>
			<jsp:include page="<%=pageCarrito%>"/>	
          	<!-- Carrito -->
            </td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2"><% String urlBannerTop = "/componentes/comunes/bannerTop.jsp?idSeccion="+idSeccion;%>
			<jsp:include page="<%=urlBannerTop%>"/>  </td>
      </tr>
      <tr>
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
             <tr>
                <td align="left" valign="top">
                <!-- ARBOL -->
            	<%
            	//String arbolPage = "/componentes/comunes/arbolCategorias.jsp?tipoArbol=" + idSeccion;
            	String arbolPage = "/contenidosEstaticos/homes/arbolCategorias" + idSeccion + ".html";
            	%>
            	<jsp:include page="<%=arbolPage%>"/>
                <!-- ARBOL --> 
                </td>
              </tr>
              <tr>
               <%
           		String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + idSeccion;
           	   %>                           
                <jsp:include page="<%=urlInstitucionalLeft%>"/>
              </tr>
            </table></td>
            
            <td class="Gcentro" width="422">
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0" >
              <tr>
                <td>
  <!-- ULTIMOS VISITADOS -->
	                <%
	            	String ultimosVisitadosPage = "/componentes/comunes/ultimosVisitados.jsp?idSeccion=" + idSeccion;
	            	%>
	            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
  <!-- ULTIMOS VISITADOS -->                 
				</td>
  		      </tr>
            </table></td>
            <td class="Gbarraderecha" width="162">
                <!-- top -->
            <%
            	//String topPage = "/componentes/inicio/top.jsp";
                String topPage = "/contenidosEstaticos/homes/top" + idSeccion + ".html";
            	%>
            	<jsp:include page="<%=topPage%>"/>
            <!-- top -->            
                </td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td colspan="3"><div align="center">
              <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion=" + idSeccion;%>
				 <jsp:include page="<%=urlInstitucional%>"/></td>
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
