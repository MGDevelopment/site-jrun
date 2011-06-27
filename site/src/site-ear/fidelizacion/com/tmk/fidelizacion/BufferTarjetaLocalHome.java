package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface BufferTarjetaLocalHome extends EJBLocalHome
{
	public BufferTarjetaLocal create(String NRO_TARJETA, String ESTADO, java.sql.Timestamp ESTADO_FECHA, String ESTADO_USR, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) throws  CreateException;
	public BufferTarjetaLocal findByPrimaryKey(String pk) throws  FinderException; 
}


