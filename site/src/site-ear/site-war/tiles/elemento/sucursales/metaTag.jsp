<%@page import="com.tmk.kernel.Convert"%>
<%
	String unidadNegocio = Convert.toString(request.getParameter("unegocio"), "ateneo");
	String nombreNegocio = null;
	String tipoNegocio = null;
	String nombreCorto = null;

	if(unidadNegocio.equals("ateneo")){
		 nombreNegocio = "Editorial El Ateneo";
		 tipoNegocio = "editorial";
		 nombreCorto = "el ateneo";
	}else{
		 nombreNegocio = "Librería Yenny";
		 tipoNegocio = "librería";
		 nombreCorto = "yenny";
	}
%>

<title><%=nombreNegocio%> - Tematika Sucursales - Grupo ILHSA</title>
<meta name="description" content="Tematika.com: sucursales. <%=nombreNegocio%>. Variedad de productos y precios para el mercado de habla hispana. Libros, discos, peliculas, agendas, pasatiempos." />
<meta name="keywords" content="<%=tipoNegocio%>, <%=nombreCorto%>, tematika, grupo ilhsa, venta, online, internet, comprar, envios, domicilio, todo el mundo, argentina" />

<meta name="distribution" content="Global" />
<meta name="copyright" content="Tematika.com" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta name="AUTHOR" content="Tematika.com" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="Resource-type" content="Document" />