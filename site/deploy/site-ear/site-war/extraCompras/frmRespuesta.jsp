<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals" %>

<% SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");
%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>

        <meta name="robots" content="noindex, nofollow">
        <meta name="GOOGLEBOT" content="noindex, nofollow">

		<style type="text/css" rel="stylesheet">
		td
		{
			font-family: verdana;
			font-size: 11px;
		}
		div.TextoNegro
		{
			font-size: 10px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}
		font.TextoBordo
		{
			color: #990000;
			font-size: 12px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}
		a.EnlaceNegro
		{
			font-size: 11px;
			font-family: verdana;
			color: #000000;
			text-decoration: none;
		}
		</style>
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<table width="770" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td width="390">
					<%@include file="/componentes/comunes/logo.jsp"%>
				</td>

				<td width="350" align="right" valign="top">
					<jsp:include page="/componentes/comunes/carrito.jsp" />
				</td>
			</tr>
		</table>

		<table bgcolor="#dce1e6" pad="#C20200" width="745" cellspacing="0" cellpadding="0" border="0">

			<tr>
				<td colspan="2" bgcolor="#ffffff">
					<jsp:include page="/componentes/comunes/solapas.jsp?modo=rojo" />
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center" height="33">
					<jsp:include page="/componentes/inicio/buscador.jsp" />
				</td>
			</tr>

			<tr>
				<td style="background:  url(/imagenes/sombraesquina.gif) no-repeat right; ">
				</td>

				<td width="750" height="8" style="background:  url(/imagenes/sombrasuperior.gif)">
				</td>
			</tr>

			<tr valign="top" bgcolor="#ffffff">
				<td width="1">&nbsp;</td>
				<td valing="middle">
					<table bgcolor="#FFFFFF" cellpadding="0" cellspacing="0">
					  <tr>
						<td><img src="/imagenes/cabecera-eXtraCompras.gif" width="760" height="120"></td>
					  </tr>
					  <tr>
						<td> <table width="760" border="0" cellspacing="2" cellpadding="1" bgcolor="#E4E4E7" style="font-size:11;font-family:Verdana;color:#4C5397;">
							<tr>
							  <td style="font-size:5; padding:0" colspan="5">&nbsp;</td>
							</tr>
							<tr>
							  <td style="font-size:5; padding:0" colspan="4" width="70%" valign="top"><table width="98%" border="0" cellspacing="0" cellpadding="0" style="font-size:11;font-family:Verdana;color:#4C5397;">
								  <tr height=1>
									<td  style="font-size:1;padding:0"></td>
									<td colspan="2" rowspan=2 width=7 style="font-size:1;padding:0;"><img src="/imagenes/esquina1.gif" width="7" height="7"></td>
									<td  bgcolor="FFFFFF" style="font-size:1;padding:0"></td>
									<td width=7 colspan="2" rowspan=2 style="font-size:1;padding:0;"><img src="/imagenes/esquina3.gif" width="7" height="7"></td>
								  </tr>
								  <tr height=6>
									<td style="font-size:1"></td>
									<td style="font-size:1" bgcolor="#A5B9C3">&nbsp;</td>
								  </tr>
								  <tr>
									<td style="font-size:4" bgcolor="#A0A6AD"></td>
									<td width="1" style="font-size:1" bgcolor="FFFFFF"></td>
									<td width="6" style="font-size:1" bgcolor="#A5B9C3"></td>
									<td style="font-size:4" bgcolor="#A5B9C3">&nbsp;</td>
									<td width="6" bgcolor="#A5B9C3" style="font-size:1"></td>
									<td width="1" bgcolor="#FFFFFF" style="font-size:1"></td>
								  </tr>
								  <tr>
									<td bgcolor="FFFFFF" style="padding-left:10"><b>Nro. de Cuenta
									  &gt;</b></td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF" style="padding-left:10;padding-top:5;font-size:11;font-family:arial;color:000000;font-weight:600">711333062</td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF"></td>
								  </tr>
								  <tr>
									<td style="font-size:1" bgcolor="#A0A6AD"></td>
									<td style="font-size:1" bgcolor="#FFFFFF"></td>
									<td style="font-size:1" bgcolor="#A5B9C3"></td>
									<td style="font-size:4" bgcolor="#A5B9C3">&nbsp;</td>
									<td bgcolor="#A5B9C3" style="font-size:1"></td>
									<td bgcolor="#FFFFFF" style="font-size:1"></td>
								  </tr>
								  <tr>
									<td bgcolor="FFFFFF" style="padding-left:10"><b>Nombre &gt;</b></td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF" style="padding-left:10;padding-top:5;font-size:10;font-family:arial;color:000000;font-weight:600">POUSA
									  HORACIO</td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF"></td>
								  </tr>
								  <tr>
									<td style="font-size:1" bgcolor="#A0A6AD"></td>
									<td style="font-size:1" bgcolor="#FFFFFF"></td>
									<td style="font-size:1" bgcolor="#A5B9C3"></td>
									<td style="font-size:4" bgcolor="#A5B9C3">&nbsp;</td>
									<td bgcolor="#A5B9C3" style="font-size:1"></td>
									<td bgcolor="#FFFFFF" style="font-size:1"></td>
								  </tr>
								  <tr>
									<td bgcolor="FFFFFF" style="padding-left:10"><b>Direcci&oacute;n
									  &gt;</b></td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF" style="padding-left:10;padding-top:5;font-size:10;color:000000;font-family:arial;font-weight:600">AV.
									  NAZCA 4354 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; DPTO. 2</td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF"></td>
								  </tr>
								  <tr>
									<td style="font-size:1" bgcolor="#A0A6AD"></td>
									<td style="font-size:1" bgcolor="#FFFFFF"></td>
									<td style="font-size:1" bgcolor="#A5B9C3"></td>
									<td style="font-size:4" bgcolor="#A5B9C3">&nbsp;</td>
									<td bgcolor="#A5B9C3" style="font-size:1"></td>
									<td bgcolor="#FFFFFF" style="font-size:1"></td>
								  </tr>
								  <tr>
									<td bgcolor="FFFFFF" style="padding-left:10"><b>CP&gt; &nbsp;
									  &nbsp; Localidad&gt;</b></td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF" style="padding-left:10;padding-top:5;font-size:10;color:000000;font-family:arial;font-weight:600">1419
									  &nbsp; &nbsp; CAPITAL FEDERAL</td>
									<td bgcolor="FFFFFF"></td>
									<td bgcolor="FFFFFF"></td>
								  </tr>
								  <tr>
									<td style="font-size:1" bgcolor="#A0A6AD"></td>
									<td style="font-size:1" bgcolor="#FFFFFF"></td>
									<td style="font-size:1" bgcolor="#A5B9C3"></td>
									<td style="font-size:4" bgcolor="#A5B9C3">&nbsp;</td>
									<td bgcolor="#A5B9C3" style="font-size:1"></td>
									<td bgcolor="#FFFFFF" style="font-size:1"></td>
								  </tr>
								  <tr height=6>
									<td style="font-size:1" ></td>
									<td colspan="2"  rowspan=2 style="font-size:1;padding:0;"><img src="/imagenes/esquina2.gif" width="7" height="7"></td>
									<td style="font-size:1" bgcolor="#A5B9C3">&nbsp;</td>
									<td colspan="2" rowspan=2 style="font-size:1;padding:0;"><img src="/imagenes/esquina4.gif" width="7" height="7"></td>
								  </tr>
								  <tr height=1>
									<td style="font-size:1;padding:0"></td>
									<td style="font-size:1;padding:0" bgcolor="FFFFFF"></td>
								  </tr>
								</table></td>
							  <td style="padding:0" valign="top"><table  width="100%" border="0" cellspacing="0" cellpadding="0" >
                    <tr>
                      <td align="right" style="font-size:4;">&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="right" style="font-size:10;font-family:Verdana;color:#4C5397;">Grupo
                        ILHSA S.A.</td>
                    </tr>
                    <tr>
                      <td align="right" style="font-size:10;font-family:Verdana;color:#4C5397;">Patagones
                        2463 (C1282ACA)</td>
                    </tr>
                    <tr>
                      <td align="right" style="font-size:10;font-family:Verdana;color:#4C5397;">Ciudad
                        Aut&oacute;noma de Buenos Aires</td>
                    </tr>
                    <tr>
                      <td align="right" style="font-size:10;font-family:Verdana;color:#4C5397;">Tel.:
                        54 11 4943 8200</td>
                    </tr>
                    <tr>
                      <td align="right" style="font-size:10;font-family:Verdana;color:#4C5397;">Fax.:
                        54 11 4943 8252</td>
                    </tr>
                    <tr>
                      <td align="right">&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="right"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td><table width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor="#000099" bordercolor="#FFFFFF">
                                <tr>
                                  <td><div  style="font-size:9px;color:FFFFFF;font-family:tahoma" align="center"><b>Para
                                      Informes y consultas</b></div></td>
                                </tr>
                              </table></td>
                          </tr>
                          <tr>
                            <td bgcolor="#FAAC1A" align="center" style="font-size:15;color:FFFFFF;font-family:verdana"><i><b>0810-333-9366</b></i></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
							</tr>

							<tr>
							  <td style="font-size:4; padding:0" colspan="5"><hr width="100%" color="#4C5397"></td>
							</tr>
							<tr>
								<td colspan=5>
									<table style="font-size:11;font-family:Verdana;color:#4C5397;">
										<tr>
							  <td style=""> <b>TOTAL A PAGAR &gt;</b> </td>
							  <td> <input name="text3" type="text" style="font-size:11;font-family:Verdana;color:#4C5397;border:1px solid #;C3C3C6;text-align:right;padding-right:20;font-weight:bold" value="7,11" size=15></td>
							  <td style=""> <b>ESTADO DE CUENTA AL &gt;</b></td>
							  <td style=""><input name="text" type="text" style="font-size:11;font-family:Verdana;color:#4C5397;border:1px solid #;C3C3C6;text-align:right;padding-right:20;font-weight:bold" value="30/08/2004" size=15></td>
							  <td>&nbsp; </td>
							</tr>
							<tr>
							  <td> <b>VENCIMIENTO ACTUAL &gt;</b> </td>
							  <td> <input type="text" value="15/09/2004" size=15 style="font-size:11;font-family:Verdana;color:#4C5397;border:1px solid #;C3C3C6;text-align:right;padding-right:20;font-weight:bold">
							  </td>
							  <td style=""> <b>PAGO ANTERIOR &gt;</b></td>
							  <td style=""><input name="text2" type="text" style="font-size:11;font-family:Verdana;color:#4C5397;border:1px solid #;C3C3C6;text-align:right;padding-right:20;font-weight:bold" value="0,00" size=15></td>
							  <td>&nbsp; </td>
							</tr>
							<tr>
							  <td> <b>PROXIMO VENCIMIENTO &gt;</b> </td>
							  <td> <input type="text" value="15/10/2004" size=15 style="font-size:11;font-family:Verdana;color:#4C5397;border:1px solid #;C3C3C6;text-align:right;padding-right:20;font-weight:bold">
							  </td>
							  <td colspan="2" style=""> <b>SALDO DE PUNTO ACUMULADOS EN ESTE PERIODO&gt;</b></td>
							  <td> <input type="text" value="" size=15 style="font-size:11;font-family:Verdana;color:#4C5397;border:1px solid #;C3C3C6;text-align:right;padding-right:20;font-weight:bold">
							  </td>
							</tr>
									</table>
								</td>
							</tr>
							<tr>
							  <td>&nbsp;</td>
							  <td>&nbsp;</td>
							  <td style="">&nbsp;</td>
							  <td style="">&nbsp;</td>
							  <td>&nbsp;</td>
							</tr>
						  </table></td>
					  </tr>
					  <tr>
						<td style="font-size:2">&nbsp;
						</td>
					  </tr>
					  <tr>
						<td> <table width="760" border="0" cellspacing="2" cellpadding="1" bgcolor="#FFFFFF" style="font-size:10;font-family:Verdana">
							<tr style="color:ffffff;">
							  <td valign="top" align="center" bgcolor="#000099"><b>Establecimiento</b></td>
							  <td valign="top" align="center" bgcolor="#000099"><b>Fecha de Compra</b></td>
							  <td valign="top" align="center" bgcolor="#000099"><b>Cuota N&deg;</b></td>
							  <td valign="top" align="center" bgcolor="#000099"><b>Cant. Cuotas<br>
								del Plan</b></td>
							  <td valign="top" align="center" bgcolor="#000099"><b>N&deg; Operación</b></td>
							  <td valign="top" align="center" bgcolor="#000099"><b>Importe Cuota</b></td>
							  <td valign="top" align="center" bgcolor="#000099"><b>Intereses por<br>
								Pago Fuera<br>
								de T&eacute;rmino</b></td>
							  <td valign="top" width="80" align="center" bgcolor="#000099"><b>Total</b></td>
							</tr>
							<tr>
							  <td align="center" bgcolor="#D4D5D7">&nbsp;</td>
							  <td align="center" bgcolor="#D4D5D7">&nbsp;</td>
							  <td align="center" bgcolor="#D4D5D7">&nbsp;</td>
							  <td align="center" bgcolor="#D4D5D7">&nbsp;</td>
							  <td align="center" bgcolor="#D4D5D7">&nbsp;</td>
							  <td align="right" bgcolor="#D4D5D7">&nbsp;</td>
							  <td align="right" bgcolor="#D4D5D7">&nbsp;</td>
							  <td align="right" bgcolor="#D4D5D7">&nbsp;</td>
							</tr>
							<tr>
							  <td  valign="top" align="right" bgcolor="#D4D5D7" colspan="7" style="font-size:9;color:#555588;">
								<b>SUBTOTAL&nbsp; <br>
								Gastos de envío liquidación mensual (IVA incluído)&nbsp; <br>
								Seguro (IVA incluído)&nbsp;
								<p> &nbsp; TOTAL&nbsp; <br>
								  &nbsp; </b> </td>
							  <td align="center" bgcolor="#D4D5D7"> &nbsp; &nbsp; &nbsp;4,08 <br>
								&nbsp; &nbsp; &nbsp;3,03 <br> &nbsp; &nbsp; &nbsp;0,00
								<P>
								<table width="65" border="0" bgcolor="#FAAC1A" cellspacing="0" cellpadding="2">
								  <tr>
									<td> <table width="63" bgcolor="#FFFFFF" border="0" cellspacing="0" cellpadding="2">
										<tr>
										  <td align="right" style="font-size:11;font-family:Verdana">
											7,11 &nbsp; </td>
										</tr>
									  </table></td>
								  </tr>
								</table></td>
							</tr>
						  </table></td>
					  </tr>
					  <tr>
						<td><table  width="760" border="0"  cellspacing="2" cellpadding="0">
							<tr>
							  <td bgcolor="#FFE6C3">&nbsp;</td>
							</tr>
						  </table></td>
					  </tr>
					</table>

				</td>
			</tr>
		</table>

	</body>
</html>
