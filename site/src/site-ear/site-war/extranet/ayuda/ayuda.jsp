<%@ page import="com.tmk.kernel.Globals" %>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Extranet") %>
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>

	<body background="/imagenes/236-TMK/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<a name="Volver"></a>
		<table width="770" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" align="center" border="0">
		<tr align="center">
			<td valign="top">
				<table width="770" align="center" cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td>
						<jsp:include page="/extranet/comunes/header.jsp"/>
						<jsp:include page="/extranet/comunes/solapas.jsp"/>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>

		<table width="770" height="100%" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" align="center" border="0">
        <tr>
			<td valign="top">
				<table width="750" bgcolor="#FFFFFF" cellspacing="5" cellpadding="0" align="center" border="0">
				<tr>
					<td valign="top">
						<font class="TextoNegro">
							La extranet exclusiva para afiliados de Tematika se divide en dos &aacute;reas que son: AFILIADOS y REPORTES.<br>
							Cada una de ellas agrupa las funcionalidades que se detallan a continuaci&oacute;n:
						</font>
						<br><br><br>
					</td>
				</tr>

				<tr>
                    <td valing="top">
						<b>Manual</b>
					</td>
				</tr>
				<tr>
                    <td valing="top">
						<table bgcolor="#FFFFFF" cellspacing="15" cellpadding="0" align="left" border="0">
							<tr>
								<td>
									<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
									<a href="<%= Globals.PAGINA_SITIO %>/inicio/index.jsp?URL_GRUPO=/grupos/interior/manualafiliado.html" target="_blank"> Manual de uso</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
                    <td valing="top">
						<b>Afiliados</b>
					</td>
				</tr>

				<tr>
                    <td valing="top">
						<table bgcolor="#FFFFFF" cellspacing="15" cellpadding="0" align="left" border="0">
						<tr>
							<td>
								<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
								<a href="#Mod">Modificaci&oacute;n de Datos</a>
								<br><br>
								<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
								<a href="#Secc">Secciones</a>
							</td>
						</tr>
						</table>
					</td>
				</tr>

				<br>
                <tr>
                    <td valing="top">
						<b>Reportes</b>
					</td>
				</tr>

				<tr>
                    <td valing="top">
						<table bgcolor="#FFFFFF" cellspacing="15" cellpadding="0" align="left" border="0">
						<tr>
							<td>
								<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
								<a href="#Visitas">Visitas por D&iacute;a</a>
								<br><br>
								<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
                                <a href="#Rank">Ranking de Ventas</a>
								<br><br>
								<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
								<a href="#VxPr">Ventas por Producto</a>
								<br><br>
								<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
								<a href="#ComCob">Comisiones Cobradas </a>
								<br><br>
								<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
								<a href="#ComPro">Comisiones en Proceso</a>
							</td>
						</tr>
						</table>
					</td>
				</tr>

 				<tr>
                    <td valing="top">
						<b>RSS</b>
					</td>
				</tr>
				<tr>
                    <td valing="top">
						<table bgcolor="#FFFFFF" cellspacing="15" cellpadding="0" align="left" border="0">
							<tr>
								<td>
									<img src="/imagenes/clickTrans.gif" width="12" height="13" border="0" align="absmiddle">
									<a href="/inicio/index.jsp?URL_GRUPO=/grupos/interior/rss.html" target="_blank"> Manual de uso de RSS (descarga)</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td valing="top">
						<br><br>
						<b>Modificaci&oacute;n de Datos</b>
						<a name="Mod"></a>
					</td>
				</tr>

                <tr>
					<td valing="top">
						<table width="710" bgcolor="#FFFFFF" cellspacing="5" cellpadding="0" align="center" border="0">
						<tr>
							<td>
								-
							</td>
							<td>
								Para modificar lo datos de su sitio y/o su empresa ingrese en la solapa
								<strong>Afiliado</strong> y luego seleccione la opci&oacute;n <strong>Modificaci&oacute;n de Datos</strong>
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Ser&aacute; direccionado al formulario donde podr&aacute; cambiar los datos existentes.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Luego presione el bot&oacute;n Actualizar para que los cambios tengan efecto.
							</td>
						</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td valing="top">
						<br><br>
						<b>Secciones</b>
						<a name="Secc"></a>
					</td>
				</tr>

                <tr>
					<td valing="top">
						<table width="710" bgcolor="#FFFFFF" cellspacing="5" cellpadding="0" align="center" border="0">
						<tr>
							<td>
								-
							</td>
							<td>
								Para ingresar a las secciones de su alianza ingrese en la solapa <strong>Afiliado</strong>
								y luego seleccione la opci&oacute;n <strong>Secciones</strong>
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Aqu&iacute; podr&aacute; dar de alta las distintas secciones que incluir&aacute;
								en su sitio.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Cada secci&oacute;n representa un link proveniente de su p&aacute;gina para
								que usted lleve el control del origen de sus visitas, compras, etc.
							</td>
						</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td valing="top">
						<br><br>
						<b>Visitas por D&iacute;a</b>
						<a name="Visitas"></a>
					</td>
				</tr>

                <tr>
					<td valing="top">
						<table width="710" bgcolor="#FFFFFF" cellspacing="5" cellpadding="0" align="center" border="0">
						<tr>
							<td>
								-
							</td>
							<td>
								Para ingresar al detalle de las visitas diarias ingrese en la solapa <strong>Reportes</strong>
								y luego seleccione la opci&oacute;n <strong>Visitas por D&iacute;a</strong>
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
                            	Elija el rango de fechas que comprender&aacute; el reporte.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Ser&aacute; direccionado a un reporte de visitas detallado agrupado
								por d&iacute;a, mostrando un subtotal diario, y un total general.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
                            	Luego presione el bot&oacute;n Volver para salir del reporte y regresar
								al men&uacute;.
							</td>
						</tr>
						</table>
					</td>
				</tr>

				<br>

				<tr>
					<td valing="top">
						<br><br>
						<b>Ranking de Ventas<b>
						<a name="Rank"></a>
					</td>
				</tr>

                <tr>
					<td valing="top">
						<table width="710" bgcolor="#FFFFFF" cellspacing="5" cellpadding="0" align="center" border="0">
						<tr>
							<td>
								-
							</td>
							<td>
								Para ingresar al ranking de ventas ingrese en la solapa<strong> Reportes</strong>
								y luego seleccione la opci&oacute;n <strong>Ranking de Ventas</strong>
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
                            	Elija el rango de fechas que comprender&aacute; su ranking.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Ser&aacute; direccionado al ranking en formato de lista detallando
								el ISBN y t&iacute;tulo del producto, la cantidad de ejemplares
								vendidos, el precio unitario, y un subtotal correspondiente
								a las ventas de ese art&iacute;culo. Ver&aacute; tambi&eacute;n
								la cantidad total de t&iacute;tulos vendidos y el importe total.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
                            	Luego presione el bot&oacute;n Volver para salir del reporte y regresar
								al men&uacute;.
							</td>
						</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td valing="top">
						<br><br>
						<b>Ventas por Producto</b>
						<a name="VxPr"></a>
					</td>
				</tr>

                <tr>
					<td valing="top">
						<table width="710" bgcolor="#FFFFFF" cellspacing="5" cellpadding="0" align="center" border="0">
						<tr>
							<td>
								-
							</td>
							<td>
								Para ingresar al reporte de Ventas por Producto ingrese en la solapa <strong>Reportes</strong>
								y luego seleccione la opci&oacute;n <strong>Ventas por Producto</strong>
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
                            	Elija el rango de fechas que comprender&aacute; su ranking.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Ser&aacute; direccionado a un ranking de ventas agrupado por tipo
								de producto, (libros - m&uacute;sica - pel&iacute;culas)
								mostrando la cantidad de productos vendidos pr tipo, el
								total de cada uno, y un total general en cantidad y en dinero.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
                            	Luego presione el bot&oacute;n Volver para salir del reporte y regresar
								al men&uacute;.
							</td>
						</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td valing="top">
						<br><br>
						<b>Comisiones Cobradas</b>
						<a name="ComCob"></a>
					</td>
				</tr>

                <tr>
					<td valing="top">
						<table width="710" bgcolor="#FFFFFF" cellspacing="5" cellpadding="0" align="center" border="0">
						<tr>
							<td>
								-
							</td>
							<td>
                            	Para ingresar al reporte de comisiones ingrese en la solapa <strong>Reportes</strong>
								y luego seleccione la opci&oacute;n <strong>Comisiones Cobradas.</strong>
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
                            	Aqu&iacute; ver&aacute; el hist&oacute;rico de todas las comisiones
								que ya ha cobrado, siendo los campos del reporte:
							</td>
						</tr>

						<tr>
							<td>
							</td>
							<td>
								<table>
								<tr>
									<td>
										-
									</td>
									<td>
										Id de Pago: Enumera los pago que se han efectuado.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Calculado al: Fecha en la cual se cerr&oacute; el calculo de la comisi&oacute;n.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Tipo de Comisi&oacute;n: Informa si se trat&oacute; de una comisi&oacute;n
										fija o variable, seg&uacute;n usted haya preferido.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Cantidad de Productos: Informa la cantidad de productos vendidos
										para ese pago de comisi&oacute;n.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Importe Vendido: Indica el total en pesos que se vendi&oacute;
										en el per&iacute;odo.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Comisi&oacute;n: Indica el total en pesos que deber&aacute; facturarse.
									</td>
								</tr>
								</table>
							</td>
						<tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Luego presione el bot&oacute;n Volver para salir del reporte
								y regresar al men&uacute;.
							</td>
						</tr>
						</table>

				<tr>
					<td valing="top">
						<br><br>
						<b>Comisiones en Proceso</b>
						<a name="ComPro"></a>
					</td>
				</tr>

                <tr>
					<td valing="top">
						<table width="710" bgcolor="#FFFFFF" cellspacing="5" cellpadding="0" align="center" border="0">
						<tr>
							<td>
								-
							</td>
							<td>
                            	Para ingresar al reporte de comisiones en proceso ingrese en la solapa <strong>Reportes</strong>
								y luego seleccione la opci&oacute;n <strong>Comisiones en Proceso.</strong>
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
                            	Aqu&iacute; ver&aacute; el hist&oacute;rico de todas las comisiones
								que a&uacute;n no ha cobrado, siendo los campos del reporte:
							</td>
						</tr>

						<tr>
							<td>
							</td>
							<td>
								<table>
								<tr>
									<td>
										-
									</td>
									<td>
										Calculado al: Fecha de cierre del &uacute;ltimo reporte de comisiones
										cobradas.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Tipo de Comisi&oacute;n: Informa si se trat&oacute; de una comisi&oacute;n
										fija o variable, seg&uacute;n usted haya preferido.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Cantidad de Productos: Informa la cantidad de productos vendidos hasta el momento.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Cantidad de Productos: Informa la cantidad de productos vendidos hasta el momento.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Importe Vendido: Indica el total en pesos que se vendi&oacute; hasta el momento.
									</td>
								</tr>

								<tr>
									<td>
										-
									</td>
									<td>
										Comisi&oacute;n: Indica el total en pesos que deber&aacute; facturarse hasta el momento.
									</td>
								</tr>
								</table>
							</td>
						<tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Gestionar Comisi&oacute;n:Cuando su comisi&oacute;n alcance los $100 (cien pesos) puede
								gestionar el cobro de la misma presionando este bot&oacute;n.
							</td>
						</tr>

						<tr>
							<td>
								-
							</td>
							<td>
								Cuando una comisi&oacute;n en proceso se cobre, desaparecer&aacute;
								de este reporte y se incluir&ntilde;&aacute; en el reporte de <strong>Comisiones Cobradas</strong>.
							</td>
						</tr>


						<tr>
							<td>
								-
							</td>
							<td>
								Luego presione el bot&oacute;n Volver para salir del reporte y regresar al men&uacute;.
							</td>
						</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td align="right">
						<br><br><br><br>
						<strong>
							<a href="#Volver">Volver</a>
						</strong>
						<br><br>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>