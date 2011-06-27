<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.controllers.buscador.BusquedaPorCategorias,
                 com.tmk.setup.Contenido,
                 com.tmk.service.categoria.CategoriaService"%>

		<%
		 String idsArt = request.getParameter("idsArt");
		 String idSocio = request.getParameter("idSocio");
		 String idSucursal = request.getParameter("idSucursal");
		 boolean eliminar = Convert.toBoolean(request.getParameter("eliminar"), false);
 		 if (!"".equals(idsArt) & idsArt != null) {
		 	ArticuloClass [] articulos = ArticuloManager.getArticulosParaUltimosVisitados(
       		  idsArt);
         %>

         <% for (int i=0; i<articulos.length; i++) { %>
         <table width="390" border="0" cellspacing="0" cellpadding="0" class="moduleproductob">
               <tr>
                 <td><table width="390" border="0" cellspacing="0" cellpadding="0">
                     <tr>
                       <td width="82" rowspan="2" class="celdafoto">
                       <%	String imgPage = "/componentes/comunes/imagenBusqueda.jsp?idArticulo=" + articulos[i].getIdArticulo() + "&idSeccion=" + articulos[i].getIdSeccion() +
							"&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulos[i].getIdSeccion()][3] + "&alto=" + Globals.tamImagen[articulos[i].getIdSeccion()][4] + "&esNovedad=" + articulos[i].esNovedad() +
							"&titulo=" + Convert.corregir(articulos[i].getTitulo(), true).toUpperCase();
						%>
						<a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><jsp:include page="<%=imgPage%>"/></a>
                       </td>
                       <td colspan="2" valign="top" class="celdacontenido"><span class="FProductos"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase()%></a></span><br />
						<%if (articulos[i].getAtributoPrincipal()!= null) {
							BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),new Integer (1), new Integer(10), BuscadorHelper.CRIT_FECHA_NV, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
						%>
                           <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a><br />
                           <%}%>
                           <% BusquedaPorCategorias busquedaPorCategorias = new BusquedaPorCategorias(articulos[i].getGrupo(), new Integer(articulos[i].getIdSeccion()),new Integer(articulos[i].getIdGrupo()),(Integer)null, (Integer)null, new Integer(1), new Integer(0),BuscadorHelper.CRIT_FECHA_NV, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());%>
                           <a href="<%=busquedaPorCategorias.salto()%>" class="Fautores">Subcategoria</a> <span class="Fprecio"><%=Convert.corregir(articulos[i].getGrupo(), true)%></span></td>
                     </tr>
                     <tr>
                       <td width="201" valign="bottom" class="celdapreciocomprar"><div align="left"><span class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[i].getPrecio())%></span></div></td>
                       <td valign="bottom">
                       <%if  (eliminar) {%>
						<div align="right"><a href="/BorrarDeLista?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>"><img src="/imagenes/listaDeseos/b-eliminar.gif" alt="Eliminar" border="0" /></a></div>
						<%} else { %>
                       <%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) { %>
                       <div align="right"><a href="/AgregarProducto?articulo=<%=articulos[i].getIdArticulo()%>&ID_SUCURSAL=<%=idSucursal%>&ID_SOCIO=<%=idSocio%>"><img src="/imagenes/listaDeseos/b-reglar.gif" alt="Regalar" width="49" height="8" border="0" /></a></div>
    	                <%}
                       	}%>
                       </td>
                       </tr>
                 </table></td>
               </tr>
           </table>
           <%}%>
         <%} %>