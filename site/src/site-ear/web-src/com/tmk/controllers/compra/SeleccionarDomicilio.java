/**
 * $Log: SeleccionarDomicilio.java,v $
 * Revision 1.32  2009/03/20 19:02:46  oClopez
 * cambio viernes
 *
 * Revision 1.31  2008/07/07 18:59:49  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.30  2006/10/12 14:59:11  omsartori
 * no message
 *
 * Revision 1.29  2006/02/20 12:38:25  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.28  2006/02/09 16:15:36  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.27  2005/12/29 17:45:27  omsartori
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
 * Revision 1.26  2005/11/04 12:55:42  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 *
 * Revision 1.24  2005/10/14 16:05:32  omsartori
 * - Correccion en grabacion de orden de referente
 *
 * Revision 1.23  2005/10/11 16:04:47  omsartori
 * - Seguimiento EMPRO
 *     - Visitas x canal
 *     - Compras x canal
 *     - Registraciones x canal
 *     - Ingresos al detalle de articulo x canal
 * - Filtro de texto en formato de Articulo
 * - Campo adicional en la orden para envios a Brasil (CPF CNPJ)
 *
 * Revision 1.22  2004/11/11 21:10:38  omsartori
 * - tabulación de detalle de articulos
 * - correccion de tablas de detalle articulos
 * - Se quito la funcion Convert.equals de seleccionarDomicilio
 *
 * Revision 1.21  2004/09/30 14:17:27  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.20  2004/09/24 18:19:23  oGPistoia
 * - Nombres y Apellidos del receptor del pedido terminado.
 *
 * Revision 1.19  2004/09/10 15:13:19  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.18  2004/09/07 16:15:38  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.17  2004/02/16 20:24:22  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.16  2003/11/19 18:55:47  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.15  2003/10/07 14:56:26  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.14  2003/10/03 16:30:19  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.13  2003/09/11 18:09:48  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.12  2003/09/09 17:49:49  SLizardo
 * Modificacion del SocioPK.
 *
 * Revision 1.11  2003/09/04 21:40:02  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.10  2003/09/03 20:04:27  SLizardo
 * no message
 *
 * Revision 1.9  2003/09/02 14:06:25  SLizardo
 * Actualizar Productos
 *
 * Revision 1.8  2003/09/01 20:06:22  SLizardo
 * no message
 *
 * Revision 1.7  2003/08/25 20:46:28  SLizardo
 * Optimize Imports
 *
 * Revision 1.6  2003/08/12 16:26:10  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.5  2003/08/11 15:38:36  SLizardo
 * no message
 *
 * Revision 1.4  2003/08/11 14:26:55  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.3  2003/08/09 22:54:58  SLizardo
 * no message
 *
 * Revision 1.2  2003/08/04 22:17:59  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.1  2003/08/02 16:58:34  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 */
package com.tmk.controllers.compra;

import java.io.IOException;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tmk.bus.socio.BufferSocios;
import com.tmk.bus.socio.Socios2;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.DatosDomicilio;
import com.tmk.kernel.DomicilioDAO;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.socio.BufferSocioDomicilioLocalHome;
import com.tmk.socio.SocioDomicilioLocal;
import com.tmk.socio.SocioDomicilioLocalHome;
import com.tmk.src.socio.SocioPK;

@SuppressWarnings("serial")
public class SeleccionarDomicilio extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//boolean esProcesoNuevo = ProcesoCompraUtilImp.getInstance().esProcesoNueo(request);
        HttpSession session = request.getSession();
        OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");
        SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");

        // Volver a la pagina si no corresponde
        if (!CompraHelper.continuaProceso(request, response, ordenDAO)) return;

        try {
            // carga el domicilio correspondiente
            boolean facturacion = Boolean.valueOf(request.getParameter("facturacion")).booleanValue();
            String tipoDomicilio = request.getParameter(DatosDomicilio.ID);
            if(tipoDomicilio == null ){
            	TmkLogger.debug("Proceso de compras->No se especifico ningun Domicilio para avanzar a la pagina de Domicilios");
            	throw new Exception ("No ha especificado una tipo de direccion...");
            }
            TmkLogger.debug("Cargando direccion para " + tipoDomicilio);
            //domicilio para socios pk con tipo de domicilio
            DomicilioDAO domicilioDAO = DomicilioDAO.load(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO, tipoDomicilio);
            //SocioDomicilios domicilioDAO = ServiceLocator.getSocioService().getByPKYTipoDomicilio(socioPK, tipoDomicilio);            
            
            //if(esProcesoNuevo) {	            
	            //comentario(se agrego), se traslado desde SeleccionarMedioDeCobro.java para la UI nueva
	            String comentario = request.getParameter("COMENTARIO");
	            if(comentario!=null && comentario.trim().length() > 0){
	            	String comentarioFormateado=Convert.soloLetrasYNros(comentario);
	            	if(!comentario.equals(comentarioFormateado)){
	            		TmkLogger.debug("Comentario contiene caracteres invalidos");
	                	throw new Exception ("El comentario contiene caracteres invalidos, solo se permiten letras y numeros");
	            	}
            		ordenDAO.setComentario(comentario);
	            }
            //}
            if (domicilioDAO.esEnvio()) {
                ordenDAO.setDomicilioEnvio(domicilioDAO);                
	            // Toma el nombre de a quien va el pedido
	            String nombresReceptor = Convert.toString(request.getParameter(CompraHelper.CAMPO_NOMBRES_RECEPTOR), null);
	            String apellidosReceptor = Convert.toString(request.getParameter(CompraHelper.CAMPO_APELLIDOS_RECEPTOR), null);
	            // Si alguno de los datos es nulo graba nulo, porque sino la interface inventaría el nombre
	            if (nombresReceptor != null && apellidosReceptor != null) {
		            // Guarda los cambios
		            TmkLogger.debug("Destinatario del pedido: " + Convert.nombreCompleto(nombresReceptor, apellidosReceptor));
                    ordenDAO.setNombresReceptor(nombresReceptor.toUpperCase());
		            ordenDAO.setApellidosReceptor(apellidosReceptor.toUpperCase());
	            }else {
	            	ordenDAO.setNombresReceptor(null);
		            ordenDAO.setApellidosReceptor(null);
	            }
                if(ordenDAO.getDomicilioEnvio()!=null) {
                	//si la direccion de envio esta fuera de argentina, elimino el medio de cobro contrareembolso.
                    if (ordenDAO.getDomicilioEnvio().getIdPais().intValue() != Globals.ARGENTINA.getId()) {
                        if (ordenDAO.getMedioDeCobro() != null && ordenDAO.getMedioDeCobro().esReembolso()) {                        	
	                        ordenDAO.setMedioDeCobro(null);
                        }
                    }
	                if (ordenDAO.getDomicilioEnvio().getIdPais().intValue() != CompraHelper.PAIS_BRASIL) {
		                ordenDAO.setCPF_CNPJ(null);
	                }
                }
            }
            //SI LA DIRECCION DE ENTREGA ES LA MISMA QUE LA DIRECCION DE FACTURACION
            if (facturacion) {
                TmkLogger.info("Usando la misma direccion para Facturacion.");
                SocioDomicilioLocalHome socioDomicilioLH = (SocioDomicilioLocalHome) DBUtil.getHome("SocioDomicilio");
                /*busco en la base en la base que la direccion figure como de facturación*/
                Iterator colSocioDomicilio = socioDomicilioLH.findByTipoFacturacion(
                        socioPK.ID_SUCURSAL,
                        socioPK.ID_SOCIO).iterator();

                boolean encontro = false;
	            String TIPO_DOMICILIO = null;
                while (!encontro && colSocioDomicilio.hasNext()) {
                    SocioDomicilioLocal socioDomicilio = (SocioDomicilioLocal) colSocioDomicilio.next();
                    //domicilio dao la cargo con la pk de socio mas tipo_domicilio y socioDomicilio por pk de socio unicamente
                    //comparo todo menos el TIPO_DOMICILIO
	                encontro = ( (socioDomicilio.getID_PAIS() != null  && socioDomicilio.getID_PAIS().equals(domicilioDAO.getIdPais())) ||
	                        (socioDomicilio.getID_PAIS() == null && domicilioDAO.getIdPais() == null) ) &&

	                        ( (socioDomicilio.getID_PROVINCIA() != null  && socioDomicilio.getID_PROVINCIA().equals(domicilioDAO.getIdProvincia())) ||
		                    (socioDomicilio.getID_PROVINCIA() == null && domicilioDAO.getIdProvincia() == null) ) &&

	                        ( (socioDomicilio.getID_LOCALIDAD() != null  && socioDomicilio.getID_LOCALIDAD().equals(domicilioDAO.getIdLocalidad())) ||
                            (socioDomicilio.getID_LOCALIDAD() == null && domicilioDAO.getIdLocalidad() == null) ) &&

	                        ( (socioDomicilio.getCP() != null  && socioDomicilio.getCP().equals(domicilioDAO.getCodigoPostal())) ||
                            (socioDomicilio.getCP() == null && domicilioDAO.getCodigoPostal() == null) ) &&

	                        ( (socioDomicilio.getCALLE() != null  && socioDomicilio.getCALLE().equals(domicilioDAO.getCalle())) ||
                            (socioDomicilio.getCALLE() == null && domicilioDAO.getCalle() == null) ) &&

	                        ( (socioDomicilio.getNUMERO() != null  && socioDomicilio.getNUMERO().equals(domicilioDAO.getNumero())) ||
                            (socioDomicilio.getNUMERO() == null && domicilioDAO.getNumero() == null) ) &&

	                        ( (socioDomicilio.getEDIFICIO() != null  && socioDomicilio.getEDIFICIO().equals(domicilioDAO.getEdificio())) ||
                            (socioDomicilio.getEDIFICIO() == null && domicilioDAO.getEdificio() == null) ) &&

	                        ( (socioDomicilio.getPISO() != null  && socioDomicilio.getPISO().equals(domicilioDAO.getPiso())) ||
                            (socioDomicilio.getPISO() == null && domicilioDAO.getPiso() == null) ) &&

	                        ( (socioDomicilio.getDEPTO() != null  && socioDomicilio.getDEPTO().equals(domicilioDAO.getDepto())) ||
                            (socioDomicilio.getDEPTO() == null && domicilioDAO.getDepto() == null) );

					if (encontro) {
						TIPO_DOMICILIO = socioDomicilio.getTIPO_DOMICILIO();
					}
                }
                if (encontro) {
                    TmkLogger.info("Utiliza direccion " + TIPO_DOMICILIO + " de facturacion existente.");
                } else {
                    TmkLogger.info("Utiliza direccion de facturacion nueva.");
                    TIPO_DOMICILIO = DBUtil.buildAddress(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO, "TF");
                    SocioDomicilioLocalHome domicilioHome = (SocioDomicilioLocalHome) DBUtil.getHome("SocioDomicilio");
                    domicilioHome.create(
                            socioPK.ID_SUCURSAL,
                            socioPK.ID_SOCIO,
                            TIPO_DOMICILIO,
                            domicilioDAO.getCalle(),
                            domicilioDAO.getNumero(),
                            domicilioDAO.getEdificio(),
                            domicilioDAO.getPiso(),
                            domicilioDAO.getDepto(),
                            domicilioDAO.getCodigoPostal(),
                            domicilioDAO.getIdLocalidad(),
                            domicilioDAO.getIdProvincia(),
                            domicilioDAO.getIdPais(),
                            domicilioDAO.getProvinciaExterna(),
                            domicilioDAO.getLocalidadExterna()
                    );
                    //Grabacion de domicilio para buffer
	               	Integer ID_SUCURSAL = socioPK.ID_SUCURSAL;
					Integer ID_SOCIO = socioPK.ID_SOCIO;
	                try {
		                //SocioLocal socio = ShortCuts.findSocioById(socioPK);
		                Socios2 socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
		                //BufferSocioPK bufferSocioPK = new BufferSocioPK(ID_SUCURSAL, ID_SOCIO);
						//BufferSocioLocalHome bufferSocioLocalHome = (BufferSocioLocalHome) DBUtil.getHome("BufferSocio");
						try {
							/*BufferSocioLocal bufferSocioLocal = bufferSocioLocalHome.findByPrimaryKey(bufferSocioPK);
							bufferSocioLocal.setPROCESADO("N");
							bufferSocioLocal.setPROCESADO_ECL(null);
							bufferSocioLocal.setAUXFLAG2(socio.getAUXFLAG2());*/
							BufferSocios bufferSocioLocal = new BufferSocios(ID_SUCURSAL,ID_SOCIO);
							bufferSocioLocal.setProcesado("N");
							bufferSocioLocal.setProcesado_ecl(null);
							bufferSocioLocal.setAuxflag2(socio.getAuxflag2());
							ServiceLocator.getDboService().update(bufferSocioLocal);
						} catch (DBOInexistenteException e) {
							TmkLogger.info ("Agregar Domicilio] no se encuentra buffersocio " + ID_SUCURSAL + "-" + ID_SOCIO + " comienza la creacion." );
							try {
								ServiceLocator.getBufferSocioService().create(
										socio.getId_sucursal(),
										socio.getId_socio(),
										socio.getId_caal(),
										socio.getId_tipo_contribuyente(),
										socio.getTipo_persona(),
										socio.getLogin(),
										socio.getNombres(),
										socio.getApellidos(),
										socio.getPassword(),
										socio.getTipo_doc(),
										socio.getNro_doc(),
										socio.getNacionalidad().getIdPais(),
										socio.getFecha_nacimiento(),
										socio.getSexo(),
										socio.getEstado_civil(),
										socio.getHijos(),
										socio.getId_profesion(),
										"N",
										socio.getE_mail1(),
										null, null, null, null, null, socio.getAuxflag2()
									);
								/*bufferSocioLocalHome.create(
									socio.getID_SUCURSAL(),
									socio.getID_SOCIO(),
									socio.getID_CAAL(),
									socio.getID_TIPO_CONTRIBUYENTE(),
									socio.getTIPO_PERSONA(),
									socio.getLOGIN(),
									socio.getNOMBRES(),
									socio.getAPELLIDOS(),
									socio.getPASSWORD(),
									socio.getTIPO_DOC(),
									socio.getNRO_DOC(),
									socio.getNACIONALIDAD(),
									socio.getFECHA_NACIMIENTO(),
									socio.getSEXO(),
									socio.getESTADO_CIVIL(),
									socio.getHIJOS(),
									socio.getID_PROFESION(),
									"N",
									socio.getE_MAIL1(),
									null, null, null, null, null, socio.getAUXFLAG2()
								);*/
								TmkLogger.info ("Agregar Domicilio] Se creo en buffersocio " + ID_SUCURSAL + "-" + ID_SOCIO + " con exito.");
							} catch (Exception ce) {
								TmkLogger.error("Agregar Domicilio] No se pudo crear buffersocio " + ID_SUCURSAL + "-" + ID_SOCIO + ". " + e.toString());
							}
						}
						try {
							BufferSocioDomicilioLocalHome bufferHome = (BufferSocioDomicilioLocalHome) DBUtil.getHome("BufferSocioDomicilio");
							bufferHome.create(
								ID_SUCURSAL, ID_SOCIO,
								TIPO_DOMICILIO,
								domicilioDAO.getCalle(),
								domicilioDAO.getNumero(),
								domicilioDAO.getEdificio(),
								domicilioDAO.getPiso(),
								domicilioDAO.getDepto(),
								domicilioDAO.getCodigoPostal(),
								domicilioDAO.getIdLocalidad(),
								domicilioDAO.getIdProvincia(),
								domicilioDAO.getIdPais(),
								"N",
								null
							);
						} catch (CreateException ce) {
							TmkLogger.error("Agregar Domicilio] No se pudo crear buffersocioDomicilio " + ID_SUCURSAL + "-" + ID_SOCIO + " " +
											TIPO_DOMICILIO + ". " + ce.toString());
						}
					} catch (Exception e) {
						TmkLogger.error("Agregar Domicilio] se produjo un error " + ID_SUCURSAL + "-" + ID_SOCIO +  " " +
										TIPO_DOMICILIO + ". " + e.toString());
					}
                }
                //creo el domicilio  con los mismos datos que la de domicilioDAO, pero con 
                //el tipo_domicilio que le corresponde a TIPO_DOMICILIO
                DomicilioDAO domicilio = new DomicilioDAO(
                        socioPK.ID_SUCURSAL,
                        socioPK.ID_SOCIO,
                        TIPO_DOMICILIO,
                        domicilioDAO.getCalle(),
                        domicilioDAO.getNumero(),
                        domicilioDAO.getEdificio(),
                        domicilioDAO.getPiso(),
                        domicilioDAO.getDepto(),
                        domicilioDAO.getCodigoPostal(),
                        domicilioDAO.getIdPais(),
                        domicilioDAO.getIdProvincia(),
                        domicilioDAO.getIdLocalidad(),
                        domicilioDAO.getProvinciaExterna(),
                        domicilioDAO.getLocalidadExterna()
                );
                ordenDAO.setDomicilioFacturacion(domicilio);
            } else if (domicilioDAO.esFacturacion()) {
            	//indico que se seleccino para mostrar luego tildado el radio en la pantalla de domicilios
                ordenDAO.setDomicilioFacturacion(domicilioDAO);
            //En rediseño de proceso de compra defini un parametro para indica
            //que la direccion es de facturacion->"TIPO_DOMICILIO_FAC" 
            } else if(request.getParameter("TIPO_DOMICILIO_FAC") != null) {
            	domicilioDAO = DomicilioDAO.load(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO, request.getParameter("TIPO_DOMICILIO_FAC"));
            	ordenDAO.setDomicilioFacturacion(domicilioDAO);
            }
        } catch (Exception e) { 
        	//if(!esProcesoNuevo){
        		//CompraHelper.redirectTo(response, CompraHelper.PAGINA_DOMICILIO_ + DomicilioDAO.HEADER_ENVIO);
        	//}else{
        		CompraHelper.redirectTo(response, ProcesoCompraUtil.ENTREGA);
        	//}
        	return;
        }

        //BLOQUE PARA CHEQUEO DE SI ES SUSCRIPCION SOLO SEA EN ARGETINA
        /*if(CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))){
        	//si el pais no es argentina indico con un mensaje de error
        	try{
	        	if(!ordenDAO.getDomicilioEnvio().getIdPais().equals(Globals.ARGENTINA.getId())||
	        			!ordenDAO.getDomicilioFacturacion().getIdPais().equals(Globals.ARGENTINA.getId())){
	        		session.setAttribute("errorEnDomicilioDeSuscripcion", "true");
	        		response.sendRedirect("/compra/domicilios.jsp?TIPO_DOMICILIO=EN");
	        		return;
	        	}else{
	        		//si esta Ok, elimino el msj.
	        		session.removeAttribute("errorEnDomicilioDeSuscripcion");
	        	}
        	}catch(Exception npe){
        		TmkLogger.info("Falta cargar direccion] " + npe);
        	}
        }*/
        //FIN BLOQUE VALIDACION PAIS     
        //if(esProcesoNuevo) {
        	request.setAttribute("seguir", "/compra/medioDeCobro.do");
        //}
        // Siguiente estado
        CompraHelper.proximoEstado(request, response, ordenDAO);
    }
}
