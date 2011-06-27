<%@ page import="com.tmk.articulo.ArticuloLocal,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals" %>
<%
	int idArticulo = Integer.valueOf(request.getParameter("idArticulo").toString()).intValue();
	ArticuloLocal articuloLocal = Contenido.getArticulo(idArticulo);
	String texto = Contenido.getIndice(articuloLocal);
	String imagenSuperior="/imagenes/articulo_" + articuloLocal.getCATEGORIA_SECCION() + ".gif";
	//String imagenInferior = "/imagenes/indices_" + articuloLocal.getCATEGORIA_SECCION() + ".gif";
	String imagenInferior = "/imagenes/indices.gif";
%>
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Indice") %>
		<%= Globals.keywords("Indice, Tabla de Contenido, Lista de Temas, Temario") %>
        <link href="/estilos/seccion_<%= Globals.seccion(articuloLocal.getCATEGORIA_SECCION().intValue())%>.css" rel="stylesheet" type="text/css">
	</head>
	<body link="#000000" vlink="#000000" alink="#000000" leftmargin="0" topmargin="0">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" Class="tablaPrincipal">
			<tr >
				<td height="19" colspan="4" align="left" valign="middle" class="Precios">&nbsp;</td>
				<td width="3"></td>
			</tr>
			<tr>
				<td width="18" rowspan="3" valign="top">&nbsp; </td>
				<td width="109" height="38" align="center" valign="bottom" ><img src="<%=imagenSuperior%>"><img src="<%=imagenInferior%>"></td>
				<td height="19" colspan="2" align="left" valign="middle" Class="titulo" ><br><br><br><%=Contenido.getTitulo(idArticulo)%> </td>
				<td></td>
			</tr>
			<tr>
				<td rowspan="2" align="center" valign="middle" >&nbsp;</td>
				<td height="2"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td></td>
			</tr>
			<tr>
				<td height="450" valign="top" Class="fondoClaro">&nbsp;</td>
				<td colspan="2" valign="top" Class="fondoClaro"><br><div align="justify"><%=texto.replaceAll(Globals.ENTER,"<br>")%></div></td>
				<td width="31" valign="top" Class="fondoClaro">&nbsp;</td>
				<td></td>
			</tr>
			<tr>
				<td height="1"></td>
				<td></td>
				<td width="832"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
<%=Globals.getGoogleAnalytics()%>
	</body>
</html>
