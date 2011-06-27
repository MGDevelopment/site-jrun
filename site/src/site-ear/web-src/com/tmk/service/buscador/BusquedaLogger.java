/* $Log
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Globals;

import java.util.Vector;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

public class BusquedaLogger extends Daemon{
	private static String logPath = "d:\\tematika\\busquedaLog\\";
	private String logFile;
	private Vector lista = new Vector();
	private static SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
	private static SimpleDateFormat formatoDeFechaArchivo = new SimpleDateFormat("yyMMddHHmmss");
	private static long tamMaximo =4194304; //en bytes

	//

	BusquedaLogger(String logFile) {
		super(Daemon.UN_SEGUNDO, Daemon.UN_MINUTO *2);
		this.logFile = logFile;
	}

	synchronized protected void ejecutarTarea() {
		if (((Boolean)Globals.procesosBackground.get("LogBusquedas")).booleanValue()) {
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
				 TmkLogger.error("BusquedaLogger] error " + e.toString());
			}
		}
	}

	protected String getMensaje() {
        return null;
	}

	protected boolean pausada() {
        return false;
	}

	public synchronized void add(String error, String qry) {
        StringBuffer str = new StringBuffer();
		str.append(formatoDeFecha.format(new Date()));
        str.append("|");
		str.append(error);
		str.append(Globals.ENTER);
		str.append(qry);
		str.append(Globals.ENTER);
		lista.add(str);
	}

}
