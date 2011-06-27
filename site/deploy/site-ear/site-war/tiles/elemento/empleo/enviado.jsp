<%@ page import="com.tmk.kernel.Globals"%>
        <table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td class="Gcentro" width="422">
            	<table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
	              <tr>
    	            <td>
        	        	<table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
            	      		<tr>
		        	            <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-empleo.gif" alt="Oportunidad de Empleo" width="220" height="12" /></td>
        	        	    </tr>
		                	<tr>
        		            	<td class="moduloayuda"><p class="Ftextorojo">Su informaci&oacute;n ha sido enviada a nuestro departamento de Recursos Humanos. En caso de tener una b&uacute;squeda acorde a su perfil nos comunicaremos con usted.</p>
	                		      <p class="Ftextorojo">Muchas Gracias. </p></td>
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
    	        </table>
    	    </td>
            <td class="Gbarraderecha" width="155">
            	<table width="155" border="0" cellspacing="0" cellpadding="0">
              		<tr>
		                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
						  <jsp:include page="<%=urlInstitucionalRight%>"/>
		            </tr>
        	    </table>
          	</td>
          </tr>
        </table>
      </td>
    </tr>
    </table></td>
  </tr>
</table>
