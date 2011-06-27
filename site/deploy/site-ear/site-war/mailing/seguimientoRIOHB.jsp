<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.common.ReporteDeMedioDeCobroDaemon,
                 com.tmk.setup.Contenido"%>
<html>
	<body>
		<b>Reporte de Seguimiento de RIO HB</b><br><br>
<%
	Calendar fecha = Calendar.getInstance();
	fecha.set(Calendar.DATE, 1);
	int diaMaximo = fecha.getActualMaximum(Calendar.DAY_OF_MONTH);

	Vector primerasCompras = ReporteDeMedioDeCobroDaemon.primerasCompras;
	Vector repeticiones = ReporteDeMedioDeCobroDaemon.repeticion;
	Vector total = ReporteDeMedioDeCobroDaemon.total;

%>
		<table align="center" width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 10px;">
	        <tr>
				<td align="center" colspan="2" style="border-right: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 10px;">
					&nbsp;
				</td>
                <td colspan="<%=diaMaximo%>" align="center">
                    <b>Mes de <%= Convert.toStringPublicacion(fecha.getTime()) %></b>
				</td>
			</tr>
			<tr>
				<td colspan="2">
                 <B>Día</B>
				</td>
            <%	for (int i=1; i <= diaMaximo;  i++){
				    String color ="";
						fecha.set(Calendar.DATE, i);
	                if ((fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
						color = "bgcolor = \"#bbEEFF\"";
	                }
	        %>
                <td align="center" width="40" <%=color%>>
                <%= i%>
                </td>
			<%	} %>
            </tr>
            <tr>
                <td width="45">
                    <b>Primeras Compras</b>
                </td>
            <%  for (int i=0; i <= diaMaximo; i++) {
	        %>

                <td align="right" <%if (i == 0) {%>style="border-right: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 10px;"<% } %>>
                    <%=Convert.toString(primerasCompras.get(i),"0")%>
                </td>
            <%
            }
            %>
            </tr>
            <tr>
                <td>
                    <b>Repetición</b>
                </td>
            <% for (int i=0; i <= diaMaximo; i++) {
	        %>

                <td align="right" <%if (i == 0) {%>style="border-right: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 10px;"<% } %>>
                    <%=Convert.toString(repeticiones.get(i),"0")%>
                </td>
            <%
            }
            %>
            </tr>
            <tr>
                <td>
                    <b>Total</b>
                </td>
            <% for (int i=0; i <= diaMaximo; i++) {
	        %>

                <td align="right" <%if (i == 0) {%>style="border-right: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 10px;"<% } %>>

			        <%
	                    double val = 0;
                        val = (total.get(i) =="0")? val: ((Double)total.get(i)).doubleValue();
	                %>
                    <%= Contenido.precioToString(val)%>

                </td>
            <%
            }
            %>
            </tr>
        </table>
        <P></P>
        <table style="font-family: Verdana, Arial; font-size: 11px;" border="0">
        <tr>
        <td>
            <b>* Primeras Compras:</b> Socios que se registraron y compraron con RIO HB en el mes.
			<br>
            &nbsp;
            <br>
            <b>* Repeticiones:</b> Socios que compraron con RIO HB más de una vez en el mes.
			<br>
			&nbsp;
            <br>
            <b>* Total:</b> Es la sumatoria de los importes de las ordenes aprobadas con medio de pago RIO HB, sin tener en cuenta devoluciones en el mes.
        </td>
        </tr>
        </table>
	</body>
</html>
