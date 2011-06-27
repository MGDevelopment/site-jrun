<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.IdiomaDAO,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.controllers.buscador.BusquedaGenerica,
                 com.tmk.controllers.buscador.CriterioDAO,
                 com.tmk.setup.ImageServer,
                 com.tmk.controllers.buscador.BusquedaPorCategorias,
                 com.tmk.controllers.buscador.BusquedaPorIDdeEditorial,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.setup.Contenido,
                 java.util.Date,
   				 java.net.URLEncoder,
                 java.util.regex.Pattern,
                 java.util.Calendar,
                 com.tmk.service.categoria.CategoriaService,
                 com.tmk.bus.categoria.CategoriaPK,
                 com.tmk.bus.categoria.Categoria"
%>
<%

int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_LIBRO);
// Lo crea vacio al comienzo por si alguna clasificacion no esta terminada, o si el usuario quita algun parametro intencionalmente
BusquedaGenerica busquedaDAO;

String textoABuscar = request.getParameter(BuscadorHelper.TEXTO);

textoABuscar = (textoABuscar != null)? textoABuscar.replaceAll("\\'", " "): null;

int claveCriterio = Convert.toNumber(request.getParameter(BuscadorHelper.CRITERIO_ORDEN),BuscadorHelper.CRIT_MAS_VENDIDOS.getClave().intValue());
CriterioDAO criterio = new CriterioDAO(new Integer(claveCriterio));

boolean pedidoEspecial = Convert.toBoolean(request.getParameter(BuscadorHelper.PEDIDO_ESPECIAL), false);
Integer registroInicial = Convert.toNumber(request.getParameter(BuscadorHelper.REGISTRO_INICIAL), new Integer(1));
Integer registroFinal = Convert.toNumber(request.getParameter(BuscadorHelper.REGISTRO_FINAL), new Integer(10));

Integer seccion = new Integer(idSeccion);
Integer grupo = Convert.toNumber(request.getParameter("idGrupo"), (Integer)null);
Integer familia = Convert.toNumber(request.getParameter("idFamilia"), (Integer)null);
Integer subfamilia = Convert.toNumber(request.getParameter("idSubFamilia"), (Integer)null);
StringBuffer paginaRecorrido = new StringBuffer();

CategoriaPK categoriaPK = new CategoriaPK(new Integer[]{seccion, grupo, familia, subfamilia});
Categoria categoria = CategoriaService.getCategoriaEspecifica(categoriaPK);


	paginaRecorrido.append("/catalogo");
	paginaRecorrido.append(CategoriaService.getURL(categoria));
	StringBuffer paginaRecorrido2 = new StringBuffer();
	paginaRecorrido2.append("/catalogo/?").append("idSeccion").append("=").append(seccion);
	if(grupo != null){
		paginaRecorrido2.append("&").append("idGrupo").append("=").append(grupo);
		if(familia != null){
			paginaRecorrido2.append("&").append("idFamilia").append("=").append(familia);
			if(subfamilia != null)
				paginaRecorrido2.append("&").append("idSubFamilia").append("=").append(subfamilia);
		}
	}


String descripcionCategoria = categoria.getSubCategoria()[0].getDescripcion();
if (categoria.getSubCategoria()[0].getSubCategoria() != null && categoria.getSubCategoria()[0].getSubCategoria().length>0) {
	descripcionCategoria = categoria.getSubCategoria()[0].getSubCategoria()[0].getDescripcion();
	if (categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria() != null && categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria().length>0) {
		descripcionCategoria = categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria()[0].getDescripcion();
	}
}
descripcionCategoria = Convert.capitalizar(descripcionCategoria, false);

busquedaDAO = new BusquedaPorCategorias(textoABuscar, seccion, grupo, familia, subfamilia, registroInicial, registroFinal, criterio, pedidoEspecial);

busquedaDAO.runQuerySubtotales();
%>

<div style="width: 650px; float: right; position:static;" >
		<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
		          <tr>

		            <td class="Gcentro" width="422">
		            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
						<%
							StringBuffer idsArticulo = new StringBuffer("");
							int cantArticulosPorPagina = 5;
							int paginaActual = (int)Math.ceil((double)registroInicial.intValue()/cantArticulosPorPagina);
							if (paginaActual == 1) {
								if (Contenido.getSite().getRecorridoPorTemas().getRecorridoSecciones() !=null) {
									com.tmk.kernel.site.RecorridoSeccion reSeccion[] = Contenido.getSite().getRecorridoPorTemas().getRecorridoSecciones().getRecorridoSeccion();
									for (int i=0; i<reSeccion.length; i++) {
										if (reSeccion[i].getId() == seccion.intValue()) {
											if (grupo != null) {
												if (reSeccion[i].getRecorridoGrupos() != null) {
													com.tmk.kernel.site.RecorridoGrupo reGrupo[] = reSeccion[i].getRecorridoGrupos().getRecorridoGrupo();
													for (int j=0; j<reGrupo.length; j++) {
														if (reGrupo[j].getId() == grupo.intValue()) {
															if (familia != null) {
																if (reGrupo[j].getRecorridoFamilias() != null) {
																	com.tmk.kernel.site.RecorridoFamilia reFamilia[] = reGrupo[j].getRecorridoFamilias().getRecorridoFamilia();
																	for (int k=0; k<reFamilia.length; k++) {
																		if (reFamilia[k].getId() == familia.intValue()) {
																			if (subfamilia != null) {
																				// No llega hasta subfamilia
																			} else {
																				com.tmk.kernel.site.Producto productos[] = reFamilia[k].getClaves().getProducto();
																				for (int m=0; m<productos.length; m++) {
																					if (productos[m].getVencimiento() == null || productos[m].getVencimiento().after(new Date())) {
																						idsArticulo.append(productos[m].getId()).append(",");
																					}
																				}
																			}
																		}
																	}
																}
															} else {
																if (reGrupo[j].getClaves() != null) {
																	com.tmk.kernel.site.Producto productos[] = reGrupo[j].getClaves().getProducto();
																	for (int l=0; l<productos.length; l++) {
																		if (productos[l].getVencimiento() == null || productos[l].getVencimiento().after(new Date())) {
																			idsArticulo.append(productos[l].getId()).append(",");
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}

							}
							for (int i = 0; i < busquedaDAO.subtotales().length; i++) {
								if ((busquedaDAO.subtotales()[i] > 0) && ((seccion == null) || (seccion.intValue() == i))) {
									busquedaDAO.setSeccion(new Integer(i));
									busquedaDAO.run();
									StringBuffer ids = new StringBuffer();

									int agregados = (idsArticulo.toString().equals(""))?0:idsArticulo.toString().split(",").length;

									for (int index = 0; index < Math.min(busquedaDAO.getItems().size(), cantArticulosPorPagina)-agregados; index++) {
										ids.append(((Integer)busquedaDAO.getItems().get(index)).intValue()).append(",");
									}
									ids = new StringBuffer(idsArticulo.toString() + ids.toString());
									ArticuloClass articulos[] = ArticuloManager.getArticulosParaCatalogo((ids.length()>0)? ids.substring(0, ids.length()-1): "" + Globals.ARTICULO_DEFAULT, busquedaDAO.getSeccion().intValue());

						%>

		              <tr>
		              <td>
		              </tr>
		              <tr>
		                <td>
							<div style="margin-top:10px">
								<% String urlBanner = Contenido.getBannerCategoria(idSeccion,
										(grupo!=null)?grupo.intValue():-1, (familia!=null)?familia.intValue():-1
												,(subfamilia!=null)?subfamilia.intValue():-1);%>
							  	 <%if (urlBanner != null && !urlBanner.equals("")) { %>
							  	 	<%//out.println(urlBanner);%>
								  	 <jsp:include page="<%=urlBanner%>"/>
							  	 <%} %>

							</div>
						</td>
					 </tr>
					  <tr>
		                <td>&nbsp;</td>
		              </tr>
						<%--}--%>
					  <tr>
		                <td>
		                <div align="center">
		                    <table width="390" border="0" cellspacing="0" cellpadding="0" class="modulobuscador">
				<%if(articulos.length > 0){ %>
		                      <tr>
		                        <td><table width="390" border="0" cellspacing="0" cellpadding="0" >
		                           <tr class="modulosmedio">
		                              <td><table width="390" border="0" cellspacing="0" cellpadding="0" class="titulosceldastabla">							
		                                <tr>
		                                  <td class="titulosceldas">
			                                  <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-otrostitulos.gif" alt="Otros discos"/>
						                    </td>
		                                </tr>
		                            </table></td>
		                           </tr>
		                        </table></td>
		                      </tr>
							  <tr>
		        		        <td>&nbsp;</td>
		    	          	  </tr>
			                  <%
			                	for (int y=0; y<articulos.length; y++) {
			                  %>
								<tr>
		                          <td><table width="390" border="0" cellspacing="0" cellpadding="0" class="moduleproductob">
		                              <tr>
		                                <td><table width="390" border="0" cellspacing="0" cellpadding="0">
		                                    <tr>
		                                    <%	String img2Page = "/componentes/comunes/imagenBusqueda.jsp?idArticulo=" + articulos[y].getIdArticulo() + "&idSeccion=" + articulos[y].getIdSeccion() +
													"&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulos[y].getIdSeccion()][3] + "&alto=" + Globals.tamImagen[articulos[y].getIdSeccion()][4] + "&esNovedad=" + articulos[y].esNovedad() +
												    "&titulo=" + Convert.corregir(articulos[y].getTitulo(), true).toUpperCase();
											%>
		                                        <td width="82" rowspan="5" class="celdafoto">
													<a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>"><jsp:include page="<%=img2Page %>"/></a>
												</td>
		                                        <td colspan="3" valign="top" class="celdacontenido"><!-- a href="/articulo/detalleArticulo.jsp?idArticulo=<%//=articulos[y].getIdArticulo()%>" class="FProductos"--><a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>" class="FProductos"><%=Convert.corregir(articulos[y].getTitulo(),true).toUpperCase()%></a><br>

												  <%
												  String atributoPrincipal = "";
												  if (articulos[y].getAtributoPrincipal() != null && !"".equals(articulos[y].getAtributoPrincipal())) {
									           				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
															articulos[y].getAtributoPrincipal(), articulos[y].getIdAtributoPrincipal(), new Integer(articulos[y].getIdSeccion()),
															new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible());
															atributoPrincipal = articulos[y].getAtributoPrincipal() + " - ";
												  %>
		                                          <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=Convert.corregir(articulos[y].getAtributoPrincipal(),true).toUpperCase()%></a><br>
		                                          <%} %>

		                                          <%
		                                          	if (articulos[y].getGrupo()!= null) {
		                                          		BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(Convert.corregir(articulos[y].getGrupo(), true),
		                                          				new Integer(idSeccion), new Integer(articulos[y].getIdGrupo()), (Integer)null,
		                                          				(Integer)null, new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS,
		                                          				!DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible());
		                                          %>
		                                          <a href="<%=busquedaPorCategoria.salto()%>" class="Fautores">Subcategoria</a>&nbsp;<span class="Fprecio"><%=Convert.corregir(articulos[y].getGrupo(), true)%></span>
		                                          <%
		                                            }
		                                          %>
		                                          </td>
		                                    </tr>
											<tr>
			                                  <td width="201" valign="bottom" class="celdapreciocomprar"><div align="left"><span class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[y].getPrecio())%></span></div></td>
		    	                              <td valign="bottom">
		    	                              		<div align="right">
		    	                              		<table width="2" border="0" cellspacing="0" cellpadding="0">
			                    				     	<tr>
			                                    		        	<td height="19" class="divInfo"><!-- a href="/articulo/detalleArticulo.jsp?idArticulo=<%//=articulos[y].getIdArticulo()%>" --><a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>" class="FProductos"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[y].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[y].getTitulo(), true)%>"  border="0" /></a></td>
										             			<%if (DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible() && articulos[y].getHabilitadoTematika().equals("S")) { %>
					             							<td class="divComprarPedir"><a href="javascript:carrito_AgregarArticulo(<%=articulos[y].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar.gif" alt="Comprar"  border="0"/></a></td>
			      									     			<% } else {%>
					             							<td class="divComprarPedir"><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[y].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Comprar"  border="0"/></a></td>
			      												<% } %>
			      											</tr>
					           						</table>
					           						</div>
					           					</td>
		            	                    </tr>
		                                </table></td>
		                              </tr>
		                          </table></td>
		                        </tr>
		                       	<%
		                			}
								%>
				    			<%
					                int totalProductos = busquedaDAO.subtotales()[busquedaDAO.getSeccion().intValue()];
			    	            int totalPaginas = (int)Math.ceil((double)totalProductos/cantArticulosPorPagina);

			                	if (totalPaginas>1) {
			                %>

	                        <tr>
	                          <td class="celdapaginas">
							<%

									if (paginaActual > 1) {
									StringBuffer  saltoNavegacion = new StringBuffer();
									saltoNavegacion.append(paginaRecorrido);
		    	          	        saltoNavegacion.append("--").append(((((paginaActual-1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
		    	          	        saltoNavegacion.append("--").append(((paginaActual-1)*cantArticulosPorPagina));
		    	          	        saltoNavegacion.append("--").append(busquedaDAO.getCriterio().getClave().intValue()).append(".htm");;
	    		            %>
	                          	<a href="<%=saltoNavegacion%>" class="FAyuda">Anterior</a>
	                          		<span class="Ftexto05">|</span>
							<%
									}
							%>
	        		        <%
			    					for (int x=Math.max(paginaActual-5, 1);	x<Math.min(Math.max(paginaActual-5, 1)+10, totalPaginas+1); x++) {

			    						StringBuffer  saltoNavegacion = new StringBuffer();
			    						saltoNavegacion.append(paginaRecorrido);
		              	   		     	saltoNavegacion.append("--").append((((x*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
		   			        	  	    saltoNavegacion.append("--").append(x*cantArticulosPorPagina);
		   	        		  	        saltoNavegacion.append("--").append(busquedaDAO.getCriterio().getClave().intValue()).append(".htm");;

		    							if (paginaActual == x) {
	                		%>
	                         	<a href="<%=saltoNavegacion%>" class="FAyuda"><b><%=x%></b></a>
				            <%
				    					} else {
			                %>
	    	                    <a href="<%=saltoNavegacion%>" class="FAyuda"><%=x%></a>
	        		        <%
				    					}
	        		        		}
			                %>
	        		        <%
		        	    	   		if ( paginaActual < totalPaginas) {

		        	    	   			StringBuffer  saltoNavegacion = new StringBuffer();
		        	    	   			saltoNavegacion.append(paginaRecorrido);
		              	   		     	saltoNavegacion.append("--").append(((((paginaActual+1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
		   			        	  	    saltoNavegacion.append("--").append(((paginaActual+1)*cantArticulosPorPagina));
		   	        		  	        saltoNavegacion.append("--").append(busquedaDAO.getCriterio().getClave().intValue()).append(".htm");
			                %>
				                 <span class="Ftexto05">| </span><a href="<%=saltoNavegacion%>" class="FAyuda">Siguiente</a>
					    	<%
		        	        		}
					    	%>
	                          </td>
	                        </tr>
			                <%
	    		            	}
	        	        %>

	                <%}else{ %>
	                <tr>
	                <td>&nbsp;</td>
	              </tr>
	                <%} %>
	                       </table>
	                  </div></td>
	                </tr>
						<%
						    }
					    }

						%>



	            </table>
	            </td>
	            <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">
	              <tr class="">
	                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
	                    <tr>
	                        <td><table  border="0" cellspacing="0" cellpadding="0">
	                            <tr>
	                              <td><span class="Ftexto02">ORDENAR TITULOS POR:</span></td>
	                            </tr>
	                            <tr>
	                              <td class="moduloordencelda">
	                              <%if (criterio.equals(BuscadorHelper.CRIT_MAS_VENDIDOS)) { %>
		                              <span class="Ftexto02">- Los m&aacute;s vendidos</span>
	                              <%} else {

	                            	  busquedaDAO.setCriterio(BuscadorHelper.CRIT_MAS_VENDIDOS);

	                            	  StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                            	  saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                            	  saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
	                            	  saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_MAS_VENDIDOS.getClave().intValue());

	 	                          %>
	                            	  <span class="Ftexto02">- </span><a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">Los m&aacute;s vendidos</a>
	                              <%
	                                }
	                              %>
	                              </td>
	                            </tr>
	                            <tr>
	                              <td class="moduloordencelda">
	      	                      <%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_EC)) { %>
	                              		<span class="Ftexto02">- Precio de venta<br />
	                                    &nbsp;&nbsp;(+econ&oacute;micos primeros)</span></td>
	                              <%} else {

	                            	   busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_EC);

	                            	   StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                            	   saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
	                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_PRECIO_EC.getClave().intValue());
	                              %>
	                            		<a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Precio de venta<br />
	                                    <span class="Ftexto02">&nbsp;&nbsp;</span>(+econ&oacute;micos primeros)</a></td>
	                              <%
	                                }
	                              %>
	                            </tr>

	                            <tr>
	                              <td class="moduloordencelda"><span class="Ftexto02">
	                               <%if (criterio.equals(BuscadorHelper.CRIT_FECHA_VN)) { %>
		                              <span class="Ftexto02">- Fecha de aparici&oacute;n<br />
	                                    &nbsp;&nbsp;(+antiguos primeros)</span></td>
		                           <%} else {

		                        	   busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_VN);

		                        	   StringBuffer  saltoOrdenCriterio = new StringBuffer();

		                        	   saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
		                        	   saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
	                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_FECHA_VN.getClave().intValue());

	                               %>

	                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Fecha de aparici&oacute;n<br />
	                                  <span class="Ftexto02">&nbsp;&nbsp;</span>(+antiguos primeros)</a></td>
	                               <%
	                                 }
	                               %>
	                               </td>
	                            </tr>

	                            <tr>
	                              <td class="moduloordencelda">
	                              <%if (criterio.equals(BuscadorHelper.CRIT_FECHA_NV)) { %>
		                              <span class="Ftexto02">- Fecha de aparici&oacute;n<br />
	                                    &nbsp; &nbsp;(+recientes primeros)</span></td>
		                           <%} else {

		                        	     busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_NV);
		                        	     StringBuffer  saltoOrdenCriterio = new StringBuffer();

		                        	     saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
		                        	     saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
		                            	 saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_FECHA_NV.getClave().intValue());

	                               %>
	                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Fecha de aparici&oacute;n<br />
	                                  <span class="Ftexto02">&nbsp;&nbsp;</span>(+recientes primeros)</a></td>
	                               <%
	                                 }
	                               %>
								</td>
	                            </tr>

	                            <tr>
	                              <td class="moduloordencelda">
	      	                      <%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_CE)) { %>
	                              		<span class="Ftexto02">- Precio de venta<br />
	                                    &nbsp;&nbsp;(+costosos primeros)</span></td>
	                              <%} else {

	                            	    busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_CE);

	                            	    StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                            	    saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                            	    saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
		                            	saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_PRECIO_CE.getClave().intValue());
	                              %>
	                            		<a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Precio de venta<br />
	                                    <span class="Ftexto02">&nbsp;&nbsp;</span>(+costosos primeros)</a></td>
	                              <%
	                                }
	                              %>
	                            </tr>


	                            <tr>
	                              <td class="moduloordencelda">
	                              	<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_AZ)) { %>
		                              <span class="Ftexto02">- Alfab&eacute;ticamente (A-Z)</td>
		                           <%} else {

		                        	     busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_AZ);

		                        	     StringBuffer  saltoOrdenCriterio = new StringBuffer();

		                        	     saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
		                        	     saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
			                             saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_ALFAB_AZ.getClave().intValue());
	                               %>
	                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Alfab&eacute;ticamente (A-Z)<br/></a>
	                               <%
	                                 }
	                               %>
	                              </td>
	                            </tr>

	                            <tr>
	                              <td class="moduloordencelda">
	                              	<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_ZA)) { %>
		                              <span class="Ftexto02">- Alfab&eacute;ticamente (Z-A)</td>
		                           <%} else {
		                        	   	busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_ZA);
		                        	   	StringBuffer  saltoOrdenCriterio = new StringBuffer();
		                        	   	saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
		                        	   	saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
			                            saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_ALFAB_ZA.getClave().intValue());
	                               %>
	                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Alfab&eacute;ticamente (Z-A)<br/></a>
	                               <%
	                                 }
	                               %>
	                              </td>
	                            </tr>
	                        </table></td>
	                      </tr>
	                </table></td>
	              </tr>

	            </table></td>
	          </tr>

			</table>

</div>
<%=Globals.getGoogleAnalytics()%>