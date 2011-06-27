package com.tmk.socio;

import com.tmk.kernel.DBUtil;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class SocioDomicilioBean implements EntityBean {

	private EntityContext context;
    private boolean esEditable = true;
	private Integer id_orden = null;

	public void ejbLoad() {
		try {
			id_orden = DBUtil.ordenesEnProcesoPorDireccion(getID_SOCIO(), getID_SUCURSAL(), getTIPO_DOMICILIO());
			esEditable = (id_orden == null);
		}
		catch (Exception e)	{
		}
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

	public SocioDomicilioPK ejbCreate(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS, String DESCRIPCION_PROVINCIA_INEX, String DESCRIPCION_LOCALIDAD_INEX) throws CreateException {
		setID_SUCURSAL(ID_SUCURSAL);
		setID_SOCIO(ID_SOCIO);
		setTIPO_DOMICILIO(TIPO_DOMICILIO);
		setCALLE(CALLE);
		setNUMERO(NUMERO);
		setEDIFICIO(EDIFICIO);
		setPISO(PISO);
		setDEPTO(DEPTO);
		setCP(CP);
		setID_LOCALIDAD(ID_LOCALIDAD);
		setID_PROVINCIA(ID_PROVINCIA);
		setID_PAIS(ID_PAIS);
		setDESCRIPCION_PROVINCIA_INEX(DESCRIPCION_PROVINCIA_INEX);
		setDESCRIPCION_LOCALIDAD_INEX(DESCRIPCION_LOCALIDAD_INEX);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS, String DESCRIPCION_PROVINCIA_INEX, String DESCRIPCION_LOCALIDAD_INEX) {
	}

	public abstract Integer getID_SUCURSAL();

	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract String getTIPO_DOMICILIO();

	public abstract void setTIPO_DOMICILIO(String TIPO_DOMICILIO);

	public abstract String getCALLE();

	public abstract void setCALLE(String CALLE);

	public abstract Integer getNUMERO();

	public abstract void setNUMERO(Integer NUMERO);

	public abstract String getEDIFICIO();

	public abstract void setEDIFICIO(String EDIFICIO);

	public abstract Integer getPISO();

	public abstract void setPISO(Integer PISO);

	public abstract String getDEPTO();

	public abstract void setDEPTO(String DEPTO);

	public abstract String getCP();

	public abstract void setCP(String CP);

	public abstract Integer getID_LOCALIDAD();

	public abstract void setID_LOCALIDAD(Integer ID_LOCALIDAD);

	public abstract Integer getID_PROVINCIA();

	public abstract void setID_PROVINCIA(Integer ID_PROVINCIA);

	public abstract Integer getID_PAIS();

	public abstract void setID_PAIS(Integer ID_PAIS);

	public abstract String getDESCRIPCION_PROVINCIA_INEX();

	public abstract void setDESCRIPCION_PROVINCIA_INEX(String DESCRIPCION_PROVINCIA_INEX);

	public abstract String getDESCRIPCION_LOCALIDAD_INEX();

	public abstract void setDESCRIPCION_LOCALIDAD_INEX(String DESCRIPCION_LOCALIDAD_INEX);

	public boolean getEsEditable () {
		return esEditable;
	}

	public Integer getID_ORDEN () {
		return id_orden;
	}
}

