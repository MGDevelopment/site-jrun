/**
 * $Log: AtributoDinamicoDAO.java,v $
 * Revision 1.1  2005/01/12 15:29:36  oGPistoia
 * - Buscador de Atributos Dinamicos (solo falta la pagina)
 *
 */
package com.tmk.kernel;

import java.util.Vector;

public class AtributoDinamicoDAO {

	private String texto;
	private String campo;
	public Vector valores;

	public AtributoDinamicoDAO(String texto, String campo) {
		super();
		this.texto = texto;
		this.campo = campo;
		this.valores = new Vector();
	}

	public String getTexto() {
		return texto;
	}

	public String getCampo() {
		return campo;
	}

	public Vector getValores() {
		return valores;
	}

	public boolean mostrarOpciones() {
		// Antes era que tuviera algun elemento, pero si tiene 1 sola opcion tampoco se muestra
		return (valores.size() > 1);
	}

	public void agregarValor(String valor) {
		valores.add(valor);
	}

}
