<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.admin.AlianzaLocal,
				 com.tmk.admin.AlianzaLocalHome,
				 com.tmk.kernel.DBUtil" %>

<%	Integer idAlianza = new Integer(request.getParameter("ID_ALIANZA"));
	Integer idSeccion = new Integer(request.getParameter("ID_SECCION"));
	AlianzaLocalHome alianzaLocalHome = (AlianzaLocalHome) DBUtil.getHome("Alianza");
	AlianzaLocal alianzaLocal = alianzaLocalHome.findByPrimaryKey(idAlianza);
	String razonSocial = Convert.toString(alianzaLocal.getRAZON_SOCIAL());
%>

<b>
	Acaba de registrarse en el Programa de Afiliados de <%=Globals.NOMBRE_DEL_SITIO%>
</b>
<br>
Bienvenido <%= razonSocial %>
<br>
En nuestro sitio encontrará la oferta más amplia y variada de productos para publicar en su sitio.
<br>
<br>
Su número de alianza es: <b><%=Convert.toString(idAlianza)%></b><br>
Su número de sección genérica es: <b><%=Convert.toString(idSeccion)%></b><br><br>

<%String alianzaSeccion = "ID_ALIANZA=" + idAlianza + "&ID_SECCION=" + idSeccion;%>

Un ejemplo de link directo a nuestro sitio es:<br>
&nbsp;   <b><%=Globals.PAGINA_SITIO + "?" + alianzaSeccion%></b><br><br>

Un ejemplo de link a un producto de nuestro sitio es:<br>
&nbsp;   <b><%=Globals.PAGINA_SITIO + "/articulo/detalleArticulo.jsp?idArticulo=" + Globals.ARTICULO_DEFAULT + "&" + alianzaSeccion %></b><br>
(Es decir, agregando <b>&<%=alianzaSeccion%></b> a cualquier link de nuestro sitio)
<br>

<br>
<br>
CONSULTE EL MANUAL DE USO:
<br>

<a href="<%= Globals.PAGINA_SITIO %>/inicio/index.jsp?URL_GRUPO=/grupos/interior/manualafiliado.html">
	manual
</a>

<br><br>
Cualquier consulta usted tiene a su disposición un Departamento de Servicios al Afiliado, al cual se puede contactar a través de <a href="mailto:<%=Globals.MAIL_ALIANZAS%>"><%=Globals.MAIL_ALIANZAS%></a>.
<br>

<br><br>
<b>Muchas gracias por elegirnos.</b>
