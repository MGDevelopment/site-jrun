package com.tmk.soa.servicios.interfaces;

import com.tmk.bus.articulo.ListaDeseos;
import com.tmk.src.listadeseos.ListaDeseosPK;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;

public interface ListaDeDeseosService {

	public void create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, String TIPO_DOMICILIO, String NOMBRES, String APELLIDOS, Integer CUMPL_DIA, Integer CUMPL_MES, String PALABRAS_CLAVES, Integer PUBLICA) throws DuplicateException,Exception;

	//reutilizo la pk creada para los ejb.(esto lo puedo hacer)
	public ListaDeseos findByPrimaryKey(ListaDeseosPK listaPK) throws DBOInexistenteException,Exception;

	//public boolean update(ListaDeseos lista);
}
