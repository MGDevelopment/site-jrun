<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.extranet.alianza.AlianzaHelper,
				 com.tmk.controllers.extranet.reporte.ReporteHelper,
				 com.tmk.controllers.MainHelper"%>

<%	Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");
	
	if(idAlianza == null) {
		session.setAttribute("Extranet.feedback", "Ingrese su usuario y clave para acceder al contenido RSS de Novedades de Tematika.com");
		session.setAttribute("Extranet.redirect", "/extranet/rss");
%>
		<jsp:forward page="/extranet/index.jsp" />
<%	}
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Extranet RSS") %>
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>

	<body background="/imagenes/extranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<table width="770" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" align="center" border="0">
		<tr>
			<td align="center" valign="top">
				<table align="center" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td>
						<jsp:include page="/extranet/comunes/header.jsp"/>
						<jsp:include page="/extranet/comunes/solapas.jsp"/>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>

		<table width="770"  bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" align="center" border="0">
		<tr>
			<td align="left">
				<font style= "font-size:12px" color="#003366">
					&nbsp; &nbsp; Seleccione el RSS de novedades segun la categoría deseada:
					<p/>
				</font>
			</td>
		</tr>

		<tr height="400">
			<td align="center" valign="top">
			<table width="90%" cellpadding="0" cellspacing="0" border="0" align="center">	 	
								<tr valign="top">
									<td align="left" valign="top" width="40" style="font-size:5px;padding-top:2px">
										<a href="/GenerarRSSParaAlianza?<%=MainHelper.FIELD_ID_SECCION%>=<%=Globals.SECCION_LIBRO%>" target="_blank">
											<img src="/imagenes/xmlIcono.gif" border="0">
										</a>	
									</td>
									<td align="left" ><a style="color:#003366;font-size:11px" href="/GenerarRSSParaAlianza?<%=MainHelper.FIELD_ID_SECCION%>=<%=Globals.SECCION_LIBRO%>" target="_blank"><b>Ultimas Novedades y Lanzamientos de Libros</b><br>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div style="border-bottom: solid 1px #CCC;font-size:1"></div>
									</td>
								</tr>

								<tr>
									<td colspan="2" style="font-size:5px">
										<br>
									</td>
								</tr>
								<tr>
									<td align="left" valign="top" width="40" style="font-size:5px;padding-top:2px">
										<a href="/GenerarRSSParaAlianza?<%=MainHelper.FIELD_ID_SECCION%>=<%=Globals.SECCION_PELICULA%>" target="_blank">
											<img src="/imagenes/xmlIcono.gif" border="0">
										</a>
									</td>	
									<td align="left"><a style="color:#003366;font-size:11px" href="/GenerarRSSParaAlianza?<%=MainHelper.FIELD_ID_SECCION%>=<%=Globals.SECCION_PELICULA%>" target="_blank"><b>Ultimos Lanzamientos en DVD</b></a><br>
									</td>
								</tr>
								<tr>
									<td colspan="2">

										<div style="border-bottom: solid 1px #CCC;font-size:1"></div>
									</td>
								</tr>
								<tr>
									<td colspan="2" style="font-size:5px">
										<br>
									</td>
								</tr>
								<tr>
									<td align="left" valign="top" width="40" style="font-size:5px;padding-top:2px">
										<a href="/GenerarRSSParaAlianza?<%=MainHelper.FIELD_ID_SECCION%>=<%=Globals.SECCION_MUSICA%>" target="_blank">
											<img src="/imagenes/xmlIcono.gif" border="0">
										</a>	
									</td>
									<td align="left" class="rssLeyenda"><a style="color:#003366;font-size:11px" href="/GenerarRSSParaAlianza?<%=MainHelper.FIELD_ID_SECCION%>=<%=Globals.SECCION_MUSICA%>" target="_blank"> <b>Ultimos Lanzamientos de CDs</b> <br>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div style="border-bottom: solid 1px #CCC;font-size:1"></div>
									</td>
								</tr>
								<tr>
									<td colspan="2" style="font-size:5px">
										<br>
									</td>
								</tr>
								<tr>
									<td align="left" valign="top" width="40" style="font-size:5px;padding-top:2px">
										<a href="/GenerarRSSParaAlianza?<%=MainHelper.FIELD_ID_SECCION%>=<%=Globals.SECCION_JUGUETES%>" target="_blank">
											<img src="/imagenes/xmlIcono.gif" border="0">
										</a>	
									</td>
									<td align="left" class="rssLeyenda"><a style="color:#003366;font-size:11px" href="/GenerarRSSParaAlianza?<%=MainHelper.FIELD_ID_SECCION%>=<%=Globals.SECCION_JUGUETES%>" target="_blank"> <b>Novedades de Pasatiempos</b> <br>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div style="border-bottom: solid 1px #CCC;font-size:1"></div>
									</td>
								</tr>
							</table>	
			
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>
