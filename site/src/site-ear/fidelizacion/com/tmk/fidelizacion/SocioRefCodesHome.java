package com.tmk.fidelizacion;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

import javax.ejb.FinderException;

public interface SocioRefCodesHome extends EJBHome
{
	public SocioRefCodes create(Integer ID_SOCIO, Integer ID_SUCURSAL, String DOMAIN, String LOW_VALUE, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String CARACTER, Double NUMERO, java.sql.Timestamp FECHA) throws RemoteException,  CreateException;
	public SocioRefCodes findByPrimaryKey(SocioRefCodesPK pk) throws RemoteException,  FinderException; 
}


