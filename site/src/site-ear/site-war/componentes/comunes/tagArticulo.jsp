<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 java.util.Vector,
                 com.tmk.articulo.ArticuloLocal,
                 com.tmk.setup.Contenido,
                 java.util.Calendar"%>

 <%
     Integer idArticulo = new Integer(Convert.toNumber(request.getParameter("idArticulo"), Globals.ARTICULO_DEFAULT));
     ArticuloLocal articuloLocal = Contenido.getArticulo(idArticulo.intValue());
     int categoriaArticulo = articuloLocal.getCATEGORIA_SECCION().intValue();

            String titulo = Convert.corregir(articuloLocal.getTITULO(), true);
		    String autor = "";
			Vector vec = new Vector();

            if(categoriaArticulo==Globals.SECCION_PELICULA){
                vec = articuloLocal.getDIRECTORES();
            }else{
                vec = articuloLocal.getAUTORES();
            }

			StringBuffer autorBuf = new StringBuffer("");
			for (int i=0; i < vec.size(); i++) {
				autorBuf.append(Convert.nombrePropio((String)vec.get(i), true)).append(" - ");
			}

            if (autorBuf.length() > 3) {
	            autor = autorBuf.substring(0, autorBuf.length()-3);
            }

            String nombreProducto = Convert.plural(Globals.productoSeccion(articuloLocal.getCATEGORIA_SECCION().intValue()));
        %>
		<meta name="description" content="<%=Globals.NOMBRE_DEL_SITIO%> - <%=nombreProducto%> : <%=titulo%> de <%=autor%> - <%=articuloLocal.getCategorizacion()%> - Venta de libros por internet. Envíos a domicilio a todo el mundo.">
		<meta name="keywords" content="<%=titulo%> <%=autor%>">
		<meta name="Revisit" content="15 days">
		<meta name="distribution" content="Global">
		<meta name="copyright" content="<%=Globals.NOMBRE_DEL_SITIO%>">
		<meta name="revisit-after" content="30 days">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
		<meta name="DC.Language" scheme="RFC1766" content="Spanish">
		<meta name="AUTHOR" content="Tematika.com">
		<meta name="Author Metatags" content="NetOne">
		<!-- meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"-->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="Resource-type" content="Document">

		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		 <link href="/estilos/seccion_<%=Globals.seccion(articuloLocal.getCATEGORIA_SECCION().intValue())%>.css" rel="stylesheet" type="text/css">


        <%=Globals.title(titulo + " - " + autor)%>