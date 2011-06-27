<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.MedioDeCobroDAO,
                 com.tmk.kernel.TarjetaPlanDAO,
                 com.tmk.kernel.Convert,
                 com.tmk.setup.Contenido"%><html>
		<%
			double precio = Convert.toNumber(request.getParameter("precio"), 0.00);
			String textoH1 = request.getParameter("textoH1");
		%>

	<head>

		<title> Planes de Pago </title>
		<script languaje="javascript">
        	function muestraPlan(sel) {
	            for (i=0; i<sel.length; i++) {
	                eval('document.getElementById(\'medio' + i + '\').style.display=\'none\'');
	            }
	            eval('document.getElementById(\'medio' + sel.selectedIndex + '\').style.display=\'\'');
	        }
		</script>
	</head>
	<body>
    <form name="frmMedioDeCobro">
    	<table align="center" width="360" border=0 style="font-size:12;font-family:verdana;color:ffffff;" bgcolor="006699">
			<tr>
				 <td width=135 align=right><b>Planes de Pago:</b></td>
				 <td  align=left>
					<select name="idMedioDeCobro" onChange="muestraPlan(this)" style="font-size:12;font-family:verdana">

					</select>
				 </td>
			</tr>
			
	    </table>
	    </form>
        <table height="295" align="center">
	        <tr>
				<td align="center">
					<b><h1 style="color:006699; font-size:12;font-family:verdana">
						Planes de pago - <%=textoH1%>
					   </h1>
					</b>
				</td>
			</tr>
        	<tr>
        		<td valign="top">

<%
			int contadorHabilitados = -1;
			for(int i=0; i<Globals.MEDIOS_DE_COBRO.length; i++) {

				if (Globals.MEDIOS_DE_COBRO[i].estaHabilitado() && Globals.MEDIOS_DE_COBRO[i].esTarjeta() && (!Globals.MEDIOS_DE_COBRO[i].getId().equals("VNA")) && (!Globals.MEDIOS_DE_COBRO[i].getId().equals("MNA"))) {

%>
				<script languaje="javascript">
					//document.frmMedioDeCobro.idMedioDeCobro.add(new Option('<%=Globals.MEDIOS_DE_COBRO[i].getNombre()%>', '<%=Globals.MEDIOS_DE_COBRO[i].getId()%>'))
					document.frmMedioDeCobro.idMedioDeCobro.options[document.frmMedioDeCobro.idMedioDeCobro.length++]= new Option('<%=Globals.MEDIOS_DE_COBRO[i].getNombre()%>', '<%=Globals.MEDIOS_DE_COBRO[i].getId()%>')

				</script>

					<table border = "0" id="medio<%=++contadorHabilitados%>"  align="center" width="360" bgcolor="006699" style="color:006699; font-size:12;font-family:verdana" cellspacing="1">
		  				<tr>
							<td bgcolor="eff3ff" width=50 align="center"><b>Cuotas</b></td>
							<td bgcolor="eff3ff" width=70 align="center"><b>TNA</b></td>
							<td  bgcolor="eff3ff" width=120 align="center"><b>Cuota Mensual</b></td>
			                <td bgcolor="eff3ff" width=120 align="center"><b>Total a Facturar</b></td>
						</tr>


<%              String colorClaro ="ffffff";
				String colorOscuro ="eff3ff";
				String colorActual ="eff3ff";
				TarjetaPlanDAO planes[] = TarjetaPlanDAO.getParaMedio(Globals.MEDIOS_DE_COBRO[i]);
			    for (int j=0; j<planes.length; j++) {
%>

<%                  if (colorActual.equals(colorClaro)) {
						colorActual = colorOscuro;
					} else {
						colorActual = colorClaro;
					}
%>

					  <tr style="display">
	 				  	  <td align="right" bgcolor="<%=colorActual%>">
							<%=planes[j].getCuotas()%>
  						  </td>
			 			  <td align="right" bgcolor="<%=colorActual%>">
							<%=planes[j].getTNA()%> %
					 	  </td>
		 				  <td align="right" bgcolor="<%=colorActual%>">
		 				    <%=Contenido.precioToString(planes[j].calculaCuota(precio))%>
		 				  </td>
		 				  <td align="right" bgcolor="<%=colorActual%>">
							<%=Contenido.precioToString(precio*planes[j].getCoeficiente())%>
					 	  </td>
					  </tr>
<%
		        }
%>
					</table>
<%
			}
		}
%>
				</td>
			</tr>
		</table>

		<table align="center" bgcolor="eff3ff" border=0>
			<tr height=18>
				<td bgcolor="006699" valign="middle" Style="font-size:1">
					<a href="javascript:window.close()" style="color:ffffff; font-family:verdana; font-size:10; text-decoration:none; padding:5"><b>CERRAR</b></a>
				</td>
			</tr>
		</table>
<script languaje="javascript">
	muestraPlan(document.frmMedioDeCobro.idMedioDeCobro);
</script>
	</body>
</html>