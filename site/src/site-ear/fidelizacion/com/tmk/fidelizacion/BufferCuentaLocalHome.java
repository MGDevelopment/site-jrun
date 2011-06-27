package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface BufferCuentaLocalHome extends EJBLocalHome
{
	public BufferCuentaLocal create(Integer ID_CUENTA, Integer ID_SUCURSAL, java.sql.Timestamp FECHA_APERTURA, String ESTADO, java.sql.Timestamp ESTADO_FECHA, String ESTADO_USR, java.sql.Timestamp FECHA_TRANSMISION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) throws  CreateException;
	public BufferCuentaLocal findByPrimaryKey(BufferCuentaPK pk) throws  FinderException; 
}


