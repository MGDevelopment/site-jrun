package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface PedidoEspecialLocalHome extends EJBLocalHome {

	public PedidoEspecialLocal create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, java.util.Date FECHA, String TELEFONO, String HORARIO, String COMENTARIO, Integer ID_DISPONIBILIDAD, Integer ID_PEDIDO, Integer ID_CONSULTA, Integer ID_OPINION) throws CreateException;

	public PedidoEspecialLocal findByPrimaryKey(Integer pk) throws FinderException;

	public Collection findUltimosPedidos() throws FinderException;

}




