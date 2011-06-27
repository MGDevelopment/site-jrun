/**
 * @author Lizardo Santiago
 *
 * $Log: SocioTelefonoLocalHome.java,v $
 * Revision 1.4  2003/12/04 17:21:16  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.3  2003/09/09 15:52:55  SLizardo
 * equals() y hashCode() agregados a la PK.
 *
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;
import java.util.Date;

public interface SocioTelefonoLocalHome extends EJBLocalHome {

	public SocioTelefonoLocal create(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT, String COMENTARIOS, Date F_ALTA, String USR_ALTA, Date F_MODI, String USR_MODI) throws CreateException;

	public SocioTelefonoLocal findByPrimaryKey(SocioTelefonoPK pk) throws FinderException;

	public Collection findBySocio(Integer ID_SUCURSAL, Integer ID_SOCIO) throws FinderException;
}


