/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaBean.java,v $
 * Revision 1.9  2006/10/12 14:58:27  omsartori
 * no message
 *
 * Revision 1.8  2006/06/05 12:39:44  omsartori
 * - Modificacion de nuevas recomendaciones
 *
 * Revision 1.7  2006/02/09 16:15:32  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.6  2006/01/31 15:51:24  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.5  2005/09/22 18:37:56  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.4  2004/02/11 19:32:41  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.3  2003/12/04 17:18:34  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/11/11 14:31:33  JMembrives
 * agregado del campo PORC_COMISION_PARTICULAR en alta y modificacion.
 *
 * Revision 1.1  2003/10/11 17:53:44  SLizardo
 * no message
 *
 * Revision 1.7  2003/10/03 16:28:35  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.6  2003/09/01 15:33:40  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.5  2003/08/25 18:22:39  SLizardo
 * no message
 *
 * Revision 1.4  2003/08/15 15:58:50  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.3  2003/07/25 19:58:20  SLizardo
 * no message
 *
 * Revision 1.2  2003/07/25 16:03:47  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;
 
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import java.util.Date;

public abstract class AlianzaBean implements EntityBean {

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

	public Integer ejbCreate(Integer ID_ALIANZA, String RAZON_SOCIAL, String URL, String TIPO_NEGOCIO, String CUIT, String USUARIO, String CLAVE, Integer ID_TIPO_CONTRIBUYENTE, String NOMBRE_CONTACTO, String APELLIDO_CONTACTO, String CARGO_CONTACTO, String NOMBRE_PAGO_COMISION, String APELLIDO_PAGO_COMISION, String E_MAIL_1, String E_MAIL_2, String TIPO_COMISION, Double PORC_COMISION_PARTICULAR) throws CreateException {
		setID_ALIANZA(ID_ALIANZA);
		setRAZON_SOCIAL(RAZON_SOCIAL);
		setURL(URL);
		setTIPO_NEGOCIO(TIPO_NEGOCIO);
		setCUIT(CUIT);
		setUSUARIO(USUARIO);
		setCLAVE(CLAVE);
		setID_TIPO_CONTRIBUYENTE(ID_TIPO_CONTRIBUYENTE);
		setNOMBRE_CONTACTO(NOMBRE_CONTACTO);
		setAPELLIDO_CONTACTO(APELLIDO_CONTACTO);
		setCARGO_CONTACTO(CARGO_CONTACTO);
		setNOMBRE_PAGO_COMISION(NOMBRE_PAGO_COMISION);
		setAPELLIDO_PAGO_COMISION(APELLIDO_PAGO_COMISION);
		setE_MAIL_1(E_MAIL_1);
		setE_MAIL_2(E_MAIL_2);
		setTIPO_COMISION(TIPO_COMISION);
		setPORC_COMISION_PARTICULAR(PORC_COMISION_PARTICULAR);
        /*socio-alianza*/
        //setID_SOCIO(ID_SOCIO);
        /*socio-alianza*/
		return null;
	}

	public void ejbPostCreate(Integer ID_ALIANZA, String RAZON_SOCIAL, String URL, String TIPO_NEGOCIO, String CUIT, String USUARIO, String CLAVE, Integer ID_TIPO_CONTRIBUYENTE, String NOMBRE_CONTACTO, String APELLIDO_CONTACTO, String CARGO_CONTACTO, String NOMBRE_PAGO_COMISION, String APELLIDO_PAGO_COMISION, String E_MAIL_1, String E_MAIL_2, String TIPO_COMISION, Double PORC_COMISION_PARTICULAR) {
	}

	// cmp field methods
	public abstract Integer getID_ALIANZA();

	public abstract void setID_ALIANZA(Integer ID_ALIANZA);

	public abstract String getRAZON_SOCIAL();

	public abstract void setRAZON_SOCIAL(String RAZON_SOCIAL);

	public abstract String getURL();

	public abstract void setURL(String URL);

	public abstract String getTIPO_NEGOCIO();

	public abstract void setTIPO_NEGOCIO(String TIPO_NEGOCIO);

	public abstract String getCUIT();

	public abstract void setCUIT(String CUIT);

	public abstract String getUSUARIO();

	public abstract void setUSUARIO(String USUARIO);

	public abstract String getCLAVE();

	public abstract void setCLAVE(String CLAVE);

	public abstract Integer getID_TIPO_CONTRIBUYENTE();

	public abstract void setID_TIPO_CONTRIBUYENTE(Integer ID_TIPO_CONTRIBUYENTE);

	public abstract String getNOMBRE_CONTACTO();

	public abstract void setNOMBRE_CONTACTO(String NOMBRE_CONTACTO);

	public abstract String getAPELLIDO_CONTACTO();

	public abstract void setAPELLIDO_CONTACTO(String APELLIDO_CONTACTO);

	public abstract String getCARGO_CONTACTO();

	public abstract void setCARGO_CONTACTO(String CARGO_CONTACTO);

	public abstract String getNOMBRE_PAGO_COMISION();

	public abstract void setNOMBRE_PAGO_COMISION(String NOMBRE_PAGO_COMISION);

	public abstract String getAPELLIDO_PAGO_COMISION();

	public abstract void setAPELLIDO_PAGO_COMISION(String APELLIDO_PAGO_COMISION);

	public abstract String getE_MAIL_1();

	public abstract void setE_MAIL_1(String E_MAIL_1);

	public abstract String getE_MAIL_2();

	public abstract void setE_MAIL_2(String E_MAIL_2);

	public abstract String getTIPO_COMISION();

	public abstract void setTIPO_COMISION(String TIPO_COMISION);

	public abstract Date getFECHA_BAJA();

	public abstract void setFECHA_BAJA(Date FECHA_BAJA);

	public abstract Double getPORC_COMISION_PARTICULAR();

	public abstract void setPORC_COMISION_PARTICULAR(Double PORC_COMISION_PARTICULAR);

    /*socio-alianza*/

/*    public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);*/

    /*socio-alianza*/
}