
<%@page import="com.tmk.util.HTML.Template"%>
<%@ page import="java.util.*,
                 java.text.DecimalFormat,
                 com.tmk.soa.servicios.ServiceLocator,
				 java.text.SimpleDateFormat,
				 com.tmk.common.SucursalLocalHome,
				 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.MesDAO,
				 com.tmk.setup.Contenido,
				 com.tmk.kernel.Globals,
				 com.tmk.kernel.site.Evento"
%>

<% 
	Template template = (Template)ServiceLocator.getTemplateService().getTemplate("tmpEventosTmk");
	for (int mesesActual = 0; mesesActual < 2; mesesActual++) {
		DecimalFormat df = new DecimalFormat("00");

	    Date ahora = new Date();
		int esteMes = ahora.getMonth();
		int esteAño = ahora.getYear() + 1900;

		GregorianCalendar gc_actual = new GregorianCalendar(esteAño, esteMes + mesesActual, 1);
		GregorianCalendar gc_futuro = new GregorianCalendar(esteAño, esteMes + mesesActual + 1, 1);

		Enumeration eventos = Contenido.getSite().getEventos().enumerateEvento();
		SucursalLocalHome sucursalHome = (SucursalLocalHome)DBUtil.getHome("Sucursal");

		Vector vecDiaEvento = new Vector();
		Vector vecMesEvento = new Vector();
		Vector vecSucursalEvento= new Vector();
		Vector vecDescripcion = new Vector();
		Vector vecFechaEvento = new Vector();

		while(eventos.hasMoreElements()) {
			Evento evento = (Evento) eventos.nextElement();

			if ((evento.getFecha().getMonth() == gc_actual.get(Calendar.MONTH)) && (evento.getActivo())) {
				vecDiaEvento.add(new Integer(evento.getFecha().getDate())) ;
				vecMesEvento.add(new Integer(evento.getFecha().getMonth()));
				vecFechaEvento.add(evento.getFecha());
				vecSucursalEvento.add(Convert.capitalizar(sucursalHome.findByPrimaryKey(new Integer(evento.getSucursal())).getDESCRIPCION(), true));
				vecDescripcion.add(evento.getDescripcion());
			}
		}
		//if(vecFechaEvento.size()==0){

		//}else{
		if(vecFechaEvento.size() > 0) {
        	template.setParam("mesDeEvento",MesDAO.getMes(gc_actual.get(Calendar.MONTH) + 1).getNombre().toUpperCase());				                     
            SimpleDateFormat formateador = new SimpleDateFormat("EEEE dd");

            Vector vecEventos = new Vector();            
			for (int i = 0; i < vecFechaEvento.size(); i++) {
				Hashtable has = new Hashtable();
				has.put("dia",Convert.capitalizar(formateador.format(vecFechaEvento.get(i)), false));
				has.put("hora",vecFechaEvento.get(i).toString().substring(11,16));
				has.put("textoDeEvento",vecDescripcion.get(i));
				has.put("lugarDeEvento",vecSucursalEvento.get(i));
				vecEventos.add(has);
    		}
			template.setParam("eventos",vecEventos);
		}
	}
	template.setParam("googleEnalytics",Globals.getGoogleAnalytics());
%>	

