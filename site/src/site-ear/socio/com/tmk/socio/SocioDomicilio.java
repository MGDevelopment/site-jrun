/**
 * @author Lizardo Santiago
 *
 * $Log: SocioDomicilio.java,v $
 * Revision 1.6  2004/12/27 15:42:28  omsartori
 * - chequeo de direcciones que no se deben modificar
 * - reporte de compras por socio con un demonio
 * - reporte de socios registrados con un demonio
 *
 * Revision 1.5  2003/12/04 17:21:11  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.4  2003/11/19 18:55:43  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.3  2003/09/09 15:52:50  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface SocioDomicilio extends EJBObject {

	public Integer getID_SUCURSAL() throws RemoteException;

	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public String getTIPO_DOMICILIO() throws RemoteException;

	public void setTIPO_DOMICILIO(String TIPO_DOMICILIO) throws RemoteException;

	public String getCALLE() throws RemoteException;

	public void setCALLE(String CALLE) throws RemoteException;

	public Integer getNUMERO() throws RemoteException;

	public void setNUMERO(Integer NUMERO) throws RemoteException;

	public String getEDIFICIO() throws RemoteException;

	public void setEDIFICIO(String EDIFICIO) throws RemoteException;

	public Integer getPISO() throws RemoteException;

	public void setPISO(Integer PISO) throws RemoteException;

	public String getDEPTO() throws RemoteException;

	public void setDEPTO(String DEPTO) throws RemoteException;

	public String getCP() throws RemoteException;

	public void setCP(String CP) throws RemoteException;

	public Integer getID_LOCALIDAD() throws RemoteException;

	public void setID_LOCALIDAD(Integer ID_LOCALIDAD) throws RemoteException;

	public Integer getID_PROVINCIA() throws RemoteException;

	public void setID_PROVINCIA(Integer ID_PROVINCIA) throws RemoteException;

	public Integer getID_PAIS() throws RemoteException;

	public void setID_PAIS(Integer ID_PAIS) throws RemoteException;

	public String getDESCRIPCION_PROVINCIA_INEX() throws RemoteException;

	public void setDESCRIPCION_PROVINCIA_INEX(String DESCRIPCION_PROVINCIA_INEX) throws RemoteException;

	public String getDESCRIPCION_LOCALIDAD_INEX() throws RemoteException;

	public void setDESCRIPCION_LOCALIDAD_INEX(String DESCRIPCION_LOCALIDAD_INEX) throws RemoteException;

	public boolean getEsEditable ();

	public Integer getID_ORDEN ();
}


