<%@ page import="com.tmk.socio.SocioDomicilioLocalHome,
                 com.tmk.socio.SocioDomicilioLocal,
                 com.tmk.socio.SocioDomicilioPK,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.*,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.orden.OrdenDAO"%>



<script type="text/javascript" src="/js/Validation.js"></script>
<script type="text/javascript" src="/js/Combo.js"></script>
<jsp:include page="/js/Combos.jsp" />

<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	SocioDomicilioPK pk = new SocioDomicilioPK();
	pk.ID_SUCURSAL = socioPK.ID_SUCURSAL;
	pk.ID_SOCIO = socioPK.ID_SOCIO;
	pk.TIPO_DOMICILIO = request.getParameter("TIPO_DOMICILIO");

	SocioDomicilioLocalHome domicilioHome = (SocioDomicilioLocalHome)DBUtil.getHome("SocioDomicilio");

	SocioDomicilioLocal domicilio = domicilioHome.findByPrimaryKey(pk);
%>

<script type="text/javascript">
	function validarForm(form)
	{
		var form = document.formDomicilio;

		if(isEmpty(form.CALLE.value))
		{
			form.CALLE.focus();
			alert('Debés indicar una calle');
			return;
		}

		if(isNaN(form.NUMERO.value) || isEmpty(form.NUMERO.value))
		{
			form.NUMERO.focus();
			alert('Debés indicar un número');
			return;
		}

		if( !isEmpty(form.PISO.value) && isNaN(form.PISO.value))
		{
			form.PISO.focus();
			alert('Debés indicar un número');
			return;
		}


		if(isEmpty(form.CP.value))
		{
			form.CP.focus();
			alert('Debés indicar un Código Postal');
			return;
		}

		form.submit();
	}

</script>



				<tr>
				<form action="/ActualizarDomicilio" method="post" name="formDomicilio">
					<input type="hidden" name="_DISPATCHER" value="/<%= request.getParameter("HOME") %>/?seccionMiCuenta=3&opcionMenu=0&TIPO_DOMICILIO=<%= request.getParameter("TIPO_DOMICILIO") %>">
					<input type="hidden" name="TIPO_DOMICILIO" value="<%= pk.TIPO_DOMICILIO %>">

				<%if (!(domicilio.getEsEditable())) {%>
					<tr class="moduloayuda">

							<td>
								<table cellpadding="4" class="moduloayuda">
							<tr valign="middle">
								<td class="moduloayuda"><img src="/imagenes/miCuenta/baliza.gif"></td>
								<td><div class="Ftextorojo">Si Ud. modifica esta dirección el cambio se reflejará en la
							orden número <a href="/compra/detalleOrden.jsp?idOrden=<%= domicilio.getID_ORDEN()%>"><%= Convert.toString(domicilio.getID_ORDEN())%></a>
							actualmente en progreso. Para evitarlo agregue una nueva dirección.</div></td>
							</tr>
							</table>
							</td>

						</tr>
				<% }%>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="35" colspan="3" valign="top" class="Ftexto02"><strong>Modificar domicilio</strong><br />
                          Recuerde que los campos con (<span class="Ftextorojo">*</span>) son obligatorios.</td>
                      </tr>
                      <tr>
                        <td width="142" valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Calle: </td>
                        <td width="224" colspan="2"><div align="left">
                            <input name="CALLE" value="<%= domicilio.getCALLE() %>" size="50" maxlength="54" type="text" class="ayudatext" onKeyPress="cambiarFoco(event,'document.formDomicilio.NUMERO');"/>
                        </div></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> N&uacute;mero: </td>
                        <td colspan="2"><div align="left">
                          <input name="NUMERO" value="<%=(domicilio.getNUMERO() == null)? "" :Convert.toString(domicilio.getNUMERO())%>" size="5" maxlength="10" type="text" class="empleotext4date" onKeyPress="cambiarFoco(event,'document.formDomicilio.EDIFICIO');" />
                        </div></td>
                      </tr>
                      <tr>
                        <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Piso: </td>
                        <td height="28" colspan="2"><div align="left">
                          <input name="PISO" value="<%=Convert.toString(domicilio.getPISO()) %>" size="3" maxlength="3" type="text" class="empleotext5" onKeyPress="cambiarFoco(event,'document.formDomicilio.DEPTO');" />
                        </div></td>
                      </tr>
                      <tr>
                        <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Departamento:</td>
                        <td height="28" colspan="2"><div align="left">
                          <input name="DEPTO" value="<%=Convert.toString(domicilio.getDEPTO()) %>" size="4" maxlength="4" type="text" class="empleotext5" onKeyPress="cambiarFoco(event,'document.formDomicilio.CP');" />
                        </div></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Edificio: </td>
                        <td colspan="2"><div align="left">
                            <input name="EDIFICIO" value="<%=Convert.toString(domicilio.getEDIFICIO()) %>" size="4" maxlength="4" type="text" class="empleotext4date" onKeyPress="cambiarFoco(event,'document.formDomicilio.PISO');" />
                        </div></td>
                      </tr>

                    <%	PaisDAO paisDefault = PaisDAO.getPais(domicilio.getID_PAIS());%>

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
                      <%	ProvinciaDAO provinciaDefault = paisDefault.getProvincia(domicilio.getID_PROVINCIA());%>
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
				                        if (paises[INDEX_PAIS].comboDependiente[i].id == <%= provinciaDefault.getId() %>) {
				                            selected = " selected";
				                            INDEX_PROVINCIA = i;
				                        } else {
				                            selected = "";
				                        }
				                        //selected = (paises[INDEX_PAIS].comboDependiente[i].id == <%= provinciaDefault.getId() %>) ? " selected " : "";

				                        document.write('<option value="' + paises[INDEX_PAIS].comboDependiente[i].id + '"'  + selected + '>');
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
                            <input name="PROVINCIA_EXTERNA" value="<%=Convert.toString(domicilio.getDESCRIPCION_PROVINCIA_INEX())%>" size="20" maxlength="15" type="text" class="empleotext2" />
                          </td>
                      </tr>


                     <%	LocalidadDAO localidadDefault = provinciaDefault.getLocalidad(domicilio.getID_LOCALIDAD());%>

                      <tr>
                        <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Localidad: </td>
                        <td height="28" colspan="2"><div align="left">
                            <select name="ID_LOCALIDAD" onchange="activarOtraLocalidad()" onfocus="activarOtraLocalidad()"  class="empleomenu2">
								<script type="text/javascript">
									if(paises[INDEX_PAIS].comboDependiente.length > 0) {
										for(i = 0; i < paises[INDEX_PAIS].comboDependiente[INDEX_PROVINCIA].comboDependiente.length; i++) {
											var selected;
				        					selected = (paises[INDEX_PAIS].comboDependiente[INDEX_PROVINCIA].comboDependiente[i].id == <%= localidadDefault.getId() %>) ? " selected " : "";

											document.write('<option value="' + paises[INDEX_PAIS].comboDependiente[INDEX_PROVINCIA].comboDependiente[i].id + '"' + selected + '>');
											document.write(paises[INDEX_PAIS].comboDependiente[INDEX_PROVINCIA].comboDependiente[i].descripcion);
											document.write('</option>');
										}
									}
								</script>
							</select>

                        </div></td>
                      </tr>
                      <tr>
                      	  <td>&nbsp;</td>
	                      <td class="Ftexto02">&nbsp;&nbsp;&nbsp;Otra
                            <input name="LOCALIDAD_EXTERNA" value="<%=Convert.toString(domicilio.getDESCRIPCION_LOCALIDAD_INEX())%>" size="20" maxlength="20" type="text" class="empleotext2" />
                          </td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> C&oacute;digo postal: </td>
                        <td colspan="2"><div align="left">
                            <input name="CP" value="<%= domicilio.getCP() %>" size="22" maxlength="20" type="text" class="empleotext" onKeyPress="cambiarFoco(event,'document.formDomicilio.ID_PAIS');" />
                        </div></td>
                      </tr>

                      <tr>
                        <td>&nbsp;</td>
                        <td colspan="2"><div align="right"><a href="javascript:validarForm();"><img src="/imagenes/miCuenta/b-modificardomicilio.gif" alt="Modificar domicilio" width="142" height="10" border="0" class="benviar2" /></a></div></td>
                      </tr>

                    </table>
                    </td>
                  </form>
                  </tr>

