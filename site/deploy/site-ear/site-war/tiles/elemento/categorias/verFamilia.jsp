<%--
	permite pasar directamente al jsp que muestra cada verFamilia especifico y evitar tantos if
	para determinar cual es el que se debe usar 
--%>
<%		
	StringBuffer url = new StringBuffer("/tiles/elemento/categorias/verFamilia");
	url.append(request.getParameter("idSeccion").toString());
	url.append(".jsp?");
	url.append(request.getQueryString());
	pageContext.include(url.toString());			
%>
