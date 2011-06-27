<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.src.listadeseos.ListaDeseosPK,
                 com.tmk.socio.SocioDomicilioPK,
                 com.tmk.kernel.DBUtil,                 
                 java.util.Iterator,
                 java.util.Vector"%>
<%-- 
	com.tmk.listaDeseos.ListaDeseosLocalHome,
    com.tmk.listaDeseos.ListaDeseosLocal,
	com.tmk.socio.SocioDomicilioLocal,
    com.tmk.socio.SocioDomicilioLocalHome,
	com.tmk.kernel.PaisDAO,
    com.tmk.kernel.ProvinciaDAO,
    com.tmk.kernel.LocalidadDAO,    
--%>

<%@page import="com.tmk.soa.servicios.ServiceLocator" %>
<%@page import="com.tmk.bus.articulo.CarritoListaDeseos" %>
<%@page import="com.tmk.bus.articulo.ListaDeseos"%>
<%@page import="com.tmk.bus.socio.SocioDomicilios"%>
<%@page import="com.tmk.bus.socio.SocioDomicilios"%>

<%
	SocioPK socioPK = new SocioPK(Integer.valueOf(request.getParameter("ID_SUCURSAL")), Integer.valueOf(request.getParameter("ID_SOCIO")));

%>

	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Lista de Deseos") %>
	</head>
<script src="/js/Validation.js" type="text/javascript"></script>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
          	<%--
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">

              	<%SocioPK socioPKReg = (SocioPK)session.getAttribute("Registracion.socioPK");
			 	if (socioPKReg != null) { %>
				<tr>
					<td valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
            			<tr>
							  <td align="left" class="preguntasceldas"><a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a></td>
		                </tr>
    		        </table></td>
	    	   	</tr>
    	   		<%}%>
            	<jsp:include page="/miCuenta/left.jsp"/>
             
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
							//DBO
							ListaDeseosPK listaPK = new ListaDeseosPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
							ListaDeseos listaDBO = ServiceLocator.getListaDeDeseosService().findByPrimaryKey(listaPK);
							
						%>

                        <tr>
                          <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="370" height="55" valign="top" class="Ftexto02"><div align="center"><img src="/imagenes/listaDeseos/listadedeseos-header.gif" alt="Lista de deseos" width="210" height="34" /></div></td>
                              </tr>
                              <tr>
                                <td height="20" valign="top" class="Ftexto02"><strong>RESULTADO DE B&Uacute;SQUEDA </strong></td>
                              </tr>
	                        <%
	                    		if (listaDBO != null) {
							%>
                              <tr>
                                <td valign="bottom" class="Ftexto02" style="padding-bottom:15px">
                                <table width="370" border="0" align="left" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td class="celdamodulodomicilio2"><table width="360" border="0" cellspacing="0" cellpadding="0">
                                      <tr>
                                        <td width="121" valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"> Nombres y Apellido: </td>
                                        <td width="239" valign="top" style="padding:4px 0px 4px 0px"><strong><%= listaDBO.getNombres() %> <%= listaDBO.getApellidos() %></strong> </td>
                                      </tr>
                                      <tr>
                                        <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"> Palabra Clave: </td>
                                        <td valign="top" style="padding:4px 0px 4px 0px"><%= listaDBO.getPalabras_claves() %></td>
                                      </tr>
                                      <tr>
                                        <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px">Direccion:</td>
                                        <td valign="top" style="padding:4px 0px 4px 0px">
                                    <%										
										//dbo
										if(listaDBO.getTipo_domicilio()!=null) {
											SocioDomicilios domicilio = listaDBO.getDomicilioDeseo();																
											
									%>

										<%= domicilio.getCalle() %>
										<%= domicilio.getNumero()%>
										<br>
										<%= (domicilio.getLocalidad()!=null) ? domicilio.getLocalidad().getDescripcion() : ""%>,
										<%= domicilio.getPais().getDescripcion()%>
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
                                        <td valign="top" style="padding:4px 0px 4px 0px"><strong><%= listaDBO.getCumpl_dia() %> de <%= meses[Math.max(listaDBO.getCumpl_mes().intValue(),1)-1] %></strong> </td>
                                      </tr>

                                    </table></td>
                                  </tr>


                                </table></td>
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

            <%
	            int comienzo = 1;
            	int cantidadPorPag = 5;
    	     	int fin = comienzo + cantidadPorPag-1;
            	if(listaDBO.getPublica().intValue() != 2) {
					Iterator productos = ServiceLocator.getCarritoListaDeseosService().findBySocio(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO).iterator();
		            Vector ids = new Vector();
	                  while(productos.hasNext()) {
	           			CarritoListaDeseos producto =(CarritoListaDeseos)productos.next(); 
	           			ids.add(producto.getId_articulo());
	                  }

	                  String idsArt = ids.subList(comienzo-1, Math.min((fin), ids.size())).toString().replaceAll("\\[", "").replaceAll("\\]", "");

			%>

			 <tr>
                <td><table width="390" border="0" cellspacing="0" cellpadding="0" class="modulobuscador">
                  <tr>
                    <td><table width="390" border="0" cellspacing="0" cellpadding="0" class="titulostabla">
                        <tr>
                          <td><span class="titulosceldas"><img src="/imagenes/listaDeseos/t-listadeseos.gif" alt="Lista de deseos" width="172" height="12" /></span>

                          </td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
           		  	<td>
	               	  <div id="ListaDES"><p style="color:green;">Cargando...</p>
	               	  </div>
	             	</td>
         		  </tr>
         		  <tr>
					<td class="celdapaginas">
						<div id="Paginado">
						</div>
					</td>
				  </tr>
                </table></td>
              </tr>
               	  <script type="text/javascript">

				var httpListaDes = getAjax();

				function traerLista(idArt) {
					httpListaDes.open('get', '/listaDeseos/listaAjax.jsp?idsArt=' + idArt + '&idSocio=<%=socioPK.ID_SOCIO%>&idSucursal=<%=socioPK.ID_SUCURSAL%>&param=' + Math.random());
				    httpListaDes.onreadystatechange = moduloLista;
				    httpListaDes.send(null);
				}

				function moduloLista() {
				    if(httpListaDes.readyState == 4){
				        var response = httpListaDes.responseText;
				        document.getElementById('ListaDES').innerHTML = response;
				    }
				}
				traerLista('<%=idsArt%>');

				var httpPag = getAjax();

			</script>
         	<tr>
				<td>
                	 <% String paginadoUrl = "/listaDeseos/paginado.jsp?cantArticulosPorPagina=" + cantidadPorPag + "&articulos=" + ids.toString().replaceAll("\\[", "").replaceAll("\\]", "") + "&comienzo=" + comienzo;%>
				  	 <jsp:include page="<%=paginadoUrl%>"/>
 	        	</td>
 	        </tr>

              <%} %>

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
                <jsp:include page="/listaDeseos/buscador.jsp"/>
                </td>
              </tr>
              	<!-- RECOMENDADOS -->
              <% String recoPage = "/listaDeseos/recomendados.jsp?ID_SOCIO=" + socioPK.ID_SOCIO + "&ID_SUCURSAL=" + socioPK.ID_SUCURSAL;%>
              <jsp:include page="<%=recoPage%>"/>
          		<!-- RECOMENDADOS -->
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
