package com.tmk.referido;

import javax.ejb.EJBLocalObject;

public interface ReferidoLocal extends EJBLocalObject
{
	public Integer getID_SOCIO_REFERENTE();
	public void setID_SOCIO_REFERENTE(Integer ID_SOCIO_REFERENTE);

	public Integer getID_SUCURSAL_REFERENTE();
	public void setID_SUCURSAL_REFERENTE(Integer ID_SUCURSAL_REFERENTE);

	public Integer getID_SOCIO_REFERIDO();
	public void setID_SOCIO_REFERIDO(Integer ID_SOCIO_REFERIDO);

	public Integer getID_SUCURSAL_REFERIDO();
	public void setID_SUCURSAL_REFERIDO(Integer ID_SUCURSAL_REFERIDO);

	public Long getCODIGO_REFERIDO();
	public void setCODIGO_REFERIDO(Long CODIGO_REFERIDO);

	public Integer getID_ORDEN_REFERIDO();
	public void setID_ORDEN_REFERIDO(Integer ID_ORDEN_REFERIDO);

	public String getESTADO();
	public void setESTADO(String ESTADO);

	public String getNOMBRE_REFERIDO();
	public void setNOMBRE_REFERIDO(String NOMBRE_REFERIDO);

	public String getAPELLIDO_REFERIDO();
	public void setAPELLIDO_REFERIDO(String APELLIDO_REFERIDO);

	public String getEMAIL_REFERIDO();
	public void setEMAIL_REFERIDO(String EMAIL_REFERIDO);

	public java.sql.Timestamp getFECHA();
	public void setFECHA(java.sql.Timestamp FECHA);

	public java.sql.Timestamp getFECHA_VENC_REFERIDO();
	public void setFECHA_VENC_REFERIDO(java.sql.Timestamp FECHA_VENC_REFERIDO);

	public java.sql.Timestamp getFECHA_VENC_REFERENTE();
	public void setFECHA_VENC_REFERENTE(java.sql.Timestamp FECHA_VENC_REFERENTE);

	public String getCUPON_REFERIDO();
	public void setCUPON_REFERIDO(String CUPON_REFERIDO);

	public String getCUPON_REFERENTE();
	public void setCUPON_REFERENTE(String CUPON_REFERENTE);

	public String getBENEF_REFERIDO();
	public void setBENEF_REFERIDO(String BENEF_REFERIDO);

	public String getBENEF_REFERENTE();
	public void setBENEF_REFERENTE(String BENEF_REFERENTE);
}


