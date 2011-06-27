<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.*,
                 java.sql.Timestamp,
                 com.tmk.controllers.MainHelper" %>

<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
  	if (socioPK == null) {
  		response.sendRedirect("/miCuenta/");
	  	return;
	}
	String redirect = Convert.toString((String)session.getAttribute(MainHelper.URL_REDIRECT), "/");
	boolean esReferido = Convert.toBoolean(request.getParameter("esReferido"), false);
%>
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
				  		<table width="366" border="0" cellspacing="0" cellpadding="0">
	                        <tr>
	                          <td valign="bottom" class="Ftexto02">
	                          	<div align="center" style="margin:20px 0px 20px 0px">
		                          <img src="/imagenes/inicio/cuentaCreada.gif" alt="Felicitaciones! Ya sos usuario de Tematika.com" width="224" height="62" />
		                          <p>
	    		                       <span class="btnContinuar" style="margin-left:90px;">
	            			               Para continuar hace click <a href="<%=redirect%>" style="font-size:12px;color:#000000;">aqui</a>
	                        		   </span>
	                          	</div>
	                          </td>
	                        </tr>
	                        <tr>
	                          <td valign="bottom" class="FTtit01">
	                        	  <div id="registroExtraBack">
		                              <div id="registroExtraTxt1">¿Querés formar parte de nuestro programa de beneficios?
		                              </div>
	                          	 	  <div id="registroExtraTxt2">
	                          			  Ahora con eXtra!, la nueva tarjeta gratuita para clientes de Tematika.com, Yenny y El Ateneo, cada vez que nos elegís, acumulás puntos y obtenés descuentos y beneficios sorprendentes.
	                          			  Porque con eXtra! sumás puntos y multiplicás premios. <a href="/extra/index.jsp?seccionEXtra=1" target="_blank" class="Flink02">M&aacute;s informaci&oacute;n...</a>
			                          </div>
				                      <div id="registroExtraFin">
	    		  		              	  <a href="/miCuenta/registroSocioEXtra.jsp"><img src="/imagenes/inicio/b-ingresarExtra.gif" alt="Empezar a sumar puntos!" border="0" /></a> </div>
	        	        		      </div>
	            	            	  <%if (esReferido) { %>
	                	          	      <div id="registroExtraTxt1">
			  		                          Has sido identificado como usuario referido, para participar de los beneficios haz click <a href="/miCuenta/registroSocioCadena.jsp" class="Flink02">aqu&iacute;</a>
			 	                          </div>
									  <%}%>
	                          	 </div>
	                          </td>
	                        </tr>
	                    </table>
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
		<div class="cProcTit" style="margin-top: 0pt;"><span>Mi Cuenta- Tematika</span></div>
			<div class="cProcFor-wrapper2 cProcForms2" id="divMensaje" style="border:1px dashed #FF070F;color:red;display:none;padding:4px 4px 4px 25px;">
            	<b style="margin-bottom: 0pt;">&nbsp;</b>
            	<div style="margin-bottom: 0pt;text-align:center;" >
            	
            	</div>			            
     		</div>    
	         
	        <div class="cProcFor-wrapper2 cProcForms2" id="referido">
           		<b style="margin-bottom: 0pt;">&nbsp;</b>
           		<div style="margin-bottom: 0pt;text-align:center;">
           			<img height="62" width="224" alt="Felicitaciones! Ya sos usuario de Tematika.com" src="/imagenes/inicio/cuentaCreada.gif">
           			<br><br>
           			Para continuar hace click <a href="<%=redirect%>" style="font-size:12px;color:#000000;">aqui</a>
           		</div>           					            
    		</div>
    		<div class="cProcFor-wrapper2 cProcForms2" id="referido">
           		<p style="margin-bottom: 0pt; width: 450px;font-weight: bold;">¿Querés formar parte de nuestro programa de beneficios?</p>
           		<div style="margin-bottom: 0pt;text-align:left;">
           			Ahora con eXtra!, la nueva tarjeta gratuita para clientes de Tematika.com, Yenny y El Ateneo, cada vez que nos elegís, acumulás puntos y obtenés descuentos y beneficios sorprendentes.
	                Porque con eXtra! sumás puntos y multiplicás premios. <a href="/extra/index.jsp?seccionEXtra=1" target="_blank">M&aacute;s informaci&oacute;n...</a>
           		</div>			            
    		</div>
    		<!--
    		<div class="cProcFor-wrapper2 cProcForms2" id="referido">
           		<b style="margin-bottom: 0pt; width: 250px;">&nbsp;</b>
           		<div style="margin-bottom: 0pt;text-align:cente;">
           			<a href="/miCuenta/registroSocioEXtra.jsp"><img src="/imagenes/inicio/b-ingresarExtra.gif" alt="Empezar a sumar puntos!" border="0" /></a> 
           		</div>
           	</div>
           	-->
           	<%if (esReferido) { %>
		        <div class="cProcFor-wrapper2 cProcForms2" id="referido">
	           		<b style="margin-bottom: 0pt;">&nbsp;</b>
	           		<div style="margin-bottom: 0pt;text-align:center;">
	           			Has sido identificado como usuario referido, para participar de los beneficios haz click <a href="/miCuenta/registroSocioCadena.jsp" class="Flink02">aqu&iacute;</a>
	           		</div>			            
	    		</div>        	          	      
			<%}%>    		    
	        <!--<a class="cProcForButton vPrevButt" style="text-align:center;cursor:pointer;" id="btnRegistrar" onclick="registrarSocioTMK();">Ingresar</a>-->
	</div>
</div>

<%if (Globals.esModoRelease()){ %>
<!-- Tag for Activity Group: Tematika website, Activity: Tematika Boton envio Registro co -->

<!-- Start of DoubleClick Spotlight Tag: Please do not remove-->
<!-- Activity Name for this tag is:Tematika Boton envio Registro co -->
<!-- Web site URL where tag should be placed: https://www.tematika.com/miCuenta/crearCuenta.jsp -->
<!-- Creation Date:12/29/2006 -->
<SCRIPT language="JavaScript">
var axel = Math.random()+"";
var a = axel * 10000000000000;
document.write('<IMG SRC="https://ad.doubleclick.net/activity;src=1364770;type=tematsit;cat=tematb03;ord='+ a + '?" WIDTH=1 HEIGHT=1 BORDER=0>');
</SCRIPT>
<NOSCRIPT>
<IMG SRC="https://ad.doubleclick.net/activity;src=1364770;type=tematsit;cat=tematb03;ord=1?" WIDTH=1 HEIGHT=1 BORDER=0>
</NOSCRIPT>
<!-- End of DoubleClick Spotlight Tag: Please do not remove-->
<%} %>
<%=Globals.getGoogleAnalyticsSSL()%>