<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.*,
                 java.sql.Timestamp,
                 com.tmk.fidelizacion.*,
                 com.tmk.controllers.MainHelper" %>

<script type="text/javascript">

var divLoading = '<img style=\"padding-left:20%;width:30px;height:30px;\" src=\"/imagenes/rediseno/imagenes/comun/loading.gif\">';
	function registrarSocioEXtra() {
		for (i=0; i<document.frmRegistro.elements.length; i++) {
			document.frmRegistro.elements[i].style.backgroundColor = "#ffffff";
		}
		if (document.frmRegistro.tipoDoc) {
			$('#sexo').get(0).style.backgroundColor = "#FFFFFF";

			var valorSexo = '';
			if (document.frmRegistro.sexo[0].checked) {
				valorSexo = document.frmRegistro.sexo[0].value;
			}
			if (document.frmRegistro.sexo[1].checked) {
				valorSexo = document.frmRegistro.sexo[1].value;
			}
		}
	    var paramsDatAD = '';
	    if (document.frmRegistro.tipoDoc) {
	    	paramsDatAD = '&tipoDoc=' + document.frmRegistro.tipoDoc.options[document.frmRegistro.tipoDoc.selectedIndex].value
				+ '&nroDoc=' + document.frmRegistro.nroDoc.value
				+ '&nacionalidad=' + document.frmRegistro.nacionalidad.options[document.frmRegistro.nacionalidad.selectedIndex].value
				+ '&sexo=' + valorSexo
				+ '&fechaNacDD=' + document.frmRegistro.fechaNacDD.value
				+ '&fechaNacMM=' + document.frmRegistro.fechaNacMM.value
				+ '&fechaNacAAAA=' + document.frmRegistro.fechaNacAAAA.value
				+ '&estadoCivil=' + document.frmRegistro.estadoCivil.value
				+ '&hijos=' + document.frmRegistro.hijos.value
				+ '&profesion=' + document.frmRegistro.profesion.options[document.frmRegistro.profesion.selectedIndex].value;
	    }

	    var params = 'aceptoEXtra=' + document.frmRegistro.aceptoEXtra.checked
			+ '&infoEXtra=' + document.frmRegistro.infoEXtra.checked
			+ '&datosComplementarios=' + document.frmRegistro.datosComplementarios.checked
			+ paramsDatAD
			+ '&idEstudio=' + document.frmRegistro.idEstudio.options[document.frmRegistro.idEstudio.selectedIndex].value
			+ '&idOcupacion=' + document.frmRegistro.idOcupacion.options[document.frmRegistro.idOcupacion.selectedIndex].value
			+ '&idIdioma=' + document.frmRegistro.idIdioma.options[document.frmRegistro.idIdioma.selectedIndex].value
			+ '&idRamo=' + document.frmRegistro.idRamo.options[document.frmRegistro.idRamo.selectedIndex].value
			+ '&idSistemasTV=' + document.frmRegistro.idSistemasTV.options[document.frmRegistro.idSistemasTV.selectedIndex].value
			+ '&idTarjetas=' + document.frmRegistro.idTarjetas.options[document.frmRegistro.idTarjetas.selectedIndex].value
			+ '&idCompra=' + document.frmRegistro.idCompra.options[document.frmRegistro.idCompra.selectedIndex].value
			+ '&idTarjetaPuntaje=' + document.frmRegistro.idTarjetaPuntaje.options[document.frmRegistro.idTarjetaPuntaje.selectedIndex].value
			+ '&idCelular='  + document.frmRegistro.idCelular.options[document.frmRegistro.idCelular.selectedIndex].value
			+ '&tieneVehiculo=' + document.frmRegistro.tieneVehiculo.options[document.frmRegistro.tieneVehiculo.selectedIndex].value
			+ '&marcaVehiculo=' + document.frmRegistro.marcaVehiculo.options[document.frmRegistro.marcaVehiculo.selectedIndex].value
			+ '&modeloVehiculo=' + document.frmRegistro.modeloVehiculo.options[document.frmRegistro.modeloVehiculo.selectedIndex].value
			+ '&anoVehiculo=' + document.frmRegistro.anoVehiculo.value
			+ '&idTipoCombustible=' + document.frmRegistro.idTipoCombustible.options[document.frmRegistro.idTipoCombustible.selectedIndex].value
			+ '&idPCHogar=' + document.frmRegistro.idPCHogar.checked
			+ '&idInternetHogar=' + document.frmRegistro.idInternetHogar.checked;

	    $.ajax({
			url:"/RegistrarSocioEXtra",
			data:params,
			dataType:"json",
			contentType:"application/x-www-form-urlencoded",
			type:"POST",
			beforeSend:function(obj) {				
				$('#divMensajeRetorno').html("");
				$('#divMensajeRetorno').html(divLoading);
				mostrarDiv('modalDomDatosPersonales');
				mostrarDiv('modalBack');
			},
			success:function(obj){
 			
				if (obj.Resultado.valor) {
					$('#formRegistracion').get(0).style.display = "none";
					$('#msgRegistracionExitosa').get(0).innerHTML =  obj.Resultado.mensaje[0];
					$('#registracionExitosa').get(0).style.display = "";
					$('#hrefRegistracionExitosa').get(0).focus();
					$('#mensajeError').get(0).style.display = "none";										
				} else {
					if(obj.Resultado.targetRedirect!=null) {
						document.location.href= obj.Resultado.targetRedirect;
					}
					if (obj.Resultado.mensaje != null) {
						$('#mensajeError').get(0).innerHTML = "";
						for(i=0; i<obj.Resultado.mensaje.length; i++) {
							$('#mensajeError').get(0).innerHTML = $('#mensajeError').get(0).innerHTML +
							obj.Resultado.mensaje[i] + '<br>';
						}
						$('#mensajeError').get(0).style.display = "";
					}
					if (obj.Resultado.campo != null) {
						if (obj.Resultado.campo[0] == 'sexo') {
							var campo = eval ('document.frmRegistro.' + obj.Resultado.campo[0] + "[0]");
						} else {
							var campo = eval ('document.frmRegistro.' + obj.Resultado.campo[0]);
						}
						//campo.focus();
						$('#txtBuscar').get(0).focus();
						for(i=0; i<obj.Resultado.campo.length; i++) {
							if (obj.Resultado.campo[i] == 'sexo') {
								$('#sexo').get(0).style.backgroundColor = "#FF6666";
							} else {
								var campo = eval ('document.frmRegistro.' + obj.Resultado.campo[i]);
								campo.style.backgroundColor = "#FF6666";
							}
						}
					}
					//$('#registroExtraFin').get(0).style.display = "";
				}
				$('#txtBuscar').get(0).focus();
				mostrarDiv('modalBack');
				mostrarDiv('modalDomDatosPersonales');
			}
		});
		return false;
	}//fin funcion

	function reloadLoginPage(puntos) {
		$('#linkExtraAsociar').get(0).innerHTML = "Consultar mis Puntos";
		$('#linkExtraAsociar').get(0).href = '/fidelizacion/panel/puntos.jsp';
	}

</script>

<%

  SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
  boolean esSocioTMK = Convert.toBoolean((Boolean)session.getAttribute("socioTMK"), false);
  String redirect = Convert.toString((String)session.getAttribute(MainHelper.URL_REDIRECT), "/");
%>
<div style="margin-top: 10px;">	
	<div class="compraWrapper2"><!--  style="background-color: #FBF5EF">-->
		<table width="650" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
          <%--
            <td class="Gbarraizquierda" width="139">
	            <table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
				 	<tr>
						<td valign="top">

							<table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
		            			<tr>
									  <td align="left" class="preguntasceldas">
									  	<a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a>
									  </td>
				                </tr>
				    	    </table>

				    	</td>
		  			</tr>
	            	<jsp:include page="/miCuenta/left.jsp"/>
    	        </table>
            </td>
            --%>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                 <table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>
                  <tr>
                  <td class="moduloAyuda" bgcolor="#F3F4F5" style="padding:10px">
                  	<div id="formRegistracion">
                  	<table width="366" border="0" cellspacing="0" cellpadding="0">
  					<form name="frmRegistro" onSubmit="return false">
                        <tr>
                        	<td valign="top" class="Ftexto02">
                          		<table width="366" border="0" cellpadding="0" cellspacing="0">
                        			<tr>
                              			<td height="25" valign="top" class="Ftexto02"><strong class="FTtit01">Solicitud de adhesi&oacute;n al programa eXtra! </strong></td>
                            		</tr>
                            		 <tr>
	                        			<td>
		    	                    		<div id="mensajeError" class="cuadroError" style="display:none;">
		    	                    		</div>
		            	            	</td>
		                        	</tr>
                            		<tr>
                              			<td valign="middle">
											<table width="366" border="0" cellspacing="0" cellpadding="0">
			        	                        <tr>
                        				            <td width="24"><span class="Ftexto02">
			                	                      <input name="aceptoEXtra" type="checkbox"  checked="checked" tabindex="1" onKeyPress="enviarDatos(event);"/>
                        					            </span></td>
			                    	                <td width="342" class="Ftexto02">Acepto adherirme al programa eXtra!</td>
                        				        </tr>
		                                	</table>
										</td>
                	            	</tr>
                        	    	<tr>
                            	  		<td height="25" valign="middle">
											<table width="366" border="0" cellspacing="0" cellpadding="0">
                    	              			<tr>
				        	                        <td width="24"><span class="Ftexto02">
                                				      <input type="checkbox" name="infoEXtra" value="checkbox" tabindex="2" onKeyPress="enviarDatos(event);"/>
				                                    </span>
													</td>
				                                	<td width="342" class="Ftexto02">No deseo recibir informaci&oacute;n por email relacionada al programa eXtra!</td>
                                				</tr>
		                              		</table>
										</td>
                    	        	</tr>
                        	    	<tr>
                            	  		<td valign="middle">
											<table width="366" border="0" cellspacing="0" cellpadding="0">
                    	            			<tr>
			            	                        <td width="24"><span class="Ftexto02">
                        				              <input name="datosComplementarios" type="checkbox" value="checkbox" checked="checked" onclick="return habilitaDatosComplementarios(this);" tabindex="3" onKeyPress="enviarDatos(event);"/>
			                    	                </span>
												    </td>
			        	                            <td width="342" class="Ftexto02">Si completas el formulario de Datos Complementarios te llevas 50 puntos m&aacute;s.</td>
                        				       </tr>
		                    	            </table>
										</td>
                    	        	</tr>
                               </table>
                          <table width="366" border="0" cellpadding="0" cellspacing="0">
                          <% if (esSocioTMK) {%>
                            <tr>
                              <td height="35" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">Datos adicionales:</span></td>
                            </tr>
                             <tr>
                          		<td colspan="3" valign="bottom" class="FTtit01">&nbsp;</td>
                        	</tr>

                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Documento de identidad:</td>
                              <td colspan="2"><table width="224" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td>
                                        <select name="tipoDoc" class="tipoDoc" tabindex="4" onKeyPress="enviarDatos(event);">
                                        	<option value="">selecciona</option>
                                        <%
											for (int i = 0; i < Globals.TIPOS_DOCUMENTO.length; i++) {
												TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[i];
										%>

											<option value="<%= tipoDeDocumentoDAO.getId() %>"><%= tipoDeDocumentoDAO.getNombre() %></option>
										<%  } %>
                                        </select>

                                        <input name="nroDoc" type="text" class="nroDoc" size="8" maxlength="15" tabindex="5" onKeyPress="enviarDatos(event);"/>
                                     </td>
                                  </tr>
                              </table></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Nacionalidad: </td>
                              <td colspan="2"><div align="left">
                                  <select name="nacionalidad" class="nacionalidad" tabindex="6" onKeyPress="enviarDatos(event);">
										<option value="">selecciona</option>
                                   <%
										for (int i = 0; i < Globals.PAISES.length; i++) {
											PaisDAO paisDAO = Globals.PAISES[i];
								   %>
											<option value="<%= paisDAO.getId() %>"> <%= paisDAO.getNombre() %></option>
			 					   <%  	} %>
			 					   </select>
                              </div></td>
                            </tr>
                            <tr>
                              <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Sexo: </td>
                              <td height="28" colspan="2" valign="bottom" style="padding-left:3px; text-align:left">
                                 <table id="sexo" border ="0" cellpadding="2" cellspacing="0" class="Ftexto02" style="border:solid 1px #666;background-color:#FFF"><tr><td>
                                  <input name="sexo" type="radio" value="M" tabindex="7" onKeyPress="enviarDatos(event);"/></td><td>
                                Masculino</td><td>
                                <input name="sexo" type="radio" value="F" tabindex="8" onKeyPress="enviarDatos(event);"/></td><td>
                                Femenino</td></tr></table>
                                 </td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02">&nbsp;&nbsp;Fecha de nacimiento: </td>
                              <td colspan="2"><div align="left">
                                  <input name="fechaNacDD" type="text" class="fecNac" value="dd" size="2" maxlength="2" tabindex="9" onKeyPress="enviarDatos(event);"/>/
                                  <input name="fechaNacMM" type="text" class="fecNac" value="mm" size="2" maxlength="2" tabindex="10" onKeyPress="enviarDatos(event);"/>/
                                  <input name="fechaNacAAAA" type="text" class="fecNac" value="aaaa" size="4" maxlength="4" tabindex="11" onKeyPress="enviarDatos(event);"/>
                              </div></td>
                            </tr>
                            <tr>
                              <td height="28" valign="bottom" class="Ftexto02">&nbsp;&nbsp;Estado civil: </td>
                              <td height="28" colspan="2"><div align="left">
                                  <table width="224" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                      <td width="125"><select name="estadoCivil" class="profesion" tabindex="12" onKeyPress="enviarDatos(event);">
													   	<option value="">selecciona</option>
                                      <%
                                      		for (int i = 0; i < Globals.ESTADOS_CIVILES.length; i++) {
												EstadoCivilDAO estadoCivilDAO = Globals.ESTADOS_CIVILES[i];
									  %>
												<option value="<%= estadoCivilDAO.getId() %>"> <%= estadoCivilDAO.getNombre() %></option>
			  						  <%  } %>
                                      </select></td>
                                      <td width="27" valign="bottom"><span class="Ftexto02">Hijos:</span></td>
                                      <td width="72"><input name="hijos" type="text" class="empleotext5" maxlength="2" tabindex="13" onKeyPress="enviarDatos(event);"/></td>
                                    </tr>
                                  </table>
                              </div></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02">&nbsp;&nbsp;Profesi&oacute;n: </td>
                              <td colspan="2"><div align="left">
                                  <select name="profesion" class="profesion" tabindex="14" onKeyPress="enviarDatos(event);">
								     	<option value="">selecciona</option>
                                  <%
                                  		for (int i = 0; i < Globals.PROFESIONES.length; i++) {
											ProfesionDAO profesionDAO = Globals.PROFESIONES[i];
								  %>
											<option value="<%= profesionDAO.getId() %>"> <%= profesionDAO.getNombre() %></option>
                                  <%	}%>
                                  </select>
                              </div></td>
                            </tr>
                       <%}%>
                       <tr>
                       	<td colspan="3">
                       		&nbsp;
                       	</td>
                       </tr>
						<tr>
                          <td height="25" colspan="3" valign="bottom" class="FTtit01">Datos Complementarios                            :</td>
                        </tr>
                        <tr>
                       	<td colspan="3">
                       		&nbsp;
                       	</td>
                       </tr>
                        <tr>
                          <td width="142" valign="bottom" class="Ftexto02">Estudios: </td>
                          <td width="224" colspan="2"><div align="left">

                            <select name="idEstudio"  class="empleomenu4" tabindex="15" onKeyPress="enviarDatos(event);">
                              <%  for (int i = 0; i < Globals.ESTUDIOS.length; i++) {
											EstudioDAO temp = Globals.ESTUDIOS[i];%>
								<option value="<%= temp.getId() %>" <%=(Globals.ESTUDIO_PRIMARIO.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
  							  <%  } %>
                            </select>

                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Ocupaci&oacute;n:</td>
                          <td colspan="2"><div align="left">
                               <select name="idOcupacion"  class="empleomenu4" tabindex="16" onKeyPress="enviarDatos(event);">
	                              <%  for (int i = 0; i < Globals.OCUPACIONES.length; i++) {
												OcupacionDAO temp = Globals.OCUPACIONES[i];%>
												<option value="<%= temp.getId() %>" <%=(Globals.OCUPACION_OTRA.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
									<%  } %>
                              </select>
                          </div></td>
                        </tr>

                        <tr>
                          <td valign="bottom" class="Ftexto02">Idioma:</td>
                          <td colspan="2"><div align="left">
                               <select name="idIdioma" class="empleomenu4" tabindex="17" onKeyPress="enviarDatos(event);">
								<%  for (int i = 0; i < Globals.IDIOMAS.length; i++) {
										IdiomaDAO temp = Globals.IDIOMAS[i];
										if (temp.consultarEnFidelizacion()) {%>
										<option value="<%= temp.getId() %>" <%=(Globals.IDIOMA_INGLES.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
								<%      }
									}
								%>
                             </select>
                          </div></td>
                        </tr>

                        <tr>
                          <td valign="bottom" class="Ftexto02">Ramo/Actividad: </td>
                          <td colspan="2"><div align="left">
                              <select name="idRamo" class="empleomenu4" tabindex="18" onKeyPress="enviarDatos(event);">
                                <%  for (int i = 0; i < Globals.ACTIVIDADES_LABORALES.length; i++) {
										ActividadLaboralDAO temp = Globals.ACTIVIDADES_LABORALES[i];%>
										<option value="<%= temp.getId() %>"  <%=(Globals.ACTIVIDAD_LABORAL_OTRA.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
								<%  } %>
                              </select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Sistemas de T.V: </td>
                          <td colspan="2"><div align="left">
                              <select name="idSistemasTV" class="empleomenu4" tabindex="19" onKeyPress="enviarDatos(event);">
									<%  for (int i = 0; i < Globals.SISTEMA_TV.length; i++) {
											SistemaTVDAO temp = Globals.SISTEMA_TV[i];%>
											<option value="<%= temp.getId() %>"  <%=(Globals.SISTEMA_TV_NINGUNO.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
									<%  } %>
                             </select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Tarjetas: </td>
                          <td colspan="2"><div align="left">
                              <select name="idTarjetas" class="empleomenu4" tabindex="20" onKeyPress="enviarDatos(event);">
									<%  for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
												MedioDeCobroDAO temp = Globals.MEDIOS_DE_COBRO[i];
											if (temp.esTarjeta() && temp.consultarEnFidelizacion()) {%>
												<option value="<%= temp.getId() %>"> <%= temp.getNombre() %></option>
									<%		}
									} %>
							  </select>
                          </div></td>
                        </tr>

                        <tr>
                          <td valign="bottom" class="Ftexto02">Compra en:</td>
                          <td colspan="2"><div align="left">
                              <select name="idCompra" class="empleomenu4" tabindex="21" onKeyPress="enviarDatos(event);">
									<%  for (int i = 0; i < Globals.EMPRESAS_SIMILARES.length; i++) {
												EmpresaSimilarDAO temp = Globals.EMPRESAS_SIMILARES[i];%>
												<option value="<%= temp.getId() %>"  <%=(Globals.EMPRESA_SIMILAR_OTRA.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
									<%  } %>
							  </select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Tarjetas de Puntaje: </td>
                          <td colspan="2"><div align="left">
							  <select name="idTarjetaPuntaje" class="empleomenu4" tabindex="22" onKeyPress="enviarDatos(event);">
										<%  for (int i = 0; i < Globals.TARJETAS_DE_PUNTAJE.length; i++) {
												TarjetaDePuntajeDAO temp = Globals.TARJETAS_DE_PUNTAJE[i];%>
												<option value="<%= temp.getId() %>"  <%=(Globals.TARJETA_DE_PUNTAJE_OTRA.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
										<%  } %>
							 </select>                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Tel&eacute;fono Celular: </td>
                          <td colspan="2"><div align="left">
                              <select name="idCelular" class="empleomenu4" tabindex="23" onKeyPress="enviarDatos(event);">
										<%  for (int i = 0; i < Globals.TELEFONOS_CELULARES.length; i++) {
												TelefonoCelularDAO temp = Globals.TELEFONOS_CELULARES[i];%>
												<option value="<%= temp.getId() %>"  <%=(Globals.TELEFONO_CELULAR_OTRO.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
										<%  } %>
							  </select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Tiene Veh&iacute;culo: </td>
                          <td colspan="2"><div align="left">
                            <select name="tieneVehiculo" class="empleomenu" onchange="habilitaVehiculo(this);" tabindex="24" onKeyPress="enviarDatos(event);">
									<option value="FALSE">No</option>
									<option value="TRUE">Sí</option>
							</select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Marca: </td>
                          <td colspan="2"><div align="left">

                             <select name="marcaVehiculo" class="empleomenu4" onchange="cargarModelos(this);" tabindex="25" onKeyPress="enviarDatos(event);">
	                             <%  for (int i = 0; i <  Globals.MARCAS_DE_VEHICULOS.length; i++) {
										MarcaDeVehiculoDAO temp = Globals.MARCAS_DE_VEHICULOS[i];%>
										<option value="<%= temp.getId() %>" > <%= temp.getNombre() %></option>
								<%  } %>
                             </select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Modelo:</td>
                          <td colspan="2"><div align="left">
                              <select name="modeloVehiculo" class="empleomenu4" tabindex="26" onKeyPress="enviarDatos(event);">

                              </select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02"> A&ntilde;o: </td>
                          <td colspan="2"><div align="left">
                            &nbsp;<input name="anoVehiculo" value="" size="4" maxlength="4" type="text" class="nroDoc" tabindex="27" onKeyPress="enviarDatos(event);"/>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Marca de combustible: </td>
                          <td colspan="2"><div align="left">
                              <select name="idMarcaCombustible" class="empleomenu4" tabindex="28" onKeyPress="enviarDatos(event);">
								<%  for (int i = 0; i < Globals.MARCAS_DE_COMBUSTIBLE.length; i++) {
										MarcaDeCombustibleDAO temp = Globals.MARCAS_DE_COMBUSTIBLE[i];%>
										<option value="<%= temp.getId() %>"  <%=(Globals.MARCAS_DE_COMBUSTIBLE_DEFECTO.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
								<%  } %>
                             </select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">Tipo de combustible: </td>
                          <td colspan="2"><div align="left">
                              <select name="idTipoCombustible" class="empleomenu4" tabindex="29" onKeyPress="enviarDatos(event);">
								<%  for (int i = 0; i < Globals.TIPOS_DE_COMBUSTIBLE.length; i++) {
										TipoDeCombustibleDAO temp = Globals.TIPOS_DE_COMBUSTIBLE[i];%>
										<option value="<%= temp.getId() %>"  <%=(Globals.MARCAS_DE_COMBUSTIBLE_DEFECTO.getId().equals(temp.getId())) ? " selected " : ""%>> <%= temp.getNombre() %></option>
								<%  } %>
                              </select>
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">&nbsp;</td>
                          <td height="30" colspan="2" valign="bottom"><table width="218" border="0" align="right" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="24"><span class="Ftexto02">
                                <input name="idPCHogar" type="checkbox" value="checkbox" tabindex="30" onKeyPress="enviarDatos(event);"/>
                              </span></td>
                              <td width="342" class="Ftexto02">Tenes PC en tu hogar</td>
                            </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02">&nbsp;</td>
                          <td height="30" colspan="2" valign="bottom"><table width="218" border="0" align="right" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="24"><span class="Ftexto02">
                                <input name="idInternetHogar" type="checkbox" value="checkbox" tabindex="31" onKeyPress="enviarDatos(event);"/>
                              </span></td>
                              <td width="342" class="Ftexto02">Tenes Intenet en tu hogar </td>
                            </tr>
                          </table></td>
                        </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="80" valign="top">
                           <div id="registroExtraFin">
	                            <a onclick="registrarSocioEXtra();" style="cursor:pointer" tabindex="32"><img src="/imagenes/inicio/b-continuar.gif" alt="Empezar a sumar puntos!" border="0" /></a> </div>
	                       </div>
                           <div id="mensajeLoad" class="cuadroLoad" style="display:none;width:290px;margin-left:32px;margin-top:30px;">
		            	      		Procesando...<a id="hrefMensajeLoad" href="#"></a>
        			       </div>
                    	  </td>
                        </tr>
                        </form>
                    </table>

                  </div>
                   <div id="registracionExitosa" class="cuadroExitoExterno" style="display:none;width:370px">
                   <a id="hrefRegistracionExitosa" href="#"></a>
                   <div  class="cuadroExito">
                   		<div class="cuadroExitoTitulo" style="width:350px">
                   			Bienvenido al programa eXtra!!
                   		</div>
                   		<img src="/imagenes/iconoAvion.jpg"><br>
						<div id="msgRegistracionExitosa"></div><br>&nbsp;<br>
						<div class="btnContinuar" style="margin-left:80px;">
						Para continuar hace click <a href="<%=redirect%>" style="font-size:12px;color:#000000;">aqui</a><br>
						</div>
		           </div>
		           </div>
		          	</td>
                  </tr>
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
            </table></td>
            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
              <tr>
                <td><table width="148" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><span class="Ftexto02">AQU&Iacute; PODRAS ADHERIRTE AL PROGRAMA DE PUNTOS EXTRA! </span></td>
                  </tr>
                  <tr>
                    <td class="moduloordencelda"><span class="Ftexto02"><strong>Con solo adherirte sumas 30 puntos.</strong></span></td>
                  </tr>
                  <tr>
                    <td class="moduloordencelda"><span class="Ftexto02"><strong>Completanto el formulario de datos complementarios te llevas 50 puntos m&aacute;s. </strong></span></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>
	</div>
</div>
<!-- modal de avisos -->
<div class="ventModal-wrapper" id="modalDomDatosPersonales" style="display:none;position:fixed;left:70%;width:300px;top:150px;">
	<div class="tmkMarcoMiCuentaVentanaTitulo"><div class="hModUsrNombre" id="tituloDiv">Procesando...</div>
        
    </div>    
   <div class="vModContent"  id="divModalOculto" style="display:none;"></div>
   	<div class="vModContent"  id="mensajeRetorno">
   		<div><label class="error" style="text-align:center" id="divMensajeRetorno"></label></div>     	
	</div>
</div>
<script language="javascript">
	cargarModelos(document.frmRegistro.marcaVehiculo);
	habilitaVehiculo(document.frmRegistro.tieneVehiculo);
	document.frmRegistro.aceptoEXtra.focus();

	function habilitaDatosComplementarios(check) {
		var desde = 10000
		for (i=0; i<document.frmRegistro.elements.length; i++) {
			if (document.frmRegistro.elements[i].name == 'idEstudio' || i > desde) {
				desde = i-1;
				document.frmRegistro.elements[i].disabled = !check.checked;
			}

		}
	}

	function habilitaVehiculo(select) {

		var habilitado = (select.options[select.selectedIndex].value == 'TRUE')?true:false;
		var desde = 10000
		for (i=0; i<document.frmRegistro.elements.length; i++) {
			if (document.frmRegistro.elements[i].name == 'idPCHogar') {
				desde = 10000;
			}
			if (document.frmRegistro.elements[i].name == 'marcaVehiculo' || i > desde) {
				desde = i-1;
				document.frmRegistro.elements[i].disabled = !habilitado;
			}

		}
	}

	function enviarDatos(e) {
		var tecla = (document.all) ? e.keyCode : e.which;
		if (tecla == 13) {
			registrarSocioEXtra();
		}
		return false;
	}

	function cargarModelos(select) {

		var aBorrar = document.frmRegistro.modeloVehiculo.options.length;
		for (i=0; i<aBorrar; i++) {
			document.frmRegistro.modeloVehiculo.options[0] = null;
		}
		var datos = Math.random()+'&marcaVehiculo=' + select.options[select.selectedIndex].value;
		$.ajax({
			cache:false,
			type: "Get",
			dataType:"json",
			url:"/GetModelosVehiculos",
			data: datos,
			beforeSend: function(obj){
				if (document.frmRegistro.modeloVehiculo.options.length == 0) {
					var opcion = new Option ("CARGANDO MODELOS", "");
					document.frmRegistro.modeloVehiculo.options[document.frmRegistro.modeloVehiculo.length] = opcion;
					$('#registroExtraFin').get(0).style.display = 'none';
				}
			},			
			success: function(obj){
				//var obj = jQuery.parseJSON(connAj.responseText);
				document.frmRegistro.modeloVehiculo.options[0] = null;
				if (obj != null) {
					for (i=0; i<obj.modelo.length; i++) {
						var opcion = new Option (obj.modelo[i].nombre, obj.modelo[i].id);
						document.frmRegistro.modeloVehiculo.options[document.frmRegistro.modeloVehiculo.length] = opcion;
					}
				} else {
					alert(null);
				}
				$('#registroExtraFin').get(0).style.display = 'block';
			}
		});
		
		return false;
	}
</script>