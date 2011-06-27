/**
 * @author Lizardo Santiago
 *
 * $Log: SocioTelefono.java,v $
 * Revision 1.3  2003/12/04 17:21:15  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/09/09 15:52:54  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.Date;

public interface SocioTelefono extends EJBObject {

	public Integer getID_SUCURSAL() throws RemoteException;

	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public String getTIPO_TELEFONO() throws RemoteException;

	public void setTIPO_TELEFONO(String TIPO_TELEFONO) throws RemoteException;

	public String getCOD_AREA() throws RemoteException;

	public void setCOD_AREA(String COD_AREA) throws RemoteException;

	public String getNRO_TEL() throws RemoteException;

	public void setNRO_TEL(String NRO_TEL) throws RemoteException;

	public String getEXT_INT() throws RemoteException;

	public void setEXT_INT(String EXT_INT) throws RemoteException;

	public String getCOMENTARIOS() throws RemoteException;

	public void setCOMENTARIOS(String COMENTARIOS) throws RemoteException;

	public Date getF_ALTA() throws RemoteException;

	public void setF_ALTA(Date F_ALTA) throws RemoteException;

	public String getUSR_ALTA() throws RemoteException;

	public void setUSR_ALTA(String USR_ALTA) throws RemoteException;

	public Date getF_MODI() throws RemoteException;

	public void setF_MODI(Date F_MODI) throws RemoteException;

	public String getUSR_MODI() throws RemoteException;

	public void setUSR_MODI(String USR_MODI) throws RemoteException;
}
