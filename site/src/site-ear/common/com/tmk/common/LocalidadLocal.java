package com.tmk.common;

import javax.ejb.EJBLocalObject;

public interface LocalidadLocal extends EJBLocalObject {

	public Integer getID_PAIS();

	public void setID_PAIS(Integer ID_PAIS);

	public Integer getID_PROVINCIA();

	public void setID_PROVINCIA(Integer ID_PROVINCIA);

	public Integer getID_LOCALIDAD();

	public void setID_LOCALIDAD(Integer ID_LOCALIDAD);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public String getHABILITADO_TEMATIKA();

	public void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA);

}


