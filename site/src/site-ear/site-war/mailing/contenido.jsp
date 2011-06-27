<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 java.util.Date,
                 com.tmk.setup.Contenido"%>

<b>Se cambi&oacute; la configuraci&oacute;n del sitio (<%=Globals.PAGINA_SITIO%>).</b><br><br>

Fecha actual: <%= Convert.toStringLargo(new Date())%><br><br>

Fecha del Contenido: <%= Convert.toStringLargo(Contenido.getXmlLoader().getXMLFileDate())%>

<br><br>
<b>Promoción vigente:<b><br>
<%@include file="/leyendas/promociones.htm"%><br><br><br>

<%@include file="/mailing/promocionesAVencer.jsp"%>

