package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface TarjetaVerificadaHome extends EJBHome {

	public TarjetaVerificada create(Integer ID, byte[] NRO_TARJETA, String NOMBRES_SOCIO, String APELLIDOS_SOCIO, String E_MAIL, String CALLE_ENVIO, Integer NUMERO_ENVIO, String EDIFICIO_ENVIO, Integer PISO_ENVIO, String DEPTO_ENVIO, String CP_ENVIO, Integer ID_PAIS_ENVIO, Integer ID_PROVINCIA_ENVIO, Integer ID_LOCALIDAD_ENVIO, String CALLE_FACT, Integer NUMERO_FACT, String EDIFICIO_FACT, Integer PISO_FACT, String DEPTO_FACT, String CP_FACT, Integer ID_PAIS_FACT, Integer ID_PROVINCIA_FACT, Integer ID_LOCALIDAD_FACT, Integer NIVEL_RIESGO, String COMENTARIOS) throws RemoteException, CreateException;

	public TarjetaVerificada findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;
}


