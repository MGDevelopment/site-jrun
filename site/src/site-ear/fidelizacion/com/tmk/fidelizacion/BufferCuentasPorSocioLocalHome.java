package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface BufferCuentasPorSocioLocalHome extends EJBLocalHome
{
	public BufferCuentasPorSocioLocal create(Integer ID_CUENTA, Integer ID_SUCURSAL, Integer ID_CUSO, Integer ID_SOCIO, Integer ID_SUCURSAL_SOCIO, Integer DPER_CODIGO, Integer COMPONENTE, java.sql.Timestamp FECHA_TRANSMISION, String CANJE_HABILITADO, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI) throws  CreateException;
	public BufferCuentasPorSocioLocal findByPrimaryKey(BufferCuentasPorSocioPK pk) throws  FinderException; 
}


