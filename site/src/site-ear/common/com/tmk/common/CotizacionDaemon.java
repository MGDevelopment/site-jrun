/**
 * $Log: CotizacionDaemon.java,v $
 * Revision 1.5  2004/06/15 20:56:00  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.4  2004/06/09 18:49:00  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.3  2004/05/04 18:09:27  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.2  2003/12/04 17:19:05  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
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

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;

public class CotizacionDaemon extends Daemon {

	public CotizacionDaemon() {
		super(Daemon.CINCO_SEGUNDOS, Daemon.UNA_HORA);
	}

	protected void ejecutarTarea() throws Exception {
		Globals.TASA_DOLLAR = DBUtil.cargarUltimaCotizacion(Globals.MONEDA_DOLLAR);
		Globals.TASA_EURO = DBUtil.cargarUltimaCotizacion(Globals.MONEDA_EURO);
	}

	protected String getMensaje() {
		return "Cotizacion Dollar: " + Globals.TASA_DOLLAR + ". Cotizacion Euro: " + Globals.TASA_EURO;
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento() || ((Globals.MONEDA_DOLLAR == 0) && (Globals.MONEDA_EURO == 0)));
	}
}

