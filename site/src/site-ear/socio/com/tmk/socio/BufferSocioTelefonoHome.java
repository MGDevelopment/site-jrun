/**
 * @author Lizardo Santiago
 *
 * $Log: BufferSocioTelefonoHome.java,v $
 * Revision 1.3  2003/12/04 17:21:10  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/08/05 19:24:27  SLizardo
 * Funcionalidad del caso de Registracion Cubierta
 *
 *
 */
package com.tmk.socio;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;

public interface BufferSocioTelefonoHome extends EJBHome {

	public BufferSocioTelefono create(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_TELEFONO, String COD_AREA, String NRO_TEL, String EXT_INT, String COMENTARIOS, String OPERACION, java.sql.Timestamp F_ALTA, String USR_ALTA, java.sql.Timestamp F_MODI, String USR_MODI, String PROCESADO) throws RemoteException, CreateException;

	public BufferSocioTelefono findByPrimaryKey(BufferSocioTelefonoPK pk) throws RemoteException, FinderException;
}


