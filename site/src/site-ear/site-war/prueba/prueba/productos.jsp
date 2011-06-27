<td class="Gbarraderecha">
							<table width="155" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table width="180" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
											<tr>
												<td>
													 <table  border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td><span class="Ftexto02">ORDENAR RESULTADOS POR:</span></td>
														</tr>
														<%busquedaDAO.setSeccion(seccion);%>
														<tr>
															<td class="moduloordencelda">
															<%if (criterio.equals(BuscadorHelper.CRIT_MAS_VENDIDOS)) { %>
																<br><b>- Los m&aacute;s vendidos</b>
															<%} else {
																busquedaDAO.setCriterio(BuscadorHelper.CRIT_MAS_VENDIDOS);
															%>																
																<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow">
																	<span class="Ftexto02">- Los m&aacute;s vendidos</span>	
																</a>
															<%
																}
															%>
															</td>
														</tr>
													<!-- FERCHA DE APARICION -->
														<tr>
															<td class="moduloordencelda">
																<span class="Ftexto02">- Fecha de aparici&oacute;n
																	<span style="padding:10px;">
																		<%if (criterio.equals(BuscadorHelper.CRIT_FECHA_NV)) { %>																		
																				<br><b>-m&aacute;s recientes primeros</b>
																	 	<%} else {
																			 busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_NV);
																		 %>
																				<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br/>
																					<span class="Ftexto02"> -m&aacute;s recientes primeros</span>
																				</a>
																		 <%
																			 }
																		 %>									
																	</span>
																	<span style="padding:10px;">		
																		 <%if (criterio.equals(BuscadorHelper.CRIT_FECHA_VN)) { %>																		
																				<br><b>-m&aacute;s antiguos primeros</b>
																	 	 <%} else {
																				busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_VN);
																		 %>
																				<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br/>
																					<SPAN class="Ftexto02">-m&aacute;s antiguos primeros</SPAN>
																				</a>
																		 <%
																			 }
																		 %>
																	 </span>
																</span>
															 </td>
														</tr>
													<!-- PRECIO DE VENTA -->
														<TR>
															<td class="moduloordencelda">
																<span class="Ftexto02">- Precio de venta
																	<span style="padding:10px;">
																		<%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_EC)) { %>
																				<br><b>-m&aacute;s econ&oacute;micos primeros</b>
																		<%} else {
																			busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_EC);
																		%>
																				<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br />
																					 <SPAN class="Ftexto02">-m&aacute;s econ&oacute;micos primeros</SPAN>
																				</a>
																		<%
																			}
																		%>								
																	</span>
																	<span style="padding:10px;">		
																		<%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_CE)) { %>
																				<br><b>-m&aacute;s costosos primeros</b>
																	<%} else {
																		busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_CE);
																	%>
																				<a style="paddin:10px;" href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br />
																					<span class="Ftexto02">-m&aacute;s costosos primeros</span>
																				</a>
																	<%
																		}
																	%>
																	 </span>
																</span>
															 </td>
														<TR>
														
														<!-- ALFABETICO -->
														<TR>
															<td class="moduloordencelda">
																<span >- Alfab&eacute;ticamente
																	<span style="padding:10px;">
																		<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_AZ)) { %>
																				<br><b>-(A-Z)</b>
																	 	<%} else {
																			 busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_AZ);
																		 %>
																				<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br>
																					<span class="Ftexto02">-(A-Z)</span>
																				</a>
																		 <%
																			 }
																		 %>							
																	</span>
																	<span style="padding:10px;">		
																	<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_ZA)) { %>
																			<br><b>-(Z-A)</b>
																 	<%}else {
																		 busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_ZA);
																	 %>
																			<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br>
																				<span class="Ftexto02">-(Z-A)</span>
																			</a>
																	 <%
																		 }
																	 %>
																	 </span>
																</span>
															 </td>
														<TR>
												</table></td>
											</tr>
									</table></td>
								</tr>
								<tr>
									<td class="Ftexto02"><table width="155" border="0" cellpadding="0" cellspacing="0" class="tablaaccesos">
											<tr>
												<td><table width="155" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td class="Ftexto02">Si no tuvo un resultado<br />
																satisfactorio, pruebe con:</td>
														</tr>
														<% if (seccionElegida != Globals.SECCION_HOME) { %>
														<tr>
															<td><div align="left"><a href="/articulo/buscadorAvanzado.jsp?idSeccion=<%=busquedaDAO.getSeccion()%>&seccion=<%=seccionElegida%>" rel="nofollow"><img style="padding-top:7px" src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-bavanzada.gif" alt="B&uacute;squeda avanzada" border="0" class="accesos02" /></a></div></td>
														</tr>
														<% } %>


														<%
														if (!pedidoEspecial) {

															busquedaDAO.setSeccion(new Integer(seccionElegida));
															busquedaDAO.setCriterio(criterio);
															busquedaDAO.setPedidoEspecial(true);
														%>
														<tr class="dwcopytype=&quot;CopyTableRow&quot;">
															<td><div align="left"><a href="<%=busquedaDAO.salto()%>"><img src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-productossinstock.gif" alt="Productos sin stock"  border="0" class="accesos02" /></a></div></td>
														</tr>
														<%
														}
														%>
														<tr class="dwcopytype=&quot;CopyTableRow&quot;">
															<td><div align="left"><a href="/indice"><img src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-mapadeproductos.gif" alt="Mapa de productos"  border="0" class="accesos02" /></a></div></td>
														</tr>
												</table></td>
											</tr>
									</table></td>
								</tr>
						</table></td>