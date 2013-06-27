package com.tmk.bus.articulo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Vector;

import com.tmk.bus.categoria.Categoria;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.bus.fk.ArticuloFK;
import com.tmk.dbo.DBO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.service.categoria.CategoriaService;
import com.tmk.setup.ImageServer;

public class Articulo extends DBO {

	/*campos de la tabla, que no son dbo*/
	private static final ArticuloFK cls_fk = ArticuloFK.getInstance();
	private Integer id_articulo;
	private String titulo;
	private String cod_ext_visual;
	private String descripcion;
	private String idioma;
	private Integer paginas; //duracion
	private Integer peso;
	private Double precio_venta_vigente;
	private Double auxnumber05; //alto
	private Double auxnumber06; //ancho
	private Double auxnumber07; //profundidad
	private Integer categoria_seccion;
	private Integer categoria_grupo;
	private Integer categoria_familia;
	private Integer categoria_subfamilia;
	private String archivo_imagen;
	private Timestamp fecha_alta;
	private String habilitado_tematika;
	private Double cls_precio;
	private Boolean cls_error;
	private String cls_msgError;
	private String cls_urlImagen;
	private String cls_urlDetalle;
	private String cls_evaluacionComentario;
	private String cls_cantidadComentario;
	private String cls_altImagen;

	/*los dbo relacionados arrays*/	
	private DescripcionPrincipal descripcionPrincipal[];
	private TemaMusical temaMusical[];
	private IndiceDeContenido indiceDeContenido[];
	private ArticuloAutor[] articuloAutor;
	private ContraTapa contraTapa[];
	private Solapa solapa[];
	private ArticuloCompilador articuloCompilador[];
	private ComentarioArticulos comentarioArticulo[];
	private Tasa tasa;	
	private Formato formato;
	private TipoArticulo tipoArticulo;	
	private MasVendidoSeccion masVendidoSeccion;
	private Disponibilidad disponibilidad;
	private Editor editor;
		
	
	public Integer getCategoria_grupo() {
		return categoria_grupo;
	}

	public void setCategoria_grupo(Integer categoria_grupo) {
		this.categoria_grupo = categoria_grupo;
	}

	public Integer getCategoria_familia() {
		return categoria_familia;
	}

	public void setCategoria_familia(Integer categoria_familia) {
		this.categoria_familia = categoria_familia;
	}

	public Integer getCategoria_subfamilia() {
		return categoria_subfamilia;
	}

	public void setCategoria_subfamilia(Integer categoria_subfamilia) {
		this.categoria_subfamilia = categoria_subfamilia;
	}

	public void setCategoria_seccion(Integer categoria_seccion) {
		this.categoria_seccion = categoria_seccion;
	}

	public String getUrlImagen() {
		return this.cls_urlImagen;
	}
	
	public Double getUrlPrecio() {
		return this.cls_precio;
	}
	public Articulo (){
		
	}

	public Articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public ArticuloAutor[] getAutor() {
		return articuloAutor;
	}

	/**
	 * Definie la pk de tabla
	 */
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		return pk.toString();
	}

	/**
	 * Metodos estaticos
	 */
	public static String getTabla() {
		return "ARTICULOS";
	}

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "ART";
	}

	public static String getOrden() {
		return null;
	}

	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_articulo"};
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	/*GET'S, SET'S de los atributos*/
	public Integer getId_articulo() {
		return id_articulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getPrecio_venta_vigente() {
		return precio_venta_vigente;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getISBN() {
		return cod_ext_visual;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public Integer getPeso() {
		return peso;
	}

	public Timestamp getFechaAlta() {
		return fecha_alta;
	}

	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public DescripcionPrincipal[] getDescripcionPrincipal() {
		return descripcionPrincipal;
	}

	public Editor getEditor() {
		return editor;
	}

	public Tasa getTasa() {
		return tasa;
	}

	public Formato getFormato() {
		return formato;
	}

	public TipoArticulo getTipoArticulo() {
		return tipoArticulo;
	}

	public IndiceDeContenido[] getIndiceDeContenido() {
		return indiceDeContenido;
	}

	public ContraTapa[] getContraTapa() {
		return contraTapa;
	}

	public Solapa[] getSolapa() {
		return solapa;
	}

	public TemaMusical[] getTemaMusical() {
		return temaMusical;
	}

	
	public void setTemaMusical(TemaMusical[] temaMusical) {
		this.temaMusical = temaMusical;
	}

	public ArticuloCompilador[] getArticuloCompilador() {
		return articuloCompilador;
	}

	public ArticuloAutor[] getArticuloAutor() {
		return articuloAutor;
	}

	public void setArticuloAutor(ArticuloAutor[] articuloAutor) {
		this.articuloAutor = articuloAutor;
	}

	public Integer getCategoria_seccion() {
		return categoria_seccion;
	}

	public String getMedidas() {
		if (auxnumber05 != null && auxnumber06 != null && auxnumber07 != null) {
			return new StringBuffer(Convert.toMM(auxnumber05.doubleValue())).append(" x ").append(Convert.toMM(auxnumber06.doubleValue())).append(" x ").append(Convert.toMM(auxnumber07.doubleValue())).toString();
		}
		return null;
	}

	public double getPrecio(){
		double impuesto = 0;
		if (this.tasa != null) {
			impuesto += (tasa.getTasa_general()!=null)? tasa.getTasa_general().doubleValue():0;
			impuesto += (tasa.getTasa_adicional()!=null)? tasa.getTasa_adicional().doubleValue():0;
			impuesto += (tasa.getTasa_percep_video()!=null)? tasa.getTasa_percep_video().doubleValue():0;
		}

		return this.precio_venta_vigente.doubleValue() * (1 + impuesto /100);
	}

	/**
	 * Setea los precio en pesos,dolar, euro.
	 */
	public void setClsPrecio() {
		cls_precio = new Double(getPrecio());
	}

	public Categoria getCategoria() {
		CategoriaPK catPK = new CategoriaPK (new Integer[]{categoria_seccion,
				   categoria_grupo,
				   categoria_familia,
				   categoria_subfamilia});
		return CategoriaService.getCategoriaEspecifica(catPK);
	}

	public boolean tieneImagenChica() {
		return ("C".equals(archivo_imagen) || "T".equals(archivo_imagen));
	}

	public boolean tieneImagenGrande() {
		return ("G".equals(archivo_imagen) || "T".equals(archivo_imagen));
	}

	public void insert(Connection conn) throws Exception, SQLException {}
	public void delete(Connection conn) throws Exception {}
	public void update(Connection conn) throws Exception {}

	public boolean tieneDBO() {
		return true;
	}

	public boolean esNovedad() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, - Globals.DIAS_CONSIDERADOS_NOVEDAD);
		return ((fecha_alta != null) && (fecha_alta.after(cal.getTime())));
	}

	public String getImagen() {
		String pathImgCh = ImageServer.obtenerNombreDeTapa(id_articulo.intValue(), true, categoria_seccion.intValue(), 0, "", esNovedad());
		String pathImgGde = ImageServer.obtenerNombreDeTapa(id_articulo.intValue(), false, categoria_seccion.intValue(), 0, "", esNovedad());

		//si tengo imagen chica y grande, muestro la chica con el link a la grande
		if ( (pathImgCh != null && !"".equals(pathImgCh))) {
			return pathImgCh;
		// si tengo solo imagen chica, muestro imagen chica
		} else  if ( (pathImgGde != null && !"".equals(pathImgGde)) ) {
	  	  return pathImgGde;
		// si no tengo ninguna muestro la generica
		} else {
			String tapaGenerica = ImageServer.nombreArticuloSinImagen(esNovedad(), categoria_seccion.intValue());
			return tapaGenerica;
		}
	}
	public String getImagenGrande(){
		return ImageServer.obtenerNombreDeTapa(id_articulo.intValue(), false, categoria_seccion.intValue(), 0, "", esNovedad());		
	}

	public void setError (boolean error, String msg) {
		this.cls_error =  new Boolean(error);
		this.cls_msgError = msg;
	}

	public void setImagen () {
		this.cls_urlImagen = getImagen();
	}

	// fix mg20121005: modificacion URLs para la busqueda de articulos en catgorias S/D
	// fix mg20130221: modificacion para el soloLetrasYNrosCategoria
	// fix mg20130306: corregirCasosEspeciales()
	public void setUrlDetalle() {
		if(this.cls_urlDetalle!=null){
			return;
		}
		Categoria categoria = getCategoria();
		StringBuffer url = new StringBuffer();
		url.append("/");
		if (categoria.getCategoriaPK().getPK()[0].intValue() == 4) {
			url.append("cds");
		} else if (categoria.getCategoriaPK().getPK()[0].intValue() == 5) {
			url.append("dvds");
		} else {
			url.append(Convert.sinTildesNiEnie(categoria.getDescripcion().toLowerCase()));
		}
		while (categoria.getSubCategoria().length>0) {
			categoria = categoria.getSubCategoria()[0];
			String descripcion = "";
			if ("s__d".equals(categoria.getDescripcion())) {
				descripcion = categoria.getDescripcion();
			} else {
				descripcion=Convert.soloLetrasYNrosCategoria(Convert.sinTildesNiEnie(Convert.corregir(categoria.getDescripcion(), true)).toLowerCase());
			}
			while(descripcion.endsWith("_"))
				descripcion=descripcion.substring(0, descripcion.length()-1);				
			if ("s__d".equals(categoria.getDescripcion()) && 0 == categoria.getCategoriaPK().getPK()
					[categoria.getCategoriaPK().getPK().length-1]) {
				// nada
			}
			else {
				url.append("/").append(descripcion);
				url.append("--").append(categoria.getCategoriaPK().getPK()
					[categoria.getCategoriaPK().getPK().length-1]);
			}
		}

		
		url.append("/").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(Convert.corregirCasosEspeciales(this.titulo), true)).toLowerCase())).append("--").append(this.id_articulo).append(".htm");
		this.cls_urlDetalle = url.toString();
	}
	
	/**
	 * Arma el link al detalle usando setUrlDetalle();y luego retorna el string 
	 * que representa el link(en la forma necesaria para que lo entienda el  urlRrewrite)
	 * @return
	 */
	public String getUrlDetalle() {
		this.setUrlDetalle();
		return this.cls_urlDetalle;
	}
	

	public boolean estaHabilitado() {
		return "S".equals(this.habilitado_tematika);
	}

	public void filtrarAutores() {
		if (articuloAutor != null) {
			Vector<ArticuloAutor> aux = new Vector<ArticuloAutor>();
			for (int i=0; i<articuloAutor.length; i++) {
				if (categoria_seccion.equals(new Integer(Globals.SECCION_PELICULA))) {
					if (articuloAutor[i].getRole().equals("D02")) {
						aux.add(articuloAutor[i]);
					}
				} else {
					if (articuloAutor[i].getRole().equals("A01")) {
						aux.add(articuloAutor[i]);
					}
				}
			}
			if (aux.size() >0) {
				articuloAutor = (ArticuloAutor[]) aux.toArray(new ArticuloAutor[aux.size()]);
			} else {
				articuloAutor = null;
			}

		}
	}

	/**
	 * recorre a todos los autores y les setea la url de busqueda para ese autor
	 */
	public void setUrlBusquedaAutor() {
		if (this.articuloAutor != null) {
			for (int i=0; i<articuloAutor.length; i++) {
				articuloAutor[i].getAutor().setUrlBusqueda(this.categoria_seccion);
			}
		}
	}

	public void setUrlBusquedaEditor() {
		this.editor.setUrlBusqueda(this.categoria_seccion);
	}

	public void setEvaluacionComentario(String evaluacionComentario) {
		this.cls_evaluacionComentario = evaluacionComentario;
	}

	public void setCantidadComentario(String cantidadComentario) {
		this.cls_cantidadComentario = cantidadComentario;
	}
	
	public ComentarioArticulos[] getComentarioArticulo() {
		return comentarioArticulo;
	}

	public void setComentarioArticulo(ComentarioArticulos[] comentarioArticulo) {
		this.comentarioArticulo = comentarioArticulo;
	}
	
	public Categoria getGenero() {
		Categoria categoria = getCategoria();		
		while (categoria.getSubCategoria().length>0) {
			categoria = categoria.getSubCategoria()[0];			
		}
		return categoria;//retorna la categoria mas especifica
	}
	/**
	 * Muestra la categoria mas especifica y un nivel mas arriba
	 * @return
	 */
	public String getGeneroSecuencial() {
		StringBuffer generoLargo = new StringBuffer("");
		Categoria categoria = getCategoria();
		while (categoria.getSubCategoria().length>0) {
			categoria = categoria.getSubCategoria()[0];			
		}
		generoLargo.append(categoria.getDescripcion()).append("KEYPARSER");
		Integer[]pkAux = new Integer[categoria.getCategoriaPK().getPK().length-1]; 
		for(int i=0;i<categoria.getCategoriaPK().getPK().length-1;i++){
			pkAux[i] = categoria.getCategoriaPK().getPK()[i];
		}
		CategoriaPK cpk = new CategoriaPK(pkAux);
		
		Categoria auxCat = CategoriaService.getCategoriaEspecifica(cpk);
		while (auxCat.getSubCategoria().length>0) {
			auxCat = auxCat.getSubCategoria()[0];			
		}
		generoLargo.append(auxCat.getDescripcion());
		String[] retorno = generoLargo.toString().split("KEYPARSER");
		if(retorno.length>1){			
			return retorno[1]+" "+retorno[0];
		}
		return retorno[0];
	}	
	
	public MasVendidoSeccion getMasVendidoSeccion() {
		return masVendidoSeccion;
	}

	//METODOS OBTENIDOS DESDE ArticuloDAO.java
	public boolean esGastoDeEnvio() {
		return ((this.categoria_seccion == Globals.GASTO_DE_ENVIO_CATEGORIA_SECCION) &&
		        (this.categoria_grupo == Globals.GASTO_DE_ENVIO_CATEGORIA_GRUPO) &&
		        (this.categoria_familia == Globals.GASTO_DE_ENVIO_CATEGORIA_FAMILIA));
	}

	public boolean esInteresCobrado() {
		return ((this.categoria_seccion == Globals.INTERES_COBRADO_CATEGORIA_SECCION) &&
		        (this.categoria_grupo == Globals.INTERES_COBRADO_CATEGORIA_GRUPO) &&
		        (this.categoria_familia == Globals.INTERES_COBRADO_CATEGORIA_FAMILIA));
	}
	
	//metodo de test (no se si es asi, la comprobacion=
	public boolean esPapelDeRegalo() {
		return ((this.categoria_seccion == 99) &&
		        (this.categoria_grupo == 1) &&
		        (this.categoria_familia == 4));
	}

	public String getCls_altImagen() {
		setCls_altImagen();
		return cls_altImagen;
	}

	public void setCls_altImagen() {
		if(this.cls_altImagen!=null)
			return;
		String aux="";
		Categoria categoria = getCategoria();
		if (categoria.getCategoriaPK().getPK()[0].intValue() == 4) {
			aux+="cds";
		} else if (categoria.getCategoriaPK().getPK()[0].intValue() == 5) {
			aux+="dvds";
		} else {
			aux+=Convert.sinTildesNiEnie(categoria.getDescripcion().toLowerCase());
		}
		while (categoria.getSubCategoria().length>0) {
			categoria = categoria.getSubCategoria()[0];
			aux=Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(categoria.getDescripcion(), true)).toLowerCase())+" - "+aux;
		}
		cls_altImagen=Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(this.titulo, true)))+" - "+aux;		
	}
	
}
