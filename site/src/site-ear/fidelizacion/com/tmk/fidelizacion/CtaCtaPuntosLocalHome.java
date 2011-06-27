package com.tmk.fidelizacion;

import javax.ejb.EJBLocalHome;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface CtaCtaPuntosLocalHome extends EJBLocalHome
{
	public CtaCtaPuntosLocal create(Integer ID_SUCURSAL, Integer ID_CCPT, String CECO_NIV_01, String CECO_NIV_02, String CECO_NIV_03, String CECO_NIV_04, String CECO_NIV_05, String MSEC_NIV_01, String MSEC_NIV_02, String MSEC_NIV_03, String MSEC_NIV_04, String MSEC_NIV_05, Integer ID_SOCIO, Integer ID_SUCURSAL_SOCIO, Integer ID_CUENTA, Integer ID_SUCURSAL_CUENTA, String NRO_TARJETA, Integer ID_CONCEPTO, Integer ID_REGLA, Integer ID_MOVIMIENTO, Integer ID_SUCURSAL_MOVIMIENTO, Integer ITEM, Integer PUNTOS, Double IMPORTE_ADICIONAL, java.sql.Timestamp FECHA_TRANSMISION, Integer ID_CUENTA_RELA, Integer ID_SUCURSAL_CUENTA_RELA, String USR_ALTA, java.sql.Timestamp F_ALTA, String USR_MODI, java.sql.Timestamp F_MODI, java.sql.Timestamp FECHA, Integer SALDO_X_APLICAR, Integer SIGNO_SALDO) throws  CreateException;
	public CtaCtaPuntosLocal findByPrimaryKey(CtaCtaPuntosPK pk) throws  FinderException;
}


