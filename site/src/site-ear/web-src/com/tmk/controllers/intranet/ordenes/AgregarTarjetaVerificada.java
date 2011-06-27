/**
 * $Log: AgregarTarjetaVerificada.java,v $
 * Revision 1.7  2005/08/29 12:30:15  omsartori
 * - Redireccionamiento de dominio configurable.
 * - Campo comentario agregado en mail de tarjetas verificadas.
 * - Correccion tamanio de imagenes en ranking.
 *
 * Revision 1.6  2005/08/25 13:43:07  omsartori
 * - Msg de bloque de IP e ip en subject del mail de alerta
 * - Mail de tarjeta verificada en formato texto (html no anda)
 * - Se intercambio el boton de referidos con el de afiliados de la home
 * - Link a seccion de ayuda en carrito
 *
 * Revision 1.5  2005/08/24 13:13:42  omsartori
 * - Modifcacion en homes.
 * - Referidos> cambio de direccion de envio
 *                      reporte de referidos por dia
 *
 * Revision 1.4  2005/08/16 16:09:24  omsartori
 * - Cambios estéticos en home
 * - Posibilidad de incluir un file html en el destacado de las home
 * - Yahoo agregado al seguimiento
 * - Se agregaron las palabras de búsqueda al reporte de seguimiento.
 *
 * Revision 1.3  2005/05/26 14:45:28  omsartori
 * - Mail de tarjetas verificadas.
 * - Pais de facturacion y tarjeta extra para reporte de compras por socios.
 * - Se elimino el cambio de modo en el revitalizer
 * - Cambio de la leyenda de entrega y tel de contacto en la compra y ayuda
 * - Vigencia del referido
 * - Promocion no acumulable con referido
 *
 * Revision 1.2  2004/03/03 22:33:55  NRodriguez
 * - correccion de bugs en base de tarjetas
 *
 * Revision 1.1  2003/10/28 00:22:07  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.1  2003/10/14 05:26:11  NRodriguez
 * - Base de tarjetas fraudulentas - tarjetas verificadas
 *
 */
package com.tmk.controllers.intranet.ordenes;

import com.tmk.admin.TarjetaVerificadaLocalHome;
import com.tmk.kernel.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AgregarTarjetaVerificada extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numeroTarjeta = Convert.toString(request.getParameter(TarjetaVerificadaHelper.NUMERO_TARJETA));
		String nombreSocio = request.getParameter(TarjetaVerificadaHelper.NOMBRE_SOCIO).toUpperCase();
		String apellidoSocio = request.getParameter(TarjetaVerificadaHelper.APELLIDO_SOCIO).toUpperCase();
		String email = request.getParameter(TarjetaVerificadaHelper.EMAIL).toUpperCase();

		String calleEnvio = request.getParameter(TarjetaVerificadaHelper.CALLE_ENVIO).toUpperCase();
		Integer numeroEnvio = Convert.toNumber(request.getParameter(TarjetaVerificadaHelper.NUMERO_ENVIO), (Integer) null);
		String edificioEnvio = request.getParameter(TarjetaVerificadaHelper.EDIFICIO_ENVIO).toUpperCase();
		Integer pisoEnvio = Convert.toNumber(request.getParameter(TarjetaVerificadaHelper.PISO_ENVIO), (Integer) null);
		String deptoEnvio = request.getParameter(TarjetaVerificadaHelper.DEPTO_ENVIO).toUpperCase();
		String cpEnvio = request.getParameter(TarjetaVerificadaHelper.CP_ENVIO).toUpperCase();

		String calleFacturacion = request.getParameter(TarjetaVerificadaHelper.CALLE_FACTURACION).toUpperCase();
		Integer numeroFacturacion = Convert.toNumber(request.getParameter(TarjetaVerificadaHelper.NUMERO_FACTURACION), (Integer) null);
		String edificioFacturacion = request.getParameter(TarjetaVerificadaHelper.EDIFICIO_FACTURACION).toUpperCase();
		Integer pisoFacturacion = Convert.toNumber(request.getParameter(TarjetaVerificadaHelper.PISO_FACTURACION), (Integer) null);
		String deptoFacturacion = request.getParameter(TarjetaVerificadaHelper.DEPTO_FACTURACION).toUpperCase();
		String cpFacturacion = request.getParameter(TarjetaVerificadaHelper.CP_FACTURACION).toUpperCase();

		Integer nivelRiesgo = Convert.toNumber(request.getParameter(TarjetaVerificadaHelper.NIVEL_RIESGO), (Integer) null);
		String comentarios = request.getParameter(TarjetaVerificadaHelper.COMENTARIOS).toUpperCase();
        StringBuffer parametros = new StringBuffer();
		parametros.append("?").append(TarjetaVerificadaHelper.CAMPO_ERROR).append("=");

		try {
			Integer id = DBUtil.getSequenceValue("tarjeta_verificada_seq");

        	TarjetaVerificadaLocalHome tarjetaVerificadaLocalHome = (TarjetaVerificadaLocalHome) DBUtil.getHome("TarjetaVerificada");

			tarjetaVerificadaLocalHome.create(
					id,
					Seguridad.encriptarTarjeta(numeroTarjeta),
					nombreSocio,
					apellidoSocio, email,
					calleEnvio, numeroEnvio, edificioEnvio, pisoEnvio,
					deptoEnvio, cpEnvio, (Integer)null,  (Integer)null, (Integer)null,
					calleFacturacion, numeroFacturacion, edificioFacturacion, pisoFacturacion,
					deptoFacturacion, cpFacturacion, (Integer)null,(Integer)null, (Integer)null,
					nivelRiesgo, comentarios);

            parametros.append("no");

			StringBuffer urlMail = new StringBuffer("");

			urlMail.append("/mailing/datosTarjetaVerificada.jsp");
			urlMail.append("?").append(TarjetaVerificadaHelper.NUMERO_TARJETA).append("=").append(numeroTarjeta);
			urlMail.append("&").append(TarjetaVerificadaHelper.NOMBRE_SOCIO).append("=").append(nombreSocio);
			urlMail.append("&").append(TarjetaVerificadaHelper.APELLIDO_SOCIO).append("=").append(apellidoSocio);
			urlMail.append("&").append(TarjetaVerificadaHelper.EMAIL).append("=").append(email);
			urlMail.append("&").append(TarjetaVerificadaHelper.CALLE_ENVIO).append("=").append(calleEnvio);
			urlMail.append("&").append(TarjetaVerificadaHelper.EDIFICIO_ENVIO).append("=").append(edificioEnvio);
			urlMail.append("&").append(TarjetaVerificadaHelper.NUMERO_ENVIO).append("=").append(numeroEnvio);
			urlMail.append("&").append(TarjetaVerificadaHelper.PISO_ENVIO).append("=").append(pisoEnvio);
			urlMail.append("&").append(TarjetaVerificadaHelper.DEPTO_ENVIO).append("=").append(deptoEnvio);
			urlMail.append("&").append(TarjetaVerificadaHelper.CP_ENVIO).append("=").append(cpEnvio);
			urlMail.append("&").append(TarjetaVerificadaHelper.CALLE_FACTURACION).append("=").append(calleFacturacion);
			urlMail.append("&").append(TarjetaVerificadaHelper.EDIFICIO_FACTURACION).append("=").append(edificioFacturacion);
			urlMail.append("&").append(TarjetaVerificadaHelper.NUMERO_FACTURACION).append("=").append(numeroFacturacion);
			urlMail.append("&").append(TarjetaVerificadaHelper.PISO_FACTURACION).append("=").append(pisoFacturacion);
			urlMail.append("&").append(TarjetaVerificadaHelper.DEPTO_FACTURACION).append("=").append(deptoFacturacion);
			urlMail.append("&").append(TarjetaVerificadaHelper.CP_FACTURACION).append("=").append(cpFacturacion);
			urlMail.append("&").append(TarjetaVerificadaHelper.NIVEL_RIESGO).append("=").append(nivelRiesgo);
			urlMail.append("&").append(TarjetaVerificadaHelper.COMENTARIOS).append("=").append(comentarios);
			urlMail.append("&").append("flagMail=s");


			StringBuffer txtMail = new StringBuffer();
			txtMail.append("Riesgo:  ").append(NivelDeRiesgoDAO.buscaNivelDeRiesgo(nivelRiesgo)).append("\n");
			txtMail.append("Tarjeta: ").append(numeroTarjeta).append("\n");
			txtMail.append("Titular: ").append(apellidoSocio).append(", ").append(nombreSocio).append("\n");
			txtMail.append("E-Mail:  ").append(email).append("\n");
            txtMail.append("Domicilio Envio: ").append("\n");
			txtMail.append("    Calle: ").append(calleEnvio).append("\n");
			txtMail.append("    Nro:   ").append(numeroEnvio).append("\n");
			txtMail.append("    Ed:    ").append(edificioEnvio).append("\n");
			txtMail.append("    Dpto:  ").append(deptoEnvio).append("\n");
			txtMail.append("    Piso:  ").append(pisoEnvio).append("\n");
			txtMail.append("    CP:    ").append(cpEnvio).append("\n");
			txtMail.append("Domicilio Facturación: ").append("\n");
			txtMail.append("    Calle: ").append(calleFacturacion).append("\n");
			txtMail.append("    Nro:   ").append(numeroFacturacion).append("\n");
			txtMail.append("    Ed:    ").append(edificioFacturacion).append("\n");
			txtMail.append("    Dpto:  ").append(deptoFacturacion).append("\n");
			txtMail.append("    Piso:  ").append(pisoFacturacion).append("\n");
			txtMail.append("    CP:    ").append(cpFacturacion).append("\n");
			txtMail.append("Comentario: ").append("\n");
			txtMail.append("   ").append(comentarios).append("\n");

            TmkLogger.debug(urlMail);
			MailUtil.sendMail(Globals.MAIL_MAILER
							  ,Globals.MAIL_TARJETAS_VERIFICADAS,
							  "TMK Tarjeta Verificada",
							  txtMail.toString());

		} catch (Exception e) {
			TmkLogger.error("Error al dar de alta tarjeta verificada");
			TmkLogger.error("Nombre socio: " + nombreSocio);
			TmkLogger.error("Apellido socio: " + apellidoSocio);
			TmkLogger.debug(e.toString());
			e.printStackTrace();


			parametros.append("si");
		}

		response.sendRedirect(TarjetaVerificadaHelper.PAGINA_ALTA + parametros.toString());
    }
}

