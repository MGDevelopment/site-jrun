/**
 * @author Lizardo Santiago
 *
 * $Log: RecuperarClave.java,v $
 * Revision 1.19  2008/05/30 16:06:06  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.18  2008/04/09 20:20:23  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.17  2004/04/06 22:22:43  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.16  2004/03/25 18:19:55  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.15  2003/12/22 22:28:00  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.14  2003/12/04 17:21:31  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.13  2003/11/26 15:38:16  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.12  2003/10/13 21:43:41  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.11  2003/10/13 04:32:36  SLizardo
 * Update PASSWORD
 *
 * Revision 1.10  2003/10/13 04:08:55  SLizardo
 * no message
 *
 * Revision 1.9  2003/10/07 14:56:28  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.8  2003/10/06 15:36:10  SLizardo
 * no message
 *
 * Revision 1.7  2003/10/06 14:05:36  SLizardo
 * Update Socios
 *
 * Revision 1.6  2003/10/03 16:30:32  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/09/26 15:24:48  SLizardo
 * String => StringBuffer
 *
 * Revision 1.4  2003/08/29 17:55:18  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.3  2003/08/25 20:46:12  SLizardo
 * Optimize Imports
 *
 * Revision 1.2  2003/08/12 15:10:55  SLizardo
 * Verifica si existe o no el usuario. Y se extendio el mail.
 *
 * Revision 1.1  2003/08/05 22:13:50  SLizardo
 * Se agrego el metodo findByLogin y se cambio el antiguo a findByLoginPassword
 *
 */
package com.tmk.controllers.registracion;

//import com.tmk.socio.SocioLocal;
import com.tmk.util.ShortCuts;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.bus.socio.Socios2;
import com.tmk.kernel.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public final class RecuperarClave extends HttpServlet {

	private static int cantidadPerdidaDePassword;

	public static int getCantidadPerdidaDePassword() {
		return cantidadPerdidaDePassword;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String LOGIN = request.getParameter("LOGIN").toUpperCase();
		/*DATOS para enviar por mail*/
		String nombreCompleto = "";
		String email = "";
		String clave = "";
		/*DATOS para enviar por mail*/

		
		//SocioLocal socio = ShortCuts.findSocioByLogin(LOGIN);
		Socios2  socio = ShortCuts.findSocioByLogin(LOGIN);

		SocioTMK socioTMK = new SocioTMK();

		if (socio != null) {
			//nombreCompleto = Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS());
			//email = new String(CryptUtil.desEncriptar(socio.getLOGIN()));
			//clave = new String(CryptUtil.desEncriptar(socio.getPASSWORD()));
			nombreCompleto = Convert.nombreCompleto(socio.getNombres(), socio.getApellidos());
			email = new String(CryptUtil.desEncriptar(socio.getLogin()));
			clave = new String(CryptUtil.desEncriptar(socio.getPassword()));
		} else {

			try {
				Connection conn = DBUtil.buildConnection();
				try {
					socioTMK.select(conn, new String[]{"login = '" + LOGIN + "'"});
					nombreCompleto = Convert.nombreCompleto(socioTMK.getNombres(), socioTMK.getApellidos());
					email = socioTMK.getLogin();
					clave = new String(CryptUtil.desEncriptar(socioTMK.getPassword()));
				} finally {
					conn.close();
				}
			} catch (Exception e) {}
		}

		if (socio != null || socioTMK.getIdSocio() != null) {
			TmkLogger.debug("Pedido de Clave. Login '" + LOGIN + "'");

			/*
			A PEDIDO DE DW SE CANCELA EL CAMBIO DE CLAVE, REUNION DEL DIA 30/3/2004
			String PASSWORD = this.generarPassword();
			socio.setPASSWORD(CryptUtil.encriptar(PASSWORD.getBytes()));
			*/

			StringBuffer body = new StringBuffer();

			cantidadPerdidaDePassword++;

			body.append("Estimado/a ").append(nombreCompleto).append(":").append(Globals.ENTER).append(Globals.ENTER);
			body.append("Como fue solicitado, le enviamos su contraseña para poder ingresar a ").append(Globals.NOMBRE_DEL_SITIO).append(".").append(Globals.ENTER);
			body.append(Globals.ENTER).append(Globals.ENTER);
			body.append("Email: ").append(email).append(Globals.ENTER);
			body.append("Clave: ").append(clave).append(Globals.ENTER);
			body.append(Globals.ENTER).append(Globals.ENTER);
			body.append("Muchas Gracias.").append(Globals.ENTER);

			MailUtil.sendMail(Globals.MAIL_CALL_CENTER, email, Globals.NOMBRE_DEL_SITIO + " - Pedido de Clave", body.toString());

			response.sendRedirect("/miCuenta/claveEnviada.jsp?LOGIN=" + LOGIN);
		} else {

			HttpSession session = request.getSession();
			session.setAttribute("Registracion.feedback", "El usuario \"" + LOGIN + "\" no esta registrado.");

			response.sendRedirect("/miCuenta/?seccionMiCuenta=5&LOGIN=" + LOGIN);
		}
	}

	private String generarPassword() {
		StringBuffer password = new StringBuffer();
		String letras = new String("abcdefghijklmnrstuvwxyz1234567890");

		for (int i = 0; i < 8; i++) {
			int azar = (int) (Math.random() * letras.length() + 1);

			password.append(letras.charAt(azar - 1));
		}

		return password.toString();
	}
}
