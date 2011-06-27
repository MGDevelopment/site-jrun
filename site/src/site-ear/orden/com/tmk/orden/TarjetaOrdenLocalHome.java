package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface TarjetaOrdenLocalHome extends EJBLocalHome {

	public TarjetaOrdenLocal create(Integer ID_ORDEN, String ID_MEDIO_COBRO, byte[] NRO_TARJETA, String NOMBRE_CLIENTE, Integer CODIGO_RESPUESTA, Integer CODIGO_AUTORIZACION, String MENSAJE_GPAY, String TIPO_DOC, Long NRO_DOC, String DIRECCION_RESUMEN, byte[] P1, byte[] P2, byte[] P3) throws CreateException;

	public TarjetaOrdenLocal findByPrimaryKey(TarjetaOrdenPK pk) throws FinderException;
}


