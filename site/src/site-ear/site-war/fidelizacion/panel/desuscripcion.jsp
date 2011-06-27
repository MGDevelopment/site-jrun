<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.fidelizacion.PuntajeWrapper,
                 com.tmk.kernel.Convert,
                 com.tmk.fidelizacion.VencimientoPuntos,
                 com.tmk.controllers.fidelizacion.ConsultaDePuntos,
                 java.util.Enumeration,
                 java.net.URLEncoder"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.Iterator"%>
<%
	StringBuffer nuevaPagina = new StringBuffer();
	Enumeration par = request.getParameterNames();
	//linked list para no perder el orden de los parametros
	
	String par1 = "";
	String par2 = "";
	String par3 = "";
	String par4 = "";
	for (int i = 0; par.hasMoreElements(); i++) {
		//if (i > 0) nuevaPagina.append("&");
		String nombreParametro = par.nextElement().toString();		
		String valorParametro = request.getParameter(nombreParametro);
		//nuevaPagina.append(nombreParametro).append("=").append( URLEncoder.encode(valorParametro,"ISO-8859-1"));
		//bloque mio
		if("idem".equals(nombreParametro)) {
			par1 = nombreParametro+"="+URLEncoder.encode(valorParametro,"ISO-8859-1");
		}else if("em".equals(nombreParametro)){
			par2 = "&"+nombreParametro+"="+URLEncoder.encode(valorParametro,"ISO-8859-1");
		}else if("ca".equals(nombreParametro)){
			par3 = "&"+nombreParametro+"="+URLEncoder.encode(valorParametro,"ISO-8859-1");
		}else if("me".equals(nombreParametro)){
			par4 = "&"+nombreParametro+"="+URLEncoder.encode(valorParametro,"ISO-8859-1");
		}
		//fin
		//nuevaPagina.append(nombreParametro).append("=").append( URLEncoder.encode(valorParametro,"ISO-8859-1"));		
	}
	nuevaPagina.append(par1).append(par2).append(par3).append(par4);
	
	System.out.println("http://app3.embluejet.com/unsuscribe.asp?"+nuevaPagina);
%>




<html>
<head>
	<META HTTP-EQUIV="refresh" CONTENT="5; url=/promo/visualizar.jsp?URL_GRUPO=/grupos/desuscripcion.htm">
	<script type="text/javascript" src="/js/prototype-1.6.0.3.js"></script>
	<script language="javascript">
	function desuscribir() {
		var par = '<%=nuevaPagina%>';
		var testFrame = document.createElement("IFRAME");
		testFrame.id = "testFrame";
		testFrame.src = "http://app3.embluejet.com/unsuscribe.asp?" + par;
		testFrame.style.display = 'none';
		document.body.appendChild(testFrame);
	}
	</script>

</head>

<body onload="desuscribir()">
Aguarde por favor...
<%=Globals.getGoogleAnalytics()%>

</body>
</html>