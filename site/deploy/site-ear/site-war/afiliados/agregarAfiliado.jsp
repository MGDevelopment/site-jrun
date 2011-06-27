<%@ page import="com.tmk.kernel.Convert"%>

<script>
function agregar()
{

	if (isEmpty(document.formAfiliado.RAZON_SOCIAL.value)) {
		alert('Debés ingresar la Razón Social.');
		document.formAfiliado.RAZON_SOCIAL.focus();
		return false;
	}
	if (isEmpty(document.formAfiliado.URL.value) || document.formAfiliado.URL.value=='http://') {
		alert('Debés ingresar la URL del Sitio.');
		document.formAfiliado.URL.focus()
		return false;
	}

	if (isEmpty(document.formAfiliado.NOMBRE_CONTACTO.value)) {
		alert('Indicá el nombre del contacto.');
		document.formAfiliado.NOMBRE_CONTACTO.focus()
		return false;
	}
	if (isEmpty(document.formAfiliado.APELLIDO_CONTACTO.value)) {
		alert('Indicá el apellido del contacto.');
		document.formAfiliado.APELLIDO_CONTACTO.focus()
		return false;
	}
	if (isEmpty(document.formAfiliado.CARGO_CONTACTO.value)) {
		alert('Debés ingresar el cargo del contacto.');
		document.formAfiliado.CARGO_CONTACTO.focus()
		return false;
	}
	if (isEmpty(document.formAfiliado.COD_AREA.value)) {
		alert('Ingresá el código de área.');
		document.formAfiliado.COD_AREA.focus()
		return false;
	}

	if (isEmpty(document.formAfiliado.NRO_TEL.value)) {
		alert('Debés ingresar el número de teléfono del contacto.');
		document.formAfiliado.NRO_TEL.focus()
		return false;
	}

	if (!isMail(document.formAfiliado.E_MAIL_1.value)) {
		alert('Debés ingresar un e-mail válido.');
		document.formAfiliado.E_MAIL_1.focus()
		return false;
	}
	if (isEmpty(document.formAfiliado.NOMBRE_PAGO_COMISION.value)) {
		alert('Ingresá el nombre correspondiente al Pago de comisiones.');
		document.formAfiliado.NOMBRE_PAGO_COMISION.focus()
		return false;
	}
	if (isEmpty(document.formAfiliado.APELLIDO_PAGO_COMISION.value)) {
		alert('Ingresá el apellido correspondiente al Pago de comisiones.');
		document.formAfiliado.APELLIDO_PAGO_COMISION.focus()
		return false;
	}

	if (isEmpty(document.formAfiliado.CUIT.value)) {
		alert('Debés ingresar el CUIT.');
		document.formAfiliado.CUIT.focus()
		return false;
	}
	if (isEmpty(document.formAfiliado.USUARIO.value)) {
		alert('Debés ingresar un usuario.');
		document.formAfiliado.USUARIO.focus()
		return false;
	}

	if (isEmpty(document.formAfiliado.CLAVE.value)) {
		alert('Debés ingresar la clave.');
		document.formAfiliado.CLAVE.focus()
		return false;
	}

	if (isEmpty(document.formAfiliado.confirmaClave.value)) {
		alert('Debés confirmar la clave.');
		document.formAfiliado.confirmaClave.focus()
		return false;
	}

	if( (document.formAfiliado.CLAVE.value) != (document.formAfiliado.confirmaClave.value)){
		alert('La clave y su confirmación deben ser iguales.');
		document.formAfiliado.CLAVE.focus()
		return false;
	}
return true;
//document.formAfiliado.submit();

}


</script>
<%
    String RAZON_SOCIAL = Convert.toString(request.getParameter("RAZON_SOCIAL"), "");
    String URL = Convert.toString(request.getParameter("URL"), "");
    String TIPO_NEGOCIO = request.getParameter("TIPO_NEGOCIO");
    String CUIT = Convert.toString(request.getParameter("CUIT"), "");
    String USUARIO = Convert.toString(request.getParameter("USUARIO"), "");
    String ID_TIPO_CONTRIBUYENTE = request.getParameter("ID_TIPO_CONTRIBUYENTE");
    String NOMBRE_CONTACTO = Convert.toString(request.getParameter("NOMBRE_CONTACTO"), "");
    String APELLIDO_CONTACTO = Convert.toString(request.getParameter("APELLIDO_CONTACTO"), "");
    String CARGO_CONTACTO = Convert.toString(request.getParameter("CARGO_CONTACTO"), "");
    String NOMBRE_PAGO_COMISION = Convert.toString(request.getParameter("NOMBRE_PAGO_COMISION"), "");
    String APELLIDO_PAGO_COMISION = Convert.toString(request.getParameter("APELLIDO_PAGO_COMISION"), "");
    String E_MAIL_1 = Convert.toString(request.getParameter("E_MAIL_1"), "");
    String E_MAIL_2 = Convert.toString(request.getParameter("E_MAIL_2"), "");
    String COD_AREA = Convert.toString(request.getParameter("COD_AREA"), "");
    String NRO_TEL = Convert.toString(request.getParameter("NRO_TEL"), "");
    String EXT_INT = Convert.toString(request.getParameter("EXT_INT"), "");

    String feedback = (String)session.getAttribute("Extranet.feedback");
%>

                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-afiliados.gif" alt="Programa de afiliados" width="219" height="12" /></td>
                  </tr>
                  <tr>
               <form name="formAfiliado" action="/AgregarAfiliado" method="post" onsubmit="return agregar()">
   			   <input type="hidden" name="TIPO_COMISION" value="<%= request.getParameter("TIPO_COMISION") %>">
                    <td class="moduloayuda">
                    <table width="370" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td height="45" colspan="3" valign="top" class="Ftexto02"><strong>Para formar parte del Programa de Afiliados el interesado deber&aacute; ingresar los siguientes datos:</strong><br /></td>
                            </tr>

                            <tr>
                              <td colspan="3" valign="bottom" class="FTtit01">INFORMACION DEL SITIO</td>
                              </tr>
                            <tr>
                              <td width="143" valign="bottom" class="Ftexto02"><span class="Ftextorojo"> </span> <span class="Ftextorojo">&nbsp;&nbsp;</span>Raz&oacute;n Social : </td>
                              <td width="227" colspan="2"><div align="left">

                                  <input type="text" name="RAZON_SOCIAL" size="55" value="<%= RAZON_SOCIAL%>" class="ayudatext" />
                              </div></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> URL del sitio: </td>
                              <td colspan="2"><div align="left">
                                <input type="text" name="URL" size="55" value="<%=("".equals(URL))?"http://":URL%>" class="ayudatext" º/>
                              </div></td>

                            </tr>
                            <tr>
                              <td height="28" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">CONTACTO</span></td>
                              </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>Nombres: </td>
                              <td colspan="2"><div align="left">
                                  <input type="text" name="NOMBRE_CONTACTO" value="<%= NOMBRE_CONTACTO%>" size="50" class="ayudatext" />

                              </div></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>Apellidos: </td>
                              <td colspan="2"><div align="left">
                                  <input type="text" name="APELLIDO_CONTACTO" value="<%= APELLIDO_CONTACTO%>" size="50" class="ayudatext" />
                              </div></td>
                            </tr>


                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>Cargo: </td>
                              <td colspan="2"><div align="left">
                                <input type="text" name="CARGO_CONTACTO" value="<%= CARGO_CONTACTO%>" size="50" class="ayudatext" />
                              </div></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>C&oacute;digo de area: </td>

                              <td colspan="2"><div align="left">
                                  <input type="text" name="COD_AREA" value="<%= COD_AREA%>" size="5" class="empleotext4date" />
                              </div></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>N&uacute;mero: </td>
                              <td colspan="2"><div align="left">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">

                                  <tr>
                                    <td width="47%"><input type="text" name="NRO_TEL" value="<%= NRO_TEL%>" size="17" class="empleotext" /></td>
                                    <td width="53%" valign="bottom"><div align="left" class="Ftexto02">Int:
                                        <input type="text" name="EXT_INT" value="<%= EXT_INT%>" size="7" class="empleotext5" />
                                    </div></td>
                                  </tr>
                                </table>
                              </div></td>
                            </tr>

                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>E-mail: </td>
                              <td colspan="2"><div align="left">
                                  <input type="text" name="E_MAIL_1" value="<%= E_MAIL_1%>" size="50" class="ayudatext" />
                              </div></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>E-mail alternativo: </td>

                              <td colspan="2"><div align="left">
                                  <input type="text" name="E_MAIL_2" value="<%= E_MAIL_2%>" size="50" class="ayudatext" />
                              </div></td>
                            </tr>
                            <tr>
                              <td height="28" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">PAGO DE COMISIONES</span></td>
                            </tr>
                            <tr>

                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>Nombres: </td>
                              <td colspan="2"><div align="left">
                                  <input type="text" name="NOMBRE_PAGO_COMISION" value="<%= NOMBRE_PAGO_COMISION%>" size="55" class="ayudatext" />
                              </div></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>Apellidos: </td>
                              <td colspan="2"><div align="left">

                                  <input type="text" name="APELLIDO_PAGO_COMISION" value="<%= APELLIDO_PAGO_COMISION%>" size="50" class="ayudatext" />
                              </div></td>
                            </tr>

                            <tr>
                              <td height="28" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">INFORMACION DE SU CUENTA</span></td>
                            </tr>
                            <tr>
                              <td height="28" valign="bottom" class="Ftexto02">Tipo de negocio: </td>
							<%
							    boolean negocioValido = (TIPO_NEGOCIO == null || TIPO_NEGOCIO == "0" );
							    String tipoIndividual = (negocioValido)? "checked" : "";
							    String tipoCorporativo = (negocioValido)? "" : "checked";
							%>
                              <td height="28" colspan="2" valign="bottom"><table class="Ftexto02" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td width="9%"><div align="left">
                                    <input type="radio" name="TIPO_NEGOCIO" value="0" <%= tipoIndividual%> />
                                  </div></td>
                                  <td width="27%"><div align="left">Individual</div></td>
                                  <td width="10%"><div align="left">
                                    <input type="radio" name="TIPO_NEGOCIO" value="1" <%= tipoCorporativo%> />

                                  </div></td>
                                  <td width="54%"><div align="left">Corporativo</div></td>
                                </tr>
                              </table></td>
                            </tr>
                            <tr>
                              <td height="28" valign="bottom" class="Ftexto02">&nbsp;</td>
                              <td height="28" colspan="2" valign="bottom"><table class="Ftexto02" width="100%" border="0" cellspacing="0" cellpadding="0">

                                <tr>
                                  <td width="9%"><div align="left">
                                      <input input type="radio" name="ident" value="checkbox" checked />
                                  </div></td>
                                  <td width="27%"><div align="left">CUIT</div></td>
                                  <td width="10%"><div align="left">
                                      <input input type="radio" name="ident" value="checkbox" />
                                  </div></td>

                                  <td width="54%"><div align="left">CUIL</div></td>
                                </tr>
                              </table></td>
                            </tr>
                            <tr>
                              <td height="28" valign="bottom" class="Ftexto02">&nbsp;</td>
                              <td height="28" colspan="2" valign="bottom" style="padding-left:7px"><table class="Ftexto02" width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>

                                  <td width="20%" valign="bottom">N&uacute;mero:</td>
                                  <td width="80%" valign="bottom"><input type="text" name="CUIT" value="<%= CUIT%>" class="empleotext2" /></td>
                                </tr>
                              </table></td>
                            </tr>

                            <tr>
                              <td height="28" valign="bottom" class="Ftexto02">Condici&oacute;n frente al IVA: </td>
						<%
						    boolean contribuyenteValido = (ID_TIPO_CONTRIBUYENTE == null || ID_TIPO_CONTRIBUYENTE == "0" );
						    String tipoInscripto = (contribuyenteValido)? "" : "checked";
						    String tipoNoInscripto = (contribuyenteValido)? "checked" : "";
						%>
                              <td height="28" colspan="2" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                                <tr>
                                  <td width="9%"><div align="left">
                                      <input type="radio" name="ID_TIPO_CONTRIBUYENTE" value="1" <%= tipoInscripto%> />
                                  </div></td>
                                  <td width="27%"><div align="left">Inscripto</div></td>
                                  <td width="10%"><div align="left">
                                      <input type="radio" name="ID_TIPO_CONTRIBUYENTE" value="0" <%= tipoNoInscripto%> />

                                  </div></td>
                                  <td width="54%"><div align="left">No inscripto </div></td>
                                </tr>
                              </table></td>
                            </tr>
                            <tr>
                              <td height="28" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">USUARIO Y PASSWORD</span></td>
                            </tr>
                            <%
							    if(feedback != null) {
							        session.removeAttribute("Extranet.feedback");
							%>
							<tr>
                              <td colspan="3">&nbsp;</td>
                            </tr>
                            <tr>
	                            <td  colspan="3" valign="bottom" class="Ftexto02"><span class="Ftextorojo"><b><%=feedback %></b></span></td>
				            </tr>
							<%	}
							%>

                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>Usuario: </td>
                              <td colspan="2"><div align="left">
                                  <input type="text" name="USUARIO" value="<%= USUARIO%>" class="ayudatext"/>
                              </div></td>
                            </tr>
							 <%
							    if(feedback != null) {
							%>
							<%= "<script> window.formAfiliado.USUARIO.focus();</script>"%>
							<%} %>

                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>Clave: </td>

                              <td colspan="2"><div align="left">
                                  <input type="password" name="CLAVE" class="ayudatext" />
                              </div></td>
                            </tr>

                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span>Confirmar clave: </td>
                              <td colspan="2"><div align="left">
                                  <input type="password" name="confirmaClave" class="ayudatext" />
                              </div></td>
                            </tr>
             				<tr>
                              <td valign="bottom" class="Ftexto02">&nbsp;</td>
                              <td colspan="2">&nbsp;</td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td colspan="2"><div align="right">
                              <input type="image" src="/imagenes/inicio/b-regafiliado.gif">
                              <!-- a href="javascript:agregar();"><img src="/imagenes/inicio/b-regafiliado.gif" alt="Registrarse como afiliado" width="191" height="10" border="0" class="benviar2" /></a--></div></td>
                            </tr>
                          </table></td>
                        </tr>
                    </table></td>
                    </form>
                  </tr>
                </table></td>