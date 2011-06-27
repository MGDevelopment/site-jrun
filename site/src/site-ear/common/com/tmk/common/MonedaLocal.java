package com.tmk.common;

import javax.ejb.EJBLocalObject;

public interface MonedaLocal extends EJBLocalObject {

	public String getID_MONEDA();

	public void setID_MONEDA(String ID_MONEDA);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

}


