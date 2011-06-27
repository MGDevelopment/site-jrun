<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.*,
                 java.sql.Timestamp,
                 com.tmk.controllers.MainHelper" %>

<%--
                 //com.tmk.socio.SocioLocalHome,
                 //com.tmk.socio.SocioLocal, 
--%>


<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
  	if (socioPK != null) {
  		response.sendRedirect("/miCuenta/index.jsp");
	  	return;
	}
	String email = Convert.toString(request.getParameter("LOGIN"), "");
    String redirect = Convert.toString((String)session.getAttribute(MainHelper.URL_REDIRECT), "/");
%>


<script type="text/javascript">
	function registrarSocioTMK() {
		for (i=0; i<document.frmRegistro.elements.length; i++) {
			if (document.frmRegistro.elements[i].type == 'text'
				|| document.frmRegistro.elements[i].type == 'password') {
				document.frmRegistro.elements[i].style.backgroundColor = "#ffffff";
				//document.frmRegistro.elements[i].style.color = "#000000";
			}
		}
		var valores = 'nombres=' +   document.frmRegistro.nombres.value
			+ '&apellidos=' +  document.frmRegistro.apellidos.value
			+ '&email=' +  document.frmRegistro.email.value
			+ '&password=' +  document.frmRegistro.password.value
			+ '&rePassword=' +  document.frmRegistro.rePassword.value;

		$.ajax({
			cache:false,
			type: "POST",
			dataType:"json",
			url:'/RegistrarSocioTMK',
			data: valores,
			beforeSend: function(obj) {
				$('#divMensaje').html(divLoading2);
				$('#divMensaje').css("display","block");
				$('#btnRegistrar').css("display","none");
			},			
			success: function(obj){
					$('#btnRegistrar').css("display","block");
					$('#divMensaje').html("");
					$('#divMensaje').css("display","none");
					if (obj.Resultado.valor) {
						//chequeo referido
						if (obj.Resultado.aux[0] == "true") {
							esReferido = true;
						} else {
							//$('#referido').get(0).style.display = "none";
							esReferido = false;
						}
						window.location.href = '/miCuenta/?seccionMiCuenta=REG_OK&esReferido=' + esReferido;
					} else {
						if (obj.Resultado.mensaje != null) {
							for(i=0; i<obj.Resultado.mensaje.length; i++) {
								$('#divMensaje').get(0).innerHTML = $('#divMensaje').get(0).innerHTML +
								obj.Resultado.mensaje[i] + '<br>';
							}
							$('#divMensaje').get(0).style.display = "";
						}
						if (obj.Resultado.campo != null) {
							var campo = eval ('document.frmRegistro.' + obj.Resultado.campo[0]);
							campo.focus();
							for(i=0; i<obj.Resultado.campo.length; i++) {
								var campo = eval ('document.frmRegistro.' + obj.Resultado.campo[i]);
								campo.style.backgroundColor = "#FF6666";
							}
						}
					}						
					
			}
		});
		return false;		
	}

	function enviarDatos(e) {
		var tecla = (document.all) ? e.keyCode : e.which;
		if (tecla == 13) {
			registrarSocioTMK();
		}
	}
</script>
<%--
<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td class="Gbarraizquierda" width="139">
	            <table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
				 	<tr>
						<td valign="top">

							<div id="TerminarSesion"   <%=(socioPK==null)? "style=\"display:none\"":""%>>
							<table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
		            			<tr>
									  <td align="left" class="preguntasceldas">
									  	<a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a>
									  </td>
				                </tr>
				    	    </table>
				    	    </div>
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
                        	<td colspan="3" valign="bottom" class="Ftexto02"><strong>Registro a Tematika.com</strong> <br />
                            	Recuerde que los campos con (<span class="Ftextorojo">*</span>) son obligatorios.</td>
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
                          <td width="142" valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Nombres: </td>
                          <td width="224" colspan="2"><div align="left">
                              <input name="nombres" type="text" class="ayudatext" tabindex="1" onKeyPress="enviarDatos(event)" />
                          </div></td>
                        </tr>
                        <tr>
                          <td valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Apellidos: </td>
                          <td colspan="2"><div align="left">
                              <input name="apellidos" type="text" class="ayudatext"  maxlength="50" tabindex="2" onKeyPress="enviarDatos(event)"/>
                          </div></td>
                        </tr>

                        <tr>
                          <td valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Direccion de e-mail: </td>
                          <td colspan="2"><div align="left">
                              <input name="email" type="text" value="<%=email%>" class="ayudatext" maxlength="104" tabindex="3" onKeyPress="enviarDatos(event)"/>
                          </div></td>
                        </tr>

                        <tr>
                          <td valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Clave de acceso: </td>
                          <td colspan="2"><div align="left">
                              <input name="password" type="password" class="empleotext"  maxlength="40" tabindex="4" onKeyPress="enviarDatos(event)"/>
                          </div></td>
                        </tr>
                        <tr>
                          <td height="40" valign="bottom" class="Ftexto02"> <p><span class="Ftextorojo">*</span> Reingresar clave de<br />
                            &nbsp;&nbsp;acceso: </p>                            </td>
                          <td colspan="2" valign="bottom"><div align="left">
                              <input name="rePassword" type="password" class="empleotext" tabindex="5" onKeyPress="enviarDatos(event)"/>
                          </div></td>
                        </tr>

                        <tr>
                          	<td height="80" colspan="3" valign="top">
	                        	<div id="registroExtraFin">
	                            	<a href="#" style="cursor:pointer" onclick="registrarSocioTMK()" tabindex="6"><img src="/imagenes/inicio/b-registrarse.gif" alt="Empezar a sumar puntos!" border="0" /></a> </div>
	                          	</div>
	                          	<div id="mensajeLoad" class="cuadroLoad" style="display:none;width:290px;margin-left:32px;margin-top:30px;">
		            	      		Procesando...<a id="hrefMensajeLoad" href="#"></a>
        			          	</div>
		                    </td>
                        </tr>
                    </form>
	                </table>
                  	</div>


                  	<div id="registracionExitosa" style="display:none">
                  		<a id="hrefRegistracionExitosa" href="#"></a>
                  		<table width="366" border="0" cellspacing="0" cellpadding="0">
	                        <tr>
	                          <td valign="bottom" class="Ftexto02">
	                          <div align="center" style="margin:20px 0px 20px 0px">
	                          <img src="/imagenes/inicio/cuentaCreada.gif" alt="Felicitaciones! Ya sos usuario de Tematika.com" width="224" height="40" />

	                          <p>
	                           <span class="btnContinuar" style="margin-left:90px;">
	                           Para continuar hace click <a href="<%=redirect%>" style="font-size:12px;color:#000000;">aqui</a>
	                           </span>
	                          </div></td>
	                        </tr>
	                        <tr>
	                          <td valign="bottom" class="FTtit01">
	                          <div id="registroExtraBack">
	                          <div id="registroExtraTxt1">¿Querés formar parte de nuestro programa de beneficios?</div>
	                          <div id="registroExtraTxt2">
	                          		Ahora con eXtra!, la nueva tarjeta gratuita para clientes de Tematika.com, Yenny y El Ateneo, cada vez que nos elegís, acumulás puntos y obtenés descuentos y beneficios sorprendentes.
	                          		Porque con eXtra! sumás puntos y multiplicás premios. <a href="/fidelizacion/panel/index.jsp" target="_blank" class="Flink02">M&aacute;s informaci&oacute;n...</a>
	                          </div>
	                          <div id="registroExtraFin">
	                            <a href="/miCuenta/registroSocioEXtra.jsp"><img src="/imagenes/inicio/b-ingresarExtra.gif" alt="Empezar a sumar puntos!" border="0" /></a> </div>
	                          </div>
	                          <div id="referido">
	                          	<div id="registroExtraTxt1">
		                          	Has sido identificado como usuario referido, para participar de los beneficios haz click <a href="/miCuenta/registroSocioCadena.jsp" class="Flink02">aqu&iacute;</a>
	                          	</div>
	                          </div>
	                          </div>
	                          </td>
	                        </tr>
	                    </table>
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
--%>


<div style="margin-top: 10px;">	
	<div class="compraWrapper2"><!--  style="background-color: #FBF5EF">-->
		<div class="cProcTit" style="margin-top: 0pt;"><span>Mis datos personales</span></div>
			<div class="cProcFor-wrapper2 cProcForms2" id="divMensaje" style="border:1px dashed #FF070F;color:red;display:none;padding:4px 4px 4px 25px;">
            	<b style="margin-bottom: 0pt;">&nbsp;</b>
            	<div style="margin-bottom: 0pt;text-align:center;" >
            	
            	</div>			            
     		</div>    
			<form metho="POST"  name="frmRegistro" id="frmRegistro" onSubmit="return false">
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;"><label style="color:#FF0000;">*&nbsp;</label>Nombres</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="text" style="width: 150px;" name="nombres" >
		            	</span>
		            </div>
		        </div>		        
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;"><label style="color:#FF0000;">*&nbsp;</label>Apellidos</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="text" style="width: 150px;" name="apellidos" >
		            	</span>
		            </div>
		        </div>
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;"><label style="color:#FF0000;">*&nbsp;</label>Direccion de e-Mail</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="text" style="width: 150px;" name="email" value="<%=request.getParameter("LOGIN")%>">
		            	</span>
		            </div>
		        </div>
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;"><label style="color:#FF0000;">*&nbsp;</label>Clave de acceso</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="password" style="width: 150px;" name="password" >
		            	</span>
		            </div>
		        </div>
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;"><label style="color:#FF0000;">*&nbsp;</label>Repetir clave de acceso</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="password" style="width: 150px;" name="rePassword" >
		            	</span>
		            </div>
		        </div>		        
		        <!-- 
		        <div class="cProcFor-wrapper2 cProcForms2" id="referido">
            		<b style="margin-bottom: 0pt;">&nbsp;</b>
            		<div style="margin-bottom: 0pt;text-align:center;">
            			Has sido identificado como usuario referido, para participar de los beneficios haz click <a href="/miCuenta/registroSocioCadena.jsp" class="Flink02">aqu&iacute;</a>
            		</div>			            
     			</div>
     			-->    
		        <a class="cProcForButton vPrevButt" style="text-align:center;cursor:pointer;" id="btnRegistrar" onclick="registrarSocioTMK();">Ingresar</a>
		</form>
		<div class="cProcFor-wrapper2 cProcForms2" style="background-color: #F8ECE0;">
	            <div style="margin-bottom: 0pt;">
	            	<span style="margin-right: 10px;font-size:11px;">
						Disposición (Dirección Nacional de Protección de Datos Personales) 10/2008<p>
						<p>"El titular de los datos personales tiene la facultad de ejercer el derecho de acceso a los mismos en forma gratuita a intervalos no inferiores a seis meses, salvo que se acredite un interés legítimo al efecto conforme lo establecido en el artículo 14, inciso 3 de la Ley Nº 25.326"</p>
						<p>"La DIRECCION NACIONAL DE PROTECCION DE DATOS PERSONALES, órgano de control de la Ley Nº 25.326, tiene la atribución de atender las denuncias y reclamos que se interpongan con relación al incumplimiento de las normas sobre protección de datos personales".<p>
	            	</span>
	            </div>			            
      		</div>		 
	</div>
</div>

<script languaje="javascript">
	document.frmRegistro.nombres.focus();
</script>