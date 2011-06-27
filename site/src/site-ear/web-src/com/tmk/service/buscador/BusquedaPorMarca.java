/**
 * $Log: BusquedaPorMarca.java,v $
 * Revision 1.2  2006/09/28 14:58:16  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.1  2005/12/29 17:45:26  omsartori
 * * Cambios Dromo
 *    Se quitaron los datos distribuidor, proveedor e isbn.
 *    Se agregaron los datos marca y fabricante.
 *    Se agregaron los buscadores por marca y fabricante, tanto por código como por palabra.
 *    Se modificó el orden de las tarjetas en el plan de pago del detalle artículo, ahora es VIS, AME, MAS, DIN.
 *    Se agregaron los campos:
 *    Tipo de documento.
 *    Nro de Documento.
 *    Rango horario de recepción del pedido.
 *    Estos campos son visibles en la orden del cliente y en el detalle de orden de la intranet de TMK. Y deben completarse obligatoriamente para órdenes que contengan artículos de Dromo.
 *
 * * Se filtró la localidad “ciudad autónoma de Buenos Aires” del listado de localidades válidas para tmk.
 *
 * * Doc Empro 10
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorMarca extends BusquedaGenerica {

    public BusquedaPorMarca(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
    }

	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(e a) use_nl(a d) */");
		sql.append(Globals.ENTER).append("        a.id_articulo");
		sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        cg_ref_codes c");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        AND a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        AND c.rv_domain = 'MARCA'");
		sql.append(Globals.ENTER).append("        AND a.auxnumber03      = c.rv_low_value");
		sql.append(Globals.ENTER).append("        AND upper(c.rv_abbreviation) like '%").append(getTexto().toUpperCase()).append("%'");
        sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());

		return sql;
	}

	public StringBuffer getQueryParcial(Filtro filtro) {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(e a) use_nl(a d) */");
		sql.append(Globals.ENTER).append("        a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        cg_ref_codes c");
		sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        AND a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        AND c.rv_domain = 'MARCA'");
		sql.append(Globals.ENTER).append("        AND a.auxnumber03      = c.rv_low_value");
		sql.append(Globals.ENTER).append("        AND upper(c.rv_abbreviation) like '%").append(getTexto().toUpperCase()).append("%'");
        
		return sql;
	}

	
	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_MARCA);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Marca";
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

