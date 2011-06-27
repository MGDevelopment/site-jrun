<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.*,
                 com.tmk.kernel.Globals" %>
<%
    String LOGIN = Convert.toString(request.getParameter("LOGIN"), "");
  
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	if(socioPK != null){
%>
		<tiles:insert definition="seccion.micuenta.modificar">
<%
	}
%>
<%--
	<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td class="Gbarraizquierda"width="139">
	            <table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
					<%if (socioPK != null) {%>
						<tr>
							<td valign="top">
								<table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
			            			<tr>
										<td align="left" class="preguntasceldas">
										<form name ="terminar" action="/TerminarSesion" name="terminar">
											<a onclick="javascript:document.terminar.submit" class="FAyuda">DESCONECTARSE</a>
										</form>
										</td>
					                </tr>
			    		        </table>
		    		        </td>
			    	   </tr>
		    	   <%}%>
					<!-- **** MENU IZQUIERDO**** -->
		            <jsp:include page="/miCuenta/left.jsp"/>
	            </table>
			</td>

            <%if(socioPK == null) {%>

            <td class="Gcentro" width="422">
            	 <%
            	 	StringBuffer pageLogin = new StringBuffer();
            	 	pageLogin.append("/miCuenta/login.jsp?");
            	 %>
            	 <jsp:include page="<%=pageLogin.toString()%>"/>
            </td>

          <%}%>

            <td class="Gbarraderecha" width="150">
	            <table width="155" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td><!-- **** MENU DERECHO**** -->
		                <table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
		                  <tr>
		                    <td>
		                    	<table border="0" align="center" cellpadding="0" cellspacing="0">
			                        <tr>
			                          <td><span class="Ftexto02"><strong>Si es un usuario nuevo:</strong><br />
			                            Ingrese su e-Mail en el cuadro inferior. <br />
			                            Presione el bot&oacute;n <em>Registrarse</em>.</span></td>
			                        </tr>
			                        <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Si ya tiene su cuenta:</strong><br />
			                            Ingrese su e-Mail en el cuadro superior.
			                            Ingrese su contrase&ntilde;a.<br />
			                            Presione el bot&oacute;n <em>Ingresar</em>. </span></td>
			                        </tr>
			                        <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Actualizar e-Mail:</strong><br />
			                            Ingrese su e-Mail en el primer cuadro.
			                            Haga click en el enlace <em>Actualizar email</em>. </span></td>
			                        </tr>
			                        <tr>
			                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Recuperar Contrase&ntilde;a:</strong><br />
			                            Ingrese su e-Mail en el primer cuadro.
			                            Haga click en el enlace <em>Olvid&eacute; mi contrase&ntilde;a</em>. </span></td>
			                        </tr>
		                    	</table>
		                    </td>
		                  </tr>
		                </table>
		               </td>
	              </tr>
	            </table>
            </td>
          </tr>
    </table>
    --%>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
			<div class="cProcTit" style="margin-top: 0pt;"><span>USUARIOS REGISTRADOS:</span></div>
			<form method="POST" name="frmLogin" id="frmLogin" onSubmit="">
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">Mi E-mail es:</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="text" style="width: 260px;" name="login" onkeypress="javascript:if (presionoEnter(event))validarFormCliente();" >
		            	</span>
		            </div>
		        </div>
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">Mi contraseña es:</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="password" style="width: 260px;" name="password" onkeypress="javascript:if (presionoEnter(event))validarFormCliente();">
		            	</span>
		            </div>
		        </div>
				<div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">&nbsp;</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<a href="javascript:recuperarClave();" onkeypress="javascript:if (presionoEnter(event))recuperarClave;" >Olvidé mi contraseña</a>
		            	</span>
		            </div>
		        </div>
	       		<a class="cProcForButton vPrevButt" style="text-align:center;" href="javascript:validarFormCliente();">Ingresar</a> 			        	         
	       </form>
	       <div class="cProcFor-wrapper2 cProcForms2" style="border-bottom: none">         		
         		<div style="margin-bottom: 0pt;width:560px;text-align:center">
         			<label class="error" id="divMensajeLogin">
         			<%=(request.getAttribute("Registracion.feedback")!=null?request.getAttribute("Registracion.feedback"):"")%>
         			</label>	
     			</div>
     		</div>
	</div>
	<div class="compraWrapper2">
			<div class="cProcTit" style="margin-top: 0pt;"><span>USUARIOS NUEVOS:</span></div>
			<form action="javascript:validarFormClienteNuevo();" metho="POST"  name="frmRegistrar" id="frmRegistrar">
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">Mi E-mail es:</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="text" style="width: 260px;" name="LOGIN" onkeypress="javascript:if (presionoEnter(event))validarFormClienteNuevo();">
		            	</span>
		            </div>
		        </div>

	       		<a class="cProcForButton vPrevButt" style="text-align:center;" href="javascript:validarFormClienteNuevo();">Registrarse</a> 			        	         
	       </form>	       
	</div>
	<div class="compraWrapper2"  style="background-color: #FBF5EF">
			<div class="cProcTit" style="margin-top: 0pt;"><span>AYUDA</span></div>
	        <div class="cProcFor-wrapper2 cProcForms2" style="padding-bottom:1px;">
	            <b style="margin-bottom: 0pt;">Si es un usuario nuevo:</b>
	            <div style="margin-bottom: 0pt;">
	            	<span style="margin-right: 10px;">
	            		Ingrese su e-Mail en el cuadro inferior.
	            		Presione el botón Registrarse.
	            	</span>
	            </div>
	        </div>    
	        <div class="cProcFor-wrapper2 cProcForms2" style="padding-bottom:1px;">
	            <b style="margin-bottom: 0pt;">Si ya tiene su cuenta:</b>
	            <div style="margin-bottom: 0pt;">
	            	<span style="margin-right: 10px;">
						Ingrese su e-Mail en el cuadro superior. <br>
						Ingrese su contraseña.<br>
						Presione el botón <i>Ingresar</i>. 
	            	</span>
	            </div>
	        </div>	        
	        <div class="cProcFor-wrapper2 cProcForms2" style="padding-bottom:1px;">
	            <b style="margin-bottom: 0pt;">Recuperar Contraseña:</b>
	            <div style="margin-bottom: 0pt;">
	            	<span style="margin-right: 10px;">
						Ingrese su e-Mail en el primer cuadro. <br>
						Haga click en el enlace <i>Olvidé mi contraseña.</i> 
	            	</span>
	            </div>
	        </div>
	</div>
</div>
 
 
<%if (Globals.esModoRelease()){ %>
<!-- Tag for Activity Group: Tematika website, Activity: Tematicka ingresar a Mi Cuenta -->

<!-- Start of DoubleClick Spotlight Tag: Please do not remove-->
<!-- Activity Name for this tag is:Tematicka ingresar a Mi Cuenta -->
<!-- Web site URL where tag should be placed: https://www.tematika.com/miCuenta/ -->
<!-- Creation Date:12/29/2006 -->
<SCRIPT language="JavaScript">
var axel = Math.random()+"";
var a = axel * 10000000000000;
document.write('<IMG SRC="https://ad.doubleclick.net/activity;src=1364770;type=tematsit;cat=temati02;ord='+ a + '?" WIDTH=1 HEIGHT=1 BORDER=0>');
</SCRIPT>
<NOSCRIPT>
<IMG SRC="https://ad.doubleclick.net/activity;src=1364770;type=tematsit;cat=temati02;ord=1?" WIDTH=1 HEIGHT=1 BORDER=0>
</NOSCRIPT>
<!-- End of DoubleClick Spotlight Tag: Please do not remove-->
<%} %>
<%=Globals.getGoogleAnalyticsSSL()%>