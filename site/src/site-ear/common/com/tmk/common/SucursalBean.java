/**
 * @author Lizardo Santiago
 *
 * $Log: SucursalBean.java,v $
 * Revision 1.7  2003/10/03 16:28:59  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/09/16 23:08:22  SLizardo
 * Administracion de Eventos
 *
 *
 */
package com.tmk.common;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import java.util.Date;

public abstract class SucursalBean implements EntityBean {

	private EntityContext context;

	public void ejbLoad() {
	}

	public void ejbStore() {
	}

	public void setEntityContext(EntityContext context) {
		this.context = context;
	}

	public void unsetEntityContext() throws EJBException {
		this.context = null;
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public Integer ejbCreate(Integer ID_SUCURSAL, String DESCRIPCION, Date FECHA_APERTURA, String DIRECCION, Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String CODIGO_POSTAL, String TELEFONO, String FAX, String EMAIL) throws CreateException {
		setID_SUCURSAL(ID_SUCURSAL);
		setDESCRIPCION(DESCRIPCION);
		setFECHA_APERTURA(FECHA_APERTURA);
		setDIRECCION(DIRECCION);
		setID_PAIS(ID_PAIS);
		setID_PROVINCIA(ID_PROVINCIA);
		setID_LOCALIDAD(ID_LOCALIDAD);
		setCODIGO_POSTAL(CODIGO_POSTAL);
		setTELEFONO(TELEFONO);
		setFAX(FAX);
		setEMAIL(EMAIL);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL, String DESCRIPCION, Date FECHA_APERTURA, String DIRECCION, Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String CODIGO_POSTAL, String TELEFONO, String FAX, String EMAIL) {
	}

	public abstract Integer getID_SUCURSAL();

	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract Date getFECHA_APERTURA();

	public abstract void setFECHA_APERTURA(Date FECHA_APERTURA);

	public abstract String getDIRECCION();

	public abstract void setDIRECCION(String DIRECCION);

	public abstract Integer getID_PAIS();

	public abstract void setID_PAIS(Integer ID_PAIS);

	public abstract Integer getID_PROVINCIA();

	public abstract void setID_PROVINCIA(Integer ID_PROVINCIA);

	public abstract Integer getID_LOCALIDAD();

	public abstract void setID_LOCALIDAD(Integer ID_LOCALIDAD);

	public abstract String getCODIGO_POSTAL();

	public abstract void setCODIGO_POSTAL(String CODIGO_POSTAL);

	public abstract String getTELEFONO();

	public abstract void setTELEFONO(String TELEFONO);

	public abstract String getFAX();

	public abstract void setFAX(String FAX);

	public abstract String getEMAIL();

	public abstract void setEMAIL(String EMAIL);
}
