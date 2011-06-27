/**
 * @author Lizardo Santiago
 *
 * $Log: SocioLocal.java,v $
 * Revision 1.12  2008/07/07 18:59:45  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.11  2004/06/09 18:50:18  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.10  2004/05/14 19:19:08  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.9  2003/12/04 17:21:14  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.8  2003/10/13 21:43:38  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.7  2003/10/07 17:25:41  SLizardo
 * E_MAIL_1 => E_MAIL1
 *
 * Revision 1.6  2003/10/07 16:19:30  SLizardo
 * E_MAIL_1 para Socios
 *
 */
package com.tmk.socio;

import javax.ejb.EJBLocalObject;

public interface SocioLocal extends EJBLocalObject {

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

	public byte[] getPASSWORD();

	public void setPASSWORD(byte[] PASSWORD);

	public byte[] getLOGIN();

	public void setLOGIN(byte[] LOGIN);

	public String getE_MAIL1();

	public void setE_MAIL1(String E_MAIL1);

	public String getEMAIL();

	public String getINFO_EXTRA();

	public void setINFO_EXTRA(String INFO_EXTRA);

	public String getINFO_TERCEROS();

	public void setINFO_TERCEROS(String INFO_TERCEROS);

	public String getINTERNET_CASA();

	public void setINTERNET_CASA(String INTERNET_CASA);

	public String getPC_CASA();

	public void setPC_CASA(String PC_CASA);
	
	public String getAUXFLAG2();

	public void setAUXFLAG2(String AUXFLAG2);

}
