package com.tmk.common;

import javax.ejb.EJBLocalObject;

public interface PedidoEspecialLocal extends EJBLocalObject {

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public Integer getID_SUCURSAL_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public Integer getID_SOCIO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public Integer getID_ARTICULO();

	public void setFECHA(java.util.Date FECHA);

	public java.util.Date getFECHA();

	public void setTELEFONO(String TELEFONO);

	public String getTELEFONO();

	public void setHORARIO(String HORARIO);

	public String getHORARIO();

	public void setCOMENTARIO(String COMENTARIO);

	public String getCOMENTARIO();

	public void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD);

	public Integer getID_DISPONIBILIDAD();

	public void setID_PEDIDO(Integer ID_PEDIDO);

	public Integer getID_PEDIDO();

	public void setID_CONSULTA(Integer ID_CONSULTA);

	public Integer getID_CONSULTA();

	public void setID_OPINION(Integer ID_OPINION);

	public Integer getID_OPINION();


}


