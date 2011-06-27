<%@ page import="com.tmk.controllers.promo.CuponRespuestasHelper,
                 com.tmk.kernel.Globals"%><script type="text/javascript">
	function max(txarea, orden)
	{

		total = 150;
		tam = txarea.value.length;
		str="";
		str=str+tam;
		eval('Digitado' + orden + '.innerHTML = str;');
		eval('Restante' + orden + '.innerHTML = total - str;');

		if (tam > total){
			aux = txarea.value;
			txarea.value = aux.substring(0,total);
			eval('Digitado' + orden + '.innerHTML = total;');
			eval ('Restante' + orden + '.innerHTML = 0;');
		}
	}

	function validarForm(f) {
		if(f.<%=CuponRespuestasHelper.CAMPO_RESPUESTA1%>.value=='') {
			alert('Debe completar todas las preguntas para participar de la promoción');
			f.<%=CuponRespuestasHelper.CAMPO_RESPUESTA1%>.focus();
			return false;
		}

		if(f.<%=CuponRespuestasHelper.CAMPO_RESPUESTA2%>.value=='') {
			alert('Debe completar todas las preguntas para participar de la promoción');
			f.<%=CuponRespuestasHelper.CAMPO_RESPUESTA2%>.focus();
			return false;
		}

		if(f.<%=CuponRespuestasHelper.CAMPO_RESPUESTA3%>.value=='') {
			alert('Debe completar todas las preguntas para participar de la promoción');
			f.<%=CuponRespuestasHelper.CAMPO_RESPUESTA3%>.focus();
			return false;
		}

		f.submit();
	}




</script>

<div>
	<table width="100%" border="0" align="center" cellpadding=1 cellspacing=0>
		<tr>
			<td style="font-size:5;">
				<br>&nbsp;
			</td>
		</tr>
		<tr>
			<td style="font-size:12" align="center">
				<a style="cursor:hand;" onclick="javascript:window.open('/grupos/interior/Diadelamadre.htm','', 'scrollbars=yes, resizable=yes, width=640, height=500')"><img src="/imagenes/Banner400x100Diadelamadre.jpg" border=0></a>
			</td>
		</tr>

		<tr>
			<td style="font-size:5">
				<br>&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				<i>
					Por cada $50 de compra completá el cupón y participá de sorteos semanales de viajes a Brasil.
				</i>
				<br><b>Usted completará un sólo cupón  y  el sistema generará la cantidad de cupones correspondientes al importe de su compra.</b>
			</td>
		</tr>
		<tr>
			<td style="font-size:3">
				<br>&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				<form name="frmRespuestas" method="post" action ="/AgregarCuponRespuestas">
					<input type="hidden" name="<%=CuponRespuestasHelper.CAMPO_ID_ORDEN%>" value="<%=ordenDAO.getIdOrdenProcesada()%>">
					<input type="hidden" name="<%=CuponRespuestasHelper.CAMPO_TOTAL%>" value="<%=ordenDAO.totalSitioCompleto()%>">
				<table align="center" width="360" border=0>
					<tr>
						<td>
							<b>1. ¿Qué músico es actualmente Ministro de Cultura de Brasil? </b>
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="<%=CuponRespuestasHelper.CAMPO_RESPUESTA1%>" rows="3" cols="66" style="font-size: 9px; font-family: Verdana, Arial, Helvetica, sans-serif;" onkeyup="max(this, 1)" onkeypress="max(this, 1)"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<font id="Digitado1" color="red">0</font> Caracteres digitados / Restan <font id="Restante1" color="red">150</font>
							<br>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<b>2. ¿Cuál es el título del último álbum editado en la Argentina de Caetano Veloso, que incluye canciones en Ingles?</b>
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="<%=CuponRespuestasHelper.CAMPO_RESPUESTA2%>" rows="3" cols="66" style="font-size: 9px; font-family: Verdana, Arial, Helvetica, sans-serif;" onkeyup="max(this, 2)" onkeypress="max(this, 2)"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<font id="Digitado2" color="red">0</font> Caracteres digitados / Restan <font id="Restante2" color="red">150</font>
							<br>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<b>3. ¿Cómo se llama el autor del libro "Doña Flor y sus dos maridos?</b>
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="<%=CuponRespuestasHelper.CAMPO_RESPUESTA3%>" rows="3" cols="66" style="font-size: 9px; font-family: Verdana, Arial, Helvetica, sans-serif;" onkeyup="max(this, 3)" onkeypress="max(this, 3)"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<font id="Digitado3" color="red">0</font> Caracteres digitados / Restan <font id="Restante3" color="red">150</font>
							<br>
							&nbsp;
						</td>
					<tr>
						<td>
							<br>
							<b>Acuerdo Legal.</b>
						</td>
					</tr>
					<tr>
						<td style = "font-size:9">

							&nbsp; &nbsp; &nbsp;Por favor lea atentamente el acuerdo. La <b>lectura</b> y <b>aceptación</b> <br>del mismo son requisitos para participar de la promoción.
							<br>&nbsp;
						</td>
					</tr>
					</tr>
                     	<td>
							<table border = 1 cellspacing="0" cellpadding="0" style="border-right-width:0">
								<tr>
									<td>
										<div id="legal" align="justify" style=" WIDTH: 350px; HEIGHT: 135px;font-size: 9px;padding:3;">
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Autorizo al Organizador y a las empresas involucradas en la promoción a utilizar mis datos para conformar una base de datos. Asimismo, autorizo a que me hagan llegar publicidad de los productos o servicios que esas empresas comercializan.<br><br>
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Vigencia: 01/10/2005 hasta 30/10/2005. Promoción válida en todo el país, excepto las provincias de Córdoba y Mendoza. Reglamento de participación disponible en todos los locales de Yenny, El Ateneo y Dromo, en <a Style="text-decoration:underline;color:blue" target="_blank" href="<%=Globals.PAGINA_SITIO%>">www.tematika.com</a> o 0810 33 39872. Las fotos son de carácter ilustrativo.
										   </div>
                                        </td>
	                                </tr>
	                            </table>

									</td>
								</tr>
								<tr>
									<td><br>
										<b><a Style="text-decoration:underline;color:blue;cursor:hand" onclick="javascript:window.open('/grupos/interior/reglamentomadre.htm', '', 'scrollbars=yes, resizable=yes, width=640, height=500')">Reglamento de la promoción</a></b>
									</td>
								</tr>
							</table>
							</form>

						</td>
					</tr>
					<tr>
						<td style="font-size:2">
							<hr size="2" noshade>
								<br>&nbsp;
						</td>
					</tr>
				</table>
