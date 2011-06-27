package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class TarjetaVerificadaBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID, byte[] NRO_TARJETA, String NOMBRES_SOCIO, String APELLIDOS_SOCIO, String E_MAIL, String CALLE_ENVIO, Integer NUMERO_ENVIO, String EDIFICIO_ENVIO, Integer PISO_ENVIO, String DEPTO_ENVIO, String CP_ENVIO, Integer ID_PAIS_ENVIO, Integer ID_PROVINCIA_ENVIO, Integer ID_LOCALIDAD_ENVIO, String CALLE_FACT, Integer NUMERO_FACT, String EDIFICIO_FACT, Integer PISO_FACT, String DEPTO_FACT, String CP_FACT, Integer ID_PAIS_FACT, Integer ID_PROVINCIA_FACT, Integer ID_LOCALIDAD_FACT, Integer NIVEL_RIESGO, String COMENTARIOS) throws CreateException {
		setID(ID);
		setNRO_TARJETA(NRO_TARJETA);
		setNOMBRES_SOCIO(NOMBRES_SOCIO);
		setAPELLIDOS_SOCIO(APELLIDOS_SOCIO);
		setE_MAIL(E_MAIL);
		setCALLE_ENVIO(CALLE_ENVIO);
		setNUMERO_ENVIO(NUMERO_ENVIO);
		setEDIFICIO_ENVIO(EDIFICIO_ENVIO);
		setPISO_ENVIO(PISO_ENVIO);
		setDEPTO_ENVIO(DEPTO_ENVIO);
		setCP_ENVIO(CP_ENVIO);
		setID_PAIS_ENVIO(ID_PAIS_ENVIO);
		setID_PROVINCIA_ENVIO(ID_PROVINCIA_ENVIO);
		setID_LOCALIDAD_ENVIO(ID_LOCALIDAD_ENVIO);
		setCALLE_FACT(CALLE_FACT);
		setNUMERO_FACT(NUMERO_FACT);
		setEDIFICIO_FACT(EDIFICIO_FACT);
		setPISO_FACT(PISO_FACT);
		setDEPTO_FACT(DEPTO_FACT);
		setCP_FACT(CP_FACT);
		setID_PAIS_FACT(ID_PAIS_FACT);
		setID_PROVINCIA_FACT(ID_PROVINCIA_FACT);
		setID_LOCALIDAD_FACT(ID_LOCALIDAD_FACT);
		setNIVEL_RIESGO(NIVEL_RIESGO);
		setCOMENTARIOS(COMENTARIOS);
		return null;
	}

	public void ejbPostCreate(Integer ID, byte[] NRO_TARJETA, String NOMBRES_SOCIO, String APELLIDOS_SOCIO, String E_MAIL, String CALLE_ENVIO, Integer NUMERO_ENVIO, String EDIFICIO_ENVIO, Integer PISO_ENVIO, String DEPTO_ENVIO, String CP_ENVIO, Integer ID_PAIS_ENVIO, Integer ID_PROVINCIA_ENVIO, Integer ID_LOCALIDAD_ENVIO, String CALLE_FACT, Integer NUMERO_FACT, String EDIFICIO_FACT, Integer PISO_FACT, String DEPTO_FACT, String CP_FACT, Integer ID_PAIS_FACT, Integer ID_PROVINCIA_FACT, Integer ID_LOCALIDAD_FACT, Integer NIVEL_RIESGO, String COMENTARIOS) {
	}

	// cmp field methods
	public abstract Integer getID();

	public abstract void setID(Integer ID);

	public abstract byte[] getNRO_TARJETA();

	public abstract void setNRO_TARJETA(byte[] NRO_TARJETA);

	public abstract String getNOMBRES_SOCIO();

	public abstract void setNOMBRES_SOCIO(String NOMBRES_SOCIO);

	public abstract String getAPELLIDOS_SOCIO();

	public abstract void setAPELLIDOS_SOCIO(String APELLIDOS_SOCIO);

	public abstract String getE_MAIL();

	public abstract void setE_MAIL(String E_MAIL);

	public abstract String getCALLE_ENVIO();

	public abstract void setCALLE_ENVIO(String CALLE_ENVIO);

	public abstract Integer getNUMERO_ENVIO();

	public abstract void setNUMERO_ENVIO(Integer NUMERO_ENVIO);

	public abstract String getEDIFICIO_ENVIO();

	public abstract void setEDIFICIO_ENVIO(String EDIFICIO_ENVIO);

	public abstract Integer getPISO_ENVIO();

	public abstract void setPISO_ENVIO(Integer PISO_ENVIO);

	public abstract String getDEPTO_ENVIO();

	public abstract void setDEPTO_ENVIO(String DEPTO_ENVIO);

	public abstract String getCP_ENVIO();

	public abstract void setCP_ENVIO(String CP_ENVIO);

	public abstract Integer getID_PAIS_ENVIO();

	public abstract void setID_PAIS_ENVIO(Integer ID_PAIS_ENVIO);

	public abstract Integer getID_PROVINCIA_ENVIO();

	public abstract void setID_PROVINCIA_ENVIO(Integer ID_PROVINCIA_ENVIO);

	public abstract Integer getID_LOCALIDAD_ENVIO();

	public abstract void setID_LOCALIDAD_ENVIO(Integer ID_LOCALIDAD_ENVIO);

	public abstract String getCALLE_FACT();

	public abstract void setCALLE_FACT(String CALLE_FACT);

	public abstract Integer getNUMERO_FACT();

	public abstract void setNUMERO_FACT(Integer NUMERO_FACT);

	public abstract String getEDIFICIO_FACT();

	public abstract void setEDIFICIO_FACT(String EDIFICIO_FACT);

	public abstract Integer getPISO_FACT();

	public abstract void setPISO_FACT(Integer PISO_FACT);

	public abstract String getDEPTO_FACT();

	public abstract void setDEPTO_FACT(String DEPTO_FACT);

	public abstract String getCP_FACT();

	public abstract void setCP_FACT(String CP_FACT);

	public abstract Integer getID_PAIS_FACT();

	public abstract void setID_PAIS_FACT(Integer ID_PAIS_FACT);

	public abstract Integer getID_PROVINCIA_FACT();

	public abstract void setID_PROVINCIA_FACT(Integer ID_PROVINCIA_FACT);

	public abstract Integer getID_LOCALIDAD_FACT();

	public abstract void setID_LOCALIDAD_FACT(Integer ID_LOCALIDAD_FACT);

	public abstract Integer getNIVEL_RIESGO();

	public abstract void setNIVEL_RIESGO(Integer NIVEL_RIESGO);

	public abstract String getCOMENTARIOS();

	public abstract void setCOMENTARIOS(String COMENTARIOS);

}


