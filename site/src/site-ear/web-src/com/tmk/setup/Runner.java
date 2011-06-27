package com.tmk.setup;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Calendar;

import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.server.RunPro;
import com.tmk.service.categoria.CategoriaService;

public class Runner extends Daemon{
private RunPro runPro;

	public Runner(RunPro proceso) {
		super(Convert.toNumber(proceso.getComienzo(), 0),
				Convert.toNumber(proceso.getEspera(), 0));
		this.runPro = proceso;
	}

	protected void ejecutarTarea() throws Exception {
		try {
			Class clase = Class.forName(runPro.getClase());
			Method metodo = clase.getMethod(runPro.getMetodo(), (Class[])null);
			TmkLogger.debug("Procesando... " + clase.getName() + "]" + metodo.getName());
			Object retorno = (Object) metodo.invoke(this, (Object[])null);
			if (runPro.getEmail() != null && runPro.getEmail().length>0 ) {
				if (metodo.getReturnType().getName().endsWith("String")) {
					MailUtil.sendMail(Globals.MAIL_MAILER, runPro.getEmail(), runPro.getNombre(), (String)retorno, "HTML");
				}
				if (metodo.getReturnType().getName().endsWith("File")) {
					MailUtil.sendMail(Globals.MAIL_MAILER, runPro.getEmail(), runPro.getNombre(), "", "HTML", (File)retorno);
				//	((File)retorno).delete();
				}
			}

		} catch(Exception e) {
			String msg = runPro.getClase() + " ]" + runPro.getMetodo() + " Error en Ejecucion de metodo. " + e.toString() + MainHelper.getMessage(e);
			TmkLogger.error(msg);
			MainHelper.enviarMailDeError(msg);
		}

	}

	protected String getMensaje() {
		return runPro.getClase() + "]" + runPro.getMetodo() + " Procesado";
	}

	protected boolean pausada() {
		Calendar calendar = Calendar.getInstance();
		return Globals.baseDeDatosEnMantenimiento()
		|| (CategoriaService.categoria == null && !runPro.getNombre().equals("CargadorDeCategorias"))
		|| !MainHelper.esTiempoDeEjecutar(calendar.get(Calendar.DATE)
				, calendar.get(Calendar.HOUR_OF_DAY)
				, calendar.get(Calendar.MINUTE)
				, calendar.get(Calendar.DAY_OF_WEEK),
				Convert.toNumber(runPro.getDia(), (Integer) null),
				Convert.toNumber(runPro.getHora(), (Integer) null),
				Convert.toNumber(runPro.getMinuto(), (Integer) null),
				Convert.toNumber(runPro.getRangoRepMen(), (Integer) null),
				Convert.toNumber(runPro.getRangoRepMay(),  (Integer) null),
				runPro.getDiaSemana());
	}
}
