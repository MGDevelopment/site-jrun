package com.tmk.fidelizacion;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface CtaCtaPuntos extends EJBObject
{
	public Integer getID_SUCURSAL() throws RemoteException;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public Integer getID_CCPT() throws RemoteException;
	public void setID_CCPT(Integer ID_CCPT) throws RemoteException;

	public String getCECO_NIV_01() throws RemoteException;
	public void setCECO_NIV_01(String CECO_NIV_01) throws RemoteException;

	public String getCECO_NIV_02() throws RemoteException;
	public void setCECO_NIV_02(String CECO_NIV_02) throws RemoteException;

	public String getCECO_NIV_03() throws RemoteException;
	public void setCECO_NIV_03(String CECO_NIV_03) throws RemoteException;

	public String getCECO_NIV_04() throws RemoteException;
	public void setCECO_NIV_04(String CECO_NIV_04) throws RemoteException;

	public String getCECO_NIV_05() throws RemoteException;
	public void setCECO_NIV_05(String CECO_NIV_05) throws RemoteException;

	public String getMSEC_NIV_01() throws RemoteException;
	public void setMSEC_NIV_01(String MSEC_NIV_01) throws RemoteException;

	public String getMSEC_NIV_02() throws RemoteException;
	public void setMSEC_NIV_02(String MSEC_NIV_02) throws RemoteException;

	public String getMSEC_NIV_03() throws RemoteException;
	public void setMSEC_NIV_03(String MSEC_NIV_03) throws RemoteException;

	public String getMSEC_NIV_04() throws RemoteException;
	public void setMSEC_NIV_04(String MSEC_NIV_04) throws RemoteException;

	public String getMSEC_NIV_05() throws RemoteException;
	public void setMSEC_NIV_05(String MSEC_NIV_05) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;
	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Integer getID_SUCURSAL_SOCIO() throws RemoteException;
	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) throws RemoteException;

	public Integer getID_CUENTA() throws RemoteException;
	public void setID_CUENTA(Integer ID_CUENTA) throws RemoteException;

	public Integer getID_SUCURSAL_CUENTA() throws RemoteException;
	public void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA) throws RemoteException;

	public String getNRO_TARJETA() throws RemoteException;
	public void setNRO_TARJETA(String NRO_TARJETA) throws RemoteException;

	public Integer getID_CONCEPTO() throws RemoteException;
	public void setID_CONCEPTO(Integer ID_CONCEPTO) throws RemoteException;

	public Integer getID_REGLA() throws RemoteException;
	public void setID_REGLA(Integer ID_REGLA) throws RemoteException;

	public Integer getID_MOVIMIENTO() throws RemoteException;
	public void setID_MOVIMIENTO(Integer ID_MOVIMIENTO) throws RemoteException;

	public Integer getID_SUCURSAL_MOVIMIENTO() throws RemoteException;
	public void setID_SUCURSAL_MOVIMIENTO(Integer ID_SUCURSAL_MOVIMIENTO) throws RemoteException;

	public Integer getITEM() throws RemoteException;
	public void setITEM(Integer ITEM) throws RemoteException;

	public Integer getPUNTOS() throws RemoteException;
	public void setPUNTOS(Integer PUNTOS) throws RemoteException;

	public Double getIMPORTE_ADICIONAL() throws RemoteException;
	public void setIMPORTE_ADICIONAL(Double IMPORTE_ADICIONAL) throws RemoteException;

	public java.sql.Timestamp getFECHA_TRANSMISION() throws RemoteException;
	public void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION) throws RemoteException;

	public Integer getID_CUENTA_RELA() throws RemoteException;
	public void setID_CUENTA_RELA(Integer ID_CUENTA_REGLA) throws RemoteException;

	public Integer getID_SUCURSAL_CUENTA_RELA() throws RemoteException;
	public void setID_SUCURSAL_CUENTA_RELA(Integer ID_SUCURSAL_CUENTA_RELA) throws RemoteException;

	public String getUSR_ALTA() throws RemoteException;
	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public java.sql.Timestamp getF_ALTA() throws RemoteException;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;
	public void setUSR_MODI(String USR_MODI) throws RemoteException;

	public java.sql.Timestamp getF_MODI() throws RemoteException;
	public void setF_MODI(java.sql.Timestamp F_MODI) throws RemoteException;

	public java.sql.Timestamp getFECHA() throws RemoteException;
	public void setFECHA(java.sql.Timestamp FECHA) throws RemoteException;

	public Integer getSALDO_X_APLICAR() throws RemoteException;
	public void setSALDO_X_APLICAR(Integer SALDO_X_APLICAR) throws RemoteException;

	public Integer getSIGNO_SALDO() throws RemoteException;
	public void setSIGNO_SALDO(Integer SIGNO_SALDO) throws RemoteException;

}


