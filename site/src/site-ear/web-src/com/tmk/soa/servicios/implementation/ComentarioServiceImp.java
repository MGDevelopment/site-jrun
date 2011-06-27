package com.tmk.soa.servicios.implementation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.servicios.interfaces.ComentarioService;

public class ComentarioServiceImp implements ComentarioService {

	public double getCalificacion(ComentarioArticulos[] comentarioArticulos) {
		if(comentarioArticulos == null)
			return 0;
		
		int canTotal = 0;
		int i;
		for(i = 0;i <  comentarioArticulos.length; i++ ) {
			canTotal += comentarioArticulos[i].getEvaluacion().intValue();
		}
		return (double)canTotal / i;	
	}

	public ComentarioArticulos getComentarioByPK(Integer idComentario,Integer idArticulo) {
		try {
			return DAOFactory.getComentarioArticuloDAO().findByPK(idComentario,idArticulo);
		}catch (AplicationException ae) {
			return null;
		}
	}
	
	public Collection<?> getIdsDeComentario(int cantidad) {
		try {
			return DAOFactory.getComentarioArticuloDAO().getIdsDeComentarios(cantidad);
		}catch(Exception e) {
			return null;
		}
	}

	public ComentarioArticulos getByIdComentario(Integer idComentario) {
		try {
			return DAOFactory.getComentarioArticuloDAO().getByIdComentario(idComentario);
		}catch (AplicationException ae) {
			return null;
		}
	}

	public Collection<?> getComentariosByIds(List ids) {
		try {
			return DAOFactory.getComentarioArticuloDAO().getComentariosByIds(ids);
		}catch(Exception e) {
			return new TreeSet();
		}
	}

	public Collection<?> getIdsDeComentario(HashMap<String, Object> pk,Integer cantidad) {
		try {
			return DAOFactory.getComentarioArticuloDAO().getIdsDeComentarios(pk,cantidad);
		}catch(Exception e) {
			return null;
		}
	}
	
	public Vector getEstrellasByCalificacion(double calificacion,HashMap<String, String> estrellas) {
		Hashtable<String, Object> hasEstrellas = null;		
		Vector<Hashtable<String, Object>> vecEstrellas = new Vector<Hashtable<String,Object>>(5);
		
		if (calificacion > 0) {
			for (int j = 0; j < (int) calificacion; j++) {
				// son estrellas llenas
				hasEstrellas = new  Hashtable<String, Object>(1,0.1f);
				hasEstrellas.put("estrellaClass", estrellas.get("estrellaLlena"));
				vecEstrellas.add(hasEstrellas);
			}
			double estrellasVacias = (calificacion > 0) ? 5 - calificacion : 0;// cuantas estrellas vacias y si hay media o no
			if ((calificacion - (int) calificacion) == 0.5) {
				// si hay media estrella
				hasEstrellas = new  Hashtable<String, Object>(1,0.1f);
				hasEstrellas.put("estrellaClass", estrellas.get("estrellaMedia"));
				vecEstrellas.add(hasEstrellas);
			}
			for (int c = 0; c < (int) estrellasVacias; c++) {
				// estrellas vacias
				hasEstrellas = new  Hashtable<String, Object>(1,0.1f);
				hasEstrellas.put("estrellaClass", estrellas.get("estrellaDes"));
				vecEstrellas.add(hasEstrellas);
			}			
		}
		return vecEstrellas;
	}
}
