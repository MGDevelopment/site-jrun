package com.tmk.articulo;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class ArticuloTextoBean implements EntityBean {

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

	public ArticuloTextoPK ejbCreate(Integer ID_ARTICULO, String TIPO, Integer PARTE, String TIPO_TEXTO, String TEXTO, Integer ID_AUTOR, String ROLE, String IDIOMA) throws CreateException {
		setID_ARTICULO(ID_ARTICULO);
		setTIPO(TIPO);
		setPARTE(PARTE);
		setTIPO_TEXTO(TIPO_TEXTO);
		setTEXTO(TEXTO);
		setID_AUTOR(ID_AUTOR);
		setROLE(ROLE);
		setIDIOMA(IDIOMA);
		return null;
	}

	public void ejbPostCreate(Integer ID_ARTICULO, String TIPO, Integer PARTE, String TIPO_TEXTO, String TEXTO, Integer ID_AUTOR, String ROLE, String IDIOMA) {
	}

	// cmp field methods
	public abstract Integer getID_ARTICULO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract String getTIPO();

	public abstract void setTIPO(String TIPO);

	public abstract Integer getPARTE();

	public abstract void setPARTE(Integer PARTE);

	public abstract String getTIPO_TEXTO();

	public abstract void setTIPO_TEXTO(String TIPO_TEXTO);

	public abstract String getTEXTO();

	public abstract void setTEXTO(String TEXTO);

	public abstract Integer getID_AUTOR();

	public abstract void setID_AUTOR(Integer ID_AUTOR);

	public abstract String getROLE();

	public abstract void setROLE(String ROLE);

	public abstract String getIDIOMA();

	public abstract void setIDIOMA(String IDIOMA);

}


