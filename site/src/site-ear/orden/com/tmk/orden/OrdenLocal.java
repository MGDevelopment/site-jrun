package com.tmk.orden;

import javax.ejb.EJBLocalObject;

public interface OrdenLocal extends EJBLocalObject {

	public Integer getID_ORDEN();

	public void setID_ORDEN(Integer ID_ORDEN);

	public java.sql.Timestamp getFECHA();

	public void setFECHA(java.sql.Timestamp FECHA);

	public Double getNETO();

	public void setNETO(Double NETO);

	public String getESTADO();

	public void setESTADO(String ESTADO);

	public Integer getID_SUCURSAL_SOCIO();

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public Double getTOTAL();

	public void setTOTAL(Double TOTAL);

	public String getTELEFONO();

	public void setTELEFONO(String TELEFONO);

	public String getHR_CONTACTO();

	public void setHR_CONTACTO(String HR_CONTACTO);

	public String getCOMENTARIOS();

	public void setCOMENTARIOS(String COMENTARIOS);

	public Integer getNIVEL_RIESGO();

	public void setNIVEL_RIESGO(Integer NIVEL_RIESGO);

	public String getMOTIVO_RIESGO();

	public void setMOTIVO_RIESGO(String MOTIVO_RIESGO);

	public Integer getID_ALIANZA();

	public void setID_ALIANZA(Integer ID_ALIANZA);

	public Integer getID_SECCION();

	public void setID_SECCION(Integer ID_SECCION);

	public Integer getID_DOMINIO();

	public void setID_DOMINIO(Integer ID_DOMINIO);

	public Integer getID_ORDEN_MOTIVO_RIESGO();

	public void setID_ORDEN_MOTIVO_RIESGO(Integer ID_ORDEN_MOTIVO_RIESGO);

	public String getNOMBRES_RECEPTOR();

	public void setNOMBRES_RECEPTOR(String NOMBRES_RECEPTOR);

	public String getAPELLIDOS_RECEPTOR();

	public void setAPELLIDOS_RECEPTOR(String APELLIDOS_RECEPTOR);

	public String getCUPON();

	public void setCUPON(String CUPON);

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


