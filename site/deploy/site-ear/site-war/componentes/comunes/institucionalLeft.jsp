<%@ page import="com.tmk.kernel.Globals,				 
				 com.tmk.kernel.Convert"%>

<%
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_HOME);
%>

<td>
	<table width="130" border="0" cellpadding="0" cellspacing="0" class="tablaaccesos" align="left">
    	<tr>
        	<td><table width="130" border="0" cellspacing="0" cellpadding="0">
                	<tr>
                    	<td><div align="left"><a href="/institucional/verEventos.jsp"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-eventos.gif" alt="Eventos" border="0" /></a></div></td>
                    </tr>
                    <tr>
                        <td><div align="left"><a href="/afiliados"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-asociados.gif" alt="Asociados web"  border="0" class="accesos02" /></a></div></td>
                    </tr>
                    <tr>
                        <td><div align="left"><a href="/referido"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-referidos.gif" alt="Referidos" border="0" class="accesos02" /></a></div></td>
                    </tr>
                    <tr>
                       <td><div align="left"><a href="/institucional/servicios.jsp"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-serviciosclientes.gif" alt="Servicios al cliente"  border="0" class="accesos02" /></a></div></td>
                    </tr>
                 </table></td>
          </tr>
	</table>
</td>