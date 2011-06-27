/**
 * $Log: ParamsLoaderDaemon.java,v $
 * Revision 1.11  2007/07/25 20:07:15  omsartori
 * - Nuevo diseño de fidelizacion
 * - Actualizacion de Datos
 *      - Encripcion de codigos
 *
 * Revision 1.10  2006/12/29 12:33:32  omsartori
 * -Detalle Articulo
 *    - Modulo Extra
 *    - Comentarios
 *
 * Revision 1.9  2004/10/08 22:50:04  oGPistoia
 * - Adaptaciones al diseño de eXtra III
 * - Bug en Nombre Receptor en componentes
 * - Interes de 0.01 por redondeo eliminado
 *
 * Revision 1.8  2004/10/05 21:27:54  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.7  2004/09/10 15:12:46  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.6  2004/06/15 20:56:01  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.5  2004/06/09 18:49:01  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.4  2004/05/04 18:09:28  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.3  2004/03/04 18:51:38  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.2  2004/02/27 13:44:14  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.1  2003/10/12 22:11:20  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 */
package com.tmk.common;

import com.tmk.kernel.*;

public class ParamsLoaderDaemon extends Daemon {

	public ParamsLoaderDaemon() {
		super(Daemon.AHORA, Daemon.UNA_HORA, Thread.MAX_PRIORITY);
	}

	protected void ejecutarTarea() throws Exception {
		Globals.ID_CANAL_ALTERNATIVO = DBUtil.getParameterInt("ID_CANAL_ALTERNATIVO");
		Globals.ID_SUCURSAL_TEMATIKA = DBUtil.getParameterInt("SUCURSAL_CAAL_TEMATIKA");

		Globals.MONEDA_DOLLAR = DBUtil.getParameterInt("MONEDA_DOLLAR");
		Globals.MONEDA_EURO = DBUtil.getParameterInt("MONEDA_EURO");

		Globals.TIPO_PERSONA_FISICA = DBUtil.getParameterString("TIPO_PERSONA_FISICA");
		Globals.TIPO_PERSONA_JURIDICA = DBUtil.getParameterString("TIPO_PERSONA_JURIDICA");

		Globals.GASTO_ENVIO_ADICIONAL_MERC_EXTERIOR = DBUtil.getParameterInt("GASTO_ENVIO_ADICIONAL_MERC_EXTERIOR");
		Globals.GASTO_ENVIO_ADICIONAL_MERC_LOCAL = DBUtil.getParameterInt("GASTO_ENVIO_ADICIONAL_MERC_LOCAL");
		Globals.GASTO_ENVIO_BASICO_MERC_EXTERIOR = DBUtil.getParameterInt("GASTO_ENVIO_BASICO_MERC_EXTERIOR");
		Globals.GASTO_ENVIO_BASICO_MERC_LOCAL = DBUtil.getParameterInt("GASTO_ENVIO_BASICO_MERC_LOCAL");
		//PARAMETRO NECESARIO APRA SUSCRIPCION QUID
		Globals.GASTO_ENVIO_BASICO_MERC_LOCAL_QUID = DBUtil.getParameterInt("GASTO_ENVIO_BASICO_MERC_LOCAL_QUID");
		Globals.MENOR_GASTO_ENVIO = DBUtil.getMenorGastoDeEnvio();
		
		Globals.REGLA_PRECIO_ARTICULO_MINIMO = DBUtil.getParameterDouble("REGLA_PRECIO_ART_MINIMO");
		Globals.REGLA_PRECIO_ARTICULO_MAXIMO = DBUtil.getParameterDouble("REGLA_PRECIO_ART_MAXIMO");
		Globals.REGLA_LIMITE_COMPRA_MINIMO = DBUtil.getParameterDouble("REGLA_LIMITE_COMPRA_MINIMO");
		Globals.REGLA_LIMITE_COMPRA_MAXIMO = DBUtil.getParameterDouble("REGLA_LIMITE_COMPRA_MAXIMO");
		Globals.CARGO_POR_ENVIO_CONTRAREEMBOLSO = DBUtil.getParameterDouble("CARGO_POR_ENVIO_CONTRAREEMBOLSO");

		Globals.ID_ARTICULO_INTERES_COBRADO = DBUtil.getParameterInt("ID_ARTICULO_INTERES_COBRADO");

		// Lo cargo al final para que se posterguen todos las otras cargas
		Globals.ARTICULO_DEFAULT = DBUtil.getParameterInt("ARTICULO_DEFAULT");

		if (Globals.FIDELIZACION_VIGENTE) {
			Globals.FDN_A„OS_VIGENCIA = DBUtil.getParameterInt("FDN_ANIOS_VIGENCIA");
			Globals.FDN_REGLA_ADHESION_FIDELIZACION = DBUtil.getParameterInt("FDN_REGLA_ADHESION_FIDELIZACION");
			Globals.FDN_REGLA_ADHESION_COMPLEMENTARIOS = DBUtil.getParameterInt("FDN_REGLA_ADHESION_COMPLEMENTARIOS");
			Globals.FDN_REGLA_ACTUALIZACION = DBUtil.getParameterInt("FDN_REGLA_ACTUALIZACION");
			Globals.FDN_CONCEPTO_EVENTO = DBUtil.getParameterInt("FDN_CONCEPTO_EVENTO");
			Globals.FDN_FORMULARIO_IDIOMAS = DBUtil.getParameterString("FDN_FORMULARIO_IDIOMAS");
			Globals.FDN_FORMULARIO_TARJETAS = DBUtil.getParameterString("FDN_FORMULARIO_TARJETAS");
			Globals.FDN_ID_SUCURSAL_FIDELIZACION_SITIO = DBUtil.getParameterInt("FDN_ID_SUCURSAL_FIDELIZACION_SITIO");
		}
	}

	protected String getMensaje() {
		return null;
	}

	protected boolean pausada() {
		return Globals.baseDeDatosEnMantenimiento();
	}

}
