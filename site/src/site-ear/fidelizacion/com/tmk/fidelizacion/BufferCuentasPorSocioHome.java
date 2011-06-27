package com.tmk.fidelizacion;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import java.util.Collection;
import javax.ejb.FinderException;

public interface BufferCuentasPorSocioHome extends EJBHome
{
	public BufferCuentasPorSocio create(Integer ID_CUENTA, Integer ID_SUCURSAL, Integer ID_CUSO, Integer ID_SOCIO, Integer ID_SUCURSAL_SOCIO, Integer DPER_CODIGO, Integer COMPONENTE, java.sql.Timestamp FECHA_TRANSMISION, String CANJE_HABILITADO, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) throws RemoteException,  CreateException;
	public BufferCuentasPorSocio findByPrimaryKey(BufferCuentasPorSocioPK pk) throws RemoteException,  FinderException; 
}


