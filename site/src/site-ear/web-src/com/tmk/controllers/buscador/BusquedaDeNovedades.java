/**
 * $Log: BusquedaDeNovedades.java,v $
 * Revision 1.4  2006/09/28 14:58:14  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.3  2005/09/15 19:19:23  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.2  2005/01/25 15:52:44  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.1  2005/01/11 15:14:01  oGPistoia
 * - Buscador de Novedades
 *
 */
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;

public class BusquedaDeNovedades extends BusquedaGenerica {

	private Integer diasConsideradosNovedad;
	private Integer diasIgnoradosNovedad;
	private Integer grupo;
	private Integer familia;
	private Integer subfamilia;

    public BusquedaDeNovedades(Integer seccion, Integer grupo, Integer familia, Integer subfamilia,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial,
                       Integer diasConsideradosNovedad,
                       Integer diasIgnoradosNovedad) {
	    super(null, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
	    this.grupo = grupo;
	    this.familia = familia;
	    this.subfamilia = subfamilia;
	    this.diasConsideradosNovedad = (diasConsideradosNovedad == null) ? new Integer(Globals.DIAS_CONSIDERADOS_NOVEDAD) : diasConsideradosNovedad;
	    this.diasIgnoradosNovedad = (diasIgnoradosNovedad == null) ? new Integer(Globals.DIAS_IGNORADOS_NOVEDAD) : diasIgnoradosNovedad;
    }

	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("    SELECT a.id_articulo,");
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
		sql.append(Globals.ENTER).append("        AND a.categoria_grupo ").append(((grupo != null) ? ("= " + grupo) : "is not null"));
		sql.append(Globals.ENTER).append("        AND a.categoria_familia ").append(((familia != null) ? ("= " + familia) : "is not null"));
		sql.append(Globals.ENTER).append("        AND a.categoria_subfamilia ").append(((subfamilia != null) ? ("= " + subfamilia) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        AND a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        AND fecha_alta >= SYSDATE - ").append(Math.min(180, diasConsideradosNovedad.intValue())); // Limito que no pongan un maximo muy pesado
		sql.append(Globals.ENTER).append("        AND fecha_alta <= SYSDATE - ").append(Math.min(5, diasIgnoradosNovedad.intValue())); // Limito que no ignoren los productos sin restricciones
		sql.append(Globals.ENTER).append("       " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("        ").append((criterio == null) ? "" : criterio.getTextoQuery());

		return sql;
	}

	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.DE_NOVEDADES);
		parametro(buffer, BuscadorHelper.CATEGORIA_GRUPO, grupo);
		parametro(buffer, BuscadorHelper.CATEGORIA_FAMILIA, familia);
		parametro(buffer, BuscadorHelper.CATEGORIA_SUBFAMILIA, subfamilia);
		parametro(buffer, BuscadorHelper.DIAS_CONSIDERADOS_NOVEDAD, diasConsideradosNovedad);
		parametro(buffer, BuscadorHelper.DIAS_IGNORADOS_NOVEDAD, diasIgnoradosNovedad);
		return buffer;
	}

	public String getNombreDeBusqueda() {
		return "Novedades";
	}

	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		if (grupo != null) result.append(", Grupo: ").append(grupo);
		if (familia != null) result.append(", Familia: ").append(familia);
		if (subfamilia != null) result.append(", SubFamilia: ").append(subfamilia);
		if (diasConsideradosNovedad != null) result.append(", dias considerados novedad: ").append(diasConsideradosNovedad);
		if (diasIgnoradosNovedad != null) result.append(", dias ignorados novedad: ").append(diasIgnoradosNovedad);
		return result.toString();
	}
}
