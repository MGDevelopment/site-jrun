<%@ page import="com.tmk.socio.SocioDomicilioLocalHome,
                 java.util.Iterator,
                 java.util.Vector,
                 com.tmk.socio.SocioDomicilioLocal,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.*,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.orden.OrdenDAO,
                 java.text.DecimalFormat" %>


<%  String URI = request.getRequestURI();
	//System.out.println(""+URI);
%>
	<table  cellspacing="0" cellpadding="0" border="0" align="center" class="Ftexto02">
		<form name="frmDireccion">
			<%
			SocioPK pk = (SocioPK)session.getAttribute("Registracion.socioPK");
			SocioDomicilioLocalHome domicilioHome = (SocioDomicilioLocalHome)DBUtil.getHome("SocioDomicilio");
			Iterator iterator = null;

			if(request.getParameter("TIPO_DOMICILIO") == null) {
				iterator = domicilioHome.findBySocio(pk.ID_SUCURSAL, pk.ID_SOCIO).iterator();
			} else if(request.getParameter("TIPO_DOMICILIO").substring(0, 2).equals("EN")) {
				iterator = domicilioHome.findByTipoEnvio(pk.ID_SUCURSAL, pk.ID_SOCIO).iterator();
			} else if(request.getParameter("TIPO_DOMICILIO").substring(0, 2).equals("TF")) {
				iterator = domicilioHome.findByTipoFacturacion(pk.ID_SUCURSAL, pk.ID_SOCIO).iterator();
			}
			int i = 1;

			//OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");
			boolean tieneArticulosDeDromo = false;
			boolean msgPasatiempos = false;
			boolean articuloPasatiempos = false;
	        if (ordenDAO != null) {
	            Vector articulos = ordenDAO.getArticulos();

	            for (int j=0; j<articulos.size() && !articuloPasatiempos; j++) {
	            	ArticuloDAO articulo = (ArticuloDAO)articulos.get(j);
	            	//si es pasatiempo fuera del grupo gs del tiempo
	            	if (articulo.getCategoriaSeccion() == Globals.SECCION_JUGUETES &&
	            			articulo.getCategoriaGrupo() != 4) {
	            		articuloPasatiempos = true;
	            	}
	            }

	        }
	        int dirCheck = 1;
			if (iterator.hasNext()) {
				while(iterator.hasNext())
				{
					cantidadDomicilios++;
					SocioDomicilioLocal domicilio = (SocioDomicilioLocal)iterator.next();

					PaisDAO paisDAO = PaisDAO.getPais(domicilio.getID_PAIS());
					ProvinciaDAO provinciaDAO = paisDAO.getProvincia(domicilio.getID_PROVINCIA());
					LocalidadDAO localidadDAO = provinciaDAO.getLocalidad(domicilio.getID_LOCALIDAD());

					%>
					<tr>
					<td valign="bottom" class="Ftexto02">
						<table width="366" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
							<%
								String checked = "";
								String disabled = "";
								
								if (articuloPasatiempos && !(paisDAO.getId()==Globals.ARGENTINA.getId()) &&
										request.getParameter("TIPO_DOMICILIO") != null &&
								        request.getParameter("TIPO_DOMICILIO").substring(0, 2).equals("EN")) {
									disabled = "disabled";
									checked = "";
									dirCheck++;
									msgPasatiempos = true;
								} else {
									disabled = "";
									if (dirCheck == i) {
										checked = "checked";
									} else {
										checked = "";
									}
								}
								
							%>

						   <tr>
	                              <td width="26" valign="middle"><div align="left">
	                                  <input name="<%= DatosDomicilio.ID %>" type="radio" value="<%= domicilio.getTIPO_DOMICILIO()%>" id="<%= domicilio.getTIPO_DOMICILIO()%>" <%=checked %> <%=disabled%> />
	                              </div></td>
	                              <td width="340" valign="middle"><span class="FTtit01">DOMICILIO <%= i %></span></td>
	                       </tr>
						   <tr>
	                             <td colspan="2"><table width="366" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
	                                 <tr>
	                                   <%
	                                       DecimalFormat format = new DecimalFormat("#");
	                                   %>
	                                   <td width="305" style="padding-left:5px"><%= Convert.toString(domicilio.getCALLE()) %> <%= (domicilio.getNUMERO() == null)? "": format.format(domicilio.getNUMERO())%>
	                                   <%= (domicilio.getEDIFICIO() == null)? "":"<br>Ed "+domicilio.getEDIFICIO()%>
	                                   <%= (domicilio.getPISO() == null)? "":"<br>Dpto " + domicilio.getPISO()%>
	                                   <%= (domicilio.getDEPTO() == null)? "":(domicilio.getPISO() == null)? "<br>Dpto " + domicilio.getDEPTO():"" + domicilio.getDEPTO()%><br />
	                                   <%= Convert.toString(domicilio.getDESCRIPCION_LOCALIDAD_INEX(), localidadDAO.getNombre()) %> <br />
	                                   <%= Convert.toString(domicilio.getDESCRIPCION_PROVINCIA_INEX(), provinciaDAO.getNombre()) %><br />
	                                   <%= Convert.toString(paisDAO.getNombre()) %><br />
	                                   </td>

	                                   <%if (disabled != ""){ %>

	                                   <%}else{ %>
							          <td width="61" valign="bottom"><div align="right"><a href="javascript:document.getElementById('<%= domicilio.getTIPO_DOMICILIO()%>').checked=true; modificarDireccion(); "><img src="/imagenes/miCuenta/b-modificar.gif" alt="Modificar domicilio" width="60" height="10" border="0" style="padding-right:15px" /></a></div></td>
	                                   <%} %>
	                                 </tr>
	                              </table></td>
	                        </tr>

	                        <tr>
	                          <td colspan="2">&nbsp;</td>
	                        </tr>

	                </table></td>
	              <%i++;%>
	             </tr>
			<%}%>
				 <tr>
                 	<td colspan="2">
                		<div style="float:right; margin-bottom:10px; border:dashed 1px #CCC; padding:5px; font-size:1px;">
			                <a href="/<%=home%>/agregarDomicilio.jsp?TIPO_DOMICILIO=<%= request.getParameter("TIPO_DOMICILIO") %>&HOME=<%=home%>"><img src="/imagenes/compra/b-agregardomicilio.gif" alt="Agregar domicilio" border=""></a>
        		        </div>
                	</td>
	             </tr>
    	         <tr>

		<%  if(request.getParameter("TIPO_DOMICILIO").startsWith("EN")) {
			//System.out.print(request.getParameter("TIPO_DOMICILIO"));
		%>
			<%if (!URI.equalsIgnoreCase("/listaDeseos/domicilios.jsp" ) && !URI.equalsIgnoreCase("/miCuenta/domicilios.jsp" ) ){%>

				<tr>
					<td class="celdamodulodomicilio2"><table width="346" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="277" class="Ftexto02"><div align="left">&iquest; Este domicilio de env&iacute;o coincide con el de facturaci&oacute;n ? </div></td>
                          <td width="20"><div align="left">
                              <input name="facturacion"  type="radio" value="true" checked />
                          </div></td>
                          <td width="17"><div align="left"><span class="Ftexto02">Si</span></div></td>
                          <td width="10"><div align="left">
                              <input name="facturacion"  type="radio" value="false" />
                          </div></td>
                          <td width="22"><div align="left"><span class="Ftexto02">No</span></div></td>
                        </tr>
                    </table></td>
				</tr>
			<%}%>
		<%	} else {
		%>
				<input type="hidden" name="facturacion" value="false">
		<%	}
		%>
<%
	} else { int mostrar= 7;
%>

	<tr>
		<td align="center" class="Ftexto01">
			<strong>NO HAY DIRECCIONES CARGADAS HASTA EL MOMENTO</strong>
			<div align="left"><a href="/<%=home%>/agregarDomicilio.jsp?TIPO_DOMICILIO=<%= request.getParameter("TIPO_DOMICILIO") %>&HOME=<%=home%>"><img src="/imagenes/compra/b-agregardomicilio.gif" alt="Agregar domicilio" width="112" height="8" border="0" class="bagregardomicilio"  /></a></div>
		</td>
	</tr>
<%	}
%>

		</form>
	</table>
	<%if(msgPasatiempos) { %>
	<table width="100%" align="center">
		<tr>
			<td>
				Nota: Las direcciones ubicadas en el exterior de Argentina no podrán ser utilizadas debido a que su compra cuenta con artículos de las
				categorías <%=Convert.nombrePropio(Globals.textoSolapa(Globals.SECCION_JUGUETES))%>, para los cuales no está permitido el envío al exterior de Argentina.
			</td>
		</tr>
	</table>
	<%}%>




