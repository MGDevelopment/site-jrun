/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioDomicilio.java,v $
 * Revision 1.6  2006/10/12 14:59:08  omsartori
 * no message
 *
 * Revision 1.5  2006/02/20 12:38:24  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.4  2003/12/04 17:21:06  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/09/27 19:56:33  SLizardo
 * no message
 *
 *
 */
package com.tmk.socio;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface BufferSocioDomicilio extends EJBObject {

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

	public String getPROCESADO() throws RemoteException;

	public void setPROCESADO(String PROCESADO) throws RemoteException;
	
	public String getPROCESADO_ECL() throws RemoteException;

	public void setPROCESADO_ECL(String PROCESADO_ECL) throws RemoteException;

}
