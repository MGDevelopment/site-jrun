<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.*,
                 java.sql.Timestamp,
                 com.tmk.controllers.MainHelper" %>
                 
<%--
				 //com.tmk.socio.SocioLocalHome,
				 //com.tmk.socio.SocioLocal, 
--%>
<%
  response.setDateHeader("Expires",-1);
  response.setHeader("Pragma","no-cache");
  if(request.getProtocol().equals("HTTP/1.1"))
  	response.setHeader("Cache-Control","no-cache");

  SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
  boolean esSocioTMK = Convert.toBoolean((Boolean)session.getAttribute("socioTMK"), false);
  String redirect = Convert.toString((String)session.getAttribute(MainHelper.URL_REDIRECT), "/");
  if (socioPK == null) {
  	response.sendRedirect("/miCuenta/index.jsp");
  	return;

  }
  if (!esSocioTMK) {
  	///ya es socio CADENA. Reenvio a modificar
  	response.sendRedirect("/miCuenta/modificarSocio.jsp");
  	return;
  }
%>



<script type="text/javascript">
	function handle(connAj, params) {
	    if (params == 'registrarSocioCadena') {
		    if(connAj.readyState == 4){
	 			$('#mensajeLoad').get(0).style.display = "none";
	 			//var obj = (connAj.responseText).evalJSON();
	 			var obj = jQuery.parseJSON(connAj.responseText);
				if (obj.Resultado.valor) {
					$('#formRegistracion').get(0).style.display = "none";
					$('#registracionExitosa').get(0).style.display = "";
					$('#hrefRegistracionExitosa').get(0).focus();
					$('#mensajeError').get(0).style.display = "none";
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
						if (obj.Resultado.campo[0] == 'sexo') {
							var campo = eval ('document.frmRegistro.' + obj.Resultado.campo[0] + "[0]");
						} else {
							var campo = eval ('document.frmRegistro.' + obj.Resultado.campo[0]);
						}
						campo.focus();
						for(i=0; i<obj.Resultado.campo.length; i++) {
							if (obj.Resultado.campo[i] == 'sexo') {
								$('#sexo').get(0).style.backgroundColor = "#FF6666";
							} else {
								var campo = eval ('document.frmRegistro.' + obj.Resultado.campo[i]);
								campo.style.backgroundColor = "#FF6666";
							}

						}
					}
					$('#registroExtraFin').get(0).style.display = "";
				}
		    } else {
				$('#mensajeLoad').get(0).style.display = "";
				$('#registroExtraFin').get(0).style.display = "none";
				$('#hrefMensajeLoad').get(0).focus();
		    }
		}
		if (params == 'reloadLoginPage') {
			if(connAj.readyState == 4){
				$('#loginPage').get(0).innerHTML = connAj.responseText;
			}
		}
	}

	function registrarSocioCadena() {
		for (i=0; i<document.frmRegistro.elements.length; i++) {
			document.frmRegistro.elements[i].style.backgroundColor = "#ffffff";
		}
		$('#sexo').get(0).style.backgroundColor = "#FFFFFF";


		var valorSexo = '';
		for (i=0; i<document.frmRegistro.elements.length; i++) {
			if (document.frmRegistro.elements[i].checked) {
				valorSexo = document.frmRegistro.elements[i].value;
			}
		}

		ejecutarAjax('/RegistrarSocioCadena?param=' + Math.random(),
		'tipoDoc=' + document.frmRegistro.tipoDoc.options[
						document.frmRegistro.tipoDoc.selectedIndex
							].value
		+ '&nroDoc=' + document.frmRegistro.nroDoc.value
		+ '&nacionalidad=' + document.frmRegistro.nacionalidad.options[
								document.frmRegistro.nacionalidad.selectedIndex
									].value
		+ '&sexo=' + valorSexo
		+ '&fechaNacDD=' + document.frmRegistro.fechaNacDD.value
		+ '&fechaNacMM=' + document.frmRegistro.fechaNacMM.value
		+ '&fechaNacAAAA=' + document.frmRegistro.fechaNacAAAA.value
		+ '&estadoCivil=' + document.frmRegistro.estadoCivil.value
		+ '&hijos=' + document.frmRegistro.hijos.value
		+ '&profesion=' + document.frmRegistro.profesion.options[
								document.frmRegistro.profesion.selectedIndex
									].value
		, 'POST', 'registrarSocioCadena');
		return false;
	}

	function enviarDatos(e) {
		var tecla = (document.all) ? e.keyCode : e.which;
		if (tecla == 13) {
			registrarSocioCadena();
		}
	}

</script>

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
		                  	 <table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
		                     	<tr>
		                        	<td class="celdamodulodomicilio2"><span class="Ftexto02">Para poder seguir con el proceso, necesitamos que complete los siguientes datos.</span></td>
		                         </tr>
		                      </table>
                          </td>
                        </tr>
                        <tr>
                          <td valign="top" class="Ftexto02">
                          <table width="366" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                              <td height="35" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">Datos adicionales:</span></td>
                            </tr>
                             <tr>
                          		<td colspan="3" valign="bottom" class="FTtit01">&nbsp;</td>
                        	</tr>
                             <tr>
	                        	<td colspan="3">
    	                    		<div id="mensajeError" class="cuadroError" style="display:none;">
    	                    		</div>
            	            	</td>
                        	</tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Documento de identidad:</td>
                              <td colspan="2"><table width="224" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td>
                                        <select name="tipoDoc" class="tipoDoc" tabindex="1" onKeyPress="enviarDatos(event)">
                                        	<option value="">selecciona</option>
                                        <%
											for (int i = 0; i < Globals.TIPOS_DOCUMENTO.length; i++) {
												TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[i];
										%>

											<option value="<%= tipoDeDocumentoDAO.getId() %>"><%= tipoDeDocumentoDAO.getNombre() %></option>
										<%  } %>
                                        </select>

                                        <input name="nroDoc" type="text" class="nroDoc" size="8" maxlength="15" tabindex="2"/>
                                     </td>
                                  </tr>
                              </table></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Nacionalidad: </td>
                              <td colspan="2"><div align="left">
                                  <select name="nacionalidad" class="nacionalidad" tabindex="3" onKeyPress="enviarDatos(event)">
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
                                  <input name="sexo" type="radio" value="M" tabindex="4" onKeyPress="enviarDatos(event)"/></td><td>
                                Masculino</td><td>
                                <input name="sexo" type="radio" value="F" tabindex="5" onKeyPress="enviarDatos(event)"/></td><td>
                                Femenino</td></tr></table>
                                 </td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02">&nbsp;&nbsp;Fecha de nacimiento: </td>
                              <td colspan="2"><div align="left">
                                  <input name="fechaNacDD" type="text" class="fecNac" value="dd" size="2" maxlength="2" tabindex="6" onKeyPress="enviarDatos(event)"/>/
                                  <input name="fechaNacMM" type="text" class="fecNac" value="mm" size="2" maxlength="2" tabindex="7" onKeyPress="enviarDatos(event)"/>/
                                  <input name="fechaNacAAAA" type="text" class="fecNac" value="aaaa" size="4" maxlength="4" tabindex="8" onKeyPress="enviarDatos(event)"/>
                              </div></td>
                            </tr>
                            <tr>
                              <td height="28" valign="bottom" class="Ftexto02">&nbsp;&nbsp;Estado civil: </td>
                              <td height="28" colspan="2"><div align="left">
                                  <table width="224" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                      <td width="125"><select name="estadoCivil" class="profesion" tabindex="9" onKeyPress="enviarDatos(event)">
													   	<option value="">selecciona</option>
                                      <%
                                      		for (int i = 0; i < Globals.ESTADOS_CIVILES.length; i++) {
												EstadoCivilDAO estadoCivilDAO = Globals.ESTADOS_CIVILES[i];
									  %>
												<option value="<%= estadoCivilDAO.getId() %>"> <%= estadoCivilDAO.getNombre() %></option>
			  						  <%  } %>
                                      </select></td>
                                      <td width="27" valign="bottom"><span class="Ftexto02">Hijos:</span></td>
                                      <td width="72"><input name="hijos" type="text" class="empleotext5" maxlength="2" tabindex="10" onKeyPress="enviarDatos(event)"/></td>
                                    </tr>
                                  </table>
                              </div></td>
                            </tr>
                            <tr>
                              <td valign="bottom" class="Ftexto02">&nbsp;&nbsp;Profesi&oacute;n: </td>
                              <td colspan="2"><div align="left">
                                  <select name="profesion" class="profesion" tabindex="11" onKeyPress="enviarDatos(event)">
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
                          </table></td>
                        </tr>
                        <tr>
                          <td height="80" valign="top">
                           <div id="registroExtraFin">
	                            <a href="#" style="cursor:pointer" onclick="registrarSocioCadena()" tabindex="12"><img src="/imagenes/inicio/b-continuar.gif" alt="Empezar a sumar puntos!" border="0" /></a> </div>
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
                   			Registro de Datos Exitoso!!
                   		</div>
                   		<img src="/imagenes/iconoAvion.jpg"><br>
						Gracias por completar los datos adicionales.<p>
						<div class="btnContinuar" style="margin-left:80px;">
	                    Para continuar hace click <a href="<%=redirect%>" style="font-size:12px;color:#000000;">aqui</a>
	                    </div><br>&nbsp;<br>
    	                <div class="btnContinuar" style="margin-left:40px;">
	                    Si deseas adherirte a eXtra hace click <a href="/miCuenta/registroSocioEXtra.jsp" style="font-size:12px;color:#000000;">aqui</a>
	                    </div>
	                    <br>

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

              </tr>
            </table></td>
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
              </tr>
            </table></td>
          </tr>

        </table>


<% if(Globals.esModoRelease()) { %>
<!-- Tag for Activity Group: Tematika website - Sales, Activity: Tematika Mi Cuenta -->

<!-- Start of DoubleClick Spotlight Tag: Please do not remove-->
<!-- Activity Name for this tag is:Tematika Mi Cuenta -->
<!-- Web site URL where tag should be placed: https://www.tematika.com/miCuenta/datosPersonales.jsp -->
<!-- Creation Date:12/29/2006 -->
<IMG SRC="https://ad.doubleclick.net/activity;src=1364770;type=tematsal;cat=tematsc1;qty=1;cost=<%=(request.getHeader("Referer").indexOf("registroSocioTMK")>-1 || request.getHeader("Referer").indexOf("registroSocioTMK.jsp")>-1)?1:0%>;ord=1?" WIDTH=1 HEIGHT=1 BORDER=0>
<!-- End of DoubleClick Spotlight Tag: Please do not remove-->
<%} %>
<%=Globals.getGoogleAnalyticsSSL()%>
</body>
</html>
<script languaje="javascript">
	document.frmRegistro.tipoDoc.focus();
</script>