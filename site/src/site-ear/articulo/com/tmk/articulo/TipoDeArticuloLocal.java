package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface TipoDeArticuloLocal extends EJBLocalObject {

	public String getID_TIPO_ARTICULO();

	public void setID_TIPO_ARTICULO(String ID_TIPO_ARTICULO);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public String getCUENTA_MASCARA();

	public void setCUENTA_MASCARA(String CUENTA_MASCARA);

}


