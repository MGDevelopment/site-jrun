<%@ page import="com.tmk.kernel.Globals"%>
<link href="/estilos/mesaSeccion.css" rel="stylesheet" type="text/css" />
<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top"><table width="130" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                	<td align="left" valign="top">
	                <!-- ARBOL -->
    	        	<%--
        	    	//String arbolPage = "/componentes/inicio/arbolCategoriaInicio.jsp";
            		String arbolPage = "/contenidosEstaticos/homes/arbolCategorias" + Globals.SECCION_HOME + ".html";
            		%>
	            	<jsp:include page="<%=arbolPage%>"/--%>
    	            <!-- ARBOL -->                 
        	        </td>
            	  </tr>                  
            	</table></td>
          	  </tr>
              <tr>
               <%
           		String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + Globals.SECCION_HOME;
           	   %>                           
               <jsp:include page="<%=urlInstitucionalLeft%>"/> 
              </tr>            
            </table></td>
            <td class="Gcentro" width="422"><table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-afiliados.gif" alt="Programa de afiliados" width="219" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda"><table width="370" border="0" cellspacing="0" cellpadding="0">

                        <tr>
                          <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="370" height="20" valign="top" class="Ftexto02"><span class="FTtit01">FORME PARTE DE NUESTRO PROGRAMA DE AFILIADOS:</span><br />
                                  <br />
                                  - Gestione su afiliacion<br />

                                  - Coloque en su sitio links a Tematika.com<br />
                                  - Ofrezca a sus clientes o usuarios nuestro servicio para la compra de productos de inter&eacute;s cultural y de    entretenimientos: Libros, Discos y Pel&iacute;culas 
                                  - Reciba comisiones sobre las ventas efectivas referidas desde un 5% hasta un 20%. </td>
                              </tr>

                              <tr>
                                <td height="40" valign="bottom"><table width="370" border="0" align="left" cellpadding="0" cellspacing="0">
                                  <tr>

                                    <td class="celdamodulodomicilio2"><table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
                                        <tr>
                                          <td width="185" valign="middle"><a href="/afiliados/afiliadoEstandar.jsp?page=/afiliados/verAcuerdo.jsp"><img src="/imagenes/inicio/b-registrarse.gif" alt="Registrarse como afiliado" width="90" height="10" border="0" /></a></td>
                                          <td width="175" height="20" valign="middle"><div align="right"><a href="/extranet/index.jsp"><img src="/imagenes/inicio/b-ingresar.gif" alt="Ingresar como afiliado" width="64" height="10" border="0" /></a></div></td>
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
            <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">

                        <tr>
                          <td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
                              <tr>
                                <td><span class="Ftexto02">INFORMACION SOBRE NUESTRO PROGRAMA DE AFILIADOS:</span></td>
                              </tr>
                              <tr>
                                <td class="moduloordencelda"><span class="Ftexto02"><strong>Pago de comisiones al Afiliado</strong>:<br />

                                  Puede elegir dos esquemas variables de comisiones.<br />
                                  <a href="/afiliados/afiliadoEstandar.jsp?page=/afiliados/verComisiones.jsp?info=true" class="FSubCategorias2">Haga clic aqu&iacute;</a> para conocerlos.</span></td>
                              </tr>
                              <tr>
                                <td class="moduloordencelda"><span class="Ftexto02"><strong>Herramientas tecnol&oacute;gicas de rastreo</strong>:<br />

                                  Le ofrecemos links parametrizados que nos permiten identificarlo como afiliado. 
                                  C&oacute;mo funciona y c&oacute;mo acceder a nuestra informaci&oacute;n de ventas y visitas desde su sitio web.<br />
                                  <a href="/inicio/index.jsp?URL_GRUPO=/grupos/interior/manualafiliado.html " target="_blank" class="FSubCategorias2">Url's / Links a <%=Globals.NOMBRE_DEL_SITIO%> y Manual de Uso</a>.</span>
								  <br>
                                  <a href="/inicio/index.jsp?URL_GRUPO=/grupos/interior/rss.html" target="_blank" class="FSubCategorias2"> Manual de uso de RSS </a>
                                  </td>
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
<%=Globals.getGoogleAnalyticsSSL()%>

