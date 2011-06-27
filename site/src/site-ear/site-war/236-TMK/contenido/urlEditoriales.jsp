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
                 javax.ejb.FinderException,
                 com.tmk.kernel.TmkLogger"%>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	} %>

<%
    int senal = Convert.toNumber(request.getParameter("senal"), 0);
    Iterator editores = null;
    Integer idEditorial = null;
    String nombreBuscado = "";
    String nombre = null;
    if(senal==1){
        //busca los editores
        try{
            idEditorial = Convert.toNumber(request.getParameter("idEditorial"),new Integer(0));
            nombre = Convert.toString(request.getParameter("nombre"),"");
            if(nombre!=""){
                nombreBuscado = "%" + nombre.toUpperCase() + "%";
            }
            EditorLocalHome editorLocal = (EditorLocalHome) DBUtil.getHome("Editor");
            editores = editorLocal.findByNombreEditorial(idEditorial,nombreBuscado).iterator();
        }
        catch(FinderException fe){
            TmkLogger.debug(fe.toString());
        }
        catch(Exception e){
           TmkLogger.debug(e.toString());
        }
    }
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

<body background="/imagenes/intranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
<table align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" width="770" valign="top" height="100%"><tr><td valign="top">
	<table width="100%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<jsp:include page="/236-TMK/comunes/header.jsp"/>
			</td>
		</tr>
	</table>

    <script type="text/javascript" src="/js/Validation.js"></script>
    <script language="javascript">
    function consultar(){
        if (isEmpty(document.formBuscador.idEditorial.value) && isEmpty(document.formBuscador.nombre.value)) {
            alert('La busqueda no puede estar vacia.');
            return false;
        }
        document.formBuscador.submit();
    }
    </script>

    <br><font style="font-size: 18px; color:#003366">&nbsp;&nbsp;ABM de Editoriales</font><br><br>

    <%
        if(session.getAttribute("edicionEditorError") != null){
    %>
    <CENTER><font style="font-size: 13px; color:red">&nbsp;&nbsp;<b><%=session.getAttribute("edicionEditorError")%></b></font></CENTER>
    <%
            session.removeAttribute("edicionEditorError");
        }
    %>
    <%
        if(session.getAttribute("edicionEditorOk") != null){
    %>
    <CENTER><font style="font-size: 13px; color:green">&nbsp;&nbsp;<b><%=session.getAttribute("edicionEditorOk")%></b></font></CENTER>
    <%
            session.removeAttribute("edicionEditorOk");
        }
    %>

    <form name="formBuscador" action="urlEditoriales.jsp" method="post">
    <input type="hidden" value="1" name="senal">
    <table width="500" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
        <tr class="titulos" >
		    <td bgcolor="#59B3D9" align="center">IdEditorial</td>
			<td bgcolor="#59B3D9" align="center">Nombre / Razon Social</td>
		</tr>
        <tr>
            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="center"><input type="text" value="<%if(idEditorial!=null){if(idEditorial.intValue()!=0)out.println(idEditorial);}%>" onkeydown="if(event.keyCode<48 || event.keyCode>57)event.keyCode='';" name="idEditorial" size="10"></td>
            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="center"><input type="text" value="<%=Convert.toString(nombre,"")%>" name="nombre" size="50"></td>
        </tr>
    </table>

    <table width="512" align="center">
        <tr>
		    <td align="right">
			    <img src="/imagenes/buscar.jpg" border="0" style="cursor:hand;" onclick="javascript:consultar();">
		    </td>
	    </tr>
	</table>

    </form>

    <%
        if(editores!=null){
            if(editores.hasNext()){
                EditorLocal editoresLocales = null;%>
    <table width="700" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
        <tr class="titulos" >
		    <td bgcolor="#59B3D9" align="center">IdEditorial</td>
			<td bgcolor="#59B3D9" align="center">Nombre</td>
            <td bgcolor="#59B3D9" align="center">URL</td>
            <td bgcolor="#59B3D9" align="center">&nbsp;</td>
		</tr>
            <%while(editores.hasNext()) {
                editoresLocales = (EditorLocal)editores.next();%>
        <tr>
            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="left">&nbsp;<%=editoresLocales.getID_EDITOR()%></td>
            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="left">&nbsp;<%=editoresLocales.getNOMBRE()%></td>
            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="left">&nbsp;<%=Convert.toString(editoresLocales.getURL(),"-")%></td>
            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="left">&nbsp;<a style="text-decoration:underline;" href="actualizarEditorial.jsp?idEditorial=<%=Convert.toString(idEditorial,"")%>&nombre=<%=Convert.toString(nombre,"")%>&idEditor=<%=editoresLocales.getID_EDITOR()%>"><b>Modificar</b></a></td>
        </tr>
    <%      } %>
    </table><br><br>
    <%      }else{%>
    <CENTER><font style="font-size: 13px; color:red">&nbsp;&nbsp;<b>No se encontraron editoriales para la búsqueda.</b></font></CENTER><br><br>
    <%      }
        } %>

    <table width="512" align="center">
        <tr>
		    <td width="468"></td>
            <td width="32">
                <a href="/236-TMK/contenido"><img src="/imagenes/botonVolver.gif" border="0"></a>
		    </td>
	    </tr>
	</table>
</td></tr></table>
</body>
</html>