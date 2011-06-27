package com.tmk.common;

import javax.ejb.EJBLocalObject;

public interface MetodoDeEnvioLocal extends EJBLocalObject {

	public Integer getID_METODO_ENVIO();

	public void setID_METODO_ENVIO(Integer ID_METODO_ENVIO);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public String getURL();

	public void setURL(String URL);

	public String getHABILITADO();

	public void setHABILITADO(String HABILITADO);

}


