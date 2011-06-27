package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface EditorLocalHome extends EJBLocalHome {

	public EditorLocal create(Integer ID_EDITOR, String NOMBRE, String RAZON_SOCIAL, String DIRECCION, String CODIGO_POSTAL, String TELEFONO, String FAX, String EMAIL, String CUIT, String OBSERVACIONES, Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String URL) throws CreateException;

	public EditorLocal findByPrimaryKey(Integer pk) throws FinderException;

    public Collection findByNombreEditorial(Integer id_editor, String nombre) throws FinderException;
}


