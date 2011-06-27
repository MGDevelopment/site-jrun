package com.tmk.soa.exceptions;

import java.sql.SQLException;

public class DuplicateException extends SQLException {
	
	public DuplicateException(String mensaje) {
		super(mensaje);
	}	
	
}
