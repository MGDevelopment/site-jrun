package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.bus.socio.Socios2;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorCategoriaSeccion;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.dbo.sql.OrderBYDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.interfaces.ComentarioArticuloDAO;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.persistencia.ConnectionProvider;

public class ComentarioArticuloDaoJdbcImpl implements ComentarioArticuloDAO {

	public ComentarioArticulos findByPK(Integer idComentario,Integer idArticulo) throws AplicationException{
		Collection<DBO> art  = null;
		ComparadorPorDefecto comparador =  new ComparadorPorDefecto();			
		CamposABuscarDBO camposABuscar = null;
		CamposLeftJoinDBO camposLeftJoin = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".evaluacion");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".estado");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".nickname");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".f_alta");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_sucursal_socio");			
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				
				//campos left join
				camposLeftJoin = new CamposLeftJoinDBO();
												
				Condicion cndIdComentario = new Condicion(ComentarioArticulos.getAlias()+".id_comentario",
				Comparador.IGUAL,""+idComentario);	
				Condicion cndIdArticulo= new Condicion(ComentarioArticulos.getAlias()+".id_articulo",
						Comparador.IGUAL,""+idArticulo);	
				
								
				WhereDBO where = new WhereDBO();
				where.add(cndIdComentario);
				where.add(Operador.AND,cndIdArticulo);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(ComentarioArticulos.getAlias()+".f_alta desc");
								
				art =  (TreeSet<DBO>)DBO.select2(ComentarioArticulos.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
				camposABuscar = null;
				camposLeftJoin = null;
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloDaoJdbcImpl->getDetalleXArticulo->idArticulo="+ idComentario+"->No tiene comentarios");
			return null;
		}	
		return (ComentarioArticulos)art.iterator().next();	
	}

	public Collection findByIdArticulo(Integer idArticulo) {
		
		return null;
	}

	public Collection getIdsDeComentarios(int cantidad) throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT   MAX (com.id_comentario) id_comentario, art.categoria_seccion ");
		qry.append(" FROM comentario_articulos com, articulos art ");
		qry.append(" WHERE art.id_articulo = com.id_articulo ");
		//qry.append(" AND art.categoria_seccion IN (1, 3, 4, 5) ");
		qry.append(" AND com.estado = 'A' ");
		qry.append(" AND ART.archivo_imagen != 'N' ");
		qry.append(" AND art.habilitado_tematika = 'S' ");
		qry.append(" AND art.id_disponibilidad > 1 ");
		
		// FIX mgoldsman 20110806 - begin
		qry.append(" AND ROWNUM < " + (cantidad + 1));
		// FIX mgoldsman 20110806 - end
		
		//qry.append(" GROUP BY art.categoria_seccion " );
		qry.append(" GROUP BY com.id_comentario,art.categoria_seccion " );		
		//qry.append(" ORDER BY art.categoria_seccion asc" );
		qry.append(" ORDER BY com.id_comentario desc " );
				
		List<Integer> filas = null;
		try {
			Connection con = ConnectionProvider.getConection();
			try {
				PreparedStatement pst = con.prepareStatement(qry.toString());
					try {
						ResultSet rst = pst.executeQuery();
						filas = new LinkedList<Integer>();
						while(rst.next() && filas.size() < cantidad) {
							filas.add(rst.getInt("id_comentario"));
						}
						rst.close();
					}finally {
						pst.close();
					}					
			}finally {
				con.close();
			}
		}catch(Exception e) {
			throw e;
		}
		return filas;
	}
	
	public ComentarioArticulos getByIdComentario(Integer idComentario) throws AplicationException{
		Collection<DBO> art  = null;
		ComparadorPorDefecto comparador =  new ComparadorPorDefecto();			
		CamposABuscarDBO camposABuscar = null;
		CamposLeftJoinDBO camposLeftJoin = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".evaluacion");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".estado");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".nickname");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".f_alta");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_sucursal_socio");			
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				
				//campos left join
				camposLeftJoin = new CamposLeftJoinDBO();
												
				Condicion cndIdComentario = new Condicion(ComentarioArticulos.getAlias()+".id_comentario",
				Comparador.IGUAL,""+idComentario);	
								
				WhereDBO where = new WhereDBO();
				where.add(cndIdComentario);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(ComentarioArticulos.getAlias()+".f_alta desc");
								
				art =  (TreeSet<DBO>)DBO.select2(ComentarioArticulos.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
				camposABuscar = null;
				camposLeftJoin = null;
			}
		} catch (Exception e) {
			TmkLogger.error("ArticuloDaoJdbcImpl->getDetalleXArticulo->idArticulo="+ idComentario+"->No tiene comentarios");
			return null;
		}	
		return (ComentarioArticulos)art.iterator().next();	
	}
	
	@SuppressWarnings("unchecked")
	public Collection getComentariosByIds(List ids) throws Exception {
		Collection<DBO> art  = null;
		ComparadorPorCategoriaSeccion comparador =  new ComparadorPorCategoriaSeccion();			
		CamposABuscarDBO camposABuscar = null;
		CamposLeftJoinDBO camposLeftJoin = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".evaluacion");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".estado");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".comentario");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".nickname");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".f_alta");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".id_sucursal_socio");			
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
				camposABuscar.agregarCampoABusqueda(ComentarioArticulos.getAlias() + ".socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				
				//campos left join
				camposLeftJoin = new CamposLeftJoinDBO();
												
				Condicion cndIdComentario = new Condicion(ComentarioArticulos.getAlias()+".id_comentario",
				Comparador.IN,Comparador.listaToIN(ids));					
								
				WhereDBO where = new WhereDBO();
				where.add(cndIdComentario);
												
				//OrderBYDBO order = new OrderBYDBO();
				//order.agregarCampoAOrden(ComentarioArticulos.getAlias()+".f_alta desc");
								
				art =  (TreeSet<DBO>)DBO.select2(ComentarioArticulos.class,conn,camposABuscar,camposLeftJoin,where,null, comparador);				
			} finally {
				conn.close();
				camposABuscar = null;
				camposLeftJoin = null;
			}
		} catch (Exception e) {
			throw e;
		}	
		return art;		
	}

	public Collection getIdsDeComentarios(HashMap<String, Object> pk,Integer cantidad) throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT   com.id_comentario");
		qry.append(" FROM comentario_articulos com, articulos art ");
		qry.append(" WHERE com.id_articulo = art.id_articulo ");
		qry.append(" AND art.categoria_seccion = ");
		qry.append( pk.get("idSeccion"));
		
		if(null != pk.get("idGrupo")) {
			qry.append(" AND art.categoria_grupo = ");
			qry.append( pk.get("idGrupo"));
		}
		if(null != pk.get("idFamilia")) {
			qry.append(" AND art.categoria_familia = ");
			qry.append( pk.get("idFamilia"));
		}
		if(null != pk.get("idSubFamilia")) {
			qry.append(" AND art.categoria_subfamilia = ");
			qry.append( pk.get("idSubFamilia"));
		}
		
		qry.append(" AND com.estado = 'A' ");
		qry.append(" AND ART.archivo_imagen != 'N' ");
		qry.append(" AND art.habilitado_tematika = 'S' ");
		qry.append(" AND art.id_disponibilidad > 1 ");
		
		// FIX mgoldsman 20110806 - begin
		qry.append(" AND ROWNUM < " + (cantidad + 1));
		// FIX mgoldsman 20110806 - end
		
		qry.append(" ORDER BY com.id_comentario desc " );
		
				
		List<Integer> filas = null;
		try {
			Connection con = ConnectionProvider.getConection();
			try {
				PreparedStatement pst = con.prepareStatement(qry.toString());
					try {
						ResultSet rst = pst.executeQuery();
						filas = new ArrayList<Integer>(cantidad);
						while(rst.next() && filas.size() <= cantidad-1) {
							filas.add(rst.getInt("id_comentario"));
						}
						rst.close();
					}finally {
						pst.close();
					}					
			}finally {
				con.close();
			}
		}catch(Exception e) {
			throw e;
		}
		return filas;
	
	}
	
	/*public Collection<?> findByEvaluacion(Integer evaluacion) throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" Select categoria_seccion,id_articulo,cantidad,posicion");
		qry.append(" From (");
		qry.append(" SELECT art.categoria_seccion,art.id_articulo, count(com.evaluacion) cantidad,"); 
		qry.append(" ROW_NUMBER() OVER (PARTITION BY art.categoria_seccion ORDER BY count(com.evaluacion)  DESC) posicion"); 
		qry.append(" from comentario_articulos com, articulos art");
		qry.append(" where com.id_articulo = art.id_articulo");
		qry.append(" and sysdate - 15 <= com.f_alta");
		qry.append(" group by art.categoria_seccion,art.id_articulo)datos");
		qry.append(" where datos.posicion = 1");
		
		ArrayList<HashMap<String, Object>>filas = null;
		try {
			Connection con = ConnectionProvider.getConection();
			try {
				PreparedStatement pst = con.prepareStatement(qry.toString());
					try {
						ResultSet rst = pst.executeQuery();
						filas = new ArrayList<HashMap<String, Object>>();
						while(rst.next()) {
							HashMap<String, Object> registros =  new HashMap<String, Object>(4);
							registros.put("CATGORIA_SECCION",rst.getInt("CATGORIA_SECCION"));
							registros.put("ID_ARTICULO",rst.getInt("ID_ARTICULO"));
							registros.put("CANTIDAD",rst.getInt("CANTIDAD"));
							registros.put("POSICION",rst.getInt("POSICION"));
							filas.add(registros);
						}
						rst.close();
					}finally {
						pst.close();
					}
					
			}finally {
				con.close();
			}
		}catch(Exception e) {
			throw e;
		}
		return filas;
	}*/

	/*public Collection<?> findByEvaluacion() throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" Select id_articulo,categoria_Seccion,cantidad,posicion");
		qry.append(" From (");
		qry.append(" SELECT art.categoria_seccion,art.id_articulo, count(com.evaluacion) cantidad,"); 
		qry.append(" ROW_NUMBER() OVER (PARTITION BY art.categoria_seccion ORDER BY count(com.evaluacion)  DESC) posicion"); 
		qry.append(" from comentario_articulos com, articulos art");
		qry.append(" where com.id_articulo = art.id_articulo");
		qry.append(" and sysdate - 360 <= com.f_alta");
		qry.append(" group by art.categoria_seccion,art.id_articulo)datos");
		qry.append(" where datos.posicion = 1");
		
		ArrayList<HashMap<String, Object>>filas = null;
		try {
			Connection con = ConnectionProvider.getConection();
			try {
				PreparedStatement pst = con.prepareStatement(qry.toString());
					try {
						ResultSet rst = pst.executeQuery();
						filas = new ArrayList<HashMap<String, Object>>();
						while(rst.next()) {
							HashMap<String, Object> registros =  new HashMap<String, Object>(4);
							registros.put("CATEGORIA_SECCION",rst.getObject("CATEGORIA_SECCION"));
							registros.put("ID_ARTICULO",rst.getObject("ID_ARTICULO"));
							registros.put("CANTIDAD",rst.getObject("CANTIDAD"));
							registros.put("POSICION",rst.getObject("POSICION"));
							filas.add(registros);
						}
						rst.close();
					}finally {
						pst.close();
					}
					
			}finally {
				con.close();
			}
		}catch(Exception e) {
			throw e;
		}
		return filas;
	}*/

	/*public ComentarioArticulos getComentarioByIdArticulo(Integer idArticulo) throws Exception {
		
		StringBuffer qry = new StringBuffer();
		qry.append(" select id_socio,id_sucursal_socio from comentario_articulos");
		qry.append(" where id_articulo = 496931 and evaluacion = 5 and estado = 'A'and (id_sucursal_socio,id_socio) ");
		qry.append(" in (select id_sucursal_socio,id_socio from comentario_articulos where id_articulo = 496931 and "); 
		qry.append(" f_alta = (select max(f_alta) from comentario_articulos where id_articulo = 496931))"); 
		
		ComentarioArticulos obj = null; 
		try {
			Connection con = ConnectionProvider.getConection();
			try {
				PreparedStatement pst = con.prepareStatement(qry.toString());
					try {
						ResultSet rst = pst.executeQuery();
						obj = new ComentarioArticulos();
						while(rst.next()) {
							obj.setComentario(rst.getString("comentario"));
							obj.setId_socio(rst.getInt("id_socio"));
							obj.setId_sucursal_socio(rst.getInt("id_sucursal_socio"));
						}
						rst.close();
					}finally {
						pst.close();
					}					
			}finally {
				con.close();
			}
		}catch(Exception e) {
			throw e;
		}
		return obj;
	}*/
}
