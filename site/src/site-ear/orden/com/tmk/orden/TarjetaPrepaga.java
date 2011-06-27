/**
 * $Log: TarjetaPrepaga.java,v $
 * Revision 1.3  2007/12/18 20:10:35  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.2  2005/12/29 17:45:19  omsartori
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
 * Revision 1.1  2005/12/13 16:16:38  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 */
package com.tmk.orden;


import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TarjetaPrepaga {
	private String nro;
    private String estado;
	private double saldo;
    private String mensaje = "";
	private int idOrden;
	private double importeParaOrden;
	private static final String ESTADO_HABILITADO = "HA";
	private static final String ESTADO_INEXISTENTE = "2";
	private static final String TIPO_TRANSACCION = "GA";


	public TarjetaPrepaga (String nro) {
		this.nro = nro;
		try{
			cargar();
		} catch (TarjetaPrepagaException e) {
			mensaje = "Nro [" + nro + "] no puede ser utilizada. " + e.getMensajeAMostrar();
			TmkLogger.debug(getMensaje());
		} catch (Exception e) {
			mensaje = "Error en carga [" + nro + "] no puede ser utilizada. " + e.getMessage();
			TmkLogger.error(getMensaje());
		}
	}

	public TarjetaPrepaga(String nro, String estado, double saldo, int idOrden, double importeParaOrden) {
		this.nro = nro;
		this.estado = estado;
        this.saldo = saldo;
		this.idOrden = idOrden;
		this.importeParaOrden = importeParaOrden;
	}

	/*public TarjetaPrepaga (long nro, int idOrden) {
		this.nro = nro;
		try{
			cargar();
			cargarOrden(idOrden);
		} catch (TarjetaPrepagaException e) {
			mensaje = "Nro [" + nro + "] no puede ser utilizada. " + e.getMensajeAMostrar();
			TmkLogger.debug(getMensaje());
		} catch (Exception e) {
			mensaje = "Error en carga [" + nro + "] no puede ser utilizada. " + e.getMessage();
			TmkLogger.error(getMensaje());
		}
	}*/

	private void cargar() throws TarjetaPrepagaException, Exception {
		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "  SELECT tp.estado, tp.saldo" +
			        "  FROM tarjeta_prepaga tp" +
			        "  WHERE tp.nro = ?") ;
			try {
				statement.setString(1, this.nro);
				ResultSet resultSet = statement.executeQuery();
				try {
					if (resultSet.next()) {
						this.estado = resultSet.getString("estado");
						this.saldo = resultSet.getDouble("saldo");
					} else {
						this.estado = ESTADO_INEXISTENTE;
						throw new TarjetaPrepagaException("No existe");
					}
					if (!(this.estado.equals(ESTADO_HABILITADO))) {
						throw new TarjetaPrepagaException("No está habilitada. Estado " + this.estado);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public String getNro() {
        return this.nro;
	}

	public double getSaldo() {
		return Convert.round(this.saldo);
	}

	public String getEstado() {
		return this.estado;
	}

	public String getMensaje() {
		return "TARJETA PREPAGA] " + this.mensaje;
	}

	public boolean estaHabilitada() {
		return this.ESTADO_HABILITADO.equals(estado);
	}

	public double getSaldoDisponible() {
		if (estaHabilitada()) {
			return this.saldo;
		} else {
			return 0.0;
		}
	}

	public double getImporteParaOrden () {
		return Convert.round(this.importeParaOrden);
	}

	public void setImporteParaOrden (double importeParaOrden) {
		this.importeParaOrden = importeParaOrden;
	}

	public static String getCodigoDeTransaccion () {
		return TIPO_TRANSACCION;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public boolean equals(TarjetaPrepaga tarjeta) {
		if (this.nro == tarjeta.getNro()) {
			return true;
		}
		return false;
	}
}

