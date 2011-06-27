package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface PuntosPorSucursalLocalHome extends EJBLocalHome
{
	public PuntosPorSucursalLocal create(Integer ID_CUENTA, Integer ID_SUCURSAL, java.sql.Timestamp MES, Integer PUNTOS, Long FECHA_MODIFICACION, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, Double SALDO_X_APLICAR, Integer SIGNO_SALDO, Integer ID_SUCURSAL_CUENTA) throws  CreateException;
	public PuntosPorSucursalLocal findByPrimaryKey(PuntosPorSucursalPK pk) throws  FinderException; 
}


