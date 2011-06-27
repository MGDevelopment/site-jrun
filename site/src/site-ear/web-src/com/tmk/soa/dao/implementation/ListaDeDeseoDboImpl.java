package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.TreeSet;
import com.tmk.bus.articulo.ListaDeseos;
import com.tmk.bus.socio.Localidad;
import com.tmk.bus.socio.Pais;
import com.tmk.bus.socio.Provincia;
import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;
import com.tmk.kernel.DBUtil;
import com.tmk.src.listadeseos.ListaDeseosPK;
import com.tmk.soa.dao.interfaces.ListaDeDeseoDAO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.persistencia.ConnectionProvider;

public class ListaDeDeseoDboImpl implements ListaDeDeseoDAO {

	public ListaDeseos create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO,
			String TIPO_DOMICILIO, String NOMBRES, String APELLIDOS,
			Integer CUMPL_DIA, Integer CUMPL_MES, String PALABRAS_CLAVES,
			Integer PUBLICA) throws DuplicateException,Exception {
		
		ListaDeseosPK pk = new ListaDeseosPK(ID_SUCURSAL_SOCIO,ID_SOCIO);
		ListaDeseos lista = new ListaDeseos(pk);
		lista.setApellidos(APELLIDOS);
		lista.setNombres(NOMBRES);
		lista.setCumpl_dia(CUMPL_DIA);
		lista.setCumple_mes(CUMPL_MES);
		lista.setPalabras_claves(PALABRAS_CLAVES);
		lista.setPublica(PUBLICA);
		
		try{
			Connection conn = ConnectionProvider.getConection();
			try {				
				lista.insert(conn);	
			}finally {
				conn.close();
			}		
		}catch (DuplicateException de) {
			throw de;
		}catch (Exception e) {
			throw e;
		}
		return lista;
		/*try{
			Connection con = ConnectionProvider.getConection();
			try{				
				lista.insert(con);
			}catch(SQLException e){
				throw e;
			}finally {
				con.close();
			}			
		}catch (Exception e) {
			throw new AplicationException("ListaDeDeseoDboImpl->create()->pk="+pk.toString()+ e.getMessage());
		}
		return lista;*/
	}
	
	public ListaDeseos findByPrimaryKey(ListaDeseosPK listaPK)
			throws DBOInexistenteException,Exception {
		ComparadorPorDefecto comparador = new ComparadorPorDefecto();
		
		Collection<DBO> lista  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".id_sucursal_socio");
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".tipo_domicilio");
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".apellidos");
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".cumpl_dia");
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".cumpl_mes");
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".palabras_claves");
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias() + ".publica");
				//DOMICILIO DENTRO DE LA LISTA_DESEO
				camposABuscar.agregarCampoABusqueda(ListaDeseos.getAlias()+".domicilioDeseo");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias()+".id_sucursal");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias()+".id_socio");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias()+".tipo_domicilio");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".calle");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".cp");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".numero");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".edificio");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".piso");
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".depto");
						
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".pais");//DBO PAIS		
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".habilitado_tematika");
				
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".provincia");//DBO PROVINCIA
				camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_pais");
				camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_provincia");		
				camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".descripcion");
				
				camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".localidad");//DBO LOCALIDAD
				camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_pais");
				camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_provincia");
				camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_localidad");
				camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".descripcion");
				
				
				CamposLeftJoinDBO camposLestJoin = new CamposLeftJoinDBO();
				camposLestJoin.setCampoDBOLeftJoin(ListaDeseos.getAlias()+".domicilioDeseo");
				camposLestJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".pais");
				camposLestJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".provincia");
				camposLestJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".localidad");
				
				Condicion cndIdSocio = new Condicion(ListaDeseos.getAlias()+".id_sucursal_socio",
						Comparador.IGUAL,""+listaPK.ID_SUCURSAL_SOCIO);
				Condicion cndIdSucu = new Condicion(ListaDeseos.getAlias()+".id_socio",
						Comparador.IGUAL,""+listaPK.ID_SOCIO);
													
				WhereDBO where = new WhereDBO();
				where.add(cndIdSocio);
				where.add(Operador.AND,cndIdSucu);
								
				lista =  (TreeSet<DBO>)DBO.select2(ListaDeseos.class,conn,camposABuscar,camposLestJoin,where,null, comparador);				
			} finally {
				try{
					conn.close();
				}catch (SQLException e) {
					throw new Exception("ListaDeDeseoDboImpl->findByPrimaryKey()->No se pudo cerrar la conexion"+ e.getMessage());
				}				
			}
			return (ListaDeseos)lista.iterator().next();
		} catch (DBOInexistenteException e) {
			throw e;
		} catch (Exception e) {			
			throw new Exception("ListaDeDeseoDboImpl->findByPrimaryKey()"+e.getMessage());
			
		}
	}

}
