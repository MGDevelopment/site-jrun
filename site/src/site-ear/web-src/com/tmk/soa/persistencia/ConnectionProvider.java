package com.tmk.soa.persistencia;

import java.sql.Connection;

import com.tmk.kernel.DBUtil;

public final class ConnectionProvider {

	/***
	 * Como DButil ya hace un buil de la conexin solo la devuelvo
	 * @return
	 * @throws Exception
	 */
	public static Connection getConection() throws Exception{ 
		return DBUtil.buildConnection();
	}
}
