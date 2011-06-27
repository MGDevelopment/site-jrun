package com.tmk.orden;

import javax.ejb.EJBLocalObject;

public interface CarritoCompraLocal extends EJBLocalObject {

	public Integer getID_SUCURSAL_SOCIO();

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public Integer getID_ARTICULO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public Integer getCANTIDAD();

	public void setCANTIDAD(Integer CANTIDAD);

	public java.util.Date getFECHA();

	public void setFECHA(java.util.Date FECHA);

}


