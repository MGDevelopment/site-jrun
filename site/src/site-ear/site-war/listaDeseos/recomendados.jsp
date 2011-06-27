<%@ page import="java.util.Vector,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.setup.Contenido,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.service.categoria.CategoriaService"%>
<%
	SocioPK socioPK = new SocioPK(Integer.valueOf(request.getParameter("ID_SUCURSAL")), Integer.valueOf(request.getParameter("ID_SOCIO")));

try {

		Vector recomendados = com.tmk.kernel.DBUtil.articulosRecomendadosCompra(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO), 5);

		if (!recomendados.isEmpty()){
			ArticuloClass articulosRecomendados[] = ArticuloManager.getArticulosParaUltimosVisitados(recomendados.toString().replaceAll("\\[","").replaceAll("\\]", ""));
			if (articulosRecomendados != null && articulosRecomendados.length >0) {
 %>
          <tr>
            <td>
            	<table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">
              	  <tr>
                  <td class="titulosceldas"><img src="/imagenes/listaDeseos/t-recomendadoslista.gif" alt="TOP100 Libros" width="85" height="12" /></td>
    	          </tr>
    	          <%
	  	for(int index = 0; index < Math.min(recomendados.size(), 5); index++) {
	  %>
        	      <tr>
            	    	<td>
            	    		<table width="152" border="0" cellpadding="0" cellspacing="0" class="toptabla">


                       <tr>
        				              <td width="152"><div align="left"><span class="FProductos">
        				              <a href="<%=CategoriaService.getURL(articulosRecomendados[index].getCategoria())+ArticuloManager.getURL(articulosRecomendados[index])%>" class="FProductos"><%=Convert.corregir(articulosRecomendados[index].getTitulo(), true).toUpperCase()%></a></span><br />
                        			      <%
                        			      String atributoPrincipal = "";
	 					          	  	  if (articulosRecomendados[index].getAtributoPrincipal() != null) {
					           			      BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
											  articulosRecomendados[index].getAtributoPrincipal(), articulosRecomendados[index].getIdAtributoPrincipal(), new Integer(articulosRecomendados[index].getIdSeccion()),
											  new Integer (1), new Integer(10), BuscadorHelper.CRIT_FECHA_NV, !DisponibilidadDAO.buscaDisponibilidad(articulosRecomendados[index].getIdDisponibilidad()).estaDisponible());
											  atributoPrincipal = articulosRecomendados[index].getAtributoPrincipal() + " - ";
										  %>
                        			      <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=articulosRecomendados[index].getAtributoPrincipal().toUpperCase()%></a><%}%><br>

                        			      <span class="Fprecio"> <%=Contenido.precioToString(articulosRecomendados[index].getPrecio())%></span><br></div>
        				              </td>
                       </tr>
        			            <tr>
                    		  		  <td width="152"><div align="left">
                              <table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
            						          <tr>
	                                  <td height="19" class="divInfo">
	                                  	<a href="<%=CategoriaService.getURL(articulosRecomendados[index].getCategoria())+ArticuloManager.getURL(articulosRecomendados[index])%>"><img src="/imagenes/<%=Globals.seccion(Globals.SECCION_HOME)%>/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulosRecomendados[index].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulosRecomendados[index].getTitulo(), true)%>" width="34" height="8" border="0" /></a></td>
                			 		              <%if (DisponibilidadDAO.buscaDisponibilidad(articulosRecomendados[index].getIdDisponibilidad()).estaDisponible() && articulosRecomendados[index].getHabilitadoTematika().equals("S")) { %>
                  			 		              <td class="divComprarPedir"><a href="javascript:agregarProducto(<%=articulosRecomendados[index].getIdArticulo()%>);window.scrollTo(0,0);"><img src="/imagenes/<%=Globals.seccion(Globals.SECCION_HOME)%>/b-comprar.gif" alt="Comprar" width="52" height="8" border="0" /></a></td>
                			 		              <% } else {%>
                			 		              <td class="divComprarPedir"><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulosRecomendados[index].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(Globals.SECCION_HOME)%>/b-pedir.gif" alt="Comprar"  border="0"/></a></td>
                            			      <% } %>
	                              </tr>
                              </table>
            				          </div></td>
                       </tr>
        			        </table>
        			    </td>
	               </tr>
	               <%
	               	 }
    	           %>
    	          <!--ETAPA II  -->
              <!-- tr>
                <td><div align="left"><a href="#"><img src="/imagenes/<%//=Globals.seccion(Globals.SECCION_HOME) %>/b-vertodos.gif" alt="Ver ranking completo" width="52" height="7" border="0" class="Gvermasimage" /></a></div></td>
              </tr-->
            </table></td>
          </tr>
            <%		}
	}
} catch (Exception e){

}
 %>