<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.site.Pagina,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.DisponibilidadDAO,
                 java.util.Vector,
                 com.tmk.service.categoria.CategoriaService,
                 com.tmk.controllers.MainHelper"%>

<%
int idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION), 0);  
Pagina paginaXML = null;
for (int i=0; i<Contenido.getSite().getPaginas().getPaginaCount(); i++) {
	if (Contenido.getSite().getPaginas().getPagina(i).getId() == idSeccion) {
		paginaXML = Contenido.getSite().getPaginas().getPagina(i);	
	}	
}

ArticuloClass articulos[] = null;
Vector aux = new Vector();
if (paginaXML.getDestacados() != null) {
	if (idSeccion == Globals.SECCION_HOME) {
	for (int i=0; i<paginaXML.getDestacados().getArticuloCount(); i++) { 
		com.tmk.kernel.site.Articulo articuloXML = paginaXML.getDestacados().getArticulo(i);
		aux.add(ArticuloManager.getArticulosParaResultadoDeBusqueda(
				articuloXML.getId() + "", articuloXML.getIdSeccion())[0]);
	}
	articulos = (ArticuloClass [])aux.toArray(new ArticuloClass[aux.size()]);
	
		
	} else {
	
	String idArticulos ="";
	for (int i=0; i<paginaXML.getDestacados().getArticuloCount(); i++) { 
		idArticulos = idArticulos + paginaXML.getDestacados().getArticulo(i).getId() + ",";
	}	
	if (idArticulos.length()>1) {
		idArticulos = idArticulos.substring(0, idArticulos.length()-1);
		
	}
	articulos =  ArticuloManager.getArticulosParaResultadoDeBusqueda(
			idArticulos, idSeccion);
	}
}
%>
<%
	if(articulos != null) {
%>
<table width="390" border="0" cellpadding="0" cellspacing="0" class="modulorecomendadosd">
   <tr>
     <td width="50" class="titulosceldas"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-novedades.gif" alt="Novedades" /></td>            
   </tr>
   <tr>
     <td>
     	<table border="0" align="center" cellpadding="0" cellspacing="0" width="388">
     		<%
     			if (idSeccion == Globals.SECCION_HOME) {
     		%>
     		<tr>
     			<td valign="top"><img src="/imagenes/inicio/t-<%=Globals.seccion(articulos[0].getIdSeccion())%>.gif" alt="<%=Globals.textoSolapa(articulos[0].getIdSeccion())%>"  border="0" width="123" height="29" border="0" class="titulosNovedadesImages"/></td>
     			<td valign="top"><div align="center"><img src="/imagenes/inicio/t-<%=Globals.seccion(articulos[1].getIdSeccion())%>.gif" alt="<%=Globals.textoSolapa(articulos[1].getIdSeccion())%>"  border="0" width="123" height="29" border="0" class="titulosNovedadesImages"/></div></td>
     			<td valign="top"><img src="/imagenes/inicio/t-<%=Globals.seccion(articulos[2].getIdSeccion())%>.gif" alt="<%=Globals.textoSolapa(articulos[2].getIdSeccion())%>"  border="0" width="123" height="29" border="0" class="titulosNovedadesImages"/></td>
     		</tr>
     		<%
     			}
     		%>
       		<%
       			for (int x=0; x<articulos.length; x=x+3) {
       		%>
       		<tr>
         		<%
         			for (int i=0+x; i<Math.min(3+x, articulos.length); i++) {
         		%>
         		<td <%=(i==0 || i==2)? "width=\"123\"":""%> valign="top">
         			<table class="modulorecomendados-1" width="123" border="0" cellspacing="0" cellpadding="0" align="center">

           				<tr>
			             	<td><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase()%></a></td>
           				</tr>
           				<tr>
             				<td>
             				<%
             					if (articulos[i].getAtributoPrincipal() != null) {
             						           				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
             										articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),
             										new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
             				%>
             					<a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores0"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a><%
             						}
             					%></td>
           				</tr>
			         </table>
		         </td>
				<%
					}
				%>		         
       		</tr>
	        <tr>
	        	<%
	        		for (int i=0+x; i<Math.min(3+x, articulos.length); i++) {
	        	         			int valor = (articulos.length%3 == 0)? 0: (3-articulos.length%3);
	        	%>
     		    <td <%=(i==0 || i==2)?"width=\"123\"":""%>   valign="top">
     		    	<table width="123" border="0" cellspacing="0" cellpadding="0" class=modulorecomendados-fin align="center">
           				<tr>
             				<td><div align="left"><span class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[i].getPrecio())%></span></div></td>
           				</tr>
           				<tr>
           					<td><div align="left">
           						 <table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
                                	<tr>
	                                	<td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-info.gif" alt="<%=(articulos[i].getAtributoPrincipal() != null)?articulos[i].getAtributoPrincipal() + " - ":""%><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase()%>" title="<%=(articulos[i].getAtributoPrincipal() != null)?articulos[i].getAtributoPrincipal() + " - ":""%><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase()%>" border="0" /></a></td>
             			<%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) { %>
             							<td class="divComprarPedir"><a href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar.gif" alt="Comprar"  border="0"/></a></td>
             			<% } else {%>
             							<td class="divComprarPedir"><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Comprar"  border="0"/></a></td>
             			<% } %>
           							</tr>
           						</table>
           					</div></td>
           				</tr>		
         			</table>
        		</td>
        		<%
         		}
				%>		         
       		</tr>
       	 <%}%>	
	     </table>
     </td>
   </tr>
</table>
<%}%>  