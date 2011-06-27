package com.tmk.soa.dao.implementation;

//import java.lang.reflect.Field;
import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.LinkedList;
import com.tmk.dbo.DBO;
//import com.tmk.dbo.sql.RelacionCamposInsertDBO;
import com.tmk.kernel.DBUtil;
import com.tmk.soa.dao.interfaces.DboDAO;
//import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.persistencia.ConnectionProvider;

public class DboDaoImpl implements DboDAO {
	
	public void insert(DBO dbo)throws DuplicateException, Exception {
		try {
			 Connection conn = DBUtil.buildConnection();
			 try {
				 dbo.insert(conn);
			 } finally {
				 conn.close();
			 }
		}catch(DuplicateException de) {
			throw de;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void update(DBO dbo) throws DBOInexistenteException, Exception {
		Connection con = ConnectionProvider.getConection();
		try {
			dbo.update(con);			
		}finally {
			con.close();
		}			
	}
	
	public void delete(DBO dbo) throws Exception {		
		 Connection conn = DBUtil.buildConnection();
		 try {
			 dbo.delete(conn);
		 } finally {
			 conn.close();
		 }
	}
	
	/*private LinkedList<PreparedStatement> getInsertDBO(Connection con,LinkedList<PreparedStatement>listaDePrepared,Object dbo,HashSet<String>objetosAGrabar) throws Exception {
		DBO bo = (DBO)dbo;
		ArrayList<Object> camposDBO = new ArrayList<Object>();
		ArrayList<Object> camposArray = new ArrayList<Object>();
		
		StringBuffer qry = new StringBuffer("INSERT INTO ");
		qry.append(bo.getClass().getMethod("getTabla").invoke(bo)).append("(");
		StringBuffer values = new StringBuffer(" values (");
		Field[] campos = bo.getClass().getDeclaredFields();
		int[] indices = new int [campos.length];
		int camposAgregados = 0;
		for(int i=0;i<indices.length;i++)indices[i]=-1;
			
		for(int i=0;i<campos.length;i++) {
			Field campo = campos[i];
			campo.setAccessible(true);
			if(campo.getName().startsWith("cls_"))continue;
			boolean esArray = false;
			Class clase = null;
			if(campo.getType().isArray()) {
				 clase = campo.getType().getComponentType();
				 esArray = true;
			}else{
				clase = campo.getType();
			}
			boolean esDBO = DBO.esDBO(clase);
			esArray = (esArray && esDBO);
			if(campo.get(bo)!=null){
				if(!esDBO && !esArray ) {
					//si el campo tenia el mismo problema que en el select. (mas de 30 caracteres)
					if(RelacionCamposInsertDBO.getInstance().getCamposCambiados().containsKey(campo.getName())) {
						qry.append(RelacionCamposInsertDBO.getInstance().getCamposCambiados().get(campo.getName())).append(", ");
					}else{
						qry.append(campo.getName()).append(", ");
					}
					values.append("?, ");
					//values.append(campo.get(bo)).append(", ");
					indices[camposAgregados++] = i;
				}else {
					if(objetosAGrabar.contains(clase.getSimpleName())){
						if(esDBO && !esArray){
							camposDBO.add(campo.get(bo));													
						}else {
							camposArray.add(campo.get(bo));
						}
						String[] pkDboIncluido = RelacionCamposInsertDBO.getInstance().getCamosInsert(bo.getClass().getSimpleName()+"-"+clase.getSimpleName());
						for(int j=0;pkDboIncluido !=null && j<pkDboIncluido.length;j++){
							qry.append(pkDboIncluido[j]).append(", ");
							values.append("?, ");
						}
						indices[camposAgregados++] = i;
					}
				}
			}
		}
		qry = new StringBuffer(qry.substring(0,qry.length()-2));
		values= new StringBuffer(values.substring(0,values.length()-2));
		qry.append(")");
		values.append(")");
		qry.append(" ").append(values).toString();
		//Connection con = ConnectionProvider.getConection(); 
		PreparedStatement ps = con.prepareStatement(qry.toString());
		int indice = 0;
		for(int i=0;i<camposAgregados;i++) {
			//como cargue los indices en el array de los campos que se agregan los obtngo de ahi directamente
			Field campo = campos[indices[i]];
			campo.setAccessible(true);
			Class clase = null;
			if(campo.getType().isArray()) {
				clase = campo.getType().getComponentType();
			}else{
				clase = campo.getType();
			}
			if(DBO.esDBO(clase)) {
				//busco el valor de los campos del dbo hijo para agregarlos al prepared statemen
				Field[] fiels = clase.getDeclaredFields();
				String[] camposRelacionados = RelacionCamposInsertDBO.getInstance().getCamosInsert(bo.getClass().getSimpleName()+"-"+clase.getSimpleName());
				for(int k=0;camposRelacionados!=null && k<camposRelacionados.length;k++){
					for(int j=0;j<fiels.length;j++){
						Field fiel = fiels[j];
						fiel.setAccessible(true);
						if(camposRelacionados[k].equals(fiel.getName())){
							ps.setObject(++indice,fiel.get(campo.get(bo)));
							//System.out.print (fiel.getName()+ "-");
							//System.out.println(fiel.get(campo.get(bo)));
							break;
						}
					}
				}
			}else{
				ps.setObject(++indice,campo.get(bo));
				//System.out.print(campo.getName() + "-") ;
				//System.out.println(campo.get(bo));
			}
		}
		System.err.println(qry);
		listaDePrepared.add(ps);
		
		//campos DBO que dependen de este DBO
		for(int i=0;i<camposDBO.size();i++) {
			DBO dboHijo = (DBO)camposDBO.get(i); 
			insert(dboHijo,objetosAGrabar);
		}
		//campos arrays dentro del DBO
		for(int i=0;i<camposArray.size();i++){
			DBO[] dbos =  (DBO[])camposArray.get(i);
			for(int j=0;j<dbos.length;j++) {
				insert(dbos[j],objetosAGrabar);
			}
		}
		return listaDePrepared;
	}*/
	 
	/*public void insert(Object dbo,HashSet<String>objetosAGrabar) {
	try {
		Connection con = ConnectionProvider.getConection();
		con.setAutoCommit(false);
		LinkedList<PreparedStatement> ps = getInsertDBO(con,new LinkedList<PreparedStatement>(),dbo,objetosAGrabar);
		try {
			for(int i=0;i<ps.size();i++){
				ps.get(i).execute();
				ps.get(i).close();
				ps.remove(i);
			}
		}catch (Exception e) {
			con.rollback();
			throw e;
			
		}finally{
			//con.rollback();
			con.commit();
		}
	}catch (Exception e) {
		AplicationException ae = new AplicationException(e);
		ae.setMsjError("No se pudo insertar el dbo pk="+((DBO)dbo).getPK());
	}
	}*/

}
