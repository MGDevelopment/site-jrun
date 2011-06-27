<%
	String URL = request.getParameter("URL_GRUPO"); 
%>

<table width="800" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
         <tr>
           <!-- td class="Gbarraizquierda" width="200">
	            <table width="" border="0" align="left" cellpadding="0" cellspacing="0">					
				
	            </table>
			</td-->
		
			<td align="center">
				<table>
					<tr>
						<td>
           	 				<jsp:include page="<%= URL %>"> </jsp:include>
           	 			</td>
           	 		</tr>
           	 	</table>
           	</td>
           
         </tr>
</table>