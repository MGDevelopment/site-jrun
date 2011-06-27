/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioBean.java,v $
 * Revision 1.10  2008/07/07 18:59:43  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.9  2006/10/12 14:59:08  omsartori
 * no message
 *
 * Revision 1.8  2004/06/09 18:50:14  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.7  2004/05/14 19:19:05  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.6  2003/12/04 17:21:06  GPistoia
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

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

public abstract class BufferSocioBean implements EntityBean {

	private EntityContext context;

	public void ejbLoad() {
	}

	public void ejbStore() {
	}

	public void setEntityContext(EntityContext context) {
		this.context = context;
	}

	public void unsetEntityContext() throws EJBException {
		this.context = null;
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public BufferSocioPK ejbCreate(
	        Integer ID_SUCURSAL,
	        Integer ID_SOCIO,
	        Integer ID_CAAL,
	        Integer ID_TIPO_CONTRIBUYENTE,
	        String TIPO_PERSONA,
	        byte[] LOGIN,
	        String NOMBRES,
	        String APELLIDOS,
	        byte[] PASSWORD,
	        String TIPO_DOC,
	        Long NRO_DOC,
	        Integer NACIONALIDAD,
	        java.sql.Timestamp FECHA_NACIMIENTO,
	        String SEXO,
	        String ESTADO_CIVIL,
	        Integer HIJOS,
	        Integer ID_PROFESION,
	        String PROCESADO,
	        String E_MAIL1,
	        String INFO_EXTRA,
	        String INFO_TERCEROS,
	        String INTERNET_CASA,
	        String PC_CASA,
	        String PROCESADO_ECL,
	        String AUXFLAG2
	        ) throws CreateException {
		setID_SUCURSAL(ID_SUCURSAL);
		setID_SOCIO(ID_SOCIO);
		setID_CAAL(ID_CAAL);
		setID_TIPO_CONTRIBUYENTE(ID_TIPO_CONTRIBUYENTE);
		setTIPO_PERSONA(TIPO_PERSONA);
		setSEXO(SEXO);
		setNOMBRES(NOMBRES);
		setAPELLIDOS(APELLIDOS);
		setTIPO_DOC(TIPO_DOC);
		setNRO_DOC(NRO_DOC);
		setNACIONALIDAD(NACIONALIDAD);
		setFECHA_NACIMIENTO(FECHA_NACIMIENTO);
		setESTADO_CIVIL(ESTADO_CIVIL);
		setHIJOS(HIJOS);
		setID_PROFESION(ID_PROFESION);
		setPASSWORD(PASSWORD);
		setLOGIN(LOGIN);
		setPROCESADO(PROCESADO);
		setE_MAIL1(E_MAIL1);
		setINFO_EXTRA(INFO_EXTRA);
		setINFO_TERCEROS(INFO_TERCEROS);
		setINTERNET_CASA(INTERNET_CASA);
		setPC_CASA(PC_CASA);
		setPROCESADO_ECL(PROCESADO_ECL);
		setAUXFLAG2(AUXFLAG2);
		return null;
	}

	public void ejbPostCreate(
	        Integer ID_SUCURSAL,
	        Integer ID_SOCIO,
	        Integer ID_CAAL,
	        Integer ID_TIPO_CONTRIBUYENTE,
	        String TIPO_PERSONA,
	        byte[] LOGIN,
	        String NOMBRES,
	        String APELLIDOS,
	        byte[] PASSWORD,
	        String TIPO_DOC,
	        Long NRO_DOC,
	        Integer NACIONALIDAD,
	        java.sql.Timestamp FECHA_NACIMIENTO,
	        String SEXO,
	        String ESTADO_CIVIL,
	        Integer HIJOS,
	        Integer ID_PROFESION,
	        String PROCESADO,
	        String E_MAIL1,
	        String INFO_EXTRA,
	        String INFO_TERCEROS,
	        String INTERNET_CASA,
	        String PC_CASA,
	        String PROCESADO_ECL,
	        String AUXFLAG2
	        ) {
	}

	public abstract Integer getID_SUCURSAL();

	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract Integer getID_CAAL();

	public abstract void setID_CAAL(Integer ID_CAAL);

	public abstract Integer getID_TIPO_CONTRIBUYENTE();

	public abstract void setID_TIPO_CONTRIBUYENTE(Integer ID_TIPO_CONTRIBUYENTE);

	public abstract String getTIPO_PERSONA();

	public abstract void setTIPO_PERSONA(String TIPO_PERSONA);

	public abstract String getSEXO();

	public abstract void setSEXO(String SEXO);

	public abstract String getNOMBRES();

	public abstract void setNOMBRES(String NOMBRES);

	public abstract String getAPELLIDOS();

	public abstract void setAPELLIDOS(String APELLIDOS);

	public abstract String getTIPO_DOC();

	public abstract void setTIPO_DOC(String TIPO_DOC);

	public abstract Long getNRO_DOC();

	public abstract void setNRO_DOC(Long NRO_DOC);

	public abstract Integer getNACIONALIDAD();

	public abstract void setNACIONALIDAD(Integer NACIONALIDAD);

	public abstract java.sql.Timestamp getFECHA_NACIMIENTO();

	public abstract void setFECHA_NACIMIENTO(java.sql.Timestamp FECHA_NACIMIENTO);

	public abstract String getESTADO_CIVIL();

	public abstract void setESTADO_CIVIL(String ESTADO_CIVIL);

	public abstract Integer getHIJOS();

	public abstract void setHIJOS(Integer HIJOS);

	public abstract Integer getID_PROFESION();

	public abstract void setID_PROFESION(Integer ID_PROFESION);

	public abstract String getPROCESADO();

	public abstract void setPROCESADO(String PROCESADO);

	public abstract byte[] getPASSWORD();

	public abstract void setPASSWORD(byte[] PASSWORD);

	public abstract byte[] getLOGIN();

	public abstract void setLOGIN(byte[] LOGIN);

	public abstract String getE_MAIL1();

	public abstract void setE_MAIL1(String E_MAIL1);

	public abstract String getINFO_EXTRA();

	public abstract void setINFO_EXTRA(String INFO_EXTRA);

	public abstract String getINFO_TERCEROS();

	public abstract void setINFO_TERCEROS(String INFO_TERCEROS);

	public abstract String getINTERNET_CASA();

	public abstract void setINTERNET_CASA(String INTERNET_CASA);

	public abstract String getPC_CASA();

	public abstract void setPC_CASA(String PC_CASA);

	public abstract String getPROCESADO_ECL();

	public abstract void setPROCESADO_ECL(String PROCESADO_ECL);

	public abstract String getAUXFLAG2();

	public abstract void setAUXFLAG2(String AUXFLAG2);
	
}
