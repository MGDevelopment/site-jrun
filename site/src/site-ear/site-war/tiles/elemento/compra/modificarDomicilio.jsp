<%@ page import="com.tmk.kernel.Globals"%>




<%	String tipoDomicilio = request.getParameter("TIPO_DOMICILIO"); %>

<%= Globals.keywords(Globals.PAGINA_SITIO) %>


<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
              	<%if(request.getParameter("TIPO_DOMICILIO").startsWith("EN")) {  %>

                	<td align="left" valign="top"><img src="/imagenes/compra/micompra-02.gif" width="140" height="139" /></td>

                <%}else{ %>

	                <td align="left" valign="top"><img src="/imagenes/compra/micompra-03.gif" width="140" height="139" /></td>

                <%} %>
              </tr>
            </table></td>

            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="modulocompratop">

					<%	String pag ="/compra/modificarDomicilioCompra.jsp?TIPO_DOMICILIO=" + tipoDomicilio + "&HOME=compra";
					%>

			 		<jsp:include page="<%=pag%>"/>

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
                          <td><span class="Ftexto02">AQU&Iacute; SE PRESENTA EL FORMULARIO CON LOS DATOS CORRESPONDIENTES AL DOMICILIO QUE USTED SELECCION&Oacute;.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02">Modifique cualquiera de los campos con la nueva informaci&oacute;n.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02">Presionando el bot&oacute;n <em>Modificar domicilio</em> usted vuelve a la p&aacute;gina anterior y sus cambios habr&aacute;n sido actualizados.</span></td>
                        </tr>

                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
    </table>
<script>
	document.formDomicilio.CALLE.focus()
</script>