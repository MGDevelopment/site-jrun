/**
 * @author Lizardo Santiago
 *
 * $Log: ActualizarDomicilio.java,v $
 * Revision 1.13  2008/07/07 18:59:55  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.12  2006/10/12 14:59:11  omsartori
 * no message
 *
 * Revision 1.11  2006/02/20 12:38:25  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.10  2005/04/26 17:32:11  omsartori
 * - Arreglado bug buscador rapido comilla simple.
 * - Arreglado bug buscador avanzado comilla simple.
 * - Referido circuito completo testeado.
 * - Posicionamiento: metas home, links producto a detalle y a buscador por categoria.
 *
 * Revision 1.9  2003/12/04 17:21:30  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.8  2003/11/19 18:55:49  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.7  2003/11/03 20:57:17  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.6  2003/10/03 16:30:29  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.5  2003/08/29 17:55:17  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.4  2003/08/25 20:46:09  SLizardo
 * Optimize Imports
 *
 * Revision 1.3  2003/08/21 21:12:58  SLizardo
 * no message
 *
 * Revision 1.2  2003/08/09 22:16:00  SLizardo
 * no message
 *
 * Revision 1.1  2003/08/05 22:13:51  SLizardo
 * Se agrego el metodo findByLogin y se cambio el antiguo a findByLoginPassword
 *
 */
package com.tmk.controllers.registracion;

import com.tmk.bus.socio.BufferSocios;
import com.tmk.bus.socio.Socios2;
import com.tmk.kernel.*;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.socio.*;
//import com.tmk.util.ShortCuts;

import javax.ejb.FinderException;
import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.tmk.src.socio.SocioPK;

public class ActualizarDomicilio extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SocioPK pk = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
		if(pk == null) {
			response.sendRedirect("/miCuenta");
		}
			
		String TIPO_DOMICILIO = Convert.toString(request.getParameter("TIPO_DOMICILIO"), null);
		String CALLE = Convert.toString(request.getParameter("CALLE"), null);
		Integer NUMERO = Convert.toNumber(request.getParameter("NUMERO"), (Integer) null);
		String EDIFICIO = Convert.toString(request.getParameter("EDIFICIO"), null);
		Integer PISO = Convert.toNumber(request.getParameter("PISO"), (Integer) null);
		String DEPTO = Convert.toString(request.getParameter("DEPTO"), null);
		String CP = Convert.toString(request.getParameter("CP"), null);
		Integer ID_LOCALIDAD = Convert.toNumber(request.getParameter("ID_LOCALIDAD"), (Integer) null);
		Integer ID_PROVINCIA = Convert.toNumber(request.getParameter("ID_PROVINCIA"), (Integer) null);
		Integer ID_PAIS = new Integer(PaisDAO.getPais(Convert.toNumber(request.getParameter("ID_PAIS"), Globals.ARGENTINA.getId())).getId());
		String DESCRIPCION_PROVINCIA_INEX = request.getParameter("PROVINCIA_EXTERNA");
		String DESCRIPCION_LOCALIDAD_INEX = request.getParameter("LOCALIDAD_EXTERNA");


		try {

			if (Convert.toString(NUMERO, "").length() > 5) {
				CALLE = CALLE + " " + NUMERO;
				NUMERO = null;
			}

			SocioDomicilioPK domicilioPK = new SocioDomicilioPK();
			domicilioPK.ID_SOCIO = pk.ID_SOCIO;
			domicilioPK.ID_SUCURSAL = pk.ID_SUCURSAL;
			domicilioPK.TIPO_DOMICILIO = TIPO_DOMICILIO;
			SocioDomicilioLocalHome domicilioHome = (SocioDomicilioLocalHome) DBUtil.getHome("SocioDomicilio");
			SocioDomicilioLocal domicilio = domicilioHome.findByPrimaryKey(domicilioPK);

			domicilio.setCALLE(CALLE);
			domicilio.setCP(CP);
			domicilio.setDEPTO(DEPTO);
			domicilio.setEDIFICIO(EDIFICIO);
			domicilio.setID_LOCALIDAD(ID_LOCALIDAD);
			domicilio.setID_PAIS(ID_PAIS);
			domicilio.setID_PROVINCIA(ID_PROVINCIA);
			domicilio.setNUMERO(NUMERO);
			domicilio.setPISO(PISO);
			domicilio.setDESCRIPCION_PROVINCIA_INEX(DESCRIPCION_PROVINCIA_INEX);
			domicilio.setDESCRIPCION_LOCALIDAD_INEX(DESCRIPCION_LOCALIDAD_INEX);

		} catch (NamingException ne) {
			TmkLogger.error(ne.getMessage());

		} catch (FinderException fe) {
			TmkLogger.error(fe.getMessage());

		}

		try {
				//SocioLocal socio = ShortCuts.findSocioById(new com.tmk.socio.SocioPK(pk.ID_SUCURSAL,pk.ID_SOCIO));
				Socios2 socio = ServiceLocator.getSocioService().findByPrimaryKey(pk);
				
				//BufferSocioPK bufferSocioPK = new BufferSocioPK(pk.ID_SUCURSAL, pk.ID_SOCIO);
				//BufferSocioLocalHome bufferSocioLocalHome = (BufferSocioLocalHome) DBUtil.getHome("BufferSocio");
				BufferSocios bufferSocio = new BufferSocios(pk.ID_SUCURSAL,pk.ID_SOCIO);
				try {
					/*BufferSocioLocal bufferSocioLocal = bufferSocioLocalHome.findByPrimaryKey(bufferSocioPK);
					bufferSocioLocal.setPROCESADO("N");
					bufferSocioLocal.setPROCESADO_ECL(null);
					bufferSocioLocal.setAUXFLAG2(socio.getAUXFLAG2());*/
					
					bufferSocio.setProcesado("N");
					bufferSocio.setProcesado_ecl(null);
					bufferSocio.setAuxflag2(socio.getAuxflag2());
					ServiceLocator.getDboService().update(bufferSocio);
					
				//} catch (FinderException e) {
				} catch (DBOInexistenteException e) {
					TmkLogger.info ("Actualizar Domicilio] no se encuentra buffersocio " + pk.ID_SUCURSAL + "-" + pk.ID_SOCIO + " comienza la creacion." );
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
							socio.getNro_doc().longValue(),
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
						TmkLogger.info ("Actualizar Domicilio] Se creo en buffersocio " + pk.ID_SUCURSAL + "-" + pk.ID_SOCIO + " con exito.");
					//} catch (CreateException ce) {
					} catch (Exception ce) {
						TmkLogger.error("Actualizar Domicilio] No se pudo crear buffersocio " + pk.ID_SUCURSAL + "-" + pk.ID_SOCIO + ". " + e.toString());
					}
				}
			    BufferSocioDomicilioLocalHome bufferHome = (BufferSocioDomicilioLocalHome) DBUtil.getHome("BufferSocioDomicilio");
				try {
					BufferSocioDomicilioPK bufferSocioDomicilioPK = new BufferSocioDomicilioPK(pk.ID_SUCURSAL, pk.ID_SOCIO, TIPO_DOMICILIO);
					BufferSocioDomicilioLocal bufferSocioDomicilio = bufferHome.findByPrimaryKey(bufferSocioDomicilioPK);
					bufferSocioDomicilio.setCALLE(CALLE);
					bufferSocioDomicilio.setNUMERO(NUMERO);
					bufferSocioDomicilio.setEDIFICIO(EDIFICIO);
					bufferSocioDomicilio.setPISO(PISO);
					bufferSocioDomicilio.setDEPTO(DEPTO);
					bufferSocioDomicilio.setCP(CP);
					bufferSocioDomicilio.setID_LOCALIDAD(ID_LOCALIDAD);
					bufferSocioDomicilio.setID_PROVINCIA(ID_PROVINCIA);
					bufferSocioDomicilio.setID_PAIS(ID_PAIS);
					bufferSocioDomicilio.setPROCESADO("N");
					bufferSocioDomicilio.setPROCESADO_ECL(null);
				}  catch (FinderException fe2) {
					try {

						bufferHome.create(
							pk.ID_SUCURSAL, pk.ID_SOCIO,
							TIPO_DOMICILIO,
							CALLE, NUMERO, EDIFICIO, PISO, DEPTO, CP, ID_LOCALIDAD, ID_PROVINCIA, ID_PAIS, "N", null
						);
					} catch (CreateException ce) {
						TmkLogger.error("Actualizar Domicilio] No se pudo crear buffersocioDomicilio " + pk.ID_SUCURSAL + "-" + pk.ID_SOCIO + " " +
										TIPO_DOMICILIO + ". " + ce.toString());
					}
				}
			} catch (Exception e) {
                TmkLogger.error("Actualizar Domicilio] se produjo un error " + pk.ID_SUCURSAL + "-" + pk.ID_SOCIO +  " " +
					                TIPO_DOMICILIO + ". " + e.toString());
			}

		String _DISPATCHER = request.getParameter("_DISPATCHER");
		response.sendRedirect(_DISPATCHER);
	}
}
