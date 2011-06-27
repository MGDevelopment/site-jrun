<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.fidelizacion.CatalogoDAO,
                 com.tmk.fidelizacion.ItemDeCatalogoDAO,
                 com.tmk.setup.ImageServer,
                 com.tmk.kernel.Convert"%>
<%	int orden = Convert.toNumber(request.getParameter("orden"), 0);
	boolean ascendente = Convert.toBoolean(request.getParameter("ascendente"), false);
	int puntosFidelizacion = Convert.toNumber((Integer)session.getAttribute("PuntajeFidelizacion"), 0);
	boolean todo = Convert.toBoolean(request.getParameter("todo"), true);
	if (!(puntosFidelizacion >0)) {
		todo = true;
	}
	//Calendar hora = Calendar.getInstance();
	CatalogoDAO catalogoDAO = Globals.CATALOGOS;
%>



<%@page import="com.tmk.setup.Contenido"%>
<script language="javaScript">
	function mostrarImagen(pathImagen) {
	    window.open('/fidelizacion/panel/componentes/imagenGrande.jsp?pathImagen=' + pathImagen, '', 'toolbar=0,status=0,scrollbars=no,resizable=yes,width=30,height=30');
	}
</script>


<div id="seccionTematika">
	<div style="width:830px;  margin:auto; margin-top:80px; " >
		<table width="740" border="0" align="center" cellpadding="0" cellspacing="0" background="#ffffff">
		  <tr>
		    <td>
		    	<br>
		    </td>
		  </tr>
		  <tr>
		    <td>
		       <!-- Menu -->
			   <% String pageMenu = "/tiles/elemento/extra/menu.jsp?mnuActivo=3";%>
			   <jsp:include page="<%=pageMenu%>"/>
		       <!-- Menu -->
		     </td>
		    </tr>
		  <tr>
		    	<td>
		        	<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
		        		<tr>
				          	<td>
				          		<table width="100%" border="0" cellspacing="0" cellpadding="0">
					              	<tr>
		            			    	<td valign="top">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
							                    <tr>
							                      <td height="40" class="punteonargris"><img src="/imagenes/fidelizacion/titulo_01.gif" width="461" height="26"></td>
							                    </tr>
							                    <tr>
							                      <td class="punteonargris">
						                       	 	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="celdacatalogo">
								                          <!-- link a catalogo -->
								                          <tr>
								                          	<td>
								                          		<table width="100%" cellspacing="2" cellpadding="3" border="0" class="texto" >
																	<%if (!todo) {%>
																	<tr>
																		<td align="right" >
 																			<a class="aextra" href="/fidelizacion/panel/catalogo.jsp?todo=true" style="color:#0093C9;font-size: 12px"><B>Ver el catálogo completo</a>
																		</td>
																	</tr>
																	<%}%>
														            <%if (todo && puntosFidelizacion > 0) {%>
																	<tr>
																		<td align="right">
																			<a class="aextra" href="/fidelizacion/panel/catalogo.jsp?todo=false"  style="color:#0093C9;font-size:12px"><B>Ver artículos canjeables por mis puntos</a>
																		</td>
																	</tr>
																	<%}%>
																</table>
								                          	</td>
								                          </tr>
								                          <!-- link a catalogo -->
								                          <!-- encabezados -->
								                          <tr>
								                            <td>
								                            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
								                                	<tr>
								                                  		<td width="100" class="catalogoc1">
										                                  	<table width="100%" border="0" cellspacing="0" cellpadding="0">
										                                    	<tr>
										                                        	<td width="18">
										                                        		<table width="100%" border="0" cellspacing="0" cellpadding="0">
												                                            <tr>
												                                              <td valign="top"><a href="/fidelizacion/panel/catalogo.jsp?orden=0&ascendente=true&todo=<%=todo%>"> <img src="/imagenes/fidelizacion/flecha_01.gif" width="12" height="12"  border="0"></a></td>
												                                            </tr>
												                                            <tr>
												                                              <td height="15" valign="bottom"><a href="/fidelizacion/panel/catalogo.jsp?orden=0&ascendente=false&todo=<%=todo%>"> <img src="/imagenes/fidelizacion/flecha_02.gif" width="12" height="12"  border="0"></a></td>
												                                            </tr>
										                                          		</table>
										                                          	</td>
										                                        	<td><span class="celeste2"><strong>PUNTOS</strong></span></td>
										                                      	</tr>
										                                    </table>
								                                    	</td>
								                                  		<td width="100" class="catalogoc2">
								                                  			<table width="100%" border="0" cellspacing="0" cellpadding="0">
								                                      			<tr>
								                                        			<td width="18">
								                                        				<table width="100%" border="0" cellspacing="0" cellpadding="0">
									                                            			<tr>
									                                              				<td valign="top"><a href="/fidelizacion/panel/catalogo.jsp?orden=1&ascendente=true&todo=<%=todo%>"><img src="/imagenes/fidelizacion/flecha_01.gif" width="12" height="12"  border="0"></a></td>
									                                            			</tr>
												                                            <tr>
												                                              <td height="15" valign="bottom"><a href="/fidelizacion/panel/catalogo.jsp?orden=1&ascendente=false&todo=<%=todo%>"><img src="/imagenes/fidelizacion/flecha_02.gif" width="12" height="12"  border="0"></a></td>
												                                            </tr>
								                                          				</table>
								                                          			</td>
											                                        <td><span class="celeste2"><strong>PESOS</strong></span></td>
											                                    </tr>
								                                    		</table>
								                                    	</td>
								                                  		<td class="catalogoc3">
								                                  			<table width="100%" border="0" cellspacing="0" cellpadding="0">
								                                      			<tr>
								                                        			<td width="18">
								                                        				<table width="100%" border="0" cellspacing="0" cellpadding="0">
												                                            <tr>
												                                              <td valign="top"><a href="/fidelizacion/panel/catalogo.jsp?orden=2&ascendente=true&todo=<%=todo%>"><img src="/imagenes/fidelizacion/flecha_01.gif" width="12" height="12" border="0"></a></td>
												                                            </tr>
												                                            <tr>
												                                              <td height="15" valign="bottom"><a href="/fidelizacion/panel/catalogo.jsp?orden=2&ascendente=false&todo=<%=todo%>"><img src="/imagenes/fidelizacion/flecha_02.gif" width="12" height="12" border="0"></a></td>
												                                            </tr>
								                                          				</table>
								                                          			</td>
								                                        			<td><span class="celeste2"><strong>DESCRIPCION</strong></span></td>
											                                    </tr>
								                                    		</table>
								                                    	</td>
								                                	</tr>
								                              	</table>
								                            </td>
								                          </tr>
		   						                          <!-- encabezados -->
		   						                          <%
															ItemDeCatalogoDAO items[] = catalogoDAO.getItems();

															if (orden == 1) {
																items = catalogoDAO.getItemsPesos();
															}

															if (orden == 2) {
																items = catalogoDAO.getItemsDescripcion();
															}

															int diferencia = items.length-1;

															if (ascendente) {
																diferencia = 0;
															}

													for (int i = 0; i < items.length; i++) {

																//out.println(Math.abs(diferencia - i));
																ItemDeCatalogoDAO itemDeCatalogoDAO = items[Math.abs(diferencia - i)];
			 											  %>
								                          <!-- items -->
								                          <% if (todo == true || itemDeCatalogoDAO.getPuntos() <= puntosFidelizacion) {%>
								                          <tr>
								                            <td>
								                            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
								                                	<tr>
								                                  		<td width="100" class="catalogog1"><span class="txtgris16"><strong>X
								                                    		<%=Convert.toString(itemDeCatalogoDAO.getPuntos()).replaceAll("\\p{Punct}", "")%></strong></span><br> <span class="txtgris14"><strong>PUNTOS</strong></span></td>
								                                  		<td width="100" class="catalogog2">
								                                  		<%if (itemDeCatalogoDAO.getImporteAdicional() > 0) {%>
								                                  				<span class="txtnaranja14"><strong>+
								                                    				<%=Contenido.precioToString(itemDeCatalogoDAO.getImporteAdicional())%></strong></span></td>
								                                    	<%}%>
										                                <td class="catalogog3">
								                                  			<table width="100%" border="0" cellspacing="0" cellpadding="0">
								                                      			<tr>
								                                        			<td width="50" valign="top">
								                                        			<%
								                                        				String pathImgCh = ImageServer.obtenerNombreDeTapa(itemDeCatalogoDAO.getIdArticulo(), true, itemDeCatalogoDAO.getCategoria(), 0, "", false);
								                                        				String pathImgGr = ImageServer.obtenerNombreDeTapa(itemDeCatalogoDAO.getIdArticulo(), false, itemDeCatalogoDAO.getCategoria(), 0, "", false);
								                                        				if(pathImgGr==null || pathImgGr.equals(""))
								                                        					pathImgGr=pathImgCh;
																					%>
																					<% if (pathImgCh !=null && !pathImgCh.equals("")) {%>
																						<a href="javascript:mostrarImagen('<%=pathImgGr%>')"><img src="<%=pathImgCh%>" width="43" height="44" border="0" class="Gimagesproductos" alt="<%=itemDeCatalogoDAO.getTitulo()%>"> </a>
																					<% } else {
																						String tapaGenerica = ImageServer.nombreArticuloSinImagen(false, itemDeCatalogoDAO.getCategoria());%>
																						<img src="<%=tapaGenerica%>" width="43" height="44" border="0" class="Gimagesproductos" alt="<%=itemDeCatalogoDAO.getTitulo()%>">
																					<% }%>
								                                        			</td>
								                                        			<td class="descripcion">
								                                        			<%if (Globals.seccionHabilitada(itemDeCatalogoDAO.getCategoria())&& itemDeCatalogoDAO.esHabilitadoTematika()) {%>
								                                        				<a href="/detalle/index.jsp?idArticulo=<%=itemDeCatalogoDAO.getIdArticulo()%>"  class="descripcion">
								                                        				<%=itemDeCatalogoDAO.getTitulo()%></a>
																					<%} else {%>
																						<%=itemDeCatalogoDAO.getTitulo()%>
																					<%}%>
																					<br>
																					<span class="txtblanco12">
																					<%=(itemDeCatalogoDAO.esHastaAgotarStock()) ? "Hasta agotar stock en sucursal." : "Disponible para canje en sucursal."%></br>
																					<% if (Globals.seccionHabilitada(itemDeCatalogoDAO.getCategoria())&& itemDeCatalogoDAO.esHabilitadoTematika()) {%>
																						<br/>Este producto además puede adquirirse a través de este sitio
																					<% }%>
																					</span>
																					<% if (pathImgCh !=null && !pathImgCh.equals("") ) {%>
																						<a style="color:#ffffff" class="ftexto02" href="javascript:mostrarImagen('<%=pathImgCh%>')">Ampliar Imagen</a>
																					<% }%>
												                                   </td>
											                                     </tr>
								            		                        </table>
								            		                    </td>
								                                	</tr>
								                              	</table>
								                            </td>
								                          </tr>
								                          <%}%>
												<%  } %>
								                          <!-- items -->
							                        </table>
							                     </td>
						                    </tr>
						                  </table>
						                </td>
		                				<td width="165" valign="top" bgcolor="#E79A0B">
		                				<!--LEFT-->
		            	 				  <% String pageLeft = "/fidelizacion/panel/componentes/left.jsp";%>
										  <jsp:include page="<%=pageLeft%>"/>
		               					<!--LEFT-->
		                				</td>
							        </tr>
							        <tr>
							          <td height="4"></td>
							        </tr>
							        <tr>
							          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
							              <tr>
							                <td width="144" bgcolor="#00708B">&nbsp;</td>
							                <td bgcolor="#9C928D" align="left"><a href="#top"><img src="/imagenes/fidelizacion/marco_16.gif" width="101" height="22" border="0"></a></td>
							              </tr>
							            </table></td>
							        </tr>
		     				 	</table>
		     				</td>
						  </tr>
					</table>
		        </td>
		      </tr>
		    </table></td>
		  </tr>
		</table>
</div>
</div>