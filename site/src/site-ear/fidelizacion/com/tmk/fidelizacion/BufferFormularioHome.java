package com.tmk.fidelizacion;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import java.util.Collection;
import javax.ejb.FinderException;

public interface BufferFormularioHome extends EJBHome
{
	public BufferFormulario create(String NRO_FORMULARIO, java.sql.Timestamp FECHA, String DATOS_ADICIONALES, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, java.sql.Timestamp FECHA_TRANSMISION, Integer DPER_CODIGO) throws RemoteException,  CreateException;
	public BufferFormulario findByPrimaryKey(String pk) throws RemoteException,  FinderException; 
}


