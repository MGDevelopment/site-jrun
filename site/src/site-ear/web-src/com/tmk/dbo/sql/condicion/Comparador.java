package com.tmk.dbo.sql.condicion;

import java.util.Iterator;
import java.util.List;

public class Comparador {
	public static Comparador BETWEEN;
	public static Comparador IN;
	public static Comparador MAYOR;
	public static Comparador MENOR;
	public static Comparador IGUAL;
	public static Comparador LIKE;
	public static Comparador IS_NOT_NULL;
	static {  	
		BETWEEN = new Comparador("between");
		MAYOR = new Comparador(">");
		MENOR = new Comparador("<");
		IGUAL= new Comparador("=");		
		IN= new Comparador("in");
		LIKE= new Comparador("like");
		IS_NOT_NULL = new Comparador("is not null");
	};
	
	private String Comparador;
	
	private Comparador(String Comparador){
		this.Comparador = Comparador;
	}

	public String toString() {		
		return Comparador; 
	}

	public static String listaToIN(List<Integer> listaIds) {
	//"('372739','189827','103406','49035','49036','49037','49038','49039')")
		StringBuffer strIds = new StringBuffer("(");
		for(int i=0;i<listaIds.size();i++) {
			int id = listaIds.get(i).intValue();
			strIds.append("'");
			strIds.append(id);
			strIds.append("'");
			strIds.append(",");			
		}
		String ids = strIds.toString().substring(0, strIds.length()-1);
		ids = ids.concat(")");
		return ids;
	}
	
	public static String listaToIN(List<Integer> listaIds, String campo) {
		Iterator<Integer> itIds = listaIds.iterator();
		Integer id;
		StringBuffer strId = new StringBuffer("id_articulo in (");
		int i=0;
		while(itIds.hasNext()) {
			id = itIds.next();
			strId.append("'");
			strId.append(id.intValue());
			strId.append("'");
			strId.append(" ,");
			i++;
			if(i==999) {
				strId = new StringBuffer(strId.toString().substring(0,strId.length()-1));
				strId.append(")");
				strId.append(" or ");
				strId.append(campo);
				strId.append(" in (");
				i=0;
			}
		}
				
		String ids = "";	
		ids = strId.toString().substring(0, strId.length() - 1);
		ids = ids.concat(")");
		
		return ids;
	}
	
	public static String[] listaToArrayIN(List<Integer> listaIds, String campo) {
		Iterator<Integer> itIds = listaIds.iterator();
		Integer id;
		StringBuffer strId = new StringBuffer(campo);
		strId.append(" in (");
		int i=0;
		int pos=0;
		int tam = 1;
		if(listaIds.size()/1000 >= 1 && listaIds.size()%1000 >1)
			tam = listaIds.size()/1000 + 1;
		String[]arrayIn = new String[tam];
		while(itIds.hasNext()) {
			id = itIds.next();
			strId.append("'");
			strId.append(id.intValue());
			strId.append("'");
			strId.append(" ,");
			i++;
			if(i==999) {
				strId = new StringBuffer(strId.toString().substring(0,strId.length()-1));
				strId.append(")");
				arrayIn[pos++]=strId.toString();				
				strId = new StringBuffer(campo);
				strId.append(" in (");
				i=0;
			}
		}
				
		String ids = "";	
		ids = strId.toString().substring(0, strId.length() - 1);
		ids = ids.concat(")");
		arrayIn[pos]=ids;
		return arrayIn;
	}

}
