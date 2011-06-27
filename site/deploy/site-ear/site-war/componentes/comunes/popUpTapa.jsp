<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals"%>
                 
<%String pathImg = Convert.toString(request.getParameter("pathImg"), "");%>

<html>
	<head>
		<%= Globals.title("Imagen del producto") %>
		<%= Globals.keywords("Imagen, Foto, Fotografía, Tapa, Aspecto del Producto") %>
        <meta name="robots" content="noindex, nofollow">
        <meta name="GOOGLEBOT" content="noindex, nofollow">

		<script language="javascript">
		function resizeImg() {

			w = document.images[0].width;
			h = document.images[0].height;
			window.resizeTo(w+50, h+65);
			//window.setTimeout('resizeImg()', 1000);
		}
		</script>


	</head>
	<body onContextMenu="return false;" onload="resizeImg()" topmargin=15>
		<table border="0" align="center">
			<tr valign="middle" >
				<td height="95" valign="middle">
					<img src="<%=pathImg%>" border="0" name="imagen">
				</td>
			</tr>

		</table>
	</body>
</html>
