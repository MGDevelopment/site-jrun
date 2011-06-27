/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaLocal.java,v $
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
 * Revision 1.5  2005/09/22 18:37:58  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.4  2004/02/11 19:32:42  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.3  2003/12/04 17:18:36  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/11/11 14:31:34  JMembrives
 * agregado del campo PORC_COMISION_PARTICULAR en alta y modificacion.
 *
 * Revision 1.1  2003/10/11 17:53:48  SLizardo
 * no message
 *
 * Revision 1.5  2003/09/01 15:33:37  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:42  SLizardo
 * no message
 *
 * Revision 1.3  2003/08/15 15:58:52  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.2  2003/07/25 15:58:33  SLizardo
 * *** empty log message ***
 *
 */
package com.tmk.admin;

import javax.ejb.EJBLocalObject;
import java.util.Date;

public interface AlianzaLocal extends EJBLocalObject {

	public Integer getID_ALIANZA();

	public void setID_ALIANZA(Integer ID_ALIANZA);

	public String getRAZON_SOCIAL();

	public void setRAZON_SOCIAL(String RAZON_SOCIAL);

	public String getURL();

	public void setURL(String URL);

	public String getTIPO_NEGOCIO();

	public void setTIPO_NEGOCIO(String TIPO_NEGOCIO);

	public String getCUIT();

	public void setCUIT(String CUIT);

	public String getUSUARIO();

	public void setUSUARIO(String USUARIO);

	public String getCLAVE();

	public void setCLAVE(String CLAVE);

	public Integer getID_TIPO_CONTRIBUYENTE();

	public void setID_TIPO_CONTRIBUYENTE(Integer ID_TIPO_CONTRIBUYENTE);

	public String getNOMBRE_CONTACTO();

	public void setNOMBRE_CONTACTO(String NOMBRE_CONTACTO);

	public String getAPELLIDO_CONTACTO();

	public void setAPELLIDO_CONTACTO(String APELLIDO_CONTACTO);

	public String getCARGO_CONTACTO();

	public void setCARGO_CONTACTO(String CARGO_CONTACTO);

	public String getNOMBRE_PAGO_COMISION();

	public void setNOMBRE_PAGO_COMISION(String NOMBRE_PAGO_COMISION);

	public String getAPELLIDO_PAGO_COMISION();

	public void setAPELLIDO_PAGO_COMISION(String APELLIDO_PAGO_COMISION);

	public String getE_MAIL_1();

	public void setE_MAIL_1(String E_MAIL_1);

	public String getE_MAIL_2();

	public void setE_MAIL_2(String E_MAIL_2);

	public String getTIPO_COMISION();

	public void setTIPO_COMISION(String TIPO_COMISION);

	public Date getFECHA_BAJA();

	public void setFECHA_BAJA(Date FECHA_BAJA);

	public Double getPORC_COMISION_PARTICULAR();

	public void setPORC_COMISION_PARTICULAR(Double PORC_COMISION_PARTICULAR);

    /*socio-alianza*/
    /*public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);*/
    /*socio-alianza*/
}
