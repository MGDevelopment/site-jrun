package com.tmk.controllers;

import com.tmk.controllers.alianza.EstadisticaVisitas;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.net.UnidadRed;
import com.tmk.util.ByteArrayWarpper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.RowSetDynaClass;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Pattern;

public final class MainHelper {


	public static final int [] mnuSeccion  = new int [] {Globals.SECCION_LIBRO, Globals.SECCION_MUSICA,
		Globals.SECCION_PELICULA, Globals.SECCION_JUGUETES, Globals.SECCION_SUCURSALES, Globals.SECCION_QUID,
			Globals.SECCION_EXTRA};
	/*200 sucursales, 300 quid, 400 extra,500 login*/

	/*-------------------------------SESSIONS-------------------------------------------------------*/
	//LOGIN
	public static final String SESSION_SOCIOPK = "Registracion.socioPK";
	public static final String SESSION_NOMBREYAPELLIDO = "Registracion.nombreCompleto";
	public static final String SESSION_NOMBRE = "Registracion.nombre";
	public static final String SESSION_LOGIN = "Registracion.login";
	public static final String SESSION_PUNTAJE_FIDELIZACION = "PuntajeFidelizacion";
	//PURCHASE
	public static final String SESSION_ORDEN = "ordenDAO";
	//REDIRECT
	public static final String URL_REDIRECT = "urlRedirect";
	public static final String REFERER = "referer";
	/*------------------------------/SESSIONS-------------------------------------------------------*/


	/*------------------------------VIEWS-----------------------------------------------------------*/
	//HOMES
	public static final String PAGE_HOME = "/inicio/index.jsp";
	//ERROR
	public static final String PAGE_ERROR = "/errorPage/errorPage.jsp";
	//PURCHASE
	public static final String PAGE_END_PURCHASE = "/compra/detalleDeOrden.jsp?idOrden=";
	//INTRANET
	public static final String PAGE_HOME_INTRANET = "/236-TMK/index.jsp";
	public static final String PAGE_DISPONIBILIDAD_POR_ARTICULO = "/236-TMK/disponibilidad/porArticulo.jsp";
	public static final String PAGE_CONTENIDO_INICIO = "/236-TMK/contenido/index.jsp";
	//MI CUENTA
	public static final String PAGE_REGISTRO_SOCIO_CADENA = "/miCuenta/registroSocioCadena.jsp";
	public static final String PAGE_REGISTRO_SOCIO_CADENA_REDISENO = "/miCuenta/registroSocioCadena.jsp";

	/*------------------------------/VIEWS----------------------------------------------------------*/


	/*------------------------------ACTIONS---------------------------------------------------------*/
	public static final String ACTION_GET_XML_ARTICULO_BY ="/GetXMLArticuloBy";
	public static final String ACTION_GET_XML_REGLA_BY ="/GetXMLReglaBy";
	public static final String ACTION_GET_XML_CATEGORIA_BY = "/GetXMLCategoriaBy";
	public static final String ACTION_CREAR_REGLA ="/CrearRegla";
	public static final String ACTION_ELIMINAR_REGLA ="/EliminarRegla";
	public static final String ACTION_GENERAR_ARTICULO ="/GenerarArticulo";
	public static final String ACTION_AGREGAR_ARTICULO_DE_CATALOGO = "/AgregarArticuloDeCatalogo";
	public static final String ACTION_ELIMINAR_ARTICULO_GENERADO ="/EliminarArticuloGenerado";
	public static final String ACTION_ELIMINAR_ARTICULO_DE_CATALOGO = "/EliminarArticuloDeCatalogo";
	public static final String ACTION_APLICAR_PROMO_VC ="/AplicarPromoVC";
	public static final String ACTION_GENERAR_RSS_PARA_ALIANZA = "GenerarRSSParaAlianza";

	/*------------------------------/ACTIONS--------------------------------------------------------*/


	/*--------------------------------CONST---------------------------------------------------------*/
	public static final String CONST_DOMICILIO_ENVIO = "EN";
	public static final String CONST_DOMICILIO_FACTURACION = "TF";
	public static final Integer CONST_ALIANZA_SECCION_POR_DEFECTO = new Integer(1);

	/*-------------------------------/CONST---------------------------------------------------------*/

	/*-------------------------------FIELDS---------------------------------------------------------*/
	public static final String FIELD_ID_ARTICULO = "idArticulo";
	public static final String FIELD_ID_DISPONIBILIDAD = "idDisponibilidad";
	public static final String FIELD_HABILITADO_TEMATIKA = "habilitadoTematika";
	public static final String FIELD_ISBN = "ISBN";
	public static final String FIELD_DESDE = "desde";
	public static final String FIELD_HASTA = "hasta";
	public static final String FIELD_DESCRIPCION = "descripcion";
	public static final String FIELD_SECUENCIA = "secuencia";
	public static final String FIELD_ID_SECCION = "idSeccion";
	public static final String FIELD_ID_GRUPO = "idGrupo";
	public static final String FIELD_ID_FAMILIA = "idFamilia";
	public static final String FIELD_ID_SUB_FAMILIA = "idSubFamilia";
	public static final String FIELD_ID_ORDEN = "idOrden";
	public static final String FIELD_RESPUESTA1 = "respuesta1";
	public static final String FIELD_RESPUESTA2 = "respuesta2";
	public static final String FIELD_RESPUESTA3 = "respuesta3";
	public static final String FIELD_TOTAL = "total";
	public static final String FIELD_ACEPTA_PROMO = "aceptaPromo";
	public static final String FIELD_VENCIMIENTO = "vencimiento";

	/*-------------------------------/FIELDS--------------------------------------------------------*/

	/*--------------------------------HTTP PARAMETERS-----------------------------------------------*/
	public static final String PARAM_INCLUIDO = "INCLUIDO";
	public static final String PARAM_SUB_CATEGORIAS = "subCategorias";
	public static final String PARAM_INCLUYE_CATEGORIA = "incluyeCategoria";

	/*-------------------------------/HTTP PARAMETERS-----------------------------------------------*/

	/*------------------------------RESOURCES-------------------------------------------------------*/
	public static final String RES_DIR_CONTENIDOS_ESTATICOS = "/contenidosEstaticos";
	public static final String RES_PAGE_EXTRA_BENEFICIOS = "/eXtra/beneficiosNvo.htm";
	//public static final String RES_DIR_GENERACION_ARTICULO = "/contenidosEstaticos/detalleArticulo";
	public static final String RES_PAGE_EXTRA_INICIO = "/eXtra/inicio.htm";
	public static final String RES_PAGE_EXTRA_INICIO_R = "/eXtra/inicio_rediseno.htm";
	public static final String RES_REPORTING_IMG_PATH = "/grupos/reporting";
	public static final String RES_TMPL_PATH = "/templates";
	public static final String RES_DIR_AUX_DATA = "/recursos/auxData";
	public static final String RES_DIR_COMMENT_FEED = "/commentFeed";
	public static final String RES_DIR_WISHLIST_FEED = "/wishListFeed";

	/*------------------------------/RESOURCES------------------------------------------------------*/

	/*-----------------------------RESOURSES FOLDERS------------------------------------------------*/
	public static final String FLD_CHARTS = "/recursos/charts";
	/*-----------------------------RESOURSES FOLDERS------------------------------------------------*/

	/*-------------------------------COMMON METHODS-------------------------------------------------*/
	public static String addParameter(String nameParam, String valueParam, boolean first) {
		return (first)?"?":"&" + nameParam + "=" + valueParam;
	}

	public static String getParameters(HttpServletRequest request) {
		StringBuffer bufParam = new StringBuffer();
		Enumeration params = request.getParameterNames();
		for (int i = 0; params.hasMoreElements(); i++) {
			bufParam.append((i>0)?"&":"?");
			String nombreParametro = params.nextElement().toString();
			bufParam.append(nombreParametro).append("=");
			try {
				bufParam.append(URLEncoder.encode(request.getParameter(nombreParametro), "ISO-8859-1"));
			} catch (Exception e) {
				bufParam.append(request.getParameter(nombreParametro));
			}
		}
		return bufParam.toString();
	}

	public static String getMessage(Exception e) {
		StringBuffer message = new StringBuffer();
		for(int i =0; i<e.getStackTrace().length; i++) {
			message.append(e.getStackTrace()[i]).append(Globals.ENTER);
		}
		return message.toString();
	}

	public static Iterator getRs(String qry) throws Exception {
		Connection conn = DBUtil.buildConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(qry.toString());
			try {
				ResultSet rs = ps.executeQuery();
				try {
					return new RowSetDynaClass(rs).getRows().iterator();
				} finally {
					rs.close();
				}
			} finally {
				ps.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ERROR EJECUTANDO QRY ->" + qry.toString());
			throw e;
		} finally {
			conn.close();
		}
	}

	public static Vector getVectorDB(String qry) throws Exception {
		Vector retorno = new Vector();
		Connection conn = DBUtil.buildConnection();
		try {
			Statement st = conn.createStatement();
			try {
				ResultSet rs = st.executeQuery(qry.toString());
				try {
					while(rs.next()) {
						Hashtable h = new Hashtable();
						ResultSetMetaData rsmd = rs.getMetaData();
						for(int i=1; i <=rsmd.getColumnCount(); i++) {
							if (rs.getObject(i) == null) {
								h.put(rsmd.getColumnName(i), "");
							} else {
								if (rsmd.getColumnClassName(i).equals("byte[]")) {
									h.put(rsmd.getColumnName(i), new ByteArrayWarpper(rs.getBytes(i)));
								} else {
									h.put(rsmd.getColumnName(i), rs.getObject(i));
								}
							}
						}
						retorno.addElement(h);
					}
				} finally {
					rs.close();
				}
			} finally {
				st.close();
			}
		} finally {
			conn.close();
		}
		return retorno;
	}

	public static void enviarMailDeError(String error) {
		MailUtil.sendMail(Globals.MAIL_MAILER,
				Globals.MAIL_WEBMASTER, "ERROR - " + Globals.NOMBRE_DEL_SITIO,
				error);
	}

	//borra todos los directorios
	public static boolean borrarDirectorio(File directorio){
    	if (directorio.exists()) {
	    	if (directorio.isDirectory()) {
	    		while (directorio.listFiles().length>0) {
	    			borrarDirectorio(directorio.listFiles()[0]);
	    		}
	    		TmkLogger.debug("borrando directorio " + directorio.getAbsolutePath());
    			boolean res = directorio.delete();
    			if (!res) {
    				TmkLogger.debug("fallo al borrar " + directorio.getAbsolutePath());
    				return false;
    			} else {
    				return true;
    			}
	    	} else {
	    		TmkLogger.debug("borrando archivo " + directorio.getAbsolutePath());
	    		boolean res = directorio.delete();
    			if (!res) {
    				TmkLogger.debug("fallo al borrar " + directorio.getAbsolutePath());
    				return false;
    			} else {
    				return true;
    			}
	    	}
    	}
    	return true;
    }

	public static boolean esTiempoDeEjecutar(int diaActual, int horaActual, int minutoActual,
			int diaSemanaActual, Integer diaRep, Integer horaRep, Integer minutoRep, Integer rangoRepMen,
			Integer rangoRepMay, int [] diasSemana) {
			boolean retorno = true;
			retorno = retorno && (diaRep == null || diaRep.intValue() == diaActual);
			retorno = retorno && (horaRep == null || horaRep.intValue() == horaActual);
			retorno = retorno && (minutoRep == null || minutoRep.intValue() == minutoActual);
			retorno = retorno && (rangoRepMen == null || horaActual  >= rangoRepMen.intValue());
			retorno = retorno && (rangoRepMay == null || horaActual < rangoRepMay.intValue());
			boolean diaSemana = true;
			if (diasSemana != null && diasSemana.length>0) {
				diaSemana = false;
				for (int i=0; i<diasSemana.length; i++) {
					diaSemana = diaSemana || (diaSemanaActual == diasSemana[i]);
				}
			}
		return retorno && diaSemana;
	}


	public static void copyFile(File in, File out) throws IOException {
	    FileChannel inChannel = new FileInputStream(in).getChannel();
	    FileChannel outChannel = new FileOutputStream(out).getChannel();
	    try {
	    	// magic number for Windows, 64Mb - 32Kb)
	        int maxCount = (64 * 1024 * 1024) - (32 * 1024);
	        long size = inChannel.size();
	        long position = 0;
	        while (position < size) {
	        	position +=
	            inChannel.transferTo(position, maxCount, outChannel);
	        }
	    }
	    catch (IOException e) {
	        throw e;
	    }
	    finally {
	        if (inChannel != null) inChannel.close();
	        if (outChannel != null) outChannel.close();
	    }
	}

	public static File saveFile(String contenido, String fileName) throws Exception{
		File file = new File(fileName);
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter in = new FileWriter(file);
		in.write(contenido);
		in.close();
		return file;
	}

	public static void saveFileNet(String fileName, String contenido, String keyUnidad) throws Exception {
		//MainHelper.saveFile(contenido, "D:/tmp/recursos/contenidosEstaticos"+fileName);
		
//		lista
			
		UnidadRed unidad = UnidadRed.getUnidad(keyUnidad);
		File file = MainHelper.saveFile(contenido, "aux" + Calendar.getInstance().getTimeInMillis() + Math.random() + ".htm");
		UnidadRed.copiarFicheroAUnidad(file, unidad, fileName);
		file.delete();
		
		
	}

	public static void saveExistingFileNet(String fileName, String sourceFileName, String keyUnidad) throws Exception {
//		lista
		UnidadRed unidad = UnidadRed.getUnidad(keyUnidad);
		File file = new File(sourceFileName);
		UnidadRed.copiarFicheroAUnidad(file, unidad, fileName);
		file.delete();
	}

	public static void deleteFileNet(String fileName, String keyUnidad) throws Exception {
		UnidadRed unidad = UnidadRed.getUnidad(keyUnidad);
		UnidadRed.eliminarFicheroDeUnidad(unidad, fileName);
	}

	public static void makeDirNet(String dirName, String keyUnidad) throws Exception {
		UnidadRed unidad = UnidadRed.getUnidad(keyUnidad);
		UnidadRed.crearDirectorioDeUnidad(unidad, dirName);
	}

	public static void delDirNet(String dirName, String keyUnidad) throws Exception {
		UnidadRed unidad = UnidadRed.getUnidad(keyUnidad);
		UnidadRed.eliminarDirectorioDeUnidad(unidad, dirName);
	}

	public static boolean esEMail (String cadena) {
		return ((Pattern.compile("[a-zA-Z0-9_-]+[.[a-zA-Z0-9_-]+]*@[[a-zA-Z0-9_-]+.[a-zA-Z0-9_-]+]+")).matcher(cadena)).matches();
	}

	public static Date convertirEnFecha (String fecha, String formato) throws Exception {
		//"dd/MM/yyyy"
		SimpleDateFormat formatoFecha = new SimpleDateFormat(formato);
		formatoFecha.setLenient(false);
		if (fecha == null) {
			return null;
		}
		return formatoFecha.parse(fecha);
	}


	public static void printFile (HttpServletResponse response, File file, String content) throws Exception {
//		sirvo el archivo
		PrintWriter out = response.getWriter();
		BufferedReader reader = new BufferedReader (new FileReader(file));

		response.setHeader("Content-Type", content);
		while (reader.ready()) {
			out.write(reader.readLine());
		}

	}

	/***
	 * @see recorre el array de mnuSeccion y retorna el
	 * @see indice donde se encuantra la seccion uscada
	 * @param value
	 * @return ubicacion en array de la seccion buscada
	 */
	public static int getIndexMnuSeccion(int idSeccion) {
		//si es home muestro solo los menues de extra quid, etc a la derecha
		int pos = (idSeccion == Globals.SECCION_HOME)? 3:mnuSeccion.length;
		for ( int i=0 ; i < mnuSeccion.length; i++) {
			if(idSeccion == mnuSeccion[i]){
				pos =  i;
				break;
			}
		}
		return pos;
	}

	public static void controlDeModo(HttpServletRequest request, HttpServletResponse response) {
		try {
			if ((!Globals.sitioDisponible()) &&
			        (Convert.toBoolean(request.getParameter("CONTROLAR_SERVER"),true)) &&
			        (Convert.toBoolean(request.getSession().getAttribute("RESPETAR_MODO"), true))) {

				response.sendRedirect("/mantenimiento.jsp");
				return;
			}
			if (Globals.esModoRelease()) {
				// pasa a modo seguro si debe
				synchronized (request.getSession()) {
					String referer = request.getRequestURL().toString();
					if (referer != null) {
						// listado de paginas que deben procesarse en modo seguro
						String seguras[] = new String[] {"/compra", "/miCuenta", "/listaDeseos", "/236-TMK", "/extranet", "/afiliados"};
						// Controla si la pagina actual necesita modo seguro
						boolean necesitaSeguridad = false;
						for (int i = 0; (!necesitaSeguridad) && (i < seguras.length); i++) {
							necesitaSeguridad = (referer.indexOf(seguras[i]) >= 0);
						}
						// Recolecta los parametros para pasarlos
						StringBuffer parametros = new StringBuffer();
						Enumeration params = request.getParameterNames();
						while (params.hasMoreElements()) {
							if (parametros.length() == 0) parametros.append("?");
							if (parametros.length() > 1) parametros.append("&");
							String nombreParametro = params.nextElement().toString();
							String valorParametro = request.getParameter(nombreParametro);
							parametros.append(nombreParametro).append("=").append(valorParametro);
						}
						// NO ESTA EN MODO SEGURO Y NECESITA
						if ((necesitaSeguridad) && (referer.indexOf("http:") >= 0)) {
							response.resetBuffer();
							response.sendRedirect(referer.replaceFirst("http:", "https:").replaceFirst("8101", "9100") + parametros);
							return;
						}
						// ESTA EN MODO SEGURO Y NO LO NECESITA
						if ((!necesitaSeguridad) && (referer.indexOf("https:") >= 0)) {
							response.resetBuffer();
							response.sendRedirect(referer.replaceFirst("https:", "http:").replaceFirst("9100", "8101") + parametros);
							return;
						}
					}
				}
			}
			EstadisticaVisitas.mantenerEstadistica(request, response);
		} catch (Exception e) {
			TmkLogger.error(e.toString());
		}
	}

	public static String controlDeModo(HttpServletResponse response,HttpServletRequest request ) {
		try {
			if ((!Globals.sitioDisponible()) &&
			        (Convert.toBoolean(request.getParameter("CONTROLAR_SERVER"),true)) &&
			        (Convert.toBoolean(request.getSession().getAttribute("RESPETAR_MODO"), true))) {
				return "frwMantenimiento";
			}
			return "";
		}catch (Exception e) {
			return "frwMantenimiento";
		}
	}
	///INSERT //MOdificar lo q lo usa para utilizar el nuevo
	public static PreparedStatement getInsertToDBByObject(Object obj, String table, Connection conn) throws Exception {
		StringBuffer fields = new StringBuffer("Insert into ").append(table).append(" (");
		StringBuffer values = new StringBuffer("values (");
		for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
			java.lang.reflect.Field field = obj.getClass().getDeclaredFields()[i];
			field.setAccessible(true);
			if (field.get(obj) != null) {
				fields.append(field.getName()).append(", ");
				values.append("?, ");
			}
		}
		if (fields.toString().equals("Insert into " + table + " (")) {
			throw new Exception("MainHelper.getInsertToDBByObject(" + obj.getClass().getName() + ") ERROR: todos los campos son nulos");
		} else {
			fields = new StringBuffer(fields.toString().substring(0, fields.length()-2));
			values = new StringBuffer(values.toString().substring(0, values.length()-2));
			fields.append(")");
			values.append(")");
			fields.append(" ").append(values).toString();
			PreparedStatement ps = conn.prepareStatement(fields.toString());
			int indice = 0;
			for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
				java.lang.reflect.Field field = obj.getClass().getDeclaredFields()[i];
				field.setAccessible(true);
				if (field.get(obj) != null) {
					ps.setObject((++indice), field.get(obj));
				}
			}
			return ps;
		}
	}
	
	
	/*-------------------------------/COMMON METHODS------------------------------------------------*/
}
