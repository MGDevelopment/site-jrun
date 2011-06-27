/**
 * @author Lizardo Santiago
 *
 * $Log: TarjetaSocioLocal.java,v $
 * Revision 1.5  2003/12/04 17:21:17  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.4  2003/10/09 19:30:14  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.3  2003/09/09 15:17:10  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.EJBLocalObject;

public interface TarjetaSocioLocal extends EJBLocalObject {

	public Integer getID_SUCURSAL_SOCIO();

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO);

	public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public Integer getID_ITEM();

	public void setID_ITEM(Integer ID_ITEM);

	public String getID_MEDIO_COBRO();

	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO);

	public byte[] getNRO_TARJETA();

	public void setNRO_TARJETA(byte[] NRO_TARJETA);

	public String getNOMBRE_TITULAR();

	public void setNOMBRE_TITULAR(String NOMBRE_TITULAR);

	public String getTIPO_DOC();

	public void setTIPO_DOC(String TIPO_DOC);

	public Long getNRO_DOC();

	public void setNRO_DOC(Long NRO_DOC);

	public String getDIRECCION_RESUMEN();

	public void setDIRECCION_RESUMEN(String DIRECCION_RESUMEN);
}
