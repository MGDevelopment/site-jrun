<%@ page import="java.util.*,
                 java.text.DecimalFormat,
				 java.text.SimpleDateFormat,
				 com.tmk.common.SucursalLocalHome,
				 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.MesDAO,
				 com.tmk.setup.Contenido,
				 com.tmk.kernel.Globals,
				 com.tmk.kernel.site.Evento"%>
<link href="/estilos/mesa.css" rel="stylesheet" type="text/css" />				 
				 
<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
                  <tr>
                    <td align="left" valign="top">
	                    <!-- ARBOL -->
    	        		<%--
//        			    String arbolPage = "/componentes/inicio/arbolCategoriaInicio.jsp";
    	        		String arbolPage = "/contenidosEstaticos/homes/arbolCategorias" + Globals.SECCION_HOME + ".html";
		            	%>
        		    	<jsp:include page="<%=arbolPage%>"/--%>
                		<!-- ARBOL -->  
                    </td>
                  </tr>
                  <tr>
                    <%
            			String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + Globals.SECCION_HOME;
            	  	%>                           
                	<jsp:include page="<%=urlInstitucionalLeft%>"/>      
                  </tr>
                </table></td>
              </tr>
            </table></td>
            <td class="Gcentro" width="422"><table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              
		<!-- tabla eventos -->

			<td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-eventos.gif" alt="Eventos" width="129" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">

			<% for (int mesesActual = 0; mesesActual < 2; mesesActual++) { %>

 				<%	DecimalFormat df = new DecimalFormat("00");

				    Date ahora = new Date();
					int esteMes = ahora.getMonth();
					int esteAño = ahora.getYear() + 1900;

					GregorianCalendar gc_actual = new GregorianCalendar(esteAño, esteMes + mesesActual, 1);
					GregorianCalendar gc_futuro = new GregorianCalendar(esteAño, esteMes + mesesActual + 1, 1);

					Enumeration eventos = Contenido.getSite().getEventos().enumerateEvento();
					SucursalLocalHome sucursalHome = (SucursalLocalHome)DBUtil.getHome("Sucursal");

					Vector vecDiaEvento = new Vector();
					Vector vecMesEvento = new Vector();
					Vector vecSucursalEvento= new Vector();
					Vector vecDescripcion = new Vector();
					Vector vecFechaEvento = new Vector();

					while(eventos.hasMoreElements()) {
						Evento evento = (Evento) eventos.nextElement();

						if ((evento.getFecha().getMonth() == gc_actual.get(Calendar.MONTH)) && (evento.getActivo())) {
							vecDiaEvento.add(new Integer(evento.getFecha().getDate())) ;
							vecMesEvento.add(new Integer(evento.getFecha().getMonth()));
							vecFechaEvento.add(evento.getFecha());
							vecSucursalEvento.add(Convert.capitalizar(sucursalHome.findByPrimaryKey(new Integer(evento.getSucursal())).getDESCRIPCION(), true));
							vecDescripcion.add(evento.getDescripcion());
						}
					}
				%>
                      <tr>
                      <%if(vecFechaEvento.size()==0){
                        	}else{ %>
                        <td><table width="366" border="0" cellpadding="0" cellspacing="0" class="tablaevento">
                        <tr>
                        	<td><div align="left"><h2><span class="FTtit01"><%= MesDAO.getMes(gc_actual.get(Calendar.MONTH) + 1).getNombre().toUpperCase()%></span></h2></div>
                     
    	                     <%	SimpleDateFormat formateador = new SimpleDateFormat("EEEE dd");
								for (int i = 0; i < vecFechaEvento.size(); i++) {
  							 %> 	
  							 	<p class="FTtit01"><%= Convert.capitalizar(formateador.format(vecFechaEvento.get(i)), false) + " a las " + vecFechaEvento.get(i).toString().substring(11,16) + " horas"%> </p>
	                            <p class="Ftexto02"> <%=vecDescripcion.get(i)%><br />
                            		<span class="Ftextorojo"><%= vecSucursalEvento.get(i)%></span>
                             	</p>
           				  	 <% } %>                             
							</td>
                        </tr>
                        </table></td>
                     <%}%>                       
                      </tr>
	      <% } %>    
	      			 </table></td>
                  </tr>
              </table></td>
		<!-- fin tabla eventos -->              
              </tr>
              <tr>
              	<!-- ultimos visitados -->
    	        	<td>
        	     	<%
            			String ultimosVisitadosPage = "/componentes/comunes/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            		%>
	            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
                	</td>
               	<!-- ultimos visitados -->         

              </tr>
            </table></td>
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">

            <jsp:include page="/general/eventosRight.htm"/>

            <tr>
                 <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>  
              </tr>
            </table></td>
          </tr>
          <!--  tr>            
            <td colspan="3" height="25" align="center"><h2 class="Ftextopie"><b>Eventos - Venta de entradas y tickets </b></h2></td>
            
          </tr> -->         

        </table>

<%=Globals.getGoogleAnalytics()%>

