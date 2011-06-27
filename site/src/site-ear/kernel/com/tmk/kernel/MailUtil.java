/**
 * $Log: MailUtil.java,v $
 * Revision 1.24  2007/10/18 20:05:15  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.23  2006/11/27 13:03:36  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.22  2006/05/03 18:16:57  omsartori
 * - Modificacion de formulario de envio de CV
 * - Modificacion del proceso de generacion de detalles para commit
 * - proceso de indices a DB
 *
 * Revision 1.21  2005/12/29 17:45:11  omsartori
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
 * Revision 1.20  2005/05/10 14:22:56  omsartori
 * - Posicionamiento: metas por secciones, sucursales. division de links a sucursales y a ranking,
 * link a detalle en resultado de busqueda, palabra de busqueda en resultado de busqueda
 *
 * Revision 1.19  2004/11/01 16:31:43  oGPistoia
 * - Cambios para evitar bloqueos en comercial por la unificacion de socios duplicados que tienen nueva cuenta eXtra
 * - Cambios en el controler de Clientes Institucionales
 * - Generadores de clases de java para parser de xmls.
 *
 * Revision 1.18  2004/10/05 21:27:58  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.17  2004/02/16 20:22:56  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.16  2003/12/04 17:19:13  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.15  2003/11/26 15:36:57  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.14  2003/11/19 18:55:27  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.13  2003/11/13 20:11:40  GPistoia
 * -Cambio de direccion para generacion de mail por temas de firewall
 * -Extensibilidad en detalles de articulos para agregar html del usuario
 * -Mejora en pantalla de estado de ordenes
 * -Sincronizacion de estadisticas
 *
 * Revision 1.12  2003/10/29 19:57:22  GPistoia
 * -Correccion de queries con *
 * -Envio de mail a callcenter
 * -Correccion en promocion, nuevo campo
 * -Numero de tarjeta completo en detalle de orden
 *
 * Revision 1.11  2003/10/23 19:05:13  GPistoia
 * -Correccion de Mas vendidos
 * -Site.xml generado en español
 * -Agregado de direccion de mail para estadisticas
 *
 * Revision 1.10  2003/10/14 08:53:27  GPistoia
 * -Mail configurable en pedido especial
 *
 * Revision 1.9  2003/10/12 22:11:25  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.8  2003/09/29 17:20:08  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.7  2003/09/04 21:39:29  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.6  2003/08/14 14:39:59  SLizardo
 * Se actualizo el Logger (Globals.XXX a TmkLogger.XXX)
 *
 * Revision 1.5  2003/08/06 21:28:22  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.4  2003/08/02 16:58:12  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.3  2003/07/28 19:21:28  GPistoia
 * -Controlador de registracion
 *
 * Revision 1.2  2003/07/22 19:48:59  GPistoia
 * -Disco V para migracion de paginas
 *
 * Revision 1.1  2003/07/21 15:07:31  GPistoia
 * -Articulo
 * -Common y conversion
 * -Funciones para consulta
 *
 */
package com.tmk.kernel;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MailUtil {

	public static void sendMail(String from, String to, String subject, String body) {
		// Manda el mail en un hilo aparte para no demorar el proceso
		if (Globals.MAIL_HABILITADO) new MailThread(from, new String[]{to}, subject, body, null, null).start();
	}

	public static void sendMail(String from, String to[], String subject, String body) {
		// Manda el mail en un hilo aparte para no demorar el proceso
		if (Globals.MAIL_HABILITADO) new MailThread(from, to, subject, body, null, null).start();
	}

	public static void sendMail(String from, String to, String subject, String body, String page) {
		// Manda el mail en un hilo aparte para no demorar el proceso
		if (Globals.MAIL_HABILITADO) new MailThread(from, new String[]{to}, subject, body, page, null).start();
	}

	public static void sendMail(String from, String to[], String subject, String body, String page) {
		// Manda el mail en un hilo aparte para no demorar el proceso
		if (Globals.MAIL_HABILITADO) new MailThread(from, to, subject, body, page, null).start();
	}
	
	public static void sendMail(String from, String to, String subject, String body, String page, File attach) {
		// Manda el mail en un hilo aparte para no demorar el proceso
		if (Globals.MAIL_HABILITADO) new MailThread(from, new String[]{to}, subject, body, page, attach).start();
	}

	public static void sendMail(String from, String to[], String subject, String body, String page, File attach) {
		// Manda el mail en un hilo aparte para no demorar el proceso
		if (Globals.MAIL_HABILITADO) new MailThread(from, to, subject, body, page, attach).start();
	}	
	
	private static class MailThread extends Thread {

		private String from;
		private String to[];
		private String subject;
		private String body;
		private String page = null;
		private String type = "text/plain";
		private File attach = null;

		public MailThread(String from, String to[], String subject, String body, String page, File attach) {
			super();
			this.from = from;
			this.to = to;
			this.subject = subject;
			this.body = body;
			this.page = page;
			this.attach = attach;
		}

		public void run() {
			// Trata de bajar el texto desde una pagina
			if ((Globals.ENVIA_MAILS_LARGOS) && (page != null)) {
				try {
					if (!page.equals("HTML")) {
						this.body = HTMLUtil.download(Globals.SERVER_MAIL + page);
						
					}
					this.type = "text/html";
				} catch (Exception e) {
					// No importa si falla porque la rutina de mail ya tiene un texto default
				}
			}
			// manda el mail
			try {
				Properties props = System.getProperties();

				props.put("mail.smtp.host", Globals.MAIL_SMTP_HOST);
				Session mailSession = Session.getDefaultInstance(props, null);

				Message msg = new MimeMessage(mailSession);

				msg.setFrom(new InternetAddress(from.toUpperCase()));

				for (int i = 0; i < to.length; i++) {
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i].toUpperCase()));
				}
				
				msg.setHeader("X-Mailer", Globals.MAIL_MAILER);
				msg.setSubject(subject);
				msg.setSentDate(new java.util.Date());
				
				if (attach != null) {
					File compressAttach = new File("attach.zip");
					ZipOutputStream out = new ZipOutputStream(new FileOutputStream(compressAttach));
					FileInputStream in = new FileInputStream(attach);
					    
		            // Add ZIP entry to output stream.
		            out.putNextEntry(new ZipEntry(attach.getName()));
		            byte[] buf = new byte[1024];
		            // Transfer bytes from the file to the ZIP file
		            int len;
		            while ((len = in.read(buf)) > 0) {
		                out.write(buf, 0, len);
		            }
		            // Complete the entry
		            out.closeEntry();
		            in.close();
		            out.close();
					
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setText(body);

				    Multipart multipart = new MimeMultipart();
				    multipart.addBodyPart(messageBodyPart);
	
				    messageBodyPart = new MimeBodyPart();
				    DataSource source = new FileDataSource(compressAttach);
				    messageBodyPart.setDataHandler( new DataHandler(source));
				    messageBodyPart.setFileName(compressAttach.getName());
				    multipart.addBodyPart(messageBodyPart);
				   
				    // Put parts in message
				    msg.setContent(multipart);
		
				}
				
				else {
					msg.setContent(body, type);
				}

				Transport.send(msg);

				for (int i = 0; i < to.length; i++) {
					TmkLogger.info("Se envio mail a " + to[i].toUpperCase() + " sobre " + subject);
				}

			} catch (Exception e) {

				TmkLogger.error("No se envio mail sobre " + subject + e.toString());
			}
		}
	}

}
