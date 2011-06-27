package com.tmk.src.fidelizacion;

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Globals;
import com.tmk.kernel.Convert;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.bus.socio.Socios2;
import com.tmk.src.fidelizacion.PuntajeWrapper;
import com.tmk.src.fidelizacion.VencimientoPuntos;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.Iterator;

public class FidelizacionHelper {

	private static int cantidadDeConsultasDePuntosCorrectas;
	private static int cantidadDeConsultasDePuntosNoDisponibles;
	private static int cantidadDeConsultasDePuntosSinPuntos;
	private static int cantidadDeConsultasDePuntosNoHabilitadas;

	public static int getCantidadDeConsultasDePuntosCorrectas() {
		return cantidadDeConsultasDePuntosCorrectas;
	}

	public static int getCantidadDeConsultasDePuntosNoDisponibles() {
		return cantidadDeConsultasDePuntosNoDisponibles;
	}

	public static int getCantidadDeConsultasDePuntosSinPuntos() {
		return cantidadDeConsultasDePuntosSinPuntos;
	}

	public static int getCantidadDeConsultasDePuntosNoHabilitadas() {
		return cantidadDeConsultasDePuntosNoHabilitadas;
	}

	public static PuntajeWrapper consultarPuntos(String numeroDeTarjeta) throws PuntosNoDisponiblesException {

		if (!Globals.FIDELIZACION_VIGENTE) return null;

		try {
			Connection connection = DBUtil.buildConnection();

			try {

				PuntajeWrapper puntajeWrapper = new PuntajeWrapper(numeroDeTarjeta.trim());

				cargarCuentasPorTarjeta(puntajeWrapper, connection);

				cargarSociosPorCuenta(puntajeWrapper, connection);

				cargarEstadoDeTarjeta(puntajeWrapper, connection);

//				cargarPuntos(puntajeWrapper, connection);

//				cargarVencimientos(puntajeWrapper, connection);

				cargarPuntosYVencimientos(puntajeWrapper, connection);

				cargarSocio(puntajeWrapper);

				cantidadDeConsultasDePuntosCorrectas++;

				TmkLogger.debug(puntajeWrapper);
				return puntajeWrapper;
			} finally {
				connection.close();
			}
			
		} catch (Exception e) {
			cantidadDeConsultasDePuntosNoDisponibles++;
			throw new PuntosNoDisponiblesException("Verifique que la información ingresada sea correcta.");

		}
	}

	public static PuntajeWrapper consultarPuntos(String sexo, String tipoDeDocumento, long numeroDeDocumento, int nacionalidad) throws PuntosNoDisponiblesException {

		if (!Globals.FIDELIZACION_VIGENTE) return null;

		try {
			Connection connection = DBUtil.buildConnection();

			try {

				PuntajeWrapper puntajeWrapper = new PuntajeWrapper(sexo, tipoDeDocumento, numeroDeDocumento, nacionalidad);

				cargarSocioPorDocumento(puntajeWrapper);

				cargarCuentaPorSocio(puntajeWrapper, connection);

				cargarEstadoDeTarjeta(puntajeWrapper, connection);

//				cargarPuntos(puntajeWrapper, connection);

//				cargarVencimientos(puntajeWrapper, connection);

				cargarPuntosYVencimientos(puntajeWrapper, connection);

				cargarSocio(puntajeWrapper);

				cantidadDeConsultasDePuntosCorrectas++;

				TmkLogger.debug(puntajeWrapper);
				return puntajeWrapper;

			} finally {
				connection.close();
			}

		} catch (Exception e) {
			cantidadDeConsultasDePuntosNoDisponibles++;
			throw new PuntosNoDisponiblesException("Verifique que la información ingresada sea correcta.");
		}
	}

	public static PuntajeWrapper consultarPuntos(Integer sucursalSocio, Integer socio) throws PuntosNoDisponiblesException {

		if (!Globals.FIDELIZACION_VIGENTE) return null;

		try {
			Connection connection = DBUtil.buildConnection();

			try {

				PuntajeWrapper puntajeWrapper = new PuntajeWrapper(socio.intValue(), sucursalSocio.intValue());

				cargarCuentaPorSocio(puntajeWrapper, connection);

				cargarEstadoDeTarjeta(puntajeWrapper, connection);

//				cargarPuntos(puntajeWrapper, connection);

//				cargarVencimientos(puntajeWrapper, connection);

				cargarPuntosYVencimientos(puntajeWrapper, connection);

				cargarSocio(puntajeWrapper);

				cantidadDeConsultasDePuntosCorrectas++;

				TmkLogger.debug(puntajeWrapper);
				return puntajeWrapper;

			} finally {
				connection.close();
			}

		} catch (Exception e) {
			// No hubo falla, probablemente no tiene puntos aun
			cantidadDeConsultasDePuntosSinPuntos++;
			throw new PuntosNoDisponiblesException("Verifique que la información ingresada sea correcta.");
		}
	}

	public static PuntajeWrapper consultarPuntos(String sexo, String tipoDeDocumento, Long numeroDeDocumento, Integer nacionalidad) throws PuntosNoDisponiblesException {

		try {
			return consultarPuntos(sexo, tipoDeDocumento, numeroDeDocumento.longValue(), nacionalidad.intValue());

		} catch (PuntosNoDisponiblesException e) {
			throw e;

		} catch (Exception e) {
			cantidadDeConsultasDePuntosNoDisponibles++;
			throw new PuntosNoDisponiblesException("Aún no disponemos de los puntos del socio.");
		}
	}
	
	/**
	 * Override para Socios2
	 * @param puntajeWrapper
	 * @throws PuntosNoDisponiblesException
	 */
	public static PuntajeWrapper cargarPuntajeEnSession(HttpSession session, Socios2 socio) {
		if (!Globals.FIDELIZACION_VIGENTE) return null;

		TmkLogger.debug("Se van a consultar los puntos");

		try {
//			 Busca los puntos para el usuario
			PuntajeWrapper puntajeWrapper = FidelizacionHelper.consultarPuntos(socio.getId_sucursal(), socio.getId_socio());
			if (puntajeWrapper != null) session.setAttribute("PuntajeFidelizacion", new Integer(puntajeWrapper.getPuntos()));
			return puntajeWrapper;

		} catch (Exception e1) {
			// NO PUEDE ACCEDER A LOS PUNTOS POR ID, LO HACE POR DNI
			try {
				// Busca los puntos para el usuario
				PuntajeWrapper puntajeWrapper = FidelizacionHelper.consultarPuntos(socio.getSexo(), socio.getTipo_doc(), socio.getNro_doc(), socio.getNacionalidad().getIdPais());
				if (puntajeWrapper != null) session.setAttribute("PuntajeFidelizacion", new Integer(puntajeWrapper.getPuntos()));
				return puntajeWrapper;
				

			} catch (Exception e2) {
				// NO PUEDE ACCEDER A LOS PUNTOS, CONTINUA SIN MOSTRARLOS
				return null;
			}
		}
	}

	private static void cargarSocioPorDocumento(PuntajeWrapper puntajeWrapper) throws PuntosNoDisponiblesException {

		TmkLogger.debug("Fidelizacion] Carga socio por documento: sexo " + puntajeWrapper.getSexo() + ", tipo " + puntajeWrapper.getTipoDeDocumento() + ", numero " + puntajeWrapper.getNumeroDeDocumento() + " y pais " + puntajeWrapper.getNacionalidad());

		try {
			// Busca el socio por DNI
			Iterator socios = ServiceLocator.getSocioService().findRepetidosAUnificar(puntajeWrapper.getSexo(), puntajeWrapper.getTipoDeDocumento(), new Long(puntajeWrapper.getNumeroDeDocumento()), new Integer(puntajeWrapper.getNacionalidad())).iterator();
			if (socios.hasNext()) {
				Socios2 socio = (Socios2)socios.next();
				puntajeWrapper.setIdSocio(socio.getId_socio().intValue());
				puntajeWrapper.setIdSucursalSocio(socio.getId_sucursal().intValue());
				TmkLogger.debug("Fidelizacion] El socio se llama " + Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()));

			} else {
				throw new PuntosNoDisponiblesException("No está disponible la información sobre esta cuenta.");
			}
		} catch (Exception e) {
			throw new PuntosNoDisponiblesException("En este momento no podemos consultar la información.");
		}
	}

	private static void cargarCuentasPorTarjeta(PuntajeWrapper puntajeWrapper, Connection connection) throws PuntosNoDisponiblesException, SQLException {

		// Consulta de cuenta por nro de tarjeta
		TmkLogger.debug("Fidelizacion] Consulta de cuentas por tarjeta " + puntajeWrapper.getNumeroDeTarjeta() + "...");

		PreparedStatement statement = connection.prepareStatement(
		        " SELECT  1 orden," +
		        "         id_cuenta," +
		        "         id_sucursal_cuenta," +
		        "         id_cuso" +
		        "    FROM buffer_fdn_tarjetas_x_cuentas" +
		        "   WHERE nro_tarjeta = ?" +
		        "    UNION" +
		        " SELECT  2 orden," +
		        "         id_cuenta," +
		        "         id_sucursal_cuenta," +
		        "         id_cuso" +
		        "    FROM fdn_tarjetas_x_cuentas" +
		        "   WHERE nro_tarjeta = ?" +
		        " ORDER BY 1");
		try {
			int index = 0;
			statement.setString(++index, puntajeWrapper.getNumeroDeTarjeta());
			statement.setString(++index, puntajeWrapper.getNumeroDeTarjeta());

			ResultSet resultSet = statement.executeQuery();
			try {
				if (!resultSet.next()) throw new PuntosNoDisponiblesException("No está disponible la información sobre esta tarjeta.");

				puntajeWrapper.setIdCuenta(resultSet.getInt("id_cuenta"));
				puntajeWrapper.setIdSucursalCuenta(resultSet.getInt("id_sucursal_cuenta"));
				puntajeWrapper.setIdCuso(resultSet.getInt("id_cuso"));

			} finally {
				resultSet.close();
			}

		} finally {
			statement.close();
		}
	}

	private static void cargarSociosPorCuenta(PuntajeWrapper puntajeWrapper, Connection connection) throws PuntosNoDisponiblesException, SQLException {

		TmkLogger.debug("Fidelizacion] Carga socios por cuenta: sucursal " + puntajeWrapper.getIdSucursalCuenta() + ", cuenta " + puntajeWrapper.getIdCuenta() + ", cuso " + puntajeWrapper.getIdCuso());

		PreparedStatement statement = connection.prepareStatement(
		        " SELECT  1 orden," +
		        "         id_sucursal_socio," +
		        "         id_socio" +
		        "    FROM buffer_fdn_cuentas_x_socios" +
		        "   WHERE id_cuenta = ?" +
		        "     AND id_sucursal = ?" +
		        "     AND id_cuso = ?" +
		        " UNION" +
		        " SELECT  2 orden," +
		        "         id_sucursal_socio," +
		        "         id_socio" +
		        "    FROM fdn_cuentas_x_socios" +
		        "   WHERE id_cuenta = ?" +
		        "     AND id_sucursal = ?" +
		        "     AND id_cuso = ?" +
		        " ORDER BY 1");
		try {
			int index = 0;
			statement.setInt(++index, puntajeWrapper.getIdCuenta());
			statement.setInt(++index, puntajeWrapper.getIdSucursalCuenta());
			statement.setInt(++index, puntajeWrapper.getIdCuso());
			statement.setInt(++index, puntajeWrapper.getIdCuenta());
			statement.setInt(++index, puntajeWrapper.getIdSucursalCuenta());
			statement.setInt(++index, puntajeWrapper.getIdCuso());
			ResultSet resultSet = statement.executeQuery();
			try {
				if (!resultSet.next()) throw new PuntosNoDisponiblesException("No está disponible la información sobre esta tarjeta.");

				puntajeWrapper.setIdSocio(resultSet.getInt("id_socio"));
				puntajeWrapper.setIdSucursalSocio(resultSet.getInt("id_sucursal_socio"));

			} finally {
				resultSet.close();
			}

		} finally {
			statement.close();
		}
	}

	private static void cargarEstadoDeTarjeta(PuntajeWrapper puntajeWrapper, Connection connection) throws PuntosNoDisponiblesException, SQLException {

		TmkLogger.debug("Fidelizacion] Estado de la tarjeta...");

		PreparedStatement statement = connection.prepareStatement(
		        " SELECT   1 orden," +
		        "  	       tarj.estado estado," +
		        "          dom.rv_meaning descripcion, tacu.nro_tarjeta nro_tarjeta" +
		        "     FROM buffer_fdn_cuentas_x_socios cuso," +
		        "          buffer_fdn_tarjetas_x_cuentas tacu," +
		        "          buffer_fdn_tarjetas tarj," +
		        "          cg_ref_codes dom" +
		        "    WHERE cuso.id_cuenta = ?" +
		        "      AND cuso.id_sucursal = ?" +
		        "      AND cuso.id_socio = ?" +
		        "      AND cuso.id_sucursal_socio = ?" +
		        "      AND cuso.id_cuenta = tacu.id_cuenta" +
		        "      AND cuso.id_sucursal = tacu.id_sucursal_cuenta" +
		        "      AND cuso.id_cuso = tacu.id_cuso" +
		        "      AND tacu.nro_tarjeta = tarj.nro_tarjeta" +
		        "      AND tarj.estado = dom.rv_low_value" +
		        "      AND dom.rv_domain = 'FDN_TARJ_ESTADO'" +
		        " UNION" +
		        " SELECT   2," +
		        "        tarj.estado," +
		        "        dom.rv_meaning, tacu.nro_tarjeta nro_tarjeta" +
		        "   FROM fdn_cuentas_x_socios cuso," +
		        "        fdn_tarjetas_x_cuentas tacu," +
		        "        fdn_tarjetas tarj," +
		        "        cg_ref_codes dom" +
		        "  WHERE cuso.id_cuenta = ?" +
		        "    AND cuso.id_sucursal = ?" +
		        "    AND cuso.id_socio = ?" +
		        "    AND cuso.id_sucursal_socio = ?" +
		        "    AND cuso.id_cuenta = tacu.id_cuenta" +
		        "    AND cuso.id_sucursal = tacu.id_sucursal_cuenta" +
		        "    AND cuso.id_cuso = tacu.id_cuso" +
		        "    AND tacu.nro_tarjeta = tarj.nro_tarjeta" +
		        "    AND tarj.estado = dom.rv_low_value" +
		        "    AND dom.rv_domain = 'FDN_TARJ_ESTADO'" +
		        " ORDER BY 1");
		try {
			int index = 0;
			statement.setInt(++index, puntajeWrapper.getIdCuenta());
			statement.setInt(++index, puntajeWrapper.getIdSucursalCuenta());
			statement.setInt(++index, puntajeWrapper.getIdSocio());
			statement.setInt(++index, puntajeWrapper.getIdSucursalSocio());
			statement.setInt(++index, puntajeWrapper.getIdCuenta());
			statement.setInt(++index, puntajeWrapper.getIdSucursalCuenta());
			statement.setInt(++index, puntajeWrapper.getIdSocio());
			statement.setInt(++index, puntajeWrapper.getIdSucursalSocio());
			ResultSet resultSet = statement.executeQuery();
			try {

				boolean encontroTarjetaHabilitada = false;
				while (resultSet.next() && (!encontroTarjetaHabilitada)) {
					TmkLogger.debug("Fidelizacion] Estado de la tarjeta: " + resultSet.getString("descripcion"));

					// Pregunta por el estado de la cuenta
					String estado = resultSet.getString("estado");
					if ("HA".equalsIgnoreCase(estado)) {
						puntajeWrapper.setNumeroDeTarjeta(resultSet.getString("nro_tarjeta"));
						encontroTarjetaHabilitada = true;
					}
				}

				// La encontro?
				if (encontroTarjetaHabilitada) {
					TmkLogger.debug("Fidelizacion] Se encontro la tarjeta " + puntajeWrapper.getNumeroDeTarjeta());
				} else {
					cantidadDeConsultasDePuntosNoHabilitadas++;
					throw new PuntosNoDisponiblesException("Lamentablemente la cuenta no se encuentra habilitada.");
				}

			} finally {
				resultSet.close();
			}

		} finally {
			statement.close();
		}
	}

	private static void cargarPuntos(PuntajeWrapper puntajeWrapper, Connection connection) throws SQLException {

		TmkLogger.debug("Fidelizacion] Consulta de puntos: Cuenta " + puntajeWrapper.getIdCuenta() + ", sucursal " + puntajeWrapper.getIdSucursalCuenta() + "...");

		PreparedStatement statement = connection.prepareStatement(
		        " SELECT   SUM(puntos) puntos" +
		        "     FROM fdn_puntos_x_sucursal" +
		        "    WHERE id_cuenta = ?" +
		        "      AND id_sucursal_cuenta = ?" +
		        "      AND id_sucursal = ?" +
		        " GROUP BY id_cuenta" +
		        " UNION ALL" +
		        " SELECT   SUM(puntos) puntos" +
		        "     FROM snp_fdn_puntos_x_sucursal" +
		        "    WHERE id_cuenta = ?" +
		        "      AND id_sucursal_cuenta = ?" +
		        "      AND id_sucursal != ?" +
		        " GROUP BY id_cuenta," +
		        "          id_sucursal_cuenta");
		try {
			int index = 0;
			statement.setInt(++index, puntajeWrapper.getIdCuenta());
			statement.setInt(++index, puntajeWrapper.getIdSucursalCuenta());
			statement.setInt(++index, Globals.FDN_ID_SUCURSAL_FIDELIZACION_SITIO);
			statement.setInt(++index, puntajeWrapper.getIdCuenta());
			statement.setInt(++index, puntajeWrapper.getIdSucursalCuenta());
			statement.setInt(++index, Globals.FDN_ID_SUCURSAL_FIDELIZACION_SITIO);
			ResultSet resultSet = statement.executeQuery();
			try {
				int puntos = 0;
				while (resultSet.next()) {
					puntos += resultSet.getInt("puntos");
				}
				puntajeWrapper.setPuntos(puntos);

			} finally {
				resultSet.close();
			}

		} finally {
			statement.close();
		}
	}

	private static void cargarSocio(PuntajeWrapper puntajeWrapper) {
		try {
			//SocioLocalHome socioHome = (SocioLocalHome) DBUtil.getHome("Socio");
			SocioPK socioPK = new SocioPK();
			socioPK.ID_SOCIO = new Integer(puntajeWrapper.getIdSocio());
			socioPK.ID_SUCURSAL = new Integer(puntajeWrapper.getIdSucursalSocio());
			
			//SocioLocal socioLocal = socioHome.findByPrimaryKey(socioPK);
			Socios2  socioLocal = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
			puntajeWrapper.setNombreSocio(socioLocal.getNombres());
			puntajeWrapper.setApellidoSocio(socioLocal.getApellidos());
			puntajeWrapper.setEMail(socioLocal.getE_mail1());	
		} catch (Exception e) {
			// Si no tuviera nombre, continua vacio
			TmkLogger.debug("Fidelizacion] No se pudo cargar el nombre del socio");
		}
	}

	private static void cargarCuentaPorSocio(PuntajeWrapper puntajeWrapper, Connection connection) throws PuntosNoDisponiblesException, SQLException {

		TmkLogger.debug("Fidelizacion] Carga cuenta por socio: sucursal " + puntajeWrapper.getIdSucursalSocio() + ", socio " + puntajeWrapper.getIdSocio());

		PreparedStatement statement = connection.prepareStatement(
				" SELECT * FROM (" +	
		        " SELECT cuso.id_cuenta id_cuenta," +
		        "        cuso.id_sucursal id_sucursal_cuenta," +
		        "        cuso.id_socio id_socio," +
		        "        cuso.componente componente," +
		        "        cuso.id_sucursal_socio" +
		        "   FROM buffer_fdn_cuentas_x_socios cuso" +
		        "  WHERE cuso.id_socio = ?" +
		        "    AND cuso.id_sucursal_socio = ?" +
		        "  UNION" +
		        " SELECT cuso.id_cuenta id_cuenta," +
		        "        cuso.id_sucursal id_sucursal," +
		        "        cuso.id_socio id_socio," +
		        "        cuso.componente componente," +
		        "        cuso.id_sucursal_socio" +
		        "   FROM fdn_cuentas_x_socios cuso" +
		        "  WHERE cuso.id_socio = ?" +
		        "    AND cuso.id_sucursal_socio = ?) WHERE componente< 80 Order by componente");
		try {
			int index = 0;
			statement.setInt(++index, puntajeWrapper.getIdSocio());
			statement.setInt(++index, puntajeWrapper.getIdSucursalSocio());
			statement.setInt(++index, puntajeWrapper.getIdSocio());
			statement.setInt(++index, puntajeWrapper.getIdSucursalSocio());
			ResultSet resultSet = statement.executeQuery();
			try {
				if (!resultSet.next()) throw new PuntosNoDisponiblesException("No está disponible la información sobre esta tarjeta.");

				puntajeWrapper.setIdCuenta(resultSet.getInt("id_cuenta"));
				puntajeWrapper.setIdSucursalCuenta(resultSet.getInt("id_sucursal_cuenta"));
				puntajeWrapper.setComponente(resultSet.getInt("componente"));
				TmkLogger.debug("Fidelizacion] Sucursal " + puntajeWrapper.getIdSucursalSocio() + ", Socio " + puntajeWrapper.getIdSocio() + ") Cuenta " + puntajeWrapper.getIdCuenta() + ", sucursal cuenta " + puntajeWrapper.getIdSucursalCuenta());

			} finally {
				resultSet.close();
			}

		} finally {
			statement.close();
		}
	}

	public static void cargarPuntosYVencimientos(PuntajeWrapper puntajeWrapper, Connection connection) {
		try {
			boolean esGold = false;
			CallableStatement puntosYVencimientos = connection.prepareCall("{call Fdn_Operaciones.obtener_vencimientos(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			try {
				int index = 0;
				puntosYVencimientos.setInt(++index, Globals.FDN_ID_SUCURSAL_FIDELIZACION_SITIO);
				puntosYVencimientos.setInt(++index, puntajeWrapper.getIdCuenta());
				puntosYVencimientos.setInt(++index, puntajeWrapper.getIdSucursalCuenta());
				puntosYVencimientos.registerOutParameter (++index, java.sql.Types.INTEGER);
				puntosYVencimientos.registerOutParameter(++index, java.sql.Types.DATE);
				puntosYVencimientos.registerOutParameter(++index, java.sql.Types.INTEGER);
				puntosYVencimientos.registerOutParameter(++index, java.sql.Types.DATE);
				puntosYVencimientos.registerOutParameter(++index, java.sql.Types.INTEGER);
				puntosYVencimientos.registerOutParameter(++index, java.sql.Types.DATE);
				puntosYVencimientos.execute();
				
				puntajeWrapper.setPuntos(puntosYVencimientos.getInt(4) + puntosYVencimientos.getInt(6) + puntosYVencimientos.getInt(8));
				try {
					CallableStatement gold = connection.prepareCall("{? = call Fdn_Operaciones.es_gold (?, ?)}");
					try {
						int index2 = 0;
						gold.registerOutParameter(++index2, java.sql.Types.INTEGER);
						gold.setInt(++index2, puntajeWrapper.getIdSucursalSocio());
						gold.setInt(++index2, puntajeWrapper.getIdSocio());
						gold.execute();
						esGold = (gold.getInt(1) == 1)?true:false;
					} finally {
						gold.close();
					}
				} catch (Exception e) {
					TmkLogger.debug("No se puede determinar si es cliente gold " + e.toString());
				} 
				puntajeWrapper.setGold(esGold);
				if (!puntajeWrapper.esGold()) {
					VencimientoPuntos vencimiento = new VencimientoPuntos(puntosYVencimientos.getDate(5), puntosYVencimientos.getInt(4));
					puntajeWrapper.addVencimiento(vencimiento);
					vencimiento = new VencimientoPuntos(puntosYVencimientos.getDate(7), puntosYVencimientos.getInt(6));
					puntajeWrapper.addVencimiento(vencimiento);
					vencimiento = new VencimientoPuntos(puntosYVencimientos.getDate(9), puntosYVencimientos.getInt(8));
					puntajeWrapper.addVencimiento(vencimiento);
				}	
			} finally {
				puntosYVencimientos.close();
			}
        } catch (Exception e) {
        	TmkLogger.debug("No se pueden calcular los puntos " + e.toString());
        }
	}

}
