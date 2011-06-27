<%@ page import="com.tmk.kernel.Globals,com.tmk.kernel.Convert" %>
<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_LIBRO);
String nombreGrupo = Convert.toString(request.getParameter("nombreGrupo"));

int registroInicial= Convert.toNumber(request.getParameter("registroInicial"),1);
int registroFinal= Convert.toNumber(request.getParameter("registroFinal"),10);

%> 

<%--= Globals.charset() %>
<%  String anex = (idSeccion == 4)? "discos": (idSeccion == 5)? "videos":""; %>
<%= Globals.title("Ranking de " + Globals.seccion(idSeccion) + ". Los " + anex + " más vendidos. " + Convert.corregir((("".equals(nombreGrupo))? Globals.seccion(idSeccion):nombreGrupo),true) + ". " + Globals.NOMBRE_DEL_SITIO)--%>

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center" style="margin-top: 99px;	">
          <tr>
            <td  class="Gbarraizquierda"width="139">
            <table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
             <tr>
                <td align="left" valign="top">
                <!-- ARBOL -->
            	<%--
            	//String arbolPage = "/componentes/comunes/arbolCategorias.jsp?tipoArbol=" + idSeccion;
            	String arbolPage = "/contenidosEstaticos/homes/arbolCategorias" + idSeccion + ".html";
            	%>
            	<jsp:include page="<%=arbolPage%>"/--%>
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
            
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">

				<%
				String rankingPage = "/contenidosEstaticos/ranking/ranking" + idSeccion + nombreGrupo + "p" + registroInicial + "_" + registroFinal + ".html"; 				

				%>
				<jsp:include page="<%=rankingPage%>"/>
	
              <tr>
                <!-- ULTIMOS VISITADOS -->
	                <td>
	                <%
	            	String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + idSeccion;
	            	%>
	            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
	                </td>
                 <!-- ULTIMOS VISITADOS -->                 
              </tr>
            </table></td>
            <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">

              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
<!-- RANKING RIGHT -->
	                <%
	            	String rankingRight = "/componentes/comunes/rankingRight.jsp?nombreGrupo= " + nombreGrupo + "&idSeccion=" + idSeccion;
	            	%>
	            	<jsp:include page="<%=rankingRight%>"/>
<!-- RANKING RIGHT -->                   
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>  
        </table>
        
<%=Globals.getGoogleAnalytics()%>
