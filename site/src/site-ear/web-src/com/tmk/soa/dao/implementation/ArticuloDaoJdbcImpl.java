package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.ArticuloAutor;
import com.tmk.bus.articulo.ArticuloAutorBiografia;
import com.tmk.bus.articulo.Autor;
import com.tmk.bus.articulo.DescripcionPrincipal;
import com.tmk.bus.articulo.Disponibilidad;
import com.tmk.bus.articulo.Editor;
import com.tmk.bus.articulo.Formato;
import com.tmk.bus.articulo.MasVendidoSeccion;
import com.tmk.bus.articulo.Tasa;
import com.tmk.bus.articulo.TemaMusical;
import com.tmk.bus.articulo.TipoArticulo;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.bus.socio.SocioIntegracion;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.dbo.sql.OrderBYDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.interfaces.ArticuloDAO;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.persistencia.ConnectionProvider;

public class ArticuloDaoJdbcImpl implements ArticuloDAO {

	public Collection getListaArticulos(Integer idArticulo)
			throws AplicationException {
		
		List<Integer>idsArticulo = new ArrayList<Integer>();
		idsArticulo.add(idArticulo);
		return this.getListaArticulos(idsArticulo,null);
	}
	
	@SuppressWarnings("unchecked")
	public Collection getListaArticulosParaSEO(List<Integer> idArticulos) {
		Collection<Articulo> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				//camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
				//camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".precio_venta_vigente");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".descripcion");
										
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".articuloAutor");//DBO ArticuloAutor			
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".role");			
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".autor");//DBO Autor
				
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion2");
			
				//campos left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".articuloAutor");
				camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".autor");

				Condicion condicionIn = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IN,Comparador.listaToIN(idArticulos));
						
				WhereDBO where = new WhereDBO();
				where.add(condicionIn);			
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, new ComparadorPorDefecto());				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
		}	
		return art;
	}
	public Collection getListaArticulos(List<Integer> idArticulos,Comparator<DBO> comparador) throws AplicationException {		
		if(comparador == null) {
			comparador = new ComparadorPorDefecto();
		}
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
				
				//campos left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".comentarioArticulo");
				camposLeftJoin.setCampoDBOLeftJoin(ComentarioArticulos.getAlias()+".socio");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".articuloAutor");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".descripcionPrincipal");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".tasa");
				camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".autor");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".masVendidoSeccion");
				
				Condicion condicionIn = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IN,Comparador.listaToIN(idArticulos));
										
				Condicion condicionEstado = new Condicion(
						ComentarioArticulos.getAlias()+".estado(+)",Comparador.IGUAL,"'A'");
				/*Condicion condicionEstadoA = new Condicion(
						ComentarioArticulos.getAlias()+".estado",Comparador.IGUAL,"'A'");
				Condicion condicionEstadoN = new Condicion(
						ComentarioArticulos.getAlias()+".estado",Comparador.IGUAL,"'N'");
				Condicion condFecha = new Condicion(
						ComentarioArticulos.getAlias()+".fecha",Comparador.MAYOR,"SYSDATE - (1 / 24 * 1)");														
				Condicion CondicionDerecha = new Condicion(condicionEstadoN, Operador.AND,condFecha);
				
				Condicion grupo = new Condicion(condicionEstadoA,Operador.OR,CondicionDerecha);
				*/		
				WhereDBO where = new WhereDBO();
				where.add(condicionIn);
				where.add(Operador.AND,condicionEstado);
				//where.add(Operador.AND,grupo);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			throw new AplicationException(e);
		}	
		return art;
	}

	public Articulo getArticuloById(Integer idArticulo)
			throws AplicationException {
		try {
			return this.getArticuloById(idArticulo, null);
		} catch (AplicationException e) {
			return null;
		}
	}
	public Articulo getArticuloById(Integer idArticulo,Comparator<DBO> comparador) throws AplicationException {		
		if(comparador == null) {
			comparador = new ComparadorPorDefecto();
		}
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
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tasa");//dbo
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".idioma");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".cod_ext_visual");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".paginas");
				//agrego el tipo de articulo
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tipoArticulo");
				camposABuscar.agregarCampoABusqueda(TipoArticulo.getAlias() + ".id_tipo_articulo");
				camposABuscar.agregarCampoABusqueda(TipoArticulo.getAlias() + ".descripcion");
				
				
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".disponibilidad");//dbo
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
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".biografia");
				
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".id_articulo");//DBO biografias
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".role");
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".texto");
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".parte");
				
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
				
				/*camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".masVendidoSeccion");//DBO MasVendidos
				camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".orden");*/
				
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".editor");
				camposABuscar.agregarCampoABusqueda(Editor.getAlias() + ".nombre");
				camposABuscar.agregarCampoABusqueda(Editor.getAlias() + ".id_editor");
				
				//formato
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".formato");//DBO Formato
				camposABuscar.agregarCampoABusqueda(Formato.getAlias() + ".rv_meaning");
				
				//temas_musicales
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".temaMusical");//DBO tema Musica
				camposABuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".nro_tema");
				camposABuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".nombre");
				
				//campos left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".comentarioArticulo");
				camposLeftJoin.setCampoDBOLeftJoin(ComentarioArticulos.getAlias()+".socio");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".articuloAutor");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".descripcionPrincipal");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".tasa");
				camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".autor");
				camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".biografia");	
				//camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".masVendidoSeccion");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".formato");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".temaMusical");
				
				Condicion condicionIn = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IGUAL,""+idArticulo);
										
				Condicion condicionEstado = new Condicion(
						ComentarioArticulos.getAlias()+".estado(+)",Comparador.IGUAL,"'A'");
					
				WhereDBO where = new WhereDBO();
				where.add(condicionIn);
				where.add(Operador.AND,condicionEstado);
				//where.add(Operador.AND,grupo);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
			throw new AplicationException(e.getMessage());
		}	
		return (Articulo)art.iterator().next();
	}
	
	public Articulo getComentariosXArticulo(Integer idArticulo) throws AplicationException {		
		try {
			return this.getComentarioXArticulo(idArticulo, null);
		} catch (AplicationException e) {
			return null;
		}
	}
		
	/***
	 * devue los comentarios para un articulo particular, si esta aprobado 'A' o si tiene como maximo 
	 * una hora de haber sido comenta do
	 */		
	public Articulo getComentarioXArticulo(Integer idArticulo,Comparator<DBO> comparador)throws AplicationException {
			Collection<DBO> art  = null;
			if(comparador == null){
				comparador =  new ComparadorPorDefecto();
			}
			CamposABuscarDBO camposABuscar = null;
			CamposLeftJoinDBO camposLeftJoin = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");				
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".comentarioArticulo");//DBO comentarioArticulo
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".evaluacion");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".estado");
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
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".socioIntegracion");
				camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".identificador");
				camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".dominio");
				
				//campos left join
				camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+ ".comentarioArticulo");
				camposLeftJoin.setCampoDBOLeftJoin(ComentarioArticulos.getAlias()+".socio");
				camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+ ".socioIntegracion");
				
				Condicion condicionIgual = new Condicion(Articulo.getAlias()+".id_articulo",
				Comparador.IGUAL,""+idArticulo);	
				
				Condicion condicionEstadoA = new Condicion(
						ComentarioArticulos.getAlias()+".estado",Comparador.IGUAL,"'A'");
				Condicion condicionEstadoN = new Condicion(
						ComentarioArticulos.getAlias()+".estado",Comparador.IGUAL,"'N'");
				Condicion condFecha = new Condicion(
						ComentarioArticulos.getAlias()+".fecha",Comparador.MAYOR,"SYSDATE - (1 / 24 * 1)");														
				Condicion CondicionDerecha = new Condicion(condicionEstadoN, Operador.AND,condFecha);
				
				Condicion grupo = new Condicion(condicionEstadoA,Operador.OR,CondicionDerecha);
				
				WhereDBO where = new WhereDBO();
				where.add(condicionIgual);
				where.add(Operador.AND,grupo);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(ComentarioArticulos.getAlias()+".f_alta desc");
								
				art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
				camposABuscar = null;
				camposLeftJoin = null;
			}
		} catch (Exception e) {
			//TmkLogger.error("ArticuloDaoJdbcImpl->getComentarioXArticulo->idArticulo="+ idArticulo+"->No tiene comentarios");
			return null;
		}	
		return (Articulo)art.iterator().next();
	}

	/**
	 * Obtiene los articulos relacionados a uno particular para mostrar en el detalle.
	 */
	public Collection getArticulosRelacionados(List<Integer> idArticulos) {
		Collection<DBO> art  = null;
		ComparadorPorDefecto comparador  = new ComparadorPorDefecto();
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
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
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".precio_venta_vigente");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tasa");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".idioma");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".cod_ext_visual");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".paginas");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_general");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_adicional");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_percep_video");
				
				//campos left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();				
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".tasa");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".comentarioArticulo");
				camposLeftJoin.setCampoDBOLeftJoin(ComentarioArticulos.getAlias()+".socio");
				
				Condicion condicionIn = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IN,Comparador.listaToIN(idArticulos));										
						
				WhereDBO where = new WhereDBO();
				where.add(condicionIn);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
		}	
		return art;
	}


	/**
	 * Obtiene los ids De los articulos que estan relacionados en venta al <br>
	 * que se esta mostrando su detalle
	 */
	public List<Integer> getIdsArticulosRelacionados(Integer idArticulo,
			int cantidad) throws SQLException,AplicationException{
		List<Integer> retorno = new ArrayList<Integer>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {			
				connection = ConnectionProvider.getConection();								
				StringBuffer qry = new StringBuffer();

				qry.append(" SELECT id_articulo_relacionado");
				qry.append(" FROM articulos art, ");
				qry.append(" (");
				qry.append(" SELECT id_articulo_relacionado, id_articulo");
				qry.append(" FROM ");
				qry.append("    ( ");
				qry.append("    SELECT id_articulo_relacionado, id_articulo");
				qry.append("    FROM ");
				qry.append("        ( ");
				qry.append("        SELECT rco.id_articulo_relacionado, rco.cant_comprobantes, rco.id_articulo ");
				qry.append("        FROM articulos arr, articulos art, rco_articulos_relacionados rco ");
				qry.append("        WHERE arr.activo = 'SI' AND arr.id_articulo = rco.id_articulo_relacionado ");
				qry.append("            AND art.id_articulo  = rco.id_articulo AND rco.cant_comprobantes>= ");
				qry.append("            GET_RECO_UMBRAL_CATEGORIA (art.categoria_seccion, art.categoria_grupo, art.categoria_familia, ");
				qry.append("            art.categoria_subfamilia, NULL, art.fecha_alta) AND rco.tipo_relacion = 'C' AND rco.id_articulo =").append(idArticulo);
				qry.append("            AND arr.habilitado_tematika = 'S' ");
				qry.append("            AND arr.categoria_seccion in  (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append("        UNION ");
				qry.append("        SELECT rco.id_articulo_relacionado, rco.cant_comprobantes, rco.id_articulo" );
				qry.append("        FROM articulos arr,rco_articulos_relacionados rco ");
				qry.append("        WHERE arr.activo = 'SI' AND arr.id_articulo = rco.id_articulo_relacionado AND rco.tipo_relacion = 'M' ");
				qry.append("            AND rco.id_articulo =").append(idArticulo).append(" AND NVL(rco.fecha_expiracion, SYSDATE + 1) >= SYSDATE ");
				qry.append("            AND arr.habilitado_tematika = 'S' ");
				qry.append("            AND arr.categoria_seccion in  (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append("        ) ");
				qry.append("    ORDER BY cant_comprobantes desc ");
				qry.append("    ) ");
				qry.append(" WHERE rownum <=").append(cantidad);
				qry.append(" ) s where art.id_articulo = ").append(idArticulo);

				statement = connection.prepareStatement(qry.toString());				
                rs = statement.executeQuery();				
				while (rs.next()) {
                    retorno.add(rs.getInt("id_articulo_relacionado"));
                    //retorno.add("" + rs.getString("titulo"));
                    //retorno.add("" + rs.getString("titparametro"));
				}
			} catch (Exception e) {
				throw new AplicationException(e.getMessage());
			}finally{
				connection.close();
				statement.close();
				rs.close();
			}
		return retorno;
	}

	public TemaMusical[] getTemasMusicalesByIdArticulo(Integer idArticulo) throws AplicationException {		
		
		ComparadorPorDefecto comparador = new ComparadorPorDefecto();
		
		Collection<DBO> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");								
				//temas_musicales
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".temaMusical");//DBO Formato
				camposABuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".nro_tema");
				camposABuscar.agregarCampoABusqueda(TemaMusical.getAlias() + ".nombre");
				
				//campos left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".temaMusical");
				
				Condicion condicionIn = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IGUAL,""+idArticulo);
					
				WhereDBO where = new WhereDBO();
				where.add(condicionIn);				
											
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
			throw new AplicationException(e.getMessage());
		}	
		if(art != null)
			return ((Articulo)art.iterator().next()).getTemaMusical();
		else
			return null;
	}
	
	public Articulo getBiografiaByIdArticulo(Integer idArticulo)
			throws AplicationException {
	
		ComparadorPorDefecto comparador = new ComparadorPorDefecto();
		Collection<DBO> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
				
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".articuloAutor");//DBO ArticuloAutor			
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".role");				
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".biografia");
				
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".id_articulo");//DBO biografias
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".role");
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".texto");
				camposABuscar.agregarCampoABusqueda(ArticuloAutorBiografia.getAlias() + ".parte");
				
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".autor");//DBO Autor				
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion2");
								
				
				//campos left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".articuloAutor");
				camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".autor");
				camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".biografia");				
				
				
				Condicion condicionIn = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IGUAL,""+idArticulo);												
					
				WhereDBO where = new WhereDBO();
				where.add(condicionIn);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
			throw new AplicationException(e.getMessage());
		}	
		return (Articulo)art.iterator().next();
	}
	
	public Articulo getDatosPrincipal(Integer idArticulo) {
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
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".idioma");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".cod_ext_visual");
				
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				
				Condicion condicionIgual = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IGUAL,""+idArticulo);
													
				WhereDBO where = new WhereDBO();
				where.add(condicionIgual);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			//TmkLogger.error(MainHelper.getMessage(e));
			return null;
		}	
		return (Articulo)art.iterator().next();
	}
	
	public Articulo getArticuloByIDParaCarrito(Integer idArticulo) throws AplicationException{
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
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".idioma");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".cod_ext_visual");
				//campos dbo's 
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tasa");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_general");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_adicional");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_percep_video");
				
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".articuloAutor");//DBO ArticuloAutor			
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".role");			
				camposABuscar.agregarCampoABusqueda(ArticuloAutor.getAlias() + ".autor");//DBO Autor
				
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".id_autor");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(Autor.getAlias() + ".descripcion2");
				
				
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".articuloAutor");
				camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".autor");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".tasa");
				
				Condicion condicionIgual = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IGUAL,""+idArticulo);
													
				WhereDBO where = new WhereDBO();
				where.add(condicionIgual);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
			return (Articulo)art.iterator().next();
		} catch (Exception e) {
			//TmkLogger.error(MainHelper.getMessage(e));	
			throw new AplicationException(e.getMessage());
		}			
	}

	public Articulo getArticuloByIDParaChequearDisponibilidad(Integer idArticulo)
			throws AplicationException {
		CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tasa");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".precio_venta_vigente");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".cod_ext_visual");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".disponibilidad");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".habilitado_tematika");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");

		camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_general");
		camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_adicional");
		camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_percep_video");
		camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".id_disponibilidad");
		camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".id_esquema");
		camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".pedido_especial");
		camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".descripcion");

		CamposLeftJoinDBO camposLeftJoinDBO = new CamposLeftJoinDBO();
		camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".tasa");
				
		Condicion condicionIgual = new Condicion(Articulo.getAlias()+".id_articulo",
				Comparador.IGUAL,""+idArticulo);
								
		WhereDBO where = new WhereDBO();
		where.add(condicionIgual);
		DBO art = null;
		try {
			Connection conn = ConnectionProvider.getConection();
			try {										
				art = ((TreeSet<DBO>)DBO.select2(Articulo.class, conn, camposABuscar, camposLeftJoinDBO,where,null,new ComparadorPorDefecto())).iterator().next();			
				return (Articulo)art;
			}finally {
				conn.close();
				camposABuscar = null;
				camposLeftJoinDBO = null;
				condicionIgual = null;
				where = null;
			}			
		}catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
			throw new AplicationException(e.getMessage());
		} 
	}
	
	/**
	 * Obtiene el articulo para la home de tematika
	 */
	/*public Articulo getComentarioParaHome(Integer idArticulo,Comparator<DBO> comparador)throws AplicationException {
		Collection<DBO> art  = null;
		if(comparador == null){
			comparador =  new ComparadorPorDefecto();
		}
		CamposABuscarDBO camposABuscar = null;
		CamposLeftJoinDBO camposLeftJoin = null;
	try {
		Connection conn = DBUtil.buildConnection();
		try {
			camposABuscar = new CamposABuscarDBO();
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
			camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".comentarioArticulo");//DBO comentarioArticulo
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_comentario");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".evaluacion");
			camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".estado");
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
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".socioIntegracion");
			camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".id_socio");
			camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".id_sucursal");
			camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".identificador");
			camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".dominio");
			
			//campos left join
			camposLeftJoin = new CamposLeftJoinDBO();
			camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+ ".comentarioArticulo");
			camposLeftJoin.setCampoDBOLeftJoin(ComentarioArticulos.getAlias()+".socio");
			camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+ ".socioIntegracion");
			
			Condicion condicionIgual = new Condicion(Articulo.getAlias()+".id_articulo",
			Comparador.IGUAL,""+idArticulo);	
			
			Condicion condicionEstadoA = new Condicion(
					ComentarioArticulos.getAlias()+".estado",Comparador.IGUAL,"'A'");
			Condicion condicionEstadoN = new Condicion(
					ComentarioArticulos.getAlias()+".estado",Comparador.IGUAL,"'N'");
			Condicion condFecha = new Condicion(
					ComentarioArticulos.getAlias()+".fecha",Comparador.MAYOR,"SYSDATE - (1 / 24 * 1)");														
			Condicion CondicionDerecha = new Condicion(condicionEstadoN, Operador.AND,condFecha);
			
			Condicion grupo = new Condicion(condicionEstadoA,Operador.OR,CondicionDerecha);
			
			WhereDBO where = new WhereDBO();
			where.add(condicionIgual);
			where.add(Operador.AND,grupo);
											
			OrderBYDBO order = new OrderBYDBO();
			order.agregarCampoAOrden(ComentarioArticulos.getAlias()+".f_alta desc");
							
			art =  (TreeSet<DBO>)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
		} finally {
			conn.close();
			camposABuscar = null;
			camposLeftJoin = null;
		}
	} catch (Exception e) {
		//TmkLogger.error("ArticuloDaoJdbcImpl->getComentarioXArticulo->idArticulo="+ idArticulo+"->No tiene comentarios");
		return null;
	}	
	return (Articulo)art.iterator().next();
	}
	*/
}
