<td class="Gbarraderecha" width="162">
		<table width="155" border="0" cellspacing="0" cellpadding="0">
	              <tr class="">
	                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
	                    <tr>
	                        <td><table  border="0" cellspacing="0" cellpadding="0">
	                            <tr>
	                              <td><span class="Ftexto02">ORDENAR TITULOS POR:</span></td>
	                            </tr>
	                            <tr>
	                              <td class="moduloordencelda">
	                              <%if (criterio.equals(BuscadorHelper.CRIT_MAS_VENDIDOS)) { %>
		                              <span class="Ftexto02">- Los m&aacute;s vendidos</span>
	                              <%} else {

	                            	  busquedaDAO.setCriterio(BuscadorHelper.CRIT_MAS_VENDIDOS);

	                            	  StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                            	  saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                            	  saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
	                            	  saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_MAS_VENDIDOS.getClave().intValue());

	 	                          %>
	                            	  <span class="Ftexto02">- </span><a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">Los m&aacute;s vendidos</a>
	                              <%
	                                }
	                              %>
	                              </td>
	                            </tr>
	                            <tr>
	                              <td class="moduloordencelda">
	      	                      <%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_EC)) { %>
	                              		<span class="Ftexto02">- Precio de venta<br />
	                                    &nbsp;&nbsp;(+econ&oacute;micos primeros)</span></td>
	                              <%} else {

	                            	   busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_EC);

	                            	   StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                            	   saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
	                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_PRECIO_EC.getClave().intValue());
	                              %>
	                            		<a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Precio de venta<br />
	                                    <span class="Ftexto02">&nbsp;&nbsp;</span>(+econ&oacute;micos primeros)</a></td>
	                              <%
	                                }
	                              %>
	                            </tr>

	                            <tr>
	                              <td class="moduloordencelda"><span class="Ftexto02">
	                               <%if (criterio.equals(BuscadorHelper.CRIT_FECHA_VN)) { %>
		                              <span class="Ftexto02">- Fecha de aparici&oacute;n<br />
	                                    &nbsp;&nbsp;(+antiguos primeros)</span></td>
		                           <%} else {

		                        	   busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_VN);

		                        	   StringBuffer  saltoOrdenCriterio = new StringBuffer();

		                        	   saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
		                        	   saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
	                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_FECHA_VN.getClave().intValue());

	                               %>

	                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Fecha de aparici&oacute;n<br />
	                                  <span class="Ftexto02">&nbsp;&nbsp;</span>(+antiguos primeros)</a></td>
	                               <%
	                                 }
	                               %>
	                               </td>
	                            </tr>

	                            <tr>
	                              <td class="moduloordencelda">
	                              <%if (criterio.equals(BuscadorHelper.CRIT_FECHA_NV)) { %>
		                              <span class="Ftexto02">- Fecha de aparici&oacute;n<br />
	                                    &nbsp; &nbsp;(+recientes primeros)</span></td>
		                           <%} else {

		                        	     busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_NV);
		                        	     StringBuffer  saltoOrdenCriterio = new StringBuffer();

		                        	     saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
		                        	     saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
		                            	 saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_FECHA_NV.getClave().intValue());

	                               %>
	                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Fecha de aparici&oacute;n<br />
	                                  <span class="Ftexto02">&nbsp;&nbsp;</span>(+recientes primeros)</a></td>
	                               <%
	                                 }
	                               %>
								</td>
	                            </tr>

	                            <tr>
	                              <td class="moduloordencelda">
	      	                      <%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_CE)) { %>
	                              		<span class="Ftexto02">- Precio de venta<br />
	                                    &nbsp;&nbsp;(+costosos primeros)</span></td>
	                              <%} else {

	                            	    busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_CE);

	                            	    StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                            	    saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                            	    saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
		                            	saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_PRECIO_CE.getClave().intValue());
	                              %>
	                            		<a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Precio de venta<br />
	                                    <span class="Ftexto02">&nbsp;&nbsp;</span>(+costosos primeros)</a></td>
	                              <%
	                                }
	                              %>
	                            </tr>


	                            <tr>
	                              <td class="moduloordencelda">
	                              	<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_AZ)) { %>
		                              <span class="Ftexto02">- Alfab&eacute;ticamente (A-Z)</td>
		                           <%} else {

		                        	     busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_AZ);

		                        	     StringBuffer  saltoOrdenCriterio = new StringBuffer();

		                        	     saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
		                        	     saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
			                             saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_ALFAB_AZ.getClave().intValue());
	                               %>
	                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Alfab&eacute;ticamente (A-Z)<br/></a>
	                               <%
	                                 }
	                               %>
	                              </td>
	                            </tr>

	                            <tr>
	                              <td class="moduloordencelda">
	                              	<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_ZA)) { %>
		                              <span class="Ftexto02">- Alfab&eacute;ticamente (Z-A)</td>
		                           <%} else {
		                        	   	busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_ZA);
		                        	   	StringBuffer  saltoOrdenCriterio = new StringBuffer();
		                        	   	saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
		                        	   	saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
			                            saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_ALFAB_ZA.getClave().intValue());
	                               %>
	                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Alfab&eacute;ticamente (Z-A)<br/></a>
	                               <%
	                                 }
	                               %>
	                              </td>
	                            </tr>
	                        </table></td>
	                      </tr>
	                </table></td>
	              </tr>

	            </table></td>