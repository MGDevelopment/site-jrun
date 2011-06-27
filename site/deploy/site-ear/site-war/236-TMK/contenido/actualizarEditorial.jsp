<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.*,
				 com.tmk.controllers.intranet.contenido.ContenidoHelper,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.articulo.EditorLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.articulo.EditorLocal,
                 javax.ejb.FinderException"%>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	} %>

<%
    EditorLocal editorLocal = null;
    Integer idEditorial = null;
    String nombre = null;
    try{
        Integer idEditor = Convert.toNumber(request.getParameter("idEditor"),(Integer) null);
        idEditorial = Convert.toNumber(request.getParameter("idEditorial"),(Integer) null);
        nombre = Convert.toString(request.getParameter("nombre"),"");
        EditorLocalHome editorLocalHome = (EditorLocalHome) DBUtil.getHome("Editor");
        editorLocal = editorLocalHome.findByPrimaryKey(idEditor);
    }catch (FinderException fe){%>
        <jsp:forward page="urlEditoriales.jsp"/>
    <%}catch (Exception e){%>
        <jsp:forward page="urlEditoriales.jsp"/>
    <%}
%>

	<style type="text/css" rel="stylesheet">
		font.TextoBordo
		{
			color: #990000;
			font-size: 12px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}

		table.BordeFino
		{
			border-collapse: collapse;
			border: 2px solid;
			border-color: #5AB5DE;
		}
	</style>
	<%= Globals.estiloBasico() %>

<body background="/imagenes/admSite/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
<table align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" width="770" height="100%"><tr><td valign="top">
	<table width="100%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<jsp:include page="/admSite/comunes/header.jsp"/>
			</td>
		</tr>
	</table>

    <br><font style="font-size: 18px; color:#003366">&nbsp;&nbsp;Modificación de la Url de Editoriales</font><br><br>

    <form name="formActualizarEditor" action="/ModificarEditor" method="post">
    <input type="hidden" value="<%=editorLocal.getID_EDITOR()%>" name="idEditor">
    <input type="hidden" value="<%=Convert.toString(idEditorial,"")%>" name="idEditorial">
    <input type="hidden" value="<%=Convert.toString(nombre,"")%>" name="nombre">
    <table width="500" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
        <tr class="titulos" >
		    <td bgcolor="#59B3D9" align="center">IdEditorial</td>
			<td bgcolor="#59B3D9" align="center">Nombre</td>
		</tr>
        <tr>
            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="left">&nbsp;<%=editorLocal.getID_EDITOR()%></td>
            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="left">&nbsp;<%=editorLocal.getNOMBRE()%></td>
        </tr>
        <tr class="titulos" >
		    <td colspan="2" bgcolor="#59B3D9" align="center">&nbsp;Url</td>
		</tr>
        <tr>
            <td colspan="2" style="border-right: 1px solid #59B3D9;"  class="contenido" align="center">
            <%
                String urlEditorial = Convert.toString(editorLocal.getURL(),"");
                if(urlEditorial.length()>7){
                    urlEditorial = editorLocal.getURL().substring(7);
                }else{
                    urlEditorial = "";
                }
            %>
            http://&nbsp;<input type="text" size="80" maxlength="256" name="urlEditor" value="<%=urlEditorial%>">
            </td>
        </tr>
    </table>
    <br><br>
    <table width="512" align="center">
        <tr>
            <td align="right">
                <a href="/admSite/contenido/urlEditoriales.jsp?idEditorial=<%=Convert.toString(idEditorial,"")%>&nombre=<%=Convert.toString(nombre,"")%>&senal=1"><img src="/imagenes/botonVolver.gif" border="0"></a>
                &nbsp;&nbsp;<img src="/imagenes/botonActualizar.gif" border="0" style="cursor:hand;" onclick="javascript:document.formActualizarEditor.submit();">
		    </td>
	    </tr>
	</table>
</td></tr></table>
</body>
</html>