package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface TarjetaVerificadaLocalHome extends EJBLocalHome {

	public TarjetaVerificadaLocal create(Integer ID, byte[] NRO_TARJETA, String NOMBRES_SOCIO, String APELLIDOS_SOCIO, String E_MAIL, String CALLE_ENVIO, Integer NUMERO_ENVIO, String EDIFICIO_ENVIO, Integer PISO_ENVIO, String DEPTO_ENVIO, String CP_ENVIO, Integer ID_PAIS_ENVIO, Integer ID_PROVINCIA_ENVIO, Integer ID_LOCALIDAD_ENVIO, String CALLE_FACT, Integer NUMERO_FACT, String EDIFICIO_FACT, Integer PISO_FACT, String DEPTO_FACT, String CP_FACT, Integer ID_PAIS_FACT, Integer ID_PROVINCIA_FACT, Integer ID_LOCALIDAD_FACT, Integer NIVEL_RIESGO, String COMENTARIOS) throws CreateException;

	public TarjetaVerificadaLocal findByPrimaryKey(Integer pk) throws FinderException;

	public Collection findAll() throws FinderException;
}


