<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals"%>


<%int estadoActual = Convert.toNumber(request.getParameter("estadoActual"),0);%>



<%
boolean[] estado= {false,false,false,false,false,false,false,false};
estado[estadoActual]=true;%>
<table border="1" align="center"><tr><td align="center" bgcolor="#DCE1E6">
<%for (int i=0; i<6 ;i++){%>
	<br>
	<%if (estado[i]){%>
        <%if (i>0) {%>
		<img src="/imagenes/flecha.gif">
        <%}%>
        <br>
		<img src="../imagenes/compra/iconoCompra_<%=i%>_On.gif" vspace="3"><br>
		<img src="../imagenes/compra/textoCompra_<%=i%>_On.gif" vspace="2"><br>
	<%}else{
        if (i>0){%>
		<img src="../imagenes/compra/flechaTransicion_<%=(estadoActual > i )? "On" : "Of"%>.gif"><br>
        <%}%>
		<img src="../imagenes/compra/iconoCompra_<%=i%>_Of.gif" vspace="3"><br>
		<img src="../imagenes/compra/textoCompra_<%=i%>_Of.gif" vspace="2"><br>
	<%}
}
    %>

</td></tr></td>



