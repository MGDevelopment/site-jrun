package com.tmk.common;

import javax.ejb.EJBLocalObject;

public interface PaisLocal extends EJBLocalObject {

	public Integer getID_PAIS();

	public void setID_PAIS(Integer ID_PAIS);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public String getHABILITADO_TEMATIKA();

	public void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA);

}


