/**
 * $Log: BusquedaPorMarca.java,v $
 * Revision 1.2  2006/09/28 14:58:16  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campa�as aplicadas
 *
 * Revision 1.1  2005/12/29 17:45:26  omsartori
 * * Cambios Dromo
 *    Se quitaron los datos distribuidor, proveedor e isbn.
 *    Se agregaron los datos marca y fabricante.
 *    Se agregaron los buscadores por marca y fabricante, tanto por c�digo como por palabra.
 *    Se modific� el orden de las tarjetas en el plan de pago del detalle art�culo, ahora es VIS, AME, MAS, DIN.
 *    Se agregaron los campos:
 *    Tipo de documento.
 *    Nro de Documento.
 *    Rango horario de recepci�n del pedido.
 *    Estos campos son visibles en la orden del cliente y en el detalle de orden de la intranet de TMK. Y deben completarse obligatoriamente para �rdenes que contengan art�culos de Dromo.
 *
 * * Se filtr� la localidad �ciudad aut�noma de Buenos Aires� del listado de localidades v�lidas para tmk.
 *
 * * Doc Empro 10
 *
 */
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;

public class BusquedaPorMarca extends BusquedaGenerica {

    public BusquedaPorMarca(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
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
		sql.append(Globals.ENTER).append("        cg_ref_codes c");
		sql.append(Globals.ENTER).append("      " + criterio.getAddFrom());
        sql.append(Globals.ENTER).append("    WHERE d.id_disponibilidad = a.id_disponibilidad");
        sql.append(Globals.ENTER).append("        AND d.id_esquema = 'PROD'");
        if (soloPedidoEspecial)
        	sql.append(Globals.ENTER).append("        AND a.id_disponibilidad in ( 3,1 )" );		
        else 
            sql.append(Globals.ENTER).append("        AND d.id_disponibilidad NOT IN (3)");
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

	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.CLAVE_DE_BUSQUEDA, BuscadorHelper.POR_MARCA);
		parametro(buffer, BuscadorHelper.TEXTO, texto);
		return buffer;

	}

	public String getNombreDeBusqueda() {
		return "Marca";
	}

}

