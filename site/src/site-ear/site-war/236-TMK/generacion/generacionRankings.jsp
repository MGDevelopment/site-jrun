<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.Site,
                 com.tmk.kernel.site.Ranking,
				 com.tmk.kernel.site.RankingSeccion,
 				 com.tmk.kernel.site.RankingGrupo"%>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
    if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("GENERAR_CONTENIDOS_ESTATICOS"))) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>

<html>
	<head>
	<%= Globals.estiloBasico() %>

		<style>
		.titulos{
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			font-weight: bold;
		}

		.contenido{
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			text-decoration: none;
			color: #000000;
		}

		</style>
	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
	<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" height="100%" width="770" >
		<tr>
			<td valign="top">
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:include page="/236-TMK/comunes/header.jsp"/>
						</td>
					</tr>
				</table>

				<font style="font-size: 18px; color:#003366">&nbsp;&nbsp;Rankings</font><br><br>

                <%
                    if(session.getAttribute("generacionError") != null){
                %>
                        <CENTER><font style="font-size: 13px; color:red">&nbsp;&nbsp;<b><%=session.getAttribute("generacionError")%></b></font></CENTER>
                <%      session.removeAttribute("generacionError");
                    }
                %>

                <%
	                if(session.getAttribute("generacionOK") != null){
                %>
                        <CENTER><font style="font-size: 13px; color:green">&nbsp;&nbsp;<b><%=session.getAttribute("generacionOK")%></b></font></CENTER>
                <%      session.removeAttribute("generacionOK");
	                }
                %>

                <script language="javascript">
                
               		function seleccionarTodos(chkbox){
						for (var i=0;i < document.formContenidosEstaticos.elements.length;i++){
							var elemento = document.formContenidosEstaticos.elements[i];
							if (elemento.type == "checkbox"){
									elemento.checked = chkbox.checked
							}
						}
					}

                </script>
                
                
                <form action="/GenerarRankingEstatico" name="formContenidosEstaticos" method="post">
                <input type="hidden" value="" name="rankingsAGenerar">
				<table width="500" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
					<tr class="titulos" >
						<td bgcolor="#59B3D9" align="center" width="30" height="20"><input type="checkbox" onclick="seleccionarTodos(this);" name="selectAll"></td>
  						<td bgcolor="#59B3D9">Categor&iacute;a</td>
					</tr>
					
					<%int rankingNumero = 1; %>
		<!-- TOP 100 LIBROS-->					
					<tr>
						<td style="border-right: 1px solid #59B3D9;" align="center" class="contenido"><input type="checkbox" value="<%=Globals.SECCION_LIBRO%>,-1" name="ranking<%=rankingNumero%>" onclick="document.formContenidosEstaticos.selectAll.checked=false;"></td>
                        <td style="border-right: 1px solid #59B3D9;"  class="contenido"><%=Convert.corregir(Globals.seccion(Globals.SECCION_LIBRO),true).toUpperCase()%></td>
					</tr>
		<!-- TOP 100 LIBROS-->	
					<%rankingNumero++; %>
				<%
	                Site site = Contenido.getSite();
    	            Ranking ranking = site.getRanking();   	            
    	            
				 	for (int ri = 0; ri < ranking.getRankingSeccionCount(); ri++) {
						RankingSeccion rankingSeccion = ranking.getRankingSeccion(ri);
						if(rankingSeccion.getRankingGrupoCount() > 1){			
							for (int rg = 0; rg < rankingSeccion.getRankingGrupoCount(); rg++) {
								RankingGrupo rankingGrupo= rankingSeccion.getRankingGrupo(rg);								
				%>                     
		<!-- SECCION LIBROS POR CATEGORIA: ficcion, no ficcion, infantiles, juveniles  -->                	
		<!-- EL TOP ES DE 10 -->
                	<tr>
						<td style="border-right: 1px solid #59B3D9;" align="center" class="contenido"><input type="checkbox" value="<%=rankingSeccion.getId()%>,<%=rankingGrupo.getNombre()%>" name="ranking<%=rankingNumero%>" onclick="document.formContenidosEstaticos.selectAll.checked=false;"></td>
                        <td style="border-right: 1px solid #59B3D9;"  class="contenido"><%=Convert.corregir(Globals.seccion(rankingSeccion.getId()),true).toUpperCase()%> > <%=rankingGrupo.getNombre().toUpperCase()%></td>
                       <% rankingNumero++;%>
					</tr>
      		   	       <%   }
						}else{%>

		<!-- SECCION DISTINTA A LIBROS-->
		<!-- EL TOP ES DE 20 -->
					<tr>
						<td style="border-right: 1px solid #59B3D9;" align="center" class="contenido"><input type="checkbox" value="<%=rankingSeccion.getId()%>,-1" name="ranking<%=rankingNumero%>" onclick="document.formContenidosEstaticos.selectAll.checked=false;"></td>
                        <td style="border-right: 1px solid #59B3D9;"  class="contenido"><%=Convert.corregir(Globals.seccion(rankingSeccion.getId()),true).toUpperCase()%></td>
                       <% rankingNumero++;%>
					</tr>
						<%} %>
              		<%} %>  
                    
				</table>
				
				<table width="500" align="center">
				  <tr>
					<td width="500" align="right">
						<br><br>
						
						<script language="javascript">   				
							
							function generarRanking(ranking){							

    							document.formContenidosEstaticos.rankingsAGenerar.value = document.formContenidosEstaticos.rankingsAGenerar.value + ranking + ";";
							}
						                                             
							function estaChecked(cantidadRankings){
								document.formContenidosEstaticos.rankingsAGenerar.value="";
								for(i = 1; i < cantidadRankings;i++ ){
									if ( eval('document.formContenidosEstaticos.ranking' + i + '.checked == true')){
										var ranking = eval('document.formContenidosEstaticos.ranking'+i+'.value') ;
										generarRanking(ranking);										
									} 
								}
							}							                                                  
							
                            function comenzarGeneracion(obj){ 
                                if(document.formContenidosEstaticos.rankingsAGenerar.value!=""){
                                    document.formContenidosEstaticos.submit();                                    
                                } else {
                                    alert("Debe seleccionar la categoría a generar.");
                                }
                            }
                            </script>
						<div align="right">
						<a style="cursor:hand;" onclick="estaChecked(<%=rankingNumero%>);comenzarGeneracion(this);return;"><img src="/imagenes/boton_Generar_Contenido_Estatico.gif" border="0"></a>
                        <a href="/236-TMK/generacion/"><img src="/imagenes/botonVolver.gif" border="0"></a>
						</div>
					</td>
				  </tr>
				</table>
                </form>
			</td>
		</tr>
	</table>
</body>