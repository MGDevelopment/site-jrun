package com.tmk.admin;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface TarjetaVerificada extends EJBObject {

	public Integer getID() throws RemoteException;

	public void setID(Integer ID) throws RemoteException;

	public byte[] getNRO_TARJETA() throws RemoteException;

	public void setNRO_TARJETA(byte[] NRO_TARJETA) throws RemoteException;

	public String getNOMBRES_SOCIO() throws RemoteException;

	public void setNOMBRES_SOCIO(String NOMBRES_SOCIO) throws RemoteException;

	public String getAPELLIDOS_SOCIO() throws RemoteException;

	public void setAPELLIDOS_SOCIO(String APELLIDOS_SOCIO) throws RemoteException;

	public String getE_MAIL() throws RemoteException;

	public void setE_MAIL(String E_MAIL) throws RemoteException;

	public String getCALLE_ENVIO() throws RemoteException;

	public void setCALLE_ENVIO(String CALLE_ENVIO) throws RemoteException;

	public Integer getNUMERO_ENVIO() throws RemoteException;

	public void setNUMERO_ENVIO(Integer NUMERO_ENVIO) throws RemoteException;

	public String getEDIFICIO_ENVIO() throws RemoteException;

	public void setEDIFICIO_ENVIO(String EDIFICIO_ENVIO) throws RemoteException;

	public Integer getPISO_ENVIO() throws RemoteException;

	public void setPISO_ENVIO(Integer PISO_ENVIO) throws RemoteException;

	public String getDEPTO_ENVIO() throws RemoteException;

	public void setDEPTO_ENVIO(String DEPTO_ENVIO) throws RemoteException;

	public String getCP_ENVIO() throws RemoteException;

	public void setCP_ENVIO(String CP_ENVIO) throws RemoteException;

	public Integer getID_PAIS_ENVIO() throws RemoteException;

	public void setID_PAIS_ENVIO(Integer ID_PAIS_ENVIO) throws RemoteException;

	public Integer getID_PROVINCIA_ENVIO() throws RemoteException;

	public void setID_PROVINCIA_ENVIO(Integer ID_PROVINCIA_ENVIO) throws RemoteException;

	public Integer getID_LOCALIDAD_ENVIO() throws RemoteException;

	public void setID_LOCALIDAD_ENVIO(Integer ID_LOCALIDAD_ENVIO) throws RemoteException;

	public String getCALLE_FACT() throws RemoteException;

	public void setCALLE_FACT(String CALLE_FACT) throws RemoteException;

	public Integer getNUMERO_FACT() throws RemoteException;

	public void setNUMERO_FACT(Integer NUMERO_FACT) throws RemoteException;

	public String getEDIFICIO_FACT() throws RemoteException;

	public void setEDIFICIO_FACT(String EDIFICIO_FACT) throws RemoteException;

	public Integer getPISO_FACT() throws RemoteException;

	public void setPISO_FACT(Integer PISO_FACT) throws RemoteException;

	public String getDEPTO_FACT() throws RemoteException;

	public void setDEPTO_FACT(String DEPTO_FACT) throws RemoteException;

	public String getCP_FACT() throws RemoteException;

	public void setCP_FACT(String CP_FACT) throws RemoteException;

	public Integer getID_PAIS_FACT() throws RemoteException;

	public void setID_PAIS_FACT(Integer ID_PAIS_FACT) throws RemoteException;

	public Integer getID_PROVINCIA_FACT() throws RemoteException;

	public void setID_PROVINCIA_FACT(Integer ID_PROVINCIA_FACT) throws RemoteException;

	public Integer getID_LOCALIDAD_FACT() throws RemoteException;

	public void setID_LOCALIDAD_FACT(Integer ID_LOCALIDAD_FACT) throws RemoteException;

	public Integer getNIVEL_RIESGO() throws RemoteException;

	public void setNIVEL_RIESGO(Integer NIVEL_RIESGO) throws RemoteException;

	public String getCOMENTARIOS() throws RemoteException;

	public void setCOMENTARIOS(String COMENTARIOS) throws RemoteException;

}


