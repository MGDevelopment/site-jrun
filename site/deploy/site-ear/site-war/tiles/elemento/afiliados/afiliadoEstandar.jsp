<script src="/js/Validation.js" type="text/javascript"></script>
<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert"			 		
%> 
<%= Globals.title("Programa de Afiliados") %>
<%= Globals.keywords("Programa de Afiliados, Comision, Ganancia, Porcentaje sobre Ventas") %>

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
<!-- INCLUDE PAGINA AFILIADO -->                

                
               <% String urlAfiliado = Convert.toString(request.getParameter("page"));%>
				<jsp:include page="<%=urlAfiliado%>"/>             
              
                
                
<!-- INCLUDE PAGINA AFILIADO -->                
              </tr>
              
            </table></td>
           <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">
<!-- si por parametro viene cambiaRight=true cambia el institucionalRight por texto del form de alta de afiliado -->
          <% 
          boolean cambiaRight = "true".equals(request.getParameter("cambiaRight"));         		
	          if(cambiaRight){ 
       	  %>
       	      <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                          <tr>
                            <td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td><span class="Ftexto02">Todos los datos ser&aacute;n validados antes de ser procesado el formulario (SA1). En   caso de existir alg&uacute;n campo incompleto se solicitar&aacute; al usuario que verifique lo   ingresado. Una vez completado correctamente el formulario y enviado a Tematika,   el sistema le asignar&aacute; un c&oacute;digo de alianza autom&aacute;ticamente, y nuestro nuevo   socio afiliado (Contacto) recibir&aacute; un e-mail en donde se le informar&aacute; la   aceptaci&oacute;n de su alta. A partir de este momento ser&aacute; un canal de comunicaci&oacute;n   entre nosotros y el afiliado. Una vez confirmada su alta de afiliado, estar&iacute;a en   condiciones de acceder a nuestra exclusiva Extranet de Afiliados, en donde   contar&aacute; con todos los beneficios anteriormente detallados.</span></td>

                                </tr>

                            </table></td>
                          </tr>
                      </table></td>
                    </tr>
                </table></td>
              </tr>
			<%
	          }else{
			%>
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>  

			<%} %>
           </table></td>
          </tr>
        </table>
<%=Globals.getGoogleAnalyticsSSL()%>

