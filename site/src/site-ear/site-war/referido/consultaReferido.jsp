<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.controllers.referido.ReferidoManager,
                 com.tmk.referido.ReferidoLocal,
                 com.tmk.referido.ReferidoLocalHome,
                 java.util.Iterator,
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert,
                 java.util.Date,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper" %>

 <%     SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/referido/consultaReferido.jsp");
%>
		<jsp:forward page="/miCuenta" />
<%	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT,  "/referido/consultaReferido.jsp");
%>
		<jsp:forward page="<%=MainHelper.PAGE_REGISTRO_SOCIO_CADENA%>" />
<%	}

	ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");

%>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Mi Cuenta") %>
<script src="/js/ajax.js" type="text/javascript"></script>
<script src="/js/popUp.js" type="text/javascript"></script>
<script src="/js/carrito.js" type="text/javascript"></script>
<script type="text/JavaScript">

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

</script>
<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
<link href="/estilos/seccion_inicio.css" rel="stylesheet" type="text/css" />
</head>

<body onload="MM_preloadImages('/imagenes/inicio/b-libros-over.gif','/imagenes/inicio/b-pasatiempos-over.gif','/imagenes/inicio/b-musica-over.gif','/imagenes/inicio/b-peliculas-over.gif')">
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0" class="Gtablaprincipal">
  <tr>
    <td><table width="740" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="183" valign="middle">
        <!-- Logo -->
        <%@include file="/componentes/comunes/logo.jsp"%>
        <!-- Logo -->
        </td>
        
        <td width="557" valign="middle">
        <!-- Login -->
        <%
       	String loginPage = "/componentes/comunes/login.jsp?idSeccion=" + Globals.SECCION_HOME;
       	%>
       	<jsp:include page="<%=loginPage%>"/>
        <!-- Login -->
        </td>
      </tr>
       <% String urlMenuSecciones = "/componentes/inicio/menuSecciones.jsp";%>
	  	 <jsp:include page="<%=urlMenuSecciones%>"/>    
      <tr>
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="modulobuscadorcarrito">
          <tr>
            <td width="575"><jsp:include page="/componentes/inicio/buscador.jsp"/> </td>            
            <td width="165">    
            <!-- Carrito -->
            <% String pageCarrito = "/componentes/comunes/carrito.jsp?idSeccion=" + Globals.SECCION_HOME;%>
			<jsp:include page="<%=pageCarrito%>"/>	
          	<!-- Carrito -->            
            </td>              
          </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2"><% String urlBannerTop = "/componentes/comunes/bannerTop.jsp?idSeccion=" + Globals.SECCION_HOME ;%>
		<jsp:include page="<%=urlBannerTop%>"/>      
      	</td>
      </tr>
      <tr>
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
          <tr>
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

            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>

                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellpadding="0" cellspacing="0">

                          <tr>
                            <td height="25" valign="top" class="FTtit01">ESTADO DE MIS REFERIDOS </td>
                          </tr>
                          
                          <tr>
								<td colspan="3" align="center">
								<%
							    try {
									Iterator referidos = referidoLH.findBySocioReferenteEstado (socioPK.ID_SOCIO, socioPK.ID_SUCURSAL, ReferidoManager.REFERIDO_COMPRA_APROBADA).iterator();
                                    ReferidoLocal referido = (ReferidoLocal) referidos.next();
								     if (referido.getFECHA_VENC_REFERENTE().after(new Date())) {
								%>
									<font color="559944"><b>Por las compras realizadas por sus referidos <%=Globals.NOMBRE_DEL_SITIO%> te otorga <%=referido.getBENEF_REFERENTE()%> en sus próximas compras hasta el <%=Convert.toString(referido.getFECHA_VENC_REFERENTE())%>!!!</b><br/><br/></font>
								<%
								     }
							    } catch(Exception e) {

								}
								%>
								</td>
							</tr>
<!-- REFERIDOS DISPONIBLES -->                          
                          <tr>
                            <td valign="top" class="FTtit01ch">REFERIDOS DISPONIBLES </td>
                          </tr>
                        <%
						  try {
  						  Iterator referidos = referidoLH.findBySocioReferenteDisponibles(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL).iterator();
						%>
                          <tr>
                            <td valign="top"><table class="Ftexto02" width="370" cellpadding="0" cellspacing="0" style="margin:10px 0px 15px 0px; border:solid 1px #B9B9B9">
							 <%
	                              if (referidos.hasNext()) {
		                     %>
                              <tr>
                                <td width="106" height="20" align="center" valign="center" bgcolor="#c0d9ff"><strong> Vencimiento </strong></td>
                                <td width="262" height="35" align="center" valign="center" bgcolor="#c0d9ff"><div align="left"><strong>Nombre del referido</strong> </div></td>
                              </tr>
                              <%
                                     while (referidos.hasNext()) {
	                                 ReferidoLocal referido = (ReferidoLocal) referidos.next();
	                          %>
                                
                              <tr>
                                <td valign="center" height="20" style="border-bottom:solid 1px #CCC"><div align="center"><%= Convert.toString(referido.getFECHA_VENC_REFERENTE())%></div></td> <!-- si es vacio NO DISPONIBLE-->

                                <td align="middle" valign="center" style="border-bottom:solid 1px #CCC"><div align="left"><%= Convert.nombreCompleto(referido.getNOMBRE_REFERIDO(), referido.getAPELLIDO_REFERIDO())%></div></td>
                              </tr>
							 <%
                                     }

	                              } else {
		                     %>                              
								<tr>
                                   <td height="20" valign="center"><div align="center">No existen referidos a su nombre. </div></td>
                                </tr>
                        <%
                                  }
						    } catch (Exception e) {
                                   out.println (e.toString());
							}
                        %>
                            </table></td>
                          </tr>


<!-- REFERIDOS EN PROCESO-->                                               
                          <tr>
                            <td valign="top" class="FTtit01ch">REFERIDOS EN PROCESO </td>
                          </tr>
						<%
							try {
							Iterator referidos = referidoLH.findBySocioReferenteEnProceso(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL).iterator();
						%>                          
                          <tr>
                            <td valign="top"><table class="Ftexto02" width="370" cellpadding="0" cellspacing="0" style="margin:10px 0px 15px 0px; border:solid 1px #B9B9B9">
					    <%
	                              if (referidos.hasNext()) {
		                %>
     		                  <tr>
                                <td width="106" height="20" align="center" valign="center" bgcolor="#c0d9ff"><strong> Vencimiento </strong></td>
                                <td width="262" height="35" align="center" valign="center" bgcolor="#c0d9ff"><div align="left"><strong>Nombre del referido</strong> </div></td>
                              </tr>
					     <%
                                       while (referidos.hasNext()) {
                                          ReferidoLocal referido = (ReferidoLocal) referidos.next();
                         %>
                              <tr>
                                <td valign="center" height="20" style="border-bottom:solid 1px #CCC"><div align="center"><%= Convert.toString(referido.getFECHA_VENC_REFERENTE())%></div></td>

                                <td align="middle" valign="center" style="border-bottom:solid 1px #CCC"><div align="left"><%= Convert.nombreCompleto(referido.getNOMBRE_REFERIDO(), referido.getAPELLIDO_REFERIDO())%></div></td>
                              </tr>
                         <%
                                       }
                                  } else {
                         %>
                                <tr>
                                  <td height="20" valign="center"><div align="center">No existen referidos a su nombre. </div></td>
                                </tr>
		                <%
	                              }
							} catch (Exception e) {
                                      out.println (e.toString());
							}
                        %>
		                    </table></td>
                          </tr>

<!-- REFERIDOS VENCIDOS -->                                                    
                          <tr>
                            <td valign="top" class="FTtit01ch">REFERIDOS VENCIDOS </td>
                          </tr>
  					    <%
							try {
							Iterator referidos = referidoLH.findBySocioReferenteVencidos(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL).iterator();
						%>
                        
                          <tr>
                            <td valign="top"><table class="Ftexto02" width="370" cellpadding="0" cellspacing="0" style="margin:10px 0px 15px 0px; border:solid 1px #B9B9B9">
                        <%
                                  if (referidos.hasNext()) {
                        %>
                                <tr>
                                  <td width="106" height="20" align="center" valign="center" bgcolor="#c0d9ff"><strong> Vencimiento </strong></td>
                                  <td width="262" height="35" align="center" valign="center" bgcolor="#c0d9ff"><div align="left"><strong>Nombre del referido</strong> </div></td>
                                </tr>
                         <%
                                      while (referidos.hasNext()) {
                                           ReferidoLocal referido = (ReferidoLocal) referidos.next();
                         %>
                                <tr>
                                  <td valign="center" height="20" style="border-bottom:solid 1px #CCC"><div align="center"><%= Convert.toString(referido.getFECHA_VENC_REFERENTE())%></div></td> 
                                  <td align="middle" valign="center" style="border-bottom:solid 1px #CCC"><div align="left"><%= Convert.nombreCompleto(referido.getNOMBRE_REFERIDO(), referido.getAPELLIDO_REFERIDO())%></div></td>
                                </tr>
                         <%
                                       }
	                              } else {
		                 %>
                                <tr>
                                  <td height="20" valign="center"><div align="center">No existen referidos a su nombre. </div></td>
                                </tr>
                         <%
                                  }
  						     } catch (Exception e) {
                                    out.println (e.toString());
						     }
                         %>
                            </table></td>
                          </tr>
                          
                          <tr>
                            <td height="55" valign="middle"><table width="370" border="0" align="left" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td class="celdamodulodomicilio2"><table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td width="185" valign="middle"><a href="#"></a></td>
                                        <td width="175" height="20" valign="middle"><div align="right"><a href="/AgregarReferido"><img src="/imagenes/miCuenta/b-agregarref.gif" alt="Agregar referido" border="0" /></a></div></td>
                                      </tr>                                     
                                  </table></td>
                                </tr>
                            </table></td>
                          </tr>
                        </table></td>

                      </tr>
                    </table></td>
                  </tr>

                </table></td>
              </tr>
               
           </table></td>
            <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
   		      <jsp:include page="<%=urlInstitucionalRight%>"/>  

            </table></td>
          </tr>
          <tr>
            <td colspan="3"><div align="center">
              <table width="670" border="0" cellpadding="0" cellspacing="0" class="Gfooter">
                 <tr>
		           <td colspan="3"><div align="center">
        		      <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion="+ Globals.SECCION_HOME ;%>
				      <jsp:include page="<%=urlInstitucional%>"/>  
		           </div></td>
        		  </tr>
              </table>
           </div></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<%=Globals.getGoogleAnalytics()%>	
</body>
</html>
