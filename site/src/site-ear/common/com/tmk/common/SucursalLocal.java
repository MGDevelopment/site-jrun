/**
 * @author Lizardo Santiago
 *
 * $Log: SucursalLocal.java,v $
 * Revision 1.6  2003/10/03 16:29:00  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/09/16 23:08:26  SLizardo
 * Administracion de Eventos
 *
 *
 */
package com.tmk.common;

import javax.ejb.EJBLocalObject;
import java.util.Date;

public interface SucursalLocal extends EJBLocalObject {

	public Integer getID_SUCURSAL();

	public void setID_SUCURSAL(Integer ID_SUCURSAL);

	public String getDESCRIPCION();

	public void setDESCRIPCION(String DESCRIPCION);

	public Date getFECHA_APERTURA();

	public void setFECHA_APERTURA(Date FECHA_APERTURA);

	public String getDIRECCION();

	public void setDIRECCION(String DIRECCION);

	public Integer getID_PAIS();

	public void setID_PAIS(Integer ID_PAIS);

	public Integer getID_PROVINCIA();

	public void setID_PROVINCIA(Integer ID_PROVINCIA);

	public Integer getID_LOCALIDAD();

	public void setID_LOCALIDAD(Integer ID_LOCALIDAD);

	public String getCODIGO_POSTAL();

	public void setCODIGO_POSTAL(String CODIGO_POSTAL);

	public String getTELEFONO();

	public void setTELEFONO(String TELEFONO);

	public String getFAX();

	public void setFAX(String FAX);

	public String getEMAIL();

	public void setEMAIL(String EMAIL);
}
