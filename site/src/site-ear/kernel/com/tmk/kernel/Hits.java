/**
 * $Log: Hits.java,v $
 * Revision 1.4  2007/09/03 13:41:23  msartori
 * no message
 *
 * Revision 1.3  2005/08/25 13:43:02  omsartori
 * - Msg de bloque de IP e ip en subject del mail de alerta
 * - Mail de tarjeta verificada en formato texto (html no anda)
 * - Se intercambio el boton de referidos con el de afiliados de la home
 * - Link a seccion de ayuda en carrito
 *
 * Revision 1.2  2005/06/15 16:48:33  omsartori
 * - Alerta de intrusion desde multiples hilos
 *
 * Revision 1.1  2005/06/15 14:19:13  omsartori
 * - Clase de alerta de intrusiones
 *
 */
package com.tmk.kernel;
import java.util.Date;

public class Hits {
	private static final boolean OK = true;
	//private static final boolean NEGAR = false;

	private String ip;
	private Date fecha;
	private int contador;
    private boolean estado;
	private boolean alertaEnviada;

	public Hits (String ip) {
		this.ip = ip;
		this.contador = 0;
		this.estado = OK;
		this.alertaEnviada = false;
	}

	public String getIP() {
		return ip;
	}

	public void setFecha(Date fecha) {
		if (this.fecha == null) {
			this.fecha = fecha;
		} else {
			long dif = fecha.getTime() - this.fecha.getTime();
        	if (dif < Globals.BLOQUEO_IP_TIEMPO_ENTRE_HITS) {
		        contador ++;
	        } else {
		        contador = 0;
	        }
			this.fecha = fecha;
		}
    	if (contador >= Globals.BLOQUEO_IP_HITS) {
		   // this.estado = NEGAR;
		    if (!alertaEnviada) {
		        enviarAlerta("hits sucesivos");
			   // alertaEnviada = true;
		    }
	    }
		/*TmkLogger.debug("ip " + this.ip);
		TmkLogger.debug("miliseg " + this.fecha.getTime());
		TmkLogger.debug("contador " + this.contador);
		TmkLogger.debug("estado " + this.estado);*/
	}

	public boolean aceptaPeticion() {
		return this.estado;
	}

	public void enviarAlerta(String msg) {
		MailUtil.sendMail(Globals.MAIL_MAILER,
					 Globals.MAIL_WEBMASTER,
					 "TMK Bloquear IP " + this.ip + " " + msg,
					 "Mensaje Automático de TMK Bloquear IP " + this.ip + " (" + msg + ")"
					);
	}

}
