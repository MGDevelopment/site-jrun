/**
 * $Log: BusquedaPorCategorias.java,v $
 * Revision 1.3  2006/09/28 14:58:15  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.2  2005/09/15 19:19:25  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/01/25 15:52:48  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.2  2004/05/04 18:11:02  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.1  2004/02/11 19:34:28  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorCategorias extends BusquedaGenerica {

	private Integer grupo;
	private Integer familia;
	private Integer subfamilia;

    public BusquedaPorCategorias(String texto, Integer seccion, Integer grupo, Integer familia, Integer subfamilia,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
	    this.grupo = grupo;
	    this.familia = familia;
	    this.subfamilia = subfamilia;
    }

	public Integer getGrupo() {
		return grupo;
	}

	public Integer getFamilia() {
		return familia;
	}

	public Integer getSubfamilia() {
		return subfamilia;
	}

	public boolean tieneCategoriaGrupo() {
		return (grupo != null);
	}

	public boolean tieneCategoriaFamilia() {
		return (familia != null);
	}

	public boolean tieneCategoriaSubFamilia() {
		return (subfamilia != null);
	}

    // fix mg20130823: merge con codigo provisto por Gaston
	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    SELECT");
		sql.append(Globals.ENTER).append("        a.id_articulo,");
        sql.append(Globals.ENTER).append("        a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        a.fecha_alta,");
        sql.append(Globals.ENTER).append("        a.titulo,");
        sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("       " + criterio.getAddSelect());
		sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("     articulos a");
        sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        if (soloPedidoEspecial)
        	sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );		
        else 
            sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
		sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("        AND a.categoria_grupo ").append((tieneCategoriaGrupo() ? ("= " + getGrupo()) : "is not null"));
		sql.append(Globals.ENTER).append("        AND a.categoria_familia ").append((tieneCategoriaFamilia() ? ("= " + getFamilia()) : "is not null"));
		sql.append(Globals.ENTER).append("        AND a.categoria_subfamilia ").append((tieneCategoriaSubFamilia() ? ("= " + getSubfamilia()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("       " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());        
        
        return sql;
	}

	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_CATEGORIAS);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		parametro(buffer, BuscadorHelper.CATEGORIA_GRUPO, grupo);
		parametro(buffer, BuscadorHelper.CATEGORIA_FAMILIA, familia);
		parametro(buffer, BuscadorHelper.CATEGORIA_SUBFAMILIA, subfamilia);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Categorias";
	}

	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		if (grupo != null) result.append(", Grupo: ").append(grupo);
		if (familia != null) result.append(", Familia: ").append(familia);
		if (subfamilia != null) result.append(", SubFamilia: ").append(subfamilia);
		return result.toString();
	}

}
