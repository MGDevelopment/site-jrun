<%@ page import="com.tmk.kernel.Convert,
				 com.tmk.src.socio.SocioPK,
				 com.tmk.bus.orden.CuponDePago,
				 com.tmk.service.orden.OrdenService,
                 com.tmk.orden.OrdenDAO,
                 com.tmk.kernel.DBUtil,
                 java.sql.Connection,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.orden.OrdenLocal,
                 com.tmk.setup.Contenido,
                 java.util.Calendar,
                 java.util.Date"%>
<%
	boolean puedeVerCupon = true;
	Integer idOrden = Convert.toNumber(request.getParameter("idOrden"), (Integer)null);
	SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
	String mensaje =null;
	if (socioPK == null) {
		puedeVerCupon = false;
		mensaje ="Para imprimir el cupón debes iniciar sesión con tu usuario y contraseña.";
	}
	OrdenLocal orden = null;
	try {
		OrdenLocalHome ordenLH = (OrdenLocalHome)DBUtil.getHome("Orden");
		orden = ordenLH.findByPrimaryKey(idOrden);
		if (!orden.getID_SOCIO().equals(socioPK.ID_SOCIO) || !orden.getID_SUCURSAL_SOCIO().equals(socioPK.ID_SUCURSAL)) {
			puedeVerCupon = false;
			mensaje ="El cupón que intentas imprimir no corresponde al socio que ha iniciado sesión.";
		}
	} catch (Exception e) {
		puedeVerCupon = false;
		mensaje ="La orden no es válida.";
	}
	
	if (orden == null) {
		puedeVerCupon = false;
	}
									
	
	if (puedeVerCupon) {
		OrdenDAO ordenDAO = OrdenService.cargarOrden(idOrden.intValue());
 		if ((ordenDAO != null) && (ordenDAO.getMedioDeCobro().requiereCuponDePago())) {
			
			Connection conn = DBUtil.buildConnection();
			CuponDePago cuponDePago = new CuponDePago();
			try {
				
				String param [] = new String[] {"id_orden = " + idOrden.toString()};
				cuponDePago.select(conn, param);
			} catch (Exception e) {
				mensaje ="La orden no tiene asignado un cupón de pago.";
			} finally {
				conn.close();
			}	
			if (cuponDePago.getCodigo() != null) { 	

				Calendar cal = Calendar.getInstance();
				cal.setTime(orden.getFECHA());
				cal.add(Calendar.DATE, 15);
				Date date = new Date(cal.getTimeInMillis());
				//Si todavia no vencio
				if (cal.after(Calendar.getInstance())) {

	
%>

<html>
	<head>
		<script>
		function imprimir() {
			document.getElementById('btnImprimir').style.display='none';
			window.print();
			document.getElementById('btnImprimir').style.display='block';
		}
		</script>
	</head>
	<body>
		<table border="0" style="border:dashed 1px #555555;" cellpadding="5" width="550px" bgcolor="#ffffff" height="400">
		<tr>
		<td>
		<table border="1" style="font-family:arial;border: solid 1px #dddddd; border-collapse: collapse; font-size: 14px" cellpadding="2" width="600px">
			<tr>
				<td>
					<img src="http://www.tematika.com/imagenes/logo-tematika.gif" alt="Tematika.com">
				</td>
				
			</tr>
			<tr>
				<td>
					<table border="0" cellpadding="0" cellspacing="0"  style="font-family:arial;font-size: 14px" width="600">
						<tr>
							<td>

								Vto: <%=Convert.toString(date)%>
							</td>
							
							<td align="right">
								Importe: <b><%=Contenido.precioToString(ordenDAO.totalSitioCompleto())%></b>&nbsp;
							</td>
					</table>
				</td>
			</tr>	
			<tr>
				<td>
					Orden: <%=ordenDAO.getIdOrdenProcesada()%>
				</td>
			</tr>
			<tr>
				<td>
					Socio: <%=request.getSession().getAttribute("Registracion.nombreCompleto")%>
				</td>
			</tr>
			
			
			<tr>	
				<td>
					Código de operación manual: <%=cuponDePago.getCodigo()%>
				</td>
			</tr>
			<tr>
				<td>
					Presente este cupón en cualquier sucursal de <b><%=ordenDAO.getMedioDeCobro().getNombre()%></b> indicandolé al cajero el monto a abonar.
				</td>
			</tr>	
			<tr>
				<td align="center">
					<img src="/imagenes/DM.png" alt="DineroMail"><img src="/imagenes/<%=ordenDAO.getMedioDeCobro().getId()%>.PNG" alt="<%=ordenDAO.getMedioDeCobro().getNombre()%>">
				</td>
			</tr>
			<tr>
				<td align="center">
					...............................................................................................................................
					<br>
					<img width="300" src="http://www.dineromail.com/barras/barcode.asp?image=3&type=23&data=<%=cuponDePago.getCodigo()%>" alt="<%=cuponDePago.getCodigo()%>"> 
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" id="btnImprimir" value="imprimir" onclick="imprimir()">
				</td>
			</tr>
		</table>
		</td>
		</tr>
		</table>
	</body>
</html>
<%
				} else {
					mensaje = "La fecha de pago del cupón ha vencido";
				}
			}
		} else {
			mensaje = "La orden no tiene asignado un cupón de pago.";
		}
	}
%>
<% 
	if (mensaje!= null) {
%>
	<html>
		<head>
			
			<link href="/estilos/seccion_inicio.css" rel="stylesheet" type="text/css" />
		</head>
		<body>
			<table>
				<tr>
					<td>
						<div id="userLoginError">
							<%=mensaje%>
						</div>
					</td>
				</tr>
			</table>
		</body>
	</html>
<%		
	}
%>