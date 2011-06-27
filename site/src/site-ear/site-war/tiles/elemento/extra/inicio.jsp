<%@ page import="com.tmk.kernel.Globals,
	 com.tmk.controllers.MainHelper,
	 com.tmk.kernel.TmkLogger"%>
<%String page = request.getParameter("page");%>
<div id="seccionTematika">
	<div style="width:830px;  margin:auto; margin-top:80px;" >
		<table width="760" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr><td></td></tr>
	      <tr>
	        <td>
	        <div align="center">
	          <table width="740" border="0" cellpadding="0" cellspacing="0" >
	            <tr>
	              <td width="575"></td>
	                <td width="165"></td>
	              </tr>
	          </table>
	        </div></td>
	      </tr>
	      <tr>
	        <td>
				<table width="740" border="0" align="center" cellpadding="0" cellspacing="0" >
					<tr><td><br></td></tr>
				  	<tr>
					    <td>
					       <!-- Menu -->
					     	<% String pageMenu = "/tiles/elemento/extra/menu.jsp?mnuActivo=1";%>
						    <jsp:include page="<%=pageMenu%>"/>
					       <!-- Menu -->
					    </td>
				    </tr>
				  <tr>
						<td>
				        	<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
				        		<tr>
						          	<td>
						          		<% if (page != null) { %>
							          		<%try{
							          		%>
							          			<jsp:include page="<%=page%>"/>
							          		<%} catch (Exception e) {
							          			TmkLogger.debug("Pagina error " + page);
							          		}%>
				          		    	<% } else {%>
						          		<table width="100%" border="0" cellspacing="0" cellpadding="0">
							              	<tr>
				            			    	<td valign="top">
				            			    	<jsp:include page="<%=MainHelper.RES_PAGE_EXTRA_INICIO_R%>"/>
				    			                </td>
				                				<td width="165" valign="top" bgcolor="#E79A0B">
				                				<!--LEFT-->
				            	 				  <%String pageLeft = "/fidelizacion/panel/componentes/left.jsp";%>
												  <jsp:include page="<%=pageLeft%>"/>
				               					<!--LEFT-->
				                				</td>
									        </tr>
									        <tr>
									          <td height="4"></td>
									        </tr>
									        <tr><td>
										          <table width="100%" border="0" cellspacing="0" cellpadding="0">
										              <tr>
										                <td width="144" bgcolor="#00708B">&nbsp;</td>
										                <td bgcolor="#9C928D" align="left"><a href="#top"><img src="/imagenes/fidelizacion/marco_16.gif" width="101" height="22" border="0"></a></td>
										              </tr>
										            </table>
									        </td></tr>
				     				 	</table>
				      			    	<% }%>
				     				</td>
								  </tr>
							</table>
				        </td>
				      </tr>
				    </table>
		  </td>
		</tr>
	</table>
	</div>
</div>