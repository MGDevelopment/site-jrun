package com.tmk.procesos;

import com.tmk.kernel.*;
import java.sql.*;

public class splitArticulosTexto extends Daemon {

    //private static EjecucionDeQrys ejecucionDeQrys = new EjecucionDeQrys();
	//private static long tiempoEspera = 900000;
	
    public splitArticulosTexto() {
    	super(Daemon.CINCO_SEGUNDOS , Daemon.UN_DIA*30);
        //super(Daemon.UN_MINUTO, Daemon.UN_DIA*30);
	}

    protected void ejecutarTarea() {
    	
        TmkLogger.debug("Inicio splitArticulos" +
        		"");
        try{
            Connection conn = DBUtil.buildConnection();
            try{
            	String [] suprimir = {"LA", "DE", "DEL", "CON", "LO", "LOS", "EL", "EN", "ANTE", "POR", "ESTE", "ESTA", 
            			"ESTOS", "Y", "A", "BAJO", "CONTRA", "DESDE", "DURANTE", "ENTRE", "HACIA", "HASTA", "MEDIANTE",
            			"PARA", "SEGUN", "SIN", "SOBRE", "TRAS", ",", ";", "O", "UN", "LAS", "I", "TE", "UNA", "ESTAS", "COMO",
            			"TU", "TUS", "QUE", "AL", "ES", "HAY", "SUS", "MI", "ESO", "SE", "ETC", "SON", "CADA", "CUAL", "LE", "SI", "NO",
            			"SU", "HA", "TAL", "PERO", "MAS", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            			"—", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            			"ELLO", "LES", "SINO", "ESTO", "UNAS", "ESTAN", "SEA", "USE", "OTRAS", "OF", "THE", "BY", "OR", "IN", "ON", "IS",
            			"ITS", "WAS", "IT", "TO", "AND", "YOU", "YOUR", "INTO", "YOULL", "ARE", "LIKE", "ELLA", "CUALES", "NOS",
            			"N∫", "HAN", "SER", "AT", "AINT", "GET", "ME", "USTED", "YA", "OTRA", "CASI", "DA", "AS", "TODO", "TODOS", "SOLO",
            			"CUANDO", "TAMBIEN", "ASI", "UNO", "DOS", "PUEDE", "GRAN", "DONDE", "TANTO", "TAN", "OTROS", "TIENE", "MUY", "MISMO",
            			"TRAVES", "FUE", "TODAS", "SIEMPRE", "HACE", "PARTE", "TODA", "MANERA", "QUIEN", "ESE", "TEMAS", "ADEMAS", "SIDO",
            			"NUESTRA", "NUESTRO", "OFRECE", "AHORA", "HACER", "TRES", "ELLOS", "ESA", "PORQUE", "DESPUES", "YO",
            			"PARTIR", "OTRO", "PUEDEN", "ALGUNOS", "NI", "ERA", "VA", "FOR", "ACERCA", "CUALQUIER", "ANTES", "AUN", "ALGO", "DEBE", "AUNQUE",
            			"AQUI", "MUCHOS", "EMBARGO", "POCO", "NUNCA", "MUCHO", "MUCHAS", "QUIENES", "MENOS", "MY", "THIS", "TIENEN", "AQUELLOS", "DENTRO", "PUES", "WHIT",
            			"TRATA", "MIENTRAS", "VECES", "SERA", "TIPO", "WITH", "CUATRO", "PERMITE", "PROPONE", "HABIA", "UNOS", "TI", "TENER", "ALGUNAS", "VER", "ENTONCES",
            			"MISMA", "JUNTO", "INCLUSO", "DECIR", "QUIERO", "ALLA", "LUEGO", "NOSOTROS", "DIVERSOS", "LADO",
            			"VAN", "ELLAS", "ESOS", "BE", "PARECE", "ESPECIALMENTE", "CREAR", "HACEN", "CARACTERISTICAS", "DESCUBRIR", "THAT", "EXPLICA", "FUERON", "DAR",
            			"BUSCA", "ALL", "FROM", "DIVERSAS", "ENCUENTRA", "CUYA", "PODRA", "XX", "DICE", "LLEVA", "VARIOS", "QUIERE", "DISTINTAS", "HE", "ALLI", "LLEGAR", "MISMOS", "ONE", "NUESTRAS", "DEMAS", "SABE",
            			"SIGUE", "SOY", "ENCONTRARA", "ESTAR", "PENSAR", "HABER", "DON", "RESULTA", "ALGUNA", "DESARROLLAR", "CUYO", "DESCRIBE",
            			"DESCUBRE", "REALIZAR", "SOY", "ENCONTRARA", "ESTAR", "PENSAR", "ALGUNA", "DESCRIBE", "PUBLICADO", "SEGUIR", "PONE", "ESAS",
            			"AQUEL", "LOGRAR", "TODAVIA", "CAPAZ", "ENTENDER", "BUEN", "DO", "ESCRIBIR", "DONT", "SIENDO", "DEBEN", "PODEMOS", "VUELVE", "AN", "CONVERTIDO",
            			"VE", "INTENTA", "MIS", "PERMITEN", "ABORDA", "MEJORAR", "DAN", "PONER", "UTILIZAR", "VOY", "DEJAR", "CONOCE", "ALCANZAR"};
            	
                		Statement statement = conn.createStatement();
                		PreparedStatement ps = conn.prepareStatement("INSERT into articulos_textos_x_palabra (id_articulo, texto, tipo) values (?, ?, ?)");
                		try{
                			ResultSet resultSet = statement.executeQuery("select att.id_articulo, att.texto " +
                							"  from articulos_textos att, articulos a where att.tipo = '01' and a.categoria_seccion in (1,3,4,5) and a.habilitado_tematika='S' and a.activo = 'SI' and a.id_articulo = att.id_articulo and a.id_articulo>= 107505" +
                							"  order by id_articulo, parte");
                			try {
                				
                				while (resultSet.next()){
                					String texto = resultSet.getString("texto").toUpperCase();
                					texto = texto.replaceAll("[‚„·‡‰a]".toUpperCase(), "A");
                					texto = texto.replaceAll("[ÈËÍÎe]".toUpperCase(), "E");
                					texto = texto.replaceAll("[ÌÏÓÔi]".toUpperCase(), "I");
                					texto = texto.replaceAll("[ÛÚÙıˆo]".toUpperCase(), "O");
                					texto = texto.replaceAll("[˙˘˚¸u]".toUpperCase(), "U");
                					texto = texto.replaceAll(", ", " ");
                					texto = texto.replaceAll(",", " ");
                					texto = texto.replaceAll("\r", " ");
                					texto = texto.replaceAll("\n", " ");
                					texto = texto.replaceAll("\\p{Punct}", "");
                					texto = texto.replaceAll("ø", "");
                					texto = texto.replaceAll(" - ", " ");
                					texto = texto.replaceAll("- ", " ");
                					texto = texto.replaceAll(" -", " ");
                					texto = texto.replaceAll("'", "");
                					texto = texto.replaceAll(" / ", " ");
                					texto = texto.replaceAll(" /", " ");
                					texto = texto.replaceAll("/ ", " ");
                					texto = texto.replaceAll("/", " ");
                					/*texto = texto.replaceAll(" \\ ", " ");
                					texto = texto.replaceAll(" \\", " ");
                					texto = texto.replaceAll("\\ ", " ");
                					texto = texto.replaceAll("\\", " ");*/
                					texto = texto.replaceAll("CONTENIDO", "");
                					//out.println(texto + "<p>");  
               					    String textos[] = texto.split(" ");
                					
               					    
               					    
               					    for (int i=0; i<suprimir.length; i++) {
                						for (int k=0; k<textos.length; k++) {
        									if (textos[k]!=null) {
        										textos[k] = textos[k].trim();
        			        					if (textos[k].equals(suprimir[i].trim())
        			        							|| textos[k].equals("")) {
        			        							textos[k] = null;
        			        					}
        									}	
                						}

                					}	
                					for (int j=0; j<textos.length; j++) {
                						if (textos[j] != null) {
        	        						try {
        	        							ps.setInt(1, resultSet.getInt("id_articulo"));
        		        						ps.setString(2, textos[j]);
        		        						ps.setString(3, "01");
        		        						ps.execute();
        		        					//	out.println(textos[j] + "<br>");	
        	        						} catch (Exception e){
        	        							TmkLogger.error("error en insert " + e.toString());
        	        						}
                						}	
                					//	ps.execute();
                					}
                				}
                			} catch (Exception e) {
        	                    TmkLogger.error(e.toString());
                			} finally {
                				resultSet.close();
        	                }
                			
                			
                        } catch (Exception e){
                            TmkLogger.error(e.toString());
                        } finally{
                            statement.close();
                        }
                   
            } catch (Exception e){
                TmkLogger.error(e.toString());
            } finally{
                conn.close();
            }
         
         } catch (Exception e) {
        	 TmkLogger.error(e.toString());
         }

    }

    protected String getMensaje() {
    	return "Ejecucion de Qrys";
	}

	protected boolean pausada() {
        return (Globals.baseDeDatosEnMantenimiento());
	}
}