<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.controllers.buscador.BuscadorHelper" %>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%
	int idSeccion = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SECCION), Globals.SECCION_HOME);
	String palcla = Convert.toString(request.getParameter(BuscadorHelper.POR_PALABRAS_CLAVES));
%>

<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
   <tr>

     <td class="Gcentro"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
       <tr>
         <td><div align="center">
             <table width="375" border="0" cellspacing="0" cellpadding="0" >
               <tr class="modulosmedio">
                 <td class="titulosceldas"><table width="375" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
                     <tr>
                       <td><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-busqavanzada.gif" alt="B&uacute;squeda avanzada" /></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
					<%--<form name="formSearch" action="<%=BuscadorHelper.PAGINA_BUSCADOR%>?idSeccion=<%=idSeccion%>" method="get" onsubmit="return consultar(this)">--%>
					<form 
						name="formSearch" 
						<%--action="<%=(session.getAttribute("busquedaNueva")!=null && ((Boolean)session.getAttribute("busquedaNueva")).booleanValue()) ? "/buscador/productos_nue.jsp" : ""+BuscadorHelper.PAGINA_BUSCADOR%>?idSeccion=<%=idSeccion%>" --%>
						action="/buscador/productos_nue.jsp?idSeccion=<%=idSeccion%>" 
						method="post" 
						onsubmit="return consultar(this)">
					
					<%-- <form name="formSearch" action="/SetearBusqueda?idSeccion=<%=idSeccion%>" method="GET" onsubmit="return consultar(this)"> --%>
					<input type="hidden" name="<%=BuscadorHelper.CATEGORIA_SECCION%>" value="<%=idSeccion%>">
					<input type="hidden" name="idSeccionPropia" value="<%=idSeccion%>">
					<input type="hidden" name="seccionBusqueda" value="En Libros">
					<input type="hidden" name="<%=BuscadorHelper.ES_BUSQUEDA_AVANZADA%>" value="true">
					<%
						String pagina="/tiles/elemento/componentes/"+
								Globals.seccion(idSeccion) + "/buscadorAvanzado.jsp?"+
										BuscadorHelper.POR_PALABRAS_CLAVES + "=" +
											palcla + "&idSeccion=" + request.getParameter("idSeccion");
					%>
						<jsp:include page="<%=pagina%>" />
					</form>
                </tr>
              </table>
          </div></td>
        </tr>
        <tr>
          <td><!-- ultimos visitados -->
            <%String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + idSeccion;%>
      		<jsp:include page="<%=ultimosVisitadosPage%>"/>
          </td><!-- Ultimos Visitados -->
       </tr>
     </table></td>
     <td class="Gbarraderecha"><table width="162" border="0" cellpadding="0" cellspacing="0" class="">
         <tr>
           <td class="Ftexto02"><table width="162" border="0" cellpadding="0" cellspacing="0" class="tablaaccesoavanzadas">
             <tr>

               <td><table width="162" border="0" cellspacing="0" cellpadding="0">
                   <tr>
                     <td class="Ftexto02">Si no tuvo un resultado<br />
                       satisfactorio, pruebe con:</td>
                   </tr>
                     <tr>
                       <td><div align="left"><a href="/indice"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-mapadeproductos.gif" alt="Mapa de productos"  border="0" class="accesos02" /></a></div></td>
                     </tr>
                   </tr>
               </table></td>
             </tr>
           </table></td>
         </tr>

     </table></td>
   </tr>
</table>