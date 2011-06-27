/**
 * $Log: ConexionDaemon.java,v $
 * Revision 1.5  2004/07/12 19:51:58  oGPistoia
 * - Correccion del director en el detalle reducido del buscador
 * - Correccion del bug de AgregarProducto
 *
 * Revision 1.4  2004/03/04 18:51:36  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.3  2003/12/04 17:19:05  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.2  2003/11/07 15:32:54  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.1  2003/10/12 22:11:18  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 */
package com.tmk.common;

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.Pair;

public class ConexionDaemon extends Daemon {

	protected StringBuffer message;

	public ConexionDaemon() {
		super(Daemon.UN_MINUTO, Daemon.CINCO_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {
		message = null;
		Pair datos[] = DBUtil.usuariosConectados();
		message = new StringBuffer("Usuario ");
		int total = 0;
		for (int i = 0; i < datos.length; i++) {
			String nombre = datos[i].getValue1().toString();
			int cantidad = ((Number) datos[i].getValue2()).intValue();
			total += cantidad;
			message.append(nombre).append("(").append(cantidad).append("), ");
		}
		message.append("total de conexiones: " + total);
	}

	public String getMensaje() {
		return message.toString();
	}

	protected boolean pausada() {
		return Globals.baseDeDatosEnMantenimiento() || Globals.esModoRelease();
	}
}
