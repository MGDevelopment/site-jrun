/**
 * $Log: BusquedaPorIDdeEditorial.java,v $
 * Revision 1.3  2006/09/28 14:58:16  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campa�as aplicadas
 *
 * Revision 1.2  2005/09/15 19:19:26  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/07/18 13:53:06  omsartori
 * - Modificaciones en referido
 * - ejb articulo reducido
 * - buscador de editor por id
 *
 */
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorIDdeEditorial extends BusquedaGenerica {

	private Integer idEditorial;

    public BusquedaPorIDdeEditorial(String texto, Integer idEditorial, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
	    this.idEditorial = idEditorial;
    }
    // fix mg20130823: fix disponibilidades y pedido especial
	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    SELECT /*+ use_nl(e a) use_nl(a d) */");
		sql.append(Globals.ENTER).append("        a.id_articulo,");
        sql.append(Globals.ENTER).append("        a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        a.fecha_alta,");
        sql.append(Globals.ENTER).append("        a.titulo,");
        sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        editores e");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        if (soloPedidoEspecial)
        	sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );		
        else 
            sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        and a.id_editor         = e.id_editor");
		sql.append(Globals.ENTER).append("        and a.id_editor= '").append(idEditorial).append("'");
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
	    sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());

		return sql;
	}

	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_IDdeEDITORIAL);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		parametro(buffer, BuscadorHelper.ID_EDITOR, idEditorial);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "id de Editor";
	}

}



