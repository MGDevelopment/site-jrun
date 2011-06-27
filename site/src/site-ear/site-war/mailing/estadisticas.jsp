<%@ page import="com.tmk.service.orden.OrdenService,
                 com.tmk.controllers.alianza.EstadisticaVisitas,
                 com.tmk.kernel.*,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.site.Paginas,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.controllers.carrito.*,
                 com.tmk.controllers.registracion.*,
                 com.tmk.controllers.buscador.BusquedaGenerica,
                 com.tmk.controllers.fidelizacion.*,
                 java.util.Hashtable,
                 java.util.Enumeration,
                 com.tmk.setup.ImageServer,
                 java.util.Date,
                 com.tmk.fidelizacion.FidelizacionHelper,
                 com.tmk.controllers.referido.ReferidoManager,
                 com.tmk.controllers.buscador.InfoBuscador"%>
<table width="500">
	<tr>
		<td>
			<b>Estadísticas temporales</b><br>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Modo de Funcionamiento</i></td>
					<td align="center"><%=Convert.toString(Globals.MODO_ACTUAL.toString()).toUpperCase()%> - <%= Globals.VERSION.replaceFirst("Revision:", "").replaceAll("$", "") %></td>
				</tr>
				<tr>
					<td><i>Fecha actual</i></td>
					<td align="center"><%=Convert.toStringLargo(new Date())%></td>
				</tr>
				<tr>
					<td><i>Fecha de inicio del server</i></td>
					<td align="center"><%=Convert.toStringLargo(Globals.FECHA_INICIO)%></td>
				</tr>
				<tr>
					<td><i>Fecha de modificación de contenido</i></td>
					<td align="center"><%=Convert.toStringLargo(Contenido.getXmlLoader().getXMLFileDate())%></td>
				</tr>
				<tr>
					<td><i>Fecha de modificación de la configuración</i></td>
					<td align="center"><%=Convert.toStringLargo(Globals.getXmlLoader().getXMLFileDate())%></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Visitas</i></td>
					<td align="right"><%=Convert.toString(EstadisticaVisitas.getCantidadDeVisitas())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Visitas "google"</i></td>
					<td align="right"><%=Convert.toString(EstadisticaVisitas.getCantidadDeVisitasGoogle())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Visitas "yahoo"</i></td>
					<td align="right"><%=Convert.toString(EstadisticaVisitas.getCantidadDeVisitasYahoo())%></td>
				</tr>


				<tr>
					<td><i>Hits</i></td>
					<td align="right"><%=Convert.toString(EstadisticaVisitas.getCantidadDeHits())%></td>
				</tr>
				<%  int hits[] = Contenido.getInstance().getHitsPorPagina();
					Paginas paginas = Contenido.getSite().getPaginas();
					for (int i = 0; i < paginas.getPaginaCount(); i++) {
				%>
				<tr>
					<td><i>Hits en <%=Convert.capitalizar(Globals.seccion(paginas.getPagina(i).getId()), false)%></i></td>
					<td align="right"><%=Convert.toString(hits[i])%></td>
				</tr>
				<%}%>
				<tr>
					<td><i>Hits en Papeles y Notas</i></td>
					<td align="right"></b><%=Convert.toString(CompraHelper.visitasDePaginaPapeles)%></i></td>
				</tr>
				<tr>
					<td><i>Hits en Domicilio de Envio</i></td>
					<td align="right"></b><%=Convert.toString(CompraHelper.visitasDePaginaDomicilioDeEnvio)%></i></td>
				</tr>
				<tr>
					<td><i>Hits en Domicilio de Facturacion</i></td>
					<td align="right"></b><%=Convert.toString(CompraHelper.visitasDePaginaDomicilioDeFacturacion)%></i></td>
				</tr>
				<tr>
					<td><i>Hits en Forma de Pago</i></td>
					<td align="right"></b><%=Convert.toString(CompraHelper.visitasDePaginaFormaDePago)%></i></td>
				</tr>
				<tr>
					<td><i>Hits en Confirmación</i></td>
					<td align="right"></b><%=Convert.toString(CompraHelper.visitasDePaginaConfirmacion)%></i></td>
				</tr>
				<tr>
					<td><i>Hits en Índice de Contenidos</i></td>
					<td align="right"></b><%=Convert.toString(EstadisticaVisitas.getAccesoAIndice())%></i></td>
				</tr>
				<tr>
					<td><i>Hits en Biografías</i></td>
					<td align="right"></b><%=Convert.toString(EstadisticaVisitas.getAccesoABiografia())%></i></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Ordenes generadas</i></td>
					<td align="right"><%=Convert.toString(OrdenService.cantidadOrdenesGeneradas())%></td>
				</tr>
				<tr>
					<td><i>Ordenes no autorizadas</i></td>
					<td align="right"><%=Convert.toString(OrdenService.cantidadOrdenesDesaprobadas())%></td>
				</tr>
				<tr>
					<td><i>Ordenes con fallo</i></td>
					<td align="right"><%=Convert.toString(OrdenService.cantidadOrdenesAbortadas())%></td>
				</tr>
				<tr>
					<td><i>Ordenes en proceso de confirmación</i></td>
					<td align="right"></b><%=Convert.toString(OrdenService.cantidadEnProcesoDeConfirmacion())%></i></td>
				</tr>
				<tr>
					<td><i>Ordenes en proceso de autorización</i></td>
					<td align="right"></b><%=Convert.toString(OrdenService.cantidadEnProcesoDeAutorizacion())%></i></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Sesiones abiertas</i></td>
					<td align="right"><%=Convert.toString(IniciarSesion.getCantidadSesionesAbiertas())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Sesiones abiertas "google"</i></td>
					<td align="right"><%=Convert.toString(IniciarSesion.getCantidadSesionesAbiertasGoogle())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Sesiones abiertas "yahoo"</i></td>
					<td align="right"><%=Convert.toString(IniciarSesion.getCantidadSesionesAbiertasYahoo())%></td>
				</tr>

				<tr>
					<td colspan="2"><i>Palabras Clave de Búsqueda</i>
						<table width="90%" align="right" style="border: solid 1px ; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
							<tr>
								<td>
									<%=Convert.toString(IniciarSesion.getPalabrasClave())%>
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td><i>Sesiones cerradas</i></td>
					<td align="right"><%=Convert.toString(TerminarSesion.getCantidadSesionesCerradas())%></td>
				</tr>
				<tr>
					<td><i>Sesiones rechazadas</i></td>
					<td align="right"><%=Convert.toString(IniciarSesion.getCantidadSesionesRechazadas())%></td>
				</tr>
				<tr>
					<td><i>Passwords reinicializados</i></td>
					<td align="right"><%=Convert.toString(RecuperarClave.getCantidadPerdidaDePassword())%></td>
				</tr>
				<tr>
					<td><i>Usuarios nuevos</i></td>
					<td align="right"><%=Convert.toString(RegistrarSocioTMK.getCantidadDeSociosNuevos())%></td>
				</tr>
				<tr>
					<td><i>Usuarios nuevos "google"</i></td>
					<td align="right"><%=Convert.toString(RegistrarSocioTMK.getCantidadDeSociosNuevosGoogle())%></td>
				</tr>
				<tr>
					<td><i>Usuarios nuevos "yahoo"</i></td>
					<td align="right"><%=Convert.toString(RegistrarSocioTMK.getCantidadDeSociosNuevosYahoo())%></td>
				</tr>

				<tr>
					<td colspan="2"><i>Palabras Clave de Búsqueda</i>
						<table width="90%" align="right" style="border: solid 1px ; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
							<tr>
								<td>
									<%=Convert.toString(RegistrarSocioTMK.getPalabrasClave())%>
								</td>
							</tr>
						</table>
					</td>
				</tr>

			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Articulos agregados al carrito</i></td>
					<td align="right"><%=Convert.toString(AgregarProducto.getCantidadArticulosAgregados())%></td>
				</tr>
				<tr>
					<td><i>Articulos eliminados del carrito</i></td>
					<td align="right"><%=Convert.toString(EliminarProducto.getCantidadArticulosEliminados())%></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<%int totalDeBusquedas =  BusquedaGenerica.getTotalConsulta(-1);%>
				<tr>
					<td bgcolor="EEEEEE"><i>Cantidad de búsquedas</i></td>
					<td bgcolor="EEEEEE" align="right"></b><%=Convert.toString(totalDeBusquedas)%></i></td>
				</tr>
				<tr>
					<td bgcolor="DDEECC" width="70%"><i>Cantidad de búsquedas <%=InfoBuscador.getNombreDeValor(InfoBuscador.CONSULTAS_OK)%></i></td>
					<td bgcolor="DDEECC" align="right"></b><%=Convert.round(BusquedaGenerica.getTotalConsulta(InfoBuscador.CONSULTAS_OK)* 100.00 / totalDeBusquedas)%>%</i></td>
				</tr>
				<tr>
					<td bgcolor="FFFF99" width="70%"><i>Cantidad de búsquedas <%=InfoBuscador.getNombreDeValor(InfoBuscador.CONSULTAS_SIN_RESULTADO)%></i></td>
					<td bgcolor="FFFF99" align="right"></b><%=Convert.round(BusquedaGenerica.getTotalConsulta(InfoBuscador.CONSULTAS_SIN_RESULTADO)* 100.00 / totalDeBusquedas)%>%</i></td>
				</tr>
				<tr>
					<td bgcolor="FF9933" width="70%"><i>Cantidad de búsquedas <%=InfoBuscador.getNombreDeValor(InfoBuscador.CONSULTAS_TIMEOUT)%></i></td>
					<td bgcolor="FF9933" align="right"></b><%=Convert.round(BusquedaGenerica.getTotalConsulta(InfoBuscador.CONSULTAS_TIMEOUT)* 100.00 / totalDeBusquedas)%>%</i></td>
				</tr>
				<tr>
					<td bgcolor="FF6633" width="70%"><i>Cantidad de búsquedas <%=InfoBuscador.getNombreDeValor(InfoBuscador.CONSULTAS_ERROR)%></i></td>
					<td bgcolor="FF6633" align="right"></b><%=Convert.round(BusquedaGenerica.getTotalConsulta(InfoBuscador.CONSULTAS_ERROR)* 100.00 / totalDeBusquedas)%>%</i></td>
				</tr>
				<tr>
					<td><i>Busquedas 2da p&aacute;gina o mayor</i></td>
					<td align="right"></b><%=Convert.toString(BusquedaGenerica.getPaginaciones())%></i></td>
				</tr>
				<tr>
					<td><i>Cantidad de articulos mostrados</i></td>
					<td align="right"></b><%=Convert.toString(BusquedaGenerica.cantidadDeArticulosMostrados())%></i></td>
				</tr>
				<tr>
					<td><i>Cantidad de articulos encontrados</i></td>
					<td align="right"></b><%=Convert.toString(BusquedaGenerica.cantidadDeArticulosEncontrados())%></i></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<%
					Hashtable estadisticasDeBusqueda = BusquedaGenerica.getEstadisticasDeBusqueda();
					Enumeration keys = estadisticasDeBusqueda.keys();
					
					while (keys.hasMoreElements()) {
						Object nombre = keys.nextElement();
						//Integer valor = (Integer)estadisticasDeBusqueda.get(nombre);
						InfoBuscador infoBuscador = (InfoBuscador)estadisticasDeBusqueda.get(nombre);
				%>
				<% int totalXTipo =  infoBuscador.getTotal();%>
				<tr>
					<td bgcolor="EEEEEE" width="70%" valign="top"><i>Búsquedas por <%=nombre.toString().toUpperCase()%></i></td>
					<td bgcolor="EEEEEE" align="right"><%=totalXTipo%>
				</tr>					
				
					<% for (int i=0; i<infoBuscador.getTamanioRegistro(); i++) {%>
				<tr>
					<td width="70%" valign="top">&nbsp; &nbsp; &nbsp;<%=infoBuscador.getNombreDeValor(i)%></td>
					<td align="right"><%=Convert.round(infoBuscador.getCantidadConsulta(i)* 100.00 / totalXTipo)%>%</td>
				</tr>	
					<% } %>
				<%  } %>
			</table>
		</td>
	</tr>
	<!-- tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td>
						<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
						<tr>
							<td colspan="2">
								Porcentajes de Busquedas en segundos
							</td>
						</tr>
						<tr>
							<td width="70%" align="right">
								Segundos
							</td>
							<td align="right" >
								Porcentaje
							</td>
						</tr>
						<%
						/*int[] tiempos =  BusquedaGenerica.getTiempos(null);
						int[][] orden = new int[2][tiempos.length];
						
						for (int i=0; i<tiempos.length; i++) {
							orden[0][i] = i;
							orden[1][i] = tiempos[i];
						}
						int max;
						int aux1;
						int aux2;
						for (int i=0; i<orden[0].length-1; i++) {
							max = i;

							for (int j=i+1; j<orden[0].length; j++) {
								if (orden[1][j]>orden[1][max]) {
									max = j;
								}	
							}
							aux1 = orden [0][i];
							aux2 = orden [1][i];
							orden [0][i] = orden [0][max];
							orden [1][i] = orden [1][max];							
							orden [0][max] = aux1;
							orden [1][max] = aux2;							
						}
						
					
						for (int i=0; i<orden[0].length; i++) {
							if (orden[1][i]>0) {*/
						%>
							<tr>
								<td align="right">
									<%//=(orden[0][i]) + " y " + (orden[0][i] + 1)%>
								</td>
								<td  align="right">
									<%//=Convert.round((orden[1][i]*100.00/BusquedaGenerica.getTotalConsulta(InfoBuscador.CONSULTAS_OK)))%>%
								</td>
							</tr>	
							<%/*}
						}	*/
						%>
						<table>
					</td>
				</tr>
			</table>
		</td>
	</tr-->		
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Cantidad de Tapas Generadas</i></td>
					<td align="right"><%=Convert.toString(ImageServer.getCantidadDeTapasGeneradas())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Cantidad de Tapas Ya Generadas</i></td>
					<td align="right"><%=Convert.toString(ImageServer.getCantidadDeTapasYaGeneradas())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Cantidad de Tapas No disponibles</i></td>
					<td align="right"><%=Convert.toString(ImageServer.getCantidadDeTapasNoDisponibles())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Cantidad de Tapas Requeridas</i></td>
					<td align="right"><%=Convert.toString(ImageServer.getCantidadDeTapasPedidas())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Cantidad de Tapas Falladas</i></td>
					<td align="right"><%=Convert.toString(ImageServer.getCantidadDeTapasFalladas())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Cantidad de Tapas Eliminadas</i></td>
					<td align="right"><%=Convert.toString(ImageServer.getCantidadDeTapasEliminadas())%></td>
				</tr>
				<tr>
					<td width="70%"><i>Cantidad de Tapas en el directorio</i></td>
					<td align="right"><%=Convert.toString(ImageServer.getCantidadDeTapasValidas())%></td>
				</tr>
			</table>
		</td>
	</tr>
	<% if (Globals.FIDELIZACION_VIGENTE) { %>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Consulta de Puntos Correctas</i></td>
					<td align="right"><%=Convert.toString(FidelizacionHelper.getCantidadDeConsultasDePuntosCorrectas())%></td>
				</tr>
				<tr>
					<td><i>Consulta de Puntos No Disponibles</i></td>
					<td align="right"><%=Convert.toString(FidelizacionHelper.getCantidadDeConsultasDePuntosNoDisponibles())%></td>
				</tr>
				<tr>
					<td><i>Consulta de Puntos Sin Puntos Acumulados</i></td>
					<td align="right"><%=Convert.toString(FidelizacionHelper.getCantidadDeConsultasDePuntosSinPuntos())%></td>
				</tr>
				<tr>
					<td><i>Consulta de Puntos Cuentas No Habilitadas</i></td>
					<td align="right"><%=Convert.toString(FidelizacionHelper.getCantidadDeConsultasDePuntosNoHabilitadas())%></td>
				</tr>
				<tr>
					<td><i>Adhesiones</i></td>
					<td align="right"><%=Convert.toString(RegistrarSocioEXtra.cantidadDeFidelizaciones())%></td>
				</tr>
				<tr>
					<td><i>Adhesiones con Datos Complementarios</i></td>
					<td align="right"><%=Convert.toString(RegistrarSocioEXtra.cantidadDeDatosComplementarios())%></td>
				</tr>
				<tr>
					<td><i>Adhesiones Canceladas</i></td>
					<td align="right"><%=Convert.toString(RegistrarSocioEXtra.cantidadDeFidelizacionesFalladas())%></td>
				</tr>
			</table>
		</td>
	</tr>
	<% } %>
<% if (Globals.referidoHabilitado()) { %>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Referidos Generados</i></td>
					<td align="right"><%=Convert.toString(ReferidoManager.REFERIDOS_GENERADOS)%></td>
				</tr>
				<tr>
					<td><i>Referidos Reconocidos</i></td>
					<td align="right"><%=Convert.toString(ReferidoManager.REFERIDOS_RECONOCIDOS)%></td>
				</tr>
				<tr>
					<td><i>Refereidos Rechazados</i></td>
					<td align="right"><%=Convert.toString(ReferidoManager.REFERIDOS_RECONOCIDOS_SOCIOS_ANTERIORES)%></td>
				</tr>
				<tr>
					<td><i>Compras de Referidos/Aprobadas</i></td>
					<td align="right"><%=Convert.toString(ReferidoManager.REFERIDOS_COMPRA)%>/<%=Convert.toString(ReferidoManager.REFERIDOS_COMPRA_APROBADA)%></td>
				</tr>

				<tr>
					<td><i>Referentes Reconocidos</i></td>
					<td align="right"><%=Convert.toString(ReferidoManager.REFERENTES_RECONOCIDOS)%></td>
				</tr>
				<tr>
					<td><i>Compras de Referentes/Aprobadas</i></td>
					<td align="right"><%=Convert.toString(ReferidoManager.REFERENTES_COMPRA)%>/<%=Convert.toString(ReferidoManager.REFERENTES_COMPRA_APROBADA)%></td>
				</tr>
			</table>
		</td>
	</tr>
	<% } %>

	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Memoria Libre (alerta en <%=Convert.toString(Globals.MEMORIA_ALERTA)%> Kbs.)</i></td>
					<%if((Runtime.getRuntime().freeMemory()) / 1024 < 70 ) {
						TmkLogger.info("Queda menos de 70MB");
						System.gc();
					}
					%>
					<td align="right"><%=Convert.toString(Runtime.getRuntime().freeMemory() / 1024)%> Kbs.</td>
				</tr>
				<tr>
					<td><i>Memoria Total (limite en <%=Convert.toString(Globals.MEMORIA_MAXIMA)%> Kbs.)</i></td>
					<td align="right"><%=Convert.toString(Runtime.getRuntime().totalMemory() / 1024)%> Kbs.</td>
				</tr>
				<tr>
					<td><i>Memoria Reportada</i></td>
					<td align="right"><%=Convert.toString(Runtime.getRuntime().maxMemory() / 1024)%> Kbs.</td>
				</tr>
			</table>
		</td>
	</tr>
<table>
