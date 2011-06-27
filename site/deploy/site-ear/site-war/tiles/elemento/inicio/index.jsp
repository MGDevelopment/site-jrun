<%--@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<%
	String URL_GRUPOS = request.getParameter("URL_GRUPO");
%>
<table align="center">
<tr><td>
	<jsp:include page="<%=URL_GRUPOS%>"/>
</td></tr>
</table>
--%>
<%@ page import="com.tmk.kernel.Globals, com.tmk.setup.Contenido"%>
<%Contenido.getInstance().incrementaVisitaPagina(0); %>
<link href="/estilos/mesa.css" rel="stylesheet" type="text/css" />

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda" width="139"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top">
                <!-- ARBOL -->
            	<%--
            	//String arbolPage = "/componentes/inicio/arbolCategoriaInicio.jsp";
            	String arbolPage = "/contenidosEstaticos/homes/arbolCategorias" + Globals.SECCION_HOME + ".html";
            	%>
            	<jsp:include page="<%=arbolPage%>"/--%>
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
             <%
             String principalPage = "/contenidosEstaticos/homes/principal" + Globals.SECCION_HOME + ".html";
            %>
            <%String urlGrupo = request.getParameter("URL_GRUPO");%>
            <%	if (urlGrupo == null) { %>
			 <td class="Gcentro" width="422">
            <!-- FOCO PRINCIPAL -->
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td>
            <jsp:include page="<%=principalPage%>"/></td>
              </tr>
              <tr>
                <%
                String destacadoPage = "/contenidosEstaticos/homes/destacado" + Globals.SECCION_HOME + ".html";
            	%>
                <td><jsp:include page="<%=destacadoPage%>"/></td>
              </tr>
              <tr>
                <!-- ultimos visitados -->
                <td>
                <%
            	String ultimosVisitadosPage = "/tiles/elemento/institucional/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            	%>
            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
                </td>
                 <!-- ultimos visitados -->
              </tr>
            </table>
            <!-- FOCO PRINCIPAL -->

            </td>
              <% } else {
			%>
				<td >
					<jsp:include page="<%= urlGrupo %>" />
				</td>
			<% } %>
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
         </table>

<%if (Globals.esModoRelease()){ %>
<!-- Tag for Activity Group: Tematika website, Activity: Tematika Home -->

<!-- Start of DoubleClick Spotlight Tag: Please do not remove-->
<!-- Activity Name for this tag is:Tematika Home -->
<!-- Web site URL where tag should be placed: http://www.tematika.com -->
<!-- Creation Date:12/29/2006 -->
<SCRIPT language="JavaScript">
var axel = Math.random()+"";
var a = axel * 10000000000000;
document.write('<IMG SRC="http://ad.ar.doubleclick.net/activity;src=1364770;type=tematsit;cat=temath01;ord='+ a + '?" WIDTH=1 HEIGHT=1 BORDER=0>');
</SCRIPT>
<NOSCRIPT>
<IMG SRC="http://ad.ar.doubleclick.net/activity;src=1364770;type=tematsit;cat=temath01;ord=1?" WIDTH=1 HEIGHT=1 BORDER=0>
</NOSCRIPT>
<!-- End of DoubleClick Spotlight Tag: Please do not remove-->
<%} %>
<%=Globals.getGoogleAnalytics()%>