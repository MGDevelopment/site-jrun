package com.tmk.dbo;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Vector;
import com.tmk.controllers.MainHelper;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.dbo.sql.OrderBYDBO;
import com.tmk.dbo.sql.RelacionCamposInsertDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
//import com.tmk.soa.persistencia.ConnectionProvider;
import com.tmk.soa.servicios.interfaces.DboService;
import com.tmk.util.ByteArrayWarpper;

public abstract class DBO {
	
	protected boolean seteado = false;
			
	public DBO() {
	}
			
	public String toString() {
		StringBuffer str = new StringBuffer("");
		str.append(this.getClass().getName()).append("<br>");
		for (int j=0; j<this.getClass().getDeclaredFields().length; j++) {
			Field field = this.getClass().getDeclaredFields()[j];
			field.setAccessible(true);
			if(field.getName().startsWith("cls_")) continue;
			try {
				if (field.getType().isArray()) {
					str.append(field.getName()).append("<br>");
					DBO[] dbo =(DBO[])field.get(this);
					for (int i=0; i<dbo.length; i++) {
						str.append(dbo[i].toString()).append("<br>");
					}
				} else {
					str.append(field.getName()).append(" = ").append(field.get(this)).append("<br>");
				}
			} catch (Exception e) {

			}
		}
		return str.toString();
	}

	public void select(Connection conn)  throws DBOInexistenteException, Exception {
		try {
			PreparedStatement ps = getSelectToDBByObject(this, conn);
			try {
				ResultSet rs = ps.executeQuery();
				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					//Asegura un solo registro. Aunque el select siempre deberia ser por PK
					if (rs.next()) {
						for(int i=1; i <=rsmd.getColumnCount(); i++) {
							for (int j=0; j<this.getClass().getDeclaredFields().length; j++) {
								Field field = this.getClass().getDeclaredFields()[j];
								field.setAccessible(true);
								setField(field, rsmd.getColumnName(i), rsmd.getColumnClassName(i), rs);								
							}
						}
					} else {
						//throw new Exception ("No se encuentra el DBO " + this.getClass().getMethod("getTabla", null).invoke(null, null) + " PK " + this.getPK());
						throw new DBOInexistenteException("No se encuentra el DBO " + this.getClass().getMethod("getTabla",(Class[]) null).invoke((Object)null, (Object[])null) + " PK " + this.getPK());
					}
				} finally {
					rs.close();
				}
			} finally {
				ps.close();
			}
		} catch (DBOInexistenteException e) {
			throw e;
		} catch (Exception e) {
			throw new Exception (this.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}
	}
	
	public void select(Connection conn, String[] param)  throws DBOInexistenteException, Exception {
		try {
			PreparedStatement ps = getSelectByParamToDBByObject(this, conn, param);
			try {
				ResultSet rs = ps.executeQuery();
				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					//Pueden ser varios registros pero se queda con el primero
					if (rs.next()) {
						for(int i=1; i <=rsmd.getColumnCount(); i++) {
							for (int j=0; j<this.getClass().getDeclaredFields().length; j++) {
								Field field = this.getClass().getDeclaredFields()[j];
								field.setAccessible(true);
								boolean esDBO = esDBO(field.getType());
								boolean esArray = field.getType().isArray() & esDBO;
								if(!esArray && !esDBO){
									setField(field, rsmd.getColumnName(i), rsmd.getColumnClassName(i), rs);
								}
							}
						}
					} else {
						StringBuffer str = new StringBuffer("");
						for (int i=0; i<param.length; i++) {
							str.append(param[i]).append(" ");
						}
						//throw new Exception ("No se encuentra el DBO " + this.getClass().getMethod("getTabla", null).invoke(null, null) + " PARAMETRO " + str.toString());
						throw new DBOInexistenteException ("No se encuentra el DBO " + this.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null) + " PARAMETRO " + str.toString());
					}
				} finally {
					rs.close();
				}
			} finally {
				ps.close();
			}
		} catch (DBOInexistenteException e) {
			throw e;
		} catch (Exception e) {
			throw new Exception (this.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}
	}
	
	public void insert(Connection conn) throws DuplicateException,Exception {
		try {
			PreparedStatement ps = getInsertToDBByObject(this, conn);
			try {
				ps.execute();
			} catch (SQLException se) {
				if(se.getErrorCode() == DboService.DUPLICATE_CODE){
					throw new DuplicateException(se.getMessage());
				}else {
					throw new Exception (this.toString() + " " + se.toString() + MainHelper.getMessage(se));
				}
			}
			finally {
				ps.close();
			}
		}catch (DuplicateException de) {
			throw de;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void update(Connection conn) throws  DBOInexistenteException, Exception {
		try {
			PreparedStatement ps = getUpdateToDBByObject(this, conn);
			try {
				ps.execute();
				if (ps.getUpdateCount() < 1) {
					//throw new Exception("No se pudo updatear " + this.getClass().getMethod("getTabla", null).invoke(null, null) + " PK " + this.getPK());
					throw new DBOInexistenteException("No se pudo updatear " + this.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null) + " PK " + this.getPK());
				}
			} finally {
				ps.close();
			}
		} catch (DBOInexistenteException se) {
			throw se;
		} catch (Exception e) {
			throw new Exception (this.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}
	}
	
	public void delete(Connection conn) throws Exception {
		try {
			StringBuffer qry = new StringBuffer("");
			String alias = (String)this.getClass().getMethod("getAlias", (Class[])null).invoke(this, (Object[])null);
			qry.append("DELETE FROM " ).append(this.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null)).append(" ").append(alias).append( " WHERE ").append(this.getPK());
			PreparedStatement ps = conn.prepareStatement(qry.toString());
			try {
				ps.execute();
			} finally {
				ps.close();
			}
		} catch (Exception e) {
			throw new Exception (this.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}
	}
	
	private void setField(Field field, String columnName, String columnClassName, ResultSet rs) throws Exception {
		if (field.getName().toLowerCase().equals(columnName.toLowerCase())) {
			if (field.getName().toLowerCase().equals(columnName.toLowerCase())) {
				if (columnClassName.equals("byte[]")) {
					field.set(this, rs.getBytes(columnName));
				} else if (columnClassName.endsWith("Integer")) {
					field.set(this, new Integer(rs.getInt(columnName)));
				/*} else if (columnClassName.endsWith("BigDecimal")) {
					field.set(this, new Integer(rs.getInt(columnName)));
				} */
				}else if (columnClassName.endsWith("BigDecimal")) {
					try {
						field.set(this, new Integer(rs.getInt(columnName)));
					} catch (Exception e) {
						try {
							try{
								field.set(this, new Double(rs.getDouble(columnName)));
							}catch (IllegalArgumentException e2) {
								field.set(this, new Long(rs.getLong(columnName)));
							}
						}catch (Exception e3) {
							field.set(this, new Long(rs.getLong(columnName)));
						}
					}
				}
				else if (columnClassName.endsWith("String")) {
					field.set(this, rs.getString(columnName));
				} else if (columnClassName.endsWith("Timestamp")) {
					field.set(this, rs.getTimestamp(columnName));
				} else if (columnClassName.endsWith("Time")) {
					field.set(this, rs.getTime(columnName));
				} else if (columnClassName.endsWith("Short")) {
					field.set(this, new Short(rs.getShort(columnName)));
				} else if (columnClassName.endsWith("Long")) {
					field.set(this, new Long(rs.getLong(columnName)));
				} else if (columnClassName.endsWith("Float")) {
					field.set(this, new Float(rs.getFloat(columnName)));
				} else if (columnClassName.endsWith("Double")) {
					field.set(this, new Double(rs.getDouble(columnName)));
				} else if (columnClassName.endsWith("Date")) {
					field.set(this, rs.getDate(columnName));
				} else if (columnClassName.endsWith("Boolean")) {
					field.set(this, new Boolean(rs.getBoolean(columnName)));
				} else {
					TmkLogger.debug(columnClassName);
					TmkLogger.debug(columnName);
					field.set(this, rs.getObject(columnName));
				}
			}
		}
	}

	private static void setField(Object obj, Field field, String columnName, String columnClassName, ResultSet rs) throws Exception {
			if (field.getName().toLowerCase().equals(columnName.toLowerCase())) {
				if (columnClassName.equals("byte[]")) {
					field.set(obj, rs.getBytes(columnName));
				} else if (columnClassName.endsWith("Integer")) {
					field.set(obj, new Integer(rs.getInt(columnName)));
				} else if (columnClassName.endsWith("BigDecimal")) {
					field.set(obj, new Integer(rs.getInt(columnName)));
				} else if (columnClassName.endsWith("String")) {
					field.set(obj, rs.getString(columnName));
				} else if (columnClassName.endsWith("Timestamp")) {
					field.set(obj, rs.getTimestamp(columnName));
				} else if (columnClassName.endsWith("Time")) {
					field.set(obj, rs.getTime(columnName));
				} else if (columnClassName.endsWith("Short")) {
					field.set(obj, new Short(rs.getShort(columnName)));
				} else if (columnClassName.endsWith("Long")) {
					field.set(obj, new Long(rs.getLong(columnName)));
				} else if (columnClassName.endsWith("Float")) {
					field.set(obj, new Float(rs.getFloat(columnName)));
				} else if (columnClassName.endsWith("Double")) {
					field.set(obj, new Double(rs.getDouble(columnName)));
				} else if (columnClassName.endsWith("Date")) {
					field.set(obj, rs.getDate(columnName));
				} else if (columnClassName.endsWith("Boolean")) {
					field.set(obj, new Boolean(rs.getBoolean(columnName)));
				} else {
					TmkLogger.debug(columnClassName);
					TmkLogger.debug(columnName);
					field.set(obj, rs.getObject(columnName));
				}
			}
	}

	//Deberia ser el definitivo
	private static void setField(Object obj, Field field, String columnName, ResultSet rs,  String columnLabel) throws Exception {
		int columnIndex = rs.findColumn(columnLabel);
		String columnClassName = rs.getMetaData().getColumnClassName(columnIndex);

		if (field.getName().toLowerCase().equals(columnName.toLowerCase())) {
			if (columnClassName.equals("byte[]")) {				
				field.set(obj,new ByteArrayWarpper(rs.getBytes(columnIndex)));
			} else if (columnClassName.endsWith("Integer")) {
				field.set(obj, new Integer(rs.getInt(columnIndex)));
			} else if (columnClassName.endsWith("BigDecimal")) {
				try {
					field.set(obj, new Integer(rs.getInt(columnIndex)));
				} catch (Exception e) {
					try {
						try{
							field.set(obj, new Double(rs.getDouble(columnIndex)));
						}catch (IllegalArgumentException e2) {
							field.set(obj, new Long(rs.getLong(columnIndex)));
						}
					}catch (Exception e3) {
						field.set(obj, new Long(rs.getLong(columnIndex)));
					}
				}
			} else if (columnClassName.endsWith("String")) {
				field.set(obj, rs.getString(columnIndex));
			} else if (columnClassName.endsWith("Timestamp")) {
				field.set(obj, rs.getTimestamp(columnIndex));
			} else if (columnClassName.endsWith("Time")) {
				field.set(obj, rs.getTime(columnIndex));
			} else if (columnClassName.endsWith("Short")) {
				field.set(obj, new Short(rs.getShort(columnIndex)));
			} else if (columnClassName.endsWith("Long")) {
				field.set(obj, new Long(rs.getLong(columnIndex)));
			} else if (columnClassName.endsWith("Float")) {
				field.set(obj, new Float(rs.getFloat(columnIndex)));
			} else if (columnClassName.endsWith("Double")) {
				field.set(obj, new Double(rs.getDouble(columnIndex)));
			} else if (columnClassName.endsWith("Date")) {
				field.set(obj, rs.getDate(columnIndex));
			} else if (columnClassName.endsWith("Boolean")) {
				field.set(obj, new Boolean(rs.getBoolean(columnIndex)));
			} else {
				TmkLogger.debug(columnClassName);
				TmkLogger.debug(columnName);
				field.set(obj, rs.getObject(columnIndex));
			}
		}
}

	public static Vector getALL(Connection conn, Class c, String[] param, String orden, Integer cantidad) throws Exception {
		Vector<Object> aux = new Vector<Object>();
		try {
			PreparedStatement ps = getSelectToDBByObjectALL((DBO)c.newInstance(), conn, param, orden, cantidad);
			try {
				ResultSet rs = ps.executeQuery();
				try {
					ResultSetMetaData rsmd = rs.getMetaData();

					while (rs.next()) {
						Object o = c.newInstance();
						for(int i=1; i <=rsmd.getColumnCount(); i++) {
							for (int j=0; j<o.getClass().getDeclaredFields().length; j++) {
								Field field = o.getClass().getDeclaredFields()[j];
								field.setAccessible(true);
								setField(o, field, rsmd.getColumnName(i), rsmd.getColumnClassName(i), rs);
							}
						}
						aux.add(o);
					}
				} finally {
					rs.close();
				}
			} finally {
				ps.close();
			}
		} catch (Exception e) {
			throw new Exception (c.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}
		return aux;
	}

	public static DBO setDBOs(DBO dbo, ResultSet rs, LinkedHashSet cols, CamposABuscarDBO camposABuscar,Boolean esPrimerRegistro) throws Exception {
		String alias = ((String)dbo.getClass().getMethod("getAlias", (Class[])null).invoke(dbo, (Object[])null)).toLowerCase();
		for (int j=0; j<dbo.getClass().getDeclaredFields().length; j++) {
			Field field = dbo.getClass().getDeclaredFields()[j];
			field.setAccessible(true);
			Class clase;
			if (field.getType().isArray()) {
				clase = field.getType().getComponentType();
			} else {
				clase = field.getType();
			}
			if (esDBO(clase)) {
				if (camposABuscar.incluirEnBusqueda(alias + "." +  field.getName())) {
					if (field.getType().isArray()) {
						if (rs.isFirst() || (esPrimerRegistro != null && esPrimerRegistro) ) {							
							DBO dboHijo = (DBO)field.getType().getComponentType().newInstance();
							dboHijo = setObjeto(dboHijo, rs, cols);
							if (dboHijo != null) {
								DBO [] dboHijoList = null;
								if (dboHijo.tieneDBO()) {
									dboHijo = setDBOs(dboHijo, rs, cols, camposABuscar,esPrimerRegistro);
								}
								dboHijoList = DBO.addItems(dboHijoList, dboHijo);
								field.set(dbo, dboHijoList);
							}
						} else {
							DBO dboHijoList[] = (DBO[])field.get(dbo);
							if (dboHijoList != null) {
								DBO dboHijo = (DBO)field.getType().getComponentType().newInstance();
								dboHijo = setObjeto(dboHijo, rs, cols);
										boolean encontrado = false;
										for (int k=0; k<dboHijoList.length; k++) {
											if (dboHijo.equals(dboHijoList[k])) {
												dboHijo = dboHijoList[k];
												encontrado = true;
												break;
											}
										}
										if (!encontrado) {
											dboHijoList = DBO.addItems(dboHijoList, dboHijo);
										}
									if (dboHijo.tieneDBO()) {
										dboHijo = setDBOs(dboHijo, rs, cols, camposABuscar,esPrimerRegistro);
									}
									field.set(dbo, dboHijoList);
							}
						}
					} else {
						if (field.get(dbo) == null) {
							DBO dboHijo = (DBO)field.getType().newInstance();
							dboHijo = setObjeto(dboHijo, rs, cols);
							if (dboHijo != null ) {
								if (dboHijo.tieneDBO()) {
									dboHijo = setDBOs(dboHijo, rs, cols, camposABuscar,esPrimerRegistro);
								}
								field.set(dbo, dboHijo);
							}
						}
					}
				}
			}
		}
		return dbo;
	}

	public static DBO setObjeto(DBO dbo, ResultSet rs, LinkedHashSet cols) throws Exception {
		if (dbo.estaSeteado()) {
			return dbo;
		}
		Iterator it = cols.iterator();
																	
		String alias = ((String)dbo.getClass().getMethod("getAlias",(Class[])null).invoke(dbo, (Object[])null)).toLowerCase();
		boolean objNulo = true;
		while (it.hasNext()) {
			String label = (String)it.next();
			int columnIndex = rs.findColumn(label);
			if (rs.getObject(columnIndex) != null) {
				String[] columnMetaData = label.split("__");
				if (alias.startsWith(columnMetaData[0].toLowerCase())) {
					for (int j=0; j<dbo.getClass().getDeclaredFields().length; j++) {
						Field field = dbo.getClass().getDeclaredFields()[j];
						field.setAccessible(true);
						if (columnMetaData[1].toLowerCase().equals(field.getName().toLowerCase())) {
							setField(dbo, field, columnMetaData[1], rs, label);
							dbo.seteado();
							objNulo = false;
							it.remove();
							cols.remove(label);
							break;
						}
					}
				}
			} else {
				it.remove();
				cols.remove(label);
			}
		}
		return (objNulo)? null:dbo;
	}

	public static void select(DBO dbo, Connection conn, CamposABuscarDBO camposABuscar, CamposLeftJoinDBO camposLeftJoin)  throws DBOInexistenteException, Exception {
		try {
			PreparedStatement ps = getSelectToDB(dbo, conn, camposABuscar, camposLeftJoin);
			try {
				ResultSet rs = ps.executeQuery();
				try {
					//Asegura un solo registro. Aunque el select siempre deberia ser por PK
					boolean encontrado = false;
					ResultSetMetaData rsm = rs.getMetaData();
					while (rs.next()) {
						encontrado = true;
						LinkedHashSet<String> cols = new LinkedHashSet<String>(rsm.getColumnCount());
						for (int i=1; i<=rsm.getColumnCount(); i++) {
							cols.add(rsm.getColumnLabel(i));
						}
						dbo = setObjeto(dbo, rs, cols);
						if (dbo.tieneDBO()) {
							dbo = setDBOs(dbo, rs, cols, camposABuscar,null);
						}
					}
					if (!encontrado) {
						//throw new Exception ("No se encuentra el DBO " + dbo.getClass().getMethod("getTabla", null).invoke(null, null) + " PK " + dbo.getPK());
						throw new DBOInexistenteException("No se encuentra el DBO " + dbo.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null) + " PK " + dbo.getPK());
					}
				} finally {
					rs.close();
				}
			} finally {
				ps.close();
			}
		} catch (DBOInexistenteException di) {
			throw di;
		} catch (Exception e) {
			throw new Exception (dbo.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}
	} 

	//public static DBO[] select2(Class claseDBO, Connection conn, CamposABuscarDBO camposABuscar, CamposLeftJoinDBO camposLeftJoin, WhereDBO where,OrderBYDBO orderBy)  throws Exception {
	public static Collection<DBO> select2(Class claseDBO, Connection conn, CamposABuscarDBO camposABuscar, CamposLeftJoinDBO camposLeftJoin, WhereDBO where,OrderBYDBO orderBy, Comparator<DBO> comparador)  throws DBOInexistenteException, Exception {
		int cantidad = 0;
		if(where != null) {
			cantidad = where.getCantidadABuscar();
		}
		String[] pkdbo = (String[])claseDBO.getMethod("getCamposPK",(Class[]) null).invoke((Object)null, (Object[])null);
		String[] pkAnterior = null;
		String[] pkActual = null; 
		Collection<DBO> resultado = new TreeSet<DBO>(comparador);
		
		DBO dbo = (DBO)claseDBO.newInstance();		
		try {
			PreparedStatement ps = getSelectToDB2(claseDBO, conn, camposABuscar, camposLeftJoin, where,orderBy);
			try {
				ResultSet rs = ps.executeQuery();
				try {
					//Asegura un solo registro. Aunque el select siempre deberia ser por PK
					boolean encontrado = false;
					ResultSetMetaData rsm = rs.getMetaData();									
					
					while (rs.next()) {
						boolean esPrimero = false; 
						pkActual = getValueOfPK(rs,pkdbo);
						if (pkAnterior == null) {
							pkAnterior = pkActual;
						}						
						if (!sonIguales(pkActual, pkAnterior)) {
							resultado.add(dbo);
							if(cantidad > 0 && resultado.size() == cantidad) {
								break;
							}
							Class newDBO = Class.forName(claseDBO.getName());
							dbo = (DBO)newDBO.newInstance();
							pkAnterior = pkActual;
							//indicamos que estamos en el primero registro
							esPrimero = true;
						} 						
						encontrado = true;
						LinkedHashSet<String> cols = new LinkedHashSet<String>(rsm.getColumnCount());
						for (int i=1; i<=rsm.getColumnCount(); i++) {
							cols.add(rsm.getColumnLabel(i));
						}
						dbo = setObjeto(dbo, rs, cols);
						if (dbo.tieneDBO()) {
							dbo = setDBOs(dbo, rs, cols, camposABuscar,new Boolean(esPrimero));
						}
					}
					if (encontrado) {
						if(cantidad  == 0) {
							resultado.add(dbo);
						}else {
							if(resultado.size() < cantidad) {							
								resultado.add(dbo);
							}
						}
					} else {											
						//throw new Exception (" No se encuentra el DBO " + dbo.getClass().getMethod("getTabla", null).invoke(null, null) + " PK " + dbo.getPK());
						//throw new DBOInexistenteException (" No se encuentra el DBO " + dbo.getClass().getMethod("getTabla", null).invoke(null, null) + " PK " + dbo.getPK());
						throw new DBOInexistenteException (" No se encuentra el DBO " + dbo.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null) + " WHERE " + where);
					}
				} finally {
					rs.close();
				}
			} finally {
				ps.close();
			}
		} catch (DBOInexistenteException e) {
			throw e;
		} catch (Exception e) {
			throw new Exception (dbo.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}					
		return resultado;
	}

	private static boolean sonIguales(String[] pkActual, String[] pkAnterior) {		
		for(int i=0; i < pkActual.length; i++) {
			if(!pkActual[i].equals(pkAnterior[i]))
				return false;
		}
		return true;
	}

	private static String[] getValueOfPK(ResultSet rs, String[] pkdbo) throws SQLException{		
		String[]pk = new String[pkdbo.length];
		for(int i=0; i< pkdbo.length; i++) {
			pk[i] = (String)rs.getString(pkdbo[i]);
		}
		return pk;
	}
	
	@SuppressWarnings("unchecked")
	public static DBO[] addItems (DBO[] lista, DBO item)  throws Exception{
		Class cls = item.getClass();
		if (lista != null) {
			ArrayList aux = new ArrayList(Arrays.asList(lista));
			aux.add(item);
			DBO[] listaAux =(DBO[])aux.toArray(new DBO[aux.size()]);
			lista = (DBO[])Array.newInstance(cls, listaAux.length);
			for (int i=0; i<listaAux.length; i++) {
				lista[i] = listaAux[i];
			}
		} else {
			lista = (DBO[])Array.newInstance(cls, 1);
			lista[0] = item;
		}
		return  lista;
	}

	/*metodos abstractos sin implentacion*/
	public abstract boolean tieneDBO();

	public abstract String getPK();
		
	public boolean equals(DBO dbo) {
		return this.getPK().equals(dbo.getPK());
	}

	public boolean estaSeteado() {
		return seteado;
	}

	public void seteado() {
		seteado = true;
	}
		
	/*metodos sacadas de main helper*/
	// SELECT
	public static PreparedStatement getSelectToDBByObject(DBO obj, Connection conn) throws Exception {
		StringBuffer qry = new StringBuffer("SELECT ");
		for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
			Field field = obj.getClass().getDeclaredFields()[i];
			if (!field.getName().startsWith("cls_")) {
				field.setAccessible(true);
				qry.append(field.getName()).append(", ");
			}
		}
		qry = new StringBuffer(qry.toString().substring(0, qry.length()-2));
		qry.append(" FROM ").append(obj.getClass().getMethod("getTabla", (Class[])null).invoke(obj, (Object[])null)).append(" ").append(obj.getClass().getMethod("getAlias", (Class[])null).invoke(obj, (Object[])null));
		qry.append(" WHERE ").append(obj.getPK());
		PreparedStatement ps = conn.prepareStatement(qry.toString());
		return ps;
	}
	
	//SELECT con Parametro
	public static PreparedStatement getSelectByParamToDBByObject(DBO obj, Connection conn, String[] param) throws Exception {
		StringBuffer qry = new StringBuffer("SELECT ");
		for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
			Field field = obj.getClass().getDeclaredFields()[i];
			if (!field.getName().startsWith("cls_")) {
				field.setAccessible(true);
				qry.append(field.getName()).append(", ");
			}
		}
		qry = new StringBuffer(qry.toString().substring(0, qry.length()-2));
		qry.append(" FROM ").append(obj.getClass().getMethod("getTabla", (Class[])null).invoke(obj, (Object[])null)).append(" ").append(obj.getClass().getMethod("getAlias", (Class[])null).invoke(obj, (Object[])null));
		qry.append(" WHERE ").append(param[0]);
		for (int i=1; i<param.length; i++) {
			qry.append(" AND ").append(param[i]);
		}
		PreparedStatement ps = conn.prepareStatement(qry.toString());
		return ps;
	}
	
	///INSERT DBO object
	public static PreparedStatement getInsertToDBByObject(DBO obj, Connection conn) throws Exception {
		StringBuffer fields = new StringBuffer("INSERT INTO ").append(obj.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null)).append(" (");
		StringBuffer values = new StringBuffer("values (");
		for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
			Field field = obj.getClass().getDeclaredFields()[i];
			field.setAccessible(true);
			if (field.get(obj) != null) {
				if (!field.getName().startsWith("cls_")) {
					fields.append(field.getName()).append(", ");
					values.append("?, ");
				}
			}
		}
		if (fields.toString().equals("INSERT INTO " + obj.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null) + " (")) {
			throw new Exception("getInsertToDBByObject(" + obj.getClass().getName() + ") ERROR: todos los campos son nulos");
		} else {
			fields = new StringBuffer(fields.toString().substring(0, fields.length()-2));
			values = new StringBuffer(values.toString().substring(0, values.length()-2));
			fields.append(")");
			values.append(")");
			fields.append(" ").append(values).toString();
			PreparedStatement ps = conn.prepareStatement(fields.toString());
			int indice = 0;
			for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
				Field field = obj.getClass().getDeclaredFields()[i];
				if (!field.getName().startsWith("cls_")) {
					field.setAccessible(true);
					if (field.get(obj) != null) {
						ps.setObject((++indice), field.get(obj));
					}
				}
			}
			return ps;
		}
	}

	///UPDATE DBO object
	public static PreparedStatement getUpdateToDBByObject(DBO obj, Connection conn) throws Exception {
		StringBuffer qry = new StringBuffer("UPDATE ").append(obj.getClass().getMethod("getTabla",(Class[])null).invoke((Object)null, (Object[])null)).append(" ").append(obj.getClass().getMethod("getAlias", (Class[])null).invoke(obj, (Object[])null)).append(" SET ");
		for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
			Field field = obj.getClass().getDeclaredFields()[i];
			boolean esDBO = esDBO(field.getType());
			boolean esArray = field.getType().isArray() & esDBO;
			//boolean esCampoCls = field.getName().startsWith("cls_");
			if (!field.getName().startsWith("cls_")) {
				field.setAccessible(true);
				if (!esDBO && !esArray && field.get(obj) != null) {
					qry.append(field.getName()).append(" = ?, ");
				}
			}
		}
		if (qry.toString().equals("UPDATE " + obj.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null) + " " + obj.getClass().getMethod("getAlias", (Class[])null).invoke(obj, (Object[])null) + " SET ")) {
			throw new Exception("getUpdateToDBByObject(" + obj.getClass().getName() + ") ERROR: todos los campos son nulos");
		} else {
			qry = new StringBuffer(qry.toString().substring(0, qry.length()-2));
			qry.append(" WHERE ").append(obj.getPK());
			PreparedStatement ps = conn.prepareStatement(qry.toString());
			int indice = 0;
			for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
				Field field = obj.getClass().getDeclaredFields()[i];
				boolean esDBO = esDBO(field.getType());
				boolean esArray = field.getType().isArray() & esDBO;
				if (!field.getName().startsWith("cls_")) {
					field.setAccessible(true);
					if (!esDBO && !esArray && field.get(obj) != null) {
						ps.setObject((++indice), field.get(obj));
					}
				}
			}
			return ps;
		}
	}
	
	public static PreparedStatement getSelectToDB(DBO dbo, Connection conn, CamposABuscarDBO camposABuscarDBO, CamposLeftJoinDBO camposLeftJoinDBO) throws Exception {
		StringBuffer qry = new StringBuffer("SELECT ");
		qry.append(getDBOFields(dbo.getClass(), camposABuscarDBO));
		qry.append(" FROM ");
		qry.append(getDBOFrom(dbo.getClass(), camposABuscarDBO));
		qry.append(" WHERE ");
		qry.append(dbo.getPK());
		String join = getDBOJoinWhere(null, dbo.getClass(), null, camposABuscarDBO, camposLeftJoinDBO);

		if (!"".equals(join)) {
			qry.append(" and ");
			if (join.length() > 2) {
				join = join.substring(0, join.length()-5);
			}
			qry.append(join);
		}

		String orden = getDBOOrden(dbo.getClass(), camposABuscarDBO);
		if (!"".equals(orden)) {
			qry.append(" ORDER BY ");
			if (orden.length() > 2) {
				orden = orden.substring(0, orden.length()-2);
			}
			qry.append(orden);
		}
		return conn.prepareStatement(qry.toString());
	}
	
	public static String getDBOFields(Class claseDBO, CamposABuscarDBO camposABuscarDBO) throws Exception{
		StringBuffer fields = new StringBuffer("");
		for (int i=0; i<claseDBO.getDeclaredFields().length; i++) {
			Field field =  claseDBO.getDeclaredFields()[i];
			if (!field.getName().startsWith("cls_") && camposABuscarDBO.incluirEnBusqueda(claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null) + "." + field.getName())) {
				field.setAccessible(true);
				Class clase;
				if (field.getType().isArray()) {
					clase = field.getType().getComponentType();
				} else {
					clase = field.getType();
				}
				if (esDBO(clase)) {
					fields.append(getDBOFields(clase, camposABuscarDBO)).append(", ");
				} else {
					fields.append(claseDBO.getMethod("getAlias", (Class[]) null).invoke((Object)null, (Object[])null)).append(".").append(field.getName());
					fields.append(" ");
					try {
						fields.append(((String)claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null)).substring(0, Math.min(30-(field.getName().length()+2), ((String)claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null)).length())));
						fields.append("__");
						fields.append(field.getName()).append(", ");
					}catch(StringIndexOutOfBoundsException ae) {
						fields.append(((String)claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null)).substring(0, Math.min(30-(field.getName().length()-4), ((String)claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null)).length())));
						fields.append("__");
						fields.append(field.getName().substring(0,field.getName().length()-4)).append(", ");
					}					
				}
			}
		}
		if (fields.length() > 2) {
			fields = new StringBuffer(fields.substring(0, fields.length()-2));
		}
		
		return fields.toString();
	}
	
	public static String getDBOFrom(Class claseDBO, CamposABuscarDBO camposABuscarDBO) throws Exception{
		StringBuffer fields = new StringBuffer("");
		fields.append(claseDBO.getMethod("getTabla",(Class[]) null).invoke((Object)null, (Object[])null));
		fields.append(" ");
		fields.append(claseDBO.getMethod("getAlias", (Class[]) null).invoke((Object)null, (Object[])null));
		for (int i=0; i<claseDBO.getDeclaredFields().length; i++) {
			Field field =  claseDBO.getDeclaredFields()[i];
			if (!field.getName().startsWith("cls_") && camposABuscarDBO.incluirEnBusqueda(claseDBO.getMethod("getAlias", (Class[]) null).invoke((Object)null, (Object[])null) + "." + field.getName())) {
				field.setAccessible(true);
				Class clase;
				if (field.getType().isArray()) {
					clase = field.getType().getComponentType();
				} else {
					clase = field.getType();
				}
				if (esDBO(clase)) {
					fields.append(", ").append(getDBOFrom(clase, camposABuscarDBO));
				}
			}
		}
		return fields.toString();
	}
	
	//recursiva cortar los ultimos 5 caracteres
	public static String getDBOJoinWhere(String tblPadre, Class claseDBO, String dboField, CamposABuscarDBO camposABuscarDBO, CamposLeftJoinDBO camposLeftJoinDBO) throws Exception{
		StringBuffer fields = new StringBuffer("");
		if (tblPadre != null) {
			String[][] fk = (String[][])claseDBO.getMethod("getFK", new Class[]{String.class}).invoke(null, new Object[]{dboField});
			for (int i=0; i<fk.length; i++) {
				fields.append(tblPadre).append(".").append(fk[i][0]);
				fields.append("=").append(claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null)).append(".").append(fk[i][1]);
				if(camposLeftJoinDBO != null) {
					if (camposLeftJoinDBO.esCampoDBOLeftJoin(tblPadre + "." + dboField)) {
						fields.append("(+)");
					}
				}
				fields.append(" and ");
			}
			Object filtro = claseDBO.getMethod("getFiltro", (Class[]) null).invoke((Object)null, (Object[])null);
			if (filtro != null) {
				fields.append(filtro);
				fields.append(" and ");
			}
		}
		for (int i=0; i<claseDBO.getDeclaredFields().length; i++) {
			Field field =  claseDBO.getDeclaredFields()[i];
			if (!field.getName().startsWith("cls_") &&  camposABuscarDBO.incluirEnBusqueda(claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null) + "." + field.getName())) {
				field.setAccessible(true);
				Class clase;
				if (field.getType().isArray()) {
					clase = field.getType().getComponentType();
				} else {
					clase = field.getType();
				}
				if (esDBO(clase)) {
					fields.append(getDBOJoinWhere((String)claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null), clase, field.getName(),  camposABuscarDBO, camposLeftJoinDBO));
				}
			}
		}

		return fields.toString();
	}
	
	//Se fija si un objeto extiende DBO
	public static boolean esDBO(Class clase) {
		while (!clase.getName().equals(Object.class.getName()) && clase.getSuperclass() != null) {
			if (clase.getSuperclass().getName().equals(DBO.class.getName())) {
				return true;
			} else {
				clase = clase.getSuperclass();
			}
		}
		return false;
	}

//	recursiva cortar los ultimos 2 caracteres
	public static String getDBOOrden(Class claseDBO, CamposABuscarDBO camposABuscarDBO) throws Exception{
		StringBuffer fields = new StringBuffer("");
		String orden= (String)claseDBO.getMethod("getOrden",(Class[]) null).invoke((Object)null, (Object[])null);
		if (orden!= null && !"".equals(orden)) {
			fields.append(orden).append(", ");
		}

		for (int i=0; i<claseDBO.getDeclaredFields().length; i++) {
			Field field =  claseDBO.getDeclaredFields()[i];
			if (!field.getName().startsWith("cls_") && camposABuscarDBO.incluirEnBusqueda(claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null) + "." + field.getName())) {
				field.setAccessible(true);
				Class clase;
				if (field.getType().isArray()) {
					clase = field.getType().getComponentType();
				} else {
					clase = field.getType();
				}
				if (esDBO(clase)) {
					fields.append(getDBOOrden(clase, camposABuscarDBO));

				}
			}
		}

		return fields.toString();
	}

	//public static String[] getDBOOrden2(Class claseDBO, CamposABuscarDBO camposABuscarDBO,OrderBYDBO orderBy) throws Exception{
	public static String getDBOOrden2(Class claseDBO, CamposABuscarDBO camposABuscarDBO) throws Exception{
		StringBuffer fields = new StringBuffer("");
		String orden= (String)claseDBO.getMethod("getOrden",(Class[]) null).invoke((Object)null, (Object[])null);
		if (orden!= null && !"".equals(orden)) {
			fields.append(orden).append(", ");
		}

		for (int i=0; i<claseDBO.getDeclaredFields().length; i++) {
			Field field =  claseDBO.getDeclaredFields()[i];
			if (!field.getName().startsWith("cls_") && camposABuscarDBO.incluirEnBusqueda(claseDBO.getMethod("getAlias",(Class[]) null).invoke((Object)null, (Object[])null) + "." + field.getName())) {
				field.setAccessible(true);
				Class clase;
				if (field.getType().isArray()) {
					clase = field.getType().getComponentType();
				} else {
					clase = field.getType();
				}
				if (esDBO(clase)) {
					fields.append(getDBOOrden(clase, camposABuscarDBO));

				}
			}
		}
		
		//return new String[]{fields.toString(),((orderBy!=null)?orderBy.aString():"")};//
		return fields.toString();
	}

	public static PreparedStatement getSelectToDB2(Class claseDBO, Connection conn, CamposABuscarDBO camposABuscarDBO, CamposLeftJoinDBO camposLeftJoinDBO, WhereDBO where,OrderBYDBO orderBy) throws Exception {
		StringBuffer qry = new StringBuffer("SELECT ");
		qry.append(getDBOFields(claseDBO, camposABuscarDBO));
		qry.append(" FROM ");
		qry.append(getDBOFrom(claseDBO, camposABuscarDBO));
		qry.append(" WHERE ");		
		if(where != null) {
			qry.append(where.toString());
		}else {
			qry.append(" 1=1 ");//en caso de no tener condicion de where traigo todo
		}
		String join = getDBOJoinWhere(null, claseDBO, null, camposABuscarDBO, camposLeftJoinDBO);

		if (!"".equals(join)) {
			qry.append(" and ");
			if (join.length() > 2) {
				join = join.substring(0, join.length()-5);
			}
			qry.append(join);
		}
		
		StringBuffer qryOrden = new StringBuffer(" ORDER BY ");
		
		qryOrden.append((orderBy!=null)?orderBy.aString():"");
				
		String orden = getDBOOrden2(claseDBO, camposABuscarDBO);
		if (!"".equals(orden) && (orden.length() > 2)) {
			qryOrden.append((orderBy!=null)?",":"");
			qryOrden.append(orden.substring(0, orden.length()-2));
		}
		if (!qryOrden.toString().equals(" ORDER BY ")) {
			qry.append(qryOrden);
		}
		join = null;
		orden = null;
		qryOrden = null;
		return conn.prepareStatement(qry.toString());		
	}

	//SELECT ALL con parametro
	public static PreparedStatement getSelectToDBByObjectALL(DBO obj, Connection conn, String []param, String orden, Integer cantidad) throws Exception {
		StringBuffer qry = new StringBuffer("");
		if (cantidad != null) {
			qry.append("SELECT ");
			for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
				java.lang.reflect.Field field = obj.getClass().getDeclaredFields()[i];
				if (!field.getName().startsWith("cls_")) {
					field.setAccessible(true);
					qry.append(field.getName()).append(", ");
				}
			}
			qry = new StringBuffer(qry.toString().substring(0, qry.length()-2));
			qry.append(" FROM (");
		}

		qry.append("SELECT ");
		for (int i=0; i<obj.getClass().getDeclaredFields().length; i++) {
			java.lang.reflect.Field field = obj.getClass().getDeclaredFields()[i];
			if (!field.getName().startsWith("cls_")) {
				field.setAccessible(true);
				qry.append(field.getName()).append(", ");
			}
		}
		if (cantidad != null) {
			qry.append("rownum col, ");
		}

		qry = new StringBuffer(qry.toString().substring(0, qry.length()-2));
		qry.append(" FROM ").append(obj.getClass().getMethod("getTabla", (Class[])null).invoke((Object)null, (Object[])null));
		if (param != null && param.length > 0) {
			qry.append(" WHERE ").append(param[0]);
			for (int i=1; i<param.length; i++) {
				qry.append(" AND ").append(param[i]);
			}
		}
		if (orden != null) {
			qry.append(" ORDER BY " + orden);
		}

		if (cantidad != null) {
			qry.append(" ) WHERE col <=").append(cantidad);
		}

		PreparedStatement ps = conn.prepareStatement(qry.toString());
		TmkLogger.debug(qry.toString());
		return ps;
	}
	
	//AGREGADO EN BETA AUN NO SE DEBE USAR SOLO PARA PRUEBAS
	public static void insert(DBO bo,HashSet<String>objetosAGrabar,Connection con) throws Exception {
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
			boolean esDBO = esDBO(clase);
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
			if(esDBO(clase)) {
				//busco el valor de los campos del dbo hijo para agregarlos al prepared statemen
				Field[] fiels = clase.getDeclaredFields();
				String[] camposRelacionados = RelacionCamposInsertDBO.getInstance().getCamosInsert(bo.getClass().getSimpleName()+"-"+clase.getSimpleName());
				for(int k=0;camposRelacionados!=null && k<camposRelacionados.length;k++){
					for(int j=0;j<fiels.length;j++){
						Field fiel = fiels[j];
						fiel.setAccessible(true);
						if(camposRelacionados[k].equals(fiel.getName())){
							ps.setObject(++indice,fiel.get(campo.get(bo)));
							System.out.print (fiel.getName()+ "-");
							System.out.println(fiel.get(campo.get(bo)));
							break;
						}
					}
				}
			}else{
				ps.setObject(++indice,campo.get(bo));
				System.out.print(campo.getName() + "-") ;
				System.out.println(campo.get(bo));
			}
		}
		System.err.println(qry);
		ps.execute();
		//campos DBO que dependen de este DBO
		for(int i=0;i<camposDBO.size();i++) {
			DBO dbo = (DBO)camposDBO.get(i); 
			insert(dbo,objetosAGrabar,con);
		}
		//campos arrays dentro del DBO
		for(int i=0;i<camposArray.size();i++){
			DBO[] dbos =  (DBO[])camposArray.get(i);
			for(int j=0;j<dbos.length;j++) {
				insert(dbos[j],objetosAGrabar,con);
			}
		}
	}	

}
