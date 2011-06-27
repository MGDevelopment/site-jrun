package com.tmk.orden;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Orden extends EJBObject {

	public Integer getID_ORDEN() throws RemoteException;

	public void setID_ORDEN(Integer ID_ORDEN) throws RemoteException;

	public abstract java.sql.Timestamp getFECHA() throws RemoteException;

	public abstract void setFECHA(java.sql.Timestamp FECHA) throws RemoteException;

	public void setNETO(Double NETO) throws RemoteException;

	public String getESTADO() throws RemoteException;

	public void setESTADO(String ESTADO) throws RemoteException;

	public Integer getID_SUCURSAL_SOCIO() throws RemoteException;

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Double getTOTAL() throws RemoteException;

	public void setTOTAL(Double TOTAL) throws RemoteException;

	public String getTELEFONO() throws RemoteException;

	public void setTELEFONO(String TELEFONO) throws RemoteException;

	public String getHR_CONTACTO() throws RemoteException;

	public void setHR_CONTACTO(String HR_CONTACTO) throws RemoteException;

	public String getCOMENTARIOS() throws RemoteException;

	public void setCOMENTARIOS(String COMENTARIOS) throws RemoteException;

	public Integer getNIVEL_RIESGO() throws RemoteException;

	public void setNIVEL_RIESGO(Integer NIVEL_RIESGO) throws RemoteException;

	public String getMOTIVO_RIESGO() throws RemoteException;

	public void setMOTIVO_RIESGO(String MOTIVO_RIESGO) throws RemoteException;

	public Integer getID_ALIANZA() throws RemoteException;

	public void setID_ALIANZA(Integer ID_ALIANZA) throws RemoteException;

	public Integer getID_SECCION() throws RemoteException;

	public void setID_SECCION(Integer ID_SECCION) throws RemoteException;

	public Integer getID_DOMINIO() throws RemoteException;

	public void setID_DOMINIO(Integer ID_DOMINIO) throws RemoteException;

	public Integer getID_ORDEN_MOTIVO_RIESGO() throws RemoteException;

	public void setID_ORDEN_MOTIVO_RIESGO(Integer ID_ORDEN_MOTIVO_RIESGO) throws RemoteException;

	public String getNOMBRES_RECEPTOR() throws RemoteException;

	public void setNOMBRES_RECEPTOR(String NOMBRES_RECEPTOR) throws RemoteException;

	public String getAPELLIDOS_RECEPTOR() throws RemoteException;

	public void setAPELLIDOS_RECEPTOR(String APELLIDOS_RECEPTOR) throws RemoteException;

	public String getCUPON() throws RemoteException;

	public void setCUPON(String CUPON) throws RemoteException;

	public String getCPF_CNPJ();

	public void setCPF_CNPJ(String CPF_CNPJ);

	public Integer getNRO_DOC_RECEPTOR();

	public void setNRO_DOC_RECEPTOR(Integer NRO_DOC_RECEPTOR);

	public String getTIPO_DOC_RECEPTOR();

	public void setTIPO_DOC_RECEPTOR(String TIPO_DOC_RECEPTOR);

	public String getRANGO_HORARIO_RECEPTOR();

	public void setRANGO_HORARIO_RECEPTOR(String RANGO_HORARIO_RECEPTOR);
	
	public java.sql.Timestamp getFAC_ELC_ENV();
	
	public void  setFAC_ELC_ENV(java.sql.Timestamp FAC_ELC_ENV);

}


