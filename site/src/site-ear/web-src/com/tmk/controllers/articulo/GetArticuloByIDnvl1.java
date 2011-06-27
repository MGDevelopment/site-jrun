package com.tmk.controllers.articulo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.ArticuloAutor;
import com.tmk.bus.articulo.Autor;
import com.tmk.bus.articulo.Disponibilidad;
import com.tmk.bus.articulo.Editor;
import com.tmk.bus.articulo.Formato;
import com.tmk.bus.articulo.MasVendidoSeccion;
import com.tmk.bus.articulo.Tasa;
import com.tmk.bus.articulo.TipoArticulo;
import com.tmk.common.ComentarioClass;
import com.tmk.controllers.MainHelper;
import com.tmk.dbo.DBO;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.xml.converter.AutorConverter;
import com.tmk.xml.converter.CapitalizarDescripcionConverter;
import com.tmk.xml.converter.EditorConverter;
import com.tmk.xml.converter.IdiomaConverter;
import com.tmk.xml.converter.TimestampConverter;

public class GetArticuloByIDnvl1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String idArticulo = request.getParameter("idArticulo");
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".editor");
				camposABuscar.agregarCampoABusqueda(Editor.getAlias() + ".nombre");
				camposABuscar.agregarCampoABusqueda(Editor.getAlias() + ".id_editor");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".idioma");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".paginas");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".formato");
				camposABuscar.agregarCampoABusqueda(Formato.getAlias() + ".rv_meaning");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tipoArticulo");
				camposABuscar.agregarCampoABusqueda(TipoArticulo.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".disponibilidad");
				camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".id_esquema");
				camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".pedido_especial");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".masVendidoSeccion");
				camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".orden");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".articuloAutor");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".autor");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion2");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".role");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tasa");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_general");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_adicional");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_percep_video");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".precio_venta_vigente");


				CamposLeftJoinDBO camposLeftJoinDBO = new CamposLeftJoinDBO();
				camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".editor");
				camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".formato");
				camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".tipoArticulo");
				camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".disponibilidad");
				camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".masVendidoSeccion");
				camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".articuloAutor");
				camposLeftJoinDBO.setCampoDBOLeftJoin(ArticuloAutor.getAlias() + ".autor");
				camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".tasa");

				Articulo art = new Articulo(new Integer(idArticulo));
				DBO.select(art, conn, camposABuscar, camposLeftJoinDBO);
				art.filtrarAutores();
				art.setUrlDetalle();
				art.setImagen();
				art.setUrlBusquedaAutor();
				art.setUrlBusquedaEditor();
				art.setClsPrecio();

				try {
					double infoComentario [] = ComentarioClass.getCantidadDeComentariosYEvaluacion(art.getId_articulo().intValue());
					art.setCantidadComentario(Convert.toString(infoComentario[0]));
					art.setEvaluacionComentario(Convert.toString(infoComentario[1]));
				} catch (Exception e) {
					TmkLogger.debug(e.toString());
				}

				XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
				xstream.alias("Articulo", Articulo.class);
				xstream.registerLocalConverter(Articulo.class, "titulo", new CapitalizarDescripcionConverter());
				xstream.registerLocalConverter(Formato.class, "rv_meaning", new CapitalizarDescripcionConverter());
				xstream.registerLocalConverter(TipoArticulo.class, "descripcion", new CapitalizarDescripcionConverter());
				xstream.registerConverter(new TimestampConverter());
				xstream.registerLocalConverter(Autor.class, "descripcion", new AutorConverter());
				xstream.registerLocalConverter(Autor.class, "descripcion2", new AutorConverter());
				xstream.registerLocalConverter(Editor.class, "nombre", new EditorConverter());
				xstream.registerLocalConverter(Articulo.class, "idioma", new IdiomaConverter());

				xstream.omitField(DBO.class, "seteado");

		        out.print(Convert.toFixedJSON(xstream.toXML(art)));

				} finally {
					conn.close();
				}
		} catch (Exception e) {
			TmkLogger.error(this.getClass().getName() + "]" + e.toString() + MainHelper.getMessage(e));
		}
	}
}
