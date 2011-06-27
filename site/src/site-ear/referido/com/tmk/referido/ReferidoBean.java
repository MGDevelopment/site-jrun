package com.tmk.referido;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;

public abstract class ReferidoBean implements EntityBean
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

	public Long ejbCreate(Integer ID_SOCIO_REFERENTE, Integer ID_SUCURSAL_REFERENTE, Integer ID_SOCIO_REFERIDO, Integer ID_SUCURSAL_REFERIDO, Long CODIGO_REFERIDO, Integer ID_ORDEN_REFERIDO, String ESTADO, String NOMBRE_REFERIDO, String APELLIDO_REFERIDO, String EMAIL_REFERIDO, java.sql.Timestamp FECHA, java.sql.Timestamp FECHA_VENC_REFERIDO, java.sql.Timestamp FECHA_VENC_REFERENTE, String CUPON_REFERIDO, String CUPON_REFERENTE, String BENEF_REFERIDO, String BENEF_REFERENTE)throws CreateException {
		setID_SOCIO_REFERENTE(ID_SOCIO_REFERENTE);
		setID_SUCURSAL_REFERENTE(ID_SUCURSAL_REFERENTE);
		setID_SOCIO_REFERIDO(ID_SOCIO_REFERIDO);
		setID_SUCURSAL_REFERIDO(ID_SUCURSAL_REFERIDO);
		setCODIGO_REFERIDO(CODIGO_REFERIDO);
		setID_ORDEN_REFERIDO(ID_ORDEN_REFERIDO);
		setESTADO(ESTADO);
		setNOMBRE_REFERIDO(NOMBRE_REFERIDO);
		setAPELLIDO_REFERIDO(APELLIDO_REFERIDO);
		setEMAIL_REFERIDO(EMAIL_REFERIDO);
		setFECHA(FECHA);
		setFECHA_VENC_REFERIDO(FECHA_VENC_REFERIDO);
		setFECHA_VENC_REFERENTE(FECHA_VENC_REFERENTE);
		setCUPON_REFERIDO(CUPON_REFERIDO);
		setCUPON_REFERENTE(CUPON_REFERENTE);
		setBENEF_REFERIDO(BENEF_REFERIDO);
		setBENEF_REFERENTE(BENEF_REFERENTE);
		return null;
	}

	public void ejbPostCreate(Integer ID_SOCIO_REFERENTE, Integer ID_SUCURSAL_REFERENTE, Integer ID_SOCIO_REFERIDO, Integer ID_SUCURSAL_REFERIDO, Long CODIGO_REFERIDO, Integer ID_ORDEN_REFERIDO, String ESTADO, String NOMBRE_REFERIDO, String APELLIDO_REFERIDO, String EMAIL_REFERIDO, java.sql.Timestamp FECHA, java.sql.Timestamp FECHA_VENC_REFERIDO, java.sql.Timestamp FECHA_VENC_REFERENTE, String CUPON_REFERIDO, String CUPON_REFERENTE, String BENEF_REFERIDO, String BENEF_REFERENTE) {
	}

	// cmp field methods
	public abstract Integer getID_SOCIO_REFERENTE();
	public abstract void setID_SOCIO_REFERENTE(Integer ID_SOCIO_REFERENTE);

	public abstract Integer getID_SUCURSAL_REFERENTE();
	public abstract void setID_SUCURSAL_REFERENTE(Integer ID_SUCURSAL_REFERENTE);

	public abstract Integer getID_SOCIO_REFERIDO();
	public abstract void setID_SOCIO_REFERIDO(Integer ID_SOCIO_REFERIDO);

	public abstract Integer getID_SUCURSAL_REFERIDO();
	public abstract void setID_SUCURSAL_REFERIDO(Integer ID_SUCURSAL_REFERIDO);

	public abstract Long getCODIGO_REFERIDO();
	public abstract void setCODIGO_REFERIDO(Long CODIGO_REFERIDO);

	public abstract Integer getID_ORDEN_REFERIDO();
	public abstract void setID_ORDEN_REFERIDO(Integer ID_ORDEN_REFERIDO);

	public abstract String getESTADO();
	public abstract void setESTADO(String ESTADO);

	public abstract String getNOMBRE_REFERIDO();
	public abstract void setNOMBRE_REFERIDO(String NOMBRE_REFERIDO);

	public abstract String getAPELLIDO_REFERIDO();
	public abstract void setAPELLIDO_REFERIDO(String APELLIDO_REFERIDO);

	public abstract String getEMAIL_REFERIDO();
	public abstract void setEMAIL_REFERIDO(String EMAIL_REFERIDO);

	public abstract java.sql.Timestamp getFECHA();
	public abstract void setFECHA(java.sql.Timestamp FECHA);

	public abstract java.sql.Timestamp getFECHA_VENC_REFERIDO();
	public abstract void setFECHA_VENC_REFERIDO(java.sql.Timestamp FECHA_VENC_REFERIDO);

	public abstract java.sql.Timestamp getFECHA_VENC_REFERENTE();
	public abstract void setFECHA_VENC_REFERENTE(java.sql.Timestamp FECHA_VENC_REFERENTE);

	public abstract String getCUPON_REFERIDO();
	public abstract void setCUPON_REFERIDO(String CUPON_REFERIDO);

	public abstract String getCUPON_REFERENTE();
	public abstract void setCUPON_REFERENTE(String CUPON_REFERENTE);

	public abstract String getBENEF_REFERIDO();
	public abstract void setBENEF_REFERIDO(String BENEF_REFERIDO);

	public abstract String getBENEF_REFERENTE();
	public abstract void setBENEF_REFERENTE(String BENEF_REFERENTE);
}


