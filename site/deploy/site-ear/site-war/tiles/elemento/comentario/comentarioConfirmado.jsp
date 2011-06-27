<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.controllers.comentario.ComentarioHelper,
				 com.tmk.kernel.Convert,
				 com.tmk.common.ComentarioClass,
				 com.tmk.bus.articulo.ArticuloManager,
				 com.tmk.bus.articulo.ArticuloClass,
				 com.tmk.service.categoria.CategoriaService"%>
<%response.addHeader("pragma", "no-cache"); %>
<%

int idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
ComentarioClass comentario = new ComentarioClass(0, idArticulo);
%>
<link href="/estilos/mesa.css" rel="stylesheet" type="text/css" />

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda" width="139"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top">
                <!-- ARBOL -->
                </td>
              </tr>
              <tr>
               <%
           			//String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + Globals.SECCION_HOME;
           	   %>
                	<%--<jsp:include page="<%=urlInstitucionalLeft%>"/>--%>
              </tr>
            </table></td>
            <td class="Gcentro" width="422"> <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td>
	                <table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
	                	<tr>
	                    	<td width="50" class="titulosceldas"><img src="/imagenes/t-agregarcoment.gif" alt="Agregar comentario" width="204" height="12" /></td>
	                  	</tr>
	                  	<tr>
	                    	<td class="moduloayuda">
	                    		<table width="370" border="0" cellspacing="0" cellpadding="0">
			                        <tr>
	    		                    	<td valign="bottom" class="Ftexto02">
	    		                    		<table width="370" border="0" cellspacing="0" cellpadding="0">
			  		                              <tr>
	                				                  <td width="238" height="20" valign="top" class="Ftexto02"><span class="FProductosDetalle"><%=Convert.corregir(comentario.getTituloArticulo(), true).toUpperCase()%></span></td>
	                              				  </tr>
					                              <tr>
	            				                    <td height="20" valign="bottom" class="Ftexto02"><span class="Ftextorojo">Gracias por enviarnos su opini&oacute;n.</span><br />

	                            				      	  <br>
						                                  El comentario estar&aacute; disponible por una hora y ser&aacute; publicado definitivamente   una vez que haya sido aprobado. Comentarios despectivos sobre el autor, editorial o nuestra empresa no ser&aacute;n publicados, como tampoco obscenidades o   malas palabras. Comentarios muy cortos o sin opiniones concretas no ser&aacute;n   publicados. Nuestra empresa se reserva el derecho de publicar el comentario en caso de dudas.<br>
						                                  <%
						                                  	ArticuloClass articulos[] = ArticuloManager.getArticulosParaUltimosVisitados(comentario.getIdArticulo()+"");
						                                  %>
						                                  <br><a href="<%=CategoriaService.getURL(articulos[0].getCategoria()) + ArticuloManager.getURL(articulos[0])%>">Vea su comentario aquí</a></td>

	                				              </tr>
					                          </table>
					                    </td>
			                        </tr>
	    		                </table>
	    		            </td>
	                  </tr>
	                </table>
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
            <td class="Gbarraderecha" width="162">
            	<% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
            </td>
          </tr>
<%--           <tr>
            <td colspan="3"><div align="center">
                 <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion="+ Globals.SECCION_HOME;%>
				 <jsp:include page="<%=urlInstitucional%>"/>
            </div></td>
          </tr>

          <tr>
            <td colspan=3>
            	<div align="center">
		            <table  border="0" cellpadding="0" cellspacing="0">
		            	<tr>
		            		<td>
					          <div class="Gfooter3"><h3 class="Ftextopie"><b>Libros, discos, pel&iacute;culas, pasatiempos. <br />
	              				Librer&iacute;a, disquer&iacute;a online.</b></h3></div>
	              		     </td>
					    </tr>
					</table>
				</div>
			</td>
          </tr>
--%>
        </table>