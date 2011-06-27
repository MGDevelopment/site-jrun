<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.controllers.referido.ReferidoManager,
                 com.tmk.kernel.Convert"%>
<%
	SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
	if (socioPK == null) {
		pageContext.forward("/miCuenta/");
	}
    session.removeAttribute("URL_REDIRECT");
%>

<script type="text/javascript">

	function max1(txarea)
	{

		total = 250;
		tam = txarea.value.length;
		str="";
		str=str+tam;
		document.getElementById("Digitado1").innerHTML = str;
		document.getElementById("Restante1").innerHTML = total - str;

		if (tam > total){
			aux = txarea.value;
			txarea.value = aux.substring(0,total);
			document.getElementById("Digitado1").innerHTML = total
			document.getElementById("Restante1").innerHTML = 0
		}
	}

	function max2(txarea)
	{
		total = 250;
		tam = txarea.value.length;
		str="";
		str=str+tam;
		document.getElementById("Digitado2").innerHTML = str;
		document.getElementById("Restante2").innerHTML = total - str;

		if (tam > total){
			aux = txarea.value;
			txarea.value = aux.substring(0,total);
			document.getElementById("Digitado2").innerHTML = total
			document.getElementById("Restante2").innerHTML = 0
		}
	}

	function max3(txarea)
	{
		total = 250;
		tam = txarea.value.length;
		str="";
		str=str+tam;
		document.getElementById("Digitado3").innerHTML = str;
		document.getElementById("Restante3").innerHTML = total - str;

		if (tam > total){
			aux = txarea.value;
			txarea.value = aux.substring(0,total);
			document.getElementById("Digitado3").innerHTML = total
			document.getElementById("Restante3").innerHTML = 0
		}
	}

    function max4(txarea)
	{
		total = 250;
		tam = txarea.value.length;
		str="";
		str=str+tam;
		document.getElementById("Digitado4").innerHTML = str;
		document.getElementById("Restante4").innerHTML = total - str;

		if (tam > total){
			aux = txarea.value;
			txarea.value = aux.substring(0,total);
			document.getElementById("Digitado4").innerHTML = total
			document.getElementById("Restante4").innerHTML = 0
		}
	}

	function max5(txarea)
	{
		total = 250;
		tam = txarea.value.length;
		str="";
		str=str+tam;
		document.getElementById("Digitado5").innerHTML = str;
		document.getElementById("Restante5").innerHTML = total - str;

		if (tam > total){
			aux = txarea.value;
			txarea.value = aux.substring(0,total);
			document.getElementById("Digitado5").innerHTML = total
			document.getElementById("Restante5").innerHTML = 0
		}
	}

	function validarForm (frm) {

    	var ref1, ref2, ref3, ref4, ref5;
	    ref1 = frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO1%>.value;
	    ref2 = frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO2%>.value;
	    ref3 = frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO3%>.value;
	    ref4 = frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO4%>.value;
	    ref5 = frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO5%>.value;
        nom1 = frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO1%>.value;
        nom2 = frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO2%>.value;
        nom3 = frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO3%>.value;
        nom4 = frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO4%>.value;
        nom5 = frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO5%>.value;
		app1 = frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO1%>.value;
        app2 = frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO2%>.value;
        app3 = frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO3%>.value;
        app4 = frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO4%>.value;
        app5 = frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO5%>.value;


		if (ref1 == ''){
	        alert('Por favor, completa el campo e-mail.');
			frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO1%>.focus();
			return false;
	    }else {
            if (nom1 == '') {
				alert('Por favor, completá el campo Nombre.');
				frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO1%>.focus();
				return false;
			}
			if (app1 == '') {
				alert('Por favor, completá el campo Apellido.');
				frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO1%>.focus();
				return false;
			}
		    if (isMail(ref1) == false) {
				alert('La dirección de correo electrónico 1 no es correcta.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO1%>.focus();
				return false;
	        }
	    }


		if (ref2 != '') {
			if (isMail(ref2) == false) {
				alert('La dirección de correo electrónico 2 no es correcta.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO2%>.focus();
				return false;
	        }
            if (nom2 == '') {
				alert('Por favor, completá el campo Nombre.');
				frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO2%>.focus();
				return false;
			}
			if (app2 == '') {
				alert('Por favor, completá el campo Apellido.');
				frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO2%>.focus();
				return false;
			}
	    }


		if (ref3 !='' ) {
			if (isMail(ref3) == false) {
				alert('La dirección de correo electrónico 3 no es correcta.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO3%>.focus();
				return false;
			}
			if (nom3 == '') {
				alert('Por favor, completá el campo Nombre.');
				frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO3%>.focus();
				return false;
			}
			if (app3 == '') {
				alert('Por favor, completá el campo Apellido.');
				frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO3%>.focus();
				return false;
			}
	    }

	    if (ref4 !='' ) {
			if (isMail(ref4) == false) {
				alert('La dirección de correo electrónico 4 no es correcta.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO4%>.focus();
				return false;
			}
			if (nom4 == '') {
				alert('Por favor, completá el campo Nombre.');
				frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO4%>.focus();
				return false;
			}
			if (app4 == '') {
				alert('Por favor, completá el campo Apellido.');
				frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO4%>.focus();
				return false;
			}
	    }

	    if (ref5 !='' ) {
			if (isMail(ref5) == false) {
				alert('La dirección de correo electrónico 5 no es correcta.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO5%>.focus();
				return false;
			}
			if (nom5 == '') {
				alert('Por favor, completá el campo Nombre.');
				frm.<%=ReferidoManager.CAMPO_NOMBRE_REFERIDO5%>.focus();
				return false;
			}
			if (app5 == '') {
				alert('Por favor, completá el campo Apellido.');
				frm.<%=ReferidoManager.CAMPO_APELLIDO_REFERIDO5%>.focus();
				return false;
			}
	    }


	    if (ref1 == ref2) {
			alert('El campo correo electrónico 1 no puede ser igual al 2.');
			frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO2%>.focus();
			return false;
	    }

	    if (ref1 == ref3) {
			alert('El campo correo electrónico 1 no puede ser igual al 3.');
			frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO3%>.focus();
			return false;
	    }

		if (ref1 == ref4) {
			alert('El campo correo electrónico 1 no puede ser igual al 4.');
			frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO4%>.focus();
			return false;
	    }

		if (ref1 == ref5) {
			alert('El campo correo electrónico 1 no puede ser igual al 5.');
			frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO5%>.focus();
			return false;
	    }


	    if (ref2 != '') {
	        if (ref2 == ref3) {
				alert('El campo correo electrónico 2 no puede ser igual al 3.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO3%>.focus();
				return false;
			}
			if (ref2 == ref4) {
				alert('El campo correo electrónico 2 no puede ser igual al 4.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO4%>.focus();
				return false;
			}
			if (ref2 == ref5) {
				alert('El campo correo electrónico 2 no puede ser igual al 5.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO5%>.focus();
				return false;
			}
	    }

	    if (ref3 != '') {
	        if (ref3 == ref4) {
				alert('El campo correo electrónico 3 no puede ser igual al 4.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO4%>.focus();
				return false;
			}
			if (ref3 == ref5) {
				alert('El campo correo electrónico 3 no puede ser igual al 5.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO5%>.focus();
				return false;
			}
	    }

		if (ref4 != '') {
	        if (ref4 == ref5) {
				alert('El campo correo electrónico 4 no puede ser igual al 5.');
				frm.<%=ReferidoManager.CAMPO_MAIL_REFERIDO5%>.focus();
				return false;
			}
	    }
		//todo bien => hace submit
	    return true;
	}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

</script>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="422" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
          	<%--
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
			<%
			 if (socioPK != null) { %>
				<tr>
					<td valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
            			<tr>
							  <td align="left" class="preguntasceldas"><a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a></td>
		                </tr>
    		        </table></td>
	    	   </tr>
    	   <%}%>
            <jsp:include page="/miCuenta/left.jsp"/>

            </table></td>
            --%>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
                <td><table width="422" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>

                  <tr>
               <form name="form" method="post" action="<%=ReferidoManager.SERVLET%>" onSubmit ="return validarForm(this)">
                    <td class="moduloayuda">
                    <table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0">
						<%
							String msg;
						%>
                          <tr>
                            <td height="20" valign="top"><table width="370" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                                <tr>
                                  <td width="366"><table width="370" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                                      <tr>
                                        <td colspan="3" valign="top" class="FTtit01">REFERIDO 1 </td>
                                      </tr>
                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">E-mail: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO1), "")%>" name="<%= ReferidoManager.CAMPO_MAIL_REFERIDO1%>" size="75" maxlength="100" class="empleotext" />
                                        </div></td>
                                      </tr>
 										<%
											msg = (String)request.getSession().getAttribute(ReferidoManager.SESSION_ERROR_REFERIDO1);
											if (msg != null) {
										%>
                                      <tr>
                                        <td colspan="3" height="28" valign="bottom" class="Ftextorojo"><div align="left"><b><%=msg%></b>
                                        <script>
											   document.form.<%=ReferidoManager.CAMPO_MAIL_REFERIDO1%>.focus();
										</script>
										<%
  										      request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO1, null);
											}
										%>
                                        </div></td>
                                      </tr>

                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">Nombre: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">

                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO1), "")%>" name="<%= ReferidoManager.CAMPO_NOMBRE_REFERIDO1%>" size="50" maxlength="50" class="empleotext" />
                                        </div></td>
                                      </tr>
                                      <tr>
                                        <td valign="bottom" class="Ftexto02"> Apellido: </td>
                                        <td colspan="2"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO1), "")%>" name="<%= ReferidoManager.CAMPO_APELLIDO_REFERIDO1%>" size="50" maxlength="50" class="ayudatext" />
                                        </div></td>

                                      </tr>
                                      <tr>
                                        <td height="25" valign="bottom"><div align="left">Comentarios: </div></td>
                                        <td width="224" rowspan="2"><textarea name="<%= ReferidoManager.CAMPO_COMENTARIO_REFERIDO1%>" class="ayudatextarea" onkeyup="max1(this)" onkeypress="max1(this)"><%= Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO1), "")%></textarea>
                                        	<br>&nbsp;&nbsp;
                                        	<font id="Digitado1" color="red">0</font> Caracteres digitados / Restan <font id="Restante1" color="red">250</font>
                                        </td>
                                      </tr>
                                      <tr>
                                        <td height="75">&nbsp;</td>
                                      </tr>

                                      <tr>
                                        <td colspan="3">&nbsp;</td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td height="20" valign="top"><table width="370" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                                <tr>
                                  <td width="366"><table width="370" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                                      <tr>
                                        <td colspan="3" valign="top" class="FTtit01">REFERIDO 2 </td>
                                      </tr>
                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">E-mail: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO2), "")%>" name="<%= ReferidoManager.CAMPO_MAIL_REFERIDO2%>" size="75"  maxlength="100" class="empleotext" />
                                        </div></td>
                                      </tr>
 										<%
  										    msg = (String)request.getSession().getAttribute(ReferidoManager.SESSION_ERROR_REFERIDO2);
											if (msg != null) {
										%>
                                      <tr>
                                        <td colspan="3" height="28" valign="bottom" class="Ftextorojo"><div align="left"><b><%=msg%></b>
                                        <script>
											   document.form.<%=ReferidoManager.CAMPO_MAIL_REFERIDO2%>.focus();
										</script>
										<%
												request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO2, null);
											}
										%>
                                        </div></td>
                                      </tr>

                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">Nombre: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO2), "")%>" name="<%= ReferidoManager.CAMPO_NOMBRE_REFERIDO2%>" size="50"  maxlength="50" class="empleotext" />
                                        </div></td>
                                      </tr>
                                      <tr>
                                        <td valign="bottom" class="Ftexto02"> Apellido: </td>
                                        <td colspan="2"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO2), "")%>" name="<%= ReferidoManager.CAMPO_APELLIDO_REFERIDO2%>"  size="50"  maxlength="50" class="ayudatext" />
                                        </div></td>

                                      </tr>
                                      <tr>
                                        <td height="25" valign="bottom"><div align="left">Comentarios: </div></td>
                                        <td width="224" rowspan="2"><textarea name="<%= ReferidoManager.CAMPO_COMENTARIO_REFERIDO2%>" class="ayudatextarea" onkeyup="max2(this)" onkeypress="max2(this)"><%= Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO2), "")%></textarea>
                                        	<br>&nbsp;&nbsp;
                                        	<font id="Digitado2" color="red">0</font> Caracteres digitados / Restan <font id="Restante2" color="red">250</font>
                                        </td>
                                      </tr>
                                      <tr>
                                        <td height="75">&nbsp;</td>
                                      </tr>

                                      <tr>
                                        <td colspan="3">&nbsp;</td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td height="20" valign="top"><table width="370" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                                <tr>
                                  <td width="366"><table width="370" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                                      <tr>
                                        <td colspan="3" valign="top" class="FTtit01">REFERIDO 3 </td>
                                      </tr>
                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">E-mail: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO3), "")%>" name="<%= ReferidoManager.CAMPO_MAIL_REFERIDO3%>"  size="75"  maxlength="100" class="empleotext" />
                                        </div></td>
                                      </tr>
 										<%
 										    msg = (String)request.getSession().getAttribute(ReferidoManager.SESSION_ERROR_REFERIDO3);
											if (msg != null) {
										%>
                                      <tr>
                                        <td colspan="3" height="28" valign="bottom" class="Ftextorojo"><div align="left"><b><%=msg%></b>
                                        <script>
											   document.form.<%=ReferidoManager.CAMPO_MAIL_REFERIDO3%>.focus();
										</script>
										<%
											   request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO3, null);
											}
										%>
                                        </div></td>
                                      </tr>

                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">Nombre: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">

                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO3), "")%>" name="<%= ReferidoManager.CAMPO_NOMBRE_REFERIDO3%>"  size="50"  maxlength="50" class="empleotext" />
                                        </div></td>
                                      </tr>
                                      <tr>
                                        <td valign="bottom" class="Ftexto02"> Apellido: </td>
                                        <td colspan="2"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO3), "")%>" name="<%= ReferidoManager.CAMPO_APELLIDO_REFERIDO3%>"  size ="50"  maxlength="50" class="ayudatext" />
                                        </div></td>

                                      </tr>
                                      <tr>
                                        <td height="25" valign="bottom"><div align="left">Comentarios: </div></td>
                                        <td width="224" rowspan="2"><textarea name="<%= ReferidoManager.CAMPO_COMENTARIO_REFERIDO3%>" class="ayudatextarea" onkeyup="max3(this)" onkeypress="max3(this)"><%= Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO3), "")%></textarea>
                                        	<br>&nbsp;&nbsp;
                                        	<font id="Digitado3" color="red">0</font> Caracteres digitados / Restan <font id="Restante3" color="red">250</font>
                                        </td>
                                      </tr>
                                      <tr>
                                        <td height="75">&nbsp;</td>
                                      </tr>

                                      <tr>
                                        <td colspan="3">&nbsp;</td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td height="20" valign="top"><table width="370" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                                <tr>
                                  <td width="366"><table width="370" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                                      <tr>
                                        <td colspan="3" valign="top" class="FTtit01">REFERIDO 4 </td>
                                      </tr>
                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">E-mail: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO4), "")%>" name="<%= ReferidoManager.CAMPO_MAIL_REFERIDO4%>"  size="75"  maxlength="100" class="empleotext" />
                                        </div></td>
                                      </tr>
 										<%
 										    msg = (String)request.getSession().getAttribute(ReferidoManager.SESSION_ERROR_REFERIDO4);
											if (msg != null) {
										%>
                                      <tr>
                                        <td colspan="3" height="28" valign="bottom" class="Ftextorojo"><div align="left"><b><%=msg%></b>
                                        <script>
											   document.form.<%=ReferidoManager.CAMPO_MAIL_REFERIDO4%>.focus();
										</script>
										<%
										       request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO4, null);
											}
										%>
                                        </div></td>
                                      </tr>

                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">Nombre: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO4), "")%>" name="<%= ReferidoManager.CAMPO_NOMBRE_REFERIDO4%>"  size="50"  maxlength="50" class="empleotext" />
                                        </div></td>
                                      </tr>
                                      <tr>
                                        <td valign="bottom" class="Ftexto02"> Apellido: </td>
                                        <td colspan="2"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO4), "")%>" name="<%= ReferidoManager.CAMPO_APELLIDO_REFERIDO4%>"  size="50"  maxlength="50" class="ayudatext" />
                                        </div></td>

                                      </tr>
                                      <tr>
                                        <td height="25" valign="bottom"><div align="left">Comentarios: </div></td>
                                        <td width="224" rowspan="2"><textarea name="<%= ReferidoManager.CAMPO_COMENTARIO_REFERIDO4%>"  class="ayudatextarea" onkeyup="max4(this)" onkeypress="max4(this)"><%= Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO4), "")%></textarea>
                                        	<br>&nbsp;&nbsp;
                                        	<font id="Digitado4" color="red">0</font> Caracteres digitados / Restan <font id="Restante4" color="red">250</font>
                                        </td>
                                      </tr>
                                      <tr>
                                        <td height="75">&nbsp;</td>
                                      </tr>

                                      <tr>
                                        <td colspan="3">&nbsp;</td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td height="20" valign="top"><table width="370" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                                <tr>
                                  <td width="366"><table width="370" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                                      <tr>
                                        <td colspan="3" valign="top" class="FTtit01">REFERIDO 5 </td>
                                      </tr>
                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">E-mail: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_MAIL_REFERIDO5), "")%>" name="<%= ReferidoManager.CAMPO_MAIL_REFERIDO5%>"  size="75"  maxlength="100" class="empleotext" />
                                        </div></td>
                                      </tr>
 										<%
	 										msg = (String)request.getSession().getAttribute(ReferidoManager.SESSION_ERROR_REFERIDO5);
											if (msg != null) {
										%>
                                      <tr>
                                        <td colspan="3" height="28" valign="bottom" class="Ftextorojo"><div align="left"><b><%=msg%></b>
                                        <script>
											   document.form.<%=ReferidoManager.CAMPO_MAIL_REFERIDO5%>.focus();
										</script>
										<%
											request.getSession().setAttribute(ReferidoManager.SESSION_ERROR_REFERIDO5, null);
											}
										%>
                                        </div></td>
                                      </tr>

                                      <tr>
                                        <td height="28" valign="bottom" class="Ftexto02">Nombre: </td>
                                        <td height="28" colspan="2" valign="bottom"><div align="left">

                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_NOMBRE_REFERIDO5), "")%>" name="<%= ReferidoManager.CAMPO_NOMBRE_REFERIDO5%>"  size="50"  maxlength="50" class="empleotext" />
                                        </div></td>
                                      </tr>
                                      <tr>
                                        <td valign="bottom" class="Ftexto02"> Apellido: </td>
                                        <td colspan="2"><div align="left">
                                            <input type="text" value="<%=Convert.toString(request.getParameter(ReferidoManager.CAMPO_APELLIDO_REFERIDO5), "")%>" name="<%= ReferidoManager.CAMPO_APELLIDO_REFERIDO5%>"  size="50"  maxlength="50" class="ayudatext" />
                                        </div></td>

                                      </tr>
                                      <tr>
                                        <td height="25" valign="bottom"><div align="left">Comentarios: </div></td>
                                        <td width="224" rowspan="2"><textarea name="<%= ReferidoManager.CAMPO_COMENTARIO_REFERIDO5%>" class="ayudatextarea" onkeyup="max5(this)" onkeypress="max5(this)"><%= Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO5), "")%></textarea>
                                        	<br>&nbsp;&nbsp;
                                        	<font id="Digitado5" color="red">0</font> Caracteres digitados / Restan <font id="Restante5" color="red">250</font>
                                        </td>
                                      </tr>
                                      <tr>
                                        <td height="75">&nbsp;</td>
                                      </tr>

                                      <tr>
                                        <td colspan="3">&nbsp;</td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                        </table></td>

                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><div align="right"><input type="image" src="/imagenes/miCuenta/b-enviar.gif" alt="Enviar"  border="0" class="benviar2" border="0"></div></td>
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
            
            <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
                  <tr>
                    <td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="Ftexto02">Ingrese el correo electr&oacute;nico, nombre, apellido de cada uno de sus referidos   y un comentario. Cada una de las personas recibir&aacute; en su correo una invitaci&oacute;n a   Tematika.com para participar del programa de referidos.</td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>

              <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
   		      <jsp:include page="<%=urlInstitucionalRight%>"/>

            </table></td>
            
          </tr>
        </table>
	</div>
</div>

<script>
	max1(document.form.<%=ReferidoManager.CAMPO_COMENTARIO_REFERIDO1%>)
	;max2(document.form.<%=ReferidoManager.CAMPO_COMENTARIO_REFERIDO2%>);max3(document.form.<%=ReferidoManager.CAMPO_COMENTARIO_REFERIDO3%>);
	max4(document.form.<%=ReferidoManager.CAMPO_COMENTARIO_REFERIDO4%>);max5(document.form.<%=ReferidoManager.CAMPO_COMENTARIO_REFERIDO5%>);
	document.form.<%=ReferidoManager.CAMPO_MAIL_REFERIDO1%>.focus();
</script>

