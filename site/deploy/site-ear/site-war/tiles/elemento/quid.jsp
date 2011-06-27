<%@page import="com.tmk.kernel.Globals"%>
<table border="0">
	<tr>
		<td style="padding-top: 30px;">
			<jsp:include flush="true" page="/grupos/quid/quidActual.html"></jsp:include>
		</td>
		<td class="Gbarraderecha" width="155" valign="top">
			<table border="0" cellpadding="0" cellspacing="0">
<%--				<tr>
					<td>
						<a href="/quid/suscripcionQuid.jsp?ID_ALIANZA=1234&ID_SECCION=1213" title="Inicia tu suscripcion a nuestra revista!!!" class="sinLink" >
							<img src="/imagenes/rediseno/imagenes/quidSuscripcion.jpg" border="0"/>
						</a>
					</td>
				</tr>
--%>
				    <%String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
			  		<jsp:include page="<%=urlInstitucionalRight%>"/>			  		
			</table>
		</td>
	</tr>
</table>
