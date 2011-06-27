<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals"%>
<%  //int idArticulo = Convert.toNumber(request.getParameter("idArticulo"), Globals.ARTICULO_DEFAULT);
	//String textoH1 = request.getParameter("textoH1");
%>

<html>
	<head>
	<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Imagen del producto") %>
		<%= Globals.keywords("Imagen, Foto, Fotografía, Tapa, Aspecto del Producto") %>
        <meta name="robots" content="noindex, nofollow">
        <meta name="GOOGLEBOT" content="noindex, nofollow">

		<script language="javascript">
		function resizeImg() {

			w = document.images[0].width;
			h = document.images[0].height;
			window.resizeTo(w+50, h+95);
			//window.setTimeout('resizeImg()', 1000);
		}
		</script>


	</head>
	<body onContextMenu="return false;" onload="resizeImg()" topmargin=15>
		<table border="0" align="center">
			<tr>
				<td align="center">
					<h1 style="color:006699; font-size:12;font-family:verdana">
						
					</h1>
				</td>
			</tr>
			<tr valign="middle" >
				<td height="95" valign="middle">
					<img src="<%=request.getParameter("path")%>" border="0" name="imagen">
				</td>
			</tr>

		</table>
	</body>
</html>
