package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface ItemOrdenLocalHome extends EJBLocalHome {

	public ItemOrdenLocal create(Integer ID_ORDEN, Integer ID_ARTICULO, Integer CANTIDAD, Double PRECIO_ORIGINAL, Integer ID_PAPEL_REGALO, Double PRECIO_UNITARIO, Double PRECIO_DESCUENTO, Double PRECIO_PROMOCION, Integer ID_LISTA_PVP, String ESTADO, Integer ID_PROMOCION, Double PRECIO_PROMOCION_SIN_IMPUESTOS, Integer ID_ARTICULO_MOL, Long ITEM, Integer ID_PROMOCION2, Integer ID_PROMOCION3, Integer ID_PROMOCION4, Integer ID_PROMOCION5, Integer ID_CAMPAIGN) throws CreateException;

	public ItemOrdenLocal findByPrimaryKey(ItemOrdenPK pk) throws FinderException;

	public Collection findArticulos(Integer ID_ORDEN) throws FinderException;
}


