/**
 * $Log: SessionTracker.java,v $
 * Revision 1.2  2007/06/11 18:37:33  omsartori
 * - Log de busquedas
 *
 * Revision 1.1  2006/01/13 15:45:51  omsartori
 * -Doc 11 Empro
 *   -Tracking de Sessiones
 *
 */
package com.tmk.controllers.alianza;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.TmkLogger;

import java.util.Vector;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

public class SessionTracker extends Daemon{
	private static String logPath = "d:\\tematika\\";
	private static String logFile = "tmkSessionTrack.log";
	private Vector lista = new Vector();
	private static SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
	private static SimpleDateFormat formatoDeFechaArchivo = new SimpleDateFormat("yyMMddHHmmss");
	private static long tamMaximo =4194304; //en bytes

	static SessionTracker instance = new SessionTracker();

	SessionTracker() {
		super(Daemon.UN_SEGUNDO, Daemon.TREINTA_SEGUNDOS);
	}

	synchronized protected void ejecutarTarea() {
		File file = new File(logPath + logFile);
		if (file.length() >= tamMaximo) {
			file.renameTo(new File(logPath + logFile + formatoDeFechaArchivo.format(new Date())));
			file = new File(logPath + logFile);
		}
		try {
			FileWriter outs = new FileWriter(file, true);

			for (int i = 0; i<lista.size(); i++) {
				outs.write(lista.get(i).toString());
				outs.write("\n");
			}
			outs.close();
			lista.clear();
		} catch (Exception e) {
			 TmkLogger.error("SessionTracker] error " + e.toString());
		}
	}

	protected String getMensaje() {
        return null;
	}

	protected boolean pausada() {
        return false;
	}

	public synchronized static void add(String idSocio, String idAlianzaSession, String idAlianzaCookie, String evento) {
        StringBuffer str = new StringBuffer();
		str.append(formatoDeFecha.format(new Date()));
        str.append("|");
		str.append(idSocio);
		str.append("|");
		str.append(idAlianzaSession);
		str.append("|");
		str.append(idAlianzaCookie);
		str.append("|");
		str.append(evento);
		instance.lista.add(str);
	}

}
