<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.service.orden.OrdenService,
                 com.tmk.orden.OrdenDAO,
                 com.tmk.kernel.DomicilioDAO,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.kernel.Globals,                 
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.TmkLogger,                                                   
				 com.tmk.setup.Contenido,   
 	             com.tmk.kernel.site.*,			               
                 com.tmk.controllers.alianza.EstadisticaVisitas,
                 com.tmk.orden.OrdenLocal,
                 com.tmk.kernel.ArticuloDAO,
                 com.tmk.bus.promo.PromoExtraManager,
                 com.tmk.controllers.MainHelper" 
                 %>
<%--
                 //com.tmk.socio.SocioPK, 
--%>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
	<link href="/estilos/seccion_inicio.css" rel="stylesheet" type="text/css" />
	<script src="/js/popUp.js" type="text/javascript"></script>
	<script src="/js/ajax.js" type="text/javascript"></script>
</head>

<body onload="javascript:__utmSetTrans();MM_preloadImages('/imagenes/inicio/b-libros-over.gif','/imagenes/inicio/b-pasatiempos-over.gif','/imagenes/inicio/b-musica-over.gif','/imagenes/inicio/b-peliculas-over.gif')">


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
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top"><img src="/imagenes/compra/micompra-05.gif" width="140" height="139" /></td>
              </tr>
            </table></td>
            <td  height="300" class="Gcentro"><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="modulocompratop">
              <tr>
                <td class="moduloayuda"><div align="center">
                  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                    
                    <tr>
                      <td valign="bottom" class="Ftexto02"><span class="FTtit01">Gracias por habernos elegido.</span><br />
                        </td>
                    </tr>



<!-- PROMOCIONES HORIZONTALES -->		
		<%	Pagina pagina = Contenido.getPagina(Globals.SECCION_HOME);%>

		<%if (pagina.getPromocionesHorz() != null) {%>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>

           		<%
					PromocionesHorz promociones = pagina.getPromocionesHorz();
					int linea=1;
				%>

			<%for (int index = 0; index < promociones.getListaMultipleTypeItemCount(); index++) {%> 
			<%ListaMultipleTypeItem elemento = promociones.getListaMultipleTypeItem(index);%>

				<%if (linea==1){ %>
  			    <tr>
       				<td  valign="bottom" class="Ftexto02"><table class="moduloayuda" width="90%" border="0" cellspacing="0" cellpadding="0" align="center">				
					<tr>	
				<%
				  }
				%>
						<td>
							<%if(elemento.getLink() != null) {%>
							<%Link link = elemento.getLink();%>
									
							<table width="50%" border="0" cellspacing="0" cellpadding="0" align="center">
									<tr>
										<td align="center">
											<%String paginaDestino = Contenido.getPagina(link);%>
											<%if (paginaDestino != null) {%><a href="<%=paginaDestino%>"><%}%>
											<img src="<%=Contenido.getImagen(link)%>" border="0" alt="<%=Contenido.getAyuda(link)%>">
											<%if (paginaDestino != null) {%></a><%}%>
										</td>
									</tr>
										
								<%if (link.getTexto() != null) {%>
								<td align="center" >
									<b><%=Contenido.getTexto(link)%></b>
								</td>
							</table>	
								<%}else{%>
								<td align="center" >&nbsp;</td>
							</table>	
								<%}%>
							<%} %>
						</td>
					<%if (linea==2){ %>
					</tr>				
					</table></td>
			   </tr>
					<%
						linea=1;
					}else{
						linea++;
					 }
					%>								
			<%
			  }
			 if(linea!=1){
			%>
					</tr>					
					</table></td>
  			  </tr>
			<%} %>
		<%}%>
<!-- FIN PROMOCIONES HORIZONTALES -->                
                    <tr>
                      <td>&nbsp;</td>
                    </tr>
                  </table>
                </div></td>
              </tr>
            </table></td>
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
			 <tr>
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>  
              </tr>
            </table></td>
          </tr>
           <tr>
            <td colspan="3"><div align="center">
                 <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion="+ Globals.SECCION_HOME;%>
				 <jsp:include page="<%=urlInstitucional%>"/>   
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
	
</body>
</html>
