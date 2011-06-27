/**
 * 
 */
package com.tmk.action;

import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.LocalidadDAO;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.PaisDAO;
import com.tmk.kernel.ProvinciaDAO;
import com.tmk.setup.Contenido;
import com.tmk.util.HTML.Template;
import com.tmk.view.model.EnviarCvForm;

/**
 * @author oClopez
 *
 */
public class EnviarCvAction extends Action {

	@SuppressWarnings("deprecation")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if(request.getAttribute("errores")!= null && ((ActionErrors)request.getAttribute("errores")).size()>0) {
			request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
			this.saveErrors(request, (ActionErrors)request.getAttribute("errores"));
			return mapping.getInputForward();
		}
		
		EnviarCvForm enviarCvForm = (EnviarCvForm)form;
		Hashtable<String, String> path = new Hashtable<String, String>();		
		path.put("filename", Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH
					+ "/templates/mailCv.htm"));
		
		Template tmpFormCv = new Template(path); 
		
		PaisDAO paisDAO = Globals.ARGENTINA;
		ProvinciaDAO provinciaDAO = paisDAO.getProvincia(enviarCvForm.getProvincia());
		String provincia = provinciaDAO.getNombre();

		//int idLocalidad = Convert.toNumber(request.getParameter("localidad"), 0);
		int idLocalidad = Integer.parseInt(enviarCvForm.getLocalidad());
		String localidad = "";
		if (Globals.CODIGO_OTRA_LOCALIDAD == idLocalidad) {
			localidad = Convert.toString(request.getParameter("otraLocalidad"), "");
		} else {
			LocalidadDAO localidadDAO = provinciaDAO.getLocalidad(idLocalidad);
			localidad = localidadDAO.getNombre();
		}
		
		tmpFormCv.setParam("nombre", enviarCvForm.getNombre());
		tmpFormCv.setParam("apellido", enviarCvForm.getApellido());
		tmpFormCv.setParam("fechaNacimiento", enviarCvForm.getFechaNac());
		tmpFormCv.setParam("edad", enviarCvForm.getEdad());
		tmpFormCv.setParam("tipoDocumento", enviarCvForm.getTipoDocumento());
		tmpFormCv.setParam("nroDocumento", enviarCvForm.getNroDocumento());
		tmpFormCv.setParam("sexo", enviarCvForm.getSexo());
		tmpFormCv.setParam("direccion", enviarCvForm.getDireccion());
		tmpFormCv.setParam("localidad", localidad);
		tmpFormCv.setParam("provincia", provincia);
		tmpFormCv.setParam("pais", paisDAO.getNombre());
		tmpFormCv.setParam("codigoPostal", enviarCvForm.getCodigoPostal());
		tmpFormCv.setParam("telefono1", enviarCvForm.getTelContacto1());
		tmpFormCv.setParam("telefono2", enviarCvForm.getTelContacto2());
		tmpFormCv.setParam("email", enviarCvForm.getEmail());
		tmpFormCv.setParam("nivelEstudio", enviarCvForm.getNivelEstudio());
		tmpFormCv.setParam("estadoEstudio", enviarCvForm.getEstadoEstudio());
		tmpFormCv.setParam("tieneTrabajo", enviarCvForm.getTrabaja());
		tmpFormCv.setParam("turno", enviarCvForm.getTurno());
		tmpFormCv.setParam("puestoDeseado", enviarCvForm.getPuestoDeseado());
		if(enviarCvForm.getTrabaja()) {
			tmpFormCv.setParam("trabaja", "Si");
			tmpFormCv.setParam("empresa", enviarCvForm.getEmpresa());
			tmpFormCv.setParam("puesto", enviarCvForm.getPuesto());
			tmpFormCv.setParam("desde", enviarCvForm.getDesde());
			tmpFormCv.setParam("hasta", enviarCvForm.getHasta());
		}else {
			tmpFormCv.setParam("trabaja", "No");
		}
		
		//request.setAttribute("idSeccion", new Integer(Globals.SECCION_EMPLEO));
		
		/*ENVIO LOS MAILS*/
		MailUtil.sendMail(Globals.MAIL_MAILER,
                Globals.MAIL_OFERTA_DE_TRABAJO,
                Globals.NOMBRE_DEL_SITIO + " - CV",
                tmpFormCv.output(),
                "HTML");

		MailUtil.sendMail(Globals.MAIL_MAILER,
				  enviarCvForm.getEmail(),
				  Globals.NOMBRE_DEL_SITIO + " - Empleos",
				  "Gracias por haberse postulado a Grupo ILhsa s.a.<br>Sus datos han sido incorporados en nuestra base de datos y serán tenidos en cuenta para futuras búsquedas.",
				  "HTML");
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
		return mapping.findForward("tilesFormCvEnviado");
		
	}
	
}

