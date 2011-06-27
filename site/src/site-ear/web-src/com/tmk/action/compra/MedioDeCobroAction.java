package com.tmk.action.compra;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.controllers.carrito.CarritoUtil;
import com.tmk.controllers.compra.CompraHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MedioDeCobroDAO;
import com.tmk.kernel.TipoDeDocumentoDAO;
import com.tmk.orden.OrdenDAO;
import com.tmk.orden.TarjetaPrepaga;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.util.HTML.Template;

public class MedioDeCobroAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String frwRedirect = ProcesoCompraUtilImp.getInstance().frwRedireccion(request, response, ProcesoCompraUtil.MEDIO_DE_PAGO);
		if(frwRedirect != null) {
			return mapping.findForward(frwRedirect);
		}
		frwRedirect = "frwMedioDeCobro";		
				
		Template tmpMedioDeCobro = (Template)ServiceLocator.getTemplateService().getTemplate("tmpMedioDeCobro");		
		OrdenDAO ordenDAO = (OrdenDAO)request.getSession().getAttribute("ordenDAO");
		
		setMediosDeCobros(tmpMedioDeCobro,ordenDAO);
		//datos para fax
		tmpMedioDeCobro.setParam("telCallCenter",Globals.TELEFONO_CALL_CENTER);
		tmpMedioDeCobro.setParam("urlFax",CompraHelper.PAGINA_FAX);			
		MedioDeCobroDAO fax = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_FAX);
		String estadoFaxTexto = (fax.estaHabilitado()) ? " enabled " : " disabled ";
		tmpMedioDeCobro.setParam("estadoFaxTexto",estadoFaxTexto);				
		tmpMedioDeCobro.setParam("faxCallCenter",Globals.FAX_CALL_CENTER);
		//fin fax
//FIN BLOQUE
		
		//ya tiene medio de cobro?		
		boolean tieneMedioDeCobro = ordenDAO.getMedioDeCobro()!=null;
		boolean esTarjeta= false;
		if(tieneMedioDeCobro ) {
			tmpMedioDeCobro.setParam("tieneMedioDeCobro", tieneMedioDeCobro);
			if(ordenDAO.getMedioDeCobro().esTarjeta()) {
				tmpMedioDeCobro.setParam("numeroTarjeta", Convert.toString(ordenDAO.get_NumeroTarjetaCompletoDesencriptado()));
				esTarjeta = true;
			}else {
				tmpMedioDeCobro.setParam("displayTA","none");
				tmpMedioDeCobro.setParam("numeroTarjeta","");
			}
			//1)deshabilito todos 
			for(int i=0;i<Globals.MEDIOS_DE_COBRO.length;i++){
				//if(Globals.MEDIOS_DE_COBRO[i].estaHabilitado()) {
					if(Globals.MEDIOS_DE_COBRO[i].getId().equals(ordenDAO.getMedioDeCobro().getId())){
						tmpMedioDeCobro.setParam("display"+ordenDAO.getMedioDeCobro().getId(),"");
						tmpMedioDeCobro.setParam("idMedioDeCobro",ordenDAO.getMedioDeCobro().getId());
					}else{
						tmpMedioDeCobro.setParam("display"+Globals.MEDIOS_DE_COBRO[i].getId(),"none");
					}
				//}
			}
		}else {
			//POR SEGURIDAD DESHABILITO TODOS LOS DIVS CON INFORMACION
			for(int i=0;i<Globals.MEDIOS_DE_COBRO.length;i++){
				//if(Globals.MEDIOS_DE_COBRO[i].estaHabilitado()) {
					tmpMedioDeCobro.setParam("display"+Globals.MEDIOS_DE_COBRO[i].getId(),"none");
				//}
			}
			//como los medios de pago tarjeta estan agrupados en en div id="TA", 
			//agrego esta linea y oculto directamente el div donde estan.
			tmpMedioDeCobro.setParam("displayTA","none");
		}
		
//BLOQUE PARA EL CUPON
		Object cuponObj = request.getSession().getAttribute(CompraHelper.PARAMETRO_CUPON);		
		String cupon = Convert.toString((ordenDAO.getCupon() == null) ? cuponObj : ordenDAO.getCupon(), "");
		
		if (cupon.equals(Globals.CUPON_REFERIDO.getId())) {
			cupon = "";
		}
		for (int i = 0; i<Globals.CUPON_REFERENTE.length; i++) {
			if (cupon.equals(Globals.CUPON_REFERENTE[i].getId())) {
				cupon = "";
				break;
			}
		}
		tmpMedioDeCobro.setParam("campoCupon", CompraHelper.CAMPO_CUPON );
		tmpMedioDeCobro.setParam("valorCupon", cupon);
		
//BLOQUE PARA MOSTRAR LOS MESES.(en modal de visa)
		Vector<Hashtable<String, Object>> vec = new  Vector<Hashtable<String, Object>>();
		Hashtable<String, Object> has = null;
		for (int indexMes = 1; indexMes <= 12; indexMes++) {
			has = new Hashtable<String, Object>();
			has.put("value", indexMes);
			has.put("checked", (indexMes == ordenDAO.get_MesVencimiento() && esTarjeta) ? " selected " : "" );
			has.put("texto", indexMes);
			vec.add(has);
		}
		tmpMedioDeCobro.setParam("meses", vec);	
		
//DATOS PARA EL ANIO.(en modal de visa)
		vec = new  Vector<Hashtable<String, Object>>();
		int anoActual = Calendar.getInstance().get(Calendar.YEAR);
		int vencimiento = (ordenDAO.get_AnoVencimiento() == 0) ? (anoActual + 1) : ordenDAO.get_AnoVencimiento();		
		for (int indexAnio = anoActual; indexAnio <= anoActual + 10; indexAnio++) { 
			has = new Hashtable<String, Object>();
			has.put("value", indexAnio);
			has.put("checked", (indexAnio == vencimiento && esTarjeta) ? "selected" : "");
			has.put("texto", indexAnio);
			vec.add(has);			
		}		
		tmpMedioDeCobro.setParam("anios", vec);	
		
//BLOQUE DE CUOTAS.(en modal de visa)
		 if (Globals.HABILITA_CUOTAS) {
			 tmpMedioDeCobro.setParam("habilitaCuontas", "true");
			 if (ordenDAO.getTarjetaPlanDAO() != null && esTarjeta) {
				 tmpMedioDeCobro.setParam("tarjetaPlanYTarjeta", "true");
				 tmpMedioDeCobro.setParam("tarjetaDaoClave", Convert.toString(ordenDAO.getTarjetaPlanDAO().getClave(), ""));				 
			 }			 
		 }		 
//DATOS DEL TITULAR DE LA TARJETA.(en modal de visa)
		 tmpMedioDeCobro.setParam("titularTarjeta", (esTarjeta)? Convert.toString(ordenDAO.getNombreCliente()): "");
		 String numeroDeDocumento = Convert.toString(ordenDAO.getNumeroDocumento());
		 //si llEga a ser 0 el numero de documento,pongo nada ("")
		 numeroDeDocumento = "0".equals(numeroDeDocumento)? "" : numeroDeDocumento;  
		 tmpMedioDeCobro.setParam("numeroDocumento", numeroDeDocumento);
		 tmpMedioDeCobro.setParam("domEnvTarj", Convert.toString(ordenDAO.getDomicilioResumen(), ""));
		 tmpMedioDeCobro.setParam("codigoDeSeguridad", Convert.toString(ordenDAO.get_CodigoSeguridad(), ""));
//TIPOS DE DOCUMENTO.(en modal de visa)
		 vec = new  Vector<Hashtable<String, Object>>();
		 for (int td = 0; td < Globals.TIPOS_DOCUMENTO.length; td++) {
			TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[td];
			has = new Hashtable<String, Object>();
			has.put("idDocumento",tipoDeDocumentoDAO.getId());
			has.put("nombreDocumento",tipoDeDocumentoDAO.getNombre());
			vec.add(has);
		 }		 
		 tmpMedioDeCobro.setParam("tiposDocumentos", vec);
//DATOS DE CONTACTO 
		if(ordenDAO.getTelefonoContacto()!=null) {
			tmpMedioDeCobro.setParam("numeroTelefono", ordenDAO.getTelefonoContacto());
		}
		//String horarioEntrega = ordenDAO.getRANGO_HORARIO_RECEPTOR();
		String horarioEntrega = ordenDAO.getHorarioContacto();
		if(horarioEntrega!=null && !horarioEntrega.trim().equals("")) {
			if(horarioEntrega.indexOf("(09:00 a 13:00)")>=0) {
				tmpMedioDeCobro.setParam("checkPorLaManana", "checked");
			}
			if(horarioEntrega.indexOf("(13:00 a 18:00)") >=0) {
				tmpMedioDeCobro.setParam("checkPorLaTarde", "checked");
			}
			if(horarioEntrega.indexOf("(09:00 a 18:00)")>=0) {
				tmpMedioDeCobro.setParam("checkPorDefecto", "checked");
			}
		}else {
			tmpMedioDeCobro.setParam("checkPorDefecto", "checked");
		}
		
//BLOQUE EXTRA
		 if (Globals.FIDELIZACION_VIGENTE) {
			 tmpMedioDeCobro.setParam("fideliazacionVigente", "true");
			 tmpMedioDeCobro.setParam("valorTarjeta", Convert.toString(ordenDAO.getNumeroTarjetaExtra()));			
		 }else{
			 tmpMedioDeCobro.setParam("fideliazacionVigente", "");
		 }	
//BLOQUE CPF/CNPJ(PARA DIRECCIONE EN BRASIL) 
		 if(ordenDAO.getDomicilioEnvio() != null){
	     	if (ordenDAO.getDomicilioEnvio().getIdPais().intValue() == CompraHelper.PAIS_BRASIL) {
                tmpMedioDeCobro.setParam("esBrasil", "true");
	     		String CPF="";
                String CNPJ="";
                String codCPF_CNPJ="";
                if (ordenDAO.getCPF_CNPJ() !=  null) {
                    if (ordenDAO.getCPF_CNPJ().indexOf("CPF") >-1) {
                        CPF = "checked";
                        codCPF_CNPJ = ordenDAO.getCPF_CNPJ().replaceAll("CPF ", "");
                    } else {
                        CNPJ = "checked";
                        codCPF_CNPJ = ordenDAO.getCPF_CNPJ().replaceAll("CNPJ ", "");
                    }
                } else {
                    CPF = "checked";
                }
               tmpMedioDeCobro.setParam("checkedCPF", CPF);
               tmpMedioDeCobro.setParam("checkedCNPJ", CNPJ);
               tmpMedioDeCobro.setParam("valorCPF_CNPJ", codCPF_CNPJ);
	     	}
	     }
		  
//FIN BLOQUE	     	
		//seteo para google analytics
		if(Globals.esModoRelease()){
			tmpMedioDeCobro.setParam("googleAnalyticsSSL", Globals.getGoogleAnalyticsSSL());
		}
		
		//obtengo las pantallas anterior y siguiente en base a la que estoy parado
		Map<String, String> direcciones = null;
		direcciones = ProcesoCompraUtilImp.getInstance().getDirecciones(ProcesoCompraUtil.MEDIO_DE_PAGO);	
		tmpMedioDeCobro.setParam("pantallaAnterior", direcciones.get("anterior"));
		tmpMedioDeCobro.setParam("pantallaSiguiente", direcciones.get("siguiente"));
		
		request.setAttribute("template", tmpMedioDeCobro.output());
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));		
		return mapping.findForward(frwRedirect);
	}

	/**
	 * Carga en el vector de medios de cobros todos aquellos habilitados y retorna el vector cargado.
	 * @param tmpMedioDeCobro
	 * @param ordenDAO
	 * @return Vector<Hashtable<String, Object>>
	 */	
	private final void setMediosDeCobros(Template tmpMedioDeCobro,OrdenDAO ordenDAO) {
		boolean tieneMedioDeCobro = false;
		
		if (ordenDAO.getMedioDeCobro() != null) {
			tieneMedioDeCobro = true;
		}				
		Vector<Hashtable<String, Object>> vecMediosDeCobro = new  Vector<Hashtable<String, Object>>();
		Hashtable<String, Object> hasMediosDeCobros = new Hashtable<String, Object>();
		
		hasMediosDeCobros.put("idMedio", "-1");
		hasMediosDeCobros.put("nombre", "Elija una opci&oacute;n");
		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esTarjeta()) ? " selected " : "");
		vecMediosDeCobro.add(hasMediosDeCobros);
		//tarjetas
		hasMediosDeCobros = new Hashtable<String, Object>();
		tmpMedioDeCobro.setParam(Globals.TIPO_MEDIO_DE_COBRO_TARJETAS, "true");//verifique en medioDeCobros.jsp y no hay chequeo de si esta habilitado o no. por eso lo agrego sin preguntar si esta habiliado.
		hasMediosDeCobros.put("idMedio", Globals.TIPO_MEDIO_DE_COBRO_TARJETAS);
		hasMediosDeCobros.put("nombre", "Con Tarjeta de Crédito");
		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esTarjeta()) ? " selected " : "" );
		vecMediosDeCobro.add(hasMediosDeCobros);
       MedioDeCobroDAO rioHB = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_RIOHB);
       if (rioHB.estaHabilitado()) {
    	    tmpMedioDeCobro.setParam(rioHB.getId(), "true");
    	    tmpMedioDeCobro.setParam("nombreHomeBanking", rioHB.getNombre());
	    	hasMediosDeCobros = new Hashtable<String, Object>();
	   		hasMediosDeCobros.put("idMedio", Globals.CLAVE_MEDIO_DE_COBRO_RIOHB);
	   		hasMediosDeCobros.put("nombre", rioHB.getNombre());
	   		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esHomeBanking()) ? " selected " : "");
	   		vecMediosDeCobro.add(hasMediosDeCobros);
       }      
       boolean estadoPagoFacil = false;
      	 MedioDeCobroDAO pagoFacil = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL);
      	 estadoPagoFacil = (( ordenDAO.getAlgunDomicilioEnvio()!=null ) && pagoFacil.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina());
      	 if (estadoPagoFacil) {
      		tmpMedioDeCobro.setParam(pagoFacil.getId(), "true");
      	 	hasMediosDeCobros = new Hashtable<String, Object>();
	   		hasMediosDeCobros.put("idMedio", Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL);
	   		hasMediosDeCobros.put("nombre", pagoFacil.getNombre());
	   		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esPagoFacil()) ? " selected " : "");
	   		vecMediosDeCobro.add(hasMediosDeCobros);
      	 }     
       boolean estadoRapiPago = false;
      	 MedioDeCobroDAO rapiPago = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO);
      	 estadoRapiPago = (( ordenDAO.getAlgunDomicilioEnvio()!=null ) && rapiPago.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina());
      	 if (estadoRapiPago) {
      		tmpMedioDeCobro.setParam(rapiPago.getId(), "true");
      	 	hasMediosDeCobros = new Hashtable<String, Object>();
	   		hasMediosDeCobros.put("idMedio", Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO);
	   		hasMediosDeCobros.put("nombre", rapiPago.getNombre());
	   		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esRapiPago()) ? " selected " : "");
	   		vecMediosDeCobro.add(hasMediosDeCobros);
      	 }      

       boolean estadoDineroMail = false;
      	 MedioDeCobroDAO dineroMail = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_DINERO_MAIL);
      	 estadoDineroMail = ( ordenDAO.getAlgunDomicilioEnvio()!=null  && dineroMail.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina());
      	 if (estadoDineroMail) {   
      		tmpMedioDeCobro.setParam(dineroMail.getId(), "true");
      	 	hasMediosDeCobros = new Hashtable<String, Object>();
	   		hasMediosDeCobros.put("idMedio", Globals.CLAVE_MEDIO_DE_COBRO_DINERO_MAIL);
	   		hasMediosDeCobros.put("nombre", dineroMail.getNombre());
	   		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esDineroMail()) ? " selected " : "");
	   		vecMediosDeCobro.add(hasMediosDeCobros);
      	 }      
	
	  /* Logica necesario para habilitar el medio de arcash*/
		boolean estadoArcash = false;
      	MedioDeCobroDAO arcash = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_ARCASH);
      	estadoArcash = ( ordenDAO.getAlgunDomicilioEnvio()!=null  && arcash.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina());											                              	 	
 		if (estadoArcash) { 
 			tmpMedioDeCobro.setParam(arcash.getId(), "true");
 			hasMediosDeCobros = new Hashtable<String, Object>();
	   		hasMediosDeCobros.put("idMedio", Globals.CLAVE_MEDIO_DE_COBRO_ARCASH);
	   		hasMediosDeCobros.put("nombre", arcash.getNombre());
	   		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esArcash()) ? " selected " : "");
	   		vecMediosDeCobro.add(hasMediosDeCobros);
 		}
      	      
      	boolean estadoReembolso = false;
        boolean esSuscripcionQuid = CarritoUtil.estaEnlaOrden(ordenDAO,CarritoUtil.getAriculosExcluidos().get(0));
      	MedioDeCobroDAO reembolso = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO);      	
		estadoReembolso = (( ordenDAO.getAlgunDomicilioEnvio()!=null ) && reembolso.estaHabilitado() && ordenDAO.getAlgunDomicilioEnvio().getPais().esArgentina() && !esSuscripcionQuid);		
		if (estadoReembolso) {
			tmpMedioDeCobro.setParam(reembolso.getId(), "true");
			hasMediosDeCobros = new Hashtable<String, Object>();
	   		hasMediosDeCobros.put("idMedio", Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO);
	   		hasMediosDeCobros.put("nombre", reembolso.getNombre());
	   		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esReembolso()) ? " selected " : "");
	   		vecMediosDeCobro.add(hasMediosDeCobros);
       }      
      
        boolean estadoFax = false;      	
		MedioDeCobroDAO fax = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_FAX);
		estadoFax = (fax.estaHabilitado());
		String estadoFaxTexto = (estadoFax) ? " enabled " : " disabled ";
		hasMediosDeCobros = new Hashtable<String, Object>();
		tmpMedioDeCobro.setParam(fax.getId(), Globals.CLAVE_MEDIO_DE_COBRO_FAX);
   		hasMediosDeCobros.put("idMedio", Globals.CLAVE_MEDIO_DE_COBRO_FAX);
   		hasMediosDeCobros.put("nombre", fax.getNombre());
   		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esFax()) ? " selected " : "");
   		hasMediosDeCobros.put("estadoFaxTexto", estadoFaxTexto);
   		vecMediosDeCobro.add(hasMediosDeCobros);
   		//
   		MedioDeCobroDAO tarjetaPrepaga = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA);
		if (tarjetaPrepaga.estaHabilitado()) {	  
			tmpMedioDeCobro.setParam(tarjetaPrepaga.getId(), "true");
			hasMediosDeCobros = new Hashtable<String, Object>();
	   		hasMediosDeCobros.put("idMedio", Globals.CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA);
	   		hasMediosDeCobros.put("nombre", tarjetaPrepaga.getNombre());
	   		hasMediosDeCobros.put("checked", (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) ? " selected " : "");
	   		vecMediosDeCobro.add(hasMediosDeCobros);
		} 
				
		tmpMedioDeCobro.setParam("mediosDisponibles",vecMediosDeCobro );
		//la logica de las tarjetas prepagas ahora aca:
		
		Vector<Hashtable<String,Object>> vecTarjeasCargadas = new Vector<Hashtable<String,Object>>();
		Vector<Hashtable<String,Object>> vecTarjeas = new Vector<Hashtable<String,Object>>();
		hasMediosDeCobros = null;
		int tarjetasCargadas=0;
		if (tieneMedioDeCobro && ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) {
			for(tarjetasCargadas=0; tarjetasCargadas<ordenDAO.getTarjetasPrepagas().size(); tarjetasCargadas++) {
                //<input type="text" maxlength="32" size="45" name="<%=CompraHelper.CAMPO_TARJETA_PREPAGA + tarjetasCargadas%>"
       			//value="<%=((TarjetaPrepaga)ordenDAO.getTarjetasPrepagas().get(tarjetasCargadas)).getNro()
				hasMediosDeCobros = new Hashtable<String, Object>();
				hasMediosDeCobros.put("name", CompraHelper.CAMPO_TARJETA_PREPAGA + tarjetasCargadas);
				hasMediosDeCobros.put("value", ((TarjetaPrepaga)ordenDAO.getTarjetasPrepagas().get(tarjetasCargadas)).getNro());
				vecTarjeasCargadas.add(hasMediosDeCobros);
			}
		}
		tmpMedioDeCobro.setParam("tarjetasCargadas", vecTarjeasCargadas);
		for (int i=tarjetasCargadas; i<5; i++) {
			hasMediosDeCobros = new Hashtable<String, Object>();
			hasMediosDeCobros.put("name", CompraHelper.CAMPO_TARJETA_PREPAGA + i);
			vecTarjeas.add(hasMediosDeCobros);
			//<input type="text" maxlength="32" size="45" name="<%=CompraHelper.CAMPO_TARJETA_PREPAGA + i%>" class="ayudatext" />        
		}		
		tmpMedioDeCobro.setParam("tarjetas", vecTarjeas);
	}
}
