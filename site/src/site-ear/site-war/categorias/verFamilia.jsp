<%
	//REDIRECCIONA AL CATALOGO DESARROLLADO PARA REDISEÑO.
	//PASANDOLE LOS PARAMETROS COMO SI SE SELECCIONASE UNA OPCION DEL ALBOL DE CATEGORIAS.
	StringBuffer url = new StringBuffer("/catalogo/index.jsp?");
	url.append("idSeccion=").append(request.getParameter("seccion").toString());
	url.append("&");
	url.append("idGrupo=").append(request.getParameter("grupo"));
	/*request.setAttribute("idSeccion",request.getParameter("idSeccion"));
	request.setAttribute("idGrupo",request.getParameter("idGrupo"));
	request.setAttribute("idFamilia",request.getParameter("idFamilia"));
	request.setAttribute("idSubFamilia",request.getParameter("idSubFamilia"));*/
%>
<jsp:forward page="<%=url.toString()%>"></jsp:forward>