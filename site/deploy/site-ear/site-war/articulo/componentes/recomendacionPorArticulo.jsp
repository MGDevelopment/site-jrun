<%@ page import="java.util.Vector,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.service.categoria.CategoriaService,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert"%>
		<%
			Integer idArticulo = new Integer(Convert.toNumber(request.getParameter("idArticulo"), Globals.ARTICULO_DEFAULT));

			Vector articulosRecomendados = DBUtil.articulosRecomendadosPorArticulo(idArticulo.intValue(), 5);
		    Vector idsArticulosRecomendados = new Vector();
		    idsArticulosRecomendados.add(0,idArticulo);

			if (!articulosRecomendados.isEmpty()) {
				for (int i=0; i < articulosRecomendados.size(); i=i+3) {
					idsArticulosRecomendados.add(articulosRecomendados.get(i));
				}
				ArticuloClass articulos[] = ArticuloManager.getArticulosParaUltimosVisitados(idsArticulosRecomendados.toString().replaceAll("\\[","").replaceAll("\\]", ""));
		%> <tr>
                <td><table class="Glosqcomprarontabla" width="162" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td class="Glosqcompraronceldaop"><span class="Ftexto02">LOS QUE COMPRARON </span><a href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>" class="Fdetalledestacado"><%=Convert.corregir(articulos[0].getTitulo(),true).toUpperCase() %></a><span class="Ftexto02"> TAMBIEN COMPRARON:</span></td>
                  </tr>
		<%
				for (int i=1; i<articulos.length; i++) {

		%>
                  <tr>
                    <td><table class="Glosqcomprarontablaprod" width="162" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td class="FProductos"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><%=Convert.corregir(articulos[i].getTitulo(),true)%></a><br />
                           <%if(articulos[i].getAtributoPrincipal()!= null) { 
                        	   	BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(articulos[i].getAtributoPrincipal(), 
                        	   																					articulos[i].getIdAtributoPrincipal(), 
                        	   																					new Integer(articulos[i].getIdSeccion()),
                        	   																					new Integer (1), 
                        	   																					new Integer(10), 
                        	   																					BuscadorHelper.CRIT_FECHA_NV, 
                        	   																					!DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());%>
                           		<a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=Convert.corregir(articulos[i].getAtributoPrincipal(),true)%></a>
                           <%} %>
                          </td>
                        </tr>
                    </table></td>
                  </tr>
		<%
				}
		%>

                </table></td>
            </tr>
         <%
         	}
         %>
