package com.tmk.articulo;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Articulo extends EJBObject {

	public Integer getID_ARTICULO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public String getTITULO() throws RemoteException;

	public void setTITULO(String TITULO) throws RemoteException;

	public String getCODIGO_PROVEEDOR() throws RemoteException;

	public void setCODIGO_PROVEEDOR(String CODIGO_PROVEEDOR) throws RemoteException;

	public String getDESCRIPCION() throws RemoteException;

	public void setDESCRIPCION(String DESCRIPCION) throws RemoteException;

	public java.sql.Timestamp getFECHA_ALTA() throws RemoteException;

	public void setFECHA_ALTA(java.sql.Timestamp FECHA_ALTA) throws RemoteException;

	public String getIDIOMA() throws RemoteException;

	public void setIDIOMA(String IDIOMA) throws RemoteException;

	public Integer getPAGINAS() throws RemoteException;

	public void setPAGINAS(Integer PAGINAS) throws RemoteException;

	public Integer getPESO() throws RemoteException;

	public void setPESO(Integer PESO) throws RemoteException;

	public Double getPRECIO_VENTA_VIGENTE() throws RemoteException;

	public void setPRECIO_VENTA_VIGENTE(Double PRECIO_VENTA_VIGENTE) throws RemoteException;

	public Double getPRECIO_COMPRA_VIGENTE() throws RemoteException;

	public void setPRECIO_COMPRA_VIGENTE(Double PRECIO_COMPRA_VIGENTE) throws RemoteException;

	public Integer getDESDE_EDAD() throws RemoteException;

	public void setDESDE_EDAD(Integer DESDE_EDAD) throws RemoteException;

	public Integer getHASTA_EDAD() throws RemoteException;

	public void setHASTA_EDAD(Integer HASTA_EDAD) throws RemoteException;

	public String getMARCA() throws RemoteException;

	public void setMARCA(String MARCA) throws RemoteException;

	public String getAGOTADO() throws RemoteException;

	public void setAGOTADO(String AGOTADO) throws RemoteException;

	public String getACTIVO() throws RemoteException;

	public void setACTIVO(String ACTIVO) throws RemoteException;

	public String getARCHIVO_EN_SITE() throws RemoteException;

	public void setARCHIVO_EN_SITE(String ARCHIVO_EN_SITE) throws RemoteException;

	public String getARCHIVO_IMAGEN() throws RemoteException;

	public void setARCHIVO_IMAGEN(String ARCHIVO_IMAGEN) throws RemoteException;

	public String getARCHIVO_CAPITULO() throws RemoteException;

	public void setARCHIVO_CAPITULO(String ARCHIVO_CAPITULO) throws RemoteException;

	public Integer getID_ARTICULO_SITE() throws RemoteException;

	public void setID_ARTICULO_SITE(Integer ID_ARTICULO_SITE) throws RemoteException;

	public String getID_TIPO_ARTICULO() throws RemoteException;

	public void setID_TIPO_ARTICULO(String ID_TIPO_ARTICULO) throws RemoteException;

	public String getID_MONEDA_COMPRA() throws RemoteException;

	public void setID_MONEDA_COMPRA(String ID_MONEDA_COMPRA) throws RemoteException;

	public String getID_MONEDA_VENTA() throws RemoteException;

	public void setID_MONEDA_VENTA(String ID_MONEDA_VENTA) throws RemoteException;

	public Integer getID_EDITOR() throws RemoteException;

	public void setID_EDITOR(Integer ID_EDITOR) throws RemoteException;

	public Integer getID_PROVEEDOR() throws RemoteException;

	public void setID_PROVEEDOR(Integer ID_PROVEEDOR) throws RemoteException;

	public Integer getID_COLECCION() throws RemoteException;

	public void setID_COLECCION(Integer ID_COLECCION) throws RemoteException;

	public String getID_IMPUESTO() throws RemoteException;

	public void setID_IMPUESTO(String ID_IMPUESTO) throws RemoteException;

	public String getNOVEDAD() throws RemoteException;

	public void setNOVEDAD(String NOVEDAD) throws RemoteException;

	public String getSTOCK() throws RemoteException;

	public void setSTOCK(String STOCK) throws RemoteException;

	public String getES_TEXTO() throws RemoteException;

	public void setES_TEXTO(String ES_TEXTO) throws RemoteException;

	public String getESTADO_INGRESO() throws RemoteException;

	public void setESTADO_INGRESO(String ESTADO_INGRESO) throws RemoteException;

	public Integer getCATEGORIA_SECCION() throws RemoteException;

	public void setCATEGORIA_SECCION(Integer CATEGORIA_SECCION) throws RemoteException;

	public Integer getCATEGORIA_GRUPO() throws RemoteException;

	public void setCATEGORIA_GRUPO(Integer CATEGORIA_GRUPO) throws RemoteException;

	public Integer getCATEGORIA_FAMILIA() throws RemoteException;

	public void setCATEGORIA_FAMILIA(Integer CATEGORIA_FAMILIA) throws RemoteException;

	public Integer getCATEGORIA_SUBFAMILIA() throws RemoteException;

	public void setCATEGORIA_SUBFAMILIA(Integer CATEGORIA_SUBFAMILIA) throws RemoteException;

	public Integer getID_ACTIVIDAD_IIBB() throws RemoteException;

	public void setID_ACTIVIDAD_IIBB(Integer ID_ACTIVIDAD_IIBB) throws RemoteException;

	public Integer getID_COEDITOR() throws RemoteException;

	public void setID_COEDITOR(Integer ID_COEDITOR) throws RemoteException;

	public Integer getNRO_EDICION() throws RemoteException;

	public void setNRO_EDICION(Integer NRO_EDICION) throws RemoteException;

	public String getCOLECCION_DIRECTOR() throws RemoteException;

	public void setCOLECCION_DIRECTOR(String COLECCION_DIRECTOR) throws RemoteException;

	public String getCOLECCION_SERIE() throws RemoteException;

	public void setCOLECCION_SERIE(String COLECCION_SERIE) throws RemoteException;

	public String getCOLECCION_NUMERO() throws RemoteException;

	public void setCOLECCION_NUMERO(String COLECCION_NUMERO) throws RemoteException;

	public Integer getNRO_VOLUMEN() throws RemoteException;

	public void setNRO_VOLUMEN(Integer NRO_VOLUMEN) throws RemoteException;

	public Integer getTOTAL_VOLUMENES() throws RemoteException;

	public void setTOTAL_VOLUMENES(Integer TOTAL_VOLUMENES) throws RemoteException;

	public String getTRADUCTOR() throws RemoteException;

	public void setTRADUCTOR(String TRADUCTOR) throws RemoteException;

	public String getCOMPILADOR() throws RemoteException;

	public void setCOMPILADOR(String COMPILADOR) throws RemoteException;

	public String getILUSTRADOR() throws RemoteException;

	public void setILUSTRADOR(String ILUSTRADOR) throws RemoteException;

	public String getCOD_EXT_VISUAL() throws RemoteException;

	public void setCOD_EXT_VISUAL(String COD_EXT_VISUAL) throws RemoteException;

	public String getAUXVARCHAR01() throws RemoteException;

	public void setAUXVARCHAR01(String AUXVARCHAR01) throws RemoteException;

	public String getAUXVARCHAR02() throws RemoteException;

	public void setAUXVARCHAR02(String AUXVARCHAR02) throws RemoteException;

	public String getAUXVARCHAR03() throws RemoteException;

	public void setAUXVARCHAR03(String AUXVARCHAR03) throws RemoteException;

	public String getAUXVARCHAR04() throws RemoteException;

	public void setAUXVARCHAR04(String AUXVARCHAR04) throws RemoteException;

	public String getAUXVARCHAR05() throws RemoteException;

	public void setAUXVARCHAR05(String AUXVARCHAR05) throws RemoteException;

	public String getAUXVARCHAR06() throws RemoteException;

	public void setAUXVARCHAR06(String AUXVARCHAR06) throws RemoteException;

	public String getAUXVARCHAR07() throws RemoteException;

	public void setAUXVARCHAR07(String AUXVARCHAR07) throws RemoteException;

	public String getAUXVARCHAR08() throws RemoteException;

	public void setAUXVARCHAR08(String AUXVARCHAR08) throws RemoteException;

	public String getAUXVARCHAR09() throws RemoteException;

	public void setAUXVARCHAR09(String AUXVARCHAR09) throws RemoteException;

	public String getAUXVARCHAR10() throws RemoteException;

	public void setAUXVARCHAR10(String AUXVARCHAR10) throws RemoteException;

	public String getAUXVARCHAR11() throws RemoteException;

	public void setAUXVARCHAR11(String AUXVARCHAR11) throws RemoteException;

	public String getAUXVARCHAR12() throws RemoteException;

	public void setAUXVARCHAR12(String AUXVARCHAR12) throws RemoteException;

	public String getAUXVARCHAR13() throws RemoteException;

	public void setAUXVARCHAR13(String AUXVARCHAR13) throws RemoteException;

	public String getAUXVARCHAR14() throws RemoteException;

	public void setAUXVARCHAR14(String AUXVARCHAR14) throws RemoteException;

	public String getAUXVARCHAR15() throws RemoteException;

	public void setAUXVARCHAR15(String AUXVARCHAR15) throws RemoteException;

	public Integer getAUXNUMBER01() throws RemoteException;

	public Integer getAUXNUMBER02() throws RemoteException;

	public void setAUXNUMBER02(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER03() throws RemoteException;

	public void setAUXNUMBER03(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER04() throws RemoteException;

	public void setAUXNUMBER04(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER05() throws RemoteException;

	public void setAUXNUMBER05(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER06() throws RemoteException;

	public void setAUXNUMBER06(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER07() throws RemoteException;

	public void setAUXNUMBER07(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER08() throws RemoteException;

	public void setAUXNUMBER08(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER09() throws RemoteException;

	public void setAUXNUMBER09(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER10() throws RemoteException;

	public void setAUXNUMBER10(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER11() throws RemoteException;

	public void setAUXNUMBER11(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER12() throws RemoteException;

	public void setAUXNUMBER12(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER13() throws RemoteException;

	public void setAUXNUMBER13(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER14() throws RemoteException;

	public void setAUXNUMBER14(Integer AUXNUMBER01) throws RemoteException;

	public Integer getAUXNUMBER15() throws RemoteException;

	public void setAUXNUMBER15(Integer AUXNUMBER01) throws RemoteException;

	public String getAUXFLAG01() throws RemoteException;

	public void setAUXFLAG01(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG02() throws RemoteException;

	public void setAUXFLAG02(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG03() throws RemoteException;

	public void setAUXFLAG03(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG04() throws RemoteException;

	public void setAUXFLAG04(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG05() throws RemoteException;

	public void setAUXFLAG05(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG06() throws RemoteException;

	public void setAUXFLAG06(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG07() throws RemoteException;

	public void setAUXFLAG07(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG08() throws RemoteException;

	public void setAUXFLAG08(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG09() throws RemoteException;

	public void setAUXFLAG09(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG10() throws RemoteException;

	public void setAUXFLAG10(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG11() throws RemoteException;

	public void setAUXFLAG11(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG12() throws RemoteException;

	public void setAUXFLAG12(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG13() throws RemoteException;

	public void setAUXFLAG13(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG14() throws RemoteException;

	public void setAUXFLAG14(String AUXFLAG01) throws RemoteException;

	public String getAUXFLAG15() throws RemoteException;

	public void setAUXFLAG15(String AUXFLAG01) throws RemoteException;

	public String getAUXLONGCHAR01() throws RemoteException;

	public void setAUXLONGCHAR01(String AUXLONGCHAR01) throws RemoteException;

	public String getAUXLONGCHAR02() throws RemoteException;

	public void setAUXLONGCHAR02(String AUXLONGCHAR01) throws RemoteException;

	public void setAUXNUMBER01(Integer AUXNUMBER01) throws RemoteException;

	public Integer getID_DISPONIBILIDAD() throws RemoteException;

	public void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD) throws RemoteException;

	public String getHABILITADO_TEMATIKA() throws RemoteException;

	public void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA) throws RemoteException;

}
