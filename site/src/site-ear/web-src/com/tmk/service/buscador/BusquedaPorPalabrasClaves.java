/**
 * $Log: BusquedaPorPalabrasClaves.java,v $
 * Revision 1.11  2007/09/03 13:42:13  msartori
 * no message
 *
 * Revision 1.10  2007/05/09 18:18:00  omsartori
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
 * Revision 1.9  2007/04/26 18:32:49  omsartori
 * no message
 *
 * Revision 1.8  2007/02/13 13:18:10  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.7  2006/09/28 14:58:17  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.6  2006/08/14 13:29:23  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.5  2006/08/02 15:20:38  omsartori
 * - Mejoras en busquedas>
 *                    Reemplazo de ejb por 1 solo qry
 *                    Hints no necesarios en qry principales eliminados
 * - Banner promos e institucionales agregados en detalle de producto
 * - Indice agregado a las busquedas por palabra clave
 * - Correccion en resaltado> tags incompletos en el corte
 * - Componente de imagen libre de ejb y qrys
 * - Componente de cotizacion parametrizado por monedas y libre de ejb
 *
 * Revision 1.4  2006/03/30 14:42:51  omsartori
 * - catalogo extra nuevo (deshabilitado:falta diseño)
 * - Correccion de orden interpretes
 * - Resaltado de busqueda
 * - recordar las palabras  en busquedas fallidas o sin resultados
 *
 * Revision 1.3  2005/11/04 15:30:05  oDZurita
 * - Desacoplamiento de algunos componentes en las home de cada categoría.
 * - Generador del componente que permite generar contenidos estáticos.
 * - Modificación en las búsquedas por palabra clave.
 * - Modificaciones especificadas en el documento de marketing nº9
 * - Permitir la generación de los componentes estáticas a través de la intranet.
 * - Implementación de una tercer lista en la home de inicio, solo aplicable cuando está habilitada alguna de las categorías de Dromo.
 * - Correccion de la paginación en el resultado de una búsqueda.
 * - Captura del error en el detalle del producto por inexistencia del producto.
 *
 * Revision 1.2  2005/09/15 19:19:27  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/01/25 15:52:52  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.3  2004/06/30 18:23:39  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
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

public class BusquedaPorPalabrasClaves extends BusquedaGenerica {

    public BusquedaPorPalabrasClaves(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
    }

	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();

		/*Agregado para la busqueda incluso por titulo*/
        sql.append(Globals.ENTER).append("    select * from (");
        /*Agregado para la busqueda incluso por titulo*/
        sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(s a) */");
		//sql.append(Globals.ENTER).append("        distinct");
		sql.append(Globals.ENTER).append("        a.id_articulo,a.categoria_seccion");
        sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        articulos_textos s");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        // fix mg20130704: evita los no disponibles (3) en el buscador
        sql.append(Globals.ENTER).append("  	  AND d.id_esquema = 'PROD' AND d.id_disponibilidad NOT IN (3) ");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_articulo       = s.id_articulo");
		sql.append(Globals.ENTER).append("        AND catsearch (s.texto, '").append(getTexto()).append("*', ").append("'') > 0");
        sql.append(Globals.ENTER).append("        AND (s.tipo = '01')"); //para indices  |or s.tipo = '04'|
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
        
		 //agregado para isbn
        sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("  	 SELECT a.id_articulo,a.categoria_seccion");
        sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
		sql.append(Globals.ENTER).append("           FROM disponibilidades d,");
		sql.append(Globals.ENTER).append("                articulos a, articulos_isbn i");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
		sql.append(Globals.ENTER).append("          WHERE d.id_disponibilidad = a.id_disponibilidad");
		sql.append(Globals.ENTER).append("            AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append("        	  AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("            AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        	  AND i.isbn                = UPPER(REPLACE(REPLACE('").append(getTexto()).append("', '-', ''), ' ', ''))");
		sql.append(Globals.ENTER).append("			  AND i.id_articulo = a.id_articulo ");
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
		
		/*Agregado para la busqueda incluso por titulo*/
        sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(s a) */");
		//sql.append(Globals.ENTER).append("        distinct");
		sql.append(Globals.ENTER).append("        a.id_articulo,a.categoria_seccion");
        sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        // fix mg20130704: evita los no disponibles (3) en el buscador
        sql.append(Globals.ENTER).append("  	  AND d.id_esquema = 'PROD' AND d.id_disponibilidad NOT IN (3) ");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
        sql.append(Globals.ENTER).append("        AND catsearch (a.titulo, '").append(getTexto()).append("*', ").append("'') > 0");
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("           ) ").append((criterio == null) ? "" : criterio.getTextoQuery());
        /*Agregado para la busqueda incluso por titulo*/

		return sql;
	}

	
	public StringBuffer getQueryParcial(Filtro filtro) {
		StringBuffer sql = new StringBuffer();

		/*Agregado para la busqueda incluso por titulo*/
        //sql.append(Globals.ENTER).append("    select * from (");
        /*Agregado para la busqueda incluso por titulo*/
        sql.append(Globals.ENTER).append("    SELECT ");
		//sql.append(Globals.ENTER).append("        distinct");
		sql.append(Globals.ENTER).append("        a.id_articulo");
		if(!filtro.getId().equals("0")){
			sql.append(",a.categoria_seccion");	
		}
		sql.append(Globals.ENTER).append(		  filtro.getSelectInterno());		
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        articulos_textos s");
		sql.append(Globals.ENTER).append(			filtro.getFrom());
		sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_articulo       = s.id_articulo");
		sql.append(Globals.ENTER).append("        AND catsearch (s.texto, '").append(getTexto()).append("*', ").append("'') > 0");
        sql.append(Globals.ENTER).append("        AND (s.tipo = '01')"); //para indices  |or s.tipo = '04'|
        sql.append("and ").append(filtro.getWhere());
		 //agregado para isbn
        sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("  	 SELECT a.id_articulo");
        if(!filtro.getId().equals("0")){
			sql.append(",a.categoria_seccion");	
		}
        sql.append(Globals.ENTER).append(filtro.getSelectInterno());        
        sql.append(Globals.ENTER).append("           FROM disponibilidades d,");
		sql.append(Globals.ENTER).append("                articulos a, articulos_isbn i");
		sql.append(Globals.ENTER).append(			filtro.getFrom());
		sql.append(Globals.ENTER).append("          WHERE d.id_disponibilidad = a.id_disponibilidad");
		sql.append(Globals.ENTER).append("            AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append("        	  AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("            AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        	  AND i.isbn                = UPPER(REPLACE(REPLACE('").append(getTexto()).append("', '-', ''), ' ', ''))");
		sql.append(Globals.ENTER).append("			  AND i.id_articulo = a.id_articulo ");
		sql.append("and ").append(filtro.getWhere());
		/*Agregado para la busqueda incluso por titulo*/
        sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(s a) */");
		sql.append(Globals.ENTER).append("        distinct");
		sql.append(Globals.ENTER).append("        a.id_articulo");
		if(!filtro.getId().equals("0")){
			sql.append(",a.categoria_seccion");	
		}
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());		
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a");
        sql.append(Globals.ENTER).append(			filtro.getFrom());
		sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
        sql.append(Globals.ENTER).append("        AND catsearch (a.titulo, '").append(getTexto()).append("*', ").append("'') > 0 ");
        sql.append("and ").append(filtro.getWhere());
       // sql.append(Globals.ENTER).append("        )");        
		/*Agregado para la busqueda incluso por titulo*/

		return sql;
	}

	
	
	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_PALABRAS_CLAVES);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Palabras Claves";
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
