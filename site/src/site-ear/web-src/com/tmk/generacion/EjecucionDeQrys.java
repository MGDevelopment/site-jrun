package com.tmk.generacion;

import com.tmk.kernel.*;
import java.sql.*;
import java.util.Calendar;


public class EjecucionDeQrys extends Daemon {

    //private static EjecucionDeQrys ejecucionDeQrys = new EjecucionDeQrys();
	private static long tiempoEspera = 900000;
	

    public EjecucionDeQrys() {
    	super(Daemon.CINCO_SEGUNDOS , Daemon.UN_DIA*30);
        //super(Daemon.UN_MINUTO, Daemon.UN_DIA*30);
	}

    protected void ejecutarTarea() {
    	String []qrys = new String[6]; 
    	
    	StringBuffer qry = new StringBuffer("");
    /*	qry = new StringBuffer("");
    	qry.append(" SELECT  a.id_articulo, a.categoria_seccion," );
    	qry.append("  a.fecha_alta, a.titulo,");
    	qry.append("  a.precio_venta_vigente");
    	qry.append(" FROM articulos a, disponibilidades d");
    	qry.append(" WHERE id_articulo in (");
    	qry.append(" SELECT distinct id_articulo");
    	qry.append(" FROM articulos_textos s");
    	qry.append(" WHERE ");
    	qry.append(" catsearch (s.texto, 'EJERCICIO*', '') > 0");
    	qry.append(" AND (s.tipo = '01'))");
    	qry.append(" AND d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.pedido_especial = 'N'");
    	qry.append(" AND a.categoria_seccion = 1");
    	qry.append(" AND a.habilitado_tematika = 'S'");
    	qry.append(" AND a.activo = 'SI' -- VARIANTE 1 (IN)");
    	    	
    	qrys[0] = qry.toString();*/
    	
    	qry = new StringBuffer("");
    	qry.append(" SELECT DISTINCT  a.id_articulo, a.categoria_seccion, ");
    	qry.append("  a.fecha_alta, a.titulo,");
    	qry.append(" a.precio_venta_vigente");
    	qry.append("  FROM disponibilidades d,");
    	qry.append("  articulos a,");
    	qry.append("  articulos_textos s");
    	qry.append(" WHERE d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.pedido_especial = 'N'");
    	qry.append(" AND a.categoria_seccion = 1");
    	qry.append(" AND habilitado_tematika = 'S'");
    	qry.append(" AND a.activo = 'SI'");
    	qry.append(" AND a.id_articulo = s.id_articulo");
    	qry.append(" AND catsearch (s.texto, 'libro*', '') > 0");
    	qry.append(" AND (s.tipo = '01')  -- ORIGINAL");
    	
    	qrys[0] = qry.toString();
    	
    	qry = new StringBuffer("");
    	qry.append(" SELECT DISTINCT  s.id_articulo ");
    	qry.append(" FROM");
    	qry.append(" 	articulos_textos s");
    	qry.append(" WHERE");
    	qry.append(" 	catsearch (s.texto, 'libro*', 'tipo=''01''') > 0");
    	
    	
    	qrys[1] = qry.toString();
    	
        	
     /*	qry = new StringBuffer("");
    	qry.append(" SELECT /* +Index(a arti2_pk )*/ /* DISTINCT  a.id_articulo, a.categoria_seccion, ");
    	qry.append("  a.fecha_alta, a.titulo,");
    	qry.append(" a.precio_venta_vigente");
    	qry.append("  FROM disponibilidades d,");
    	qry.append("  articulos a,");
    	qry.append("  articulos_textos s");
    	qry.append(" WHERE d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.pedido_especial = 'N'");
    	qry.append(" AND a.categoria_seccion = 1");
    	qry.append(" AND habilitado_tematika = 'S'");
    	qry.append(" AND a.activo = 'SI'");
    	qry.append(" AND a.id_articulo = s.id_articulo");
    	qry.append(" AND catsearch (s.texto, 'EJERCICIO*', '') > 0");
    	qry.append(" AND (s.tipo = '01') --VARIANTE 2 (HINT)");
    	
    	qrys[2] = qry.toString();*/
        	
    	
    /*	qry = new StringBuffer("");
    	qry.append(" SELECT DISTINCT a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo, ");
    	qry.append(" a.precio_venta_vigente");
    	qry.append(" FROM disponibilidades d, articulos a, articulos_textos_x_palabra s");
    	qry.append(" WHERE d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.pedido_especial = 'N'");
    	qry.append(" AND a.categoria_seccion = 1");
    	qry.append(" AND habilitado_tematika = 'S'");
    	qry.append(" AND a.activo = 'SI'");
    	qry.append(" AND a.id_articulo = s.id_articulo");
    	qry.append(" AND s.texto like 'EJERCICIO%'");
    	qry.append(" AND s.tipo = '01' -- VARIANTE 4 (diccionario de datos)");
    	
    	qrys[1] = qry.toString();*/
    	
    	/*
      	qry = new StringBuffer("");
    	qry.append(" SELECT /*+ use_merge(s a) INDEX(a arti2_pk) INDEX(d disp_idx)*//*  DISTINCT a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo, ");
    	qry.append(" a.precio_venta_vigente");
    	qry.append(" FROM disponibilidades d, articulos a, articulos_textos_x_palabra s");
    	qry.append(" WHERE d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.pedido_especial = 'N'");
    	qry.append(" AND a.categoria_seccion = 1");
    	qry.append(" AND habilitado_tematika = 'S'");
    	qry.append(" AND a.activo = 'SI'");
    	qry.append(" AND a.id_articulo = s.id_articulo");
    	qry.append(" AND s.texto like 'EJERCICIO%'");
    	qry.append(" AND s.tipo = '01' -- VARIANTE 5 (diccionario de datos HINT)");
    	
    	qrys[4] = qry.toString();*/
    	qry = new StringBuffer("");
    	qry.append(" select distinct aat.id_articulo,  aat.categoria_seccion,  aat.fecha_alta,  aat.titulo,");
    	qry.append(" aat.precio_venta_vigente");
    	qry.append(" from articulos_articulos_textos aat");
    	qry.append(" where catsearch (aat.texto, 'libro*', 'pedido_especial = ''N'' and categoria_seccion = 1 and  tipo = ''01''') > 0  -- VARIANTE 3 (TABLA DESNORMALIZADA CATSEARCH)");
    	
    	qrys[2] = qry.toString();
    	
    	/*qry = new StringBuffer("");
    	qry.append(" select distinct aat.id_articulo,  aat.categoria_seccion,  aat.fecha_alta,  aat.titulo,");
    	qry.append(" aat.precio_venta_vigente");
    	qry.append(" from articulos_articulos_textos aat");
    	qry.append(" where aat.pedido_especial = 'N'");
    	qry.append(" and aat.categoria_seccion = 1");
    	qry.append(" and aat.tipo = '01'");
    	qry.append(" and upper(aat.texto) like 'EJERCICIO%'  -- VARIANTE 6 (TABLA DESNORMALIZADA LIKE)");
    	
    	qrys[3] = qry.toString();*/
    	
    /*	qry = new StringBuffer("");
     	qry.append(" select distinct aat.id_articulo");
    	qry.append(" from articulos_articulos_textos aat");
    	qry.append(" where catsearch (aat.texto, 'ejercicio*', '') > 0  -- ");
    	
    	qrys[1] = qry.toString();
    	*/
    	
    	/*
    	StringBuffer qry = new StringBuffer("");
    	qry.append(" SELECT /*+ INDEX( aa borrame) *//*"); 
    	qry.append("       aa.id_articulo, a.categoria_seccion");
    	qry.append(" FROM articulos_autores aa, articulos a, disponibilidades d");
    	qry.append(" WHERE ");
    	qry.append(" (aa.role = 'A01' AND a.categoria_seccion in (1,3,4)");
    	qry.append(" 	 or ");
    	qry.append("	  aa.role in ('D02', 'E01') AND a.categoria_seccion = 5)");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND a.habilitado_tematika = 'S'");
    	qry.append(" AND aa.id_articulo = a.id_articulo");
    	qry.append(" AND id_autor IN (SELECT id_autor");
    	qry.append("                      FROM (SELECT id_autor, ROWNUM col");
    	qry.append("                              FROM autores");
    	qry.append("                             WHERE catsearch (descripcion, 'jose', NULL) > 0)");
    	qry.append("                     WHERE col <= 10)	");
    	qrys[0] = qry.toString();
    	
    	qry = new StringBuffer("");
    	
    	qry.append(" SELECT "); 
    	qry.append("       aa.id_articulo, a.categoria_seccion");
    	qry.append(" FROM articulos_autores aa, articulos a, disponibilidades d");
    	qry.append(" WHERE ");
    	qry.append(" (aa.role = 'A01' AND a.categoria_seccion in (1,3,4)");
    	qry.append(" 	 or ");
    	qry.append("	  aa.role in ('D02', 'E01') AND a.categoria_seccion = 5)");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND a.habilitado_tematika = 'S'");
    	qry.append(" AND aa.id_articulo = a.id_articulo");
    	qry.append(" AND id_autor IN (SELECT id_autor");
    	qry.append("                      FROM (SELECT id_autor, ROWNUM col");
    	qry.append("                              FROM autores");
    	qry.append("                             WHERE catsearch (descripcion, 'jose', NULL) > 0)");
    	qry.append("                     WHERE col <= 10)	");
    	qrys[1] = qry.toString();
    	
    	qry = new StringBuffer("");
    	
    	
    	qry.append("  SELECT a.id_articulo, a.categoria_seccion ");
        qry.append("  FROM disponibilidades d,  ");
        qry.append("         articulos a,  ");
        qry.append("       articulos_autores aa,  ");
        qry.append("       autores au  ");
        qry.append(" WHERE d.pedido_especial = 'N'  ");
        qry.append(" AND d.id_esquema = 'PROD'  ");
        qry.append(" AND d.id_disponibilidad = a.id_disponibilidad ");
        qry.append(" AND a.habilitado_tematika = 'S'  ");
        qry.append(" AND a.id_articulo = aa.id_articulo  ");
        qry.append(" AND aa.id_autor = au.id_autor  ");
        qry.append(" AND catsearch (au.descripcion, 'jose*', NULL) > 0 ");
        qry.append(" AND  "); 			 
        qry.append(" (   (a.categoria_seccion IN (1, 3, 4) AND aa.ROLE = 'A01')  ");
        qry.append(" OR (a.categoria_seccion = 5 AND aa.ROLE IN ('D02', 'E01'))  ");
        qry.append(" ) ");
    	
        qrys[2] = qry.toString();
    	
        qry = new StringBuffer("");
    	qry.append(" SELECT /*+ INDEX( aa borrame) *//*"); 
    	qry.append("       aa.id_articulo, a.categoria_seccion");
    	qry.append(" FROM articulos_autores aa, articulos a, disponibilidades d");
    	qry.append(" WHERE ");
    	qry.append(" (aa.role = 'A01' AND a.categoria_seccion in (1,3,4)");
    	qry.append(" 	 or ");
    	qry.append("	  aa.role in ('D02', 'E01') AND a.categoria_seccion = 5)");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND a.habilitado_tematika = 'S'");
    	qry.append(" AND aa.id_articulo = a.id_articulo");
    	qry.append(" AND id_autor IN (SELECT id_autor");
    	qry.append("                      FROM (SELECT id_autor, ROWNUM col");
    	qry.append("                              FROM autores");
    	qry.append("                             WHERE catsearch (descripcion, 'sabato', NULL) > 0)");
    	qry.append("                     WHERE col <= 10)	");
    	qrys[3] = qry.toString();
    	
    	qry = new StringBuffer("");
    	
    	qry.append(" SELECT "); 
    	qry.append("       aa.id_articulo, a.categoria_seccion");
    	qry.append(" FROM articulos_autores aa, articulos a, disponibilidades d");
    	qry.append(" WHERE ");
    	qry.append(" (aa.role = 'A01' AND a.categoria_seccion in (1,3,4)");
    	qry.append(" 	 or ");
    	qry.append("	  aa.role in ('D02', 'E01') AND a.categoria_seccion = 5)");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND a.habilitado_tematika = 'S'");
    	qry.append(" AND aa.id_articulo = a.id_articulo");
    	qry.append(" AND id_autor IN (SELECT id_autor");
    	qry.append("                      FROM (SELECT id_autor, ROWNUM col");
    	qry.append("                              FROM autores");
    	qry.append("                             WHERE catsearch (descripcion, 'sabato', NULL) > 0)");
    	qry.append("                     WHERE col <= 10)	");
    	qrys[4] = qry.toString();
    	
    	qry = new StringBuffer("");
    	
    	
    	qry.append("  SELECT a.id_articulo, a.categoria_seccion ");
        qry.append("  FROM disponibilidades d,  ");
        qry.append("         articulos a,  ");
        qry.append("       articulos_autores aa,  ");
        qry.append("       autores au  ");
        qry.append(" WHERE d.pedido_especial = 'N'  ");
        qry.append(" AND d.id_esquema = 'PROD'  ");
        qry.append(" AND d.id_disponibilidad = a.id_disponibilidad ");
        qry.append(" AND a.habilitado_tematika = 'S'  ");
        qry.append(" AND a.id_articulo = aa.id_articulo  ");
        qry.append(" AND aa.id_autor = au.id_autor  ");
        qry.append(" AND catsearch (au.descripcion, 'sabato*', NULL) > 0 ");
        qry.append(" AND  "); 			 
        qry.append(" (   (a.categoria_seccion IN (1, 3, 4) AND aa.ROLE = 'A01')  ");
        qry.append(" OR (a.categoria_seccion = 5 AND aa.ROLE IN ('D02', 'E01'))  ");
        qry.append(" ) ");
    	
        qrys[5] = qry.toString();*/
        
    	/*+ index(aa borrame)*/
    	/*
    	qry.append(" SELECT ").append(Globals.ENTER); 
    	qry.append(" a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo, ").append(Globals.ENTER);
        qry.append(" a.precio_venta_vigente").append(Globals.ENTER);
        qry.append(" FROM disponibilidades d, articulos a, articulos_autores aa, autores au").append(Globals.ENTER);
        qry.append(" WHERE d.pedido_especial = 'N'").append(Globals.ENTER);
        qry.append(" AND d.id_esquema = 'PROD'").append(Globals.ENTER);
        qry.append(" AND a.categoria_seccion = 1").append(Globals.ENTER);
        qry.append(" AND a.habilitado_tematika = 'S'").append(Globals.ENTER);
        qry.append(" AND d.id_disponibilidad = a.id_disponibilidad").append(Globals.ENTER);
        qry.append(" AND a.id_articulo = aa.id_articulo").append(Globals.ENTER);
        qry.append(" AND aa.id_autor = au.id_autor").append(Globals.ENTER);
        qry.append(" AND catsearch (au.descripcion, 'cortazar*', NULL) > 0").append(Globals.ENTER);
        qry.append(" AND aa.ROLE = 'A01'").append(Globals.ENTER);
        qrys[0] = qry.toString();*/
        
        /*+ use_nl(au aa) use_nl(aa a) use_nl (a d) index(a arti2_pk) */
        /*qry = new StringBuffer("");
        qry.append(" SELECT  ").append(Globals.ENTER);
    	qry.append(" a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo, ").append(Globals.ENTER);
        qry.append(" a.precio_venta_vigente");
        qry.append(" FROM disponibilidades d, articulos a, articulos_autores aa, autores au").append(Globals.ENTER);
        qry.append(" WHERE d.pedido_especial = 'N'").append(Globals.ENTER);
        qry.append(" AND d.id_esquema = 'PROD'").append(Globals.ENTER);
        qry.append(" AND a.categoria_seccion = 1").append(Globals.ENTER);
        qry.append(" AND a.habilitado_tematika = 'S'").append(Globals.ENTER);
        qry.append(" AND d.id_disponibilidad = a.id_disponibilidad").append(Globals.ENTER);
        qry.append(" AND a.id_articulo = aa.id_articulo").append(Globals.ENTER);
        qry.append(" AND aa.id_autor = au.id_autor").append(Globals.ENTER);
        qry.append(" AND catsearch (au.descripcion, 'chopra*', NULL) > 0").append(Globals.ENTER);
        qry.append(" AND aa.ROLE = 'A01'").append(Globals.ENTER);*/
        //qrys[1] = qry.toString();

    	/*+ index(aa borrame)*/
    	/*
        qry = new StringBuffer("");
        qry.append(" SELECT   au.descripcion ").append(Globals.ENTER);
        qry.append(" FROM articulos_autores aa, autores au ").append(Globals.ENTER);
        qry.append(" WHERE aa.id_autor = au.id_autor ").append(Globals.ENTER);
        qry.append(" AND catsearch (au.descripcion, 'borges*', NULL) > 0 ").append(Globals.ENTER);
        qry.append(" AND aa.ROLE = 'A01' ").append(Globals.ENTER);
        qrys[1] = qry.toString();
        */
    	
    	/*
        qry = new StringBuffer("");
        qry.append(" SELECT au.descripcion ").append(Globals.ENTER);
        qry.append(" FROM autores au").append(Globals.ENTER);
        qry.append(" WHERE catsearch (au.descripcion, 'borges*', NULL) > 0").append(Globals.ENTER);
        qrys[2] = qry.toString();
        */
    	/*
    	qry = new StringBuffer("");
    	qry.append(" SELECT DISTINCT a.id_articulo, a.categoria_seccion");
    	qry.append(" FROM disponibilidades d, articulos a, articulos_textos s");
    	qry.append(" WHERE d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.pedido_especial = 'N'");
    	qry.append(" AND a.categoria_seccion = 1");
    	qry.append(" AND habilitado_tematika = 'S'");
    	qry.append(" AND a.activo = 'SI'");
    	qry.append(" AND a.id_articulo = s.id_articulo");
    	qry.append(" AND catsearch (s.texto, 'historia*', '') > 0");
    	qry.append(" AND (s.tipo = '01')");
    	qrys[0] = qry.toString();
    	
    
    	qry = new StringBuffer("");
    	qry.append(" SELECT /*+ use_nl(s a) *//*");
    	qry.append(" DISTINCT a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo,");
    	qry.append(" a.precio_venta_vigente");
    	qry.append(" FROM disponibilidades d, articulos a, articulos_textos s");
    	qry.append(" WHERE d.id_disponibilidad = a.id_disponibilidad");
    	qry.append(" AND d.id_esquema = 'PROD'");
    	qry.append(" AND d.pedido_especial = 'N'");
    	qry.append(" AND a.categoria_seccion = 1");
    	qry.append(" AND habilitado_tematika = 'S'");
    	qry.append(" AND a.activo = 'SI'");
    	qry.append(" AND a.id_articulo = s.id_articulo");
    	qry.append(" AND catsearch (s.texto, 'historia*', '') > 0");
    	qry.append(" AND (s.tipo = '01')");
    	qrys[1] = qry.toString();
    	*/
        TmkLogger.debug("Inicio Ejecucion de Qrys");
         try{
            Connection conn = DBUtil.buildConnection();
            while (1==1){
           /* try{
            	//while (1==1){
	            	for (int i=0; i<1; i++) {
	            		PreparedStatement statement = conn.prepareStatement(qrys[i]);
	            		try{
	            			long tiempo = Calendar.getInstance().getTimeInMillis();
	            			ResultSet resultSet = statement.executeQuery();
	            			
	            			try {
	            				int w = 0;
	            				while (resultSet.next() && w<10){
	            					w++;	
	            				}
	            			} catch (Exception e) {
			                    TmkLogger.error("EJECUCION DE QRYS]  fech de resultados" + e.toString() + Globals.ENTER + qrys[i]);
	            			} finally {
	            				resultSet.close();
			                }
	            			tiempo = Calendar.getInstance().getTimeInMillis() - tiempo;
	            			TmkLogger.debug("Tiempo prepared" + tiempo);
	            			MailUtil.sendMail(
	            					Globals.MAIL_MAILER,
	            					Globals.MAIL_WEBMASTER,
	            					"Ejecucion de qrys",
	            					"Tiempo ps " + tiempo + Globals.ENTER + " qry: " + qrys[i]);
		                } catch (Exception e){
		                		MailUtil.sendMail(
	            					Globals.MAIL_MAILER,
	            					Globals.MAIL_WEBMASTER,
	            					"Ejecucion de qrys",
	            					"Error:" + e.toString() + Globals.ENTER + " qry: " + qrys[i]);
		                } finally{
		                    statement.close();
		                }
		                sleep(60000);
	            	}
	            	//sleep(tiempoEspera);
            	//}	
            } catch (Exception e){
                TmkLogger.error("EJECUCION DE QRYS] inicializacion de st " + e.toString());
            }
            */
            try{
            	//while (1==1){
	            	for (int i=0; i<3; i++) {
	            		Statement statement = conn.createStatement();
	            		try{
	            			long tiempo = Calendar.getInstance().getTimeInMillis();
	            			ResultSet resultSet = statement.executeQuery(qrys[i]);
	            			
	            			try {
	            				int w = 0;
	            				while (resultSet.next() && w<10){
	            					w++;	
	            				}
	            			} catch (Exception e) {
			                    TmkLogger.error("EJECUCION DE QRYS]  fech de resultados" + e.toString() + Globals.ENTER + qrys[i]);
	            			} finally {
	            				resultSet.close();
			                }
	            			tiempo = Calendar.getInstance().getTimeInMillis() - tiempo;
	            			TmkLogger.debug("Tiempo statement " + tiempo);
	            			MailUtil.sendMail(
	            					Globals.MAIL_MAILER,
	            					Globals.MAIL_WEBMASTER,
	            					"Ejecucion de qrys",
	            					"Tiempo s" + tiempo + Globals.ENTER + " qry: " + qrys[i]);
		                } catch (Exception e){
		                		MailUtil.sendMail(
	            					Globals.MAIL_MAILER,
	            					Globals.MAIL_WEBMASTER,
	            					"Ejecucion de qrys",
	            					"Error:" + e.toString() + Globals.ENTER + " qry: " + qrys[i]);
		                } finally{
		                    statement.close();
		                }
		                sleep(60000);
	            	}
	            	//sleep(tiempoEspera);
            	//}	
            } catch (Exception e){
                TmkLogger.error("EJECUCION DE QRYS] inicializacion de st " + e.toString());
            }
            
            finally{
                conn.close();
            }
         }
           
        } catch (Exception e) {
	        TmkLogger.error("EJECUCION DE QRYS] conexion " + e.toString());
        }
    }

    protected String getMensaje() {
    	return "Ejecucion de Qrys";
	}

	protected boolean pausada() {
        return (Globals.baseDeDatosEnMantenimiento());
	}
}