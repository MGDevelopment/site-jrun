<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.fidelizacion.PuntajeWrapper,
                 com.tmk.kernel.Convert,
                 com.tmk.fidelizacion.VencimientoPuntos,
                 com.tmk.controllers.fidelizacion.ConsultaDePuntos,
                 java.util.Enumeration,
                 java.net.URLEncoder"%>
                
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">
<%
	StringBuffer nuevaPagina = new StringBuffer();
	Enumeration par = request.getParameterNames();
	for (int i = 0; par.hasMoreElements(); i++) {
		if (i > 0) nuevaPagina.append("&");
		String nombreParametro = par.nextElement().toString();
		String valorParametro = request.getParameter(nombreParametro);
		nuevaPagina.append(nombreParametro).append("=").append( URLEncoder.encode(valorParametro,"ISO-8859-1"));
	}

 
%>	
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<%= Globals.icon() %>
	<%= Globals.title("Tematika.com - eXtra") %>
	<%= Globals.keywords("tematika, eXtra, fidelización") %>

	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

	<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
	<link href="/estilos/extra.css" rel="stylesheet" type="text/css" />
	<link href="/estilos/seccion_inicio.css" rel="stylesheet" type="text/css" />

	<script src="/js/ajax.js" type="text/javascript"></script>
	<script src="/js/popUp.js" type="text/javascript"></script>
	<script src="/js/carrito.js" type="text/javascript"></script>
	<script src="/js/imagen.js" type="text/javascript"></script>
	<script src="/js/prototipe.js" type="text/javascript"></script>
	
	<script language="javascript">
	function desuscribir() {
		var par = '<%=nuevaPagina%>';
		var testFrame = document.createElement("IFRAME");
		testFrame.id = "testFrame";
		testFrame.src = "http://plataforma.emblue.com.ar/unsuscribe.asp?" + par;
		//testFrame.src = "http://tematika.emblue.com.ar/unsuscribe.asp?" + par;
		testFrame.style.display = 'none';
		document.body.appendChild(testFrame);
		handleWait(false); 	
		handleMsg('Desuscripción exitosa', 'success');	
		
	}
	

		

	function handleMsg(msg, tag) {
		$(tag).getElementsByTagName('div')[0].innerHTML = msg;
		$(tag).show();
	}
	
	/*
	function handleOK(responseText) {
		var msg='';
		if (!responseText.include("emBlue")) {
			msg='Error, vuelva a intentarlo en algunos minutos...'
			handleMsg(msg, 'error');		
		} else { 
			msg = responseText.substring(responseText.toUpperCase().indexOf("<H1>")+4, responseText.toUpperCase().indexOf("</H1>"));
			if (msg.include('Desuscripción exitosa')) {
				handleMsg(msg, 'success');		
			} else {
				handleMsg(msg, 'error');			
			}	
		}
	}*/

	
	
	</script>
	
</head>

<body onload="MM_preloadImages('/imagenes/inicio/b-libros-over.gif','/imagenes/inicio/b-musica-over.gif','/imagenes/inicio/b-pasatiempos-over.gif','/imagenes/inicio/b-peliculas-over.gif','/imagenes/fidelizacion/mnu1Over.gif','/imagenes/fidelizacion/mnu2Over.gif','/imagenes/fidelizacion/mnu3Over.gif','/imagenes/fidelizacion/mnu4Over.gif','/imagenes/fidelizacion/mnu5Over.gif','/imagenes/fidelizacion/mnu6Over.gif','/imagenes/fidelizacion/mnu7Over.gif','/imagenes/fidelizacion/mnu8Over.gif');desuscribir()">
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
					                      <td class="punteonargris">
						                      	<table width="100%" border="0" cellpadding="0" cellspacing="0">
						                          <tr> 
						                            <td><b>
						                            <table  class="fontautores" width="100%" bgcolor="EEEEEE" id="wait"><tr><td><div id="msg">Procesando...</div></td></tr></table>
						                            <table style="display:none" class="fontautores" width="100%" bgcolor="F8FFF8" id="success"><tr><td><div style="color:green" id="msg"></div></td></tr></table>
						                            <table style="display:none" class="fontautores" width="100%" bgcolor="FFF8F8" id="error"><tr><td><div style="color:red" id="msg"></div></td></tr></table>
						                            </b></td>
						                          </tr>
						                        </table>
				                     	 </td>
				                    	</tr>
				                  </table>		
				                </td>
                				<td width="165" valign="top" bgcolor="#E79A0B">
                				<!--LEFT-->
            	 				  <% String pageLeft = "/fidelizacion/panel/componentes/left.jsp";%>
								  <jsp:include page="<%=pageLeft%>"/>	
               					<!--LEFT-->   
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
<script>

	
	
	
		
	
</script>
<%=Globals.getGoogleAnalytics()%>
</body>
</html>		  