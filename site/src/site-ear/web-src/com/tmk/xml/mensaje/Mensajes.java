package com.tmk.xml.mensaje;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Mensajes {
	private Mensaje[] lista;
	//indica cuantos mensajes puedo tomar, que no estan vencidos
	
	public Mensaje[] getMensajes() {
		return this.lista;
	}
	public Mensaje[] setMensajes(Mensaje[] mensaje) {
		return this.lista = mensaje;
	}
	public Mensajes(List lista) {
		this.lista = (Mensaje[])lista.toArray(new Mensaje[lista.size()]);
	}

	public Mensajes() {

	}
	/**
	 *@see setea a null los mensajes que estan vencidos, luego llama a eliminarNulos(cantiad)
	 *@param fechaVencimiento
	 *@return void
	 */
	public void filtrar() throws ParseException {
		String DATE_FORMAT = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date fechaVencimiento;
		Date fechaActual = new Date();
		int cantidadNoVencidos = 0;

		for(int i = 0;i < this.lista.length;i++) {
			//si la fecha es vacia se agrega igual a la lista
			if(null != this.lista[i].fechaVencimiento && !"".equals(this.lista[i].fechaVencimiento)) {
				//fecha vacio se agrega a la lista igual.
				fechaVencimiento = sdf.parse(this.lista[i].fechaVencimiento);
				if(fechaActual.after(fechaVencimiento)) {
					this.lista[i] = null;
				} else {
					cantidadNoVencidos++;
				}
			} else {
				cantidadNoVencidos++;
			}
		}
		//con la lista cargada solo con los que se van a mostrar, elimino los nulos
		eliminarNulos(cantidadNoVencidos);
	}

	/**
	 * @see elimina los mensajes que estan en null en el array de mensaje
	 * @param cantidadNoVencidos
	 */
	private void eliminarNulos(int cantidadNoVencidos) {
		int cargados = 0;
		Mensaje[] mensajesFiltrado = new Mensaje[cantidadNoVencidos];
		
		for(int i = 0;i < this.lista.length && cargados < cantidadNoVencidos; i++) {
			if(this.lista[i] != null) {
				mensajesFiltrado[cargados] =  this.lista[i];
				cargados ++;
			}		
		}
		this.lista = mensajesFiltrado;
	}	
}
