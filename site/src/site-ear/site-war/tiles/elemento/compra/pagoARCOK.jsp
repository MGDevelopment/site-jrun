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

<%
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
	//datos de repsueta de archas
	String result = request.getParameter("Result");
	String errorCode = request.getParameter("ErrorCode");
	String idPurchase = request.getParameter("IdPurchase");
	String amount = request.getParameter("Amount");
	String idCurrency = request.getParameter("IdCurrency");
	String externalReference = request.getParameter("ExternalReference");
	String token = request.getParameter("Token");
	String txt1 = request.getParameter("txt1");
	String txt2 = request.getParameter("txt2");
	String txt3 = request.getParameter("txt3");
	//out.print("result " + result + "errorCode "+errorCode + "idPurchase "+idPurchase);
	//out.print("amount "+ amount + "idCurrency "+idCurrency + "externalReference "+ externalReference + "token "+token);
%>

<table width="760" border="0" align="center" cellpadding="0" cellspacing="0" class="Gtablaprincipal">
  <tr>
    <td>
    <table width="740" border="0" cellspacing="0" cellpadding="0">           
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
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>	