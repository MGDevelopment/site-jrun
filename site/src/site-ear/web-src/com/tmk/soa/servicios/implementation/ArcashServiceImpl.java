package com.tmk.soa.servicios.implementation;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
import com.tmk.setup.SHA1;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.servicios.interfaces.ArcashService;

public class ArcashServiceImpl implements ArcashService {

	/***
	 * No esta en uso, pero de ser necesario consulta una si una ordene esta en estado procesado
	 */
	public int estadoDeOrden(String idOrden) throws Exception{
		return DAOFactory.getArcashDAO().getEstadoOrdenById(idOrden);
	}

	/**
	 * con todos los datos en la pantalla de confirmacion, se envia el mail
	 * al cliente con el formulario de arcash para realizar el pago
	 */
	public void enviarMail(Map<String, String> datosCliente) throws Exception {
		DAOFactory.getArcashDAO().enviarMail(datosCliente);
	}

	/**
	 * retorna el path del formulario dependiende de si es modo release o desarrollo (release o debug)
	 */
	public String getPathArash() {
		if(Globals.esModoRelease()) {
			return Globals.PATCH_FORM_ARCASH_RELEASE;
		}else {
			return Globals.PATCH_FORM_ARCASH_DESARROLLO;
		}
	}

	/**
	 * devuelve el token que le corresponde hasheado en SHA1 de:<br>
	 * "IDMerchant|Amount|IDcurrency|Password"<br>
	 * Sha1("IDMerchant|Amount|IDcurrency|Password")<br> La password debe ser mínimo
	 * de 8 caracteres. <br>Ejemplo: SHA1("15|48.50|1|test1234")<br> El string
	 * resultante a enviar es: EC4B1E1C7375D5478137A2A39D17043FB4E0335A
	 */
	public String getToken(OrdenDAO ordenDAO,String pass) {
		SHA1 sha = new SHA1();
		String token = "";
 		try {
 			token = sha.getHash(pass.toString());
 		} catch(NoSuchAlgorithmException e) {
 			TmkLogger.error("Generando token para arcash->"+ordenDAO.getIdOrdenProcesada()+ "->" + e.getMessage());
 		}
 		return token;
	}
	
	/**
	 * id unico de tematika,con el cual arcash lo identifica,
	 * que es enviado en el formulario de pago.
	 */
	public String getIdMerchant() {
		if(Globals.esModoRelease()) {
			return Globals.ID_MERCHANT_RELEASE;
		}else {
			return Globals.ID_MERCHANT_DESARROLLO;
		}
	}

	public String getPasword()  {
		if(Globals.esModoRelease()) {
			return Globals.PSW_RELEASE;
		}else {
			return Globals.PSW_DESARROLLO;
		}
	}

	/***
	 * devuelve el path de la imagen que se envia a arcash, y que se mostrara el
	 * formulario de pago
	 */
	public String getLogoArcash() {
		if(Globals.esModoRelease()) {
			return Globals.PATCH_LOGO_ARCASH_RELEASE;
		}else {
			return Globals.PATCH_LOGO_ARCASH_DESARROLLO;
		}		
	}

	public String getLinkDeFormulario(Map<String, String> datosFormulario) {
		String link = ""; 
		try {
			link =  DAOFactory.getArcashDAO().getLinkDeFormulario(datosFormulario);	
		} catch (Exception e) {
			TmkLogger.error("ArcashServiceImpl->getLinkDeFormulario->" + e);
		}		
		return link;
	}
	/**
	 * Devuelve el link para ingresar a la inerfaz de arcash para verificar el pago de una orden
	 */
	public String getLinkDePagoArcash() {
		if(Globals.esModoRelease()) {
			return Globals.LINK_APROBAR_ORDEN_ARCASH_RELEASE;
		}else {
			return Globals.LINK_APROBAR_ORDEN_ARCASH_DEASRROLLO;
		}		
	}
}