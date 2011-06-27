package com.tmk.soa.servicios.implementation;

import javax.servlet.http.HttpServletRequest;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.service.buscador.BuscadorHelper;
import com.tmk.service.buscador.BusquedaDeNovedades;
import com.tmk.service.buscador.BusquedaGenerica;
import com.tmk.service.buscador.BusquedaInicio;
import com.tmk.service.buscador.BusquedaParaRecomendar;
import com.tmk.service.buscador.BusquedaPorAutor;
import com.tmk.service.buscador.BusquedaPorCategorias;
import com.tmk.service.buscador.BusquedaPorEditorial;
import com.tmk.service.buscador.BusquedaPorIDdeAutor;
import com.tmk.service.buscador.BusquedaPorIDdeEditorial;
import com.tmk.service.buscador.BusquedaPorIDdeMarca;
import com.tmk.service.buscador.BusquedaPorIDdeProveedor;
import com.tmk.service.buscador.BusquedaPorIDs;
import com.tmk.service.buscador.BusquedaPorISBN;
import com.tmk.service.buscador.BusquedaPorMarca;
import com.tmk.service.buscador.BusquedaPorPalabrasClaves;
import com.tmk.service.buscador.BusquedaPorProveedor;
import com.tmk.service.buscador.BusquedaPorTemaMusical;
import com.tmk.service.buscador.BusquedaPorTitulo;
import com.tmk.service.buscador.BusquedaVacia;
import com.tmk.service.buscador.CriterioDAO;
import com.tmk.soa.bo.BuscadorBO;
import com.tmk.soa.servicios.interfaces.BuscadorService;

public class BuscadorServiceImp implements BuscadorService {

	/**
	 * Obtiene un buscador que no sea avanzado
	 */
	public BusquedaGenerica getBuscador(HttpServletRequest request,
			BuscadorBO buscadorBo) {
		BusquedaGenerica busqueda = null;
		if (buscadorBo.getClaveDeBusqueda() == null) {
			busqueda = new BusquedaInicio(buscadorBo.getTexto(), buscadorBo.getIdSeccion(),
					buscadorBo.getPaginaActual(), buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer(buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_TITULO.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorTitulo( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_AUTOR.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorAutor( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_PALABRAS_CLAVES.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorPalabrasClaves( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_ISBN.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorISBN( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_EDITORIAL.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorEditorial( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_PROVEEDOR.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorProveedor( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_TEMA_MUSICAL.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorTemaMusical( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_CATEGORIAS.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorCategorias( buscadorBo.getTexto(), buscadorBo.getIdSeccion(),  buscadorBo.getIdGrupo(),  buscadorBo.getIdFamilia(),  buscadorBo.getIdSubFamilia(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_IDS.equals( buscadorBo.getClaveDeBusqueda())) {
			String idArticulos = request.getParameter(BuscadorHelper.IDS_ARTICULOS);
			busqueda = new BusquedaPorIDs( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial(), idArticulos);
		} else if (BuscadorHelper.PARA_RECOMENDAR.equals( buscadorBo.getClaveDeBusqueda())) {
			Integer idSucursal = Convert.toNumber(request.getParameter(BuscadorHelper.ID_SUCURSAL), (Integer)null);
			Integer idSocio = Convert.toNumber(request.getParameter(BuscadorHelper.ID_SOCIO), (Integer)null);
			busqueda = new BusquedaParaRecomendar(buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial(), idSucursal, idSocio);
		} else if (BuscadorHelper.DE_NOVEDADES.equals( buscadorBo.getClaveDeBusqueda())) {
			Integer diasConsideradosNovedad  = Convert.toNumber(request.getParameter(BuscadorHelper.DIAS_CONSIDERADOS_NOVEDAD), (Integer)null);
			Integer diasIgnoradosNovedad = Convert.toNumber(request.getParameter(BuscadorHelper.DIAS_IGNORADOS_NOVEDAD), (Integer)null);
			busqueda = new BusquedaDeNovedades(buscadorBo.getIdSeccion(),  buscadorBo.getIdGrupo(),  buscadorBo.getIdFamilia(),  buscadorBo.getIdSubFamilia(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial(), diasConsideradosNovedad, diasIgnoradosNovedad);	
		} else if (BuscadorHelper.POR_IDdeEDITORIAL.equals( buscadorBo.getClaveDeBusqueda())) { //Para EMPRO evita los operadores de catsearch
			Integer idEditor = Convert.toNumber(request.getParameter(BuscadorHelper.ID_EDITOR), new Integer (0));
			busqueda = new BusquedaPorIDdeEditorial( buscadorBo.getTexto(), idEditor, buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),	 buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_IDdeAUTOR.equals( buscadorBo.getClaveDeBusqueda())) { //Para EMPRO y ARTICULO REDUCIDO evita los operadores de catsearch, mejora la busqueda
			Object idAutor = request.getParameter(BuscadorHelper.ID_AUTOR);
			busqueda = new BusquedaPorIDdeAutor ( buscadorBo.getTexto(), idAutor, buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_IDdePROVEEDOR.equals( buscadorBo.getClaveDeBusqueda())) { //Para EMPRO y ARTICULO REDUCIDO evita los operadores de catsearch, mejora la busqueda
			Integer idProveedor = Convert.toNumber(request.getParameter(BuscadorHelper.ID_PROVEEDOR), new Integer(0));
			busqueda = new BusquedaPorIDdeProveedor ( buscadorBo.getTexto(), idProveedor, buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_IDdeMARCA.equals( buscadorBo.getClaveDeBusqueda())) {
			Integer idMarca = Convert.toNumber(request.getParameter(BuscadorHelper.ID_MARCA), new Integer(0));
			busqueda = new BusquedaPorIDdeMarca ( buscadorBo.getTexto(), idMarca, buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} else if (BuscadorHelper.POR_MARCA.equals( buscadorBo.getClaveDeBusqueda())) {
			busqueda = new BusquedaPorMarca ( buscadorBo.getTexto(), buscadorBo.getIdSeccion(), buscadorBo.getPaginaActual(),  buscadorBo.getResultadosPorPagina(), new CriterioDAO(new Integer( buscadorBo.getCriterioDeOrden())), buscadorBo.isPedidoEspecial());
		} 				
		else {
			busqueda = new BusquedaVacia();
		}
		return busqueda;
	}

	public BusquedaGenerica getBuscadorAvanzado(HttpServletRequest request,
			BuscadorBO buscadorBo) {		
		
		return null;
	}

	public BuscadorBO getBuscadorBO(HttpServletRequest request) {
		BuscadorBO buscadorBo =  new BuscadorBO();
		String claveDeBusqueda = Convert.toString(request.getParameter(BuscadorHelper.CLAVE_DE_BUSQUEDA), null);
		String criterioDeOrden = Convert.toString(request.getParameter(BuscadorHelper.CRITERIO_ORDEN), BuscadorHelper.CRIT_MAS_VENDIDOS.getClave().toString());
		Integer resultadosPorPagina = Convert.toNumber(request.getParameter("resultadosPorPagina"), 10);
		boolean pedidoEspecial = Convert.toBoolean(request.getParameter(BuscadorHelper.PEDIDO_ESPECIAL), false);
		Integer idGrupo = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_GRUPO), (Integer)null);			
		Integer idFamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_FAMILIA), (Integer)null);			
		Integer idSubFamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SUBFAMILIA), (Integer)null);
		
		int paginaActual = 0;
		//Determino la pagina actual
		if(Convert.toNumber(request.getParameter("pagina"), -1) == -1) {
			if(Convert.toNumber(request.getParameter("registroInicial"), -1)==-1) {
				paginaActual = 1;
			} else {
				paginaActual = (new Integer(request.getParameter("registroInicial")).intValue() + 9) /10;
			}
		} else {
			paginaActual = Integer.parseInt(request.getParameter("pagina"));
		}
		
		Integer idSeccion = null; 
		if(request.getParameter("seccion") != null) {
			idSeccion = new Integer(request.getParameter("seccion"));
		}else {
			idSeccion  = Convert.toNumber(request.getParameter("idSeccion"),new Integer(Globals.SECCION_HOME));
		}
		
		buscadorBo = new BuscadorBO();
		buscadorBo.setCriterioDeOrden(criterioDeOrden);
		buscadorBo.setIdFamilia(idFamilia);
		buscadorBo.setIdGrupo(idGrupo);
		buscadorBo.setIdSubFamilia(idSubFamilia);
		buscadorBo.setPaginaActual(paginaActual);
		buscadorBo.setResultadosPorPagina(resultadosPorPagina);
		buscadorBo.setPedidoEspecial(pedidoEspecial);
		buscadorBo.setClaveDeBusqueda(claveDeBusqueda);
		buscadorBo.setIdSeccion(idSeccion);
		return buscadorBo;
	}

	
}
