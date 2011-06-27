/**
 * $Log: Seguridad.java,v $
 * Revision 1.11  2003/12/04 17:19:16  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.10  2003/10/09 19:29:57  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.9  2003/09/16 19:30:58  GPistoia
 * -Se agrego la posibilidad de seleccionar nivel de log
 * -Capacidad de limitar la cantidad de caracteres a grabar de la tarjeta
 * -Bug de acentos y tildes contra javascript
 *
 * Revision 1.8  2003/09/15 22:30:55  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.7  2003/09/12 18:07:56  SLizardo
 * no message
 *
 * Revision 1.6  2003/08/29 20:39:33  SLizardo
 * no message
 *
 * Revision 1.5  2003/08/22 14:03:56  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.4  2003/08/21 17:48:27  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.3  2003/08/06 21:28:23  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.2  2003/08/02 16:58:14  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.1  2003/07/26 19:06:09  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel;


public class Seguridad {

	private static int ULTIMOS_DIGITOS_MOSTRABLES = 4;
	private static int CARACTERES_ENTRE_SEPARACIONES = 4;
	private static char CARACTER_OCULTO = 'x';
	private static char CARACTER_SEPARACION = '-';
	//private static String CHARSET_NAME = "UTF8";
	//private static String ALGORITHM = "DES";


	/**
	 * Devuelve el string del numero de tarjeta desencriptado y con xxxx para mostrar solo algunos valores
	 */
	public static String numeroTarjetaAMostrar(byte[] numeroTarjetaEncriptado) {
		return cortarNumeroDeTarjeta(desencriptarTarjeta(numeroTarjetaEncriptado));
	}

	/**
	 * Devuelve el string del numero de tarjeta desencriptado y con xxxx para mostrar solo algunos valores
	 */
	public static String cortarNumeroDeTarjeta(String tarjeta) {
		if (tarjeta == null) {
			return "No accesible";
		} else {
			StringBuffer xxx = new StringBuffer();
			for (int i = 0; i < tarjeta.length(); i++) {
				xxx.append((i < tarjeta.length() - ULTIMOS_DIGITOS_MOSTRABLES) ? CARACTER_OCULTO : tarjeta.charAt(i));
			}
			for (int i = tarjeta.length() - 1; i > 0; i--) {
				if (i % CARACTERES_ENTRE_SEPARACIONES == 0) {
					xxx.insert(i, CARACTER_SEPARACION);
				}
			}
			return xxx.toString();
		}
	}

	/**
	 * Numero de tarjeta que debe grabarse
	 */
	public static byte[] numeroTarjetaAGrabar(byte[] numeroTarjetaEncriptado) {
		return numeroTarjetaEncriptado;  // por ahora se graba completo
	}

	/**
	 * Metodos de encriptacion de la tarjeta
	 */
	public static byte[] encriptarTarjeta(String numeroOriginal) {
		return (numeroOriginal == null) ? null : CryptUtil.encriptar(numeroOriginal.getBytes());
	}

	/**
	 * Metodos de desencriptacion de la tarjeta
	 */
	public static String desencriptarTarjeta(byte[] numeroOriginal) {
		byte[] result = (numeroOriginal == null) ? null : CryptUtil.desEncriptar(numeroOriginal);
		return (result == null) ? null : new String(result);
	}

	/**
	 * Metodos de encriptacion de la tarjeta
	 */
	/*public static String encriptarTarjeta(String numeroOriginal, String defaultValue) {
		try {
			SecretKey secretKey = buildSecretKey(CRYPT_SEED);
			return encodeString(secretKey, numeroOriginal);
		} catch (Exception e) {
			return defaultValue;
		}
	}*/

	/**
	 * Metodos de desencriptacion de la tarjeta
	 */
	/*public static String desencriptarTarjeta(String numeroOriginal, String defaultValue) {
		try {
			SecretKey secretKey = buildSecretKey(CRYPT_SEED);
			return decodeString(secretKey, numeroOriginal);
		} catch (Exception e) {
			return defaultValue;
		}
	}*/

	/**
	 * Construye la clave secreta
	 */
	/*private static SecretKey buildSecretKey(String secretKey) throws Exception {
		byte[] bytes = secretKey.substring(0, 8).getBytes();
		DESKeySpec keySpec = new DESKeySpec(bytes);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);

		return keyFactory.generateSecret(keySpec);
	}*/

	/**
	 * Encripta un texto segun la clave secreta
	 */
	/*private static String encodeString(SecretKey secretKey, String txt) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		byte[] bytes = txt.getBytes(CHARSET_NAME);
		byte[] encrypted = cipher.doFinal(bytes);

		return new BASE64Encoder().encode(encrypted);
	}*/

	/**
	 * Desencripta un texto segun la clave secreta
	 */
	/*private static String decodeString(SecretKey secretKey, String txt) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		byte[] bytes = new BASE64Decoder().decodeBuffer(txt);
		byte[] decrypted = cipher.doFinal(bytes);

		return new String(decrypted, CHARSET_NAME);
	}*/

	/** Clave de encriptacion generica */
	//private static String CRYPT_SEED = "39mof47m";

}
