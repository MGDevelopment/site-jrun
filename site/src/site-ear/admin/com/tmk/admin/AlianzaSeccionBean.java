/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaSeccionBean.java,v $
 * Revision 1.3  2005/09/22 18:37:59  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.2  2003/12/04 17:18:37  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:50  SLizardo
 * no message
 *
 * Revision 1.7  2003/10/03 16:28:38  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/09/01 20:06:24  SLizardo
 * no message
 *
 * Revision 1.5  2003/09/01 15:33:36  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:43  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:53  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 15:55:12  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import java.util.Date;

public abstract class AlianzaSeccionBean implements EntityBean {

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

	public AlianzaSeccionPK ejbCreate(Integer ID_SECCION, Integer ID_ALIANZA, String SECCION_NOMBRE) throws CreateException {
		setID_SECCION(ID_SECCION);
		setID_ALIANZA(ID_ALIANZA);
		setSECCION_NOMBRE(SECCION_NOMBRE);
		return null;
	}

	public void ejbPostCreate(Integer ID_SECCION, Integer ID_ALIANZA, String SECCION_NOMBRE) {
	}

	// cmp field methods
	public abstract Integer getID_SECCION();

	public abstract void setID_SECCION(Integer ID_SECCION);

	public abstract Integer getID_ALIANZA();

	public abstract void setID_ALIANZA(Integer ID_ALIANZA);

	public abstract String getSECCION_NOMBRE();

	public abstract void setSECCION_NOMBRE(String SECCION_NOMBRE);

	public abstract Date getFECHA_BAJA();

	public abstract void setFECHA_BAJA(Date FECHA_BAJA);
}
