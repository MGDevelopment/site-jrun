/**
 * $Log: MemoriaDaemon.java,v $
 * Revision 1.4  2004/07/12 19:51:59  oGPistoia
 * - Correccion del director en el detalle reducido del buscador
 * - Correccion del bug de AgregarProducto
 *
 * Revision 1.3  2004/02/27 13:44:13  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.2  2003/12/22 22:26:49  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.1  2003/10/12 22:11:19  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 */
package com.tmk.common;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;

public class MemoriaDaemon extends Daemon {

	public MemoriaDaemon() {
		super(Daemon.UN_MINUTO, Daemon.DIEZ_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {
		// En realidad no hace nada, solo imprime los valores
	}

	public String getMensaje() {
		StringBuffer texto = new StringBuffer();
		texto.append("Memoria: Libre ").append(Runtime.getRuntime().freeMemory() / 1024).append(" Kbs");
		texto.append(", Total ").append(Runtime.getRuntime().totalMemory() / 1024).append(" Kbs");
		texto.append(", Alerta ").append(Globals.MEMORIA_ALERTA).append(" Kbs");
		texto.append(", Limite ").append(Globals.MEMORIA_MAXIMA).append(" Kbs");
		texto.append(", Disponible ").append(Runtime.getRuntime().maxMemory() / 1024).append(" Kbs");
		return texto.toString();
	}

	protected boolean pausada() {
		return false; // Siempre puede funcionar
	}
}
