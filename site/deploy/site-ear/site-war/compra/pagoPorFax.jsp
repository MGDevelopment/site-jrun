<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.setup.Contenido"%>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		

<link href="/estilos/old/comun.css" rel="stylesheet" type="text/css" />
<link href="/estilos/old/seccion_inicio.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="700" border="0" align="center" cellpadding="0" cellspacing="0" class="Gtablaprincipal">
  <tr>
    <td><table width="700" border="0" cellspacing="0" cellpadding="0">
       <tr>
        <td width="183" valign="middle">

       <img src="/imagenes/<%=Contenido.getLogo()%>" alt="<%=Contenido.getMensajeLogo()%>" width="182" height="36" border="0" />

        </td>
      </tr>
      <tr>
        <td colspan="2"><table width="710" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
          <tr>
            <td class="Gcentro" width="490"><table width="480" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop">

<!--DATOS PARA IMPRIMIR-->
             <tr>
	
                <td><div align="center" class="moduloayuda">
                  <table width="490" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                    <tr>
                      <td><table width="480" border="0" cellspacing="0" cellpadding="0" class="moduloayuda">
                          <tr>
                            <td height="30" colspan="3" valign="middle" class="Ftexto02"><span class="FTtit01">SU N&Uacute;MERO DE ORDEN ES:</span> ............................<br /><br />
                              (Por favor escriba el n&uacute;mero de orden que le aparecer&aacute; en la pantalla de finalizaci&oacute;n)</td>
                          </tr>
                      </table></td>
                    </tr>
                  </table>
                  <table width="480" border="0" align="center" cellpadding="0" cellspacing="0" >
					<tr>
                      <td  valign="bottom" class="Ftexto02"><table width="480" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                          <tr>
                            <td valign="middle"><table width="480" border="0" cellspacing="0" cellpadding="0"  >
                              <tr>
                                <td colspan="3" valign="bottom" style="padding-bottom:5px"><table width="480" border="0" align="left" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td class="celdamodulodomicilio2"><table width="480" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td width="480" valign="middle"><strong>Imprima este formulario, compl&eacute;telo y env&iacute;elo por fax al n&uacute;mero <%=Globals.FAX_CALL_CENTER%></strong></td>
                                      </tr>
                                    </table></td>
                                  </tr>
                                </table></td>
                              </tr>
                              
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom">Tipo de Tarjeta: ................................................................................................... </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom" >N&uacute;mero de Tarjeta:   ............................................................................................... </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom" >C&oacute;digo de Seguridad:   ............................................................................................. </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom" >Fecha de Vencimiento:   ............................................................................................ </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom" >Nombre del Titular:   ................................................................................................ </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom" >DNI/ID/Pasaporte:   ................................................................................................ </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom" >Direcci&oacute;n del resumen de cuenta:   ............................................................................... </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom" >   ....................................................................................................................... </td>
                                
                              </tr>

                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="20" valign="bottom" >Tel&eacute;fono del Titular:   .............................................................................................. </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                              <tr>
                                <td align="right" width="480" height="50" valign="bottom" >Firma y aclaraci&oacute;n:   ............................................................................................... </td>
                              </tr>
                              <tr>
                              	<td>&nbsp;</td>
                              </tr>
                            </table></td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                  </table>
                </div></td>
			 </tr>
            </table></td>

<!-- FIN DATOS PARA IMPRIMIR -->
            
            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="162" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table width="148" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td>
                          	<p class="Ftexto02">TODOS LOS DATOS QUE FIGURAN EN ESTA PANTALLA SON LOS NECESARIOS PARA QUE PUEDA EFECTUAR SU PAGO POR FAX.</p>
                          </td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><br/><strong>Procedimiento:</strong><br/>
                            - Imprima este formulario, o transcr&iacute;balo y complete todos los datos.<br /><br/>
                            - El n&uacute;mero de orden usted lo encontrar&aacute; en la pantalla de finalizaci&oacute;n de su compra.<br /><br/>
                            - Firme el formulario y por favor env&iacute;elo al n&uacute;mero que figura en la parte superior de la pantalla.</span></td>
                        </tr>
                       
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td colspan="3"><div align="center">
                 <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion="+ Globals.SECCION_HOME;%>
				 <jsp:include page="<%=urlInstitucional%>"/>   
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<%=Globals.getGoogleAnalyticsSSL()%>
</body>
</html>
