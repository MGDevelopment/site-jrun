<%@ page import="javax.servlet.ServletContext,
				 com.tmk.kernel.Convert,
				 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals,
                 java.util.Vector,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.service.categoria.CategoriaService" %>

<%
	int idArticulo = Convert.toNumber(request.getParameter("idArticulo"), Globals.ARTICULO_DEFAULT);
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0);
	String titulo = request.getParameter("titulo");
	boolean generacion = Convert.toBoolean(request.getParameter("generacion"), false);
	ArticuloClass articulo[] = ArticuloManager.getArticuloParaUrlRewrite(idArticulo+"");
	if (articulo != null && articulo.length>0) {
		String urlActual = request.getRequestURI();
		String urlPrimerCapitulo="";
		String urlBiografia="";
		String urlEntrevista="";
		String urlNotaPrensa="";
		String urlIndiceContenidos="";
		String urlComentarios="";

		if (generacion) {
	urlPrimerCapitulo= "/articulo/componentes/primerCapitulo.jsp" ;
	urlBiografia= "/articulo/componentes/biografia.jsp" ;
	urlEntrevista= "/articulo/componentes/entrevista.jsp" ;
	urlNotaPrensa="/articulo/componentes/notaPrensa.jsp";
	urlIndiceContenidos="/articulo/componentes/indiceDeContenidos.jsp";
		} else {
	urlPrimerCapitulo= "/detalle/primerCapitulo.jsp" ;
	urlBiografia= "/detalle/biografias.jsp" ;
	urlEntrevista= "/detalle/entrevistas.jsp" ;
	urlNotaPrensa="/detalle/notasPrensa.jsp";
	urlIndiceContenidos="/articulo/indiceDeContenidos.jsp";
		}
		
		ServletContext servletContext = Contenido.getServletContext();


		Vector autores = new Vector();
		String nombreAutor = null;

		if (idSeccion == Globals.SECCION_PELICULA){
	autores = ArticuloManager.getAutorDelArticulo(idArticulo,"'D02'");
		}else{
	autores = ArticuloManager.getAutorDelArticulo(idArticulo,"'A01'");
		}

		boolean tieneBiografia = false;
		int idAutor = 0;

	    for (int i = 0; i < autores.size(); i=i+2) {
		   idAutor = Convert.toNumber(autores.get(i).toString(),0);
		   nombreAutor = Convert.nombrePropio(autores.get(i+1).toString(),true);
	       if(ArticuloManager.getBiografia(idArticulo, idAutor, servletContext)!=null){
	    	   tieneBiografia = true;
	    	   break;
	       }
		}

	 switch(idSeccion){
	case (Globals.SECCION_LIBRO):
%>

			<td><table width="375" border="0" align="center" cellpadding="0" cellspacing="0">
	  		<%
	  			if(	(ArticuloManager.tienePrimerCapitulo(idArticulo, servletContext))
	  			    || (ArticuloManager.tieneIndice(idArticulo))
	  				|| (tieneBiografia)
	  			    || (ArticuloManager.tieneEntrevista(idArticulo,servletContext))
	  			    ){
	  		%>
	                  <tr>
	                    <td><div align="left"><img src="/imagenes/libros/<%=(urlActual.equals(urlBiografia))?"t-acercaautor.gif":"t-acerca.gif"%>" alt="Acerca de esta obra" width="148" height="10" /></div></td>
	                  </tr>
	                  <tr>
	                    <td><table width="375" border="0" cellspacing="0" cellpadding="0" class="moduloacerca">
	                      <tr>
	                        <td><table width="355" border="0" align="center" cellpadding="0" cellspacing="0">
	                          <tr>
	                            <td><div align="left">

					<!-- LINK SUPERIOR IZQUIERDO -->
					<%
						if(urlActual.equals(urlPrimerCapitulo) || urlActual.equals(urlEntrevista) || urlActual.equals(urlBiografia)){
					%>
								<a href="<%=CategoriaService.getURL(articulo[0].getCategoria())+ArticuloManager.getURL(articulo[0])+"#titulo"%>">
								<img src="/imagenes/libros/b-volveraobra.gif" alt="Volver a la rese&ntilde;a de la obra" width="170" height="24" border="0" />
					<%
						}else{
										if (ArticuloManager.tienePrimerCapitulo(idArticulo,servletContext)) {
					%>
	    		                <a href="<%="/detalle/primerCapitulo.jsp?idArticulo=" + idArticulo  + "#titulo"%>">
	        		            <img src="/imagenes/libros/b-primcap.gif" alt="<%="Ver el primer cap&iacute;tulo de " + titulo%>" width="170" height="24" border="0" /></a>
						<%
							}else{
						%>
	                	        <img src="/imagenes/libros/b-primcap2.gif" alt="<%="Ver el primer cap&iacute;tulo de " + titulo%>" width="170" height="24" border="0" />
		   				<%
		   					}
		   				%>
	    			<%
	    				}
	    			%>
	                            </div></td>
	                            <td><div align="right">
					<!-- FIN LINK SUPERIOR IZQUIERDO -->

					<!-- LINK SUPERIOR DERECHO -->
					<%
						if(urlActual.equals(urlBiografia)){
										if (ArticuloManager.tieneEntrevista(idArticulo,servletContext)) {
					%>

							   <a href="<%="/detalle/entrevistas.jsp?idArticulo=" + idArticulo  + "#titulo"%>">
	                     	   <img src="/imagenes/libros/b-entrevistas.gif" alt="<%=" Ver entrevistas a " + nombreAutor%>" width="170" height="24" border="0" />
	                     	   </a>

					<%
						}else{
					%>

								<img src="/imagenes/libros/b-entrevistas2.gif" alt="<%="Ver entrevistas a " + nombreAutor%>" width="170" height="24" border="0" />

					<%
						}
									}else if(urlActual.equals(urlEntrevista)){
											if (tieneBiografia){
					%>

							    <a href="<%="/detalle/biografias.jsp?idArticulo=" + idArticulo +"&idAutor=" + idAutor  + "#titulo"%>">
	                            <img src="/imagenes/libros/b-bio.gif" alt="<%=" Ver biograf&iacute;a de " + nombreAutor%>" width="170" height="24" border="0" />
	                            </a>

					<%
						}else{
					%>

							    <img src="/imagenes/libros/b-bio2.gif" alt="<%=" Ver biograf&iacute;a de " + nombreAutor%>" width="170" height="24" border="0" />

					<%
						}
									}else if(urlActual.equals(urlIndiceContenidos)){
					%>
						     	<a href="<%=CategoriaService.getURL(articulo[0].getCategoria())+ArticuloManager.getURL(articulo[0])+"#titulo"%>">
						     	<img src="/imagenes/libros/b-volveraobra.gif" alt="<%="Volver a la rese&ntilde;a de " + titulo%>" width="170" height="24" border="0" />

					<%
						}else if (ArticuloManager.tieneIndice(idArticulo)) {
					%>
	                            <a href="<%="/articulo/indiceDeContenidos.jsp?idArticulo=" + idArticulo  + "#titulo"%>">
	                            <img src="/imagenes/libros/b-indice.gif" alt="<%="Ver el &iacute;ndice de contenidos de " + titulo%>" width="170" height="24" border="0" />
	                            </a>

					<%
						}else{
					%>
	                            <img src="/imagenes/libros/b-indice2.gif" alt="<%="Ver el &iacute;ndice de contenidos de " + titulo%>" width="170" height="24" border="0" />
					<%
						}
					%>
								</div></td>
	                          </tr>
	  			    <!-- FIN LINK SUPERIOR DERECHO -->


					<!-- LINK INFERIOR IZQUIERDO -->
					<%
						if((!urlActual.equals(urlBiografia))&&(!urlActual.equals(urlEntrevista))){
					%>
	                          <tr>
	                            <td width="178" class="moduloacerca2"><div align="left">
	                            <%
	                            	if (tieneBiografia) {
	                            %>
									<a href="<%="/detalle/biografias.jsp?idArticulo=" + idArticulo +"&idAutor=" + idAutor  + "#titulo"%>">
		                            <img src="/imagenes/libros/b-bio.gif" alt="<%=" Ver biograf&iacute;a de " + nombreAutor%>" width="170" height="24" border="0" />
		                            </a>
								<%
									}else{
								%>
								    <img src="/imagenes/libros/b-bio2.gif" alt="<%=" Ver biograf&iacute;a de " + nombreAutor%>" width="170" height="24" border="0" />
								<%
									}
								%>
	                            </div></td>

					<!-- FIN LINK INFERIOR IZQUIERDO -->

					<!-- LINK INFERIOR DERECHO -->
								<td width="177" class="moduloacerca2"><div align="right">
								<%
									if (ArticuloManager.tieneEntrevista(idArticulo,servletContext)) {
								%>
								<a href="<%="/detalle/entrevistas.jsp?idArticulo=" + idArticulo  + "#titulo"%>">
	                            <img src="/imagenes/libros/b-entrevistas.gif" alt="<%=" Ver entrevistas a " + nombreAutor%>" width="170" height="24" border="0" />
	                            </a>
	                            <%
	                            	}else{
	                            %>
	                            <img src="/imagenes/libros/b-entrevistas2.gif" alt="<%=" Ver entrevistas a " + nombreAutor%>" width="170" height="24" border="0"/>
	                            <%
	                            	}
	                            %>
	                            </div></td>
	                          </tr>
	                  <%
	                  	}
	                  %>
					<!-- FIN LINK INFERIOR DERECHO -->

	                        </table></td>
	                      </tr>
	                    </table></td>
	                  </tr>
	<%
		}
	%>
	            </table></td>
	<%
		break;

		case (Globals.SECCION_MUSICA):
	%>
				<td><table width="375" border="0" align="center" cellpadding="0" cellspacing="0">
	<%
		if ((tieneBiografia)
		|| (ArticuloManager.tieneNotaDePrensa(idArticulo, servletContext))
		){
	%>
	            <tr>
	              <td><div align="left"><img src="/imagenes/musica/t-sobreestedisco.gif" alt="Sobre este disco" width="133" height="12"  /></div></td>
	            </tr>
	            <tr>
	              <td><table width="375" border="0" cellspacing="0" cellpadding="0" class="moduloacerca">
	                <tr>
	                  <td><table width="355" border="0" align="center" cellpadding="0" cellspacing="0">
	                    <tr>
	            <%
	            	if(urlActual.equals(urlBiografia)|| urlActual.equals(urlNotaPrensa)){
	            %>
	                      <td width="178"><table width="174" border="0" align="left" cellpadding="0" cellspacing="0" class="moduloacerca2">
	                        <tr>
	                         <td><div align="left">
				    	   <a href="<%=CategoriaService.getURL(articulo[0].getCategoria())+ArticuloManager.getURL(articulo[0])+"#titulo"%>">
	                       <img src="/imagenes/musica/b-volveradisco.gif" alt="Volver al disco" width="88" height="7" border="0" /></a></div></td>
				<%
					}else{
					                       	if (tieneBiografia) {
				%>
	                      <td width="178"><table width="174" border="0" align="left" cellpadding="0" cellspacing="0" class="moduloacerca2">
	                        <tr>
	                         <td><div align="left">
	                         <a href="<%="/detalle/biografias.jsp?idArticulo=" + idArticulo +"&idAutor=" + idAutor  + "#titulo"%>">
	                         <img src="/imagenes/musica/b-bioartista.gif" alt="<%="Biograf&iacute;a de " + nombreAutor%>" width="88" height="7" border="0" /></a></div></td>
				<%
					}else{
				%>
	                      <td width="178"><table width="174" border="0" align="left" cellpadding="0" cellspacing="0" class="moduloacerca2Des">
	                        <tr>
	                         <td><div align="left">
	                         <img src="/imagenes/musica/b-bioartista2.gif" alt="<%="Biograf&iacute;a de " + nombreAutor%>" width="88" height="7" border="0" /></div></td>
	 			<%
	 				}
	 			%>
	<%
		}
	%>
	                        </tr>
	                      </table></td>

				<%
					if(urlActual.equals(urlNotaPrensa)){
								   if (tieneBiografia) {
				%>
	                      <td width="177"><div align="right">
	                        <table width="174" border="0" align="right" cellpadding="0" cellspacing="0" class="moduloacerca2">
	                          <tr>
	                            <td><div align="left">
		                         <a href="<%="/detalle/biografias.jsp?idArticulo=" + idArticulo +"&idAutor=" + idAutor  + "#titulo"%>">
			                     <img src="/imagenes/musica/b-bioartista.gif" alt="<%="Biograf&iacute;a de " + nombreAutor%>" width="88" height="7" border="0" /></a></div></td>
				<%
					}else{
				%>
	                      <td width="177"><div align="right">
	                        <table width="174" border="0" align="right" cellpadding="0" cellspacing="0" class="moduloacerca2Des">
	                          <tr>
	                            <td><div align="left">
				                 <img src="/imagenes/musica/b-bioartista2.gif" alt="<%="Biograf&iacute;a de " + nombreAutor%>" width="88" height="7" border="0" /></div></td>
				<%
					}
							   }else{
									if (ArticuloManager.tieneNotaDePrensa(idArticulo, servletContext)) {
				%>
	                      <td width="177"><div align="right">
	                        <table width="174" border="0" align="right" cellpadding="0" cellspacing="0" class="moduloacerca2">
	                          <tr>
	                            <td><div align="left">
	                            <a href="<%="/detalle/notasPrensa.jsp?idArticulo=" +  idArticulo  + "#titulo"%>">
	                            <img src="/imagenes/musica/b-notas.gif" alt="Notas relacionadas" width="127" height="7" border="0" /></a></div></td>
				<%
					}else{
				%>
	                      <td width="177"><div align="right">
	                        <table width="174" border="0" align="right" cellpadding="0" cellspacing="0" class="moduloacerca2Des">
	                          <tr>
	                            <td><div align="left">
				                <img src="/imagenes/musica/b-notas2.gif" alt="Notas relacionadas" width="127" height="7" border="0"/></div></td>
				<%
					}
								}
				%>
							</tr>
	                        </table>
	                      </div></td>
	                    </tr>
	                  </table></td>
	                </tr>
	              </table></td>
	            </tr>
	<%
		}
	%>
	          </table></td>

	<%
		break;
		case (Globals.SECCION_PELICULA):
	%>
				<td><table width="375" border="0" align="center" cellpadding="0" cellspacing="0">
	<%
		if ((tieneBiografia)
		|| (ArticuloManager.tieneNotaDePrensa(idArticulo,servletContext))
		){
	%>
	             <tr>
	               <td><div align="left"><img src="/imagenes/peliculas/t-sobreestefilm.gif" alt="Sobre este film" width="125" height="12" /></div></td>
	             </tr>
	             <tr>
	               <td><table width="375" border="0" cellspacing="0" cellpadding="0" class="moduloacerca">
	                 <tr>
	                   <td><table width="355" border="0" align="center" cellpadding="0" cellspacing="0">
	                     <tr>
					<%
						if(urlActual.equals(urlNotaPrensa)|| urlActual.equals(urlBiografia)) {
					%>
						    <td width="178"><table width="174" border="0" align="left" cellpadding="0" cellspacing="0" class="moduloacerca2">
	                         <tr>
	                           <td><div align="left">
	                           <a href="<%=CategoriaService.getURL(articulo[0].getCategoria())+ArticuloManager.getURL(articulo[0])+"#titulo"%>">
	                           <img src="/imagenes/peliculas/b-volverafilm.gif" alt="Volver al film" width="96" height="7" border="0" /></a></div></td>
					<%
						}else{
							if (tieneBiografia) {
					%>
	                       <td width="178"><table width="174" border="0" align="left" cellpadding="0" cellspacing="0" class="moduloacerca2">
	                         <tr>
	                           <td><div align="left">
	                           <a href="<%="/detalle/biografias.jsp?idArticulo=" + idArticulo +"&idAutor=" + idAutor  + "#titulo"%>">
	                           <img src="/imagenes/peliculas/b-bioartista.gif" alt="Biograf&iacute;a del director" width="103" height="7" border="0" /></a></div></td>
					<%		}else{ %>
	                       <td width="178"><table width="174" border="0" align="left" cellpadding="0" cellspacing="0" class="moduloacerca2Des">
	                         <tr>
	                           <td><div align="left">
	                           <img src="/imagenes/peliculas/b-bioartista2.gif" alt="Biograf&iacute;a del director" width="103" height="7" border="0" /></div></td>
					<%		}
						}
					%>
	                   		 </tr>
	                       </table></td>

	                       <td width="177"><div align="right">

					<%
					if(urlActual.equals(urlNotaPrensa)) {

					    if (tieneBiografia) {
					%>
	                         <table width="174" border="0" align="right" cellpadding="0" cellspacing="0" class="moduloacerca2">
	                           <tr>
	                             <td><div align="left">
		                           <a href="<%="/detalle/biografias.jsp?idArticulo=" + idArticulo +"&idAutor=" + idAutor  + "#titulo"%>">
	    	                       <img src="/imagenes/peliculas/b-bioartista.gif" alt="Biograf&iacute;a del director" width="103" height="7" border="0" /></a></div></td>
					<%  }else{ %>
	                         <table width="174" border="0" align="right" cellpadding="0" cellspacing="0" class="moduloacerca2Des">
	                           <tr>
	                           <td><div align="left">
		   	                       <img src="/imagenes/peliculas/b-bioartista2.gif" alt="Biograf&iacute;a del director" width="103" height="7" border="0" /></div></td>
					<%	}
					}else{
					    if (ArticuloManager.tieneNotaDePrensa(idArticulo,servletContext)) {
					%>
	                         <table width="174" border="0" align="right" cellpadding="0" cellspacing="0" class="moduloacerca2">
	                           <tr>
	                             <td><div align="left"><a href="<%="/detalle/notasPrensa.jsp?idArticulo=" +  idArticulo  + "#titulo"%>"><img src="/imagenes/peliculas/b-notas.gif" alt="Notas relacionadas" width="135" height="7" border="0" /></a></div></td>
					<%  }else{ %>
	                         <table width="174" border="0" align="right" cellpadding="0" cellspacing="0" class="moduloacerca2Des">
	                           <tr>
	                             <td><div align="left"><img src="/imagenes/peliculas/b-notas2.gif" alt="Notas relacionadas" width="135" height="7" /></div></td>
			<%			}
					}
			%>
	                           </tr>
	                         </table>
	                       </div></td>
	                     </tr>
	                   </table></td>
	                 </tr>
	               </table></td>
	             </tr>
	<%} %>
	           </table></td>
	<%
	   }//fin del case
	}
	%>