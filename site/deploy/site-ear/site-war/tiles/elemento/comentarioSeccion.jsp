<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<%--@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.kernel.TmkLogger"--%>

<%--
	Hashtable path =  new Hashtable();
	path.put("filename",application.getRealPath(MainHelper.RES_TMPL_PATH + "/templates/tmpComentarioSeccion.htm"));
	try {
		Template tmpMnuDcho  = new Template(path);
		out.println(tmpMnuDcho.output());
	} catch(Exception e) {

	}
--%>
<script language="javascript">	
	<%
		Object idGrupo = request.getParameter("idGrupo");
		Object idFamilia = request.getParameter("idFamilia");
		Object idSubFamilia = request.getParameter("idSubFamilia");
	%>
	$(document).ready(function() {
		<%--function en /tiles/elemento/js/jsSeccionConCatalogo.jsp--%>
		getComentariosSeccion(<%=idSeccion%>,<%=idGrupo%>,<%=idFamilia%>,<%=idSubFamilia%>);
	});	
</script>
<div class="solapas" id="calles3"><!-- comentarios -->
   	<div class="tmtkMesaMenuMod">
        <div class="solapasTitComent"></div>
        <!-- <ul class="dropdown">
        	<li class="dir"><span onclick="javascript:desplegarOpciones('displayUsuarios');" id="mostrardisplayUsuarios">Los más recientes</span>
	        	<ul id="displayUsuarios">
	        		<li><a id="recientesUsr" onmouseover="javascript:desplegarOpciones('displayUsuarios);" onmouseout="javascript:ocultarOpciones('displayUsuarios');" href="javascript:mostrarBuscarPor('recientesUsr','mostrardisplayUsuarios','displayUsuarios');">Los más recientes</a></li>
	                <li><a id="utilesUsr" onmouseover="javascript:desplegarOpciones('displayUsuarios');" onmouseout="javascript:ocultarOpciones('displayUsuarios');" href="javascript:mostrarBuscarPor('utilesUsr','mostrardisplayUsuarios','displayUsuarios');">Los más útiles</a></li>
	                <li><a id="popularesUsr" onmouseover="javascript:desplegarOpciones('displayUsuarios');" onmouseout="javascript:ocultarOpciones('displayUsuarios');" href="javascript:mostrarBuscarPor('popularesUsr','mostrardisplayUsuarios','displayUsuarios');">Los más populares</a></li>
				</ul>
            </li>
        </ul>
        -->
   	</div>
   	<a name="coment"></a>
    <div id="divComentarios"></div>
</div>