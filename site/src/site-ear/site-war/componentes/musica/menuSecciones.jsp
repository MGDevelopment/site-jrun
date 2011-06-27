<%@ page import="com.tmk.kernel.Globals"%>

<script type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
  var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
  if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}


function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>

<tr>
	<td colspan="2">
		<div id="Spanel"><!-- abro el panel de secciones !-->
		<div id="Smiscelanea"><img src="/imagenes/musica/b-miscelanea.gif" width="159" height="40"></div>
		<div id="Slibros">
        <a href="/<%=Globals.seccion(Globals.SECCION_LIBRO) %>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Libros','','/imagenes/musica/b-libros-over.gif',1)"><img src="/imagenes/musica/b-libros.gif" name="Image7" width="68" height="40" border="0" id="Libros" /></a>
        </div>
		
        <div id="Smusica">
        <img src="/imagenes/musica/b-musica.gif" name="M&uacute;sica" width="102" height="40" border="0" id="M&uacute;sica">      
        </div>
        
		<div id="Spasatiempos">
        <a href="/<%=Globals.seccion(Globals.SECCION_JUGUETES) %>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Pasatiempos','','/imagenes/musica/b-pasatiempos-over.gif',1)"><img src="/imagenes/musica/b-pasatiempos.gif" name="Pasatiempos" width="127" height="40" border="0" id="Pasatiempos" /></a> 
        </div>
        
		<div id="SPeliculas">
        <a href="/<%=Globals.seccion(Globals.SECCION_PELICULA) %>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Pel&iacute;culas','','/imagenes/musica/b-peliculas-over.gif',1)"><img src="/imagenes/musica/b-peliculas.gif" name="Pel&iacute;culas" width="152" height="40" border="0" id="Pel&iacute;culas" /></a>
        </div>
		
        
        <div id="SExtra">
        <a href="/fidelizacion/panel/puntos.jsp"><img src="/imagenes/musica/b-extra.gif" alt="eXtra!" border="0"></a>
        </div>
        
		</div><!-- cierro el panel de secciones !-->
		
		<!-- abro el panel de secciones !-->
		<!-- div id="Spanel">
		   <div id="Smiscelanea"><img src="/imagenes/musica/b-miscelanea.gif" width="147" height="39" /></div>
		   <div id="Stematika"><a href="/<%=Globals.seccion(Globals.SECCION_HOME)%>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('tmk','','/imagenes/musica/b-tmtk-over.gif',1)"><img src="/imagenes/musica/b-tmtk.gif" alt="Tematika - Volver a la home"  border="0" id="tmk"/></a></div>
		   <div id="Slibros"><a href="/<%=Globals.seccion(Globals.SECCION_LIBRO) %>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Libros','','/imagenes/musica/b-libros-over.gif',1)"><img src="/imagenes/musica/b-libros.gif" alt="Libros" name="Libros" width="60" height="39" border="0" id="Libros" /></a></div>
		   <div id="Smusica"><a href="/<%=Globals.seccion(Globals.SECCION_MUSICA)%>"><img src="/imagenes/musica/b-musica.gif" alt="M&uacute;sica" name="M&uacute;sica" width="94" height="39" border="0" id="M&uacute;sica" /></a></div>
		   <div id="Spasatiempos"><a href="/<%=Globals.seccion(Globals.SECCION_JUGUETES) %>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Pasatiempos','','/imagenes/musica/b-pasatiempos-over.gif',1)"><img src="/imagenes/musica/b-pasatiempos.gif" alt="Pasatiempos" name="Pasatiempos" width="117" height="39" border="0" id="Pasatiempos" /></a></div>
		   <div id="SPeliculas"><a href="/<%=Globals.seccion(Globals.SECCION_PELICULA) %>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Pel&iacute;culas','','/imagenes/musica/b-peliculas-over.gif',1)"><img src="/imagenes/musica/b-peliculas.gif" alt="Pel&iacute;culas" name="Pel&iacute;culas" width="134" height="39" border="0" id="Pel&iacute;culas" /></a></div>
		   <div id="Shojal"><img src="/imagenes/musica/b-hojal.gif" width="57" height="38" /></div>
		</div-->
	</td>
</tr>
