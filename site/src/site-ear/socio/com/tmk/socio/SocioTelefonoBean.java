/**
 * @author Lizardo Santiago
 *
 * $Log: SocioTelefonoBean.java,v $
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

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import java.util.Date;

public abstract class SocioTelefonoBean implements EntityBean {

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

	public SocioTelefonoPK ejbCreate(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT, String COMENTARIOS, Date F_ALTA, String USR_ALTA, Date F_MODI, String USR_MODI) throws CreateException {
		setID_SUCURSAL(ID_SUCURSAL);
		setID_SOCIO(ID_SOCIO);
		setTIPO_TELEFONO(TIPO_TELEFONO);
		setCOD_AREA(COD_AREA);
		setNRO_TEL(NRO_TEL);
		setEXT_INT(EXT_INT);
		setCOMENTARIOS(COMENTARIOS);
		setF_ALTA(F_ALTA);
		setUSR_ALTA(USR_ALTA);
		setF_MODI(F_MODI);
		setUSR_MODI(USR_MODI);
		return null;
	}

	public void ejbPostCreate(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT, String COMENTARIOS, Date F_ALTA, String USR_ALTA, Date F_MODI, String USR_MODI) {
	}

	public abstract Integer getID_SUCURSAL();

	public abstract void setID_SUCURSAL(Integer ID_SUCURSAL);

	public abstract Integer getID_SOCIO();

	public abstract void setID_SOCIO(Integer ID_SOCIO);

	public abstract String getTIPO_TELEFONO();

	public abstract void setTIPO_TELEFONO(String TIPO_TELEFONO);

	public abstract String getCOD_AREA();

	public abstract void setCOD_AREA(String COD_AREA);

	public abstract String getNRO_TEL();

	public abstract void setNRO_TEL(String NRO_TEL);

	public abstract String getEXT_INT();

	public abstract void setEXT_INT(String EXT_INT);

	public abstract String getCOMENTARIOS();

	public abstract void setCOMENTARIOS(String COMENTARIOS);

	public abstract Date getF_ALTA();

	public abstract void setF_ALTA(Date F_ALTA);

	public abstract String getUSR_ALTA();

	public abstract void setUSR_ALTA(String USR_ALTA);

	public abstract Date getF_MODI();

	public abstract void setF_MODI(Date F_MODI);

	public abstract String getUSR_MODI();

	public abstract void setUSR_MODI(String USR_MODI);
}
