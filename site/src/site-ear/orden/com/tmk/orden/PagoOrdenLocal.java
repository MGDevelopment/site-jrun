package com.tmk.orden;

import javax.ejb.EJBLocalObject;

public interface PagoOrdenLocal extends EJBLocalObject {

	public Integer getID_ORDEN();

	public void setID_ORDEN(Integer ID_ORDEN);

	public String getID_MEDIO_COBRO();

	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public Double getIMPORTE();

	public void setIMPORTE(Double IMPORTE);

	public void setCUOTAS(Integer CUOTAS);

	public Integer getCUOTAS();

	public void setCOEFICIENTE(Double COEFICIENTE);

	public Double getCOEFICIENTE();

	public void setMONEDA(Integer MONEDA);

	public Integer getMONEDA();

	public void setCAMBIO(Double CAMBIO);

	public Double getCAMBIO();

}


