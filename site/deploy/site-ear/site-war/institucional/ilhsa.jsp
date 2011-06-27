<%@ page import="com.tmk.kernel.Globals"%>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Grupo ILHSA</title>
<script type="text/JavaScript">
<!--



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
</script>
<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
<link href="/estilos/seccion_inicio.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0" class="Gtablaprincipal">
  <tr>
    <td><table width="720" border="0" cellspacing="0" cellpadding="0">

      <tr>
        <td width="183" valign="middle"><div align="left"><img src="/imagenes/logo-ilhsa.jpg" alt="Ilhsa" width="120" height="67" border="0" /></div></td>
        <td width="557" valign="middle">       
         <!-- Login -->
        	<%
	       	String loginPage = "/componentes/comunes/login.jsp?idSeccion=" + Globals.SECCION_HOME;
    	   	%>
       		<jsp:include page="<%=loginPage%>"/>
	    <!-- Login -->
		</td>
      </tr>
      <tr>
        <td colspan="2">
		<div id="IinstBorder2"><span style="font-size:1px">&nbsp;</span></div>		</td>
      </tr>
      <tr>
        <td colspan="2"><img src="/imagenes/inicio/header-ilhsa.jpg" width="720" height="52" style="margin-top:15px; margin-bottom:15px"></td>
      </tr>
      <tr>
        <td colspan="2"><table width="720" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="146" class="Gbarraizquierda" align="left"><table width="130" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><div class="GdivSubcatTit"><span class="FTtit01">MARCAS ILHSA</span></div>
                    <div id="GdivSubcatSub"><a href="/inicio" class="FSubCategoriasIzq">Tematika.com </a></div>
                    <div id="GdivSubcatSub"><a href="/institucional/sucursales.jsp?sucursal=30&unegocio=yenny" class="FSubCategoriasIzq">Yenny</a></div>
                    <div id="GdivSubcatSub"><a href="/institucional/sucursales.jsp?sucursal=205&unegocio=ateneo" class="FSubCategoriasIzq">El Ateneo</a></div>
                    <div class="GdivSubcatTit2"><span class="FTtit01">GRUPO ilhsa</span></div>
                    <div id="GdivSubcatSub"><a href="/institucional/clientesInstitucionales.jsp" class="FSubCategoriasIzq">Ventas corporativas </a></div>
                    <div id="GdivSubcatSub"><a href="/institucional/prensa.jsp?page=/asociadas/prensa/prensa1.htm" class="FSubCategoriasIzq">Prensa </a></div>
                    <div id="GdivSubcatSub"><a href="/empleos" class="FSubCategoriasIzq">Empleo </a></div>                    
                </td>
              </tr>
            </table></td>
            <td width="574" valign="top" class="InstIlhsaContent"><p class="Ftexto06"><strong>NUESTRA VISION </strong><br />
  Tematika.com es la librer&iacute;a online l&iacute;der en el mercado hispano parlante, posee la mayor base de datos de libros en lengua espa&ntilde;ola y sirve a miles de clientes en los cinco continentes. Su estrategia se apoya en tres pilares principales: el marketing uno a uno, la excelencia en la atenci&oacute;n al cliente, y el aprovechamiento de todos los canales de distribuci&oacute;n del Grupo ILHSA. </p>

              <p class="Ftexto06"><strong>PERFIL DE LA COMPA&Ntilde;IA </strong><br />
  Tematika.com, con m&aacute;s de doscientos mil t&iacute;tulos disponibles en su sitio, y miles de clientes en 60 pa&iacute;ses, se ha convertido en la mayor librer&iacute;a virtual de la lengua hispana y por pertenecer al Grupo l&iacute;der en la venta del libro en la Argentina, ha podido aplicar, a diferencia de muchas empresas de internet, un modelo de negocios exitoso y escalable. Asimismo tiene en vigencia acuerdos de exclusividad como sponsors a Intermanagers para el &aacute;rea tem&aacute;tica Negocios, Util&iacute;sima Satelital para el &aacute;rea tem&aacute;tica Mujer, Fisher Price para el &aacute;rea tem&aacute;tica de Chicos, Grupo Editorial Sudamericana para Novelas y Users para el &aacute;rea tem&aacute;tica de Tecnolog&iacute;a.<br />

  Tematika ha desarrollado un modelo de librer&iacute;a online diferente, basado en la segmentaci&oacute;n de la demanda y no de la oferta. Para eso ofrece &aacute;reas tem&aacute;ticas donde se nuclean comunidades de intereses afines, y se dise&ntilde;an recorridos de lectura que han tenido excelentes respuestas entre sus clientes.<br />
  Tematika.com es el sitio de referencia obligado para quienes buscan tanto el &uacute;ltimo bestseller como un libro t&eacute;cnico o dif&iacute;cil de conseguir. Para ayudar a nuestros clientes a focalizar sus b&uacute;squedas mostramos rese&ntilde;as, notas period&iacute;sticas, primeros cap&iacute;tulos, sinopsis de miles de libros junto con recomendaciones de nuestros editores y de nuestra comunidad de lectores.</p>

              <p class="Ftexto06"><strong>MANAGEMENT DEL GRUPO ILHSA </strong><br />
  Nuestro Management cuenta con un amplio conocimiento en Negocios, Servicios y Comercio Electr&oacute;nico.<br />
                Se ha desenvuelto en empresas de primer nivel internacional como Carrefour, Liberty Group, Citibank, ABN Amro, y Nestle.</p></td>
          </tr>
        </table></td>
      </tr>
      <tr>

        <td colspan="2"><div id="IinstBorderBottom"><span style="font-size:1px">&nbsp;</span></div></td>
      </tr>
      <tr>
        <td colspan="2"><table width="720" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" dwcopytype="CopyTableRow">
          <tr>
            <td colspan="3"><div align="center">
                 <%String institucionalPage = "/componentes/comunes/institucionalReducido.jsp"; %>
                <jsp:include page="<%=institucionalPage%>" />
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

