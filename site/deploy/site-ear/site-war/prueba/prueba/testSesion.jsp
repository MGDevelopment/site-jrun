<%--@page import="java.util.Enumeration"--%>
<%	
	/*out.println(""+ session.getAttribute("resultadoBusquedaForm")!=null);
	Enumeration<String> atributos =  session.getAttributeNames() ;
	while(atributos.hasMoreElements()) {
		String param = atributos.nextElement();
		out.println(param);
		out.println("<br>");
	}*/
%>
<tmpl_loop resultados>
	<table width="390" cellspacing="0" cellpadding="0" border="0" class="moduleproductob">
		<tr>
			<td>
				<table width="390" cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<tr>
							<td width="82" class="celdafoto" rowspan="5">
								<a href="/libros/arte__arquitectura_y_diseno--9/musica--4/tango--8/las_mejores_letras_de_tango--377347.htm">
									<img height="68" 
										width="45" 
										border="0" 
										alt="LAS MEJORES LETRAS DE TANGO" 
										class="Gimagesproductos" 
										src="/tapas/adicionales/sinImagen_1.jpg"/> 
								</a>
							</td>
							<td valign="top" class="celdacontenido" colspan="3">
								<a class="FProductos" 
									href="/libros/arte__arquitectura_y_diseno--9/musica--4/tango--8/las_mejores_letras_de_tango--377347.htm">
									LAS MEJORES LETRAS DE TANGO
								</a>
								<br/>
								<a class="Fautores" href="/buscador/productos.jsp?seccion=1&amp;idSeccion=1&amp;criterioDeOrden=6&amp;claveDeBusqueda=porCategorias&amp;texto=Arte%2C+Arquitectura+y+Dise%F1o&amp;grupo=9">
									Subcategoria
								</a>
								<span class="Fprecio">Arte, Arquitectura y Diseño</span>
							</td>
						</tr>
						<tr>
							<td width="201" valign="bottom" class="celdapreciocomprar">
								<div align="left">
									<span class="Fprecio">PRECIO: $	16,00.-</span>
								</div>
							</td>
							<td valign="bottom">
								<div align="right">
									<table width="2" cellspacing="0" cellpadding="0" border="0">
										<tbody>
											<tr>
												<td height="19" class="divInfo">
													<a class="FProductos"
														href="/libros/arte__arquitectura_y_diseno--9/musica--4/tango--8/las_mejores_letras_de_tango--377347.htm"><img
														border="0" title="Las mejores Letras de Tango"
														alt="Las mejores Letras de Tango"
														src="/imagenes/libros/b-info.gif" />
													</a>
												</td>
												<td class="divComprarPedir">
													<a rel="nofollow"
														href="javascript:carrito_AgregarArticulo(377347);window.scrollTo(0,0);"><img
														border="0" alt="Comprar" 
														src="/imagenes/libros/b-comprar.gif" />
													</a>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</tmpl_loop>