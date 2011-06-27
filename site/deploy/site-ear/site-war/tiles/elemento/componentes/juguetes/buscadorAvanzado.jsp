<%@ page import="com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.categoria.CategGrupoLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.kernel.Globals,
                 com.tmk.categoria.CategGrupoLocal,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.IdiomaDAO,
                 com.tmk.setup.Contenido" %>
<%
String palcla = Convert.toString(request.getParameter(BuscadorHelper.POR_PALABRAS_CLAVES));
%>
<script type="text/javascript" src="/js/Validation.js" ></script>

<script>
function consultar(form){
	if (isEmpty(form.<%=BuscadorHelper.POR_TITULO%>.value) &&
	isEmpty(form.<%=BuscadorHelper.POR_AUTOR%>.value) &&
	isEmpty(form.<%=BuscadorHelper.POR_EDITORIAL%>.value) &&
	isEmpty(form.<%=BuscadorHelper.POR_PALABRAS_CLAVES%>.value) &&
	isEmpty(form.<%=BuscadorHelper.POR_ISBN%>.value)) {
		alert ('Ingresá al menos un criterio de búsqueda');
		return false;
	}
	return true;
}

function intro(e){
	tecla=(document.all) ? e.keyCode : e.which;
	if(tecla==13) {
		window.event.keyCode=0;
		document.formSearch.submit();
	}
}
</script>


				<td><table width="375" border="0" cellspacing="0" cellpadding="0" class="tablabavanzada">
                            <tr>
                              <td><div align="center">
                                <table width="355" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td colspan="3" valign="bottom" class="FTtit01">CRITERIOS DE B&Uacute;SQUEDA</td>

                                  </tr>
                                  <tr>
                                    <td width="142" valign="bottom" class="Ftexto02">T&iacute;tulo: </td>
                                    <td width="224" colspan="2"><div align="left">
                                        <input type="text" name="<%=BuscadorHelper.POR_TITULO%>" size="70" maxlength="70" class="ayudatext" />
                                    </div></td>
                                  </tr>
                                  <tr>

                                    <td valign="bottom" class="Ftexto02">Autor: </td>
                                    <td colspan="2"><div align="left">
                                        <input type="text" name="<%=BuscadorHelper.POR_AUTOR%>" size="70" maxlength="70" class="ayudatext" />
                                    </div></td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02">Editorial: </td>

                                    <td colspan="2"><div align="left">
                                        <input type="text" name="<%=BuscadorHelper.POR_EDITORIAL%>" size="70" maxlength="70" class="ayudatext" />
                                    </div></td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02">ISBN: </td>
                                    <td colspan="2"><div align="left">
                                        <input type="text" name="<%=BuscadorHelper.POR_ISBN%>" class="ayudatext" />

                                    </div></td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02">Palabra clave: </td>
                                    <td colspan="2"><div align="left">
                                        <input type="text" name="<%=BuscadorHelper.POR_PALABRAS_CLAVES%>" value="<%=palcla%>" size="70" maxlength="70" class="ayudatext" />
                                    </div></td>
                                  </tr>

                                  <tr>
                                    <td height="35" colspan="3" valign="bottom" class="Ftexto02"><span class="FTtit01">FILTROS DE BUSQUEDA </span></td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02">Clasificaci&oacute;n tem&aacute;tica: </td>
                                    <td colspan="2"><div align="left">
                                        <select name="<%=BuscadorHelper.POR_CLASIFICACION_TEMATIKA%>" class="formbavanzada" onkeypress="intro(event)">
											<option value="">-NO FILTRAR-</option>
											<%
												CategGrupoLocalHome grupoHome = (CategGrupoLocalHome)DBUtil.getHome("CategGrupo");
												Iterator grupos = grupoHome.findByCategoria(new Integer(Globals.SECCION_JUGUETES)).iterator();
												while (grupos.hasNext()) {
													CategGrupoLocal grupo = (CategGrupoLocal)grupos.next();
											%>
											<option value="<%= grupo.getCATEGORIA_GRUPO() %>"><%= Convert.corregir(grupo.getDESCRIPCION(), true) %></option>
											<%	} %>

                                        </select>
                                    </div></td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02">Idioma: </td>
                                    <td colspan="2"><div align="left">
                                        <select name="<%=BuscadorHelper.POR_IDIOMA%>" class="formbavanzada" onkeypress="intro(event)">
											<option value="">-NO FILTRAR-</option>
											<%  for (int i = 0; i < Globals.IDIOMAS.length; i++) {
													IdiomaDAO idiomaDAO = Globals.IDIOMAS[i];
											%>
											<option value="<%= idiomaDAO.getId() %>"><%= idiomaDAO.getNombre() %></option>
											<%}%>
                                        </select>
                                    </div></td>
                                  </tr>
                                  <tr>
                                    <td valign="bottom" class="Ftexto02">Precio: </td>
                                    <td colspan="2"><div align="left">
                                        <select name="<%=BuscadorHelper.POR_PRECIO%>" class="formbavanzada" onkeypress="intro(event)">
											<option value="">-No Filtrar-</option>
											<option value="25">Menor a <%= Contenido.precioToString(25) %></option>
											<option value="50">Menor a <%= Contenido.precioToString(50) %></option>
											<option value="75">Menor a <%= Contenido.precioToString(75) %></option>
											<option value="100">Menor a <%= Contenido.precioToString(100) %></option>
                                        </select>
                                    </div></td>
                                  </tr>
                                  <tr>
                                    <td colspan="3" valign="bottom" class="Ftexto02">&nbsp;</td>
                                  </tr>
                                  <tr>

                                    <td>&nbsp;</td>
                                    <td colspan="2"><div align="right"><input type="image" src="/imagenes/juguetes/b-buscaravanzado.gif"></div></td>
                                  </tr>
                                </table>
                              </div></td>
                            </tr>
                        </table></td>