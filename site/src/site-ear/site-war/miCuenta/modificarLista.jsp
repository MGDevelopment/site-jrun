<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.src.listadeseos.ListaDeseosPK,
                 com.tmk.kernel.DBUtil,                 
                 java.util.Iterator,                 
                 java.util.Vector,
                 com.tmk.kernel.Convert"%>

<%@page import="com.tmk.bus.articulo.ListaDeseos"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.soa.exceptions.DBOInexistenteException"%>
<%
	SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");
	if(socioPK == null)
	{
		session.setAttribute("URL_REDIRECT", "/miCuenta/?seccionMiCuneta=7");
		pageContext.forward("/miCuenta/");
	}
	//DBO
	ListaDeseosPK listaPK = new ListaDeseosPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
	ListaDeseos listaDBO = null;
	try {
		listaDBO = ServiceLocator.getListaDeDeseosService().findByPrimaryKey(listaPK);	
	}catch(DBOInexistenteException e) {
		
	}catch(Exception e) { 
		
	}
	
%>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td class="Gcentro" width="422">
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
			<!--principal  -->
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
								<form action="/ActualizarLista" method="post" name="modificarLista" onSubmit ="return validarForm(modificarLista)">
								<input type="hidden" name="_DISPACHER" value="/miCuenta/?seccionMiCuenta=6">
                                <td width="370" height="20" valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="35" colspan="3" valign="top" class="Ftexto02"><strong>Datos de mi lista</strong><br />
										Recuerde que los campos con (<span class="Ftextorojo">*</span>) son obligatorios.</td>
                                  </tr>
                                  <tr>
                                    <td width="116" height="20" valign="bottom" class="Ftexto02" ><span class="Ftextorojo">*</span> Nombres: </td>
                                    <td width="254" colspan="2" valign="middle"><input name="NOMBRES" value="<%=listaDBO.getNombres()%>" type="text" class="ayudatext" /></td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Apellidos: </td>
                                    <td colspan="2" valign="bottom" class="Ftexto02"><input name="APELLIDOS" value="<%=listaDBO.getApellidos()%>" type="text" class="ayudatext" /></td>
                                  </tr>
                                  <tr class="experienciatabla2">
                                    <td height="26" valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Palabras Clave: </td>
                                    <td colspan="2" rowspan="2"><div align="left">
                                        <textarea name="PALABRAS_CLAVES" rows="4" cols="30" class="experienciatextarea"><%=listaDBO.getPalabras_claves()%></textarea>
                                    </div></td>
                                  </tr>
                                  <tr class="experienciatabla2">
                                    <td height="74" valign="bottom" class="Ftexto02">&nbsp;</td>
                                  </tr>

                                  <tr>
                                    <td valign="middle" class="Ftexto02">&nbsp;</td>
                                    <td colspan="2" valign="bottom" class="Ftexto02" style="padding:5px 0px 10px 9px">Ejemplo: Vivo en Buenos Aires, voy al colegio San Andres,
                                      mi equipo de f&uacute;tbol es River Plate, mi mascota se llama &quot;Jerry&quot;.</td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Fecha de nacimiento: </td>
                                    <td colspan="2" valign="bottom" class="Ftexto02"><table width="189" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td width="72">
                                        	<select name="CUMPL_DIA" class="empleomenu" onKeyPress="cambiarFoco(event,'document.modificarLista.CUMPL_MES');">
                                          		<%
													for(int i = 1; i <= 31; i ++)
													{
														%>
														<%-- <option value="<%= i %>" <%= (lista.getCUMPL_DIA().intValue() == i ? " selected" : "") %>>--%>
														<option value="<%= i %>" <%= (listaDBO.getCumpl_dia().intValue() == i ? " selected" : "") %>>
																<%= i %>
														</option>
														<%
													}
												%>
                                            </select>
                                        </td>
                                        <td width="10" valign="middle">/</td>
                                        <td width="111"><select class="empleomenu3" name="CUMPL_MES"  onKeyPress="enviar(event, 'modificarLista.submit();');">
                                          <option value="0"> -- MES -- </option>
											<option value="1"<%= listaDBO.getCumpl_mes().intValue() == 1 ? " selected" : "" %>> Enero</option>
											<option value="2"<%= listaDBO.getCumpl_mes().intValue() == 2 ? " selected" : "" %>> Febrero</option>
											<option value="3"<%= listaDBO.getCumpl_mes().intValue() == 3 ? " selected" : "" %>> Marzo</option>
											<option value="4"<%= listaDBO.getCumpl_mes().intValue() == 4 ? " selected" : "" %>> Abril</option>
											<option value="5"<%= listaDBO.getCumpl_mes().intValue() == 5 ? " selected" : "" %>> Mayo</option>
											<option value="6"<%= listaDBO.getCumpl_mes().intValue() == 6 ? " selected" : "" %>> Junio</option>
											<option value="7"<%= listaDBO.getCumpl_mes().intValue() == 7 ? " selected" : "" %>> Julio</option>
											<option value="8"<%= listaDBO.getCumpl_mes().intValue() == 8 ? " selected" : "" %>> Agosto</option>
											<option value="9"<%= listaDBO.getCumpl_mes().intValue() == 9 ? " selected" : "" %>> Septiembre</option>
											<option value="10"<%= listaDBO.getCumpl_mes().intValue() == 10 ? " selected" : "" %>> Octubre</option>
											<option value="11"<%= listaDBO.getCumpl_mes().intValue() == 11 ? " selected" : "" %>> Noviembre</option>
											<option value="12"<%= listaDBO.getCumpl_mes().intValue() == 12 ? " selected" : "" %>> Diciembre</option>
                                            </select></td>
                                      </tr>
                                    </table></td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02">&nbsp;</td>
                                    <td colspan="2" valign="bottom" class="Ftexto02">&nbsp;</td>
                                  </tr>
                                  <tr>
                                    <td colspan="3" valign="bottom" class="Ftexto02"><table width="343" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td width="159">Hacer p&uacute;blica mi lista de deseos </td>
                                        <td width="20" valign="middle"><input  type="radio" name="PUBLICA" value="1" <%= (Convert.toNumber(listaDBO.getPublica(), 0) == 1 ? " checked" : "") %>/></td>
                                        <td width="20">Si</td>
                                        <td width="20" valign="middle"><input type="radio" name="PUBLICA"  value="0" <%= (Convert.toNumber(listaDBO.getPublica(), 0) != 1 ? " checked" : "") %>/></td>
                                        <td width="124">No</td>
                                      </tr>
                                    </table></td>
                                    </tr>

                                  <tr>
                                    <td height="20" colspan="3" valign="top" class="Ftexto02"><div align="right">
                                    <input type="image" src="/imagenes/listaDeseos/b-enviar.gif" alt="Enviar" width="47" height="9" border="0" class="benviar2" />
                                    </div></td>
								  </form>
                                  </tr>
                                </table></td>
                              </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                </table>

                </td>
              </tr>
            <!--principal  -->


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
            <!--BARRRA DERECHA -->
            <table width="155" border="0" cellspacing="0" cellpadding="0">

              <tr>
                <td>
                <table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
                  <tr>
                    <td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td><span class="Ftexto02">AQU&Iacute; PODR&Aacute; MODIFICAR SU LISTA DE DESEOS.</span></td>
                      </tr>

                      <tr>
                        <td class="moduloordencelda"><span class="Ftexto02"><strong>Campo Palabras Clave:</strong> Ingrese aqu&iacute; el texto que considere que servir&aacute; para que sus amigos o contactos encuentren su lista de deseos.</span></td>
                      </tr>
                      <tr>
                        <td class="moduloordencelda"><span class="Ftexto02"><strong>Hacer p&uacute;blica mi lista de deseos:</strong> <br />
                          Seleccione si o no, con un click si quiere que su lista de deseos sea p&uacute;blica para otros usuarios de Tematika.</span></td>
                      </tr>

                    </table></td>
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

	<script type="text/javascript">
		    function validarForm(f) {
				if(isEmpty(f.NOMBRES.value))	{
					f.NOMBRES.focus();
					alert('El campo Nombres no puede estar vacío.');
					return false;
				}
				if(isEmpty(f.APELLIDOS.value))	{
					f.APELLIDOS.focus();
					alert('El campo Apellidos no puede estar vacío.');
					return false;
				}
				if(isEmpty(f.PALABRAS_CLAVES.value))	{
					f.PALABRAS_CLAVES.focus();
					alert('El campo Palabras Claves no puede estar vacío.');
					return false;
				}

                return true;
			}
	</script>
