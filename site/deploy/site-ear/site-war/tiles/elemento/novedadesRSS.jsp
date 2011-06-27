<%@page import="com.tmk.kernel.Globals"%>

<table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>


							<div class="rssTitulo">¿Qu&eacute; es un RSS?</div><br style="font-size:5px">
							<div class="rssTexto">
								El RSS ("Really Simple Syndication") es un formato que permite emitir contenidos
								desde un sitio para que sean agregados facilmente en aplicaciones o sitios web.
							</div><br>
							<div class="rssTitulo">¿Ya arm&oacute; su sitio?</div><br style="font-size:5px">
							<div class="rssTexto">

								Tematika.com le ofrece las &uacute;ltimas novedades en materia de Libros, CDs, DVDs
								 y Pasatiempos para que pueda mantener actualizado su sitio.
							</div><br>
							<table width="98%" cellpadding="0" cellspacing="0" border="0">
								<tr valign="top">
									<td align="left" valign="top" width="40" style="font-size:5px;padding-top:2px">
										<a href="/rss/novedadesLibros.xml" target="_blank">
											<img src="/imagenes/xmlIcono.gif" border="0">
										</a>
									</td>
									<td align="left" class="rssLeyenda"><b>Ultimas Novedades y Lanzamientos de Libros</b><br>

										<a class="rssLeyenda" href="/rss/novedadesLibros.xml" target="_blank">http://www.tematika.com/rss/novedadesLibros.xml</a>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div style="border-bottom: solid 1px #CCC;font-size:1"></div>
									</td>
								</tr>

								<tr>
									<td colspan="2" style="font-size:5px">
										<br>
									</td>
								</tr>
								<tr>
									<td align="left" valign="top" width="40" style="font-size:5px;padding-top:2px">
										<a href="/rss/novedadesPeliculas.xml" target="_blank">
											<img src="/imagenes/xmlIcono.gif" border="0">

										</a>
									</td>
									<td align="left" class="rssLeyenda"> <b>Ultimos Lanzamientos en DVD</b>
										<a class="rssLeyenda" href="/rss/novedadesPeliculas.xml" target="_blank">http://www.tematika.com/rss/novedadesPeliculas.xml</a>
									</td>
								</tr>
								<tr>
									<td colspan="2">

										<div style="border-bottom: solid 1px #CCC;font-size:1"></div>
									</td>
								</tr>
								<tr>
									<td colspan="2" style="font-size:5px">
										<br>
									</td>
								</tr>
								<tr>

									<td align="left" valign="top" width="40" style="font-size:5px;padding-top:2px">
									<a href="/rss/novedadesMusica.xml" target="_blank">
										<img src="/imagenes/xmlIcono.gif" border="0">
									</a>
									</td>
									<td align="left" class="rssLeyenda"> <b>Ultimos Lanzamientos de CDs</b>
										<a class="rssLeyenda" href="/rss/novedadesMusica.xml" target="_blank">http://www.tematika.com/rss/novedadesMusica.xml</a>
									</td>

								</tr>
								<tr>
									<td colspan="2">
										<div style="border-bottom: solid 1px #CCC;font-size:1"></div>
									</td>
								</tr>
								<tr>
									<td colspan="2" style="font-size:5px">
										<br>

									</td>
								</tr>
								<tr>
									<td align="left" valign="top" width="40" style="font-size:5px;padding-top:2px">
										<a href="/rss/novedadesPasatiempos.xml" target="_blank">
											<img src="/imagenes/xmlIcono.gif" border="0">
										</a>
									</td>
									<td align="left" class="rssLeyenda"> <b>Novedades de Pasatiempos</b>
										<a class="rssLeyenda" href="/rss/novedadesPasatiempos.xml" target="_blank">http://www.tematika.com/rss/novedadesPasatiempos.xml</a>

									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div style="border-bottom: solid 1px #CCC;font-size:1"></div>
									</td>
								</tr>

							</table>
						</td>

					</tr>
					<tr>
						<td>
							<table width="95%" align="center">
								<tr>
									<td class="Ftexto02" >
										<b><br>
										Pertenec&eacute;s al programa de <span style="text-decoration:underline;">Asociados Web</span> de Tematika.com? Ingresa <a href="/extranet/rss" class="rssLeyenda">aquí</a> y descarga las novedades personalizadas para tu sitio.
										<p>Todavía no sos <span style="text-decoration:underline;">Asociado Web</span> de Tematika.com? Hace click <a href="/afiliados/afiliadoEstandar.jsp?page=/afiliados/verAcuerdo.jsp" class="rssLeyenda">aquí</a> y registrate!!
										</b>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>

<%if (Globals.esModoRelease()){ %>
<!-- Tag for Activity Group: Tematika website, Activity: Tematika Home -->

<!-- Start of DoubleClick Spotlight Tag: Please do not remove-->
<!-- Activity Name for this tag is:Tematika Home -->
<!-- Web site URL where tag should be placed: http://www.tematika.com -->
<!-- Creation Date:12/29/2006 -->
<SCRIPT language="JavaScript">
var axel = Math.random()+"";
var a = axel * 10000000000000;
document.write('<IMG SRC="http://ad.ar.doubleclick.net/activity;src=1364770;type=tematsit;cat=temath01;ord='+ a + '?" WIDTH=1 HEIGHT=1 BORDER=0>');
</SCRIPT>
<NOSCRIPT>
<IMG SRC="http://ad.ar.doubleclick.net/activity;src=1364770;type=tematsit;cat=temath01;ord=1?" WIDTH=1 HEIGHT=1 BORDER=0>
</NOSCRIPT>
<!-- End of DoubleClick Spotlight Tag: Please do not remove-->
<%} %>
<%=Globals.getGoogleAnalytics()%>
