package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface BufferTarjetasPorCuentaLocalHome extends EJBLocalHome
{
	public BufferTarjetasPorCuentaLocal create(String NRO_TARJETA, Integer ID_CUENTA, Integer ID_SUCURSAL_CUENTA, Integer ID_CUSO, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String NRO_FORMULARIO) throws  CreateException;
	public BufferTarjetasPorCuentaLocal findByPrimaryKey(String pk) throws  FinderException; 
}


