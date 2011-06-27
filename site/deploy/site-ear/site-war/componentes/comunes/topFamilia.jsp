<%@page import="com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals,
                 com.tmk.service.categoria.CategoriaService,
                 com.tmk.controllers.MainHelper"%>
<% 
int seccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION),Globals.SECCION_LIBRO);
int grupo = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_GRUPO),-1);
int familia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_FAMILIA),-1);

ArticuloClass articulos[] = ArticuloManager.getArticulosParaTop (seccion, grupo, familia, 5);
%>

<% if (articulos != null && articulos.length>0) { %>    
 <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">
	<%if(seccion==Globals.SECCION_LIBRO){ %>	
  		 <tr>
            <td class="titulosceldas"><table width="155" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
                <tr>
                     <td><img src="/imagenes/libros/t-masvendidos.gif" alt="Mas vendidos" width="96" height="10" /></td>
                </tr>
           </table></td>
         </tr>
	<%}else{ %>         
          <tr>
             <td class="titulosceldas"><img src="/imagenes/<%=Globals.seccion(seccion)%>/t-masvendidos.gif" <%if(seccion==Globals.SECCION_JUGUETES){%>alt="Mas vendidos de Pasatiempos"<%}else{%>alt="Los m&aacute;s vendidos"<%} %> /></td>
          </tr>
    <%} %>
	<% for (int i=0; i<articulos.length && i<5; i++) { %>    
          <tr>
              <td><table width="155" border="0" cellpadding="0" cellspacing="0" class="toptabla">
                  <tr>
                     <td rowspan="2" class="topnumeros"><img src="/imagenes/<%=Globals.seccion(seccion)%>/top-0<%=i+1%>.gif" alt="Puesto <%=i+1%>" /></td>
                     <td width="152"><div align="left"><span class="FProductos"><a class="FProductos" href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %></a></span><br />
                        <%  String atributoPrincipal = "";
			          	  	if (articulos[i].getAtributoPrincipal() != null) {
	            				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
									articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),
									new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
								atributoPrincipal = articulos[i].getAtributoPrincipal() + " - "; 	
		          	  	%>
                           <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a><br/>
                        <%} %> 
                           </a><span class="Fprecio"><%=Contenido.precioToString(articulos[i].getPrecio())%></span><br />
                           </div></td>
                  </tr>
                  <tr>
                     <td width="152" class="topcompracelda">
	                     <div align="left">
		              		<table width="2" border="0" cellspacing="0" cellpadding="0">
	    	  	            	<tr>
	      		                	<td height="19" class="divInfo"><a class="FProductos" href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><img src="/imagenes/<%=Globals.seccion(seccion)%>/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true)%>" border="0"/></a></td>
	      	    	              	<td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) {%><a href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(seccion)%>/b-comprar.gif" alt="Comprar"  border="0"/></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(seccion)%>/b-pedir.gif" alt="Comprar"  border="0" class="espacioizquierda"/></a><%}%></td>
	                	        </tr>
	                    	</table>
	            		</div>
                     </td>
                  </tr>
              </table></td>
           </tr>
	<%} %>     
	<!-- ETAPA 2 -->      
           <!-- tr>
             <td><div align="left"><a href="#"><img src="/imagenes/<%//=Globals.seccion(seccion)%>/b-ranking.gif" alt="Ver ranking completo"  border="0" class="Gvermasimage" /></a></div></td>
           </tr-->
  	<!-- ETAPA 2 -->                 
 </table></td>
<%} %>                       