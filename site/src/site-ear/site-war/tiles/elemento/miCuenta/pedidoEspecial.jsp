<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.pedidoEspecial.PedidoEspecialHelper,
				 com.tmk.articulo.ArticuloLocal,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.*,
                 java.util.Vector"%>
<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>

<%--
                 //com.tmk.socio.SocioLocalHome,
                 //com.tmk.socio.SocioLocal, 
--%>

<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	//SocioLocalHome socioHome = (SocioLocalHome)DBUtil.getHome("Socio");
	//SocioLocal socio = socioHome.findByPrimaryKey(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
	Socios2 socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
	//String nombreCompleto = Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS());
	String nombreCompleto = Convert.nombreCompleto(socio.getNombres(), socio.getApellidos());

	ArticuloLocal articuloLocal = Contenido.getArticulo(Convert.toNumber(request.getParameter(PedidoEspecialHelper.CAMPO_ARTICULO), Globals.ARTICULO_DEFAULT));

%>

<script type="text/javascript" src="/js/Validation.js" ></script>
<script type="text/JavaScript">
			function continuar() {
				if(isEmpty(document.pedidoAgotados.<%= PedidoEspecialHelper.CAMPO_TELEFONO %>.value)) {
					alert('Es obligatorio indicar un número de teléfono.');
					return;
				} else if(isEmpty(document.pedidoAgotados.<%= PedidoEspecialHelper.CAMPO_HORARIO %>.value)) {
					alert('Es obligatorio indicar un horario.');
					return;
				} else {
					document.pedidoAgotados.submit();
				}
			}
</script>

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
               <tr>
                <td align="left" valign="top">
                <!-- ARBOL -->
            	<%
            	//String arbolPage = "/contenidosEstaticos/homes/arbolCategorias" + Globals.SECCION_HOME + ".html";
            	%>
            	<%--jsp:include page="<%=arbolPage%>"/--%>
                <!-- ARBOL -->
                </td>
              </tr>
              <tr>
               <%--
           		//String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + Globals.SECCION_HOME;
           	   %>
                <jsp:include page="<%=urlInstitucionalLeft%>"/--%>
              </tr>
            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-pedidoespecial.gif" alt="Pedido especial" width="173" height="12" /></td>
                  </tr>

                  <tr>

	               	<form name="pedidoAgotados" method="post" action="/PedidoEspecial">
					<input type="hidden" name="<%= PedidoEspecialHelper.CAMPO_ARTICULO %>" value="<%= articuloLocal.getID_ARTICULO().intValue() %>">

                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">

					  <tr>
					  	<td>
						<%if (session.getAttribute("mensajePedidoEspecial") != null) {
						%>
						<span style="font-size:14;color:red"><%=session.getAttribute("mensajePedidoEspecial") %></span>
						<%
							session.removeAttribute("mensajePedidoEspecial");
						} %>
						</td>
                      </tr>

                      <tr>
                        <td colspan="3" valign="bottom" style="padding-bottom:10px; text-align:left"><span class="FTtit01">MOMENTANEAMENTE SIN DISPONIBILIDAD</span><br />
                          <span class="Ftexto02">
                          <p>El producto que usted ha solicitado se encuentra sin stock. <br />
                            Tematika le ofrece un servicio de b&uacute;squeda sin cargo adicional. <br />
                            El precio est&aacute; sujeto a variaciones determinadas por el proveedor.<br />
                            <br />
                            Si desea encargarlo, por favor complete el siguiente formulario. <br />
                            Recuerde que los campos con (<span class="Ftextorojo">*</span>) son obligatorios.<br />
                            <br />
                          </p>
                          </span></td>
                      </tr>
                      <tr>
                        <td width="142" height="29" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Art&iacute;culo: </td>
                        <td width="224" height="29" align="left" valign="bottom" class="celdapedidoespecialfor"><span class="Ftexto02"><%= Contenido.getTitulo(articuloLocal.getID_ARTICULO().intValue()) %></span> </td>
                      </tr>
                      <tr>
                        <td height="29" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Disponibilidad: </td>
                        <td height="29" colspan="2" valign="bottom" class="celdapedidoespecialfor"><span class="Ftexto02"><%= articuloLocal.getDISPONIBILIDAD_SITIO().getNombre() %></span> </td>
                      </tr>
                      <tr>
                        <td height="29" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Nombre completo: </td>
                        <td height="29" colspan="2" valign="bottom" class="celdapedidoespecialfor"><span class="Ftexto02"><%= nombreCompleto %></span> </td>
                      </tr>
					  <tr>
                        <td height="29" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Email: </td>
                        <%--<td height="29" colspan="2" valign="bottom" class="celdapedidoespecialfor"><span class="Ftexto02"><%= socio.getEMAIL() %></span> </td>--%>
                        <td height="29" colspan="2" valign="bottom" class="celdapedidoespecialfor"><span class="Ftexto02"><%= socio.getlogin() %></span> </td>
                      </tr>


                      <tr>
                        <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">* </span>Tel&eacute;fono: </td>
                        <td height="28" colspan="2" valign="bottom"><div align="left">
                          <input name="<%= PedidoEspecialHelper.CAMPO_TELEFONO %>" type="text" size=50 class="empleotext" />
                        </div></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Horario de contacto: </td>
                        <td colspan="2"><div align="left">
                            <input name="<%= PedidoEspecialHelper.CAMPO_HORARIO %>" type="text" size=50 class="ayudatext" />
                        </div></td>
                      </tr>
                      <tr>
                        <td height="25" valign="bottom"><div align="left"><span class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Comentarios: </span></div></td>
                        <td rowspan="2"><textarea name="<%= PedidoEspecialHelper.CAMPO_COMENTARIO %>" class="ayudatextarea"></textarea></td>
                      </tr>

                       <tr>
                           <td>&nbsp;</td>
                       </tr>
                       <tr>
                           <td>&nbsp;</td>
                       </tr>

                      <%
						String alcance = "PEESP";
						Pair par = DBUtil.getConsulta(alcance);
	 					if( par != null ) {
  					  %>

					    <tr>

					    <td colspan="4"><table width="360" align="center">

								<tr>
									<td colspan="2" class="Ftexto02">
									<b>Ay&uacute;denos a atenderlo mejor.</b>
									</td>
								</tr>
								<tr>
									<td colspan="2" class="Ftexto02">
									<input type="hidden" name="<%= PedidoEspecialHelper.CAMPO_ID_CONSULTA %>" value="<%= par.getValue1()%>" >
									<%= par.getValue2()	%>
									</td>
								</tr>

								<%
						            Vector vector = DBUtil.getOpinion((Integer)par.getValue1());
									String radioChecked = "checked";
									for( int i=0; i < vector.size(); i++) {
								%>
									<tr>
										<td class="Ftexto02">
	                                        <input type="radio" name="<%= PedidoEspecialHelper.CAMPO_ID_OPINION %>" value="<%= ((Pair)vector.get(i)).getValue1() %>" <%= radioChecked%>>
										</td>
										<td class="Ftexto02">
                                            <%= ((Pair)vector.get(i)).getValue2() %>
										</td>
									</tr>
								<%
									radioChecked = "";
									}
								%>
					    </table></td>

					    </tr>
       				  <%}%>

                      <tr>
                        <td>&nbsp;</td>
                        <td colspan="2"><div align="right"><a href="javascript:continuar();"><img src="/imagenes/inicio/b-enviar.gif" alt="Enviar" width="47" height="9" border="0" class="benviar2" /></a></div></td>
                      </tr>
                    </table></td>
                    </form>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
            </table></td>
          </tr>
        </table>

<%=Globals.getGoogleAnalyticsSSL()%>
