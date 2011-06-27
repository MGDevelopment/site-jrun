package com.tmk.view.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class EnviarCvForm extends ActionForm {
	/*datos personales*/
	private String nombre;
	private String apellido;
	private String fechaNac;
	private String edad;
	private String tipoDocumento;
	private String nroDocumento;
	private String sexo;
	private String direccion;
	private String pais;
	private String localidad;
	private String otraLocalidad;
	private String codigoPostal;
	/*datos de contacto*/
	private String telContacto1;
	private String telContacto2;
	private String email;
	private int provincia;
	/*estudios*/
	private String nivelEstudio;
	private String estadoEstudio;
	
	/*datos laborales*/
	private String puestoDeseado;
	private boolean trabaja;
	private String turno;
	private String empresa;
	private String puesto;
	private String desde;
	private String hasta;
		
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.nombre = null;
		this.apellido = null;
		this.codigoPostal = null;
		this.direccion = null;
		this.email = null;
		this.empresa = null;
		this.fechaNac = null;
		this.hasta = null;
		this.localidad = null;
		this.estadoEstudio = null;
		this.nivelEstudio = null;
		this.nroDocumento = null;
		this.localidad = null;
		this.otraLocalidad = null;
		this.pais = null;
		this.provincia  = 0;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
			
		ActionErrors errors = new ActionErrors();
		
		if(this.nombre == null || this.nombre.length() == 0){
			errors.add("nombre", new ActionError("empleo.dato.vacio"));
		}
		if(this.apellido== null || this.apellido.length() == 0){
			errors.add("apellido", new ActionError("empleo.dato.vacio"));
		}
		if(this.sexo== null || this.sexo.length() == 0){
			errors.add("sexo", new ActionError("empleo.dato.vacio"));
		}
		if(this.fechaNac == null || this.fechaNac.length() == 0 || this.fechaNac.equals("dd-mm-aaaa")){
			errors.add("fechaNac", new ActionError("empleo.dato.vacio"));
		}		
		if(this.direccion == null || this.direccion.length() == 0){
			errors.add("direccion", new ActionError("empleo.dato.vacio"));
		}
		if(this.provincia == 0){
			errors.add("provincia", new ActionError("empleo.dato.vacio"));
		}
		if(this.localidad == null || this.localidad.length() == 0){
			errors.add("localidad", new ActionError("empleo.dato.vacio"));
		}
		if(this.codigoPostal == null || this.codigoPostal.length() == 0){
			errors.add("codigoPostal", new ActionError("empleo.dato.vacio"));
		}
		if((this.telContacto1 == null || this.telContacto1.length() == 0) && 
		   (this.telContacto2 == null || this.telContacto2.length() == 0)
		){
			errors.add("telContacto1", new ActionError("empleo.dato.vacio"));
		}
		if(this.email == null || this.email.length() == 0){
			errors.add("email", new ActionError("empleo.dato.vacio"));
		}
		if(this.nivelEstudio== null || this.nivelEstudio.length() == 0){
			errors.add("nivelEstudio", new ActionError("empleo.dato.vacio"));
		}
		if(this.trabaja) {
			if(this.empresa== null || this.empresa.length() == 0){
				errors.add("empresa", new ActionError("empleo.dato.vacio"));
			}
			if(this.puesto== null || this.puesto.length() == 0){
				errors.add("puesto", new ActionError("empleo.dato.vacio"));
			}
			if(this.desde== null || this.desde.length() == 0){
				errors.add("desde", new ActionError("empleo.dato.vacio"));
			}
			if(this.hasta== null || this.hasta.length() == 0){
				errors.add("hasta", new ActionError("empleo.dato.vacio"));
			}
		}		
		
		if(this.puestoDeseado ==null || this.puestoDeseado.length() == 0) {
			errors.add("puestoDeseado", new ActionError("empleo.dato.vacio"));
		}
		request.setAttribute("errores", errors);
		return null;
	}
	
	
	/*SET-GETS*/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getLocalidad2() {
		return otraLocalidad;
	}

	public void setLocalidad2(String otraLocalidad) {
		this.otraLocalidad = otraLocalidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelContacto() {
		return telContacto1;
	}

	public void setTelContacto(String telContacto1) {
		this.telContacto1 = telContacto1;
	}
	
	
	public void setNivelEducacion(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public boolean getTrabaja() {
		return trabaja;
	}

	public void setTrabaja(boolean trabaja) {
		this.trabaja = trabaja;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getOtraLocalidad() {
		return otraLocalidad;
	}

	public void setOtraLocalidad(String otraLocalidad) {
		this.otraLocalidad = otraLocalidad;
	}

	public String getTelContacto1() {
		return telContacto1;
	}

	public void setTelContacto1(String telContacto1) {
		this.telContacto1 = telContacto1;
	}

	public String getTelContacto2() {
		return telContacto2;
	}

	public void setTelContacto2(String telContacto2) {
		this.telContacto2 = telContacto2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProvincia() {
		return provincia;
	}

	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public String getEstadoEstudio() {
		return estadoEstudio;
	}

	public void setEstadoEstudio(String estadoEstudio) {
		this.estadoEstudio = estadoEstudio;
	}

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setPuestoDeseado(String puestoDeseado) {
		this.puestoDeseado = puestoDeseado;
	}

	public String getPuestoDeseado() {
		return puestoDeseado;
	}
	
 	
}
