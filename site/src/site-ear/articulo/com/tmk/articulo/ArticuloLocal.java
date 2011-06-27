package com.tmk.articulo;

import com.tmk.kernel.DisponibilidadDAO;

import javax.ejb.EJBLocalObject;
import java.util.Vector;

public interface ArticuloLocal extends EJBLocalObject {

	public Integer getID_ARTICULO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public String getTITULO();

	public void setTITULO(String TITULO);

	public String getCODIGO_PROVEEDOR();

	public void setCODIGO_PROVEEDOR(String CODIGO_PROVEEDOR);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public java.sql.Timestamp getFECHA_ALTA();

	public void setFECHA_ALTA(java.sql.Timestamp FECHA_ALTA);

	public String getIDIOMA();

	public void setIDIOMA(String IDIOMA);

	public Integer getPAGINAS();

	public void setPAGINAS(Integer PAGINAS);

	public Integer getPESO();

	public void setPESO(Integer PESO);

	public Double getPRECIO_VENTA_VIGENTE();

	public void setPRECIO_VENTA_VIGENTE(Double PRECIO_VENTA_VIGENTE);

	public Double getPRECIO_COMPRA_VIGENTE();

	public void setPRECIO_COMPRA_VIGENTE(Double PRECIO_COMPRA_VIGENTE);

	public Integer getDESDE_EDAD();

	public void setDESDE_EDAD(Integer DESDE_EDAD);

	public Integer getHASTA_EDAD();

	public void setHASTA_EDAD(Integer HASTA_EDAD);

	public String getMARCA();

	public void setMARCA(String MARCA);

	public String getAGOTADO();

	public void setAGOTADO(String AGOTADO);

	public String getACTIVO();

	public void setACTIVO(String ACTIVO);

	public String getARCHIVO_EN_SITE();

	public void setARCHIVO_EN_SITE(String ARCHIVO_EN_SITE);

	public String getARCHIVO_IMAGEN();

	public void setARCHIVO_IMAGEN(String ARCHIVO_IMAGEN);

	public String getARCHIVO_CAPITULO();

	public void setARCHIVO_CAPITULO(String ARCHIVO_CAPITULO);

	public Integer getID_ARTICULO_SITE();

	public void setID_ARTICULO_SITE(Integer ID_ARTICULO_SITE);

	public String getID_TIPO_ARTICULO();

	public void setID_TIPO_ARTICULO(String ID_TIPO_ARTICULO);

	public String getID_MONEDA_COMPRA();

	public void setID_MONEDA_COMPRA(String ID_MONEDA_COMPRA);

	public String getID_MONEDA_VENTA();

	public void setID_MONEDA_VENTA(String ID_MONEDA_VENTA);

	public Integer getID_EDITOR();

	public void setID_EDITOR(Integer ID_EDITOR);

	public Integer getID_PROVEEDOR();

	public void setID_PROVEEDOR(Integer ID_PROVEEDOR);

	public Integer getID_COLECCION();

	public void setID_COLECCION(Integer ID_COLECCION);

	public String getID_IMPUESTO();

	public void setID_IMPUESTO(String ID_IMPUESTO);

	public String getNOVEDAD();

	public void setNOVEDAD(String NOVEDAD);

	public String getSTOCK();

	public void setSTOCK(String STOCK);

	public String getES_TEXTO();

	public void setES_TEXTO(String ES_TEXTO);

	public String getESTADO_INGRESO();

	public void setESTADO_INGRESO(String ESTADO_INGRESO);

	public Integer getCATEGORIA_SECCION();

	public void setCATEGORIA_SECCION(Integer CATEGORIA_SECCION);

	public Integer getCATEGORIA_GRUPO();

	public void setCATEGORIA_GRUPO(Integer CATEGORIA_GRUPO);

	public Integer getCATEGORIA_FAMILIA();

	public void setCATEGORIA_FAMILIA(Integer CATEGORIA_FAMILIA);

	public Integer getCATEGORIA_SUBFAMILIA();

	public void setCATEGORIA_SUBFAMILIA(Integer CATEGORIA_SUBFAMILIA);

	public Integer getID_ACTIVIDAD_IIBB();

	public void setID_ACTIVIDAD_IIBB(Integer ID_ACTIVIDAD_IIBB);

	public Integer getID_COEDITOR();

	public void setID_COEDITOR(Integer ID_COEDITOR);

	public Integer getNRO_EDICION();

	public void setNRO_EDICION(Integer NRO_EDICION);

	public String getCOLECCION_DIRECTOR();

	public void setCOLECCION_DIRECTOR(String COLECCION_DIRECTOR);

	public String getCOLECCION_SERIE();

	public void setCOLECCION_SERIE(String COLECCION_SERIE);

	public String getCOLECCION_NUMERO();

	public void setCOLECCION_NUMERO(String COLECCION_NUMERO);

	public Integer getNRO_VOLUMEN();

	public void setNRO_VOLUMEN(Integer NRO_VOLUMEN);

	public Integer getTOTAL_VOLUMENES();

	public void setTOTAL_VOLUMENES(Integer TOTAL_VOLUMENES);

	public String getTRADUCTOR();

	public void setTRADUCTOR(String TRADUCTOR);

	public String getCOMPILADOR();

	public void setCOMPILADOR(String COMPILADOR);

	public String getILUSTRADOR();

	public void setILUSTRADOR(String ILUSTRADOR);

	public String getCOD_EXT_VISUAL();

	public void setCOD_EXT_VISUAL(String COD_EXT_VISUAL);

	public String getAUXVARCHAR01();

	public void setAUXVARCHAR01(String AUXVARCHAR01);

	public String getAUXVARCHAR02();

	public void setAUXVARCHAR02(String AUXVARCHAR02);

	public String getAUXVARCHAR03();

	public void setAUXVARCHAR03(String AUXVARCHAR03);

	public String getAUXVARCHAR04();

	public void setAUXVARCHAR04(String AUXVARCHAR04);

	public String getAUXVARCHAR05();

	public void setAUXVARCHAR05(String AUXVARCHAR05);

	public String getAUXVARCHAR06();

	public void setAUXVARCHAR06(String AUXVARCHAR06);

	public String getAUXVARCHAR07();

	public void setAUXVARCHAR07(String AUXVARCHAR07);

	public String getAUXVARCHAR08();

	public void setAUXVARCHAR08(String AUXVARCHAR08);

	public String getAUXVARCHAR09();

	public void setAUXVARCHAR09(String AUXVARCHAR09);

	public String getAUXVARCHAR10();

	public void setAUXVARCHAR10(String AUXVARCHAR10);

	public String getAUXVARCHAR11();

	public void setAUXVARCHAR11(String AUXVARCHAR11);

	public String getAUXVARCHAR12();

	public void setAUXVARCHAR12(String AUXVARCHAR12);

	public String getAUXVARCHAR13();

	public void setAUXVARCHAR13(String AUXVARCHAR13);

	public String getAUXVARCHAR14();

	public void setAUXVARCHAR14(String AUXVARCHAR14);

	public String getAUXVARCHAR15();

	public void setAUXVARCHAR15(String AUXVARCHAR15);

	public Integer getAUXNUMBER01();

	public void setAUXNUMBER01(Integer AUXNUMBER01);

	public Integer getAUXNUMBER02();

	public void setAUXNUMBER02(Integer AUXNUMBER02);

	public Integer getAUXNUMBER03();

	public void setAUXNUMBER03(Integer AUXNUMBER03);

	public Integer getAUXNUMBER04();

	public void setAUXNUMBER04(Integer AUXNUMBER04);

	public Integer getAUXNUMBER05();

	public void setAUXNUMBER05(Integer AUXNUMBER05);

	public Integer getAUXNUMBER06();

	public void setAUXNUMBER06(Integer AUXNUMBER06);

	public Integer getAUXNUMBER07();

	public void setAUXNUMBER07(Integer AUXNUMBER07);

	public Integer getAUXNUMBER08();

	public void setAUXNUMBER08(Integer AUXNUMBER08);

	public Integer getAUXNUMBER09();

	public void setAUXNUMBER09(Integer AUXNUMBER08);

	public Integer getAUXNUMBER10();

	public void setAUXNUMBER10(Integer AUXNUMBER10);

	public Integer getAUXNUMBER11();

	public void setAUXNUMBER11(Integer AUXNUMBER11);

	public Integer getAUXNUMBER12();

	public void setAUXNUMBER12(Integer AUXNUMBER12);

	public Integer getAUXNUMBER13();

	public void setAUXNUMBER13(Integer AUXNUMBER13);

	public Integer getAUXNUMBER14();

	public void setAUXNUMBER14(Integer AUXNUMBER14);

	public Integer getAUXNUMBER15();

	public void setAUXNUMBER15(Integer AUXNUMBER15);

	public String getAUXFLAG01();

	public void setAUXFLAG01(String AUXFLAG01);

	public String getAUXFLAG02();

	public void setAUXFLAG02(String AUXFLAG02);

	public String getAUXFLAG03();

	public void setAUXFLAG03(String AUXFLAG03);

	public String getAUXFLAG04();

	public void setAUXFLAG04(String AUXFLAG04);

	public String getAUXFLAG05();

	public void setAUXFLAG05(String AUXFLAG05);

	public String getAUXFLAG06();

	public void setAUXFLAG06(String AUXFLAG06);

	public String getAUXFLAG07();

	public void setAUXFLAG07(String AUXFLAG07);

	public String getAUXFLAG08();

	public void setAUXFLAG08(String AUXFLAG08);

	public String getAUXFLAG09();

	public void setAUXFLAG09(String AUXFLAG09);

	public String getAUXFLAG10();

	public void setAUXFLAG10(String AUXFLAG10);

	public String getAUXFLAG11();

	public void setAUXFLAG11(String AUXFLAG11);

	public String getAUXFLAG12();

	public void setAUXFLAG12(String AUXFLAG12);

	public String getAUXFLAG13();

	public void setAUXFLAG13(String AUXFLAG13);

	public String getAUXFLAG14();

	public void setAUXFLAG14(String AUXFLAG14);

	public String getAUXFLAG15();

	public void setAUXFLAG15(String AUXFLAG15);

	public String getAUXLONGCHAR01();

	public void setAUXLONGCHAR01(String AUXLONGCHAR01);

	public String getAUXLONGCHAR02();

	public void setAUXLONGCHAR02(String AUXLONGCHAR02);

	public Integer getID_DISPONIBILIDAD();

	public void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD);

	public DisponibilidadDAO getDISPONIBILIDAD_SITIO();

	public Integer getID_DISPONIBILIDAD_SITIO();

	public String getHABILITADO_TEMATIKA();

	public void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA);

	public boolean getESTA_HABILITADO_TEMATIKA();

	public Double getPRECIO_ORIGINAL();

	public Double getPRECIO_CON_IMPUESTOS();

	public Double getPRECIO_CON_DESCUENTO();

	public Double getPRECIO_SITIO();

	public Double getPORCENTAJE_DESCUENTO();

	public Integer getLISTA_PVP();

	public Double getTASA_IMPUESTO_GENERAL();

	public Double getTASA_IMPUESTO_VIDEO();

	public boolean getTIENE_DESCUENTO();

	public Double getAHORRO();

	public Vector getAUTORES();

	public Vector getID_AUTORES();

	public Vector getPRODUCTORES();

	public Vector getPROTAGONISTAS();

	public Vector getDIRECTORES();

	public Vector getID_DIRECTORES();

	public java.sql.Timestamp getFECHA_ESTRENO();

	public Integer getALTO();

	public Integer getANCHO();

	public String getFORMATO();

	public String getIDIOMA_ORIGINAL();

	public Integer getPROFUNDIDAD();

	public String getTIPO_EDICION();

	public String getSUBTITULO();

	public String getTITULO_ORIGINAL();

	public Boolean getESTA_AGOTADO();

	public Integer getPAIS_PUBLICACION();

	public Integer getPAIS_IMPRESION();

	public Integer getANO_IMPRESION();

	public String getCODIGO_DISPONIBILIDAD_ONIX();

	public String getISBN();

	public String getCALIFICACION();

	public Integer getDURACION();

	public String getREGION();

	public String getGENERO();

	public String getAUDIO();

	public String getSINOPSIS();

	public String getTABLA_DE_CONTENIDO();

	public String getCRITICA();

	public String getDESCRIPCION_DEL_LECTOR();

	public String getPRIMER_CAPITULO();

	public String getINFORMACION_ADICIONAL();

	public String getINTRODUCCION();

	public Vector getARTICULOS_RECOMENDADOS();

	//public Vector getAUTORES_RECOMENDADOS();

	public Vector getTEMAS();

	public Vector getATRIBUTOS_DESTACADOS(boolean repetirInformacion, boolean agregarSecundarios, boolean agregarSinopsis);

	public Vector getATRIBUTOS_DESTACADOS(boolean repetirInformacion, boolean agregarSecundarios, boolean agregarSinopsis, boolean mejorarTitulo);

	public Vector getATRIBUTOS();

	public String getATRIBUTO_PRINCIPAL();

	public String getGrupoDescripcion();

	public String getFamiliaDescripcion();

	public String getSubFamiliaDescripcion();

	public String getUrlBusquedaXCategoria();

	public String getUrlBusquedaXAtributoPrincipal();

	public String getCategorizacion();

    /*url editorial*/
    public String getUrlEditorial();
    /*url editorial*/

}
