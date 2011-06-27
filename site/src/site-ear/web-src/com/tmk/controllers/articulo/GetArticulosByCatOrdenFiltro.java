package com.tmk.controllers.articulo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.articulo.ArticuloManager;

public class GetArticulosByCatOrdenFiltro extends HttpServlet {
	static int itemsByCat[] = new int[]{0, 40, 0, 40, 60, 40};
	static int tamPag[] = new int[]{0, 4, 0, 4, 6, 4};

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("index");
        int idx = (index==null)? 0:new Integer(index).intValue()-1;
        String idCategoria = request.getParameter("idCategoria");
        String filtro = request.getParameter("filtro");
        String orden = request.getParameter("orden");
        //AGREGAR DATOS AL VECTOR
        //VER EL TAM DE AUX

        PrintWriter out = response.getWriter();
        Vector datos = new Vector();
        datos.add(null);
        datos.add(null);
        datos.add(null);
        datos.add(null);
        datos.add(null);
        datos.add(null);

        if (idCategoria == null || "".equals(idCategoria)) {
        	if (orden == null || "MV".equals(orden) ) {
        		if (filtro == null || "M".equals(filtro)) {
        			for (int j=0; j<itemsByCat.length; j++) {
                		if (itemsByCat[j]>0) {
        	        		int aux[] = new int[Math.min(itemsByCat[j],
        	        				(ArticuloManager.articulosMVM[j].length - (idx*tamPag[j]) >0)?
        	        						(ArticuloManager.articulosMVM[j].length - (idx*tamPag[j])):ArticuloManager.articulosMVM[j].length)];
        	    	        for (int i=0; i<aux.length; i++) {
        	    	            aux[i]=ArticuloManager.articulosMVM[j][i+(idx*tamPag[j])];
        	    	        }
        	    	        if (aux.length>0) {
        	    	        	datos.set(j, aux);
        	    	        }
                		}
                	}
        		}

        		if ("Y".equals(filtro)) {
        			for (int j=0; j<itemsByCat.length; j++) {
                		if (itemsByCat[j]>0) {
                			int aux[] = new int[Math.min(itemsByCat[j],
        	        				(ArticuloManager.articulosMVY[j].length - (idx*tamPag[j]) >0)?
        	        						(ArticuloManager.articulosMVY[j].length - (idx*tamPag[j])):ArticuloManager.articulosMVY[j].length)];

        	        		for (int i=0; i<aux.length; i++) {
        	    	            aux[i]=ArticuloManager.articulosMVY[j][i+(idx*tamPag[j])];
        	    	        }
        	        		 if (aux.length>0) {
         	    	        	datos.set(j, aux);
         	    	        }
                		}
                	}
        		}
        	} else {
        		if ("MVA".equals(orden)) {
	        		if (filtro == null || "M".equals(filtro)) {
	        			for (int j=0; j<itemsByCat.length; j++) {
	                		if (itemsByCat[j]>0) {
	                			int aux[] = new int[Math.min(itemsByCat[j],
	        	        				(ArticuloManager.articulosMVAM[j].length - (idx*tamPag[j]) >0)?
	        	        						(ArticuloManager.articulosMVAM[j].length - (idx*tamPag[j])):ArticuloManager.articulosMVAM[j].length)];

	        	        		for (int i=0; i<aux.length; i++) {
	        	    	            aux[i]=ArticuloManager.articulosMVAM[j][i+(idx*tamPag[j])];
	        	    	        }
	        	    	        if (aux.length>0) {
	        	    	        	datos.set(j, aux);
	        	    	        }
	                		}
	                	}
	        		}

	        		if ("Y".equals(filtro)) {
	        			for (int j=0; j<itemsByCat.length; j++) {
	                		if (itemsByCat[j]>0) {
	                			int aux[] = new int[Math.min(itemsByCat[j],
	        	        				(ArticuloManager.articulosMVAY[j].length - (idx*tamPag[j]) >0)?
	        	        						(ArticuloManager.articulosMVAY[j].length - (idx*tamPag[j])):ArticuloManager.articulosMVAY[j].length)];

	        	        		for (int i=0; i<aux.length; i++) {
	        	    	            aux[i]=ArticuloManager.articulosMVAY[j][i+(idx*tamPag[j])];
	        	    	        }
	        	    	        if (aux.length>0) {
	        	    	        	datos.set(j, aux);
	        	    	        }
	                		}
	                	}
	        		}

	        		if ("T".equals(filtro)) {
	        			for (int j=0; j<itemsByCat.length; j++) {
	                		if (itemsByCat[j]>0) {
	                			int aux[] = new int[Math.min(itemsByCat[j],
	        	        				(ArticuloManager.articulosMVA[j].length - (idx*tamPag[j]) >0)?
	        	        						(ArticuloManager.articulosMVA[j].length - (idx*tamPag[j])):ArticuloManager.articulosMVA[j].length)];

	        	        		for (int i=0; i<aux.length; i++) {
	        	    	            aux[i]=ArticuloManager.articulosMVA[j][i+(idx*tamPag[j])];
	        	    	        }
	        	    	        if (aux.length>0) {
	        	    	        	datos.set(j, aux);
	        	    	        }
	                		}
	                	}
	        		}
        		} else {
        			if ("MP".equals(orden)) {
    	        		if (filtro == null || "M".equals(filtro)) {
    	        			for (int j=0; j<itemsByCat.length; j++) {
    	                		if (itemsByCat[j]>0) {
    	                			int aux[] = new int[Math.min(itemsByCat[j],
    	        	        				(ArticuloManager.articulosMPM[j].length - (idx*tamPag[j]) >0)?
    	        	        						(ArticuloManager.articulosMPM[j].length - (idx*tamPag[j])):ArticuloManager.articulosMPM[j].length)];

    	        	        		for (int i=0; i<aux.length; i++) {
    	        	    	            aux[i]=ArticuloManager.articulosMPM[j][i+(idx*tamPag[j])];
    	        	    	        }
    	        	    	        if (aux.length>0) {
    	        	    	        	datos.set(j, aux);
    	        	    	        }
    	                		}
    	                	}
    	        		}

    	        		if ("Y".equals(filtro)) {
    	        			for (int j=0; j<itemsByCat.length; j++) {
    	                		if (itemsByCat[j]>0) {
    	                			int aux[] = new int[Math.min(itemsByCat[j],
    	        	        				(ArticuloManager.articulosMPY[j].length - (idx*tamPag[j]) >0)?
    	        	        						(ArticuloManager.articulosMPY[j].length - (idx*tamPag[j])):ArticuloManager.articulosMPY[j].length)];

    	        	        		for (int i=0; i<aux.length; i++) {
    	        	    	            aux[i]=ArticuloManager.articulosMPY[j][i+(idx*tamPag[j])];
    	        	    	        }
    	        	    	        if (aux.length>0) {
    	        	    	        	datos.set(j, aux);
    	        	    	        }
    	                		}
    	                	}
    	        		}

    	        		if ("T".equals(filtro)) {
    	        			for (int j=0; j<itemsByCat.length; j++) {
    	                		if (itemsByCat[j]>0) {
    	                			int aux[] = new int[Math.min(itemsByCat[j],
    	        	        				(ArticuloManager.articulosMP[j].length - (idx*tamPag[j]) >0)?
    	        	        						(ArticuloManager.articulosMP[j].length - (idx*tamPag[j])):ArticuloManager.articulosMP[j].length)];

    	        	        		for (int i=0; i<aux.length; i++) {
    	        	    	            aux[i]=ArticuloManager.articulosMP[j][i+(idx*tamPag[j])];
    	        	    	        }
    	        	    	        if (aux.length>0) {
    	        	    	        	datos.set(j, aux);
    	        	    	        }
    	                		}
    	                	}
    	        		}
            		}
        		}
        	}
        	//FALTA MAS POPULARES

        } else {
        	int idCat = new Integer(idCategoria).intValue();
        	if (orden == null || "MV".equals(orden) ) {
        		if (filtro == null || "M".equals(filtro)) {
        			int aux[] = new int[Math.min(itemsByCat[idCat],
	        				(ArticuloManager.articulosMVM[idCat].length - (idx*tamPag[idCat]) >0)?
	        						(ArticuloManager.articulosMVM[idCat].length - (idx*tamPag[idCat])):ArticuloManager.articulosMVM[idCat].length)];

        			for (int i=0; i<aux.length; i++) {
        				aux[i]=ArticuloManager.articulosMVM[idCat][i+(idx*tamPag[idCat])];
        			}
        			 if (aux.length>0) {
 	    	        	datos.set(idCat, aux);
 	    	        }
        		}
        		if ("Y".equals(filtro)) {
        			int aux[] = new int[Math.min(itemsByCat[idCat],
	        				(ArticuloManager.articulosMVY[idCat].length - (idx*tamPag[idCat]) >0)?
	        						(ArticuloManager.articulosMVY[idCat].length - (idx*tamPag[idCat])):ArticuloManager.articulosMVY[idCat].length)];


        			for (int i=0; i<aux.length; i++) {
        				aux[i]=ArticuloManager.articulosMVY[idCat][i+(idx*tamPag[idCat])];
        			}
        			 if (aux.length>0) {
 	    	        	datos.set(idCat, aux);
 	    	        }
        		}

        	} else {
        		if ("MVA".equals(orden)) {
	        		if (filtro == null || "M".equals(filtro)) {
	        			int aux[] = new int[Math.min(itemsByCat[idCat],
		        				(ArticuloManager.articulosMVAM[idCat].length - (idx*tamPag[idCat]) >0)?
		        						(ArticuloManager.articulosMVAM[idCat].length - (idx*tamPag[idCat])):ArticuloManager.articulosMVAM[idCat].length)];


	        			for (int i=0; i<aux.length; i++) {
	        				aux[i]=ArticuloManager.articulosMVAM[idCat][i+(idx*tamPag[idCat])];
	        			}
	        			 if (aux.length>0) {
	 	    	        	datos.set(idCat, aux);
	 	    	        }
	        		}
	        		if ("Y".equals(filtro)) {
	        			int aux[] = new int[Math.min(itemsByCat[idCat],
		        				(ArticuloManager.articulosMVAY[idCat].length - (idx*tamPag[idCat]) >0)?
		        						(ArticuloManager.articulosMVAY[idCat].length - (idx*tamPag[idCat])):ArticuloManager.articulosMVAY[idCat].length)];


	        			for (int i=0; i<aux.length; i++) {
	        				aux[i]=ArticuloManager.articulosMVAY[idCat][i+(idx*tamPag[idCat])];
	        			}
	        			 if (aux.length>0) {
	 	    	        	datos.set(idCat, aux);
	 	    	        }
	        		}
	        		if ("T".equals(filtro)) {
	        			int aux[] = new int[Math.min(itemsByCat[idCat],
		        				(ArticuloManager.articulosMVA[idCat].length - (idx*tamPag[idCat]) >0)?
		        						(ArticuloManager.articulosMVA[idCat].length - (idx*tamPag[idCat])):ArticuloManager.articulosMVA[idCat].length)];

	        			for (int i=0; i<aux.length; i++) {
	        				aux[i]=ArticuloManager.articulosMVA[idCat][i+(idx*tamPag[idCat])];
	        			}
	        			 if (aux.length>0) {
	 	    	        	datos.set(idCat, aux);
	 	    	        }
	        		}
        		} else {
        			if ("MP".equals(orden)) {
    	        		if (filtro == null || "M".equals(filtro)) {
    	        			int aux[] = new int[Math.min(itemsByCat[idCat],
    		        				(ArticuloManager.articulosMPM[idCat].length - (idx*tamPag[idCat]) >0)?
    		        						(ArticuloManager.articulosMPM[idCat].length - (idx*tamPag[idCat])):ArticuloManager.articulosMPM[idCat].length)];


    	        			for (int i=0; i<aux.length; i++) {
    	        				aux[i]=ArticuloManager.articulosMPM[idCat][i+(idx*tamPag[idCat])];
    	        			}
    	        			 if (aux.length>0) {
    	 	    	        	datos.set(idCat, aux);
    	 	    	        }
    	        		}
    	        		if ("Y".equals(filtro)) {
    	        			int aux[] = new int[Math.min(itemsByCat[idCat],
    		        				(ArticuloManager.articulosMPY[idCat].length - (idx*tamPag[idCat]) >0)?
    		        						(ArticuloManager.articulosMPY[idCat].length - (idx*tamPag[idCat])):ArticuloManager.articulosMPY[idCat].length)];


    	        			for (int i=0; i<aux.length; i++) {
    	        				aux[i]=ArticuloManager.articulosMPY[idCat][i+(idx*tamPag[idCat])];
    	        			}
    	        			 if (aux.length>0) {
    	 	    	        	datos.set(idCat, aux);
    	 	    	        }
    	        		}
    	        		if ("T".equals(filtro)) {
    	        			int aux[] = new int[Math.min(itemsByCat[idCat],
    		        				(ArticuloManager.articulosMP[idCat].length - (idx*tamPag[idCat]) >0)?
    		        						(ArticuloManager.articulosMP[idCat].length - (idx*tamPag[idCat])):ArticuloManager.articulosMP[idCat].length)];

    	        			for (int i=0; i<aux.length; i++) {
    	        				aux[i]=ArticuloManager.articulosMP[idCat][i+(idx*tamPag[idCat])];
    	        			}
    	        			if (aux.length>0) {
    	 	    	        	datos.set(idCat, aux);
    	 	    	        }
    	        		}
            		}
        		}
        	}
        }

        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.alias("dato", Vector.class);
        Pattern pt= Pattern.compile("(\\{)(\\\"[^\\\"]+\\\")([^:}]*)(\\})");
        Matcher mt= pt.matcher(xstream.toXML(datos));
        String correctJsonStr= mt.replaceAll("$2");
        out.print(correctJsonStr.replaceAll("\n", "").replaceAll("\r", ""));


    }
}
