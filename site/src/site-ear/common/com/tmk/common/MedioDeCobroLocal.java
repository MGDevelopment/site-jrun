package com.tmk.common;

import javax.ejb.EJBLocalObject;

public interface MedioDeCobroLocal extends EJBLocalObject {

	public String getID_MEDIO_COBRO();

	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public String getTIPO();

	public void setTIPO(String TIPO);

	public String getHABILITADO_TEMATIKA();

	public void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA);
}


