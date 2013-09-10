/**
 * $Log: BusquedaPorAutor.java,v $
 * Revision 1.9  2007/07/11 15:00:52  omsartori
 * - Busqueda Logger
 * - Cambio de estandar html
 * - PopUp registracion
 * - Rearmado de ajax de carrito de compras
 * - Pop Up carrito de compras
 *
 * Revision 1.8  2007/06/11 18:37:34  omsartori
 * - Log de busquedas
 *
 * Revision 1.7  2007/03/29 17:36:28  omsartori
 * - Medidas para productos
 * - Mejora de tiempos en busqueda de autor (modificacion de qry)
 *
 * Revision 1.6  2007/03/19 14:22:18  omsartori
 * - Generador de arbol de categorias
 * - Atributo peso agregado para detalle de libros y derivados
 * - Buscador avanzado
 * 	* Las búsquedas se disparan presionando la tecla Enter en cualquier campo
 * 	* Se unificó el atributo soporte con el que se utiliza para el detalle en articulos de la seccion musica
 * - Paginas de institucionales
 * - Se agregó retorno de carro a los textos de reseña
 *
 * Revision 1.5  2007/02/16 18:41:02  omsartori
 * - schedule de generacion de ranking y top de familias
 * - correccion bug paginacion de lista de deseos
 * - filtro de palabras para buscador
 * - estadisticas de homes, biografias e indices
 * - correccion de bug de aprobacion de comentarios
 *
 * Revision 1.4  2007/02/02 21:04:56  oLSuarez
 * - Mapa de entrevistas
 * - Mapa de notas de prensa
 * Se agrego linksMapa.jsp
 *
 * Revision 1.3  2006/09/28 14:58:15  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.2  2005/09/15 19:19:24  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/01/25 15:52:47  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.3  2004/05/04 18:11:02  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.2  2004/03/04 18:52:55  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.1  2004/02/11 19:34:28  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorAutor extends BusquedaGenerica {

    public BusquedaPorAutor(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
    }

    
	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();
		//sql.append(Globals.ENTER).append("     SELECT /*+ INDEX(aa borrame) use_nl (au aa a d)*/");
		sql.append(Globals.ENTER).append("     SELECT /*+ use_nl (au aa a d)*/");
		sql.append(Globals.ENTER).append("  	 	 distinct ");
		sql.append(Globals.ENTER).append("     		 a.id_articulo,a.categoria_seccion");
        sql.append(Globals.ENTER).append("           " + criterio.getAddSelect());
		sql.append(Globals.ENTER).append("  	 FROM autores au INNER JOIN articulos_autores aa");
		sql.append(Globals.ENTER).append("  	      ON au.id_autor = aa.id_autor");
		sql.append(Globals.ENTER).append("    		  INNER JOIN articulos a ON aa.id_articulo = a.id_articulo");
		//sql.append(Globals.ENTER).append("  	 	  INNER JOIN disponibilidades d");
		//sql.append(Globals.ENTER).append("  	 	  ON a.id_disponibilidad = d.id_disponibilidad");
		sql.append(Globals.ENTER).append("           " + criterio.getAddFromJoin());
		// sql.append(Globals.ENTER).append("  	WHERE d.pedido_especial = '").append(pedidoEspecial()).append("'");
		// sql.append(Globals.ENTER).append("  	  AND d.id_esquema = 'PROD' ");
		sql.append(Globals.ENTER).append("  	  WHERE a.categoria_seccion  ").append((tieneCategoriaSeccion() ? ("+0= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("  	  AND a.habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        AND a.activo            = 'SI'");
		sql.append(Globals.ENTER).append(" 		AND a.id_disponibilidad ").append( soloPedidoEspecial ? "" : "not" ).append(" in ( 3,1 )" );
		if (!tieneCategoriaSeccion()) {
			sql.append(Globals.ENTER).append(" 		and aa.role in ('A01', 'D02', 'E01')");
		} else if (getSeccion().intValue() == Globals.SECCION_PELICULA) {
			sql.append(Globals.ENTER).append(" 		and aa.role in ('D02', 'E01')");
		} else  {
			sql.append(Globals.ENTER).append(" 		and aa.role ='A01'");
		}
		sql.append(Globals.ENTER).append("  	  AND catsearch (au.descripcion, '").append(getTexto()).append("*', NULL) > 0");
		sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());
		
		return sql;
	}
	

	public StringBuffer getQueryParcial(Filtro filtro) {
		StringBuffer sql = new StringBuffer();
		//sql.append(Globals.ENTER).append("     SELECT /*+ INDEX(aa borrame) use_nl (au aa a d)*/");
		//sql.append(Globals.ENTER).append("     SELECT /*+ use_nl (au aa a d)*/");
		sql.append(Globals.ENTER).append("     SELECT ");
		sql.append(Globals.ENTER).append("  	 	 distinct ");
		sql.append(Globals.ENTER).append("     		 a.id_articulo ");
		if(!filtro.getId().equals("0")){
			sql.append(",a.categoria_seccion");	
		}
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("  	 FROM autores au INNER JOIN articulos_autores aa");
		sql.append(Globals.ENTER).append("  	      ON au.id_autor = aa.id_autor");
		sql.append(Globals.ENTER).append("    		  INNER JOIN articulos a ON aa.id_articulo = a.id_articulo");
		// sql.append(Globals.ENTER).append("  	 	  INNER JOIN disponibilidades d");
		// sql.append(Globals.ENTER).append("  	 	  ON a.id_disponibilidad = d.id_disponibilidad");
		// sql.append(Globals.ENTER).append("  	WHERE d.pedido_especial = '").append(pedidoEspecial()).append("'");
		// sql.append(Globals.ENTER).append("  	  AND d.id_esquema = 'PROD' ");
		sql.append(Globals.ENTER).append("  	  WHERE a.categoria_seccion  ").append((tieneCategoriaSeccion() ? ("+0= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("  	  AND a.habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        AND a.activo            = 'SI'");
		sql.append(Globals.ENTER).append(" 		AND a.id_disponibilidad ").append( soloPedidoEspecial ? "" : "not" ).append(" in ( 3,1 )" );		
		if (!tieneCategoriaSeccion()) {
			sql.append(Globals.ENTER).append(" 		and aa.role in ('A01', 'D02', 'E01')");
		} else if (getSeccion().intValue() == Globals.SECCION_PELICULA) {
			sql.append(Globals.ENTER).append(" 		and aa.role in ('D02', 'E01')");
		} else  {
			sql.append(Globals.ENTER).append(" 		and aa.role ='A01'");
		}
		sql.append(Globals.ENTER).append("  	  AND catsearch (au.descripcion, '").append(getTexto()).append("*', NULL) > 0");
		
		return sql;
	}
	

	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_AUTOR);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Autor";
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
        sql.append(" AND ");
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
        sql.append(Globals.ENTER).append("		 WHERE ");
        sql.append(in);
        sql.append(" and ").append(filtro.getWhere());
    	/*sinopsis*/
    	sql.append(Globals.ENTER).append("    UNION");
    	sql.append(Globals.ENTER).append("    SELECT  a.id_articulo");
		sql.append(Globals.ENTER).append(	  filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("    FROM articulos a ");
		sql.append(Globals.ENTER).append(		  filtro.getFrom());
		sql.append(Globals.ENTER).append("    WHERE ");
		sql.append(in);
        sql.append(" and ").append(filtro.getWhere());
		/*sinopsis*/
        return sql;
	}
	
}
