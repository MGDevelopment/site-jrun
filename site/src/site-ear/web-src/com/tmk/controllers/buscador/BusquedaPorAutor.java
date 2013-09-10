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
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorAutor extends BusquedaGenerica {

    public BusquedaPorAutor(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
    }
    // fix mg20130823: fix disponibilidades y pedido especial
	public String getQuerySubtotales() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" select categoria_seccion seccion, count(*) cantidad");
		sql.append(Globals.ENTER).append(" FROM (");
		sql.append(Globals.ENTER).append(" 		   SELECT /*+ INDEX(aa borrame) use_nl (au aa a d)*/ ");
		sql.append(Globals.ENTER).append("     		    distinct a.id_articulo,");
        sql.append(Globals.ENTER).append("        		a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        		a.fecha_alta,");
        sql.append(Globals.ENTER).append("        		a.titulo,");
        sql.append(Globals.ENTER).append("        		a.precio_venta_vigente");
		sql.append(Globals.ENTER).append(" 			FROM ");
		sql.append(Globals.ENTER).append(" 				autores au inner join articulos_autores aa");
		sql.append(Globals.ENTER).append(" 				on au.id_autor = aa.id_autor");
		sql.append(Globals.ENTER).append(" 				inner join articulos a on");
		sql.append(Globals.ENTER).append(" 				aa.id_articulo = a.id_articulo");
		sql.append(Globals.ENTER).append(" 				inner join disponibilidades d");
		sql.append(Globals.ENTER).append(" 				on a.id_disponibilidad = d.id_disponibilidad");
		sql.append(Globals.ENTER).append(" 			WHERE  d.id_esquema = 'PROD'");
		if (soloPedidoEspecial)
			sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );
		else 
		    sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
		sql.append(Globals.ENTER).append(" 				AND a.categoria_seccion  ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append(" 				AND a.habilitado_tematika = 'S'");
		if (!tieneCategoriaSeccion()) {
			sql.append(Globals.ENTER).append(" 			AND aa.role in ('A01', 'D02', 'E01')");
		} else if (getSeccion().intValue() == Globals.SECCION_PELICULA) {
			sql.append(Globals.ENTER).append(" 			AND aa.role in ('D02', 'E01')");
		} else  {
			sql.append(Globals.ENTER).append(" 			AND aa.role ='A01'");
		}
		sql.append(Globals.ENTER).append(" 				AND catsearch (au.descripcion, '").append(getTexto()).append("*', NULL) > 0");
		sql.append(") group by categoria_seccion");
		return sql.toString();
		
		
	}
	// fix mg20130823: fix disponibilidades y pedido especial
	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("     SELECT /*+ INDEX(aa borrame) use_nl (au aa a d)*/");
		sql.append(Globals.ENTER).append("  	 	 distinct ");
		sql.append(Globals.ENTER).append("     		 a.id_articulo,");
        sql.append(Globals.ENTER).append("        	 a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        	 a.fecha_alta,");
        sql.append(Globals.ENTER).append("        	 a.titulo,");
        sql.append(Globals.ENTER).append("        	 a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("           " + criterio.getAddSelect());
		sql.append(Globals.ENTER).append("  	 FROM autores au INNER JOIN articulos_autores aa");
		sql.append(Globals.ENTER).append("  	      ON au.id_autor = aa.id_autor");
		sql.append(Globals.ENTER).append("    		  INNER JOIN articulos a ON aa.id_articulo = a.id_articulo");
		sql.append(Globals.ENTER).append("  	 	  INNER JOIN disponibilidades d");
		sql.append(Globals.ENTER).append("  	 	  ON a.id_disponibilidad = d.id_disponibilidad");
		sql.append(Globals.ENTER).append("           " + criterio.getAddFromJoin());
		sql.append(Globals.ENTER).append("  	WHERE d.id_esquema = 'PROD' ");
		if (soloPedidoEspecial)
			sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );
		else 
		    sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
		sql.append(Globals.ENTER).append("  	  AND a.categoria_seccion  ").append((tieneCategoriaSeccion() ? ("+0= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("  	  AND a.habilitado_tematika = 'S'");
		if (!tieneCategoriaSeccion()) {
			sql.append(Globals.ENTER).append(" 		and aa.role in ('A01', 'D02', 'E01')");
		} else if (getSeccion().intValue() == Globals.SECCION_PELICULA) {
			sql.append(Globals.ENTER).append(" 		and aa.role in ('D02', 'E01')");
		} else  {
			sql.append(Globals.ENTER).append(" 		and aa.role ='A01'");
		}
		sql.append(Globals.ENTER).append("  	  AND catsearch (au.descripcion, '").append(getTexto()).append("*', NULL) > 0");
		//sql.append(Globals.ENTER).append("           " + criterio.getAddWhere());
		sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());
		
		/*
		 * SELECT /*+ INDEX(aa borrame) use_nl (au aa a d)*//*
                 a.id_articulo, a.categoria_seccion
            FROM autores au INNER JOIN articulos_autores aa
                 ON au.id_autor = aa.id_autor
                 INNER JOIN articulos a ON aa.id_articulo = a.id_articulo
                 INNER JOIN disponibilidades d
                 ON a.id_disponibilidad = d.id_disponibilidad
           WHERE d.pedido_especial = 'N'
             AND d.id_esquema = 'PROD'
             AND a.categoria_seccion = 1
             AND a.habilitado_tematika = 'S'
             AND aa.ROLE = 'A01'
             AND catsearch (au.descripcion, 'cortazar*', NULL) > 0
                ORDER BY fecha_alta DESC
		 * 
		 * */
		/*
		sql.append(Globals.ENTER).append("  	 SELECT /*+ use_nl(aa a)*//* a.id_articulo,");
        sql.append(Globals.ENTER).append("  	 a.categoria_seccion,");
        sql.append(Globals.ENTER).append("  	 a.fecha_alta,");
        sql.append(Globals.ENTER).append("  	 a.titulo,");
        sql.append(Globals.ENTER).append("  	 a.precio_venta_vigente");
        sql.append(Globals.ENTER).append("           " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("		  FROM disponibilidades d, articulos a,");
        sql.append(Globals.ENTER).append("			(SELECT id_articulo, role");
        sql.append(Globals.ENTER).append("			   FROM articulos_autores");
        sql.append(Globals.ENTER).append("			  WHERE id_autor IN (SELECT id_autor");
        sql.append(Globals.ENTER).append("			   					   FROM autores");
        sql.append(Globals.ENTER).append("								  WHERE catsearch (descripcion, '").append(getTexto()).append("*', NULL) > 0").append(")) aa");
        sql.append(Globals.ENTER).append("           " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("		 WHERE");
        sql.append(Globals.ENTER).append("			d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("			and d.pedido_especial = 'N'");
        sql.append(Globals.ENTER).append("			and d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("			and a.categoria_seccion  ").append((tieneCategoriaSeccion() ? ("+0= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("			and a.habilitado_tematika = 'S'");
        sql.append(Globals.ENTER).append("			and a.id_articulo = aa.id_articulo");
        sql.append(Globals.ENTER).append("           " + criterio.getAddWhere());
    	if (!tieneCategoriaSeccion()) {
			sql.append(Globals.ENTER).append(" 		and aa.role in ('A01', 'D02', 'E01')");
		} else if (getSeccion().intValue() == Globals.SECCION_PELICULA) {
			sql.append(Globals.ENTER).append(" 		and aa.role in ('D02', 'E01')");
		} else  {
			sql.append(Globals.ENTER).append(" 		and aa.role ='A01'");
		}
		sql.append(Globals.ENTER).append("       " + criterio.getAddWhere());
		sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());
		*/
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

}
