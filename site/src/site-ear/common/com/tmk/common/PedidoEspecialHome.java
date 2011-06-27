package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface PedidoEspecialHome extends EJBHome {

	public PedidoEspecial create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, java.util.Date FECHA, String TELEFONO, String HORARIO, String COMENTARIO, Integer ID_DISPONIBILIDAD, Integer ID_PEDIDO, Integer ID_CONSULTA, Integer ID_OPINION) throws RemoteException, CreateException;

	public PedidoEspecial findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

	public Collection findUltimosPedidos() throws RemoteException, FinderException;

}


