/**
 * $Log: MesDAO.java,v $
 * Revision 1.5  2005/09/22 18:38:09  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.4  2004/02/11 19:32:53  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.3  2003/10/03 16:29:05  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.2  2003/09/11 18:08:45  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.1  2003/08/15 15:59:21  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 */
package com.tmk.kernel;

public class MesDAO {

	private int id;
	private String nombre;

	public MesDAO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = Convert.capitalizar(nombre, false);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "Mes (" + id + ") " + nombre;
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof MesDAO) &&
		        (id == ((MesDAO) other).id));
	}

	public static MesDAO getMes(int id) {
		for (int i = 0; i < Globals.MESES.length; i++) {
			MesDAO current = Globals.MESES[i];
			if (current.getId() == id) {
				return current;
			}
		}
		return null;
	}

}
