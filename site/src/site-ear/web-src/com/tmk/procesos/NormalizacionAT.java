package com.tmk.procesos;

import com.tmk.kernel.*;
import java.sql.*;

public class NormalizacionAT extends Daemon {

    //private static EjecucionDeQrys ejecucionDeQrys = new EjecucionDeQrys();
	
	
    public NormalizacionAT() {
    	super(Daemon.CINCO_SEGUNDOS , Daemon.UN_DIA*30);
        //super(Daemon.UN_MINUTO, Daemon.UN_DIA*30);
	}

    protected void ejecutarTarea() {
    	
        TmkLogger.debug("Inicio normalizacion");
        try{
            Connection conn = DBUtil.buildConnection();
            try{
            	/*String [] suprimir = {"LA", "DE", "DEL", "CON", "LO", "LOS", "EL", "EN", "ANTE", "POR", "ESTE", "ESTA", 
            			"ESTOS", "Y", "A", "BAJO", "CONTRA", "DESDE", "DURANTE", "ENTRE", "HACIA", "HASTA", "MEDIANTE",
            			"PARA", "SEGUN", "SIN", "SOBRE", "TRAS", ",", ";", "O", "UN", "LAS", "I", "TE", "UNA", "ESTAS", "COMO",
            			"TU", "TUS", "QUE", "AL", "ES", "HAY", "SUS", "MI", "ESO", "SE", "ETC", "SON", "CADA", "CUAL", "LE", "SI", "NO",
            			"SU", "HA", "TAL", "PERO", "MAS", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            			"Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            			"ELLO", "LES", "SINO", "ESTO", "UNAS", "ESTAN", "SEA", "USE", "OTRAS", "OF", "THE", "BY", "OR", "IN", "ON", "IS",
            			"ITS", "WAS", "IT", "TO", "AND", "YOU", "YOUR", "INTO", "YOULL", "ARE", "LIKE", "ELLA", "CUALES", "NOS",
            			"Nº", "HAN", "SER", "AT", "AINT", "GET", "ME", "USTED", "YA", "OTRA", "CASI", "DA", "AS", "TODO", "TODOS", "SOLO",
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
            	*/
                		Statement statement = conn.createStatement();
                		PreparedStatement ps = conn.prepareStatement("INSERT into articulos_articulos_textos " +
                				"(id_articulo, categoria_seccion, fecha_alta, titulo, precio_venta_vigente, orden," +
                				"pedido_especial, tipo, texto, parte, idioma) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                		try{
                			ResultSet resultSet = 
                				statement.executeQuery(
                						" SELECT DISTINCT a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo," +
                						" a.precio_venta_vigente, mvs.orden, d.pedido_especial, s.tipo," +
                						" s.parte, s.texto, s.idioma" +
                						" FROM disponibilidades d," +
                						" articulos a," +
                						" articulos_textos s," +
                						" mas_vendidos_seccion mvs" +
                						" WHERE d.id_disponibilidad = a.id_disponibilidad" +
                						" AND d.id_esquema = 'PROD'" +
                						" AND a.id_articulo = mvs.id_articulo(+)" +
                						" AND habilitado_tematika = 'S'" +
                						" AND s.id_articulo = a.id_articulo" +
                						" AND activo = 'SI' " +
                						" AND a.id_articulo >= 110132" +
                						" Order by a.id_articulo");
                			try {
                				
                				while (resultSet.next()){
                					ps.setInt(1, resultSet.getInt("id_articulo"));
                					ps.setInt(2, resultSet.getInt("categoria_seccion"));
                					ps.setTimestamp(3, resultSet.getTimestamp("fecha_alta"));
                					ps.setString(4, resultSet.getString("titulo"));
                					if (resultSet.getDouble("precio_venta_vigente") != 0) {
                						ps.setDouble(5, resultSet.getDouble("precio_venta_vigente"));
                					} else {
                						ps.setNull(5, Types.DOUBLE);
                					}
                					if (resultSet.getInt("orden") != 0) {
                						ps.setInt(6, resultSet.getInt("orden"));
                					} else {
                						ps.setNull(6, Types.NUMERIC);
                					}
                					
                					ps.setString(7, resultSet.getString("pedido_especial"));
                					ps.setString(8, resultSet.getString("tipo"));
               					    
                					ps.setString(9, resultSet.getString("texto"));
                					ps.setString(10, resultSet.getString("parte"));
                					ps.setString(11, resultSet.getString("idioma"));
                					
                					ps.execute();
                					TmkLogger.debug("Insertado " + resultSet.getInt("id_articulo"));
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
    	return "Normalizacion articulos_textos";
	}

	protected boolean pausada() {
        return (Globals.baseDeDatosEnMantenimiento());
	}
}