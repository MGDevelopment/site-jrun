package com.tmk.setup;

import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.server.Procesos;
import com.tmk.kernel.server.RunPro;


public final class Launcher {
	private final static Launcher instance = new Launcher();

	public static Launcher getInstance() {
		return instance;
	}

	private Launcher() {
		TmkLogger.info("Cargando Procesos");
		Procesos procesos = Globals.SERVER.getProcesos();
		if (procesos != null) {
			for (int i=0; i<procesos.getRunProCount(); i++) {
				RunPro proceso = procesos.getRunPro()[i];
				new Runner (proceso);
				TmkLogger.info(proceso.getClase() + ")" + proceso.getMetodo() + "]  loaded");
			}
		} else {
			TmkLogger.info("No hay procesos a cargar");
		}
		TmkLogger.info("Carga de Procesos FINALIZADA...");
	}
}
