<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.src.listadeseos.ListaDeseosPK,                 
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.PaisDAO,
                 com.tmk.kernel.ProvinciaDAO,
                 com.tmk.kernel.LocalidadDAO,
                 java.util.Iterator,                 
                 java.util.Vector,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper"%>

<%SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK"); %>

<%@page import="com.tmk.bus.articulo.CarritoListaDeseos"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.bus.articulo.ListaDeseos"%>
<%@page import="com.tmk.bus.socio.SocioDomicilios"%>
<%@page import="com.tmk.soa.exceptions.DBOInexistenteException"%>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
	<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
          	<%--
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">

              	<%
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
            </td>--%>
            <td class="Gcentro" width="422">

           <%
				//DBO
				ListaDeseosPK listaPK = new ListaDeseosPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
				ListaDeseos listaDBO = null;
				try{
					listaDBO = ServiceLocator.getListaDeDeseosService().findByPrimaryKey(listaPK);
				}catch(DBOInexistenteException e) {
					
				}catch(Exception e) {
					
				}
			%>
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
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
                                <td width="370" height="10" valign="bottom" class="Ftexto02">
                                <%
	                    			//if (lista != null) {
	                    			if (listaDBO != null) {
								%>
                                <table width="370" border="0" cellspacing="0" cellpadding="0" class="tabladomicilios">
                                  <tr>
                                    <td height="20" colspan="2" valign="top" class="FTtit01">DATOS DE MI LISTA </td>
                                    </tr>

                                  <tr>
                                    <td width="116" valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px">Nombres: </td>
                                    <td width="254" class="Ftexto02" valign="top" style="padding:4px 0px 4px 0px"><strong><%= listaDBO.getNombres() %> </strong></td>
                                  </tr>
                                  <tr>
                                    <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px">Apellidos: </td>
                                    <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"><strong><%= listaDBO.getApellidos() %></strong></td>
                                  </tr>
                                  <tr>
                                    <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px">Palabras clave : </td>
                                    <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px"><span class="Ftexto02"><%= listaDBO.getPalabras_claves() %></span></td>
                                  </tr>


                                  <tr>
                                    <td valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px">Fecha de nacimiento: </td>
                                    <td valign="top" style="padding:4px 0px 4px 0px" class="Ftexto02"><strong> <%
                                        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                                        %>
                                        <%= listaDBO.getCumpl_dia() %> de <%= meses[Math.max(listaDBO.getCumpl_mes().intValue(),1)-1] %>
                                        </strong></td>
                                  </tr>

                                  <tr>
                                    <td height="20" colspan="2" valign="top" class="Ftexto02">
                                    <div align="right">
<a href="/miCuenta/?seccionMiCuenta=7"><img src="/imagenes/listaDeseos/b-modificar.gif" alt="Enviar" width="60" height="10" border="0"  style="padding-bottom:5px"></a>
                                    </div></td>
                                  </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td height="10" valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0" class="tabladomicilios">
                                  <tr>
                                    <td height="20" colspan="2" valign="top" class="FTtit01">DIRECCION DE ENVIO</td>
                                  </tr>
                                  <tr>
                                    <td colspan="2" valign="top" class="Ftexto02" style="padding:4px 0px 4px 0px">
									<%	
										if(listaDBO.getDomicilioDeseo() != null) {											
											//DBO
											SocioDomicilios domicilio = listaDBO.getDomicilioDeseo();
											
									%>
										<%= domicilio.getCalle() %>&nbsp;
										<%= domicilio.getNumero() %>
										<br>
										<%= (domicilio.getLocalidad()!=null)?domicilio.getLocalidad().getDescripcion():"" %>
										<br>
										<%= domicilio.getPais().getDescripcion() %>
										<%
										} else {
										%>Sin Definir<%
										}
										%>
										</td>
                                    </tr>
                                  <tr>
                                    <td height="20" colspan="2" valign="top" class="Ftexto02"><div align="right">
										<a href="/miCuenta/?seccionMiCuenta=10&TIPO_DOMICILIO=ENVI"><img src="/imagenes/listaDeseos/b-modificar.gif" alt="Enviar" width="60" height="10" border="0"  style="padding-bottom:5px"></a>
                                    </div></td>
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
                </table>
              </td>
              </tr>
               <!--principal  -->
            <%
	            int comienzo = 1;
            	int cantidadPorPag = 5;
    	     	int fin = comienzo + cantidadPorPag-1;
				//DBO
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
                  <tr><!-- se carga con ajax la lista de deseos -->
           		  	<td>
	               	  <div id="ListaDES"><p style="color:green;">Cargando lista...</p>
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
					httpListaDes.open('get', '/listaDeseos/listaAjax.jsp?eliminar=true&idsArt=' + idArt + '&param=' + Math.random());
				    httpListaDes.onreadystatechange = moduloLista;
				    httpListaDes.send(null);
				}

				function moduloLista() {
				    if(httpListaDes.readyState == 4){
				        var response = httpListaDes.responseText;
				        document.getElementById('ListaDES').innerHTML = response;
				    }
				}
				var idsArt ='<%=idsArt%>';
				traerLista(idsArt);

				var httpPag = getAjax();


			</script>
			<tr>
				<td>
                	 <% String paginadoUrl = "/listaDeseos/paginado.jsp?cantArticulosPorPagina=" + cantidadPorPag + "&articulos=" + ids.toString().replaceAll("\\[", "").replaceAll("\\]", "") + "&comienzo=" + comienzo;%>
				  	 <jsp:include page="<%=paginadoUrl%>"/>
 	        	</td>
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