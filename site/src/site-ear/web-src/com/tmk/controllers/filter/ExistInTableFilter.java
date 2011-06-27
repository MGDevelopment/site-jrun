package com.tmk.controllers.filter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.controllers.MainHelper;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;


public class ExistInTableFilter extends Filter {
	String table;
	String where;
	boolean negado;
	
	public ExistInTableFilter(String table, String where, boolean negado) {
		this.table = table;
		this.where = where;
		this.negado = negado;
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws FilterException {
		this.state = (negado)? SUCCESS:FAILURE;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE " + where);
					try {
						if (rs.next()) {
							this.state = (negado)? FAILURE: SUCCESS;
						} else {
							this.state = (negado)? SUCCESS: FAILURE;
						}
					} finally {
						rs.close();
					}
				} finally {
					st.close();
				}
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			throw new FilterException(e.toString() + MainHelper.getMessage(e));
			
		}
		TmkLogger.info(toString());	
		
	}

	public String getName() {
		return this.getClass().getName();
	}

}
