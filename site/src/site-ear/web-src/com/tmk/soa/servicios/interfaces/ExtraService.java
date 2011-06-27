/**
 * 
 */
package com.tmk.soa.servicios.interfaces;

/**
 * Admnistra todo lo relacionado a Extra.
 * @author oCLopez
 * 
 */
public interface ExtraService {
	
	//public String getSequenceNumeroDeFormulario() throws Exception;
	
	public String getNumeroDeFormulario() throws Exception; 
	
	//public String getSequenceNumeroDeTarjeta() throws Exception;
	
	public String getNumeroDeTarjeta() throws Exception;
	
	public Integer getNumeroDeCuenta() throws Exception;

}
