<%@ page import="com.tmk.kernel.Globals,				 
				 com.tmk.kernel.Convert"%>

<%
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_HOME);
%>

	<table width="155" border="0" cellpadding="0" cellspacing="0" class="modulosderecha">	
		<tr>
        	<td class="titulosceldas"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/t-sobretmtk.gif" alt="Sobre Tematika.com" width="116" height="12" /></td>
        </tr>
        <tr>
        	<td><div align="left"><a href="/<%=Globals.seccion(Globals.SECCION_HOME) %>"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-tematika.gif" alt="Tematika.com" width="58" height="10" border="0" class="accesostop" /></a></div></td>
        </tr>
        <tr>
        	<td><div align="left"><a href="/institucional/conozcanos.jsp"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-marcas.gif" alt="Marcas Grupo ILHSA" width="78" height="10" border="0" class="accesos02" /></a></div></td>
        </tr>
        <tr>
        	<td><div align="left"><a href="/institucional/sucursales.jsp?sucursal=205&unegocio=ateneo"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-sucursales.gif" alt="Sucursales" width="67" height="10" border="0" class="accesos02" /></a></div></td>
        </tr>
        <tr>
        	<td><div align="left"><a href="/institucional/prensa.jsp?page=/asociadas/prensa/prensa1.htm"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-prensa.gif" alt="Prensa" width="40" height="10" border="0" class="accesos02" /></a></div></td>
        </tr>
        <tr>
        	<td><div align="left"><a href="/empleos"><img src="/imagenes/<%=Globals.seccion(idSeccion) %>/b-empleo.gif" alt="Empleo" width="42" height="10" border="0" class="accesosbottom" /></a></div></td>
        </tr>
    </table>
