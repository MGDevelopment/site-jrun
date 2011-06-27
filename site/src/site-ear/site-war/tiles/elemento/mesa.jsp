<div class="globoArticuloLoad" id="loadArticulo" style="display:none;" >cargando</div>
<div class="globoArticulo" style="display:none;" id="globo" onmouseover="this.style.display=''; clearTimeout(tempo);" onmouseout="tempo=setTimeout('ocultarGlobo();',10);">
<div id="globoArticuloTop" class="globoArticuloTop">
<a id="linkDetalleImagen" href=""><img id="urlImagen" class="globoArticuloTapa" src="" alt=""/></a>
<div class="globoArticuloInfo">
<a id="artTitulo" href="#"></a>
<div id="trAutor">
<div id="autor" style="display:none;"></div>de<a id="autorURLBusqueda" href=""><span id="artAutor"></span></a>
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
<div id="trPagina"><span id="pagina"></span> <span id="artPagina"></span></div>
<div id="trFormato">Formato: <span id="artFormato"></span></div>
<div id="trDisponibilidad">Entrega: <span id="artDisponibilidad"></span> + <a href="javascript:mostrarDiv('tiempoEntrega');">Tiempo de Envío</a></div>
<div id="tiempoEntrega" style="display:none;"><b>Capital Federal:</b> 48 horas hábiles.<br/>
<b>GBA:</b> 72 horas hábiles.<br/>
<b>Interior del país:</b> 96 horas hábiles.<br/>
<b>Resto del Mundo:</b> varía entre 72 a 96 horas hábiles dependiendo si se trata de una ciudad capital.<br/>
El horario de entrega para los pedidos dentro de Argentina es de Lunes a Viernes de 9 a 18hs.
</div>
<div class="globoArticuloMasInfo">
<a id="linkDetalleInfo" href="" class="globoArticuloMasInfo">+ info</a> <span style="color:#bbb">|</span> <a id="linkAgregarComentario" href="" class="globoArticuloMasInfo">agregar comentario</a>
</div>
</div>
</div>
<div id="globoArticuloBottom" class="globoArticuloBottom">
<div id="precioArticulo" class="globoArticuloPrecio"></div>
<%--<div id="precioArticuloDolar" class="globoArticuloPrecio"></div>
<div id="precioArticuloEuro" class="globoArticuloPrecio"></div>--%>
<table  border="0" cellspacing="0" cellpadding="0" onmouseover="this.style.display=''" onmouseout="ocultarGlobo()">
	<tbody><tr><td>
		<div id="trComprar">
		<a href="#" id="btnComprar"><object><div class="globoArticuloComprar"></div></object></a>
		</div>
		<div id="trPedir">
		<a href="#" id="btnPedir"><object><div class="globoArticuloPedir"></div></object></a>
		</div>
	</td></tr></tbody>
</table>
</div>
</div>
<div class="tmtkMesaNovedades" id="mesa"><!-- mesa y títulos de secciones -->
<a href="/libros" class="tmtkMesaSeccionesTit" title="Libros" onmouseover="javascript:mostrarDiv('tmtkMesaSeccionesTitLibros');" onmouseout="javascript:mostrarDiv('tmtkMesaSeccionesTitLibros');"><object><div id="tmtkMesaSeccionesTitLibros" style="display:none;"></div></object></a>
<a href="/musica" class="tmtkMesaSeccionesTit" title="Msica" onmouseover="javascript:mostrarDiv('tmtkMesaSeccionesTitMusica');" onmouseout="javascript:mostrarDiv('tmtkMesaSeccionesTitMusica');"><object><div id="tmtkMesaSeccionesTitMusica" style="display:none;"></div></object></a>
<a href="/peliculas" class="tmtkMesaSeccionesTit" title="Pelculas" onmouseover="javascript:mostrarDiv('tmtkMesaSeccionesTitPeliculas');" onmouseout="javascript:mostrarDiv('tmtkMesaSeccionesTitPeliculas');"><object><div id="tmtkMesaSeccionesTitPeliculas" style="display:none;"></div></object></a>
<a href="/juguetes" class="tmtkMesaSeccionesTit" title="Pasatiempos" onmouseover="javascript:mostrarDiv('tmtkMesaSeccionesTitPasatiempos');" onmouseout="javascript:mostrarDiv('tmtkMesaSeccionesTitPasatiempos');"><object><div id="tmtkMesaSeccionesTitPasatiempos" style="display:none;"></div></object></a>
<div class="tmtkMesa-back">
<div class="tmtkMesaMenuMod">
<div class="tmtkMesaMenuTit"></div>
<ul class="dropdown">
<li class="diri"><span onclick="javascript:desplegarOpciones('orden');actualizarPaginacion(0);" id="mostrarRanking"></span>
<ul id="orden" onmouseover="clearTimeout(tempo);" onmouseout="ocultarOpcionesT('orden');"><li></li></ul>
</li>
</ul>
<ul class="dropdown">
<li class="diri"><span onclick="javascript:desplegarOpciones('filtro');actualizarPaginacion(0);" id="mostrarTiempo"></span>
<ul id="filtro" onmouseover="clearTimeout(tempo);" onmouseout="ocultarOpcionesT('filtro')"><li></li></ul>
</li>
</ul>
</div>
<div class="tmtkMesa">
<table border="0" cellpadding="0" cellspacing="0">
<tr>
<td>
<table  border="0" cellpadding="0" cellspacing="0">
<tr>
<td>
<div class="disabledEfectCtrl" id="ctrlDisabled" style="font-family:'Tahoma'; text-align:center;vertical-align:middle; font-size: 30px;">                                        	
<br/><br/><br/>
<b>Cargando...</b>
</div>
</td>
</tr>
<tr style="display:none;">
<td colspan="4" align="center">
<!-- 
<select id="orden" name="orden" onChange="cargarFiltro()">
</select>
<select id="filtro" name="filtro" onChange="cambioDeFiltroOrden()">
</select>
 -->
</td>
</tr>
<tr>
<td>
<div class="disabledEfect" id="cat1Disabled"></div>
</td>
<td>
<div class="disabledEfect" id="cat4Disabled"></div>
</td>
<td>
<div class="disabledEfect" id="cat5Disabled"></div>
</td>
<td>
<div class="disabledEfect" id="cat3Disabled"></div>
</td>
</tr>
<tr>
<td align="center" >
<a id="anterior1" onfocus="this.blur()" href="#"><object><div id="anterior1DIV" class="mesaAnterior"></div></object></a>
<div id="cat1" class="divMesa">
<table cellpadding="0" cellspacing="0">
<tr style="height:156px">
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm1-so1" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm1-so3" src="" alt="" /></div>
<div class="arbolShadow">
<a id="aitm1-1" href="#">
<img style="position:relative;top:0px;" src="" id="itm1-1" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
</div>
</td>
<td  valign="middle">
<div class="divMesaCont">
<div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm1-so2"  width="100px" height="150px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm1-so4"  width="100px" height="150px" src="" alt=""/></div>
<div class="arbolShadow">
<a id="aitm1-2" href="#">
<img style="position:relative;top:0px;" src="" id="itm1-2"  onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
</div>
</td>
</tr>
<tr style="height:156px">
<td  valign="middle">
<div class="divMesaCont">
<!-- /imagenes/blc_1.jpg esto va en el src para que muestre la imagen cuadra blanca-->
<div class="arbolShadow">
<a id="aitm1-3" href="#">
<img style="position:relative;top:0px" src="" id="itm1-3"  onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
<div class="arbolShadow"><img style="position:absolute;top:475px;left:11px;"  id="itm1-io3"  width="100px" height="150px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:315px;left:11px;"  id="itm1-io1"  width="100px" height="150px" src="" alt="" /></div>
</div>
</td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm1-4" href="#">
<img style="position:relative;top:0px" src="" id="itm1-4"  onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
<div class="arbolShadow"><img style="position:absolute;top:475px;left:118px;"  id="itm1-io4"  width="100px" height="150px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:315px;left:118px;"  id="itm1-io2"  width="100px" height="150px" src="" alt="" /></div>
</div>
</td>
</tr>
</table>
</div>
<a id="siguiente1" onfocus="this.blur()" href="#"><object><div id="siguiente1DIV" class="mesaSiguiente"></div></object></a>
</td>
<td align="center">
<a id="anterior4" onfocus="this.blur()" href="#"><object><div id="anterior4DIV" class="mesaAnterior"></div></object></a>
<div id="cat4"  class="divMesa">
<table cellpadding="0" cellspacing="0">
<tr>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow"><img style="position:absolute;top:-308px;"  id="itm4-so1"  width="100px" height="100px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:-204px;"  id="itm4-so3"  width="100px" height="100px" src="" alt="" /></div>
<div class="arbolShadow"><img style="position:absolute;top:-100px;"  id="itm4-so5"  width="100px" height="100px" src="" alt="" /></div>
<div class="arbolShadow">
<a id="aitm4-1" href="#">
<img style="position:relative;top:0px;" src="" id="itm4-1" width="100px" height="100px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
</div>
</td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow"><img style="position:absolute;top:-308px;"  id="itm4-so2"  width="100px" height="100px" src="" alt="" /></div>
<div class="arbolShadow"><img style="position:absolute;top:-204px;"  id="itm4-so4"  width="100px" height="100px" src="" alt="" /></div>
<div class="arbolShadow"><img style="position:absolute;top:-100px;"  id="itm4-so6"  width="100px" height="100px" src="" alt="" /></div>
<div class="arbolShadow">
<a id="aitm4-2" href="#">
<img style="position:relative;top:0px;" src="" id="itm4-2" width="100px" height="100px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>																
</div>
</td>
</tr>
<tr>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm4-3" href="#">
<img style="position:relative;top:0px;" src="" id="itm4-3" width="100px" height="100px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>	
</div>
</div>
</td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm4-4" href="#">
<img style="position:relative;top:0px;" src="" id="itm4-4" width="100px" height="100px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
</div>
</td>
</tr>
<tr>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm4-5" href="#">
<img style="position:relative;top:0px;" src="" id="itm4-5" width="100px" height="100px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
<div class="arbolShadow"><img style="position:absolute;top:523px;left:11px;"  id="itm4-io5"  width="100px" height="100px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:419px;left:11px;"  id="itm4-io3"  width="100px" height="100px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:315px;left:11px;"  id="itm4-io1"  width="100px" height="100px" src="" alt="" /></div>
</div>
</td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm4-6" href="#">
<img style="position:relative;top:0px;" src="" id="itm4-6" width="100px" height="100px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+100)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>			                                                	
<div class="arbolShadow"><img style="position:absolute;top:523px;left:118px"  id="itm4-io6"  width="100px" height="100px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:419px;left:118px;"  id="itm4-io4"  width="100px" height="100px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:315px;left:118px;"  id="itm4-io2"  width="100px" height="100px" src="" alt="" /></div>
</div>
</td>
</tr>
</table>
</div>
<a id="siguiente4" onfocus="this.blur()" href="#"><object><div id="siguiente4DIV" class="mesaSiguiente"></div></object></a>
</td>
<td align="center">
<a id="anterior5" onfocus="this.blur()" href="#"><object><div id="anterior5DIV" class="mesaAnterior"></div></object></a>
<div id="cat5"  class="divMesa">
<table cellpadding="0" cellspacing="0">
<tr style="height:156px">
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm5-so1"  width="100px" height="150px" src="" alt="" /></div>
<div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm5-so3"  width="100px" height="150px" src="" alt="" /></div>
<div class="arbolShadow">
<a id="aitm5-1" href="#">
<img style="position:relative;top:0px;" src="" id="itm5-1" width="100px" height="150px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
</div>
</td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm5-so2"  width="100px" height="150px" src="" alt="" /></div>
<div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm5-so4"  width="100px" height="150px" src="" alt="" /></div>
<div class="arbolShadow">
<a id="aitm5-2" href="#">
<img style="position:relative;top:0px;" src="" id="itm5-2" width="100px" height="150px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
</div>
</td>
</tr>
<tr style="height:156px">
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm5-3" href="#">
<img style="position:relative;top:0px;" src="" id="itm5-3" width="100px" height="150px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt="" />
</a>
</div>
<div class="arbolShadow"><img style="position:absolute;top:475px;left:11px;"  id="itm5-io3"  width="100px" height="150px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:315px;left:11px;"  id="itm5-io1"  width="100px" height="150px" src="" alt="" /></div>
</div>
</td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm5-4" href="#">
<img style="position:relative;top:0px;" src="" id="itm5-4" width="100px" height="150px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt=""/>
</a>
</div>
<div class="arbolShadow"><img style="position:absolute;top:475px;left:118px;"  id="itm5-io4"  width="100px" height="150px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:315px;left:118px;"  id="itm5-io2"  width="100px" height="150px" src="" alt="" /></div>
</div>
</td>
</tr>
</table>
</div>
<a id="siguiente5" onfocus="this.blur()" href="#"><object><div id="siguiente5DIV" class="mesaSiguiente"></div></object></a>
</td>
<td align="center">
<a id="anterior3" onfocus="this.blur()" href="#"><object><div id="anterior3DIV" class="mesaAnterior"></div></object></a>
<div id="cat3" class="divMesa">
<table cellpadding="0" cellspacing="0">
<tr style="height:156px">
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm3-so1"  width="100px" height="150px" src="" alt="" /></div>
<div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm3-so3"  width="100px" height="150px" src="" alt="" /></div>
<div class="arbolShadow">
<a id="aitm3-1" href="#">
<img style="position:relative;top:0px;" src="" id="itm3-1" width="100px" height="150px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt=""/>
</a>
</div>
</div>
</td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow"><img style="position:absolute;top:-310px;"  id="itm3-so2"  width="100px" height="150px" src="" alt="" /></div>
<div class="arbolShadow"><img style="position:absolute;top:-155px;"  id="itm3-so4"  width="100px" height="150px" src="" alt="" /></div>
<div class="arbolShadow">
<a id="aitm3-2" href="#">
<img style="position:relative;top:0px;" src="" id="itm3-2" width="100px" height="150px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt=""/>
</a>
</div>
</div>
</td>
</tr>
<tr style="height:156px">
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm3-3" href="#">
<img style="position:relative;top:0px;" src="" id="itm3-3" width="100px" height="150px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt=""/>
</a>
</div>
<div class="arbolShadow"><img style="position:absolute;top:475px;left:11px;"  id="itm3-io3"  width="100px" height="150px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:315px;left:11px;"  id="itm3-io1"  width="100px" height="150px" src="" alt="" /></div>
</div>
</td>
<td valign="middle">
<div class="divMesaCont">
<div class="arbolShadow">
<a id="aitm3-4" href="#">
<img style="position:relative;top:0px;" src="" id="itm3-4" width="100px" height="150px" onmouseover="articuloPopUp(this.idArticulo, getX(this), getX(this)+100, getY(this), getY(this)+150)" onmouseout="javascript:enProgreso=false;" alt=""/>
</a>
</div>
<div class="arbolShadow"><img style="position:absolute;top:475px;left:118px;"  id="itm3-io4"  width="100px" height="150px" src="" alt=""/></div>
<div class="arbolShadow"><img style="position:absolute;top:315px;left:118px;"  id="itm3-io2"  width="100px" height="150px" src="" alt="" /></div>
</div>
</td>
</tr>
</table>
</div>
<a id="siguiente3" onfocus="this.blur()" href="#"><object><div id="siguiente3DIV" class="mesaSiguiente"></div></object></a>
</td>
</tr>
</table>
</td>
</tr>
</table>
</div>
</div>
</div><!-- FIN mesa y títulos de secciones -->
<%
	StringBuffer url = null;
	try {
		url = new StringBuffer("/contenidosEstaticos/articulos/mesa/listaY_MV_sec1_pag1SEO.html");
		pageContext.include(url.toString());
	}catch(Exception e){}
	try {
		url = new StringBuffer("/contenidosEstaticos/articulos/mesa/listaY_MV_sec4_pag1SEO.html");
		pageContext.include(url.toString());
	}catch(Exception e){}		
	try {
		url = new StringBuffer("/contenidosEstaticos/articulos/mesa/listaY_MV_sec5_pag1SEO.html");
		pageContext.include(url.toString());
	}catch(Exception e){}
	try {
		url = new StringBuffer("/contenidosEstaticos/articulos/mesa/listaY_MV_sec3_pag1SEO.html");
		pageContext.include(url.toString());
	}catch(Exception e){}	
%>