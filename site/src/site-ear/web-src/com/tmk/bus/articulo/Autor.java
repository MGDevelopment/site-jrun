package com.tmk.bus.articulo;

import com.tmk.bus.fk.AutorFK;
import com.tmk.controllers.buscador.BuscadorHelper;
import com.tmk.controllers.buscador.BusquedaPorIDdeAutor;
import com.tmk.dbo.DBO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;

public class Autor extends DBO {
	private static final AutorFK cls_fk = AutorFK.getInstance();

	private Integer id_autor;
	private String descripcion;
	private String descripcion2; //se utiliza para articulos de musica
	private String cls_urlBusqueda;

	public Autor() {
	}

	public static String getAlias() {
		return "Au";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getFiltro() {
		return null;
	}

	public static String getOrden() {
		return null;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_autor = ").append(id_autor);
		return pk.toString();
	}

	/*gets sets*/
	public static String getTabla() {
		return "AUTORES";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getId_autor() {
		return id_autor;
	}

	public String getDescripcion2() {
		return descripcion2;
	}

	public boolean tieneDBO() {
		return false;
	}

	public void setUrlBusqueda(Integer categoria_seccion) {
		BusquedaPorIDdeAutor buscador = new BusquedaPorIDdeAutor(
				(categoria_seccion.intValue() == Globals.SECCION_MUSICA && this.descripcion2 != null)?
						Convert.nombrePropio(this.descripcion2.toUpperCase().replaceAll("\\[MUS]", ""), false)
						: Convert.nombrePropio(this.descripcion.toUpperCase().replaceAll("\\[MUS]", ""), false),
						this.id_autor, categoria_seccion,
				new Integer(0), new Integer(10), BuscadorHelper.CRIT_FECHA_NV, false);
		this.cls_urlBusqueda = buscador.salto().toString();
	}

	public String getNombre(Integer categoriaSecion) {
		return ((categoriaSecion != Globals.SECCION_MUSICA ||this.descripcion2 == null)? 
				this.descripcion : 
				this.descripcion2);	 
	}

	public String getCls_urlBusqueda() {
		return cls_urlBusqueda;
	}

	public void setCls_urlBusqueda(String cls_urlBusqueda) {
		this.cls_urlBusqueda = cls_urlBusqueda;
	}
	
}
