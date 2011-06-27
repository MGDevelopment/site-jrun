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
        <td colspan="2"><table width="738" border="0" cellpadding="0" cellspacing="0" class="botonera">
          <tr>
            <td><table width="705" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="79"><a href="/<%=Globals.seccion(Globals.SECCION_LIBRO)%>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Libros','','/imagenes/accesorios/b-libros-over.gif',1)"><img style="padding-right:1px" src="/imagenes/accesorios/b-libros.gif" alt="Libros" name="Libros" width="79" height="38" border="0" id="Libros" /></a></td>
                <td width="103"><div align="center"><a href="/<%=Globals.seccion(Globals.SECCION_JUGUETES)%>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Pasatiempos','','/imagenes/accesorios/b-pasatiempos-over.gif',1)"><img src="/imagenes/accesorios/b-juguetes.gif" alt="Pasatiempos" name="Pasatiempos" width="101" height="38" border="0" id="Pasatiempos" /></a></div></td>
                <td width="85"><div align="left"><a href="/<%=Globals.seccion(Globals.SECCION_MUSICA)%>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('M&uacute;sica','','/imagenes/accesorios/b-musica-over.gif',1)"><img src="/imagenes/accesorios/b-musica.gif" alt="M&uacute;sica" name="M&uacute;sica" width="84" height="38" border="0" id="M&uacute;sica" /></a></div></td>
                <td width="99"><a href="/<%=Globals.seccion(Globals.SECCION_INFORMATICA)%>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Inform&aacute;tica','','/imagenes/accesorios/b-informatica-over.gif',1)"><img src="/imagenes/accesorios/b-informatica.gif" alt="Inform&aacute;tica" name="Inform&aacute;tica" width="99" height="38" border="0" id="Inform&aacute;tica" /></a></td>
                <td width="118"><a href="/<%=Globals.seccion(Globals.SECCION_PELICULA)%>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image119','','/imagenes/accesorios/b-peliculas-over.gif',1)"><img src="/imagenes/accesorios/b-peliculas.gif" alt="Pel&iacute;culas" name="Image119" width="118" height="38" border="0" id="Image119" /></a></td>
                <td width="96"><a href="/<%=Globals.seccion(Globals.SECCION_ELECTRONICA)%>" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Electr&oacute;nica','','/imagenes/accesorios/b-electronica-over.gif',1)"><img src="/imagenes/accesorios/b-electronica.gif" alt="Electr&oacute;nica" name="Electr&oacute;nica" width="96" height="38" border="0" id="Electr&oacute;nica" /></a></td>
                <td width="125"><a href="/<%=Globals.seccion(Globals.SECCION_ACCESORIOS)%>"><img src="/imagenes/accesorios/b-accesorios.gif" alt="Accesorios" name="Accesorios" width="132" height="38" border="0" id="Accesorios" /></a></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>