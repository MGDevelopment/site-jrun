<%@page import="com.tmk.util.HTML.Template"%>
<%
	//este archivo es capaz de recibir una Template.
	//un String resultado de hace template.output();
	//una cadena que represnta una url que debe incluirse
	
	Template template = (Template)request.getAttribute("template"); 
	if(template != null) {
		out.println(template.output());
	}else{
		//si se guardo el string de la template directamente en el request
		String stringTempalte = (String)request.getAttribute("StringTemplate");
		if(stringTempalte!=null) {
			out.println(stringTempalte);
		}else {
			//si se incluyo un path a ser incluido
			String pathFileAIncluir = (String)request.getAttribute("pathFileAncluir");
			if(pathFileAIncluir ==null){
				pathFileAIncluir = (String)request.getAttribute("page");
			}
			//para los links provenientes de la cartelera
			if(pathFileAIncluir ==null){
				pathFileAIncluir = (String)request.getParameter("URL_MSG");
			}
			pageContext.include(pathFileAIncluir);
		}
	}
%>
<%--<jsp:include page="<%=pathFileAIncluir%>"></jsp:include>--%>