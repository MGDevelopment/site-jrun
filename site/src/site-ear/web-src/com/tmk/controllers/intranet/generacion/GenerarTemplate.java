package com.tmk.controllers.intranet.generacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.util.calendar.CalendarDate;

import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.ArticuloAutor;
import com.tmk.bus.articulo.ArticuloAutorBiografia;
import com.tmk.bus.articulo.ArticuloCompilador;
import com.tmk.bus.articulo.Autor;
import com.tmk.bus.articulo.Compilador;
import com.tmk.bus.articulo.ContraTapa;
import com.tmk.bus.articulo.DescripcionPrincipal;
import com.tmk.bus.articulo.Disponibilidad;
import com.tmk.bus.articulo.Editor;
import com.tmk.bus.articulo.Formato;
import com.tmk.bus.articulo.IndiceDeContenido;
import com.tmk.bus.articulo.Solapa;
import com.tmk.bus.articulo.Tasa;
import com.tmk.bus.articulo.TemaMusical;
import com.tmk.bus.articulo.TipoArticulo;
import com.tmk.bus.categoria.Categoria;
import com.tmk.controllers.MainHelper;
import com.tmk.dbo.DBO;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.util.HTML.Template;

 public class GenerarTemplate extends HttpServlet {
	 private String id_articulo;

	 private String fecha;
	 private String tipoPromocion;
	 private String tipo;
	 private Template template;
	 private CamposABuscarDBO camposABuscar;
	 private CamposLeftJoinDBO camposLeftJoin;

	public void init() throws ServletException {
		super.init();
		camposLeftJoin = new CamposLeftJoinDBO();
		camposABuscar = new CamposABuscarDBO();
		setDefinirRelaciones(camposABuscar, camposLeftJoin);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*datos que obtengo del formulario*/
		id_articulo = request.getParameter("hid_articulo");
		fecha = request.getParameter("hfecha");
		tipoPromocion = request.getParameter("tipoPromocion");
		String error = null;
		Articulo articulo = null;
		Hashtable args = new Hashtable( );
		PrintWriter respuesta = response.getWriter();

		/*defino el tipo de template a usar dependiendo de la categoria 1=libros, 4=musica, 5=peliculas*/
		try{
			/*valido la fecha*/
			if(validarFecha(fecha)){
				error = setError(new String[]{"cuadroMensajeError","La fecha ingresada es incorrecta"});
				throw new Exception();
			}
			Connection conn = DBUtil.buildConnection();
			try{
				//busco el id o isbn del articulo lo meto dentro de un try-catch por si falla por q no existe
				try{

					articulo = new Articulo(new Integer(id_articulo));
					DBO.select(articulo, conn, camposABuscar, camposLeftJoin);
					articulo.filtrarAutores();
					//devuelve el tipo de producto [1-libros 2-musica 5-peliduclas]
					tipo = getTipo(String.valueOf(articulo.getCategoria_seccion()));
					args.put("filename", Contenido.getServletContext().getRealPath("/templates/generacion/"+tipo+tipoPromocion+".htm"));
					template = new Template(args);
					//cargo la template con los datos obtenidos, si se cargaron los datos*/
					cargarArticulo(articulo,template);
				}catch (Exception e) {
					error = setError(new String[]{"cuadroMensajeError","No se pudo generar la template, por favor reintente..."});
					throw e;
				}
			}
			catch(Exception e){
				if(error != null){//pincho por q no hay articulos con ese criterio
					throw e;
				}
			}
			finally{
				conn.close();
			}
		}catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
			if(error.length()==0){
				error = setError(new String[]{"cuadroMensajeError","Error de sistema contacte al administrado"});
			}
		}
		/*si hubo algun error devuelvo el mensaje de error*/
		if(error != null){
			response.setContentType("text/html;charset=ISO-8859-1");
			respuesta.write(error.toString());
		}else{
			response.setContentType("application/force-download");
			response.setHeader("Content-disposition", "attachment; filename="+articulo.getTitulo()+".html");
			respuesta.write(template.output().toString());
		}
	}


	public void cargarArticulo(Articulo articulo, Template t){
		boolean tieneResena = false;
		/*t.setParam("articulo",Convert.nombrePropio(articulo.getTitulo()));*/
		t.setParam("articulo",Convert.corregir(articulo.getTitulo(), true)+"&nbsp;");
		t.setParam("idarticulo",articulo.getId_articulo().intValue());
		t.setParam("fec_ven",Convert.toEsStringLargo(new Date(fecha)));
		t.setParam("imagen", articulo.getImagen());
		t.setParam("detalleArticulo",getDetalle(articulo));
		t.setParam("enPeso",Contenido.precioToString(articulo.getPrecio()));
		t.setParam("enDolar",Contenido.precioDollarToString(articulo.getPrecio()));
		t.setParam("enEuro",Contenido.precioEuroToString(articulo.getPrecio()));

		/*seteo de sinopsis*/
		StringBuffer sinopsis = new StringBuffer("");
		StringBuffer listaDeTemas = new StringBuffer("");
		String filaTemaMusica =  "<td width=\"16\" class=\"modulosmediolista\"><span class=\"Ftexto02\">";
		String fila2TemaMusica = "<td width=\"370\" class=\"modulosmediolista2\"><span class=\"Ftexto02\">";
		String cierreFilaTemaMusica = "</span></td>";
		if(articulo.getTemaMusical()!= null){
			tieneResena = true;
			for(int i=0;i< articulo.getTemaMusical().length; i++){
				listaDeTemas.append("<tr>");
				listaDeTemas.append(filaTemaMusica);
					listaDeTemas.append(""+(i+1));
				listaDeTemas.append(cierreFilaTemaMusica);
				listaDeTemas.append(fila2TemaMusica);
					listaDeTemas.append(articulo.getTemaMusical()[i].getNombre());
				listaDeTemas.append(cierreFilaTemaMusica);
				listaDeTemas.append("</tr>");
			}
			t.setParam("listaDeTemas",listaDeTemas.toString().replaceAll("Ð", "Ñ"));
			//t.setParam("sinopsisArticulo",listaDeTemas.toString());
		}else{
			if(articulo.getDescripcionPrincipal()!= null){
				tieneResena = true;
				for(int i = 0; i < articulo.getDescripcionPrincipal().length ; i++)
					if(articulo.getDescripcionPrincipal()[i].getTexto() != null)
						sinopsis.append(articulo.getDescripcionPrincipal()[i].getTexto());
				t.setParam("sinopsisArticulo","<b>Sinopsis</b><br>"+Convert.nombrePropio(sinopsis.toString()));
			}
		}
		if(tieneResena)
			t.setParam("resena", "true");
		/*cargo los nombres de los autores*/
		StringBuffer autores = new StringBuffer("");
		if(articulo.getAutor() != null){
			for(int i=0;i<articulo.getAutor().length;i++){
				if(articulo.getAutor()[i].getAutor().getDescripcion() != null) {
					autores.append(Convert.nombrePropio(articulo.getAutor()[i].getAutor().getDescripcion(),false)).append("-");
				}
			}
			t.setParam("autor",autores.toString().toUpperCase().substring(0,autores.length()-1));
			t.setParam("hayAutor","siHay");
		}

		/*seteo la/s biografias de los autores*/
		StringBuffer biografias = new StringBuffer("");
		if(articulo.getArticuloAutor()!= null ){
			/*si haymas de 1*/
			if(articulo.getArticuloAutor().length > 1 ){
				for (int i=0;i<articulo.getArticuloAutor().length;i++){
					if(articulo.getArticuloAutor()[i].getBiografia() != null){
						for(int j=0;j<articulo.getArticuloAutor()[i].getBiografia().length;j++)
							if(articulo.getArticuloAutor()[i].getBiografia()[j].getTexto() != null)
								biografias.append(Convert.capitalizar(articulo.getArticuloAutor()[i].getBiografia()[j].getTexto(),true)).append("&nbsp;");
					}
				}
			}else{
				if(articulo.getArticuloAutor()[0].getBiografia() != null){
					for(int j=0;j<articulo.getArticuloAutor()[0].getBiografia().length;j++)
						if(articulo.getArticuloAutor()[j].getBiografia()[j].getTexto() != null)
							biografias.append(Convert.nombrePropio(articulo.getArticuloAutor()[j].getBiografia()[j].getTexto(),true)).append("&nbsp;");
				}
			}
			if(biografias.length() > 0)
				t.setParam("biografia","<b>Biografia</b><br>"+biografias.toString());
		}

	}
	/*genera el detalle de los articulo, peliculas,musica, libros*/
	private String getDetalle(Articulo articulo) {
		Hashtable args = new Hashtable();
		Template detalle = null;
		try{
			args.put("filename", Contenido.getServletContext().getRealPath("/templates/generacion/detallesArticulo.htm"));
			detalle = new Template(args);
			Categoria categoria =  articulo.getCategoria();

			/*seleccionamos dependiendo de que tipo de articulo es*/
			switch (articulo.getCategoria_seccion().intValue()) {
			case 1:/*libros*/
				detalle.setParam("libros", "libros");
				detalle.setParam("isbn", articulo.getISBN());
				detalle.setParam("editorial", articulo.getEditor().getNombre());
				if(categoria.getSubCategoria()[0].getDescripcion() != null)
					detalle.setParam("clasificacion", Convert.corregir(categoria.getSubCategoria()[0].getDescripcion().toLowerCase(),true));
				detalle.setParam("paginas", articulo.getPaginas());
				detalle.setParam("formato", articulo.getFormato().getRv_meaning());
				if(null != articulo.getPeso() && articulo.getPeso().doubleValue() > 0 ){
					detalle.setParam("peso", Convert.toGramos( articulo.getPeso().doubleValue()));
				}
				detalle.setParam("medidas",articulo.getMedidas());
				break;
			case 4:/*musica*/
				detalle.setParam("musica", "musica");
				detalle.setParam("selloDiscografico", Convert.nombrePropio(articulo.getEditor().getNombre(),false));
				detalle.setParam("soporte", Convert.nombrePropio(categoria.getSubCategoria()[0].getDescripcion().toLowerCase(),false));
			break;
			case 5:/*pelidculas*/
				detalle.setParam("peliculas", "peliculas");
				detalle.setParam("productora", Convert.nombrePropio(articulo.getEditor().getNombre(),false));
				detalle.setParam("estreno", articulo.getTipoArticulo().getDescripcion());
				detalle.setParam("formato", articulo.getPeso());
				detalle.setParam("genero", Convert.nombrePropio(categoria.getSubCategoria()[0].getDescripcion().toLowerCase(),false));
				if(null != articulo.getPaginas())
					detalle.setParam("duracion", articulo.getPaginas() +" min.");
			break;
			}

		}catch (Exception e) {
			TmkLogger.error(e);
		}

		return detalle.output().toString();
	}

	private String getTipo(String tipo){
		switch(Integer.parseInt(tipo)){
		case 1: tipo= "libros-"; break;
		case 4: tipo= "cds-";	break;
		case 5: tipo= "peliculas-";	break;
	}
		return tipo;
	}
	/*arma la tabla para devolver si se genera un error*/
	private String setError(String [] error){
		try{
			Hashtable args = new Hashtable();
			args.put("filename", Contenido.getServletContext().getRealPath("/templates/generacion/errorTemplate.htm"));
			Template tempError = new Template(args);
			tempError.setParam("class", error[0]);
			tempError.setParam("error", error[1]);
			return tempError.output().toString().toString();
		}catch (Exception e) {
			return "Ocurrio Un Error, reintente...";
		}
	}
	private void setDefinirRelaciones(CamposABuscarDBO camposaBuscar, CamposLeftJoinDBO camposLeftJoin) {
		/*CAMPOS A BUSCAR*/
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".cod_ext_visual");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".descripcion");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".idioma");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".paginas");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".peso");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".precio_venta_vigente");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".auxnumber05");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".auxnumber06");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".auxnumber07");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".archivo_imagen");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".articuloAutor");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".role");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".autor");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_autor");
		camposaBuscar.agregarCampoABusqueda(Autor.getAlias() + ".id_autor");
		camposaBuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion");
		camposaBuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion2");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".biografia");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".id_autor");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".role");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".parte");
		camposaBuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".texto");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".disponibilidad");
		camposaBuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".descripcion");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tasa");
		camposaBuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_general");
		camposaBuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_adicional");
		camposaBuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_percep_video");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".descripcionPrincipal");
		camposaBuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".idioma");
		camposaBuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".parte");
		camposaBuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".texto");
		camposaBuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".tipo");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".editor");
		camposaBuscar.agregarCampoABusqueda(Editor.getAlias() + ".nombre");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".formato");
		camposaBuscar.agregarCampoABusqueda(Formato.getAlias() + ".rv_meaning");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tipoArticulo");
		camposaBuscar.agregarCampoABusqueda(TipoArticulo.getAlias() + ".descripcion");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".indiceDeContenido");
		camposaBuscar.agregarCampoABusqueda(IndiceDeContenido.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(IndiceDeContenido.getAlias() + ".tipo");
		camposaBuscar.agregarCampoABusqueda(IndiceDeContenido.getAlias() + ".idioma");
		camposaBuscar.agregarCampoABusqueda(IndiceDeContenido.getAlias() + ".texto");
		camposaBuscar.agregarCampoABusqueda(IndiceDeContenido.getAlias() + ".parte");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".contraTapa");
		camposaBuscar.agregarCampoABusqueda(ContraTapa.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(ContraTapa.getAlias() + ".tipo");
		camposaBuscar.agregarCampoABusqueda(ContraTapa.getAlias() + ".idioma");
		camposaBuscar.agregarCampoABusqueda(ContraTapa.getAlias() + ".texto");
		camposaBuscar.agregarCampoABusqueda(ContraTapa.getAlias() + ".parte");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".solapa");
		camposaBuscar.agregarCampoABusqueda(Solapa.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(Solapa.getAlias() + ".tipo");
		camposaBuscar.agregarCampoABusqueda(Solapa.getAlias() + ".idioma");
		camposaBuscar.agregarCampoABusqueda(Solapa.getAlias() + ".texto");
		camposaBuscar.agregarCampoABusqueda(Solapa.getAlias() + ".parte");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".temaMusical");
		camposaBuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".nro_tema");
		camposaBuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".nombre");
		camposaBuscar.agregarCampoABusqueda(Articulo.getAlias() + ".articuloCompilador");
		camposaBuscar.agregarCampoABusqueda(ArticuloCompilador.getAlias() + ".role");
		camposaBuscar.agregarCampoABusqueda(ArticuloCompilador.getAlias() + ".id_articulo");
		camposaBuscar.agregarCampoABusqueda(ArticuloCompilador.getAlias() + ".compilador");
		camposaBuscar.agregarCampoABusqueda(ArticuloCompilador.getAlias() + ".id_autor");
		camposaBuscar.agregarCampoABusqueda(Compilador.getAlias() + ".id_autor");
		camposaBuscar.agregarCampoABusqueda(Compilador.getAlias() + ".descripcion");

		/*CAMPOS LEFT JOIN*/
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".editor");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".tasa");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".articuloAutor");
		camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias() + ".autor");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".descripcionPrincipal");
		camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias() + ".autor");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".descripcionPrincipal");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".formato");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".tipoArticulo");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".indiceDeContenido");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".contraTapa");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".solapa");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".temaMusical");
		camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias() + ".articuloCompilador");
		camposLeftJoin.setCampoDBOLeftJoin(ArticuloCompilador.getAlias() + ".compilador");
		camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias() + ".biografia");


	}

	public boolean validarFecha(String fecha) {
		boolean error = false;
		try{
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false);
			formatoFecha.parse(fecha);
		}catch (ParseException e) {
			error = true;
		}
		return error;
	}


}