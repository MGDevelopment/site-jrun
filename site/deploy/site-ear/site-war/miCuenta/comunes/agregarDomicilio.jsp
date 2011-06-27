<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.*,
                 com.tmk.controllers.compra.CompraHelper "%>
<%  String URI = request.getRequestURI(); %>
<jsp:include flush="true" page="/js/Combos.jsp"/>

<script type="text/javascript">
	function validar() {
		var form = document.formDomicilio;

		if (isEmpty(form.CALLE.value)) {
			form.CALLE.focus();
			alert('Ingresá un nombre de calle');
			return;
		}

  	    if (isNaN(form.NUMERO.value) || isEmpty(form.NUMERO.value)) {
			form.NUMERO.focus();
			alert('Debés indicar un número');
			return;
		}

		if (form.ID_PROVINCIA.value == -1)
		{
			alert('Seleccioná una provincia de la lista');
			return;
		}

		if (form.ID_LOCALIDAD.value == -1)
		{
			alert('Seleccioná una localidad de la lista');
			return;
		}
		if (isEmpty(form.CP.value)) {
			form.CP.focus();
			alert('Debés indicar un código postal');
			return;
		}



		form.submit();
	}
</script>

				<tr>
				<form action="/AgregarDomicilio" method="post" name="formDomicilio">
					<input type="hidden" name="TIPO_DOMICILIO" value="<%= request.getParameter("TIPO_DOMICILIO") %>">
<%--				<input type="hidden" name="_DISPATCHER" value="/<%= request.getParameter("HOME") %>/domicilios.jsp?TIPO_DOMICILIO=<%= request.getParameter("TIPO_DOMICILIO") %>"> --%>
					<input type="hidden" name="_DISPATCHER" value="/<%= request.getParameter("HOME") %>/domicilios.jsp?TIPO_DOMICILIO=<%= request.getParameter("TIPO_DOMICILIO") %>">

                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="35" colspan="3" valign="top" class="Ftexto02"><strong>Agregar domicilio </strong>(deje en blanco el campo que no corresponda).<br />
                          Recuerde que los campos con (<span class="Ftextorojo">*</span>) son obligatorios.</td>
                      </tr>
                      <tr>
                        <td width="142" valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Calle: </td>
                        <td width="224" colspan="2"><div align="left">
                            <input name="CALLE" value="" size="50" maxlength="54" type="text" class="ayudatext" onKeyPress="cambiarFoco(event,'document.formDomicilio.NUMERO');"/>
                        </div></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> N&uacute;mero: </td>
                        <td colspan="2"><div align="left">
                          <input name="NUMERO" value="" size="5" maxlength="10" type="text" class="empleotext4date" onKeyPress="cambiarFoco(event,'document.formDomicilio.EDIFICIO');" />
                        </div></td>
                      </tr>
                      <tr>
                        <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Piso: </td>
                        <td height="28" colspan="2"><div align="left">
                          <input name="PISO" value="" size="3" maxlength="3" type="text" class="empleotext5" onKeyPress="cambiarFoco(event,'document.formDomicilio.DEPTO');" />
                        </div></td>
                      </tr>
                      <tr>
                        <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Departamento:</td>
                        <td height="28" colspan="2"><div align="left">
                          <input name="DEPTO" value="" size="4" maxlength="4" type="text" class="empleotext5" onKeyPress="cambiarFoco(event,'document.formDomicilio.CP');" />
                        </div></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Edificio: </td>
                        <td colspan="2"><div align="left">
                            <input name="EDIFICIO" value="" size="4" maxlength="4" type="text" class="empleotext4date" onKeyPress="cambiarFoco(event,'document.formDomicilio.PISO');" />
                        </div></td>
                      </tr>

                    <%	PaisDAO paisDefault = Globals.ARGENTINA;%>

                     <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Pa&iacute;s: </td>
                        <td colspan="2"><div align="left">
                            <select name="ID_PAIS" onChange="javascript:INDEX_PAIS = actualizarCombo(this, document.formDomicilio.ID_PROVINCIA, paises);INDEX_PROVINCIA = actualizarCombo(formDomicilio.ID_PROVINCIA, document.formDomicilio.ID_LOCALIDAD, paises[INDEX_PAIS].comboDependiente);activarOtraProvincia();" onKeyPress="cambiarFoco(event,'document.formDomicilio.ID_PROVINCIA');" class="empleomenu4">
                              <script type="text/javascript">
								for(i = 0; i < paises.length; i++) {
									var selected;

									if (paises[i].id == <%= paisDefault.getId() %>) {
										selected =  " selected ";
										INDEX_PAIS = i ;
									} else {
										selected = ""
									}

									document.write('<option value="' + paises[i].id + '"' + selected + '>');
									document.write(paises[i].descripcion);
									document.write('</option>');
								}
  							  </script>
                            </select>
                        </div></td>
                      </tr>

                      <tr>
                        <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Provincia: </td>
                        <td height="28" colspan="2"><div align="left">
                          <select name="ID_PROVINCIA" onfocus="activarOtraLocalidad()" onChange="javascript:INDEX_PROVINCIA = actualizarCombo(this, document.formDomicilio.ID_LOCALIDAD, paises[INDEX_PAIS].comboDependiente);activarOtraProvincia();" onKeyPress="cambiarFoco(event,'document.formDomicilio.ID_LOCALIDAD');" class="empleomenu2">
			                  <option value="-1">
								Elegir de la lista
							  </option>
							  <script type="text/javascript">
								for(i = 0; i < paises[INDEX_PAIS].comboDependiente.length; i++)
								{
									document.write('<option value="' + paises[INDEX_PAIS].comboDependiente[i].id + '"' + '>');
									document.write(paises[INDEX_PAIS].comboDependiente[i].descripcion);
									document.write('</option>');
								}
							   </script>
			              </select>

                        </div></td>
                      </tr>

                      <tr>
                      	  <td>&nbsp;</td>
	                      <td class="Ftexto02">&nbsp;&nbsp;&nbsp;Otra
                            <input name="PROVINCIA_EXTERNA" size="20" maxlength="15" disabled type="text" class="empleotext2" />
                          </td>
                      </tr>

                      <tr>
                        <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Localidad: </td>
                        <td height="28" colspan="2"><div align="left">
                            <select name="ID_LOCALIDAD" onchange="activarOtraLocalidad()" onfocus="activarOtraLocalidad()"  class="empleomenu2">
								<option value="-1" selected>
									Elija una provincia primero
								</option>
							</select>

                        </div></td>
                      </tr>
                      <tr>
                      	  <td>&nbsp;</td>
	                      <td class="Ftexto02">&nbsp;&nbsp;&nbsp;Otra
                            <input name="LOCALIDAD_EXTERNA" size="20" maxlength="20" disabled type="text" class="empleotext2" />
                          </td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> C&oacute;digo postal: </td>
                        <td colspan="2"><div align="left">
                            <input name="CP" value="" size="22" maxlength="20" type="text" class="empleotext" onKeyPress="cambiarFoco(event,'document.formDomicilio.ID_PAIS');" />
                        </div></td>
                      </tr>

                      <tr>
                        <td>&nbsp;</td>
                        <td colspan="2"><div align="right"><a href="javascript:validar();">


                        <%if ( URI.equalsIgnoreCase("/compra/agregarDomicilio.jsp")){%>
							<img src="/imagenes/compra/b-continuar.gif" alt="Agregar domicilio" width="74" height="10" border="0" class="benviar2" />
                        <%}else{ %>
	                      	<img src="/imagenes/miCuenta/b-agregar.gif" alt="Agregar domicilio" width="60" height="10" border="0" class="benviar2" />
    					<%} %>

                        </a></div></td>
                      </tr>

                    </table>
                    </td>
                  </form>
                  </tr>

