package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class OrdenBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_ORDEN, java.sql.Timestamp FECHA, Double NETO, String ESTADO, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO,
	                         Double TOTAL, String TELEFONO, String HR_CONTACTO, String COMENTARIOS, Integer NIVEL_RIESGO, String MOTIVO_RIESGO,
	                         Integer ID_ALIANZA, Integer ID_SECCION, Integer ID_DOMINIO, Integer ID_ORDEN_MOTIVO_RIESGO, String NOMBRES_RECEPTOR,
	                         String APELLIDOS_RECEPTOR, String CUPON, String CPF_CNPJ,
	                         Integer NRO_DOC_RECEPTOR_AUT, String TIPO_DOC_RECEPTOR_AUT, String RANGO_HORARIO_RECEPTOR_AUT,
	                         java.sql.Timestamp FAC_ELC_ENV) throws CreateException {
		setID_ORDEN(ID_ORDEN);
		setFECHA(FECHA);
		setNETO(NETO);
		setESTADO(ESTADO);
		setID_SUCURSAL_SOCIO(ID_SUCURSAL_SOCIO);
		setID_SOCIO(ID_SOCIO);
		setTOTAL(TOTAL);
		setTELEFONO(TELEFONO);
		setHR_CONTACTO(HR_CONTACTO);
		setCOMENTARIOS(COMENTARIOS);
		setNIVEL_RIESGO(NIVEL_RIESGO);
		setMOTIVO_RIESGO(MOTIVO_RIESGO);
		setID_ALIANZA(ID_ALIANZA);
		setID_SECCION(ID_SECCION);
		setID_DOMINIO(ID_DOMINIO);
		setID_ORDEN_MOTIVO_RIESGO(ID_ORDEN_MOTIVO_RIESGO);
		setNOMBRES_RECEPTOR(NOMBRES_RECEPTOR);
		setAPELLIDOS_RECEPTOR(APELLIDOS_RECEPTOR);
		setCUPON(CUPON);
		setCPF_CNPJ(CPF_CNPJ);
		setNRO_DOC_RECEPTOR(NRO_DOC_RECEPTOR_AUT);
		setTIPO_DOC_RECEPTOR(TIPO_DOC_RECEPTOR_AUT);
		setRANGO_HORARIO_RECEPTOR(RANGO_HORARIO_RECEPTOR_AUT);
		setFAC_ELC_ENV(FAC_ELC_ENV);
		return null;
	}

	public void ejbPostCreate(Integer ID_ORDEN, java.sql.Timestamp FECHA, Double NETO, String ESTADO, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO,
	                          Double TOTAL, String TELEFONO, String HR_CONTACTO, String COMENTARIOS, Integer NIVEL_RIESGO, String MOTIVO_RIESGO,
	                          Integer ID_ALIANZA, Integer ID_SECCION, Integer ID_DOMINIO, Integer ID_ORDEN_MOTIVO_RIESGO, String NOMBRES_RECEPTOR,
	                          String APELLIDOS_RECEPTOR, String CUPON, String CPF_CNPJ, Integer NRO_DOC_RECEPTOR, String TIPO_DOC_RECEPTOR,
	                         String RANGO_HORARIO_RECEPTOR, java.sql.Timestamp FAC_ELC_ENV) {
	}

	// cmp field methods
	public abstract Integer getID_ORDEN();

	public abstract void setID_ORDEN(Integer ID_ORDEN);

	public abstract java.sql.Timestamp getFECHA();

	public abstract void setFECHA(java.sql.Timestamp FECHA);

	public abstract Double getNETO();

	public abstract void setNETO(Double NETO);

	public abstract String getESTADO();

	public abstract void setESTADO(String ESTADO);

	public abstract Integer getID_SUCURSAL_SOCIO();

	public abstract void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Double getTOTAL();

	public abstract void setTOTAL(Double TOTAL);

	public abstract String getTELEFONO();

	public abstract void setTELEFONO(String TELEFONO);

	public abstract String getHR_CONTACTO();

	public abstract void setHR_CONTACTO(String HR_CONTACTO);

	public abstract String getCOMENTARIOS();

	public abstract void setCOMENTARIOS(String COMENTARIOS);

	public abstract Integer getNIVEL_RIESGO();

	public abstract void setNIVEL_RIESGO(Integer NIVEL_RIESGO);

	public abstract String getMOTIVO_RIESGO();

	public abstract void setMOTIVO_RIESGO(String MOTIVO_RIESGO);

	public abstract Integer getID_ALIANZA();

	public abstract void setID_ALIANZA(Integer ID_ALIANZA);

	public abstract Integer getID_SECCION();

	public abstract void setID_SECCION(Integer ID_SECCION);

	public abstract Integer getID_DOMINIO();

	public abstract void setID_DOMINIO(Integer ID_DOMINIO);

	public abstract Integer getID_ORDEN_MOTIVO_RIESGO();

	public abstract void setID_ORDEN_MOTIVO_RIESGO(Integer ID_ORDEN_MOTIVO_RIESGO);

	public abstract String getNOMBRES_RECEPTOR();

	public abstract void setNOMBRES_RECEPTOR(String NOMBRES_RECEPTOR);

	public abstract String getAPELLIDOS_RECEPTOR();

	public abstract void setAPELLIDOS_RECEPTOR(String APELLIDOS_RECEPTOR);

	public abstract void setCUPON(String CUPON);

	public abstract String getCUPON();

	public abstract String getCPF_CNPJ();

	public abstract void setCPF_CNPJ(String CPF_CNPJ);

	public abstract Integer getNRO_DOC_RECEPTOR();

	public abstract void setNRO_DOC_RECEPTOR(Integer NRO_DOC_RECEPTOR);

	public abstract String getTIPO_DOC_RECEPTOR();

	public abstract void setTIPO_DOC_RECEPTOR(String TIPO_DOC_RECEPTOR);

	public abstract String getRANGO_HORARIO_RECEPTOR();

	public abstract void setRANGO_HORARIO_RECEPTOR(String RANGO_HORARIO_RECEPTOR);
	
	public abstract java.sql.Timestamp getFAC_ELC_ENV();
	
	public abstract void setFAC_ELC_ENV(java.sql.Timestamp FAC_ELC_ENV);

}
