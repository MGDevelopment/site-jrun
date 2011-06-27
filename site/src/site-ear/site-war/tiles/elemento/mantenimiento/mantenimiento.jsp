<%@ page import="com.tmk.kernel.*,
                 com.tmk.setup.Contenido,
                 java.util.Date,
                 java.text.NumberFormat,
                 java.text.ChoiceFormat,
                 java.text.DecimalFormat,
                 java.awt.*"%>
<div style="; height:300px" >
<table style="text-align: center">
			<tr>
				<td height="59" valign="top" class="titulocarrito"> <div align="left">
					<jsp:include page="/componentes/comunes/logo.jsp?CONTROLAR_SERVER=false"/>
				</td>
			</tr>
		</table>
		<br>
		<table width="60%" align="center" bgcolor="#FFFFCC">
			<tr bgcolor="#FF9933">
				<td height="4" valign="bottom"></td>
			</tr>
			<tr>
				<td>
					<p align="center">
						<font size="3" face="Verdana, Arial, Helvetica, sans-serif">
							<strong><%=Globals.MENSAJE_MODO%></strong>
						</font>
					</p>
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
						La página se reconectará automáticamente al sitio cuando este disponible.
					</font>
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
						Hora actual: <%= Convert.TIME_FORMAT.format(new Date())%>.
					</font>
				</td>
			</tr>
			<tr bgcolor="#FF9933">
				<td height="4" valign="bottom"></td>
			</tr>
		</table>
</div>


<%Contenido.setServletContext(getServletConfig().getServletContext());%>
<%session.setAttribute("RESPETAR_MODO", Convert.toString(Convert.toBoolean(request.getParameter("RESPETAR_MODO"), true)));%>