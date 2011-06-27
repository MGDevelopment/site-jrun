/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocio.java,v $
 * Revision 1.11  2009/04/15 16:06:57  oClopez
 * version estable de desarrollo
 *
 * Revision 1.10  2008/07/07 18:59:43  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.9  2006/10/12 14:59:08  omsartori
 * no message
 *
 * Revision 1.8  2004/06/09 18:50:13  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.7  2004/05/14 19:19:05  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.6  2003/12/04 17:21:05  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/10/09 20:48:46  SLizardo
 * Cierre de Incidentes
 *
 */
package com.tmk.socio;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface BufferSocio extends EJBObject {

	public Integer getID_SUCURSAL() throws RemoteException;

	public void setID_SUCURSAL(Integer ID_SUCURSAL) throws RemoteException;

	public Integer getID_SOCIO() throws RemoteException;

	public void setID_SOCIO(Integer ID_SOCIO) throws RemoteException;

	public Integer getID_CAAL() throws RemoteException;

	public void setID_CAAL(Integer ID_CAAL) throws RemoteException;

	public Integer getID_TIPO_CONTRIBUYENTE() throws RemoteException;

	public void setID_TIPO_CONTRIBUYENTE(Integer ID_TIPO_CONTRIBUYENTE) throws RemoteException;

	public String getTIPO_PERSONA() throws RemoteException;

	public void setTIPO_PERSONA(String TIPO_PERSONA) throws RemoteException;

	public String getSEXO() throws RemoteException;

	public void setSEXO(String SEXO) throws RemoteException;

	public String getNOMBRES() throws RemoteException;

	public void setNOMBRES(String NOMBRES) throws RemoteException;

	public String getAPELLIDOS() throws RemoteException;

	public void setAPELLIDOS(String APELLIDOS) throws RemoteException;

	public String getTIPO_DOC() throws RemoteException;

	public void setTIPO_DOC(String TIPO_DOC) throws RemoteException;

	public Long getNRO_DOC() throws RemoteException;

	public void setNRO_DOC(Long NRO_DOC) throws RemoteException;

	public Integer getNACIONALIDAD() throws RemoteException;

	public void setNACIONALIDAD(Integer NACIONALIDAD) throws RemoteException;

	public java.sql.Timestamp getFECHA_NACIMIENTO() throws RemoteException;

	public void setFECHA_NACIMIENTO(java.sql.Timestamp FECHA_NACIMIENTO) throws RemoteException;

	public String getESTADO_CIVIL() throws RemoteException;

	public void setESTADO_CIVIL(String ESTADO_CIVIL) throws RemoteException;

	public Integer getHIJOS() throws RemoteException;

	public void setHIJOS(Integer HIJOS) throws RemoteException;

	public Integer getID_PROFESION() throws RemoteException;

	public void setID_PROFESION(Integer ID_PROFESION) throws RemoteException;

	public String getPROCESADO() throws RemoteException;

	public void setPROCESADO(String PROCESADO) throws RemoteException;

	public byte[] getPASSWORD() throws RemoteException;

	public void setPASSWORD(byte[] PASSWORD) throws RemoteException;

	public byte[] getLOGIN() throws RemoteException;

	public void setLOGIN(byte[] LOGIN) throws RemoteException;

	public String getE_MAIL1() throws RemoteException;

	public void setE_MAIL1(String E_MAIL1) throws RemoteException;

	public String getINFO_EXTRA() throws RemoteException;

	public void setINFO_EXTRA(String INFO_EXTRA) throws RemoteException;

	public String getINFO_TERCEROS() throws RemoteException;

	public void setINFO_TERCEROS(String INFO_TERCEROS) throws RemoteException;

	public String getINTERNET_CASA() throws RemoteException;

	public void setINTERNET_CASA(String INTERNET_CASA) throws RemoteException;

	public String getPC_CASA() throws RemoteException;

	public void setPC_CASA(String PC_CASA) throws RemoteException;

	public String getPROCESADO_ECL() throws RemoteException;

	public void setPROCESADO_ECL(String PROCESADO_ECL) throws RemoteException;

	public String getAUXFLAG2() throws RemoteException;

	public void setAUXFLAG2(String AUXFLAG2) throws RemoteException;

}
