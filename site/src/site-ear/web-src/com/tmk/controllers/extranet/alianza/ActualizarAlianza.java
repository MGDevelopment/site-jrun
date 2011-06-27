/**
 * @author Lizardo Santiago
 *
 * $Log: ActualizarAlianza.java,v $
 * Revision 1.11  2004/09/07 16:15:39  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.10  2004/02/11 19:34:34  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.9  2004/02/03 03:07:16  NRodriguez
 * - nueva extranet
 *
 * Revision 1.8  2003/12/04 17:21:24  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.7  2003/11/11 14:31:41  JMembrives
 * agregado del campo PORC_COMISION_PARTICULAR en alta y modificacion.
 *
 * Revision 1.6  2003/10/29 18:11:48  SLizardo
 * Codigo de area / Numero de Telefono
 *
 */
package com.tmk.controllers.extranet.alianza;

import com.tmk.admin.*;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;
//import com.tmk.controllers.extranet.alianza.AlianzaHelper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.FinderException;
import java.io.IOException;

public final class ActualizarAlianza extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        StringBuffer respuesta = new StringBuffer("/extranet/afiliados/");

		//Integer idAlianza = Convert.toNumber(request.getParameter(AlianzaHelper.ID_ALIANZA), (Integer) null);
        Integer idAlianza = Convert.toNumber(request.getParameter("ID_ALIANZA"), (Integer) null);
		//String razonSocial = request.getParameter(AlianzaHelper.RAZON_SOCIAL);
		String razonSocial = request.getParameter("RAZON_SOCIAL");
		//String url = request.getParameter(AlianzaHelper.URL);
		String url = request.getParameter("URL");
		//String tipoNegocio = request.getParameter(AlianzaHelper.TIPO_NEGOCIO);
		String tipoNegocio = request.getParameter("TIPO_NEGOCIO");
		//String cuit = request.getParameter(AlianzaHelper.CUIT);
		String cuit = request.getParameter("CUIT");
//		String usuario = request.getParameter(AlianzaHelper.USUARIO);
		String usuario = request.getParameter("USUARIO");
		//String clave = request.getParameter(AlianzaHelper.CLAVE);
		String clave = request.getParameter("CLAVE");
		//Integer idTipoContribuyente = Convert.toNumber(request.getParameter(AlianzaHelper.ID_TIPO_CONTRIBUYENTE), (Integer) null);
		Integer idTipoContribuyente = Convert.toNumber(request.getParameter("ID_TIPO_CONTRIBUYENTE"), (Integer) null);
		//String nombreContacto = request.getParameter(AlianzaHelper.NOMBRE_CONTACTO);
		String nombreContacto = request.getParameter("NOMBRE_CONTACTO");
		//String apellidoContacto = request.getParameter(AlianzaHelper.APELLIDO_CONTACTO);
		String apellidoContacto = request.getParameter("APELLIDO_CONTACTO");
//		String cargoContacto = request.getParameter(AlianzaHelper.CARGO_CONTACTO);
		String cargoContacto = request.getParameter("CARGO_CONTACTO");
		//String nombrePagoComision = request.getParameter(AlianzaHelper.NOMBRE_PAGO_COMISION);
		String nombrePagoComision = request.getParameter("NOMBRE_PAGO_COMISION");
		//String apellidoPagoComision = request.getParameter(AlianzaHelper.APELLIDO_PAGO_COMISION);
		String apellidoPagoComision = request.getParameter("APELLIDO_PAGO_COMISION");
//		String eMail1 = request.getParameter(AlianzaHelper.E_MAIL_1);
		String eMail1 = request.getParameter("E_MAIL_1");
		//String eMail2 = request.getParameter(AlianzaHelper.E_MAIL_2);
		String eMail2 = request.getParameter("E_MAIL_2");
		//String tipoComision = request.getParameter(AlianzaHelper.TIPO_COMISION);
		String tipoComision = request.getParameter("TIPO_COMISION");
		//Double porcComisionParticular = Convert.toNumber(request.getParameter(AlianzaHelper.PORC_COMISION_PARTICULAR), (Double) null);
		Double porcComisionParticular = Convert.toNumber(request.getParameter("PORC_COMISION_PARTICULAR"), (Double) null);

		try {
			AlianzaLocalHome alianzaHome = (AlianzaLocalHome) DBUtil.getHome("Alianza");
			AlianzaLocal alianza;

			boolean esUnico;

			try {
				alianza = alianzaHome.findByUsuario(usuario);
				esUnico = (alianza.getID_ALIANZA().intValue() == idAlianza.intValue());

			} catch (FinderException e) {

				alianza = alianzaHome.findByPrimaryKey(idAlianza);
				esUnico = true;

			} catch (Exception e) {

				throw e;
			}

			if (esUnico) {
				alianza.setRAZON_SOCIAL(razonSocial);
				alianza.setURL(url);
				alianza.setTIPO_NEGOCIO(tipoNegocio);
				alianza.setCUIT(cuit);
				alianza.setUSUARIO(usuario);
				alianza.setCLAVE(clave);
				alianza.setID_TIPO_CONTRIBUYENTE(idTipoContribuyente);
				alianza.setNOMBRE_CONTACTO(nombreContacto);
				alianza.setAPELLIDO_CONTACTO(apellidoContacto);
				alianza.setCARGO_CONTACTO(cargoContacto);
				alianza.setNOMBRE_PAGO_COMISION(nombrePagoComision);
				alianza.setAPELLIDO_PAGO_COMISION(apellidoPagoComision);
				alianza.setE_MAIL_1(eMail1);
				alianza.setE_MAIL_2(eMail2);
				alianza.setTIPO_COMISION(tipoComision);
				alianza.setPORC_COMISION_PARTICULAR(porcComisionParticular);

				AlianzaTelefonoLocalHome telefonoHome = (AlianzaTelefonoLocalHome) DBUtil.getHome("AlianzaTelefono");

				//String codArea = request.getParameter(AlianzaHelper.COD_AREA);
				String codArea = request.getParameter("COD_AREA");
				//String nroTelefono = request.getParameter(AlianzaHelper.NRO_TEL);
				String nroTelefono = request.getParameter("NRO_TEL");
				//String interno = request.getParameter(AlianzaHelper.EXT_INT);
				String interno = request.getParameter("EXT_INT");

				try {
					AlianzaTelefonoLocal telefono = telefonoHome.findByPrimaryKey(new AlianzaTelefonoPK(idAlianza, "PART"));
					telefono.setCOD_AREA(codArea);
					telefono.setNRO_TEL(nroTelefono);
					telefono.setEXT_INT(interno);

				} catch (FinderException e) {
					telefonoHome.create(idAlianza, "PART", codArea, nroTelefono, interno);

				} catch (Exception e) {

					TmkLogger.error("No se pudo actualizar el telefono alianza." + e.getMessage());
					TmkLogger.error(e.getMessage());
				}

			} else {

				respuesta.append("modificarDatos.jsp?#CLAVE");
			    session.setAttribute("Extranet.errUsr", "Ya existe ese nombre de usuario. Elija otro por favor.");
			}

		} catch (Exception e) {
			TmkLogger.error("No se pudo actualizar la alianza. " + e.getMessage());
			TmkLogger.error(e.getMessage());

			respuesta.append("modificarDatos.jsp");
			session.setAttribute("Extranet.errGen", "Error al actualizar los datos, vuelvalo a intentar.");

		}

		response.sendRedirect(respuesta.toString());
	}

}
