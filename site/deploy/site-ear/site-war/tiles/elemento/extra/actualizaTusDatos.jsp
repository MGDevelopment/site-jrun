<%@ page import="com.tmk.kernel.Globals,
 				 com.tmk.kernel.TipoDeDocumentoDAO,
				 com.tmk.kernel.PaisDAO,
				 com.tmk.controllers.fidelizacion.ActualizacionEMailManager"%>

<script janguaje="javascript">
	function validarForm(frm) {
		frm.<%=ActualizacionEMailManager.CAMPO_NRO_DOC%>.nombre = "Identificación personal";
		frm.<%=ActualizacionEMailManager.CAMPO_EMAIL%>.nombre = "Nueva dirección de e-mail";
		frm.<%=ActualizacionEMailManager.CAMPO_PASSWORD%>.nombre = "Contraseña";
		frm.<%=ActualizacionEMailManager.CAMPO_CONPASSWORD%>.nombre = "Confirmar contraseña";
		frm.<%=ActualizacionEMailManager.CAMPO_CALLE%>.nombre = "Calle";
		frm.<%=ActualizacionEMailManager.CAMPO_CP%>.nombre = "CP";
		frm.<%=ActualizacionEMailManager.CAMPO_COD_AREA%>.nombre = "Código de área";
		frm.<%=ActualizacionEMailManager.CAMPO_NRO_TEL%>.nombre = "Número";
		frm.<%=ActualizacionEMailManager.CAMPO_EXT_INT%>.nombre = "Interno";
		frm.<%=ActualizacionEMailManager.CAMPO_EMAIL%>.email = true;

		if (frm.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>.options[frm.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>.selectedIndex].value == 99999 &&
			frm.<%=ActualizacionEMailManager.CAMPO_TIPO_DOMICILIO%>.value != '') {
			frm.<%=ActualizacionEMailManager.CAMPO_STR_PROVINCIA_DIR%>.optional = false;
		} else {
			frm.<%=ActualizacionEMailManager.CAMPO_STR_PROVINCIA_DIR%>.optional = true;
		}

		if (frm.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>.options[frm.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>.selectedIndex].value == 99999 &&
			frm.<%=ActualizacionEMailManager.CAMPO_TIPO_DOMICILIO%>.value != '') {
			frm.<%=ActualizacionEMailManager.CAMPO_STR_LOCALIDAD_DIR%>.optional = false;
		} else {
			frm.<%=ActualizacionEMailManager.CAMPO_STR_LOCALIDAD_DIR%>.optional = true;
		}
		//return verify(frm);
		return validar(frm);
	}
	function validar(frm) {
		var msg = "";

		if(isBlank(frm.nroDoc)) {
			msg += "-Identificacion personal\n";
		}
		
		if(isblank(frm.eMail) || !isMail(frm.eMail.value)) {
			msg += "-E-mail\n";
		}

		if(isBlank(frm.password)) {
			msg += "-Contraseña vacía\n";
		}
		if(isBlank(frm.conPassword)) {
			msg += "-Verificacion de Contraseña vacía\n";
		}
		if((!isBlank(frm.password) && !isBlank(frm.conPassword)) && (frm.password.value != frm.conPassword.value) ) {
			msg += "-Contraseñas distintas\n";
		}
		
		if(frm.actDomicilio.checked) {
			if(isBlank(frm.calle)) {
				msg += "-Calle\n";
			}
			if(isBlank(frm.cp)) {
				msg += "-CP\n";
			}
		}
		if(frm.actTelefono.checked) {
			if(isBlank(frm.nroTelefono)) {
				msg += "-Número de telefono\n";
			}
			if(isBlank(frm.codArea)) {
				msg += "-Código de area\n";
			}
		}		

		if(msg != "") {
			var aux = "Por favor verifique los siguientes campos!\n" + msg; 			
			alert(aux);
			return false;
		}else {
			return true;
		}			
	}
		
	function isMail(value) {
		return (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value));
	}
	
	function isBlank (o)
	{
		if (o == null) return true;

		var s;
		s = o.value;

		if ((s == null) || (s == ""))
			return true;

		for (var i=0;i<s.length;i++) {
			var c = s.charAt(i);
			if (o.type == "select")
			{
				if (o.options[o.selectedIndex].value == "") return false;
			} else {
				if ((c != ' ') && (c != '\n') && (c != '\t')) return false;
			}
		}
		return true;
	}

	function cheqDomicilio(frm) {
		frm.<%=ActualizacionEMailManager.CAMPO_TIPO_DOMICILIO%>.optional = true;
		frm.<%=ActualizacionEMailManager.CAMPO_NUMERO%>.optional = true;
		frm.<%=ActualizacionEMailManager.CAMPO_EDIFICIO%>.optional = true;
		frm.<%=ActualizacionEMailManager.CAMPO_PISO%>.optional = true;
		frm.<%=ActualizacionEMailManager.CAMPO_DEPTO%>.optional = true;
		frm.<%=ActualizacionEMailManager.CAMPO_CP%>.optional = true;

		frm.<%=ActualizacionEMailManager.CAMPO_NUMERO%>.numeric = true;
		frm.<%=ActualizacionEMailManager.CAMPO_PISO%>.numeric = true;

		if (frm.actDomicilio.checked) {
			frm.<%=ActualizacionEMailManager.CAMPO_CALLE%>.optional = false;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>.optional = false;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>.optional = false;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_PAIS_DIR%>.optional = false;
			frm.<%=ActualizacionEMailManager.CAMPO_STR_LOCALIDAD_DIR%>.optional = false;
			frm.<%=ActualizacionEMailManager.CAMPO_STR_PROVINCIA_DIR%>.optional = false;
			frm.<%=ActualizacionEMailManager.CAMPO_CP%>.optional = false;
			frm.<%=ActualizacionEMailManager.CAMPO_CALLE%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_PAIS_DIR%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_STR_LOCALIDAD_DIR%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_STR_PROVINCIA_DIR%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_CP%>.disabled = false;

			frm.<%=ActualizacionEMailManager.CAMPO_NUMERO%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_EDIFICIO%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_PISO%>.disabled = false;
			frm.<%=ActualizacionEMailManager.CAMPO_DEPTO%>.disabled = false;

			frm.<%=ActualizacionEMailManager.CAMPO_TIPO_DOMICILIO%>.value='ENVI';

			document.getElementById('lblCalle').className = 'arial12';
			document.getElementById('lblNumero').className = 'arial12';
			document.getElementById('lblEdificio').className = 'arial12';
			document.getElementById('lblPiso').className = 'arial12';
			document.getElementById('lblDpto').className = 'arial12';
			document.getElementById('lblCP').className = 'arial12';
			document.getElementById('lblPais').className = 'arial12';
			document.getElementById('lblProvincia').className = 'arial12';
			document.getElementById('lblLocalidad').className = 'arial12';
		} else {
			frm.<%=ActualizacionEMailManager.CAMPO_CALLE%>.optional = true;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>.optional = true;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>.optional = true;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_PAIS_DIR%>.optional = true;
			frm.<%=ActualizacionEMailManager.CAMPO_STR_LOCALIDAD_DIR%>.optional = true;
			frm.<%=ActualizacionEMailManager.CAMPO_STR_PROVINCIA_DIR%>.optional = true;
			frm.<%=ActualizacionEMailManager.CAMPO_CALLE%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_ID_PAIS_DIR%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_STR_LOCALIDAD_DIR%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_STR_PROVINCIA_DIR%>.disabled = true;

			frm.<%=ActualizacionEMailManager.CAMPO_NUMERO%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_EDIFICIO%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_PISO%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_DEPTO%>.disabled = true;
			frm.<%=ActualizacionEMailManager.CAMPO_CP%>.disabled = true;

			frm.<%=ActualizacionEMailManager.CAMPO_TIPO_DOMICILIO%>.value='';

			document.getElementById('lblCalle').className = 'arial12Disabled';
			document.getElementById('lblNumero').className = 'arial12Disabled';
			document.getElementById('lblEdificio').className = 'arial12Disabled';
			document.getElementById('lblPiso').className = 'arial12Disabled';
			document.getElementById('lblDpto').className = 'arial12Disabled';
			document.getElementById('lblCP').className = 'arial12Disabled';
			document.getElementById('lblPais').className = 'arial12Disabled';
			document.getElementById('lblProvincia').className = 'arial12Disabled';
			document.getElementById('lblLocalidad').className = 'arial12Disabled';
		}
	}

	function cheqTelefono(frm) {
		frm.<%=ActualizacionEMailManager.CAMPO_TIPO_TELEFONO%>.optional = true;
		frm.<%=ActualizacionEMailManager.CAMPO_EXT_INT%>.optional = true;
		//if (frm.<%=ActualizacionEMailManager.CAMPO_TIPO_TELEFONO%>.value == '') {
		if (frm.actTelefono.checked) {
				frm.<%=ActualizacionEMailManager.CAMPO_COD_AREA%>.optional = false;
				frm.<%=ActualizacionEMailManager.CAMPO_NRO_TEL%>.optional = false;
				frm.<%=ActualizacionEMailManager.CAMPO_COD_AREA%>.disabled = false;
				frm.<%=ActualizacionEMailManager.CAMPO_NRO_TEL%>.disabled = false;
				frm.<%=ActualizacionEMailManager.CAMPO_EXT_INT%>.disabled = false;
				frm.<%=ActualizacionEMailManager.CAMPO_TIPO_TELEFONO%>.value = 'ENVI';
				document.getElementById('lblCodArea').className = 'arial12';
				document.getElementById('lblNumeroTel').className = 'arial12';
				document.getElementById('lblInterno').className = 'arial12';
		} else {
				frm.<%=ActualizacionEMailManager.CAMPO_COD_AREA%>.optional = true;
				frm.<%=ActualizacionEMailManager.CAMPO_NRO_TEL%>.optional = true;
				frm.<%=ActualizacionEMailManager.CAMPO_COD_AREA%>.disabled = true;
				frm.<%=ActualizacionEMailManager.CAMPO_NRO_TEL%>.disabled = true;
				frm.<%=ActualizacionEMailManager.CAMPO_EXT_INT%>.disabled = true;
				frm.<%=ActualizacionEMailManager.CAMPO_TIPO_TELEFONO%>.value = '';
				document.getElementById('lblCodArea').className = 'arial12Disabled';
				document.getElementById('lblNumeroTel').className = 'arial12Disabled';
				document.getElementById('lblInterno').className = 'arial12Disabled';

		}
	}
</script>

<jsp:include page="/js/Combos.jsp" />
<!-- <script type="text/javascript" src="/js/Validation.js">-->

<div id="seccionTematika">
	<div style="width:830px;  margin:auto; margin-top:80px;">
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td>
    	<br>
    </td>
  </tr>
  <tr>
    <td>
       <!-- Menu -->
   	   <% String pageMenu = "/tiles/elemento/extra/menu.jsp?mnuActivo=8";%>
	   <jsp:include page="<%=pageMenu%>"/>
       <!-- Menu -->
     </td>
    </tr>
    <tr>
    	<td>
        <table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="40" class="punteonargris"><img src="/imagenes/fidelizacion/titulo_10.gif" width="222" height="26"></td>
                    </tr>
                    <tr>
                      <td class="punteonargris"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="celeste">
                          <tr>
                            <td><strong>Por completar los datos recibir&aacute;s
                              <span class="extranaranja">200 puntos eXtra!</span>
                              que se acumular&aacute;n autom&aacute;ticamente
                              en tu casilla s&oacute;lo luego de la primera actualizaci&oacute;n.</strong></td>
                          </tr>
                        </table></td>
                    </tr>
                    <%if (session.getAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR) != null) {%>
                    <tr>
                    	<td class="punteonargris">
                    		<table bgcolor="#FFFFDF;" width="100%" align="center" style="border-bottom: 3px solid #FF0000; border-top: 3px solid #FF0000;" cellpadding="4">
								<tr valign="middle">
									<td>
										<table align="center" cellpading="0" cellspacing="0">
											<tr>
												<td width="35"><img src="/imagenes/miCuenta/baliza.gif"></td>
												<td><div class="FTtit01"><%=session.getAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR)%></div></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
                    	</td>
                    </tr>
                    <%
                    		session.removeAttribute(ActualizacionEMailManager.SESSION_MSG_ERROR);
                      }%>
                    <tr>
                      <td class="punteonargris"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="2" bgcolor="#CDCDCD"></td>
                          </tr>
                          <tr>
                            <td bgcolor="#F7F8FA">
                            <form name="frmDatosActMail"  method="post" action="<%=ActualizacionEMailManager.CONTROLADOR_INICIO%>" onsubmit="return validarForm(this)">
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
                                  <tr>
                                    <td height="1"></td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="10" class="Ftexto02"><font color="#FF0000">*</font></td>
                                          <td width="200" class="arial12">Identificaci&oacute;n
                                            Personal:</td>
                                          <td width="100"><select name="<%=ActualizacionEMailManager.CAMPO_TIPO_DOC%>" class="arial12">
                                              			  <%
														  	for (int td = 0; td < Globals.TIPOS_DOCUMENTO.length; td++) {
																TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[td];
														  %>
																<option value="<%= tipoDeDocumentoDAO.getId() %>" <%=(tipoDeDocumentoDAO.getId().equals(Globals.TIPO_DOCUMENTO_DNI.getId())) ? " selected" : ""%>><%= tipoDeDocumentoDAO.getNombre() %></option>
														  <%
														  	}
														  %>
                                            </select></td>
                                          <td><input  type="text" class="arial12" size="10" name="<%=ActualizacionEMailManager.CAMPO_NRO_DOC%>" maxlength="15" nombre="identificación"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="10" class="Ftexto02"><font color="#FF0000">*</font></td>
                                          <td width="200" class="arial12">Nacionalidad:</td>
                                          <td><SELECT class=arial12 name="<%=ActualizacionEMailManager.CAMPO_ID_PAIS%>" nombre="nacionalidad">
                                              		<%
														for (int p = 0; p < Globals.PAISES.length; p++) {
															PaisDAO paisDAO = Globals.PAISES[p];
													%>
															<option value="<%= paisDAO.getId() %>" <%=(paisDAO.getId()==Globals.ARGENTINA.getId()) ? " selected" : ""%>><%= paisDAO.getNombre() %></option>
													<%
														}
													%>
                                            </SELECT></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="10" class="Ftexto02"><font color="#FF0000">*</font></td>
                                          <td width="200" class="arial12">Sexo:</td>
                                          <td><select name="<%=ActualizacionEMailManager.CAMPO_SEXO %>" class="arial12">
                                              <option selected value="M">M</option>
                                              <option value="F">F</option>
                                            </select> </td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="10" class="Ftexto02"><font color="#FF0000">*</font></td>
                                          <td width="200" class="arial12">Nueva
                                            direcci&oacute;n de e-mail:</td>
                                          <td><input type="text" class="arial12" maxlength="100" name="<%=ActualizacionEMailManager.CAMPO_EMAIL%>" size="23" nombre="e-mail"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="10" class="Ftexto02"><font color="#FF0000">*</font></td>
                                          <td width="200" class="arial12">Contrase&ntilde;a:</td>
                                          <td><input type="password" class="arial12" size="23" name="<%=ActualizacionEMailManager.CAMPO_PASSWORD%>" maxlength="40" nombre="contraseña"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="10" class="Ftexto02"><font color="#FF0000">*</font></td>
                                          <td width="200" class="arial12">Confirmar
                                            contrase&ntilde;a:</td>
                                          <td><input type="password" class="arial12" size="23"  name="<%=ActualizacionEMailManager.CAMPO_CONPASSWORD%>" maxlength="40" nombre="confirmacion de contraseña"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td height="20" background="/imagenes/fidelizacion/punteado.gif">&nbsp;</td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                        	<td colspan="5" class="arial12">
	                                        	<input type="hidden" name="<%=ActualizacionEMailManager.CAMPO_TIPO_DOMICILIO%>" value="">
	                                        	<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
				                                        	<input name="actDomicilio" type="checkbox" onclick="cheqDomicilio(document.frmDatosActMail);">
	                                        			</td>
														<td  class="arial12">
							                            	Actualizar Domicilio
														</td>
													</tr>
												</table>
                                        	</td>
                                        </tr>
                                        <tr>
                                        	<td colspan="5">
                                        		<br>
                                        	</td>
                                        </tr>
                                        <tr>
                                          <td width="10" class="Ftexto02">&nbsp;</td>
                                          <td width="100" class="arial12" id="lblCalle">Calle:</td>
                                          <td width="165"><input type="text" class="arial12" size="23" name="<%=ActualizacionEMailManager.CAMPO_CALLE%>" maxlength="100" nombre="calle"></td>
                                          <td width="60" class="arial12" id="lblNumero">N&uacute;mero:</td>
                                          <td><input type="text" class="arial12" size="23" name="<%=ActualizacionEMailManager.CAMPO_NUMERO%>" maxlength="10" nombre="numero"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="10" class="Ftexto02">&nbsp;</td>
                                          <td width="100" class="arial12" id="lblEdificio">Edificio:</td>
                                          <td width="165"><input type="text" class="arial12" size="23" name="<%=ActualizacionEMailManager.CAMPO_EDIFICIO%>" maxlength="4" nombre="edificio"></td>
                                          <td width="60" class="arial12" id="lblPiso">Piso:</td>
                                          <td width="65"><input type="text" class="arial12" size="3" name="<%=ActualizacionEMailManager.CAMPO_PISO%>" maxlength="4" nombre="piso"></td>
                                          <td width="35" class="arial12" id="lblDpto">Dpto:</td>
                                          <td><input type="text" class="arial12" size="3" name="<%=ActualizacionEMailManager.CAMPO_DEPTO%>" maxlength="4" nombre="departamento"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                  		<td>
                                    		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        		<tr>
                                          			<td width="10" class="Ftexto02">&nbsp;</td>
                                          			<td width="100" class="arial12" id="lblCP">CP:</td>
                                          			<td width="165"><input type="text" class="arial12" size="23" name="<%=ActualizacionEMailManager.CAMPO_CP%>" maxlength="20" nombre="codigo postal"></td>
                                          			<td colspan="2"></td>
										 		</tr>
                                      		</table>
                                    	</td>
                                  </tr>
                                  <tr>
                                  		<td>
                                    		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        		<tr>
                                          			<td width="10" class="Ftexto02">&nbsp;</td>
                                          			<td width="100" class="arial12" id="lblPais">Pa&iacute;s:</td>
                                          			<td width="165">
                                          				<select class="arial12" name="<%=ActualizacionEMailManager.CAMPO_ID_PAIS_DIR%>" onChange="javascript:INDEX_PAIS = actualizarCombo(this, document.frmDatosActMail.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>, paises);INDEX_PROVINCIA = actualizarCombo(frmDatosActMail.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>, document.frmDatosActMail.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>, paises[INDEX_PAIS].comboDependiente);" onKeyPress="cambiarFoco(event,'document.frmDatosActMail.<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>');" nombre="pais">
			                                                <script type="text/javascript">
																for(i = 0; i < paises.length; i++) {
																	var selected;
																	if (paises[i].id == <%= Globals.ARGENTINA.getId() %>) {
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
                    			                    </td>
                                          			<td colspan="2"></td>
										 		</tr>
                                      		</table>
                                    	</td>
                                  </tr>
                                  <tr>
                                    	<td>
                                    		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		                                        <tr>
	        		                                  <td width="10" class="Ftexto02">&nbsp;</td>
	                		                          <td width="100" class="arial12" id="lblProvincia">Provincia:</td>
	                        		                  <td width="165">
	    	                                      	  <select class="arial12" name="<%=ActualizacionEMailManager.CAMPO_ID_PROVINCIA_DIR%>" class="formextra" onfocus="" onChange="javascript:INDEX_PROVINCIA = actualizarCombo(this, document.frmDatosActMail.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>, paises[INDEX_PAIS].comboDependiente);" onKeyPress="cambiarFoco(event,'document.frmDatosActMail.<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>');" nombre="provincia">
		    	                                      	<script type="text/javascript">
	 												  	    for(i = 0; i < paises[INDEX_PAIS].comboDependiente.length; i++) {
 													  				document.write('<option value="' + paises[INDEX_PAIS].comboDependiente[i].id + '"' + '>');
																	document.write(paises[INDEX_PAIS].comboDependiente[i].descripcion);
																	document.write('</option>');
																}
													    </script>
												  	  </select>
	    	                                      <input type="text" class="arial12" size="23" name="<%=ActualizacionEMailManager.CAMPO_STR_PROVINCIA_DIR%>" type="text" maxlenght="50" class="formextra" nombre="otra provincia">
		    	                               </td>
		    	                               <td colspan="2"></td>
        	                                 </tr>
                                         </table>
                                     </td>
                                    </tr>
                                    <tr>
                                    	<td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        	<tr>
                                       		    <td width="10" class="Ftexto02">&nbsp;</td>
                                          		<td width="100" class="arial12" id="lblLocalidad">Localidad:</td>
                                          		<td width="165">
                                          			<select class="arial12" name="<%=ActualizacionEMailManager.CAMPO_ID_LOCALIDAD_DIR%>" onchange="" onfocus="" class="formextra" nombre="localidad">
                                          				<script type="text/javascript">
															for(i = 0; i < paises[INDEX_PAIS].comboDependiente[0].comboDependiente.length; i++)	{
																document.write('<option value="' + paises[INDEX_PAIS].comboDependiente[0].comboDependiente[i].id + '"' + '>');
																document.write(paises[INDEX_PAIS].comboDependiente[0].comboDependiente[i].descripcion);
																document.write('</option>');
															}
														</script>
													</select>
                                          		<input type="text" class="arial12" size="23" name="<%=ActualizacionEMailManager.CAMPO_STR_LOCALIDAD_DIR %>" type="text"  maxlenght="50" class="formextra" nombre="otra localidad">
                                          	</td>
                                          	<td colspan="2"></td>
                                        </tr>
                                      </table>
                                    </td>
                                  </tr>
                                  <tr>
                                    <td height="20" background="/imagenes/fidelizacion/punteado.gif">&nbsp;</td>
                                  </tr>
                                  <tr>
                                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                        	<td colspan="6">
                                        		<input type="hidden" name="<%=ActualizacionEMailManager.CAMPO_TIPO_TELEFONO%>" value=""/>
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<input name="actTelefono" type="checkbox" onclick="cheqTelefono(document.frmDatosActMail);">
														</td>
														<td class="arial12">
															Actualizar Tel&eacute;fono
														</td>
													</tr>
												</table>
                                        	</td>
                                        </tr>
                                        <tr>
                                        	<td colspan="6">
                                        		<br>
                                        	</td>
                                        </tr>
                                        <tr>
                                          <td width="10" class="Ftexto02">&nbsp;</td>
                                          <td width="100" class="arial12" id="lblCodArea">C&oacute;digo
                                            de &Aacute;rea:</td>
                                          <td width="75"><input type="text" class="arial12" size="5" name="<%=ActualizacionEMailManager.CAMPO_COD_AREA%>" maxlength="10" nombre="codigo de area"></td>
                                          <td width="60" class="arial12" id="lblNumeroTel">N&uacute;mero:</td>
                                          <td width="165"><input type="text" class="arial12" size="23" name="<%=ActualizacionEMailManager.CAMPO_NRO_TEL%>" maxlength="15" nombre="numero"></td>
                                          <td width="50" class="arial12" id="lblInterno">Interno:</td>
                                          <td><input type="text" class="arial12" size="5" name="<%=ActualizacionEMailManager.CAMPO_EXT_INT%>" maxlength="10" nombre="interno"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td height="30" align="center" valign="bottom"><input type="image" src="/imagenes/fidelizacion/b-enviar.gif" width="47" height="9" border="0"></td>
                                  </tr>
                                </table>
                              </form></td>
                          </tr>
                          <tr>
                            <td height="2" bgcolor="#CDCDCD"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr>
                      <td class="punteonargris"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                         <tr>
                         	<td class="Ftexto02">
							 	<hr>
						 			Disposición (Dirección Nacional de Protección de Datos Personales) 10/2008
							 		<p>
									<p>
									"El titular de los datos personales tiene la facultad de ejercer el derecho de acceso a los mismos en forma gratuita a intervalos no inferiores a seis meses, salvo que se acredite un interés legítimo al efecto conforme lo establecido en el artículo 14, inciso 3 de la Ley Nº 25.326"
									<p>
									"La DIRECCION NACIONAL DE PROTECCION DE DATOS PERSONALES, órgano de control de la Ley Nº 25.326, tiene la atribución de atender las denuncias y reclamos que se interpongan con relación al incumplimiento de las normas sobre protección de datos personales".<p>
								<hr>
						 	</td>
                         </tr>
                      </table>
                     </td>
                    </tr>

                          <tr>
                            <td class="Ftexto02"><font color="#FF0000" face="Arial, Helvetica, sans-serif">*</font>
                              <span class="txtgris14">Datos requeridos para la
                              actualizaci&oacute;n</span></td>
                            <td><p>&nbsp;</p></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
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
</div>
</div>

<script languaje="javascript">
	/*	este script desabilita los checkbox de los formularios actualizar domicilio y actualizar telefono */
	cheqDomicilio(document.frmDatosActMail);
	cheqTelefono(document.frmDatosActMail);
</script>