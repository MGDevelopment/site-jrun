<%@ page import="com.tmk.articulo.ComentarioExternoLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.controllers.comentario.ComentarioHelper,
                 com.tmk.articulo.ComentarioExternoLocal,
                 com.tmk.kernel.Convert"%>
            <%//COMENTARIOS Livra%>
               <%
               ComentarioExternoLocalHome comentarioExternoLocalHome = (ComentarioExternoLocalHome) DBUtil.getHome("ComentarioExterno");
	           Iterator comentariosExternos = comentarioExternoLocalHome.findByIdArticulo(idArticulo).iterator();
               %>
               <% if (comentariosExternos.hasNext()) {%>
				<table width="100%" cellpadding=0 cellspacing=0>
					<tr>
						<td colspan=2>
							<br>&nbsp;
							<br>
							<hr color="DDDDDD" height=1px>

						<td>
					</tr>
					<tr>
	                    <td>
							<table width ="100%" border=0 cellpading=0 cellspacing=0>
								<tr>
									<td><b>Opiniones de clientes</b></td>
									<td align=right><a href="http://ar.livra.com" target="_blank"><img src="/imagenes/logolivra-Medium.gif" width="93" height="17" border=0></a></td>
								</tr>
							</table>
                            <br>
                        </td>
                    </tr>
                    	<!--tr>
							<td align=right>
							 &gt; <a href="masComentarios.jsp?idArticulo=<%//=articuloLocal.getID_ARTICULO()%>&idSeccion=<%//=articuloLocal.getCATEGORIA_SECCION()%>"  style="color:0000DD;text-decoration:underline"><b>Ver más comentarios de este producto</b></a>
							</td>
						</tr-->
                    <tr>
                        <td>
                    <%

	                        int maxEvaluacion = ComentarioHelper.MAXIMO_EVALUACION;

	                        while (comentariosExternos.hasNext()) {
		                        ComentarioExternoLocal comentarioExterno = (ComentarioExternoLocal) comentariosExternos.next();

	                %>
							<table cellspacing=0 cellpadding=0 border =0 width="99%" align=center>
								<tr>
									<td>

										<b><%=comentarioExterno.getTITLE()%></b>
									</td>
									<td align=right rowspan=2>

										<%
		                                for (int i=0; i<Math.min(maxEvaluacion, (comentarioExterno.getRATING()).intValue()); i++) {
			                            %>
			                                <img src="/imagenes/evaluacionArticuloON.gif">
			                            <%
		                                  }
		                                  for (int i=(comentarioExterno.getRATING()).intValue(); i<maxEvaluacion; i++) {
										%>
											<img src="/imagenes/evaluacionArticuloOFF.gif">
										<%
		                                  }
										%>

									</td>
								</tr>
								<tr>
									<td>
										Escrito por <%=comentarioExterno.getREVIEWER()%> - <font color="007700"><%=Convert.toStringPublicacion(comentarioExterno.getFECHA())%></font>
									</td>
								</tr>
								<tr>
									<td colspan=2 Style="font-size:10">
                                        &nbsp;
									<td>
								</tr>
								<tr>
									<td colspan=2>
                                        <b>Lo Bueno: </b><%=Convert.toString(comentarioExterno.getPRO())%>
									<td>
								</tr>
								<tr>
									<td colspan=2>
                                        <b>Lo Malo: </b><%=Convert.toString(comentarioExterno.getCON())%>
									<td>
								</tr>
								<tr>
									<td colspan=2 Style="font-size:10">
                                       &nbsp;
									<td>
								</tr>
								<tr>
									<td colspan=2 style="text-align:justify" valign="bottom">
                                       <%=comentarioExterno.getBODY().replaceAll("\\n", "<br>")%>
                                       <%
                                            if (comentarioExterno.getFULL_BODY().intValue() != 1) {
	                                   %>
	                                   <br>
	                                   <br>
	                                    <!--a href="masComentarios.jsp?" ><img src="/imagenes/susp.gif"   border=0 alt="ver opinión completa"></a-->
	                                    <a href="masComentarios.jsp?idArticulo=<%=articuloLocal.getID_ARTICULO()%>&idSeccion=<%=articuloLocal.getCATEGORIA_SECCION()%>
                                                    #<%=comentarioExterno.getTITLE()%>" style="color:0000DD;text-decoration:underline">ver opinión completa</a>

	                                   <%
                                            }
                                       %>
									<td>
								</tr>
								<tr>
									<td colspan=2 Style="font-size:10">
                                        &nbsp;
									<td>
								</tr>
                                <tr>
									<td colspan=2>
                                        <font color="008800"><%=comentarioExterno.getHELPFULRECOMMENTATIONS()%> de <%=comentarioExterno.getTOTALRECOMMENTATIONS()%> personas encontraron la opinión útil.</font>
									<td>
								</tr>
								<tr>
									<td colspan=2>
										<br>&nbsp;
                                        <br>
										<hr color="DDDDDD" height=1px>

									<td>
								</tr>


							</table>

	                <%
		                    }
	                 %>
                    	    <table width="100%">
                               	<tr>
									<td align=right>
									 &gt; <a href="masComentarios.jsp?idArticulo=<%=articuloLocal.getID_ARTICULO()%>&idSeccion=<%=articuloLocal.getCATEGORIA_SECCION()%>"  style="color:0000DD;text-decoration:underline"><b>Ver más comentarios de este producto</b></a>
									</td>
								</tr>
							</table>

                        </td>
                    </tr>
                 </table>
                 <%}%>
				 <%//COMENTARIOS Livra%>