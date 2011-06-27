/**
 * @author Lizardo Santiago
 *
 * $Log: EnviarCV.java,v $
 * Revision 1.15  2009/03/11 14:46:44  msartori
 * no message
 *
 * Revision 1.14  2006/11/03 14:57:56  oLSuarez
 * Rediseño de paginas de ayuda
 * Rediseño de institucional
 * Rediseño de prensa
 * Rediseño de empleo
 *
 * Revision 1.13  2006/05/19 14:24:33  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 * Revision 1.12  2006/05/03 18:17:03  omsartori
 * - Modificacion de formulario de envio de CV
 * - Modificacion del proceso de generacion de detalles para commit
 * - proceso de indices a DB
 *
 * Revision 1.11  2004/06/30 18:23:41  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.10  2004/04/06 22:22:41  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.9  2003/11/26 15:38:13  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.8  2003/10/23 19:05:57  GPistoia
 * -Correccion de Mas vendidos
 * -Site.xml generado en español
 * -Agregado de direccion de mail para estadisticas
 *
 * Revision 1.7  2003/10/13 21:43:40  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.6  2003/10/07 16:59:27  JMembrives
 * no message
 *
 * Revision 1.5  2003/10/03 16:30:20  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.4  2003/09/04 21:40:03  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.3  2003/09/04 14:41:17  SLizardo
 * no message
 *
 * Revision 1.2  2003/09/04 14:36:43  SLizardo
 * no message
 *
 * Revision 1.1  2003/09/02 19:31:20  SLizardo
 * no message
 *
 */
package com.tmk.controllers.empleos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.LocalidadDAO;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.PaisDAO;
import com.tmk.kernel.ProvinciaDAO;

public final class EnviarCV extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String nombre = Convert.toString(request.getParameter("nombre"), "");
		String apellido = Convert.toString(request.getParameter("apellido"), "");
		String fechaNac = Convert.toString(request.getParameter("fechaNac"), "");
		String edad = Convert.toString(request.getParameter("edad"), "");
		String tipoDocumento = Convert.toString(request.getParameter("tipoDocumento"), "");
		String nroDocumento = Convert.toString(request.getParameter("nroDocumento"), "");
		String sexo = Convert.toString(request.getParameter("sexo"), "");
		String direccion = Convert.toString(request.getParameter("direccion"), "");


		PaisDAO paisDAO = Globals.ARGENTINA;
		int idProvincia = Convert.toNumber(request.getParameter("provincia"), 0);

		ProvinciaDAO provinciaDAO = paisDAO.getProvincia(idProvincia);
		String provincia = provinciaDAO.getNombre();

		int idLocalidad = Convert.toNumber(request.getParameter("localidad"), 0);

		String localidad = "";
		if (Globals.CODIGO_OTRA_LOCALIDAD == idLocalidad) {
			localidad = Convert.toString(request.getParameter("otraLocalidad"), "");
		} else {
			LocalidadDAO localidadDAO = provinciaDAO.getLocalidad(idLocalidad);
			localidad = localidadDAO.getNombre();
		}


		String codigoPostal = Convert.toString(request.getParameter("codigoPostal"), "");
		String telContacto1 = Convert.toString(request.getParameter("telContacto1"), "");
		String telContacto2 = Convert.toString(request.getParameter("telContacto2"), "");
		String email = Convert.toString(request.getParameter("email"), "");
		String nivelEstudio = Convert.toString(request.getParameter("nivelEstudio"), "");
		String estadoEstudio = Convert.toString(request.getParameter("estadoEstudio"), "");
		String institucion = Convert.toString(request.getParameter("institucion"), "");
		String ultimoCursado = Convert.toString(request.getParameter("ultimoCursado"), "");
		String areaEstudio = Convert.toString(request.getParameter("areaEstudio"), "");
		String idioma1 = Convert.toString(request.getParameter("idioma1"), "");
		String idioma2 = Convert.toString(request.getParameter("idioma2"), "");
		String idioma3 = Convert.toString(request.getParameter("idioma3"), "");
		String nivelIdioma1 = Convert.toString(request.getParameter("nivelIdioma1"), "");
		String nivelIdioma2 = Convert.toString(request.getParameter("nivelIdioma2"), "");
		String nivelIdioma3 = Convert.toString(request.getParameter("nivelIdioma3"), "");
		String otroIdioma = Convert.toString(request.getParameter("otroIdioma"), "");
		String actual = Convert.toString(request.getParameter("actual"), "");

		int cantExp = Convert.toNumber(request.getParameter("cantExp"), 0);

		String [] fechaDesde = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			fechaDesde[i] = Convert.toString(request.getParameter("fechaDesde" + (i+1)), "");
		}

		String [] fechaHasta = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			fechaHasta[i] = Convert.toString(request.getParameter("fechaHasta" + (i+1)), "");
		}

		String [] empresa = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			empresa[i] = Convert.toString(request.getParameter("empresa" + (i+1)), "");
		}

		String [] actividad = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			actividad[i] = Convert.toString(request.getParameter("actividad" + (i+1)), "");
		}

		String [] tipoCargo = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			tipoCargo[i] = Convert.toString(request.getParameter("tipoCargo" + (i+1)), "");
		}

		String [] cargo = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			cargo[i] = Convert.toString(request.getParameter("cargo" + (i+1)), "");
		}

		String [] funcion = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			funcion[i] = Convert.toString(request.getParameter("funcion" + (i+1)), "");
		}

		String [] ocupacion = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			ocupacion[i] = Convert.toString(request.getParameter("ocupacion" + (i+1)), "");
		}

		String [] motivoEgreso = new String [cantExp];
		for (int i=0; i<cantExp; i++) {
			motivoEgreso[i] = Convert.toString(request.getParameter("motivoEgreso" + (i+1)), "");
		}

		String puestoPostulado = Convert.toString(request.getParameter("puestoPostulado"), "");

		String puestoVendedor = "";
		if (puestoPostulado.equals("Vendedor")) {
			int cantTipoVendedor = Convert.toNumber(request.getParameter("cantTipoVendedor"), 0);
			for (int i=0; i<cantTipoVendedor; i++) {
				if ("on".equals(request.getParameter("tipoVendedor" + (i+1)))) {
					puestoVendedor = puestoVendedor + "&nbsp; &nbsp;" + Convert.toString(request.getParameter("tipoVendedorDesc" + (i+1)), "") + "<br>";
				}
			}
		}


		//AHORA A MOSTRAR

		StringBuffer html = new StringBuffer();

		html.append("<html><head><style>body {font-family: Verdana, Arial, Sans-Serif;font-size: 10px;}td{font-family: Verdana, Arial, Sans-Serif;");
		html.append("font-size: 11px;}select{font-family: Verdana, Arial, Sans-Serif;font-size: 11px;}input{font-family: Verdana, Arial, Sans-Serif;");
		html.append("font-size: 11px;}a{color: #000000;font-family: Verdana, Arial, Sans-Serif;font-size: 10px;}.textoSolapa{font-weight: bold;font-size: 11px;");
		html.append("text-decoration: none;}.textoTitulo{color: #990000;font-family: Verdana, Arial, Sans-Serif;font-size: 12px;}</style></head><body>");
		html.append("<table width=\"600\" style=\"border: 1px solid #59B3D9; border-top: 20px solid #59B3D9; border-bottom: 5px solid #59B3D9;\">");
		html.append("<tr><td colspan=\"2\" class=\"textoTitulo\"><br><b>&nbsp;&nbsp;&nbsp;Datos personales</b><br><br></td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Nombre</b>");
		html.append("</td><td>").append(nombre).append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Apellido</b></td><td>").append(apellido).append("</td></tr>");
		html.append("<tr><td><b>&nbsp;&nbsp;&nbsp;Fecha de Nacimiento</b></td><td>").append(fechaNac).append("&nbsp;").append(edad).append("</td></tr>");
		html.append("<tr><td><b>&nbsp;&nbsp;&nbsp;Tipo y Número de documento</b></td><td>").append(tipoDocumento).append("&nbsp;").append(nroDocumento);
		html.append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Sexo</b></td><td>").append(sexo).append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Direccion</b></td><td>");
		html.append(direccion).append("&nbsp;").append(localidad).append("&nbsp;(").append(codigoPostal).append("),&nbsp;").append(provincia).append(",&nbsp;Argentina");
		html.append("</td></tr><tr><td colspan=\"2\" class=\"textoTitulo\"><hr color=\"#59B3D9\" size=\"1\"><br><b>&nbsp;&nbsp;&nbsp;Datos Contacto<b><br><br>");
		html.append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Teléfonos</b></td><td>").append(telContacto1).append("<br>").append(telContacto2).append("</td>");
		html.append("</tr><tr><td><b>&nbsp;&nbsp;&nbsp;e-Mail</b></td><td>").append(email).append("</td></tr><tr><td colspan=\"2\"  class=\"textoTitulo\">");
		html.append("<hr color=\"#59B3D9\" size=\"1\" ><BR><b>&nbsp;&nbsp;&nbsp;Estudios</b><br><br></td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Maximo nivel alcanzado</b>");
		html.append("</td><td>").append(nivelEstudio).append("&nbsp;").append(estadoEstudio).append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Institución</b>");
		html.append("</td><td>").append(institucion).append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Ultimo año cursado</b></td><td>").append(ultimoCursado);
		html.append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Area de Estudios</b></td><td>").append(areaEstudio).append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Idioma</b>");
		html.append("</td><td>").append(idioma1).append("&nbsp;").append(nivelIdioma1).append("</td></tr>");
		if (!idioma2.equals("")) {
			html.append("<tr><td></td><td>").append(idioma2).append("&nbsp;").append(nivelIdioma2).append("</td></tr>");
		}
		if (!idioma3.equals("")) {
			html.append("<tr><td></td><td>").append(idioma3).append("&nbsp;").append(nivelIdioma3).append("</td></tr>");
		}
		if (!otroIdioma.equals("")) {
			html.append("<tr><td></td><td>").append(otroIdioma).append("</td></tr>");
		}
		if (cantExp > 0){
			html.append("<tr><td colspan=\"2\" class=\"textoTitulo\"><hr color=\"#59B3D9\" size=\"1\"><BR><b>&nbsp;&nbsp;&nbsp;Experiencia laboral</b><BR>");
			html.append("</td></tr>");
		}
		html.append("<tr><td colspan=2>");
		for (int i=0; i<cantExp; i++) {
			html.append("<table width=\"90%\" cellpadding=1 cellspacing=1 style=\"border: 1px solid #59B3D9;\"  align=\"center\"><tr><td colspan=2>");
			html.append("<table><tr><td>&nbsp;&nbsp;&nbsp;Desde el</td><td><span style=\"text-decoration:underline\">").append(fechaDesde[i]);
			html.append("</span></td><td>");
			if (i==0 && actual.equals("on")) {
				html.append("&nbsp; &nbsp;Hasta la actualidad");
			} else {
				html.append("&nbsp; &nbsp;Hasta el</td><td><span style=\"text-decoration:underline\">").append(fechaHasta[i]).append("</span>");

			}

			html.append("</td></tr></table></td></tr><tr><td width=\"230\"><b>&nbsp;&nbsp;&nbsp;Nombre de la empresa</b></td><td>");
			html.append(empresa[i]).append("</td></tr><tr><td><b>&nbsp;&nbsp;&nbsp;Actividad de la empresa</b></td><td>").append(actividad[i]);
			html.append("</td></tr><tr heigth=\"35\"><td valign=\"top\"><b>&nbsp;&nbsp;&nbsp;Cargo desempeñado</b></td><td>");
			html.append(tipoCargo[i]);
			if (tipoCargo[i].equals("Cargo ejecutivo")) {
				html.append("<br>Cargo:&nbsp;").append(cargo[i]).append("<br>Función:&nbsp;").append(funcion[i]);
			} else {
				html.append("<br>Ocupación:&nbsp;").append(ocupacion[i]);
			}
			html.append("</td></tr><tr><td></td></tr><tr><td valign=\"top\" colspan=\"2\">&nbsp;&nbsp;&nbsp;<b>Motivo de Egreso</b></td></tr><tr>");
			html.append("<td  colspan=\"2\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").append(motivoEgreso[i].replaceAll("\n","<br>")).append("</td></tr><tr><td colspan=\"2\" Style=\"font-size:5\">");
			html.append("&nbsp;</td></tr></table><br>");
		}
		html.append("</td></tr><tr><td><b>Puesto para el que se postula</b></td><td>").append(puestoPostulado).append("</td></tr>");
		if (!puestoVendedor.equals("")){
			html.append("<tr><td></td><td>").append(puestoVendedor).append("</td></tr>");
		}
		html.append("</table></body></html>");


		MailUtil.sendMail(Globals.MAIL_MAILER,
                      Globals.MAIL_OFERTA_DE_TRABAJO,
                      Globals.NOMBRE_DEL_SITIO + " - CV",
                      html.toString(),
                      "HTML");

		MailUtil.sendMail(Globals.MAIL_MAILER,
					  email,
					  Globals.NOMBRE_DEL_SITIO + " - Empleos",
					  "Gracias por haberse postulado a Grupo ILhsa s.a.<br>Sus datos han sido incorporados en nuestra base de datos y serán tenidos en cuenta para futuras búsquedas.",
					  "HTML");

		response.sendRedirect("/empleos/enviado.jsp");
	}
}
