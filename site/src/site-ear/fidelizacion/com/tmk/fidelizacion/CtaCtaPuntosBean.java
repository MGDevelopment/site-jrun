package com.tmk.fidelizacion;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public abstract class CtaCtaPuntosBean implements EntityBean
{
	private EntityContext context;

	public void ejbLoad() {
	}

	public void ejbStore() {
	}

	public void setEntityContext(EntityContext context) {
		this.context = context;
	}

	public void unsetEntityContext() throws EJBException {
		this.context = null;
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public CtaCtaPuntosPK ejbCreate(Integer ID_SUCURSAL, Integer ID_CCPT, String CECO_NIV_01, String CECO_NIV_02, String CECO_NIV_03, String CECO_NIV_04, String CECO_NIV_05, String MSEC_NIV_01, String MSEC_NIV_02, String MSEC_NIV_03, String MSEC_NIV_04, String MSEC_NIV_05, Integer ID_SOCIO, Integer ID_SUCURSAL_SOCIO, Integer ID_CUENTA, Integer ID_SUCURSAL_CUENTA, String NRO_TARJETA, Integer ID_CONCEPTO, Integer ID_REGLA, Integer ID_MOVIMIENTO, Integer ID_SUCURSAL_MOVIMIENTO, Integer ITEM, Integer PUNTOS, Double IMPORTE_ADICIONAL, java.sql.Timestamp FECHA_TRANSMISION, Integer ID_CUENTA_RELA, Integer ID_SUCURSAL_CUENTA_RELA, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, java.sql.Timestamp FECHA, Integer SALDO_X_APLICAR, Integer SIGNO_SALDO)throws CreateException {
		setID_SUCURSAL(ID_SUCURSAL);
		setID_CCPT(ID_CCPT);
		setCECO_NIV_01(CECO_NIV_01);
		setCECO_NIV_02(CECO_NIV_02);
		setCECO_NIV_03(CECO_NIV_03);
		setCECO_NIV_04(CECO_NIV_04);
		setCECO_NIV_05(CECO_NIV_05);
		setMSEC_NIV_01(MSEC_NIV_01);
		setMSEC_NIV_02(MSEC_NIV_02);
		setMSEC_NIV_03(MSEC_NIV_03);
		setMSEC_NIV_04(MSEC_NIV_04);
		setMSEC_NIV_05(MSEC_NIV_05);
		setID_SOCIO(ID_SOCIO);
		setID_SUCURSAL_SOCIO(ID_SUCURSAL_SOCIO);
		setID_CUENTA(ID_CUENTA);
		setID_SUCURSAL_CUENTA(ID_SUCURSAL_CUENTA);
		setNRO_TARJETA(NRO_TARJETA);
		setID_CONCEPTO(ID_CONCEPTO);
		setID_REGLA(ID_REGLA);
		setID_MOVIMIENTO(ID_MOVIMIENTO);
		setID_SUCURSAL_MOVIMIENTO(ID_SUCURSAL_MOVIMIENTO);
		setITEM(ITEM);
		setPUNTOS(PUNTOS);
		setIMPORTE_ADICIONAL(IMPORTE_ADICIONAL);
		setFECHA_TRANSMISION(FECHA_TRANSMISION);
		setID_CUENTA_RELA(ID_CUENTA_RELA);
		setID_SUCURSAL_CUENTA_RELA(ID_SUCURSAL_CUENTA_RELA);
		setUSR_ALTA(USR_ALTA);
		setF_ALTA(F_ALTA);
		setUSR_MODI(USR_MODI);
		setF_MODI(F_MODI);
		setFECHA(FECHA);
		setSALDO_X_APLICAR(SALDO_X_APLICAR);
		setSIGNO_SALDO(SIGNO_SALDO);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL, Integer ID_CCPT, String CECO_NIV_01, String CECO_NIV_02, String CECO_NIV_03, String CECO_NIV_04, String CECO_NIV_05, String MSEC_NIV_01, String MSEC_NIV_02, String MSEC_NIV_03, String MSEC_NIV_04, String MSEC_NIV_05, Integer ID_SOCIO, Integer ID_SUCURSAL_SOCIO, Integer ID_CUENTA, Integer ID_SUCURSAL_CUENTA, String NRO_TARJETA, Integer ID_CONCEPTO, Integer ID_REGLA, Integer ID_MOVIMIENTO, Integer ID_SUCURSAL_MOVIMIENTO, Integer ITEM, Integer PUNTOS, Double IMPORTE_ADICIONAL, java.sql.Timestamp FECHA_TRANSMISION, Integer ID_CUENTA_RELA, Integer ID_SUCURSAL_CUENTA_RELA, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, java.sql.Timestamp FECHA, Integer SALDO_X_APLICAR, Integer SIGNO_SALDO) {
	}

	// cmp field methods
	public abstract Integer getID_SUCURSAL();
	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getID_CCPT();
	public abstract void setID_CCPT(Integer ID_CCPT);

	public abstract String getCECO_NIV_01();
	public abstract void setCECO_NIV_01(String CECO_NIV_01);

	public abstract String getCECO_NIV_02();
	public abstract void setCECO_NIV_02(String CECO_NIV_02);

	public abstract String getCECO_NIV_03();
	public abstract void setCECO_NIV_03(String CECO_NIV_03);

	public abstract String getCECO_NIV_04();
	public abstract void setCECO_NIV_04(String CECO_NIV_04);

	public abstract String getCECO_NIV_05();
	public abstract void setCECO_NIV_05(String CECO_NIV_05);

	public abstract String getMSEC_NIV_01();
	public abstract void setMSEC_NIV_01(String MSEC_NIV_01);

	public abstract String getMSEC_NIV_02();
	public abstract void setMSEC_NIV_02(String MSEC_NIV_02);

	public abstract String getMSEC_NIV_03();
	public abstract void setMSEC_NIV_03(String MSEC_NIV_03);

	public abstract String getMSEC_NIV_04();
	public abstract void setMSEC_NIV_04(String MSEC_NIV_04);

	public abstract String getMSEC_NIV_05();
	public abstract void setMSEC_NIV_05(String MSEC_NIV_05);

	public abstract Integer getID_SOCIO();
	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_SUCURSAL_SOCIO();
	public abstract void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public abstract Integer getID_CUENTA();
	public abstract void setID_CUENTA(Integer ID_CUENTA);

	public abstract Integer getID_SUCURSAL_CUENTA();
	public abstract void setID_SUCURSAL_CUENTA(Integer ID_SUCURSAL_CUENTA);

	public abstract String getNRO_TARJETA();
	public abstract void setNRO_TARJETA(String NRO_TARJETA);

	public abstract Integer getID_CONCEPTO();
	public abstract void setID_CONCEPTO(Integer ID_CONCEPTO);

	public abstract Integer getID_REGLA();
	public abstract void setID_REGLA(Integer ID_REGLA);

	public abstract Integer getID_MOVIMIENTO();
	public abstract void setID_MOVIMIENTO(Integer ID_MOVIMIENTO);

	public abstract Integer getID_SUCURSAL_MOVIMIENTO();
	public abstract void setID_SUCURSAL_MOVIMIENTO(Integer ID_SUCURSAL_MOVIMIENTO);

	public abstract Integer getITEM();
	public abstract void setITEM(Integer ITEM);

	public abstract Integer getPUNTOS();
	public abstract void setPUNTOS(Integer PUNTOS);

	public abstract Double getIMPORTE_ADICIONAL();
	public abstract void setIMPORTE_ADICIONAL(Double IMPORTE_ADICIONAL);

	public abstract java.sql.Timestamp getFECHA_TRANSMISION();
	public abstract void setFECHA_TRANSMISION(java.sql.Timestamp FECHA_TRANSMISION);

	public abstract Integer getID_CUENTA_RELA();
	public abstract void setID_CUENTA_RELA(Integer ID_CUENTA_RELA);

	public abstract Integer getID_SUCURSAL_CUENTA_RELA();
	public abstract void setID_SUCURSAL_CUENTA_RELA(Integer ID_SUCURSAL_CUENTA_RELA);

	public abstract String getUSR_ALTA();
	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract java.sql.Timestamp getF_ALTA();
	public abstract void setF_ALTA(java.sql.Timestamp F_ALTA);

	public abstract String getUSR_MODI();
	public abstract void setUSR_MODI(String USR_MODI);

	public abstract java.sql.Timestamp getF_MODI();
	public abstract void setF_MODI(java.sql.Timestamp F_MODI);

	public abstract java.sql.Timestamp getFECHA();
	public abstract void setFECHA(java.sql.Timestamp FECHA);

	public abstract Integer getSALDO_X_APLICAR();
	public abstract void setSALDO_X_APLICAR(Integer SALDO_X_APLICAR);

	public abstract Integer getSIGNO_SALDO();
	public abstract void setSIGNO_SALDO(Integer SIGNO_SALDO);

}


