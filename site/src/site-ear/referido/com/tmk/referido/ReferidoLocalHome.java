package com.tmk.referido;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface ReferidoLocalHome extends EJBLocalHome
{
	public ReferidoLocal create (Integer ID_SOCIO_REFERENTE, Integer ID_SUCURSAL_REFERENTE, Integer ID_SOCIO_REFERIDO, Integer ID_SUCURSAL_REFERIDO, Long CODIGO_REFERIDO, Integer ID_ORDEN_REFERIDO, String ESTADO, String NOMBRE_REFERIDO, String APELLIDO_REFERIDO, String EMAIL_REFERIDO, java.sql.Timestamp FECHA, java.sql.Timestamp FECHA_VENC_REFERIDO, java.sql.Timestamp FECHA_VENC_REFERENTE, String CUPON_REFERIDO, String CUPON_REFERENTE, String BENEF_REFERIDO, String BENEF_REFERENTE) throws  CreateException;
	public ReferidoLocal findByPrimaryKey (Long pk) throws  FinderException;
	public ReferidoLocal findBySocioReferido (Integer idSocio, Integer idSucursal) throws FinderException;
	public Collection findBySocioReferenteEstado (Integer idSocio, Integer idSucursal, String estado) throws FinderException;
	public ReferidoLocal findByOrdenReferido (Integer idOrden) throws FinderException;
	public Collection findBySocioReferenteDisponibles (Integer idSocio, Integer idSucursal) throws FinderException;
	public Collection findBySocioReferenteEnProceso (Integer idSocio, Integer idSucursal) throws FinderException;
	public Collection findBySocioReferenteVencidos (Integer idSocio, Integer idSucursal) throws FinderException;
}



