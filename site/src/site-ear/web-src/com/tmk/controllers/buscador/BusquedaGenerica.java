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
package com.tmk.controllers.buscador;

import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Globals;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;


import java.util.Calendar;
import java.util.Vector;
import java.util.Date;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.net.URLEncoder;
import java.util.Enumeration;

abstract public class BusquedaGenerica {

	protected static int cantidadDeArticulosEncontrados;
	protected static int cantidadDeArticulosMostrados;
	protected static int paginaciones;
	protected static final int ORATIMEOUT = 1013;
	protected static final int SEGUNDOS_TIMEOUT = 45;

	protected static Hashtable estadisticasDeBusqueda = new Hashtable();

	protected String texto;
	protected Integer seccion;
	protected Integer registroInicial;
	protected Integer registroFinal;
	protected CriterioDAO criterio;
	protected boolean soloPedidoEspecial;
	protected boolean tenerEnCuentaPedidoEspecial;

	protected Vector items;

	protected int subtotales[];

	protected boolean consultaExtensa;
	protected boolean timeout;

	protected Date fechaInicioConsulta;
	protected Date fechaFinConsulta;

	protected int tiempoDeEjecucion;

	static BusquedaLogger busquedaLoggerError;
	static BusquedaLogger busquedaLoggerTimeout;

	//private static Vector palabrasNoEncontradas = new Vector();


	static {
			try {
				busquedaLoggerError = new BusquedaLogger("LogError.txt");
				busquedaLoggerTimeout = new BusquedaLogger("LogTimeout.txt");
			} catch (Exception e) {
				TmkLogger.error(e.toString() + MainHelper.getMessage(e));
			}
	};

	public BusquedaGenerica(String texto, Integer seccion,
	                   Integer registroInicial, Integer registroFinal,
	                   CriterioDAO criterio,
	                   boolean soloPedidoEspecial) {
		super();
		this.texto = texto;
		this.seccion = seccion;
		this.criterio = criterio;
		this.registroInicial = registroInicial;
		this.registroFinal = registroFinal;
		this.soloPedidoEspecial = soloPedidoEspecial;
		this.tenerEnCuentaPedidoEspecial=true;
		this.subtotales = new int[Globals.SECCIONES.length];
	}


	public BusquedaGenerica(String texto, Integer seccion,
            Integer registroInicial, Integer registroFinal,
            CriterioDAO criterio) {
		super();
		this.texto = texto;
		this.seccion = seccion;
		this.criterio = criterio;
		this.registroInicial = registroInicial;
		this.registroFinal = registroFinal;
		this.tenerEnCuentaPedidoEspecial = false;
		this.subtotales = new int[Globals.SECCIONES.length];
	}

	public static Hashtable getEstadisticasDeBusqueda() {
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

	public Vector getItems() {
		return items;
	}

	public int[] subtotales() {
		return subtotales;
	}

	public int total() {
		int result = 0;
		for (int i = 0; i < subtotales.length; i++) {
			result += subtotales[i];
		}
		return result;
	}

	public String getQuerySubtotales() {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("select categoria_seccion seccion, count(*) cantidad from (");
		sql.append(getQueryParcial());
		sql.append(" ) group by categoria_seccion");

		return sql.toString();
	}

	abstract public StringBuffer getQueryParcial();

	public String getQuery() {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("    select * from (");

		sql.append(Globals.ENTER).append("        select q.*, rownum fila from (");

		sql.append(getQueryParcial().toString());

		sql.append(Globals.ENTER).append("        ) q ");

		int inicio = (registroInicial == null) ? 1 : registroInicial.intValue();
		int fin = (registroFinal == null) ? cantidadDeFilasAMostrar().intValue() : registroFinal.intValue();

		sql.append(Globals.ENTER).append("    ) where fila >= ").append(inicio).append(" and fila <= ").append(fin);

		//estadistica de paginacion
		if (inicio > 1) {
			paginaciones++;
		}
		return sql.toString();

	}

	abstract public String getNombreDeBusqueda();

	public String toString() {
		StringBuffer result = new StringBuffer("Busqueda ").append(getNombreDeBusqueda());
		if (texto != null) result.append(", Texto: ").append('\'').append(texto).append('\'');
		if (seccion != null) result.append(", Seccion: ").append(Globals.seccion(seccion.intValue()));
		if (registroInicial != null) result.append(", Inicio: ").append(registroInicial);
		if (registroFinal != null) result.append(", Final: ").append(registroFinal);
		if (soloPedidoEspecial) result.append(", Solo Pedido especial");
		if (criterio != null) result.append(", ").append(criterio);
		return result.toString();
	}

	public double tiempoUtilizado() {
		return ((fechaInicioConsulta == null) || (fechaFinConsulta == null))
		        ? 0
		        : Convert.round((fechaFinConsulta.getTime() - fechaInicioConsulta.getTime()) / 1000);
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

	public void run()  {
		items = new Vector();

		fechaInicioConsulta = new Date();

		fechaFinConsulta = fechaInicioConsulta;

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
					/**/
					boolean restanSecciones = false;
					for (int i=seccion.intValue()+1; i<subtotales.length; i++) {
						if (subtotales[i] > 0) {
							restanSecciones = true;
						}
					}
					if (!restanSecciones) {
						addTiempo(this.getNombreDeBusqueda(), tiempoDeEjecucion);
					}
					/**/
					try {
						while (resultSet.next()) {
							items.add(new Integer(resultSet.getInt(1)));
						}
						cantidadDeArticulosMostrados = cantidadDeArticulosMostrados + items.size();
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
				 addLog(getNombreDeBusqueda() + "|" + es.getMessage(), getQuery(), false);
			} else {
				consultaExtensa = true;
				incrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_ERROR);
				addLog(getNombreDeBusqueda() + "|" + es.getMessage(), getQuery(), true);
			}
			decrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_OK);
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda() + " " + es.getMessage() + " consulta: " + getQuerySubtotales(true));

		} catch (Exception e) {
			consultaExtensa = true;
			incrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_ERROR);
			decrementaConsulta(getNombreDeBusqueda(), InfoBuscador.CONSULTAS_OK);
			addLog(getNombreDeBusqueda() + "|" + e.getMessage(), getQuery(), true);
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda() + " " + e.getMessage() + " consulta: " + getQuerySubtotales(true));
		}
		fechaFinConsulta = new Date();
	}

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
						while (resultSet.next()) {
							if (Globals.seccionHabilitada(resultSet.getInt("seccion"))) {
								int cantidad = resultSet.getInt("cantidad");
								total += cantidad;
								subtotales[resultSet.getInt("seccion")] = cantidad;
								cantidadDeArticulosEncontrados = cantidadDeArticulosEncontrados + cantidad;
							}
						}

						if (total > 0) {
							incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_OK);
						} else {
							incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_SIN_RESULTADO);
							//**//
							/*palabrasNoEncontradas.add(getNombreDeBusqueda());
							palabrasNoEncontradas.add(getTexto());*/
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
				addLog(getNombreDeBusqueda() + "|" + es.getMessage(), getQuerySubtotales(), false);
			} else {
				consultaExtensa = true;
				incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_ERROR);
				addLog(getNombreDeBusqueda() + "|" + es.getMessage(), getQuerySubtotales(), true);
			}
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda() + " " + es.getMessage() + " consulta: " + getQuerySubtotales(true));
		}
		catch (Exception e) {
			consultaExtensa = true;
			incrementaConsulta(getNombreDeBusqueda(),InfoBuscador.CONSULTAS_ERROR);
			addLog(getNombreDeBusqueda() + "|" + e.getMessage(), getQuerySubtotales(), true);
			TmkLogger.error("Error en Busqueda " + getNombreDeBusqueda()  + " " + e.getMessage() + " consulta: " + getQuerySubtotales(true));
		}
	}

	public boolean esConsultaExtensa() {
		return consultaExtensa;
	}

	public Integer getRegistroInicial() {
		return registroInicial;
	}

	public void setRegistroInicial(Integer registroInicial) {
		this.registroInicial = registroInicial;
	}

	public Integer getRegistroFinal() {
		return registroFinal;
	}

	public void setRegistroFinal(Integer registroFinal) {
		this.registroFinal = registroFinal;
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
		Enumeration keys = estadisticasDeBusqueda.keys();

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
		Enumeration keys = estadisticasDeBusqueda.keys();
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

	public static void addLog(String error, String qry, boolean esError) {
		if (((Boolean)Globals.procesosBackground.get("LogBusquedas")).booleanValue()) {
			if (esError) {
				busquedaLoggerError.add(error, qry);
			} else {
				busquedaLoggerTimeout.add(error, qry);
			}
		}
	}

	public String getQuery(boolean sen) {
		if (((Boolean)Globals.procesosBackground.get("LogBusquedas")).booleanValue()) {
			return "";
		} else {
			return getQuery();
		}
	}

	public String getQuerySubtotales(boolean sen) {
		if (((Boolean)Globals.procesosBackground.get("LogBusquedas")).booleanValue()) {
			return "";
		} else {
			return  getQuerySubtotales();
		}
	}


	private void addTiempo(String nombre, int tiempo) {
		InfoBuscador infoBuscador = getInfoBuscador(nombre);
		infoBuscador.setTiempo(tiempo);
		setInfoBuscador (infoBuscador);
	}

	/*public static Vector getPalabrasNoEncontradas() {
		return palabrasNoEncontradas;
	}*/
}

