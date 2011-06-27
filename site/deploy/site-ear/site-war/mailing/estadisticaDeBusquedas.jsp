<%@ page import="com.tmk.controllers.buscador.BusquedaGenerica,
                 com.tmk.controllers.buscador.InfoBuscador,
                 com.tmk.kernel.Convert"%>

<table width="500">
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td>
						<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
						<tr>
							<td colspan="2">
								<b>Porcentajes de Busquedas en segundos</b>
							</td>
						</tr>
						<tr>
							<td width="70%" align="right">
								<b>Segundos</b>
							</td>
							<td align="right" >
								<b>Porcentaje</b>
							</td>
						</tr>
						<%
						int[] tiempos =  BusquedaGenerica.getTiempos(null);
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
							if (orden[1][i]>0) {
						%>
							<tr>
								<td align="right">
									<%=(orden[0][i]) + " y " + (orden[0][i] + 1)%>
								</td>
								<td  align="right">
									<%=Convert.round((orden[1][i]*100.00/BusquedaGenerica.getTotalConsulta(InfoBuscador.CONSULTAS_OK)))%>%
								</td>
							</tr>	
							<%}%>
						<%	
						}	
						%>
						<table>
					</td>
				</tr>
			</table>
		</td>
	</tr>		
</table>
<p>&nbsp; <p>	
