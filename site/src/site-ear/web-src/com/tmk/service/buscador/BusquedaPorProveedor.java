/**
 * $Log: BusquedaPorProveedor.java,v $
 * Revision 1.3  2006/09/28 14:58:17  omsartori
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
 * Revision 1.1  2005/01/25 15:52:53  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.2  2005/01/20 20:48:35  oGPistoia
 * - Modificacion en buscador por proveedor
 * - Filtro extra para productos deshabilitados con atributos dinámicos
 *
 * Revision 1.1  2005/01/18 19:46:12  oGPistoia
 * - Nuevo EJB de Proveedores
 * - Busqueda por Proveedor
 * - Modificaciones en los reportes
 * - Cambios en clientes institucionales
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorProveedor extends BusquedaGenerica {

    public BusquedaPorProveedor(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
    }
    // fix mg20130823: fix disponibilidades y pedido especial
	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(e a) use_nl(a d) */");
		sql.append(Globals.ENTER).append("        a.id_articulo");
        sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        proveedores p");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        // fix mg20130705: evita los no disponibles (3) en el buscador
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD' ");
        if (soloPedidoEspecial)
        	sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );		
        else 
            sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        AND a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        AND a.id_proveedor      = p.id_proveedor");
		sql.append(Globals.ENTER).append("        and catsearch(p.nombre, '").append(getTexto()).append("', '') > 0");
        sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());

		return sql;
	}

	// fix mg20130823: fix disponibilidades y pedido especial
	public StringBuffer getQueryParcial(Filtro filtro) {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(e a) use_nl(a d) */");
		sql.append(Globals.ENTER).append("        a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        proveedores p");
		sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
		// fix mg20130705: evita los no disponibles (3) en el buscador
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD' ");
        if (soloPedidoEspecial)
        	sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );		
        else 
            sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        AND a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        AND a.id_proveedor      = p.id_proveedor");
		sql.append(Globals.ENTER).append("        and catsearch(p.nombre, '").append(getTexto()).append("', '') > 0");
        
		return sql;
	}
	
	
	
	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_PROVEEDOR);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Proveedor";
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
