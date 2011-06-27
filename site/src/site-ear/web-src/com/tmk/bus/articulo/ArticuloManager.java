/* *
 * Log$
 * */

package com.tmk.bus.articulo;

import java.util.Iterator;
import java.util.Vector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Timestamp;

import javax.servlet.ServletContext;

import org.apache.commons.beanutils.DynaBean;

import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Globals;
import com.tmk.bus.articulo.ArticuloClass;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.site.Claves;
import com.tmk.kernel.site.Producto;
import com.tmk.kernel.site.RecorridoFamilias;
import com.tmk.kernel.site.RecorridoGrupos;
import com.tmk.kernel.site.RecorridoSecciones;
import com.tmk.service.categoria.CategoriaService;
import com.tmk.setup.Contenido;

public final class ArticuloManager {


	private static final String DIRECTORIO_ASOCIADAS = "/asociadas";
	private static final String DIRECTORIO_NOTAS_PRENSA = DIRECTORIO_ASOCIADAS + "/notasDePrensa";
	private static final String DIRECTORIO_ENTREVISTAS = DIRECTORIO_ASOCIADAS + "/entrevistas";
	private static final String DIRECTORIO_BIOGRAFIAS = DIRECTORIO_ASOCIADAS + "/biografias";
	private static final String DIRECTORIO_CAPITULOS = DIRECTORIO_ASOCIADAS + "/capitulos";
	private static final String EXTENSION_TXT = ".txt";


	public static Vector totalArticulos = null;
	public static Vector totalArticulosY = null;
	public static Vector totalArticulosM = null;


	//public static int articulosMV[][] = new int[6][];
	public static int articulosMVY[][] = new int[6][];
	public static int articulosMVM[][] = new int[6][];

	public static int articulosMVA[][] = new int[6][];
	public static int articulosMVAY[][] = new int[6][];
	public static int articulosMVAM[][] = new int[6][];

	public static int articulosMP[][] = new int[6][];
	public static int articulosMPY[][] = new int[6][];
	public static int articulosMPM[][] = new int[6][];

	//para detalle pero por ISBN
	public static ArticuloClass getArticuloParaDetalle(String ISBN) {
		ArticuloClass articulo = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" SELECT a.id_articulo, a.categoria_seccion, cod_ext_visual");
					qry.append(" FROM articulos a ");
					qry.append(" 	,articulos_isbn ai");
					qry.append(" WHERE a.id_articulo = ai.id_articulo");
					qry.append(" 	and	(ai.isbn = UPPER(REPLACE('").append(ISBN).append("','-',''))");
					qry.append("		OR ai.isbn = (SELECT '978'||SUBSTR(UPPER(REPLACE('").append(ISBN).append("', '-', '')),1,9)");
					qry.append("						|| dv('978'||SUBSTR(UPPER(REPLACE('").append(ISBN).append("', '-', '')),1,9)) FROM dual)");
					qry.append("		OR ai.isbn = (SELECT SUBSTR (REPLACE('").append(ISBN).append("', '-', ''),4,9) ");
					qry.append("				   	    || dv(SUBSTR(UPPER(REPLACE('").append(ISBN).append("', '-', '')),4,9)) FROM dual))");

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							articulo = new ArticuloClass(rs.getInt("id_articulo"));
							articulo.setISBN(rs.getString("cod_ext_visual"));
							CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion"))});
							articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticuloParaDetalle(recorrido de rs), " + ISBN + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticuloParaDetalle(ejecucion de qry), " + ISBN + e.toString());
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosParaDetalle(creacion de statement), " + ISBN + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticuloParaDetalle(conexion), " + ISBN + e.toString());
		}
		return articulo;
	}



	//para detalleArticulo
	public static ArticuloClass getArticuloParaDetalle(int idArticulo) {
		ArticuloClass articulo = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" SELECT a.id_articulo, a.categoria_seccion, cod_ext_visual isbn, ROUND (precio_venta_vigente * ( 1");
					qry.append(" 	+ NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append(" 	+ NVL (tasa_adicional, 0)");
					qry.append(" 	+ NVL (tasa_percep_video, 0)");
					qry.append(" 	FROM tasas");
					qry.append(" 	WHERE id_impuesto = a.id_impuesto");
					qry.append(" 	AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append(" 	AND fecha_vigencia =");
					qry.append(" 		(SELECT MAX (fecha_vigencia)");
					qry.append(" 		FROM tasas");
					qry.append(" 		WHERE id_impuesto = a.id_impuesto");
					qry.append(" 		AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append(" 	AND fecha_vigencia <= SYSDATE))");
					qry.append(" 	/ 100,0)),2) precio");
					qry.append(" FROM articulos a ");
					qry.append(" WHERE a.id_articulo = ").append(idArticulo);

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							articulo = new ArticuloClass(rs.getInt("id_articulo"));
							articulo.setPrecio(rs.getDouble("precio"));
							articulo.setISBN(rs.getString("isbn"));
							CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion"))});
							articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
						}

					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticuloParaDetalle(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticuloParaDetalle(ejecucion de qry), " + idArticulo + e.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticuloParaDetalle(creacion de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticuloParaDetalle(conexion), " + idArticulo + e.toString());
		}
		return articulo;
	}

	/**
	 * determina si el campo "tipo" de la tabla ARTICULOS_TEXTOS es '04' 
	 * @param idArticulo
	 * @return
	 */
	public static boolean tieneIndice (int idArticulo) {
		boolean retorno = false;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" Select id_articulo");
					qry.append(" from articulos_textos");
					qry.append(" where tipo='04'");
					qry.append(" and id_articulo=").append(idArticulo);

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							retorno = true;
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: tieneIndice(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: tieneIndice(ejecucion de qry), " + idArticulo + e.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: tieneIndice(creacion de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: tieneIndice(conexion), " + idArticulo + e.toString());
		}
		return retorno;
	}

	public static String getIndice (int idArticulo) {
		StringBuffer retorno = new StringBuffer();
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" Select parte, texto");
					qry.append(" from articulos_textos");
					qry.append(" where tipo='04'");
					qry.append(" and id_articulo=").append(idArticulo);
					qry.append(" order by parte");

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							retorno.append(rs.getString("texto"));
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getIndice(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getIndice(ejecucion de qry), " + idArticulo + e.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getIndice(creacion de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: tieneIndice(conexion), " + idArticulo + e.toString());
		}
		return retorno.toString();
	}


	/*
	 * Me dice si tiene al menos un archivo de nota de prensa el idArticulo
	 */
	public static boolean tieneNotaDePrensa(int idArticulo, ServletContext servletContext) {
		try {
			String pathDeArchivo = new StringBuffer(DIRECTORIO_NOTAS_PRENSA).append("/").append(idArticulo + EXTENSION_TXT).toString();
			File file = new File(servletContext.getRealPath(pathDeArchivo));

			return file.exists();
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: tieneNotasDePrensa, " + idArticulo + e.toString());
			return false;
		}
	}


	public static String getNotaDePrensa(int idArticulo,  ServletContext servletContext) {
		try {
			String pathDeArchivo = new StringBuffer(DIRECTORIO_NOTAS_PRENSA).append("/").append(idArticulo + EXTENSION_TXT).toString();
			return Globals.loadFileContent("<br>", servletContext.getRealPath(pathDeArchivo));
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getNotaDePrensa, " + idArticulo + e.toString());
			return null;
		}
	}


	/*
	 * Me dice si tiene al menos un archivo de entrevistas el idArticulo
	 */
	public static boolean tieneEntrevista(int idArticulo, ServletContext servletContext) {
		try {
			String pathDeArchivo = new StringBuffer(DIRECTORIO_ENTREVISTAS).append("/").append(idArticulo + EXTENSION_TXT).toString();
			File file = new File(servletContext.getRealPath(pathDeArchivo));
			return file.exists();
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: tieneEntrevista, " + idArticulo + e.toString());
			return false;
		}
	}


	public static String getEntrevista(int idArticulo,  ServletContext servletContext) {
		try {
			String pathDeArchivo = new StringBuffer(DIRECTORIO_ENTREVISTAS).append("/").append(idArticulo + EXTENSION_TXT).toString();
			return Globals.loadFileContent("<br>", servletContext.getRealPath(pathDeArchivo));
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getEntrevista, " + idArticulo + e.toString());
			return null;
		}
	}

	/*
	 * Me dice si tiene el primer capitulo del idArticulo
	 */
	public static boolean tienePrimerCapitulo(int idArticulo,  ServletContext servletContext) {
		try {
			String pathDeArchivo = new StringBuffer(DIRECTORIO_CAPITULOS).append("/").append(idArticulo + EXTENSION_TXT).toString();
			File file = new File(servletContext.getRealPath(pathDeArchivo));
			return file.exists();
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: tienePrimerCapitulo, " + idArticulo + e.toString());
			return false;
		}
	}


	public static String getPrimerCapitulo(int idArticulo,  ServletContext servletContext) {
		try {
			String pathDeArchivo = new StringBuffer(DIRECTORIO_CAPITULOS).append("/").append(idArticulo + EXTENSION_TXT).toString();
			return Globals.loadFileContent("<br>", servletContext.getRealPath(pathDeArchivo));
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getPrimerCapitulo, " + idArticulo + e.toString());
			return null;
		}
	}


	/*
	 * Devuelve de la base, el texto de la biografia del idArticulo del idAutor
	 * */
	public static String getBiografiaBase (int idArticulo, int idAutor) {
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" SELECT texto");
					qry.append(" FROM articulos_autores_biografia");
					qry.append(" WHERE id_articulo=").append(idArticulo);
					qry.append(" AND id_autor=").append(idAutor);
					qry.append(" ORDER BY parte");
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						StringBuffer buffer = new StringBuffer();
						while (rs.next()) {
							buffer.append(rs.getString("texto"));
						}
						return (buffer.toString().trim().length() < 10) ? null : buffer.toString();

					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getBiografiaBase(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getBiografiaBase(ejecucion de qry), " + idArticulo + e.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getBiografiaBase(creacion de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: tieneIndice(conexion), " + idArticulo + e.toString());
		}
		return null;
	}


	/*
	 * Devuelve del archivo, el texto de la biografia del idArticulo
	 * */
	public static String getBiografiaArchivo(int idArticulo, int idAutor, ServletContext servletContext) {
		try {
			String pathDeArchivo = new StringBuffer(DIRECTORIO_BIOGRAFIAS).append("/").append(idAutor + EXTENSION_TXT).toString();
			File file = new File(servletContext.getRealPath(pathDeArchivo));
			if(file.exists()){
				try{
					BufferedReader reader = new BufferedReader(new FileReader(servletContext.getRealPath(pathDeArchivo)));
					try {
						StringBuffer buffer = new StringBuffer();
						while (reader.ready()) {
							buffer.append(reader.readLine()).append("<br>");
						}
						return buffer.toString();
					} finally {
						reader.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getBiografiaArchivo(reader) " + idArticulo + e.toString());
					return null;
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getBiografiaArchivo(creacion de objeto file) " + idArticulo + e.toString());
		}
		return null;
	}


	/*
	 * Devuelve el texto de la biografia del idArticulo, ya sea del archivo o de la base
	 * */
	public static String getBiografia(int idArticulo, int idAutor, ServletContext servletContext){

		String biografiaArchivo = getBiografiaArchivo(idArticulo, idAutor,servletContext);
		return (biografiaArchivo!=null)? biografiaArchivo : getBiografiaBase(idArticulo, idAutor);
	}


	public static int getAutorConBiografia(int idArticulo, String role, ServletContext servletContext){
		int retorno = -1;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" SELECT id_Autor");
					qry.append(" FROM articulos_autores");
					qry.append(" WHERE id_articulo=").append(idArticulo);
					qry.append(" AND role in ").append(role);

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							if (getBiografia(idArticulo, rs.getInt("id_Autor"), servletContext) != null) {
								retorno = rs.getInt("id_Autor");
								return retorno;
							}
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getAutorConBiografia(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getAutorConBiografia(ejecucion de qry), " + idArticulo + e.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getAutorConBiografia(creacion de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getAutorConBiografia(conexion), " + idArticulo + e.toString());
		}
		return retorno;
	}

	/**
	 * Devuelve un array con: idAutor, nombreAutor, idArticulo  de aquellos autores que tienen un archivo
	 * de entrevista y pertenecen a la seccion libros
	 *
	 */
	public static final String[] getAutorDeEntrevista(int idSeccion, ServletContext servletContext) throws Exception {

		StringBuffer entrevistas = new StringBuffer();
		Integer articulo;
		Vector<String> entrevistasAutores = new Vector<String>();
		String autorEntrevista="";

		File file = new File(servletContext.getRealPath(DIRECTORIO_ENTREVISTAS));
		File [] archivos = file.listFiles();


		for(int i=0; i<archivos.length;i++){
			try{
				articulo = new Integer(archivos[i].getName().replaceAll(".txt",""));
				entrevistas = entrevistas.append(", ").append(articulo);

			}catch (Exception e){
				TmkLogger.error("ArticuloManager] getAutorDeEntrevista(Nombre de archivo de entrevista con caracteres no numericos), "  + e.toString());
			}
		}

		entrevistas.replace(0,1,"");

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				if(entrevistas.length() > 0){
					try {
						StringBuffer qry = new StringBuffer();
						qry.append(" SELECT aa.id_autor idAutor, nvl(aut.descripcion2, aut.descripcion) nombreAutor,");
						qry.append(" 		 a.id_articulo idArticulo ");
						qry.append(" FROM articulos_autores aa, articulos a, autores aut ");
						qry.append(" WHERE aa.id_articulo in (").append(entrevistas).append(")");
						qry.append(" 	and aa.id_articulo = a.id_articulo");
						qry.append(" 	and aa.id_autor = aut.id_autor");
						qry.append(" 	and aa.role in ('A01')");
						qry.append("    and a.categoria_seccion =").append(idSeccion);
						qry.append(" 	and a.habilitado_tematika ='S'");
						qry.append(" ORDER BY a.id_articulo");

						ResultSet rs = st.executeQuery(qry.toString());

						int i =0;

						try {
							while (rs.next()){

								if(entrevistasAutores.size()== 0){
									entrevistasAutores.add(i,rs.getString("idAutor"));
									entrevistasAutores.add(i+1, Convert.nombrePropio(rs.getString("nombreAutor"), false));
									entrevistasAutores.add(i+2,rs.getString("idArticulo"));
									i=i+3;
								}else{
									if(rs.getString("idArticulo").equals(entrevistasAutores.get(i-1).toString())){
										entrevistasAutores.set(i-3,entrevistasAutores.get(i-3).toString() +  "," + rs.getString("idAutor"));
										entrevistasAutores.set(i-2, entrevistasAutores.get(i-2).toString()+" <br />" + Convert.nombrePropio(rs.getString("nombreAutor"), false));
									}else{
										entrevistasAutores.add(i,rs.getString("idAutor"));
										entrevistasAutores.add(i+1, Convert.nombrePropio(rs.getString("nombreAutor"), false));
										entrevistasAutores.add(i+2,rs.getString("idArticulo"));
										i=i+3;
									}
								}
							}
							if(entrevistasAutores.size()>0){
								for(int j=0 ; j < entrevistasAutores.size() ; j=j+3){
									autorEntrevista = autorEntrevista + entrevistasAutores.get(j) + " ; " + entrevistasAutores.get(j+1)+ " ; " + entrevistasAutores.get(j+2)+ "; ";
								}
								autorEntrevista = autorEntrevista.substring(0, autorEntrevista.length()-1);
							}
						} catch (Exception e) {
							TmkLogger.error("ArticuloManager] getAutorDeEntrevista(recorrido de rs), "  + e.toString());
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager] getAutorDeEntrevista(ejecucion de qry), "  + e.toString());

					}  finally {
						st.close();
					}
				}else{
					return autorEntrevista.split(";");
				}

			} catch (Exception e) {
				TmkLogger.error("ArticuloManager] getAutorDeEntrevista(creacion de statement), " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager] getAutorDeEntrevista(conexion), " + e.toString());
		}

		return autorEntrevista.split(";");
	}


	/**
	 * Devuelve la cantidad de entrevistas de la seccion pasada por parametro
	 */
	public static final int getCantidadDeEntrevistas(ServletContext servletContext, int idSeccion) throws Exception {

		StringBuffer entrevistas = new StringBuffer();
		int cantidadEntrevistas = 0;
		Integer articulo;

		File file = new File(servletContext.getRealPath(DIRECTORIO_ENTREVISTAS));
		File [] archivos = file.listFiles();

		for(int i=0; i<archivos.length;i++){
			try{
				articulo = new Integer(archivos[i].getName().replaceAll(".txt",""));
				entrevistas = entrevistas.append(", ").append(articulo);

			}catch (Exception e){
				TmkLogger.error("ArticuloManager: getCantidadDeEntrevistas(Nombre de archivo de entrevista con caracteres no numericos), "  + e.toString());
			}
		}

		entrevistas.replace(0,1,"");

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				if(entrevistas.length() > 0){
					try {

						StringBuffer qry = new StringBuffer();

						qry.append(" SELECT count(*) cantidad  ");
						qry.append(" FROM articulos a");
						qry.append(" WHERE a.id_articulo in (").append(entrevistas).append(")");
						qry.append(" 	and a.categoria_seccion =").append(idSeccion);
						qry.append(" GROUP BY a.categoria_seccion");

						ResultSet rs = st.executeQuery(qry.toString());

						try {
							while (rs.next()) {
								cantidadEntrevistas = rs.getInt("cantidad");
							}

						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getCantidadDeEntrevistas(recorrido de rs), "  + e.toString());
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getCantidadDeEntrevistas(ejecucion de qry), "  + e.toString());

					}  finally {
						st.close();
					}
				}else{
					return cantidadEntrevistas;
				}

			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getCantidadDeEntrevistas(creacion de statement), " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getCantidadDeEntrevistas(conexion), " + e.toString());
		}
		return cantidadEntrevistas;
	}



	public static final ArticuloClass [] getArticulosConNotasDePrensa(int idSeccion, ServletContext servletContext) throws Exception {

		StringBuffer notasDePrensa = new StringBuffer();
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>();
		ArticuloClass articulo;

		File file = new File(servletContext.getRealPath(DIRECTORIO_NOTAS_PRENSA));
		File [] archivos = file.listFiles();


		for(int i=0; i<archivos.length;i++){
			try{
				notasDePrensa = notasDePrensa.append(", ").append(archivos[i].getName().replaceAll(".txt",""));
			}catch (Exception e){
				TmkLogger.error("ArticuloManager: getArticulosConNotasDePrensa(Nombre de archivo de entrevista con caracteres no numericos), "  + e.toString());
			}
		}

		notasDePrensa.replace(0,1,"");

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				if(notasDePrensa.length() > 0){
					try {

						StringBuffer qry = new StringBuffer();

						qry.append(" SELECT aa.id_autor idAutor, nvl(aut.descripcion2, aut.descripcion) nombreAutor, a.id_articulo idArticulo, a.titulo titulo, a.categoria_seccion seccion  ");
						qry.append(" FROM articulos_autores aa, articulos a, autores aut ");
						qry.append(" WHERE aa.id_articulo in (").append(notasDePrensa).append(")");
						qry.append(" 	and aa.id_articulo = a.id_articulo");
						qry.append(" 	and aa.id_autor = aut.id_autor");
						qry.append(" 	and aa.role in ('A01')");
						qry.append("    and a.categoria_seccion =").append(idSeccion);
						qry.append(" 	and a.habilitado_tematika ='S'");
						qry.append(" ORDER BY a.id_articulo");

						ResultSet rs = st.executeQuery(qry.toString());

						//TmkLogger.debug(qry.toString());

						int idArticuloAnt = 0; //para corte de control

						try {
							int i = 0;
							articulo = new ArticuloClass(-1);
							while (rs.next()) {
								if (rs.getInt("idArticulo") != idArticuloAnt) {
									if (articulo.getIdArticulo() != -1) {
										articulos.add(articulo);
									}
									articulo = new ArticuloClass(rs.getInt("idArticulo"));
									articulo.setAutor(rs.getInt("idAutor"),Convert.nombrePropio(rs.getString("nombreAutor"), false));
									articulo.setTitulo(rs.getString("titulo"));
									CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion"))});
									articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								}else{
									articulo.setAutor(rs.getInt("idAutor"),Convert.nombrePropio(rs.getString("nombreAutor"), false));
								}
								idArticuloAnt = articulo.getIdArticulo();
								i++;
							}
							if (i>0) {
								articulos.add(articulo);
							}


						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getArticulosConNotasDePrensa(recorrido de rs), "  + e.toString());
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosConNotasDePrensa(ejecucion de qry), "  + e.toString());

					}  finally {
						st.close();
					}
				}else{
					return null;
				}

			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosConNotasDePrensa(creacion de statement), " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosConNotasDePrensa(conexion), " + e.toString());
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}


	public static final ArticuloClass [] getArticulosConPrimerCapitulo(ServletContext servletContext) throws Exception {

		StringBuffer articulosPrimerCapitulo = new StringBuffer();
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>();
		ArticuloClass articulo;

		File file = new File(servletContext.getRealPath(DIRECTORIO_CAPITULOS));
		File [] archivos = file.listFiles();


		for(int i=0; i<archivos.length;i++){
			try{
				articulosPrimerCapitulo = articulosPrimerCapitulo.append(", ").append(archivos[i].getName().replaceAll(".txt",""));
			}catch (Exception e){
				TmkLogger.error("ArticuloManager: getArticulosConPrimerCapitulo(Nombre de archivo de primer capitulo con caracteres no numericos), "  + e.toString());
			}
		}

		articulosPrimerCapitulo.replace(0,1,"");

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				if(articulosPrimerCapitulo.length() > 0){
					try {

						StringBuffer qry = new StringBuffer();

						qry.append(" SELECT aa.id_autor idAutor, nvl(aut.descripcion2, aut.descripcion) nombreAutor, a.id_articulo idArticulo, a.titulo titulo, a.categoria_seccion, a.categoria_grupo, a.categoria_familia, a.categoria_subfamilia ");
						qry.append(" FROM articulos_autores aa, articulos a, autores aut ");
						qry.append(" WHERE aa.id_articulo in (").append(articulosPrimerCapitulo).append(")");
						qry.append(" 	and aa.id_articulo = a.id_articulo");
						qry.append(" 	and aa.id_autor = aut.id_autor");
						qry.append(" 	and aa.role in ('A01')");
						qry.append(" 	and a.categoria_seccion = ").append(Globals.SECCION_LIBRO);
						qry.append(" 	and a.habilitado_tematika ='S'");
						qry.append(" ORDER BY a.id_articulo");

						ResultSet rs = st.executeQuery(qry.toString());

						//TmkLogger.debug(qry.toString());

						int idArticuloAnt = 0; //para corte de control

						try {
							int i = 0;
							articulo = new ArticuloClass(-1);
							while (rs.next()) {
								if (rs.getInt("idArticulo") != idArticuloAnt) {
									if (articulo.getIdArticulo() != -1) {
										articulos.add(articulo);
									}
									articulo = new ArticuloClass(rs.getInt("idArticulo"));
									articulo.setAutor(rs.getInt("idAutor"), Convert.nombrePropio(rs.getString("nombreAutor"), false));
									articulo.setTitulo(rs.getString("titulo"));
									CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subfamilia"))});
									articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								}else{
									articulo.setAutor(rs.getInt("idAutor"), Convert.nombrePropio(rs.getString("nombreAutor"), false));
								}
								idArticuloAnt = articulo.getIdArticulo();
								i++;
							}
							if (i>0) {
								articulos.add(articulo);
							}


						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getArticulosConPrimerCapitulo(recorrido de rs), "  + e.toString());
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosConPrimerCapitulo(ejecucion de qry), "  + e.toString());

					}  finally {
						st.close();
					}
				}else{
					return null;
				}

			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosConPrimerCapitulo(creacion de statement), " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosConPrimerCapitulo(conexion), " + e.toString());
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}



	public static final ArticuloClass [] getArticulosConIndiceDeContenidos(ServletContext servletContext) throws Exception {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>();
		ArticuloClass articulo;

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
					try {

						StringBuffer qry = new StringBuffer();

						qry.append(" SELECT aa.id_autor idAutor, nvl(aut.descripcion2, aut.descripcion) nombreAutor, a.id_articulo idArticulo, a.titulo titulo, a.categoria_seccion, a.categoria_grupo, a.categoria_familia, a.categoria_subfamilia ");
						qry.append(" FROM articulos_textos ate, articulos a, articulos_autores aa, autores aut ");
						qry.append(" WHERE a.id_articulo = aa.id_articulo(+)");
						qry.append(" 	and a.id_articulo = ate.id_articulo");
						qry.append(" 	and ate.parte = 1");
						qry.append(" 	and a.habilitado_tematika ='S'");
						qry.append(" 	and aut.id_autor = aa.id_autor");
						qry.append(" 	and ate.tipo = '04'");
						qry.append("    and aa.role in ('A01')");
						qry.append(" 	and ate.parte = 1");
						qry.append(" ORDER BY a.titulo");


						ResultSet rs = st.executeQuery(qry.toString());


						int idArticuloAnt = 0; //para corte de control

						try {
							int i = 0;
							articulo = new ArticuloClass(-1);
							while (rs.next()) {
								if (rs.getInt("idArticulo") != idArticuloAnt) {
									if (articulo.getIdArticulo() != -1) {
										articulos.add(articulo);
									}
									articulo = new ArticuloClass(rs.getInt("idArticulo"));
									articulo.setAutor(rs.getInt("idAutor"),rs.getString("nombreAutor"));
									articulo.setTitulo(rs.getString("titulo"));
									CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")),
																					   new Integer(rs.getInt("categoria_grupo")),
																					   new Integer(rs.getInt("categoria_familia")),
																					   new Integer(rs.getInt("categoria_subfamilia"))
									});
									articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));

								}else{
									articulo.setAutor(rs.getInt("idAutor"),rs.getString("nombreAutor"));
								}
								idArticuloAnt = articulo.getIdArticulo();
								i++;
							}
							if (i>0) {
								articulos.add(articulo);
							}


						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getArticulosConIndiceDeContenidos(recorrido de rs), "  + e.toString());
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosConIndiceDeContenidos(ejecucion de qry), "  + e.toString());

					}  finally {
						st.close();
					}

			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosConIndiceDeContenidos(creacion de statement), " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosConIndiceDeContenidos(conexion), " + e.toString());
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}


	public static final ArticuloClass [] getArticulosConComentarios(int idSeccion, ServletContext servletContext) throws Exception {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>();
		ArticuloClass articulo;

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
					try {

						StringBuffer qry = new StringBuffer();

						qry.append(" SELECT aa.id_autor idAutor, nvl(aut.descripcion2, aut.descripcion) nombreAutor, a.id_articulo idArticulo, a.titulo titulo, a.categoria_seccion, a.categoria_grupo, a.categoria_familia, a.categoria_subfamilia ");
						qry.append(" FROM articulos a, articulos_autores aa, comentario_articulos ca, autores aut");
						qry.append(" WHERE aut.id_autor = aa.id_autor");
						qry.append(" 	and a.id_articulo =aa.id_articulo");
						qry.append(" 	and a.id_articulo = ca.id_articulo");
						qry.append("    and a.categoria_seccion =").append(idSeccion);
						qry.append(" 	and a.habilitado_tematika ='S'");
						qry.append(" 	and ca.estado = 'A' ");
						qry.append(" 	and aa.role in('A01')");
						qry.append(" ORDER BY a.titulo");

						ResultSet rs = st.executeQuery(qry.toString());

						int idArticuloAnt = 0; //para corte de control

						try {
							int i = 0;
							articulo = new ArticuloClass(-1);
							while (rs.next()) {
								if (rs.getInt("idArticulo") != idArticuloAnt) {
									if (articulo.getIdArticulo() != -1) {
										articulos.add(articulo);
									}
									articulo = new ArticuloClass(rs.getInt("idArticulo"));
									articulo.setAutor(rs.getInt("idAutor"),rs.getString("nombreAutor"));
									articulo.setTitulo(rs.getString("titulo"));
									CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subfamilia"))});
									articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								}else{
									articulo.setAutor(rs.getInt("idAutor"),rs.getString("nombreAutor"));
								}
								idArticuloAnt = articulo.getIdArticulo();
								i++;
							}
							if (i>0) {
								articulos.add(articulo);
							}


						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getArticulosConComentarios(recorrido de rs), "  + e.toString());
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosConComentarios(ejecucion de qry), "  + e.toString());

					}  finally {
						st.close();
					}

			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosConComentarios(creacion de statement), " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosConComentarios(conexion), " + e.toString());
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}




	public static ArticuloClass getTextos(int idArticulo, int idSeccion) {
		ArticuloClass articulo = new ArticuloClass (idArticulo);
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				switch (idSeccion) {
					case Globals.SECCION_JUGUETES:
					case Globals.SECCION_PELICULA:
					case Globals.SECCION_LIBRO: {
						qry.append(" select ate.tipo, nvl(to_number(ate.parte), 1) parteSinop, ate.texto textoSinop ");
						qry.append(" from articulos a, articulos_textos ate");
						qry.append(" where ");
						qry.append(" a.id_articulo = ate.id_articulo ");
						qry.append(" and (ate.tipo = '01' or ate.tipo = '17' or ate.tipo = '18') and ate.idioma='ES'");
						qry.append(" and a.id_articulo =").append(idArticulo);
						qry.append(" order by a.id_articulo, ate.parte");
						PreparedStatement ps = conn.prepareStatement(qry.toString());
						try {
							ResultSet rs = ps.executeQuery();
							try {
								while (rs.next()) {
									if (rs.getString("tipo").equals("01")) {
										articulo.setSinopsis(rs.getInt("parteSinop"), rs.getString("textoSinop"));
									}
									if (rs.getString("tipo").equals("17")) {
										articulo.setSolapa(rs.getInt("parteSinop"), rs.getString("textoSinop"));
									}
									if (rs.getString("tipo").equals("18")) {
										articulo.setContratapa(rs.getInt("parteSinop"), rs.getString("textoSinop"));

									}
								}
							} catch (Exception e) {
								TmkLogger.error("ArticuloManager: getSinopsis(recorrido de rs), " +  e.toString());
								TmkLogger.error(qry.toString());
							} finally {
								rs.close();
							}
						} finally {
							ps.close();
						}
						break;
					}
					case Globals.SECCION_MUSICA:{
						qry.append(" select nvl(atm.nro_tema, 1) nroTema, atm.nombre nombreTema");
						qry.append(" from articulos a,");
						qry.append(" articulos_temas_musicales atm");
						qry.append(" where");
						qry.append(" a.id_articulo = atm.id_articulo ");
						qry.append(" and a.id_articulo =").append(idArticulo);
						qry.append(" order by a.id_articulo, nroTema");
						PreparedStatement ps = conn.prepareStatement(qry.toString());
						try {
							ResultSet rs = ps.executeQuery(qry.toString());
							try {
								while (rs.next()) {
									articulo.setTemaMusical(rs.getInt("nroTema"), rs.getString("nombreTema"));
								}
							} catch (Exception e) {
								TmkLogger.error("ArticuloManager: getSinopsis(recorrido de rs), " +  e.toString());
								TmkLogger.error(qry.toString());
							} finally {
								rs.close();
							}
						} finally {
							ps.close();
						}
						break;
					}
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getSinopsis(creacion de statement), " + idArticulo + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getSinopsis(conexion), " + idArticulo + " " + e.toString());
		}
		return articulo;
	}

	 /*
	 * Devuelve un array con los idAutores del idArticulo
	 */
	public static final Vector getAutorDelArticulo(int idArticulo,String role) throws Exception {
		Vector autores = new Vector();

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();

					qry.append(" SELECT aut.id_autor, nvl(aut.descripcion2, aut.descripcion) descripcion ");
					qry.append(" FROM articulos_autores arta,autores aut ");
					qry.append(" WHERE arta.id_autor = aut.id_autor ");
					qry.append("and arta.id_articulo =").append(idArticulo);
					qry.append(" and arta.role in (").append(role);
					qry.append(" )");

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							autores.add(new Integer(rs.getInt("id_autor")));
							autores.add(Convert.nombrePropio(rs.getString("descripcion"), false));
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getAutorArticulo(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getAutorArticulo(ejecucion de qry), " + idArticulo + e.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getAutorArticulo(creacion de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getAutorArticulo(conexion), " + idArticulo + e.toString());
		}
		return autores;
	}






//	pasar los ids de articulos separados por ","
	public static ArticuloClass[] getArticulosParaResultadoDeBusqueda (String idsArticulos, int idSeccion) {
		//long tiempoinicial= Calendar.getInstance().getTimeInMillis();
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>(10);
		Vector<ArticuloClass> aux = new Vector<ArticuloClass>(10);
		String ids[] = idsArticulos.split(",");
		ArticuloClass articulo;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				int idArticuloAnt = 0; //para corte de control
				try {

					switch (idSeccion) {
						case Globals.SECCION_LIBRO:{
							  qry.append(" select a.id_articulo, a.titulo, aut.id_autor,");
							  qry.append(" nvl(aut.descripcion2, aut.descripcion) descripcion, a.id_editor,");
							  qry.append(" ROUND (precio_venta_vigente * ( 1");
							  qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
							  qry.append(" + NVL (tasa_adicional, 0)");
							  qry.append(" + NVL (tasa_percep_video, 0)");
							  qry.append(" FROM tasas");
							  qry.append(" WHERE id_impuesto = a.id_impuesto");
							  qry.append(" AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							  qry.append(" AND fecha_vigencia =");
							  qry.append(" 		(SELECT MAX (fecha_vigencia)");
							  qry.append("	FROM tasas");
							  qry.append("	WHERE id_impuesto = a.id_impuesto");
							  qry.append("	AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							  qry.append("	AND fecha_vigencia <= SYSDATE))");
							  qry.append("	/ 100,0)),2) precio, a.id_disponibilidad, a.habilitado_tematika,");
							  qry.append("	nvl(to_number(ate.parte), 1) parte, ate.texto,");
							  qry.append("	nvl(to_number(ate2.parte), 1) parteSinop, ate2.texto textoSinop, a.fecha_alta,");
							  qry.append("	cod_ext_visual isbn, ed.nombre editorial,");
							  qry.append("	decode(cg.rv_meaning, 'ESP-Book Book ¿ detail unspecified', '', 'ESP-Book Book – detail unspecified', '', 'ESP-Board book Child¿s book with all pages printed on board', '', rv_meaning) formato");
							  qry.append("	,a.categoria_seccion");
							  qry.append("	,a.categoria_grupo");
							  qry.append("	,a.categoria_familia");
							  qry.append("	,a.categoria_subFamilia");
							  qry.append("  ,aa.orden, aa.role ");
							  qry.append("  from articulos a");
							  qry.append("	left join articulos_autores aa");
							  qry.append("	on a.id_articulo = aa.id_articulo and aa.role  in ('A01', 'C01')");
							  qry.append("	left join autores aut");
							  qry.append("	on aa.id_autor = aut.id_autor");
							  qry.append("	left join editores ed");
							  qry.append("	on a.id_editor = ed.id_editor");
							  qry.append("	left join articulos_textos ate");
							  qry.append("	on a.id_articulo = ate.id_articulo and ate.tipo = '04'");
							  qry.append("	left join articulos_textos ate2");
							  qry.append("	on a.id_articulo = ate2.id_articulo and ate2.tipo = '01' and ate2.idioma='ES'");
							  qry.append("	left join cg_ref_codes cg");
							  qry.append("  on a.auxvarchar03 = cg.rv_low_value and cg.rv_domain = 'ONIX:ProductForm'");
							  qry.append("  where a.id_articulo in (").append(idsArticulos).append(")");
							  qry.append("  order by a.id_articulo, ate.parte, ate2.parte, aa.orden");
							  //TmkLogger.debug("qry = " + qry.toString());
							  ResultSet rs = st.executeQuery(qry.toString());
								try {
									int i = 0;
									articulo = new ArticuloClass(-1);
									while (rs.next()) {
										if (rs.getInt("id_articulo") != idArticuloAnt) {
											if (articulo.getIdArticulo() != -1) {
												aux.add(articulo);
											}
											articulo = new ArticuloClass(rs.getInt("id_articulo"));
											articulo.setTitulo(rs.getString("titulo"));
											articulo.setPrecio(rs.getDouble("precio"));
											articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
											articulo.setEsNovedad(rs.getDate("fecha_alta"));
											articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
											articulo.setEditorial(rs.getString("editorial"));
											articulo.setIdEditorial(rs.getInt("id_editor"));
											articulo.setISBN(rs.getString("ISBN"));
											articulo.setFormato(rs.getString("formato"));
											CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
											articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
										}
										if (rs.getString("descripcion") != null) {
											if (rs.getString("role").equals("A01")) {
												articulo.setAutor(rs.getInt("id_autor"), rs.getString("descripcion"));
											}
											if (rs.getString("role").equals("C01")) {
												articulo.setCompilador(rs.getInt("id_autor"), rs.getString("descripcion"));
											}
										}
										articulo.setIndice(rs.getInt("parte"), rs.getString("texto"));
										articulo.setSinopsis(rs.getInt("parteSinop"), rs.getString("textoSinop"));
										idArticuloAnt = articulo.getIdArticulo();
										i++;
									}
									if (i>0) {
										aux.add(articulo);
									}
								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getArticulosParaResultadoDeBusqueda(recorrido de rs), " +  e.toString());
//									TmkLogger.error(qry.toString());
								} finally {
									rs.close();
								}
							//long l= Calendar.getInstance().getTimeInMillis()-tiempoinicial;
							//System.out.println("tiempo total, busqueda + seteo"+l);
							break;
							}

						case Globals.SECCION_JUGUETES:{
							 qry.append(" SELECT   a.id_articulo, a.titulo, aut.id_autor, a.id_editor,");
							 qry.append(" nvl(aut.descripcion2, aut.descripcion) descripcion,");
							 qry.append(" 		ROUND (  precio_venta_vigente");
							 qry.append("                * (  1");
							 qry.append("                   + NVL (  (SELECT   NVL (tasa_general, 0)");
							 qry.append("                                    + NVL (tasa_adicional, 0)");
							 qry.append("                                     + NVL (tasa_percep_video, 0)");
							 qry.append("                              FROM tasas");
							 qry.append("                              WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                AND fecha_vigencia =");
							 qry.append("                                      (SELECT MAX (fecha_vigencia)");
							 qry.append("                                       FROM tasas");
							 qry.append("                                       WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                           AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                           AND fecha_vigencia <= SYSDATE))");
							 qry.append("                        / 100,");
							 qry.append("                          0");
							 qry.append("                         )");
							 qry.append("                  ),");
							 qry.append("                2");
							 qry.append("               ) precio,");
							 qry.append("         a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
							 qry.append("         cod_ext_visual isbn, ed.nombre editorial, pv.nombre proveedor,");
							 qry.append("         nvl(to_number(ate.parte), 1) parteSinop, ate.texto textoSinop, aa.orden");
							 qry.append("	,a.categoria_seccion");
							 qry.append("	,a.categoria_grupo");
							 qry.append("	,a.categoria_familia");
							 qry.append("	,a.categoria_subFamilia");
							 qry.append("  	FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
							 qry.append("	left join articulos_autores aa");
							 qry.append("	on a.id_articulo = aa.id_articulo and (aa.role  = 'A01' or aa.role='A09')");
							 qry.append("	left join autores aut");
							 qry.append("	on aa.id_autor = aut.id_autor");
							 qry.append("       LEFT JOIN proveedores pv ON a.id_proveedor = pv.id_proveedor");
							 qry.append("       LEFT JOIN articulos_textos ate on a.id_articulo = ate.id_articulo and ate.tipo = '01' and ate.idioma = 'ES'");
							 qry.append("   WHERE a.id_articulo IN (").append(idsArticulos);
							 qry.append(" 							)");
							 qry.append(" 	ORDER BY a.id_articulo, aa.orden");


							  ResultSet rs = st.executeQuery(qry.toString());
								try {
									int i = 0;
									articulo = new ArticuloClass(-1);
									while (rs.next()) {
										if (rs.getInt("id_articulo") != idArticuloAnt) {
											if (articulo.getIdArticulo() != -1) {
												aux.add(articulo);
											}
											articulo = new ArticuloClass(rs.getInt("id_articulo"));
											articulo.setTitulo(rs.getString("titulo"));
											articulo.setPrecio(rs.getDouble("precio"));
											articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
											articulo.setEsNovedad(rs.getDate("fecha_alta"));
											articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
											articulo.setEditorial(rs.getString("editorial"));
											articulo.setIdEditorial(rs.getInt("id_editor"));
											articulo.setISBN(rs.getString("ISBN"));
											articulo.setProveedor(rs.getString("proveedor"));
											CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
											articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
										}
										if (rs.getString("descripcion") != null) {
											articulo.setAutor(rs.getInt("id_autor"), rs.getString("descripcion"));
										}
										articulo.setSinopsis(rs.getInt("parteSinop"), rs.getString("textoSinop"));
										idArticuloAnt = articulo.getIdArticulo();
										i++;
									}
									if (i>0) {
										aux.add(articulo);
									}

								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getArticulosParaResultadoDeBusqueda(recorrido de rs), " +  e.toString());
									TmkLogger.error(qry.toString());
								} finally {
									rs.close();
								}
							break;
						}
						case Globals.SECCION_MUSICA:{

							 qry.append(" SELECT   a.id_articulo, a.titulo,");
							 qry.append(" 			ROUND (  precio_venta_vigente");
							 qry.append("                 * (  1");
							 qry.append("                    + NVL (  (SELECT   NVL (tasa_general, 0)");
							 qry.append("                                     + NVL (tasa_adicional, 0)");
							 qry.append("                                     + NVL (tasa_percep_video, 0)");
							 qry.append("                                FROM tasas");
							 qry.append("                               WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                 AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                 AND fecha_vigencia =");
							 qry.append("                                        (SELECT MAX (fecha_vigencia)");
							 qry.append("                                           FROM tasas");
							 qry.append("                                          WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                            AND fecha_vigencia <= SYSDATE))");
							 qry.append("                           / 100,");
							 qry.append("                           0");
							 qry.append("                          )");
							 qry.append("                   ),");
							 qry.append("                 2");
							 qry.append("                ) precio,");
							 qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
							 qry.append("          aut.id_autor idInterprete, nvl(aut.descripcion2, aut.descripcion) interprete, ed.nombre discografica,");
							 qry.append(" 		  nvl(atm.nro_tema, nvl(to_number(ate.parte), 1)) nroTema,");
							 qry.append(" 		  nvl(atm.nombre, replace(ate.texto, chr(10),'<br>')) nombreTema,");
							 qry.append(" 		  ta.descripcion formato, aa.orden");
							 qry.append("	,a.categoria_seccion");
							 qry.append("	,a.categoria_grupo");
							 qry.append("	,a.categoria_familia");
							 qry.append("	,a.categoria_subFamilia");
							 qry.append("     FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
							 qry.append("          LEFT JOIN articulos_autores aa");
							 qry.append("          ON a.id_articulo = aa.id_articulo AND aa.ROLE = 'A01'");
							 qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
							 qry.append("          LEFT JOIN articulos_textos ate");
							 qry.append("          ON a.id_articulo = ate.id_articulo AND ate.tipo = '01'");
							 qry.append("          LEFT JOIN articulos_temas_musicales atm");
							 qry.append("          ON a.id_articulo = atm.id_articulo");
							 qry.append("          LEFT JOIN tipos_articulos ta");
							 qry.append("          ON a.id_tipo_articulo = ta.id_tipo_articulo");
							 qry.append("    WHERE a.id_articulo IN (").append(idsArticulos).append(")");
							 qry.append(" ORDER BY a.id_articulo, nro_tema, ate.parte, aa.orden");


							 ResultSet rs = st.executeQuery(qry.toString());
								try {
									int i = 0;
									articulo = new ArticuloClass(-1);
									while (rs.next()) {
										if (rs.getInt("id_articulo") != idArticuloAnt) {
											if (articulo.getIdArticulo() != -1) {
												aux.add(articulo);
											}
											articulo = new ArticuloClass(rs.getInt("id_articulo"));
											articulo.setTitulo(rs.getString("titulo"));
											articulo.setPrecio(rs.getDouble("precio"));
											articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
											articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
											articulo.setEsNovedad(rs.getDate("fecha_alta"));
											articulo.setDiscografica(rs.getString("discografica"));
											articulo.setFormato(rs.getString("formato"));
											CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
											articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
										}
										articulo.setTemaMusical(rs.getInt("nroTema"), rs.getString("nombreTema"));
										if (rs.getString("interprete") != null) {
											articulo.setInterprete(rs.getInt("idInterprete"), rs.getString("interprete"));
										}
										idArticuloAnt = articulo.getIdArticulo();
										i++;
									}
									if (i>0) {
										aux.add(articulo);
									}

								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getArticulosParaResultadoDeBusqueda(recorrido de rs), " +  e.toString());
									TmkLogger.error(qry.toString());
								} finally {
									rs.close();
								}
							break;
						}
						case Globals.SECCION_PELICULA:{

							 qry.append(" SELECT   a.id_articulo, a.titulo,");
							 qry.append("          ROUND (  precio_venta_vigente");
							 qry.append("                 * (  1");
							 qry.append("                    + NVL (  (SELECT   NVL (tasa_general, 0)");
							 qry.append("                                     + NVL (tasa_adicional, 0)");
							 qry.append("                                     + NVL (tasa_percep_video, 0)");
							 qry.append("                                FROM tasas");
							 qry.append("                               WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                 AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                 AND fecha_vigencia =");
							 qry.append("                                        (SELECT MAX (fecha_vigencia)");
							 qry.append("                                           FROM tasas");
							 qry.append("                                         WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                            AND fecha_vigencia <= SYSDATE))");
							 qry.append("                           / 100,");
							 qry.append("                          0");
							 qry.append("                          )");
							 qry.append("                   ),");
							 qry.append("                2");
							 qry.append("                ) precio,");
							 qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
							 qry.append("          aut.id_autor iddirector, nvl(aut.descripcion2, aut.descripcion) director,");
							 qry.append("          ed.nombre productora, a.id_Editor idProductora, aut2.id_autor idprotagonista,");
							 qry.append("          aut2.descripcion protagonista,");
							 qry.append("          NVL (TO_NUMBER (ate.parte), 1) parteSinop, ate.texto textoSinop,");
							 qry.append("          ta.descripcion formato, aa.orden, aa2.orden");
							 qry.append("	,a.categoria_seccion");
							 qry.append("	,a.categoria_grupo");
							 qry.append("	,a.categoria_familia");
							 qry.append("	,a.categoria_subFamilia");
							 qry.append("     FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
							 qry.append("          LEFT JOIN articulos_autores aa");
							 qry.append("          ON a.id_articulo = aa.id_articulo and aa.ROLE = 'D02'");
							 qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
							 qry.append("          LEFT JOIN articulos_autores aa2");
							 qry.append("          ON a.id_articulo = aa2.id_articulo AND (aa2.ROLE = 'E01')");
							 qry.append("          LEFT JOIN autores aut2 ON aa2.id_autor = aut2.id_autor");
							 qry.append("          LEFT JOIN articulos_textos ate");
							 qry.append("          ON a.id_articulo = ate.id_articulo AND ate.tipo = '01'");
							 qry.append("          LEFT JOIN tipos_articulos ta ON a.id_tipo_articulo = ta.id_tipo_articulo");
							 qry.append("          INNER JOIN categ_grupos cg2 ON a.categoria_seccion = cg2.categoria_seccion");
							 qry.append("          AND a.categoria_grupo = cg2.categoria_grupo");
							 qry.append("    WHERE a.id_articulo IN (").append(idsArticulos).append(")");
							 qry.append(" ORDER BY a.id_articulo, partesinop, textosinop, aa.orden, aa2.orden ");



							 ResultSet rs = st.executeQuery(qry.toString());
								try {
									int i = 0;
									articulo = new ArticuloClass(-1);
									while (rs.next()) {
										if (rs.getInt("id_articulo") != idArticuloAnt) {
											if (articulo.getIdArticulo() != -1) {
												aux.add(articulo);
											}
											articulo = new ArticuloClass(rs.getInt("id_articulo"));
											articulo.setTitulo(rs.getString("titulo"));
											articulo.setPrecio(rs.getDouble("precio"));
											articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
											articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
											articulo.setEsNovedad(rs.getDate("fecha_alta"));
											articulo.setProductora(rs.getString("productora"));
											articulo.setIdProductora(rs.getInt("idProductora"));
											articulo.setFormato(rs.getString("formato"));
											CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
											articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
										}
										articulo.setSinopsis(rs.getInt("parteSinop"), rs.getString("textoSinop"));
										if (rs.getString("director") != null) {
											articulo.setDirector(rs.getInt("idDirector"), rs.getString("director"));
										}
										if (rs.getString("protagonista") != null) {
											articulo.setProtagonista(rs.getInt("idProtagonista"), rs.getString("protagonista"));
										}
										idArticuloAnt = articulo.getIdArticulo();
										i++;
									}
									if (i>0) {
										aux.add(articulo);
									}

								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getArticulosParaResultadoDeBusqueda(recorrido de rs), " +  e.toString());
									TmkLogger.error(qry.toString());
								} finally {
									rs.close();
								}
							break;
						}
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosParaResultadoDeBusqueda(ejecucion de qry), " + idsArticulos + " " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					st.close();
				}
				//TmkLogger.debug(qry);
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosParaResultadoDeBusqueda(creacion de statement), " + idsArticulos + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosParaResultadoDeBusqueda(conexion), " + idsArticulos + " " + e.toString());
		}

		for (int i=0; i<ids.length; i++) {
			for (int j=0; j<aux.size(); j++) {
				if (ids[i].trim().equals("" +((ArticuloClass)aux.get(j)).getIdArticulo())) {
					articulos.add((ArticuloClass)aux.get(j));
					break;
				}
			}
		}
		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}



	public static ArticuloClass[] getArticulosParaCatalogo (String idsArticulos, int idSeccion) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>(6);
		Vector<ArticuloClass> aux = new Vector<ArticuloClass>(6);
		String ids[] = idsArticulos.split(",");
		ArticuloClass articulo;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				int idArticuloAnt = 0; //para corte de control
				try {

					switch (idSeccion) {
						case Globals.SECCION_LIBRO:{
							  qry.append(" select a.id_articulo, a.titulo, aut.id_autor,");
							  qry.append(" nvl(aut.descripcion2, aut.descripcion) descripcion, a.id_editor,");
							  qry.append(" ROUND (precio_venta_vigente * ( 1");
							  qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
							  qry.append(" + NVL (tasa_adicional, 0)");
							  qry.append(" + NVL (tasa_percep_video, 0)");
							  qry.append(" FROM tasas");
							  qry.append(" WHERE id_impuesto = a.id_impuesto");
							  qry.append(" AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							  qry.append(" AND fecha_vigencia =");
							  qry.append(" 		(SELECT MAX (fecha_vigencia)");
							  qry.append("	FROM tasas");
							  qry.append("	WHERE id_impuesto = a.id_impuesto");
							  qry.append("	AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							  qry.append("	AND fecha_vigencia <= SYSDATE))");
							  qry.append("	/ 100,0)),2) precio, a.id_disponibilidad, a.habilitado_tematika,");
							  qry.append("	a.fecha_alta,");
							  qry.append("	cod_ext_visual isbn, ed.nombre editorial,");
							  qry.append("	decode(cg.rv_meaning, 'ESP-Book Book ¿ detail unspecified', '', 'ESP-Book Book – detail unspecified', '', 'ESP-Board book Child¿s book with all pages printed on board', '', rv_meaning) formato");
							  qry.append("  , aa.orden, aa.role ");
  							  qry.append("	,a.categoria_seccion");
							  qry.append("	,a.categoria_grupo");
							  qry.append("	,a.categoria_familia");
							  qry.append("	,a.categoria_subFamilia");
							  qry.append("  from articulos a");
							  qry.append("	left join articulos_autores aa");
							  qry.append("	on a.id_articulo = aa.id_articulo and aa.role in  ('A01', 'C01')");
							  qry.append("	left join autores aut");
							  qry.append("	on aa.id_autor = aut.id_autor");
							  qry.append("	left join editores ed");
							  qry.append("	on a.id_editor = ed.id_editor");
							  qry.append("	left join cg_ref_codes cg");
							  qry.append("  on a.auxvarchar03 = cg.rv_low_value and cg.rv_domain = 'ONIX:ProductForm'");
							  qry.append("  where a.id_articulo in (").append(idsArticulos).append(")");
							  qry.append("  order by a.id_articulo, aa.orden");

							  ResultSet rs = st.executeQuery(qry.toString());

								try {
									int i = 0;
									articulo = new ArticuloClass(-1);
									while (rs.next()) {
										if (rs.getInt("id_articulo") != idArticuloAnt) {
											if (articulo.getIdArticulo() != -1) {
												aux.add(articulo);
											}
											articulo = new ArticuloClass(rs.getInt("id_articulo"));

											articulo.setTitulo(rs.getString("titulo"));
											articulo.setPrecio(rs.getDouble("precio"));
											articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
											articulo.setEsNovedad(rs.getDate("fecha_alta"));
											articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
											articulo.setEditorial(rs.getString("editorial"));
											articulo.setIdEditorial(rs.getInt("id_editor"));
											articulo.setISBN(rs.getString("ISBN"));
											articulo.setFormato(rs.getString("formato"));
											CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
											articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
										}
										if (rs.getString("descripcion") != null) {
											if (rs.getString("role").equals("A01")) {
												articulo.setAutor(rs.getInt("id_autor"), rs.getString("descripcion"));
											}
											if (rs.getString("role").equals("C01")) {
												articulo.setCompilador(rs.getInt("id_autor"), rs.getString("descripcion"));
											}
										}
										idArticuloAnt = articulo.getIdArticulo();
										i++;
									}
									if (i>0) {
										aux.add(articulo);
									}
								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getArticulosParaCatalogo(recorrido de rs), " +  e.toString());
									TmkLogger.error(qry.toString());
								} finally {
									rs.close();
								}
							break;
							}

						case Globals.SECCION_JUGUETES:{
							 qry.append(" SELECT   a.id_articulo, a.categoria_seccion, a.titulo, aut.id_autor, a.id_editor,");
							 qry.append(" nvl(aut.descripcion2, aut.descripcion) descripcion,");
							 qry.append(" 		ROUND (  precio_venta_vigente");
							 qry.append("                * (  1");
							 qry.append("                   + NVL (  (SELECT   NVL (tasa_general, 0)");
							 qry.append("                                    + NVL (tasa_adicional, 0)");
							 qry.append("                                     + NVL (tasa_percep_video, 0)");
							 qry.append("                              FROM tasas");
							 qry.append("                              WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                AND fecha_vigencia =");
							 qry.append("                                      (SELECT MAX (fecha_vigencia)");
							 qry.append("                                       FROM tasas");
							 qry.append("                                       WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                           AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                           AND fecha_vigencia <= SYSDATE))");
							 qry.append("                        / 100,");
							 qry.append("                          0");
							 qry.append("                         )");
							 qry.append("                  ),");
							 qry.append("                2");
							 qry.append("               ) precio,");
							 qry.append("         a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
							 qry.append("         cod_ext_visual isbn, ed.nombre editorial, pv.nombre proveedor,");
							 qry.append("          aa.orden");
							 qry.append("	,a.categoria_seccion");
							 qry.append("	,a.categoria_grupo");
							 qry.append("	,a.categoria_familia");
							 qry.append("	,a.categoria_subFamilia");
							 qry.append("  	FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
							 qry.append("	left join articulos_autores aa");
							 qry.append("	on a.id_articulo = aa.id_articulo and (aa.role  = 'A01' or aa.role='A09')");
							 qry.append("	left join autores aut");
							 qry.append("	on aa.id_autor = aut.id_autor");
							 qry.append("       LEFT JOIN proveedores pv ON a.id_proveedor = pv.id_proveedor");
							 qry.append("   WHERE a.id_articulo IN (").append(idsArticulos);
							 qry.append(" 							)");
							 qry.append(" 	ORDER BY a.id_articulo, aa.orden");


							  ResultSet rs = st.executeQuery(qry.toString());
								try {
									int i = 0;
									articulo = new ArticuloClass(-1);
									while (rs.next()) {
										if (rs.getInt("id_articulo") != idArticuloAnt) {
											if (articulo.getIdArticulo() != -1) {
												aux.add(articulo);
											}

											articulo = new ArticuloClass(rs.getInt("id_articulo"));

											articulo.setTitulo(rs.getString("titulo"));
											articulo.setPrecio(rs.getDouble("precio"));
											articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
											articulo.setEsNovedad(rs.getDate("fecha_alta"));
											articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
											articulo.setEditorial(rs.getString("editorial"));
											articulo.setIdEditorial(rs.getInt("id_editor"));
											articulo.setISBN(rs.getString("ISBN"));
											articulo.setProveedor(rs.getString("proveedor"));
											CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
											articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
										}
										if (rs.getString("descripcion") != null) {
											articulo.setAutor(rs.getInt("id_autor"), rs.getString("descripcion"));
										}
										idArticuloAnt = articulo.getIdArticulo();
										i++;
									}
									if (i>0) {
										aux.add(articulo);
									}

								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getArticulosParaCatalogo(recorrido de rs), " +  e.toString());
									TmkLogger.error(qry.toString());
								} finally {
									rs.close();
								}
							break;
						}
						case Globals.SECCION_MUSICA:{

							 qry.append(" SELECT   a.id_articulo, a.categoria_seccion, a.titulo,");
							 qry.append(" 			ROUND (  precio_venta_vigente");
							 qry.append("                 * (  1");
							 qry.append("                    + NVL (  (SELECT   NVL (tasa_general, 0)");
							 qry.append("                                     + NVL (tasa_adicional, 0)");
							 qry.append("                                     + NVL (tasa_percep_video, 0)");
							 qry.append("                                FROM tasas");
							 qry.append("                               WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                 AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                 AND fecha_vigencia =");
							 qry.append("                                        (SELECT MAX (fecha_vigencia)");
							 qry.append("                                           FROM tasas");
							 qry.append("                                          WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                            AND fecha_vigencia <= SYSDATE))");
							 qry.append("                           / 100,");
							 qry.append("                           0");
							 qry.append("                          )");
							 qry.append("                   ),");
							 qry.append("                 2");
							 qry.append("                ) precio,");
							 qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
							 qry.append("          aut.id_autor idInterprete, nvl(aut.descripcion2, aut.descripcion) interprete, ed.nombre discografica,");
							 qry.append(" 		  ta.descripcion formato, aa.orden");
							 qry.append("	,a.categoria_seccion");
							 qry.append("	,a.categoria_grupo");
							 qry.append("	,a.categoria_familia");
							 qry.append("	,a.categoria_subFamilia");
							 qry.append("     FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
							 qry.append("          LEFT JOIN articulos_autores aa");
							 qry.append("          ON a.id_articulo = aa.id_articulo AND aa.ROLE = 'A01'");
							 qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
							 qry.append("          LEFT JOIN tipos_articulos ta");
							 qry.append("          ON a.id_tipo_articulo = ta.id_tipo_articulo");
							 qry.append("    WHERE a.id_articulo IN (").append(idsArticulos).append(")");
							 qry.append(" ORDER BY a.id_articulo, aa.orden");


							 ResultSet rs = st.executeQuery(qry.toString());
								try {
									int i = 0;
									articulo = new ArticuloClass(-1);
									while (rs.next()) {
										if (rs.getInt("id_articulo") != idArticuloAnt) {
											if (articulo.getIdArticulo() != -1) {
												aux.add(articulo);
											}
											articulo = new ArticuloClass(rs.getInt("id_articulo"));
											articulo.setTitulo(rs.getString("titulo"));
											articulo.setPrecio(rs.getDouble("precio"));
											articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
											articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
											articulo.setEsNovedad(rs.getDate("fecha_alta"));
											articulo.setDiscografica(rs.getString("discografica"));
											articulo.setFormato(rs.getString("formato"));
											CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
											articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
										}
										if (rs.getString("interprete") != null) {
											articulo.setInterprete(rs.getInt("idInterprete"), rs.getString("interprete"));
										}
										idArticuloAnt = articulo.getIdArticulo();
										i++;
									}
									if (i>0) {
										aux.add(articulo);
									}

								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getArticulosParaCatalogo(recorrido de rs), " +  e.toString());
									TmkLogger.error(qry.toString());
								} finally {
									rs.close();
								}
							break;
						}
						case Globals.SECCION_PELICULA:{

							 qry.append(" SELECT   a.id_articulo, a.categoria_seccion, a.titulo,");
							 qry.append("          ROUND (  precio_venta_vigente");
							 qry.append("                 * (  1");
							 qry.append("                    + NVL (  (SELECT   NVL (tasa_general, 0)");
							 qry.append("                                     + NVL (tasa_adicional, 0)");
							 qry.append("                                     + NVL (tasa_percep_video, 0)");
							 qry.append("                                FROM tasas");
							 qry.append("                               WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                 AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                 AND fecha_vigencia =");
							 qry.append("                                        (SELECT MAX (fecha_vigencia)");
							 qry.append("                                           FROM tasas");
							 qry.append("                                         WHERE id_impuesto = a.id_impuesto");
							 qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
							 qry.append("                                            AND fecha_vigencia <= SYSDATE))");
							 qry.append("                           / 100,");
							 qry.append("                          0");
							 qry.append("                          )");
							 qry.append("                   ),");
							 qry.append("                2");
							 qry.append("                ) precio,");
							 qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
							 qry.append("          aut.id_autor iddirector, nvl(aut.descripcion2, aut.descripcion) director,");
							 qry.append("          ed.nombre productora, a.id_Editor idProductora, aut2.id_autor idprotagonista,");
							 qry.append("          aut2.descripcion protagonista,");
							 qry.append("          ta.descripcion formato, aa.orden");
							 qry.append("	,a.categoria_seccion");
							 qry.append("	,a.categoria_grupo");
							 qry.append("	,a.categoria_familia");
							 qry.append("	,a.categoria_subFamilia");
							 qry.append("     FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
							 qry.append("          LEFT JOIN articulos_autores aa");
							 qry.append("          ON a.id_articulo = aa.id_articulo and aa.ROLE = 'D02'");
							 qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
							 qry.append("          LEFT JOIN articulos_autores aa2");
							 qry.append("          ON a.id_articulo = aa2.id_articulo AND (aa2.ROLE = 'E01')");
							 qry.append("          LEFT JOIN autores aut2 ON aa2.id_autor = aut2.id_autor");
							 qry.append("          LEFT JOIN tipos_articulos ta ON a.id_tipo_articulo = ta.id_tipo_articulo");
							 qry.append("    WHERE a.id_articulo IN (").append(idsArticulos).append(")");
							 qry.append(" ORDER BY a.id_articulo, aa.orden");



							 ResultSet rs = st.executeQuery(qry.toString());
								try {
									int i = 0;
									articulo = new ArticuloClass(-1);
									while (rs.next()) {
										if (rs.getInt("id_articulo") != idArticuloAnt) {
											if (articulo.getIdArticulo() != -1) {
												aux.add(articulo);
											}
											articulo = new ArticuloClass(rs.getInt("id_articulo"));
											articulo.setTitulo(rs.getString("titulo"));
											articulo.setPrecio(rs.getDouble("precio"));
											articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
											articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
											articulo.setEsNovedad(rs.getDate("fecha_alta"));
											articulo.setProductora(rs.getString("productora"));
											articulo.setIdProductora(rs.getInt("idProductora"));
											articulo.setFormato(rs.getString("formato"));
											CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
											articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
										}
										if (rs.getString("director") != null) {
											articulo.setDirector(rs.getInt("idDirector"), rs.getString("director"));
										}
										if (rs.getString("protagonista") != null) {
											articulo.setProtagonista(rs.getInt("idProtagonista"), rs.getString("protagonista"));
										}
										idArticuloAnt = articulo.getIdArticulo();
										i++;
									}
									if (i>0) {
										aux.add(articulo);
									}

								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getArticulosParaCatalogo(recorrido de rs), " +  e.toString());
									TmkLogger.error(qry.toString());
								} finally {
									rs.close();
								}
							break;
						}
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosParaCatalogo(ejecucion de qry), " + idsArticulos + " " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					st.close();
				}
				//TmkLogger.debug(qry);
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosParaCatalogo(creacion de statement), " + idsArticulos + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosParaCatalogo(conexion), " + idsArticulos + " " + e.toString());
		}

		for (int i=0; i<ids.length; i++) {
			for (int j=0; j<aux.size(); j++) {
				if (ids[i].trim().equals("" +((ArticuloClass)aux.get(j)).getIdArticulo())) {
					articulos.add((ArticuloClass)aux.get(j));
					break;
				}
			}
		}
		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}



	public static ArticuloClass getArticuloParaImagen (int idArticulo) {
		ArticuloClass articulo = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" Select id_articulo, categoria_seccion, fecha_alta");
					qry.append(" from articulos");
					qry.append(" where id_articulo =").append(idArticulo);

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							articulo = new ArticuloClass(rs.getInt("id_articulo"));
							CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion"))});
							articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
							articulo.setEsNovedad(rs.getDate("fecha_alta"));
							articulo.setPrecio(0);
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticuloParaImagen(recorrido de rs), " + idArticulo + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticuloParaImagen(ejecucion de qry), " + idArticulo + e.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticuloParaImagen(creacion de statement), " + idArticulo + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticuloParaImagen(conexion), " + idArticulo + e.toString());
		}

		return articulo;

	}


	public static ArticuloClass[] getArticulosParaUltimosVisitados (String idsArticulos) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>(10);
		Vector<ArticuloClass> aux = new Vector<ArticuloClass>(10);
		String ids[] = idsArticulos.split(",");
		ArticuloClass articulo;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				int idArticuloAnt = 0; // para corte de control

				qry.append("SELECT a.id_articulo, ");
				qry.append(" a.titulo, aut.id_autor,");
				qry.append(" nvl(aut.descripcion2, aut.descripcion) autor, aa.ROLE, ed.id_editor, ed.nombre editorial,");
				qry.append(" a.auxnumber03 id_marca, cr.rv_abbreviation marca,");
				qry.append(" cr.rv_domain dominio,");
				qry.append(" ROUND ( a.precio_venta_vigente");
				qry.append(" * (  1");
				qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
				qry.append(" + NVL (tasa_adicional, 0)");
				qry.append(" + NVL (tasa_percep_video, 0)");
				qry.append("                                FROM tasas");
				qry.append("                               WHERE id_impuesto = a.id_impuesto");
				qry.append("                                AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
				qry.append("                                          AND fecha_vigencia =");
				qry.append("                                        (SELECT MAX (fecha_vigencia)");
				qry.append("                                           FROM tasas");
				qry.append("                                          WHERE id_impuesto = a.id_impuesto");
				qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
				qry.append("                                            AND fecha_vigencia <= SYSDATE))");
				qry.append("                           / 100,");
				qry.append("                           0");
				qry.append("                          )");
				qry.append("                   ),");
				qry.append("                 2");
				qry.append("                ) precio,");
				qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta, aa.orden");
			    qry.append("	,a.categoria_seccion");
				qry.append("	,a.categoria_grupo");
				qry.append("	,a.categoria_familia");
				qry.append("	,a.categoria_subFamilia");
				qry.append("     FROM articulos a");
				qry.append("          LEFT JOIN articulos_autores aa");
				qry.append("          ON a.id_articulo = aa.id_articulo");
				qry.append("        AND (aa.ROLE = 'A01' OR aa.ROLE = 'D02' OR aa.ROLE = 'C01')");
				qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
				qry.append("          LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
				qry.append("          LEFT JOIN cg_ref_codes cr");
				qry.append("          ON a.auxnumber03 = cr.rv_low_value AND cr.rv_domain = 'MARCA'");
				qry.append("    WHERE a.id_articulo IN (").append(idsArticulos).append(")");
				qry.append(" ORDER BY a.id_articulo, aa.orden");
				PreparedStatement ps = conn.prepareStatement(qry.toString());
				try {
					ResultSet rs = ps.executeQuery();
					try {
						int i = 0;
						articulo = new ArticuloClass(-1);
						while (rs.next()) {
							if (rs.getInt("id_articulo") != idArticuloAnt) {
								if (articulo.getIdArticulo() != -1) {
									aux.add(articulo);
								}
								articulo = new ArticuloClass(rs.getInt("id_articulo"));
								CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
								articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));

								articulo.setTitulo(rs.getString("titulo"));
								if (rs.getInt("categoria_seccion") == Globals.SECCION_JUGUETES && rs.getString("editorial") != null) {
									articulo.setIdEditorial(rs.getInt("id_editor"));
									articulo.setEditorial(rs.getString("editorial"));
								}
								
								articulo.setPrecio(rs.getDouble("precio"));
								articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
								articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
								articulo.setEsNovedad(rs.getDate("fecha_alta"));
							}

							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_LIBRO) {
								if (rs.getString("ROLE").equals("A01")) {
									articulo.setAutor(rs.getInt("id_autor"), rs.getString("autor"));
								}
								if (rs.getString("ROLE").equals("C01")) {
									articulo.setCompilador(rs.getInt("id_autor"), rs.getString("autor"));
								}
							}

							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_MUSICA
									&& rs.getString("ROLE").equals("A01")) {
								articulo.setInterprete(rs.getInt("id_autor"), rs.getString("autor"));
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_PELICULA
									&& rs.getString("ROLE").equals("D02")) {
								articulo.setDirector(rs.getInt("id_autor"), rs.getString("autor"));
							}

							// articulo.setSinopsis(rs.getInt("parteSinop"),
							// rs.getString("textoSinop"));
							idArticuloAnt = articulo.getIdArticulo();
							i++;
						}
						if (i>0) {
							aux.add(articulo);
						}

					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosParaUltimosVisitados(recorrido de rs), " +  e.toString());
						TmkLogger.error(qry.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosParaUltimosVisitados(ejecucion de qry), " + idsArticulos + " " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosParaUltimosVisitados(creacion de statement), " + idsArticulos + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosParaUltimosVisitados(conexion), " + idsArticulos + " " + e.toString());
		}


		for (int i=0; i<ids.length; i++) {
			for (int j=0; j<aux.size(); j++) {
				if (ids[i].trim().equals("" +((ArticuloClass)aux.get(j)).getIdArticulo())) {
					articulos.add((ArticuloClass)aux.get(j));
					break;
				}
			}
		}
		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}


	public static ArticuloClass[] getArticulosParaTop (int idSeccion, int idGrupo, int idFamilia, int cantidadARetornar) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>(cantidadARetornar);
		String tblMVSeccion = " mas_vendidos_seccion mvs";
		String tblMVGrupo = " mas_vendidos_grupo mvs";
		String tblMVFamilia = " mas_vendidos_familia mvs";

		String tblMV = tblMVSeccion;

		String filMVSeccion = " categoria_seccion = ";
		String filMVGrupo = " and categoria_grupo = ";
		String filMVFamilia = " and categoria_familia = ";

		String filMV = filMVSeccion + idSeccion;

		if (idGrupo != -1) {
			tblMV = tblMVGrupo;
			filMV = filMV + filMVGrupo + idGrupo;
			if (idFamilia != -1) {
				tblMV = tblMVFamilia;
				filMV = filMV + filMVFamilia + idFamilia;
			}
		}

		ArticuloClass articulo;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				int idArticuloAnt = 0; // para corte de control
				try {
					qry.append("SELECT a.id_articulo, a.categoria_seccion, a.categoria_grupo, a.categoria_familia, a.categoria_subfamilia");
					qry.append(" , a.titulo, aut.id_autor,");
					qry.append(" nvl(aut.descripcion2, aut.descripcion) autor, aa.ROLE, ed.id_editor, ed.nombre editorial,");
					qry.append(" a.auxnumber03 id_marca, cr.rv_abbreviation marca,");
					qry.append(" cr.rv_domain dominio,");
					qry.append(" ROUND ( a.precio_venta_vigente");
					qry.append(" * (  1");
					qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append(" + NVL (tasa_adicional, 0)");
					qry.append(" + NVL (tasa_percep_video, 0)");
					qry.append("                                FROM tasas");
					qry.append("                               WHERE id_impuesto = a.id_impuesto");
					qry.append("                                AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                          AND fecha_vigencia =");
					qry.append("                                        (SELECT MAX (fecha_vigencia)");
					qry.append("                                           FROM tasas");
					qry.append("                                          WHERE id_impuesto = a.id_impuesto");
					qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                            AND fecha_vigencia <= SYSDATE))");
					qry.append("                           / 100,");
					qry.append("                           0");
					qry.append("                          )");
					qry.append("                   ),");
					qry.append("                 2");
					qry.append("                ) precio,");
					qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta, mvs.orden, aa.orden");
					qry.append("     FROM articulos a ");
					qry.append("          LEFT JOIN articulos_autores aa");
					qry.append("          ON a.id_articulo = aa.id_articulo");
					qry.append("        AND (aa.ROLE = 'A01' OR aa.ROLE = 'D02' OR aa.ROLE = 'C01')");
					qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
					qry.append("          LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
					qry.append("          LEFT JOIN cg_ref_codes cr");
					qry.append("          ON a.auxnumber03 = cr.rv_low_value AND cr.rv_domain = 'MARCA'");
					qry.append("   			inner join ").append(tblMV);
					qry.append("  		    on a.id_Articulo = mvs.id_articulo");
					qry.append("    WHERE a.id_articulo IN (");
					qry.append("    		select id_articulo from (");
					qry.append("    				select a.id_articulo, sel.orden from articulos a,");
					qry.append("				(select id_articulo, orden from (");
					qry.append("				select id_articulo, orden from ").append(tblMV);
					qry.append("				where ").append(filMV);
					qry.append("				order by orden)");
					qry.append("				where rownum <= 200");
					qry.append("				) sel,");
					qry.append("				disponibilidades d");
					qry.append("				where a.id_articulo = sel.id_Articulo");
					qry.append("				and a.id_disponibilidad = d.id_disponibilidad");
					qry.append("				and habilitado_tematika = 'S'");
					qry.append("				and d.pedido_especial = 'N'");
					qry.append("				and d.id_esquema = 'PROD'");
					qry.append("				order by orden)");
					qry.append("				where rownum <=").append(cantidadARetornar).append(")");
					qry.append(" ORDER BY mvs.orden").append(", aa.orden");
					//TmkLogger.debug(qry);
					ResultSet rs = st.executeQuery(qry.toString());

					try {
						int i = 0;
						articulo = new ArticuloClass(-1);
						while (rs.next()) {
							if (rs.getInt("id_articulo") != idArticuloAnt) {
								if (articulo.getIdArticulo() != -1) {
									articulos.add(articulo);
								}
								articulo = new ArticuloClass(rs.getInt("id_articulo"));
								CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")),
																				   new Integer(rs.getInt("categoria_grupo")),
																				   new Integer(rs.getInt("categoria_familia")),
																				   new Integer(rs.getInt("categoria_subfamilia"))});
								articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								articulo.setTitulo(rs.getString("titulo"));
								if (rs.getInt("categoria_seccion") == Globals.SECCION_JUGUETES && rs.getString("editorial") != null) {
									articulo.setIdEditorial(rs.getInt("id_editor"));
									articulo.setEditorial(rs.getString("editorial"));
								}
								
								articulo.setPrecio(rs.getDouble("precio"));
								articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
								articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
								articulo.setEsNovedad(rs.getDate("fecha_alta"));
							}

							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_LIBRO) {
								if (rs.getString("ROLE").equals("A01")) {
									articulo.setAutor(rs.getInt("id_autor"), rs.getString("autor"));
								}
								if (rs.getString("ROLE").equals("C01")) {
									articulo.setCompilador(rs.getInt("id_autor"), rs.getString("autor"));
								}
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_MUSICA
									&& rs.getString("ROLE").equals("A01")) {
								articulo.setInterprete(rs.getInt("id_autor"), rs.getString("autor"));
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_PELICULA
									&& rs.getString("ROLE").equals("D02")) {
								articulo.setDirector(rs.getInt("id_autor"), rs.getString("autor"));
							}

							// articulo.setSinopsis(rs.getInt("parteSinop"),
							// rs.getString("textoSinop"));
							idArticuloAnt = articulo.getIdArticulo();
							i++;
						}
						if (i>0) {
							articulos.add(articulo);
						}

					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosParaTop(recorrido de rs), " + idSeccion + " " + idGrupo + " " + idFamilia + " " + cantidadARetornar + " " + e.toString());
						TmkLogger.error(qry.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosParaTop(ejecucion de qry), " + idSeccion + " " + idGrupo + " " + idFamilia + " " + cantidadARetornar + " " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosParaTop(creacion de statement), " + idSeccion + " " + idGrupo + " " + idFamilia + " " + cantidadARetornar + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosParaTop(conexion), " +  idSeccion + " " + idGrupo + " " + idFamilia + " " + cantidadARetornar + " " + e.toString());
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);

	}

	/**
	 *
	 * Devuelve los articulos para ranking con el agregado de la sinopsis
	 *
	 * @param idSeccion
	 * @param idGrupo
	 * @param idFamilia
	 * @param cantidadARetornar
	 * @return
	 */
	public static ArticuloClass[] getArticulosParaTopExtend (int idSeccion, int idGrupo, int idFamilia, int cantidadARetornar) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>(cantidadARetornar);
		String tblMVSeccion = " mas_vendidos_seccion mvs";
		String tblMVGrupo = " mas_vendidos_grupo mvs";
		String tblMVFamilia = " mas_vendidos_familia mvs";

		String tblMV = tblMVSeccion;

		String filMVSeccion = " categoria_seccion = ";
		String filMVGrupo = " and categoria_grupo = ";
		String filMVFamilia = " and categoria_familia = ";

		String filMV = filMVSeccion + idSeccion;

		String leftAgregado="";
		String selAgregado="";
		String orderAgregado="";
	    if(idSeccion == Globals.SECCION_MUSICA){
	    	selAgregado = ", nvl(atm.nro_tema, 1) nroTema, atm.nombre nombreTema";
	    	leftAgregado = " LEFT JOIN articulos_temas_musicales atm ON a.id_articulo = atm.id_articulo ";
	    	orderAgregado=", id_articulo, nrotema";
	    }else{
	    	selAgregado = ", nvl(to_number(ate.parte), 1)parteSinop, ate.texto textoSinop";
	    	leftAgregado = " LEFT JOIN articulos_textos ate ON a.id_articulo = ate.id_articulo and ate.tipo = '01' and ate.idioma='ES' ";
	    	orderAgregado=", a.id_articulo, ate.parte";
	    }

		if (idGrupo != -1) {
			tblMV = tblMVGrupo;
			filMV = filMV + filMVGrupo + idGrupo;
			if (idFamilia != -1) {
				tblMV = tblMVFamilia;
				filMV = filMV + filMVFamilia + idFamilia;
			}
		}

		ArticuloClass articulo;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				int idArticuloAnt = 0; // para corte de control
				try {
					qry.append("SELECT a.id_articulo, a.categoria_seccion, categoria_grupo, categoria_familia, categoria_subfamilia");
					qry.append(" , a.titulo, aut.id_autor,");
					qry.append(" nvl(aut.descripcion2, aut.descripcion) autor, aa.ROLE, ed.id_editor, ed.nombre editorial,");
					qry.append(" a.auxnumber03 id_marca, cr.rv_abbreviation marca,");
					qry.append(" cr.rv_domain dominio,");
					qry.append(" ROUND ( a.precio_venta_vigente");
					qry.append(" * (  1");
					qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append(" + NVL (tasa_adicional, 0)");
					qry.append(" + NVL (tasa_percep_video, 0)");
					qry.append("                                FROM tasas");
					qry.append("                               WHERE id_impuesto = a.id_impuesto");
					qry.append("                                AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                          AND fecha_vigencia =");
					qry.append("                                        (SELECT MAX (fecha_vigencia)");
					qry.append("                                           FROM tasas");
					qry.append("                                          WHERE id_impuesto = a.id_impuesto");
					qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                            AND fecha_vigencia <= SYSDATE))");
					qry.append("                           / 100,");
					qry.append("                           0");
					qry.append("                          )");
					qry.append("                   ),");
					qry.append("                 2");
					qry.append("                ) precio,");
					qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta, mvs.orden, aa.orden").append(selAgregado);
					qry.append("     FROM articulos a ");
					qry.append("          LEFT JOIN articulos_autores aa");
					qry.append("          ON a.id_articulo = aa.id_articulo");
					qry.append("        AND (aa.ROLE = 'A01' OR aa.ROLE = 'D02' OR aa.ROLE = 'C01')");
					qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
					qry.append("          LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
					qry.append("          LEFT JOIN cg_ref_codes cr");
					qry.append("          ON a.auxnumber03 = cr.rv_low_value AND cr.rv_domain = 'MARCA'");
					qry.append("   			inner join ").append(tblMV);
					qry.append("  		    on a.id_Articulo = mvs.id_articulo").append(leftAgregado);
					qry.append("    WHERE a.id_articulo IN (");
					qry.append("    		select id_articulo from (");
					qry.append("    				select a.id_articulo, sel.orden from articulos a,");
					qry.append("				(select id_articulo, orden from (");
					qry.append("				select id_articulo, orden from ").append(tblMV);
					qry.append("				where ").append(filMV);
					qry.append("				order by orden)");
					qry.append("				where rownum <= 200");
					qry.append("				) sel,");
					qry.append("				disponibilidades d");
					qry.append("				where a.id_articulo = sel.id_Articulo");
					qry.append("				and a.id_disponibilidad = d.id_disponibilidad");
					qry.append("				and habilitado_tematika = 'S'");
					qry.append("				and d.pedido_especial = 'N'");
					qry.append("				and d.id_esquema = 'PROD'");
					qry.append("				order by orden)");
					qry.append("				where rownum <=").append(cantidadARetornar).append(")");
					qry.append(" ORDER BY mvs.orden").append(orderAgregado).append(", aa.orden");
					ResultSet rs = st.executeQuery(qry.toString());
					// TmkLogger.debug(qry);
					try {
						int i = 0;
						articulo = new ArticuloClass(-1);
						while (rs.next()) {
							if (rs.getInt("id_articulo") != idArticuloAnt) {
								if (articulo.getIdArticulo() != -1) {
									articulos.add(articulo);
								}
								articulo = new ArticuloClass(rs.getInt("id_articulo"));

								CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")),
										   new Integer(rs.getInt("categoria_grupo")),
										   new Integer(rs.getInt("categoria_familia")),
										   new Integer(rs.getInt("categoria_subfamilia"))});

								articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								articulo.setTitulo(rs.getString("titulo"));
								if (rs.getInt("categoria_seccion") == Globals.SECCION_JUGUETES && rs.getString("editorial") != null) {
									articulo.setIdEditorial(rs.getInt("id_editor"));
									articulo.setEditorial(rs.getString("editorial"));
								}
								
								articulo.setPrecio(rs.getDouble("precio"));
								articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
								articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
								articulo.setEsNovedad(rs.getDate("fecha_alta"));
							}

							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_LIBRO) {
								if (rs.getString("ROLE").equals("A01")) {
									articulo.setAutor(rs.getInt("id_autor"), rs.getString("autor"));
								}
								if (rs.getString("ROLE").equals("C01")) {
									articulo.setCompilador(rs.getInt("id_autor"), rs.getString("autor"));
								}
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_MUSICA
									&& rs.getString("ROLE").equals("A01")) {
								articulo.setInterprete(rs.getInt("id_autor"), rs.getString("autor"));
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_PELICULA
									&& rs.getString("ROLE").equals("D02")) {
								articulo.setDirector(rs.getInt("id_autor"), rs.getString("autor"));
							}

							if (rs.getInt("categoria_seccion") == Globals.SECCION_MUSICA){
								articulo.setTemaMusical(rs.getInt("nroTema"), rs.getString("nombreTema"));
							}else{
								articulo.setSinopsis(rs.getInt("parteSinop"), rs.getString("textoSinop"));
							}

							idArticuloAnt = articulo.getIdArticulo();
							i++;
						}
						if (i>0) {
							articulos.add(articulo);
						}

					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosParaTopExtend(recorrido de rs), " + idSeccion + " " + idGrupo + " " + idFamilia + " " + cantidadARetornar + " " + e.toString());
						TmkLogger.error(qry.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosParaTopExtend(ejecucion de qry), " + idSeccion + " " + idGrupo + " " + idFamilia + " " + cantidadARetornar + " " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosParaTopExtend(creacion de statement), " + idSeccion + " " + idGrupo + " " + idFamilia + " " + cantidadARetornar + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosParaTopExtend(conexion), " +  idSeccion + " " + idGrupo + " " + idFamilia + " " + cantidadARetornar + " " + e.toString());
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);

	}



	public static ArticuloClass[] getArticulosParaTopDeLibros (String idsArticulos) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>(10);
		Vector<ArticuloClass> aux = new Vector<ArticuloClass>(10);
		String ids[] = idsArticulos.split(",");
		ArticuloClass articulo;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				int idArticuloAnt = 0; // para corte de control
				try {
					qry.append("SELECT a.id_articulo, a.categoria_seccion, categoria_grupo, categoria_familia, categoria_subfamilia");
					qry.append(" , a.titulo, aut.id_autor,");
					qry.append(" nvl(aut.descripcion2, aut.descripcion) autor, aa.ROLE, ed.id_editor, ed.nombre editorial,");
					qry.append(" a.auxnumber03 id_marca, cr.rv_abbreviation marca,");
					qry.append(" cr.rv_domain dominio,");
					qry.append(" ROUND ( a.precio_venta_vigente");
					qry.append(" * (  1");
					qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append(" + NVL (tasa_adicional, 0)");
					qry.append(" + NVL (tasa_percep_video, 0)");
					qry.append("                                FROM tasas");
					qry.append("                               WHERE id_impuesto = a.id_impuesto");
					qry.append("                                AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                          AND fecha_vigencia =");
					qry.append("                                        (SELECT MAX (fecha_vigencia)");
					qry.append("                                           FROM tasas");
					qry.append("                                          WHERE id_impuesto = a.id_impuesto");
					qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                            AND fecha_vigencia <= SYSDATE))");
					qry.append("                           / 100,");
					qry.append("                           0");
					qry.append("                          )");
					qry.append("                   ),");
					qry.append("                 2");
					qry.append("                ) precio,");
					qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta, aa.orden");
					qry.append("     FROM articulos a ");
					qry.append("          LEFT JOIN articulos_autores aa");
					qry.append("          ON a.id_articulo = aa.id_articulo");
					qry.append("        AND (aa.ROLE = 'A01' OR aa.ROLE = 'D02' OR aa.ROLE = 'C01')");
					qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
					qry.append("          LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
					qry.append("          LEFT JOIN cg_ref_codes cr");
					qry.append("          ON a.auxnumber03 = cr.rv_low_value AND cr.rv_domain = 'MARCA'");
					qry.append("    WHERE a.id_articulo IN (").append(idsArticulos).append(")");
					qry.append(" ORDER BY a.id_articulo, aa.orden");
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						int i = 0;
						articulo = new ArticuloClass(-1);
						while (rs.next()) {
							if (rs.getInt("id_articulo") != idArticuloAnt) {
								if (articulo.getIdArticulo() != -1) {
									aux.add(articulo);
								}
								articulo = new ArticuloClass(rs.getInt("id_articulo"));
								CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")),
										   										   new Integer(rs.getInt("categoria_grupo")),
										   										   new Integer(rs.getInt("categoria_familia")),
										   										   new Integer(rs.getInt("categoria_subfamilia"))});

								articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								articulo.setTitulo(rs.getString("titulo"));
								if (rs.getInt("categoria_seccion") == Globals.SECCION_JUGUETES && rs.getString("editorial") != null) {
									articulo.setIdEditorial(rs.getInt("id_editorial"));
									articulo.setEditorial(rs.getString("editorial"));
								}
								
								articulo.setPrecio(rs.getDouble("precio"));
								articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
								articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
								articulo.setEsNovedad(rs.getDate("fecha_alta"));
							}

							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_LIBRO) {
								if (rs.getString("ROLE").equals("A01")) {
									articulo.setAutor(rs.getInt("id_autor"), rs.getString("autor"));
								}
								if (rs.getString("ROLE").equals("C01")) {
									articulo.setCompilador(rs.getInt("id_autor"), rs.getString("autor"));
								}
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_MUSICA
									&& rs.getString("ROLE").equals("A01")) {
								articulo.setInterprete(rs.getInt("id_autor"), rs.getString("autor"));
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_PELICULA
									&& rs.getString("ROLE").equals("D02")) {
								articulo.setDirector(rs.getInt("id_autor"), rs.getString("autor"));
							}
							idArticuloAnt = articulo.getIdArticulo();
							i++;
						}
						if (i>0) {
							aux.add(articulo);
						}

					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosParaTopDeLibros(recorrido de rs), " +  e.toString());
						TmkLogger.error(qry.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosParaTopDeLibros(ejecucion de qry), " + idsArticulos + " " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosParaTopDeLibros(creacion de statement), " + idsArticulos + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosParaTopDeLibros(conexion), " + idsArticulos + " " + e.toString());
		}


		for (int i=0; i<ids.length; i++) {
			for (int j=0; j<aux.size(); j++) {
				if (ids[i].trim().equals("" +((ArticuloClass)aux.get(j)).getIdArticulo())) {
					articulos.add((ArticuloClass)aux.get(j));
					break;
				}
			}
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}


	/**
	 * Devuelve los articulos para top de libros con el agregado de la sinopsis *
	 *
	 */

	public static ArticuloClass[] getArticulosParaTopDeLibrosExtend(String idsArticulos) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>(10);
		Vector<ArticuloClass> aux = new Vector<ArticuloClass>(10);
		String ids[] = idsArticulos.split(",");
		ArticuloClass articulo;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				int idArticuloAnt = 0; // para corte de control
				try {
					qry.append("SELECT a.id_articulo, a.categoria_seccion, categoria_grupo, categoria_familia, categoria_subfamilia");
					qry.append(" , a.titulo, aut.id_autor,");
					qry.append(" nvl(aut.descripcion2, aut.descripcion) autor, aa.ROLE, ed.id_editor, ed.nombre editorial,");
					qry.append(" a.auxnumber03 id_marca, cr.rv_abbreviation marca,");
					qry.append(" cr.rv_domain dominio,");
					qry.append(" ROUND ( a.precio_venta_vigente");
					qry.append(" * (  1");
					qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append(" + NVL (tasa_adicional, 0)");
					qry.append(" + NVL (tasa_percep_video, 0)");
					qry.append("                                FROM tasas");
					qry.append("                               WHERE id_impuesto = a.id_impuesto");
					qry.append("                                AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                          AND fecha_vigencia =");
					qry.append("                                        (SELECT MAX (fecha_vigencia)");
					qry.append("                                           FROM tasas");
					qry.append("                                          WHERE id_impuesto = a.id_impuesto");
					qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                            AND fecha_vigencia <= SYSDATE))");
					qry.append("                           / 100,");
					qry.append("                           0");
					qry.append("                          )");
					qry.append("                   ),");
					qry.append("                 2");
					qry.append("                ) precio,");
					qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta, ate.texto textoSinop, ate.parte parteSinop, aa.orden");
					qry.append("     FROM articulos a");
					qry.append("          LEFT JOIN articulos_autores aa");
					qry.append("          ON a.id_articulo = aa.id_articulo");
					qry.append("        AND (aa.ROLE = 'A01' OR aa.ROLE = 'D02' OR aa.ROLE = 'C01')");
					qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
					qry.append("          LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
					qry.append("          LEFT JOIN cg_ref_codes cr");
					qry.append("          ON a.auxnumber03 = cr.rv_low_value AND cr.rv_domain = 'MARCA'");
					qry.append("          LEFT JOIN articulos_textos ate ON a.id_articulo = ate.id_articulo ");
					qry.append("        AND ate.tipo = '01' and ate.idioma='ES'");
					qry.append("    WHERE a.id_articulo IN (").append(idsArticulos).append(")");
					qry.append(" ORDER BY a.id_articulo, ate.parte");
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						int i = 0;
						articulo = new ArticuloClass(-1);
						while (rs.next()) {
							if (rs.getInt("id_articulo") != idArticuloAnt) {
								if (articulo.getIdArticulo() != -1) {
									aux.add(articulo);
								}
								articulo = new ArticuloClass(rs.getInt("id_articulo"));
								CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")),
										   new Integer(rs.getInt("categoria_grupo")),
										   new Integer(rs.getInt("categoria_familia")),
										   new Integer(rs.getInt("categoria_subfamilia"))});
								articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								articulo.setTitulo(rs.getString("titulo"));
								if (rs.getInt("categoria_seccion") == Globals.SECCION_JUGUETES && rs.getString("editorial") != null) {
									articulo.setIdEditorial(rs.getInt("id_editorial"));
									articulo.setEditorial(rs.getString("editorial"));
								}
								
								articulo.setPrecio(rs.getDouble("precio"));
								articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
								articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
								articulo.setEsNovedad(rs.getDate("fecha_alta"));
							}

							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_LIBRO) {
								if (rs.getString("ROLE").equals("A01")) {
									articulo.setAutor(rs.getInt("id_autor"), rs.getString("autor"));
								}
								if (rs.getString("ROLE").equals("C01")) {
									articulo.setCompilador(rs.getInt("id_autor"), rs.getString("autor"));
								}
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_MUSICA
									&& rs.getString("ROLE").equals("A01")) {
								articulo.setInterprete(rs.getInt("id_autor"), rs.getString("autor"));
							}
							if (rs.getString("autor") != null && rs.getInt("categoria_seccion") == Globals.SECCION_PELICULA
									&& rs.getString("ROLE").equals("D02")) {
								articulo.setDirector(rs.getInt("id_autor"), rs.getString("autor"));
							}

							if (rs.getString("textoSinop") != null && rs.getInt("categoria_seccion") == Globals.SECCION_LIBRO){
								articulo.setSinopsis(rs.getInt("parteSinop"), rs.getString("textoSinop"));
							}

							idArticuloAnt = articulo.getIdArticulo();

							i++;
						}
						if (i>0) {
							aux.add(articulo);
						}

					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosParaTopDeLibrosExtend(recorrido de rs), " +  e.toString());
						TmkLogger.error(qry.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosParaTopDeLibrosExtend(ejecucion de qry), " + idsArticulos + " " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosParaTopDeLibrosExtend(creacion de statement), " + idsArticulos + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosParaTopDeLibrosExtend(conexion), " + idsArticulos + " " + e.toString());
		}


		for (int i=0; i<ids.length; i++) {
			for (int j=0; j<aux.size(); j++) {
				if (ids[i].trim().equals("" +((ArticuloClass)aux.get(j)).getIdArticulo())) {
					articulos.add((ArticuloClass)aux.get(j));
					break;
				}
			}
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}




	public static ArticuloClass getDetalleDeArticulo (int idArticulo, int idSeccion) {
		ArticuloClass articulo = new ArticuloClass(-1);
		try {
			Connection conn = DBUtil.buildConnection();
			//Statement st = conn.;
			try {
				StringBuffer qry = new StringBuffer();
				int idArticuloAnt = 0; //para corte de control
				switch (idSeccion) {
				case Globals.SECCION_LIBRO:{
					qry.append(" select a.id_articulo, a.titulo, aut.id_autor,");
					qry.append(" nvl(aut.descripcion2,aut.descripcion) descripcion,");
					qry.append(" ROUND (precio_venta_vigente * ( 1");
					qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append(" + NVL (tasa_adicional, 0)");
					qry.append(" + NVL (tasa_percep_video, 0)");
					qry.append(" FROM tasas");
					qry.append(" WHERE id_impuesto = a.id_impuesto");
					qry.append(" AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append(" AND fecha_vigencia =");
					qry.append(" 		(SELECT MAX (fecha_vigencia)");
					qry.append("	FROM tasas");
					qry.append("	WHERE id_impuesto = a.id_impuesto");
					qry.append("	AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("	AND fecha_vigencia <= SYSDATE))");
					qry.append("	/ 100,0)),2) precio, a.id_disponibilidad, a.habilitado_tematika,");
					qry.append("	cod_ext_visual isbn, ed.nombre editorial,");
					qry.append("	decode(cg.rv_meaning, 'ESP-Book Book ¿ detail unspecified', '', 'ESP-Book Book – detail unspecified', '', 'ESP-Board book Child¿s book with all pages printed on board', '', rv_meaning) formato");
					qry.append("  ,a.paginas, a.fecha_alta, a.idioma, ed.id_editor, a.peso");
					qry.append("  ,auxnumber05 alto, auxnumber06 ancho, auxnumber07 profundidad, aa.orden, aa.role");
					qry.append("	,a.categoria_seccion");
					qry.append("	,a.categoria_grupo");
					qry.append("	,a.categoria_familia");
					qry.append("	,a.categoria_subFamilia");
					qry.append("  from articulos a");
					qry.append("	left join articulos_autores aa");
					qry.append("	on a.id_articulo = aa.id_articulo and (aa.role  in ('A01', 'C01'))");
					qry.append("	left join autores aut");
					qry.append("	on aa.id_autor = aut.id_autor");
					qry.append("	left join editores ed");
					qry.append("	on a.id_editor = ed.id_editor");
					qry.append("	left join cg_ref_codes cg");
					qry.append("  on a.auxvarchar03 = cg.rv_low_value and cg.rv_domain = 'ONIX:ProductForm'");
					qry.append("  where a.id_articulo in (").append(idArticulo).append(")");
					qry.append("  order by aa.orden");
					PreparedStatement ps = conn.prepareStatement(qry.toString());
					try {
						ResultSet rs = ps.executeQuery();
						try {
							articulo = new ArticuloClass(-1);
							while (rs.next()) {
								if (rs.getInt("id_articulo") != idArticuloAnt) {
									articulo = new ArticuloClass(rs.getInt("id_articulo"));
									articulo.setTitulo(rs.getString("titulo"));
									articulo.setPrecio(rs.getDouble("precio"));
									articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
									articulo.setEsNovedad(rs.getDate("fecha_alta"));
									articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
									articulo.setEditorial(rs.getString("editorial"));
									articulo.setIdEditorial(rs.getInt("id_editor"));
									articulo.setISBN(rs.getString("ISBN"));
									articulo.setFormato(rs.getString("formato"));
									articulo.setPaginas(rs.getInt("paginas"));
									articulo.setFechaAlta(rs.getDate("fecha_alta"));
									articulo.setIdioma(rs.getString("idioma"));
									articulo.setPeso(rs.getInt("peso"));
									articulo.setMedidas(rs.getDouble("alto"), rs.getDouble("ancho"), rs.getDouble("profundidad"));
									CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
									articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								}
								if (rs.getString("descripcion") != null) {
									if (rs.getString("role").equals("A01")) {
										articulo.setAutor(rs.getInt("id_autor"), rs.getString("descripcion"));
									}
									if (rs.getString("role").equals("C01")) {
										articulo.setCompilador(rs.getInt("id_autor"), rs.getString("descripcion"));
									}
								}
								idArticuloAnt = articulo.getIdArticulo();
							}
						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getDetalleDeArticulo(recorrido de rs), " +  e.toString());
							TmkLogger.error(qry.toString());
						} finally {
							rs.close();
						}
					} finally {
						ps.close();
					}
					break;
				}
				case Globals.SECCION_JUGUETES:{
					qry.append(" SELECT   a.id_articulo, a.categoria_seccion, a.titulo, aut.id_autor, a.id_editor,");
					qry.append(" nvl(aut.descripcion2, aut.descripcion) descripcion,");
					qry.append(" 		ROUND (  precio_venta_vigente");
					qry.append("                * (  1");
					qry.append("                   + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append("                                    + NVL (tasa_adicional, 0)");
					qry.append("                                     + NVL (tasa_percep_video, 0)");
					qry.append("                              FROM tasas");
					qry.append("                              WHERE id_impuesto = a.id_impuesto");
					qry.append("                                AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                AND fecha_vigencia =");
					qry.append("                                      (SELECT MAX (fecha_vigencia)");
					qry.append("                                       FROM tasas");
					qry.append("                                       WHERE id_impuesto = a.id_impuesto");
					qry.append("                                           AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                           AND fecha_vigencia <= SYSDATE))");
					qry.append("                        / 100,");
					qry.append("                          0");
					qry.append("                         )");
					qry.append("                  ),");
					qry.append("                2");
					qry.append("               ) precio,");
					qry.append("         a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
					qry.append("         cod_ext_visual isbn, ed.nombre editorial, pv.nombre proveedor,");
					qry.append("          aa.orden");
					qry.append("	,a.categoria_seccion");
					qry.append("	,a.categoria_grupo");
					qry.append("	,a.categoria_familia");
					qry.append("	,a.categoria_subFamilia");
					qry.append("  	FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
					qry.append("	left join articulos_autores aa");
					qry.append("	on a.id_articulo = aa.id_articulo and (aa.role  = 'A01' or aa.role='A09')");
					qry.append("	left join autores aut");
					qry.append("	on aa.id_autor = aut.id_autor");
					qry.append("       LEFT JOIN proveedores pv ON a.id_proveedor = pv.id_proveedor");
					qry.append("   WHERE a.id_articulo IN (").append(idArticulo);
					qry.append(" 							)");
					qry.append(" 	ORDER BY aa.orden");
					PreparedStatement ps = conn.prepareStatement(qry.toString());
					try {
						ResultSet rs =  ps.executeQuery();
						try {
							articulo = new ArticuloClass(-1);
							while (rs.next()) {
								if (rs.getInt("id_articulo") != idArticuloAnt) {
									articulo = new ArticuloClass(rs.getInt("id_articulo"));
									articulo.setTitulo(rs.getString("titulo"));
									articulo.setPrecio(rs.getDouble("precio"));
									articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
									articulo.setEsNovedad(rs.getDate("fecha_alta"));
									articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
									articulo.setEditorial(rs.getString("editorial"));
									articulo.setIdEditorial(rs.getInt("id_editor"));
									articulo.setISBN(rs.getString("ISBN"));
									articulo.setProveedor(rs.getString("proveedor"));
									articulo.setFechaAlta(rs.getDate("fecha_alta"));
									CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
									articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								}
								if (rs.getString("descripcion") != null) {
									articulo.setAutor(rs.getInt("id_autor"), rs.getString("descripcion"));
								}
								idArticuloAnt = articulo.getIdArticulo();
							}
						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getDetalleDeArticulo(recorrido de rs), " +  e.toString());
							TmkLogger.error(qry.toString());
						} finally {
							rs.close();
						}
					} finally {
						ps.close();
					}
					break;
				}
				case Globals.SECCION_MUSICA:{
					qry.append(" SELECT   a.id_articulo, a.titulo,");
					qry.append(" 			ROUND (  precio_venta_vigente");
					qry.append("                 * (  1");
					qry.append("                    + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append("                                     + NVL (tasa_adicional, 0)");
					qry.append("                                     + NVL (tasa_percep_video, 0)");
					qry.append("                                FROM tasas");
					qry.append("                               WHERE id_impuesto = a.id_impuesto");
					qry.append("                                 AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                 AND fecha_vigencia =");
					qry.append("                                        (SELECT MAX (fecha_vigencia)");
					qry.append("                                           FROM tasas");
					qry.append("                                          WHERE id_impuesto = a.id_impuesto");
					qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                            AND fecha_vigencia <= SYSDATE))");
					qry.append("                           / 100,");
					qry.append("                           0");
					qry.append("                          )");
					qry.append("                   ),");
					qry.append("                 2");
					qry.append("                ) precio,");
					qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
					qry.append("          aut.id_autor idInterprete, nvl(aut.descripcion2, aut.descripcion) interprete, ed.nombre discografica,");
					qry.append(" 		  ta.descripcion formato, a.id_editor, aa.orden");
					qry.append("	,a.categoria_seccion");
					qry.append("	,a.categoria_grupo");
					qry.append("	,a.categoria_familia");
					qry.append("	,a.categoria_subFamilia");
					qry.append("     FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
					qry.append("          LEFT JOIN articulos_autores aa");
					qry.append("          ON a.id_articulo = aa.id_articulo AND aa.ROLE = 'A01'");
					qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
					qry.append("          LEFT JOIN tipos_articulos ta");
					qry.append("          ON a.id_tipo_articulo = ta.id_tipo_articulo");
					qry.append("    WHERE a.id_articulo IN (").append(idArticulo).append(")");
					qry.append("    ORDER BY aa.orden");

					PreparedStatement ps = conn.prepareStatement(qry.toString());
					try {
						ResultSet rs = ps.executeQuery();
						try {
							articulo = new ArticuloClass(-1);
							while (rs.next()) {
								if (rs.getInt("id_articulo") != idArticuloAnt) {
									articulo = new ArticuloClass(rs.getInt("id_articulo"));
									articulo.setTitulo(rs.getString("titulo"));
									articulo.setPrecio(rs.getDouble("precio"));
									articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
									articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
									articulo.setEsNovedad(rs.getDate("fecha_alta"));
									articulo.setDiscografica(rs.getString("discografica"));
									articulo.setFormato(rs.getString("formato"));
									articulo.setFechaAlta(rs.getDate("fecha_alta"));
									articulo.setIdEditorial(rs.getInt("id_editor"));
									CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
									articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								}
								if (rs.getString("interprete") != null) {
									articulo.setInterprete(rs.getInt("idInterprete"), rs.getString("interprete"));
								}
								idArticuloAnt = articulo.getIdArticulo();
							}
						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getDetalleDeArticulo(recorrido de rs), " +  e.toString());
							TmkLogger.error(qry.toString());
						} finally {
							rs.close();
						}
					} finally {
						ps.close();
					}
					break;
				}
				case Globals.SECCION_PELICULA:{
					qry.append(" SELECT   a.id_articulo, a.titulo,");
					qry.append("          ROUND (  precio_venta_vigente");
					qry.append("                 * (  1");
					qry.append("                    + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append("                                     + NVL (tasa_adicional, 0)");
					qry.append("                                     + NVL (tasa_percep_video, 0)");
					qry.append("                                FROM tasas");
					qry.append("                               WHERE id_impuesto = a.id_impuesto");
					qry.append("                                 AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                 AND fecha_vigencia =");
					qry.append("                                        (SELECT MAX (fecha_vigencia)");
					qry.append("                                           FROM tasas");
					qry.append("                                         WHERE id_impuesto = a.id_impuesto");
					qry.append("                                            AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("                                            AND fecha_vigencia <= SYSDATE))");
					qry.append("                           / 100,");
					qry.append("                          0");
					qry.append("                          )");
					qry.append("                   ),");
					qry.append("                2");
					qry.append("                ) precio,");
					qry.append("          a.id_disponibilidad, a.habilitado_tematika, a.fecha_alta,");
					qry.append("          aut.id_autor iddirector, nvl(aut.descripcion2, aut.descripcion) director,");
					qry.append("          ed.nombre productora, aut2.id_autor idprotagonista,");
					qry.append("          aut2.descripcion protagonista,");
					qry.append("          ta.descripcion formato, a.paginas, ed.id_editor, aa.orden");
					qry.append("	,a.categoria_seccion");
					qry.append("	,a.categoria_grupo");
					qry.append("	,a.categoria_familia");
					qry.append("	,a.categoria_subFamilia");
					qry.append("     FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
					qry.append("          LEFT JOIN articulos_autores aa");
					qry.append("          ON a.id_articulo = aa.id_articulo and aa.ROLE = 'D02'");
					qry.append("          LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
					qry.append("          LEFT JOIN articulos_autores aa2");
					qry.append("          ON a.id_articulo = aa2.id_articulo AND (aa2.ROLE = 'E01')");
					qry.append("          LEFT JOIN autores aut2 ON aa2.id_autor = aut2.id_autor");
					qry.append("          LEFT JOIN tipos_articulos ta ON a.id_tipo_articulo = ta.id_tipo_articulo");
					qry.append("    WHERE a.id_articulo IN (").append(idArticulo).append(")");
					qry.append("    ORDER BY aa.orden");
					PreparedStatement ps = conn.prepareStatement(qry.toString());
					try {
						ResultSet rs = ps.executeQuery();
						try {
							articulo = new ArticuloClass(-1);
							while (rs.next()) {
								if (rs.getInt("id_articulo") != idArticuloAnt) {
									articulo = new ArticuloClass(rs.getInt("id_articulo"));
									articulo.setTitulo(rs.getString("titulo"));
									articulo.setPrecio(rs.getDouble("precio"));
									articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
									articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
									articulo.setEsNovedad(rs.getDate("fecha_alta"));
									articulo.setProductora(rs.getString("productora"));
									articulo.setFormato(rs.getString("formato"));
									articulo.setFechaAlta(rs.getDate("fecha_alta"));
									articulo.setPaginas(rs.getInt("paginas"));
									articulo.setIdEditorial(rs.getInt("id_editor"));
									CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subFamilia"))});
									articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
								}
								if (rs.getString("director") != null) {
									articulo.setDirector(rs.getInt("idDirector"), rs.getString("director"));
								}
								if (rs.getString("protagonista") != null) {
									articulo.setProtagonista(rs.getInt("idProtagonista"), rs.getString("protagonista"));
								}
								idArticuloAnt = articulo.getIdArticulo();
							}
						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getDetalleDeArticulo(recorrido de rs), " +  e.toString());
							TmkLogger.error(qry.toString());
						} finally {
							rs.close();
						}
					} finally {
						ps.close();
					}
					break;
				}
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getDetalleDeArticulo(creacion de statement), " + idArticulo + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getDetalleDeArticulo(conexion), " + idArticulo + " " + e.toString());
		}
		return articulo;
	}

	/*
	 * Devuelve de la base, autores y articulos que tienen biografias
	 * */
	public static Vector getAutoresBiografiaBase (int idSeccion, String role) {

		Vector autores = new Vector();
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" SELECT aa.id_autor, nvl(aut.descripcion2, aut.descripcion) descripcion, a.id_articulo");
					qry.append(" FROM articulos_autores_biografia aab, ");
					qry.append(" articulos_autores aa, ");
					qry.append(" articulos a, ");
					qry.append(" autores aut ");
					qry.append(" WHERE aa.id_articulo = aab.id_articulo ");
					qry.append(" and aa.id_autor = aab.id_autor ");
					qry.append(" and aab.id_autor = aut.id_autor ");
					qry.append(" and a.id_articulo = aab.id_articulo ");
					qry.append(" and aa.role in (").append(role).append(") ");
					qry.append(" and a.categoria_seccion =").append(idSeccion);
					qry.append(" order by descripcion");

					ResultSet rs = st.executeQuery(qry.toString());

					try {
						String idAutorAnt = "";
						while (rs.next()) {
							if (!idAutorAnt.equals(rs.getString("id_autor"))) {
								String []autor = new String[3];
								autor[0] = rs.getString("id_autor");
								autor[1] = Convert.nombrePropio(rs.getString("descripcion"), false);
								autor[2] = rs.getString("id_articulo");
								autores.add(autor);
								//TmkLogger.debug(rs.getString("id_autor") + rs.getString("descripcion") + rs.getString("id_articulo"));
								//TmkLogger.debug(((String[])autores.get(autores.size()-1))[1]);
							}
							idAutorAnt = rs.getString("id_autor");
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getAutoresBiografiaBase(recorrido de rs), " + idSeccion + role+ e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getAutoresBiografiaBase(ejecucion de qry), " + idSeccion + role + e.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getAutoresBiografiaBase(creacion de statement), " + idSeccion + role + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getAutoresBiografiaBase(conexion), " + idSeccion + role + e.toString());
		}
		return autores;
	}

	/*
	 * Devuelve de la base, autores y articulos que tienen biografias
	 * *//*ARREGLAR PAGINANDO*/
	public static Vector getAutoresBiografiaArchivo(int idSeccion, String role, ServletContext servletContext) {

		Vector autores = new Vector();

		try {
			String pathDeArchivo = new StringBuffer(DIRECTORIO_BIOGRAFIAS).append("/").toString();
			File dir[] = new File(servletContext.getRealPath(pathDeArchivo)).listFiles();
			StringBuffer idsAutor;
			int listas = (int)Math.ceil((double)dir.length/1000);

			for (int j=0; j<listas; j++) {
				int inicio = j*1000;
				int tope = (j+1)*1000;
				idsAutor = new StringBuffer();

				for (int i=inicio; i<Math.min(dir.length, tope); i++) {
					idsAutor.append(dir[i].getName().toUpperCase().replaceAll(".TXT", ","));
					//TmkLogger.debug(i + " " +  dir[i].getName());
				}
				StringBuffer qry = new StringBuffer();
				if (idsAutor.length()>0) {
					idsAutor = new StringBuffer(idsAutor.substring(0, idsAutor.length()-1));
					try {
						Connection conn = DBUtil.buildConnection();
						try {
							Statement st = conn.createStatement();
							try {

								qry.append(" SELECT aut.id_autor, nvl(aut.descripcion2, aut.descripcion) descripcion, a.id_articulo");
								qry.append(" FROM articulos_autores aa,");
								qry.append(" autores aut,");
								qry.append(" articulos a");
								qry.append(" WHERE ");
								qry.append(" aa.id_autor = aut.id_autor");
								qry.append(" and aa.id_articulo = a.id_articulo");
								qry.append(" and role in (").append(role).append(")");
								qry.append(" and a.categoria_seccion = ").append(idSeccion);
								qry.append(" and aut.id_autor in (").append(idsAutor).append(")");
								qry.append(" order by descripcion");
								//TmkLogger.debug(qry.toString());
								ResultSet rs = st.executeQuery(qry.toString());

								try {
									String idAutorAnt = "";
									int contador =0;
									while (rs.next()) {
										if (!idAutorAnt.equals(rs.getString("id_autor"))) {
											String []autor = new String[3];
											autor[0] = rs.getString("id_autor");
											autor[1] = Convert.nombrePropio(rs.getString("descripcion"), false);
											autor[2] = rs.getString("id_articulo");
											autores.add(autor);
											//TmkLogger.debug(rs.getString("id_autor") + rs.getString("descripcion") + rs.getString("id_articulo"));
											//TmkLogger.debug(((String[])autores.get(contador))[1]);
											contador++;
										}
										idAutorAnt = rs.getString("id_autor");
									}
								} catch (Exception e) {
									TmkLogger.error("ArticuloManager: getAutoresBiografiaArchivo(recorrido de rs), " + idSeccion + role+ e.toString());
								} finally {
									rs.close();
								}
							} catch (Exception e) {
								TmkLogger.error("ArticuloManager: getAutoresBiografiaArchivo(ejecucion de qry), " + idSeccion + role + e.toString() + qry.toString());
							}  finally {
								st.close();
							}
						} catch (Exception e) {
							TmkLogger.error("ArticuloManager: getAutoresBiografiaArchivo(creacion de statement), " + idSeccion + role + e.toString());
						} finally {
							conn.close();
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getAutoresBiografiaArchivo(conexion), " + idSeccion + role + e.toString());
					}
				}
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getAutoresBiografiaArchivo(creacion de objeto file) " + idSeccion + role + e.toString());
		}
		return autores;
	}

	/*
	 * Devuelve autores y articulos que tienen biografias
	 * */
	public static void getAutoresBiografia(int idSeccion, String role, ServletContext servletContext){
		Vector autoresBase = getAutoresBiografiaBase(idSeccion, role);
		Vector autoresFile = getAutoresBiografiaArchivo(idSeccion, role, servletContext);
		Globals.mapaAutoresBiografia = new String[autoresBase.size() + autoresFile.size()][3];
		for (int i=0; i<autoresBase.size(); i++) {
			Globals.mapaAutoresBiografia[i][0] = ((String[])autoresBase.get(i))[0];
			Globals.mapaAutoresBiografia[i][1] = ((String[])autoresBase.get(i))[1];
			Globals.mapaAutoresBiografia[i][2] = ((String[])autoresBase.get(i))[2];
		}
		for (int i=0; i<autoresFile.size(); i++) {
			Globals.mapaAutoresBiografia[i + autoresBase.size()][0] = ((String[])autoresFile.get(i))[0];
			Globals.mapaAutoresBiografia[i + autoresBase.size()][1] = ((String[])autoresFile.get(i))[1];
			Globals.mapaAutoresBiografia[i + autoresBase.size()][2] = ((String[])autoresFile.get(i))[2];
			//TmkLogger.debug(autores[i][1]);
		}
		ordenarBiografia(Globals.mapaAutoresBiografia, 0, Globals.mapaAutoresBiografia.length-1);
	}


	public static void ordenarBiografia(String [][] d, int start, int end )
    {
		//TmkLogger.debug("usando algoritmo nuevo");
        String key[] = new String[3];
        int i, j;

        // j indexa el elemento que se va a insertar
        // i indexa las posibles posiciones en las que se podría insertar el elemento j
        for ( j = start + 1; j <= end; j++ )
        {
            key[0] = new String (d[ j ][0]);
            key[1] = new String (d[ j ][1]);
            key[2] = new String (d[ j ][2]);
            for ( i = j - 1; i >= 0 &&  key[1].compareTo( d[ i ][1] ) < 0; i-- ) {
                d[ i + 1 ][0] = d[ i ][0];
            	d[ i + 1 ][1] = d[ i ][1];
            	d[ i + 1 ][2] = d[ i ][2];
            }
            d[ i + 1][0] = new String(key[0]);
            d[ i + 1][1] = new String(key[1]);
            d[ i + 1][2] = new String(key[2]);
        }
    }

	public static ArticuloClass[] getArticulosByIds(String idsArticulos) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>();
		String ids[] = idsArticulos.split(",");
		Vector<ArticuloClass> aux = new Vector<ArticuloClass>();
		ArticuloClass articulo;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				try {
					qry.append(" SELECT a.id_articulo, a.titulo, d.id_disponibilidad, d.descripcion disponibilidad, a.categoria_seccion ");
					qry.append(" ,a.habilitado_tematika");
					qry.append(" FROM articulos a, disponibilidades d");
					qry.append(" WHERE a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND a.id_articulo IN (").append(idsArticulos).append(")");

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							articulo = new ArticuloClass(rs.getInt("id_articulo"));
							articulo.setTitulo(rs.getString("titulo"));
							articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
							articulo.setDisponibilidad(rs.getString("disponibilidad"));
							articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
							CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion"))});
							articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
							aux.add(articulo);
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosByIds(recorrido de rs), " +  e.toString());
						TmkLogger.error(qry.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosByIds(ejecucion de qry), " + idsArticulos + " " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosByIds(creacion de statement), " + idsArticulos + " " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosByIds(conexion), " + idsArticulos + " " + e.toString());
		}
		for (int i=0; i<ids.length; i++) {
			for (int j=0; j<aux.size(); j++) {
				if (ids[i].trim().equals("" +((ArticuloClass)aux.get(j)).getIdArticulo())) {
					articulos.add((ArticuloClass)aux.get(j));
					break;
				}
			}
		}

		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}


	public static ArticuloClass[] getArticulosByISBN(String ISBN) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>();
		ArticuloClass articulo;
		String ISBNs[] = ISBN.split(",");
		StringBuffer subQry = new StringBuffer();
		subQry.append("ai.isbn in(");
		for (int i=0; i<ISBNs.length; i++) {
			subQry.append("UPPER(REPLACE('").append(ISBNs[i].trim()).append("','-',''))").append(",");
		}
		subQry = new StringBuffer(subQry.substring(0, subQry.length()-1));
		subQry.append(")");
		subQry.append(" OR ai.isbn in (");
		for (int i=0; i<ISBNs.length; i++) {
			subQry.append("(SELECT '978'||SUBSTR(UPPER(REPLACE('").append(ISBNs[i]).append("', '-', '')),1,9)");
			subQry.append("	|| dv('978'||SUBSTR(UPPER(REPLACE('").append(ISBNs[i]).append("', '-', '')),1,9)) FROM dual)").append(",");
		}
		subQry = new StringBuffer(subQry.substring(0, subQry.length()-1));
		subQry.append(")");
		subQry.append(" OR ai.isbn in (");
		for (int i=0; i<ISBNs.length; i++) {
			subQry.append("(SELECT SUBSTR (REPLACE('").append(ISBNs[i]).append("', '-', ''),4,9) ");
			subQry.append(" || dv(SUBSTR(UPPER(REPLACE('").append(ISBNs[i]).append("', '-', '')),4,9)) FROM dual)").append(",");
		}
		subQry = new StringBuffer(subQry.substring(0, subQry.length()-1));
		subQry.append(")");

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT a.id_articulo, a.titulo, d.id_disponibilidad, d.descripcion disponibilidad, a.categoria_seccion ");
				qry.append(" ,a.habilitado_tematika");
				qry.append(" FROM articulos a, disponibilidades d");
				qry.append(" 	,articulos_isbn ai");
				qry.append(" WHERE a.id_articulo = ai.id_articulo");
				qry.append(" 	AND d.id_esquema = 'PROD'");
				qry.append(" 	AND a.id_disponibilidad = d.id_disponibilidad");
				qry.append(" 	AND	(").append(subQry).append(")");
				try {
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							articulo = new ArticuloClass(rs.getInt("id_articulo"));
							articulo.setTitulo(rs.getString("titulo"));
							articulo.setIdDisponibilidad(rs.getInt("id_disponibilidad"));
							articulo.setDisponibilidad(rs.getString("disponibilidad"));
							articulo.setHabilitadoTematika(rs.getString("habilitado_tematika"));
							CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion"))});
							articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
							articulos.add(articulo);
						}
					} catch (Exception e) {
						TmkLogger.error("ArticuloManager: getArticulosByISBN(recorrido de rs), " + ISBN + e.toString() + "QRY " + qry.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ArticuloManager: getArticulosByISBN(ejecucion de qry), " + ISBN + e.toString() + "QRY " + qry.toString());
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ArticuloManager: getArticulosByISBN(creacion de statement), " + ISBN + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticulosByISBN(conexion), " + ISBN + e.toString());
		}
		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}

	public static void setDisponibilidadYHabilitado (int idArticulo,
						int idDisponibilidad, String habilitadoTematika,
						Connection conn) throws Exception {
		CallableStatement setDisponibilidad = conn.prepareCall("{call SETDISPONIBILIDADARTICULO(?, ?, ?)}");
		try {
			int index = 0;
			setDisponibilidad.setInt(++index, idArticulo);
			setDisponibilidad.setInt(++index, idDisponibilidad);
			setDisponibilidad.setString(++index, habilitadoTematika);
			setDisponibilidad.execute();
		} finally {
			setDisponibilidad.close();
		}
	}

	public static Producto[] getArticulosEnCatalogo(Integer idSeccion, Integer idGrupo,
			Integer idFamilia, Integer idSubfamilia) throws Exception {
		Producto productos[] = null;
		if (idSeccion == null || idGrupo == null) {
			return productos;
		}
		RecorridoSecciones recorridoSecciones = Contenido.getSite().getRecorridoPorTemas().getRecorridoSecciones();

		if (recorridoSecciones != null) {
			for (int i=0; i<recorridoSecciones.getRecorridoSeccion().length && productos==null; i++) {
				if (idSeccion.intValue() == recorridoSecciones.getRecorridoSeccion()[i].getId()) {
					com.tmk.kernel.site.RecorridoGrupos recorridoGrupos = recorridoSecciones.getRecorridoSeccion()[i].getRecorridoGrupos();
					if (recorridoGrupos != null) {
						for (int j=0; j<recorridoGrupos.getRecorridoGrupo().length && productos==null; j++) {
							if (idGrupo.intValue() == recorridoGrupos.getRecorridoGrupo()[j].getId()) {
								if (idFamilia != null) {
									com.tmk.kernel.site.RecorridoFamilias recorridoFamilias = recorridoGrupos.getRecorridoGrupo()[j].getRecorridoFamilias();
									if (recorridoFamilias != null) {
										for (int k=0; k<recorridoFamilias.getRecorridoFamilia().length && productos==null; k++) {
											if (idFamilia.intValue() == recorridoFamilias.getRecorridoFamilia()[k].getId()) {
												if (recorridoFamilias.getRecorridoFamilia()[k].getClaves() != null) {
													if (recorridoFamilias.getRecorridoFamilia()[k].getClaves().getProducto() != null) {
														productos = recorridoFamilias.getRecorridoFamilia()[k].getClaves().getProducto();
													}
												}
											}
										}
									}
								} else {
									if (recorridoGrupos.getRecorridoGrupo()[j].getClaves() != null) {
										if (recorridoGrupos.getRecorridoGrupo()[j].getClaves().getProducto() != null) {
											productos = recorridoGrupos.getRecorridoGrupo()[j].getClaves().getProducto();
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return productos;
	}

	public static ArticuloClass[] getArticulosByIds(Producto[] producto) {
		StringBuffer articulos = new StringBuffer();
		if (producto != null) {
			for (int i=0; i<producto.length; i++) {
				articulos.append(producto[i].getId()).append(",");
			}
			if (articulos.length()>0) {
				articulos = new StringBuffer(articulos.substring(0, articulos.length()-1));
				ArticuloClass articulo[] = getArticulosByIds(articulos.toString());
				for (int i=0; i<articulo.length; i++) {
					if (producto[i].getVencimiento() != null) {
						articulo[i].setVencimiento(new Timestamp(producto[i].getVencimiento().getTime()));
					}
				}
				return articulo;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}


	public static Claves getClaveEnRecorridoCatalogo(Integer idSeccion, Integer idGrupo,
			Integer idFamilia, Integer idSubfamilia) throws Exception {
		Claves clave = null;
		if (idSeccion == null || idGrupo == null) {
			return clave;
		}

		RecorridoSecciones recorridoSecciones = Contenido.getSite().getRecorridoPorTemas().getRecorridoSecciones();

		if (recorridoSecciones != null) {
			for (int i=0; i<recorridoSecciones.getRecorridoSeccion().length && clave==null; i++) {

				RecorridoGrupos recorridoGrupos = recorridoSecciones.getRecorridoSeccion()[i].getRecorridoGrupos();
				if (recorridoGrupos != null) {
					for (int j=0; j<recorridoGrupos.getRecorridoGrupo().length && clave==null; j++) {
						if (idFamilia != null) {
							RecorridoFamilias recorridoFamilias = recorridoGrupos.getRecorridoGrupo()[j].getRecorridoFamilias();
							if (recorridoFamilias != null) {
								for (int k=0; k<recorridoFamilias.getRecorridoFamilia().length && clave==null; k++) {
									if (idSeccion.intValue() == recorridoSecciones.getRecorridoSeccion()[i].getId()
											&& idGrupo.intValue() == recorridoGrupos.getRecorridoGrupo()[j].getId()
											&& idFamilia.intValue() == recorridoFamilias.getRecorridoFamilia()[k].getId()) {
										clave = recorridoFamilias.getRecorridoFamilia()[k].getClaves();
									}
								}
							}
						} else {
							if (idSeccion.intValue() == recorridoSecciones.getRecorridoSeccion()[i].getId()
									&& idGrupo.intValue() == recorridoGrupos.getRecorridoGrupo()[j].getId()) {

								clave = recorridoGrupos.getRecorridoGrupo()[j].getClaves();
							}
						}
					}
				}
			}
		}
		return clave;
	}


	public static String getURL(ArticuloClass articulo) {
		StringBuffer link = new StringBuffer();
		link.append("/").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(articulo.getTitulo(), true)).toLowerCase())).append("--").append(articulo.getIdArticulo()).append(".htm");
		return link.toString();
	}

	public static String getURLAlianzaTag(ArticuloClass articulo) {
		StringBuffer link = new StringBuffer();
		link.append("/").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(articulo.getTitulo(), true)).toLowerCase())).append("--").append(articulo.getIdArticulo()).append("{ALIANZA}").append(".htm");
		return link.toString();
	}

	public static ArticuloClass[] getArticuloParaUrlRewrite(String idsArticulos) {
		Vector<ArticuloClass> articulos = new Vector<ArticuloClass>();
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT id_articulo, titulo, categoria_seccion, ");
		qry.append("		categoria_grupo, categoria_familia, categoria_subfamilia ");
		qry.append("   FROM articulos ");
		qry.append("  WHERE id_articulo in (").append(idsArticulos).append(")");
		try {
			Iterator it = MainHelper.getRs(qry.toString());
			Vector<ArticuloClass> aux = new Vector<ArticuloClass>();
			while (it.hasNext()) {
				DynaBean dyn = (DynaBean) it.next();
				ArticuloClass articulo = new ArticuloClass(new Integer(dyn.get("id_articulo").toString()).intValue());
				articulo.setTitulo(dyn.get("titulo").toString());
				CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(dyn.get("categoria_seccion").toString()),
																   new Integer(dyn.get("categoria_grupo").toString()),
																   new Integer(dyn.get("categoria_familia").toString()),
																   new Integer(dyn.get("categoria_subfamilia").toString())
																			   												});
				articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
				aux.add(articulo);
			}
			String ids[] = idsArticulos.split(",");

			for (int i=0; i<ids.length; i++) {
				for (int j=0; j<aux.size(); j++) {
					if (ids[i].trim().equals("" +((ArticuloClass)aux.get(j)).getIdArticulo())) {
						articulos.add((ArticuloClass)aux.get(j));
						break;
					}
				}
			}

		} catch (Exception e) {
			TmkLogger.error("ArticuloManager: getArticuloParaUrlRewrite(" + idsArticulos + ")" + MainHelper.getMessage(e) + e.toString());
		}
		return (ArticuloClass [])articulos.toArray(new ArticuloClass[articulos.size()]);
	}


	public static ArticuloClass[] getArticulosByCategoria(CategoriaPK categoriaPK, boolean demasNulas)  {
		StringBuffer qry = new StringBuffer("");
		qry.append(" SELECT a.id_articulo, a.titulo, ");
		qry.append(" 		a.categoria_seccion, a.categoria_grupo, a.categoria_familia, a.categoria_subfamilia");
		qry.append("   FROM articulos a");
		qry.append("  WHERE a.habilitado_tematika = 'S'");
		qry.append(" 		AND a.categoria_seccion=").append(categoriaPK.getPK()[0]);
		if (categoriaPK.getPK().length>1) {
			qry.append(" 		AND a.categoria_grupo=").append(categoriaPK.getPK()[1]);
			if (categoriaPK.getPK().length>2) {
				qry.append(" 		AND a.categoria_familia=").append(categoriaPK.getPK()[2]);
				if (categoriaPK.getPK().length>3) {
					qry.append(" 		AND a.categoria_subfamilia=").append(categoriaPK.getPK()[3]);
				} else {
					if (demasNulas) {
						qry.append(" 		AND a.categoria_familia =0");
					}
				}
			} else {
				if (demasNulas) {
					qry.append(" 		AND a.categoria_familia =0");
					qry.append(" 		AND a.categoria_subfamilia =0");
				}
			}
		} else {
			if (demasNulas) {
				qry.append(" 		AND a.categoria_grupo =0");
				qry.append(" 		AND a.categoria_familia =0");
				qry.append(" 		AND a.categoria_subfamilia =0");
			}
		}
		Vector<ArticuloClass> aux = new Vector<ArticuloClass>();
		try {
			Iterator it = MainHelper.getRs(qry.toString());

			while (it.hasNext()) {
				DynaBean dyn = (DynaBean) it.next();
				ArticuloClass articulo = new ArticuloClass(new Integer(dyn.get("id_articulo").toString()).intValue());
				articulo.setTitulo(dyn.get("id_articulo").toString());
				articulo.setCategoria(CategoriaService.getCategoriaEspecifica(categoriaPK));
				aux.add(articulo);
			}
		} catch (Exception e){
			TmkLogger.error("ArticuloManager.getArticulosByCategoria] " + e.toString() + e.getMessage());
		}
		return (ArticuloClass[])aux.toArray(new ArticuloClass[aux.size()]);
	}
/*

	public static void getTotalesArticulosParaMesa() {
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				//cantidad por categoria sin ordenamiento con filtro
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT categoria_seccion, count(a.id_articulo) cantidad");
				qry.append(" FROM articulos a ");
				qry.append(" WHERE a.habilitado_tematika = 'S' ");
				//qry.append(" AND a.archivo_imagen in ('C', 'T') ");
				qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append(" GROUP BY categoria_seccion ");
				try {
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						if (totalArticulos == null) {
							totalArticulos = new Vector(6);
							for (int i=0; i<6; i++) {
								totalArticulos.add(null);
							}
						}

						while (rs.next()) {
							totalArticulos.set(rs.getInt("categoria_seccion"), new Integer(rs.getInt("cantidad")));
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();
				///cantidad por categoria sin ordenamiento con filtro
				StringBuffer qryY = new StringBuffer();
				qryY.append(" SELECT categoria_seccion, count(a.id_articulo) cantidad");
				qryY.append(" FROM articulos a ");
				qryY.append(" WHERE a.habilitado_tematika = 'S' ");
				//qryY.append(" AND a.archivo_imagen in ('C', 'T') ");
				qryY.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryY.append(" AND fecha_alta < sysdate -15 and fecha_alta > sysdate -365 ");
				qryY.append(" GROUP BY categoria_seccion ");
				try {
					ResultSet rs = st.executeQuery(qryY.toString());
					try {
						if (totalArticulosY == null) {
							totalArticulosY = new Vector(6);
							for (int i=0; i<6; i++) {
								totalArticulosY.add(null);
							}
						}

						while (rs.next()) {
							totalArticulosY.set(rs.getInt("categoria_seccion"), new Integer(rs.getInt("cantidad")));
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();
				///cantidad por categoria sin ordenamiento con filtro
				StringBuffer qryM = new StringBuffer();
				qryM.append(" SELECT categoria_seccion, count(a.id_articulo) cantidad");
				qryM.append(" FROM articulos a ");
				qryM.append(" WHERE a.habilitado_tematika = 'S' ");
				//qryM.append(" AND a.archivo_imagen in ('C', 'T') ");
				qryM.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryM.append(" AND fecha_alta < sysdate -15 and fecha_alta > sysdate -45 ");
				qryM.append(" GROUP BY categoria_seccion ");
				try {
					ResultSet rs = st.executeQuery(qryM.toString());
					try {
						if (totalArticulosM == null) {
							totalArticulosM = new Vector(6);
							for (int i=0; i<6; i++) {
								totalArticulosM.add(null);
							}
						}

						while (rs.next()) {
							totalArticulosM.set(rs.getInt("categoria_seccion"), new Integer(rs.getInt("cantidad")));
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}
			} finally {
				conn.close();
			}
			totalArticulos.set (Globals.SECCION_LIBRO,(totalArticulos.get(Globals.SECCION_LIBRO)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_LIBRO));
			totalArticulos.set (Globals.SECCION_JUGUETES,(totalArticulos.get(Globals.SECCION_JUGUETES)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_JUGUETES));
			totalArticulos.set (Globals.SECCION_MUSICA,(totalArticulos.get(Globals.SECCION_MUSICA)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_MUSICA));
			totalArticulos.set (Globals.SECCION_PELICULA,(totalArticulos.get(Globals.SECCION_PELICULA)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_PELICULA));

			totalArticulosM.set (Globals.SECCION_LIBRO,(totalArticulosM.get(Globals.SECCION_LIBRO)==null)? new Integer(0):totalArticulosM.get(Globals.SECCION_LIBRO));
			totalArticulosM.set (Globals.SECCION_JUGUETES,(totalArticulosM.get(Globals.SECCION_JUGUETES)==null)? new Integer(0):totalArticulosM.get(Globals.SECCION_JUGUETES));
			totalArticulosM.set (Globals.SECCION_MUSICA,(totalArticulosM.get(Globals.SECCION_MUSICA)==null)? new Integer(0):totalArticulosM.get(Globals.SECCION_MUSICA));
			totalArticulosM.set (Globals.SECCION_PELICULA,(totalArticulosM.get(Globals.SECCION_PELICULA)==null)? new Integer(0):totalArticulosM.get(Globals.SECCION_PELICULA));

			totalArticulosY.set (Globals.SECCION_LIBRO,(totalArticulosY.get(Globals.SECCION_LIBRO)==null)? new Integer(0):totalArticulosY.get(Globals.SECCION_LIBRO));
			totalArticulosY.set (Globals.SECCION_JUGUETES,(totalArticulosY.get(Globals.SECCION_JUGUETES)==null)? new Integer(0):totalArticulosY.get(Globals.SECCION_JUGUETES));
			totalArticulosY.set (Globals.SECCION_MUSICA,(totalArticulosY.get(Globals.SECCION_MUSICA)==null)? new Integer(0):totalArticulosY.get(Globals.SECCION_MUSICA));
			totalArticulosY.set (Globals.SECCION_PELICULA,(totalArticulosY.get(Globals.SECCION_PELICULA)==null)? new Integer(0):totalArticulosY.get(Globals.SECCION_PELICULA));
			getArticulosParaMesa();
		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
		}
	}

	public static void getArticulosParaMesa() {
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qryMVM = new StringBuffer();
				qryMVM.append(" SELECT a.id_articulo , a.categoria_seccion");
				qryMVM.append(" FROM articulos a, mas_vendidos_seccion mvs ");
				qryMVM.append(" WHERE a.id_articulo = mvs.id_articulo(+) ");
				qryMVM.append(" AND a.categoria_seccion = mvs.categoria_seccion(+)");
				qryMVM.append(" AND a.habilitado_tematika = 'S'");
				//qryMVM.append(" AND a.archivo_imagen in ('C', 'T') ");
				qryMVM.append(" AND fecha_alta < sysdate -15 and fecha_alta > sysdate -45 ");
				qryMVM.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryMVM.append(" ORDER BY orden, a.fecha_alta desc");

				try {
					ResultSet rs = st.executeQuery(qryMVM.toString());
					try {
						articulosMVM[Globals.SECCION_LIBRO] = new int[((Integer)totalArticulosM.get(Globals.SECCION_LIBRO)).intValue()];
						articulosMVM[Globals.SECCION_JUGUETES] = new int[((Integer)totalArticulosM.get(Globals.SECCION_JUGUETES)).intValue()];
						articulosMVM[Globals.SECCION_MUSICA] = new int[((Integer)totalArticulosM.get(Globals.SECCION_MUSICA)).intValue()];
						articulosMVM[Globals.SECCION_PELICULA] = new int[((Integer)totalArticulosM.get(Globals.SECCION_PELICULA)).intValue()];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						while (rs.next()) {
							try {
								articulosMVM[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
								iterador[rs.getInt("categoria_seccion")]++;
							} catch (Exception e) {

							}
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();
				StringBuffer qryMVY = new StringBuffer();
				qryMVY.append(" SELECT a.id_articulo , a.categoria_seccion");
				qryMVY.append(" FROM articulos a, mas_vendidos_seccion mvs ");
				qryMVY.append(" WHERE a.id_articulo = mvs.id_articulo(+) ");
				qryMVY.append(" AND a.categoria_seccion = mvs.categoria_seccion(+)");
				qryMVY.append(" AND a.habilitado_tematika = 'S'");
				//qryMVY.append(" AND a.archivo_imagen in ('C', 'T') ");
				qryMVY.append(" AND fecha_alta < sysdate -15 and fecha_alta > sysdate -365 ");
				qryMVY.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryMVY.append(" ORDER BY orden, a.fecha_alta desc ");

				try {
					ResultSet rs = st.executeQuery(qryMVY.toString());
					try {
						articulosMVY[Globals.SECCION_LIBRO] = new int[((Integer)totalArticulosY.get(Globals.SECCION_LIBRO)).intValue()];
						articulosMVY[Globals.SECCION_JUGUETES] = new int[((Integer)totalArticulosY.get(Globals.SECCION_JUGUETES)).intValue()];
						articulosMVY[Globals.SECCION_MUSICA] = new int[((Integer)totalArticulosY.get(Globals.SECCION_MUSICA)).intValue()];
						articulosMVY[Globals.SECCION_PELICULA] = new int[((Integer)totalArticulosY.get(Globals.SECCION_PELICULA)).intValue()];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						while (rs.next()) {
							try {
								articulosMVY[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
								iterador[rs.getInt("categoria_seccion")]++;
							} catch (Exception e) {

							}
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();

				StringBuffer qryMVA = new StringBuffer();
				qryMVA.append(" SELECT a.categoria_seccion, a.id_articulo, decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)), count(ca.id_comentario), ");
				qryMVA.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34), a.fecha_alta");
				qryMVA.append(" FROM articulos a, comentario_articulos ca");
				qryMVA.append(" WHERE a.id_articulo = ca.id_articulo(+)");
				qryMVA.append(" AND ca.estado(+) = 'A'");
				qryMVA.append(" AND a.habilitado_tematika = 'S'");
				//qryMVA.append(" AND a.archivo_imagen in ('C', 'T')");
				qryMVA.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryMVA.append(" GROUP BY a.id_articulo, a.categoria_seccion,  a.fecha_alta");
				qryMVA.append(" ORDER BY");
				qryMVA.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34) desc,");
				qryMVA.append(" count(ca.id_comentario) desc,");
				qryMVA.append(" decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) desc, a.fecha_alta desc");

				try {
					ResultSet rs = st.executeQuery(qryMVA.toString());
					try {
						articulosMVA[Globals.SECCION_LIBRO] = new int[((Integer)totalArticulos.get(Globals.SECCION_LIBRO)).intValue()];
						articulosMVA[Globals.SECCION_JUGUETES] = new int[((Integer)totalArticulos.get(Globals.SECCION_JUGUETES)).intValue()];
						articulosMVA[Globals.SECCION_MUSICA] = new int[((Integer)totalArticulos.get(Globals.SECCION_MUSICA)).intValue()];
						articulosMVA[Globals.SECCION_PELICULA] = new int[((Integer)totalArticulos.get(Globals.SECCION_PELICULA)).intValue()];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						while (rs.next()) {
							try {
								articulosMVA[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
								iterador[rs.getInt("categoria_seccion")]++;
							} catch (Exception e) {

							}
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();
				StringBuffer qryMVAM = new StringBuffer();
				qryMVAM.append(" SELECT a.categoria_seccion, a.id_articulo, decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)), count(ca.id_comentario), ");
				qryMVAM.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34), a.fecha_alta");
				qryMVAM.append(" FROM articulos a, comentario_articulos ca");
				qryMVAM.append(" WHERE a.id_articulo = ca.id_articulo(+)");
				qryMVAM.append(" AND ca.estado(+) = 'A'");
				qryMVAM.append(" AND a.habilitado_tematika = 'S'");
				//qryMVAM.append(" AND a.archivo_imagen in ('C', 'T')");
				qryMVAM.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryMVAM.append(" AND fecha_alta < sysdate -15 and fecha_alta > sysdate -45");
				qryMVAM.append(" GROUP BY a.id_articulo, a.categoria_seccion,  a.fecha_alta");
				qryMVAM.append(" ORDER BY");
				qryMVAM.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34) desc,");
				qryMVAM.append(" count(ca.id_comentario) desc,");
				qryMVAM.append(" decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) desc, a.fecha_alta desc");


				try {
					ResultSet rs = st.executeQuery(qryMVM.toString());
					try {
						articulosMVAM[Globals.SECCION_LIBRO] = new int[((Integer)totalArticulosM.get(Globals.SECCION_LIBRO)).intValue()];
						articulosMVAM[Globals.SECCION_JUGUETES] = new int[((Integer)totalArticulosM.get(Globals.SECCION_JUGUETES)).intValue()];
						articulosMVAM[Globals.SECCION_MUSICA] = new int[((Integer)totalArticulosM.get(Globals.SECCION_MUSICA)).intValue()];
						articulosMVAM[Globals.SECCION_PELICULA] = new int[((Integer)totalArticulosM.get(Globals.SECCION_PELICULA)).intValue()];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						while (rs.next()) {
							try {
								articulosMVAM[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
								iterador[rs.getInt("categoria_seccion")]++;
							} catch (Exception e) {

							}
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();
				StringBuffer qryMVAY = new StringBuffer();
				qryMVAY.append(" SELECT a.categoria_seccion, a.id_articulo, decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)), count(ca.id_comentario), ");
				qryMVAY.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34), a.fecha_alta");
				qryMVAY.append(" FROM articulos a, comentario_articulos ca");
				qryMVAY.append(" WHERE a.id_articulo = ca.id_articulo(+)");
				qryMVAY.append(" AND ca.estado(+) = 'A'");
				qryMVAY.append(" AND a.habilitado_tematika = 'S'");
				//qryMVAY.append(" AND a.archivo_imagen in ('C', 'T')");
				qryMVAY.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryMVAY.append(" AND fecha_alta < sysdate -15 and fecha_alta > sysdate -365");
				qryMVAY.append(" GROUP BY a.id_articulo, a.categoria_seccion,  a.fecha_alta");
				qryMVAY.append(" ORDER BY");
				qryMVAY.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34) desc,");
				qryMVAY.append(" count(ca.id_comentario) desc,");
				qryMVAY.append(" decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) desc, a.fecha_alta desc");


				try {
					ResultSet rs = st.executeQuery(qryMVAY.toString());
					try {
						articulosMVAY[Globals.SECCION_LIBRO] = new int[((Integer)totalArticulosY.get(Globals.SECCION_LIBRO)).intValue()];
						articulosMVAY[Globals.SECCION_JUGUETES] = new int[((Integer)totalArticulosY.get(Globals.SECCION_JUGUETES)).intValue()];
						articulosMVAY[Globals.SECCION_MUSICA] = new int[((Integer)totalArticulosY.get(Globals.SECCION_MUSICA)).intValue()];
						articulosMVAY[Globals.SECCION_PELICULA] = new int[((Integer)totalArticulosY.get(Globals.SECCION_PELICULA)).intValue()];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						while (rs.next()) {
							try {
								articulosMVAY[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
								iterador[rs.getInt("categoria_seccion")]++;
							} catch (Exception e) {

							}
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();


				StringBuffer qryMP = new StringBuffer();
				qryMP.append(" SELECT a.categoria_seccion, a.id_articulo,  count(ca.id_comentario) ");
				qryMP.append(" FROM articulos a, comentario_articulos ca");
				qryMP.append(" WHERE a.id_articulo = ca.id_articulo(+)");
				qryMP.append(" AND ca.estado(+) = 'A'");
				qryMP.append(" AND a.habilitado_tematika = 'S'");
				//qryMP.append("  AND a.archivo_imagen in ('C', 'T')");
				qryMP.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryMP.append(" GROUP BY a.id_articulo, a.categoria_seccion,  a.fecha_alta");
				qryMP.append(" ORDER BY");
				qryMP.append(" count(ca.id_comentario) desc, a.fecha_alta desc");


				try {
					ResultSet rs = st.executeQuery(qryMP.toString());
					try {
						articulosMP[Globals.SECCION_LIBRO] = new int[((Integer)totalArticulos.get(Globals.SECCION_LIBRO)).intValue()];
						articulosMP[Globals.SECCION_JUGUETES] = new int[((Integer)totalArticulos.get(Globals.SECCION_JUGUETES)).intValue()];
						articulosMP[Globals.SECCION_MUSICA] = new int[((Integer)totalArticulos.get(Globals.SECCION_MUSICA)).intValue()];
						articulosMP[Globals.SECCION_PELICULA] = new int[((Integer)totalArticulos.get(Globals.SECCION_PELICULA)).intValue()];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						while (rs.next()) {
							try {
								articulosMP[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
								iterador[rs.getInt("categoria_seccion")]++;
							} catch (Exception e) {

							}
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();
				StringBuffer qryMPM = new StringBuffer();
				qryMPM.append(" SELECT a.categoria_seccion, a.id_articulo,  count(ca.id_comentario) ");
				qryMPM.append(" FROM articulos a, comentario_articulos ca");
				qryMPM.append(" WHERE a.id_articulo = ca.id_articulo(+)");
				qryMPM.append(" AND ca.estado(+) = 'A'");
				qryMPM.append(" AND a.habilitado_tematika = 'S'");
				//qryMPM.append("  AND a.archivo_imagen in ('C', 'T')");
				qryMPM.append(" AND fecha_alta < sysdate -15 and fecha_alta > sysdate -45 ");
				qryMPM.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryMPM.append(" GROUP BY a.id_articulo, a.categoria_seccion,  a.fecha_alta");
				qryMPM.append(" ORDER BY");
				qryMPM.append(" count(ca.id_comentario) desc, a.fecha_alta desc");

				try {
					ResultSet rs = st.executeQuery(qryMPM.toString());
					try {
						articulosMPM[Globals.SECCION_LIBRO] = new int[((Integer)totalArticulosM.get(Globals.SECCION_LIBRO)).intValue()];
						articulosMPM[Globals.SECCION_JUGUETES] = new int[((Integer)totalArticulosM.get(Globals.SECCION_JUGUETES)).intValue()];
						articulosMPM[Globals.SECCION_MUSICA] = new int[((Integer)totalArticulosM.get(Globals.SECCION_MUSICA)).intValue()];
						articulosMPM[Globals.SECCION_PELICULA] = new int[((Integer)totalArticulosM.get(Globals.SECCION_PELICULA)).intValue()];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						while (rs.next()) {
							try {
								articulosMPM[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
								iterador[rs.getInt("categoria_seccion")]++;
							} catch (Exception e) {

							}
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}

				st = conn.createStatement();
				StringBuffer qryMPY = new StringBuffer();
				qryMPY.append(" SELECT a.categoria_seccion, a.id_articulo,  count(ca.id_comentario) ");
				qryMPY.append(" FROM articulos a, comentario_articulos ca");
				qryMPY.append(" WHERE a.id_articulo = ca.id_articulo(+)");
				qryMPY.append(" AND ca.estado(+) = 'A'");
				qryMPY.append(" AND a.habilitado_tematika = 'S'");
				//qryMPY.append("  AND a.archivo_imagen in ('C', 'T')");
				qryMPY.append(" AND fecha_alta < sysdate -15 and fecha_alta > sysdate -365 ");
				qryMPY.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qryMPY.append(" GROUP BY a.id_articulo, a.categoria_seccion,  a.fecha_alta");
				qryMPY.append(" ORDER BY");
				qryMPY.append(" count(ca.id_comentario) desc, a.fecha_alta desc");


				try {
					ResultSet rs = st.executeQuery(qryMPY.toString());
					try {
						articulosMPY[Globals.SECCION_LIBRO] = new int[((Integer)totalArticulosY.get(Globals.SECCION_LIBRO)).intValue()];
						articulosMPY[Globals.SECCION_JUGUETES] = new int[((Integer)totalArticulosY.get(Globals.SECCION_JUGUETES)).intValue()];
						articulosMPY[Globals.SECCION_MUSICA] = new int[((Integer)totalArticulosY.get(Globals.SECCION_MUSICA)).intValue()];
						articulosMPY[Globals.SECCION_PELICULA] = new int[((Integer)totalArticulosY.get(Globals.SECCION_PELICULA)).intValue()];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						while (rs.next()) {
							try {
								articulosMPY[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
								iterador[rs.getInt("categoria_seccion")]++;
							} catch (Exception e) {

							}
						}
					} finally {
						rs.close();
					}
				} finally  {
					st.close();
				}


				//Globals.MesaInteractivaHomeLoaded = true;

			} finally {
				conn.close();
			}

		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
		}
	}*/
}



