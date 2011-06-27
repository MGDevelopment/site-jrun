<%@ page import="com.tmk.orden.OrdenDAO,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.ArticuloDAO,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.controllers.CommonHelper,
                 com.tmk.kernel.Globals" %>
<%
	OrdenDAO ordenDAO = (OrdenDAO)session.getAttribute("ordenDAO");
	if (ordenDAO == null) ordenDAO = new OrdenDAO();


%>


<%@page import="com.tmk.controllers.carrito.CarritoUtil"%><script type="text/JavaScript">
<!--
			function iniciarCompra()
			{
				document.formCarrito.action = '/IniciarCompra';
				document.formCarrito.submit();
			}

			function moverHaciaLista(ID_ARTICULO)
			{
				if(confirm('¿ Seguro desea mover este articulo a su lista de deseos ?'))
				{
					document.location = '/MoverHaciaLista?ID_ARTICULO='+ID_ARTICULO;
				}
			}
//-->
</script>

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top"><img src="/imagenes/compra/micompra.gif" width="140" height="139" /></td>
              </tr>
            </table></td>
            <td class="Gcentro" width="422"><table width="375" border="0" align="center" cellpadding="0" cellspacing="0">

		 <form name="formCarrito" action="/ActualizarProductos" method="post">
		 <%if (ordenDAO != null) {%>
			  <%request.setAttribute(CompraHelper.FLAG_ES_CARRITO, "true");%>
              <!-- DETALLE DE COMPRA -->
		            <%
							for (int i = 0; i < ordenDAO.getCantidadArticulos(); i++) {
							ArticuloDAO articulo = ordenDAO.getArticulo(i);
					%>
							<input type="hidden" name="ID_ARTICULO" value="<%= articulo.getId() %>">
							<input type="hidden" name="posicionEnLista" value="<%=articulo.getPosicionEnLista()%>">

				              <tr>
				                <td><table width="366" border="0" cellpadding="0" cellspacing="0" class="modulocompra">
				                    <tr>
				                      <td><table width="375" border="0" cellspacing="0" cellpadding="0">
					                      <tr>
				                            <td colspan="3" valign="top" class="titulocompra">
				                            <%
				                            	boolean esSuscripcion = CarritoUtil.estaEnlaOrden(ordenDAO,CarritoUtil.getAriculosExcluidos().get(0));				                            
				                            %>
				                            <%
				                            if(!esSuscripcion){
				                            %>
				                            	<a href="/articulo/detalleArticulo.jsp?idArticulo=<%=articulo.getId()%>&idSeccion=<%=articulo.getCategoriaSeccion()%>" class="FProductos">
				                            <%}else{%>
				                            	<a href="#" class="FProductos">
				                            <%} %>
				                            <%
				                            	out.println(Contenido.getTitulo(articulo.getId()));											 
				                            %>
				                            </a>
				                            </td>
				                          </tr>
				                          <tr>
				                            <td colspan="3" valign="top"><div align="left" class="celdascompra2"><span class="Ftexto01">Disponibilidad: <%=articulo.getDisponibilidad().getNombre()%></span><br />

				                            </div></td>
				                          </tr>
				                          <tr>
				                            <td colspan="3" valign="bottom" class="celdascompra2"><table width="369" border="0" cellspacing="0" cellpadding="0">
				                                <tr>
				                                  <td width="47" valign="bottom"><span class="Ftexto02">Cantidad:</span></td>
				                                  <td width="42"><div align="left">
				                                      <input name="CANTIDAD" type="text" class="empleotext5" value="<%= articulo.getCantidad() %>" maxlength="2" align="center"/>
				                                  </div></td>
				                                  <td width="280" valign="bottom"><div align="left"><a href="javascript:document.formCarrito.submit();" class="Fautores">Actualizar</a></div></td>
				                                </tr>
				                            </table></td>
				                          </tr>
				                          <tr>
					                          <td width="153" height="25" valign="bottom" class="celdascompra"><div align="left"><span class="Fprecio">PRECIO: <%= Contenido.precioToString(articulo.getPrecioConImpuesto() * articulo.getCantidad()) %></span></div></td>
					                          <td width="222" valign="bottom" colspan="2"><div align="left">
					                              <table width="2" border="0" cellspacing="0" cellpadding="0">
					                                <tr>
					                                  <td height="19" class="divInfo"><a href="/EliminarProducto?<%=CommonHelper.ID_ARTICULO%>=<%= articulo.getId() %>&posicionEnLista=<%=articulo.getPosicionEnLista()%>"><img src="/imagenes/compra/b-eliminar.gif" alt="+Info" width="56" height="8" border="0" /></a></td>
					                                  <td class="divComprarPedir"><a href="/MoverHaciaLista?ID_ARTICULO=<%= articulo.getId() %>&posicionEnLista=<%=articulo.getPosicionEnLista()%>"><img src="/imagenes/compra/b-listadedeseos.gif" alt="Comprar" width="153" height="8" border="0" /></a></td>
					                                </tr>
					                              </table>
					                          </div></td>
 				                          </tr>

				                      </table></td>
				                    </tr>
				                </table></td>
				              </tr>
				     		<%} %>
	    <!-- DETALLE DE COMPRA -->

			<%if (ordenDAO.tieneArticulos()) {%>
				<%	if (ordenDAO.isReadWrite() && Convert.toBoolean(request.getAttribute(CompraHelper.FLAG_ES_CARRITO), false)) {
					request.removeAttribute(CompraHelper.FLAG_ES_CARRITO);
				%>
		              <tr>
		                <td><table width="366" border="0" cellpadding="0" cellspacing="0" class="tablacompra5">
		                  <tr>
		                    <td width="289" class="Ftexto02"><div align="left">&iquest;Desea utilizar papel de regalo y escribir una dedicatoria ?</div></td>
		                    <td width="20"><div align="left">
		                      <input type="radio" name="<%= CompraHelper.FLAG_PAPEL %>" value="true" <%=((ordenDAO.getPedirPapelesYNotas())? "checked" : "" )%>/>
		                    </div></td>
		                    <td width="24"><div align="left"><span class="Ftexto02">Si</span></div></td>
		                    <td width="20"><div align="left">
		                      <input type="radio" name="<%= CompraHelper.FLAG_PAPEL %>" value="false" <%=((!ordenDAO.getPedirPapelesYNotas())? "checked" : "" ) %> />
		                    </div></td>

		                    <td width="13"><div align="left"><span class="Ftexto02">No</span></div></td>
		                  </tr>
		                </table></td>
		              </tr>
			<%	}
			%>
		<%}%>
	              <tr>
	                <td><table width="375" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop">
					 <tr>
	                    <td width="50" class="moduloayuda"><table width="355" border="0" cellspacing="0" cellpadding="0">
	                      <tr>
	                        <td width="324" class="foncarrito02">SUBTOTAL <%=Contenido.precioToString(ordenDAO.totalProductos())%></td>

	  		                <%//if (ordenDAO.tieneArticulos()) {%>
								  <td width="42"><div align="right"><a href="javascript:iniciarCompra();"><img src=<%=(ordenDAO.totalProductos()!= 0)? "/imagenes/compra/b-pagar.gif":"/imagenes/compra/b-continuar.gif"%> alt="Pagar" height="10" border="0" /></a></div></td>
							<%//}%>

	                      </tr>
	                      <tr>
	                      	<td>
	                      		<font color="red">
	                      			<%	String msgError = (String)session.getAttribute("msgError");
	                      				if(msgError != null ) {
	                      					out.print(msgError);
	                      				}
	                      			%>
	                      		</font>
	                      	</td>	                      
	                      </tr>
	                      	
	                    </table></td>
	                  </tr>

	                </table></td>
	              </tr>
	            </table></td>
	         </form>
	<%}%>
            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td class="costosdeenviocelda"><span class="Ftexto05">Informaci&oacute;n sobre Gastos de Env&iacute;o y Tiempos de Entrega, <a href="/ayuda/ayudaEstandar.jsp?url=/ayuda/enviosPlazos.jsp" target="blank" class="FAyuda">click aqui</a> </span></td>
              </tr>
              <tr>
                <td><table width="162" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table width="148" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><span class="Ftexto02">EN ESTA PANTALLA USTED PUEDE VER EL LISTADO DE LOS PRODUCTOS QUE COLOCO EN SU CARRITO DE COMPRAS.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Mover a mi lista de deseos:</strong> <br />Presionando este bot&oacute;n usted mueve el producto de su carrito hacia su lista de deseos.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Descuentos</strong>: <br />Si est&aacute; aplicando alg&uacute;n cup&oacute;n, participando de alguna promoci&oacute;n u obteniendo alg&uacute;n descuento, podr&aacute; verlo en todos los casos aplicado luego de ingresar los datos de su medio de pago. Si la promoci&oacute;n incluye productos bonificados, se mostrar&aacute;n con precio 0 reci&eacute;n en ese momento.</span></td>
                        </tr>

                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Disponibilidad</strong>: <br />
                            Muestra el tiempo promedio de salida de dicho producto.<em></em></span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Subtotal</strong>:<br />
                            - Es el importe teniendo en cuenta solo los productos del carrito. <br />
                            - Gastos adicionales o de env&iacute;o ser&aacute;n informados posteriormente.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Papel de Regalo</strong>:<br />
                            Usted tiene la opci&oacute;n de enviar el producto con un papel de regalo a elecci&oacute;n, adjunt&aacute;ndole si as&iacute; lo desea, una dedicatoria.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Bot&oacute;n Actualizar</strong>:<br />
                            Presionando este bot&oacute;n usted recalcula los subtotales seg&uacute;n las cantidades ingresadas.</span></td>
                        </tr>

                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>