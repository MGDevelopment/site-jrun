package com.tmk.xml.mensaje;

import java.util.Date;

public class Mensaje {
	String id;
	String texto;
	String fechaVencimiento;

	public String getTexto() {
		return this.texto;
	}

	public String getId() {
		return this.id;
	}
	public String getFechaVencimiento(){
		return this.fechaVencimiento;
	}


}
