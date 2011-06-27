/**
 * @author Lizardo Santiago
 *
 * $Log: SocioTelefonoLocal.java,v $
 * Revision 1.3  2003/12/04 17:21:15  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/09/09 15:52:55  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.EJBLocalObject;
import java.util.Date;

public interface SocioTelefonoLocal extends EJBLocalObject {

	public Integer getID_SUCURSAL();

	public void setID_SUCURSAL(Integer ID_SUCURSAL);

	public Integer getID_SOCIO();

	public void setID_SOCIO(Integer ID_SOCIO);

	public String getTIPO_TELEFONO();

	public void setTIPO_TELEFONO(String TIPO_TELEFONO);

	public String getCOD_AREA();

	public void setCOD_AREA(String COD_AREA);

	public String getNRO_TEL();

	public void setNRO_TEL(String NRO_TEL);

	public String getEXT_INT();

	public void setEXT_INT(String EXT_INT);

	public String getCOMENTARIOS();

	public void setCOMENTARIOS(String COMENTARIOS);

	public Date getF_ALTA();

	public void setF_ALTA(Date F_ALTA);

	public String getUSR_ALTA();

	public void setUSR_ALTA(String USR_ALTA);

	public Date getF_MODI();

	public void setF_MODI(Date F_MODI);

	public String getUSR_MODI();

	public void setUSR_MODI(String USR_MODI);

}


