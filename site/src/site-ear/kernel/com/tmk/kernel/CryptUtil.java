/**
 * @author Lizardo Santiago
 *
 * $Log: CryptUtil.java,v $
 * Revision 1.2  2003/12/04 17:19:08  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.1  2003/10/07 14:52:14  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.1  2003/10/04 21:54:55  SLizardo
 * Implementacion de DESede
 *
 */
package com.tmk.kernel;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public final class CryptUtil {

	private final static byte[] SEMILLA = new byte[]
	{
		0, 1, 2, 3, 4, 5, 6, 7,
		0, 1, 2, 3, 4, 5, 6, 7,
		0, 1, 2, 3, 4, 5, 6, 7
	};

	private final static byte[] VI = new byte[]
	{
		0, 0, 0, 0, 0, 0, 0, 0
	};

	private final static String ALGORITMO = "DESede";
	private final static String PARAMS = "/CBC/PKCS5Padding";

	private static DESedeKeySpec keySpec = null;
	private static SecretKeyFactory keyFactory = null;
	private static SecretKey secretKey = null;
	private static IvParameterSpec ivSpec = null;
	private static Cipher cipher = null;

	public static byte[] encriptar(byte[] texto_plano) {
		if (keySpec == null) {
			try {
				keySpec = new DESedeKeySpec(SEMILLA);
			} catch (InvalidKeyException ike) {
				TmkLogger.error(ike.getMessage());
			}
		}

		if (keyFactory == null) {
			try {
				keyFactory = SecretKeyFactory.getInstance(ALGORITMO);
			} catch (NoSuchAlgorithmException nsa) {
				TmkLogger.error(nsa.getMessage());
			}
		}

		if (secretKey == null) {
			try {
				secretKey = keyFactory.generateSecret(keySpec);
			} catch (InvalidKeySpecException ikse) {
				TmkLogger.error(ikse.getMessage());
			}
		}

		if (ivSpec == null) {
			ivSpec = new IvParameterSpec(VI);
		}

		if (cipher == null) {
			try {
				cipher = Cipher.getInstance(ALGORITMO + PARAMS);
			} catch (NoSuchAlgorithmException nse) {
				TmkLogger.error(nse.getMessage());
			} catch (NoSuchPaddingException nse) {
				TmkLogger.error(nse.getMessage());
			}
		}

		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
		} catch (InvalidKeyException ike) {
			TmkLogger.error(ike.getMessage());
		} catch (InvalidAlgorithmParameterException iape) {
			TmkLogger.error(iape.getMessage());
		}

		byte[] texto_encriptado = null;

		try {
			texto_encriptado = cipher.doFinal(texto_plano);
		} catch (IllegalBlockSizeException ibs) {
			TmkLogger.error(ibs.getMessage());
		} catch (BadPaddingException bpe) {
			TmkLogger.error(bpe.getMessage());
		}

		return texto_encriptado;
	}

	public static byte[] desEncriptar(byte[] texto_encriptado) {
		if (keySpec == null) {
			try {
				keySpec = new DESedeKeySpec(SEMILLA);
			} catch (InvalidKeyException ike) {
				TmkLogger.error(ike.getMessage());
			}
		}

		if (keyFactory == null) {
			try {
				keyFactory = SecretKeyFactory.getInstance(ALGORITMO);
			} catch (NoSuchAlgorithmException nsa) {
				TmkLogger.error(nsa.getMessage());
			}
		}

		if (secretKey == null) {
			try {
				secretKey = keyFactory.generateSecret(keySpec);
			} catch (InvalidKeySpecException ikse) {
				TmkLogger.error(ikse.getMessage());
			}
		}

		if (ivSpec == null) {
			ivSpec = new IvParameterSpec(VI);
		}

		if (cipher == null) {
			try {
				cipher = Cipher.getInstance(ALGORITMO + PARAMS);
			} catch (NoSuchAlgorithmException nse) {
				TmkLogger.error(nse.getMessage());
			} catch (NoSuchPaddingException nse) {
				TmkLogger.error(nse.getMessage());
			}
		}

		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
		} catch (InvalidKeyException ike) {
			TmkLogger.error(ike.getMessage());
		} catch (InvalidAlgorithmParameterException iape) {
			TmkLogger.error(iape.getMessage());
		}

		byte[] texto_desencriptado = null;

		try {
			texto_desencriptado = cipher.doFinal(texto_encriptado);
		} catch (IllegalBlockSizeException ibs) {
			TmkLogger.error(ibs.getMessage());
		} catch (BadPaddingException bpe) {
			TmkLogger.error(bpe.getMessage());
		}

		return texto_desencriptado;
	}
}
