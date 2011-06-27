package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class ItemOrdenBean implements EntityBean {

	private EntityContext context;

	public void ejbLoad() {
	}

	public void ejbStore() {
	}

	public void setEntityContext(EntityContext context) {
		this.context = context;
	}

	public void unsetEntityContext() throws EJBException {
		this.context = null;
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	} 

	public ItemOrdenPK ejbCreate(Integer ID_ORDEN, Integer ID_ARTICULO, Integer CANTIDAD, Double PRECIO_ORIGINAL, Integer ID_PAPEL_REGALO, Double PRECIO_UNITARIO, Double PRECIO_DESCUENTO, Double PRECIO_PROMOCION, Integer ID_LISTA_PVP, String ESTADO, Integer ID_PROMOCION, Double PRECIO_PROMOCION_SIN_IMPUESTOS, Integer ID_ARTICULO_MOL, Long ITEM, Integer ID_PROMOCION2, Integer ID_PROMOCION3, Integer ID_PROMOCION4, Integer ID_PROMOCION5, Integer ID_CAMPAIGN) throws CreateException {
		setID_ORDEN(ID_ORDEN);
		setID_ARTICULO(ID_ARTICULO);
		setCANTIDAD(CANTIDAD);
		setPRECIO_ORIGINAL(PRECIO_ORIGINAL);
		setID_PAPEL_REGALO(ID_PAPEL_REGALO);
		setPRECIO_UNITARIO(PRECIO_UNITARIO);
		setPRECIO_DESCUENTO(PRECIO_DESCUENTO);
		setPRECIO_PROMOCION(PRECIO_PROMOCION);
		setID_LISTA_PVP(ID_LISTA_PVP);
		setESTADO(ESTADO);
		setID_PROMOCION(ID_PROMOCION);
		setPRECIO_PROMOCION_SIN_IMPUESTOS(PRECIO_PROMOCION_SIN_IMPUESTOS);
		setID_ARTICULO_MOL(ID_ARTICULO_MOL);
		setITEM(ITEM);
		setID_PROMOCION2(ID_PROMOCION2);
		setID_PROMOCION3(ID_PROMOCION3);
		setID_PROMOCION4(ID_PROMOCION4);
		setID_PROMOCION5(ID_PROMOCION5);
		setID_CAMPAIGN(ID_CAMPAIGN);
		return null;
	}

	public void ejbPostCreate(Integer ID_ORDEN, Integer ID_ARTICULO, Integer CANTIDAD, Double PRECIO_ORIGINAL, Integer ID_PAPEL_REGALO, Double PRECIO_UNITARIO, Double PRECIO_DESCUENTO, Double PRECIO_PROMOCION, Integer ID_LISTA_PVP, String ESTADO, Integer ID_PROMOCION, Double PRECIO_PROMOCION_SIN_IMPUESTOS, Integer ID_ARTICULO_MOL, Long ITEM, Integer ID_PROMOCION2, Integer ID_PROMOCION3, Integer ID_PROMOCION4, Integer ID_PROMOCION5, Integer ID_CAMPAIGN) {
	}

	// cmp field methods
	public abstract Integer getID_ORDEN();

	public abstract void setID_ORDEN(Integer ID_ORDEN);

	public abstract Integer getID_ARTICULO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract Integer getCANTIDAD();

	public abstract void setCANTIDAD(Integer CANTIDAD);

	public abstract Double getPRECIO_ORIGINAL();

	public abstract void setPRECIO_ORIGINAL(Double PRECIO_ORIGINAL);

	public abstract Integer getID_PAPEL_REGALO();

	public abstract void setID_PAPEL_REGALO(Integer ID_PAPEL_REGALO);

	public abstract Double getPRECIO_UNITARIO();

	public abstract void setPRECIO_UNITARIO(Double PRECIO_UNITARIO);

	public abstract Double getPRECIO_DESCUENTO();

	public abstract void setPRECIO_DESCUENTO(Double PRECIO_DESCUENTO);

	public abstract Double getPRECIO_PROMOCION();

	public abstract void setPRECIO_PROMOCION(Double PRECIO_PROMOCION);

	public abstract Integer getID_LISTA_PVP();

	public abstract void setID_LISTA_PVP(Integer ID_LISTA_PVP);

	public abstract String getESTADO();

	public abstract void setESTADO(String ESTADO);

	public abstract Integer getID_PROMOCION();

	public abstract void setID_PROMOCION(Integer ID_PROMOCION);

	public abstract Double getPRECIO_PROMOCION_SIN_IMPUESTOS();

	public abstract void setPRECIO_PROMOCION_SIN_IMPUESTOS(Double PRECIO_PROMOCION_SIN_IMPUESTOS);

	public abstract Integer getID_ARTICULO_MOL();

	public abstract void setID_ARTICULO_MOL(Integer ID_ARTICULO_MOL);

	public abstract Long getITEM();

	public abstract void setITEM(Long ITEM);
	
	public abstract Integer getID_PROMOCION2();

	public abstract void setID_PROMOCION2(Integer ID_PROMOCION2);
	
	public abstract Integer getID_PROMOCION3();

	public abstract void setID_PROMOCION3(Integer ID_PROMOCION3);
	
	public abstract Integer getID_PROMOCION4();

	public abstract void setID_PROMOCION4(Integer ID_PROMOCION4);
	
	public abstract Integer getID_PROMOCION5();

	public abstract void setID_PROMOCION5(Integer ID_PROMOCION5);
	
	public abstract Integer getID_CAMPAIGN();

	public abstract void setID_CAMPAIGN(Integer ID_CAMPAIGN);

}


