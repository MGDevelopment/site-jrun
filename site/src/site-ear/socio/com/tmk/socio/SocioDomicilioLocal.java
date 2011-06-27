/**
 * @author Lizardo Santiago
 *
 * $Log: SocioDomicilioLocal.java,v $
 * Revision 1.6  2004/12/27 15:42:33  omsartori
 * - chequeo de direcciones que no se deben modificar
 * - reporte de compras por socio con un demonio
 * - reporte de socios registrados con un demonio
 *
 * Revision 1.5  2003/12/04 17:21:12  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.4  2003/11/19 18:55:45  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.3  2003/09/09 15:52:51  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.EJBLocalObject;

public interface SocioDomicilioLocal extends EJBLocalObject {

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

	public String getDESCRIPCION_PROVINCIA_INEX();

	public void setDESCRIPCION_PROVINCIA_INEX(String DESCRIPCION_PROVINCIA_INEX);

	public String getDESCRIPCION_LOCALIDAD_INEX();

	public void setDESCRIPCION_LOCALIDAD_INEX(String DESCRIPCION_LOCALIDAD_INEX);

    public boolean getEsEditable ();

	public Integer getID_ORDEN ();
}
