package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface ArticuloHome extends EJBHome {

	public Articulo create(Integer ID_ARTICULO, String TITULO, String CODIGO_PROVEEDOR, String DESCRIPCION, java.sql.Timestamp FECHA_ALTA, String IDIOMA, Integer PAGINAS, Integer PESO, Double PRECIO_VENTA_VIGENTE, Double PRECIO_COMPRA_VIGENTE, Integer DESDE_EDAD, Integer HASTA_EDAD, String MARCA, String AGOTADO, String ACTIVO, String ARCHIVO_EN_SITE, String ARCHIVO_IMAGEN, String ARCHIVO_CAPITULO, Integer ID_ARTICULO_SITE, String ID_TIPO_ARTICULO, String ID_MONEDA_COMPRA, String ID_MONEDA_VENTA, Integer ID_EDITOR, Integer ID_PROVEEDOR, Integer ID_COLECCION, String ID_IMPUESTO, String NOVEDAD, String STOCK, String ES_TEXTO, String ESTADO_INGRESO, Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, Integer CATEGORIA_FAMILIA, Integer CATEGORIA_SUBFAMILIA, Integer ID_ACTIVIDAD_IIBB, Integer ID_COEDITOR, Integer NRO_EDICION, String COLECCION_DIRECTOR, String COLECCION_SERIE, String COLECCION_NUMERO, Integer NRO_VOLUMEN, Integer TOTAL_VOLUMENES, String TRADUCTOR, String COMPILADOR, String ILUSTRADOR, String COD_EXT_VISUAL, String AUXVARCHAR01, String AUXVARCHAR02, String AUXVARCHAR03, String AUXVARCHAR04, String AUXVARCHAR05, String AUXVARCHAR06, String AUXVARCHAR07, String AUXVARCHAR08, String AUXVARCHAR09, String AUXVARCHAR10, String AUXVARCHAR11, String AUXVARCHAR12, String AUXVARCHAR13, String AUXVARCHAR14, String AUXVARCHAR15, Integer AUXNUMBER01, Integer AUXNUMBER02, Integer AUXNUMBER03, Integer AUXNUMBER04, Integer AUXNUMBER05, Integer AUXNUMBER06, Integer AUXNUMBER07, Integer AUXNUMBER08, Integer AUXNUMBER09, Integer AUXNUMBER10, Integer AUXNUMBER11, Integer AUXNUMBER12, Integer AUXNUMBER13, Integer AUXNUMBER14, Integer AUXNUMBER15, String AUXFLAG01, String AUXFLAG02, String AUXFLAG03, String AUXFLAG04, String AUXFLAG05, String AUXFLAG06, String AUXFLAG07, String AUXFLAG08, String AUXFLAG09, String AUXFLAG10, String AUXFLAG11, String AUXFLAG12, String AUXFLAG13, String AUXFLAG14, String AUXFLAG15, String AUXLONGCHAR01, String AUXLONGCHAR02, Integer ID_DISPONIBILIDAD, String HABILITADO_TEMATIKA) throws RemoteException, CreateException;

	public Articulo findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

}
