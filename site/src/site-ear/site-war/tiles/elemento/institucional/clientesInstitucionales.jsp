<%@ page import="com.tmk.controllers.institucional.ClientesInstitucionalesHelper,
				com.tmk.kernel.Globals"
%>
<script type="text/JavaScript">
<!--
function max(txarea)
{
	total = 500;
	tam = txarea.value.length;
	str="";
	str=str+tam;
	Digitado.innerHTML = str;
	Restante.innerHTML = total - str;
		if (tam > total){
			aux = txarea.value;
			txarea.value = aux.substring(0,total);
			Digitado.innerHTML = total
			Restante.innerHTML = 0
		}
	}

function validarForm(f){
		var msg = "No has ingresado datos en un campo obligatorio. Por favor, completalo. "
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_RAZON_SOCIAL%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_RAZON_SOCIAL%>.focus();
			alert(msg);
			return;
		}
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_DIRECCION%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_DIRECCION%>.focus();
			alert(msg);
			return;
		}
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_CIUDAD%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_CIUDAD%>.focus();
			alert(msg);
			return;
		}
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_PROVINCIA%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_PROVINCIA%>.focus();
			alert(msg);
			return;
		}
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_PAIS%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_PAIS%>.focus();
			alert(msg);
			return;
		}
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_CODIGO_POSTAL%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_CODIGO_POSTAL%>.focus();
			alert(msg);
			return;
		}
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_TEL%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_TEL%>.focus();
			alert(msg);
			return;
		}
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_NOMBRE%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_NOMBRE%>.focus();
			alert(msg);
			return;
		}
		if (f.<%= ClientesInstitucionalesHelper.CAMPO_MAIL%>.value=='') {
			f.<%= ClientesInstitucionalesHelper.CAMPO_MAIL%>.focus();
			alert(msg);
			return;
		}
		f.submit();
}

//-->
</script>
		<table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
		<td>
			<table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-vcorporativas.gif" alt="Ventas Corporativas" width="153" height="12" /></td>
                  </tr>

                  <tr>
                  <form method="post" action="/ClientesInstitucionales?" name="form1">
               	<td class="moduloayuda">
               	<object style="margin:0px" width="385" height="322"><param name="movie" value="http://static.slidesharecdn.com/swf/ssplayer2.swf?doc=pres-090720102004-phpapp02&stripped_title=pres-1744170" /><param name="allowFullScreen" value="true"/><param name="allowScriptAccess" value="always"/><embed src="http://static.slidesharecdn.com/swf/ssplayer2.swf?doc=pres-090720102004-phpapp02&stripped_title=pres-1744170" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="385" height="322"></embed></object><br/>

<br/>

<div class="Ftexto02">

<p><span class="FTtit01">NUESTRA FORTALEZA </span><br />

                       Ofrecemos soluciones a medida a necesidades de regalos, incentivos, planes de capacitaci&oacute;n, cat&aacute;logos de premios, y licitaciones con art&iacute;culos culturales y de entretenimiento de un alto valor percibido. Respondemos eficientemente en proyectos que involucren log&iacute;stica de distribuci&oacute;n de alcance nacional e internacional. </p>

                         <p><span class="FTtit01">ORDENES DE COMPRA</span> <br />

                        Nuestros Cheques Obsequio operan como efectivo. Nuestros clientes fijan los rangos de valor y volumen que desean adquirir. </p>

                         </p><span class="FTtit01">EVENTOS </span><br />

                        Nuestras Sucursales El Ateneo Grand Splendid y Florida 340 cuentan con espacios especialmente dise&ntilde;ados para la realizaci&oacute;n de eventos empresariales. Proveemos este espacio a las empresas clientes de nuestros productos.</p>

                      <p><span class="FTtit01">BENEFICIOS PARA PERSONAL </span><br />

                        Mediante nuestros Canales Alternativos, ofrecemos a las empresas clientes que su personal acceda a descuentos y beneficios comprando por Tematika.com o por nuestro 0810-33-EXTRA </p>

                      <p><span class="FTtit01">PRINCIPALES CLIENTES </span><br />

                       Acindar, American Express, Arcor, Aventis Pharma, BNP Parib&aacute;s, Claro, Cotagro, Edenor, Faena Group, Hewlett Packard, Hotel Hyatt, Kodak, Laboratorios Roemmers, Nobleza Piccardo, Osde, Parque de la Costa, Pragma FCB, Procter &amp; Gamble, Rosario S.A., Santander R&iacute;o, Techint, Telecom, Telef&eacute;, Telef&oacute;nica de Argentina, UCA (Universidad Cat&oacute;lica Argentina), YPF.<br />

                        <br />

                      Por favor, complete sus datos en este formulario para que podamos contactarnos con usted.

                      Recuerde que los campos con (<span class="Ftextorojo">*</span>) son obligatorios.</p>

                    </div>

                      <table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="123" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Razon Social: </td>
                            <td width="243"><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_RAZON_SOCIAL %>"  type="text" class="ayudatext" />
                              </div></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Nombre de fantasia: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_NOMBRE_FANTASIA %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Direcci&oacute;n: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_DIRECCION %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Ciudad: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_CIUDAD %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Provincia: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_PROVINCIA %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Pa&iacute;s: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_PAIS %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> C&oacute;digo postal: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_CODIGO_POSTAL %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Tel: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_TEL %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>

                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Fax: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_FAX %>" type="text" class="ayudatext" />
                              </div></td>
                      </tr>

                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Url de Instituci&oacute;n: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_URL %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td height="30" valign="bottom"><div align="left"><span class="FTtit01">CONTACTO:</span><span class="Ftexto02"></span></div></td>
                            <td>&nbsp;</td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Nombres y Apellido: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_NOMBRE %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Correo electr&oacute;nico: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_MAIL %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Tel&eacute;fono: </td>
                            <td><div align="left">
                              <input name="<%= ClientesInstitucionalesHelper.CAMPO_TELEFONO %>" type="text" class="ayudatext" />
                              </div></td>
                          </tr>
                      <tr>
                        <td height="25" valign="bottom"><div align="left"><span class="Ftexto02"><span class="Ftextorojo">&nbsp;&nbsp;</span> Comentarios: </span></div></td>
                            <td rowspan="2"><textarea name="<%= ClientesInstitucionalesHelper.CAMPO_COMENTARIO %>" class="ayudatextarea"></textarea></td>
                          </tr>
                      <tr>
                        <td height="75">&nbsp;</td>
                      </tr>
                      <tr>
                      <td>&nbsp;</td><td><div align="right"><a href="javascript:validarForm(document.form1)"><br><img src="/imagenes/inicio/b-enviar.gif" alt="Enviar" width="47" height="9" border="0" class="benviar"/></a></div></td>
                      </tr>
                  	  </table>

                  </td>
                  </form>
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
            </table></td>
            <td class="Gbarraderecha" width="155">
    	          <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
            </table></td>
          </tr>
