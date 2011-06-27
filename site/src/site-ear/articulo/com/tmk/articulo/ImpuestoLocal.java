package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface ImpuestoLocal extends EJBLocalObject {

	public String getID_IMPUESTO();

	public void setID_IMPUESTO(String ID_IMPUESTO);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public String getCUENTA_MASCARA();

	public void setCUENTA_MASCARA(String CUENTA_MASCARA);

	public String getANULADO();

	public void setANULADO(String ANULADO);

}


