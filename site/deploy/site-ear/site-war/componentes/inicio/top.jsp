<%@ page import="com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals,
                 com.tmk.service.categoria.CategoriaService" %>
<%
ArticuloClass articulos[] = ArticuloManager.getArticulosParaTop (Globals.SECCION_LIBRO, -1, -1, 5);
%>
	<table width="155" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">
          
  <% if (articulos != null && articulos.length>0) { %>
            <tr>
              <td class="titulosceldas"><img src="/imagenes/inicio/t-toplibros.gif" alt="TOP100 Libros" width="94" height="12" /></td>
            </tr>
            <% for (int i=0; i<articulos.length; i++) { %>
            <tr>
              <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="toptabla">
                  <tr>
                    <td rowspan="4" class="topnumeros"><img src="/imagenes/inicio/top-<%=i+1%>.gif" alt="Puesto <%=i+1%>" width="15" height="17" /></td>
                    <td width="152" valign="top" align="left"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %></a></td></tr>
                            <tr><td valign="top" align="left" >
                            <%
                            String atributoPrincipal = "";
			          	  	if (articulos[i].getAtributoPrincipal() != null && !"".equals(articulos[i].getAtributoPrincipal())) {
	            				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
								articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),
								new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
								atributoPrincipal = articulos[i].getAtributoPrincipal() + " - ";
		          	  		%>
                            <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores0"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a>
                            <%}%>
                            </td></tr>
                            <tr><td valign="top" align="left" class="Fprecio"><%=Contenido.precioToString(articulos[i].getPrecio())%></td></tr>
                       </td>
                  </tr>
                  <tr>
                    <td  width="152"><div align="left">
                              <table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
                                <tr>
                                  <td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><img src="/imagenes/inicio/b-infosuc.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" border="0"/></a></td>
                                  <td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) {%><a href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/inicio/b-comprarsuc.gif" alt="Comprar"  border="0"/></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/inicio/b-pedir.gif" alt="Comprar"  border="0"/></a><%}%></td>
                                </tr>
                              </table></div>
                    </td>
                  </tr>
              </table></td>
            </tr>
            <%} %>
            <tr>
            	<td class="Gvermasimage">
            		
            	</td>
            </tr>
            <tr>
              <td><div align="left"><a href="/ranking/index.jsp?idSeccion=1"><img src="/imagenes/inicio/b-ranking.gif" alt="Ver ranking completo" width="116" height="7" border="0" class="Gvermasimage" /></a></div></td>
            </tr>
          </table></td>
        </tr>
        <%} %>
        
<%
 articulos = ArticuloManager.getArticulosParaTop (Globals.SECCION_MUSICA, -1, -1, 1);
%>        
        <% if (articulos != null && articulos.length>0) { %>
        <tr>
          <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">
            <tr>
              <td class="titulosceldas"><img src="/imagenes/inicio/t-topmusica.gif" alt="TOP20 M&uacute;sica" width="94" height="12" /></td>
            </tr>
             <tr>
              <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="toptabla">
                  <tr>
                    <td rowspan="4" class="topnumeros"><img src="/imagenes/inicio/top-1.gif" alt="Puesto 1" width="15" height="17" /></td>
                    <td width="152" valign="top" align="left"><a href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>" class="FProductos"><%=Convert.corregir(articulos[0].getTitulo(), true).toUpperCase() %></a></td></tr>
                            <tr><td valign="top" align="left" >
                            <%
                            String atributoPrincipal = "";
			          	  	if (articulos[0].getAtributoPrincipal() != null && !"".equals(articulos[0].getAtributoPrincipal())) {
	            				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
								articulos[0].getAtributoPrincipal(), articulos[0].getIdAtributoPrincipal(), new Integer(articulos[0].getIdSeccion()),
								new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible());
								atributoPrincipal = articulos[0].getAtributoPrincipal() + " - ";
		          	  		%>
                            <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores0"><%=articulos[0].getAtributoPrincipal().toUpperCase()%></a>
                            <%}%>
                            </td></tr>
                            <tr><td valign="top" align="left" class="Fprecio"><%=Contenido.precioToString(articulos[0].getPrecio())%>
                       </td>
                  </tr>
                  <tr>
	                  <td  width="152">
    	                	<div align="left">
        	                      <table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
            	                    <tr>
            	                  		<td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>" class="FProductos"><img src="/imagenes/inicio/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[0].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[0].getTitulo(), true)%>" border="0" /></a></td>
		                                <td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible() && articulos[0].getHabilitadoTematika().equals("S")) { %><a href="javascript:agregarProducto(<%=articulos[0].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/inicio/b-comprar.gif" alt="Comprar"  border="0"/></a><%} else { %><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[0].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/inicio/b-pedir.gif" alt="Comprar"  border="0"/></a><%} %></td>
                                	</tr>
                              	   </table>
                         	</div>
                      </td>   	
	                 
                  </tr>
              </table></td>
            </tr>
			<tr>
            	<td class="Gvermasimage">
            		
            	</td>
            </tr>
            <tr>
              <td><div align="left"><a href="/ranking/index.jsp?idSeccion=4"><img src="/imagenes/inicio/b-ranking.gif" alt="Ver ranking completo" width="116" height="7" border="0" class="Gvermasimage" /></a></div></td>
            </tr>
          </table></td>
        </tr>
        <% } %>
<%
 articulos = ArticuloManager.getArticulosParaTop (Globals.SECCION_PELICULA, -1, -1, 1);
%>        
        <% if (articulos != null && articulos.length>0) { %>
        <tr>
          <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">
            <tr>
              <td class="titulosceldas"><img src="/imagenes/inicio/t-toppeliculas.gif" alt="TOP20 Pel&iacute;culas" width="108" height="12" /></td>
            </tr>
            <tr>
              <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="toptabla">
                  <tr>
                    <td rowspan="4" class="topnumeros"><img src="/imagenes/inicio/top-1.gif" alt="Puesto 1" width="15" height="17" /></td>
                    <td width="152" valign="top" align="left"><a href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>" class="FProductos"><%=Convert.corregir(articulos[0].getTitulo(), true).toUpperCase() %></a></td></tr>
					<tr><td valign="top" align="left">
                            <%
                            String atributoPrincipal = "";
			          	  	if (articulos[0].getAtributoPrincipal() != null && !"".equals(articulos[0].getAtributoPrincipal())) {
	            				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
								articulos[0].getAtributoPrincipal(), articulos[0].getIdAtributoPrincipal(), new Integer(articulos[0].getIdSeccion()),
								new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible());
								atributoPrincipal = articulos[0].getAtributoPrincipal() + " - ";
		          	  		%>
                            <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores0"><%=articulos[0].getAtributoPrincipal().toUpperCase()%></a>
                            <%}%>
                    </td></tr>  
                    <tr><td valign="top" align="left" class="Fprecio">      
                            <%=Contenido.precioToString(articulos[0].getPrecio())%>
                       </td>
                  </tr>
                  <tr>
                      <td  width="152">
	                		<div align="left"><table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
            	                    <tr>
            	                  		<td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>"><img src="/imagenes/inicio/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[0].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[0].getTitulo(), true)%>" border="0" /></a></td>
		                                <td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible() && articulos[0].getHabilitadoTematika().equals("S")) {%><a href="javascript:agregarProducto(<%=articulos[0].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/inicio/b-comprar.gif" alt="Comprar"  border="0"/></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[0].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/inicio/b-pedir.gif" alt="Comprar"  border="0"/></a><%}%></td>
                                	</tr>
                              	</table>
                      		</div>
                      </td>   	
                  </tr>
              </table></td>
            </tr>
			<tr>
            	<td class="Gvermasimage">
            		
            	</td>
            </tr>
           <tr>
              <td><div align="left"><a href="/ranking/index.jsp?idSeccion=5"><img src="/imagenes/inicio/b-ranking.gif" alt="Ver ranking completo" width="116" height="7" border="0" class="Gvermasimage" /></a></div></td>
            </tr>
            <% } %>
          </table></td>
        </tr>
      </table>