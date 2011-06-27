/**
 * $Log: BusquedaGenerica.java,v $
 * Revision 1.12  2009/03/20 18:24:11  msartori
 * - Meta Tags 
 * - Detalle y paginas derivadas 
 * - Buscador 
 *
 * Revision 1.11  2009/02/02 11:50:19  msartori
 * - Cambios Rediseño
 *
 * Revision 1.10  2007/10/18 20:06:58  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.9  2007/09/03 13:42:13  msartori
 * no message
 *
 * Revision 1.8  2007/07/25 20:07:45  omsartori
 * - Nuevo diseño de fidelizacion
 * - Actualizacion de Datos
 *      - Encripcion de codigos
 *
 * Revision 1.7  2007/06/11 18:37:33  omsartori
 * - Log de busquedas
 *
 * Revision 1.6  2007/05/28 19:21:04  omsartori
 * Buscador de inicio para todas las categorias deshabilitado
 * Estadísticas
 *      Se diferencias los resultados de busqueda de la siguiente forma
 *           Consultas correctas
 *           Consultas sin resultado
 *           Consultas timeout (fuera de tiempo)
 *           Consultas con error
 * Se discriminan los resultados de búsqueda por buscador
 * Circuito de prueba, se agregó la tarjeta nro 1234432112344321 como tarjeta de prueba para poder realizar el testeo de compra con tarjeta de crédito completo.
 * Aprobación de órdenes, se agregó un log para contabilizar la aprobación de cada item, para facilitar el seguimiento.
 * Se modificó el proceso de genereación de homes para sincronizar con la nueva versión de la tarea de subida de contenido de eclipse.
 *
 * Revision 1.5  2007/02/02 21:04:55  oLSuarez
 * - Mapa de entrevistas
 * - Mapa de notas de prensa
 * Se agrego linksMapa.jsp
 *
 * Revision 1.4  2007/01/05 18:46:38  oLSuarez
 * Rediseño de verFamilia.jsp
 *     - Creacion de topFamilia.jsp: para el ranking en las paginas de recorrido de flia.
 *     - Creacion del metodo DBUtil.getDescripcionCategoria() : devuelve array con
 * descripcion de grupo, familia y subfamilia.
 *
 * Revision 1.3  2006/12/13 17:16:17  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.2  2005/07/26 14:13:39  omsartori
 * - Modificaciones en Articulo Reducido
 * - Tag de Precio para Articulo
 * - Buscador por id de autor
 * - Buscador generico por atributo principal (DROMO)
 * - Home> Articulo reemplazado por Articulo Reducido
 *
 * Revision 1.1  2005/01/25 15:52:44  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.8  2004/11/03 13:08:03  omsartori
 * - archivos iniciales para Dromo
 * - Eliminación de footer.jsp de los jsp de compra
 *
 * Revision 1.7  2004/05/04 18:11:01  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.6  2004/04/06 22:22:40  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.5  2004/03/25 18:19:51  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.4  2004/03/04 18:52:54  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.3  2004/02/27 13:44:53  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.2  2004/02/11 19:34:27  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.1  2004/01/08 20:30:21  GPistoia
 * - Retoques por release, antes del buscador
 *
 */
package com.tmk.service.buscador;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;

abstract public class BusquedaGenerica {

	protected static int cantidadDeArticulosEncontrados;
	protected static int cantidadDeArticulosMostrados;
	protected static int paginaciones;
	protected static final int ORATIMEOUT = 1013;
	protected static final int SEGUNDOS_TIMEOUT = 45;
	protected static Hashtable<String, InfoBuscador> estadisticasDeBusqueda = new Hashtable<String, InfoBuscador>();
	protected String texto;
	protected Integer seccion;
	protected CriterioDAO criterio;
	protected boolean soloPedidoEspecial;
	protected boolean tenerEnCuentaPedidoEspecial;
	protected List<Integer> items;
	protected boolean consultaExtensa;
	protected boolean timeout;
	protected int tiempoDeEjecucion;
	protected Integer paginaActual;
	protected Integer cantidadDeResultados;
	protected Integer resultadosPorPagina;	
	protected FiltroValor filtroValor = null;
	//private Set<Integer>idsSecciones;
	private int[][] cantPorSecciones;
	private String seccionBuscada;
	
	public BusquedaGenerica(String texto, Integer seccion,
	                   Integer paginaActual, Integer resultadosPorPagina,
	                   CriterioDAO criterio,
	                   boolean soloPedidoEspecial) {
		super();
		this.texto = texto;
		this.seccion = seccion;
		this.criterio = criterio;
		this.paginaActual = paginaActual;
		this.soloPedidoEspecial = soloPedidoEspecial;
		this.tenerEnCuentaPedidoEspecial=true;
		this.resultadosPorPagina = resultadosPorPagina;
		this.cantPorSecciones = new int[1][6];
	}

	/**
	 * Defini como abstract aca, pero en cada Buscador concreto esta desarollado <br> 
	*/
	abstract public StringBuffer getQueryParcial();
	
	abstract public StringBuffer getQueryParcial(Filtro filtro);

	abstract public String getNombreDeBusqueda();
	
	public abstract StringBuffer getQueryFilter(Filtro filtro,String inCondicion);
	
	/***
	 * obtiene el/los id/s dearticulos usados luego para obtener la coleccion de Articulos,  
	 * @return
	 */
	public String getQuery() {
		//para determinar si se aplico un filtro o no
		StringBuffer sql = new StringBuffer();
		if (filtroValor != null) {
			Filtro filtro = BuscadorHelper.filtros[filtroValor.getIdFiltro()];
			sql.append("select a.id_articulo,a.categoria_seccion from ( ");
			sql.append(getQueryParcial(filtro));
			sql.append(" ) a ").append(filtro.getFrom());
			sql.append(" WHERE ").append(filtro.getWhere());
			Iterator<String> claves = filtroValor.getParams().keySet().iterator();
			while (claves.hasNext()) {
				String campo = claves.next();
				sql.append(" and ").append("a.").append(campo).append("='").append(filtroValor.getParams().get(campo)).append("'");
			}
		} else {
		    //sql.append("        select id_articulo, categoria_seccion from ( ");
			sql.append(getQueryParcial().toString());			
			//sql.append("        ) a ");
			//estadistica de paginacion
			if (paginaActual > 1) {
				paginaciones++;
			}
		}
		return sql.toString();

	}
	
	public String getQuery(String[] inCondicion) {
		//para determinar si se aplico un filtro o no
		StringBuffer sql = new StringBuffer();
		if (filtroValor != null) {
			//recorre el array de in para armar el union all
			for(int i=0;i<inCondicion.length;i++) {
				Filtro filtro = BuscadorHelper.filtros[filtroValor.getIdFiltro()];
				sql.append(" SELECT a.id_articulo,a.categoria_seccion from ( ");
				sql.append("    SELECT a.id_articulo ");
				if(!filtro.getId().equals("0")){
					sql.append(",a.categoria_seccion");	
				}
				sql.append(filtro.getSelectInterno());
		        sql.append("    FROM articulos a ");
		        sql.append("	WHERE ");
		        sql.append(		inCondicion[i]);
				sql.append(" ) a ").append(filtro.getFrom());
				sql.append(" WHERE ").append(filtro.getWhere());
				Iterator<String> claves = filtroValor.getParams().keySet().iterator();
				while (claves.hasNext()) {
					String campo = claves.next();
					sql.append(" and ").append("a.").append(campo).append("='").append(filtroValor.getParams().get(campo)).append("'");
				}
				if(i+1<inCondicion.length) {
					sql.append(" UNION ALL ");
				}
			}
		}else if (this.seccionBuscada!=null) {
			for(int i=0;i<inCondicion.length;i++) {
				sql.append(" SELECT a.id_articulo ");
				sql.append(",a.categoria_seccion ");
				sql.append(this.criterio.getAddSelect());
		        sql.append("    FROM articulos a ");
		        sql.append(this.criterio.getAddFrom());
		        sql.append("	WHERE ");
		        sql.append(		inCondicion[i]);
		        if(this.seccionBuscada.equals("0")){
		        	sql.append(" and a.categoria_seccion in(1,3,4,5) ");
		        }else{
		        	sql.append(" and a.categoria_seccion = ");
		        	sql.append(this.seccionBuscada);
		        	sql.append(" ");
		        }
		        sql.append( this.criterio.getAddWhere());
		        //sql.append((criterio == null) ? "" : criterio.getTextoQuery());
				if(i+1<inCondicion.length) {
					sql.append(" UNION ALL ");
				}				
			}	
			sql.append((criterio == null) ? "" : criterio.getTextoQuery());
		}else {
			sql.append("        select id_articulo, categoria_seccion from ( ");
			sql.append(getQueryParcial().toString());			
			sql.append("        ) a ");
			//estadistica de paginacion
			if (paginaActual > 1) {
				paginaciones++;
			}
		}
		//System.out.println(sql.toString());
		return sql.toString();

	}

	/***
	 * arma una query de tipo:
	 * <b>select count(id_articulo) cantidad from ( </b>
	 * <br>
	 * donde luego se le agrega el lo que devuelve getQueryParcial()(definido en el buscador instanciado)
	 * @return query para obtener la cantidad de articulos que hay para 
	 */
	@Deprecated
	public String getQuerySubtotales() {
		StringBuffer sql = new StringBuffer();
		if (filtroValor != null) {
			Filtro filtro = BuscadorHelper.filtros[filtroValor.getIdFiltro()];
			sql.append(Globals.ENTER).append("select count(id_articulo) cantidad from (");
			sql.append(getQueryParcial(filtro));
			sql.append(" ) q").append(filtro.getFrom());
			sql.append(" WHERE ").append(filtro.getWhere());
			Iterator<String> claves = filtroValor.getParams().keySet().iterator();
			while (claves.hasNext()) {
				String campo = claves.next();
				sql.append(" and ").append("q.").append(campo).append("='").append(filtroValor.getParams().get(campo)).append("'");
			}			
		} else {
			sql.append(Globals.ENTER).append("select count(id_articulo) cantidad from (");
			sql.append(getQueryParcial());
			sql.append(" )");
		}

		return sql.toString();
	}
	
	/**
	 * obtiene los ids de articulos (usados en luego para el obtener los articulos en el dbo de articulos)
	 * y los agrega a la variable items
	 */
	public void run() {
		items = new LinkedList<Integer>();

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement statement = conn.createStatement();
				statement.setQueryTimeout(SEGUNDOS_TIMEOUT);
				timeout = false;
				try {
					Calendar cron = Calendar.getInstance();
					ResultSet resultSet = statement.executeQuery(getQuery());
					this.tiempoDeEjecucion = this.tiempoDeEjecucion + new Long((Calendar.getInstance().getTimeInMillis() - cron.getTimeInMillis())/1000).intValue();
					
					try {
						while (resultSet.next()) {
							items.add(new Integer(resultSet.getInt("id_articulo")));
							//acumulo las cantidades por seccion
							this.cantPorSecciones[0][resultSet.getInt("categoria_seccion")]++;
						}
						//agrego los ids de los secciones con orcurrencias
						this.cantPorSecciones[0][0]++;
						addTiempo(this.getNombreDeBusqueda(), tiempoDeEjecucion);
						cantidadDeArticulosMostrados = cantidadDeArticulosMostrados + items.size();
						/*
						 logica del conteo 
						*/
						cantidadDeResultados = items.size();
						cantidadDeArticulosEncontrados = cantidadDeArticulosEncontrados + items.size();
						
						if (items.size() > 0) {
							incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_OK);
						} else {
							incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_SIN_RESULTADO);
						}
						/*fin*/
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				conn.close();
			}
		} catch (SQLException es) {
			if (es.getErrorCode() == ORATIMEOUT) {
				timeout = true;
				incrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_TIMEOUT);
			} else {
				consultaExtensa = true;
				incrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_ERROR);
			}
			decrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_OK);
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda() + " " + es.getMessage() + " consulta: " + getQuery(true));
		} catch (Exception e) {
			consultaExtensa = true;
			incrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_ERROR);
			decrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_OK);
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda() + " " + e.getMessage() + " consulta: " + getQuery(true));
		}
		if(timeout || consultaExtensa) {
			cantidadDeResultados = 0;
		}
	}

	public void run(String[] inCondicion) {
		items = new LinkedList<Integer>();

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement statement = conn.createStatement();
				statement.setQueryTimeout(SEGUNDOS_TIMEOUT);
				timeout = false;
				try {
					Calendar cron = Calendar.getInstance();
					ResultSet resultSet = statement.executeQuery(getQuery(inCondicion));
					this.tiempoDeEjecucion = this.tiempoDeEjecucion + new Long((Calendar.getInstance().getTimeInMillis() - cron.getTimeInMillis())/1000).intValue();
					
					try {
						while (resultSet.next()) {
							//acumulo las cantidades por seccion
							items.add(new Integer(resultSet.getInt("id_articulo")));
							this.cantPorSecciones[0][resultSet.getInt("categoria_seccion")]++;
						}
						//System.out.println("Busqueda...");
						//agrego los ids de los secciones con orcurrencias
						this.cantPorSecciones[0][0]++;
						addTiempo(this.getNombreDeBusqueda(), tiempoDeEjecucion);
						cantidadDeArticulosMostrados = cantidadDeArticulosMostrados + items.size();
						/*
						 logica del conteo 
						*/
						cantidadDeResultados = items.size();
						cantidadDeArticulosEncontrados = cantidadDeArticulosEncontrados + items.size();
						
						if (items.size() > 0) {
							incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_OK);
						} else {
							incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_SIN_RESULTADO);
						}
						/*fin*/
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				conn.close();
			}
		} catch (SQLException es) {
			if (es.getErrorCode() == ORATIMEOUT) {
				timeout = true;
				incrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_TIMEOUT);
			} else {
				consultaExtensa = true;
				incrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_ERROR);
			}
			decrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_OK);
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda() + " " + es.getMessage() + " consulta: " + getQuery(true));
		} catch (Exception e) {
			consultaExtensa = true;
			incrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_ERROR);
			decrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_OK);
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda() + " " + e.getMessage() + " consulta: " + getQuery(true));
		}
		if(timeout || consultaExtensa) {
			cantidadDeResultados = 0;
		}
	}
	/***
	 * Obtiene cuantos resultados tiene para una busqueda concreta
	 */
	@Deprecated
	public void runQuerySubtotales() {

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement statement = conn.createStatement();
				statement.setQueryTimeout(SEGUNDOS_TIMEOUT);
				timeout = false;
				try {
					Calendar cron = Calendar.getInstance();
					ResultSet resultSet = statement.executeQuery(getQuerySubtotales());
					this.tiempoDeEjecucion = new Long((Calendar.getInstance().getTimeInMillis() - cron.getTimeInMillis())/1000).intValue();
					try {
						int total = 0;
						if (resultSet.next()) {
							total = resultSet.getInt("cantidad");
						}
						cantidadDeResultados = total;
						cantidadDeArticulosEncontrados = cantidadDeArticulosEncontrados + total;
						
						if (total > 0) {
							incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_OK);
						} else {
							incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_SIN_RESULTADO);
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
		} catch (SQLException es) {
			if (es.getErrorCode() == ORATIMEOUT) {
				timeout = true;
				incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_TIMEOUT);
			} else {
				consultaExtensa = true;
				incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_ERROR);
			}
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda() + " " + es.getMessage() + " consulta: " + getQuerySubtotales(true));
		}
		catch (Exception e) {
			consultaExtensa = true;
			incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_ERROR);
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda()  + " " + e.getMessage() + " consulta: " + getQuerySubtotales(true));
		}
	}

	/***
	 * obtiene para un filtro dado por categoria_grupo, categoria_seccion cual es y cuantos hay
	 * ej: en una busqueda en libros por titulo 
	 * @param objeto Filtro
	 * @return
	 */
	public List<ItemFiltro> runFilter(Filtro filtro,String inCondiion) {
		List<ItemFiltro> itemsFiltro = new LinkedList<ItemFiltro>();
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement statement = conn.createStatement();
				statement.setQueryTimeout(SEGUNDOS_TIMEOUT);
				try {
					ResultSet resultSet = statement.executeQuery(getQryFilter(filtro,inCondiion));
					
					try {
						while (resultSet.next()) {
							ItemFiltro itemFiltro = new ItemFiltro(resultSet.getString("descripcion"),
									resultSet.getInt("cantidad"));
							ResultSetMetaData rsMD = resultSet.getMetaData();
							for (int i=3; i<=rsMD.getColumnCount(); i++) {
								itemFiltro.addParam("FIL" + filtro.getId() + "_"  + rsMD.getColumnName(i), resultSet.getObject(i).toString());
								//itemFiltro.addParam("CANT_CON_FILTRO", ""+itemFiltro.getCantidad());
								//itemFiltro.addParam("FIN_FILTRO","true");
							}
							itemsFiltro.add(itemFiltro);
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
			TmkLogger.error("Error en Busqueda FILTRO " + getNombreDeBusqueda() + " " + e.getMessage());
		}
		return itemsFiltro;
	}
	
	/***
	 * obtiene las agrupaciones de los resultados
	 * @param filtro
	 * @param inCondiion
	 * @return
	 */
	public List<ItemFiltro> runFilter(Filtro filtro,String[] inCondiion) {
		List<ItemFiltro> itemsFiltro = new LinkedList<ItemFiltro>();
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement statement = conn.createStatement();
				statement.setQueryTimeout(SEGUNDOS_TIMEOUT);
				try {
					ResultSet resultSet = statement.executeQuery(getQryFilter(filtro,inCondiion));
					
					try {
						while (resultSet.next()) {
							ItemFiltro itemFiltro = new ItemFiltro(resultSet.getString("descripcion"),
									resultSet.getInt("cantidad"));
							ResultSetMetaData rsMD = resultSet.getMetaData();
							for (int i=3; i<=rsMD.getColumnCount(); i++) {
								itemFiltro.addParam("FIL" + filtro.getId() + "_"  + rsMD.getColumnName(i), resultSet.getObject(i).toString());
								//itemFiltro.addParam("CANT_CON_FILTRO", ""+itemFiltro.getCantidad());
								//itemFiltro.addParam("FIN_FILTRO","true");
							}
							itemsFiltro.add(itemFiltro);
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
			TmkLogger.error("Error en Busqueda FILTRO " + getNombreDeBusqueda() + " " + e.getMessage());
		}
		return itemsFiltro;
	}
	/**
	 * obtiene para una agrupacion cuantos hay ej:<br>
	 *	<pre>
	 *		CANTIDAD	AUXVARCHAR03	DESCRIPCION
	 * 		5			BC				Rustica
	 * 		5			BB				tapa dura
	 * </pre>
	 */
	public String getQryFilter(Filtro filtro,String inCondicion) {
		StringBuffer sql = new StringBuffer();
		
		if(this.getNombreDeBusqueda().equals("Inicio") ){
			sql.append("select count(id_articulo) cantidad").append(filtro.getSelect());
			if(!filtro.getId().equals("0"))
				sql.append (", categoria_seccion ");
			sql.append(" from (");
			sql.append("        select a.* ").append(filtro.getSelectIntermedio()).append(" from (");
			sql.append(getQueryFilter(filtro,inCondicion).toString());
			sql.append("        ) a ").append(filtro.getFrom());
			sql.append(" 		where ").append(filtro.getWhere());
			sql.append("    ) ").append(filtro.getGroupBy());
			sql.append(", categoria_seccion");						
			sql.append(" order by ");					
			sql.append(" categoria_seccion, ");				
			sql.append(filtro.getOrderBy());
			
			//System.out.println(sql.toString());
		}else {
			sql.append("select count(id_articulo) cantidad").append(filtro.getSelect());
			sql.append(" from (");
			sql.append("        select a.* ").append(filtro.getSelectIntermedio()).append(" from (");
			//sql.append(getQueryParcial(filtro).toString());
			sql.append(getQueryFilter(filtro,inCondicion).toString());
			sql.append("        ) a ").append(filtro.getFrom());
			sql.append(" 		where ").append(filtro.getWhere());
			sql.append("    ) ").append(filtro.getGroupBy());
			sql.append(" order by ");			
			sql.append(filtro.getOrderBy());			
			//System.out.println(sql.toString());
		}
		return sql.toString();
	}
	
	public String getQryFilter(Filtro filtro,String[] inCondicion) {
		StringBuffer sql = new StringBuffer();
		
		if(this.getNombreDeBusqueda().equals("Inicio") ){
				sql.append("select count(id_articulo) cantidad").append(filtro.getSelect());
				if(!filtro.getId().equals("0"))
					sql.append (", categoria_seccion ");
				sql.append(" from (");
				sql.append("        select a.* ").append(filtro.getSelectIntermedio()).append(" from (");
				for(int i=0;i<inCondicion.length;i++) {
					sql.append(getQueryFilter(filtro,inCondicion[i]).toString());
					if(i+1<inCondicion.length)
						sql.append(" UNION ALL ");
				}
				sql.append("        ) a ").append(filtro.getFrom());
				sql.append(" 		where ").append(filtro.getWhere());
				sql.append("    ) ").append(filtro.getGroupBy());
				sql.append(", categoria_seccion");						
				sql.append(" order by ");					
				sql.append(" categoria_seccion, ");				
				sql.append(filtro.getOrderBy());						
		}else {			
				sql.append("select count(id_articulo) cantidad").append(filtro.getSelect());
				sql.append(" from (");
				sql.append("        select a.* ").append(filtro.getSelectIntermedio()).append(" from (");
				for(int i=0;i<inCondicion.length;i++) {
					sql.append(getQueryFilter(filtro,inCondicion[i]).toString());
					if(i+1<inCondicion.length)
						sql.append(" union all ");
				}
				sql.append("        ) a ").append(filtro.getFrom());
				sql.append(" 		where ").append(filtro.getWhere());
				sql.append("    )").append(filtro.getGroupBy());
				sql.append(" order by ");			
				sql.append(filtro.getOrderBy());				
		}
		//System.out.println(sql.toString());
		return sql.toString();		
	}
	
	public boolean esConsultaExtensa() {
		return consultaExtensa;
	}

	public boolean timeOut() {
		return timeout;
	}

	private InfoBuscador getInfoBuscador (String nombre) {
		synchronized (estadisticasDeBusqueda) {
			InfoBuscador infoBuscador = (InfoBuscador)estadisticasDeBusqueda.get(nombre);
			return (infoBuscador != null) ? infoBuscador:new InfoBuscador(nombre);
		}
	}

	private void setInfoBuscador (InfoBuscador infoBuscador) {
		synchronized (estadisticasDeBusqueda) {
			estadisticasDeBusqueda.put(infoBuscador.getNombre(), infoBuscador);
		}
	}

	private void incrementaConsulta(String nombre, int consulta) {
		InfoBuscador infoBuscador = getInfoBuscador(nombre);
		infoBuscador.sumCantidadConsulta(consulta);
		setInfoBuscador (infoBuscador);
	}

	private void decrementaConsulta(String nombre, int consulta) {
		InfoBuscador infoBuscador = getInfoBuscador(nombre);
		infoBuscador.resCantidadConsulta(consulta);
		setInfoBuscador (infoBuscador);
	}

	public static int getTotalConsulta(int consulta) {
		int total = 0;
		Enumeration<String> keys = estadisticasDeBusqueda.keys();

		while (keys.hasMoreElements()) {
			Object nombre = keys.nextElement();
			InfoBuscador infoBuscador = (InfoBuscador)estadisticasDeBusqueda.get(nombre);
			if (consulta < 0) {
				total += infoBuscador.getTotal();
			} else {
				total += infoBuscador.getCantidadConsulta(consulta);
			}
		}
		return total;
	}

	public static int[] getTiempos(String nombreBuscador) {
		int []retorno =  new int[(BusquedaGenerica.SEGUNDOS_TIMEOUT * Globals.SECCIONES.length) + 1];
		Enumeration<String> keys = estadisticasDeBusqueda.keys();
		while (keys.hasMoreElements()) {
			Object nombre = keys.nextElement();
			if (nombreBuscador == null || nombre.equals(nombreBuscador)) {
				InfoBuscador infoBuscador = (InfoBuscador)estadisticasDeBusqueda.get(nombre);
				for (int i=0; i< infoBuscador.getConsultasXTiempo().length; i++) {
					retorno [i] = retorno [i] + infoBuscador.getConsultasXTiempo()[i];
				}
			}
			if (nombre.equals(nombreBuscador)) {
				return retorno;
			}
		}
		return retorno;
	}

	public static int getPaginaciones() {
		return paginaciones;
	}

	public String getQuery(boolean sen) {
			return getQuery();
	}

	public String getQuerySubtotales(boolean sen) {
			return  getQuerySubtotales();
	}


	private void addTiempo(String nombre, int tiempo) {
		InfoBuscador infoBuscador = getInfoBuscador(nombre);
		infoBuscador.setTiempo(tiempo);
		setInfoBuscador (infoBuscador);
	}
	
	public Integer getCantidadDeResultados() {
		return cantidadDeResultados;
	}
	
	public void setCantidadDeResultados(int cantidadDeResultados) {
		this.cantidadDeResultados = cantidadDeResultados;
	}
	public Integer getResultadosPorPagina() {
		return resultadosPorPagina;
	}
				
	public void setFiltroValor(FiltroValor filtroValor) {
		this.filtroValor = filtroValor;
	}
	
	/*public Set<Integer> getSeccionesCargadas() {
		return this.idsSecciones;
	}*/
	
	public String toString() {
		StringBuffer result = new StringBuffer("Busqueda ").append(getNombreDeBusqueda());
		if (texto != null) result.append(", Texto: ").append('\'').append(texto).append('\'');
		if (seccion != null) result.append(", Seccion: ").append(Globals.seccion(seccion.intValue()));
		result.append(", Pagina: " + paginaActual);
		if (soloPedidoEspecial) result.append(", Solo Pedido especial");
		if (criterio != null) result.append(", ").append(criterio);
		return result.toString();
	}


	public StringBuffer salto() {
		StringBuffer buffer = new StringBuffer();
		if (seccion != null) parametro(buffer, BuscadorHelper.CATEGORIA_SECCION, seccion);
		if (seccion != null) parametro(buffer, "idSeccion", seccion);
		if (soloPedidoEspecial) parametro(buffer, BuscadorHelper.PEDIDO_ESPECIAL, new Boolean(soloPedidoEspecial));
		if (criterio != null) {
			parametro(buffer, BuscadorHelper.CRITERIO_ORDEN, criterio.getClave());
		}
		return new StringBuffer(BuscadorHelper.PAGINA_BUSCADOR).append("?").append(buffer);
	}
	public StringBuffer parametro(StringBuffer resultado, String nombreParam, Object valorParam) {
		if (Convert.toString(valorParam, null) != null) {
			resultado.append((resultado.length() == 0) ? "" : "&");
			try {
			resultado.append(nombreParam).append("=").append(URLEncoder.encode(valorParam.toString(), "ISO-8859-1"));
			} catch (java.io.UnsupportedEncodingException e) {
				resultado.append(nombreParam).append("=").append(Convert.encodeHTML(valorParam.toString()));
			}
		}
		return resultado;
	}

	public static Hashtable<String, InfoBuscador> getEstadisticasDeBusqueda() {
		return estadisticasDeBusqueda;
	}

	public static int cantidadDeArticulosEncontrados() {
		return cantidadDeArticulosEncontrados;
	}

	public static int cantidadDeArticulosMostrados() {
		return cantidadDeArticulosMostrados;
	}

	public String getTexto() {
		// El texto a buscar sin algunas busquedas conflictivas
		return (texto == null) ? null : texto.replaceAll("'", "''").replaceAll("\\.", " ");
	}

	public String getTextoOriginal() {
		return texto;
	}

	public void setTextoOriginal(String texto) {
		this.texto = texto;
	}

	public boolean tieneCategoriaSeccion() {
		return (seccion != null) && (seccion.intValue() != Globals.SECCION_HOME);
	}

	public Integer getSeccion() {
		return seccion;
	}

	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}

	public CriterioDAO getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioDAO criterio) {
		this.criterio = criterio;
	}

	public void setPedidoEspecial(boolean soloPedidoEspecial) {
		this.soloPedidoEspecial = soloPedidoEspecial;
	}

	public void setTenerEnCuentaPedidoEspecial(boolean tenerEnCuenta){
		this.tenerEnCuentaPedidoEspecial = tenerEnCuenta;
	}

	public boolean esTenerEnCuentaPedidoEspecial(){
		return tenerEnCuentaPedidoEspecial;
	}

	public boolean esPedidoEspecial() {
		return soloPedidoEspecial;
	}

	public char pedidoEspecial() {
		return esPedidoEspecial() ? 'S' : 'N';
	}

	public Integer cantidadDeFilasAMostrar() {
		return new Integer(10); // para casi todos los casos esta bien con este valor
	}

	public List<Integer> getItems() {
		return items;
	}

	
	public void setItems(List<Integer> items) {
		this.items = items;
	}

	public int[][] getCantPorSecciones() {
		return cantPorSecciones;
	}

	public void setCantPorSecciones(int[][] cantPorSecciones) {
		this.cantPorSecciones = cantPorSecciones;
	}

	public String getSeccionBuscada() {
		return seccionBuscada;
	}

	public void setSeccionBuscada(String seccionBuscada) {
		this.seccionBuscada = seccionBuscada;
	}	
	
}

