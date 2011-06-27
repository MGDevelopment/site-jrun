<%@page import="com.tmk.kernel.Globals"%>
<%--
<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="400" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>       
            <td class="Gcentro" width="400">
            <table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                 <table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>
                  <tr>
                  	<td  class="moduloAyuda" bgcolor="#F3F4F5" style="padding:10px">
                  		<div id="formModificacion" onSubmit="return false">
							<table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td align="left">
										<p>Popego es un servicio de clasificación de intereses y recomendación de contenidos.<p> 
										Al integrarlo con tu cuenta de Tematika, tus comentarios sobre productos mostrarán al resto de los usuarios de nuestro sitio tu perfil de intereses. De esta manera, los contenidos generados
										por nuestra comunidad de usuarios podrán ser relacionados con quienes los generan y así brindar mayor relevancia a quienes buscan recomendaciones de pares a la hora de comprar.										
									</td>
								</tr>
								<tr>
							      	<td colspan="1">
							      		<img src="/imagenes/com.JPG">
							      	</td>
							    </tr>
							    <tr>
							     	<td colspan="1">
							      		<img src="/imagenes/comPop.JPG">
							      	</td>
							    </tr>
							    <tr>
									<td >
										<div id="registroExtraFin">
									         <a href="/miCuenta/servicios/popego.jsp" style="cursor:pointer">
									         <img src="/imagenes/inicio/b-asociarServ.gif" alt="" border="0" tabindex="18"/></a>
									    </div>
									</td>
								</tr>
							</table>		                  	

                  		</div>
                   <div id="modificacionExitosa" class="cuadroExitoExterno" style="display:none;width:370px">
                   <a id="hrefModificacionExitosa" href="#"></a>
                   <div  class="cuadroExito">
                   		<div class="cuadroExitoTitulo" style="width:350px">
                   			Modificación de Datos de Cuenta
                   		</div>
                   		<img src="/imagenes/iconoAvion.jpg"><br>
						<div id="msgModificacionExitosa"></div>
		           </div>
		           </div>
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
              <tr>
			 	<td class="Ftexto02">
			 	<hr>
			 		Disposición (Dirección Nacional de Protección de Datos Personales) 10/2008<p>
					<p>"El titular de los datos personales tiene la facultad de ejercer el derecho de acceso a los mismos en forma gratuita a intervalos no inferiores a seis meses, salvo que se acredite un interés legítimo al efecto conforme lo establecido en el artículo 14, inciso 3 de la Ley Nº 25.326"</p>
					<p>"La DIRECCION NACIONAL DE PROTECCION DE DATOS PERSONALES, órgano de control de la Ley Nº 25.326, tiene la atribución de atender las denuncias y reclamos que se interpongan con relación al incumplimiento de las normas sobre protección de datos personales".<p>
					<hr>
			 	</td>
			 </tr>
            </tr>
            </table>
            </td>
            
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
              </tr>
            </table>
            </td>
            
          </tr>
		</table>
	</div>
</div>
--%>
<div style="margin-top: 10px;">	
	<div class="compraWrapper2"><!--  style="background-color: #FBF5EF">-->
		<div class="cProcTit" style="margin-top: 0pt;"><span>Informacion Popego</span></div>
	        <div class="cProcFor-wrapper2 cProcForms2">           		
           		<div style="margin-bottom: 0pt;text-align:left;float:inherit;">
           			Popego es un servicio de clasificación de intereses y recomendación de contenidos.
					Al integrarlo con tu cuenta de Tematika, tus comentarios sobre productos mostrarán al resto de los usuarios de nuestro sitio tu perfil de intereses. De esta manera, los contenidos generados por nuestra comunidad de usuarios podrán ser relacionados con quienes los generan y así brindar mayor relevancia a quienes buscan recomendaciones de pares a la hora de comprar. 
           		</div>           					            
    		</div>

    		<div class="cProcFor-wrapper2 cProcForms2">
           		<b style="margin-bottom: 0pt;width:100px;">&nbsp;</b>
           		<div style="margin-bottom: 0pt;text-align:left;">
           			<img src="/imagenes/com.JPG"> 
           		</div>
           	</div>           	
	        <div class="cProcFor-wrapper2 cProcForms2">
           		<b style="margin-bottom: 0pt;width:100px;">&nbsp;</b>
           		<div style="margin-bottom: 0pt;text-align:left;">
           			<img src="/imagenes/comPop.JPG">
           		</div>			            
    		</div>
    		<div class="cProcFor-wrapper2 cProcForms2">
           		<b style="margin-bottom: 0pt;width:100px;">&nbsp;</b>
           		<div style="margin-bottom: 0pt;text-align:left;">
					<%
            			String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            		%>
            		<jsp:include page="<%=ultimosVisitadosPage%>"/>
           		</div>			            
    		</div>        	          	          		            	          	          		    	        
	</div>
</div>