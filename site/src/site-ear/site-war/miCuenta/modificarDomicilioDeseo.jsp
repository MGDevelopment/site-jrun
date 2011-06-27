<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.orden.OrdenDAO"%>

<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	if(socioPK == null) {
		session.setAttribute("URL_REDIRECT", "/listaDeseos/domicilios.jsp?TIPO_DOMICILIO=ENVI");
%>
		<jsp:forward page="/miCuenta/index.jsp" />
<%	}
%>
<%	OrdenDAO ordenDAO = (OrdenDAO)session.getAttribute("ordenDAO"); %>

<%= Globals.icon() %>
<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td class="Gcentro" width="422">
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
               <td>
               	<!--principal  -->
            		<jsp:include page="/miCuenta/comunes/modificarDomicilio.jsp" />
            	<!--principal  -->
				</td></tr>

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
        	    </table>
        	</td>
            <td class="Gbarraderecha" width="155">
            <!--BARRRA DERECHA -->
            <table width="155" border="0" cellspacing="0" cellpadding="0">

              <tr>
                <td>
               		<table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
	                  	<tr>
	                    	<td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
			                      <tr>
			                        <td><span class="Ftexto02">AQU&Iacute; SE PRESENTA EL FORMULARIO CON LOS DATOS CORRESPONDIENTES AL DOMICILIO QUE USTED SELECCION&Oacute;.</span></td>
			                      </tr>
			                      <tr>
			                        <td class="moduloordencelda"><span class="Ftexto02">Modifique cualquiera de los campos con la nueva informaci&oacute;n.</span></td>
			                      </tr>
			                      <tr>
			                        <td class="moduloordencelda"><span class="Ftexto02">Presionando el bot&oacute;n <em>Modificar domicilio</em> usted vuelve a la p&aacute;gina anterior y sus cambios habr&aacute;n sido actualizados.</span></td>
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
	</div>
</div>        