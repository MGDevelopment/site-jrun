package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface BufferFormularioLocalHome extends EJBLocalHome
{
	public BufferFormularioLocal create(String NRO_FORMULARIO, java.sql.Timestamp FECHA, String DATOS_ADICIONALES, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, java.sql.Timestamp FECHA_TRANSMISION, Integer DPER_CODIGO) throws  CreateException;
	public BufferFormularioLocal findByPrimaryKey(String pk) throws  FinderException; 
}


