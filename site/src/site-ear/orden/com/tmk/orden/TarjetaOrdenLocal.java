package com.tmk.orden;

import javax.ejb.EJBLocalObject;

public interface TarjetaOrdenLocal extends EJBLocalObject {

	public Integer getID_ORDEN();

	public void setID_ORDEN(Integer ID_ORDEN);

	public String getID_MEDIO_COBRO();

	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public byte[] getNRO_TARJETA();

	public void setNRO_TARJETA(byte[] NRO_TARJETA);

	public String getNOMBRE_CLIENTE();

	public void setNOMBRE_CLIENTE(String NOMBRE_CLIENTE);

	public Integer getCODIGO_RESPUESTA();

	public void setCODIGO_RESPUESTA(Integer CODIGO_RESPUESTA);

	public Integer getCODIGO_AUTORIZACION();

	public void setCODIGO_AUTORIZACION(Integer CODIGO_AUTORIZACION);

	public String getMENSAJE_GPAY();

	public void setMENSAJE_GPAY(String MENSAJE_GPAY);

	public String getTIPO_DOC();

	public void setTIPO_DOC(String TIPO_DOC);

	public Long getNRO_DOC();

	public void setNRO_DOC(Long NRO_DOC);

	public String getDIRECCION_RESUMEN();

	public void setDIRECCION_RESUMEN(String DIRECCION_RESUMEN);

	public byte[] getP1();

	public void setP1(byte[] P1);

	public byte[] getP2();

	public void setP2(byte[] P2);

	public byte[] getP3();

	public void setP3(byte[] P3);

}
