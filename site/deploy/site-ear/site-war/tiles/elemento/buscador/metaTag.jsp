<%@page import="com.tmk.controllers.buscador.BuscadorHelper"%>
<%@page import="com.tmk.kernel.Convert"%>

<%
	String textoABuscar = request.getParameter(BuscadorHelper.TEXTO);


	if(textoABuscar == null ){
		String autor = Convert.toString(request.getParameter(BuscadorHelper.POR_AUTOR), null);
		if (autor != null) {
			autor = (autor != null)? autor.replaceAll("\\'", " "): null;
			textoABuscar = autor;
		}
		String titulo = Convert.toString(request.getParameter(BuscadorHelper.POR_TITULO), null);
		if (titulo != null) {
			titulo = (titulo != null)? titulo.replaceAll("\\'", " "): null;
			textoABuscar = titulo;
		}

		String editorial = Convert.toString(request.getParameter(BuscadorHelper.POR_EDITORIAL), null);
		if (editorial != null) {
			editorial = (editorial != null)? editorial.replaceAll("\\'", " "): null;
			textoABuscar = editorial;
		}

		String palabrasClaves = Convert.toString(request.getParameter(BuscadorHelper.POR_PALABRAS_CLAVES), null);
		if (palabrasClaves != null) {
			palabrasClaves =  palabrasClaves.replaceAll("\\'", " ");
			textoABuscar = palabrasClaves;
		}

		String isbn = Convert.toString(request.getParameter(BuscadorHelper.POR_ISBN), null);
		if (isbn != null) {
			isbn = (isbn != null)? isbn.replaceAll("\\'", " "): null;
			textoABuscar = isbn;
		}
	}
%>

<title><%=textoABuscar%> - Libros, películas, música</title>
<meta name="title" content="<%=textoABuscar%> - Libros, películas, música" />
<meta http-equiv="title" content="Tematika.com: <%=textoABuscar%> - Venta online - Libros, películas, música" />
<meta name="description" content="Tematika.com: <%=textoABuscar%> - Venta online de libros, música, películas, pasatiempos. Portal de compra por internet. Envíos a domicilio a todo el mundo. Ofertas y promociones. Gran variedad y disponibilidad." />
<meta http-equiv="DC.Description" content="Tematika.com: <%=textoABuscar%> - Venta online de libros, música, películas, pasatiempos. Portal de compra por internet. Envíos a domicilio a todo el mundo. Ofertas y promociones. Gran variedad y disponibilidad." />
<meta name="keywords" content="<%=textoABuscar%>, libros, peliculas, música, pasatiempos, venta, online, internet, comprar, envios, domicilio, todo el mundo, argentina, tematika" />
<meta http-equiv="DC.Keywords" content="<%=textoABuscar%>, libros, peliculas, música, pasatiempos, venta, online, internet, comprar, envios, domicilio, todo el mundo, argentina, tematika" />
<meta name="distribution" content="Global" />
<meta name="copyright" content="Tematika.com" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta name="AUTHOR" content="Tematika.com" />
<meta name="Resource-type" content="Document" />
<%-- agregado para los modales de listas --%>
<link href="/estilos/listasTmk.css" rel="stylesheet" type="text/css" /> 
