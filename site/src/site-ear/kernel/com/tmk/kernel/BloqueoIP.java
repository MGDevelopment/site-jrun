/**
 * $Log: BloqueoIP.java,v $
 * Revision 1.1  2005/06/15 16:48:32  omsartori
 * - Alerta de intrusion desde multiples hilos
 *
 */
package com.tmk.kernel;

import java.util.Vector;

public class BloqueoIP {
	private static Vector IPs = new Vector();

	private static int getPosicionIP(String ip) {
		int retorno = -1;
		for (int i = 0; i<IPs.size(); i++) {
			if (ip.equals(((Hits)IPs.get(i)).getIP())) {
                return i;
			}
		}
		return retorno;
	}

	/*public static void addIP (Hits hit){
		int i = getPosicionIP(hit.getIP());
		if (i != -1) {
			IPs.set(i, hit);
		} else {
			IPs.add(hit);
		}
	}*/

	public static Hits getIP (String ip) {
		int i = getPosicionIP(ip);
		if (i != -1) {
			return (Hits)IPs.get(i);
		} else{
			Hits hit = new Hits(ip);
			IPs.add(hit);
			return hit;
		}
	}

	public static int getSize() {
		return IPs.size();
	}
}
