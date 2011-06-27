/**
 * $Log: FidelizacionHelper.java,v $
 * Revision 1.14  2008/07/07 18:58:55  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.13  2008/05/30 16:03:10  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.12  2008/04/09 20:19:05  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.11  2007/12/18 20:10:28  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.10  2007/10/18 20:05:13  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.9  2007/09/03 13:41:20  msartori
 * no message
 *
 * Revision 1.8  2006/06/05 12:39:48  omsartori
 * - Modificacion de nuevas recomendaciones
 *
 * Revision 1.7  2006/02/28 19:45:44  omsartori
 * - Fin de ReGeneracion de imagen
 * - Fin de comentarios livra
 * - Modificacion de datos para usuarios de migracion, que no pasan a central
 *
 * Revision 1.6  2005/09/29 12:44:51  omsartori
 * - Ejb reducido en orden y en resultados de busqueda
 * - Mapa de productos
 * - Promo dia de la madre, pagina de promo.
 * - Seguimiento EMPRO, visitas por canales, registraciones por canales
 *
 * Revision 1.5  2005/03/15 12:27:58  omsartori
 * -Categoria (3,7,2,0 ) para Cheque obsequio
 * -Correccion del calculo del 5% para recargo EFCO
 * -Reemplazo de 7 x 10% en Afiliados libros
 * -Cambio en barra de titulos.
 * -Bug en lista de deseos.
 * -Eliminacion de jscript en combo convinado de localidades
 *
 * Revision 1.4  2004/11/01 16:31:40  oGPistoia
 * - Cambios para evitar bloqueos en comercial por la unificacion de socios duplicados que tienen nueva cuenta eXtra
 * - Cambios en el controler de Clientes Institucionales
 * - Generadores de clases de java para parser de xmls.
 *
 * Revision 1.3  2004/10/22 15:55:22  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.2  2004/09/23 18:44:41  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.1  2004/09/10 15:12:48  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.4  2004/08/03 15:48:46  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.3  2004/06/15 20:57:35  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.2  2004/06/09 18:50:20  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.1  2004/05/04 18:11:07  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Globals;
import com.tmk.kernel.Convert;
import com.tmk.socio.SocioLocalHome;
import com.tmk.socio.SocioLocal;
import com.tmk.socio.SocioPK;
import com.tmk.fidelizacion.PuntajeWrapper;
import com.tmk.fidelizacion.VencimientoPuntos;

import javax.naming.NamingException;
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

	public static PuntajeWrapper cargarPuntajeEnSession(HttpSession session, SocioLocal socio) {
		if (!Globals.FIDELIZACION_VIGENTE) return null;

		TmkLogger.debug("Se van a consultar los puntos");

		try {
//			 Busca los puntos para el usuario
			PuntajeWrapper puntajeWrapper = FidelizacionHelper.consultarPuntos(socio.getID_SUCURSAL(), socio.getID_SOCIO());
			if (puntajeWrapper != null) session.setAttribute("PuntajeFidelizacion", new Integer(puntajeWrapper.getPuntos()));
			return puntajeWrapper;

		} catch (Exception e1) {
			// NO PUEDE ACCEDER A LOS PUNTOS POR ID, LO HACE POR DNI
			try {
				// Busca los puntos para el usuario
				PuntajeWrapper puntajeWrapper = FidelizacionHelper.consultarPuntos(socio.getSEXO(), socio.getTIPO_DOC(), socio.getNRO_DOC(), socio.getNACIONALIDAD());
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
			SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");
			Iterator socios = socioLocalHome.findRepetidosAUnificar(puntajeWrapper.getSexo(), puntajeWrapper.getTipoDeDocumento(), new Long(puntajeWrapper.getNumeroDeDocumento()), new Integer(puntajeWrapper.getNacionalidad())).iterator();
			if (socios.hasNext()) {

				SocioLocal socio = (SocioLocal) socios.next();
				puntajeWrapper.setIdSocio(socio.getID_SOCIO().intValue());
				puntajeWrapper.setIdSucursalSocio(socio.getID_SUCURSAL().intValue());
				TmkLogger.debug("Fidelizacion] El socio se llama " + Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS()));

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
			SocioLocalHome socioHome = (SocioLocalHome) DBUtil.getHome("Socio");
			SocioPK socioPK = new SocioPK();
			socioPK.ID_SOCIO = new Integer(puntajeWrapper.getIdSocio());
			socioPK.ID_SUCURSAL = new Integer(puntajeWrapper.getIdSucursalSocio());
			SocioLocal socioLocal = socioHome.findByPrimaryKey(socioPK);
			puntajeWrapper.setNombreSocio(socioLocal.getNOMBRES());
			puntajeWrapper.setApellidoSocio(socioLocal.getAPELLIDOS());
			puntajeWrapper.setEMail(socioLocal.getE_MAIL1());	
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
