package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class UsuarioBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_USUARIO, byte[] LOGIN, byte[] PASSWORD, String NOMBRES, String APELLIDOS, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) throws CreateException {
		setID_USUARIO(ID_USUARIO);
		setLOGIN(LOGIN);
		setPASSWORD(PASSWORD);
		setNOMBRES(NOMBRES);
		setAPELLIDOS(APELLIDOS);
		setESTADO(ESTADO);
		setFECHA_ALTA(FECHA_ALTA);
		setUSUARIO_ALTA(USUARIO_ALTA);
		setFECHA_MODIF(FECHA_MODIF);
		setUSUARIO_MODIF(USUARIO_MODIF);
		return null;
	}

	public void ejbPostCreate(Integer ID_USUARIO, byte[] LOGIN, byte[] PASSWORD, String NOMBRES, String APELLIDOS, Integer ESTADO, java.sql.Timestamp FECHA_ALTA, String USUARIO_ALTA, java.sql.Timestamp FECHA_MODIF, String USUARIO_MODIF) {
	}

	// cmp field methods
	public abstract Integer getID_USUARIO();

	public abstract void setID_USUARIO(Integer ID_USUARIO);

	public abstract byte[] getLOGIN();

	public abstract void setLOGIN(byte[] LOGIN);

	public abstract byte[] getPASSWORD();

	public abstract void setPASSWORD(byte[] PASSWORD);

	public abstract String getNOMBRES();

	public abstract void setNOMBRES(String NOMBRES);

	public abstract String getAPELLIDOS();

	public abstract void setAPELLIDOS(String APELLIDOS);

	public abstract Integer getESTADO();

	public abstract void setESTADO(Integer ESTADO);

	public abstract java.sql.Timestamp getFECHA_ALTA();

	public abstract void setFECHA_ALTA(java.sql.Timestamp FECHA_ALTA);

	public abstract String getUSUARIO_ALTA();

	public abstract void setUSUARIO_ALTA(String USUARIO_ALTA);

	public abstract java.sql.Timestamp getFECHA_MODIF();

	public abstract void setFECHA_MODIF(java.sql.Timestamp FECHA_MODIF);

	public abstract String getUSUARIO_MODIF();

	public abstract void setUSUARIO_MODIF(String USUARIO_MODIF);

}


