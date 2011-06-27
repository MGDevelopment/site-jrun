package com.tmk.bus.articulo;

import java.sql.Timestamp;
import java.util.Date;
import com.tmk.bus.categoria.Categoria;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Pair;
import com.tmk.kernel.TmkLogger;
import java.util.Vector;


public class ArticuloClass {
	private int idArticulo;
	private int idSeccion;
	private int idGrupo;
	private String grupo;
	private String titulo;
	private double precio;
	private double porcentajeDescuento;
	private int idDisponibilidad;
	private String disponibilidad;
	private String habilitadoTematika;
	private Vector autores = null;
	private Vector compiladores = null;
	private String[] indiceDeContenido = null;
	private String[] sinopsis = null;
	boolean esNovedad = false;
	private int idEditorial;
	private String editorial = null;
	private String ISBN;
	private String formato;
	private String proveedor;
	private Vector protagonistas = null;
	private int idMarca;
	private String marca = null;
	private int paginas;
	private Date fechaAlta= null;
	private String idioma;
	private int peso;
	private String medidas;
	private String[] contratapa;
	private String[] solapa;
	//para el catalogo de contenido XML
	private Timestamp vencimiento;
	private Categoria categoria;
	
	
	public ArticuloClass(int idArticulo) {
		this.idArticulo = idArticulo; 
	}
	
	public final int getIdArticulo() {
		return this.idArticulo;
	}
	
	public void setIdSeccion(int idSeccion) {
		//this.idSeccion = idSeccion;
	}
	
	public int getIdSeccion() {
		return categoria.getCategoriaPK().getPK()[0].intValue();
	}

	public void setIdGrupo(int idGrupo) {
		//this.idGrupo = idGrupo;
	}

	public int getIdGrupo() {
		return categoria.getSubCategoria()[0].getCategoriaPK().getPK()[1].intValue();
	}
	
	public void setGrupo(String grupo) {
		//this.grupo = grupo;
	}
	
	public String getGrupo() {
		return categoria.getSubCategoria()[0].getDescripcion();
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setPrecio(double precio) {
		this.precio = Convert.round(precio);
		try {
			Pair pair = DBUtil.calculaPricing(new Integer(this.idArticulo));
			this.porcentajeDescuento = Convert.round(((Double) pair.getValue2()).doubleValue());
		} catch (Exception e) {
			TmkLogger.debug("ArticuloClass: setPrecio(porcentaje de Descuento)" + e.toString());		
		}
	}
	
	public double getPrecio() {
		return Convert.aplicarPorcentaje(this.precio, porcentajeDescuento);
	}
	
	public double getPrecioSinDescuento () {
		return this.precio;
	}
	
	public double getPorcentajeDescuento(){
		return this.porcentajeDescuento;
	}
	
	public void setIdDisponibilidad(int idDisponibilidad) {
		this.idDisponibilidad = idDisponibilidad;
	}
	
	public int getIdDisponibilidad() {
		return this.idDisponibilidad;
	}
	
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public String getDisponibilidad() {
		return this.disponibilidad;
	}
	
	public void setHabilitadoTematika(String habilitadoTematika) {
		this.habilitadoTematika = habilitadoTematika;
	}
	
	public String getHabilitadoTematika() {
		return this.habilitadoTematika;
	}
	
	public void setAutor(int idAutor, String nombre) {
		if (autores == null) {
			autores = new Vector();
		}
		
		for (int i=0; i<autores.size(); i++) {
			String autor [] = (String[])autores.get(i);
			if (autor[0].equals(idAutor+"")) {
				return;
			}
		}

		String autor[] = new String[2];
		autor[0] = idAutor+"";
		//MODIFICADO SIN COMA ASUMIR ESPACIO
		autor[1] = Convert.nombrePropio(nombre, false);
		autores.add(autor);
	}
	
	public Vector getAutor () {
		return autores;
	}
	
	public String getStringDeAutores(String separador) {
		if (autores != null) {
			StringBuffer autor = new StringBuffer();
	         for (int i=0; i<autores.size(); i++) {
	        	 autor.append(((String[])autores.get(i))[1]).append(separador);
	         }
			if (autor.length()>separador.length()) {
				return autor.toString().substring(0,autor.length()-separador.length());
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	
	public boolean tieneAutores() {
		return (autores!=null);
	}
	
	public void setCompilador(int idCompilador, String nombre) {
		if (compiladores == null) {
			compiladores = new Vector();
		}
		
		for (int i=0; i<compiladores.size(); i++) {
			String compilador [] = (String[])compiladores.get(i);
			if (compilador[0].equals(idCompilador+"")) {
				return;
			}
		}

		String compilador[] = new String[2];
		compilador[0] = idCompilador+"";
		compilador[1] = Convert.nombrePropio(nombre, true);
		compiladores.add(compilador);
	}
	
	public Vector getCompilador () {
		return compiladores;
	}
	
	public String getStringDeCompiladores(String separador) {
		if (compiladores != null) {
			StringBuffer compilador = new StringBuffer();
	         for (int i=0; i<compiladores.size(); i++) {
	        	 compilador.append(((String[])compiladores.get(i))[1]).append(separador);
	         }
			if (compilador.length()>separador.length()) {
				return compilador.toString().substring(0,compilador.length()-separador.length());
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	
	public boolean tieneCompilador() {
		return (compiladores!=null);
	}
	
	
	public void setIndice(int parte, String texto){
		if (indiceDeContenido == null) {
			indiceDeContenido = new String[100];
		}
		if (texto != null) {
			indiceDeContenido[parte-1] = texto;
		}	
	}
	
	public String getIndice() {
		if (indiceDeContenido != null) {
			StringBuffer texto = new StringBuffer();	
			for (int i=0; i<indiceDeContenido.length; i++) {
				if (indiceDeContenido[i] == null) {
					break;
				}
				texto.append(indiceDeContenido[i]);
			}
			return texto.toString();
		} else {
			return "";
		}
	}
	
	public String[] getIndice(boolean a) {
		return indiceDeContenido;
	}
	
	
	
	public void setSinopsis(int parte, String texto) {
		if (sinopsis == null) {
			sinopsis = new String[150];
		}
		if (texto != null) {
			if (parte == 0) {
				parte = 1;
			}
			sinopsis[parte-1] = texto;
		}	
	}
	
	public String getSinopsis() {
		if (sinopsis != null) {
			StringBuffer texto = new StringBuffer();	
			for (int i=0; i<sinopsis.length; i++) {
				if (sinopsis[i] == null) {
					break;
				}
				texto.append(sinopsis[i]);
			}
			return texto.toString();
		} else {
			return "";
		}
	}
	
	
	public void setContratapa(int parte, String texto) {
		if (contratapa == null) {
			contratapa = new String[100];
		}
		if (texto != null) {
			contratapa[parte-1] = texto;
		}	
	}
	
	public String getContratapa() {
		if (contratapa != null) {
			StringBuffer texto = new StringBuffer();	
			for (int i=0; i<contratapa.length; i++) {
				if (contratapa[i] == null) {
					break;
				}
				texto.append(contratapa[i]);
			}
			return texto.toString();
		} else {
			return "";
		}
	}
	
	public void setSolapa(int parte, String texto) {
		if (solapa == null) {
			solapa = new String[100];
		}
		if (texto != null) {
			solapa[parte-1] = texto;
		}	
	}
	
	public String getSolapa() {
		if (solapa != null) {
			StringBuffer texto = new StringBuffer();	
			for (int i=0; i<solapa.length; i++) {
				if (solapa[i] == null) {
					break;
				}
				texto.append(solapa[i]);
			}
			return texto.toString();
		} else {
			return "";
		}
	}
	
	public String[] getSinopsis(boolean a) {
		return sinopsis;
	}
	
	public void setEsNovedad (Date fechaAlta){
		Date fechaComparacion = new Date();
		fechaComparacion.setDate(fechaComparacion.getDate() - Globals.DIAS_CONSIDERADOS_NOVEDAD);
		this.esNovedad = ((fechaAlta != null) && (fechaAlta.after(fechaComparacion)));
	}
	
	public boolean esNovedad() {
		return this.esNovedad;
	}
	
	
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	
	public int getIdEditorial() {
		return this.idEditorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String getEditorial() {
		return this.editorial;
	}
	
	public void setISBN (String ISBN) {
		this.ISBN = ISBN;
	}
	
	public String getISBN () {
		return this.ISBN;
	}
	
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public String getFormato() {
		return this.formato;
	}
	
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	public String getProveedor() {
		return this.proveedor;
	}
	
	public void setInterprete(int idInterprete, String nombre) {
		setAutor(idInterprete, nombre);
	}
	
	public Vector getInterprete () {
		return getAutor();
	}
	
	public String getStringDeInterpretes(String separador) {
		return getStringDeAutores(separador);
	}
	
	public boolean tieneInterpretes() {
		return tieneAutores();
	}
	
	public void setDiscografica(String discografica) {
		setEditorial(discografica);
	}
	
	public String getDiscografica() {
		return getEditorial();
	}
	
	public void setTemaMusical(int nroTema, String nombreTema) {
		setSinopsis (nroTema, nombreTema);
	}
	
	public String getTemaMusical() {
		if (sinopsis != null && sinopsis.length > 2) {
			StringBuffer texto = new StringBuffer();	
			for (int i=0; i<sinopsis.length; i++) {
				if (sinopsis[i] == null) {
					break;
				}
				texto.append(Convert.nombrePropio(sinopsis[i], false)).append("<br>");
			}
			return texto.toString();
		} else { 
			return getSinopsis();
		}	
	}
	
	public String[] getTemaMusical(boolean a) {
		return getSinopsis(a);
	}
		
	public void setProductora (String productora) {
		setEditorial(productora);
	}
	
	public String getProductora() {
		return getEditorial();
	}
	
	public void setIdProductora (int idProductora) {
		setIdEditorial(idProductora);
	}
	
	public int getIdProductora() {
		return getIdEditorial();
	}
	
	public void setProtagonista (int idProtagonista, String nombre) {
		if (protagonistas == null) {
			protagonistas = new Vector();
		}
		
		for (int i=0; i<protagonistas.size(); i++) {
			String protagonista [] = (String[])protagonistas.get(i);
			if (protagonista[0].equals(idProtagonista+"")) {
				return;
			}
		}

		String protagonista[] = new String[2];
		protagonista[0] = idProtagonista+"";
		protagonista[1] = Convert.nombrePropio(nombre, true);
		protagonistas.add(protagonista);
		
		/*if (protagonistas == null) {
			protagonistas = new Hashtable();
		}
		
		if (!protagonistas.containsKey(new Integer(idProtagonista))) {
			protagonistas.put(new Integer(idProtagonista), Convert.nombrePropio(nombre));
		}*/
	}
	
	public Vector getProtagonista () {
		return protagonistas;
	}
	
	public String getStringDeProtagonistas(String separador) {
		
		if (protagonistas != null) { 
		
			StringBuffer protagonista = new StringBuffer();
	         for (int i=0; i<protagonistas.size(); i++) {
	        	protagonista.append(((String[])protagonistas.get(i))[1]);
	        	protagonista.append(separador);
	         }
			if (protagonista.length()>separador.length()) {
				return protagonista.toString().substring(0,protagonista.length()-separador.length());
			} else {
				return "";
			}
			
		} else {
			return "";
		}
	}
	
	public boolean tieneProtagonistas() {
		return (protagonistas!=null);
	}
	
	public void setDirector(int idDirector, String nombre) {
		setAutor(idDirector, nombre);
	}
	
	public Vector getDirector () {
		return getAutor();
	}
	
	public String getStringDeDirectores(String separador) {
		return getStringDeAutores(separador);
	}
	
	public boolean tieneDirectores() {
		return tieneAutores();
	}
	
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	public int getIdMarca() {
		return this.idMarca; 
	}
	
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return this.marca; 
	}
	
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public int getPagina() {
		return this.paginas; 
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public Date getFechaAlta() {
		return this.fechaAlta;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getIdioma() {
		return this.idioma;
	}
	
	public String getAtributoPrincipal() {
		switch (this.getIdSeccion()) {
			case Globals.SECCION_LIBRO: {
				if (getAutor() != null) {
					return getStringDeAutores("-");
				}	
				if (getCompilador() != null) {
					return getStringDeCompiladores("-");
				}
			}
			case Globals.SECCION_MUSICA: {
				return getStringDeInterpretes("-");
			}
			case Globals.SECCION_PELICULA: {
				return getStringDeDirectores("-");
			}
			case Globals.SECCION_JUGUETES: {
				return getEditorial();
			}
			default: return "";
		}
	}
	
	public Vector getIdAtributoPrincipal() {
		Vector aux = new Vector();
		switch (this.getIdSeccion()) {
			case Globals.SECCION_LIBRO: {
				if (getAutor() != null) {
					for (int i=0; i<getAutor().size(); i++) {
			         	aux.add(((String[])getAutor().get(i))[0]);
			         }
					return aux;
				}	
				if (getCompilador()!= null) {
					for (int i=0; i<getCompilador().size(); i++) {
			         	aux.add(((String[])getCompilador().get(i))[0]);
			         }
					return aux;
				}
			}
			case Globals.SECCION_MUSICA: {
				if (getInterprete() != null) {
					for (int i=0; i<getInterprete().size(); i++) {
			         	aux.add(((String[])getInterprete().get(i))[0]);
			         }
					return aux;
				}
			}
			case Globals.SECCION_PELICULA: {
				if (getDirector() != null) {
					for (int i=0; i<getDirector().size(); i++) {
			         	aux.add(((String[])getDirector().get(i))[0]);
			         }
					return aux;
				}
				return aux;
			}
			case Globals.SECCION_JUGUETES: {
				if (getIdEditorial() != 0) {
					aux.add(new Integer(getIdEditorial()));
				}
				return aux;
			}
			default: return aux;
		}
	}
	
	public void setPeso (int peso) {
		this.peso = peso;
	}
	
	public int getPeso () {
		return this.peso;
	}
	
	public void setMedidas(double alto, double ancho, double profundidad) {
		StringBuffer str = new StringBuffer();
		if (alto == 0 || ancho == 0 || profundidad == 0) {
			this.medidas = null;
		} else {
			str.append(Convert.toMM(alto)).append(" x ");
			str.append(Convert.toMM(ancho)).append(" x ");
			str.append(Convert.toMM(profundidad));
			this.medidas = str.toString();
		}	
		
	}
	
	public String getMedidas() {
		return this.medidas;
	}
	
	public void setVencimiento(Timestamp vencimiento) {
		this.vencimiento = vencimiento;
	}
	
	public Timestamp getVencimiento() {
		return this.vencimiento;
	}
	
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
}