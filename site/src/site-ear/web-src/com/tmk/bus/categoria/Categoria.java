package com.tmk.bus.categoria;

import java.util.Vector;

import com.tmk.kernel.Convert;

public class Categoria implements Cloneable {
	private CategoriaPK categoriaPK;
	private String descripcion;
	private int cantidadArticulosDisponibles = -1;
	private Vector subCategoria = new Vector();
	
	public Categoria(CategoriaPK categoriaPK, String descripcion) {
		this.categoriaPK = categoriaPK;
		this.descripcion = descripcion;
	}
	
	public CategoriaPK getCategoriaPK() {
		return this.categoriaPK;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	public Categoria[] getSubCategoria() {
		return (Categoria[])subCategoria.toArray(new Categoria[subCategoria.size()]);
	}
	
	public void setSubCategoria(Categoria subCategoria) {
		this.subCategoria.add(subCategoria);
	}
	
	public boolean esSubcategoriaDe(Categoria posiblePadre) {
		boolean retorno = true;
		try {
			for (int i=0; i<posiblePadre.getCategoriaPK().getPK().length; i++) {
				retorno = retorno && this.categoriaPK.getPK()[i].equals(posiblePadre.getCategoriaPK().getPK()[i]);
			}
		} catch (Exception e) {
			return false;
		}
		return retorno;
	}
	
	public String toString() {
		StringBuffer retorno = new StringBuffer("Categoria ");
		retorno.append(categoriaPK.toString());
		retorno.append(" Descripcion: ").append(this.descripcion);
		retorno.append(" SubCategorias: ").append(this.subCategoria.size());
		return retorno.toString();
	}
	
	
	public String getDescripcionLarga() {
		StringBuffer des = new StringBuffer();
		des.append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.capitalizar(descripcion, false))));
		Categoria aux = this;
		while (aux.getSubCategoria().length > 0) {
			aux = aux.getSubCategoria()[0];
			des.append("-").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.capitalizar(aux.getDescripcion(), false))));
			
		}
		return des.toString();
	}
	
	public void setCantidadArticulosDisponibles(int cantidadArticulosDisponibles) {
		this.cantidadArticulosDisponibles = cantidadArticulosDisponibles; 
	}
	
	public int getCantidadArticulosDisponibles() {
		return this.cantidadArticulosDisponibles; 
	}
}
