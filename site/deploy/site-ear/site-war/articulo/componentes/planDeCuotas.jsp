<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.kernel.MedioDeCobroDAO,
				 com.tmk.setup.Contenido"%>
<%
	double precio = Convert.toNumber(request.getParameter("precio"), 0.0);
	String textoH1 = request.getParameter("textoH1");
%>
<%
    if (Globals.TARJETAS_DETALLE_ARTICULO.size()>1) {
	        int cuotas = Convert.toNumber((String)Globals.TARJETAS_DETALLE_ARTICULO.get(0), 1);
%>
<table width="375" border="0" cellspacing="0" cellpadding="0">
	<tr>
       <td width="226" class="Ftexto03"><div align="left"><!-- <%//=Convert.pluralCompleto(cuotas, "cuota", "cuotas")%> sin interés de <%//=Contenido.precioToString((precio/cuotas))%> c/u.<br />-->
            <a href="#" onclick="javascript:window.open('/componentes/comunes/planesDePago.jsp?precio=<%=precio%>&textoH1=<%=textoH1%>', '', 'toolbar=0,status=0,scrollbars=yes,width=420,height=480,resizable=yes')" class="Flink01">Ver plan de cuotas</a></div>

       </td>
       <td width="160" style="font-size:1"><div align="right">
       <% for (int i = 1; i<Globals.TARJETAS_DETALLE_ARTICULO.size(); i++) {%><img src="/imagenes/<%=((MedioDeCobroDAO)Globals.TARJETAS_DETALLE_ARTICULO.get(i)).getId()%>.gif"/><%}%></div>
       </td>
    </tr>
</table>
<%}%>