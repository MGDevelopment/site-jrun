/**
 * $Log: SeleccionarMedioDeCobro.java,v $
 * Revision 1.34  2008/12/03 12:40:48  msartori
 * - Mesa Interactiva
 * - Vencimiento cheque obsequio por parametro
 * - Version 1.3 de xstream
 *
 * Revision 1.33  2006/08/14 13:29:23  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.32  2006/06/22 18:31:39  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.31  2006/03/22 15:01:01  omsartori
 * - Pantallas de primer capitulo, biografias, indice de contenidos -> rediseñadas
 * - Generador de imagenes nuevas
 * - Correcciones en la aplicacion para cambios en base por backup
 * - Correccion en generacion de directorio
 *
 * Revision 1.30  2005/12/29 17:45:27  omsartori
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
 * Revision 1.29  2005/12/13 16:16:45  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.28  2005/11/24 15:28:13  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.27  2005/11/14 13:47:54  omsartori
 * -Cheque Obsequio Monsanto
 *
 * Revision 1.26  2005/11/04 12:55:42  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 * Revision 1.24  2005/10/11 16:04:47  omsartori
 * - Seguimiento EMPRO
 *     - Visitas x canal
 *     - Compras x canal
 *     - Registraciones x canal
 *     - Ingresos al detalle de articulo x canal
 * - Filtro de texto en formato de Articulo
 * - Campo adicional en la orden para envios a Brasil (CPF CNPJ)
 *
 * Revision 1.23  2005/06/28 16:37:44  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.22  2005/02/23 13:45:31  omsartori
 * - ingreso a referidos desde mi cuenta.
 * - recuperacion del referido si se cae la sesion
 * - reconocimiento del referente
 * - compra del referente
 *
 * Revision 1.21  2005/02/18 13:15:36  omsartori
 * - Correccion en promociones, no enviaba el total de impuestos cuando era mas de un articulo, no grababa las promos sin impuestos.
 *
 * Revision 1.20  2005/01/25 15:52:59  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.19  2004/10/22 15:55:38  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.18  2004/09/30 14:17:28  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.17  2004/09/10 15:13:20  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.16  2004/08/03 15:48:46  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.15  2004/02/16 20:24:22  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.14  2004/01/08 20:30:22  GPistoia
 * - Retoques por release, antes del buscador
 *
 * Revision 1.13  2003/11/19 18:55:48  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.12  2003/10/03 16:30:19  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.11  2003/09/25 19:17:21  GPistoia
 * -Soporte Orden migrada
 * -Metodos en Articulo (sinopsis y directores)
 * -Funciones de presentacion
 *
 * Revision 1.10  2003/09/17 19:32:17  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.9  2003/09/16 19:31:09  GPistoia
 * -Se agrego la posibilidad de seleccionar nivel de log
 * -Capacidad de limitar la cantidad de caracteres a grabar de la tarjeta
 * -Bug de acentos y tildes contra javascript
 *
 * Revision 1.8  2003/09/09 17:49:50  SLizardo
 * Modificacion del SocioPK.
 *
 * Revision 1.7  2003/09/08 13:54:45  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.6  2003/08/27 21:17:54  GPistoia
 * -Ordenes pendientes con tarjeta y sin tarjeta
 *
 * Revision 1.5  2003/08/25 20:46:28  SLizardo
 * Optimize Imports
 *
 * Revision 1.4  2003/08/21 17:48:39  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.3  2003/08/12 16:26:11  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.2  2003/08/06 21:29:28  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.1  2003/08/04 22:17:59  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.1  2003/08/02 16:58:33  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 */
package com.tmk.controllers.compra;

import com.tmk.kernel.*;
import com.tmk.orden.OrdenDAO;
import com.tmk.orden.TarjetaPrepaga;
import com.tmk.src.socio.SocioPK;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.socio.TarjetaSocioLocal;
import com.tmk.socio.TarjetaSocioLocalHome;
import com.tmk.src.fidelizacion.PuntajeWrapper;
import com.tmk.src.fidelizacion.FidelizacionHelper;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.referido.ReferidoManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class SeleccionarMedioDeCobro extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//boolean esProcesoNuevo = session.getAttribute("procesoDeCompraNuevo")!=null && session.getAttribute("procesoDeCompraNuevo").equals("true");
		boolean esProcesoNuevo = ProcesoCompraUtilImp.getInstance().esProcesoNueo(request);
		OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");
		if (!CompraHelper.continuaProceso(request, response, ordenDAO)) return;
		// los cupones permiten promociones especiales
		//ordenDAO.setCupon((ReferidoManager.getCuponReferente(request)!="")? ReferidoManager.getCuponReferido(request): (ReferidoManager.getCuponReferido(request))?  :request.getParameter(CompraHelper.CAMPO_CUPON));

		// PROGRAMA DE REFERIDO
		String cupon = Convert.toString(Convert.toString(request.getParameter(CompraHelper.CAMPO_CUPON), (String) session.getAttribute(CompraHelper.PARAMETRO_CUPON)), "");
		if (cupon==null || (cupon!=null && cupon.equals("")))  {
			cupon = ReferidoManager.getCuponReferente(request);
		}
		// PROGRAMA DE REFERIDO
		if (cupon==null || (cupon!=null && cupon.equals("")))  {
			cupon = ReferidoManager.getCuponReferido(request);
		}
		if(cupon.length()>20)
			cupon=cupon.substring(0, 20);		
		/*Me fijo si el cupon es un cheque virtual o cupon de promo*/
		boolean esCheque = false;
		boolean esCupon = false;
		boolean estaVencido = true;
		if (cupon != null && !"".equals(cupon)) {
			if (cupon.length() == 13 && Convert.toNumber(cupon, new Long(0).longValue()) != 0) {
				try {
					Date auxFecha  = ServiceLocator.getCuponService().getFecha(cupon);
					if(auxFecha != null) {
						Calendar fechaVenChq = Calendar.getInstance();
						fechaVenChq.setTime(auxFecha);
						Calendar fechaHoy = Calendar.getInstance();
						int dia = DBUtil.getParameterInt("CHEQUE_OBSEQUIO_VIRTUAL_DIAS_VIGENCIA");
						fechaVenChq.add(Calendar.DATE, dia);
						if(fechaVenChq.after(fechaHoy) || fechaVenChq.equals(fechaHoy)) {
							estaVencido = false;
						}
						esCheque = true;					}
				} catch (Exception e) {
					TmkLogger.error("Error en validacion de cheque " + e.toString() + MainHelper.getMessage(e));
				}
			} else {
				try {
					esCupon = ServiceLocator.getCuponService().esCupon(cupon);
				} catch (Exception e) {
					TmkLogger.error("Error en validacion de cheque " + e.toString() + MainHelper.getMessage(e));
				}
			}
		}
		/*Me fijo si el cupon es un cheque virtual o cupon de promo*/

		if ((!esCheque || estaVencido) && !esCupon) {
			cupon = null;
		}
		ordenDAO.setCupon(cupon);
		// Se fija como va a pagar
		String claveMedioDeCobro = request.getParameter(CompraHelper.CAMPO_MEDIO_COBRO);

		// Como paga realmente
		MedioDeCobroDAO medioDeCobroDAO = (Globals.TIPO_MEDIO_DE_COBRO_TARJETAS.equalsIgnoreCase(claveMedioDeCobro))
		        ? MedioDeCobroDAO.buscaMedioDeCobro(request.getParameter(CompraHelper.CAMPO_TIPO_TARJETA))
		        : MedioDeCobroDAO.buscaMedioDeCobro(claveMedioDeCobro);

		        TmkLogger.debug("MEDIO]" + medioDeCobroDAO.getId());

		String telefonoContacto;
		String horarioContacto;
		String comentario;
		telefonoContacto = request.getParameter(CompraHelper.CAMPO_TELEFONO);
		horarioContacto = request.getParameter(CompraHelper.CAMPO_HORARIO);
		//EL CAMPO HORARIO SE CARGA AHORA CUANDO SELECCIONO EL DOMICILIO EN LA UI NUEVA.		
		//if(!esProcesoNuevo) {
			//comentario = request.getParameter(CompraHelper.CAMPO_COMENTARIO);			
		//}else {
			//datos ya cargados en la SeleccionarDomicilio.java(por que se traslada la  logica por nueva UI)
			comentario = ordenDAO.getComentario();			
		//}
		ordenDAO.completarDatosMedioDeCobro(
		        telefonoContacto, horarioContacto, comentario,
		        medioDeCobroDAO,
		        Globals.ESTADO_ORDEN_DATOS_A_COMPLETAR.getId()
		);
		// Eliminar la parte de cuotas por si no es tarjeta

		ordenDAO.completarDatosTarjeta(null, null, 0, 0, null, null, 0, null);
		ordenDAO.setTarjetaPlanDAO(null);

		// Si es tarjeta
		if (medioDeCobroDAO.esTarjeta()) {
            // Saca los valores para la tarjeta
			String numeroTarjeta = Convert.toString(request.getParameter(CompraHelper.CAMPO_NUMERO_TARJETA), "");
			numeroTarjeta = numeroTarjeta.replaceAll(" ", "").replaceAll("-", "");
			String titular = Convert.toString(request.getParameter(CompraHelper.CAMPO_TITULAR), null);
			String codigoSeguridad = Convert.toString(request.getParameter(CompraHelper.CAMPO_CODIGO), null);
			int mes = Convert.toNumber(request.getParameter(CompraHelper.CAMPO_MES), 0);
			int anio = Convert.toNumber(request.getParameter(CompraHelper.CAMPO_ANO), 0);
			String tipoDoc = Convert.toString(request.getParameter(CompraHelper.CAMPO_TIPO_DOC), null);
			long numeroDoc = Convert.toNumber(request.getParameter(CompraHelper.CAMPO_NRO_DOC), (long) 0);
			String domicilioEnvio = Convert.toString(request.getParameter(CompraHelper.CAMPO_DOMICILIO_ENVIO), null);

			// pone los campos
			ordenDAO.completarDatosTarjeta(
			        numeroTarjeta, codigoSeguridad, mes, anio, titular,
			        tipoDoc, numeroDoc, domicilioEnvio,
			        medioDeCobroDAO,
			        Globals.ESTADO_ORDEN_A_CONTROL_FRAUDE.getId()
			 );

			// Busca el plan de acuerdo a la clave seleccionada
			String clavePlanDeCuotas = request.getParameter(CompraHelper.CAMPO_PLAN_DE_CUOTAS);
			TarjetaPlanDAO tarjetaPlanDAO = (Globals.HABILITA_CUOTAS && (clavePlanDeCuotas != null)) ? TarjetaPlanDAO.get(clavePlanDeCuotas) : null;
			// Se guarda el plan de pago
			ordenDAO.setTarjetaPlanDAO(tarjetaPlanDAO);

			try {
				SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
		 		TarjetaSocioLocalHome tarjetaSocioLocalHome = (TarjetaSocioLocalHome) DBUtil.getHome("TarjetaSocio");
                Iterator tarjetasSocio = tarjetaSocioLocalHome.findBySocio(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO).iterator();
				// Si la tarjeta es la misma que la usada antes, entonces no graba de nuevo

				boolean foundTarjeta = false;
				while (tarjetasSocio.hasNext() && !foundTarjeta) {
					TarjetaSocioLocal tarjetaSocioLocal = (TarjetaSocioLocal) tarjetasSocio.next();
					foundTarjeta = ordenDAO.tarjetasIguales(tarjetaSocioLocal.getNRO_TARJETA());
				}
				ordenDAO.setTarjetaNueva(!foundTarjeta);

				ordenDAO.setPinValido(CompraHelper.esPinValido(numeroTarjeta, medioDeCobroDAO.getId()));
			} catch (Exception e) {
				TmkLogger.error("No se encontro la busqueda de tarjeta de socio.");
				CompraHelper.redirectTo(response, CompraHelper.PAGINA_PAGO_CON_FALLAS);
            	return;
			}
		}

		if (medioDeCobroDAO.esTarjetaPrePaga()) {
			TmkLogger.debug("Es Tarjeta Prepaga");
			ordenDAO.removeTarjetasPrepagas();
			for (int i=0; i<5; i++) {
				String nroTarjeta = request.getParameter(CompraHelper.CAMPO_TARJETA_PREPAGA + i);
				if (nroTarjeta != null && !nroTarjeta.equals("")) {
					ordenDAO.addTarjetaPrepaga(new TarjetaPrepaga(nroTarjeta));
				}
			}
		}

		// Guarda los datos de la tarjeta extra
		ordenDAO.setNumeroTarjetaExtra(null);
		ordenDAO.setPuntajeWrapper(null);
		// Ahora se fija si puede setear la cuenta para puntos
		if (Globals.FIDELIZACION_VIGENTE) {
			String tarjetaExtra = Convert.toString(request.getParameter(CompraHelper.CAMPO_TARJETA_EXTRA), null);
			ordenDAO.setNumeroTarjetaExtra(tarjetaExtra);
			try {
				if (tarjetaExtra == null) {
					// No asigna los puntos a ninguna cuenta
					TmkLogger.debug("No se especifico ninguna tarjeta eXtra");
				} else {

					PuntajeWrapper puntajeWrapper = FidelizacionHelper.consultarPuntos(tarjetaExtra);					
					com.tmk.fidelizacion.PuntajeWrapper puntajeEjb = new com.tmk.fidelizacion.PuntajeWrapper(puntajeWrapper.getNumeroDeTarjeta());
					
					puntajeEjb.setApellidoSocio(puntajeWrapper.getApellidoSocio());
					puntajeEjb.setComponente(puntajeWrapper.getComponente());
					puntajeEjb.setEMail(puntajeWrapper.getEMail());
					puntajeEjb.setEsGold(puntajeWrapper.isEsGold());
					puntajeEjb.setIdCuenta(puntajeWrapper.getIdCuenta());
					puntajeEjb.setIdCuso(puntajeWrapper.getIdCuso());
					puntajeEjb.setIdSucursalSocio(puntajeWrapper.getIdSucursalSocio());
					puntajeEjb.setIdSocio(puntajeWrapper.getIdSocio());
					puntajeEjb.setIdSucursalCuenta(puntajeWrapper.getIdSucursalCuenta());
					puntajeEjb.setNacionalidad(puntajeWrapper.getNacionalidad());
					puntajeEjb.setNombreSocio(puntajeWrapper.getNombreSocio());
					puntajeEjb.setNumeroDeDocumento(puntajeWrapper.getNumeroDeDocumento());
					puntajeEjb.setPuntos(puntajeWrapper.getPuntos());
					puntajeEjb.setSexo(puntajeWrapper.getSexo());
					puntajeEjb.setTipoDeDocumento(puntajeWrapper.getTipoDeDocumento());
					
					com.tmk.fidelizacion.VencimientoPuntos[] vencimientosEjb = new com.tmk.fidelizacion.VencimientoPuntos[puntajeWrapper.getVencimientosPuntos().length]; 
					for(int i=0;i<puntajeWrapper.getVencimientosPuntos().length;i++) {
						vencimientosEjb[i] = new com.tmk.fidelizacion.VencimientoPuntos(puntajeWrapper.getVencimientosPuntos()[i].getFecha(),puntajeWrapper.getVencimientosPuntos()[i].getPuntos()); 
					}
					puntajeEjb.setVencimientoPuntos(vencimientosEjb);
					
					ordenDAO.setPuntajeWrapper(puntajeEjb);
					//ordenDAO.setPuntajeWrapper(puntajeWrapper);
				}
			} catch (Exception e) {
				TmkLogger.debug("Fallo al buscar la tarjeta eXtra " + tarjetaExtra);
			}
		}

		if (request.getParameter(CompraHelper.ES_CPF_CNPJ) != null) {
			ordenDAO.setCPF_CNPJ(request.getParameter(CompraHelper.ES_CPF_CNPJ) + " " + request.getParameter(CompraHelper.CAMPO_CPF_CNPJ));
		}

		// Toma el nombre de a quien va el pedido
		String nombresReceptor;
		String apellidosReceptor;
		String tipoDocReceptor;
		Integer nroDocReceptor;
		String rangoHorarioReceptor;
		//se elmiminara el primer bloque una ves implementada la versio nueva.UI
		if(!esProcesoNuevo) {
			nombresReceptor = Convert.toString(request.getParameter(CompraHelper.CAMPO_NOMBRES_RECEPTOR), null);
			apellidosReceptor = Convert.toString(request.getParameter(CompraHelper.CAMPO_APELLIDOS_RECEPTOR), null);
			tipoDocReceptor = Convert.toString(request.getParameter(CompraHelper.CAMPO_TIPO_DOC_RECEPTOR), null);
			nroDocReceptor = Convert.toNumber(request.getParameter(CompraHelper.CAMPO_NRO_DOC_RECEPTOR), (Integer)null);
			rangoHorarioReceptor = Convert.toString(request.getParameter(CompraHelper.CAMPO_RANGO_HORARIO_RECEPTOR), null);
			
			//idem comentario de arriba
			if (nombresReceptor != null && apellidosReceptor != null) {
	            ordenDAO.setNombresReceptor(nombresReceptor.toUpperCase());
				ordenDAO.setApellidosReceptor(apellidosReceptor.toUpperCase());
			}
			//codigo trasladado aca desde abajo, por que luego desaparece
			ordenDAO.setTIPO_DOC_RECEPTOR(tipoDocReceptor);
			ordenDAO.setNRO_DOC_RECEPTOR(nroDocReceptor);
			ordenDAO.setRANGO_HORARIO_RECEPTOR(rangoHorarioReceptor);//seteado ahora en MedioDeCobroAction
		}else {
			nombresReceptor = ordenDAO.getNombresReceptor();
			apellidosReceptor = ordenDAO.getApellidosReceptor();
			tipoDocReceptor = Convert.toString(ordenDAO.getNRO_DOC_RECEPTOR(), null); 
			nroDocReceptor = Convert.toNumber(request.getParameter(CompraHelper.CAMPO_NRO_DOC_RECEPTOR), (Integer)null);
			rangoHorarioReceptor = ordenDAO.getRANGO_HORARIO_RECEPTOR();			
		}

		CompraHelper.proximoEstado(request, response, ordenDAO);
	}

}
