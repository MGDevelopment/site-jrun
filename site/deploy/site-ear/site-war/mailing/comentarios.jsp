<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.kernel.Convert,
                 com.tmk.setup.Contenido,
                 com.tmk.articulo.ArticuloLocal,
                 com.tmk.controllers.comentario.ComentarioHelper,
                 com.tmk.kernel.Pair,
                 java.util.Vector,
                 com.tmk.common.ComentarioClass"%>
                 
<%--
                // com.tmk.socio.SocioLocalHome,
                // com.tmk.socio.SocioPK,
                // com.tmk.socio.SocioLocal, 
--%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<body>
		<b>Reporte sobre Comentarios de Artículos</b><br><br>
<%
	ComentarioClass comentarios[] = ComentarioClass.getComentariosPorEstado(ComentarioHelper.PENDIENTE);
	if (comentarios!= null && comentarios.length>0) {
		for (int i=0; i<comentarios.length; i++) {
%>
		<table align="center" width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td width="18%">
					<%= Convert.toStringLargo(comentarios[i].getFecha())%>
				</td>
                <td>
					<a href ="mailto:<%=comentarios[i].getEmailSocio()%>?subject=Corrección de su Comentario en Tematika. &Body=<%=comentarios[i].getTexto()%>"><%=comentarios[i].getNickName()%></a>
				</td>
				<td width="15%">
					<%= ComentarioHelper.TEXTOS[comentarios[i].getEvaluacion() - ComentarioHelper.MINIMO_EVALUACION] %>
				</td>
                <td width="40%">
                    <a href="<%=Globals.PAGINA_SITIO%>/articulo/detalleArticulo.jsp?idArticulo=<%=comentarios[i].getIdArticulo()%>&idSeccion=<%=comentarios[i].getIdSeccion()%>">
                    <%= comentarios[i].getTituloArticulo()%></a>
				</td>
			</tr>
            <tr>
                <td colspan="4" style="background-color: #FFFFF0;">
                    <%= comentarios[i].getTexto().replaceAll("\n","<br>")%><br>
                    <br>
                </td>
            </tr>
		</table>
		<br>
<%  	}
	}else {
%>
		No se han registrado nuevos comentarios.
<%
	}
%>
	</body>
</html>
