package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class EditorBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_EDITOR, String NOMBRE, String RAZON_SOCIAL, String DIRECCION, String CODIGO_POSTAL, String TELEFONO, String FAX, String EMAIL, String CUIT, String OBSERVACIONES, Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String URL) throws CreateException {
		setID_EDITOR(ID_EDITOR);
		setNOMBRE(NOMBRE);
		setRAZON_SOCIAL(RAZON_SOCIAL);
		setDIRECCION(DIRECCION);
		setCODIGO_POSTAL(CODIGO_POSTAL);
		setTELEFONO(TELEFONO);
		setFAX(FAX);
		setEMAIL(EMAIL);
		setCUIT(CUIT);
		setOBSERVACIONES(OBSERVACIONES);
		setID_PAIS(ID_PAIS);
		setID_PROVINCIA(ID_PROVINCIA);
		setID_LOCALIDAD(ID_LOCALIDAD);
        setURL(URL);
		return null;
	}

	public void ejbPostCreate(Integer ID_EDITOR, String NOMBRE, String RAZON_SOCIAL, String DIRECCION, String CODIGO_POSTAL, String TELEFONO, String FAX, String EMAIL, String CUIT, String OBSERVACIONES, Integer ID_PAIS, Integer ID_PROVINCIA, Integer ID_LOCALIDAD, String URL) {
	}

	// cmp field methods
	public abstract Integer getID_EDITOR();

	public abstract void setID_EDITOR(Integer ID_EDITOR);

	public abstract String getNOMBRE();

	public abstract void setNOMBRE(String NOMBRE);

	public abstract String getRAZON_SOCIAL();

	public abstract void setRAZON_SOCIAL(String RAZON_SOCIAL);

	public abstract String getDIRECCION();

	public abstract void setDIRECCION(String DIRECCION);

	public abstract String getCODIGO_POSTAL();

	public abstract void setCODIGO_POSTAL(String CODIGO_POSTAL);

	public abstract String getTELEFONO();

	public abstract void setTELEFONO(String TELEFONO);

	public abstract String getFAX();

	public abstract void setFAX(String FAX);

	public abstract String getEMAIL();

	public abstract void setEMAIL(String EMAIL);

	public abstract String getCUIT();

	public abstract void setCUIT(String CUIT);

	public abstract String getOBSERVACIONES();

	public abstract void setOBSERVACIONES(String OBSERVACIONES);

	public abstract Integer getID_PAIS();

	public abstract void setID_PAIS(Integer ID_PAIS);

	public abstract Integer getID_PROVINCIA();

	public abstract void setID_PROVINCIA(Integer ID_PROVINCIA);

	public abstract Integer getID_LOCALIDAD();

	public abstract void setID_LOCALIDAD(Integer ID_LOCALIDAD);

    public abstract String getURL();

	public abstract void setURL(String URL);

}


