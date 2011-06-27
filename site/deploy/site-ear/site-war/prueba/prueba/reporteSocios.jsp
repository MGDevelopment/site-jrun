
<%@page import="java.io.File"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.kernel.MailUtil"%>
<%@page import="com.tmk.report.Report"%>
<%@page import="com.tmk.generacion.articulo.GeneradorDeArticulo"%>

<%
	MailUtil.sendMail(Globals.MAIL_MAILER, "laguirre@ilhsa.com", "reporteSocios", "", "HTML", (File)Report.reporteDeProductosPorSocios());	
%>	