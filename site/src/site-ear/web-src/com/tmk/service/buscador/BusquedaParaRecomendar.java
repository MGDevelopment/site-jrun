/**
 * $Log: BusquedaParaRecomendar.java,v $
 * Revision 1.4  2006/09/28 14:58:15  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.3  2006/06/22 18:31:36  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.2  2005/10/20 19:34:57  omsartori
 * - correccion en recomendados
 *
 * Revision 1.1  2005/01/25 15:52:46  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.3  2004/05/04 18:11:02  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.2  2004/03/25 18:19:52  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.1  2004/02/16 20:24:20  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;

public class BusquedaParaRecomendar extends BusquedaGenerica {

	private Integer idSucursal;
	private Integer idSocio;

    public BusquedaParaRecomendar(Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial,
                       Integer idSucursal,
                       Integer idSocio) {
	    super(null, null, registroInicial, registroFinal, criterio, soloPedidoEspecial);
	    this.idSucursal = idSucursal;
	    this.idSocio = idSocio;
    }

	public Integer cantidadDeFilasAMostrar() {
		return new Integer(15); // como son recomendaciones, es preferible mostrar muchas ya que no las van a leer detenidamente
	}
	// fix mg20130823: fix disponibilidades y pedido especial
	public StringBuffer getQueryParcial() {

		// Selecciona los productos que alguna vez eligio, sea el carrito, comprados, de la lista, etc
		StringBuffer seleccionados = new StringBuffer();
		seleccionados.append(Globals.ENTER).append("        SELECT distinct a.id_articulo FROM (");
		seleccionados.append(Globals.ENTER).append("            SELECT id_articulo, NULL id_orden FROM carrito_compra WHERE id_sucursal_socio = ").append(idSucursal).append(" AND id_socio = ").append(idSocio);
		seleccionados.append(Globals.ENTER).append("            UNION");
		seleccionados.append(Globals.ENTER).append("            SELECT id_articulo, NULL id_orden FROM carrito_lista_deseos WHERE id_sucursal_socio = ").append(idSucursal).append(" AND id_socio = ").append(idSocio);
		seleccionados.append(Globals.ENTER).append("            UNION");
		seleccionados.append(Globals.ENTER).append("            SELECT id_articulo, o.id_orden FROM orden o, item_orden io WHERE id_sucursal_socio = ").append(idSucursal).append(" AND id_socio = ").append(idSocio).append(" AND o.id_orden = io.id_orden ORDER BY id_orden DESC");
		seleccionados.append(Globals.ENTER).append("        ) idx, articulos a");
		seleccionados.append(Globals.ENTER).append("        WHERE idx.id_articulo = a.id_articulo");
		seleccionados.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");

		// toma los recomendados de los elegidos, pero que no se repitan con los elegidos
		StringBuffer recomendados = new StringBuffer();
		recomendados.append(Globals.ENTER).append("  SELECT distinct a.*");
		recomendados.append(Globals.ENTER).append("  FROM (");
		recomendados.append(Globals.ENTER).append(seleccionados);
		recomendados.append(Globals.ENTER).append("        AND rownum <= 15");   // Preseleccionar porque no es representativo demasiados productos
		recomendados.append(Globals.ENTER).append("       ) s, recomendacion_articulos r, articulos a");
		recomendados.append(Globals.ENTER).append(" WHERE s.id_articulo = r.id_articulo");
		recomendados.append(Globals.ENTER).append("   and r.id_articulo_recomendado = a.id_articulo");
		recomendados.append(Globals.ENTER).append("   and a.fecha_alta >= trunc(add_months(sysdate, - 12 * 6), 'MM')"); // Si el producto tiene más de NN años no tiene mucho sentido mostrarlo
		recomendados.append(Globals.ENTER).append("   and r.id_articulo_recomendado not in (");
		recomendados.append(Globals.ENTER).append(seleccionados);
		recomendados.append(Globals.ENTER).append("       )");
		
		
		// Selecciona los articulos para ordenar y filtrar
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    SELECT ");
		sql.append(Globals.ENTER).append("        a.id_articulo");
        sql.append(Globals.ENTER).append("        " + criterio.getAddSelect());
		sql.append(Globals.ENTER).append("    FROM (");
		sql.append(Globals.ENTER).append(recomendados);
		sql.append(Globals.ENTER).append("    ) a, disponibilidades d");
		sql.append(Globals.ENTER).append("        " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        if (soloPedidoEspecial)
        	sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );		
        else 
            sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("       " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("        ").append((criterio == null) ? "" : criterio.getTextoQuery());

		return sql;
	}

	// fix mg20130823: fix disponibilidades y pedido especial
	public StringBuffer getQueryParcial(Filtro filtro) {

		// Selecciona los productos que alguna vez eligio, sea el carrito, comprados, de la lista, etc
		StringBuffer seleccionados = new StringBuffer();
		seleccionados.append(Globals.ENTER).append("        SELECT distinct a.id_articulo FROM (");
		seleccionados.append(Globals.ENTER).append("            SELECT id_articulo, NULL id_orden FROM carrito_compra WHERE id_sucursal_socio = ").append(idSucursal).append(" AND id_socio = ").append(idSocio);
		seleccionados.append(Globals.ENTER).append("            UNION");
		seleccionados.append(Globals.ENTER).append("            SELECT id_articulo, NULL id_orden FROM carrito_lista_deseos WHERE id_sucursal_socio = ").append(idSucursal).append(" AND id_socio = ").append(idSocio);
		seleccionados.append(Globals.ENTER).append("            UNION");
		seleccionados.append(Globals.ENTER).append("            SELECT id_articulo, o.id_orden FROM orden o, item_orden io WHERE id_sucursal_socio = ").append(idSucursal).append(" AND id_socio = ").append(idSocio).append(" AND o.id_orden = io.id_orden ORDER BY id_orden DESC");
		seleccionados.append(Globals.ENTER).append("        ) idx, articulos a");
		seleccionados.append(Globals.ENTER).append("        WHERE idx.id_articulo = a.id_articulo");
		seleccionados.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");

		// toma los recomendados de los elegidos, pero que no se repitan con los elegidos
		StringBuffer recomendados = new StringBuffer();
		recomendados.append(Globals.ENTER).append("  SELECT distinct a.*");
		recomendados.append(Globals.ENTER).append("  FROM (");
		recomendados.append(Globals.ENTER).append(seleccionados);
		recomendados.append(Globals.ENTER).append("        AND rownum <= 15");   // Preseleccionar porque no es representativo demasiados productos
		recomendados.append(Globals.ENTER).append("       ) s, recomendacion_articulos r, articulos a");
		recomendados.append(Globals.ENTER).append(" WHERE s.id_articulo = r.id_articulo");
		recomendados.append(Globals.ENTER).append("   and r.id_articulo_recomendado = a.id_articulo");
		recomendados.append(Globals.ENTER).append("   and a.fecha_alta >= trunc(add_months(sysdate, - 12 * 6), 'MM')"); // Si el producto tiene más de NN años no tiene mucho sentido mostrarlo
		recomendados.append(Globals.ENTER).append("   and r.id_articulo_recomendado not in (");
		recomendados.append(Globals.ENTER).append(seleccionados);
		recomendados.append(Globals.ENTER).append("       )");
		
		
		// Selecciona los articulos para ordenar y filtrar
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    SELECT ");
		sql.append(Globals.ENTER).append("        a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("    FROM (");
		sql.append(Globals.ENTER).append(recomendados);
		sql.append(Globals.ENTER).append("    ) a, disponibilidades d");
		sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        if (soloPedidoEspecial)
        	sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );		
        else 
            sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		
		return sql;
	}
	
	
	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.PARA_RECOMENDAR);
		parametro(buffer, BuscadorHelper.ID_SUCURSAL, idSucursal);
		parametro(buffer, BuscadorHelper.ID_SOCIO, idSocio);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Recomendaciones";
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
		sql.append(in);
		sql.append(" and ").append(filtro.getWhere());
		sql.append(Globals.ENTER).append("    UNION");
        sql.append(Globals.ENTER).append("  	 SELECT  a.id_articulo");
        sql.append(Globals.ENTER).append(		 	filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("		 FROM articulos a");
        sql.append(Globals.ENTER).append(		 	filtro.getFrom());        
        sql.append(Globals.ENTER).append("		 WHERE");
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
        sql.append("and ").append(filtro.getWhere());
		/*sinopsis*/
        return sql;
	}
}
