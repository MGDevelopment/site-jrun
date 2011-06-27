package com.tmk.soa.servicios.implementation;

//import java.sql.Connection;

import com.tmk.bus.articulo.ListaDeseos;
//import com.tmk.controllers.MainHelper;
import com.tmk.src.listadeseos.ListaDeseosPK;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
//import com.tmk.soa.persistencia.ConnectionProvider;
import com.tmk.soa.servicios.interfaces.ListaDeDeseosService;

public class ListaDeDeseosServiceImpl implements ListaDeDeseosService {

	public void create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO,
			String TIPO_DOMICILIO, String NOMBRES, String APELLIDOS,
			Integer CUMPL_DIA, Integer CUMPL_MES, String PALABRAS_CLAVES,
			Integer PUBLICA) throws DuplicateException,Exception{

			DAOFactory.getListaDeDeseoDAO().create(ID_SUCURSAL_SOCIO, ID_SOCIO, TIPO_DOMICILIO, NOMBRES, APELLIDOS, CUMPL_DIA, CUMPL_MES, PALABRAS_CLAVES, PUBLICA);

	}	
	
	public ListaDeseos findByPrimaryKey(ListaDeseosPK listaPK)  throws DBOInexistenteException,Exception{		
	
		return DAOFactory.getListaDeDeseoDAO().findByPrimaryKey(listaPK); 
	
	}

	/*public boolean update(ListaDeseos lista) {

		boolean inserto  = false;
		try {
			inserto = DAOFactory.getListaDeDeseoDAO().update(lista);
		}catch (AplicationException e) {
			TmkLogger.error("ListaDeDeseosServiceImpl->update()->"+e.getMessage());
		} 		
		return inserto;
	}*/
}
