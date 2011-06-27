/**
 * $Log: BusquedaPorAtributosDinamicos.java,v $
 * Revision 1.6  2006/09/28 14:58:15  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.5  2005/09/15 19:19:24  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.4  2005/01/25 15:52:47  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.3  2005/01/18 14:13:00  oGPistoia
 * - Se agrega el flag de busqueda avanzada
 *
 * Revision 1.2  2005/01/17 14:50:00  oGPistoia
 * - No buscar si el valor es nulo
 *
 * Revision 1.1  2005/01/12 15:29:38  oGPistoia
 * - Buscador de Atributos Dinamicos (solo falta la pagina)
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;
import com.tmk.kernel.Pair;

import java.util.Vector;

public class BusquedaPorAtributosDinamicos extends BusquedaGenerica {

	private Integer grupo;
	private Integer familia;
	private Integer subfamilia;
	private Vector atributos;

	public BusquedaPorAtributosDinamicos(Integer seccion, Integer grupo, Integer familia, Integer subfamilia,
	                                     Integer registroInicial, Integer registroFinal,
	                                     CriterioDAO criterio,
	                                     boolean soloPedidoEspecial,
	                                     Vector atributos) {
		super(null, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
		this.grupo = grupo;
		this.familia = familia;
		this.subfamilia = subfamilia;
		this.atributos = atributos;
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

		for (int i = 0; i < atributos.size(); i++) {
			Pair elemento = (Pair) atributos.get(i);
			if ((elemento.getValue1() != null) && (elemento.getValue2() != null)) {
				sql.append(Globals.ENTER).append("        AND ").append(elemento.getValue1()).append(" = ").append(elemento.getValue2());
			}
		}
		sql.append(Globals.ENTER).append("       " + criterio.getAddWhere());
		sql.append(Globals.ENTER).append("        ").append((criterio == null) ? "" : criterio.getTextoQuery());

		return sql;
	}

	public StringBuffer getQueryParcial(Filtro filtro) {
		StringBuffer sql = new StringBuffer("");
		return sql;
	}
		
	
	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.ES_BUSQUEDA_AVANZADA, new Boolean(true));
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_ATRIBUTOS_DINAMICOS);
		parametro(buffer, BuscadorHelper.CATEGORIA_GRUPO, grupo);
		parametro(buffer, BuscadorHelper.CATEGORIA_FAMILIA, familia);
		parametro(buffer, BuscadorHelper.CATEGORIA_SUBFAMILIA, subfamilia);

		for (int i = 0; i < atributos.size(); i++) {
			Pair elemento = (Pair) atributos.get(i);
			parametro(buffer, BuscadorHelper.NOMBRE_ATRIBUTO + i, elemento.getValue1());
			parametro(buffer, BuscadorHelper.VALOR_ATRIBUTO + i, elemento.getValue2());
		}

		return buffer;
	}

	public String getNombreDeBusqueda() {
		return "Atributos Dinamicos";
	}

	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		if (grupo != null) result.append(", Grupo: ").append(grupo);
		if (familia != null) result.append(", Familia: ").append(familia);
		if (subfamilia != null) result.append(", SubFamilia: ").append(subfamilia);
		return result.toString();
	}
	
	public StringBuffer getQueryFilter(Filtro filtro,String in) {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    SELECT a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
        sql.append(Globals.ENTER).append("    FROM articulos a ");
        sql.append(Globals.ENTER).append(		  filtro.getFrom());
		sql.append(Globals.ENTER).append("    WHERE ");
        sql.append(Globals.ENTER).append("        a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(" AND ").append(in).append(" AND");
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
