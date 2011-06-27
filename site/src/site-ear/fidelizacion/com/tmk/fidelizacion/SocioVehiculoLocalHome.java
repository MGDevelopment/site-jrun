package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface SocioVehiculoLocalHome extends EJBLocalHome
{
	public SocioVehiculoLocal create(Integer ID_SOCIO, Integer ID_SUCURSAL, Integer ID_SOVH, String ID_MARCA, String ID_MODELO, Integer ANIO_MODELO, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) throws  CreateException;
	public SocioVehiculoLocal findByPrimaryKey(SocioVehiculo pk) throws  FinderException; 
}


