
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="java.util.TreeSet"%>
<%@page import="com.tmk.dbo.sql.OrderBYDBO"%>
<%@page import="com.tmk.dbo.sql.condicion.Operador"%>
<%@page import="com.tmk.dbo.sql.WhereDBO"%>
<%@page import="com.tmk.dbo.sql.condicion.Comparador"%>
<%@page import="com.tmk.dbo.sql.condicion.Condicion"%>
<%@page import="com.tmk.dbo.sql.CamposLeftJoinDBO"%>
<%@page import="com.tmk.bus.articulo.ArticulosTemasMusicales"%>
<%@page import="com.tmk.bus.articulo.Formato"%>
<%@page import="com.tmk.bus.articulo.Editor"%>
<%@page import="com.tmk.bus.articulo.MasVendidoSeccion"%>
<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.bus.comentario.ComentarioArticulos"%>
<%@page import="com.tmk.bus.articulo.Autor"%>
<%@page import="com.tmk.bus.articulo.ArticuloAutor"%>
<%@page import="com.tmk.bus.articulo.DescripcionPrincipal"%>
<%@page import="com.tmk.bus.articulo.Disponibilidad"%>
<%@page import="com.tmk.bus.articulo.Articulo"%>
<%@page import="com.tmk.dbo.sql.CamposABuscarDBO"%>
<%@page import="com.tmk.kernel.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.tmk.dbo.DBO"%>
<%@page import="java.util.Collection"%>
<%@page import="com.tmk.dbo.comparador.ComparadorPorDefecto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%
	/*List<Integer> idArticulos = new ArrayList<Integer>();
	idArticulos.add(new Integer(486494));
	ComparadorPorDefecto comparador = new ComparadorPorDefecto();	
	Collection<DBO> art  = null;

	try {
		Connection conn = DBUtil.buildConnection();
		try {
			CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_socio");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".precio_venta_vigente");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".descripcion");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".disponibilidad");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tasa");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".idioma");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".cod_ext_visual");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".paginas");
			
			camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".id_disponibilidad");
			camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".descripcion");
			camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".pedido_especial");
			
			
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".descripcionPrincipal");//DBO para la sinopsis articulos_textos
			camposABuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".texto");
			camposABuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".idioma");
			camposABuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".parte");
			camposABuscar.agregarCampoABusqueda(DescripcionPrincipal.getAlias() + ".tipo");			
									
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".articuloAutor");//DBO ArticuloAutor			
			camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_autor");
			camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".role");
			
			camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".autor");//DBO Autor				
			camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".id_autor");
			camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion");
			camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion2");
			
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".comentarioArticulo");//DBO comentarioArticulo
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_comentario");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".evaluacion");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".comentario");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".nickname");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".f_alta");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_socio");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_sucursal_socio");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".socio");
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");

			camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_general");
			camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_adicional");
			camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_percep_video");
			
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".masVendidoSeccion");//DBO MasVendidos
			camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".categoria_seccion");
			camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".orden");
			
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".editor");
			camposABuscar.agregarCampoABusqueda(Editor.getAlias() + ".nombre");
			camposABuscar.agregarCampoABusqueda(Editor.getAlias() + ".id_editor");
			
			//formato
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".formato");//DBO Formato
			camposABuscar.agregarCampoABusqueda(Formato.getAlias() + ".rv_meaning");
			
			//temas_musicales
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".articulos_temas_musicales");//DBO Formato
			camposABuscar.agregarCampoABusqueda(ArticulosTemasMusicales.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(ArticulosTemasMusicales.getAlias() + ".nro_tema");
			
			//campos left join
			CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
			camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".comentarioArticulo");
			camposLeftJoin.setCampoDBOLeftJoin(ComentarioArticulos.getAlias()+".socio");
			camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".articuloAutor");
			camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".descripcionPrincipal");
			camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".tasa");
			camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".autor");
			camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".masVendidoSeccion");
			camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".formato");
			
			Condicion condicionIn = new Condicion(Articulo.getAlias()+".id_articulo",
					Comparador.IN,""+idArticulos);
									
			Condicion condicionEstado = new Condicion(
					ComentarioArticulos.getAlias()+".estado(+)",Comparador.IGUAL,"'A'");
				
			WhereDBO where = new WhereDBO();
			where.add(condicionIn);
			where.add(Operador.AND,condicionEstado);
			//where.add(Operador.AND,grupo);
											
			OrderBYDBO order = new OrderBYDBO();
			order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
							
			art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);
			out.print(art.toString());
		} finally {
			conn.close();
		}
	} catch (Exception a) {
		TmkLogger.error(MainHelper.getMessage(a));
	}	
*/
%>
<a href="/ServletTest.do">Testear</a>