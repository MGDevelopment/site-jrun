/**
 * $Log: BusquedaPorIDdeAutor.java,v $
 * Revision 1.6  2007/10/18 20:06:58  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.5  2007/02/02 21:04:56  oLSuarez
 * - Mapa de entrevistas
 * - Mapa de notas de prensa
 * Se agrego linksMapa.jsp
 *
 * Revision 1.4  2006/09/28 14:58:16  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.3  2005/09/15 19:19:25  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.2  2005/08/03 16:08:56  omsartori
 * - eMPro: Ranking, links a busqueda por atributo principal y por editorial/proveedor
 *                Resultado de busqueda, texto de busqueda explicito
 * - eMPro: Seguimiento google. Reporte de visita, login y registro
 * - Mejoras: Ejb de articulo reducido en ranking, acoplamiento eliminado,
 *                 se reemplazaron los archivos de detalle de cada seccion por uno unico
 *
 * Revision 1.1  2005/07/26 14:13:40  omsartori
 * - Modificaciones en Articulo Reducido
 * - Tag de Precio para Articulo
 * - Buscador por id de autor
 * - Buscador generico por atributo principal (DROMO)
 * - Home> Articulo reemplazado por Articulo Reducido
 *
 */
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;



public class BusquedaPorIDdeAutor extends BusquedaGenerica {
    private Object idAutor;
    public BusquedaPorIDdeAutor(String texto, Object idAutor, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
	    this.idAutor = idAutor;
    }
    
    public BusquedaPorIDdeAutor(String texto, Object idAutor, Integer seccion,
            Integer registroInicial, Integer registroFinal,
            CriterioDAO criterio) {
    	super(texto, seccion, registroInicial, registroFinal, criterio);
    	this.idAutor = idAutor;
    }


	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();
//NO USAR ROLES
		sql.append(Globals.ENTER).append("    SELECT DISTINCT ");
		sql.append(Globals.ENTER).append("        a.id_articulo,");
        sql.append(Globals.ENTER).append("        a.categoria_seccion,");
        sql.append(Globals.ENTER).append("        a.fecha_alta,");
        sql.append(Globals.ENTER).append("        a.titulo,");
        sql.append(Globals.ENTER).append("        a.precio_venta_vigente");
		sql.append(Globals.ENTER).append("      " + criterio.getAddSelect());
        sql.append(Globals.ENTER).append("    FROM disponibilidades d,");
        sql.append(Globals.ENTER).append("        articulos a,");
		sql.append(Globals.ENTER).append("        articulos_autores aa,");
		sql.append(Globals.ENTER).append("        autores au");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
       	
        if(super.esTenerEnCuentaPedidoEspecial()){
        	sql.append(Globals.ENTER).append("        AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
        }
        
        sql.append(Globals.ENTER).append("        AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
        sql.append(Globals.ENTER).append("        AND habilitado_tematika = 'S'");
		sql.append(Globals.ENTER).append("        and a.activo            = 'SI'");
		sql.append(Globals.ENTER).append("        AND a.id_articulo           = aa.id_articulo");
		sql.append(Globals.ENTER).append("        AND aa.id_autor             = au.id_autor");
		sql.append(Globals.ENTER).append("        and aa.id_autor in (").append(idAutor.toString().replaceAll("\\[", "").replaceAll("\\]", "")).append(")");
		sql.append(Globals.ENTER).append("      " + criterio.getAddWhere());
        sql.append(Globals.ENTER).append("            ").append((criterio == null) ? "" : criterio.getTextoQuery());
        
		return sql;
	}

	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_IDdeAUTOR);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		parametro(buffer, BuscadorHelper.ID_AUTOR, idAutor);
		return buffer;
	}

	public String getNombreDeBusqueda() {
		return "id de Autor";
	}

}
