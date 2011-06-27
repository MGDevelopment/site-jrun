<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.bus.articulo.ArticuloManager,
				 com.tmk.bus.articulo.ArticuloClass"%>
<%
String idArticulo = request.getParameter("idArticulo");
ArticuloClass articulo = ArticuloManager.getArticulosParaUltimosVisitados(idArticulo)[0];

String seccion = Convert.capitalizar(Convert.toString(Globals.seccion(articulo.getIdSeccion())), true);
String titulo = Convert.corregir(articulo.getTitulo(),true);
String autor = Convert.capitalizar(articulo.getAtributoPrincipal(),true);
String textoSeccion = Convert.capitalizar(Convert.toString(request.getParameter("textoSeccion")),true);
String formato="";
if(articulo.getIdSeccion() == Globals.SECCION_LIBRO){	 formato = "Libro";
}else if(articulo.getIdSeccion() == Globals.SECCION_MUSICA){ formato = "Disco";
}else if(articulo.getIdSeccion() == Globals.SECCION_PELICULA){ formato = "Pelicula";
}%>
<%if (textoSeccion.equals("Notas De Prensa")){ %>
<title><%=titulo%> - <%=textoSeccion%> - Notas relacionadas con <%=titulo%> de <%=autor%></title>
<meta name="title" content="<%=titulo%> - <%=textoSeccion%> - Notas relacionadas con <%=titulo%> de <%=autor%>"/>
<meta http-equiv="title" content="<%=titulo%> - <%=textoSeccion%> - Notas relacionadas con <%=titulo%> de <%=autor%>"/>
<meta name="description" content="Tematika.com: <%=textoSeccion%>. Notas relacionadas con <%=titulo%> de <%=autor%>."/>
<meta http-equiv="DC.Description" content="Tematika.com: <%=textoSeccion%>. Notas relacionadas con <%=titulo%> de <%=autor%>."/>
<meta name="keywords" content="<%=titulo.toLowerCase()%>, <%=autor.toLowerCase()%>, <%=textoSeccion.toLowerCase()%>, venta, online, internet, comprar, argentina, tematika" />
<meta http-equiv="DC.Keywords" content="<%=titulo.toLowerCase()%>, <%=autor.toLowerCase()%>, <%=textoSeccion.toLowerCase()%>, venta, online, internet, comprar, argentina, tematika" />
<%}else if (textoSeccion.equals("Entrevista")){ %>	<title><%=autor%> - Nota de prensa - Entrevista a <%=autor%></title>
<meta name="title" content="<%=autor%> - Nota de prensa - Entrevista a <%=autor%>"/>
<meta http-equiv="title" content="<%=autor%> - Nota de prensa - Entrevista a <%=autor%>"/>
<meta name="description" content="Tematika.com: Notas de prensa. Entrevista a <%=autor%>. Información sobre su vida, su obra." />
<meta http-equiv="DC.Description" content="Tematika.com: Notas de prensa. Entrevista a <%=autor%>. Información sobre su vida, su obra." />
<meta name="keywords" content="<%=autor.toLowerCase()%>, entrevistas, notas de prensa, venta, online, internet, comprar, argentina, tematika" />
<meta http-equiv="DC.Keywords" content="<%=autor.toLowerCase()%>, entrevistas, notas de prensa, venta, online, internet, comprar, argentina, tematika" /><%}else if(textoSeccion.equals("Biografia")){%>
<title><%=autor%> - <%=textoSeccion%> - Información de <%=autor%></title>
<meta name="title" content="<%=autor%> - <%=textoSeccion%> - Información de <%=autor%>"/>
<meta http-equiv="title" content="<%=autor%> - <%=textoSeccion%> - Información de a <%=autor%>" />
<meta name="description" content="Tematika.com: <%=textoSeccion%> de <%=autor%>. Información sobre su vida, su obra." />
<meta http-equiv="DC.Description" content="Tematika.com: <%=textoSeccion%> de <%=autor%>. Información sobre su vida, su obra." />
<meta name="keywords" content="<%=autor.toLowerCase()%>, biografia, vida, obra, informacion, venta, online, internet, comprar, argentina, tematika" />
<meta http-equiv="DC.Keywords" content="<%=autor.toLowerCase()%>, biografia, vida, obra, informacion, venta, online, internet, comprar, argentina, tematika" /><% }else{ %>
<title><%=titulo%><%=("".equals(autor))?"":" - " + autor %><%=("".equals(textoSeccion))?"":" - " + textoSeccion%> - <%=seccion%></title>
<meta name="title" content="<%=titulo%> - <%=autor%> - <%=textoSeccion%> - <%=seccion%>"/>
<meta http-equiv="title" content="<%=titulo%> - <%=autor%> - <%=textoSeccion%> - <%=seccion%>"/>
<meta name="description" content="Tematika.com: <%=seccion%>. <%=(articulo.getIdSeccion() == Globals.SECCION_LIBRO && !"".equals(textoSeccion))?textoSeccion + " del libro" : "" %> <%=(articulo.getIdSeccion() != Globals.SECCION_LIBRO)? Convert.capitalizar(formato,true):""%> <%=titulo%> de <%=autor%>. Portal de compra por internet. Envíos a domicilio a todo el mundo." />
<meta http-equiv="DC.Description" content="Tematika.com: <%=seccion%>. <%=(articulo.getIdSeccion() == Globals.SECCION_LIBRO && !"".equals(textoSeccion))?textoSeccion + " del libro" : "" %> <%=(articulo.getIdSeccion() != Globals.SECCION_LIBRO)? Convert.capitalizar(formato,true):""%> <%=titulo%> de <%=autor%>. Portal de compra por internet. Envíos a domicilio a todo el mundo." />
<meta name="keywords" content="<%=titulo.toLowerCase()%>, <%=autor.toLowerCase()%>, <%=("".equals(textoSeccion))?"":textoSeccion.toLowerCase() + ", "%><%=seccion.toLowerCase()%>,<%=(articulo.getIdSeccion() == Globals.SECCION_JUGUETES)?" juguetes, juegos de mesa, regalería, merchandising, reproducciones,":(articulo.getIdSeccion() == Globals.SECCION_MUSICA)?" discos, cd,":""%> venta, online, internet, comprar, envios, domicilio, todo el mundo, argentina, tematika" />
<meta http-equiv="DC.Keywords" content="<%=titulo.toLowerCase()%>, <%=autor.toLowerCase()%>, <%=("".equals(textoSeccion))?"":textoSeccion.toLowerCase() + ", "%><%=seccion.toLowerCase()%>,<%=(articulo.getIdSeccion() == Globals.SECCION_JUGUETES)?" juguetes, juegos de mesa, regalería, merchandising, reproducciones,":(articulo.getIdSeccion() == Globals.SECCION_MUSICA)?" discos, cd,":""%> venta, online, internet, comprar, envios, domicilio, todo el mundo, argentina, tematika" /><%}%><meta name="distribution" content="Global" />
<meta name="copyright" content="Tematika.com" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta name="AUTHOR" content="Tematika.com" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="Resource-type" content="Document" />