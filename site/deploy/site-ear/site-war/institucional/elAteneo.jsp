<%@ page import="com.tmk.kernel.Globals"%>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>El Ateneo</title>
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
        <td width="183" valign="middle"><div align="left"><img src="/imagenes/logo-elateneo.gif" alt="El Ateneo" width="141" height="38" border="0" /></div></td>
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
		<div id="IinstBorder"><span style="font-size:1px">&nbsp;</span></div></td>
      </tr>
      <tr>
        <td colspan="2"><img src="/imagenes/inicio/micompra-elateneo.jpg" alt="Compra online" width="720" height="82" border="0" usemap="#Map0" class="Instimage">
          <map name="Map0" id="Map0">
            <area shape="rect" coords="493,1,721,33" href="/inicio" alt="Compra online" />
            <area shape="rect" coords="1,30,719,82" href="/inicio" alt="Compra online" />
          </map>
        </td>
      </tr>
      <tr>
        <td colspan="2"><img src="/imagenes/inicio/sucursales-elateneo.jpg" width="720" height="89" border="0" usemap="#Map1" class="InstimageBottom">
        <map name="Map1" id="Map1">
		<area shape="rect" coords="530,0,719,41" href="/institucional/sucursales.jsp?sucursal=205&unegocio=ateneo"  alt="Sucursales" /><area shape="rect" coords="1,37,719,88" href="/institucional/sucursales.jsp?sucursal=205&unegocio=ateneo" alt="Sucursales" />
</map>
        </td>
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
        </table>
          </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
