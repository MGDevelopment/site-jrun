<%	boolean info = "true".equals(request.getParameter("info")); %>
 
                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-afiliados.gif" alt="Programa de afiliados" width="219" height="12" /></td>
                  </tr>
                  <tr>              
                                      <form name="form" action="/afiliados/afiliadoEstandar.jsp?page=/afiliados/agregarAfiliado.jsp?&cambiaRight=true" method="post">                  
                    <td class="moduloayuda">
                    <table width="370" border="0" cellspacing="0" cellpadding="0">
                        <tr>                        
                          <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                              <tr>
                                <td height="10" valign="middle" class="Ftexto02"><p><strong class="FTtit01"> RANGO DE COMISIONES</strong><br />
                                </p>                                  </td>

                              </tr>
                              <tr>
                                <td height="10" valign="middle" class="Ftexto02">&nbsp;</td>
                              </tr>
                              <tr>
                                <td height="10" valign="middle" class="Ftexto02"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">                                                         
                                  <tr> 
	                         <%if(!info){%>                                
                                    <td width="7%"><div align="left">
                                      <input type="radio" name="TIPO_COMISION" value="TPRO" checked />
                                    </div></td>
							 <%}%>                                    
                                    <td width="93%"><div align="left" class="Ftexto02"><strong>Opci&oacute;n 1:</strong> </div></td>
                                  </tr>                             
                                </table></td>
                              </tr>
                              <tr>
                                <td height="20" valign="top" class="Ftexto02"><div align="center">

                                  <table width="50%" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                                    <tr>
                                      <td height="18" colspan="2" bgcolor="#C0D9FF"><div align="center" class="Ftexto02"><strong>Comisi&oacute;n por tipo de producto</strong></div></td>
                                      </tr>
                                    <tr>
                                      <td width="72%" height="20" style="border-bottom:solid 1px #CCC"><div align="center">Cd&rsquo;s</div></td>
                                      <td width="28%" height="20" style="border-bottom:solid 1px #CCC">5%</td>

                                      </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC"><div align="center">Dvd&rsquo;s</div></td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">5%</td>
                                      </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC"><div align="center">Videos</div></td>

                                      <td height="20" style="border-bottom:solid 1px #CCC">5%</td>
                                      </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC"><div align="center">Libros</div></td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">10%</td>
                                      </tr>
                                  </table>
                                </div></td>
                              </tr>
                              <tr>
                                <td height="15" valign="top" class="Ftexto02">&nbsp;</td>
                              </tr>
                              <tr>
                                <td height="20" valign="top" class="Ftexto02">Esta escala de comisiones es fija y var&iacute;a unicamente por el tipo de producto   vendido. Se le informar&aacute; sobre la cantidad total de productos vendidos   discriminando por tipo de producto para el pago de las comisiones.</td>
                              </tr>
                              <tr>

                                <td height="20" valign="top" class="Ftexto02">&nbsp;</td>
                              </tr>
                              <tr>
                                <td valign="top" class="Ftexto02"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                   <%if(!info){%>    
                                    <td width="7%"><div align="left">
                                        <input type="radio" name="TIPO_COMISION" value="VOLV" />
                                    </div></td>
                                    <%}%>     
                                    <td width="93%"><div align="left" class="Ftexto02"><strong>Opci&oacute;n 2:</strong> </div></td>

                                  </tr>
                                </table></td>
                              </tr>
                              <tr>
                                <td valign="top" class="Ftexto02">Por volumen de ventas   facturadas para todos los productos comercializados</td>
                              </tr>
                              <tr>
                                <td height="20" valign="top" class="Ftexto02">&nbsp;</td>

                              </tr>
                              <tr>
                                <td width="370" height="10" valign="top" class="Ftexto02"><div align="center">
                                  <table width="80%" border="0" cellspacing="0" cellpadding="0" class="Ftexto02">
                                    <tr>
                                      <td width="32%" height="18" bgcolor="#C0D9FF"><strong>Desde</strong></td>
                                      <td width="49%" height="18" bgcolor="#C0D9FF"><strong>Hasta</strong></td>
                                      <td width="19%" height="18" bgcolor="#C0D9FF"><div align="center"><strong>%</strong></div></td>

                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 00.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$  7.500.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">5%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$  7.501.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 15.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">6%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 15.001.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 22.500.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">7%</td>

                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 22.501.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 30.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">8%</td>
                                    </tr>
                                    <tr>

                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 30.001.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 37.500.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">9%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 37.501.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 45.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">10%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 45.001.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 52.500.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">11%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 52.501.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 60.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">12%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 60.001.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 75.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">13%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 75.001.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 82.500.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">14%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 82.501.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 90.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">15%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 90.001.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 97.500.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">16%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 97.501.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 105.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">17%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 105.001.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 112.500.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">18%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 112.501.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">$ 120.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">19%</td>
                                    </tr>
                                    <tr>
                                      <td height="20" style="border-bottom:solid 1px #CCC" colspan="2">M&aacute;s de $ 120.000.</td>
                                      <td height="20" style="border-bottom:solid 1px #CCC">20%</td>
                                    </tr>
                                  </table>
                                </div></td>
                              </tr>
                              <tr>
                                <td height="20" valign="top" class="Ftexto02">&nbsp;</td>
                              </tr>
                              <tr>
                                <td valign="top" class="Ftexto02">Esta opci&oacute;n cuenta con un modelo incremental de comisiones sujeto al volumen   facturado indpendientemente del tipo de producto efectivamente abonado por los   clientes/usuarios referidos desde el sitio de el AFILIADO. </td>

                              </tr>
                              <tr>
                                <td height="20" valign="top" class="Ftexto02">&nbsp;</td>
                              </tr>
                              <tr>
                                <td class="celdamodulodomicilio2"><table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
                                 
                                  <%if(info){%>    
                                    <tr>
                                      <td width="185" valign="middle">&nbsp;</td>
                                      <td width="175" height="20" valign="middle"><div align="right"><a href="/afiliados"><img src="/imagenes/inicio/b-volver.gif" alt="Volver" border="0" /></a></div></td>
                                    </tr>
                                  <%}else{ %>  
		                            <tr>
                                      <td width="185" valign="middle">&nbsp;</td>
                                      <td width="175" height="20" valign="middle"><div align="right"><a href="javascript:document.form.submit();"><img src="/imagenes/inicio/b-continuar.gif" alt="Continuar"  border="0" /></a></div></td>
                                    </tr>
                                  <%} %>
                                </table></td>
                              </tr>
                              <tr>
                                <td height="10" valign="top" class="Ftexto02">&nbsp;</td>
                              </tr>                              
                          </table></td>                                                   
                        </tr>
                    </table>           					                 
                    </td>              
                    </form>         
                  </tr>
                </table></td>