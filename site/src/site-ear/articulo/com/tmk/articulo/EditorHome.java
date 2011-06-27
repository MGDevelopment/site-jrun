package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface EditorHome extends EJBHome {

	public Editor create(Integer ID_EDITOR, String NOMBRE, String RAZON_SOCIAL, String DIRECCION, String CODIGO_POSTAL, String TELEFONO, String FAX, String EMAIL, String CUIT, String OBSERVACIONES, Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String URL) throws RemoteException, CreateException;

	public Editor findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

    public Collection findByNombreEditorial(Integer id_editor, String nombre) throws RemoteException, FinderException;
}


