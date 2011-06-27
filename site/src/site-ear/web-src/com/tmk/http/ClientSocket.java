package com.tmk.http;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;

public final class ClientSocket {
	// mail_smtp_host en produccion es el web
	//rotar esta variable para probar
	public static String sendRequest(Request request) throws Exception  {
		String respuesta = null;
		try {
			///AGREGAR TIMEOUT DEL SOCKET
			Socket s = new Socket(InetAddress.getByName(Globals.MAIL_SMTP_HOST)
		    		,9999);
			DataInputStream entrada = new DataInputStream(s.getInputStream());
			ObjectOutputStream salida = new ObjectOutputStream(s.getOutputStream());
			salida.writeObject(request);
	  	  	while (respuesta == null) {
	  	  		respuesta = entrada.readUTF();
	  	  	}
	  		s.close();
		} catch (Exception e) {
			TmkLogger.debug(e.toString() + MainHelper.getMessage(e));
			throw e;
		}
		return respuesta;
	}
}
