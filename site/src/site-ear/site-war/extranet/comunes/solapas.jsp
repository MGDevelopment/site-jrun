<%@ page import="com.tmk.setup.Contenido"
%>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
	<td align="right" style="background:  url(/imagenes/intranet/fondo_solapas.gif); repeat-x">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<a href="/extranet/afiliados/index.jsp">
					<img src="/imagenes/extranet/solapa_afiliados.gif" border="0">
				</a>
			</td>

			<td>
				<a href="/extranet/reportes/index.jsp">
					<img src="/imagenes/extranet/solapa_reportes.gif" border="0">
				</a>
			</td>
			
			<td>
				<a href="/extranet/rss/index.jsp">
					<img src="/imagenes/extranet/solapa_rss.gif" border="0">
				</a>
			</td>

			<td>
				<a href="mailto:<%= Contenido.getSite().getConfiguracion().getAlianzas().getEmail() %>?subject=Programa%20de%20Afiliados">
					<img src="/imagenes/extranet/solapa_contactenos.gif" border="0">
				</a>
			</td>

			<td>
				<a href="/extranet/ayuda/ayuda.jsp">
					<img src="/imagenes/extranet/solapa_ayuda.gif" border="0">
				</a>
			</td>
		</tr>
		</table>
	</td>
</tr>

<tr>
	<td height="12" style="background:url(/imagenes/intranet/fondo_renglon.gif); repeat-x">
	</td>
</tr>
</table>
