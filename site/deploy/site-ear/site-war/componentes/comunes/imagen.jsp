<%@ page import="java.io.File, java.awt.*,
                 com.tmk.setup.Contenido,
                 java.awt.image.BufferedImage,
                 javax.imageio.ImageIO" %>

<%
    int idArticuloParaTapa = articuloLocal.getID_ARTICULO().intValue();

	try {
        if(Contenido.tieneTapaChica(idArticuloParaTapa)) {
            String chica = Contenido.getTapa(idArticuloParaTapa, false);
            if (Contenido.tieneTapaGrande(idArticuloParaTapa)) {
                /*String grande = Contenido.getTapa(idArticuloParaTapa, true);
                String fileName = Contenido.getServletContext().getRealPath(grande);
				BufferedImage imagen = ImageIO.read(new File(fileName));
				int ancho = imagen.getWidth() + 50;
				int alto = imagen.getHeight() + 50;*/
                //int ancho = 200;
				//int alto = 200;
%>
			<a href="javascript:mostrarImagen();">
				<img src="<%= chica %>" width="<%= ANCHO_DEFAULT %>" height="<%= ALTO_DEFAULT %>" border="0">
			</a><br>
            <a href="javascript:mostrarImagen();">
            Ver imagen ampliada del producto
            </a>
            <%}else{%>
            <img src="<%= chica %>" width="<%= ANCHO_DEFAULT %>" height="<%= ALTO_DEFAULT %>" border="0">
            <%}
		} else if (Contenido.tieneTapaGrande(idArticuloParaTapa)) {
            String grande = Contenido.getTapa(idArticuloParaTapa, true);
            	/*String fileName = Contenido.getServletContext().getRealPath(grande);
				BufferedImage imagen = ImageIO.read(new File(fileName));
				int ancho = imagen.getWidth() + 50;
				int alto = imagen.getHeight() + 50;*/
                //int ancho = 200;
                //int alto = 200;
%>
			<a href="javascript:mostrarImagen();">
				<img src="<%= grande %>" width="<%= ANCHO_DEFAULT %>" height="<%= ALTO_DEFAULT %>" border="0">
			</a><br>
            <a href="javascript:mostrarImagen();">
            Ver imagen ampliada del producto
            </a>
<%
		} else {
			String sinImagen = Contenido.getTapa(idArticuloParaTapa, false);
%>
			<img src="<%= sinImagen %>" width="<%= ANCHO_DEFAULT %>" height="<%= ALTO_DEFAULT %>">

<%      }
	} catch (Exception e) {
		// No muestra nada si llega a fallar
		TmkLogger.debug("No se pudo cargar la imagen para el articulo " + idArticuloParaTapa);
	}
%>
