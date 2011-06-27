<%@page import="com.tmk.bus.socio.SociosIntegracion"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.bus.socio.SocioTMK,
                 com.tmk.kernel.*,
                 java.sql.Timestamp, java.sql.Connection" %>
<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.soa.servicios.interfaces.Socio2Service"%>

<%
  response.setDateHeader("Expires",-1);
  response.setHeader("Pragma","no-cache");
  if(request.getProtocol().equals("HTTP/1.1"))
  	response.setHeader("Cache-Control","no-cache");

  SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
  boolean esSocioTMK = Convert.toBoolean((Boolean)session.getAttribute("socioTMK"), false);
  boolean esSocioIntegracion;
  SociosIntegracion sociosIntegracion = null;

  Socio2Service  servicio = ServiceLocator.getSocioService();
  Socios2 socioLocal = servicio.findByPK(socioPK);
  SocioTMK socioTMK = null;

  if (esSocioTMK) {
	//si es socoTMK nunca sera sociosIntegracion por que no esta en socios2
	esSocioIntegracion = false;
	socioTMK = ServiceLocator.getSociosTMKService().findSocioTMKByPK(socioPK);	
  } else {
	  //puede o no ser socio integracion, depende de si esta o no asociado a una cuenta de popego
	  sociosIntegracion = servicio.getSocioIntegracion(socioPK,"popego.com");
	  esSocioIntegracion = sociosIntegracion != null;	        
  }
%>

<script language="javascript">
	var esPrimeraVes =true;
	var estado = false;
</script>

<script type="text/javascript" src="/js/popego.js"></script>
<script type="text/javascript" src="https://secure.popego.com/assets/javascripts/popego-core.js"></script>


<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
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
            <td class="Gcentro" width="422">
            <table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                 <table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>
                  <tr>
                  	<td  class="moduloAyuda" bgcolor="#F3F4F5" style="padding:10px">
                  		<div id="formModificacion" onSubmit="return false">
		                  	<table width="366" border="0" cellspacing="0" cellpadding="0">
  								<form name="frmModificacion" onSubmit="return false">
                    			    <tr>
                          				<td valign="top" class="Ftexto02">
					                  		<table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
					                     		<tr>
					                        		<td class="celdamodulodomicilio2"><span class="Ftexto02">Aqui puedes modificar los datos de tu cuenta.</span></td>
					                         	</tr>
					                      	</table>
				                         </td>
                			        </tr>
                        			<tr>
		                   				<td valign="top" class="Ftexto02">
        					                <table width="366" border="0" cellpadding="0" cellspacing="0">
                            					<tr>
						                            <td height="35" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">Datos de tu cuenta:</span></td>
                        					    </tr>
					                            <tr>
					                          		<td colspan="3" valign="bottom" class="FTtit01">&nbsp;</td>
					                        	</tr>
					                            <tr>
						                        	<td colspan="3">
						                        		<a name="anclaMensajeError"></a>
					    	                    		<div id="mensajeError" class="cuadroError" style="display:none;">

					    	                    		</div>
					            	            	</td>
 					                        	</tr>
                           						<tr>
						                          	<td width="142" valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Nombres: </td>
						                          	<td width="224" colspan="2"><div align="left">
						                            	<input class="nroDoc" name="nombres" type="text" value="<%=(esSocioTMK)?socioTMK.getNombres():socioLocal.getNombres()%>" class="ayudatext" tabindex="1" onKeyPress="enviarDatos(event)"/>
						                          		</div>
						                          	</td>
						                        </tr>
						                        <tr>
						                          <td valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Apellidos: </td>
						                          <td colspan="2"><div align="left">
						                              <input class="nroDoc" name="apellidos" type="text" value="<%=(esSocioTMK)?socioTMK.getApellidos():socioLocal.getApellidos()%>" class="ayudatext"  maxlength="50" tabindex="2" onKeyPress="enviarDatos(event)"/>
						                          </div></td>
						                        </tr>
						                        <tr>
						                          <td valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Direccion de e-mail: </td>
						                          <td colspan="2"><div align="left">
						                              <input class="nroDoc" name="email" type="text" value="<%=(esSocioTMK)?socioTMK.getLogin():socioLocal.getlogin()%>" class="ayudatext" maxlength="104" tabindex="3" onKeyPress="enviarDatos(event)"/>
						                          </div></td>
						                        </tr>
						                        <tr>
						                          <td valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Clave de acceso: </td>
						                          <td colspan="2"><div align="left">
						                              <input class="nroDoc" name="password" type="password" class="empleotext"  maxlength="40"
						                              value="<%=(esSocioTMK)?socioTMK.getPasswordDesencriptado():socioLocal.getpassword()%>" tabindex="4" onKeyPress="enviarDatos(event)"/>
						                          </div></td>
						                        </tr>
						                        <tr>
						                          <td height="40" valign="bottom" class="Ftexto02"> <p><span class="Ftextorojo">*</span> Reingresar clave de<br />
						                            &nbsp;&nbsp;acceso: </p>                            </td>
						                          <td colspan="2" valign="bottom"><div align="left">
						                              <input class="nroDoc" name="rePassword" type="password" class="empleotext"
						                              value="<%=(esSocioTMK)?socioTMK.getPasswordDesencriptado():socioLocal.getpassword()%>" tabindex="5" onKeyPress="enviarDatos(event)"/>
						                          </div></td>
						                        </tr>
							                       <% if (esSocioTMK) { %>
							                        <tr>
							                        	<td colspan="3">&nbsp;<br>&nbsp;</td>
							                        </tr>
	<!-- **** DATOS ADICIONALES, ACA VA EL LINK PARA ASOCIOAR A POPEGO**** -->
													<TR>
														<td class="Ftexto02">
							                        		<span class="FTtit01">Datos Adicionales</span>
							                        	</td>	
														<tr><td>&nbsp;<br></td></tr>
													</TR>
							                        <tr>
							                        	<td class="Ftexto02">
							                        		<span class="FTtit01">Completar datos adicionales?</span>
							                        	</td>
							                        	<td colspan="2" valign="bottom">
							                        		<input type="checkbox" name="datosPersonales" onclick="return habilitarDatos(this.checked)" tabindex="6" onKeyPress="enviarDatos(event)">
							                        	</td>
							                        </tr>
							                        <tr>
							                        	<td colspan="3" style="font-size:5px">&nbsp;</td>
							                        </tr>
							                        <%}%>
					                            <tr>
					                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Documento de identidad:</td>
					                              <td colspan="2">
					                              	<table width="224" border="0" cellspacing="0" cellpadding="0">
					                                	<tr>
					                                    	<td>
					                                    		<input type="hidden" name="tipoDoc" value="<%=(!esSocioTMK)?socioLocal.getTipo_doc()+"":""%>"/>
						                                        <select name="tipoDoc" class="tipoDoc" disabled tabindex="7" onKeyPress="enviarDatos(event)">
						                                        	<option value="">selecciona</option>
						                                        <%
																	for (int i = 0; i < Globals.TIPOS_DOCUMENTO.length; i++) {
																		TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[i];
						  									    %>
																	<option value="<%= tipoDeDocumentoDAO.getId() %>" <%=(!esSocioTMK)?(tipoDeDocumentoDAO.getId().equals(socioLocal.getTipo_doc())?"selected":""):""%>><%= tipoDeDocumentoDAO.getNombre() %></option>
																<%  } %>
						                                        </select>
						                                        <input type="hidden" name="nroDoc" value="<%=(!esSocioTMK)?socioLocal.getNro_doc()+"":""%>"/>
					                                        	<input name="nroDoc" type="text" class="nroDoc" size="8" maxlength="15" value="<%=(!esSocioTMK)?socioLocal.getNro_doc()+"":""%>" disabled tabindex="8" onKeyPress="enviarDatos(event)"/>
					                                     	</td>
					                                  	</tr>
					                              	</table>
					                              </td>
					                            </tr>
					                            <tr>
					                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Nacionalidad: </td>
					                              <td colspan="2"><div align="left">
					                              	  <input type="hidden" name="nacionalidad" value="<%=socioLocal.getNacionalidad().getIdPais()%>"/>				                              
					                                  <select name="nacionalidad" class="nacionalidad" disabled tabindex="9" onKeyPress="enviarDatos(event)">
															<option value="">selecciona</option>
					                                   <%
															for (int i = 0; i < Globals.PAISES.length; i++) {
																PaisDAO paisDAO = Globals.PAISES[i];
													   %>
																<option value="<%=paisDAO.getId() %>" <%=(!esSocioTMK)?((paisDAO.getId()==socioLocal.getNacionalidad().getIdPais())?"selected":""):""%>> <%= paisDAO.getNombre() %></option>
								 					   <%  	} %>
								 					   </select>
					                              </div></td>
					                            </tr>
					                            <tr>
					                              <td height="28" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Sexo: </td>
					                              <td height="28" colspan="2" valign="bottom" style="padding-left:3px; text-align:left">
					                              	 <input type="hidden" name="sexo" value="<%=socioLocal.getSexo()%>"/>
					                                 <table id="sexo" border ="0" cellpadding="2" cellspacing="0" class="Ftexto02" style="border:solid 1px #666;background-color:#FFF"><tr><td>
					                                   <input name="sexo" type="radio" value="M" <%=(!esSocioTMK)?((socioLocal.getSexo().equals("M"))?"checked":""):""%>  disabled tabindex="10" onKeyPress="enviarDatos(event)"/></td><td>
					                                Masculino</td><td>
					                                <input name="sexo" type="radio" value="F" <%=(!esSocioTMK)?((socioLocal.getSexo().equals("F"))?"checked":""):""%>  disabled tabindex="11" onKeyPress="enviarDatos(event)"/></td><td>
					                                Femenino</td></tr></table>
					                                 </td>
					                            </tr>
					                            <tr>
					                              <td valign="bottom" class="Ftexto02">&nbsp;&nbsp;Fecha de nacimiento:
					                              </td>
												<%
													String fechaNacDD = "dd";
													String fechaNacMM = "mm";
													String fechaNacAAAA = "aaaa";
													if (!esSocioTMK) {
														if (socioLocal.getFecha_nacimiento() != null) {
															fechaNacAAAA = socioLocal.getFecha_nacimiento().toString().substring(0, 4);
															fechaNacMM = socioLocal.getFecha_nacimiento().toString().substring(5, 7);
															fechaNacDD = socioLocal.getFecha_nacimiento().toString().substring(8, 10);
														}
													}
												%>
					                              <td colspan="2"><div align="left">
					                                  <input name="fechaNacDD" type="text" class="fecNac" value="<%=fechaNacDD%>" size="2" maxlength="2" <%=(esSocioTMK)?"disabled":""%> tabindex="12" onKeyPress="enviarDatos(event)"/>/
					                                  <input name="fechaNacMM" type="text" class="fecNac" value="<%=fechaNacMM%>" size="2" maxlength="2"<%=(esSocioTMK)?"disabled":""%> tabindex="13" onKeyPress="enviarDatos(event)"/ >/
					                                  <input name="fechaNacAAAA" type="text" class="fecNac" value="<%=fechaNacAAAA%>" size="4" maxlength="4" <%=(esSocioTMK)?"disabled":""%> tabindex="14" onKeyPress="enviarDatos(event)"/>
					                              </div></td>
					                            </tr>
					                            <tr>
					                              <td height="28" valign="bottom" class="Ftexto02">&nbsp;&nbsp;Estado civil: </td>
					                              <td height="28" colspan="2"><div align="left">
					                                  <table width="224" border="0" cellspacing="0" cellpadding="0">
					                                    <tr>
					                                      <td width="125"><select name="estadoCivil" class="profesion" <%=(esSocioTMK)?"disabled":""%> tabindex="15" onKeyPress="enviarDatos(event)">
																		   	<option value="">selecciona</option>
					                                      <%
					                                      		for (int i = 0; i < Globals.ESTADOS_CIVILES.length; i++) {
																	EstadoCivilDAO estadoCivilDAO = Globals.ESTADOS_CIVILES[i];
														  %>
																	<option value="<%= estadoCivilDAO.getId() %>" <%=(!esSocioTMK)?((estadoCivilDAO.getId().equals(socioLocal.getEstado_civil()))?"selected":""):""%>> <%= estadoCivilDAO.getNombre() %></option>
								  						  <%  } %>
					                                      </select></td>
					                                      <%
					                                      		String hijos="";
					                                       if (!esSocioTMK) {
					                                      		if (socioLocal.getHijos()!= null) {
					                                      			hijos = socioLocal.getHijos().toString();
					                                      		}
					                                      	}
					                                      %>
					                                      <td width="27" valign="bottom"><span class="Ftexto02">Hijos:</span></td>
					                                      <td width="72"><input name="hijos" value="<%=hijos%>" type="text" class="empleotext5" maxlength="2" <%=(esSocioTMK)?"disabled":""%> tabindex="16" onKeyPress="enviarDatos(event)"/ ></td>
					                                    </tr>
					                                  </table>
					                              </div></td>
					                            </tr>
					                            <tr>
					                            <%
					                            int idProfesion = 0;
				                            	if (!esSocioTMK) {
		                                      		if (socioLocal.getId_profesion()!= null) {
		                                      			idProfesion = socioLocal.getId_profesion().intValue();
		                                      		}
		                                      	}
					                            %>
					                              <td valign="bottom" class="Ftexto02">&nbsp;&nbsp;Profesi&oacute;n: </td>
					                              <td colspan="2">
						                              <div align="left">
						                                  <select name="profesion" class="profesion" <%=(esSocioTMK)?"disabled":""%> tabindex="17" onKeyPress="enviarDatos(event)">
														     	<option value="">selecciona</option>
						                                  		<%
						                                  		for (int i = 0; i < Globals.PROFESIONES.length; i++) {
																	ProfesionDAO profesionDAO = Globals.PROFESIONES[i];
														  		%>
																	<option value="<%= profesionDAO.getId() %>" <%=(!esSocioTMK)?((idProfesion==profesionDAO.getId())?"selected":""):""%>> <%= profesionDAO.getNombre() %></option>
						                                  		<%}%>
						                                  </select>
						                              </div>
					                              </td>
					                            </tr>
												<tr>
													<td align="center" colspan="3">
						                           <div id="registroExtraFin">
							                            <a href="#" style="cursor:pointer" onclick="modificarSocio(document.frmModificacion)">
							                            	<img src="/imagenes/inicio/b-guardar.gif" alt="Empezar a sumar puntos!" border="0" tabindex="18"/>
							                            </a>
							                       </div>							                       
						                    	  </td>
						                        </tr>
<!--*** LINK PARA ASOCIAR USUARIO DE POPEGO ***-->
												<tr>
						                        	<td colspan="3" style="font-size:20px">
						                        		&nbsp;
						                        	</td>
						                        </tr>
						                        <tr>
						                        	<td colspan="3">
						                        	<div style="border: 1px solid;padding:2px; ">
						                        		<table border="0">
									                        <tr>
									                        	 <td  class="Ftexto02" style="height: 31px;" colspan="3" align="center">
																	<b>Nuevo : Ahora podés asociar el servicio de Popego a tu cuenta de Tematika. <a href="/miCuenta/servicios/servicioPopego.jsp" target="_blank" class="FAyuda">(¿Qu&eacute; es popego?)</a></b>
									                        	</td>
									                        </tr>
									                        <tr>
									                        	 <td colspan="3" style="font-size:1px">
																	<div style="border-top: 1px solid;width:100% "></div><br>&nbsp;
									                        	</td>
									                        </tr>
															<tr>
																<td  colspan="3">
																	<table width="100%" border="0" class="Ftexto02">
																		<tr>
																			<td width="20px">
																				<img src="/imagenes/popego_favicon.png" width="15px" height="15px">
																			</td>
																			<td width="50px">
																				Popego:
																			</td>
																			<td align="left" >
																				<div style="border: 1px solid;padding:1px;background-color:#ffffff;">
											                        				<label id="lblusername"><%=(esSocioIntegracion) ? sociosIntegracion.getIdentificador() : ""%></label>
											                        			</div>	
											                        		</td>	
											                        	<% if(esSocioTMK) { %>
										                        			<td align="right" width="60px">
											                        			<div id="lnkpopegodes" style="cursor:pointer;" class="lnkNoHabilitado"><a class="lnkNoHabilitado" title="Para asociarte tenes que completar los datos adicionales de tu cuenta de tematika">Asociate!</a></div>
											                        			<div id="lnkpopego" style="cursor:pointer;display:none;"><a onClick="limpirarResultado();" class="lnkHabilitado">Asociate!</a></div>
																				<div id="lnkCancelar"  onClick="cancelar();" style="cursor:pointer;display:none;"><a class="lnkHabilitar">Cancelar</a></div>
										                        			</td>
											                        	<% }else { %>
											                        		<td align="right" width="60px">
											                        			<div id="lnkpopego" style="cursor:pointer;display:block;"
											                        				 onClick="limpirarResultado();"><a class="lnkHabilitado"><%=(esSocioIntegracion ? "Modificar!" : "Asociate!")%></a></div>
											                        			<div id="lnkCancelar"  onClick="cancelar();" style="cursor:pointer;display:none;"><a class="lnkHabilitar">Cancelar</a></div>
											                        		</td>
											                        	<% } %>
																		</tr>
																	</table>			
									                        	</td>
									                        <tr>
									                       		 <td colspan="3" align="center">
																<div id="divPopego" style="display:block;">
															        <label id="txtMensaje" class="Ftexto02">&nbsp;</label>
															        <div id="iframe_container"></div>
															        <div id="result" class=""></div>
															    </div>
															  <input type="hidden" value="null" id="username" name="username">
															 </td>
									                        </tr>
									                        
									                        <tr>
									                        	<td colspan="3">
										                        	Si ya sos usuario de Popego, sólo tenés que loguearte. <p>Si querés registrarte en Popego, también podés agregar a Tematika como servicio en sus opciones.
										                        	<a href="http://www.popego.com" target="_blank" class="FAyuda">registrate en popego!!!</a>										                        	
																	 
									                        	</td>
									                        </tr>									                        
									                    </table>
									                     </div>
									                  </td>
									                </tr>        
					                          </table></td>
					                        </tr>
					                        <tr>

											</tr>

					                        <tr>
					                          <td height="80" valign="top">
					                           <div id="registroExtraFin">
						                            <a href="#" style="cursor:pointer" onclick="modificarSocio(document.frmModificacion)">
						                            <img src="/imagenes/inicio/b-asociarServ.gif" alt="Asociar servicio!" border="0" tabindex="18"/></a>
						                       </div>
						                       <div id="mensajeLoad" class="cuadroLoad" style="display:none;width:290px;margin-left:32px;margin-top:30px;">
							            	      		Procesando...<a id="hrefMensajeLoad" href="#"></a>
					        			       </div>
					                    	  </td>
					                        </tr>
				                        </form>
				                    </table>

                  </div>
                   <div id="modificacionExitosa" class="cuadroExitoExterno" style="display:none;width:370px">
                   <a id="hrefModificacionExitosa" href="#"></a>
                   <div  class="cuadroExito">
                   		<div class="cuadroExitoTitulo" style="width:350px">
                   			Modificación de Datos de Cuenta
                   		</div>
                   		<img src="/imagenes/iconoAvion.jpg"><br>
						<div id="msgModificacionExitosa"></div>
		           </div>
		           </div>
		          	</td>
                  </tr>
                </table>
                </td>
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
			 		Disposición (Dirección Nacional de Protección de Datos Personales) 10/2008<p>
					<p>"El titular de los datos personales tiene la facultad de ejercer el derecho de acceso a los mismos en forma gratuita a intervalos no inferiores a seis meses, salvo que se acredite un interés legítimo al efecto conforme lo establecido en el artículo 14, inciso 3 de la Ley Nº 25.326"</p>
					<p>"La DIRECCION NACIONAL DE PROTECCION DE DATOS PERSONALES, órgano de control de la Ley Nº 25.326, tiene la atribución de atender las denuncias y reclamos que se interpongan con relación al incumplimiento de las normas sobre protección de datos personales".<p>
					<hr>
			 	</td>
			 </tr>
              </tr>
            </table>
            </td>
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
              </tr>
            </table>
            </td>
          </tr>
	</table>

<!-- /*** debajo los scripts****/ -->
<script type="text/javascript">
	function handle(connAj, params) {
		try{
		    if (params == 'modificarSocio') {
			    if(connAj.readyState == 4) {
		 			$('#mensajeLoad').get(0).style.display = "none";
		 			//var obj = connAj.responseText.evalJSON();		 			
		 			var obj = jQuery.parseJSON(connAj.responseText);
					if (obj.Resultado.valor) {
						$('#formModificacion').get(0).style.display = "none";
						$('#msgModificacionExitosa').get(0).innerHTML = obj.Resultado.mensaje[0];
						$('#modificacionExitosa').get(0).style.display = "";
						$('#hrefModificacionExitosa').get(0).focus();
						$('#mensajeError').get(0).style.display = "none";
						$('#username').get(0).value = 'null';
					} else {
						if (obj.Resultado.mensaje != null) {
							$('#mensajeError').get(0).innerHTML = "";
							for(i=0; i<obj.Resultado.mensaje.length; i++) {
								$('#mensajeError').get(0).innerHTML = $('#mensajeError').get(0).innerHTML +
								obj.Resultado.mensaje[i] + '<br>';
							}
							$('#mensajeError').get(0).style.display = "";
						}
						if (obj.Resultado.campo != null) {
							if(obj.Resultado.campo[0]=="starter") {
								$('#result').get(0).innerHTML='<p style=\"color:red;\"><b>Usá otra cuenta de Popego, la que elegiste le pertenece a otro usuario<b></p>';
								throw e;
							}
							if (obj.Resultado.campo[0] == 'sexo') {
								var campo = eval ('document.frmModificacion.' + obj.Resultado.campo[0] + "[0]");
							} else {
								var campo = eval ('document.frmModificacion.' + obj.Resultado.campo[0]);
							}
							campo.focus();
							for(i=0; i<obj.Resultado.campo.length; i++) {
								if (obj.Resultado.campo[i] == 'sexo') {
									$('#sexo').get(0).style.backgroundColor = "#FF6666";
								} else {
									var campo = eval ('document.frmModificacion.' + obj.Resultado.campo[i]);
									campo.style.backgroundColor = "#FF6666";
								}
							}
						}
						if (obj.Resultado.targetRedirect) {
					    	window.location.href = obj.Resultado.targetRedirect;
				      	}
						$('#registroExtraFin').get(0).style.display = "";
					}
			    } else {
					$('#mensajeLoad').get(0).style.display = "";
					$('#hrefMensajeLoad').get(0).focus();
					$('#registroExtraFin').get(0).style.display = "none";
			    }
			}
		}catch(e){
			$('#result').get(0).innerHTML='<p style=\"color:red;\"><b>Usá otra cuenta de Popego, la que elegiste le pertenece a otro usuario<b></p>';
			$('#mensajeLoad').get(0).style.display = "none";
			$('#registroExtraFin').get(0).style.display = "block";
			$('#registroExtraFin').gef(0).focus();
		}
	}
function modificarSocio(frm) {
		for (i=0; i<frm.elements.length; i++) {
			frm.elements[i].style.backgroundColor = "#ffffff";
		}
		$('#sexo').get(0).style.backgroundColor = "#FFFFFF";

		var valorSexo = '';
		for (i=0; i<frm.elements.length; i++) {
			if (frm.elements[i].name == 'sexo' && frm.elements[i].checked) {
				valorSexo = frm.elements[i].value;
			}
		}
		ejecutarAjax('/ModificarSocio?param=' + Math.random(),
		 '&nombres=' + frm.nombres.value
		+ '&apellidos=' + frm.apellidos.value
		+ '&email=' + frm.email.value
		+ '&password=' + frm.password.value
		+ '&rePassword=' + frm.rePassword.value
		+ '&tipoDoc=' + frm.tipoDoc.options[
						frm.tipoDoc.selectedIndex
							].value
		+ '&nroDoc=' + frm.nroDoc.value
		+ '&nacionalidad=' + frm.nacionalidad.options[
								frm.nacionalidad.selectedIndex
									].value
		+ '&sexo=' + valorSexo
		+ '&fechaNacDD=' + frm.fechaNacDD.value
		+ '&fechaNacMM=' + frm.fechaNacMM.value
		+ '&fechaNacAAAA=' + frm.fechaNacAAAA.value
		+ '&estadoCivil=' + frm.estadoCivil.value
		+ '&hijos=' + frm.hijos.value
		+ '&profesion=' + frm.profesion.options[
								frm.profesion.selectedIndex
									].value
		<%if (esSocioTMK) {%>
			+ '&datosPersonales=' + frm.datosPersonales.checked
		<%}	%>
		, 'POST', 'modificarSocio');
		return false;
	}

	function habilitarDatos(habilitar) {
		var frm = document.frmModificacion;
		frm.tipoDoc.disabled = !habilitar;
		frm.nroDoc.disabled = !habilitar;
		frm.nacionalidad.disabled = !habilitar;
		frm.sexo[0].disabled = !habilitar;
		frm.sexo[1].disabled = !habilitar;
		frm.fechaNacDD.disabled = !habilitar;
		frm.fechaNacMM.disabled = !habilitar;
		frm.fechaNacAAAA.disabled = !habilitar;
		frm.estadoCivil.disabled = !habilitar;
		frm.profesion.disabled = !habilitar;
		frm.hijos.disabled = !habilitar;
		if(habilitar){
			$('#lnkpopego').get(0).style.display = 'block';
			$('#lnkpopegodes').get(0).style.display = 'none';
		}
		else {
			$('#lnkpopegodes').get(0).style.display = 'block';
			$('#lnkpopego').get(0).style.display = 'none';
			$('#lnkCancelar').get(0).style.display = 'none';
			$('#result').get(0).innerHTML = '';
			if($('#result').get(0).innerHTML !='')
				resetUserName();
		}
		setLoginPopegoVisible(habilitar);
	}

	function enviarDatos(e) {
		var tecla = (document.all) ? e.keyCode : e.which;
		if (tecla == 13) {
			modificarSocio(document.frmModificacion);
		}
	}

	crearWidgets(estado);
</script>