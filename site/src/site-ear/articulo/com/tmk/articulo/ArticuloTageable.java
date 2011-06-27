/**
 * $Log: ArticuloTageable.java,v $
 * Revision 1.1  2005/07/26 14:13:26  omsartori
 * - Modificaciones en Articulo Reducido
 * - Tag de Precio para Articulo
 * - Buscador por id de autor
 * - Buscador generico por atributo principal (DROMO)
 * - Home> Articulo reemplazado por Articulo Reducido
 *
 */
package com.tmk.articulo;

import com.tmk.kernel.DisponibilidadDAO;

public interface  ArticuloTageable {
	public  Integer getID_ARTICULO();
	public  Double getPRECIO_CON_IMPUESTOS();
	public  boolean getTIENE_DESCUENTO();
	public  Double getPRECIO_SITIO();
	public  DisponibilidadDAO getDISPONIBILIDAD_SITIO();
	public  boolean getESTA_HABILITADO_TEMATIKA();
    public  Double getPORCENTAJE_DESCUENTO();

}
