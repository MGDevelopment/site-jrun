<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.bus.articulo.ArticuloClass,
				 com.tmk.bus.articulo.ArticuloManager,
				 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
				 com.tmk.controllers.buscador.BuscadorHelper,
				 java.text.DecimalFormat,
				 com.tmk.controllers.buscador.BusquedaPorIDdeEditorial,
				 com.tmk.controllers.buscador.BusquedaPorCategorias,
				 com.tmk.kernel.DisponibilidadDAO,
				 com.tmk.kernel.IdiomaDAO,
				 com.tmk.setup.ImageServer,
				 com.tmk.setup.Contenido"%>
<%
int idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0);
String generacion = request.getParameter("generacion");
ArticuloClass articulo = ArticuloManager.getDetalleDeArticulo(idArticulo, idSeccion);
%>
<td class="Gcentro">
	            <!-- Atributos -->
	            <%
				//int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), Globals.SECCION_LIBRO);
				//String idArticulo = Convert.toString(request.getParameter("idArticulo"));
				%>
				<%try {
					if (articulo.getIdArticulo() != -1) {
						DecimalFormat formato = new DecimalFormat ("0.00");
				%>

						<table width="375" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
						    	<td>
									<table width="375" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
									    	<td width="10" rowspan="3" valign="top">
									    	<%
											String imgPage = "/componentes/comunes/imagenDetalle.jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + articulo.getIdSeccion() +
													"&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulo.getIdSeccion()][5] + "&alto=" + Globals.tamImagen[articulo.getIdSeccion()][6] + "&esNovedad=" + articulo.esNovedad() +
													"&titulo=" + Convert.corregir(articulo.getTitulo(), true).toUpperCase();
											%>
										    	<jsp:include page="<%=imgPage %>"/>
									    	</td>

									        <td width="376" valign="top"><div align="left"><h1 class="FProductosDetalle"><%=Convert.corregir(articulo.getTitulo(), true).toUpperCase()%></h1>
											<%
							          	  	if (articulo.getAtributoPrincipal() != null) {
						           				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
												articulo.getAtributoPrincipal(), articulo.getIdAtributoPrincipal(), new Integer(articulo.getIdSeccion()),
												new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).estaDisponible());%>
									        	<h2 class="fontautoresDetalle"><a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="fontautoresDetalle"><%=articulo.getAtributoPrincipal().toUpperCase() %></a></h2></div>
									        <%}%>
									        </td>
									    </tr>
									    <tr>
						                  	  <%if (idSeccion == Globals.SECCION_LIBRO) {%>
							                  	  <td valign="top" class="celdaDetalle"><div class="FProductosDetalle2" align="left">ISBN: <%=articulo.getISBN()%><br />
										          <%if (articulo.getEditorial() != null && !"".equals(articulo.getEditorial())){ %>
										          <%BusquedaPorIDdeEditorial busquedaPorIDEditorial = new BusquedaPorIDdeEditorial(Convert.nombrePropio(articulo.getEditorial(), false), new Integer(articulo.getIdEditorial())
										        		  , new Integer(idSeccion), new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).estaDisponible()); %>
										                  Editorial: <a href="<%=busquedaPorIDEditorial.salto()%>" class="FProductosDetalle2link"><%=Convert.nombrePropio(articulo.getEditorial(), false)%></a><br />
										          <%} %>
										      <%if (articulo.getGrupo() != null && !"".equals(articulo.getGrupo())) { %>
										      		<%BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(articulo.getGrupo(), new Integer(idSeccion), new Integer(articulo.getIdGrupo()), (Integer)null, (Integer)null,
										      				new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).estaDisponible()); %>
											  		Clasificaci&oacute;n: <a href="<%=busquedaPorCategoria.salto()%>" class="FProductosDetalle2link"><%=Convert.corregir(articulo.getGrupo(), true)%></a><br />
										      <%} %>
										      <%if (articulo.getPagina() > 0) { %>
											        P&aacute;ginas: <%=articulo.getPagina()%> <br />
											  <%} %>
											        Publicaci&oacute;n: <%=Convert.toStringPublicacion(articulo.getFechaAlta())%>  <%if (articulo.getIdioma()!=null) {%>| Idioma: <%=IdiomaDAO.buscaIdioma(articulo.getIdioma()).getNombre()%><%} %><br />
						                      <%if (articulo.getFormato() != null && !"".equals(articulo.getFormato())) { %>
								                      Formato: <%=articulo.getFormato()%>
								                      <br />
						                      <%} %>

											  <% if(articulo.getPeso() > 0) { %>
					                      			Peso: <%=Convert.toGramos(articulo.getPeso())%>
													<br/>
											  <% } %>

											   <% if(articulo.getMedidas() != null) { %>
					                      		Medidas: <%=articulo.getMedidas()%>
				                      		        <br />
										 	 <% } %>
											      </div></td>
										      <%} %>

										      <%if (idSeccion == Globals.SECCION_JUGUETES) {%>
											      <td valign="top" class="celdaDetalle"><div class="FProductosDetalle2" align="left">A&ntilde;o: <%=Convert.toStringPublicacion(articulo.getFechaAlta())%><br />
								                  </div></td>
											  <%} %>

										      <%if (idSeccion == Globals.SECCION_MUSICA) {%>
											      <td valign="top" class="celdaDetalle"><div class="FProductosDetalle2" align="left">
											      <%if (articulo.getEditorial() != null && !"".equals(articulo.getEditorial())){ %>
											          <%BusquedaPorIDdeEditorial busquedaPorIDEditorial = new BusquedaPorIDdeEditorial(Convert.nombrePropio(articulo.getEditorial(), false), new Integer(articulo.getIdEditorial())
											        		  , new Integer(idSeccion), new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).estaDisponible()); %>
												      Sello discogr&aacute;fico: <a href="<%=busquedaPorIDEditorial.salto()%>" class="FProductosDetalle2link"><%=Convert.nombrePropio(articulo.getEditorial(), false).toUpperCase()%></a><br />
											      <%} %>
								                    A&ntilde;o: <%=Convert.toStringPublicacion(articulo.getFechaAlta())%><br />
								                  <%if (articulo.getFormato() != null && !"".equals(articulo.getFormato())) { %>
							                      	Soporte: <%=Convert.nombrePropio(articulo.getFormato(), false)%>
								                  <%} %>
							            	      </div></td>
											  <%} %>

				 						      <%if (idSeccion == Globals.SECCION_PELICULA) {%>
												  <td valign="top" class="celdaDetalle"><div class="FProductosDetalle2" align="left">
												  <%if (articulo.getEditorial() != null && !"".equals(articulo.getEditorial())){ %>
										          <%BusquedaPorIDdeEditorial busquedaPorIDEditorial = new BusquedaPorIDdeEditorial(Convert.nombrePropio(articulo.getEditorial(), false), new Integer(articulo.getIdEditorial())
										        		  , new Integer(idSeccion), new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).estaDisponible()); %>
												  Productora: <a href="<%=busquedaPorIDEditorial.salto()%>" class="FProductosDetalle2link"><%=Convert.nombrePropio(articulo.getProductora(), false)%></a><br />
												  <%} %>
							                      Estreno: <%=Convert.toStringPublicacion(articulo.getFechaAlta())%><br />
							                      <%if (articulo.getFormato() != null && !"".equals(articulo.getFormato())) { %>
							                      Formato: <%=articulo.getFormato()%>
							                      <br />
							                      <%} %>
						                          <%if (articulo.getGrupo() != null && !"".equals(articulo.getGrupo())) { %>
									      		  <%BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(articulo.getGrupo(), new Integer(idSeccion), new Integer(articulo.getIdGrupo()), (Integer)null, (Integer)null,
									      				new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).estaDisponible()); %>
										          		G&eacute;nero:  <a href="<%=busquedaPorCategoria.salto() %>" class="FProductosDetalle2link"><%=Convert.nombrePropio(articulo.getGrupo(), false)%></a><br />
							              		  <%} %>
							                      <%if(articulo.getPagina()>0) {%>Duración: <%=articulo.getPagina()%> min.<%}%>
							                      <br />
								                  </div></td>
				  							  <%} %>
									    </tr>
									    <tr>
										    <td class="celdaDetalle2"><div align="left"><span class="Ftexto01">*<%=DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).getNombre()%></span><br />
										    <%String pathImgGde = ImageServer.obtenerNombreDeTapa(articulo.getIdArticulo(), false, idSeccion, new Double (articulo.getPorcentajeDescuento()).intValue(), "", articulo.esNovedad()); %>
										    <% if (pathImgGde!= null && !"".equals(pathImgGde)) {%>
										    <a href="javascript:mostrarImagen('<%=pathImgGde%>');" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-ampliar imagen.gif" alt="Ampliar Imagen" border="0" class="bAmpliarImagen" /></a>
											<%} %>
									        </div></td>
									    </tr>
									</table>
								</td>
						    </tr>
						    <tr>
						      <td>
						      	<table width="375" border="0" cellpadding="0" cellspacing="0" class="areaCompra">
						        	<tr>
						          		<td width="278" class="Ftexto02">PRECIO <%=Contenido.precioToString(articulo.getPrecio())%> | <%=Contenido.precioDollarToString(articulo.getPrecio())%> | <%=Contenido.precioEuroToString(articulo.getPrecio())%></td>
								        <td width="108"><div align="right"><%if (DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).estaDisponible() && articulo.getHabilitadoTematika().equals("S")) { %><a href="javascript:agregarProducto(<%=articulo.getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar-detalle.gif" alt="Comprar"  border="0" /></a><%} else {%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulo.getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Pedir"  border="0" /></a><%} %></div></td>
						        	</tr>
							    </table>
							  </td>
						    </tr>

				<script language="javascript" type="text/javascript">
				function traerPalnes() {

				    http.open('get', '/articulo/componentes/planDeCuotas.jsp?precio=<%=formato.format(articulo.getPrecio()).replaceAll(",", ".")%>&param=' + Math.random());
				    http.onreadystatechange = plan;
				    http.send(null);
				}

				function plan() {
				    if(http.readyState == 4){
				        var response = http.responseText;
				        document.getElementById('planDeCuotas').innerHTML = response;
				    }
				}
				</script>
						    <tr>
						    	<td>
						    		<div id="planDeCuotas">
						    		<div>
						    	</td>
						    	<script language="javascript" type="text/javascript">
						    		traerPalnes();
						    	</script>
						    </tr>
						     <tr>
						      <td>
						      	<script type="text/javascript">
								function mostrarDiv(id){
									if(document.getElementById(id).style.display== "none") {
										document.getElementById(id).style.display = "block";
									} else {
										document.getElementById(id).style.display = "none";
									}
								}
								</script>
						      	<table width="375" border="0" cellpadding="0" cellspacing="0" class="areaAcciones">
					                  <tr>
					                    <td><div class="areaAccionesComp"><a href="javascript:mostrarDiv('compartir');"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-compartir.gif" alt="Compartir con mis amigos" width="302" height="25" border="0" /></a></div></td>
					                  </tr>
					                  <tr>
					                    <td><div class="areaAccionesListaDes"><a href="/AgregarEnLista?ID_ARTICULO=<%=articulo.getIdArticulo()%>" rel="nofollow" alt="Agregar a mi lista de deseos" class="fFooter"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-listaDeseos.gif" alt="Agregar a mi lista de deseos" width="182" height="8" border="0" /></a></div></td>
					                  </tr>
			                	</table>
					      	</td>
					    </tr>

					    <tr>
                    		<td align="left">
	           	            <%
		    		            String urlPage = Globals.DOMINIO_SITIO + "/articulo/indiceDeContenidos.jsp?idArticulo=" + articulo.getIdArticulo();
					            String titulo = Convert.corregir(articulo.getTitulo(), true);
				            %>
					            <div id="compartir" style="display:none;">

					            </div>
					            <script language="javascript" type="text/javascript">
						    		traerCompartir('<%=urlPage%>', '<%=titulo%>');
						    	</script>

	        	            </td>
             		 	</tr>
             		 </table>
					<%}%>
				<%
				} catch(Exception e) {

				}
				%>
	            <!-- Atributos -->
            </td>
            <td valign="top">
				<div id="moduloExtra">
				</div>
            </td>
          </tr>
          <tr>
            <td class="Gcentro" width="422"><table width="375" border="0" align="center" cellpadding="0" cellspacing="0">
          <%
          	String indice = ArticuloManager.getIndice(idArticulo);
          %>

          <% if (indice!=null && !"".equals(indice)) { %>
              <tr>
                <td>
                	<table width="375" border="0" align="center" cellpadding="0" cellspacing="0" class="modulosmedioDetalle">
	                  <tr class="modulorecomendadosd">
    		                <td class="titulosceldas">
    		                	<table width="375" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
			                        <tr>
            			              <td>
            			              <a name="titulo">
            			              <img src="/imagenes/<%=Globals.seccion(articulo.getIdSeccion())%>/t-indicecontenidos.gif" alt="Indice de Contenidos"/>
            			              </a>
            			              </td>

                        			</tr>
			                    </table>
			                </td>
	                  </tr>
	                  <tr>
    	                <td class="modulosinopsis"><h2 class="Ftexto06"><b></b></h2>
						<span class="Ftexto06">
						<% if (indice != null && !"".equals(indice)) {
							indice = indice.replaceAll("Indice de contenidos de este Libro", "");
					    %>
                        <%=indice.replaceAll("\r", "<p>").replaceAll("\n", "<br>").replaceAll("<pre", "<span").replaceAll("pre>", "span>")%>

                        <% }%>
						</span></td>
            	      </tr>
				    </table>
				</td>
              </tr>
          	<%} %>
              <tr>
                <%
           		String linksDeContenidosPage = "/articulo/componentes/linksDeContenidos.jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + articulo.getIdSeccion() + "&titulo=" + Convert.corregir(articulo.getTitulo(), true).toUpperCase() + "&generacion=" + generacion;
           	    %>
                <jsp:include page="<%=linksDeContenidosPage%>"/>
              </tr>
             </table></td>
            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0">
                <%
           		String busquedaPage = "/articulo/componentes/busquedaCategoria.jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + articulo.getIdSeccion();
           	    %>
                <jsp:include page="<%=busquedaPage%>"/>
                <%
           		String rcoAutorPage = "/articulo/componentes/recomendacionPorAutor.jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + articulo.getIdSeccion();
           	    %>
                <jsp:include page="<%=rcoAutorPage%>"/>
                <%
           		String rcoArticuloPage = "/articulo/componentes/recomendacionPorArticulo.jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + articulo.getIdSeccion();
           	    %>
                <jsp:include page="<%=rcoArticuloPage%>"/>

                </table></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <tr>
             <td colspan="3"><% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion="+ Globals.SECCION_HOME;%>
				 <jsp:include page="<%=urlInstitucional%>"/></td>
          </tr>
          <tr>
            <td colspan=3 align="center"><div class="Gfooter3">
	           <div class="Gfooter3"><h3 class="Ftextopie"><b><%=Convert.corregir(articulo.getTitulo(), true)%> - <%=articulo.getAtributoPrincipal()%> - <%=Convert.corregir(Globals.seccion(idSeccion), true)%></b></h3></div>
	           </div>
            </td>
          </tr>