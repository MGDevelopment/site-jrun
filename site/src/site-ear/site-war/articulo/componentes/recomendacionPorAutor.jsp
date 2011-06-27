<%@ page import="java.util.Vector,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.controllers.buscador.BuscadorHelper,
				 com.tmk.kernel.Globals,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.kernel.DBUtil,
                 com.tmk.service.categoria.CategoriaService"%>
		<%
				Integer idArticulo = Convert.toNumber(request.getParameter("idArticulo"), Globals.ARTICULO_DEFAULT);
				int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0);
				String role = (idSeccion == Globals.SECCION_PELICULA)?"'E01', 'D02'":"'A01'";

				Vector articulosRecomendados = DBUtil.articulosRecomendadosPorAutor(idArticulo.intValue(),role, 5);
			    Vector idsArticulosRecomendados = new Vector();

			    idsArticulosRecomendados.add(0,idArticulo);

				if (!articulosRecomendados.isEmpty()) {
					for (int i=0; i < articulosRecomendados.size(); i++) {
						idsArticulosRecomendados.add(articulosRecomendados.get(i));
					}

					ArticuloClass articulos[] = ArticuloManager.getArticulosParaUltimosVisitados(idsArticulosRecomendados.toString().replaceAll("\\[","").replaceAll("\\]", ""));
		%>

				<tr>
					<td><table class="Glosqcomprarontabla" width="162" border="0" cellspacing="0" cellpadding="0">
			           <tr>
	                    <td class="Glosqcompraronceldaop"><span class="Ftexto02">LOS QUE COMPRARON OBRAS DE </span>
	                    <a
	        <%if (articulos[0].getAtributoPrincipal()!= null) { BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipalUno = new BusquedaPorAtributoPrincipal(articulos[0].getAtributoPrincipal(), articulos[0].getIdAtributoPrincipal(), new Integer(articulos[0].getIdSeccion()),new Integer (1), new Integer(10), BuscadorHelper.CRIT_FECHA_NV, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible());%>
	                     href="<%=busquedaPorAtributoPrincipalUno.buscador.salto()%>"
	        <%}%>
	                 	class="Fdetalledestacado"><%=Convert.corregir(articulos[0].getAtributoPrincipal(),true).toUpperCase()%>
	                 	</a>

	                    <span class="Ftexto02"> TAMBIEN COMPRARON:</span></td>

	                  </tr>
			<%
				for (int i=1; i<articulos.length; i++) {
			%>
	                  <tr>
	                    <td><table class="Glosqcomprarontablaprod" width="162" border="0" cellspacing="0" cellpadding="0">
	                      <tr>
	                        <td><span class="FProductos"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductos"><%=Convert.corregir(articulos[i].getTitulo(),true)%></a></span><br />
							 <%if (articulos[i].getAtributoPrincipal()!= null) { BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),new Integer (1), new Integer(10), BuscadorHelper.CRIT_FECHA_NV, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());%>
	                          <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=Convert.corregir(articulos[i].getAtributoPrincipal(),true)%></a>
	                         <%}%>
	                        </td>
	                      </tr>
	                    </table></td>
	                  </tr>
			<%
						}
			%>
	                  <!-- tr class="modulosderecha">
	                    <td><div align="left"><a href="#"><img src="/imagenes/libros/b-vertodos.gif" alt="Ver todos" width="61" height="8" border="0" class="Gvermasimage" /></a></div></td>
	                  </tr-->

	                </table></td>
	            </tr>

	         <%
	         	}
	         %>
