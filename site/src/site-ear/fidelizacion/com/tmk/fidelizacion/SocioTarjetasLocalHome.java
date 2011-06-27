package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface SocioTarjetasLocalHome extends EJBLocalHome
{
	public SocioTarjetasLocal create(String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, String ID_USR_ALTA, String ID_USR_MODI, String ID_MEDIO_COBRO, Integer ID_SUCURSAL, Integer ID_SOCIO) throws  CreateException;
	public SocioTarjetasLocal findByPrimaryKey(SocioTarjetasPK pk) throws  FinderException; 
}


