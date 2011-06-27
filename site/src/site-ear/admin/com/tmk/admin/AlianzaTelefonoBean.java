/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaTelefonoBean.java,v $
 * Revision 1.3  2005/09/22 18:38:01  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:39  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:53  SLizardo
 * no message
 *
 * Revision 1.6  2003/10/03 16:28:39  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/09/01 15:33:34  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:46  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:54  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 15:45:53  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class AlianzaTelefonoBean implements EntityBean {

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

	public AlianzaTelefonoPK ejbCreate(Integer ID_ALIANZA, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT) throws CreateException {
		setID_ALIANZA(ID_ALIANZA);
		setTIPO_TELEFONO(TIPO_TELEFONO);
		setCOD_AREA(COD_AREA);
		setNRO_TEL(NRO_TEL);
		setEXT_INT(EXT_INT);
		return null;
	}

	public void ejbPostCreate(Integer ID_ALIANZA, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT) {
	}

	// cmp field methods
	public abstract Integer getID_ALIANZA();

	public abstract void setID_ALIANZA(Integer ID_ALIANZA);

	public abstract String getTIPO_TELEFONO();

	public abstract void setTIPO_TELEFONO(String TIPO_TELEFONO);

	public abstract String getCOD_AREA();

	public abstract void setCOD_AREA(String COD_AREA);

	public abstract String getNRO_TEL();

	public abstract void setNRO_TEL(String NRO_TEL);

	public abstract String getEXT_INT();

	public abstract void setEXT_INT(String EXT_INT);
}