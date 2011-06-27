<%@ page import="com.tmk.src.socio.SocioPK,
				 com.tmk.util.ShortCuts,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper"%>
<%--
	com.tmk.listaDeseos.ListaDeseosLocal,
	com.tmk.orden.OrdenDAO,
--%>

<%@page import="com.tmk.bus.articulo.ListaDeseos"%>

<%

	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

	ListaDeseos listaDBO = ShortCuts.findListaBySocio(socioPK);
	
	if(listaDBO!=null && listaDBO.getPublica().intValue() == 2)	{
		response.sendRedirect("/listaDeseos/verListaPropia.jsp");
	}
%>
		
<script>
	function validarForm(f) {
		if(isEmpty(f.correos.value)) {
			f.correos.focus();
			alert('Por favor, ingresá el correo del destinatario de tu lista.');
			return false;
		}
		var correos = f.correos.value.split(',');
		for (var i=0; i<correos.length; i++) {
			var correo = trim(correos[i]);
			if (!(isMail(correo))) {
				alert('El correo ' + (i+1) + ' ingresado es invalido.');
				f.correos.focus();
				return false;
			}
		}
		return true;
	}
</script>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>

            <td class="Gcentro" width="422">
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
            	<td>
              <table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  	<tr>
                    	<td width="50" class="titulosceldas"><img src="/imagenes/listaDeseos/t-listadeseos.gif" alt="Lista de deseos" width="172" height="12" /></td>
                  	</tr>
                  	 <tr>
                    <td class="moduloayuda"><table width="370" border="0" cellspacing="0" cellpadding="0">

                        <tr>
                          <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="55" valign="top" class="Ftexto02"><div align="center"><img src="/imagenes/listaDeseos/listadedeseos-header.gif" alt="Lista de deseos" width="210" height="34" /></div></td>
                              </tr>
               <tr>
               <td>
               	<!--principal  -->
	           		<table width="370" border="0" cellspacing="0" cellpadding="0">
                        <form name ="form" action="/EnviarCorreo" method="post" onSubmit = "return validarForm (form)">
                           <tr class="experienciatabla2">
                             <td height="26" valign="bottom" class="Ftexto02"><div align="left">Direcciones de e-mail: </div></td>
                             <td colspan="2" rowspan="2"><div align="left">
                                 <textarea name="correos" class="experienciatextarea"></textarea>
                             </div></td>
                           </tr>
                           <tr class="experienciatabla2">
                             <td height="74" valign="bottom" class="Ftexto02">&nbsp;</td>
                           </tr>
                           <tr>
                             <td height="20" colspan="3" valign="bottom" class="Ftexto02" style="padding-left:23px">&nbsp;</td>
                           </tr>
                           <tr class="experienciatabla2">
                             <td height="26" valign="bottom" class="Ftexto02"><div align="left">Comentarios: </div></td>
                             <td colspan="2" rowspan="2"><div align="left">
                                 <textarea name="mensaje" class="experienciatextarea"></textarea>
                             </div></td>
                           </tr>
                           <tr class="experienciatabla2">
                             <td height="74" valign="bottom" class="Ftexto02">&nbsp;</td>
                           </tr>
                           <tr>
                             <td height="20" colspan="3" valign="top" class="Ftexto02"><div align="right"><br><input type="image" src="/imagenes/listaDeseos/b-enviar.gif" alt="Enviar" width="47" height="9" border="0" class="benviar2" /></div></td>
                           </tr>
                        </form>
                  </table>
            	<!--principal  -->
				</td></tr>

                </table>
              </td>
              </tr>
              </table>
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
        	    </table>
        	</td>
            <td class="Gbarraderecha" width="155">
            <!--BARRRA DERECHA -->
            <table width="155" border="0" cellspacing="0" cellpadding="0">

              <tr>
                <td>
               		<table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
	                  	<tr>
	                    	<td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
			                      <tr>
			                        <td><span class="Ftexto02">ENVIO DE MAILS</span></td>
			                      </tr>
			                      <tr>
			                        <td class="moduloordencelda"><span class="Ftexto02">Ingrese las direcciones de correo electr&oacute;nico a cuales quiere enviarle su lista   de deseo (separadas <br />
			                          con coma) Ejemplo: &quot;amigos@yahoo.com,   compras@hotmail.com&quot;.</span></td>
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
	</div>
</div>