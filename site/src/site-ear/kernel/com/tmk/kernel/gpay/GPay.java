/**
 * $Log: GPay.java,v $
 * Revision 1.14  2004/09/30 14:17:10  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.13  2004/03/04 18:51:44  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.12  2004/01/08 20:30:01  GPistoia
 * - Retoques por release, antes del buscador
 *
 * Revision 1.11  2003/12/11 20:52:08  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.10  2003/12/04 17:19:17  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.9  2003/10/28 07:48:49  GPistoia
 * Ano y mes alreves en GPAY
 *
 * Revision 1.8  2003/10/12 22:11:28  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.7  2003/10/09 19:29:58  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.6  2003/10/07 14:52:21  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.5  2003/09/18 18:56:21  GPistoia
 * -Oculte los radio buttons de ir a papel de regalo.
 * -Iteracion en GPay
 *
 * Revision 1.4  2003/08/29 17:54:25  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.3  2003/08/14 14:40:00  SLizardo
 * Se actualizo el Logger (Globals.XXX a TmkLogger.XXX)
 *
 * Revision 1.2  2003/08/06 21:28:24  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.1  2003/08/02 16:58:17  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.3  2003/07/30 15:18:01  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.2  2003/07/28 19:21:27  GPistoia
 * -Controlador de registracion
 *
 * Revision 1.1  2003/07/26 19:06:07  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel.gpay;

import apisub.SUB_Connection;
import apisub.SUB_Transaction;
import com.tmk.kernel.*;

import java.text.DecimalFormat;

public class GPay {

	// resultados
	private int codigoAutorizacion;
	private String mensajeRespuesta;
	private int codigoRespuesta;
	private int idTransaccion;
	private String terminal;

	// datos a enviar
	private int numeroOrden;
	private String numeroTarjeta;
	private String codigoSeguridad;
	private int mesVencimiento;
	private int anoVencimiento;
	private double importe;

	// datos nuevos
	private int plan;
	private int cuotas;
	private int moneda;

	// Manager actual
	private static TerminalManager terminalManagerDefault;

	/**
	 * Reemplaza el TerminalManager por uno nuevo incluso durante una compra
	 */
	public static void cambiarTerminalManager(TerminalManager nuevoTerminalManager) {
		terminalManagerDefault = nuevoTerminalManager;
	}

	/**
	 * Permite generar el objeto que hace la aprobación
	 */
	public GPay(int numeroOrden,
	            String numeroTarjeta, String codigoSeguridad, int mesVencimiento, int anoVencimiento,
	            double importe, TarjetaPlanDAO tarjetaPlanDAO) {
		super();
		this.numeroOrden = numeroOrden;
		this.numeroTarjeta = numeroTarjeta;
		this.codigoSeguridad = codigoSeguridad;
		this.mesVencimiento = mesVencimiento;
		this.anoVencimiento = anoVencimiento;
		this.importe = Convert.round(importe / tarjetaPlanDAO.getCambio());
		this.plan = tarjetaPlanDAO.getPlan();
		this.cuotas = tarjetaPlanDAO.getCuotas();
		this.moneda = tarjetaPlanDAO.getMonedaGPay();
		TmkLogger.info(numeroOrden + ") Se va a cobrar " + this.importe +
		               ", plan " + plan +
		               ", en " + cuotas + " cuotas" +
		               " (el importe original era " + importe + ")");
	}

	public int getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public String getTerminal() {
		return terminal;
	}

	public static TerminalManager getTerminalManager() {
		return terminalManagerDefault;
	}

	/**
	 * ESTE METODO DEBE SER CONCURRENTE
	 */
	public void autorizar() throws GPayException {

		// Este es el manager para este proceso, puede llegar a cambiar en el proceso
		TerminalManager terminalManager = terminalManagerDefault;

		// SE CONECTA
		SUB_Connection connection = new SUB_Connection(terminalManager.getHost(), terminalManager.getPort(), false);
		boolean conexionOk = connection.isConnected();
		if (!conexionOk) {
			throw new GPayException(numeroOrden + ") Conexion al servidor GPay: " + terminalManager.toString());
		}

		// CREA LA TRANSACCION
		SUB_Transaction transaccion = new SUB_Transaction(SUB_Transaction.MODE_NOFREEZE);

		// PIDE UNA TERMINAL
		terminal = terminalManager.obtenerTerminal(numeroOrden);
		try {
			TmkLogger.info(numeroOrden + ") Se le asigno una terminal " + terminal);

			// CREA UNA SESSION
			//transaccion.ClearMsg();
			transaccion.PutField("trn_subtype_id", "1");			//subtipo de transaccion
			transaccion.PutField("trn_type_id", "1024");		    //tipo de mensaje
			transaccion.PutField("trn_internal_ter_id", terminal);	//identificación interna de la terminal

			if (transaccion.SendTransaction(connection, 30) == -1) {
				codigoRespuesta = transaccion.GetIField("trn_internal_respcode");
				mensajeRespuesta = transaccion.GetField("trn_msg_host");
				idTransaccion = transaccion.GetIField("trn_type_id");
				throw new GPayException(numeroOrden + ") Creación de Session: " + mensajeProceso());
			}
			// RECUPERA EL ID
			long idSession = transaccion.GetLField("trn_sess_id");

			TmkLogger.info(numeroOrden + ") Session " + idSession);

			// format a grabar para la fecha
			DecimalFormat dobleCeroFormat = new DecimalFormat("00");
			String fecha = dobleCeroFormat.format(anoVencimiento - 2000) + dobleCeroFormat.format(mesVencimiento);

			// formato para la orden
			String strOrden = Globals.ID_SUCURSAL_TEMATIKA + "-" + numeroOrden + "-1";

			TmkLogger.info(numeroOrden + ") Identificacion de transaccion: " + strOrden);

			// Para la moneda
			DecimalFormat tripleCeroFormat = new DecimalFormat("000");
			String monedaStr = tripleCeroFormat.format(moneda);

			// AHORA LA PROCESA
			transaccion.ClearMsg();
			transaccion.PutFField("trn_amount", (float) importe);					    //importe. Se lee con trn_exponent
			transaccion.PutField("trn_card_number", numeroTarjeta);					    //número de tarjeta
			transaccion.PutField("trn_cur_id1", monedaStr);							    //id_moneda 032=Pesos
			transaccion.PutField("trn_cvc", codigoSeguridad);					    	//codigo de seguridad
			transaccion.PutField("trn_exp_date", fecha);						    	//fecha de expiracion
			transaccion.PutIField("trn_exponent", 0);							    	//cantidad de decimales con que debe interpretarse el importe 0=Punto Flotante
			transaccion.PutIField("trn_input_mode", 4);							    	//modo de ingreso: WEB
			transaccion.PutField("trn_internal_mer_id", terminalManager.getComercio()); //identificación interna del comercio
			transaccion.PutField("trn_internal_ter_id", terminal);          			//identificación interna de la terminal
			transaccion.PutField("trn_order_descripcion", terminalManager.getMensaje());//descripcion de la orden
			transaccion.PutIField("trn_plan_id", plan);						    		//plan de cuotas de la tarjeta
			transaccion.PutIField("trn_qty_pay", cuotas);		    		            //cantidad de cuotas del plan de la tarjeta
			transaccion.PutLField("trn_sess_id", idSession);				    		//id de session
			transaccion.PutIField("trn_subtype_id", 0);						    		//subtipo de mensaje interno de GPAY
			transaccion.PutIField("trn_type_id", 60);						    		//tipo de mensaje
			transaccion.PutField("trn_ukey", strOrden);						    		//identificación de la transacción en el origen

			if (transaccion.SendTransaction(connection, 30) == -1) {
				codigoRespuesta = transaccion.GetIField("trn_internal_respcode");
				mensajeRespuesta = transaccion.GetField("trn_msg_host");
				idTransaccion = transaccion.GetIField("trn_type_id");
				throw new GPayException(numeroOrden + ") Proceso de Transaccion: " + mensajeProceso());
			}

			codigoAutorizacion = Convert.toNumber(transaccion.GetField("trn_auth_code"), 9999);
			codigoRespuesta = transaccion.GetIField("trn_internal_respcode");
			mensajeRespuesta = transaccion.GetField("trn_msg_host");
			idTransaccion = transaccion.GetIField("trn_type_id");

			TmkLogger.info(mensajeProceso());

			// CIERRA LA TRANSACCION
			transaccion.ClearMsg();
			transaccion.PutLField("trn_sess_id", idSession);		            	//sesion
			transaccion.PutField("trn_subtype_id", "2");		        		    //subtipo de transaccion
			transaccion.PutField("trn_type_id", "1024");			              	//tipo de mensaje
			transaccion.PutField("trn_internal_ter_id", terminal);          		//identificación interna de la terminal
			if ((transaccion.SendTransaction(connection, 30) == -1) || (codigoRespuesta != -1)) {
				throw new GPayException(numeroOrden + ") Cierre de Transaccion: " + mensajeProceso());
			}

			TmkLogger.info(numeroOrden + ") Codigo de Autorizacion: " + codigoAutorizacion);

		} finally {
			// Libera esta terminal para ser usada por otro proceso
			terminalManager.liberarTerminal(terminal);
		}
	}

	public String mensajeProceso() {
		return
		        "Orden: " + numeroOrden +
		        ", Tarjeta: " + Seguridad.cortarNumeroDeTarjeta(numeroTarjeta) +
		        ", Codigo de Autorizacion: " + codigoAutorizacion +
		        ", Codigo de Respuesta: " + codigoRespuesta +
		        ", Mensaje de Respuesta: '" + Convert.toString(mensajeRespuesta) + "'" +
		        ", Transaccion: " + idTransaccion;
	}

}
