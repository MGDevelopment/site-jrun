/**
 * $Log: TarjetaRangoDAO.java,v $
 * Revision 1.1  2004/08/03 15:47:02  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 */
package com.tmk.kernel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TarjetaRangoDAO {

	private String idMedioDeCobro;
	private int cantidadCaracteres;
	private long nroDesde;
	private long nroHasta;
	private boolean permiteCuotas;
	private int longitud;

	public TarjetaRangoDAO(String idMedioDeCobro, int cantidadCaracteres, long nroDesde, long nroHasta, boolean permiteCuotas, int longitud) {
		super();
		this.idMedioDeCobro = idMedioDeCobro;
		this.cantidadCaracteres = cantidadCaracteres;
		this.nroDesde = nroDesde;
		this.nroHasta = nroHasta;
		this.permiteCuotas = permiteCuotas;
		this.longitud = longitud;
	}

	public String toString() {
		return "Tarjeta " + idMedioDeCobro + ", rango entre (" + nroDesde + "... a " + nroHasta + "...), cuotas" + Convert.toString(permiteCuotas) + " y longitud " + longitud;
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof TarjetaRangoDAO) &&
		        (idMedioDeCobro.equals(((TarjetaRangoDAO) other).idMedioDeCobro) &&
		        (nroDesde == ((TarjetaRangoDAO) other).nroDesde) &&
		        (nroHasta == ((TarjetaRangoDAO) other).nroHasta) &&
		        (permiteCuotas == ((TarjetaRangoDAO) other).permiteCuotas) &&
		        (longitud == ((TarjetaRangoDAO) other).longitud)));
	}

	public String getIdMedioDeCobro() {
		return idMedioDeCobro;
	}

	public int getCantidadCaracteres() {
		return cantidadCaracteres;
	}

	public long getNroDesde() {
		return nroDesde;
	}

	public long getNroHasta() {
		return nroHasta;
	}

	public boolean isPermiteCuotas() {
		return permiteCuotas;
	}

	public int getLongitud() {
		return longitud;
	}

	static {
		new Daemon(Daemon.DIEZ_SEGUNDOS, Daemon.UN_DIA) {
			protected void ejecutarTarea() throws Exception {
				final Vector temp = new Vector();
				DBUtil.getIdDescripcion(
				        " SELECT   id_medio_cobro, nro_desde, nro_hasta, permite_cuotas, longitud" +
				        "     FROM tarjeta_rangos" +
				        " ORDER BY id_medio_cobro, nro_desde, nro_hasta",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        String idMedioDeCobro = resultSet.getString("id_medio_cobro");

						        String nroDesdeStr = Convert.toString(resultSet.getString("nro_desde"), "");
						        String nroHastaStr = Convert.toString(resultSet.getString("nro_hasta"), "");
						        int cantidadCaracteres = Math.min(nroDesdeStr.length(), nroHastaStr.length());

						        long nroDesde = Convert.toNumber(nroDesdeStr, Long.MIN_VALUE);

						        long nroHasta = Convert.toNumber(nroHastaStr, Long.MAX_VALUE);

						        boolean permiteCuotas = Convert.toBoolean(resultSet.getString("permite_cuotas"), true);

						        int longitud = resultSet.getInt("longitud");

						        temp.add(new TarjetaRangoDAO(idMedioDeCobro, cantidadCaracteres, nroDesde, nroHasta, permiteCuotas, longitud));
					        }
				        });
				Globals.TARJETAS_RANGOS = (TarjetaRangoDAO[]) temp.toArray(new TarjetaRangoDAO[temp.size()]);
			}

			protected String getMensaje() {
				return Globals.TARJETAS_RANGOS.length + " tarjetas-rangos.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.HABILITA_CUOTAS);
			}
		};
	}

}
