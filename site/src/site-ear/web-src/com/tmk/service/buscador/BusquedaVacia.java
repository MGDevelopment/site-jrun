/**
 * $Log: BusquedaVacia.java,v $
 * Revision 1.1  2005/01/25 15:52:57  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.3  2005/01/11 15:14:02  oGPistoia
 * - Buscador de Novedades
 *
 * Revision 1.2  2004/05/04 18:11:05  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.1  2004/02/11 19:34:31  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.service.buscador;

import com.tmk.kernel.Globals;

public class BusquedaVacia extends BusquedaGenerica {

	public BusquedaVacia() {
		super("especificado", null, null, null,
				BuscadorHelper.CRITERIO_DEFAULT, false);
	}

	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("    SELECT a.id_articulo,");
		sql.append(Globals.ENTER).append("        a.categoria_seccion,");
		sql.append(Globals.ENTER).append("        a.fecha_alta,");
		sql.append(Globals.ENTER).append("        a.titulo,");
		sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("    FROM articulos a");
		sql.append(Globals.ENTER).append(
				"    WHERE a.fecha_alta = trunc(SYSDATE, 'DD')");
		return sql;
	}

	public StringBuffer getQueryParcial(Filtro filtro) {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("    SELECT a.id_articulo,");
		sql.append(Globals.ENTER).append("        a.categoria_seccion,");
		sql.append(Globals.ENTER).append("        a.fecha_alta,");
		sql.append(Globals.ENTER).append("        a.titulo,");
		sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("    FROM articulos a");
		sql.append(Globals.ENTER).append(
				"    WHERE a.fecha_alta = trunc(SYSDATE, 'DD')");
		return sql;
	}

	public String getNombreDeBusqueda() {
		return "INDEFINIDA";
	}

	public StringBuffer getQueryFilter(Filtro filtro, String in) {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    SELECT a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
		sql.append(Globals.ENTER).append("    FROM articulos a ");
		sql.append(Globals.ENTER).append(filtro.getFrom());
		sql.append(Globals.ENTER).append("    WHERE ");
		sql.append(Globals.ENTER).append("        a.categoria_seccion ")
				.append(
						(tieneCategoriaSeccion() ? ("= " + getSeccion())
								: "is not null"));
		sql.append(" AND ");
		sql.append(" ( ");
		sql.append(in);
		sql.append(" ) ");
		sql.append(" AND");
		sql.append(filtro.getWhere());
		// agregado para isbn

		sql.append(Globals.ENTER).append("    UNION");
		sql.append(Globals.ENTER).append("  	 SELECT a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
		sql.append(Globals.ENTER).append("           FROM articulos a ");
		sql.append(Globals.ENTER).append(filtro.getFrom());
		sql.append(Globals.ENTER).append("          WHERE ");
		sql.append(" ( ");
		sql.append(in);
		sql.append(" ) ");
		sql.append(" and ").append(filtro.getWhere());
		sql.append(Globals.ENTER).append("    UNION");
		sql.append(Globals.ENTER).append("  	 SELECT  a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
		sql.append(Globals.ENTER).append("		 FROM articulos a");
		sql.append(Globals.ENTER).append(filtro.getFrom());
		sql.append(Globals.ENTER).append("		 WHERE");
		sql.append(" ( ");
		sql.append(in);
		sql.append(" ) ");
		sql.append(" and ").append(filtro.getWhere());
		/* sinopsis */
		sql.append(Globals.ENTER).append("    UNION");
		sql.append(Globals.ENTER).append("    SELECT  a.id_articulo");
		sql.append(Globals.ENTER).append(filtro.getSelectInterno());
		sql.append(Globals.ENTER).append("    FROM articulos a ");
		sql.append(Globals.ENTER).append(filtro.getFrom());
		sql.append(Globals.ENTER).append("    WHERE ");
		sql.append(" ( ");
		sql.append(in);
		sql.append(" ) ");
		sql.append("and ").append(filtro.getWhere());
		/* sinopsis */
		return sql;
	}
}
