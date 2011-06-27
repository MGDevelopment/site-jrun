<%@ page import="com.tmk.kernel.HTMLUtil, java.net.URLEncoder, java.util.Enumeration"%>
<%	StringBuffer nuevaPagina = new StringBuffer();
	Enumeration params = request.getParameterNames();
	for (int i = 0; params.hasMoreElements(); i++) {
		if (i > 0) nuevaPagina.append("&");
		String nombreParametro = params.nextElement().toString();
		String valorParametro = request.getParameter(nombreParametro);
		nuevaPagina.append(nombreParametro).append("=").append( URLEncoder.encode(valorParametro,"ISO-8859-1"));
	}
	nuevaPagina = new StringBuffer().append("http://plataforma.emblue.com.ar/unsuscribe.asp").append("?").append(nuevaPagina);
%> 

<%

try {
	out.println(nuevaPagina.toString());
	out.println(HTMLUtil.download(nuevaPagina.toString()));
} catch (Exception e) {
	out.println(e.toString());
}
%>