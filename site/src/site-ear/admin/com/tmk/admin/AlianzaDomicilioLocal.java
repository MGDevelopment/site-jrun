/**
 * @author Lizardo Santiago
 *
 * $Log: AlianzaDomicilioLocal.java,v $
 * Revision 1.2  2003/12/04 17:18:35  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/11 17:53:46  SLizardo
 * no message
 *
 * Revision 1.5  2003/09/01 15:33:38  SLizardo
 * Administracion de Alianzas.
 *
 * Revision 1.4  2003/08/25 18:22:41  SLizardo
 * no message
 *
 */
package com.tmk.admin;

import javax.ejb.EJBLocalObject;

public interface AlianzaDomicilioLocal extends EJBLocalObject {

	public Integer getID_ALIANZA();

	public void setID_ALIANZA(Integer ID_ALIANZA);

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
}
