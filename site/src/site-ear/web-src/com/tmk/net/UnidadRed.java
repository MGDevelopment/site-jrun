package com.tmk.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import com.tmk.kernel.Convert;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.server.Ubicacion;

/*
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
*/

//FUNCIONABA CON SMB se vuelve a el mapeo por DOS
public class UnidadRed {

	private static HashMap<String, UnidadRed> unidades = new HashMap<String, UnidadRed>();
	private String ip;
	private String host;
	private String user;
	private String password;
	private String defaultDir;


	/*SMB
	public static UnidadRed getUnidad(String id) throws Exception {
		if (!unidades.containsKey(id)) {
			UnidadRed uni = null;
			for (int i=0; i<Globals.SERVER.getUbicacionDeRed().getUbicacion().length && uni==null; i++) {
				if (Globals.SERVER.getUbicacionDeRed().getUbicacion()[i].getId().equals(id)) {
					Ubicacion ubi = Globals.SERVER.getUbicacionDeRed().getUbicacion()[i];
					String user = new String(CryptUtil.desEncriptar(Convert.hexStringToByteArray(ubi.getUser())));
					String pass = new String(CryptUtil.desEncriptar(Convert.hexStringToByteArray(ubi.getPassword())));
					uni = new UnidadRed(ubi.getIp(), ubi.getHost(), user, pass, ubi.getDefaultDir());
					unidades.put(id, uni);
				}
			}
			if (uni == null) {
				throw new Exception("No se encontro la unidad id= " + id);
			}
		}
		return (UnidadRed)unidades.get(id);
	}*/



	public synchronized static UnidadRed getUnidad(String id) throws Exception {
		if (!unidades.containsKey(id)) {
			UnidadRed uni = null;
			for (int i=0; i<Globals.SERVER.getUbicacionDeRed().getUbicacion().length && uni==null; i++) {
				if (Globals.SERVER.getUbicacionDeRed().getUbicacion()[i].getId().equals(id)) {
					Ubicacion ubi = Globals.SERVER.getUbicacionDeRed().getUbicacion()[i];
					String user = new String(CryptUtil.desEncriptar(Convert.hexStringToByteArray(ubi.getUser())));
					String pass = new String(CryptUtil.desEncriptar(Convert.hexStringToByteArray(ubi.getPassword())));
					uni = new UnidadRed(ubi.getIp(), ubi.getHost(), user, pass, ubi.getDefaultDir());

					Process proces = null;
					try {
						String strProces = "net use /delete " + uni.defaultDir.substring(0, 2);
						//TmkLogger.debug(strProces);
						proces = Runtime.getRuntime().exec(strProces);
				    } catch (Exception e) {
					    TmkLogger.error("NET USE] No se genero el proceso.");
					    throw new Exception("No se genero el proceso.");
				    }

				    if (proces != null) {
				    	boolean procesoActivo = true;
					    boolean procesoError = false;
					    while (procesoActivo) {
						    try {
							    if (proces.exitValue() != 0) {
								    procesoError = true;
							    }
							    procesoActivo = false;
						    } catch (Exception e) {
						    	//TmkLogger.debug(e.toString());
						    }
					    }
					    if (procesoError) {
						    TmkLogger.error("NET USE] fallo el proceso.");
					    } else {
					    	TmkLogger.debug("DESMAPEO REALIZADO");
					    }

				    }


					proces = null;
					try {
						String strProces = "net use /persistent:no " + uni.defaultDir.substring(0, 2) +
						" \\\\" + uni.ip + "\\tematika ";
						if((uni.host!=null)&&(!uni.host.equals("")))
							strProces+=" /user:" + uni.host + "\\" + uni.user + " " + uni.password;
						//TmkLogger.debug(strProces);
						proces = Runtime.getRuntime().exec(strProces);
				    } catch (Exception e) {
					    TmkLogger.error("NET USE] No se genero el proceso.");
					    throw new Exception("No se genero el proceso.");
				    }

				    if (proces != null) {
				    	boolean procesoActivo = true;
					    boolean procesoError = false;
					    while (procesoActivo) {
						    try {
							    if (proces.exitValue() != 0) {
								    procesoError = true;
							    }
							    procesoActivo = false;
						    } catch (Exception e) {
						    	//TmkLogger.debug(e.toString());
						    }
					    }
					    if (procesoError) {
						    TmkLogger.error("NET USE] fallo el proceso.");
						    throw new Exception ("fallo el proceso.");
					    }
					    TmkLogger.debug("MAPEO REALIZADO");
				    } else {
				    	TmkLogger.error("NET USE] No se genero el proceso.");
				    	throw new Exception ("No se genero el proceso.");
				    }

					unidades.put(id, uni);
				}
			}
			if (uni == null) {
				throw new Exception("No se encontro la unidad id= " + id);
			}
		}
		return (UnidadRed)unidades.get(id);
	}




	private UnidadRed(String ip, String host, String user, String password, String defaultDir)  throws Exception {
		this.ip = ip;
		this.user = user;
	 	this.password = password;
	  	this.host = host;
	  	this.defaultDir = defaultDir;

	}

//SBM
	/*private void conectar() throws Exception	{
	 	jcifs.Config.setProperty(this.host, this.ip);
	}*/

	/*SBM
	private String getPath () {
		return "smb://" + this.user + ":" + this.password + "@" + this.host + "/" + this.defaultDir + "/";
    }*/

	private String getPath () {
		return this.defaultDir + "\\";
    }

/*
	public static void copiarFicheroAUnidad (File in, UnidadRed unidad, String nameFile) throws Exception	{
		unidad.conectar();
		SmbFile fSmb = new SmbFile(unidad.getPath() + nameFile);
		FileInputStream fis = new FileInputStream(in);
		SmbFileOutputStream fos = new SmbFileOutputStream(fSmb);
		try {
			byte[] buf = new byte[1024];
			int i = 0;
			while ((i=fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} finally {
			fis.close();
			fos.close();
		}
	}
*/
	public static void copiarFicheroAUnidad (File in, UnidadRed unidad, String nameFile) throws Exception	{
		//unidad.conectar();
		File fNet = new File (unidad.getPath() + nameFile);
		//SmbFile fSmb = new SmbFile(unidad.getPath() + nameFile);
		FileInputStream fis = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(fNet);
		try {
			byte[] buf = new byte[1024];
			int i = 0;
			while ((i=fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} finally {
			fis.close();
			fos.close();
		}
	}

	/*SMB
	public static void eliminarFicheroDeUnidad (UnidadRed unidad, String nameFile) throws Exception	{
		unidad.conectar();
		SmbFile fSmb = new SmbFile(unidad.getPath() + nameFile);
		fSmb.delete();
	}*/

	public static void eliminarFicheroDeUnidad (UnidadRed unidad, String nameFile) throws Exception	{
		//unidad.conectar();
		File fNet = new File(unidad.getPath() + nameFile);
		fNet.delete();
	}

	/*SMB
	public static void crearDirectorioDeUnidad (UnidadRed unidad, String nameDir) throws Exception	{
		unidad.conectar();
		SmbFile fSmb = new SmbFile(unidad.getPath() + nameDir);
		fSmb.mkdir();
	}*/

	public static void crearDirectorioDeUnidad (UnidadRed unidad, String nameDir) throws Exception	{
		//unidad.conectar();
		File fNet = new File(unidad.getPath() + nameDir);
		fNet.mkdir();
	}


	public static void eliminarDirectorioDeUnidad (UnidadRed unidad, String nameFile) throws Exception	{
		//unidad.conectar();
		File fNet = new File(unidad.getPath() + nameFile);
		fNet.delete();
	}


}
