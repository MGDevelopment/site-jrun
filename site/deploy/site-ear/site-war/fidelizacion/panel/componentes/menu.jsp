<%
String mnuActivo = request.getParameter("mnuActivo");
String acciones = " onMouseOver=\"cambiarImagen('<ID>', '/imagenes/fidelizacion/<IMGOVER>')\" onMouseOut=\"cambiarImagen('<ID>', '/imagenes/fidelizacion/<IMG>')\" ";
%>

<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr> 
    	<td width="740">
    	<table width="740" cellpadding="0" cellspacing="0">
    		<tr>
    			<td>
    				<table cellpadding="0" cellspacing="0">
    					<tr>
    						<td>
			    				<a name="top"></a><a href="/fidelizacion/panel/index.jsp"><img src="/imagenes/fidelizacion/header_01.gif" width="202" height="90" border="0"></a>
			    			</td>
			    			<td>
			    				<%if ("1".equals(mnuActivo)) {%>
				    				<img src="/imagenes/fidelizacion/headers2-bienv_02.gif" width="373" height="90">
			    				<%}%>
			    				<%if ("2".equals(mnuActivo)) {%>
				    				<img src="/imagenes/fidelizacion/headers2-disfruta_02.gif" width="373" height="90">
				    			<%}%>	
				    			<%if ("3".equals(mnuActivo)) {%>
					    			<img src="/imagenes/fidelizacion/headers2-sumay_02.gif" width="373" height="90">
				    			<%}%>		
				    			<%if ("5".equals(mnuActivo)) {%>
					    			<img src="/imagenes/fidelizacion/headers2-consulta_02.gif" width="373" height="90">				    			
					    		<%}%>	
				    			<%if ("6".equals(mnuActivo)) {%>
						    		<img src="/imagenes/fidelizacion/headers2-comenza_02.gif" width="373" height="90">
						    	<%}%>
  				    			<%if ("7".equals(mnuActivo)) {%>
							    	<img src="/imagenes/fidelizacion/headers2-bases_02.gif" width="373" height="90">	
   						    	<%}%>	
   						    	<%if ("8".equals(mnuActivo)) {%>
   						    		<img src="/imagenes/fidelizacion/headers2-disfruta_02.gif" width="373" height="90">
   						    	<%}%>
   						    	<%if (mnuActivo == null) {%>
				    				<img src="/imagenes/fidelizacion/headers2-bienv_02.gif" width="373" height="90">
			    				<%}%>	   						    	
			    			</td>
			    			<td>
				    			<a href="/fidelizacion/panel/actualizacionEMail.jsp"><img src="/imagenes/fidelizacion/200-b-165x90.gif" width="165" height="90" border="0"></a>
			    			</td>
			    		</tr>
			    	</table>
			    </td>
			</tr>
			<tr>   
				<td>
					<table width="740" cellpadding="0" cellspacing="0">
						<tr>
						    <td><a href="/fidelizacion/panel/index.jsp" <%=("1".equals(mnuActivo))?"":acciones.replaceAll("<ID>", "mnu1").replaceAll("<IMGOVER>", "mnu1Over.gif").replaceAll("<IMG>", "mnu1.gif")%>><img id="mnu1" src="/imagenes/fidelizacion/mnu1.gif" width="49" height="31" border="0"></a></td>
						    <td><a href="/fidelizacion/panel/beneficios.jsp" <%=("2".equals(mnuActivo))?"":acciones.replaceAll("<ID>", "mnu2").replaceAll("<IMGOVER>", "mnu2Over.gif").replaceAll("<IMG>", "mnu2.gif")%>><img id="mnu2" src="/imagenes/fidelizacion/mnu2.gif" width="61" height="31" border="0"></a></td>
						    <td><a href="/fidelizacion/panel/catalogo.jsp" <%=("3".equals(mnuActivo))?"":acciones.replaceAll("<ID>", "mnu3").replaceAll("<IMGOVER>", "mnu3Over.gif").replaceAll("<IMG>", "mnu3.gif")%>><img id="mnu3" src="/imagenes/fidelizacion/mnu3.gif" width="121" height="31" border="0"></a></td>
						    <td><a href="/miCuenta/registroSocioEXtra.jsp" <%=("4".equals(mnuActivo))?"":acciones.replaceAll("<ID>", "mnu4").replaceAll("<IMGOVER>", "mnu4Over.gif").replaceAll("<IMG>", "mnu4.gif")%>><img id="mnu4" src="/imagenes/fidelizacion/mnu4.gif" width="55" height="31" border="0"></a></td>
						    <td><a href="/fidelizacion/panel/puntos.jsp" <%=("5".equals(mnuActivo))?"":acciones.replaceAll("<ID>", "mnu5").replaceAll("<IMGOVER>", "mnu5Over.gif").replaceAll("<IMG>", "mnu5.gif")%>><img id="mnu5" src="/imagenes/fidelizacion/mnu5.gif" width="116" height="31" border="0"></a></td>
						    <td><a href="/fidelizacion/panel/preguntas.jsp" <%=("6".equals(mnuActivo))?"":acciones.replaceAll("<ID>", "mnu6").replaceAll("<IMGOVER>", "mnu6Over.gif").replaceAll("<IMG>", "mnu6.gif")%>><img id="mnu6" src="/imagenes/fidelizacion/mnu6.gif" width="130" height="31" border="0"></a></td>
						    <td><a href="/fidelizacion/panel/reglamento.jsp" <%=("7".equals(mnuActivo))?"":acciones.replaceAll("<ID>", "mnu7").replaceAll("<IMGOVER>", "mnu7Over.gif").replaceAll("<IMG>", "mnu7.gif")%>><img id="mnu7" src="/imagenes/fidelizacion/mnu7.gif" width="71" height="31" border="0"></a></td>
						    <td><a href="/fidelizacion/panel/actualizacionEMail.jsp" <%=("8".equals(mnuActivo))?"":acciones.replaceAll("<ID>", "mnu8").replaceAll("<IMGOVER>", "mnu8Over.gif").replaceAll("<IMG>", "mnu8.gif")%>><img id="mnu8" src="/imagenes/fidelizacion/mnu8.gif" width="137" height="31" border="0"></a></td>
			    	   	</tr>
			    	</table>
			    </td>	   	
			</tr>
			<tr>
				<td>	    	
			    	<img src="/imagenes/fidelizacion/marco_01.gif" width="740" height="8"></td>
			    </td>
			</tr>
		</table>	    	
    </tr>
</table>
<% if(mnuActivo!= null) {%>
<script>
	cambiarImagen('mnu<%=mnuActivo%>', '/imagenes/fidelizacion/mnu<%=mnuActivo%>Over.gif');
	document.getElementById('mnu<%=mnuActivo%>').onmouseover='';
	document.getElementById('mnu<%=mnuActivo%>').onmouseout='';
</script>
<% }%>