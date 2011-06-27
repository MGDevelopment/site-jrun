<%@ page import="com.tmk.kernel.Globals"%>

<%

	String letra = request.getParameter("letra");
	String pagina = request.getParameter("pagina");

	if ("Ñ".equals(letra)) {
		letra = "N_1";
	}
	if ("1".equals(letra)) {
		letra = "091";
	}
	if ("2".equals(letra)) {
		letra = "091";
	}
	if ("3".equals(letra)) {
		letra = "091";
	}
	if ("4".equals(letra)) {
		letra = "091";
	}
	if ("5".equals(letra)) {
		letra = "091";
	}
	if ("6".equals(letra)) {
		letra = "091";
	}
	if ("7".equals(letra)) {
		letra = "091";
	}
	if ("8".equals(letra)) {
		letra = "091";
	}
	if ("9".equals(letra)) {
		letra = "091";
	}
	if ("0".equals(letra)) {
		letra = "091";
	}
%>
<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
<tr>
<td class="Gcentro">
	<table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
    	        <tr>
                  <td>

                  <div align="center">

                      <table width="390" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="60" valign="top">

                          <table width="390" height="30" border="0" align="center" cellspacing="0" class="resultadonum">
                            <tr>

                              <td valign="middle">

                              <%if(letra!=null && "09".equals(letra)){%><span class="Ftexto06">0...9</span><%}else{ %><a href="/indice/index.jsp?letra=09&pagina=1" class="FAyuda">0...9</a><%} %>
                              <%if(letra!=null && "A".equals(letra)){%><span class="Ftexto06">A</span><%}else{ %><a href="/indice/index.jsp?letra=A&pagina=1" class="FAyuda">A</a><%} %>
                              <%if(letra!=null && "B".equals(letra)){%><span class="Ftexto06">B</span><%}else{ %><a href="/indice/index.jsp?letra=B&pagina=1" class="FAyuda">B</a><%} %>
                              <%if(letra!=null && "C".equals(letra)){%><span class="Ftexto06">C</span><%}else{ %><a href="/indice/index.jsp?letra=C&pagina=1" class="FAyuda">C</a><%} %>
                              <%if(letra!=null && "D".equals(letra)){%><span class="Ftexto06">D</span><%}else{ %><a href="/indice/index.jsp?letra=D&pagina=1" class="FAyuda">D</a><%} %>
                              <%if(letra!=null && "E".equals(letra)){%><span class="Ftexto06">E</span><%}else{ %><a href="/indice/index.jsp?letra=E&pagina=1" class="FAyuda">E</a><%} %>
                              <%if(letra!=null && "F".equals(letra)){%><span class="Ftexto06">F</span><%}else{ %><a href="/indice/index.jsp?letra=F&pagina=1" class="FAyuda">F</a><%} %>
                              <%if(letra!=null && "G".equals(letra)){%><span class="Ftexto06">G</span><%}else{ %><a href="/indice/index.jsp?letra=G&pagina=1" class="FAyuda">G</a><%} %>
                              <%if(letra!=null && "H".equals(letra)){%><span class="Ftexto06">H</span><%}else{ %><a href="/indice/index.jsp?letra=H&pagina=1" class="FAyuda">H</a><%} %>
                              <%if(letra!=null && "I".equals(letra)){%><span class="Ftexto06">I</span><%}else{ %><a href="/indice/index.jsp?letra=I&pagina=1" class="FAyuda">I</a><%} %>
                              <%if(letra!=null && "J".equals(letra)){%><span class="Ftexto06">J</span><%}else{ %><a href="/indice/index.jsp?letra=J&pagina=1" class="FAyuda">J</a><%} %>
                              <%if(letra!=null && "K".equals(letra)){%><span class="Ftexto06">K</span><%}else{ %><a href="/indice/index.jsp?letra=K&pagina=1" class="FAyuda">K</a><%} %>
                              <%if(letra!=null && "L".equals(letra)){%><span class="Ftexto06">L</span><%}else{ %><a href="/indice/index.jsp?letra=L&pagina=1" class="FAyuda">L</a><%} %>
                              <%if(letra!=null && "M".equals(letra)){%><span class="Ftexto06">M</span><%}else{ %><a href="/indice/index.jsp?letra=M&pagina=1" class="FAyuda">M</a><%} %>
                              <%if(letra!=null && "N".equals(letra)){%><span class="Ftexto06">N</span><%}else{ %><a href="/indice/index.jsp?letra=N&pagina=1" class="FAyuda">N</a><%} %>
                              <%if(letra!=null && "N_".equals(letra)){%><span class="Ftexto06">Ñ</span><%}else{ %><a href="/indice/index.jsp?letra=N_&pagina=1" class="FAyuda">Ñ</a><%} %>
                              <%if(letra!=null && "O".equals(letra)){%><span class="Ftexto06">O</span><%}else{ %><a href="/indice/index.jsp?letra=O&pagina=1" class="FAyuda">O</a><%} %>
                              <%if(letra!=null && "P".equals(letra)){%><span class="Ftexto06">P</span><%}else{ %><a href="/indice/index.jsp?letra=P&pagina=1" class="FAyuda">P</a><%} %>
                              <%if(letra!=null && "Q".equals(letra)){%><span class="Ftexto06">Q</span><%}else{ %><a href="/indice/index.jsp?letra=Q&pagina=1" class="FAyuda">Q</a><%} %>
                              <%if(letra!=null && "R".equals(letra)){%><span class="Ftexto06">R</span><%}else{ %><a href="/indice/index.jsp?letra=R&pagina=1" class="FAyuda">R</a><%} %>
                              <%if(letra!=null && "S".equals(letra)){%><span class="Ftexto06">S</span><%}else{ %><a href="/indice/index.jsp?letra=S&pagina=1" class="FAyuda">S</a><%} %>
                              <%if(letra!=null && "T".equals(letra)){%><span class="Ftexto06">T</span><%}else{ %><a href="/indice/index.jsp?letra=T&pagina=1" class="FAyuda">T</a><%} %>
                              <%if(letra!=null && "U".equals(letra)){%><span class="Ftexto06">U</span><%}else{ %><a href="/indice/index.jsp?letra=U&pagina=1" class="FAyuda">U</a><%} %>
                              <%if(letra!=null && "V".equals(letra)){%><span class="Ftexto06">V</span><%}else{ %><a href="/indice/index.jsp?letra=V&pagina=1" class="FAyuda">V</a><%} %>
                              <%if(letra!=null && "W".equals(letra)){%><span class="Ftexto06">W</span><%}else{ %><a href="/indice/index.jsp?letra=W&pagina=1" class="FAyuda">W</a><%} %>
                              <%if(letra!=null && "X".equals(letra)){%><span class="Ftexto06">X</span><%}else{ %><a href="/indice/index.jsp?letra=X&pagina=1" class="FAyuda">X</a><%} %>
                              <%if(letra!=null && "Y".equals(letra)){%><span class="Ftexto06">Y</span><%}else{ %><a href="/indice/index.jsp?letra=Y&pagina=1" class="FAyuda">Y</a><%} %>
                              <%if(letra!=null && "Z".equals(letra)){%><span class="Ftexto06">Z</span><%}else{ %><a href="/indice/index.jsp?letra=Z&pagina=1" class="FAyuda">Z</a><%} %>

                              </td>

                            </tr>
                          </table></td>
                        </tr>
<!-- PAGINA DE INDICE -->

			<%
				String urlPagina;
					if (letra != null) {
						urlPagina = "/directorio/listado" + letra + pagina + ".html";
						if(pagina==null){
							urlPagina = "/directorio/listado" + letra + "1.html";
						}

			%>
		         	<jsp:include page="<%=urlPagina%>"/>
		    <%
		    		}

		    %>
						<tr>
						</tr>
                      </table>
                  </div></td>
        	    </tr>

<!-- PAGINA DE INDICE -->
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

	           	 <td class="Gbarraderecha">
	           	 	<table width="155" border="0" cellpadding="0" cellspacing="0" >
    	            	<tr>
        	          		<td class="Ftexto02">
        	          			<table width="155" border="0" cellpadding="0" cellspacing="0" >
            	          			<tr>
			                	        <td class="tablaaccesos">
			                	        	<table width="155" border="0" cellspacing="0" cellpadding="0">
				                    	        <tr>
                					        	      <td class="Ftexto02">Si no tuvo un resultado<br />
                            	    					satisfactorio, pruebe con:</td>
					                            </tr>
    	        				                <tr>
        	                    				  <td><div align="left">
        	                    				  <a href="/articulo/buscadorAvanzado.jsp?idSeccion=1&seccion=1">
        	                    				  <img style="padding-top:7px" src="/imagenes/inicio/b-bavanzada.gif" alt="B&uacute;squeda avanzada" width="114" height="10" border="0" class="accesos02" /></a></div></td>
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
        </table>

