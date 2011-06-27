<%@ page import="com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals,
                 com.tmk.service.categoria.CategoriaService" %>
                 
                 
                

<table width="155" border="0" cellspacing="0" cellpadding="0">
<%
String idArticulos = "";
for (int x=0; x<Contenido.getSite().getRanking().getRankingSeccion().length; x++) {
	if (Contenido.getSite().getRanking().getRankingSeccion(x).getId() == Globals.SECCION_LIBRO) {
		for (int i=0; i<Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo().length; i++) {
			if (Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getNombre().equals("Ficcion")) {
				for (int j=0; j<Math.min(Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getListaProductosTypeItem().length, 5); j++) {
					idArticulos = idArticulos +  Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getListaProductosTypeItem(j).getProducto().getId() + ",";
				}
				break;
			}
		}
	}
	break;
}

ArticuloClass articulos[] = null;

if (idArticulos.length() > 1) {
	idArticulos = idArticulos.substring(0, idArticulos.length()-1);
	articulos = ArticuloManager.getArticulosParaTopDeLibros(idArticulos);
}
%> 

 <% if(articulos != null  && articulos.length>0){ %>
  <tr>
    <td>
    	<table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">
      <tr>
        <td class="titulosceldas"><table width="155" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
            <tr>
              <td><img src="/imagenes/libros/t-topficcion.gif" alt="TOP10 Ficci&oacute;n" width="94" height="10" /></td>
            </tr>
        </table></td>
      </tr>
      <% for (int i=0; i<articulos.length; i++) { %>
      <tr>
        <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="toptabla">
            <tr>
              <td rowspan="2" class="topnumeros"><img src="/imagenes/libros/top-<%=i+1 %>.gif" alt="Puesto <%=i+1%>" width="15" height="17" /></td>
              <td width="152"><div align="left"><span class="FProductos"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %></a></span><br />
                      <%
			          	  	String atributoPrincipal = "";
			          	  	if (articulos[i].getAtributoPrincipal() != null) {
	            				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
								articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),
								new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
								atributoPrincipal = articulos[i].getAtributoPrincipal() + " - ";
		          	  %>
                      <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores1"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a><br>
                      <%}%>
                      </a><span class="Fprecio"><%=Contenido.precioToString(articulos[i].getPrecio())%></span><a href="#" class="FCategorias"><br>
                  </a></div></td>
            </tr>
            <tr>
              <td width="152">
              <div align="left">
              		<table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
      	            	<tr>
      	                	<td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><img src="/imagenes/libros/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" border="0" /></a></td>
      	                  	<td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) {%><a href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/libros/b-comprar.gif" alt="Comprar"  border="0"/></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/libros/b-pedir.gif" alt="Comprar"  border="0"/></a><%}%></td>
                        </tr>
                    </table>
              </div>
              </td>   	
            </tr>
        </table></td>
      </tr>
      <% } %> 
      <tr>
        <td><div align="left"><a href="/ranking/index.jsp?idSeccion=1&nombreGrupo=Ficcion"><img src="/imagenes/libros/b-ranking.gif" alt="Ver ranking completo" width="136" height="8" border="0" class="Gvermasimage" /></a></div></td>
      </tr>
    </table></td>
  </tr>
 <%} %> 
 
<%
idArticulos = "";
for (int x=0; x<Contenido.getSite().getRanking().getRankingSeccion().length; x++) {
	if (Contenido.getSite().getRanking().getRankingSeccion(x).getId() == Globals.SECCION_LIBRO) {
		for (int i=0; i<Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo().length; i++) {
			if (Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getNombre().equals("No Ficcion")) {
				for (int j=0; j<Math.min(Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getListaProductosTypeItem().length, 1); j++) {
					idArticulos = idArticulos +  Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getListaProductosTypeItem(j).getProducto().getId() + ",";
				}
				break;
			}
		}
	}
	break;
} 

articulos = null;

if (idArticulos.length() > 1) {
	idArticulos = idArticulos.substring(0, idArticulos.length()-1);
	articulos = ArticuloManager.getArticulosParaTopDeLibros(idArticulos);
}

%>
 <% if(articulos != null  && articulos.length>0){ %>
  <tr>
    <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">
      <tr>
        <td class="titulosceldas"><table width="155" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
            <tr>
              <td><img src="/imagenes/libros/t-topnoficcion.gif" alt="TOP10 No Ficci&oacute;n" width="117" height="10" /></td>
            </tr>
        </table></td>
      </tr>
      <% for (int i=0; i<articulos.length; i++) { %>
      
      <tr>
        <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="toptabla">
            <tr>
              <td rowspan="2" class="topnumeros"><img src="/imagenes/libros/top-<%=i+1%>.gif" alt="Puesto <%=i+1%>" width="15" height="17" /></td>
              <td width="152"><div align="left"><span class="FProductos"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %></a></span><br />
               <%   String atributoPrincipal = "";
	          	  	if (articulos[i].getAtributoPrincipal() != null) {
           				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
						articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),
						new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
						atributoPrincipal = articulos[i].getAtributoPrincipal() + " - ";
          	   %>
               		    <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores1"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a><br>
               <%   }%>
                      </a><span class="Fprecio"><%=Contenido.precioToString(articulos[i].getPrecio())%></span><a href="#" class="FCategorias"><br />
                  </a></div></td>
            </tr>
             <tr>
	             <td  width="152">
	              <div align="left">
	              		<table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
	      	            	<tr>
	      	                	<td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><img src="/imagenes/libros/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" border="0" /></a></td>
	      	                  	<td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) {%><a href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/libros/b-comprar.gif" alt="Comprar"  border="0"/></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/libros/b-pedir.gif" alt="Comprar"  border="0"/></a><%}%></td>
	                        </tr>
	                    </table>
	              </div>
	              </td>   	
            </tr>
        </table></td>
      </tr>
	  <%} %>      
      <tr>
        <td><div align="left"><a href="/ranking/index.jsp?idSeccion=1&nombreGrupo=No Ficcion"><img src="/imagenes/libros/b-ranking.gif" alt="Ver ranking completo" width="136" height="8" border="0" class="Gvermasimage" /></a></div></td>
      </tr>      
    </table></td>
  </tr>
  <%} %> 
   
 
  
</table>