<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert"%>
<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0); 
%>
<table width="500" border="0" align="right" cellpadding="0" cellspacing="0">
<!-- Nombre de usuario -->
    <tr>
      <td>
      <div align="right" class="Glogin00">
      <a class="Flogin" href="/miCuenta" rel="nofollow">
      <% 
      if (session.getAttribute("Registracion.nombre") != null) {
    	   String nombre = Convert.toString(session.getAttribute("Registracion.nombre"), "");
      %>
      <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/hola.gif" width="30" height="8" border="0" class="espacioderecha" />
	      <%for (int i=0; i<nombre.length(); i++) { %>
	      	<%String letra =nombre.substring(i, i+1);%>
	      	<%if (letra.toUpperCase().equals("Ñ")) {
	      		letra = "enie";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Ç")) {
	      		letra = "0231";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Ä")) {
	      		letra = "0196";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Ë")) {
	      		letra = "0203";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Ï")) {
	      		letra = "0207";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Ö")) {
	      		letra = "0246";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Ü")) {
	      		letra = "0252";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Á")) {
	      		letra = "a";
	      	}%>
	      	<%if (letra.toUpperCase().equals("É")) {
	      		letra = "e";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Í")) {
	      		letra = "i";
	      	}%>
	      	<%if (letra.toUpperCase().equals("Ó")) {
	      		letra = "o";
	      	}%>	      	
	      	<%if (letra.toUpperCase().equals("Ú")) {
	      		letra = "u";
	      	}%>	      	
	      	<%if (" ".equals(letra)) { %>
		      	&nbps;
	      	<%} else { %>
		      	<img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/<%=letra%>.gif" border="0"/>
	  <%	  } 
	      }
	  %>
	  <img class="espacioizquierda" src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/miscelanea.gif" width="9" height="8" border="0" />
	  <%
      } else {
      %>
      <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/m.gif"  height="8" border="0"/><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/i.gif"  height="8" border="0" class="espacioderecha"/>
      <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/c.gif"  height="8" border="0"/> <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/u.gif"  height="8" border="0"/>
      <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/e.gif"  height="8" border="0"/><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/n.gif"  height="8" border="0"/>
      <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/t.gif"  height="8" border="0"/><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/a.gif"  height="8" border="0"/>
      <img class="espacioizquierda" src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/miscelanea.gif" width="9" height="8" border="0" />
      <% 
      } 
      %>
      </a></div>
      </td>
    </tr>
<!-- Nombre de usuario -->
<!-- Fidelizacion --> 
    <tr>
	    <td class="Glogin01">
     <%
	 Integer puntosFidelizacion = (Integer)session.getAttribute("PuntajeFidelizacion");
	 if (puntosFidelizacion != null) {
		 String strPuntosFidelizacion = Convert.toString(puntosFidelizacion, "");
	 %>   
	 	
    		<a class="Flogin" href="/fidelizacion/panel/puntos.jsp" rel="nofollow"><img class="espacioderecha" src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/tenes.gif" width="33" height="8" border="0" />
	 <%
	 	for (int i=0; i<strPuntosFidelizacion.length(); i++) {
	 %>	
		<img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/<%=strPuntosFidelizacion.substring(i, i+1)%>.gif"  height="8" border="0" />
	<%
	 	}
	%>
		<img class="espacioizquierda" src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/puntosextra.gif" width="79" height="8" border="0" /><img class="espacioizquierda" src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/miscelanea.gif" width="9" height="8" border="0" /></a>
    <%
	 } else {
    %>
   		<a class="Flogin" href="/fidelizacion/panel/puntos.jsp" rel="nofollow">
   		<img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/m.gif"  height="8" border="0" /><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/i.gif" height="8" border="0" />
   		<img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/s.gif"  height="8" border="0" />
   		<img class="espacioizquierda" src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/puntosextra.gif" width="79" height="8" border="0" /><img class="espacioizquierda" src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/miscelanea.gif" width="9" height="8" border="0" /></a>
    <%
	 }
    %>
	    </td>
    </tr>    
<!-- Fidelizacion -->        
    <tr>
      <td class="Glogin01"><a class="Flogin" href="/sucursales/?sucursal=205&unegocio=ateneo"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/sucursales.gif" width="64" height="8" border="0" /><img class="espacioizquierda" src="/imagenes/<%=Globals.seccion(idSeccion)%>/login/miscelanea.gif" width="9" height="8" border="0" /></a></td>
    </tr>
</table>