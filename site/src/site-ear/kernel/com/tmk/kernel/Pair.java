/**
 * $Log: Pair.java,v $
 * Revision 1.1  2003/08/11 14:26:45  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.1  2003/08/02 16:58:13  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.1  2003/07/28 19:21:29  GPistoia
 * -Controlador de registracion
 *
 */
package com.tmk.kernel;

public class Pair {

	private Object value1;
	private Object value2;

	public Pair(Object value1, Object value2) {
		super();
		setValue1(value1);
		setValue2(value2);
	}

	public Object getValue1() {
		return value1;
	}

	public void setValue1(Object value1) {
		this.value1 = value1;
	}

	public Object getValue2() {
		return value2;
	}

	public void setValue2(Object value2) {
		this.value2 = value2;
	}
}
