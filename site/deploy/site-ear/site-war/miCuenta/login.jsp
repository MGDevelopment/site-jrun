<%@ page import="com.tmk.util.HTML.Template,
				 com.tmk.controllers.MainHelper,
				 com.tmk.setup.Contenido,
				 java.util.Hashtable,
				 com.tmk.kernel.Convert"%>
<%  Hashtable args = new Hashtable();
		args.put("filename", Contenido.getServletContext().getRealPath(
					MainHelper.RES_TMPL_PATH + "/miCuenta/loginRediseno.htm"));
	try {
		Template t = new Template (args);
 	    String feedback = Convert.toString(session.getAttribute("Registracion.feedback"), null);
    	if(feedback != null) {
    		session.removeAttribute("Registracion.feedback");
    		t.setParam("feedback", feedback);
		}
		out.println(t.output());
	} catch (Exception e) {

	}
%>
