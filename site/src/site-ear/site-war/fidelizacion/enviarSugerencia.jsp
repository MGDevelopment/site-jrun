<%@ page import="com.tmk.kernel.Globals,
 				 com.tmk.kernel.MailUtil,
 				 com.tmk.controllers.MainHelper,
 				 com.tmk.kernel.TmkLogger" %>
 				 

<%
String nombre = request.getParameter("nombre");
String correo = request.getParameter("correo");
String comentario = request.getParameter("comentario");
String mensaje = "";
try {
	MailUtil.sendMail(correo, "newsletter@ilhsa.com", "Buzon de sugerencias eXtra" ,
	"De: " + nombre + Globals.ENTER + Globals.ENTER 
	+ "Comentario: " + comentario);
	mensaje = nombre + ", tu comentario ha sido enviado con éxito. Muchas gracias!!";
} catch (Exception e) {
	mensaje = "Se ha producido un error al enviar el comentario, por favor intentalo más tarde.";
	TmkLogger.error("Buzon eXtra error:" + e.toString() + MainHelper.getMessage(e) );
}	
%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%= Globals.icon() %>
	<%= Globals.title("Tematika.com - eXtra - Consulta de Puntos") %>
	<%= Globals.keywords("tematika, eXtra, fidelización, beneficios, consulta, puntos") %>

	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

	<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
	<link href="/estilos/extra.css" rel="stylesheet" type="text/css" />
	<link href="/estilos/seccion_inicio.css" rel="stylesheet" type="text/css" />
	<link href="/estilos/news.css" rel="stylesheet" type="text/css" />
	
	<script src="/js/ajax.js" type="text/javascript"></script>
	<script src="/js/popUp.js" type="text/javascript"></script>
	<script src="/js/carrito.js" type="text/javascript"></script>
	<script src="/js/imagen.js" type="text/javascript"></script>
</head>

<body onload="MM_preloadImages('/imagenes/inicio/b-libros-over.gif','/imagenes/inicio/b-musica-over.gif','/imagenes/inicio/b-pasatiempos-over.gif','/imagenes/inicio/b-peliculas-over.gif','/imagenes/fidelizacion/mnu1Over.gif','/imagenes/fidelizacion/mnu2Over.gif','/imagenes/fidelizacion/mnu3Over.gif','/imagenes/fidelizacion/mnu4Over.gif','/imagenes/fidelizacion/mnu5Over.gif','/imagenes/fidelizacion/mnu6Over.gif','/imagenes/fidelizacion/mnu7Over.gif','/imagenes/fidelizacion/mnu8Over.gif');">
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0" class="Gtablaprincipal">
  <tr>
    <td><table width="740" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="740" valign="middle"><table border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="183">
             <!-- Logo -->
			        <%@include file="/componentes/comunes/logo.jsp"%>
		        <!-- Logo -->
			</td>
            <td width="557" align="right"><!-- Login -->
	        	<%
		       		String loginPage = "/componentes/comunes/login.jsp?idSeccion=" + Globals.SECCION_HOME;
	       		%>
		       	<jsp:include page="<%=loginPage%>"/>
    		    <!-- Login -->            
    		    </td>
          </tr>
        </table></td>
      </tr>

     <% String urlMenuSecciones = "/componentes/inicio/menuSecciones.jsp";%>
		    <jsp:include page="<%=urlMenuSecciones%>"/>  
      <tr>
        <td><div align="center">
          <table width="740" border="0" cellpadding="0" cellspacing="0" class="modulobuscadorcarrito">
            <tr>
              <td width="575"><jsp:include page="/componentes/inicio/buscador.jsp"/></td>
                <td width="165">
                    <!-- Carrito -->
            		<% String pageCarrito = "/componentes/comunes/carrito.jsp?idSeccion=" + Globals.SECCION_HOME;%>
					<jsp:include page="<%=pageCarrito%>"/>	
		          	<!-- Carrito -->
        	  	</td>                
              </tr>
          </table>
        </div></td>
      </tr>
      <tr>
        <td>
 
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr> 
    <td> 
    	<br>
    </td>
  </tr>  
  <tr> 
    <td> 
       <!-- Menu -->
 	   <% String pageMenu = "/fidelizacion/panel/componentes/menu.jsp";%>
	   <jsp:include page="<%=pageMenu%>"/>	
       <!-- Menu -->
     </td>
    </tr>
  <tr>   
    	<td>
        	<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
        		<tr> 
		          	<td>
		          		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			              	<tr>
            			    	<td valign="top">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
					                    <tr> 
					                      <td height="40"><div class="fondo2"><div align="left" class="titulo6">COMENTARIOS</div></div></td>
					                    </tr>
					                    <tr> 
					                      <td class="punteonargris">
					                      	<table width="100%" align="center" cellspacing="0" cellpadding="3" border="0">
												<tr>
													<td class="style6">
														<%=mensaje%>
													</td>
												</tr>
												<tr>
													<td align="right">
														<a class="arial12celeste" onclick="javascript:history.go(-2)" style="cursor:pointer;"><b>VOLVER</b></a>
													</td>
												</tr>
										</table>
				                      </td>
				                    </tr>
				                  </table>		
				                </td>
                				
					        </tr>
					        <tr> 
					          <td height="4"></td>
					        </tr>
					        <tr> 
					          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
					              <tr> 
					                <td width="144" bgcolor="#00708B">&nbsp;</td>
					                <td bgcolor="#9C928D" align="left"><a href="#top"><img src="/imagenes/fidelizacion/marco_16.gif" width="101" height="22" border="0"></a></td>
					              </tr>
					            </table></td>
					        </tr>
     				 	</table>
     				</td>
				  </tr>
			</table>
          
		   <table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
	            <tr>
	              <td colspan="3"><div align="center">
	                   <%String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion="+ Globals.SECCION_HOME;%>
				 	  <jsp:include page="<%=urlInstitucional%>"/>   
	              </div></td>
	            </tr>
          </table>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
<%=Globals.getGoogleAnalytics()%>
</body>
</html>		  
