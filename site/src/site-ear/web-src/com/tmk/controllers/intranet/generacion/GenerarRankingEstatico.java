package com.tmk.controllers.intranet.generacion;

import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.generacion.ContenidosEstaticos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;


public final class GenerarRankingEstatico extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String[] rankings = request.getParameter("rankingsAGenerar").split(";");

        HttpSession session = request.getSession();



        try{
    	    boolean huboError = false;
    	    boolean retorno = false;

    	    int seccion;

    	    String categoria="";

    	    String [] rankingAGenerar =  null;

            for (int i = 0; i < rankings.length; i++) {

            	int registroInicial=0;
        	    int registroFinal=0;

                rankingAGenerar = rankings[i].split(",");

                seccion=Convert.toNumber(rankingAGenerar[0],1);

                categoria=(rankingAGenerar[1].equals("-1"))?"":rankingAGenerar[1].toString();

                if(seccion == Globals.SECCION_LIBRO){

                	if("".equals(categoria)){
            			registroInicial=registroFinal + 1;
    	    			registroFinal=registroFinal + 10;

    	    			for(int j=0 ; j < 10 && !huboError ; j++){
                			retorno = ContenidosEstaticos.generarRankingEstatico(seccion, categoria, registroInicial, registroFinal);
                			registroInicial=registroFinal + 1;
    	    				registroFinal=registroFinal + 10;
	            			huboError = (huboError || !retorno);
	            		}

                	}else{
                		registroInicial= 1;
    	    			registroFinal= 10;

               			retorno = ContenidosEstaticos.generarRankingEstatico(seccion, categoria, registroInicial, registroFinal);
               			huboError = (huboError || !retorno);
                	}

            	}else{
		            	registroInicial=registroFinal + 1;
    	    			registroFinal=registroFinal + 10;

    	    			for(int j=0 ; j < 2 && !huboError ; j++){
                			retorno = ContenidosEstaticos.generarRankingEstatico(seccion, categoria, registroInicial, registroFinal);
                			registroInicial=registroFinal + 1;
    	    				registroFinal=registroFinal + 10;
	            			huboError = (huboError || !retorno);
	            		}
            	}
            }
            if (huboError) {
	            session.setAttribute("generacionError", "No se pudieron generar todos los ranking seleccionados.");
            } else {
	            session.setAttribute("generacionOK", "Se generaron exitosamente los ranking seleccionados.");
            }
        } catch(Exception e){
            session.setAttribute("generacionError", "No se pudieron generar todos los ranking seleccionados.");
        }
	    response.sendRedirect("/236-TMK/generacion/generacionRankings.jsp");
	    return;
    }

}
