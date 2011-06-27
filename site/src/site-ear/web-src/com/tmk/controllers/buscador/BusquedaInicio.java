/**
 * $Log: BusquedaInicio.java,v $
 * Revision 1.17  2007/09/03 13:42:13  msartori
 * no message
 *
 * Revision 1.16  2007/07/11 15:00:51  omsartori
 * - Busqueda Logger
 * - Cambio de estandar html
 * - PopUp registracion
 * - Rearmado de ajax de carrito de compras
 * - Pop Up carrito de compras
 *
 * Revision 1.15  2007/06/11 18:37:33  omsartori
 * - Log de busquedas
 *
 * Revision 1.14  2007/05/28 19:21:08  omsartori
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
 * Revision 1.13  2007/05/09 18:18:00  omsartori
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
 * Revision 1.12  2007/04/26 18:32:48  omsartori
 * no message
 *
 * Revision 1.11  2007/03/29 17:36:28  omsartori
 * - Medidas para productos
 * - Mejora de tiempos en busqueda de autor (modificacion de qry)
 *
 * Revision 1.10  2007/02/16 18:41:01  omsartori
 * - schedule de generacion de ranking y top de familias
 * - correccion bug paginacion de lista de deseos
 * - filtro de palabras para buscador
 * - estadisticas de homes, biografias e indices
 * - correccion de bug de aprobacion de comentarios
 *
 * Revision 1.9  2007/02/13 13:18:10  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.8  2006/12/13 17:16:17  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.7  2006/09/28 14:58:15  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.6  2006/09/14 18:25:00  omsartori
 * Promociones II
 *
 * Revision 1.5  2006/08/14 13:29:22  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.4  2006/08/02 15:20:37  omsartori
 * - Mejoras en busquedas>
 *                    Reemplazo de ejb por 1 solo qry
 *                    Hints no necesarios en qry principales eliminados
 * - Banner promos e institucionales agregados en detalle de producto
 * - Indice agregado a las busquedas por palabra clave
 * - Correccion en resaltado> tags incompletos en el corte
 * - Componente de imagen libre de ejb y qrys
 * - Componente de cotizacion parametrizado por monedas y libre de ejb
 *
 * Revision 1.3  2006/03/30 14:42:51  omsartori
 * - catalogo extra nuevo (deshabilitado:falta diseño)
 * - Correccion de orden interpretes
 * - Resaltado de busqueda
 * - recordar las palabras  en busquedas fallidas o sin resultados
 *
 * Revision 1.2  2005/09/15 19:19:23  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/01/25 15:52:45  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.2  2004/05/04 18:11:01  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.1  2004/02/11 19:34:27  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;

public class BusquedaInicio extends BusquedaGenerica {
    public BusquedaInicio(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
    	
    	 
    	
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
	    /*Busqueda por todas las categorias reanudada*/
	  //  this.seccion = (seccion == null || seccion.intValue() == Globals.SECCION_HOME)? new Integer (Globals.SECCION_LIBRO):seccion;
	    /*Busqueda por todas las categorias reanudada*/
	    
    }

	public Integer cantidadDeFilasAMostrar() {
		// si muestra muchas secciones juntas, entonces muestra de a menos cantidad
		return new Integer(5);
	}

	public String getQuerySubtotales() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("select categoria_seccion seccion, count(*) cantidad");
		sql.append(Globals.ENTER).append("  from ( SELECT  a.id_articulo,");
		sql.append(Globals.ENTER).append("                a.categoria_seccion");
		sql.append(Globals.ENTER).append("           FROM disponibilidades d,");
		sql.append(Globals.ENTER).append("                articulos a");
		sql.append(Globals.ENTER).append("          WHERE d.id_disponibilidad = a.id_disponibilidad");
		sql.append(Globals.ENTER).append("            AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append("            AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("            AND catsearch (a.titulo, '").append(getTexto()).append("*', NULL) > 0");
		sql.append(Globals.ENTER).append("            AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("          UNION");
		sql.append(Globals.ENTER).append(" 		   SELECT /*+ INDEX(aa borrame) use_nl (au aa a d)*/ ");
		sql.append(Globals.ENTER).append(" 				a.id_articulo, a.categoria_seccion");
		sql.append(Globals.ENTER).append(" 			FROM ");
		sql.append(Globals.ENTER).append(" 				autores au inner join articulos_autores aa");
		sql.append(Globals.ENTER).append(" 				on au.id_autor = aa.id_autor");
		sql.append(Globals.ENTER).append(" 				inner join articulos a on");
		sql.append(Globals.ENTER).append(" 				aa.id_articulo = a.id_articulo");
		sql.append(Globals.ENTER).append(" 				inner join disponibilidades d");
		sql.append(Globals.ENTER).append(" 				on a.id_disponibilidad = d.id_disponibilidad");
		sql.append(Globals.ENTER).append(" 			WHERE d.pedido_especial = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append(" 				AND d.id_esquema = 'PROD'		");
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
		
		
		/*
		sql.append(Globals.ENTER).append(" SELECT /*+ INDEX( aa borrame)*//*");
		sql.append(Globals.ENTER).append(" 		a.id_articulo, a.categoria_seccion");
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a, articulos_autores aa, autores au");
		sql.append(Globals.ENTER).append(" WHERE d.pedido_especial = 'N'");
		sql.append(Globals.ENTER).append(" 		AND d.id_esquema = 'PROD'");
		sql.append(Globals.ENTER).append(" 		AND d.id_disponibilidad = a.id_disponibilidad");
		sql.append(Globals.ENTER).append(" 		AND a.habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append(" 		AND a.id_articulo = aa.id_articulo");
		sql.append(Globals.ENTER).append(" 		AND aa.id_autor = au.id_autor");
		sql.append(Globals.ENTER).append(" 		AND catsearch (au.descripcion, '").append(getTexto()).append("*', NULL) > 0");
		sql.append(Globals.ENTER).append("      AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append(" 		AND (   (a.categoria_seccion IN (1, 3, 4) AND aa.ROLE = 'A01')");
		sql.append(Globals.ENTER).append("  	OR (a.categoria_seccion = 5 AND aa.ROLE IN ('D02', 'E01'))");
		sql.append(Globals.ENTER).append(" )");
	*/
		//consulta a sinopsis
		/*sql.append(Globals.ENTER).append("    UNION");
		sql.append(Globals.ENTER).append("    SELECT "); 
		sql.append(Globals.ENTER).append("        distinct");
		sql.append(Globals.ENTER).append("        a.id_articulo,");
        sql.append(Globals.ENTER).append("        a.categoria_seccion");
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        articulos_textos s");
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_articulo       = s.id_articulo");
        sql.append(Globals.ENTER).append("        AND catsearch (s.texto, '").append(getTexto()).append("*', ").append("'') > 0");
        sql.append(Globals.ENTER).append("        AND (s.tipo = '01' )");
        */
        //agregado para isbn
        sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("  	 SELECT a.id_articulo,");
		sql.append(Globals.ENTER).append("                a.categoria_seccion");
		sql.append(Globals.ENTER).append("           FROM disponibilidades d,");
		sql.append(Globals.ENTER).append("                articulos a, articulos_isbn i");
		sql.append(Globals.ENTER).append("          WHERE d.id_disponibilidad = a.id_disponibilidad");
		sql.append(Globals.ENTER).append("            AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append("        	  AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("            AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        	  AND i.isbn                = UPPER(REPLACE(REPLACE('").append(getTexto()).append("', '-', ''), ' ', ''))");
		sql.append(Globals.ENTER).append("			  AND i.id_articulo = a.id_articulo ");
		/*sinopsis*/
		sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(s a) */");
		sql.append(Globals.ENTER).append("        distinct");
		sql.append(Globals.ENTER).append("        a.id_articulo,");
        sql.append(Globals.ENTER).append("        a.categoria_seccion");
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        articulos_textos s");
		sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_articulo       = s.id_articulo");
		sql.append(Globals.ENTER).append("        AND catsearch (s.texto, '").append(getTexto()).append("*', ").append("'') > 0");
        sql.append(Globals.ENTER).append("        AND (s.tipo = '01')"); //para indices  |or s.tipo = '04'|
		/*sinopsis*/
		
		sql.append(Globals.ENTER).append("        )");
		sql.append(Globals.ENTER).append("    group by categoria_seccion");
		return sql.toString();
	}

	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    SELECT   a.id_articulo,");
        sql.append(Globals.ENTER).append("        a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        a.fecha_alta,");
        sql.append(Globals.ENTER).append("        a.titulo,");
        sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("       " + criterio.getAddSelect());
		sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
        sql.append(Globals.ENTER).append("        AND catsearch (a.titulo, '").append(getTexto()).append("*', ").append("'categoria_seccion = ").append(getSeccion()).append(" and activo = ''SI''') > 0");
        sql.append(Globals.ENTER).append("       " + criterio.getAddWhere());
        
        //agregado para isbn
        sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("  	 SELECT a.id_articulo,");
        sql.append(Globals.ENTER).append("  	 a.categoria_seccion,");
        sql.append(Globals.ENTER).append("  	 a.fecha_alta,");
        sql.append(Globals.ENTER).append("  	 a.titulo,");
        sql.append(Globals.ENTER).append("  	 a.precio_venta_vigente");
        sql.append(Globals.ENTER).append("       " + criterio.getAddSelect());
		sql.append(Globals.ENTER).append("           FROM disponibilidades d,");
		sql.append(Globals.ENTER).append("                articulos a, articulos_isbn i");
		sql.append(Globals.ENTER).append("           " + criterio.getAddFrom());
		sql.append(Globals.ENTER).append("          WHERE d.id_disponibilidad = a.id_disponibilidad");
		sql.append(Globals.ENTER).append("            AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append("        	  AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("            AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        	  AND i.isbn                = UPPER(REPLACE(REPLACE('").append(getTexto()).append("', '-', ''), ' ', ''))");
		sql.append(Globals.ENTER).append("			  AND i.id_articulo = a.id_articulo ");
		sql.append(Globals.ENTER).append("           " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("  	 SELECT /*+ use_nl(aa a)*/ a.id_articulo,");
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
        
    	/*sinopsis*/
    	sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(s a) */");
		sql.append(Globals.ENTER).append("        distinct");
		sql.append(Globals.ENTER).append("        a.id_articulo,");
        sql.append(Globals.ENTER).append("        a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        a.fecha_alta,");
        sql.append(Globals.ENTER).append("        a.titulo,");
        sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        articulos_textos s");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_articulo       = s.id_articulo");
		sql.append(Globals.ENTER).append("        AND catsearch (s.texto, '").append(getTexto()).append("*', ").append("'') > 0");
        sql.append(Globals.ENTER).append("        AND (s.tipo = '01')"); //para indices  |or s.tipo = '04'|
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
    	/*sinopsis*/
    
        
      /*  sql.append(Globals.ENTER).append("		SELECT /*+ INDEX( aa borrame) *//*");
        sql.append(Globals.ENTER).append("		 a.id_articulo, ");
        sql.append(Globals.ENTER).append("        a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        a.fecha_alta,");
        sql.append(Globals.ENTER).append("        a.titulo,");
        sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
        sql.append(Globals.ENTER).append("           " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("		FROM disponibilidades d, articulos a, articulos_autores aa, autores au ");
        sql.append(Globals.ENTER).append("           " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("		WHERE d.pedido_especial = 'N'");
        sql.append(Globals.ENTER).append("		AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("      AND a.categoria_seccion     ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("		AND d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("		AND a.habilitado_tematika = 'S'");
        sql.append(Globals.ENTER).append("		AND a.id_articulo = aa.id_articulo");
        sql.append(Globals.ENTER).append("		AND aa.id_autor = au.id_autor");
        sql.append(Globals.ENTER).append("		AND catsearch (au.descripcion, '").append(getTexto()).append("', NULL) > 0");
        sql.append(Globals.ENTER).append("           " + criterio.getAddWhere());
        if (tieneCategoriaSeccion()) {
			if (getSeccion().intValue() == Globals.SECCION_LIBRO || getSeccion().intValue() == Globals.SECCION_JUGUETES
					|| getSeccion().intValue() == Globals.SECCION_MUSICA) {
				sql.append(Globals.ENTER).append(" AND aa.role = 'A01'");
			}
			if (getSeccion().intValue() == Globals.SECCION_PELICULA) {
				sql.append(Globals.ENTER).append(" AND aa.role in ('D02', 'E01')");
			}
		}
 		*/
		//Agregado para busqueda en sinopsis
/*		sql.append(Globals.ENTER).append("    UNION");
		sql.append(Globals.ENTER).append("    SELECT ");
		sql.append(Globals.ENTER).append("        distinct");
		sql.append(Globals.ENTER).append("        a.id_articulo,");
        sql.append(Globals.ENTER).append("        a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        a.fecha_alta,");
        sql.append(Globals.ENTER).append("        a.titulo,");
        sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        articulos_textos s");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_articulo       = s.id_articulo");
        sql.append(Globals.ENTER).append("        AND catsearch (s.texto, '").append(getTexto()).append("*', ").append("'') > 0");
        sql.append(Globals.ENTER).append("        AND (s.tipo = '01')");//para indices  |or s.tipo = '04'|
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());*/
        sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());

		return sql;
	}

	public StringBuffer salto() {
		return parametro(super.salto(), BuscadorHelper.TEXTO, texto);
	}

	public String getNombreDeBusqueda() {
		return "Inicio";
	}

}
