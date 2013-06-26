<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/> 
<div class="globoArticuloLoad" id="loadArticulo" style="display:none;" ></div>
<div class="globoArticulo" style="display:none;" id="globo" onMouseOver="this.style.display=''; clearTimeout(tempo);" onmouseout="tempo=setTimeout('ocultarGlobo()',10);">
	<div id="globoArticuloTop" class="globoArticuloTop">
		<a id="linkDetalleImagen" href="">
			<img id="urlImagen"  class="globoArticuloTapa" />
		</a>
		<div class="globoArticuloInfo">
			<a id="artTitulo" href="#"></a>
			<div id="trAutor">
				<div id="autor" style="display:none;"></div>de 
				<a id="autorURLBusqueda" href="">
					<span id="artAutor"></span>
				</a>
			</div>
	<div id="calificacion" class="calificacionMod">
		<span>Calificaci&oacute;n:</span>
		<div class="calificacionStar"></div>
		<div class="calificacionStar"></div>
		<div class="calificacionStar"></div>
		<div class="calificacionStarDes"></div>
		<div class="calificacionStarDes"></div>
	</div>
<div id="trEditor"><span id="editor"></span>: <a href="" id="artEditor"></a></div>
<div id="trRanking">Ranking: <span id="artRanking"></span></div>
<div>Fecha de Publicaci&oacute;n: <span id="artPublicacion"></span></div>
<div>Idioma: <span id="artIdioma"></span></div>
<div id="trPagina"><span id="pagina"></span><span id="artPagina"></span></div><div id="trFormato">Formato: <span id="artFormato"></span></div><div id="trDisponibilidad">Disponibilidad: <span id="artDisponibilidad"></span> + <a href="javascript:mostrarDiv('tiempoEntrega');">Tiempo de Envío</a></div><div id="tiempoEntrega" style="display:none;"><b>Capital Federal:</b> 48 horas hábiles.<br><b>GBA:</b> 72 horas hábiles.<br><b>Interior del país:</b> 96 horas hábiles.<br><b>Resto del Mundo:</b> varía entre 72 a 96 horas hábiles dependiendo si se trata de una ciudad capital.<br>El horario de entrega para los pedidos dentro de Argentina es de Lunes a Viernes de 9 a 18hs. </div><div class="globoArticuloMasInfo"><a id="linkDetalleInfo" href="" class="globoArticuloMasInfo">+ info</a><span style="color:#bbb">|</span><a id="linkAgregarComentario" href="" class="globoArticuloMasInfo">agregar comentario</a></div>
</div></div>
<div id="globoArticuloBottom" class="globoArticuloBottom">
<div id="precioArticulo" class="globoArticuloPrecio"></div>
<table  border="0" cellspacing="0" cellpadding="0"><div id="trComprar"><a href="#" id="btnComprar"><div class="globoArticuloComprar"></div></a></div><div id="trPedir"><a href="#" id="btnPedir"><div class="globoArticuloPedir"></div></a></div></table> 
</div>
</div>
<%
try{
	//String url = "/GetMesaBySeccion.do?idSeccion="+idSeccion.toString();
	StringBuffer url = new StringBuffer("/contenidosEstaticos/articulos/mesa/listaY_MV_sec");
	url.append(idSeccion.toString());
	url.append("_pag1SEO.html");
	pageContext.include(url.toString());
	//System.out.print(url.toString());
}catch(Exception e){}
%>

<div class="tmtkMesaNovedades"  id="mesa">
<div class="tmtkMesa-back"><div class="tmtkMesaMenuMod"><div class="tmtkMesaMenuTit"></div>
<ul class="dropdown"><li class="diri"><span onclick="javascript:desplegarOpciones('orden');actualizarPaginacion(<%=idSeccion%>);" id="mostrarRanking"></span><ul id="orden" onmouseover="clearTimeout(tempo);" onmouseout="ocultarOpcionesT('orden');";></ul></li></ul>
<ul class="dropdown"><li class="diri"><span onclick="javascript:desplegarOpciones('filtro');actualizarPaginacion(<%=idSeccion%>);" id="mostrarTiempo"></span><ul id="filtro" onmouseover="clearTimeout(tempo);" onmouseout="ocultarOpcionesT('filtro');"></ul></li></ul>
</div><div class="tmtkMesa">
<table border="0" cellpadding="0" cellspacing="0"><tr><td>
<table  border="0" cellpadding="0" cellspacing="0"><tr><td>
<div class="disabledEfectCtrl" id="ctrlDisabled" style="font-family:'Tahoma'; text-align:center;vertical-align:middle; font-size: 30px;font-weight:bolder; ;">
</div>
</td></tr><tr style="display:none;"><td colspan="4" align="center">
<select id="orden" name="orden" onChange="cargarFiltro();"></select>
<select id="filtro" name="filtro" onChange="cambioDeFiltroOrden();"></select></td></tr>
<tr><td><div class="disabledEfect" id="cat<%=idSeccion%>Disabled"></div></td></tr><tr><td align="center" ><a id="anterior<%=idSeccion%>" onfocus="this.blur();" href="#"><div id="anterior<%=idSeccion%>DIV" class="mesaAnterior"></div></a>
<div id="cat<%=idSeccion%>" class="divMesa">
<%if (idSeccion.intValue() == Globals.SECCION_MUSICA) { %> 
<!-- Musica --> 
<table cellpadding="0" cellspacing="0" border="0">
<tr><td valign="top"><table cellpadding="0" cellspacing="0" border="0"> 
<tr>
<td valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
<img style="position:absolute;top:-308px;"  id="itm<%=idSeccion%>-so1" /></div>
<div class="arbolShadow">
<img style="position:absolute;top:-204px;"  id="itm<%=idSeccion%>-so7" />
</div>    
<div class="arbolShadow">
<img style="position:absolute;top:-100px;"  id="itm<%=idSeccion%>-so13" />
</div>
<div class="arbolShadow">
<a id="aitm<%=idSeccion%>-1" href="#">
	<img style="position:relative;top:0px;" src="/imagenes/blc_1.jpg" id="itm<%=idSeccion%>-1" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
</a>	
</div></div></td>
<td valign="middle"><div class="divMesaCont">	
<div class="arbolShadow">
<img style="position:absolute;top:-308px;"  id="itm<%=idSeccion%>-so2" /></div>
<div class="arbolShadow">
<img style="position:absolute;top:-204px;"  id="itm<%=idSeccion%>-so8" /></div>    
<div class="arbolShadow">
<img style="position:absolute;top:-100px;"  id="itm<%=idSeccion%>-so14" /></div>
<div class="arbolShadow">
<a id="aitm<%=idSeccion%>-2" href="#">
	<img style="position:relative;top:0px;" src="/imagenes/blc_1.jpg" id="itm<%=idSeccion%>-2" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
</a>
</div></div></td>  	
</tr>  	
<tr>  	
<td valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm<%=idSeccion%>-7" href="#">
	<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-7" width="100px" height="100px" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
</a>	
</div></div></td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm<%=idSeccion%>-8" href="#">
	<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-8" width="100px" height="100px" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
</a>
</div></div></td>
</tr>
<tr><td valign="middle"><div class="divMesaCont">    
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-13" href="#">
		<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-13"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>		
	</a>	
</div><div class="arbolShadow"><img style="position:absolute;top:523px;left:14px;"  id="itm<%=idSeccion%>-io13"  width="100px" height="100px"/></div><div class="arbolShadow"><img style="position:absolute;top:419px;left:14px;"  id="itm<%=idSeccion%>-io7"  width="100px" height="100px"/></div><div class="arbolShadow"><img style="position:absolute;top:315px;left:14px;"  id="itm<%=idSeccion%>-io1"  width="100px" height="100px" /></div></div></td> 
<td valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-14" href="#">
		<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-14"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div><div class="arbolShadow"><img style="position:absolute;top:523px;left:119px"  id="itm<%=idSeccion%>-io14"  width="100px" height="100px"/></div><div class="arbolShadow">
<img style="position:absolute;top:419px;left:119px;"  id="itm<%=idSeccion%>-io8"  width="100px" height="100px"/></div><div class="arbolShadow"><img style="position:absolute;top:315px;left:119px;"  id="itm<%=idSeccion%>-io2"  width="100px" height="100px" /></div></div></td>
</tr></table></td><td valign="top">
<table cellpadding="0" cellspacing="0" border="0">
<tr><td valign="middle"><div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-308px;"  id="itm<%=idSeccion%>-so3" /></div><div class="arbolShadow"><img style="position:absolute;top:-204px;"  id="itm<%=idSeccion%>-so9" /></div><div class="arbolShadow"><img style="position:absolute;top:-100px;"  id="itm<%=idSeccion%>-so15" /></div>
	<div class="arbolShadow">
		<a id="aitm<%=idSeccion%>-3" href="#">
			<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-3" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
		</a>
	</div></div></td><td valign="middle">
	<div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-308px;"  id="itm<%=idSeccion%>-so4" /></div><div class="arbolShadow"><img style="position:absolute;top:-204px;"  id="itm<%=idSeccion%>-so10" /></div><div class="arbolShadow"><img style="position:absolute;top:-100px;"  id="itm<%=idSeccion%>-so16" /></div>
	<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-4" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-4" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
	</div></div></td></tr>
<tr><td valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-9" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-9" width="100px" height="100px" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td><td valign="middle"><div class="divMesaCont"><div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-10" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-10" width="100px" height="100px" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td></tr>
<tr><td  valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm<%=idSeccion%>-15" href="#">
	<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-15"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
</a>
</div><div class="arbolShadow"><img style="position:absolute;top:523px;left:224px"  id="itm<%=idSeccion%>-io15"  width="100px" height="100px"/></div><div class="arbolShadow"><img style="position:absolute;top:419px;left:224px;"  id="itm<%=idSeccion%>-io9"  width="100px" height="100px"/></div>    <div class="arbolShadow"><img style="position:absolute;top:315px;left:224px;"  id="itm<%=idSeccion%>-io3"  width="100px" height="100px" /></div></div></td><td  valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-16" href="#">
		<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-16"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div><div class="arbolShadow"><img style="position:absolute;top:523px;left:329px"  id="itm<%=idSeccion%>-io16"  width="100px" height="100px"/></div><div class="arbolShadow"><img style="position:absolute;top:419px;left:329px;"  id="itm<%=idSeccion%>-io10"  width="100px" height="100px"/></div>    <div class="arbolShadow"><img style="position:absolute;top:315px;left:329px;"  id="itm<%=idSeccion%>-io4"  width="100px" height="100px" /></div></div></td>	</tr></table>    </td><td valign="top"><table cellpadding="0" cellspacing="0" border="0"><tr><td  valign="middle"><div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-308px;"  id="itm<%=idSeccion%>-so5" /></div><div class="arbolShadow"><img style="position:absolute;top:-204px;"  id="itm<%=idSeccion%>-so11" /></div>    <div class="arbolShadow"><img style="position:absolute;top:-100px;"  id="itm<%=idSeccion%>-so17" /></div> 	  
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-5" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-5"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td><td valign="middle"><div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-308px;"  id="itm<%=idSeccion%>-so6" /></div><div class="arbolShadow"><img style="position:absolute;top:-204px;"  id="itm<%=idSeccion%>-so12" /></div>    <div class="arbolShadow"><img style="position:absolute;top:-100px;"  id="itm<%=idSeccion%>-so18" /></div>
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-6" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-6" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td>
</tr><tr><td valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-1" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-11" width="100px" height="100px" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>	
</div></div></td><td valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-12" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-12" width="100px" height="100px" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>		
</div></div></td></tr><tr><td valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-17" href="#">
		<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-17"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div><div class="arbolShadow"><img style="position:absolute;top:523px;left:434px"  id="itm<%=idSeccion%>-io17"  width="100px" height="100px"/></div><div class="arbolShadow"><img style="position:absolute;top:419px;left:434px;"  id="itm<%=idSeccion%>-io11"  width="100px" height="100px"/></div>    <div class="arbolShadow"><img style="position:absolute;top:315px;left:434px;"  id="itm<%=idSeccion%>-io5"  width="100px" height="100px" /></div></div>    </td><td valign="middle" ><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-18" href="#">
		<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-18"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div><div class="arbolShadow"><img style="position:absolute;top:523px;left:540px"  id="itm<%=idSeccion%>-io18"  width="100px" height="100px"/></div><div class="arbolShadow"><img style="position:absolute;top:419px;left:540px;"  id="itm<%=idSeccion%>-io12"  width="100px" height="100px"/></div>    <div class="arbolShadow"><img style="position:absolute;top:315px;left:540px;"  id="itm<%=idSeccion%>-io6"  width="100px" height="100px" /></div></div></td>    </tr>	</table></td></tr></table>
<%} else { %>
<!-- resto de las categorias -->
<table cellpadding="0" cellspacing="0" border="0">
<tr><td valign="top"><table cellpadding="0" cellspacing="0" border="0">    <tr height="156px"> 	  <td valign="middle"><div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm<%=idSeccion%>-so1" /></div>    <div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm<%=idSeccion%>-so7" /></div>
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-1" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-1" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td><td valign="middle"><div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm<%=idSeccion%>-so2"  width="100px" height="150px" /></div>    <div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm<%=idSeccion%>-so8"  width="100px" height="150px" /></div>
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-2" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-2"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td></tr><tr height="156px"><td  valign="middle"><div class="divMesaCont">    
	<div class="arbolShadow">
		<a id="aitm<%=idSeccion%>-7" href="#">
			<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-7"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
		</a>
	</div>
	<div class="arbolShadow"><img style="position:absolute;top:475px;left:14px;"  id="itm<%=idSeccion%>-io7"  width="100px" height="150px"/></div><div class="arbolShadow"><img style="position:absolute;top:315px;left:14px;"  id="itm<%=idSeccion%>-io1"  width="100px" height="150px" /></div></div></td>    <td valign="middle">
	<div class="divMesaCont">
	<div class="arbolShadow">
		<a id="aitm<%=idSeccion%>-8" href="#">
			<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-8"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
		</a>
	</div>
	<div class="arbolShadow"><img style="position:absolute;top:475px;left:119px;"  id="itm<%=idSeccion%>-io8"  width="100px" height="150px"/></div><div class="arbolShadow"><img style="position:absolute;top:315px;left:119px;"  id="itm<%=idSeccion%>-io2"  width="100px" height="150px" /></div></div></td></tr></table></td><td valign="top"><table cellpadding="0" cellspacing="0" border="0"><tr><td valign="middle"><div class="divMesaCont">    <div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm<%=idSeccion%>-so3" /></div><div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm<%=idSeccion%>-so9" /></div>
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-3" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-3" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td><td valign="middle"><div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm<%=idSeccion%>-so4" /></div><div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm<%=idSeccion%>-so10" /></div>
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-4" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-4" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td></tr><tr><td  valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-9" href="#">
		<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-9"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
	</div><div class="arbolShadow"><img style="position:absolute;top:475px;left:224px;"  id="itm<%=idSeccion%>-io9"  width="100px" height="150px"/></div><div class="arbolShadow"><img style="position:absolute;top:315px;left:224px;"  id="itm<%=idSeccion%>-io3"  width="100px" height="150px" /></div></div></td><td  valign="middle"><div class="divMesaCont">
	<div class="arbolShadow">
		<a id="aitm<%=idSeccion%>-10" href="#">
			<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-10"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
		</a>
	</div>
	<div class="arbolShadow">
		<img style="position:absolute;top:475px;left:329px;"  id="itm<%=idSeccion%>-io10"  width="100px" height="150px"/></div><div class="arbolShadow"><img style="position:absolute;top:315px;left:329px;"  id="itm<%=idSeccion%>-io4"  width="100px" height="150px" /></div></div></td>	</tr></table>    </td><td valign="top"><table cellpadding="0" cellspacing="0" border="0"><tr><td  valign="middle"><div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm<%=idSeccion%>-so5"  width="100px" height="150px" /></div><div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm<%=idSeccion%>-so11"  width="100px" height="150px" /></div> 	  
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-5" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-5"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td><td valign="middle"><div class="divMesaCont"><div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm<%=idSeccion%>-so6" /></div><div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm<%=idSeccion%>-so12" /></div>
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-6" href="#">
		<img style="position:relative;top:0px;" src="" id="itm<%=idSeccion%>-6" onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div></div></td>
</tr><tr height="156px"><td valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-11" href="#">
		<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-11"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div>
<div class="arbolShadow"><img style="position:absolute;top:475px;left:434px;"  id="itm<%=idSeccion%>-io11"  width="100px" height="150px"/></div><div class="arbolShadow"><img style="position:absolute;top:315px;left:434px;"  id="itm<%=idSeccion%>-io5"  width="100px" height="150px" /></div></div>    </td><td  valign="middle"><div class="divMesaCont">
<div class="arbolShadow">
	<a id="aitm<%=idSeccion%>-12" href="#">
		<img style="position:relative;top:0px" src="" id="itm<%=idSeccion%>-12"  onMouseOver="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150);" onMouseOut="javascript:enProgreso=false;"/>
	</a>
</div><div class="arbolShadow"><img style="position:absolute;top:475px;left:539px;"  id="itm<%=idSeccion%>-io12"  width="100px" height="150px"/></div><div class="arbolShadow"><img style="position:absolute;top:315px;left:539px;"  id="itm<%=idSeccion%>-io6"  width="100px" height="150px" /></div></div></td></tr></table></td></tr></table>
<%} %>
</div>
<a id="siguiente<%=idSeccion%>" onfocus="this.blur();" href="#">
<div id="siguiente<%=idSeccion%>DIV" class="mesaSiguiente"></div></a></td></tr></table></td></tr></table></div></div></div><!-- FIN mesa y títulos de secciones --><!-- div id="buchon"></div-->