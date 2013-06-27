package com.tmk.generacion.articulo;


//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileReader;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
//import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
//import java.util.StringTokenizer;
import java.util.Vector;

//import org.eclipse.swt.layout.GridLayout;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.articulo.Articulo;
//import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.categoria.Categoria;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.controllers.MainHelper;
import com.tmk.generacion.ContenidosEstaticos;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.MultiField;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.categoria.CategoriaService;
import com.tmk.setup.Contenido;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.util.HTML.Template;


public class GeneradorDeArticulo {
	//tamaño de vista
	public static final int MESA_TAM_VIEW[] = {0, 4, 0, 4, 6, 4};
	public static final int MESA_TAM_VIEW_SECCION[] = {0, 12, 0, 12, 18, 12};
	//tamaño de pagina
	public static final int MESA_CH_PAGINA = 10;
	//filtros
	public static final String MESA_FILTRO_TOTAL = "T";
	public static final String MESA_FILTRO_AÑO = "Y";
	public static final String MESA_FILTRO_MES = "M";
	
	//ordenamientos
	public static final String MESA_ORDEN_MV = "MV";
	public static final String MESA_ORDEN_MP = "MP";
	public static final String MESA_ORDEN_MVA = "MVA";
	
	//ordenamiento Tematika recomienda(drop izquierda)
	public static final String MESA_ORDEN_TMK_RDA = "TMK_RDA";
	
	//Filtros SQL
	public static final String MESA_FILTRO_TOTAL_SQL = " AND fecha_alta < sysdate -15 ";
	public static final String MESA_FILTRO_AÑO_SQL = " AND fecha_alta < sysdate -15 AND fecha_alta > sysdate -365 ";
	public static final String MESA_FILTRO_MES_SQL = " AND fecha_alta < sysdate -15 AND fecha_alta > sysdate -105 ";
	
	//Filtros SQL tematika recomienda	
	public static final String TMKRDA_MESA_FILTRO_MES_SQL = " en_filtro = 'UTM'";//altimo tres meses
	public static final String TMKRDA_MESA_FILTRO_AÑO_SQL = " en_filtro = 'UA' ";//ultimo año
	
	//TIENE EN CUENTA IMAGEN
	public static final String TIENE_EN_CUENTA_IMAGEN =" AND a.archivo_imagen in ('C', 'T') ";

	//Control de la cantidad de Links generados para SEO
	private static int maxLen = 10;
	
	public static void generarMesa() throws Exception {
		try {
			MesaFiltroOrdenWrapper mesaFiltroOrdenWrapper = new MesaFiltroOrdenWrapper();
			
			mesaFiltroOrdenWrapper.M_MV = generarTotalMesa(MESA_ORDEN_MV, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL);
			generarListaMesa(MESA_ORDEN_MV, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL);
			mesaFiltroOrdenWrapper.Y_MV = generarTotalMesa(MESA_ORDEN_MV, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL);
			generarListaMesa(MESA_ORDEN_MV, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL);

			mesaFiltroOrdenWrapper.M_MVA = generarTotalMesa(MESA_ORDEN_MVA, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL);
			generarListaMesa(MESA_ORDEN_MVA, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL);
			mesaFiltroOrdenWrapper.Y_MVA = generarTotalMesa(MESA_ORDEN_MVA, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL);
			generarListaMesa(MESA_ORDEN_MVA, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL);
			mesaFiltroOrdenWrapper.T_MVA = generarTotalMesa(MESA_ORDEN_MVA, MESA_FILTRO_TOTAL, MESA_FILTRO_TOTAL_SQL);
			generarListaMesa(MESA_ORDEN_MVA, MESA_FILTRO_TOTAL, MESA_FILTRO_TOTAL_SQL);

			mesaFiltroOrdenWrapper.M_MP = generarTotalMesa(MESA_ORDEN_MP, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL);
			generarListaMesa(MESA_ORDEN_MP, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL);
			mesaFiltroOrdenWrapper.Y_MP = generarTotalMesa(MESA_ORDEN_MP, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL);
			generarListaMesa(MESA_ORDEN_MP, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL);
			mesaFiltroOrdenWrapper.T_MP = generarTotalMesa(MESA_ORDEN_MP, MESA_FILTRO_TOTAL, MESA_FILTRO_TOTAL_SQL);
			generarListaMesa(MESA_ORDEN_MP, MESA_FILTRO_TOTAL, MESA_FILTRO_TOTAL_SQL);
						
			
			mesaFiltroOrdenWrapper.M_TMK_RDA = generarTotalMesa(MESA_ORDEN_TMK_RDA, MESA_FILTRO_MES, TMKRDA_MESA_FILTRO_MES_SQL);
			generarListaMesa(MESA_ORDEN_TMK_RDA, MESA_FILTRO_MES, TMKRDA_MESA_FILTRO_MES_SQL);
			mesaFiltroOrdenWrapper.Y_TMK_RDA = generarTotalMesa(MESA_ORDEN_TMK_RDA, MESA_FILTRO_AÑO, TMKRDA_MESA_FILTRO_AÑO_SQL);
			generarListaMesa(MESA_ORDEN_TMK_RDA, MESA_FILTRO_AÑO, TMKRDA_MESA_FILTRO_AÑO_SQL);
			
			
			try{
				String fileName = "/articulos/mesa/filtroOrden.html";
				String json = filtroOrdenToJSON(mesaFiltroOrdenWrapper);
				MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
			}catch(Exception e){
				TmkLogger.error(e.toString() + MainHelper.getMessage(e));
			}
			
			/*MESA DEL HOME*/

			/*TODAS LAS CATEGORIAS*/
			generarMesaXCategoria(CategoriaService.categoria);
			/*TODAS LAS CATEGORIAS*/
		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
			throw e;
		}

	}

	@SuppressWarnings("unchecked")
	private static boolean generarTotalMesa(String orden, String filtro, String filtroSQL) {

		try {
			Connection conn = DBUtil.buildConnection();
			try {

				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				if (orden.equals(MESA_ORDEN_MV)) {
					qry.append(" SELECT categoria_seccion, count(distinct a.id_articulo) cantidad");
					qry.append(" FROM articulos a , disponibilidades d");
					qry.append(" WHERE a.habilitado_tematika = 'S' ");
					qry.append("	AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append("	AND d.pedido_especial = 'N'");
					qry.append("	AND d.id_esquema = 'PROD'");
					qry.append(" 	AND a.activo = 'SI' ");
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(filtroSQL);
					qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(" GROUP BY categoria_seccion ");
				}
				if (orden.equals(MESA_ORDEN_MVA) || orden.equals(MESA_ORDEN_MP)) {
					qry.append(" SELECT categoria_seccion, count(distinct a.id_articulo) cantidad ");
					qry.append(" FROM articulos a, comentario_articulos ca, disponibilidades d");
					qry.append(" WHERE a.id_articulo = ca.id_articulo");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND ca.estado = 'A'");
					qry.append(" AND a.habilitado_tematika = 'S'");
					qry.append(" AND a.activo = 'SI' ");
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(filtroSQL);
					qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(" GROUP BY a.categoria_seccion");
				}
				//para los articulos recomendados
				if (orden.equals(MESA_ORDEN_TMK_RDA)) {
					qry.append(" SELECT categoria_seccion,count(distinct a.id_articulo) cantidad ");
					qry.append(" FROM articulos_mesa_recomendados a");
					qry.append(" WHERE ");
					qry.append(filtroSQL);
					qry.append(" and a.se_muestra = 1");
					qry.append(" GROUP BY a.categoria_seccion");
				}

				try {
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						Vector totalArticulos = null;
						if (totalArticulos == null) {
							totalArticulos = new Vector(6);
							for (int i=0; i<6; i++) {
								totalArticulos.add(null);
							}
						}
						while (rs.next()) {
							totalArticulos.set(rs.getInt("categoria_seccion"), new Integer(rs.getInt("cantidad")));
						}
						totalArticulos.set (Globals.SECCION_LIBRO,(totalArticulos.get(Globals.SECCION_LIBRO)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_LIBRO));
						totalArticulos.set (Globals.SECCION_JUGUETES,(totalArticulos.get(Globals.SECCION_JUGUETES)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_JUGUETES));
						totalArticulos.set (Globals.SECCION_MUSICA,(totalArticulos.get(Globals.SECCION_MUSICA)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_MUSICA));
						totalArticulos.set (Globals.SECCION_PELICULA,(totalArticulos.get(Globals.SECCION_PELICULA)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_PELICULA));
						//recomendados
						totalArticulos.set (Globals.SECCION_HOME,(totalArticulos.get(Globals.SECCION_HOME)==null)? new Integer(0):totalArticulos.get(Globals.SECCION_HOME));
						String fileName = "/articulos/mesa/total" + filtro + "_" + orden +  ".html";

						String json = totalToJSON(totalArticulos);
						MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
						Integer comparador = new Integer(0);
						if (totalArticulos.get(Globals.SECCION_LIBRO).equals(comparador)
								&& totalArticulos.get(Globals.SECCION_MUSICA).equals(comparador)
								&& totalArticulos.get(Globals.SECCION_JUGUETES).equals(comparador)
								&& totalArticulos.get(Globals.SECCION_PELICULA).equals(comparador)){
							return false;

						} else {
							return true;
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

		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
			return false;
		}
	}

	private static void generarListaMesa(String orden, String filtro, String filtroSQL) {
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				if (orden.equals(MESA_ORDEN_MV)) {
					qry.append(" SELECT a.id_articulo , a.categoria_seccion");
					qry.append(" FROM articulos a, mas_vendidos_seccion mvs , disponibilidades d");
					qry.append(" WHERE a.id_articulo = mvs.id_articulo(+) ");
					qry.append(" AND a.categoria_seccion = mvs.categoria_seccion(+)");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND a.habilitado_tematika = 'S'");
					qry.append(" AND a.activo = 'SI' ");
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(filtroSQL);
					qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(" ORDER BY orden, a.fecha_alta desc");
				}
				if (orden.equals(MESA_ORDEN_MVA)) {
					qry.append(" SELECT a.categoria_seccion, a.id_articulo, decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)), count(ca.id_comentario), ");
					qry.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34), a.fecha_alta");
					qry.append(" FROM articulos a, comentario_articulos ca, disponibilidades d");
					qry.append(" WHERE a.id_articulo = ca.id_articulo");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND ca.estado = 'A'");
					qry.append(" AND a.habilitado_tematika = 'S'");
					qry.append(" AND a.activo = 'SI' ");
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(filtroSQL);
					qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(" GROUP BY a.id_articulo, a.categoria_seccion,  a.fecha_alta");
					qry.append(" ORDER BY");
					qry.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34) desc,");
					qry.append(" count(ca.id_comentario) desc,");
					qry.append(" decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) desc, a.fecha_alta desc");
				}
				if (orden.equals(MESA_ORDEN_MP)) {
					qry.append(" SELECT a.categoria_seccion, a.id_articulo,  count(ca.id_comentario) ");
					qry.append(" FROM articulos a, comentario_articulos ca,  disponibilidades d");
					qry.append(" WHERE a.id_articulo = ca.id_articulo");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND ca.estado = 'A'");
					qry.append(" AND a.activo = 'SI' ");
					qry.append(" AND a.habilitado_tematika = 'S'");
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(filtroSQL);
					qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(" GROUP BY a.id_articulo, a.categoria_seccion,  a.fecha_alta");
					qry.append(" ORDER BY");
					qry.append(" count(ca.id_comentario) desc, a.fecha_alta desc");
				}
				//tematika recomienda
				if (orden.equals(MESA_ORDEN_TMK_RDA)) {
					qry.append(" SELECT a.categoria_seccion, a.id_articulo ");
					qry.append(" FROM articulos_mesa_recomendados a ");
					qry.append(" WHERE ");
					qry.append(filtroSQL);
					qry.append("AND a.se_muestra = '1'");//1=se muestra|0=no
					qry.append(" GROUP BY a.id_articulo, a.categoria_seccion,posicion");
					qry.append(" ORDER BY");
					qry.append(" posicion");
				}

				try {
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						int articulos[][] = new int[6][];
						articulos[Globals.SECCION_LIBRO] = new int[MESA_CH_PAGINA * MESA_TAM_VIEW[Globals.SECCION_LIBRO]];
						articulos[Globals.SECCION_JUGUETES] = new int[MESA_CH_PAGINA * MESA_TAM_VIEW[Globals.SECCION_JUGUETES]];
						articulos[Globals.SECCION_MUSICA] = new int[MESA_CH_PAGINA * MESA_TAM_VIEW[Globals.SECCION_MUSICA]];
						articulos[Globals.SECCION_PELICULA] = new int[MESA_CH_PAGINA * MESA_TAM_VIEW[Globals.SECCION_PELICULA]];
						int iterador[] = new int[6];
						iterador[Globals.SECCION_LIBRO] = 0;
						iterador[Globals.SECCION_JUGUETES] = 0;
						iterador[Globals.SECCION_MUSICA] = 0;
						iterador[Globals.SECCION_PELICULA] = 0;
						int iteradorGlobal[] = new int[6];
						iteradorGlobal[Globals.SECCION_LIBRO] = 0;
						iteradorGlobal[Globals.SECCION_JUGUETES] = 0;
						iteradorGlobal[Globals.SECCION_MUSICA] = 0;
						iteradorGlobal[Globals.SECCION_PELICULA] = 0;
						boolean hayResultado = false;

							while (rs.next()) {
								hayResultado = true;
								try {
									if((rs.getInt("categoria_seccion")<articulos.length)
										&&(iterador[rs.getInt("categoria_seccion")]<articulos[rs.getInt("categoria_seccion")].length)){
										
										articulos[rs.getInt("categoria_seccion")][iterador[rs.getInt("categoria_seccion")]] = rs.getInt("id_articulo");
										iterador[rs.getInt("categoria_seccion")]++;
										iteradorGlobal[rs.getInt("categoria_seccion")]++;
										if (MESA_CH_PAGINA * MESA_TAM_VIEW[rs.getInt("categoria_seccion")] == iterador[rs.getInt("categoria_seccion")]) {
											String json = listaToJSON(articulos[rs.getInt("categoria_seccion")]);
											String fileName = "/articulos/mesa/lista" + filtro + "_" + orden + "_sec" + rs.getInt("categoria_seccion")
															+ "_pag" + ((iteradorGlobal[rs.getInt("categoria_seccion")]-iterador[rs.getInt("categoria_seccion")])/MESA_TAM_VIEW[rs.getInt("categoria_seccion")]+1)  + ".html";
											MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
											iterador[rs.getInt("categoria_seccion")] = 0;
	
											//GENERO EL HTML CON LOS LINKS  DE SEO
											String htmlLink = generarLinks(rs.getInt("categoria_seccion"), articulos[rs.getInt("categoria_seccion")]);
											htmlLink=htmlLink.replaceAll("&", "&amp;");
											MainHelper.saveFileNet(fileName.replaceAll(".html", "SEO.html"), htmlLink, "contenidosEstaticos");
											//FIN BLOQUE
											
											//reinicializo dsps de grabar
											articulos[rs.getInt("categoria_seccion")] = new int[MESA_CH_PAGINA * MESA_TAM_VIEW[rs.getInt("categoria_seccion")]];
										}
									}
								} catch (Exception e) {
									TmkLogger.error(e.toString() + MainHelper.getMessage(e));
								}
							}
							for (int i=0; i<MESA_TAM_VIEW.length; i++) {
								if (MESA_TAM_VIEW[i]>0) {
									String json = listaToJSON(articulos[i]);
									String fileName = "/articulos/mesa/lista" + filtro + "_" + orden + "_sec" + i
									+ "_pag" + ((iteradorGlobal[i]-iterador[i])/MESA_TAM_VIEW[i]+1)  + ".html";
									MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");									
								}
							}
						if (!hayResultado) {
							String json = "{\"list\": []}";
							String fileName = "/articulos/mesa/lista" + filtro + "_" + orden + "_sec" + Globals.SECCION_LIBRO
											+ "_pag" + ((iteradorGlobal[Globals.SECCION_LIBRO]-iterador[Globals.SECCION_LIBRO])/MESA_TAM_VIEW[Globals.SECCION_LIBRO]+1)  + ".html";
							MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");

							json = "{\"list\": []}";
							fileName = "/articulos/mesa/lista" + filtro + "_" + orden + "_sec" + Globals.SECCION_MUSICA
											+ "_pag" + ((iteradorGlobal[Globals.SECCION_MUSICA]-iterador[Globals.SECCION_MUSICA])/MESA_TAM_VIEW[Globals.SECCION_MUSICA]+1)  + ".html";
							MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");

							json = "{\"list\": []}";
							fileName = "/articulos/mesa/lista" + filtro + "_" + orden + "_sec" + Globals.SECCION_JUGUETES
											+ "_pag" + ((iteradorGlobal[Globals.SECCION_JUGUETES]-iterador[Globals.SECCION_JUGUETES])/MESA_TAM_VIEW[Globals.SECCION_JUGUETES]+1)  + ".html";
							MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");

							json = "{\"list\": []}";
							fileName = "/articulos/mesa/lista" + filtro + "_" + orden + "_sec" + Globals.SECCION_PELICULA
											+ "_pag" + ((iteradorGlobal[Globals.SECCION_PELICULA]-iterador[Globals.SECCION_PELICULA])/MESA_TAM_VIEW[Globals.SECCION_PELICULA]+1)  + ".html";
							MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
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

		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
		}
	}

	private static void generarMesaXCategoria(Categoria categoria[]) throws Exception {
		try {

			for (int i=0; i<categoria.length; i++) {
				MesaFiltroOrdenWrapper mesaFiltroOrdenWrapper = new MesaFiltroOrdenWrapper();
				mesaFiltroOrdenWrapper.M_MV = generarTotalMesaCategoria(MESA_ORDEN_MV, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL, categoria[i].getCategoriaPK());
				generarListaMesaCategoria(MESA_ORDEN_MV, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL, categoria[i].getCategoriaPK());
				mesaFiltroOrdenWrapper.Y_MV = generarTotalMesaCategoria(MESA_ORDEN_MV, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL, categoria[i].getCategoriaPK());
				generarListaMesaCategoria(MESA_ORDEN_MV, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL, categoria[i].getCategoriaPK());

				mesaFiltroOrdenWrapper.M_MVA = generarTotalMesaCategoria(MESA_ORDEN_MVA, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL, categoria[i].getCategoriaPK());
				generarListaMesaCategoria(MESA_ORDEN_MVA, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL, categoria[i].getCategoriaPK());
				mesaFiltroOrdenWrapper.Y_MVA = generarTotalMesaCategoria(MESA_ORDEN_MVA, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL, categoria[i].getCategoriaPK());
				generarListaMesaCategoria(MESA_ORDEN_MVA, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL, categoria[i].getCategoriaPK());
				mesaFiltroOrdenWrapper.T_MVA = generarTotalMesaCategoria(MESA_ORDEN_MVA, MESA_FILTRO_TOTAL, MESA_FILTRO_TOTAL_SQL, categoria[i].getCategoriaPK());
				generarListaMesaCategoria(MESA_ORDEN_MVA, MESA_FILTRO_TOTAL, MESA_FILTRO_TOTAL_SQL, categoria[i].getCategoriaPK());

				mesaFiltroOrdenWrapper.M_MP = generarTotalMesaCategoria(MESA_ORDEN_MP, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL, categoria[i].getCategoriaPK());
				generarListaMesaCategoria(MESA_ORDEN_MP, MESA_FILTRO_MES, MESA_FILTRO_MES_SQL, categoria[i].getCategoriaPK());
				mesaFiltroOrdenWrapper.Y_MP = generarTotalMesaCategoria(MESA_ORDEN_MP, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL, categoria[i].getCategoriaPK());
				generarListaMesaCategoria(MESA_ORDEN_MP, MESA_FILTRO_AÑO, MESA_FILTRO_AÑO_SQL, categoria[i].getCategoriaPK());
				mesaFiltroOrdenWrapper.T_MP = generarTotalMesaCategoria(MESA_ORDEN_MP, MESA_FILTRO_TOTAL, MESA_FILTRO_TOTAL_SQL, categoria[i].getCategoriaPK());
				generarListaMesaCategoria(MESA_ORDEN_MP, MESA_FILTRO_TOTAL, MESA_FILTRO_TOTAL_SQL, categoria[i].getCategoriaPK());

				try{
					String fileName = "/articulos/mesa/filtroOrdenCat_sec" + categoria[i].getCategoriaPK().toCode() +  ".html";
					String json = filtroOrdenToJSON(mesaFiltroOrdenWrapper);
					MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
				}catch(Exception e){
					TmkLogger.error(e.toString() + MainHelper.getMessage(e));
				}

				TmkLogger.debug("Generado " + categoria[i].getCategoriaPK().toString());

				if (categoria[i].getSubCategoria().length>0) {
					generarMesaXCategoria(categoria[i].getSubCategoria());
				}
			}
		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
		}

	}

	public static boolean generarTotalMesaCategoria(String orden, String filtro, String filtroSQL, CategoriaPK categoriaPK) {
//	private static boolean generarTotalMesaCategoria(String orden, String filtro, String filtroSQL, CategoriaPK categoriaPK) {
		try {
			Connection conn = DBUtil.buildConnection();
			try {

				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				if (orden.equals(MESA_ORDEN_MV)) {
					qry.append(" SELECT categoria_seccion, count(distinct a.id_articulo) cantidad");
					qry.append(" FROM articulos a , disponibilidades d");
					qry.append(" WHERE a.habilitado_tematika = 'S' ");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND a.activo = 'SI' ");
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(filtroSQL);
					qry.append(" AND ").append(getDBWhere(categoriaPK));
					qry.append(" GROUP BY categoria_seccion ");
				}
				if (orden.equals(MESA_ORDEN_MVA) || orden.equals(MESA_ORDEN_MP)) {
					qry.append(" SELECT categoria_seccion, count(distinct a.id_articulo) cantidad ");
					qry.append(" FROM articulos a, comentario_articulos ca, disponibilidades d");
					qry.append(" WHERE a.id_articulo = ca.id_articulo");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND ca.estado = 'A'");
					qry.append(" AND a.habilitado_tematika = 'S'");
					qry.append(" AND a.activo = 'SI' ");
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(filtroSQL);
					qry.append(" AND ").append(getDBWhere(categoriaPK));
					qry.append(" GROUP BY a.categoria_seccion");
				}

				try {
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						if (rs.next()) {
							String json = "{\"total\":" + rs.getInt("cantidad") + "}";
							String fileName = "/articulos/mesa/totalCat" + filtro + "_" + orden +"_sec" + categoriaPK.toCode() +  ".html";
							MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
							return true;
						} else {
							String json = "{\"total\":0}";
							String fileName = "/articulos/mesa/totalCat" + filtro + "_" + orden +"_sec" + categoriaPK.toCode() +  ".html";
							MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
							return false;
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

		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
			return false;
		}
	}

	public static void generarListaMesaCategoria(String orden, String filtro, String filtroSQL, CategoriaPK categoriaPK) {
//	private static void generarListaMesaCategoria(String orden, String filtro, String filtroSQL, CategoriaPK categoriaPK) {
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				if (orden.equals(MESA_ORDEN_MV)) {
					qry.append(" SELECT a.id_articulo");
					qry.append(" FROM articulos a, ");
					qry.append(" mas_vendidos_seccion mvs, disponibilidades d ");
					qry.append(" WHERE a.id_articulo = mvs.id_articulo(+) ");
					qry.append(" AND a.categoria_seccion = mvs.categoria_seccion(+)");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND a.habilitado_tematika = 'S'");
					qry.append(" AND a.activo = 'SI'");
					qry.append(filtroSQL);
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(" AND ").append(getDBWhere(categoriaPK));
					qry.append(" ORDER BY orden, a.fecha_alta desc");
				}
				if (orden.equals(MESA_ORDEN_MVA)) {
					qry.append(" SELECT a.id_articulo, decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)), count(ca.id_comentario), ");
					qry.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34), a.fecha_alta");
					qry.append(" FROM articulos a, comentario_articulos ca , disponibilidades d");
					qry.append(" WHERE a.id_articulo = ca.id_articulo");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND ca.estado = 'A'");
					qry.append(" AND a.habilitado_tematika = 'S'");
					qry.append(" AND a.activo = 'SI'");
					qry.append(filtroSQL);
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(" AND ").append(getDBWhere(categoriaPK));
					qry.append(" GROUP BY a.id_articulo, a.fecha_alta");
					qry.append(" ORDER BY");
					qry.append(" ceil( decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) + 0.34) desc,");
					qry.append(" count(ca.id_comentario) desc,");
					qry.append(" decode(count(ca.id_comentario), 0, 0, sum(ca.evaluacion)/count(ca.id_comentario)) desc, a.fecha_alta desc");
				}
				if (orden.equals(MESA_ORDEN_MP)) {
					qry.append(" SELECT a.id_articulo,  count(ca.id_comentario) ");
					qry.append(" FROM articulos a, comentario_articulos ca, disponibilidades d");
					qry.append(" WHERE a.id_articulo = ca.id_articulo");
					qry.append(" AND a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" AND d.pedido_especial = 'N'");
					qry.append(" AND d.id_esquema = 'PROD'");
					qry.append(" AND ca.estado = 'A'");
					qry.append(" AND a.habilitado_tematika = 'S'");
					qry.append(" AND a.activo = 'SI'");
					qry.append(filtroSQL);
					qry.append(TIENE_EN_CUENTA_IMAGEN);
					qry.append(" AND ").append(getDBWhere(categoriaPK));
					qry.append(" GROUP BY a.id_articulo,  a.fecha_alta");
					qry.append(" ORDER BY");
					qry.append(" count(ca.id_comentario) desc, a.fecha_alta desc");
				}
				try {
					ResultSet rs = st.executeQuery(qry.toString());
					try {
						int articulos[]= new int[MESA_CH_PAGINA * MESA_TAM_VIEW_SECCION[categoriaPK.getPK()[0]]];
						int iterador = 0;
						int iteradorGlobal =0;
						boolean hayResultados = false;

						while (rs.next()) {
							hayResultados = true;
							try {
								articulos[iterador] = rs.getInt("id_articulo");
								iterador++;
								iteradorGlobal++;
								if (MESA_CH_PAGINA * MESA_TAM_VIEW_SECCION[categoriaPK.getPK()[0]] == iterador) {
									String json = listaToJSON(articulos);
									String fileName = "/articulos/mesa/listaCat" + filtro + "_"+orden+"_sec" + categoriaPK.toCode()
													+ "_pag" + ((iteradorGlobal-iterador)/MESA_TAM_VIEW_SECCION[categoriaPK.getPK()[0]]+1)  + ".html";
									MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
									iterador = 0;
								}
							} catch (Exception e) {
								TmkLogger.error(e.toString() + MainHelper.getMessage(e));
							}
						}
						if (MESA_TAM_VIEW_SECCION[categoriaPK.getPK()[0]]>0) {
							String json = listaToJSON(articulos);
							String fileName = "/articulos/mesa/listaCat" + filtro + "_"+orden+"_sec" + categoriaPK.toCode()
							+ "_pag" + ((iteradorGlobal-iterador)/MESA_TAM_VIEW_SECCION[categoriaPK.getPK()[0]]+1)  + ".html";
							MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
						}
						if (!hayResultados){
							String json = "{\"list\": []}";
							String fileName = "/articulos/mesa/listaCat" + filtro + "_"+orden+"_sec" + categoriaPK.toCode()
											+ "_pag" + ((iteradorGlobal-iterador)/MESA_TAM_VIEW_SECCION[categoriaPK.getPK()[0]]+1)  + ".html";
							MainHelper.saveFileNet(fileName, json, "contenidosEstaticos");
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

		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
		}
	}

	private static String getDBWhere(CategoriaPK pk) {
		StringBuffer dbWhere = new StringBuffer("");
		dbWhere.append(" a.categoria_seccion = ").append(pk.getPK()[0]);
		if (pk.getPK().length>1) {
			dbWhere.append(" and a.categoria_grupo = ").append(pk.getPK()[1]);
			if (pk.getPK().length>2) {
				dbWhere.append(" and a.categoria_familia = ").append(pk.getPK()[2]);
				if (pk.getPK().length>3) {
					dbWhere.append(" and a.categoria_subfamilia = ").append(pk.getPK()[3]);
				}
			}

		}
		return dbWhere.toString();
	}

	private static String totalToJSON(Vector total) {
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("total", Vector.class);
		String json = xstream.toXML(total);
		return Convert.toFixedJSON(json);
	}

	private static String listaToJSON(int[] articulo) {
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		List<ArticuloWrapper> articulos=new ArrayList<ArticuloWrapper>();
		try {
			List<Integer> ids=new ArrayList<Integer>();
			for(int i=0; i<articulo.length; i++)
				if(articulo[i]!=0)
					ids.add(articulo[i]);
			if(ids.size()>0){
				Collection<Articulo> arts=DAOFactory.getArticuloDAO().getListaArticulosParaSEO(ids);
				if(arts!=null){
					for(Integer i : ids)
						for(Iterator<Articulo> j=arts.iterator(); j.hasNext();){
							try{
								Articulo a=j.next();
								if(a.getId_articulo().intValue()==i.intValue()){
									ArticuloWrapper artWrapper=new ArticuloWrapper();
									artWrapper.setIdArticulo(a.getId_articulo());
									artWrapper.setUrlDetalle(a.getUrlDetalle());
									artWrapper.setAltImagen(a.getCls_altImagen());					
									articulos.add(artWrapper);
								}
						}catch(Exception e){
							TmkLogger.error(e);
						}
					}
				}
			}
		} catch (Exception e) {
			TmkLogger.error(e);
		}
		String json = xstream.toXML(articulos);
		return Convert.toFixedJSON(json).replaceAll("int-array", "lista");
	}

	@SuppressWarnings("unchecked")
	private static String generarLinks(int idSeccion,int[] articulos)throws Exception {		
		if(articulos.length == 0)
			return "";
		
		List<Integer> ids =  new ArrayList<Integer>();
		for(int i=0;i<articulos.length;i++) {
			ids.add(articulos[i]);
		}		
		Collection<Articulo> bos = ServiceLocator.getArticuloService().getListaArticulosParaSEO(ids);
		int count = 0;
		if(bos!=null && bos.size() > 0) {
			if (bos.size() < 10) { 
				maxLen = bos.size();
			}
			Template tmpSEO = (Template )ServiceLocator.getTemplateService().getTemplate("tmpLinksMesa");
			Vector vecDetalles = new Vector(maxLen);//guarda todos los detalles
			Hashtable hasDetalles = null;		
			Vector vecAutores = null;		
			Iterator<Articulo> itArticulo = bos.iterator();
			while(itArticulo.hasNext()){
				hasDetalles = new Hashtable(maxLen);
				Articulo articulo = itArticulo.next();  
				articulo.setUrlDetalle();
				//hasDetalles.put("urlDetalle", articulo.getUrlDetalle());
				hasDetalles.put("titulo", Convert.corregir(articulo.getTitulo(), true));
				hasDetalles.put("urlDetalle", articulo.getUrlDetalle());
							
				// agrego el/los autores
				if (articulo.getArticuloAutor() != null) {
					vecAutores = new Vector(articulo.getArticuloAutor().length);
					articulo.setUrlBusquedaAutor();// seteo la url como en GetArticuloByIDnvl1
					for (int j = 0; j < articulo.getArticuloAutor().length; j++) {
						Hashtable hashAutores = new Hashtable();
		
						hashAutores.put("autor", Convert.nombrePropio(articulo
								.getArticuloAutor()[j].getAutor().getNombre(articulo.getCategoria_seccion()), false));
						hashAutores.put("urlAutor", articulo.getArticuloAutor()[j]
								.getAutor().getCls_urlBusqueda());
		
						vecAutores.add(hashAutores);
					}
					hasDetalles.put("autores", vecAutores);
					hasDetalles.put("tieneAutor",vecAutores.size() > 0 ? "true" : "");
				}	
				hasDetalles.put("dominio", Globals.DOMINIO_SITIO);
				vecDetalles.add(hasDetalles);
				
				count++;
				if (count == maxLen) {
					break;
				}
			}		
			tmpSEO.setParam("links", vecDetalles);
			tmpSEO.setParam("dominio", Globals.DOMINIO_SITIO);
			//response.getWriter().println(tmpSEO.output());
			return tmpSEO.output();		
		}
		return "";
	}
	
	private static String filtroOrdenToJSON(MesaFiltroOrdenWrapper mesafiltroOrdenWrapper) {
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("filtroOrden", MesaFiltroOrdenWrapper.class);
		String json = xstream.toXML(mesafiltroOrdenWrapper);
		return Convert.toFixedJSON(json);
	}

	/**
	 * Este metodo es llamado desde un run pro configurado en server.xml
	 */
	public static void generarArticulo() {
		if (Globals.GENERANDO_DETALLES) {
			System.out.println("generarArticulo->no puede correr esta corriendo generarArticuloRediseno");
			return;
		}
		Globals.GENERANDO_DETALLES = true;

		Timestamp fechaMax = null;
		try {
			Connection conn = DBUtil.buildConnection();
            try {
            	StringBuffer qry = new StringBuffer(" SELECT min(last_refresh) fecha ");
            	qry.append(" FROM all_snapshots snp, ");
            	qry.append(" all_synonyms syn ");
            	qry.append(" WHERE syn.table_name = snp.name ");
            	qry.append(" AND synonym_name in ('DISPONIBILIDADES','ARTICULOS_TEMAS_MUSICALES','CATEG_SUBFAMILIAS','CATEG_GRUPOS','CATEG_FAMILIAS','AUTORES','ARTICULOS_AUTORES_BIOGRAFIA','ARTICULOS_TEXTOS','ARTICULOS_AUTORES')");
            	PreparedStatement statement = conn.prepareStatement(qry.toString());
                try{
                    ResultSet resultSet = statement.executeQuery();
	                try {
						if(resultSet.next()){
							fechaMax = resultSet.getTimestamp("fecha");
						}
	                } finally {
		                resultSet.close();
	                }
                } finally{
                    statement.close();
                }
            }finally{
                conn.close();
            }
        } catch (Exception e) {
	        TmkLogger.error("GENERACION ARTICULO] obtencion de fecha " + e.toString() + MainHelper.getMessage(e));
        }

        //fechaMax = new Timestamp(new Date().getTime());
        if (fechaMax != null) {
        	Vector detallesArticulos = new Vector();
        	try {
        		Connection conn = DBUtil.buildConnection();
                try {
                	StringBuffer qry = new StringBuffer ("");
                	qry.append(" SELECT distinct id_articulo, categoria_seccion, alcance, extra, clave FROM ( ");
                	qry.append(" ( ");
                	qry.append(" SELECT id_articulo,categoria_seccion, alcance, extra, clave FROM ARTICULOS a ");
                	qry.append(" INNER JOIN ARTICULOS_GENERADOS ag ON ");
                	qry.append(" a.categoria_seccion = SUBSTR(ag.extra,1,2)");
                	qry.append(" AND a.categoria_grupo = SUBSTR(ag.extra,3,2)");
                	qry.append(" WHERE ag.procesado = 'N'");
                	qry.append(" AND ag.fecha <= TO_DATE(SUBSTR('").append(fechaMax).append("',1,19),'yyyy-mm-dd hh24:mi:ss')");
                	qry.append(" AND a.habilitado_tematika = 'S'");
                	qry.append(" AND ag.alcance = 4");
                	qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
                	qry.append(" ) UNION (");
                	qry.append(" SELECT id_articulo,categoria_seccion, alcance, extra, clave FROM ARTICULOS a");
                	qry.append(" INNER JOIN ARTICULOS_GENERADOS ag ON");
                	qry.append(" a.categoria_seccion = SUBSTR(ag.extra,1,2)");
                	qry.append(" AND a.categoria_grupo = SUBSTR(ag.extra,3,2)");
                	qry.append(" AND a.categoria_familia = SUBSTR(ag.extra,5,2)");
                	qry.append(" WHERE ag.procesado = 'N'");
                	qry.append(" AND ag.fecha <= TO_DATE(SUBSTR('").append(fechaMax).append("',1,19),'yyyy-mm-dd hh24:mi:ss')");
                	qry.append(" AND habilitado_tematika = 'S'");
                	qry.append(" AND ag.alcance = 5");
                	qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
                	qry.append(" ) UNION (");
                	qry.append(" SELECT id_articulo,categoria_seccion, alcance, extra, clave FROM ARTICULOS a ");
                	qry.append(" INNER JOIN ARTICULOS_GENERADOS ag ON ");
                	qry.append(" a.categoria_seccion = SUBSTR(ag.extra,1,2) ");
                	qry.append(" AND a.categoria_grupo = SUBSTR(ag.extra,3,2) ");
                	qry.append(" AND a.categoria_familia = SUBSTR(ag.extra,5,2) ");
                	qry.append(" AND a.categoria_subfamilia = SUBSTR(ag.extra,7,2) ");
                	qry.append(" WHERE ag.procesado = 'N' ");
                	qry.append(" AND ag.fecha <= TO_DATE(SUBSTR('").append(fechaMax).append("',1,19),'yyyy-mm-dd hh24:mi:ss')");
                	qry.append(" AND habilitado_tematika = 'S' ");
                	qry.append(" AND ag.alcance = 6 ");
                	qry.append(" AND a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
                	qry.append(" ) UNION ( ");
                	qry.append(" SELECT distinct a.id_articulo,a.categoria_seccion, alcance, extra, clave ");
                	qry.append(" FROM (SELECT clave, alcance, extra from articulos_generados WHERE (alcance=3 or alcance=2) and procesado='N' and fecha <= to_date(substr('").append(fechaMax).append("',1,19),'yyyy-mm-dd hh24:mi:ss') ) ag  ");
                	qry.append(" JOIN ( ");
                	qry.append(" SELECT categoria_seccion, id_articulo ");
                	qry.append(" FROM articulos");
                	qry.append(" WHERE habilitado_tematika='S' ");
                	qry.append(" and categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
                	qry.append(" ) a on ag.clave=a.id_articulo ");
                	qry.append(" ) UNION (  ");
                	qry.append(" SELECT distinct a.id_articulo,a.categoria_seccion, alcance, extra, clave ");
                	qry.append(" FROM (select clave, alcance, extra from articulos_generados where alcance=1 and procesado='N' and fecha <= to_date(substr('").append(fechaMax).append("',1,19),'yyyy-mm-dd hh24:mi:ss') ) ag  ");
                	qry.append(" JOIN ( ");
                	qry.append(" SELECT categoria_seccion,id_articulo,id_editor ");
                	qry.append(" FROM articulos ");
                	qry.append(" WHERE habilitado_tematika='S' ");
                	qry.append(" and categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
                	qry.append(" ) a on ag.clave=a.id_editor ");
                	qry.append(" ) UNION ( ");
                	qry.append(" SELECT distinct a.id_articulo,a.categoria_seccion, alcance, extra, clave ");
                	qry.append(" FROM (select clave, alcance, extra from articulos_generados where alcance=0  and procesado='N' and fecha <= to_date(substr('").append(fechaMax).append("',1,19),'yyyy-mm-dd hh24:mi:ss') ) ag  ");
                	qry.append(" JOIN articulos_autores aa on ag.clave=aa.id_autor ");
                	qry.append(" JOIN ( ");
                	qry.append(" SELECT categoria_seccion,id_articulo ");
                	qry.append(" FROM articulos ");
                	qry.append(" where habilitado_tematika='S' ");
                	qry.append(" and categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
                	qry.append(" ) a on aa.id_articulo=a.id_articulo ");
                	qry.append(" ))order by alcance, extra, clave, id_articulo ");

	                TmkLogger.debug(qry);
                    PreparedStatement statement = conn.prepareStatement(qry.toString());
                    try {
                        ResultSet resultSet = statement.executeQuery();
                        try {
                            while (resultSet.next()) {
                                 //detallesArticulos
                            	MultiField registro = new MultiField(6);
 	                            registro.addValor(0, new Integer(resultSet.getInt("id_articulo")));
 	                            registro.addValor(1, new Integer(resultSet.getInt("categoria_seccion")));
 	                            registro.addValor(2, "S");
 	                            registro.addValor(3, new Integer(resultSet.getInt("alcance")));
 	                            registro.addValor(4, new String((resultSet.getString("extra") == null)? "":(resultSet.getString("extra"))));
 	                            registro.addValor(5, new Integer(resultSet.getInt("clave")));
 	                            detallesArticulos.add(registro);
                             }
                         } finally {
                             resultSet.close();
                         }
                     } finally {
                         statement.close();
                     }
                 } finally {
                     conn.close();
                 }
             } catch (Exception e) {
 	            TmkLogger.error("GENERACION ARTICULO] ejecucion de qry principal " + e.toString() + MainHelper.getMessage(e));
             }

             /**/
             int articulosGenerados = 0;
             int cantFallados = 0;
     	     long inicio = Calendar.getInstance().getTimeInMillis();
             //GENERACION PAUSADA
     	     try {
     	    	 String estado = null;
     	    	 //int tiempoEspera = 400;
     	    	 // tomo el alcance del primer elemento para comenzar.
     		     int idArticulo = -1;
     		     int alcanceAnterior = -1;
     		     String extra = "";
     		     Integer clave = new Integer(-1);
     		     int paraCommit = 0;
     		     if (detallesArticulos.size() >0) {
                	 alcanceAnterior = ((Integer)((MultiField)detallesArticulos.get(0)).getValor(3)).intValue();
                	 extra = ((String)((MultiField)detallesArticulos.get(0)).getValor(4));
                	 clave = ((Integer)((MultiField)detallesArticulos.get(0)).getValor(5));
                 }
     		     Vector listaParaCommit = new Vector();
     		     TmkLogger.debug("cantidad de articulos" + detallesArticulos.size());
     			 for (int i=0;i<detallesArticulos.size();i++) {
     				 paraCommit++;
     				 /*commit*/
     				 // por diferente alcance o por // diferente grupo en un alcance
     				 if ((alcanceAnterior != ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue()) ||
     						 (extra!=null && !extra.equals(((MultiField)detallesArticulos.get(i)).getValor(4)) && ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() !=3 && ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() !=2) ||
     				         (clave!=null && !clave.equals(((MultiField)detallesArticulos.get(i)).getValor(5)) && ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() !=3 && ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() !=2) ||
     				         ((((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() == 3 || ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() == 2) && paraCommit > 99)) {
     					 try {
     						 commitArticuloGenerado(listaParaCommit, alcanceAnterior, extra, fechaMax);
     					 } catch (Exception e) {
     						 TmkLogger.debug("error commit " + e.toString());
     					 }
                         paraCommit = 0;
     					 listaParaCommit.clear();
     				 }
     				/*commit*/
                     //armo lista para commit en caso de que sea alcance 3 o 2, sino un solo elemento
     				//sacado del if  || listaParaCommit.size()==0
     				if (((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() ==3 || ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() ==2) {
     					listaParaCommit.add(((MultiField)detallesArticulos.get(i)).getValor(0));
                     }
     				//armo lista para commit en caso de que sea alcance 0 o 1, sino un solo elemento
     				if (((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() ==0 || ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue() ==1) {
     					//no debe repetirse la clave porque corresponde a un autor o un editor
     					if (listaParaCommit.size() == 0) {
     						listaParaCommit.add((Integer)((MultiField)detallesArticulos.get(i)).getValor(5));
     					} else {
     						if (!listaParaCommit.get(listaParaCommit.size()-1).equals((Integer)((MultiField)detallesArticulos.get(i)).getValor(5))) {
     							listaParaCommit.add((Integer)((MultiField)detallesArticulos.get(i)).getValor(5));
     						}
     					}
                     }
             		//para la proxima vuelta
     				alcanceAnterior = ((Integer)((MultiField)detallesArticulos.get(i)).getValor(3)).intValue();
     				extra = ((String)((MultiField)detallesArticulos.get(i)).getValor(4));
     				clave = ((Integer)((MultiField)detallesArticulos.get(i)).getValor(5));
                    articulosGenerados++;

                    if (idArticulo != ((Integer)((MultiField)detallesArticulos.get(i)).getValor(0)).intValue()) {
                    	//int idArt = ((Integer)((MultiField)detallesArticulos.get(i)).getValor(0)).intValue();
                        //String dirAdicional = "" + (int)Math.floor(idArt/1000) * 1000;
     					boolean retorno;
     					try {
     						//DETALLE DEL ARTICULO
	     					retorno = generarDetalle(((Integer)((MultiField)detallesArticulos.get(i)).getValor(0)).intValue(),
	     					 			((Integer)((MultiField)detallesArticulos.get(i)).getValor(1)).intValue());
	     					//generarJSONNVL1((Integer)((MultiField)detallesArticulos.get(i)).getValor(0));
	     					//long delay = Calendar.getInstance().getTimeInMillis();
	     					/*while (Calendar.getInstance().getTimeInMillis() < delay + 1000) {
	     						TmkLogger.debug("esperando");
	     					}*/
	     				//	System.out.println(Calendar.getInstance().getTimeInMillis());
	     					Thread.sleep(200);
	     				//	System.out.println(Calendar.getInstance().getTimeInMillis());

     					} catch (Exception e) {
     						retorno = false;
     					}
     					if (!retorno) {
     						cantFallados++;
     					//	System.out.println(""+cantFallados);
     					}
     					estado = (retorno) ? "P":"E";
     					TmkLogger.debug("GENERADO " + ((MultiField)detallesArticulos.get(i)).getValor(0));
     				}
     				idArticulo =((Integer)((MultiField)detallesArticulos.get(i)).getValor(0)).intValue();

     				((MultiField)detallesArticulos.get(i)).addValor(2, estado);

     			}

     		    try {
     		    	commitArticuloGenerado(listaParaCommit, alcanceAnterior, extra, fechaMax);
     		    } catch (Exception e) {
     			    TmkLogger.debug("ultimo commit" + e.toString());
     		    }

     	    } catch (Exception e) {
                MailUtil.sendMail(
     			Globals.MAIL_MAILER,
     			Globals.MAIL_WEBMASTER,
     			"Generación de los detalles estáticos.",
     			"Error en proceso de generacion. " + e.toString());

     	        TmkLogger.error("GENERACION ARTICULO] error en proceso de generacion " + e.toString());
     	        Globals.GENERANDO_DETALLES = false;
     	        return;
     	    }
            long fin = Calendar.getInstance().getTimeInMillis();
     		TmkLogger.debug("TIEMPO DE GENERACION generarArticulo " + ((fin-inicio)/1000));
     		try{
                Connection conn = DBUtil.buildConnection();
                try {
                	StringBuffer paginasError = new StringBuffer();
                	Long nextIdArtGen;
                	for(int i=0;i<detallesArticulos.size();i++){
    		            if (((String)((MultiField)detallesArticulos.get(i)).getValor(2)).equalsIgnoreCase("E")) {

    		            	paginasError.append(" articulo Nº " + ((Integer)((MultiField)detallesArticulos.get(i)).getValor(0)).intValue() + "<br>");
    	                    try{
    							nextIdArtGen = DBUtil.getSequenceLong("Tematika.ART_GEN_SEQ");
    		                    PreparedStatement statement = conn.prepareStatement("INSERT INTO ARTICULOS_GENERADOS (ID_ART_GEN,CLAVE,ALCANCE,PROCESADO) VALUES (" + nextIdArtGen.longValue() + "," + ((Integer)((MultiField)detallesArticulos.get(i)).getValor(0)).intValue() + ",3,'N')");

    							articulosGenerados--;
    							try{
    								statement.execute();
    							} finally {
    								statement.close();
    							}
    						} catch (Exception e) {
    		                    TmkLogger.error("error" + e.toString());
    						}

    	                }
    	            }

    				if (paginasError.length()>0){
    					TmkLogger.error("GENERACION ARTICULO] No se generaron todos los articulos.");
    						MailUtil.sendMail(
    						Globals.MAIL_MAILER,
    						Globals.MAIL_WEBMASTER,
    						"Generacion de los Detalles de los Artículo Estáticos.",
    						"No se pudieron terminar de generar todos los detalles estáticos de los artículos. Cantidad = " + articulosGenerados + " " + paginasError.toString());
    				} else {
    					TmkLogger.info("Finalización de la Generación de detalles Estáticos");
    						MailUtil.sendMail(
    						Globals.MAIL_MAILER,
    						Globals.MAIL_WEBMASTER,
    						"Generación de los detalles estáticos.",
    						"Se terminaron de generar todos los detalles de los artículos modificados. Cantidad = " + articulosGenerados + ". Tiempo de Generacion " + ((fin-inicio)/1000) + " segundos.");
    				}

    			} catch (Exception e) {
    				TmkLogger.error("GENERACION ARTICULO] Error en la actualizacion de articulos generados " + e.toString());
    			} finally {
    				conn.close();
    			}
            } catch (Exception e) {
            	TmkLogger.error("GENERACION ARTICULO] Error en conexion " + e.toString());
            }
             /**/

        }
        Globals.GENERANDO_DETALLES = false;
	}

	/**
	 * SETEA EL ESTADO EN S PARA INDICAR QUE YA SE PROCESO ASI LA PROXIMA LEIDA YA NO SE TIENE EN CUENTA
	 * @param Vector v
	 * @param alcance
	 * @param extra
	 * @param fecha
	 * @throws java.sql.SQLException
	 * @throws javax.naming.NamingException
	 * @throws java.lang.Exception
	 */
	private static void commitArticuloGenerado(Vector v, int alcance, String extra, Timestamp fecha) throws java.sql.SQLException, javax.naming.NamingException, java.lang.Exception {
        Connection conn = DBUtil.buildConnection();
		try {
			PreparedStatement statement;
	        if (alcance == 3 || alcance == 2 || alcance == 0 || alcance ==1) {
	            statement = conn.prepareStatement("update articulos_generados set procesado = 'S' where clave = ? and fecha <= TO_DATE(SUBSTR('" + fecha + "',1,19),'yyyy-mm-dd hh24:mi:ss')");
                for (int i=0; i<v.size(); i++) {
					try {
						statement.setInt(1, ((Integer)v.get(i)).intValue());
						TmkLogger.debug("commit idArticulo" + ((Integer)v.get(i)).intValue());
						statement.execute();
					} catch (Exception e) {
                        TmkLogger.debug("falla qry commit " + e.toString());
					}
                }
	        } else {
                statement = conn.prepareStatement("update articulos_generados set procesado = 'S' where extra = ? and fecha <= TO_DATE(SUBSTR('" + fecha + "',1,19),'yyyy-mm-dd hh24:mi:ss')");
		        try {
					statement.setString(1, extra);
			        TmkLogger.debug("commit idArticulo" + extra);
					statement.execute();
				} catch (Exception e) {
                    TmkLogger.debug("falla qry commit " + e.toString());
				}
            }
			statement.close();
			//BLOQUE AGREGADO PARA GENERACION DE DETALLE ESTATICOS "nuevos"
			//como ya tengo el vector de los articulos que se procesaron directamente llamo a generardetlle
			//for(int i = 0;i < v.size();i++){
			//	generarDetalleRediseno(((Integer)v.get(i)).intValue(), 0);
			//}
			//FIN BLOQUE
		} finally {
			conn.close();
		}
	}
		
	public static boolean generarDetalle(int idArticulo, int idSeccion) {
		return generarDetalleRediseno(idArticulo, idSeccion);
	}

/**	
	public static boolean generarDetalle(int idArticulo, int idSeccion) {

			String directorio = "/articulos";
			String dirAdicional = "" + (int)Math.floor(idArticulo/1000) * 1000;
			String paginaDinamica;
			String paginaGenerada;
			boolean generacionOK = true;
			boolean resultado = true;

			try{

//	BORRADO DE TAPAS GENERADAS
				File tapaChica = new File (Contenido.getServletContext().getRealPath("\\tapas\\sitio\\" + idArticulo + "c0.jpg"));
				if(tapaChica.exists()) {
					tapaChica.delete();
					TmkLogger.debug("Borrando TAPA " + tapaChica.getAbsolutePath());
				}

	//			File tapaChicaLocal = new File (Globals.GENERACION_DIRECTORIO + "\\tapas\\sitio\\" + idArticulo + "c0.jpg");
	//			if(tapaChicaLocal.exists()) {
	//				tapaChicaLocal.delete();
	//				TmkLogger.debug("Borrando TAPA " + tapaChicaLocal.getAbsolutePath());
	//			}
	//
				File tapaGrande = new File (Contenido.getServletContext().getRealPath("\\tapas\\sitio\\" + idArticulo + "g0.jpg"));
				if(tapaGrande.exists()) {
					tapaGrande.delete();
					TmkLogger.debug("Borrando TAPA " + tapaChica.getAbsolutePath());
				}

	//			File tapaGrandeLocal = new File (Globals.GENERACION_DIRECTORIO + "\\tapas\\sitio\\" + idArticulo + "g0.jpg");
	//			if(tapaGrandeLocal.exists()) {
	//				tapaGrandeLocal.delete();
	//				TmkLogger.debug("Borrando TAPA " + tapaChicaLocal.getAbsolutePath());
	//			}


//	BORRADO DE TAPAS GENERADAS
//	DETALLE DEL ARTICULO

			    	//detalle
			    	paginaDinamica = "/articulo/componentes/detalle[ORIGINAL].jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
			    	paginaGenerada = directorio + "/" + dirAdicional + "/detalle" + idArticulo + ".html";

			    	resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
					generacionOK = (generacionOK && resultado);

					//tag
					paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo="  + idArticulo;
			    	paginaGenerada = directorio + "/" + dirAdicional + "/tagDetalle" +  idArticulo + ".html";

			    	resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
					generacionOK = (generacionOK && resultado);


//	BIOGRAFIA
					if (idSeccion != Globals.SECCION_JUGUETES) {
						int idAutor = ArticuloManager.getAutorConBiografia(idArticulo,(idSeccion == Globals.SECCION_PELICULA)? "('D02', 'E01')":"'A01'",Contenido.getServletContext());

						if (idAutor > -1) {

							//detalle
							paginaDinamica = "/articulo/componentes/biografia.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&idAutor=" + idAutor  + "&generacion=true";
							paginaGenerada = directorio + "/" + dirAdicional + "/biografia" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);

							//tag
							paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=Biografia";
							paginaGenerada = directorio + "/" + dirAdicional + "/tagBio" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);
						}
					}

					if (idSeccion == Globals.SECCION_LIBRO) {
//	PRIMER CAPITULO
						if (ArticuloManager.tienePrimerCapitulo(idArticulo,Contenido.getServletContext())) {

							//detalle
							paginaDinamica = "/articulo/componentes/primerCapitulo.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
							paginaGenerada = directorio + "/" + dirAdicional + "/primerCapitulo" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);

							//tag
							paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=" + URLEncoder.encode("Primer Capitulo","ISO-8859-1");
							paginaGenerada = directorio + "/" + dirAdicional + "/tagCap" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);
						}

//	INDICE DE CONTENIDOS
						if (ArticuloManager.tieneIndice(idArticulo)) {
							//detalle
							paginaDinamica = "/articulo/componentes/indiceDeContenidos.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
							paginaGenerada = directorio + "/" + dirAdicional + "/indiceDeContenidos" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);

							//tag
							paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=" + URLEncoder.encode("Indice de Contenidos ", "ISO-8859-1");
							paginaGenerada = directorio + "/" + dirAdicional + "/tagIndice" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);
						}

//	ENTREVISTA
						if (ArticuloManager.tieneEntrevista(idArticulo, Contenido.getServletContext())) {
							//detalle
							paginaDinamica = "/articulo/componentes/entrevista.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
							paginaGenerada = directorio + "/" + dirAdicional + "/entrevista" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);

							//tag
							paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=Entrevista";
							paginaGenerada = directorio + "/" + dirAdicional + "/tagEntre" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);
						}

					} else {

//	NOTA DE PRENSA
						if (ArticuloManager.tieneNotaDePrensa(idArticulo, Contenido.getServletContext())) {
							//detalle
							paginaDinamica = "/articulo/componentes/notaPrensa.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
							paginaGenerada = directorio + "/" + dirAdicional + "/notaPrensa" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);

							//tag
							paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=" + URLEncoder.encode("Notas de Prensa", "ISO-8859-1");
							paginaGenerada = directorio + "/" + dirAdicional + "/tagNota" + idArticulo + ".html";

							resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
							generacionOK = (generacionOK && resultado);
						}
					}
					resultado  = generarJSONNVL1(idArticulo);
					generacionOK = (generacionOK && resultado);

					return generacionOK;
			} catch (Exception e) {
			// MailUtil.sendMail(
			//	Globals.MAIL_MAILER,
			//	Globals.MAIL_WEBMASTER,
			//	"Generación de los detalles estáticos.",
			//	"Error en proceso de generacion. " + e.toString());
				
		        TmkLogger.error("GENERACION ARTICULO] error en proceso de generacion " + e.toString());
		        Globals.GENERANDO_DETALLES = false;
		        return false;
		    }
	    }

*/
	  /**
	   * Genera el json que se usa par mostrar la data del GLobo en la mesa
	   * @param idArticulo
	   * @return
	   * @throws Exception
	   */
	public static boolean generarJSONNVL1(Integer idArticulo) throws Exception {
			String directorio = "/articulos";
			String dirAdicional = "" + (int)Math.floor(idArticulo/1000) * 1000;

			String paginaDinamica = "/GetArticuloByIDnvl1?par=" + Math.random() + "&idArticulo=" + idArticulo;
			String paginaGenerada = directorio + "/" + dirAdicional + "/jsonNVL1_" + idArticulo + ".html";

			Boolean resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");

			return resultado;
	}

	public static void generarRanking() {
		boolean huboError = false;
		boolean retorno = false;

	    try {
	    	long tiempoEspera = 1000;

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=1&registroFinal=10"
					, "/ranking/ranking1p1_10.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=11&registroFinal=20"
					, "/ranking/ranking1p11_20.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=21&registroFinal=30"
					, "/ranking/ranking1p21_30.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=31&registroFinal=40"
					, "/ranking/ranking1p31_40.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=41&registroFinal=50"
					, "/ranking/ranking1p41_50.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=51&registroFinal=60"
					, "/ranking/ranking1p51_60.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=61&registroFinal=70"
					, "/ranking/ranking1p61_70.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=71&registroFinal=80"
					, "/ranking/ranking1p71_80.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=81&registroFinal=90"
					, "/ranking/ranking1p81_90.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&registroInicial=91&registroFinal=100"
					, "/ranking/ranking1p91_100.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&nombreGrupo=Ficcion"
					, "/ranking/ranking1Ficcionp1_10.html", "contenidosEstaticos");
	    	huboError = (huboError || !retorno);
	    	Thread.sleep(tiempoEspera);

	    	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&nombreGrupo=" + URLEncoder.encode("No Ficcion", "ISO-8859-1")
					, "/ranking/ranking1No Ficcionp1_10.html", "contenidosEstaticos");
	     	huboError = (huboError || !retorno);
			Thread.sleep(tiempoEspera);

	     	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&nombreGrupo=Infantiles"
						, "/ranking/ranking1Infantilesp1_10.html", "contenidosEstaticos");
	     	huboError = (huboError || !retorno);
			Thread.sleep(tiempoEspera);

	     	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=1&nombreGrupo=Juveniles"
						, "/ranking/ranking1Juvenilesp1_10.html", "contenidosEstaticos");
	     	huboError = (huboError || !retorno);
			Thread.sleep(tiempoEspera);

	     	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=4&registroInicial=1&registroFinal=10"
						, "/ranking/ranking4p1_10.html", "contenidosEstaticos");
	     	huboError = (huboError || !retorno);
			Thread.sleep(tiempoEspera);

			retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=4&registroInicial=11&registroFinal=20"
						, "/ranking/ranking4p11_20.html", "contenidosEstaticos");
	     	huboError = (huboError || !retorno);
			Thread.sleep(tiempoEspera);

	     	retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=5&registroInicial=1&registroFinal=10"
						, "/ranking/ranking5p1_10.html", "contenidosEstaticos");
	     	huboError = (huboError || !retorno);
			Thread.sleep(tiempoEspera);

			retorno = ContenidosEstaticos.crearContenidoEstatico("/ranking/ranking.jsp?idSeccion=5&registroInicial=11&registroFinal=20"
						, "/ranking/ranking5p11_20.html", "contenidosEstaticos");
	     	huboError = (huboError || !retorno);
			Thread.sleep(tiempoEspera);

	        if (huboError) {
			        TmkLogger.debug("Error Ranking");
	             MailUtil.sendMail(
				    Globals.MAIL_MAILER,
					Globals.MAIL_WEBMASTER,
					"Generacion de Ranking.",
					"No se pudieron terminar de generar todos los Ranking. ");
	        }
     } catch (Exception e) {
         TmkLogger.debug("Error Ranking: " + e.toString());
         MailUtil.sendMail(
			    Globals.MAIL_MAILER,
				Globals.MAIL_WEBMASTER,
				"Generacion de Ranking.",
				"No se pudieron terminar de generar todos los Ranking. Error: " + e.toString() + MainHelper.getMessage(e));
		}
	}
		
	public static boolean generarDetalleRediseno(int idArticulo, int idSeccion) {
		
		String directorio = "/articulos";
		String dirAdicional = "" + (int)Math.floor(idArticulo/1000) * 1000;
		String paginaDinamica;
		String paginaGenerada;
		boolean generacionOK = true;
		boolean resultado = true;

		try{
//BORRADO DE TAPAS GENERADAS
			File tapaChica = new File (Contenido.getServletContext().getRealPath("\\tapas\\sitio\\" + idArticulo + "c0.jpg"));
			if(tapaChica.exists()) {
				tapaChica.delete();
				TmkLogger.debug("Borrando TAPA " + tapaChica.getAbsolutePath());
			}

			File tapaGrande = new File (Contenido.getServletContext().getRealPath("\\tapas\\sitio\\" + idArticulo + "g0.jpg"));
			if(tapaGrande.exists()) {
				tapaGrande.delete();
				TmkLogger.debug("Borrando TAPA " + tapaChica.getAbsolutePath());
			}
//BORRADO DE TAPAS GENERADAS

//DETALLE DEL ARTICULO			
	    	//detalle
	    	//paginaDinamica = "/articulo/componentes/detalle.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
			paginaDinamica = "/articulo/componentes/generarDetalleNuevo.jsp?idArticulo=" + idArticulo;
	    	paginaGenerada = directorio + "/" + dirAdicional + "/detalle_" + idArticulo + ".html";

	    	resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
			generacionOK = (generacionOK && resultado);

//TAG
			paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo="  + idArticulo;
	    	paginaGenerada = directorio + "/" + dirAdicional + "/tagDetalle" +  idArticulo + ".html";

	    	resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
			generacionOK = (generacionOK && resultado);

//BIOGRAFIA
			/*if (idSeccion != Globals.SECCION_JUGUETES) {
				int idAutor = ArticuloManager.getAutorConBiografia(idArticulo,(idSeccion == Globals.SECCION_PELICULA)? "('D02', 'E01')":"'A01'",Contenido.getServletContext());

				if (idAutor > -1) {

					//detalle
					paginaDinamica = "/articulo/componentes/biografia.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&idAutor=" + idAutor  + "&generacion=true";
					paginaGenerada = directorio + "/" + dirAdicional + "/biografia" + idArticulo + ".html";

					resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
					generacionOK = (generacionOK && resultado);

					//tag
					paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=Biografia";
					paginaGenerada = directorio + "/" + dirAdicional + "/tagBio" + idArticulo + ".html";

					resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
					generacionOK = (generacionOK && resultado);
				}
			}*/

			/*if (idSeccion == Globals.SECCION_LIBRO) {
//PRIMER CAPITULO
				if (ArticuloManager.tienePrimerCapitulo(idArticulo,Contenido.getServletContext())) {

					//detalle
					paginaDinamica = "/articulo/componentes/primerCapitulo.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
					paginaGenerada = directorio + "/" + dirAdicional + "/primerCapitulo" + idArticulo + ".html";

					resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
					generacionOK = (generacionOK && resultado);

					//tag
					paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=" + URLEncoder.encode("Primer Capitulo","ISO-8859-1");
					paginaGenerada = directorio + "/" + dirAdicional + "/tagCap" + idArticulo + ".html";

					resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
					generacionOK = (generacionOK && resultado);
				}

//INDICE DE CONTENIDOS
					if (ArticuloManager.tieneIndice(idArticulo)) {
						//detalle
						paginaDinamica = "/articulo/componentes/indiceDeContenidos.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
						paginaGenerada = directorio + "/" + dirAdicional + "/indiceDeContenidos" + idArticulo + ".html";

						resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
						generacionOK = (generacionOK && resultado);

						//tag
						paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=" + URLEncoder.encode("Indice de Contenidos ", "ISO-8859-1");
						paginaGenerada = directorio + "/" + dirAdicional + "/tagIndice" + idArticulo + ".html";

						resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
						generacionOK = (generacionOK && resultado);
					}

//ENTREVISTA
					if (ArticuloManager.tieneEntrevista(idArticulo, Contenido.getServletContext())) {
						//detalle
						paginaDinamica = "/articulo/componentes/entrevista.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
						paginaGenerada = directorio + "/" + dirAdicional + "/entrevista" + idArticulo + ".html";

						resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
						generacionOK = (generacionOK && resultado);

						//tag
						paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=Entrevista";
						paginaGenerada = directorio + "/" + dirAdicional + "/tagEntre" + idArticulo + ".html";

						resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
						generacionOK = (generacionOK && resultado);
					}

				} else {

//NOTA DE PRENSA
					if (ArticuloManager.tieneNotaDePrensa(idArticulo, Contenido.getServletContext())) {
						//detalle
						paginaDinamica = "/articulo/componentes/notaPrensa.jsp?idArticulo=" + idArticulo + "&idSeccion=" + idSeccion + "&generacion=true";
						paginaGenerada = directorio + "/" + dirAdicional + "/notaPrensa" + idArticulo + ".html";

						resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
						generacionOK = (generacionOK && resultado);

						//tag
						paginaDinamica = "/articulo/componentes/tag.jsp?idArticulo=" + idArticulo + "&textoSeccion=" + URLEncoder.encode("Notas de Prensa", "ISO-8859-1");
						paginaGenerada = directorio + "/" + dirAdicional + "/tagNota" + idArticulo + ".html";

						resultado  = ContenidosEstaticos.crearContenidoEstatico(paginaDinamica, paginaGenerada, "contenidosEstaticos");
						generacionOK = (generacionOK && resultado);
					}
				}
*/	
//MESA			
				resultado  = generarJSONNVL1(idArticulo);
				generacionOK = (generacionOK && resultado);

			return generacionOK;
		} catch (Exception e) {
	        TmkLogger.error("GENERACION ARTICULO] error en proceso de generacion " + e.toString());
	        Globals.GENERANDO_DETALLES = false;
	        return false;
	    }
    }
}

