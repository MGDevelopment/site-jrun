/**
 * Created by IntelliJ IDEA.
 * User: odzurita
 * Date: Oct 28, 2005
 * Time: 4:12:25 PM
 * To change this template use Options | File Templates.
 */
package com.tmk.generacion;

import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.kernel.HTMLUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.controllers.MainHelper;
import java.net.URLEncoder;
import java.io.File;



public class ContenidosEstaticos {

    private final static String saveDirectory = "/contenidosEstaticos";


	public static boolean crearContenidoEstatico(String urlFile, String fileName, String keyUnidad) {
        try {
			String texto = HTMLUtil.download(Globals.GENERACION_URL + urlFile);
            if (texto.indexOf("ERROR404ERROR") != -1) {
                TmkLogger.error("Error Generando " + fileName);
	            return false;
            }
			MainHelper.saveFileNet(fileName, texto, keyUnidad);
			TmkLogger.debug("Archivo Generado " + fileName);
            return true;

        } catch (Exception e) {
            TmkLogger.error("Error Generando " + fileName + " " +  e.toString() + MainHelper.getMessage(e));
	        return false;
        }
    }


	private static CategoriaPK getCategoria(CategoriaPK categoriaPK, Integer idSeccion, Integer idGrupo, Integer idFamilia, Integer idSubFamilia) {
    	Integer pk[];
    	if(idGrupo != null) {
			if(idFamilia != null) {
				if(idSubFamilia != null) {
					pk = new Integer [] {idSeccion,new Integer(idGrupo),new Integer(idFamilia),new Integer(idSubFamilia)};
				}else {
					pk = new Integer [] {idSeccion,new Integer(idGrupo),new Integer(idFamilia)};
				}
			}else {
				pk = new Integer [] {idSeccion,new Integer(idGrupo)};
			}
		}else {
			pk = new Integer [] {idSeccion};
		}
		categoriaPK = new CategoriaPK(pk);
		return categoriaPK;
	}

	public static String getSaveDirectory(){
        return saveDirectory;
    }

    public static void inicioMapeo() throws Exception {
            File fil = new File(Globals.GENERACION_DIRECTORIO);

		     Process proces = null;
		     if (fil.exists()) {
			    TmkLogger.debug("COMIENZA DESMAPEO");
			    try {
				    proces = Runtime.getRuntime().exec(Globals.GENERACION_SENTENCIA_DE_DESMAPEO);
			    } catch (Exception e) {
				    TmkLogger.error("DESMAPEO] No se genero el proceso");
				    throw new Exception("No se genero el proceso de desmapeo");
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

					    }
				    }
				    if (procesoError) {
					    TmkLogger.error("DESPMAPEO] fallo el proceso");
					    throw new Exception ("fallo el proceso de desmapeo");
				    }
				    TmkLogger.debug("DESMAPEO REALIZADO");
			    } else {
			      TmkLogger.error("DESMAPEO] No se genero el proceso");
			      throw new Exception ("No se genero el proceso de desmapeo");
			    }
		     } else {
		          TmkLogger.debug("DESMAPEO] No es necesario");

		     }
	         proces = null;
	         TmkLogger.debug("COMIENZA MAPEO");
		     try {
		        proces = Runtime.getRuntime().exec(Globals.GENERACION_SENTENCIA_DE_MAPEO);
		     } catch (Exception e) {
			     TmkLogger.error("MAPEO] No se genero el proceso");
			     throw new Exception("No se genero el proceso de mapeo");
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

				    }
			    }
			    if (procesoError) {
				    TmkLogger.error("MAPEO] fallo el proceso");
				    throw new Exception ("fallo el proceso de mapeo");
			    }
			    TmkLogger.debug("MAPEO REALIZADO");

		    } else {
			    TmkLogger.error("MAPEO] No se genero el proceso");
			    throw new Exception ("No se genero el proceso de mapeo");
		    }
    }


    public static boolean generarFamiliaEstatica(int seccion, String grupo, String familia) {
    	CategoriaPK categoriaPK;
    	if (familia != null && !"-1".equals(familia)) {
    		categoriaPK = new CategoriaPK( new Integer[] {new Integer(seccion),
    					new Integer(grupo),
    					new Integer(familia)});
    	} else {
    		categoriaPK = new CategoriaPK( new Integer[] {new Integer(seccion),
					new Integer(grupo)});
    	}
    	return generarFamiliaEstatica(categoriaPK);

    }

    public static boolean generarFamiliaEstatica(CategoriaPK categoriaPK) {

    	Integer []pk = categoriaPK.getPK();
		String directorio = "/familias";
    	StringBuffer paginaDinamica = new StringBuffer();
    	StringBuffer paginaGenerada = new StringBuffer();
    	boolean generacionOK = true;
    	boolean resultado = true;
		StringBuffer clave = new StringBuffer();

		clave.append("_").append(pk[0]).append("_").append(pk[1]);
		if (pk.length>2) {
			clave.append("_").append(pk[2]);
		}


//GENERACION TOP

		if (pk.length>1) {
			paginaDinamica.append("/componentes/comunes/topFamilia.jsp?");
			paginaDinamica.append(MainHelper.FIELD_ID_SECCION).append("=").append(pk[0]);
			paginaDinamica.append("&").append(MainHelper.FIELD_ID_GRUPO).append("=").append(pk[1]);
			paginaDinamica.append("&").append(MainHelper.FIELD_ID_FAMILIA).append("=").append((pk.length>2)?pk[2]+"":"");

			paginaGenerada.append(directorio).append("/topFamilia").append(clave).append(".html");

			resultado = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica.toString(), paginaGenerada.toString(), "contenidosEstaticos");
			generacionOK = (generacionOK && resultado);

//GENERACION ARBOL
			paginaGenerada = new StringBuffer();
			paginaDinamica = new StringBuffer();
			paginaDinamica.append("/componentes/comunes/arbolCategorias.jsp?");
			paginaDinamica.append(MainHelper.FIELD_ID_SECCION).append("=").append(pk[0]);
			paginaDinamica.append("&").append(MainHelper.FIELD_ID_GRUPO).append("=").append(pk[1]);
			paginaDinamica.append("&").append(MainHelper.FIELD_ID_FAMILIA).append("=").append((pk.length>2)?pk[2]+"":"");

			paginaGenerada.append(directorio).append("/arbol").append(clave).append(".html");

			resultado = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica.toString(), paginaGenerada.toString(), "contenidosEstaticos");
			generacionOK = (generacionOK && resultado);
		}
	    return generacionOK;
    }



    public static boolean generarRankingEstatico(int seccion, String categoria, int registroInicial, int registroFinal) {

		String directorio = "/ranking";
    	String paginaDinamica;
    	String paginaGenerada;
    	boolean generacionOK = true;
    	boolean resultado = true;

    	try{
    		paginaDinamica = "/ranking/ranking.jsp?idSeccion=" + seccion + "&nombreGrupo=" + URLEncoder.encode(categoria,"ISO-8859-1") + "&registroInicial=" + registroInicial + "&registroFinal=" + registroFinal;
    		paginaGenerada = directorio + "/" + "ranking" + seccion  + categoria + "p" + registroInicial + "_" + registroFinal + ".html";

    		if (seccion!=-1 && !categoria.equals("-1")) {
    			resultado = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
    			generacionOK = (generacionOK && resultado);
    		}
    	} catch(Exception e){
    		return generacionOK = false;
        }
	    return generacionOK;
    }


    public static boolean borrarFile (String ruta) {
    	try {
	    	File file = new File (ruta);
	    	if (file.exists()) {
	    		file.delete();
	    	}
	    	return true;
    	} catch (Exception e) {
    		TmkLogger.error("No se pudo borrar file " + ruta + " " + e.toString() + MainHelper.getMessage(e));
    		return false;
    	}
    }


	///HACER EL BORRADO
	public static boolean borrarDetalle(int idArticulo, int idSeccion) {

		String directorio = "/articulos";
		String dirAdicional = "" + (int)Math.floor(idArticulo/1000) * 1000;
		//String paginaDinamica;
		String paginaGenerada;

		try{

	//DETALLE DEL ARTICULO

		    	//detalle
		    	paginaGenerada = directorio + "/" + dirAdicional + "/detalle" + idArticulo + ".html";

		    	MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");

				//tag
		    	paginaGenerada = directorio + "/" + dirAdicional + "/tagDetalle" +  idArticulo + ".html";

		    	MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");



	//BIOGRAFIA
				if (idSeccion != Globals.SECCION_JUGUETES) {
					int idAutor = ArticuloManager.getAutorConBiografia(idArticulo,(idSeccion == Globals.SECCION_PELICULA)? "('D02', 'E01')":"'A01'",Contenido.getServletContext());

					if (idAutor > -1) {

						//detalle
						paginaGenerada = directorio + "/" + dirAdicional + "/biografia" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");


						//tag
						paginaGenerada = directorio + "/" + dirAdicional + "/tagBio" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");

					}
				}

				if (idSeccion == Globals.SECCION_LIBRO) {
	//PRIMER CAPITULO
					if (ArticuloManager.tienePrimerCapitulo(idArticulo,Contenido.getServletContext())) {

						//detalle
						paginaGenerada = directorio + "/" + dirAdicional + "/primerCapitulo" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");


						//tag
						paginaGenerada = directorio + "/" + dirAdicional + "/tagCap" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");

					}

	//INDICE DE CONTENIDOS
					if (ArticuloManager.tieneIndice(idArticulo)) {
						//detalle
						paginaGenerada = directorio + "/" + dirAdicional + "/indiceDeContenidos" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");


						//tag
						paginaGenerada = directorio + "/" + dirAdicional + "/tagIndice" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");

					}

	//ENTREVISTA
					if (ArticuloManager.tieneEntrevista(idArticulo, Contenido.getServletContext())) {
						//detalle
						paginaGenerada = directorio + "/" + dirAdicional + "/entrevista" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");


						//tag
						paginaGenerada = directorio + "/" + dirAdicional + "/tagEntre" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");

					}

				} else {

	//NOTA DE PRENSA
					if (ArticuloManager.tieneNotaDePrensa(idArticulo, Contenido.getServletContext())) {
						//detalle
						paginaGenerada = directorio + "/" + dirAdicional + "/notaPrensa" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");


						//tag
						paginaGenerada = directorio + "/" + dirAdicional + "/tagNota" + idArticulo + ".html";

						MainHelper.deleteFileNet(paginaGenerada, "contenidosEstaticos");

					}
				}

				return true;
		} catch (Exception e) {
			//MainHelper.enviarMailDeError("Error en borrado de detalles idArticulo=" + idArticulo + ", idSeccion=" + idSeccion + " exception " + e.toString() + " " + MainHelper.getMessage(e));
	        TmkLogger.error("Error en borrado de detalles idArticulo=" + idArticulo + ", idSeccion=" + idSeccion + " exception " + e.toString() + " " + MainHelper.getMessage(e));
	        return false;
	    }
	}

}
