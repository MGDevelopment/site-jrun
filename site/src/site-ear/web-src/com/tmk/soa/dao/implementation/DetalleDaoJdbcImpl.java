package com.tmk.soa.dao.implementation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.ArticuloAutor;
import com.tmk.bus.articulo.ArticuloAutorBiografia;
import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.categoria.Categoria;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.IdiomaDAO;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.soa.dao.interfaces.DetalleDAO;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ArticuloServiceUtil;
import com.tmk.util.HTML.Template;

public class DetalleDaoJdbcImpl implements DetalleDAO {
	
	/**
	 *@see devuelve  un objeto Template, seteado con todos los datos.
	 * El seteo lo hace ArticuloView.setListaArticulo(articulo, tmpDetalle);
	 */		
	public String getDatosDetalle(Articulo articulo,String path) throws Exception{	
		Template tmpDetalle = null;
		try {
			tmpDetalle = (Template)ServiceLocator.getTemplateService().getTemplate(path);
			this.setListaArticulo(articulo, tmpDetalle);
			return tmpDetalle.output();
		}catch (Exception e) {
			//TmkLogger.error("DetalleDaoJdbcImpl->getDatosDetalle->" + e);
			return "";
		}		
	}
	
	@SuppressWarnings("unchecked")
	public void setListaArticulo(Articulo articulo,Template tmpListaArticulo) {
		try {
			
			List<String> textoSEO=new ArrayList<String>();
			
			String nombreSeccion=Convert.capitalizar(Globals.seccion(articulo.getCategoria_seccion()), true);
			//int i=0;
			//En este metodo no se tiene en cuanta los comentarios por que se cargan con ajax.
			articulo.setUrlDetalle();
			//hasDetalles.put("indice", i++);//ESTO SE USA PARA SER USADO EL RESALTADO (indica que sector del del html es tenido en cuenta por el script de resaltado)
			tmpListaArticulo.setParam("linkSeccion", nombreSeccion.toLowerCase());
			tmpListaArticulo.setParam("urlDetalle", articulo.getUrlDetalle());
			tmpListaArticulo.setParam("urlImagen", articulo.getImagen());
			//tmpListaArticulo.setParam("pathImagen", articulo.getUrlImagen());si quieren link a la imagen
			tmpListaArticulo.setParam("pathImgGde", articulo.getImagenGrande());
			tmpListaArticulo.setParam("tieneImagenGrande", ((articulo.getImagenGrande() != null) && (!"".equals(articulo.getImagenGrande()))) ? "true" : "");
			
			String titulo=Convert.corregir(articulo.getTitulo(), true);
			textoSEO.add(titulo);
			tmpListaArticulo.setParam("titulo", titulo);
			tmpListaArticulo.setParam("isbn", articulo.getISBN());
			tmpListaArticulo.setParam("disponibilidad", articulo.getDisponibilidad().getDescripcion());
			tmpListaArticulo.setParam("idArticulo", articulo.getId_articulo());
			tmpListaArticulo.setParam("idSeccion", articulo.getCategoria_seccion());
			tmpListaArticulo.setParam("altImagen", articulo.getCls_altImagen());
			
			String titleImagen=titulo +" - ";
			String contenidoSEO=titulo + ", ";
			
			if(articulo.getAutor()!=null){
				for(int i=0; i<articulo.getAutor().length; i++){
					ArticuloAutor autor=articulo.getAutor()[i];
					String nombreAutor=Convert.nombrePropio(autor.getAutor().getNombre(articulo.getCategoria_seccion()), false);
					textoSEO.add(nombreAutor);
					titleImagen+=nombreAutor;
					contenidoSEO+=nombreAutor+", ";
					if(i>0)
						titleImagen+="-";
				}
				titleImagen+=" - ";
			}
			titleImagen+=nombreSeccion;		
			contenidoSEO+=nombreSeccion;
			tmpListaArticulo.setParam("titleImagen", titleImagen);
			tmpListaArticulo.setParam("contenidoSEO", contenidoSEO);
			
			/*if(articulo.getCategoria_seccion()==1) {
				tmpListaArticulo.setParam("genero", Convert.capitalizar(articulo.getGeneroSecuencial(), true));				
			}else{
				tmpListaArticulo.setParam("genero", Convert.capitalizar(articulo.getGenero().getDescripcion(), true));
			}*/			
			if(articulo.getCategoria_seccion() == Globals.SECCION_PELICULA) {
				tmpListaArticulo.setParam("tipoArticulo", Convert.capitalizar(articulo.getTipoArticulo().getDescripcion(), false));
			}else{
				tmpListaArticulo.setParam("formato", articulo.getFormato()!=null?articulo.getFormato().getRv_meaning():"");
			}
			
			tmpListaArticulo.setParam("tieneFormato",articulo.getFormato()!=null?"true":"");
			tmpListaArticulo.setParam("fechaPublicacion", Convert.toStringFromDDMMYYYY(articulo.getFechaAlta()));
			tmpListaArticulo.setParam("idioma", IdiomaDAO.buscaIdioma(articulo.getIdioma()).getNombre());
			tmpListaArticulo.setParam("precio", ""+articulo.getPrecio());
			
			//editor
			tmpListaArticulo.setParam("textoEditorial",ArticuloServiceUtil.getDescripcionXSeccion(articulo.getCategoria_seccion()));
			articulo.setUrlBusquedaEditor();
			tmpListaArticulo.setParam("urlEditorial", articulo.getEditor().getCls_urlBusqueda());
			tmpListaArticulo.setParam("editorial", Convert.capitalizar(articulo.getEditor().getNombre(), true).replaceAll("\\[Mus]", ""));
			if(articulo.getPaginas() != null ){
				tmpListaArticulo.setParam("paginas", articulo.getPaginas());
			}
			tmpListaArticulo.setParam("tienePagina", articulo.getPaginas() != null);
			tmpListaArticulo.setParam("textoDuracion", articulo.getCategoria_seccion().intValue()==Globals.SECCION_PELICULA?"Min.":"");
			tmpListaArticulo.setParam("textoPagina", ArticuloServiceUtil.getPaginaXSeccion(articulo.getCategoria_seccion()));
			
			tmpListaArticulo.setParam("altDatosPrincipales", nombreSeccion +": Datos Principales de "+Convert.corregir(articulo.getTitulo(), true));
			tmpListaArticulo.setParam("altComentarios", nombreSeccion +": Comentarios de "+Convert.corregir(articulo.getTitulo(), true));
			
			
			//NOTA DE PRENSA,PRIMER CAPITULO	
			boolean tienePrimerCapitulo= ArticuloManager.tienePrimerCapitulo(articulo.getId_articulo(), Contenido.getServletContext());
			tmpListaArticulo.setParam("tienePrimerCapitulo",tienePrimerCapitulo ? "true" : "");			
			if(tienePrimerCapitulo) {
				String primerCapitulo = tagBSeo(ArticuloManager.getPrimerCapitulo(articulo.getId_articulo(),Contenido.getServletContext()), textoSEO);
				boolean tieneMasDe1000 = primerCapitulo.length() > 1000;
				if(tieneMasDe1000) {
					tmpListaArticulo.setParam("primerCapitulo", primerCapitulo.substring(0, 1000));
				}else{
					tmpListaArticulo.setParam("primerCapitulo", primerCapitulo);
				}
				tmpListaArticulo.setParam("mostrarBotonVerMasPrimerCapitulo", tieneMasDe1000? "true" : "");
			}			
			//FIN NOTAS
			//ENTREVISTAS			
			boolean tieneEntrevista= ArticuloManager.tieneEntrevista(articulo.getId_articulo(), Contenido.getServletContext());
			tmpListaArticulo.setParam("tieneEntrevista",tieneEntrevista? "true" : "");			
			if(tieneEntrevista) {
				String entrevista = tagBSeo(ArticuloManager.getEntrevista(articulo.getId_articulo(),Contenido.getServletContext()), textoSEO);
				boolean tieneMasDe1000 = entrevista.length() > 1000;
				if(tieneMasDe1000) {
					tmpListaArticulo.setParam("entrevista", entrevista.substring(0, 1000) +"...");
				}else{
					tmpListaArticulo.setParam("entrevista", entrevista);
				}
				tmpListaArticulo.setParam("mostrarBotonVerMasEntrevista", tieneMasDe1000? "true" : "");
			}			
			
			// cargo la/s sinopsis si la tiene,solapa, y contratapa, indice de contenido
			StringBuffer indiceDeContenidos = new StringBuffer("");
			if (articulo.getDescripcionPrincipal() != null || articulo.getDescripcion()!=null || articulo.getTemaMusical()!=null) {
				StringBuffer strSinopsis = new StringBuffer("");
				StringBuffer solapa = new StringBuffer("");
				StringBuffer contratapa = new StringBuffer("");
				
				if(articulo.getTemaMusical()!=null) {
					//si tiene tema musical
					if(articulo.getTemaMusical()!=null) {
							tmpListaArticulo.setParam("textoSinopsis", nombreSeccion +": Lista De Temas de <b>"+Convert.corregir(articulo.getTitulo(), true)+"</b>"); 
							if(articulo.getTemaMusical()!=null) {
								for(int i=0;i<articulo.getTemaMusical().length;i++) {
									strSinopsis.append("<b>").append(articulo.getTemaMusical()[i].getNroTema());
									strSinopsis.append("</b>").append("|");
									strSinopsis.append(articulo.getTemaMusical()[i].getNombre());
									strSinopsis.append("<br>");		
								}
							}							
						}					
				} else {
					boolean tieneDescripcionPPal = articulo.getDescripcionPrincipal() != null;					
					if (tieneDescripcionPPal) {//sonpsis
						for(int j=0;j< articulo.getDescripcionPrincipal().length; j++) {
							if(articulo.getDescripcionPrincipal()[j].getTipo().equals("01"))  {
								if(articulo.getCategoria_seccion()==Globals.SECCION_MUSICA){
									tmpListaArticulo.setParam("textoSinopsis", nombreSeccion+": Lista De Temas de <b>"+Convert.corregir(articulo.getTitulo(), true)+"</b>"); 
									String[]lista = articulo.getDescripcionPrincipal()[j].getTexto().split("\n");
									for(int i=1;i<lista.length;i++){
										strSinopsis.append("<b>").append(i).append("</b>").append("|");
										strSinopsis.append(lista[i]);
										strSinopsis.append("<br>");
									}
								}else{
									tmpListaArticulo.setParam("textoSinopsis", nombreSeccion+": Sinopsis de <b>"+Convert.corregir(articulo.getTitulo(), true)+"</b>");
									strSinopsis.append(articulo.getDescripcionPrincipal()[j].getTexto());
								}
							}//solapa
							else if (articulo.getDescripcionPrincipal()[j].getTipo().equals("17")) {
								tmpListaArticulo.setParam("textoSolapa", "Solapa");
								solapa.append(articulo.getDescripcionPrincipal()[j].getTexto());
							//indice de conenido	
							}else if (articulo.getDescripcionPrincipal()[j].getTipo().equals("04")) {
								tmpListaArticulo.setParam("textoIndiceDeContenido", "Indice De Contenido");
								indiceDeContenidos.append(articulo.getDescripcionPrincipal()[j].getTexto());
							}
							else {//conratapa
								tmpListaArticulo.setParam("textoContratapa", "Contratapa");
								contratapa.append(articulo.getDescripcionPrincipal()[j].getTexto());
							}
						}
					}
				}
				
				tmpListaArticulo.setParam("tieneSinopsis", (strSinopsis.length()>0)? "true" : "");
				tmpListaArticulo.setParam("tieneSolapa", (solapa.length()>0)? "true" : "");
				tmpListaArticulo.setParam("tieneContratapa", (contratapa.length()>0)? "true" : "");
				tmpListaArticulo.setParam("tieneSinoContraSola", (strSinopsis.length()>0 || solapa.length()>0 || contratapa.length()>0) ? "true" : "");
				
				tmpListaArticulo.setParam("tieneIndiceDeContenido", (indiceDeContenidos.length()>0)? "true" : "");
				tmpListaArticulo.setParam("mostrarBotonVerMasIndiceDeContenido", (indiceDeContenidos.length()>1000)? "true" : "");
				
				tmpListaArticulo.setParam("sinopsis", tagBSeo(strSinopsis.toString().replaceAll("\n", "<br>"), textoSEO));
				tmpListaArticulo.setParam("contratapa", tagBSeo(contratapa.toString().replaceAll("\n", "<br>"), textoSEO));
				tmpListaArticulo.setParam("solapa", tagBSeo(solapa.toString().replaceAll("\n", "<br> "), textoSEO));
				tmpListaArticulo.setParam("indiceDeContenidos", tagBSeo(indiceDeContenidos.toString().replaceAll("\n", "<br>"), textoSEO));
			}
			tmpListaArticulo.setParam("tienePrimerOIndice",(tienePrimerCapitulo||indiceDeContenidos.length()>0) ? "true" : "" );
			//FIN SINOPSIS, SOLAPA, CONTRATAPA, INDICE DE CONTENIDOS
			
			Categoria cat = articulo.getCategoria();
			/*tmpListaArticulo.setParam("urlGenero", ArticuloServiceUtil.gerUrl(cat));
			tmpListaArticulo.setParam("genero", Convert.capitalizar(cat.getDescripcion(),false));*/
			cat = cat.getSubCategoria()[0];
			Vector vecClasificaciones = new Vector();
			Hashtable hashClasificaciones  = null;
			for(int i=0;cat!=null;i++) {
				hashClasificaciones  = new Hashtable();
				hashClasificaciones.put("urlGenero", ArticuloServiceUtil.gerUrl(cat));
				if(cat.getSubCategoria().length > 0) {
					hashClasificaciones.put("genero", Convert.capitalizar(cat.getDescripcion(), true) +" &raquo;");
				}else{
					hashClasificaciones.put("genero", Convert.capitalizar(cat.getDescripcion(), true));
				}
				vecClasificaciones.add(hashClasificaciones);
				cat = (cat.getSubCategoria().length > 0)?cat.getSubCategoria()[0]:null;
			}
			//SI ES MUSICA ELIMINO UNA CATEGORIA DEL VECTOR POR QUE SON IGUALES ES PARA QUE NO QUEDE ASI:
			//R&P Castellano »  R&P Castellano
			if(articulo.getCategoria_seccion()==Globals.SECCION_MUSICA){
				vecClasificaciones.remove(0);
			}
			tmpListaArticulo.setParam("clasificaciones", vecClasificaciones);
			
			/*BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(
					articulo.getCategoria().getSubCategoria()[0].getDescripcion(), 
					articulo.getCategoria_seccion(),
					articulo.getCategoria().getSubCategoria()[0].getCategoriaPK().getPK()[1], 
					(Integer) null,
					(Integer) null, 
					new Integer(1),
					new Integer(10),
					BuscadorHelper.CRIT_MAS_VENDIDOS, 
					false);

			tmpListaArticulo.setParam("urlGenero", busquedaPorCategoria.salto().toString());*/
			 
			boolean esPedidoEspecial = !articulo.getDisponibilidad().tieneStock();//getPedido_especial().equals("S");
			if(esPedidoEspecial) {
				if(articulo.getCategoria_seccion() == 3) {
					tmpListaArticulo.setParam("enSeccion", "Pasatiempos");
				}else {
					tmpListaArticulo.setParam("enSeccion", nombreSeccion);
				}
				tmpListaArticulo.setParam("estaDisponible","");	
			}else {
				tmpListaArticulo.setParam("estaDisponible","true");
			}

			//Vector vecAutores = null;
			//Agrego el/los autores
			if (articulo.getArticuloAutor() != null) {
				/*vecAutores = new Vector(articulo.getArticuloAutor().length);
				articulo.setUrlBusquedaAutor();// seteo la url como en GetArticuloByIDnvl1,
				for (int j = 0; j < articulo.getArticuloAutor().length; j++) {
					Hashtable hashAutores = new Hashtable();
					hashAutores.put("autor", Convert.nombrePropio(articulo.getArticuloAutor()[j].getAutor().getNombre(
							articulo.getCategoria_seccion()), false));
					hashAutores.put("urlAutor", articulo.getArticuloAutor()[j].getAutor().getCls_urlBusqueda());
					vecAutores.add(hashAutores);
				}
				tmpListaArticulo.setParam("autores", vecAutores);*/
				Vector aux = ServiceLocator.getDetalleArticuloService().getAutores(articulo);
				tmpListaArticulo.setParam("autores", aux);
				//para que no quede el texto "de" cuando no tiene autor
				//tmpListaArticulo.setParam("textoDe", vecAutores.size()>0? "de" :"");
				tmpListaArticulo.setParam("textoDe", aux.size()>0? "de" :"");
				
				//BIOGGRAFIAS
				StringBuffer biografias = new StringBuffer("");
				
				for(int i=0;i<articulo.getAutor().length;i++) {
					String biografiaArchivo = ArticuloManager.getBiografiaArchivo(
							articulo.getId_articulo(), articulo.getAutor()[i].getId_autor(), Contenido.getServletContext());
					//si tiene biografia de archivo
					if(biografiaArchivo != null && biografiaArchivo.length() > 0){
						biografias.append("Biografía del autor: <b>");
						biografias.append(Convert.nombrePropio(
								articulo.getAutor()[i].getAutor().getNombre(articulo.getCategoria_seccion())));
						biografias.append("</b>");
						biografias.append("<BR>");
						biografias.append(biografiaArchivo);
						continue;
					}else {					
						//si tiene en base
						ArticuloAutorBiografia[] biografia = articulo.getAutor()[i].getBiografia(); 
						if(biografia!=null) {
							biografias.append("Biografía del autor: <b>");
							biografias.append(articulo.getAutor()[i].getAutor().getNombre(articulo.getCategoria_seccion()));
							biografias.append("</b>");
							biografias.append("<br>");
							for(int c=0;c < biografia.length;c++) {
								biografias.append(biografia[i].getTexto());
							}
						}
					}
				}
				tmpListaArticulo.setParam("tieneBiografia", biografias.length()> 0 ? "true" :"");
				biografias = (biografias.length() > 1000) ? biografias = new StringBuffer(biografias.substring(0, 1000) + "..."):biografias;
				tmpListaArticulo.setParam("mostrarBotonVerMasBiografia", biografias.length()>999?"true":"");
				tmpListaArticulo.setParam("biografia", tagBSeo(biografias.toString(), textoSEO));
				//FIN BIOGRAFIAS
			}	
			//fin autores
			
			//REDES SOCIALES agregado(12/03/2010)
			tmpListaArticulo.setParam("urlPage",Globals.DOMINIO_SITIO + articulo.getUrlDetalle());
		}catch (Exception e) {
			TmkLogger.error("DetalleDaoJdbcImpl->setListaArticulo-> " + e.getMessage());
		}
	}

	//PEDIDO DE SEO PARA AGREGAR TAG B A LAS MENCIONES A TITULO Y AUTOR 
	private String tagBSeo(String texto, List<String> keys){
		if(texto==null)
			return null;
		for(String key : keys)
			//(?i) se utiliza para deshabilitar case sensitive
			texto=texto.replaceAll("(?i)"+key, "<b>"+key+"</b>");
			
		return texto;
	}
	
}
