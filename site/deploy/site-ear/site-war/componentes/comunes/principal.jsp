<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.site.Pagina,
                 com.tmk.setup.Contenido,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.bus.articulo.ArticuloClass,
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
if (idSeccion == Globals.SECCION_HOME) {
	if (paginaXML.getPrincipal().getArticulos() != null) {
		for (int i=0; i<paginaXML.getPrincipal().getArticulos().getArticuloCount(); i++) { 
	com.tmk.kernel.site.Articulo articuloXML = paginaXML.getPrincipal().getArticulos().getArticulo(i);
	aux.add(ArticuloManager.getArticulosParaResultadoDeBusqueda(
			articuloXML.getId() + "", articuloXML.getIdSeccion())[0]);
			
		}
		articulos = (ArticuloClass [])aux.toArray(new ArticuloClass[aux.size()]);
	}
	
} else {
	if (paginaXML.getPrincipal().getArticulos() != null) {
		String idArticulos ="";
		for (int i=0; i<paginaXML.getPrincipal().getArticulos().getArticuloCount(); i++) { 
	idArticulos = idArticulos + paginaXML.getPrincipal().getArticulos().getArticulo(i).getId() + ",";
		}	
		if (idArticulos.length()>1) {
	idArticulos = idArticulos.substring(0, idArticulos.length()-1);
	
		}
		articulos =  ArticuloManager.getArticulosParaResultadoDeBusqueda(
		idArticulos, idSeccion);

	}
}
%>                 
			<table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="390" border="0" align="center" cellpadding="0" cellspacing="0" class="Gmodulodestacados">
                  <tr>
<%
	if (articulos != null) {
%>    
    				
    	<%
        				    		for (int i = 0; i<articulos.length; i++){
        				    	%>
					<td width="130" valign="middle">  
					<table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
    						<tr>
            					<td>
            						<div align="center">
            <%
            	String imgPage = "/componentes/comunes/imagenBusqueda.jsp?idArticulo=" + articulos[i].getIdArticulo() + "&idSeccion=" + articulos[i].getIdSeccion() +
            			"&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulos[i].getIdSeccion()][1] + "&alto=" + Globals.tamImagen[articulos[i].getIdSeccion()][2] + "&esNovedad=" + articulos[i].esNovedad() + 
            			"&titulo=" + Convert.corregir(articulos[i].getTitulo(), true).toUpperCase();
            %>
			<a class="FProductos" href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>">
						        		<jsp:include page="<%=imgPage %>"/>
			</a>			        		
           							</div>
           						</td>
		          			</tr>	
	          			</table>
          			</td>
		<%
			}
		%>		          			
						</tr>
						<tr>
		
		<%
					for (int i = 0; i<articulos.length; i++){
				%>
			<td width="130" valign="top">  
					<table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
    	
						
							<tr>
   	        					<td class="Gdescripcionproductos" width="125">
				            		<a class="FProductos" href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>">
				            		<a class="FProductos" href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase()%></a><br/>
							<%
			          	  	if (articulos[i].getAtributoPrincipal() != null) {
		          	  		%>
				            <% 
		            				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
									articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),
									new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());%>
									<a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores0"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a><%}%></td>
    				    	</tr>
			     </table>
  		 	</td>
<%} %>
	   			</tr>

	   			<tr>
	   			    <%for (int i = 0; i<articulos.length; i++){ %>
	                 <% if (idSeccion == Globals.SECCION_HOME) { %> 	
	                 	<td width="130" valign="top">  
							<table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
			    				<tr>
   		  	  	                   <td class="Gdescripcionproductostexthome" width="125"><span class="Ftextdestacados">
				                   <% if (paginaXML.getPrincipal().getArticulos().getArticulo(i).getTexto() != null) { %>
					                   <%=paginaXML.getPrincipal().getArticulos().getArticulo(i).getTexto()%>
				                   <% } else {%>
				                   <%		if (articulos[i].getSinopsis() != null) {%>
				                	 			<%=(articulos[i].getSinopsis().length()>100)?articulos[i].getSinopsis().substring(0, 100) + "...":articulos[i].getSinopsis()%>  
				                   <%
				                   			}
				                   %>   
				                   <% }%></span>
	    	             		   </td>
	   	  		 	  			</tr>
	   	  	 				</table>
	   	  	 	  		</td>
			      	  <%} %>
	   			<%	} %>
	   			</tr>
		    	<tr>
    <%for (int i = 0; i<articulos.length; i++){ %>
				    <td width="130" valign="top"> 
						<table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
    						<tr>
           						<td width="125">
           							<div class="Gprodprincipalprecio">
									<span class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[i].getPrecio())%></span>
    	  							</div>
       							</td>
	          				</tr>	
						</table>
					</td>
    <%}%>  
	    		</tr>

		    	<tr>
    <% 	for (int i = 0; i<articulos.length; i++){ 
      		if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) { %>
				    <td width="130" valign="top"> 
						<table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
    						<tr>
								<td class="Gprodprincipalcomprar"><a  href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar.gif" alt="Comprar"  border="0"/></a></td>
							</tr>
						</table>
					</td>
      <%
      		} else {
      %>	
				    <td width="130" valign="top"> 
						<table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
    						<tr>
								<td class="Gprodprincipalcomprar"><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Comprar"  border="0"/></a></td>      
							</tr>
						</table>
					</td>
		
 	  <%
      		}
      %>
    <% 
    	}
    %>  
<%
	} else {
%>		
					<td>
<%
		if (paginaXML.getPrincipal().getBanner().getTipoUrl().toString().equals("HTML")) {
%>	
					<jsp:include page="<%=paginaXML.getPrincipal().getBanner().getUrl()%>"/>
<%
		} else {
%>			
					<img src="<%=paginaXML.getPrincipal().getBanner().getUrl()%>">
<%
		}
%>
				</td>
<%
	}
%>
		 </tr>
	  </table>
	  </td>	
	  </tr>
	  </table>
