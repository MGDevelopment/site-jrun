/**
 * @author Lizardo Santiago
 *
 * $Log: AgregarDomicilio.java,v $
 * Revision 1.23  2008/07/07 18:59:56  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.22  2006/10/12 14:59:11  omsartori
 * no message
 *
 * Revision 1.21  2006/02/20 12:38:25  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.20  2006/02/09 16:15:36  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.19  2005/12/13 16:16:45  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.18  2005/04/26 17:32:11  omsartori
 * - Arreglado bug buscador rapido comilla simple.
 * - Arreglado bug buscador avanzado comilla simple.
 * - Referido circuito completo testeado.
 * - Posicionamiento: metas home, links producto a detalle y a buscador por categoria.
 *
 * Revision 1.17  2004/06/09 18:50:22  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.16  2004/05/14 19:19:12  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.15  2003/12/04 17:21:30  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.14  2003/11/19 18:55:49  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.13  2003/11/03 20:57:18  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.12  2003/10/13 04:08:54  SLizardo
 * no message
 *
 */
package com.tmk.controllers.registracion;

import com.tmk.bus.socio.BufferSocios;
import com.tmk.bus.socio.Socios2;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.socio.*;
//import com.tmk.util.ShortCuts;
import javax.ejb.CreateException;
//import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.tmk.src.socio.SocioPK;
import com.tmk.src.socio.BufferSocioPK;

public class AgregarDomicilio extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//boolean esProcesoNuevo = request.getSession().getAttribute("procesoDeCompraNuevo")!=null && request.getSession().getAttribute("procesoDeCompraNuevo").equals("true"); 
		try {
			SocioPK pk = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
			Integer ID_SUCURSAL = pk.ID_SUCURSAL;
			Integer ID_SOCIO = pk.ID_SOCIO;
			
			//bloque para obtener el tipo de domicilio a agregar
			String TIPO_DOMICILIO_A_AGREGAR  = request.getParameter("TIPO_DOMICILIO_A_AGREGAR");
			if(null == TIPO_DOMICILIO_A_AGREGAR) {
				TIPO_DOMICILIO_A_AGREGAR = request.getParameter("TIPO_DOMICILIO"); 
			}
			
			//String TIPO_DOMICILIO = DBUtil.buildAddress(ID_SUCURSAL, ID_SOCIO, request.getParameter("TIPO_DOMICILIO"));
			String TIPO_DOMICILIO = DBUtil.buildAddress(ID_SUCURSAL, ID_SOCIO, TIPO_DOMICILIO_A_AGREGAR);
			String CALLE = Convert.toString(request.getParameter("CALLE"), null);
			Integer NUMERO = Convert.toNumber(request.getParameter("NUMERO"), (Integer)null);
			String EDIFICIO = Convert.toString(request.getParameter("EDIFICIO"), null);
			Integer PISO = Convert.toNumber(request.getParameter("PISO"), (Integer)null);
			String DEPTO = Convert.toString(request.getParameter("DEPTO"), null);
			String CP = Convert.toString(request.getParameter("CP"), null);
			Integer ID_LOCALIDAD = Convert.toNumber(request.getParameter("ID_LOCALIDAD"), (Integer)null);
			Integer ID_PROVINCIA = Convert.toNumber(request.getParameter("ID_PROVINCIA"), (Integer)null);
			Integer ID_PAIS = Convert.toNumber(request.getParameter("ID_PAIS"), (Integer)null);
			String DESCRIPCION_PROVINCIA_INEX = Convert.toString(request.getParameter("PROVINCIA_EXTERNA"), null);
			String DESCRIPCION_LOCALIDAD_INEX = Convert.toString(request.getParameter("LOCALIDAD_EXTERNA"), null);

			if (Convert.toString(NUMERO, "").length() > 5) {
				CALLE = CALLE + " " + NUMERO;
				NUMERO = null;
			}

			SocioDomicilioLocalHome domicilioHome = (SocioDomicilioLocalHome) DBUtil.getHome("SocioDomicilio");
			domicilioHome.create(
			        ID_SUCURSAL, ID_SOCIO,
			        TIPO_DOMICILIO,
			        CALLE, NUMERO, EDIFICIO, PISO, DEPTO, CP, ID_LOCALIDAD, ID_PROVINCIA, ID_PAIS,
			        DESCRIPCION_PROVINCIA_INEX, DESCRIPCION_LOCALIDAD_INEX
			);

			//SocioLocal socio = ShortCuts.findSocioById(new com.tmk.socio.SocioPK(pk.ID_SUCURSAL,pk.ID_SOCIO));
			Socios2 socio = ServiceLocator.getSocioService().findByPrimaryKey(pk);

			try {
				BufferSocioPK bufferSocioPK = new BufferSocioPK(ID_SUCURSAL, ID_SOCIO);
				//BufferSocioLocalHome bufferSocioLocalHome = (BufferSocioLocalHome) DBUtil.getHome("BufferSocio");
				try {
					BufferSocios bufferSocioLocal = new BufferSocios(bufferSocioPK); 
					/*BufferSocioLocal bufferSocioLocal = bufferSocioLocalHome.findByPrimaryKey(bufferSocioPK);
					bufferSocioLocal.setPROCESADO("N");
					bufferSocioLocal.setPROCESADO_ECL(null);
					bufferSocioLocal.setAUXFLAG2(socio.getAUXFLAG2());*/
					bufferSocioLocal.setProcesado("N");
					bufferSocioLocal.setProcesado_ecl(null);
					bufferSocioLocal.setAuxflag2(socio.getAuxflag2());
					ServiceLocator.getDboService().update(bufferSocioLocal);				
				//} catch (FinderException e) {
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
								null, null, null, null, null,
								socio.getAuxflag2()
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
							null, null, null, null, null,
							socio.getAUXFLAG2()
						);*/
						TmkLogger.info ("Agregar Domicilio] Se creo en buffersocio " + ID_SUCURSAL + "-" + ID_SOCIO + " con exito.");
					//} catch (CreateException ce) {
					} catch (Exception ce) {
						TmkLogger.error("Agregar Domicilio] No se pudo crear buffersocio " + ID_SUCURSAL + "-" + ID_SOCIO + ". " + e.toString());
					}
				}
				try {
					BufferSocioDomicilioLocalHome bufferHome = (BufferSocioDomicilioLocalHome) DBUtil.getHome("BufferSocioDomicilio");
					bufferHome.create(
						ID_SUCURSAL, ID_SOCIO,
						TIPO_DOMICILIO,
						CALLE, NUMERO, EDIFICIO, PISO, DEPTO, CP, ID_LOCALIDAD, ID_PROVINCIA, ID_PAIS, "N", null
					);
				} catch (CreateException ce) {
					TmkLogger.error("Agregar Domicilio] No se pudo crear buffersocioDomicilio " + ID_SUCURSAL + "-" + ID_SOCIO + " " +
					                TIPO_DOMICILIO + ". " + ce.toString());
				}
			} catch (Exception e) {
                TmkLogger.error("Agregar Domicilio] se produjo un error " + ID_SUCURSAL + "-" + ID_SOCIO +  " " +
					                TIPO_DOMICILIO + ". " + e.toString());
			}

		} catch (SQLException se) {
			TmkLogger.error("Agregar Domicilio] se produjo un error " + se.getMessage());

		} catch (NamingException ne) {
			TmkLogger.error("Agregar Domicilio] se produjo un error " + ne.getMessage());

		//} catch (CreateException ce) {
		} catch (Exception ce) {
			TmkLogger.error("Agregar Domicilio] se produjo un error " + ce.getMessage());
		}

		String _DISPATCHER = request.getParameter("_DISPATCHER");
		if(_DISPATCHER==null){
			response.sendRedirect(request.getHeader("referer"));
		}
		response.sendRedirect(_DISPATCHER);
	}
}
