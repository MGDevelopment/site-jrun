package com.tmk.controllers.carrito;

import java.util.ArrayList;
import java.util.List;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Globals;
import com.tmk.orden.OrdenDAO;

public final class CarritoUtil {

	private static List<Integer> idsExcluidos = new ArrayList<Integer>();
		
	/**
	 * Cargo los ids que van a estar excluidos, es este caso la suscripcion quid
	 * se debe vender sola
	 */
	public static List<Integer> getAriculosExcluidos() {
		if(idsExcluidos.size()==0){			
			if(Globals.esModoRelease()){
				idsExcluidos.add(new Integer(505382));//395032
			}else{
				idsExcluidos.add(new Integer(395032));//395032
			}
		}
		return idsExcluidos;		
	}
	/***
	 * Determina si es posible en una orden agregar una suscripcion Quid
	 * @param ordenDAO
	 * @param idArticulo
	 * @param idsExcluidos
	 * @return
	 */
	public static boolean puedeAgregarSuscripcion(OrdenDAO ordenDAO, String idArticulo,List<Integer>idsExcluidos) {
		//si el id es la suscripcion
		if(idsExcluidos.get(0).equals(new Integer(idArticulo))){
			//y no hay articulos
			if(ordenDAO.getArticulos().size() == 0) {
				//se puede agregar
				return true;
			}else{
				//si no, no.
				return false;
			}
		}
		//si no es la suscripcion,pero ya esta en la orden
		for(int i=0;i<ordenDAO.getArticulos().size();i++) {
			//si ya esta agregada,error
			if(ordenDAO.getArticulos().get(i).equals(new Integer(idArticulo))){
				return false;
			}
		}
		return true;		
	}
	/**
	 * Determina si un articulo determinado se encuentra dentro del la orden
	 * @param ordenDAO
	 * @param idArticulo
	 * @return true/false
	 */
	public static boolean estaEnlaOrden(OrdenDAO ordenDAO, Integer idArticulo) {
		if(ordenDAO == null){
			return false;
		}
		for(int i=0;i<ordenDAO.getArticulos().size();i++) {
			int id = ((ArticuloDAO)ordenDAO.getArticulos().get(i)).getId();
			if(id == idArticulo.intValue()){
				return true;
			}
		}
		return false;
	}
	/**
	 * si es release les mando a
	<pre>
			logistica_rapida@ilhsa.com
			lcejas@ilhsa.com
			rmiranda@ilhsa.com
			dwinnik@ilhsa.com
			laguirre@ilhsa.com
	</pre>		
	 * @return String[], lista de mail.
	 */
	public static String[] getEmailParaAvisoDeSuscripcion(){
		if(Globals.esModoRelease()){
			return  new String[]{"logistica_rapida@ilhsa.com","lcejas@ilhsa.com","rmiranda@ilhsa.com","dwinnik@ilhsa.com","laguirre@ilhsa.com","CLOPEZ@ILHSA.COM"};
		}else{
			return new String[]{Globals.MAIL_WEBMASTER};
		}
	}
}
