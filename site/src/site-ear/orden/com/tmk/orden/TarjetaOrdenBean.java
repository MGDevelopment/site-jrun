package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class TarjetaOrdenBean implements EntityBean {

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

	public TarjetaOrdenPK ejbCreate(Integer ID_ORDEN, String ID_MEDIO_COBRO, byte[] NRO_TARJETA, String NOMBRE_CLIENTE, Integer CODIGO_RESPUESTA, Integer CODIGO_AUTORIZACION, String MENSAJE_GPAY, String TIPO_DOC, Long NRO_DOC, String DIRECCION_RESUMEN, byte[] P1, byte[] P2, byte[] P3) throws CreateException {
		setID_ORDEN(ID_ORDEN);
		setID_MEDIO_COBRO(ID_MEDIO_COBRO);
		setNRO_TARJETA(NRO_TARJETA);
		setNOMBRE_CLIENTE(NOMBRE_CLIENTE);
		setCODIGO_RESPUESTA(CODIGO_RESPUESTA);
		setCODIGO_AUTORIZACION(CODIGO_AUTORIZACION);
		setMENSAJE_GPAY(MENSAJE_GPAY);
		setTIPO_DOC(TIPO_DOC);
		setNRO_DOC(NRO_DOC);
		setDIRECCION_RESUMEN(DIRECCION_RESUMEN);
		setP1(P1);
		setP2(P2);
		setP3(P3);
		return null;
	}

	public void ejbPostCreate(Integer ID_ORDEN, String ID_MEDIO_COBRO, byte[] NRO_TARJETA, String NOMBRE_CLIENTE, Integer CODIGO_RESPUESTA, Integer CODIGO_AUTORIZACION, String MENSAJE_GPAY, String TIPO_DOC, Long NRO_DOC, String DIRECCION_RESUMEN, byte[] P1, byte[] P2, byte[] P3) {
	}

	// cmp field methods
	public abstract Integer getID_ORDEN();

	public abstract void setID_ORDEN(Integer ID_ORDEN);

	public abstract String getID_MEDIO_COBRO();

	public abstract void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public abstract byte[] getNRO_TARJETA();

	public abstract void setNRO_TARJETA(byte[] NRO_TARJETA);

	public abstract String getNOMBRE_CLIENTE();

	public abstract void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE);

	public abstract Integer getCODIGO_RESPUESTA();

	public abstract void setCODIGO_RESPUESTA(Integer CODIGO_RESPUESTA);

	public abstract Integer getCODIGO_AUTORIZACION();

	public abstract void setCODIGO_AUTORIZACION(Integer CODIGO_AUTORIZACION);

	public abstract String getMENSAJE_GPAY();

	public abstract void setMENSAJE_GPAY(String MENSAJE_GPAY);

	public abstract String getTIPO_DOC();

	public abstract void setTIPO_DOC(String TIPO_DOC);

	public abstract Long getNRO_DOC();

	public abstract void setNRO_DOC(Long NRO_DOC);

	public abstract String getDIRECCION_RESUMEN();

	public abstract void setDIRECCION_RESUMEN(String DIRECCION_RESUMEN);

	public abstract byte[] getP1();

	public abstract void setP1(byte[] P1);

	public abstract byte[] getP2();

	public abstract void setP2(byte[] P2);

	public abstract byte[] getP3();

	public abstract void setP3(byte[] P3);

}


