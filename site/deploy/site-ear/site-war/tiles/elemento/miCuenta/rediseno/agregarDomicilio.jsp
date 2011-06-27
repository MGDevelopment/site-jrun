<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.src.socio.SocioPK"%>


<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">

              	<%SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
			 	if (socioPK != null) { %>
				<tr>
					<td valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
            			<tr>
							  <td align="left" class="preguntasceldas"><a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a></td>
		                </tr>
    		        </table></td>
	    	   	</tr>
    	   		<%}%>
            	<jsp:include page="/miCuenta/left.jsp"/>
            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>

				<!-- FORM agregarDomicilio -->

				 <jsp:include page="/miCuenta/comunes/agregarDomicilio.jsp"/>

				<!-- FORM agregarDomicilio -->

                </table></td>
              </tr>

               <tr>
                 <!-- ultimos visitados -->
                <td>
                <%
            	String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            	%>
            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
                </td>
                 <!-- ultimos visitados -->
              </tr>

            </table></td>
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><span class="Ftexto02">EN ESTA PANTALLA USTED PUEDE DAR DE ALTA UNA NUEVA DIRECCI&Oacute;N.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Calle:</strong> Ingrese el nombre de su calle lo m&aacute;s completo posible.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>N&uacute;mero</strong>: Ingrese aqu&iacute; el n&uacute;mero exacto de su domicilio.</span></td>
                        </tr>

                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Provincia</strong>: <br />
                            - Seleccione de la lista la provincia que corresponda con su domicilio. <br />
                            - Si no la encuentra elija la opci&oacute;n <em>Otra Provincia</em> del men&uacute;. <br />
                            - Complete el nombre de la misma en el campo <em>Otra</em>.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Localidad</strong>:<br />
                            - Seleccione de la lista la localidad que corresponda con su domicilio. <br />
                            - Si no la encuentra elija la opci&oacute;n <em>Otra Localidad</em> del men&uacute;. <br />
                            - Complete el nombre de la misma en el campo <em>Otra</em>.</span></td>
                        </tr>

                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>