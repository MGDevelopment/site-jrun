/**
 * $Log: MultiField.java,v $
 * Revision 1.2  2006/02/20 12:38:19  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.1  2006/01/11 17:37:11  omsartori
 * -Dromo
 *    -Se quito el campo fabricante
 *    -Se filtra la seleccion de papel de regalo para articulos (6,7,8)
 *    -Estetica en seleccion de medio de pago
 * -Empro doc 11 (parte 1)
 * -Intranet TMK
 *    -Generacion en otro equipo configurable
 *    -Correccion y configuracion de procesos de generacion de Detalle y recorrido de categorias
 *
 */
package com.tmk.kernel;

public class MultiField {
	private int cantidadDeCampos;
	private Object []arreglo;
	private int campoActual;

	public MultiField(int cantidadDeCampos) {
		campoActual = 0;
		this.cantidadDeCampos = cantidadDeCampos;
		this.arreglo = new Object[this.cantidadDeCampos];
	}

	public void addValor(int campo, Object valor) throws Exception {
		if (campo >= cantidadDeCampos) {
			throw new Exception ("MultiField.addValor tamaño de campo excedido");
		}
		arreglo[campo] = valor;
	}

    public Object getValor(int campo) throws Exception  {
		if (campo >= cantidadDeCampos) {
			throw new Exception ("MultiField.getValor tamaño de campo excedido");
		}
	    return arreglo[campo];
    }

	public Object getValor() throws Exception  {
		if (campoActual >= cantidadDeCampos) {
			throw new Exception ("MultiField.getValor tamaño de campo excedido");
		}
		campoActual++;
		return arreglo[campoActual];
    }

	public int getCampoActual() {
		return campoActual;
	}

	public int getTamanio() {
		return cantidadDeCampos;
	}

	public void irAComienzo() {
		campoActual = 0;
	}

	public void irASiguiente() {
		campoActual++;
	}

	public void irAFin() {
		campoActual = cantidadDeCampos-1;
	}

    public boolean eof() {
	   if (campoActual >= cantidadDeCampos-1) {
		   return true;
	   }
	   return false;
    }

	public boolean tieneSiguiente() {
		if (campoActual < cantidadDeCampos-1) {
			return true;
		}
		return false;
	}



}
