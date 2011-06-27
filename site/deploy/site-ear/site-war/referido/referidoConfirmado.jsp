<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals " %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<% 
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	if(socioPK == null) {
		response.sendRedirect("/miCuenta");
	}
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));	
%>
<tiles:insert definition="tiles.micuenta.referidos.confirmado"/>

<%--
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Tematika.com: Referido Confirmado") %>


<script type="text/javascript">
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
</script>

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
            <td width="575"><jsp:include page="/componentes/inicio/buscador.jsp"/> </td>            
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
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
			<%
			 if (socioPK != null) { %>
				<tr>
					<td valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
            			<tr>
							  <td align="left" class="preguntasceldas"><a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a></td>
		                </tr>
    		        </table></td>
	    	   </tr>
    	   <%}%>
            <jsp:include page="/miCuenta/left.jsp"/>   
            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>
                  <tr>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0">

                          <tr>
                            <td height="20" valign="top"><div align="center">Gracias por participar del programa de Referidos de Tematika.com.</div></td>
                          </tr>
                        </table></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
			  <tr>
                <!-- ultimos visitados -->
                <td>
                <%
            	String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            	%>
            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
                </td>
                 <!-- ultimos visitados -->
              </tr>
            </table></td>
           
            <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">

              <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
   		      <jsp:include page="<%=urlInstitucionalRight%>"/>  

            </table></td>
          </tr>
          <tr>
            <td colspan="3"><div align="center">
              <table width="670" border="0" cellpadding="0" cellspacing="0" class="Gfooter">
                 <tr>
		           <td colspan="3"><div align="center">
        		      <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion="+ Globals.SECCION_HOME ;%>
				      <jsp:include page="<%=urlInstitucional%>"/>  
		           </div></td>
        		  </tr>
              </table>
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
--%>