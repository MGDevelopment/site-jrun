/**
 * $Log: ReferidoManager.java,v $
 * Revision 1.10  2008/04/09 20:20:21  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.9  2007/01/19 12:40:26  oLSuarez
 * Rediseño de referido y correcciones
 *
 * Revision 1.8  2006/09/14 18:25:02  omsartori
 * Promociones II
 *
 * Revision 1.7  2005/09/22 18:38:53  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.6  2005/09/06 13:29:46  omsartori
 * - Reporte de Referidos
 * - Campos piso, depto, edificio en visualizacion de direcciones de envio/fact
 *
 * Revision 1.5  2005/08/24 13:13:42  omsartori
 * - Modifcacion en homes.
 * - Referidos> cambio de direccion de envio
 *                      reporte de referidos por dia
 *
 * Revision 1.4  2005/08/16 16:09:25  omsartori
 * - Cambios estéticos en home
 * - Posibilidad de incluir un file html en el destacado de las home
 * - Yahoo agregado al seguimiento
 * - Se agregaron las palabras de búsqueda al reporte de seguimiento.
 *
 * Revision 1.3  2005/07/18 13:53:08  omsartori
 * - Modificaciones en referido
 * - ejb articulo reducido
 * - buscador de editor por id
 *
 * Revision 1.2  2005/07/05 13:20:46  omsartori
 * - Cambios en Referidos Finalizados
 *
 * Revision 1.1  2005/06/28 16:37:47  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.10  2005/06/09 14:36:22  omsartori
 * - Referidos: banner de beneficios
 * - Posicionamiento: tags en resultado de busqueda
 *
 * Revision 1.9  2005/05/26 14:45:28  omsartori
 * - Mail de tarjetas verificadas.
 * - Pais de facturacion y tarjeta extra para reporte de compras por socios.
 * - Se elimino el cambio de modo en el revitalizer
 * - Cambio de la leyenda de entrega y tel de contacto en la compra y ayuda
 * - Vigencia del referido
 * - Promocion no acumulable con referido
 *
 * Revision 1.8  2005/05/17 14:38:56  omsartori
 * - Posicionamiento tags en pags desde el home, tags por producto, nueva pagina de biografia
 * - Referido, interface de carga modificada a tres referidos independientes, guarda nombre ap y mail
 *
 * Revision 1.7  2005/04/26 17:32:10  omsartori
 * - Arreglado bug buscador rapido comilla simple.
 * - Arreglado bug buscador avanzado comilla simple.
 * - Referido circuito completo testeado.
 * - Posicionamiento: metas home, links producto a detalle y a buscador por categoria.
 *
 * Revision 1.6  2005/04/08 12:55:00  omsartori
 * - Consultas de Referidos
 * - Banner por seccinon configurable desde xml
 *
 * Revision 1.5  2005/03/15 12:28:14  omsartori
 * -Categoria (3,7,2,0 ) para Cheque obsequio
 * -Correccion del calculo del 5% para recargo EFCO
 * -Reemplazo de 7 x 10% en Afiliados libros
 * -Cambio en barra de titulos.
 * -Bug en lista de deseos.
 * -Eliminacion de jscript en combo convinado de localidades
 *
 * Revision 1.4  2005/02/23 13:45:34  omsartori
 * - ingreso a referidos desde mi cuenta.
 * - recupero del referido si se cae la sesion
 * - reconocimiento del referente
 * - compra del referente
 *
 * Revision 1.3  2005/02/18 13:15:38  omsartori
 * - Correccion en promociones, no enviaba el total de impuestos cuando era mas de un articulo, no grababa las promos sin impuestos.
 *
 * Revision 1.2  2005/02/17 12:14:25  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.1  2005/02/10 14:27:35  omsartori
 * - Habilitacion de referidos por xml
 * - Referidos: envio, reconocimiento y registro
 * - Cupones de referido y referente configurables por xml
 * - Cupon de registro configurable por xml
 *
 */
package com.tmk.controllers.referido;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.*;
import com.tmk.referido.ReferidoLocalHome;
import com.tmk.referido.ReferidoLocal;
import com.tmk.referido.ReferenteOrdenLocalHome;
import com.tmk.src.socio.SocioPK;
import com.tmk.soa.servicios.ServiceLocator;
//import com.tmk.socio.SocioLocal;
//import com.tmk.socio.SocioLocalHome;
import com.tmk.orden.OrdenLocalHome;
import com.tmk.orden.OrdenLocal;
//import com.tmk.orden.OrdenDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ejb.FinderException;
import java.util.Iterator;
//import java.util.Vector;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.net.URLEncoder;

public class ReferidoManager {

	public static final String CAMPO_MAIL_REFERIDO1 = "MAIL_REFERIDO1";
	public static final String CAMPO_MAIL_REFERIDO2 = "MAIL_REFERIDO2";
	public static final String CAMPO_MAIL_REFERIDO3 = "MAIL_REFERIDO3";
	public static final String CAMPO_MAIL_REFERIDO4 = "MAIL_REFERIDO4";
	public static final String CAMPO_MAIL_REFERIDO5 = "MAIL_REFERIDO5";

	public static final String CAMPO_NOMBRE_REFERIDO1 = "NOMBRE_REFERIDO1";
	public static final String CAMPO_NOMBRE_REFERIDO2 = "NOMBRE_REFERIDO2";
	public static final String CAMPO_NOMBRE_REFERIDO3 = "NOMBRE_REFERIDO3";
	public static final String CAMPO_NOMBRE_REFERIDO4 = "NOMBRE_REFERIDO4";
	public static final String CAMPO_NOMBRE_REFERIDO5 = "NOMBRE_REFERIDO5";

	public static final String CAMPO_APELLIDO_REFERIDO1 = "APELLIDO_REFERIDO1";
	public static final String CAMPO_APELLIDO_REFERIDO2 = "APELLIDO_REFERIDO2";
	public static final String CAMPO_APELLIDO_REFERIDO3 = "APELLIDO_REFERIDO3";
	public static final String CAMPO_APELLIDO_REFERIDO4 = "APELLIDO_REFERIDO4";
	public static final String CAMPO_APELLIDO_REFERIDO5 = "APELLIDO_REFERIDO5";

	public static final String CAMPO_COMENTARIO_REFERIDO1 = "COMENTARIO_REFERIDO1";
	public static final String CAMPO_COMENTARIO_REFERIDO2 = "COMENTARIO_REFERIDO2";
	public static final String CAMPO_COMENTARIO_REFERIDO3 = "COMENTARIO_REFERIDO3";
	public static final String CAMPO_COMENTARIO_REFERIDO4 = "COMENTARIO_REFERIDO4";
	public static final String CAMPO_COMENTARIO_REFERIDO5 = "COMENTARIO_REFERIDO5";

	public static final String SESSION_ERROR_REFERIDO1 = "ERROR_REFERIDO1";
	public static final String SESSION_ERROR_REFERIDO2 = "ERROR_REFERIDO2";
	public static final String SESSION_ERROR_REFERIDO3 = "ERROR_REFERIDO3";
	public static final String SESSION_ERROR_REFERIDO4 = "ERROR_REFERIDO4";
	public static final String SESSION_ERROR_REFERIDO5 = "ERROR_REFERIDO5";

    public static final String CAMPO_CODIGO_REFERIDO = "CODIGO_REFERIDO";

	public static final String NOMBRE_REFERENTE = "NOMBRE_REFERENTE";
	public static final String APELLIDO_REFERENTE = "APELLIDO_REFERENTE";

    public static final String SERVLET = "/AgregarReferido";
    public static final String PAGINA_DATOS = "/referido/agregarReferido.jsp";
	public static final String PAGINA_CONFIRMACION = "/referido/referidoConfirmado.jsp";
	public static final String PAGINA_MAIL_REFERIDO = "/mailing/referido.jsp";
	public static final String PAGINA_MAIL_REFERENTE = "/mailing/referente.jsp";
	public static final String PAGINA_ANTERIOR = "/miCuenta";

	public static final String SESSION_CODIGO_REFERIDO = "idReferido";
	public static final String SESSION_CODIGO_REFERIDO_REFERENTE = "idsReferidos";

    //Estados
	public static final String REFERENCIA_ENVIADA ="1";
    public static final String REFERIDO_REGISTRADO = "2";
    public static final String REFERIDO_COMPRA = "3";
	public static final String REFERIDO_COMPRA_APROBADA = "4";
    /*
 	de los Estados
	El estado 1 indica que un socio de TMK a enviado una referencia a una persona.
	(Aqui comienza la vigencia del referido)
	El estado 2 indica que la persona referida se ha asociado/registrado en TMK.
	El estado 3 indica que la persona referida ha comprado.
	El estado 4 indica que la orden del referido es aprobada.
	(Aqui comienza la vigencia del referente)
	*/

	// no cambiar
	private static final long INCREMENTO = 100010001;

	//Estadisticas
	public static int REFERIDOS_GENERADOS = 0;
	public static int REFERIDOS_RECONOCIDOS = 0;
	public static int REFERIDOS_RECONOCIDOS_SOCIOS_ANTERIORES = 0;
	public static int REFERIDOS_COMPRA = 0;
	public static int REFERIDOS_COMPRA_APROBADA = 0;
	public static int REFERIDOS_COMPRA_NOAPROBADA = 0;
	public static int REFERENTES_RECONOCIDOS = 0;
	public static int REFERENTES_COMPRA = 0;
	public static int REFERENTES_COMPRA_APROBADA = 0;
	public static int REFERENTES_COMPRA_NOAPROBADA = 0;


	// genera un codigo unico para cada referido
    public static Long getCodigoReferido () throws Exception {
		StringBuffer codigoReferido = new StringBuffer("");

		long referidoSEQ = DBUtil.getSequenceValue("REFERIDO_SEQ").longValue();
		TmkLogger.info("REFERIDOS] Sequence " + referidoSEQ);

		referidoSEQ += INCREMENTO;
		codigoReferido.append(referidoSEQ);

		int sum = 0;

		for (int i = 0; i < codigoReferido.length(); i++) {
			sum = sum + Integer.parseInt(codigoReferido.substring(i, i + 1));
		}
		char clave [] = (sum > 9)? new String ("" + sum).toCharArray(): new String ("0" + sum).toCharArray();
		codigoReferido.insert(4,clave[0]);
		codigoReferido.insert(6,clave[1]);

		TmkLogger.info("REFERIDOS] codigo: " + codigoReferido.toString());

	    Long retorno = new Long (codigoReferido.toString());
		if (retorno == null) {
            throw new NullPointerException();
		}
		REFERIDOS_GENERADOS++;
	    return retorno;
    }

	// valida el codigo de un referido
	public static boolean esCodigoReferido (String codigoReferido) {
		try {
			String clave = codigoReferido.substring(4, 5) + codigoReferido.substring(6, 7);
			int sum = 0;

			for (int i = 0; i < codigoReferido.length(); i++) {
				sum = (i!=4 && i!=6)? sum + Integer.parseInt(codigoReferido.substring(i, i + 1)): sum;
			}
			return (Integer.parseInt(clave) == sum);
		}
		catch (Exception e) {
			return false;
		}
	}

	
	//POR EL MOMENTO SOLO USAR POR CLASE RegistrarSocioTMK
	public static boolean esReferido(HttpServletRequest request) {
		try {
			
			// toma la session
			HttpSession httpSession = request.getSession();
			
			//si el codigo es valido
			if (!esCodigoReferido((String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO))) {
				return false;
			}
			Long pk = (Convert.toNumber((String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO), new Long(0)));
			
			//chequea estado de referido
			ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			ReferidoLocal referido = referidoLH.findByPrimaryKey(pk);

			if (!referido.getESTADO().equals(REFERENCIA_ENVIADA)) {
				TmkLogger.debug("REFERIDOS] esReferido) abortado por estado no correspondiente. Codigo=" 
						+ (String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO));
				return false;
			}
			return true;
		} catch (Exception e) {
			TmkLogger.error("ReferidoManager] esReferido) " + e.toString() + MainHelper.getMessage(e));
			return false;
		}
	} 
	
	// reconoce a un referido cuando se registra en TMK/// 
	
	public static void setReferido (HttpServletRequest request) {
		try {
			// toma la session
			HttpSession httpSession = request.getSession();

			//si el codigo es valido
			if (!esCodigoReferido((String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO))) {
				return;
			}

			SocioPK socioPK = (SocioPK) httpSession.getAttribute("Registracion.socioPK");

			if (socioPK == null) {
				TmkLogger.error("REFERIDOS] setReferido socio null");
				return;
			}

			Long pk = (Convert.toNumber((String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO), new Long(0)));

            ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			ReferidoLocal referido = referidoLH.findByPrimaryKey(pk);

			if (!referido.getESTADO().equals(REFERENCIA_ENVIADA)) {
				TmkLogger.debug("REFERIDOS] setReferido abortado por estado no correspondiente" + socioPK.ID_SUCURSAL + " " + socioPK.ID_SOCIO);
				return;
			}

			//SocioLocalHome socioLH = (SocioLocalHome) DBUtil.getHome("Socio");
			//SocioLocal socioRegistrado = socioLH.findByPrimaryKey(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
			Socios2 socioRegistrado = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);

			/*Iterator sociosRepetidos = socioLH.findRepetidosDelSitio(socioRegistrado.getSEXO(),
											 socioRegistrado.getTIPO_DOC(), socioRegistrado.getNRO_DOC(),
											 socioRegistrado.getNACIONALIDAD()).iterator();*/
			Iterator sociosRepetidos = ServiceLocator.getSocioService().findRepetidosDelSitio(socioRegistrado.getSexo(),
												 socioRegistrado.getTipo_doc(), socioRegistrado.getNro_doc(),
												 socioRegistrado.getNacionalidad().getIdPais()).iterator();
			int cantidadSocios = 0;
			while (sociosRepetidos.hasNext()) {
				cantidadSocios++;
				sociosRepetidos.next();
			}

			if (cantidadSocios > 1) {
				TmkLogger.debug("REFERIDOS] setReferido abortado por socio registrado anteriormente");
				httpSession.setAttribute(SESSION_CODIGO_REFERIDO, null);
				return;
			}

		    referido.setID_SOCIO_REFERIDO(socioPK.ID_SOCIO);
		 	referido.setID_SUCURSAL_REFERIDO(socioPK.ID_SUCURSAL);
			referido.setESTADO(REFERIDO_REGISTRADO);

			TmkLogger.info("REFERIDOS] setReferido Referido Reconocido: Codigo " + referido.getCODIGO_REFERIDO() +
			               " Socio: " + referido.getID_SOCIO_REFERIDO() + " Sucursal: " + referido.getID_SUCURSAL_REFERIDO());
			REFERIDOS_RECONOCIDOS++;
		}

		catch (Exception e) {
			TmkLogger.error("REFERIDOS] setReferido: " + e.toString() + " " + e.getMessage() + " " + e.getStackTrace());

		}
		return;
	}

    	// si se cayo la session reestablece al referido cuando se loguea
	public static void recuperarReferido (HttpServletRequest request) {
		try {
			// toma la session
			HttpSession httpSession = request.getSession();

			SocioPK socioPK = (SocioPK) httpSession.getAttribute("Registracion.socioPK");

			if (socioPK == null) {
				TmkLogger.error("REFERIDOS] recuperarReferido socio null");
				return;
			}

			ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			ReferidoLocal referido = referidoLH.findBySocioReferido(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL);

			if (!referido.getESTADO().equals(REFERIDO_REGISTRADO)) {
				TmkLogger.debug("REFERIDOS] recuperarReferido abortado por estado no correspondiente");
				return;
			}

			//seteo el codigo
			httpSession.setAttribute(SESSION_CODIGO_REFERIDO, referido.getCODIGO_REFERIDO().toString().replaceAll("\\.", ""));

			TmkLogger.info("REFERIDOS] recuperarReferido Referido Recuperado: Codigo " + referido.getCODIGO_REFERIDO() +
						   " Socio: " + referido.getID_SOCIO_REFERIDO() + " Sucursal: " + referido.getID_SUCURSAL_REFERIDO());

		}

		catch (FinderException e) {
			TmkLogger.debug("REFERIDOS] recuperarReferido: NO ES REFERIDO ");
		}

		catch (Exception e) {
			TmkLogger.error("REFERIDOS] recuperarReferido: " + e.toString() + " " + e.getMessage() + " " + e.getStackTrace());

		}
		return;
	}

    // retorna el cupon del referido, la uso al momento de la compra
	public static String getCuponReferido (HttpServletRequest request) {
	    String cupon = "";
	    if (!Globals.referidoHabilitado()) {
		    return cupon;
	    }
	    try {
		    // toma la session
		    HttpSession httpSession = request.getSession();

		    //si el codigo es valido
		    if (!esCodigoReferido((String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO))) {
			    return cupon;
		    }

		    SocioPK socioPK = (SocioPK) httpSession.getAttribute("Registracion.socioPK");

		    if (socioPK == null) {
			    TmkLogger.error("REFERIDOS] getCuponReferido socio null");
			    return cupon;
		    }

		    Long pk = Convert.toNumber((String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO), new Long(0));
            ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
		    ReferidoLocal referido = referidoLH.findByPrimaryKey(pk);

		    if (!referido.getESTADO().equals(REFERIDO_REGISTRADO)) {
			    TmkLogger.debug("REFERIDOS] getCuponReferido sin cupon estado no correspondiente");
			    return cupon;
		    }

            if ( !(referido.getID_SOCIO_REFERIDO().equals(socioPK.ID_SOCIO) && referido.getID_SUCURSAL_REFERIDO().equals(socioPK.ID_SUCURSAL)) ) {
                TmkLogger.debug("REFERIDOS] getCuponReferido sin cupon socio no correspondiente");
	            return cupon;
            }

		    if (referido.getFECHA_VENC_REFERIDO().before(new Date())) {
				TmkLogger.debug("REFERIDOS] getCuponReferido sin cupon referido vencido");
				return cupon;
			}

		    cupon = referido.getCUPON_REFERIDO();

		    TmkLogger.info("REFERIDOS] getCuponReferido : Codigo " + referido.getCODIGO_REFERIDO() + " cupon: " + cupon +
		                   " Socio: " + referido.getID_SOCIO_REFERIDO() + " Sucursal: " + referido.getID_SUCURSAL_REFERIDO());

	    }

	    catch (Exception e) {
		    TmkLogger.error("REFERIDOS] getCuponReferido: " + e.toString() + " " + e.getMessage() + " " + e.getStackTrace());
	    }
	    return cupon;
    }


	//cuando el referido compra setea la orden
	public static void setOrdenReferido (HttpServletRequest request, Integer idOrden) {
		if (!Globals.referidoHabilitado()) {
		    return;
		}
		try {
		    // toma la session
		    HttpSession httpSession = request.getSession();

		    //si el codigo es valido
		    if (!esCodigoReferido((String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO))) {
			    return;
		    }

			SocioPK socioPK = (SocioPK) httpSession.getAttribute("Registracion.socioPK");

			if (socioPK == null) {
				TmkLogger.error("REFERIDOS] setOrdenReferido socio null");
				return;
			}

			if (idOrden == null){
				TmkLogger.error("REFERIDOS] setOrdenReferido orden null");
				return;
			}

			OrdenLocalHome ordenLH = (OrdenLocalHome) DBUtil.getHome("Orden");
			OrdenLocal orden = ordenLH.findByPrimaryKey(idOrden);

			Long pk = (Convert.toNumber((String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO), new Long(0)));
			ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			ReferidoLocal referido = referidoLH.findByPrimaryKey(pk);

			if ( !(referido.getID_SOCIO_REFERIDO().equals(socioPK.ID_SOCIO) && referido.getID_SUCURSAL_REFERIDO().equals(socioPK.ID_SUCURSAL)) ) {
				TmkLogger.debug("REFERIDOS] setOrdenReferido no se seteo orden, socio no correspondiente");
				return;
			}

            referido.setID_ORDEN_REFERIDO(orden.getID_ORDEN());
			referido.setESTADO(REFERIDO_COMPRA);
			REFERIDOS_COMPRA++;
			TmkLogger.debug("REFERIDOS] setOrdenReferido orden seteada " + idOrden);
	    }


	    catch (Exception e) {
		    TmkLogger.error("REFERIDOS] setOrdenReferido: " + e.toString() + " " + e.getMessage() + " " + e.getStackTrace());
	    }
	}


	// setea cuando la orden del referido es aprobada
	public static void setCompraReferido (Integer idOrden){

		if (!Globals.referidoHabilitado()) {
		    return;
		}
		if (idOrden == null) {
			TmkLogger.error("REFERIDOS] setCompraReferido: idOrden null");
	        return;
        }
		try {
			ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			ReferidoLocal referido = referidoLH.findByOrdenReferido(idOrden);
			referido.setESTADO(REFERIDO_COMPRA_APROBADA);

            Iterator referidos = referidoLH.findBySocioReferenteEstado(referido.getID_SOCIO_REFERENTE(), referido.getID_SUCURSAL_REFERENTE(), REFERIDO_COMPRA_APROBADA).iterator();
			int cantidadReferidos = 0;
			while (referidos.hasNext() && cantidadReferidos < Globals.CUPON_REFERENTE.length) {
				referidos.next();
				cantidadReferidos++;
			}

			referido.setCUPON_REFERENTE(Globals.CUPON_REFERENTE [cantidadReferidos-1].getId());
			referido.setBENEF_REFERENTE(Globals.CUPON_REFERENTE [cantidadReferidos-1].getBeneficio());

			Calendar fechaVencReferente = Calendar.getInstance();
			fechaVencReferente.add(Calendar.DATE, Globals.VIGENCIA_DE_REFERENTE);

			referido.setFECHA_VENC_REFERENTE(new Timestamp(fechaVencReferente.getTime().getTime()));

            SocioPK socioPK = new SocioPK (referido.getID_SUCURSAL_REFERENTE(), referido.getID_SOCIO_REFERENTE());
			//SocioLocalHome socioLH = (SocioLocalHome) DBUtil.getHome("Socio");
            Socios2 socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
			//SocioLocal socio = socioLH.findByPrimaryKey(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));

			//enviarMailReferente (referido.getCODIGO_REFERIDO(), socio.getEMAIL());
            enviarMailReferente (referido.getCODIGO_REFERIDO(), socio.getlogin());
            TmkLogger.debug("REFERIDOS] setCompraReferido: " + idOrden);
			REFERIDOS_COMPRA_APROBADA++;
		}

		catch (FinderException e) {
			//TmkLogger.error("REFERIDOS] setCompraReferido: No se asigna orden " + idOrden);
		}
		catch (Exception e) {
            TmkLogger.error("REFERIDOS] setCompraReferido: " + e.toString() + " " + e.getMessage() + " " + e.getStackTrace());
		}

	}

	// quita la orden del referido del circuito del referencia si la orden no fue aprobada
	// para poder reutilizarlo con otra orden
	public static void eliminaOrdenReferido (Integer idOrden) {
		if (!Globals.referidoHabilitado()) {
			return;
		}
		if (idOrden == null) {
			TmkLogger.error("REFERIDOS] eliminaOrdenReferido: idOrden null");
			return;
		}
		try {
			ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			ReferidoLocal referido = referidoLH.findByOrdenReferido(idOrden);
			referido.setID_ORDEN_REFERIDO(null);
			referido.setESTADO(REFERIDO_REGISTRADO);
			TmkLogger.debug("REFERIDOS] eliminaOrdenReferido: " + idOrden);
			REFERIDOS_COMPRA_NOAPROBADA++;
		}

		catch (FinderException e) {
			//TmkLogger.error("REFERIDOS] setCompraReferido: No se asigna orden " + idOrden);
		}
		catch (Exception e) {
			TmkLogger.error("REFERIDOS] eliminaReferido: " + e.toString() + " " + e.getMessage() + " " + e.getStackTrace());
		}
	}


	//FALTA DEFINIR MAIL
	// envia mail al referente, cuando se aprueba la orden del referido
	public static void enviarMailReferente(Long codigoReferido, String mailSocioReferente) throws Exception  {
		StringBuffer param = new StringBuffer("");
		param.append ("?");
		param.append (CAMPO_CODIGO_REFERIDO);
		param.append ("=");
		param.append (URLEncoder.encode(Convert.toString(codigoReferido, ""), "ISO-8859-1"));

		MailUtil.sendMail(Globals.MAIL_REFERIDOS,
			                  mailSocioReferente,
			                  Globals.NOMBRE_DEL_SITIO + " - Programa de Referidos - Beneficios en su cuenta",
                              "",
                              ReferidoManager.PAGINA_MAIL_REFERENTE + param.toString()
			);
		TmkLogger.debug("REFERIDOS] mail referente enviado");
	}


	// retorna el cupon al socio referente
	//MODIFICADA PARA SOPORTAR n compras de un referido por una compra de un REFERENTE
	public static String getCuponReferente (HttpServletRequest request) {
		String cupon = "";
	    if (!Globals.referidoHabilitado()) {
		    return cupon;
	    }
	    try {
		    // toma la session
		    HttpSession httpSession = request.getSession();

		    SocioPK socioPK = (SocioPK) httpSession.getAttribute("Registracion.socioPK");

		    if (socioPK == null) {
			    TmkLogger.error("REFERIDOS] getCuponReferente socio null");
			    return cupon;
		    }

            ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
		    Iterator referidos = referidoLH.findBySocioReferenteEstado(socioPK.ID_SOCIO, socioPK.ID_SUCURSAL, REFERIDO_COMPRA_APROBADA).iterator();

		    if (referidos.hasNext()) {
			    REFERENTES_RECONOCIDOS++;
			    ReferidoLocal referido = (ReferidoLocal) referidos.next();
                if (referido.getFECHA_VENC_REFERENTE().after(new Date())) {
	                cupon = referido.getCUPON_REFERENTE();
	                httpSession.setAttribute(SESSION_CODIGO_REFERIDO_REFERENTE, referido.getCODIGO_REFERIDO().toString());
	                TmkLogger.info("REFERIDOS] getCuponReferente->Codigo " + referido.getCODIGO_REFERIDO() + " cupon: " + cupon + " socio " + referido.getID_SOCIO_REFERENTE() + " " + referido.getID_SUCURSAL_REFERENTE());
                } else {
	                TmkLogger.info("REFERIDOS] getCuponReferente->Vencido Codigo " + referido.getCODIGO_REFERIDO() + " socio " + referido.getID_SOCIO_REFERENTE() + " " + referido.getID_SUCURSAL_REFERENTE());
                }

            }
	    }
	    catch (FinderException e) {
			TmkLogger.error("REFERIDOS] No es referente, o estado no corresponde");
	    }
	    catch (Exception e) {
		    TmkLogger.error("REFERIDOS] getCuponReferente: " + e.toString() + " " + e.getMessage() + " " + e.getStackTrace());
	    }
	    return cupon;
	}

	//cuando el referente compra setea la orden
	public static void setOrdenReferente (HttpServletRequest request, Integer idOrden) {
		if (!Globals.referidoHabilitado()) {
		    return;
		}
		try {
		    // toma la session
		    HttpSession httpSession = request.getSession();
    		//no hace falta validar los codigos ya que fueron sacados de la base

			SocioPK socioPK = (SocioPK) httpSession.getAttribute("Registracion.socioPK");

			if (socioPK == null) {
				TmkLogger.error("REFERIDOS] setOrdenReferente socio null");
				return;
			}

			if (idOrden == null){
				TmkLogger.error("REFERIDOS] setOrdenReferente orden null");
				return;
			}

			//OrdenLocalHome ordenLH = (OrdenLocalHome) DBUtil.getHome("Orden");
			//OrdenLocal orden = ordenLH.findByPrimaryKey(idOrden);

			String codigoReferido = (String) httpSession.getAttribute(SESSION_CODIGO_REFERIDO_REFERENTE);
            if (codigoReferido != null) {
				ReferenteOrdenLocalHome referenteOrdenLH = (ReferenteOrdenLocalHome) DBUtil.getHome("ReferenteOrden");
	            referenteOrdenLH.create(Convert.toNumber(codigoReferido, new Long (0)), idOrden);
				TmkLogger.info("REFERIDOS] setOrdenReferente OK-> codigo: " + codigoReferido + " socio:" + socioPK.ID_SOCIO
				               + " " + socioPK.ID_SUCURSAL + " orden:" + idOrden);
				REFERENTES_COMPRA++;
            }
	    }
	    catch (Exception e) {
		    TmkLogger.error("REFERIDOS] setOrdenReferente: " + e.toString() + " " + e.getMessage() + " " + e.getStackTrace());
	    }
	}

	public static String getBeneficioReferente(HttpServletRequest request) {
		String beneficio = "";
		if (!Globals.referidoHabilitado()) {
		    return beneficio;
		}
		SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
		if (socioPK == null) {
			return beneficio;
		}
		try {
			ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
			Iterator referidos = referidoLH.findBySocioReferenteEstado (socioPK.ID_SOCIO, socioPK.ID_SUCURSAL, ReferidoManager.REFERIDO_COMPRA_APROBADA).iterator();
			ReferidoLocal referido = (ReferidoLocal) referidos.next();
			 if (referido.getFECHA_VENC_REFERENTE().after(new Date())) {

				beneficio = "Programa de Referidos: " + referido.getBENEF_REFERENTE() + " en sus próximas compras hasta el "
				        + Convert.toString(referido.getFECHA_VENC_REFERENTE()) + "!!!";

			 }
		} catch(Exception e) {

		}
		return beneficio;
	}

	public static String getBeneficioReferido(HttpServletRequest request) {
		String beneficio = "";
		if (!Globals.referidoHabilitado()) {
		    return beneficio;
		}
		String codigoReferido = (String) request.getSession().getAttribute(SESSION_CODIGO_REFERIDO);
		if (!esCodigoReferido(codigoReferido)) {
			return beneficio;
		}
		try {
			ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
            ReferidoLocal referido = referidoLH.findByPrimaryKey(Convert.toNumber(codigoReferido, new Long(0)));
			if (referido.getESTADO().equals(REFERENCIA_ENVIADA)) {
				if (referido.getFECHA_VENC_REFERIDO().after(new Date())) {
					beneficio = "Programa de Referidos: Registrese y obtendrá un beneficio del " + referido.getBENEF_REFERIDO() + " en su próxima compra.";
			}

			} else {
				if (referido.getESTADO().equals(REFERIDO_REGISTRADO)) {
					if (referido.getFECHA_VENC_REFERIDO().after(new Date())) {
						beneficio = "Programa de Referidos: " + referido.getBENEF_REFERIDO() + " en sus próximas compras hasta el "
						+ Convert.toString(referido.getFECHA_VENC_REFERIDO()) + "!!!";
					}
				}
			}

		} catch (Exception e) {

		}
		return beneficio;
	}

	//COMENTADO PROMO II
/*
	public static boolean aplicoPromocion (String cupon, OrdenDAO orden) {
		boolean retorno = false;
		TmkLogger.debug("CUPON-> " + cupon );
		int idPromo = DBUtil.getPromocionPorCupon(cupon);
		TmkLogger.debug("Promo-> " + idPromo);
		if (idPromo != 0) {
			Vector articulos = orden.getArticulos();
			for (int i=0; i < articulos.size(); i++) {
				ArticuloDAO articulo = (ArticuloDAO) articulos.get(i);
				TmkLogger.debug("promo art-> " +  articulo.getIdPromocion().intValue());
				if (articulo.getIdPromocion().intValue() == idPromo) {
					retorno = true;
				}
			}
		} else {

		}
		if (retorno) {
			TmkLogger.debug("REFERIDOS] aplico la promo");
		} else {
			TmkLogger.debug("REFERIDOS] NO aplico la promo");
		}

		return retorno;
	}
*/

}


