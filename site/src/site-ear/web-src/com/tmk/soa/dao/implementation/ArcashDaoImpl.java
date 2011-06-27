package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import com.tmk.controllers.MainHelper;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.soa.dao.interfaces.ArcashDAO;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ArcashService;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.HTML.Template;

public class ArcashDaoImpl implements ArcashDAO {

	public int getEstadoOrdenById(String idOrden) throws Exception {
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		int estado = -1;
		try {
			StringBuffer qry = new StringBuffer("select estado from orden where id_orden = ");
			qry.append(idOrden);
			conn =  DBUtil.buildConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(qry.toString());
			if(rst.next()) {
				estado =  rst.getInt("estado");
			}
		}catch (Exception e) {
			TmkLogger.error("ArcashDaoImpl->getEstadoOrdenById->"+e.getMessage());
		}finally {
			conn.close();
			stm.close();
			rst.close();
		}
		return estado;
	}
	
	public void enviarMail(Map<String,String> datosCliente) throws Exception {

		Hashtable<String, String> path = new Hashtable<String, String>();		
		path.put("filename", Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH
					+ "/templates/tmpFrmArcash2.htm"));
		
		//agrego estoas datos por que no vienen desde la jsp 
		//es asi para que no esten a la vista
		ArcashService service = ServiceLocator.getArcashService();
		datosCliente.put("Password",service.getPasword());//pasword para todas las compras
		datosCliente.put("IDCurrency","1");//moneda actual 
		datosCliente.put("IDMerchant",service.getIdMerchant());//identificador de tematika en arcash
		datosCliente.put("logo",service.getLogoArcash());
		String pk[] = datosCliente.get("socioPK").split("-");
		//elimino para que no se agregue a la template
		datosCliente.remove("socioPK");
		
		Template tmpForm = new Template(path); 
		Iterator<String> claves = datosCliente.keySet().iterator();
		Iterator<String> valores = datosCliente.values().iterator();
		while(claves.hasNext()) {
			String key = claves.next();  
			String valor = valores.next(); 
			tmpForm.setParam(key, valor);
		}
		
		SocioPK socioPK = new SocioPK (new Integer(pk[1]),new Integer(pk[0]));
		String mail = ServiceLocator.getSocioService().getLogin(socioPK);
		/*ENVIO LOS MAILS*/
		MailUtil.sendMail(Globals.MAIL_MAILER,
                mail,
                Globals.NOMBRE_DEL_SITIO + " - Formulario de pago Arcash",
                tmpForm.output(),
                "HTML");
	}

	/**
	 * arma el link para envio de datos a arcash, no se implemento por que no enviaba la data de manera correta
	 * a traves de un <a href="...">
	 */
	public String getLinkDeFormulario(Map<String, String> datosCliente) throws Exception {
		//agrego estoas datos por que no vienen desde la jsp 
		//es asi para que no esten a la vista
		ArcashService service = ServiceLocator.getArcashService();
		datosCliente.put("Password",service.getPasword());//pasword para todas las compras
		datosCliente.put("IDCurrency","1");//moneda actual 
		datosCliente.put("IDMerchant",service.getIdMerchant());//identificador de tematika en arcash
		datosCliente.put("logo",service.getLogoArcash());
				
		Template tmpForm =(Template)ServiceLocator.getTemplateService().getTemplate("tmpFrmArcash3");
		Iterator<String> claves = datosCliente.keySet().iterator();
		Iterator<String> valores = datosCliente.values().iterator();
		while(claves.hasNext()) {
			String key = claves.next();  
			String valor = valores.next(); 
			tmpForm.setParam(key, valor);
		}
					
		return tmpForm.output();
	}

}
