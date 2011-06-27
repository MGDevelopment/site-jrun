package com.tmk.articulo;

import com.tmk.kernel.DisponibilidadDAO;

import javax.ejb.EJBLocalObject;
import java.util.Vector;

public interface ArticuloReducidoLocal extends EJBLocalObject, ArticuloTageable
{
	public Integer getID_ARTICULO();

	public String getTITULO();

	public Double getPRECIO_VENTA_VIGENTE();

	public Integer getID_DISPONIBILIDAD();

	public String getHABILITADO_TEMATIKA();

	public String getID_IMPUESTO();

	public Integer getCATEGORIA_SECCION();

	public Integer getCATEGORIA_GRUPO();

	public Integer getCATEGORIA_FAMILIA();

   	public Integer getCATEGORIA_SUBFAMILIA();

	public Integer getID_EDITOR();

	public Integer getID_PROVEEDOR();

	public Double getPRECIO_ORIGINAL();

	public String getID_TIPO_ARTICULO();

	public String getSinopsis();

    public Double getPRECIO_CON_IMPUESTOS();

	public boolean getTIENE_DESCUENTO();

	public Double getPORCENTAJE_DESCUENTO();

	public Double getPRECIO_CON_DESCUENTO();

	public Double getPRECIO_SITIO();

    public DisponibilidadDAO getDISPONIBILIDAD_SITIO();

	public boolean getESTA_HABILITADO_TEMATIKA();

	public String getEDITOR();

	public Vector getID_ATRIBUTO_PRINCIPAL();

	public Vector getDESC_ATRIBUTO_PRINCIPAL();

	public String getTEXTO_ATRIBUTO_PRINCIPAL();

	public String getTITULO_CORTO();

	public String getCOD_EXT_VISUAL();

	public String getCategorizacion();

	public String getNombreAtributoPrincipal();

	public String getNombreEditorial();

	public String getISBN();

	public String getFormato();

	public String getProtagonista();

	public String getTEXTO_ATRIBUTO_PRINCIPAL_DETALLADO();

    public int getListaPVP();

	public Double getAHORRO();

	public Double getTASA_IMPUESTO_GENERAL();

	public Double getTASA_IMPUESTO_VIDEO();

	public Integer getAUXNUMBER03();

	public String getDESCRIPCION();

    /*recorrido familias*/
    public String getSeccion();
    public String getGrupo();
    public String getFamilia();
    /*recorrido familias*/

    /*busquedas*/
    public Vector getTEMAS();
    /*busquedas*/
}


