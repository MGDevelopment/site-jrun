/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioDomicilioLocal.java,v $
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
 * Revision 1.4  2003/12/04 17:21:07  GPistoia
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

import javax.ejb.EJBLocalObject;

public interface BufferSocioDomicilioLocal extends EJBLocalObject {

	public Integer getID_SUCURSAL();

	public void setID_SUCURSAL(Integer ID_SUCURSAL);

	public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public String getTIPO_DOMICILIO();

	public void setTIPO_DOMICILIO(String TIPO_DOMICILIO);

	public String getCALLE();

	public void setCALLE(String CALLE);

	public Integer getNUMERO();

	public void setNUMERO(Integer NUMERO);

	public String getEDIFICIO();

	public void setEDIFICIO(String EDIFICIO);

	public Integer getPISO();

	public void setPISO(Integer PISO);

	public String getDEPTO();

	public void setDEPTO(String DEPTO);

	public String getCP();

	public void setCP(String CP);

	public Integer getID_LOCALIDAD();

	public void setID_LOCALIDAD(Integer ID_LOCALIDAD);

	public Integer getID_PROVINCIA();

	public void setID_PROVINCIA(Integer ID_PROVINCIA);

	public Integer getID_PAIS();

	public void setID_PAIS(Integer ID_PAIS);

	public String getPROCESADO();

	public void setPROCESADO(String PROCESADO);
	
	public String getPROCESADO_ECL();

	public void setPROCESADO_ECL(String PROCESADO_ECL);
}
