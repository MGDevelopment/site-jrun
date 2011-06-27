/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioLocal.java,v $
 * Revision 1.10  2008/07/07 18:59:43  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.9  2006/10/12 14:59:09  omsartori
 * no message
 *
 * Revision 1.8  2004/06/09 18:50:15  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.7  2004/05/14 19:19:06  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.6  2003/12/04 17:21:08  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.5  2003/10/09 20:48:47  SLizardo
 * Cierre de Incidentes
 *
 */
package com.tmk.socio;

import javax.ejb.EJBLocalObject;

public interface BufferSocioLocal extends EJBLocalObject {

	public Integer getID_SUCURSAL();

	public void setID_SUCURSAL(Integer ID_SUCURSAL);

	public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public Integer getID_CAAL();

	public void setID_CAAL(Integer ID_CAAL);

	public Integer getID_TIPO_CONTRIBUYENTE();

	public void setID_TIPO_CONTRIBUYENTE(Integer ID_TIPO_CONTRIBUYENTE);

	public String getTIPO_PERSONA();

	public void setTIPO_PERSONA(String TIPO_PERSONA);

	public String getSEXO();

	public void setSEXO(String SEXO);

	public String getNOMBRES();

	public void setNOMBRES(String NOMBRES);

	public String getAPELLIDOS();

	public void setAPELLIDOS(String APELLIDOS);

	public String getTIPO_DOC();

	public void setTIPO_DOC(String TIPO_DOC);

	public Long getNRO_DOC();

	public void setNRO_DOC(Long NRO_DOC);

	public Integer getNACIONALIDAD();

	public void setNACIONALIDAD(Integer NACIONALIDAD);

	public java.sql.Timestamp getFECHA_NACIMIENTO();

	public void setFECHA_NACIMIENTO(java.sql.Timestamp FECHA_NACIMIENTO);

	public String getESTADO_CIVIL();

	public void setESTADO_CIVIL(String ESTADO_CIVIL);

	public Integer getHIJOS();

	public void setHIJOS(Integer HIJOS);

	public Integer getID_PROFESION();

	public void setID_PROFESION(Integer ID_PROFESION);

	public String getPROCESADO();

	public void setPROCESADO(String PROCESADO);

	public byte[] getPASSWORD();

	public void setPASSWORD(byte[] PASSWORD);

	public byte[] getLOGIN();

	public void setLOGIN(byte[] LOGIN);

	public String getE_MAIL1();

	public void setE_MAIL1(String E_MAIL1);

	public String getINFO_EXTRA();

	public void setINFO_EXTRA(String INFO_EXTRA);

	public String getINFO_TERCEROS();

	public void setINFO_TERCEROS(String INFO_TERCEROS);

	public String getINTERNET_CASA();

	public void setINTERNET_CASA(String INTERNET_CASA);

	public String getPC_CASA();

	public void setPC_CASA(String PC_CASA);

	public String getPROCESADO_ECL();

	public void setPROCESADO_ECL(String PROCESADO_ECL);
	
	public String getAUXFLAG2();

	public void setAUXFLAG2(String AUXFLAG2);

}


