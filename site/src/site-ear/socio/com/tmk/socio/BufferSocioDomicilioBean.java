/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioDomicilioBean.java,v $
 * Revision 1.6  2006/10/12 14:59:09  omsartori
 * no message
 *
 * Revision 1.5  2006/02/20 12:38:24  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.4  2003/12/04 17:21:06  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/09/27 19:56:34  SLizardo
 * no message
 *
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class BufferSocioDomicilioBean implements EntityBean {

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

	public BufferSocioDomicilioPK ejbCreate(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS, String PROCESADO, String PROCESADO_ECL) throws CreateException {
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
		setPROCESADO(PROCESADO);
		setPROCESADO_ECL(PROCESADO_ECL);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS, String PROCESADO, String PROCESADO_ECL) {
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

	public abstract String getPROCESADO();

	public abstract void setPROCESADO(String PROCESADO);
	
	public abstract String getPROCESADO_ECL();

	public abstract void setPROCESADO_ECL(String PROCESADO_ECL);
}


