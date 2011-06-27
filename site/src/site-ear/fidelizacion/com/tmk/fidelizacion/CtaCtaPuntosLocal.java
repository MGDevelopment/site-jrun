package com.tmk.fidelizacion;

import javax.ejb.EJBLocalObject;

public interface CtaCtaPuntosLocal extends EJBLocalObject
{
	public Integer getID_SUCURSAL() ;
	public void setID_SUCURSAL(Integer ID_SUCURSAL) ;

	public Integer getID_CCPT() ;
	public void setID_CCPT(Integer ID_CCPT) ;

	public String getCECO_NIV_01() ;
	public void setCECO_NIV_01(String CECO_NIV_01) ;

	public String getCECO_NIV_02() ;
	public void setCECO_NIV_02(String CECO_NIV_02) ;

	public String getCECO_NIV_03() ;
	public void setCECO_NIV_03(String CECO_NIV_03) ;

	public String getCECO_NIV_04() ;
	public void setCECO_NIV_04(String CECO_NIV_04) ;

	public String getCECO_NIV_05() ;
	public void setCECO_NIV_05(String CECO_NIV_05) ;

	public String getMSEC_NIV_01() ;
	public void setMSEC_NIV_01(String MSEC_NIV_01) ;

	public String getMSEC_NIV_02() ;
	public void setMSEC_NIV_02(String MSEC_NIV_02) ;

	public String getMSEC_NIV_03() ;
	public void setMSEC_NIV_03(String MSEC_NIV_03) ;

	public String getMSEC_NIV_04() ;
	public void setMSEC_NIV_04(String MSEC_NIV_04) ;

	public String getMSEC_NIV_05() ;
	public void setMSEC_NIV_05(String MSEC_NIV_05) ;

	public Integer getID_SOCIO() ;
	public void setID_SOCIO(Integer ID_SOCIO) ;

	public Integer getID_SUCURSAL_SOCIO() ;
	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) ;

	public Integer getID_CUENTA() ;
	public void setID_CUENTA(Integer ID_CUENTA) ;

	public Integer getID_SUCURSAL_CUENTA() ;
	public void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA) ;

	public String getNRO_TARJETA() ;
	public void setNRO_TARJETA(String NRO_TARJETA) ;

	public Integer getID_CONCEPTO() ;
	public void setID_CONCEPTO(Integer ID_CONCEPTO) ;

	public Integer getID_REGLA() ;
	public void setID_REGLA(Integer ID_REGLA) ;

	public Integer getID_MOVIMIENTO() ;
	public void setID_MOVIMIENTO(Integer ID_MOVIMIENTO) ;

	public Integer getID_SUCURSAL_MOVIMIENTO() ;
	public void setID_SUCURSAL_MOVIMIENTO(Integer ID_SUCURSAL_MOVIMIENTO) ;

	public Integer getITEM() ;
	public void setITEM(Integer ITEM) ;

	public Integer getPUNTOS() ;
	public void setPUNTOS(Integer PUNTOS) ;

	public Double getIMPORTE_ADICIONAL() ;
	public void setIMPORTE_ADICIONAL(Double IMPORTE_ADICIONAL) ;

	public java.sql.Timestamp getFECHA_TRANSMISION() ;
	public void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION) ;

	public Integer getID_CUENTA_RELA() ;
	public void setID_CUENTA_RELA(Integer ID_CUENTA_RELA) ;

	public Integer getID_SUCURSAL_CUENTA_RELA() ;
	public void setID_SUCURSAL_CUENTA_RELA(Integer ID_SUCURSAL_CUENTA_RELA) ;

	public String getUSR_ALTA() ;
	public void setUSR_ALTA(String USR_ALTA) ;

	public java.sql.Timestamp getF_ALTA() ;
	public void setF_ALTA(java.sql.Timestamp F_ALTA) ;

	public String getUSR_MODI() ;
	public void setUSR_MODI(String USR_MODI) ;

	public java.sql.Timestamp getF_MODI() ;
	public void setF_MODI(java.sql.Timestamp F_MODI) ;

	public java.sql.Timestamp getFECHA() ;
	public void setFECHA(java.sql.Timestamp FECHA) ;

	public Integer getSALDO_X_APLICAR() ;
	public void setSALDO_X_APLICAR(Integer SALDO_X_APLICAR) ;

	public Integer getSIGNO_SALDO() ;
	public void setSIGNO_SALDO(Integer SIGNO_SALDO) ;

}


