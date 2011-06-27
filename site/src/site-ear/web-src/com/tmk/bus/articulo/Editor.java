package com.tmk.bus.articulo;

import com.tmk.bus.fk.EditorFK;
import com.tmk.controllers.buscador.BuscadorHelper;
import com.tmk.controllers.buscador.BusquedaPorIDdeEditorial;
import com.tmk.dbo.DBO;
import com.tmk.kernel.Convert;

public class Editor extends DBO {
	private static final EditorFK cls_fk = EditorFK.getInstance();
	private Integer id_editor;
	private String nombre;
	private String cls_urlBusqueda;

	public Editor() {

	}


	public Editor(Integer id_editor) {
		this.id_editor = id_editor;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_editor = ").append(id_editor);
		return pk.toString();
	}

	public static String getTabla() {
		return "EDITORES";
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getIdEditor() {
		return this.id_editor;
	}

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "EDIT";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getOrden() {
		return null;
	}


	public boolean tieneDBO() {
		return false;
	}

	public void setUrlBusqueda(Integer categoria_seccion) {
		BusquedaPorIDdeEditorial buscador = new BusquedaPorIDdeEditorial(
				Convert.nombrePropio(this.nombre.toUpperCase().replaceAll("\\[MUS]", ""), false),
				this.id_editor, categoria_seccion,
				new Integer(0), new Integer(10), BuscadorHelper.CRIT_FECHA_NV, false);
		this.cls_urlBusqueda = buscador.salto().toString();
	}


	public String getCls_urlBusqueda() {
		return cls_urlBusqueda;
	}	
	
}
