/**
 * @author Lizardo Santiago
 *
 * $Log: TarjetaSocio.java,v $
 * Revision 1.5  2003/12/04 17:21:16  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.4  2003/10/09 19:30:13  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.3  2003/09/09 15:17:09  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface TarjetaSocio extends EJBObject {

	public Integer getID_SUCURSAL_SOCIO() throws RemoteException;

	public void setID_SUCURSAL_SOCIO(Integer ID_SUCURSAL_SOCIO) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Integer getID_ITEM() throws RemoteException;

	public void setID_ITEM(Integer ID_ITEM) throws RemoteException;

	public String getID_MEDIO_COBRO() throws RemoteException;

	public void setID_MEDIO_COBRO(String ID_MEDIO_COBRO) throws RemoteException;

	public byte[] getNRO_TARJETA() throws RemoteException;

	public void setNRO_TARJETA(byte[] NRO_TARJETA) throws RemoteException;

	public String getNOMBRE_TITULAR() throws RemoteException;

	public void setNOMBRE_TITULAR(String NOMBRE_TITULAR) throws RemoteException;

	public String getTIPO_DOC() throws RemoteException;

	public void setTIPO_DOC(String TIPO_DOC) throws RemoteException;

	public Long getNRO_DOC() throws RemoteException;

	public void setNRO_DOC(Long NRO_DOC) throws RemoteException;

	public String getDIRECCION_RESUMEN() throws RemoteException;

	public void setDIRECCION_RESUMEN(String DIRECCION_RESUMEN) throws RemoteException;
}
