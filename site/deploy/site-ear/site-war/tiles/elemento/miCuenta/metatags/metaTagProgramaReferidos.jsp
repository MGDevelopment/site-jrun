<%String opcionMenuReferido = (String)request.getParameter("opcionMenuReferido"); 
	//System.out.println("opcionMenuReferido= " + opcionMenuReferido);
	int op = new Integer(opcionMenuReferido).intValue();
%>

<%	if(op == 0){%>
		<title>Tematika.com: Programa de Referidos. Información y Reglas</title>
		<meta name="title" content="Tematika.com: Programa de Referidos. Información y Reglas">
		<meta name="description" content="Programa de Referidos.">
		<meta name="keywords" content="referidos, referido, beneficios, descuentos">
<%	} %>

<%	if(op == 1){%>
		<meta name="title" content="Referidos">
<%	} %>

<%	if(op == 2){%>
		<meta name="title" content="Referidos Confirmado">
<%	} %>

<%	if(op == 3) {%>
		<meta name="title" content="Mi Cuenta">	
<%	} %>

