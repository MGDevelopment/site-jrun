<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.*,
				 com.tmk.controllers.intranet.contenido.ContenidoHelper,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet"%>
<html>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("CONTENIDOS", "RANKING_M")) {
%>
    	<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Modificación del Contenido") %>
		
		<script src="/js/ajax.js" type="text/javascript"></script>
		<script src="/js/prototipe.js" type="text/javascript"></script>
		
		<script type="text/javascript">
		function grabar() {
			$("grabarContenido").disabled = true;
			ejecutarAjax('/GrabarCambiosContenido', '', 'POST', null);
			return false;
		}
		
		function handle(connAj, addPar) {
			if(connAj.readyState == 4){
				$("grabarContenido").disabled = false
				$('error').hide();
				$('success').hide();
				try {
					handleWait(false);
					if (setValues(connAj.responseXML, 'success', 'error') == 'success') {
						$('success').show();
					} else {
						$('error').show();
					}
				} catch (e) {
					alert(e);
				}				
		    } else {
				handleWait(true);
				// no hago nada
		    }
		}
		</script>

		<style type="text/css" rel="stylesheet">
			font.TituloBordo
			{
				color: #990000;
				font-size: 14px;
				font-family: verdana;
				text-transform: uppercase;
				font-weight: bold;
				text-align: center;
			}
	
			font.TextoBordo
			{
				color: #990000;
				font-size: 12px;
				font-family: verdana;
				text-transform: uppercase;
				font-weight: bold;
				text-align: center;
			}
	
			a.EnlaceNegro
			{
				font-size: 11px;
				font-family: verdana;
				color: #000000;
				text-decoration: none;
			}
	
			table.BordeFino
			{
				border-collapse: collapse;
				border: 2px solid;
				border-color: #5AB5DE;
			}
		</style>

	</head>
<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" width="770" height="100%">
 <tr>
  <td valign="top">
	<table cellpadding="0" cellspacing="0" width="770">
		<tr>
			<td>
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:include page="/236-TMK/comunes/header.jsp"/>
						</td>
					</tr>
				</table>
				<br>

				<table width="650" align="center" border="0">
				<tr>
					<td>
						<table width="100%">
						<tr valign="top">
							<td	width="5%">
							</td>

							<td width="50%">
								<br>
								<font class="TextoBordo">
									Configuración general
								</font>
								<br><br>


                                <%if (usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {%>
								<img src="/imagenes/intranet/vineta.gif">
								<a href="/236-TMK/contenido/papelRegalo.jsp" class="EnlaceNegro">
									Papeles de regalo
								</a>
								<br><br>
								<%}%>

								<%//if (usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {%>
								<!-- img src="/imagenes/intranet/vineta.gif">
								<a href="/236-TMK/contenido/recomendacionLD.jsp" class="EnlaceNegro">
									Recomendados
								</a>
								<br><br-->
								<%//}%>

								<%if (usuarioDAO.tieneAlgunAcceso("CONTENIDOS", "RANKING_M")) {%>
								<img src="/imagenes/intranet/vineta.gif">
								<a href="/236-TMK/contenido/ranking.jsp" class="EnlaceNegro">
									Ranking
								</a>
								<br><br>
								<%}%>

								<%//if (usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {%>
								<!-- img src="/imagenes/intranet/vineta.gif">
								<a href="/236-TMK/contenido/urlEditoriales.jsp" class="EnlaceNegro">
									Editoriales
								</a>
								<br><br-->
								<%//}%>

							</td>
							<td	width="10%">
							</td>

							<td width="35%">
								<br>
								<font class="TextoBordo">
									Contenido por Página
								</font>
								<br><br>
							<%
								/*if (usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {
                                    Paginas paginas = Contenido.getSite().getPaginas();
									for (int i = 0; i < paginas.getPaginaCount(); i++) {
										Pagina pagina = paginas.getPagina(i);
								        if (Globals.seccionHabilitada(pagina.getId())) {*/
			                %>
								<!-- img src="/imagenes/intranet/vineta.gif">
								<a href="/236-TMK/contenido/contenido.jsp?<%//= ContenidoHelper.CAMPO_SECCION %>=<%//= pagina.getId()%>" class="EnlaceNegro">
									<%//= Convert.capitalizar(Globals.seccion(pagina.getId()), false)%>
								</a>
								<br><br-->
							<%
						/*		        }
									}
								}*/
							%>
									<img src="/imagenes/intranet/vineta.gif">
								<a href="/236-TMK/contenido/catalogo.jsp" class="EnlaceNegro">
									Catalogo
								</a>
								<br><br>
						
							</td>
						
						
						</tr>
						</table>
					</td>
				<tr>
				</table>
						<form name="generarArchivo" method="post" onSubmit="return grabar()">
							
							<table width="650" align="center">
								<tr>
									<td>
										<!-- SUCCESS -->
										<table id="success" align="center" style="display:none">
											<tr>
												<td style="color:green">
													<div id="msg"></div>
												</td>
											</tr>
										</table>
										<!-- /SUCCESS -->
										<!-- WAIT -->
										<table width="600" id="wait" align="center"  style="display:none" height="25">
											<tr bgcolor="EEEEEE">
												<td>
													<div id="msg"></div>	
												</td>
											</tr>
										</table>
										<!-- /WAIT -->
										<!-- ERROR -->
										<table id="error" align="center"  style="display:none">
											<tr>
												<td align="center" style="color:red">
													<div id="msg"></div>
												</td>
											</tr>
										</table>
										<!-- /ERROR -->
									</td>
								</tr>	
								<tr>
									<td colspan="2" align="center">
										<input id="grabarContenido" type="submit" value="Grabar Contenido">
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
