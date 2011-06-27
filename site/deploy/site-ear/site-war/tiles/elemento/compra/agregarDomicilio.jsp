<%@ page import="com.tmk.kernel.Globals"%>

<%	String tipoDomicilio = request.getParameter("TIPO_DOMICILIO");

%>


	<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top"><img src="/imagenes/compra/micompra-02.gif" width="140" height="139" /></td>
              </tr>
            </table></td>

            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="modulocompratop">

                  <jsp:include page="/tiles/elemento/comunes/agregarDomicilio.jsp"/>

                </table></td>
              </tr>

              <tr>
                <td>&nbsp;</td>


              </tr>

            </table></td>

            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="162" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table width="148" border="0" align="center" cellpadding="0" cellspacing="0">
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
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Pa&iacute;s</strong>: <br />
                            - Es el listado de los países donde enviamos los productos.  <br />
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