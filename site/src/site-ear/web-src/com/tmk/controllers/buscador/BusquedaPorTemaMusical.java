/**
 * $Log: BusquedaPorTemaMusical.java,v $
 * Revision 1.4  2006/09/28 14:58:17  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.3  2006/08/02 15:20:38  omsartori
 * - Mejoras en busquedas>
 *                    Reemplazo de ejb por 1 solo qry
 *                    Hints no necesarios en qry principales eliminados
 * - Banner promos e institucionales agregados en detalle de producto
 * - Indice agregado a las busquedas por palabra clave
 * - Correccion en resaltado> tags incompletos en el corte
 * - Componente de imagen libre de ejb y qrys
 * - Componente de cotizacion parametrizado por monedas y libre de ejb
 *
 * Revision 1.2  2005/09/15 19:19:28  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/01/25 15:52:54  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.2  2004/05/04 18:11:04  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.1  2004/02/11 19:34:30  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorTemaMusical extends BusquedaGenerica {

    public BusquedaPorTemaMusical(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
    }

	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();

		sql.append(Globals.ENTER).append("SELECT ");
		sql.append(Globals.ENTER).append("       distinct");
		sql.append(Globals.ENTER).append("       a.id_articulo,");
		sql.append(Globals.ENTER).append("       a.categoria_seccion,");
		sql.append(Globals.ENTER).append("       a.fecha_alta,");
		sql.append(Globals.ENTER).append("       a.titulo,");
		sql.append(Globals.ENTER).append("       a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
		sql.append(Globals.ENTER).append("  FROM disponibilidades          d,");
		sql.append(Globals.ENTER).append("       articulos                 a,");
		sql.append(Globals.ENTER).append("       articulos_temas_musicales tm");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
		sql.append(Globals.ENTER).append(" WHERE d.pedido_especial      = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append("   and d.id_esquema = 'PROD'");
		sql.append(Globals.ENTER).append("   and d.id_disponibilidad    = a.id_disponibilidad");
		sql.append(Globals.ENTER).append("   and a.activo               = 'SI'");
		sql.append(Globals.ENTER).append("   and a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		sql.append(Globals.ENTER).append("   and a.habilitado_tematika  = 'S'");
		sql.append(Globals.ENTER).append("   and a.id_articulo          = tm.id_articulo");
		sql.append(Globals.ENTER).append("   and catsearch(tm.nombre, '").append(getTexto()).append("', '') > 0");
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());

		return sql;
	}

	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_TEMA_MUSICAL);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Tema Musical";
	}

}
