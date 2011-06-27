
package com.tmk.controllers.comentario;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.controllers.intranet.usuario.PublicacionHelper;
import com.tmk.dbo.DBO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.view.model.ComentarioForm;
import com.tmk.xml.Resultado;

public class Comentario2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("resultado", Resultado.class);
		
		ComentarioForm comentarioForm = null;
		try {
			comentarioForm = (ComentarioForm)ServiceLocator.getModeloBuilderService().getModelo(ComentarioForm.class, request);
		} catch (Exception e2) {
			Resultado res =  new Resultado(false,new String[]{"Error interno, reintene por favor"},null);
			res.setFallaSistema(true);
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
			return;
		}		
		
		SocioPK socioPk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		
		if(socioPk == null) {
			Resultado res =  new Resultado(false,new String[]{"No esta loguado..."},null);
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
			return;
		}
		
		DBO socio =  null;
		try {
			//si encuentra este socio quiere decir que es socio tmk por ende no puede comentar, deber ser socio con registracion larga
			socio = ServiceLocator.getSociosTMKService().findSocioTMKByPK(socioPk);
			Resultado res =  new Resultado(false,new String[]{"Necesitas completar los datos adicionales..."},null);
			res.setTargetRedirect("/miCuenta/modificarSocio.jsp");
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
			return;
		} catch (DBOInexistenteException e1) {
			//si no es socioTMK puede ser un socio en la tabla socios2
			socio = ServiceLocator.getSocioService().findByPK(socioPk);
		} catch (Exception e1) {			
			Resultado res =  new Resultado(false,new String[]{"Error interno, reintente nuevamente..."},null);
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
			return;
		}
		
		try {
			// que hacemos con el nick name? lo mantenemos?
			String nickName = (Convert.toBoolean(request.getParameter(ComentarioHelper.CAMPO_USO_NICKNAME), false)) ? request.getParameter(ComentarioHelper.CAMPO_NICKNAME) : null;

			// Si no tiene los datos minimos, los pide
			if ((comentarioForm.getComentario()== null) || ("".equals(comentarioForm.getComentario().trim()))
			        || (comentarioForm.getEvaluacion() == null)) {
				Resultado res =  new Resultado(false,new String[]{"No tiene completo los campos necesarios, por favor completolos..."},null);
				response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
				return;
			}
			
			ComentarioArticulos comentarioDBO = new ComentarioArticulos(comentarioForm.getIdArticulo(),DBUtil.getSequenceValue("COMENTARIO_ARTICULOS_SEQ").intValue());
			comentarioDBO.setComentario(comentarioForm.getComentario());
			comentarioDBO.setEvaluacion(comentarioForm.getEvaluacion());
			comentarioDBO.setFecha(new Timestamp(System.currentTimeMillis()));
			comentarioDBO.setEstado("N");//Nueva, siempre comienza en este estado
			comentarioDBO.setId_socio(socioPk.ID_SOCIO);
			comentarioDBO.setId_sucursal_socio(socioPk.ID_SUCURSAL);
			try {
				ServiceLocator.getDboService().insert(comentarioDBO);
				Resultado res =  new Resultado(true,new String[]{"Su comentario se ha guardado."},null);
				response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
				TmkLogger.debug("COMENTARIOS] El comentario se grabo exitosamente");
				try {
					PublicacionHelper.publicarComentarioEnTwitter(comentarioDBO);
					TmkLogger.debug("COMENTARIOS] El comentario se ha twiteado");
				}catch(Exception e) {
					StringBuffer sb = new StringBuffer("No se pudo postear en Twitter");
					sb.append(" id_comentario = ").append(comentarioDBO.getId_comentario());
					sb.append(" id_articulo = ").append(comentarioDBO.getId_articulo());
					sb.append(" id_socio = ").append(comentarioDBO.getId_socio());
					sb.append(" id_sucursal = ").append(comentarioDBO.getId_sucursal_socio());
					TmkLogger.error(sb.toString());
				}
			}catch(Exception e) {
				Resultado res =  new Resultado(false,new String[]{"Error interno, no se puedo grabar el comentario, intente nuevamente"},null);
				res.setFallaSistema(true);
				response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
				return;
			}			
		} catch (Exception e) {
			Resultado res =  new Resultado(false,new String[]{"Error interno, no se puedo grabar el comentario, intente nuevamente"},null);
			res.setFallaSistema(true);
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
			return;
		}
	}
}