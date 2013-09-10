/**
 * $Log: BusquedaPorISBN.java,v $
 * Revision 1.3  2006/09/28 14:58:16  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.2  2005/09/15 19:19:27  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/01/25 15:52:50  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.2  2004/05/04 18:11:03  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.1  2004/02/11 19:34:29  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorISBN extends BusquedaGenerica {

    public BusquedaPorISBN(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
    }

	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();

//		sql.append(Globals.ENTER).append("    SELECT");
//		sql.append(Globals.ENTER).append("        a.id_articulo ,a.categoria_seccion");
//      sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
//      sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
//      sql.append(Globals.ENTER).append("        articulos a,");
//		sql.append(Globals.ENTER).append("        articulos_isbn i");
//		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
//      sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
//      sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
//      sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
//      sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
//      sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
//		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
//		sql.append(Globals.ENTER).append("        and a.id_articulo       = i.id_articulo");
//		sql.append(Globals.ENTER).append("        and i.isbn                = UPPER(REPLACE(REPLACE('").append(getTexto()).append("', '-', ''), ' ', ''))");
//		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
//      sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());

		sql.append(Globals.ENTER).append("    SELECT");
		sql.append(Globals.ENTER).append("        a.id_articulo ,a.categoria_seccion");
        sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
//      sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("    FROM articulos a,");
		sql.append(Globals.ENTER).append("        articulos_isbn i");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
//      sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
//      sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
//      sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("    WHERE a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_articulo       = i.id_articulo");
		sql.append(Globals.ENTER).append("  	  AND a.id_disponibilidad ").append( soloPedidoEspecial ? "" : "not" ).append(" in ( 3,1 )" );		
		sql.append(Globals.ENTER).append("        and i.isbn                = UPPER(REPLACE(REPLACE('").append(getTexto()).append("', '-', ''), ' ', ''))");
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());        
        
		return sql;
	}

	public StringBuffer getQueryParcial(Filtro filtro) {
		StringBuffer sql = new StringBuffer();

//		sql.append(Globals.ENTER).append("    SELECT");
//		sql.append(Globals.ENTER).append("        a.id_articulo,a.categoria_seccion");
//      sql.append(Globals.ENTER).append(filtro.getSelectInterno());
//      sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
//      sql.append(Globals.ENTER).append("        articulos a,");
//		sql.append(Globals.ENTER).append("        articulos_isbn i");
//		sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
//      sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
//      sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
//      sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
//      sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
//		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
//		sql.append(Globals.ENTER).append("        and a.id_articulo       = i.id_articulo");
//		sql.append(Globals.ENTER).append("        and i.isbn                = UPPER(REPLACE(REPLACE('").append(getTexto()).append("', '-', ''), ' ', ''))");

		sql.append(Globals.ENTER).append("    SELECT");
		sql.append(Globals.ENTER).append("        a.id_articulo ");
		if(!filtro.getId().equals("0")){
			sql.append(",a.categoria_seccion");	
		}
        sql.append(Globals.ENTER).append(filtro.getSelectInterno());
//      sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("    FROM articulos a,");
		sql.append(Globals.ENTER).append("        articulos_isbn i");
//		sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
//      sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
//      sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("    WHERE a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_articulo       = i.id_articulo");
		sql.append(Globals.ENTER).append("  	  AND a.id_disponibilidad ").append( soloPedidoEspecial ? "" : "not" ).append(" in ( 3,1 )" );
		sql.append(Globals.ENTER).append("        and i.isbn                = UPPER(REPLACE(REPLACE('").append(getTexto()).append("', '-', ''), ' ', ''))");		

		return sql;
	}

	
	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_ISBN);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "ISBN";
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
