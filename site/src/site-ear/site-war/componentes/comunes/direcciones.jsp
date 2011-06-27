<%@ page import="com.tmk.kernel.Convert"%>
<%int direccion= Convert.toNumber(request.getParameter("direccion"),1);%>
<table width="150">
	<tr>
		<td>
		<%if (direccion==1){%>
          <img src= "/imagenes/direccionesVerde.jpg" vspace="4"><br>
		  <img src="/imagenes/doblehr.jpg" height="5" width="108"><br><br>
		  <%}else{%>
			<img src= "/imagenes/direccionesAzul.jpg" vspace="4"><br>
			<img src="/imagenes/doblehr.jpg" height="5" width="108"><br><br>
      <%}%>
      <br>
        <%if (direccion==1){%>
                  <a href = "/institucional/elAteneo.jsp?direccion=2"><img src="/imagenes/logoAteneo.gif" vspace="2" align="absmiddle"border="0"></a>
          <%}else{%>
              <img src= "/imagenes/logoAteneo.gif" vspace="2" align="absmiddle">
          <%}%>
          <br>
		<%if (direccion==2){%>
		<table style="font-weight: bold;" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<img src="/imagenes/clickTrans.gif">
				</td>
				<td height="30">
                  		<a href = "/institucional/elAteneo.jsp?direccion=2#capital"> Capital Federal</a>
				</td>
			</tr>
			<tr>
				<td>
					<img src="/imagenes/clickTrans.gif">
				</td>
				<td height="30">
                  		<a href = "/institucional/elAteneo.jsp?direccion=2#interior"> Interior</a>
				</td>
			</tr>
		</table>
		<%}%>
	<br>
		<%if (direccion==2){%>
                  <a href = "/institucional/yenny.jsp?direccion=1"><img src= "/imagenes/logoYenny.gif" vspace="2" align="absmiddle" border="0"></a>
          <%}else{%>
              <img src= "/imagenes/logoYenny.gif" vspace="2" align="absmiddle">
          <%}%>
          <br>
		 <%if (direccion==1){%>
		    <table style="font-weight: bold;" cellpadding="0" cellspacing="0">
			 <tr>
				<td>
					<img src="/imagenes/clickTrans.gif">
				</td>
				<td height="30">
                  		<a href = "/institucional/yenny.jsp?direccion=1#capital"> Capital</a>
				</td>
			</tr>
			<tr>
				<td>
					<img src="/imagenes/clickTrans.gif">
				</td>
				<td height="30">
                  		<a href = "/institucional/yenny.jsp?direccion=1#buenosaires"> Gran Buenos Aires</a>
				</td>
			</tr>
			<tr>
				<td>
					<img src="/imagenes/clickTrans.gif">
				</td>
				<td height="30">
                  		<a href = "/institucional/yenny.jsp?direccion=1#interior"> Interior</a>
				</td>
			</tr>
			<tr>
				<td>
					<img src="/imagenes/clickTrans.gif">
				</td>
				<td height="30">
                  		<a href = "/institucional/yenny.jsp?direccion=1#exterior"> Exterior</a>
				</td>
			</tr>
		</table>
		<%}%>
	 </td>
	</tr>
</table>
