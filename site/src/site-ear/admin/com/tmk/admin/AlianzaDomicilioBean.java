/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaDomicilioBean.java,v $
 * Revision 1.3  2005/09/22 18:37:57  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:34  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:45  SLizardo
 * no message
 *
 * Revision 1.6  2003/10/03 16:28:36  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/09/01 15:33:39  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:40  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:50  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 16:03:25  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class AlianzaDomicilioBean implements EntityBean {

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

	public AlianzaDomicilioPK ejbCreate(Integer ID_ALIANZA, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS) throws CreateException {
		setID_ALIANZA(ID_ALIANZA);
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
		return null;
	}

	public void ejbPostCreate(Integer ID_ALIANZA, String TIPO_DOMICILIO, String CALLE, Integer NUMERO, String EDIFICIO, Integer PISO, String DEPTO, String CP, Integer ID_LOCALIDAD, Integer ID_PROVINCIA, Integer ID_PAIS) {
	}

	// cmp field methods
	public abstract Integer getID_ALIANZA();

	public abstract void setID_ALIANZA(Integer ID_ALIANZA);

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
}


