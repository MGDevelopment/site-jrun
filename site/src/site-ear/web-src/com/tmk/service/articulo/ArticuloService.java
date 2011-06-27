package com.tmk.service.articulo;

import java.sql.Connection;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.ArticuloAutor;
import com.tmk.bus.articulo.Autor;
import com.tmk.bus.articulo.DescripcionPrincipal;
import com.tmk.bus.articulo.Disponibilidad;
import com.tmk.bus.articulo.MasVendidoSeccion;
import com.tmk.bus.articulo.Tasa;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.controllers.MainHelper;
import com.tmk.dbo.DBO;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.dbo.sql.OrderBYDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;

public final class ArticuloService {
	
	/**
	 * Con la lista de articulos trae los dbo de los articulos 
	 * @param List idArticulos, Comparator<DBO>, objeto que indica como esta dado el orden de los articulos
	 * resultantes que se cargan en CriteriosDAO
	 * @return lista de Articulos (DBO)
	 */
	@SuppressWarnings("unchecked")
	public static Collection<Articulo> getListaArticulos(List<Integer> idArticulos,Comparator<DBO> comparador) {
		Collection<Articulo> art  = null;
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
				
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_general");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_adicional");
				camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_percep_video");
				
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".masVendidoSeccion");
				camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(MasVendidoSeccion.getAlias() + ".orden");
				
				//campos left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".comentarioArticulo");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".articuloAutor");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".descripcionPrincipal");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".tasa");
				camposLeftJoin.setCampoDBOLeftJoin(ArticuloAutor.getAlias()+".autor");
				camposLeftJoin.setCampoDBOLeftJoin(Articulo.getAlias()+".masVendidoSeccion");

				Condicion condicionIn = new Condicion(Articulo.getAlias()+".id_articulo",
						Comparador.IN,Comparador.listaToIN(idArticulos));
										
				Condicion condicionEstado = new Condicion(
						ComentarioArticulos.getAlias()+".estado(+)",Comparador.IGUAL,"'A'");
						
				WhereDBO where = new WhereDBO();
				where.add(condicionIn);
				where.add(Operador.AND,condicionEstado);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Articulo.getAlias()+".id_articulo");
								
				art =  (TreeSet)DBO.select2(Articulo.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
		}	
		return art;
	}
}
