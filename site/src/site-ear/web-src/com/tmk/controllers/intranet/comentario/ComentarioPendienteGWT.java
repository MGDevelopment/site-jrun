/**
 * $Log: ComentarioPendiente.java,v $
 * Revision 1.5  2007/09/03 13:42:19  msartori
 * no message
 *
 * Revision 1.4  2007/04/26 18:32:51  omsartori
 * no message
 *
 * Revision 1.3  2007/02/16 18:41:03  omsartori
 * - schedule de generacion de ranking y top de familias
 * - correccion bug paginacion de lista de deseos
 * - filtro de palabras para buscador
 * - estadisticas de homes, biografias e indices
 * - correccion de bug de aprobacion de comentarios
 *
 * Revision 1.2  2007/01/22 17:43:20  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.1  2004/08/09 13:41:50  omsartori
 * - Comentario para articulos desde la web
 * - Aprobación de comentarios desde la intranet
 * - Ancla para extensiones en detalle de articulo
 *
 */

package com.tmk.controllers.intranet.comentario;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.kernel.*;
import com.tmk.xml.Resultado;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.comentario.ComentarioHelper;
import com.tmk.controllers.intranet.usuario.PublicacionHelper;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Iterator;
import java.util.TreeSet;

public class ComentarioPendienteGWT extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Resultado resultado = null;
   	   	PrintWriter out = response.getWriter();
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Resultado", Resultado.class);
		xstream.omitField(Resultado.class, "valor");
	    
		try {
	    	Connection conn = DBUtil.buildConnection();	    	
			try {				
				conn.setAutoCommit(false);
				int cantComentario = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_CANTIDAD_COMENTARIO),0);
				//indica que comentarios no se pudieron modificar o postear
				String[]mensajes = new String[cantComentario];
				Integer idComentario = 0;
				Integer idArticulo = 0;
				int indice = 0;
				String estado = "";
				for (int i = 0; i < cantComentario; i++) {
					try {
						idComentario = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ID_COMENTARIO+ i), 0);
						idArticulo = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ARTICULO + i),0);
						estado = request.getParameter(ComentarioHelper.CAMPO_ESTADO + i);
						if(!estado.equals("N")) {
							if ((idComentario.intValue() != 0 && idArticulo.intValue() != 0)) {
								ComentarioArticulos comentarioArticulo = new ComentarioArticulos(idArticulo,idComentario);
								comentarioArticulo.setEstado(estado);
								comentarioArticulo.update(conn);//version vieja pero no hay nada nuevo
								//SE COMENTA EL BLOQUE POR QUE SE TRASLADA LA LOGICA DE 
								//POSTEO A COMENTARIOS.JAVA
								/*
								CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
								cargarObjetosParaQuery(camposABuscar);
								WhereDBO where = new WhereDBO();
								Condicion cndIdComentario = new Condicion(ComentarioArticulos.getAlias()+".id_comentario",Comparador.IGUAL,""+idComentario.intValue());
								where.add(cndIdComentario);		
								
								Iterator  comentario =((TreeSet)DBO.select2(ComentarioArticulos.class, conn, camposABuscar, null, where, null,new ComparadorPorDefecto())).iterator();
								if (estado.equals("A")) {
									PublicacionHelper.publicarComentarioEnTwitter((ComentarioArticulos)comentario.next());
								}*/
							}
							mensajes[indice] = estado+"-"+ ((estado.equals("A")?" Aprobado":" Rechazado"));
							indice++;
							conn.commit();
						}else{
							mensajes[indice] = "N-No se procesa";
							indice++;
						}
					} catch (Exception e) {
						//agrego al array de mensajes no posteados o modificados el idComentario e idArticulo
						mensajes[indice] = "E-"+(" No se pudo "+ (estado.equals("A")? " Aprobar" : " Rechazar"));
						indice++;
						conn.rollback();
						TmkLogger.error(e.toString() + MainHelper.getMessage(e));
					}
				}				
				resultado = new Resultado(true,mensajes,null);				
			} finally {
					conn.close();
			}
	    } catch (Exception e) {
	    	resultado = new Resultado(false,new String[] { "Se ha producido un error contacte al administrador" },null);
	    	TmkLogger.error(e.toString() + MainHelper.getMessage(e));
		}
	    out.print(xstream.toXML(resultado).replaceAll("\n", "").replaceAll("\"Resultado\":", "\"success\":"+resultado.getValor()+",\"response\":"));
    }

	private void cargarObjetosParaQuery(CamposABuscarDBO camposABuscar) {
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_comentario");
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_articulo");
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".evaluacion");
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".comentario");
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".nickname");		
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".fecha");
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".estado");
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".nickname");		
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".socio");
		/*campos socios*/
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
		camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".articulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
		
		
		
	}

}
