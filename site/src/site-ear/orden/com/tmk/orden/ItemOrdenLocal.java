package com.tmk.orden;

import javax.ejb.EJBLocalObject;

public interface ItemOrdenLocal extends EJBLocalObject {

	public Integer getID_ORDEN();

	public void setID_ORDEN(Integer ID_ORDEN);

	public Integer getID_ARTICULO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public Integer getCANTIDAD();

	public void setCANTIDAD(Integer CANTIDAD);

	public Double getPRECIO_ORIGINAL();

	public void setPRECIO_ORIGINAL(Double PRECIO_ORIGINAL);

	public Integer getID_PAPEL_REGALO();

	public void setID_PAPEL_REGALO(Integer ID_PAPEL_REGALO);

	public Double getPRECIO_UNITARIO();

	public void setPRECIO_UNITARIO(Double PRECIO_UNITARIO);

	public Double getPRECIO_DESCUENTO();

	public void setPRECIO_DESCUENTO(Double PRECIO_DESCUENTO);

	public Double getPRECIO_PROMOCION();

	public void setPRECIO_PROMOCION(Double PRECIO_PROMOCION);

	public Integer getID_LISTA_PVP();

	public void setID_LISTA_PVP(Integer ID_LISTA_PVP);

	public String getESTADO();

	public void setESTADO(String ESTADO);

	public Integer getID_PROMOCION();

	public void setID_PROMOCION(Integer ID_PROMOCION);

	public Double getPRECIO_PROMOCION_SIN_IMPUESTOS();

	public void setPRECIO_PROMOCION_SIN_IMPUESTOS(Double PRECIO_PROMOCION_SIN_IMPUESTOS);

	public Integer getID_ARTICULO_MOL();

	public void setID_ARTICULO_MOL(Integer ID_ARTICULO_MOL);

	public Long getITEM();

	public void setITEM(Long ITEM);

	public Integer getID_PROMOCION2();

	public void setID_PROMOCION2(Integer ID_PROMOCION2);
	
	public Integer getID_PROMOCION3();

	public void setID_PROMOCION3(Integer ID_PROMOCION3);
	
	public Integer getID_PROMOCION4();

	public void setID_PROMOCION4(Integer ID_PROMOCION4);
	
	public Integer getID_PROMOCION5();

	public void setID_PROMOCION5(Integer ID_PROMOCION5);
	
	public Integer getID_CAMPAIGN();

	public void setID_CAMPAIGN(Integer ID_CAMPAIGN);
}


