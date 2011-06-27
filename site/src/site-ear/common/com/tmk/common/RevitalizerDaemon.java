package com.tmk.common;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.HTMLUtil;
import com.tmk.kernel.MailUtil;
import java.util.Date;
import com.tmk.kernel.*;

public class RevitalizerDaemon extends Daemon {

	/** Texto para controlar que el server esta funcionando */
	private static String control;

	// contador para evitar sacar al server al instante
	private int contador;

	public RevitalizerDaemon() {
		// NO PONER MENOS DE UN MINUTO PORQUE NO LE DA TIEMPO AL SERVER
		super(Daemon.DIEZ_MINUTOS, Daemon.UN_MINUTO);
		//super(Daemon.UN_MINUTO, Daemon.UN_MINUTO);
	}

	public static String getControl() {
		return control;
	}

	protected void ejecutarTarea() throws Exception {

		// Consulta por la memoria del sistema
		long freeMemory = Runtime.getRuntime().freeMemory() / 1024;
		long totalMemory = Runtime.getRuntime().totalMemory() / 1024;
		boolean lowMemory = (totalMemory >= Globals.MEMORIA_MAXIMA) && (freeMemory <= Globals.MEMORIA_ALERTA);
		// Cambia el texto para asegurar que no este proxeado o algo asi
		control = "FECHA DE CONTROL " + new Date() + ". Memoria Total " + totalMemory + " kbs, Memoria Libre " + freeMemory + " kbs, Memoria Limite " + Globals.MEMORIA_MAXIMA + " kbs";
        TmkLogger.info(control);
		try {
			// baja la pagina
			String texto = HTMLUtil.download(Globals.SERVER_MAIL + "/mailing/control.jsp");
			//Globals.MODO_PRE_RESET = (Globals.esModoReset()) || (texto.indexOf(getControl()) < 0) || (lowMemory);
			contador = (Globals.esModoReset()) || (texto.indexOf(getControl()) < 0) || (lowMemory)? contador + 1: 0;
		} catch (Exception e) {
			//Globals.MODO_PRE_RESET = true;
			contador = contador + 1;

			// Ya asumio que podia fallar, asi que no necesita hacer mas nada
			TmkLogger.debug("No se pudo acceder a la pagina de control");
		}
//        finally {

		// Por cada iteracion acumula el contador antes de reiniciar
		//contador = (Globals.MODO_PRE_RESET) ? contador + 1 : 0;
//		}
		// Controla si llego a las iteraciones (solo una vez al menos que se vuelva a normalizar)
		if ((contador >= Globals.CONTROL_SERVER_ITERACIONES)) {
			// Manda mail automaticamente
			MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_WEBMASTER, Globals.NOMBRE_DEL_SITIO + " - Revitalizer",
			        "Se va a correr el proceso de consola, hora " + new Date());
			// Log
			TmkLogger.info("Se va a ejecutar la consola (reset).");

			try {
				DBUtil.killSessions();
				TmkLogger.info("Eliminando sessiones de DB");
			} catch (Exception e) {
				MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_WEBMASTER, Globals.NOMBRE_DEL_SITIO + " - Sesiones DB",
				        "Se va a correr el proceso que elimina las sesiones de DB, hora " + new Date());
			}
			// Ejecuta la consola
			Runtime.getRuntime().exec(Globals.CONTROL_SERVER_CONSOLA);
		}
	}

	protected String getMensaje() {
		return (contador > 0)? "Intento " + contador + "/" + Globals.CONTROL_SERVER_ITERACIONES + " para reinicio." : null;
		//(Globals.MODO_PRE_RESET) ? "El servidor va a reiniciarse (" + contador + "/" + Globals.CONTROL_SERVER_ITERACIONES + ")" : null;
	}

	protected boolean pausada() {
		return (!Globals.CONTROL_SERVER_HABILITADO);
	}

}
