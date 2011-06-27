<%@ page import="java.util.Iterator,
				 com.tmk.setup.Contenido,
				 com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Convert,
                 com.tmk.orden.*,
                 com.tmk.service.orden.OrdenService,
                 com.tmk.kernel.TmkLogger,
                 com.tmk.kernel.DBUtil,
                 java.util.Vector,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.kernel.DomicilioDAO,
                 com.tmk.kernel.ArticuloDAO,
                 com.tmk.orden.TarjetaPrepaga,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.articulo.Articulo,
                 com.tmk.controllers.CommonHelper,
                 com.tmk.kernel.Globals"
                 %>
                 
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.controllers.carrito.CarritoUtil"%>

<% boolean usuarioIntranet = ((UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET) != null);%>


<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	boolean existeOrden = false;

	OrdenDAO ordenDAO = null;
	int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
	try {
		OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
		Vector lasOrdenes = new Vector();
		if (socioPK != null) {
			lasOrdenes.addAll(ordenLocalHome.findOrdenesEnProceso(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO));
			lasOrdenes.addAll(ordenLocalHome.findOrdenesProcesadas(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO));
		}
		for (int i = 0; (i<lasOrdenes.size() && (!existeOrden)); i++) {
			OrdenLocal ordenLocal = (OrdenLocal)lasOrdenes.get(i);
			existeOrden = (ordenLocal.getID_ORDEN().intValue() == idOrden);
		}
	}
	catch (Exception e){
		TmkLogger.debug("ORDEN DETALLE]: No se encontro la orden:" + idOrden + " para el socio:" + socioPK.ID_SOCIO + e.toString());

	}

%>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
<table width="550" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            
            <td class="Gcentro" width="400"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
<%
	if (existeOrden) {
		ordenDAO = OrdenService.cargarOrden(idOrden);
%>
		     <tr>
                <td><table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop">
                  <tr>
                    <td class="moduloayuda"><div align="center">
                        <table width="366" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="366" valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td valign="middle"><table width="366" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td width="174" height="22" valign="top" class="Ftexto02"><span class="FTtit01">ORDEN <%=Convert.toString(idOrden)%></span></td>
                                        <td width="192" height="22" valign="top" class="Ftexto02"><div align="right">Fecha: <%=Convert.toStringLargo(ordenDAO.getFechaDeCierre())%></div></td>
                                        </tr>
                                      <tr>
                                        <td colspan="2" valign="bottom" style="padding-bottom:5px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td class="celdamodulodomicilio2"><table width="300" border="0" cellspacing="0" cellpadding="0">
                                                  <tr>
                                                    <td valign="middle" class="FTtit01">Totales de la compra </td>
                                                  </tr>
                                              </table></td>
                                            </tr>
                                        </table></td>
                                      </tr>

		                          <%
									double totalMedioDeCobro1 = 0.0;

							        totalMedioDeCobro1 = ordenDAO.totalSitioCompleto();
							        
							      %>

			       <!-- TOTALES DE LA COMPRA -->
									   <tr>
                                        <td colspan="2" valign="bottom" class="Ftexto02"><table class="modulofinalcompra" width="176" border="0" align="center" cellpadding="0" cellspacing="0">
                                            <tr>
                                              <td><table width="162" border="0" align="center" cellpadding="0" cellspacing="0">
                                                  <tr>
                                                    <td width="85" height="15" valign="middle">Subtotal:</td>
                                                    <td width="77" height="15" valign="middle"><div align="right"><%=Contenido.precioToString(ordenDAO.subTotal())%></div></td>
                                                  </tr>
                                                  <tr>
                                                    <td height="15" valign="middle">Gastos de env&iacute;o: </td>
                                                    <td height="15" valign="middle" ><div align="right"><%=Contenido.precioToString(ordenDAO.totalGastoDeEnvio())%></div></td>
                                                  </tr>
											<% if (ordenDAO.tienenSubArticulos()) { %>
												  <tr>
                                                    <td height="15" valign="middle">Papel de regalo: </td>
   		                                            <td height="15" valign="middle"> <div align="right"><%=Contenido.precioToString(ordenDAO.totalPapelDeRegalo())%></div></td>
           		                                  </tr>
 									         <%}%>

                            		        <% if (ordenDAO.getInteresCobradoDAO() != null) { %>
												  <tr>
                                                    <td height="15" valign="middle">Inter&eacute;s: </td>
   		                                            <td height="15" valign="middle"> <div align="right"><%=Contenido.precioToString(ordenDAO.getInteresCobradoDAO().getPrecioPromocion())%></div></td>
           		                                  </tr>

											<%}%>

                                                  <tr>
                                                    <td height="15" valign="middle"><strong>Total:</strong></td>
                                                    <td height="15" valign="middle" style="border-top:solid 1px #333"><div align="right"><strong><%=Contenido.precioToString(ordenDAO.totalSitioCompleto())%></strong></div></td>
                                                  </tr>
                                              </table></td>
                                            </tr>
                                        </table></td>
                                      </tr>

                                   

                                   <% if (ordenDAO.getTarjetaPlanDAO() != null) { %>

											<tr>
	    	                                    <td colspan="2" valign="bottom" class="Ftexto02" style="padding-left:5px"><table width="357" border="0" cellspacing="0" cellpadding="0" vertical-align:bottom="vertical-align:bottom"">
	        	                                    <tr>
	            	                                  <td width="300" valign="bottom" class="Ftexto02">Pago en <b><%= Convert.pluralCompleto(ordenDAO.getTarjetaPlanDAO().getCuotas(), "cuota") %></b></td>
		                                            </tr>
	    	                                    </table></td>
	        	                            </tr>

											<tr>
												<td>&nbsp;</td>
											</tr>
								   <% } %>

                                      <tr>
                                        <td colspan="2" valign="bottom" class="Ftexto02" style="padding-left:5px"><table width="357" border="0" cellspacing="0" cellpadding="0" vertical-align:bottom="vertical-align:bottom"">
                                            <tr>
                                              <td width="118" valign="bottom" class="Ftexto02">Promociones aplicadas: </td>
                                              <td width="248" valign="bottom" class="FTtit01" ><%String promosAplicadas = ordenDAO.getPromocionesAplicadas("<br>&middot;"); %>
																							   <%=(promosAplicadas.equals(""))? "Ninguna ": promosAplicadas%> </td>
                                            </tr>
                                        </table></td>
                                      </tr>

								  <% // Mostrar la conversion en caso necesario
									//if ((ordenDAO.isReadWrite()) && (ordenDAO.getDomicilioFacturacion() != null) && (!ordenDAO.getDomicilioFacturacion().getPais().esArgentina())) {
									if (!ordenDAO.getDomicilioFacturacion().getPais().esArgentina()) {
									%>
									  <tr>
                                        <td colspan="3" valign="bottom" class="Ftexto02" style="padding-left:5px"><table width="357" border="0" cellspacing="0" cellpadding="0" vertical-align:bottom="vertical-align:bottom"">
                                            <tr>
                                            	<td>&nbsp;</td>
                                            </tr>
											<tr>
                                              <td width="200" valign="bottom" class="Ftexto02">Son D&oacute;lares: &nbsp; <b><%=Contenido.precioDollarToString(ordenDAO.totalSitioCompleto())%></b></td>
                                            </tr>

                                            <tr>
                                              <td width="157" valign="bottom" class="Ftexto02">Son Euros: &nbsp; <b><%=Contenido.precioEuroToString(ordenDAO.totalSitioCompleto())%></b></td>
                                            </tr>

                                        </table></td>
                                      </tr>
								  <%}%>

                                  </table></td>
                                </tr>
                     <!--TOTALES DE LA COMPRA-->

                     <!--FORMA DE PAGO-->
          						<tr>
                                   <td style="padding:15px 0px 5px 0px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td class="celdamodulodomicilio2"><table width="300" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                              <td valign="middle" class="FTtit01">Forma de pago</td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>

                                <tr>
                                  <td><table width="366" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td style="padding-left:5px"><table width="357" border="0" cellspacing="0" cellpadding="0" >

                                            <tr>
                                              <td width="366" valign="bottom" class="Ftexto02" style="padding-bottom:7px">

				                               <% if (ordenDAO.getMedioDeCobro().esTarjeta()) {%>
													<strong>Tarjeta</strong> <%=ordenDAO.getMedioDeCobro().getNombre()%>
												<br>
														<%=Convert.toString(ordenDAO.numeroTarjetaAMostrar())%><br>
												<% } else { %>
														<strong><%=ordenDAO.getMedioDeCobro().getNombre()%></strong>
												<% } %>
                                              </td>
                                            </tr>

					<!-- TARJETA PREPAGA -->

									<% if (ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) {

											double totalImporteParaOrden = 0.0;
											Vector tarjetas = ordenDAO.getTarjetasPrepagas();
									%>
										<tr><td width="340" valign="bottom" class="Ftexto02" style="padding-bottom:7px">
											<table width= "97%" align="center" cellspacing="0" cellpadding="0" border="0">

									<%      boolean hayNoHabilitada = false;
											for (int i=0; i<tarjetas.size(); i++) {

												TarjetaPrepaga tarjeta = (TarjetaPrepaga)tarjetas.get(i);
									%>
												<tr style="color:<%=(tarjeta.estaHabilitada())?"000000":"gray"%>"><td width="40%">#<%=tarjeta.getNro()%>:&nbsp;</td>
													<td width="25%" align="right"><%=Contenido.precioToString(tarjeta.getImporteParaOrden())%></td>

									<%    	    totalImporteParaOrden += tarjeta.getImporteParaOrden();
												if (tarjeta.estaHabilitada()) {
									%>
													<td></td>
									<%
												} else {
									%>
													<td>&nbsp;(*)</td>
									<%      		hayNoHabilitada = true;
                		        				}
											}
									%>
											    </tr>

												<tr><td align="right"><strong>Total:</strong></td>
													<td  style="border-top:solid 1px #333" align="right"><strong><%=Contenido.precioToString(totalImporteParaOrden)%></strong></td>
													<td></td>
												</tr>

									<%
											if (hayNoHabilitada) {
									%>
												<tr><td Style="font-size:3" colspan=3>&nbsp;</td></tr>
												<tr><td  style="color:gray" colspan=3>(*) No habilitada</td></tr>
									<%
											}
									%>
												<tr><td Style="font-size:3" colspan=3>&nbsp;</td></tr>
												<tr><td colspan=3 class="Ftextorojo">
					    		    <%
						            		if (ordenDAO.getTotalMedioDeCobro() > totalImporteParaOrden) {

								    %>
							        			<b>No cuenta con saldo suficiente para realizar esta compra.</b>
								    <%
									        }
								    %>
										        </td></tr>
											</table>
									<%
									   }
									%>
											</td>
										</tr>

				<!-- FIN TARJETA PREPAGA -->


                                            <tr>
                                              <td valign="bottom" class="Ftexto02" style="padding-bottom:7px"><strong>Tel&eacute;fono: </strong>&nbsp; <%= Convert.toString(ordenDAO.getTelefonoContacto())%></td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" class="Ftexto02" style="padding-bottom:7px"><strong>Horario de contacto telef&oacute;nico: </strong>&nbsp;<%= Convert.toString(ordenDAO.getHorarioContacto())%></td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" class="Ftexto02"><strong>Comentarios:<br />
                                              </strong><%= Convert.toString(ordenDAO.getComentario(), "Ninguno")%></td>
                                            </tr>
				                         </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
					<!-- FORMA DE PAGO -->

                    <!-- DETALLE DE ENVIO -->
                                <tr>
                                  <td style="padding:15px 0px 5px 0px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td class="celdamodulodomicilio2"><table width="300" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                              <td valign="middle" class="FTtit01">Detalle de env&iacute;o</td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                                <tr>
                                  <td><table width="366" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td style="padding-left:5px"><table width="357" border="0" cellspacing="0" cellpadding="0" vertical-align:bottom="vertical-align:bottom"">
                                            <tr>
                                              <td width="366" valign="bottom" class="Ftexto02" style="padding-bottom:7px"><strong>Papel de regalo:</strong>&nbsp;<%=Convert.toString(ordenDAO.tienenSubArticulos())%></td>
                                            </tr>
                                            <tr>
                                              <td valign="bottom" class="Ftexto02" style="padding-bottom:7px"><strong>Dedicatoria:</strong>&nbsp;<%=Convert.toString(ordenDAO.tienenNotas())%></td>
                                            </tr>
                                            <%if (ordenDAO.getMetodoDeEnvio() != null) {%>
	                                            <tr>
    	                                          <td valign="bottom" class="Ftexto02"><strong>M&eacute;todo de env&iacute;o: </strong>&nbsp;<%=Convert.toString(ordenDAO.getMetodoDeEnvio(), "No especificado")%></td>
        	                                    </tr>
                                            <%}%>

                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>

                    <!-- DETALLE DE ENVIO -->

					<!-- DOMICILIO DE ENVIO -->
							<%DomicilioDAO domicilio = ordenDAO.getAlgunDomicilioEnvio(); %>
  						    <%if (domicilio != null){  %>
						        <tr>
                                  <td style="padding:15px 0px 5px 0px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td class="celdamodulodomicilio2"><table width="300" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                              <td valign="middle" class="FTtit01">Domicilio de env&iacute;o</td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                                <tr>
                                  <td><table width="366" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td style="padding-left:5px"><%= Convert.capitalizar(Convert.toString(domicilio.getCalle()), false) %> <%=Convert.toString(domicilio.getNumero()) %>&nbsp;
										<%= Convert.toString(domicilio.getEdificio()) %> <%= Convert.toString(domicilio.getPiso()) %>
										<%= Convert.capitalizar(Convert.toString(domicilio.getDepto()), true) %><br>
										<%= Convert.toString(domicilio.getLocalidadExterna(), domicilio.getLocalidad().getNombre()) %> (<%= Convert.toString(domicilio.getCodigoPostal()) %>)<br>
										<%= Convert.toString(domicilio.getProvinciaExterna(), domicilio.getProvincia().getNombre()) %><br>
										<%= Convert.toString(domicilio.getPais().getNombre()) %><br>
                                        </td>
                                        </tr>
                                  </table></td>
                                </tr>
                           <%}%>
                    <!-- DOMICILIO DE ENVIO -->

                    <!-- DOMICILIO DE FACTURACION -->
                                <tr>
                                  <td style="padding:15px 0px 5px 0px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td class="celdamodulodomicilio2"><table width="300" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                              <td valign="middle" class="FTtit01">Domicilio de facturaci&oacute;n </td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>
                                <% domicilio = ordenDAO.getDomicilioFacturacion(); %>
                                <tr>
                                  <td class="Ftexto02"><table width="366" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td style="padding-left:5px"><%= Convert.capitalizar(Convert.toString(domicilio.getCalle()), false) %> <%= Convert.toString(domicilio.getNumero()) %>&nbsp;
										<%= Convert.toString(domicilio.getEdificio()) %> <%= Convert.toString(domicilio.getPiso()) %>
										<%= Convert.capitalizar(Convert.toString(domicilio.getDepto()), true) %><br>
										<%= Convert.toString(domicilio.getLocalidadExterna(), domicilio.getLocalidad().getNombre()) %> (<%= Convert.toString(domicilio.getCodigoPostal()) %>)<br>
										<%= Convert.toString(domicilio.getProvinciaExterna(), domicilio.getProvincia().getNombre()) %><br>
										<%= Convert.toString(domicilio.getPais().getNombre()) %><br>
                                        </td>
                                        </tr>

                                  </table></td>
                                </tr>

					<!-- DOMICILIO DE FACTURACION -->


					<!-- OTRO DESTINATARIO DEL PEDIDO-->
					   <% if (ordenDAO.tieneOtroReceptor()) {%>
     				           <tr>
                                  <td style="padding:15px 0px 5px 0px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td class="celdamodulodomicilio2"><table width="300" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                              <td valign="middle" class="FTtit01">Destinatario del pedido</td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>


                                <tr>
                                  <td style="padding-left:5px"><table width="357" border="0" cellspacing="0" cellpadding="0" vertical-align:bottom="vertical-align:bottom"">
                                      <tr>
                                        <td valign="bottom" class="Ftexto02">Pedido a nombre de <%= Convert.nombreCompleto(ordenDAO.getNombresReceptor(), ordenDAO.getApellidosReceptor()) %></td>
                                      </tr>
                                  </table></td>
                                </tr>
                                <%}%>
					<!-- OTRO DESTINATARIO DEL PEDIDO-->

					<!--DATOS DEL PROGRAMA EXTRA -->
     				           <% if (ordenDAO.getPuntajeWrapper() != null) {%>
     				           <tr>
                                  <td style="padding:15px 0px 5px 0px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td class="celdamodulodomicilio2"><table width="300" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                              <td valign="middle" class="FTtit01">Datos del programa eXtra! </td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                  </table></td>
                                </tr>


                                <tr>
                                  <td style="padding-left:5px"><table width="357" border="0" cellspacing="0" cellpadding="0" vertical-align:bottom="vertical-align:bottom"">
                                      <tr>
                                        <td valign="bottom" class="Ftexto02">Acumular puntos eXtra! para <%= Convert.nombreCompleto(ordenDAO.getPuntajeWrapper().getNombreSocio(), ordenDAO.getPuntajeWrapper().getApellidoSocio()) %><br />
                                          (tarjeta n&uacute;mero <%= Convert.toString(ordenDAO.getNumeroTarjetaExtra()) %>)</td>
                                      </tr>

                                  </table></td>
                                </tr>
                                <%}%>

					 <!-- DATOS DEL PROGRAMA EXTRA -->

                            </table></td>
                          </tr>
                        </table>
                    </div></td>
                  </tr>
                </table></td>
              </tr>

           <!-- DETALLE DE COMPRA -->

              <tr>
                <td style="padding:15px 0px 15px 0px"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop">
                  <tr>
                    <td class="modulocontenidocarrito"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="22" valign="top"><div align="left"><span class="FTtit01">DETALLE DE SU COMPRA</span></div></td>
                      </tr>
                      <tr>
                        <td><table width="366" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">

                        <%
							for (int i = 0; i < ordenDAO.getCantidadArticulos(); i++) {
							ArticuloDAO articulo = ordenDAO.getArticulo(i);

							boolean prodPromo = ( (articulo.tienePromocion() && articulo.getPrecioConDescuento() != articulo.getPrecioPromocion())  || ((articulo.getPrecioPromocion() != articulo.getPrecioConImpuesto())
									&& articulo.getPrecioPromocion() != articulo.getPrecioConDescuento())) &&
									(articulo.getPrecioConImpuesto() + Math.abs(articulo.getAhorro()) - articulo.getPrecioPromocion()) > 0.009;

							boolean prodDesc = articulo.tieneDescuento() && (articulo.getPrecioConDescuento() != articulo.getPrecioConImpuesto());
							boolean tieneGasto = (articulo.getGastoDeEvio() != null);
							boolean gasPromo = tieneGasto && (articulo.getGastoDeEvio().tienePromocion() || articulo.getGastoDeEvio().getPrecioPromocion()!= articulo.getGastoDeEvio().getPrecioConImpuesto());
							boolean tienePapel = (articulo.getPapelDeRegalo() != null);
							boolean papPromo = tienePapel && (articulo.getPapelDeRegalo().tienePromocion() || articulo.getPapelDeRegalo().getPrecioPromocion()!= articulo.getPapelDeRegalo().getPrecioConImpuesto());

							//boolean encontroPromo = false;

						%>
							<input type="hidden" name="ID_ARTICULO" value="<%= articulo.getId() %>">
							<input type="hidden" name="posicionEnLista" value="<%=articulo.getPosicionEnLista()%>">

				 <!-- DETALLE DE ARTICULOS -->
                          <tr>
                            <td><table width="366" border="0" cellpadding="0" cellspacing="0" class="modulocompra">
                                <tr>
                                  <td><table width="366" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td valign="top" class="titulocompra">
                                        <%-- <a href="/articulo/detalleArticulo.jsp?idArticulo=<%=articulo.getId()%>&idSeccion=<%=articulo.getCategoriaSeccion()%>" class="FProductos">--%>
                                        <%
                                        	if(CarritoUtil.getAriculosExcluidos().get(0).intValue()!= articulo.getId()){
                                        %>
	                                        <a href="/articulo/detalleArticuloNuevo.jsp?idArticulo=<%=articulo.getId()%>&idSeccion=<%=articulo.getCategoriaSeccion()%>" class="FProductos">
	                                        	<%	                                        	
	                                        		//out.println(Contenido.getTitulo(articulo.getId()).toUpperCase());	                                        		
	                                        		out.println(ServiceLocator.getArticuloService().getDatosPrincipal(new Integer(articulo.getId())).getTitulo());
	                                        		
	                                        	%>
	                                        </a>
	                                    <%}else{ %>
	                                    	<a href="#" class="FProductos">
	                                        	<%//out.println(Contenido.getTitulo(articulo.getId()).toUpperCase());
	                                        		out.println(ServiceLocator.getArticuloService().getDatosPrincipal(new Integer(articulo.getId())).getTitulo());
	                                        	%>
	                                        </a>
	                                    <%} %>
                                        </td>
                                      </tr>

                                      <!-- tr>
                                        <td valign="bottom" class="celdascompra2"><div align="left"><span class="Ftexto01"><%//=articulo.getAtributoPrincipal()%></span></div></td>
                                      </tr-->

								 	  <tr>
									  	<td valign="top"><div align="left" class="celdascompra2"><span class="Ftexto01">Disponibilidad: <%=articulo.getDisponibilidad().getNombre()%></span></div></td>
                                      </tr>

                                      <tr>
                                        <td valign="bottom" class="celdascompra2"><div align="left"><span class="Ftexto01">Cantidad: <%= articulo.getCantidad() %></span></div></td>
                                      </tr>
                                      <tr>
                                        <td height="25" valign="bottom" class="celdascompra2"><div align="left">
                                            <table width="361" border="0" cellspacing="0" cellpadding="0">
                                              <tr>
                                                <td width="249"><span class="Fprecio">PRECIO: <%= Contenido.precioToString(articulo.getPrecioConImpuesto() * articulo.getCantidad()) %></span></td>
                                              </tr>

                                              <%if (prodDesc) { %>
					 						  <tr>
					 							<td><p class="Fprecio">DESCUENTO: <span class="FprecioRojo">-<%= Contenido.precioToString(Math.abs(articulo.getAhorro()))%></span></p></td>
					 						  </tr>
  							                  <%}%>

                                              <%if (prodPromo) { %>
                                              <tr>
                                                <td><p class="Fprecio">PROMOCION: <span class="FprecioRojo">-<%= Contenido.precioToString((articulo.getPrecioConImpuesto() + Math.abs(articulo.getAhorro()) - articulo.getPrecioPromocion())* articulo.getCantidad()) %></span></p></td>
                                              </tr>
                                              <%} %>

											 <% if (prodDesc && !prodPromo) { %>
                                              <tr>
                                                <td><table class="tablapreciodescuento" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                      <td><span class="Fprecio">PRECIO FINAL: <%= Contenido.precioToString((articulo.getPrecioPromocion()< articulo.getPrecioConDescuento())? articulo.getPrecioPromocion() * articulo.getCantidad(): articulo.getPrecioConDescuento() * articulo.getCantidad()) %></span></td>
                                                    </tr>
                                                </table></td>
                                              </tr>
											<%} %>
											<% if(prodPromo) { %>
                                              <tr>
                                                <td><table class="tablapreciodescuento" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                      <td><span class="Fprecio">PRECIO FINAL: <%= Contenido.precioToString((articulo.getPrecioPromocion()< articulo.getPrecioConDescuento())? articulo.getPrecioPromocion() * articulo.getCantidad(): articulo.getPrecioConDescuento() * articulo.getCantidad()) %></span></td>
                                                    </tr>
                                                </table></td>
                                              </tr>
											<%} %>


                                            </table>
                                        </div></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>

				      <%} %>
				  	<!--DETALLE DE ARTICULOS -->

                        </table></td>
                      </tr>
                    </table></td>
                    </tr>
                </table></td>
              </tr>
<%}else{ %>
			<tr>
				<td ><table width="386" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop">
					  <tr class="moduloayuda">
            		      	<td>&nbsp;&nbsp;</td>
                    		<td class="Ftextorojo">	UD. NO TIENE ACCESO A ESTA ORDEN O LA ORDEN NO EXISTE.	</td>
				   	  </tr>
      			</table></td>
      		</tr>
<%} %>

            </table>
          </tr>
	</table>
</div>
</div>

<%=Globals.getGoogleAnalyticsSSL()%>
