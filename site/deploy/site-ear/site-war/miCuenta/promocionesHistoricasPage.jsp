<%@ page import="javax.naming.InitialContext,
				 java.util.Vector,
				 java.util.Iterator,
				 com.tmk.kernel.Convert,
				 com.tmk.orden.Promocion2,
				 com.tmk.src.socio.SocioPK,
				 com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper"%>

<%
	SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");
	if(socioPK == null){
		pageContext.forward("/miCuenta");
	}
	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/promocionesHistoricas.jsp");
	}
%>


	<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">

             <%	if (socioPK != null) { %>
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
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr class="tabladomicilios">
                        <td height="20" valign="top"><div class="FTtit01">PROMOCIONES UTILIZADAS:</div></td>
                      </tr>


			<%	Vector promociones = Promocion2.consultarPromocionesHistoricas(socioPK.ID_SOCIO.intValue(), socioPK.ID_SUCURSAL.intValue());
				if (!promociones.isEmpty()) {
			%>
					<tr>
                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">

             <%       	for (int i = 0; (promociones != null) && (i < promociones.size()); i++) {
						Promocion2 promocion = (Promocion2)(promociones.get(i));

			%>
                          <tr>
                           <td valign="bottom" class="Ftexto02" style="padding-top:10px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
                               <tr>
                                 <td class="celdamodulodomicilio2"><table class="Ftexto02" width="356" border="0" cellspacing="0" cellpadding="0">
                                     <tr>
                                       <td height="39" valign="middle"><span class="FTtit01">Promoci&oacute;n: </span><span class="Ftextorojo"><%= Convert.toString(promocion.getNombre()) %></span> <br />
                                           <span class="FTtit01">Descripci&oacute;n:</span> <%= Convert.toString(promocion.getComentarios()) %><br />
                                           <span class="FTtit01">Fecha de inicio: </span><%= Convert.toString(promocion.getFInicio()) %><br />
                                           <span class="FTtit01">Fecha de finalizaci&oacute;n: </span><%= Convert.toString(promocion.getFFin()) %></td>
                                     </tr>
                                 </table></td>
                               </tr>
                           </table></td>
                        </tr>
                      <%}%>

				<%
				   }else{
			     %>
                   	  <tr>
                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                          <tr>
                             <td><table width="366" border="0" cellspacing="0" cellpadding="0">
                               <tr>
                                 <td valign="bottom" class="Ftexto02">NO SE LE HAN APLICADO PROMOCIONES AL DIA DE HOY</td>
                               </tr>
                             </table></td>
                          </tr>

              <% } %>
		                  <tr>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="Ftexto06">EL LISTADO QUE SE PUEDE VER AQU&Iacute; CORRESPONDE A TODAS LAS PROMOCIONES QUE HA APLICADO HASTA LA FECHA CON UNA DESCRIPCI&Oacute;N Y LAS FECHAS DE VIGENCIA DE LAS MISMAS.</td>
                        </tr>

                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table>