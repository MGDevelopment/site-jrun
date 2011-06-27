package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.TreeSet;
import com.tmk.bus.listas.ListasTmk;
import com.tmk.bus.listas.ListasTmkArticulos;
import com.tmk.bus.listas.ListasTmkCalificaciones;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.bus.socio.Socios2;
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
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.dao.interfaces.ListasTmkDAO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.src.socio.SocioPK;

public class ListasTmkDaoDboImp implements ListasTmkDAO {

	public Object findByPk(Object pk) throws DBOInexistenteException,Exception {
		/*Integer pk1 = (Integer)pk;		
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				//campos que van al select 
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_lista");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".estado");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".publico");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_sucursal_socio");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".f_creacion");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".f_modificacion");
				
				//ListasTmk->ListasTmkArticulos
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".listaTmkArticulos");
				camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".id_lista");
				camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".comentario");
				camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".f_agregado");
				
				//ListasTmk->ListasTmkCalificaciones
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".listasTmkCalificaciones");
				camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".id_lista");
				camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".id_calificacion");
				camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".f_calificacion");
				
				//ListasTmk->ListasTmkSocios2				
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				
				//left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(ListasTmk.getAlias()+".listaTmkArticulos");
				camposLeftJoin.setCampoDBOLeftJoin(ListasTmk.getAlias()+".listasTmkCalificaciones");
							
				//where condition
				WhereDBO where = new WhereDBO();
				Condicion condicion1 = new Condicion(ListasTmk.getAlias()+".id_lista",
						Comparador.IGUAL,pk1.toString() );								
				where.add(condicion1);
							
				//comparador
				ComparadorPorDefecto comparador = new ComparadorPorDefecto();
				
				Collection<DBO> art  =  (TreeSet<DBO>)DBO.select2(ListasTmk.class,conn,camposABuscar,camposLeftJoin,where,null, comparador);
				return (ListasTmk)art.iterator().next();
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			throw e;
		}*/
		return findByPk(pk, false);
	}
	
	public Object findByPk(Object pk,boolean esSocioTMK) throws DBOInexistenteException,Exception {
	Integer pk1 = (Integer)pk;		
	try {
		Connection conn = DBUtil.buildConnection();
		try {
			//campos que van al select 
			CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_lista");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".titulo");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".descripcion");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".categoria_seccion");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".estado");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".publico");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_socio");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_sucursal_socio");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".f_creacion");
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".f_modificacion");
			
			//ListasTmk->ListasTmkArticulos
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".listaTmkArticulos");
			camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".id_lista");
			camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".id_articulo");
			camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".comentario");
			camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".f_agregado");
			
			//ListasTmk->ListasTmkCalificaciones
			camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".listasTmkCalificaciones");
			camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".id_lista");
			camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".id_calificacion");
			camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".f_calificacion");
			
			//ListasTmk->ListasTmkSocios2			
			if(!esSocioTMK) {
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
			}else{
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".socioTMK");
				camposABuscar.agregarCampoABusqueda(SocioTMK.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(SocioTMK.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(SocioTMK.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(SocioTMK.getAlias() + ".apellidos");
			}
			
			
			/*camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".socio");
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
			camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");*/
			
			//left join
			CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
			camposLeftJoin.setCampoDBOLeftJoin(ListasTmk.getAlias()+".listaTmkArticulos");
			camposLeftJoin.setCampoDBOLeftJoin(ListasTmk.getAlias()+".listasTmkCalificaciones");
						
			//where condition
			WhereDBO where = new WhereDBO();
			Condicion condicion1 = new Condicion(ListasTmk.getAlias()+".id_lista",
					Comparador.IGUAL,pk1.toString() );								
			where.add(condicion1);
						
			//comparador
			ComparadorPorDefecto comparador = new ComparadorPorDefecto();
			
			Collection<DBO> art  =  (TreeSet<DBO>)DBO.select2(ListasTmk.class,conn,camposABuscar,camposLeftJoin,where,null, comparador);
			return (ListasTmk)art.iterator().next();
		} finally {
			conn.close();
		}
	} catch (Exception e) {
		throw e;
	}			
}
	
	public Collection<?> findBySocio(Object pk,boolean socioTMK) throws DBOInexistenteException, Exception {
		SocioPK pk1 = (SocioPK)pk;
		
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_lista");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".categoria_seccion");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".estado");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".publico");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".id_sucursal_socio");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".f_creacion");
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".f_modificacion");
				
				//ListasTmk->ListasTmkArticulos
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".listaTmkArticulos");
				camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".id_lista");
				camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".comentario");
				camposABuscar.agregarCampoABusqueda(ListasTmkArticulos.getAlias() + ".f_agregado");
				
				//ListasTmk->ListasTmkCalificaciones
				camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".listasTmkCalificaciones");
				camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".id_lista");
				camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".id_calificacion");
				camposABuscar.agregarCampoABusqueda(ListasTmkCalificaciones.getAlias() + ".f_calificacion");
				
				//ListasTmk->ListasTmkSocios2
				if(!socioTMK) {
					camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".socio");
					camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
					camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
					camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
					camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				}else{
					camposABuscar.agregarCampoABusqueda(ListasTmk.getAlias() + ".socioTMK");
					camposABuscar.agregarCampoABusqueda(SocioTMK.getAlias() + ".id_socio");
					camposABuscar.agregarCampoABusqueda(SocioTMK.getAlias() + ".id_sucursal");
					camposABuscar.agregarCampoABusqueda(SocioTMK.getAlias() + ".nombres");
					camposABuscar.agregarCampoABusqueda(SocioTMK.getAlias() + ".apellidos");
				}
				
				//left join
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(ListasTmk.getAlias()+".listaTmkArticulos");
				camposLeftJoin.setCampoDBOLeftJoin(ListasTmk.getAlias()+".listasTmkCalificaciones");
								
				//where condition
				WhereDBO where = new WhereDBO();
				Condicion condicion1 = new Condicion(ListasTmk.getAlias()+".id_socio",
						Comparador.IGUAL,pk1.ID_SOCIO.toString());
				Condicion condicion2 = new Condicion(ListasTmk.getAlias()+".id_sucursal_socio",
						Comparador.IGUAL,pk1.ID_SUCURSAL.toString() );
				where.add(condicion1);
				where.add(Operador.AND,condicion2);
					
				//order 
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(ListasTmk.getAlias()+".id_lista desc");
				//comparador
				ComparadorPorDefecto comparador = new ComparadorPorDefecto();

				return (TreeSet<DBO>)DBO.select2(ListasTmk.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);	
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			throw e;
		}			
	}

	public void delete(Object obj) throws Exception {
		ListasTmk lista = new ListasTmk(((ListasTmk)obj).getId_lista());
		DAOFactory.getDboDAO().delete(lista);
	}
	
	public void insert(Object obj) throws Exception {
		((ListasTmk)obj).setF_creacion(new Timestamp(System.currentTimeMillis()));
		((ListasTmk)obj).setF_modificacion(new Timestamp(System.currentTimeMillis()));
		((ListasTmk)obj).setEstado("A");
		
		DAOFactory.getDboDAO().insert((ListasTmk)obj);
		
	}

	public void update(Object obj) throws Exception {
		ListasTmk lista = ((ListasTmk)obj);
		//lista.setCategoria_seccion(((ListasTmk)obj).getCategoria_seccion());
		//lista.setEstado(((ListasTmk)obj).getEstado());
		lista.setF_creacion(null);
		lista.setListasTmkCalificaciones(null);
		lista.setListaTmkArticulos(null);
		lista.setF_modificacion(new Timestamp(System.currentTimeMillis()));
		//lista.setId_socio(((ListasTmk)obj).getSocio().getId_socio());
		//lista.setId_sucursal_socio(((ListasTmk)obj).getSocio().getId_sucursal());
		//lista.setPublico(((ListasTmk)obj).getPublico());
		//lista.setTitulo(((ListasTmk)obj).getTitulo());
		
		DAOFactory.getDboDAO().update(lista);

	}


}
