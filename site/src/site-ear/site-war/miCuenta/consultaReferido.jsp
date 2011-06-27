<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.controllers.referido.ReferidoManager,
                 com.tmk.referido.ReferidoLocal,
                 com.tmk.referido.ReferidoLocalHome,
                 java.util.Iterator,
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert,
                 java.util.Date,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper" %>

 <%     SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/referido/consultarReferido.jsp");
%>
		<jsp:forward page="/miCuenta" />
<%	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT,  "/miCuneta/seccionMiCuenta=11&opcionMenuReferidos=3");
%>
		<jsp:forward page="<%=MainHelper.PAGE_REGISTRO_SOCIO_CADENA%>" />
<%	}

	ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");

%>
<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="440" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>

                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellpadding="0" cellspacing="0">

                          <tr>
                            <td height="25" valign="top" class="FTtit01">ESTADO DE MIS REFERIDOS </td>
                          </tr>

                          <tr>
								<td colspan="3" align="center">
								<%
							    try {
									Iterator referidos = referidoLH.findBySocioReferenteEstado (socioPK.ID_SOCIO, socioPK.ID_SUCURSAL, ReferidoManager.REFERIDO_COMPRA_APROBADA).iterator();
                                    ReferidoLocal referido = (ReferidoLocal) referidos.next();
								     if (referido.getFECHA_VENC_REFERENTE().after(new Date())) {
								%>
									<font color="559944"><b>Por las compras realizadas por sus referidos <%=Globals.NOMBRE_DEL_SITIO%> te otorga <%=referido.getBENEF_REFERENTE()%> en sus próximas compras hasta el <%=Convert.toString(referido.getFECHA_VENC_REFERENTE())%>!!!</b><br/><br/></font>
								<%
								     }
							    } catch(Exception e) {

								}
								%>
								</td>
							</tr>
<!-- REFERIDOS DISPONIBLES -->
                          <tr>
                            <td valign="top" class="FTtit01ch">REFERIDOS DISPONIBLES </td>
                          </tr>
                        <%
						  try {
  						  Iterator referidos = referidoLH.findBySocioReferenteDisponibles(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL).iterator();
						%>
                          <tr>
                            <td valign="top"><table class="Ftexto02" width="370" cellpadding="0" cellspacing="0" style="margin:10px 0px 15px 0px; border:solid 1px #B9B9B9">
							 <%
	                              if (referidos.hasNext()) {
		                     %>
                              <tr>
                                <td width="106" height="20" align="center" valign="center" bgcolor="#c0d9ff"><strong> Vencimiento </strong></td>
                                <td width="262" height="35" align="center" valign="center" bgcolor="#c0d9ff"><div align="left"><strong>Nombre del referido</strong> </div></td>
                              </tr>
                              <%
                                     while (referidos.hasNext()) {
	                                 ReferidoLocal referido = (ReferidoLocal) referidos.next();
	                          %>

                              <tr>
                                <td valign="center" height="20" style="border-bottom:solid 1px #CCC"><div align="center"><%= Convert.toString(referido.getFECHA_VENC_REFERENTE())%></div></td> <!-- si es vacio NO DISPONIBLE-->

                                <td align="middle" valign="center" style="border-bottom:solid 1px #CCC"><div align="left"><%= Convert.nombreCompleto(referido.getNOMBRE_REFERIDO(), referido.getAPELLIDO_REFERIDO())%></div></td>
                              </tr>
							 <%
                                     }

	                              } else {
		                     %>
								<tr>
                                   <td height="20" valign="center"><div align="center">No existen referidos a su nombre. </div></td>
                                </tr>
                        <%
                                  }
						    } catch (Exception e) {
                                   out.println (e.toString());
							}
                        %>
                            </table></td>
                          </tr>


<!-- REFERIDOS EN PROCESO-->
                          <tr>
                            <td valign="top" class="FTtit01ch">REFERIDOS EN PROCESO </td>
                          </tr>
						<%
							try {
							Iterator referidos = referidoLH.findBySocioReferenteEnProceso(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL).iterator();
						%>
                          <tr>
                            <td valign="top"><table class="Ftexto02" width="370" cellpadding="0" cellspacing="0" style="margin:10px 0px 15px 0px; border:solid 1px #B9B9B9">
					    <%
	                              if (referidos.hasNext()) {
		                %>
     		                  <tr>
                                <td width="106" height="20" align="center" valign="center" bgcolor="#c0d9ff"><strong> Vencimiento </strong></td>
                                <td width="262" height="35" align="center" valign="center" bgcolor="#c0d9ff"><div align="left"><strong>Nombre del referido</strong> </div></td>
                              </tr>
					     <%
                                       while (referidos.hasNext()) {
                                          ReferidoLocal referido = (ReferidoLocal) referidos.next();
                         %>
                              <tr>
                                <td valign="center" height="20" style="border-bottom:solid 1px #CCC"><div align="center"><%= Convert.toString(referido.getFECHA_VENC_REFERENTE())%></div></td>

                                <td align="middle" valign="center" style="border-bottom:solid 1px #CCC"><div align="left"><%= Convert.nombreCompleto(referido.getNOMBRE_REFERIDO(), referido.getAPELLIDO_REFERIDO())%></div></td>
                              </tr>
                         <%
                                       }
                                  } else {
                         %>
                                <tr>
                                  <td height="20" valign="center"><div align="center">No existen referidos a su nombre. </div></td>
                                </tr>
		                <%
	                              }
							} catch (Exception e) {
                                      out.println (e.toString());
							}
                        %>
		                    </table></td>
                          </tr>

<!-- REFERIDOS VENCIDOS -->
                          <tr>
                            <td valign="top" class="FTtit01ch">REFERIDOS VENCIDOS </td>
                          </tr>
  					    <%
							try {
							Iterator referidos = referidoLH.findBySocioReferenteVencidos(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL).iterator();
						%>

                          <tr>
                            <td valign="top"><table class="Ftexto02" width="370" cellpadding="0" cellspacing="0" style="margin:10px 0px 15px 0px; border:solid 1px #B9B9B9">
                        <%
                                  if (referidos.hasNext()) {
                        %>
                                <tr>
                                  <td width="106" height="20" align="center" valign="center" bgcolor="#c0d9ff"><strong> Vencimiento </strong></td>
                                  <td width="262" height="35" align="center" valign="center" bgcolor="#c0d9ff"><div align="left"><strong>Nombre del referido</strong> </div></td>
                                </tr>
                         <%
                                      while (referidos.hasNext()) {
                                           ReferidoLocal referido = (ReferidoLocal) referidos.next();
                         %>
                                <tr>
                                  <td valign="center" height="20" style="border-bottom:solid 1px #CCC"><div align="center"><%= Convert.toString(referido.getFECHA_VENC_REFERENTE())%></div></td>
                                  <td align="middle" valign="center" style="border-bottom:solid 1px #CCC"><div align="left"><%= Convert.nombreCompleto(referido.getNOMBRE_REFERIDO(), referido.getAPELLIDO_REFERIDO())%></div></td>
                                </tr>
                         <%
                                       }
	                              } else {
		                 %>
                                <tr>
                                  <td height="20" valign="center"><div align="center">No existen referidos a su nombre. </div></td>
                                </tr>
                         <%
                                  }
  						     } catch (Exception e) {
                                    out.println (e.toString());
						     }
                         %>
                            </table></td>
                          </tr>

                          <tr>
                            <td height="55" valign="middle"><table width="370" border="0" align="left" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td class="celdamodulodomicilio2"><table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td width="185" valign="middle"><a href="#"></a></td>
                                        <td width="175" height="20" valign="middle"><div align="right">
                                        <!-- <a href="/miCuenta/?seccionMiCuenta=11&opcionMenuReferido=1">-->
                                        <a href="/AgregarReferido">
                                        <img src="/imagenes/miCuenta/b-agregarref.gif" alt="Agregar referido" border="0" /></a></div></td>
                                      </tr>
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                        </table></td>

                      </tr>
                    </table></td>
                  </tr>

                </table></td>
              </tr>

           </table></td>
           <%--
            <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
   		      <jsp:include page="<%=urlInstitucionalRight%>"/>

            </table></td>
            --%>
          </tr>
        </table>
	</div>
</div>