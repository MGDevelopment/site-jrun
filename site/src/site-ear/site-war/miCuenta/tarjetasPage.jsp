<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.util.ShortCuts,
                 com.tmk.socio.TarjetaSocioLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.socio.TarjetaSocioLocal,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Seguridad,
                 com.tmk.kernel.MedioDeCobroDAO,
                 com.tmk.kernel.Convert,
                 com.tmk.bus.socio.Socios2,
                 com.tmk.controllers.MainHelper" %>


<%--
                 //com.tmk.socio.SocioLocal
--%>

<%	
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/?seccionMiCuenta=12&opcionMenuTarjeta=tarjetas.jsp");
%>
		<jsp:forward page="/miCuenta" />
<%	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT,  "/miCuenta/tarjetas.jsp");
%>
		<jsp:forward page="<%=MainHelper.PAGE_REGISTRO_SOCIO_CADENA%>" />
<%	}%>

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <%if (socioPK != null) { %>
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
                    <td class="moduloayuda"><table  class="Ftexto02" width="366" border="0" cellspacing="0" cellpadding="0">


        <!--MUESTRA LAS TARJETAS -->
				<%
				Integer ID_SUCURSAL = socioPK.ID_SUCURSAL;
				Integer ID_SOCIO = socioPK.ID_SOCIO;

                //SocioLocal socio = ShortCuts.findSocioById(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));

                Socios2 socio = ShortCuts.findSocioById(socioPK);
                
				TarjetaSocioLocalHome tarjetaHome = (TarjetaSocioLocalHome)DBUtil.getHome("TarjetaSocio");
				Iterator tarjetas = tarjetaHome.findBySocio(ID_SUCURSAL, ID_SOCIO).iterator();
				int i=0;
				while(tarjetas.hasNext())
				{
					TarjetaSocioLocal tarjeta = (TarjetaSocioLocal)tarjetas.next();
					i++;
					%>

                      <tr>
                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                            <tr>
                              <td width="26" valign="middle"><div align="left">
                                  <input name="tarjeta" type="radio" value="radiobutton" id="tarjeta<%=i%>" checked/>
                              </div></td>
                              <td width="340" valign="middle"><span class="FTtit01">TARJETA <%=i%> </span></td>
                            </tr>
                            <tr>
                              <td colspan="2"><table class="Ftexto02" width="366" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td width="305" style="padding-left:5px"><%= MedioDeCobroDAO.buscaMedioDeCobro(tarjeta.getID_MEDIO_COBRO()).getNombre() %><br />
                                      <%= Seguridad.numeroTarjetaAMostrar(tarjeta.getNRO_TARJETA()) %><br />
                                      <%--= Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS()) %><br />--%>
                                      <%= Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()) %><br />
                                      <%--=socio.getTIPO_DOC() + " " + socio.getNRO_DOC()%><br />--%>
                                      <%=socio.getTipo_doc() + " " + socio.getNro_doc() %><br />
                                      <%=Convert.toString(tarjeta.getDIRECCION_RESUMEN()) %> <br /></td>
                                    <td width="61" valign="bottom"><div align="right"><a href="/EliminarTarjeta?ID_ITEM=<%= tarjeta.getID_ITEM()%>"><img onclick="document.getElementById('tarjeta<%=i%>').checked=true;" src="/imagenes/miCuenta/b-eliminar.gif" alt="Modificar domicilio" width="49" height="10" border="0" style="padding-right:15px" /></a></div></td>
                                  </tr>
                              </table></td>
                            </tr>
                            <tr>
                              <td colspan="2">&nbsp;</td>
                            </tr>
                        </table></td>
                      </tr>
		     <% } %>
		     		<% if(i==0){%>
		     	     <tr>
						<td align="center" class="Ftexto01">
							<strong>NO HAY TARJETAS CARGADAS HASTA EL MOMENTO</strong>
						</td>
					 </tr>
                     <%} %>

       <!-- MUESTRA LAS TARJETAS -->
                      <tr>
                        <td><br>
                        <div align="right"><a href="/miCuenta/agregarTarjeta.jsp"><img src="/imagenes/miCuenta/b-agregartarjeta.gif" alt="Agregar tarjeta" width="120" height="10" border="" class="benviar2" /></a></div></td>
                        </tr>
                    </table>
                    </td>
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
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><span class="Ftexto02">EN ESTA PANTALLA USTED PUEDE VER TODAS LAS TARJETAS DE CR&Eacute;DITO QUE INGRES&Oacute;.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Eliminar:</strong> <br />
                            Haciendo clic en el bot&oacute;n <em>Eliminar</em> usted borra la tarjeta de su lista.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Agregar Tarjeta: </strong><br />
                            Presionando el bot&oacute;n <em>Agregar tarjeta</em> usted accede al formulario para cargar una nueva tarjeta de cr&eacute;dito. .</span></td>
                        </tr>

                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>