/**
 * $Log: BusquedaPorTitulo.java,v $
 * Revision 1.4  2007/05/09 18:18:01  omsartori
 * * Busqueda de Inicio: Al aplicar un criterio de ordenamiento se mantiene la apertura de busquedas por sección, en la versión anterior la busqueda se acotaba a la última sección mostrada.
 * * Aprobación de Ordenes Intranet: Se agrego un chequeo para evitar la doble aprobación desde la intranet que genera movimientos duplicados en central.
 * * Validación de Formularios: Se agrego el foco de retorno en la validación de los siguientes formularios
 *                                             Carga de Comentarios
 *                                             Alta de Alianzas
 * * Orden de Autores: Se modificaron todas las consultas para mostrar en Tematika el mismo orden de autores que viene dado por comercial. (Se regenerarán los articulos involucrados luego de la implementación en productivo)
 * * Carrito de Compras: Se activo nuevamente el carrito de compras con tecnología ajax, que cambia de color cuando se agrega un artículo y evita la necesidad de recargar la página.
 * * Seguimiento de sesiones: Se corrigio la fecha de creación, ahora se toma la fecha dada por el servidor de aplicación para evitar diferencias con la fecha de base de datos.
 * * Directorio de acceso a intranet: Se modificó el directorio de acceso a intranet por requerimiento de seguridad junto con sus respectivos links, el directorio actual es /236-TMK
 *
 * Revision 1.3  2006/09/28 14:58:17  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.2  2005/09/15 19:19:28  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/01/25 15:52:55  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.3  2004/11/18 16:10:59  oGPistoia
 * - Nuevo buscador por distintos ID de productos
 *
 * Revision 1.2  2004/05/04 18:11:04  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.1  2004/02/11 19:34:30  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorTitulo extends BusquedaGenerica {

    public BusquedaPorTitulo(String texto, Integer seccion,
                       Integer paginaActual, Integer resultadosPorPagina,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, paginaActual, resultadosPorPagina, criterio, soloPedidoEspecial);
    }

    /**
     *  Obtiene 
     *  <pre>
     *  id_articulo | 	orden
     *  xxxxx		123
     * 		
     */
	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();
		
		sql.append("    SELECT  a.id_articulo,a.categoria_seccion ");
        sql.append("      " + criterio.getAddSelect());
        sql.append("    FROM disponibilidades d,");
        sql.append("        articulos a");
		sql.append("      " + criterio.getAddFrom());
        sql.append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append("        AND d.id_esquema = 'PROD'");
        sql.append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append("        AND habilitado_tematika = 'S'");
		sql.append("        AND a.activo            = 'SI'");
        sql.append("        AND catsearch (a.titulo, '").append(getTexto()).append("*', ").append("'categoria_seccion = ").append(getSeccion()).append(" and activo = ''SI''') > 0");
		sql.append("      " + criterio.getAddWhere());
        sql.append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());
		return sql;
	}

	/***
	 * usando el select interno del filtro Obtiene:
	 * <pre>
	 * id_articulo	id_editor
	 * </pre>
	 */
	public StringBuffer getQueryParcial(Filtro filtro) {
		StringBuffer sql = new StringBuffer();

		sql.append("    SELECT  a.id_articulo");
		if(!filtro.getId().equals("0")){
			sql.append(",a.categoria_seccion");	
		}
        sql.append(filtro.getSelectInterno());
        sql.append("    FROM disponibilidades d,");
        sql.append("        articulos a");
        //sql.append(filtro.getFrom());
		sql.append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append("        AND d.id_esquema = 'PROD'");
        sql.append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append("        AND habilitado_tematika = 'S'");
		sql.append("        AND a.activo            = 'SI'");
        sql.append("        AND catsearch (a.titulo, '").append(getTexto()).append("*', ").append("'categoria_seccion = ").append(getSeccion()).append(" and activo = ''SI''') > 0 ");
        /*sql.append(" and ");
        sql.append(filtro.getWhere());*/
        
		
		return sql;
	}

	
	@Deprecated
	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_TITULO);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Título";
	}

	public StringBuffer getQueryFilter(Filtro filtro,String in) {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    SELECT a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("    FROM articulos a ");
        sql.append(Globals.ENTER).append(		  filtro.getFrom());
		sql.append(Globals.ENTER).append("    WHERE ");
        sql.append(Globals.ENTER).append("        a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(" AND ");
        sql.append(" ( ");
		sql.append(in);
		sql.append(" ) ");
        sql.append(" AND");
        sql.append(filtro.getWhere());
        //agregado para isbn
        
        sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("  	 SELECT a.id_articulo");
        sql.append(Globals.ENTER).append(			 filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("           FROM articulos a ");
		sql.append(Globals.ENTER).append(			filtro.getFrom());
		sql.append(Globals.ENTER).append("          WHERE ");
		sql.append(" ( ");
		sql.append(in);
		sql.append(" ) ");
		sql.append(" and ").append(filtro.getWhere());
		sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("  	 SELECT  a.id_articulo");
        sql.append(Globals.ENTER).append(		 	filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("		 FROM articulos a");
        sql.append(Globals.ENTER).append(		 	filtro.getFrom());        
        sql.append(Globals.ENTER).append("		 WHERE");
        sql.append(" ( ");
		sql.append(in);
		sql.append(" ) ");
        sql.append(" and ").append(filtro.getWhere());
    	/*sinopsis*/
    	sql.append(Globals.ENTER).append("    UNION");
    	sql.append(Globals.ENTER).append("    SELECT  a.id_articulo");
		sql.append(Globals.ENTER).append(	  filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("    FROM articulos a ");
		sql.append(Globals.ENTER).append(		  filtro.getFrom());
		sql.append(Globals.ENTER).append("    WHERE ");
		sql.append(" ( ");
		sql.append(in);
		sql.append(" ) ");
        sql.append("and ").append(filtro.getWhere());
		/*sinopsis*/
        return sql;
	}

}
