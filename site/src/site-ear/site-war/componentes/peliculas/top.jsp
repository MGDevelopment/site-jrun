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
ArticuloClass articulos[] = ArticuloManager.getArticulosParaTop (Globals.SECCION_PELICULA, -1, -1, 10);
%>
                 
<table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">
<% if (articulos != null && articulos.length>0) { %> 
  <tr>
    <td class="titulosceldas"><img src="/imagenes/peliculas/t-top20.gif" alt="TOP20" width="46" height="12" /></td>
  </tr>
  <% for (int i=0; i<articulos.length; i++) { %> 
  <tr>
    <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="toptabla">
      <tr>
        <td rowspan="4" class="topnumeros"><img src="/imagenes/peliculas/top-<%=i+1%>.gif" alt="Puesto <%=i+1%>" width="15" height="17" /></td>
        <td width="152" valign="top" align="left"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %></a><br></td></tr>
        	<tr><td valign="top" align="left" >
          	<%	String atributoPrincipal = "";
       	  		if (articulos[i].getAtributoPrincipal() != null) {
       				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
					articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),
					new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
					atributoPrincipal = articulos[i].getAtributoPrincipal() + " - ";
       	  	%>
                        <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a>
            <%	}%>            
              </td></tr>
                       <tr><td valign="top" align="left" class="Fprecio"><%=Contenido.precioToString(articulos[i].getPrecio())%>
       </td>
      </tr>
      <tr>
        <td width="152">
        	<div align="left">
           		<table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
   	            	<tr>
   	                	<td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><img src="/imagenes/peliculas/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" border="0"/></a></td>
   	                  	<td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) {%><a href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/peliculas/b-comprar.gif" alt="Comprar"  border="0"/></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/peliculas/b-pedir.gif" alt="Comprar"  border="0" class="espacioizquierda"/></a><%}%></td>
                     </tr>
                 </table>
        	</div>
        </td>
      </tr>
    </table></td>
  </tr>
  <%} %>  
  <tr>
    <td><div align="center"><a href="/ranking/index.jsp?idSeccion=5"><img src="/imagenes/peliculas/b-ranking.gif" alt="Ver ranking completo" width="148" height="10" border="0" class="Gvermasimage" /></a></div></td>
  </tr>
<% } %>    
</table>