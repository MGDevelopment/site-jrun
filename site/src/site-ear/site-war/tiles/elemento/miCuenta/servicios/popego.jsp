<%@page import="com.tmk.bus.socio.SociosIntegracion"%>
<%
	SociosIntegracion sociosIntegracion = (SociosIntegracion)request.getAttribute("socioIntegracion");
	boolean esSocioTMK = Convert.toBoolean((Boolean)session.getAttribute("socioTMK"), false);
%>


<%@page import="com.tmk.kernel.Convert"%>
<script language="javascript">
	var esPrimeraVes =true;
	var estado = false;
</script>
<script type="text/javascript" src="/js/popego.js"></script>
<script type="text/javascript" src="https://secure.popego.com/assets/javascripts/popego-core.js"></script>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
			<div class="cProcTit" style="margin-top: 0pt;"><span>Popego:</span></div>
				<div class="cProcFor-wrapper2 cProcForms2" id="divMensajes" style="border:1px dashed #FF070F;color:red;display:none;padding:4px 4px 4px 25px;">
	            	<p style="margin-bottom: 0pt;font-weight: bold;">&nbsp;</p>
	            	<div style="margin-bottom: 0pt;text-align:center;" >
	            	
	            	</div>			            
	     		</div>
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <p style="margin-bottom: 0pt;"></p>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		Ahora podés asociar el servicio de Popego a tu cuenta de Tematika. <a href="/miCuenta/servicios/servicioPopego.jsp" target="_blank" class="FAyuda">(¿Qu&eacute; es popego?)</a>
		            	</span>
		            </div>
		        </div>	        			            	     		
		        
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;width:100px;">
		            	<img src="/imagenes/popego_favicon.png" width="27px" height="27px">
		            </b>
		            <div style="margin-bottom: 0pt;width:200px;" id="lblusername"  >
		            	<%=(sociosIntegracion != null) ? sociosIntegracion.getIdentificador() : ""%>
		        	</div>
		        	<% if(esSocioTMK) { %>
		        		Para asociarte ten&eacute;s que completar los datos adicionales de tu cuenta de tematika.<br>
		        		hace click <a href="/miCuenta/registroSocioCadena.jsp">acá</a> para completarlos.  
                   	<% }else { %>
                   		<a class="cProcForButton vPrevButt" style="text-align:center;" id="lnkpopego" href="javascript:limpirarResultado();"><%=(sociosIntegracion!=null ? "Modificar!" : "Asociate!")%>!!!</a>
						<a class="cProcForButton vPrevButt" style="text-align:center;display:none;" id="lnkCancelar" href="javascript:cancelar();">Cancelar!!!</a>
                   	<% } %>
		        </div>
		        <% if(!esSocioTMK) { %>
			        <div class="cProcFor-wrapper2 cProcForms2" style="border-bottom:none">
			            <b style="margin-bottom: 0pt;width:120px;">&nbsp;</b>
			            <div style="margin-bottom: 0pt;" id="divPopego">
			            		<label id="txtMensaje" class="Ftexto02">&nbsp;</label>
							    <div id="iframe_container"></div>
							    <div id="result" class=""></div>
			            </div>
			            <input type="hidden" value="null" id="username" name="username">		        
			        </div>
			        <div class="cProcFor-wrapper2 cProcForms2">
			            <div style="margin-bottom: 0pt;" id="divPopego">
			            	<a class="cProcForButton vPrevButt" style="text-align:center;display:none;" id="divBntContinuar" href="javascript:integrarSocio();">Continuar!</a>
			            </div>
			        </div>
			        <div class="cProcFor-wrapper2 cProcForms2">
			            <b style="margin-bottom: 0pt;"></b>
			            <div style="margin-bottom: 0pt;">
			            	<span style="margin-right: 10px;">
			            		Si ya sos usuario de Popego, sólo tenés que loguearte. <p>Si querés registrarte en Popego, también podés agregar a Tematika como servicio en sus opciones.
								<a href="http://www.popego.com" target="_blank" class="FAyuda">registrate en popego!!!</a>
			            	</span>
			            </div>
		        	</div>
			     <% } %>
		        
	</div>
</div>
<script type="text/javascript">
	crearWidgets(estado);
</script>