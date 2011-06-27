/**
 * $ Log $
 */

package com.tmk.common;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.DBUtil;
import java.util.Vector;
import java.util.Calendar;

public class ReporteDeComprasPorAlianzasDaemon extends Daemon {
	static public Vector comprasPorAlianzas = new Vector();


	public ReporteDeComprasPorAlianzasDaemon() {
		super(Daemon.CINCO_MINUTOS , Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {
	    comprasPorAlianzas = DBUtil.comprasPorAlianzas();
		MailUtil.sendMail(
		        Globals.MAIL_MAILER,
		        Globals.MAIL_ALIANZAS,
		        Globals.NOMBRE_DEL_SITIO + " - Reporte de Compras por Alianzas en el mes anterior",
		        "No se genero el listado de compras por alianzas en el mes anterior, se procesará más tarde.",
		        "/mailing/comprasPorAlianzas.jsp");
	}

	protected String getMensaje() {
		return "Reporte de Compras por alianzas en el mes anterior";
	}

	protected boolean pausada() {
		return Globals.baseDeDatosEnMantenimiento()
		    || (!Globals.esHorarioDeReporte(8, 50, false))
		        || (Calendar.getInstance().get(Calendar.DATE) > 2);   // Para que llegue el 1 y el 2*/
	}

}