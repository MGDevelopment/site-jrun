<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.TipoDeDocumentoDAO,
                 com.tmk.kernel.PaisDAO,
                 com.tmk.controllers.fidelizacion.ConsultaDePuntos"%>
                 <script type="text/javascript">
	function seleccionarConsulta(tipoConsulta) {
		for (i=0; i< document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>.length; i++) {
			if (document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>[i].value == tipoConsulta) {
				if (!document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>[i].disabled) {
					document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>[i].checked = true;
					return true;
				}
			}
		}
	}

	function validarForm(frm) {
		frm.<%=ConsultaDePuntos.CAMPO_NRO_DE_DOCUMENTO%>.nombre = 'Identificación personal';
		frm.<%=ConsultaDePuntos.CAMPO_NRO_TARJETA%>.nombre = 'Tarjeta eXtra';
		if (frm.<%=ConsultaDePuntos.CONSULTA_POR%>[<%=ConsultaDePuntos.CONSULTA_POR_DOCUMENTO%>].checked == true) {
			frm.<%=ConsultaDePuntos.CAMPO_NRO_DE_DOCUMENTO%>.optional = false;
			frm.<%=ConsultaDePuntos.CAMPO_NRO_TARJETA%>.optional = true;
		} else {
			frm.<%=ConsultaDePuntos.CAMPO_NRO_DE_DOCUMENTO%>.optional = true;
			frm.<%=ConsultaDePuntos.CAMPO_NRO_TARJETA%>.optional = false;
		}
		return verify(frm);
	}
	</script>
<div id="seccionTematika">
	<div style="width:830px;  margin:auto; margin-top:80px;">
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td>
    	<br>
    </td>
  </tr>
  <tr>
    <td>
       <!-- Menu -->
 	   <% String pageMenu = "/tiles/elemento/extra/menu.jsp?mnuActivo=5";%>
	   <jsp:include page="<%=pageMenu%>"/>
       <!-- Menu -->
     </td>
    </tr>
  <tr>
    	<td>
        	<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
        		<tr>
		          	<td>
		          		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			              	<tr>
            			    	<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="40" class="punteonargris"><img src="/imagenes/fidelizacion/titulo_04.gif" width="222" height="27"></td>
                    </tr>
                    <tr>
                      <td class="punteonargris"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="celeste">
                          <tr>
                            <td><strong>Consult&aacute; aqu&iacute; tus puntos
                              <font color="#F7B742">eXtra!</font> Ingres&aacute;
                              tus datos personales o tu <br>
                              n&uacute;mero de tarjeta.</strong></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr>
                      <td class="punteonargris"><form name="formDatosParaCuenta" action="/ConsultaDePuntos" method="post" onsubmit="return validarForm(this)">
                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="celdacatalogo">
                            <tr>
                              <td><table width="100%" border="0" cellspacing="0" cellpadding="0" onclick="seleccionarConsulta('<%=ConsultaDePuntos.CONSULTA_POR_DOCUMENTO%>')">
                                  <tr>
                                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
                                        <tr>
                                          <td width="27"><img src="/imagenes/fidelizacion/franjagris.gif" width="27" height="30"></td>
                                          <td width="30"><input type="radio" checked name="<%=ConsultaDePuntos.CONSULTA_POR%>" value="<%=ConsultaDePuntos.CONSULTA_POR_DOCUMENTO%>"></td>
                                          <td class="txtblanco14"><strong>POR
                                            DATOS PERSONALES</strong></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td bgcolor="#EBEBEB"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="27" height="40">&nbsp;</td>
                                          <td width="140" class="arial12">Identificaci&oacute;n
                                            personal:</td>
                                          <td width="100">
												<select  class="arial12" name="<%=ConsultaDePuntos.CAMPO_TIPO_DE_DOCUMENTO%>" onchange="document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>[0].checked=true">
												<%
													for (int td = 0; td < Globals.TIPOS_DOCUMENTO.length; td++) {
														TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[td];
												%>
													<option value="<%=tipoDeDocumentoDAO.getId() %>" <%=(tipoDeDocumentoDAO.getId().equals(Globals.TIPO_DOCUMENTO_DNI.getId())) ? " selected" : ""%>><%= tipoDeDocumentoDAO.getNombre() %></option>
												<%  } %>
												</select></td>
                                          <td><input type="text" name="<%=ConsultaDePuntos.CAMPO_NRO_DE_DOCUMENTO%>" maxlength="15" onkeypress="document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>[0].checked=true" class="arial12" size="10"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td height="30" bgcolor="#EBEBEB"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="27" height="30">&nbsp;</td>
                                          <td width="140" class="arial12">Nacionalidad:</td>
                                          <td><select class="arial12" name="<%=ConsultaDePuntos.CAMPO_NACIONALIDAD%>" onchange="document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>(0).checked=true">
									<%
										for (int p = 0; p < Globals.PAISES.length; p++) {
											PaisDAO paisDAO = Globals.PAISES[p];
									%>
										<option value="<%= paisDAO.getId() %>" <%=(paisDAO.getId()==Globals.ARGENTINA.getId()) ? " selected" : ""%>><%= paisDAO.getNombre() %></option>
									<%  } %>
									</select></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td height="30" bgcolor="#EBEBEB"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="27" height="30">&nbsp;</td>
                                          <td width="140" class="arial12">Sexo:</td>
                                          <td><select class="arial12" name="<%=ConsultaDePuntos.CAMPO_SEXO%>" onchange="document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>(0).checked=true">
												<option value="M">Masculino</option>
												<option value="F">Femenino</option>
											</select></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td><table width="100%" border="0" cellspacing="0" cellpadding="0" onclick="seleccionarConsulta('<%=ConsultaDePuntos.CONSULTA_POR_TARJETA%>')">
                                  <tr>
                                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
                                        <tr>
                                          <td width="27"><img src="/imagenes/fidelizacion/franjagris.gif" width="27" height="30"></td>
                                          <td width="30"><input class="formextra" type="radio" name="<%=ConsultaDePuntos.CONSULTA_POR%>" value="<%=ConsultaDePuntos.CONSULTA_POR_TARJETA%>"></td>
                                          <td class="txtblanco14"><strong>POR
                                            N&Uacute;MERO DE TARJETA</strong></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                  <tr>
                                    <td bgcolor="#EBEBEB"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                          <td width="27" height="40">&nbsp;</td>
                                          <td width="140" class="arial12">Ingrese
                                            su tarjeta eXtra!</td>
                                          <td><input class="arial12" size="20" type="text" name="<%=ConsultaDePuntos.CAMPO_NRO_TARJETA%>" maxlength="15" onkeypress="document.formDatosParaCuenta.<%=ConsultaDePuntos.CONSULTA_POR%>[1].checked=true"></td>
                                        </tr>
                                      </table></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td height="25" valign="bottom"><div align="center"><input type="image" src="/imagenes/fidelizacion/b-enviar.gif"></div></td>
                            </tr>
                          </table>
                        </form></td>
                    </tr>
                     <tr>
                      <td class="punteonargris"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                         <tr>
                         	<td class="Ftexto02">
							 	<hr>
						 			Disposición (Dirección Nacional de Protección de Datos Personales) 10/2008
							 		<p>
									<p>
									"El titular de los datos personales tiene la facultad de ejercer el derecho de acceso a los mismos en forma gratuita a intervalos no inferiores a seis meses, salvo que se acredite un interés legítimo al efecto conforme lo establecido en el artículo 14, inciso 3 de la Ley Nº 25.326"
									<p>
									"La DIRECCION NACIONAL DE PROTECCION DE DATOS PERSONALES, órgano de control de la Ley Nº 25.326, tiene la atribución de atender las denuncias y reclamos que se interpongan con relación al incumplimiento de las normas sobre protección de datos personales".<p>
								<hr>
						 	</td>
                         </tr>
                      </table>
                     </td>
                    </tr>
                    <tr>
                      <td class="punteonargris"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="celeste">
                          <tr>
                            <td>Actualiz&aacute; tu e-mail y recib&iacute; nuestras
                              novedades en tu casilla haciendo <span class="celestelink"><a href="/fidelizacion/panel/actualizacionEMail.jsp" class="celestelink"><strong>click
                              aqu&iacute;</strong></a></span></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table>
				                </td>
                				<td width="165" valign="top" bgcolor="#E79A0B">
                				<!--LEFT-->
            	 				  <% String pageLeft = "/fidelizacion/panel/componentes/left.jsp";%>
								  <jsp:include page="<%=pageLeft%>"/>
               					<!--LEFT-->
                				</td>
					        </tr>
					        <tr>
					          <td height="4"></td>
					        </tr>
					        <tr>
					          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
					              <tr>
					                <td width="144" bgcolor="#00708B">&nbsp;</td>
					                <td bgcolor="#9C928D" align="left"><a href="#top"><img src="/imagenes/fidelizacion/marco_16.gif" width="101" height="22" border="0"></a></td>
					              </tr>
					            </table></td>
					        </tr>
     				 	</table>



     				</td>
				  </tr>
			</table>
	</div>
</div>