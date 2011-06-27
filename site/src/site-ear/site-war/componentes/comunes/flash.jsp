<%if (flash.getFile().indexOf("swf") >= 0) {%>
	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="<%=flash.getAncho()%>" height="<%=flash.getAlto()%>">
		<param name="movie" value="/imagenes/<%=flash.getFile()%>">
		<param name="quality" value="high"><param name="SCALE" value="exactfit">
		<embed src="/imagenes/<%=flash.getFile()%>" width="<%=flash.getAncho()%>" height="<%=flash.getAlto()%>" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" scale="exactfit"></embed>
	</object>
<%} else {%>
	<img src="<%=flash.getFile()%>">
<%}%>
