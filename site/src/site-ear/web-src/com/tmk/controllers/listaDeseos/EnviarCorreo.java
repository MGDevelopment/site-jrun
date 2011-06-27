/**
 * @author Lizardo Santiago
 *
 * $Log: EnviarCorreo.java,v $
 * Revision 1.13  2009/03/04 12:55:05  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.12  2007/01/22 17:43:21  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.11  2004/06/30 18:23:41  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.10  2003/12/04 17:21:29  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.9  2003/11/26 15:38:14  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.8  2003/10/29 19:57:32  GPistoia
 * -Correccion de queries con *
 * -Envio de mail a callcenter
 * -Correccion en promocion, nuevo campo
 * -Numero de tarjeta completo en detalle de orden
 *
 * Revision 1.7  2003/10/28 01:40:25  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 * Revision 1.6  2003/10/14 08:31:26  SLizardo
 * no message
 *
 * Revision 1.5  2003/10/03 21:50:24  SLizardo
 * EJB de ListaDeDeseos actualizado.
 *
 */
package com.tmk.controllers.listaDeseos;

import com.tmk.bus.socio.Socios2;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.Globals;
import com.tmk.src.socio.SocioPK;
import com.tmk.soa.servicios.ServiceLocator;
//import com.tmk.socio.SocioLocal;
//import com.tmk.util.ShortCuts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.StringTokenizer;

public final class EnviarCorreo extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
	{
		HttpSession session = request.getSession();
		SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
		//SocioLocal socioLocal = ShortCuts.findSocioById(socioPK);
		Socios2 socioLocal = ServiceLocator.getSocioService().findByPK(socioPK);

		String correos = request.getParameter("correos");
		String mensaje = request.getParameter("mensaje");

		StringBuffer body = new StringBuffer();
		body.append("\n");
		body.append(mensaje);
		body.append("\n\n");
		body.append(Globals.PAGINA_SITIO).append("/listaDeseos/verLista.jsp?ID_SUCURSAL=").append(socioPK.ID_SUCURSAL).append("&ID_SOCIO=").append(socioPK.ID_SOCIO).append("\n ");
		body.append("\n");
		body.append("Ante cualquier consulta contáctese con nuestro Departamento de Servicios al\n ");
		body.append("Cliente a través de " + Globals.MAIL_CALL_CENTER + " o por teléfono al " +
		            Globals.TELEFONO_CALL_CENTER + " desde la Argentina, o al " +
		            Globals.TELEFONO_EXTERIOR_CALL_CENTER + " desde el exterior, de " +
		            Globals.HORARIO_CALL_CENTER + ".\n ");
		body.append("\n");
		body.append("Muchas gracias.");


		StringTokenizer st = new StringTokenizer(correos, ",");
		while(st.hasMoreElements())
		{
			String correo = st.nextElement().toString().trim();
			MailUtil.sendMail(
			        //socioLocal.getEMAIL(),
					socioLocal.getE_mail1(),
			        correo,
			        Globals.NOMBRE_DEL_SITIO + " - Lista de Deseos",
			        body.toString());
		}

		if(request.getParameter("_DISPACHER")== null)
			response.sendRedirect("/listaDeseos/verListaPropia.jsp");
		else
			response.sendRedirect("/miCuenta/?seccionMiCuenta=6");
	}
}
