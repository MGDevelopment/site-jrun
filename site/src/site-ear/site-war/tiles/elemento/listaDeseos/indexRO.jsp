<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 java.util.Iterator,
                 com.tmk.src.listadeseos.ListaDeseosPK,
                 com.tmk.socio.SocioDomicilioPK,
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert"%>

<%--
	com.tmk.kernel.PaisDAO,
    com.tmk.kernel.ProvinciaDAO,
    com.tmk.kernel.LocalidadDAO,
    com.tmk.listaDeseos.ListaDeseosLocalHome,
    com.tmk.listaDeseos.ListaDeseosLocal,
    com.tmk.socio.SocioDomicilioLocal,
    com.tmk.socio.SocioDomicilioLocalHome,
--%>


<%@page import="com.tmk.bus.articulo.ListaDeseos"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.bus.socio.SocioDomicilios"%>
<%@page import="com.tmk.soa.exceptions.DBOInexistenteException"%>

<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");%>
<%	Iterator listas = (Iterator)session.getAttribute("ListaDeseos.listas"); %>

<script src="/js/Validation.js" type="text/javascript"></script>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
          	<%--
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">

              	<%socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
			 	if (socioPK != null) { %>
				<tr>
					<td valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
            			<tr>
							  <td align="left" class="preguntasceldas"><a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a></td>
		                </tr>
    		        </table></td>
	    	   	</tr>
    	   		<%}%>
            	<jsp:include page="/miCuenta/left.jsp"/>

              <tr>
                 <%
           		String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + Globals.SECCION_HOME;
           	   %>
                <jsp:include page="<%=urlInstitucionalLeft%>"/>
              </tr>

            </table>
            </td>
            --%>
            <td class="Gcentro" width="422">


            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>

                <td>
                 <!-- principal -->
                <table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/listaDeseos/t-listadeseos.gif" alt="Lista de deseos" width="172" height="12" /></td>
                  </tr>
                  <tr>
                    <td class="moduloayuda"><table width="370" border="0" cellspacing="0" cellpadding="0">

						<%
						//ListaDeseosLocalHome listaHome = (ListaDeseosLocalHome)DBUtil.getHome("ListaDeseos");
						//SocioDomicilioLocalHome domicilioHome = (SocioDomicilioLocalHome)DBUtil.getHome("SocioDomicilio");

						%>
                        <tr>
                          <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="370" height="55" valign="top" class="Ftexto02"><div align="center"><img src="/imagenes/listaDeseos/listadedeseos-header.gif" alt="Lista de deseos" width="210" height="34" /></div></td>
                              </tr>
                              <%if(Convert.toBoolean(request.getParameter("busqueda"), false)) {%>
                              <tr>
                                <td height="20" valign="top" class="Ftexto02"><strong>RESULTADO DE B&Uacute;SQUEDA </strong></td>
                              </tr>
                              <%} %>
                        <%
                    		if (listas != null && listas.hasNext()) {

	                        	while(listas.hasNext()) {
	  								ListaDeseosPK listaPK = (ListaDeseosPK)listas.next();
		  							//ListaDeseosLocal lista = listaHome.findByPrimaryKey(listaPK);
		  							
		  							//DBO
		  							ListaDeseos listaDBO = null;
		  							try {
		  								listaDBO = ServiceLocator.getListaDeDeseosService().findByPrimaryKey(listaPK);
		  							}catch(DBOInexistenteException e) {
		  								
		  							}catch(Exception e) {
		  								
		  							}

  						%>
                              <tr>
                                <td valign="bottom" class="Ftexto02" style="padding-bottom:15px"><table width="370" border="0" align="left" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td class="celdamodulodomicilio2"><table width="360" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td width="121" valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"> Nombres y Apellido: </td>
                                        <%--<td width="239" valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"><strong><%= lista.getNOMBRES() %> <%= lista.getAPELLIDOS() %></strong> </td>--%>
                                        <td width="239" valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"><strong><%= listaDBO.getNombres() %> <%= listaDBO.getApellidos() %></strong> </td>
                                      </tr>
                                      <tr>
                                        <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"> Palabra Clave: </td>
                                        <%--<td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"><%= lista.getPALABRAS_CLAVES() %></td>--%>
                                        <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"><%= listaDBO.getPalabras_claves() %></td>
                                      </tr>
                                      <tr>
                                        <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px">Direccion:</td>
                                        <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px">
                                    <%
                                    	//if(lista.getTIPO_DOMICILIO() != null) {
                                    	if(listaDBO.getDomicilioDeseo() != null) {
											//SocioDomicilioPK domicilioPK = new SocioDomicilioPK(lista.getID_SUCURSAL_SOCIO(), lista.getID_SOCIO(), lista.getTIPO_DOMICILIO());
											//SocioDomicilioLocal domicilio = domicilioHome.findByPrimaryKey(domicilioPK);
											
											//DBO
											SocioDomicilios domicilio = listaDBO.getDomicilioDeseo();
									%>

										<%--= domicilio.getCALLE() %>
										<%= domicilio.getNUMERO() --%>
										<%= Convert.toString(domicilio.getCalle(),"") %>
										<%= Convert.toString(domicilio.getNumero(),"")%>
										<br>
										<%--
										PaisDAO paisDAO = PaisDAO.getPais(domicilio.getID_PAIS());
										ProvinciaDAO provinciaDAO = paisDAO.getProvincia(domicilio.getID_PROVINCIA());
										LocalidadDAO localidadDAO = provinciaDAO.getLocalidad(domicilio.getID_LOCALIDAD());
										--%>
										<%--= localidadDAO.getNombre() %>,
										<%= paisDAO.getNombre() --%>
										
										<%= (domicilio.getLocalidad()!=null)?Convert.toString(domicilio.getLocalidad().getDescripcion(),""):"" %>,
										<%= domicilio.getPais().getDescripcion() %>
										<%
										} else {
										%>Sin Definir<%
										}
										%>
										</td>
                                      </tr>
                                      <tr>
                                        <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"> Fecha de nacimiento: </td>
                                        <%
                                        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                                        %>
                                        <%--<td valign="top"  class="Ftexto02" style="padding:4px 0px 4px 0px"><strong><%= lista.getCUMPL_DIA() %> de <%= meses[Math.max(lista.getCUMPL_MES().intValue(),1)-1] %></strong> </td>--%>
                                        <td valign="top"  class="Ftexto02" style="padding:4px 0px 4px 0px"><strong><%= listaDBO.getCumpl_dia() %> de <%= meses[Math.max(listaDBO.getCumpl_mes().intValue(),1)-1] %></strong> </td>
                                      </tr>
                                      <tr>
                                        <%--<td colspan="2" valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"><div align="right"><a href="/listaDeseos/verLista.jsp?ID_SUCURSAL=<%= lista.getID_SUCURSAL_SOCIO() %>&ID_SOCIO=<%= lista.getID_SOCIO() %>"><img src="/imagenes/listaDeseos/b-verlista.gif" alt="Ver lista de deseos" width="110" height="8" border="0" style="padding-right:5px;" ></a></div></td>--%>
                                        <td colspan="2" valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"><div align="right"><a href="/listaDeseos/verLista.jsp?ID_SUCURSAL=<%= listaDBO.getId_sucursal_socio() %>&ID_SOCIO=<%= listaDBO.getId_socio() %>"><img src="/imagenes/listaDeseos/b-verlista.gif" alt="Ver lista de deseos" width="110" height="8" border="0" style="padding-right:5px;" ></a></div></td>
                                        </tr>
                                    </table></td>
                                  </tr>
                                </table></td>
                              </tr>
                        	<%
                        		}
	                        } else if(Convert.toBoolean(request.getParameter("busqueda"), false)) {
	                        %>
	                        <tr>
                                <td valign="bottom" class="Ftexto02" style="padding-bottom:15px">
                                No se han encontrado listas de deseos que se correspondan con su búsqueda, por favor intente nuevamente
                                </td>
                            </tr>
	                        <%
	                        }
	                        %>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
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
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
                  <tr>
                    <td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><span class="Ftexto02">AQU&Iacute; FIGURAN LAS LISTAS DE DESEOS QUE COINCIDEN CON SU CRITERIO DE B&Uacute;SQUEDA.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Ver Lista de deseos:</strong><br />
                            Presionando aqu&iacute; usted tiene acceso a los productos cargados en la lista de deseos seleccionada.</span></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td>
                <jsp:include page="/listaDeseos/buscador.jsp"/>
                </td>
              </tr>
            </table>
            </td>
          </tr>
        </table>
	</div>
</div>

<%if (Globals.esModoRelease()) {%>
<!-- Tag for Activity Group: Tematika website, Activity: Tematika  Lista Deseos -->

<!-- Start of DoubleClick Spotlight Tag: Please do not remove-->
<!-- Activity Name for this tag is:Tematika  Lista Deseos -->
<!-- Web site URL where tag should be placed: https://www.tematika.com/listaDeseos/indexRO.jsp -->
<!-- Creation Date:12/29/2006 -->
<SCRIPT language="JavaScript">
var axel = Math.random()+"";
var a = axel * 10000000000000;
document.write('<IMG SRC="https://ad.doubleclick.net/activity;src=1364770;type=tematsit;cat=tematl12;ord='+ a + '?" WIDTH=1 HEIGHT=1 BORDER=0>');
</SCRIPT>
<NOSCRIPT>
<IMG SRC="https://ad.doubleclick.net/activity;src=1364770;type=tematsit;cat=tematl12;ord=1?" WIDTH=1 HEIGHT=1 BORDER=0>
</NOSCRIPT>
<!-- End of DoubleClick Spotlight Tag: Please do not remove-->
<%} %>
<%=Globals.getGoogleAnalyticsSSL()%>
