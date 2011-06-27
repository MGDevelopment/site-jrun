<%--
<%@ page import="com.tmk.kernel.Globals,
com.tmk.kernel.Convert" %>
<% String LOGIN = Convert.toString(request.getParameter("LOGIN"), ""); %>

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
               <jsp:include page="/miCuenta/left.jsp"/>
              <tr>
                  <%
           		String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + Globals.SECCION_HOME;
           	   %>
                <jsp:include page="<%=urlInstitucionalLeft%>"/>
              </tr>
            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>
                  <tr>
                  <form name="formRegistrarse" action="/RecuperarClave" method="post">
					<input type="hidden" name="_DISPATCHER" value="/miCuenta/claveEnviada.jsp">

                    <td class="moduloayuda">
                    <table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td valign="bottom" style="padding-bottom:10px; text-align:left">

							<%
							String feedback = (String)session.getAttribute("Registracion.feedback");

							if(feedback != null)
							{
								session.removeAttribute("Registracion.feedback");
							%>

								<table bgcolor="#FFFFDF;" width="400" align="center" style="border-bottom: 3px solid #FF0000; border-top: 3px solid #FF0000;" cellpadding="4">
									<tr valign="middle">
										<td><img src="/imagenes/miCuenta/baliza.gif"></td>
										<td><div class="FTtit01"><%= feedback %></div></td>
									</tr>
								</table>
							<%
							} else {
							%>
	    	                    <p><span class="FTtit01">POR FAVOR  INGRESE LA MISMA   DIRECCI&Oacute;N DE EMAIL CON LA QUE USTED SE REGISTR&Oacute;,
    	    	                DONDE SER&Aacute; ENVIADA SU CLAVE.</span></p>
        	              <%}%>
                        </td>
                      </tr>

                      <tr>
                        <td valign="bottom" class="Ftexto02"><div align="center">
                          <input name="LOGIN" size="60" value="<%= LOGIN %>" type="text" class="ayudatext" />
                        </div></td>
                      </tr>

                      <tr>
                        <td><div align="right"><a href="javascript:continuar();"><img src="/imagenes/inicio/b-enviar.gif" alt="Enviar" width="47" height="9" border="0" class="benviar2" /></a></div></td>
                        </tr>
                    </table></td>
                    </form>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
              </tr>
            </table></td>
          </tr>

        </table>
--%>

<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.Convert"%>
<%String LOGIN = Convert.toString(request.getParameter("LOGIN"), ""); %>
<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
			<div class="cProcTit" style="margin-top: 0pt;"><span>USUARIOS REGISTRADOS:</span></div>
			<form name="formRegistrarse" action="/RecuperarClave" method="post">
				<input type="hidden" name="_DISPATCHER" value="/miCuenta/claveEnviada.jsp">
		        <div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">Mi E-mail es:</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<input type="text" style="width: 260px;" name="LOGIN" value="<%= LOGIN %>" >
		            	</span>
		            </div>
		        </div>		       
				<div class="cProcFor-wrapper2 cProcForms2">
		            <b style="margin-bottom: 0pt;">&nbsp;</b>
		            <div style="margin-bottom: 0pt;">
		            	<span style="margin-right: 10px;">
		            		<a href="javascript:continuar();">Continuar</a>
		            	</span>
		            </div>
		        </div> 			        	         
	       </form>
	       <div class="cProcFor-wrapper2 cProcForms2" style="border-bottom: none">         		
         		<div style="margin-bottom: 0pt;width:560px;text-align:center">
         			<label class="error" id="divMensajeLogin">
        				<%
						String feedback = (String)session.getAttribute("Registracion.feedback");
						if(feedback != null){
							session.removeAttribute("Registracion.feedback");						
							out.println(feedback); 
						} else {%>
							POR FAVOR  INGRESE LA MISMA   DIRECCI&Oacute;N DE EMAIL CON LA QUE USTED SE REGISTR&Oacute;,
   	    	                DONDE SER&Aacute; ENVIADA SU CLAVE
       	              <%}%>
         			</label>	
     			</div>
     		</div>
	</div>	
</div>

<script type="text/JavaScript">
<!--
	function continuar()
	{
		var form = document.formRegistrarse;

		if(isMail(form.LOGIN.value) == false)
		{
			form.LOGIN.focus();
			alert('El campo e-mail debe ser completado.');
			return;
		}

		form.submit();
	}

//-->
</script>