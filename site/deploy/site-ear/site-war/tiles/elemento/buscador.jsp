<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.controllers.buscador.BuscadorHelper"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.setup.Contenido"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="optSeleccionada" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="texto" scope="request" ignore="true" classname="java.lang.String"/>
<%
	Hashtable<String, String> opcion = new Hashtable<String, String>(6);
	Vector datBuscador =  new Vector(5);
	//OPCIONES PARA INICIO
	if (idSeccion ==  Globals.SECCION_HOME || idSeccion>100) {	
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus1");
		opcion.put("txtOpt", "Todo el Sitio");
		opcion.put("idSeccion", ""+Globals.SECCION_HOME);
		opcion.put("seccionBusqueda", "En Tematika.com");
		opcion.put("idSeccionPropia", ""+Globals.SECCION_HOME);
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "=" + Globals.SECCION_HOME);
		datBuscador.add(opcion);		
		
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus2");
		opcion.put("txtOpt", "En Libros");
		opcion.put("idSeccion", ""+Globals.SECCION_HOME);
		opcion.put("seccionBusqueda", "En Libros");
		opcion.put("idSeccionPropia", ""+Globals.SECCION_LIBRO);
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "=" + Globals.SECCION_LIBRO);

		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus3");
		opcion.put("txtOpt", "En Musica");
		opcion.put("idSeccion", ""+Globals.SECCION_HOME);
		opcion.put("seccionBusqueda", "En Musica");
		opcion.put("idSeccionPropia", ""+Globals.SECCION_MUSICA);
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="+ Globals.SECCION_MUSICA);
		
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus4");
		opcion.put("txtOpt", "En Peliculas");
		opcion.put("idSeccion", ""+Globals.SECCION_HOME);
		opcion.put("seccionBusqueda", "En Peliculas");
		opcion.put("idSeccionPropia", ""+Globals.SECCION_PELICULA);
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "=" + Globals.SECCION_PELICULA);

		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus5");
		opcion.put("txtOpt", "En Pasatiempos");
		opcion.put("idSeccion", ""+Globals.SECCION_HOME);
		opcion.put("seccionBusqueda", "En Pasatiempos");
		opcion.put("idSeccionPropia", ""+Globals.SECCION_JUGUETES);
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "=" + Globals.SECCION_JUGUETES);
		datBuscador.add(opcion);		
	}

	if (idSeccion ==  Globals.SECCION_LIBRO) {
		opcion.put("idOpt", "optBus1");
		opcion.put("idSeccion", ""+Globals.SECCION_LIBRO);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_LIBRO);
		opcion.put("seccionBusqueda", "En Libros");
		opcion.put("txtOpt", "Título");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_TITULO);

		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus2");
		opcion.put("idSeccion", ""+Globals.SECCION_LIBRO);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_LIBRO);
		opcion.put("seccionBusqueda", "En Libros");
		opcion.put("txtOpt", "Autor");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_AUTOR);

		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus3");
		opcion.put("idSeccion", ""+Globals.SECCION_LIBRO);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_LIBRO);
		opcion.put("seccionBusqueda", "En Libros");
		opcion.put("txtOpt", "Editorial");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_EDITORIAL);

		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus4");
		opcion.put("idSeccion", ""+Globals.SECCION_LIBRO);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_LIBRO);
		opcion.put("seccionBusqueda", "En Libros");
		opcion.put("txtOpt", "ISBN");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_ISBN);

		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus5");
		opcion.put("idSeccion", ""+Globals.SECCION_LIBRO);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_LIBRO);
		opcion.put("seccionBusqueda", "En Libros");
		opcion.put("txtOpt", "Palabra Clave");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_PALABRAS_CLAVES);

		datBuscador.add(opcion);
	}

	if (idSeccion ==  Globals.SECCION_JUGUETES) {
		opcion.put("idOpt", "optBus1");
		opcion.put("idSeccion", ""+Globals.SECCION_JUGUETES);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_JUGUETES);
		opcion.put("seccionBusqueda", "En Pasatiempos");
		opcion.put("txtOpt", "Título");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_TITULO);
		//OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus2");
		opcion.put("idSeccion", ""+Globals.SECCION_JUGUETES);
		opcion.put("idSeccionPropia",""+Globals.SECCION_JUGUETES);
		opcion.put("seccionBusqueda", "En Pasatiempos");
		opcion.put("txtOpt", "Autor");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_AUTOR);
		//OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus3");
		opcion.put("idSeccion", ""+Globals.SECCION_JUGUETES);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_JUGUETES);
		opcion.put("seccionBusqueda", "En Pasatiempos");
		opcion.put("txtOpt", "Editorial");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_EDITORIAL);
		//OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus4");
		opcion.put("idSeccion", ""+Globals.SECCION_JUGUETES);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_JUGUETES);
		opcion.put("seccionBusqueda", "En Pasatiempos");
		opcion.put("txtOpt", "ISBN");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_ISBN);
		//OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus5");
		opcion.put("idSeccion", ""+Globals.SECCION_JUGUETES);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_JUGUETES);
		opcion.put("seccionBusqueda", "En Pasatiempos");
		opcion.put("txtOpt", "Palabra Clave");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_PALABRAS_CLAVES);
		//OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		datBuscador.add(opcion);
	}

	if (idSeccion ==  Globals.SECCION_MUSICA) {
//		OPCIONES PARA MUSICA
		opcion.put("idOpt", "optBus1");
		opcion.put("idSeccion", ""+Globals.SECCION_MUSICA);
		opcion.put("idSeccionPropia",""+ Globals.SECCION_MUSICA);
		opcion.put("seccionBusqueda", "En Musica");
		opcion.put("txtOpt", "Título");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_TITULO);
		//OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus2");
		opcion.put("idSeccion", ""+Globals.SECCION_MUSICA);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_MUSICA);
		opcion.put("seccionBusqueda", "En Musica");
		opcion.put("txtOpt", "Grupo/Intérprete");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_AUTOR);
		//OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus3");
		opcion.put("idSeccion", ""+Globals.SECCION_MUSICA);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_MUSICA);
		opcion.put("seccionBusqueda", "En Musica");
		opcion.put("txtOpt", "Sello Discográfico");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_EDITORIAL);
		//OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus4");
		opcion.put("idSeccion", ""+Globals.SECCION_MUSICA);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_MUSICA);
		opcion.put("seccionBusqueda", "En Musica");
		opcion.put("txtOpt", "Tema Musical");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_TEMA_MUSICAL);
		//OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus5");
		opcion.put("idSeccion", ""+Globals.SECCION_MUSICA);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_MUSICA);
		opcion.put("seccionBusqueda", "En Musica");
		opcion.put("txtOpt", "Palabra Clave");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_PALABRAS_CLAVES);
		//OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		datBuscador.add(opcion);
	}
	if (idSeccion == Globals.SECCION_PELICULA) {
//		OPCIONES PARA PELICULAS
		opcion.put("idOpt", "optBus1");
		opcion.put("idSeccion", ""+Globals.SECCION_PELICULA);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_PELICULA);
		opcion.put("seccionBusqueda", "En Peliculas");
		opcion.put("txtOpt", "Título");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_TITULO);
		//OPCION_BUSQUEDA[Globals.SECCION_PELICULA].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus2");
		opcion.put("idSeccion", ""+Globals.SECCION_PELICULA);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_PELICULA);
		opcion.put("seccionBusqueda", "En Peliculas");
		opcion.put("txtOpt", "Director/Actor");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_AUTOR);
		//OPCION_BUSQUEDA[Globals.SECCION_PELICULA].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus3");
		opcion.put("idSeccion", ""+Globals.SECCION_PELICULA);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_PELICULA);
		opcion.put("seccionBusqueda", "En Peliculas");
		opcion.put("txtOpt", "Productora");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_EDITORIAL);
		//OPCION_BUSQUEDA[Globals.SECCION_PELICULA].add(opcion);
		datBuscador.add(opcion);
		opcion = new Hashtable<String, String>(6);
		opcion.put("idOpt", "optBus5");
		opcion.put("idSeccion", ""+Globals.SECCION_PELICULA);
		opcion.put("idSeccionPropia", ""+Globals.SECCION_PELICULA);
		opcion.put("seccionBusqueda", "En Peliculas");
		opcion.put("txtOpt", "Palabra Clave");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA + "&" + BuscadorHelper.CLAVE_DE_BUSQUEDA + "=" + BuscadorHelper.POR_PALABRAS_CLAVES);
		//OPCION_BUSQUEDA[Globals.SECCION_PELICULA].add(opcion);
		datBuscador.add(opcion);
	}
	
	optSeleccionada = (request.getParameter("optSeleccionada")==null)?(String)((Hashtable)datBuscador.get(0)).get("txtOpt"):request.getParameter("optSeleccionada");
	texto = request.getParameter("texto");

	Hashtable args = new Hashtable();
	args.put("filename", Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH + "/templates/buscador.htm"));
	Template t = null;
	try {
		t = new Template (args);
		t.setParam("texto", texto);
		t.setParam("idSeccion", idSeccion);
		t.setParam("id_Seccion", idSeccion);

		boolean optEncontrada = false;
		for (int i=0; i<datBuscador.size(); i++) {
			if (((String)((Hashtable)datBuscador.get(i)).get("txtOpt")).equals(optSeleccionada)) {
				t.setParam("seccionBusqueda",(String)((Hashtable)datBuscador.get(i)).get("seccionBusqueda"));
				t.setParam("idSeccionH", (String)((Hashtable)datBuscador.get(i)).get("idSeccion"));
				t.setParam("idSeccionPropia",(String)((Hashtable)datBuscador.get(i)).get("idSeccionPropia"));
				
				optEncontrada = true;
				break;
			}
		}
		if (!optEncontrada) {
			optSeleccionada = (String)((Hashtable)datBuscador.get(0)).get("txtOpt");
			t.setParam("seccionBusqueda",(String)((Hashtable)datBuscador.get(0)).get("seccionBusqueda"));
			t.setParam("idSeccionH",(String)((Hashtable)datBuscador.get(0)).get("idSeccion"));
			t.setParam("idSeccionPropia",(String)((Hashtable)datBuscador.get(0)).get("idSeccionPropia"));
		}
		t.setParam("optSeleccionada", optSeleccionada);
		t.setParam("optsBusqueda", datBuscador);
				
		//Boolean busquedaNueva = (Boolean)session.getAttribute("busquedaNueva");
		
		/*if(busquedaNueva != null && busquedaNueva.booleanValue())
			t.setParam("busquedaNueva", "true");
		else
			t.setParam("busquedaNueva", "false");
		*/
		//t.setParam("busquedaNueva", "true");
		out.print(t.output());
	} catch (Exception e) {
		TmkLogger.debug(e.toString());
	}
%>