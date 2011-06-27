<%@page import="com.tmk.controllers.intranet.admin.UsuarioDAO"%>
<%@page import="com.tmk.controllers.intranet.admin.LoginIntranet"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="java.util.Vector"%>
<%@page import="com.tmk.controllers.buscador.BuscadorHelper"%>
<%@page import="com.tmk.kernel.DBUtil"%>
<%@page import="com.tmk.kernel.Globals"%>
<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
    if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("GENERAR_RECORRIDO_DE_FAMILIAS_ESTATICAS"))) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}

    int senal = (Convert.toNumber(request.getParameter("senal"), new Integer(0))).intValue();

    Integer CATEGORIA_SECCION = null;
    Integer CATEGORIA_GRUPO = null;
    Integer CATEGORIA_FAMILIA = null;

    String error = null;
    Vector categoriasElegidas = new Vector();
    int maxResults = 1000;

    if(senal==1){
        //busqueda
        CATEGORIA_SECCION = Convert.toNumber(request.getParameter("f" + BuscadorHelper.CATEGORIA_SECCION), (Integer)null);
        CATEGORIA_GRUPO = Convert.toNumber(request.getParameter("f" + BuscadorHelper.CATEGORIA_GRUPO), (Integer)null);
        CATEGORIA_FAMILIA = Convert.toNumber(request.getParameter("f" + BuscadorHelper.CATEGORIA_FAMILIA), (Integer)null);
        try{
            categoriasElegidas = DBUtil.categoriasBuscadas(CATEGORIA_SECCION,CATEGORIA_GRUPO,CATEGORIA_FAMILIA,maxResults);
        }catch(Exception e){
            error = "No se pudo realizar la consulta. Vuelva a intentar la búsqueda.";
        }
    }

%>
<html>
	<head>
	<%= Globals.estiloBasico() %>

		<style>
		.titulos{
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			font-weight: bold;
		}

		.contenido{
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			text-decoration: none;
			color: #000000;
		}
		</style>
	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
	<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" height="100%" width="770" >
		<tr>
			<td valign="top">
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:include page="/236-TMK/comunes/header.jsp"/>
						</td>
					</tr>
				</table>

				<font style="font-size: 18px; color:#003366">&nbsp;&nbsp;Recorrido de las Familias</font><br><br>

                <%
                    if(session.getAttribute("generacionRecorridoFamiliaError") != null){
                %>
                        <CENTER><font style="font-size: 13px; color:red">&nbsp;&nbsp;<b><%=session.getAttribute("generacionRecorridoFamiliaError")%></b></font></CENTER>
                <%      session.removeAttribute("generacionRecorridoFamiliaError");
                    }
                %>

                <%
	                if(session.getAttribute("generacionRecorridoFamiliaOK") != null){
                %>
                        <CENTER><font style="font-size: 13px; color:green">&nbsp;&nbsp;<b><%=session.getAttribute("generacionRecorridoFamiliaOK")%></b></font></CENTER>
                <%      session.removeAttribute("generacionRecorridoFamiliaOK");
	                }
                %>

				<script language="javascript">
				function consultar(){
					if(document.formBuscador.f<%=BuscadorHelper.CATEGORIA_SECCION%>.value!=""
                        || document.formBuscador.f<%=BuscadorHelper.CATEGORIA_GRUPO%>.value!=""
                        || document.formBuscador.f<%=BuscadorHelper.CATEGORIA_FAMILIA%>.value!=""){
                        document.formBuscador.senal.value = 1;
					    document.formBuscador.submit();
                    }else{
                        alert("Debe indicar algún criterio para la búsqueda.");
                    }
				}
				</script>

				<form name="formBuscador" action="generacionRecorridoDeFamilias.jsp" method="post">
				<input type="hidden" value="" name="senal">

				    <table width="600" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
				        <tr class="titulos" >
						    <td bgcolor="#59B3D9" align="center">Seccion</td>
							<td bgcolor="#59B3D9" align="center">Grupo</td>
							<td bgcolor="#59B3D9" align="center">Familia</td>
						</tr>
				        <tr>
				            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="center"><input type="text" value="<%=Convert.toString(CATEGORIA_SECCION,"")%>" name="f<%=BuscadorHelper.CATEGORIA_SECCION%>" size="40"></td>
				            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="center"><input type="text" value="<%=Convert.toString(CATEGORIA_GRUPO,"")%>" name="f<%=BuscadorHelper.CATEGORIA_GRUPO%>" size="40"></td>
				            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="center"><input type="text" value="<%=Convert.toString(CATEGORIA_FAMILIA,"")%>" name="f<%=BuscadorHelper.CATEGORIA_FAMILIA%>" size="40"></td>
				        </tr>
				    </table>

				    <table width="600" align="center">
				        <tr>
						    <td align="right">
							    <img src="/imagenes/buscar.jpg" border="0" style="cursor:hand;" onclick="javascript:consultar();">
						    </td>
					    </tr>
					</table>

    			</form>

				<%if(senal==1){
					int i = 0;
                    //String selected = "";
					if(!categoriasElegidas.isEmpty()){ %>
						<script language="javascript">						

											
						function seleccionarTodos(chkbox){
							for (var i=0;i < document.formFamiliasEstaticas.elements.length;i++){
								var elemento = document.formFamiliasEstaticas.elements[i];
								if (elemento.type == "checkbox"){
										elemento.checked = chkbox.checked
								}
							}
						}

						</script>
						
                        <form action="/GenerarFamiliasEstaticas" name="formFamiliasEstaticas" method="post">
                        <input type="hidden" value="" name="<%=BuscadorHelper.CATEGORIA_SECCION%>">
                        <input type="hidden" value="" name="<%=BuscadorHelper.CATEGORIA_GRUPO%>">
                        <input type="hidden" value="" name="<%=BuscadorHelper.CATEGORIA_FAMILIA%>">
                        <input type="hidden" value="<%=Convert.toString(CATEGORIA_SECCION,"")%>" name="f<%=BuscadorHelper.CATEGORIA_SECCION%>">
                        <input type="hidden" value="<%=Convert.toString(CATEGORIA_GRUPO,"")%>" name="f<%=BuscadorHelper.CATEGORIA_GRUPO%>">
                        <input type="hidden" value="<%=Convert.toString(CATEGORIA_FAMILIA,"")%>" name="f<%=BuscadorHelper.CATEGORIA_FAMILIA%>">
                        <input type="hidden" value="<%=senal%>" name="senal">
						<table width="600" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
							<tr class="titulos" >															    
							    <td bgcolor="#59B3D9" align="center"><input type="checkbox" name="selectAll" onClick="seleccionarTodos(this)" /></td> <!--seleccionarTodos(document.formname)-->
                                <td bgcolor="#59B3D9" align="center">Sección</td>
						    	<td bgcolor="#59B3D9" align="center">Grupo</td>
								<td bgcolor="#59B3D9" align="center">Familia</td>
							</tr>
						<%for(i=0;i<maxResults && i<categoriasElegidas.size();i++){
                            //selected = (((Vector)categoriasElegidas.get(i)).get(0).equals(CATEGORIA_SECCION) && ((Vector)categoriasElegidas.get(i)).get(1).equals(CATEGORIA_GRUPO) && ((Vector)categoriasElegidas.get(i)).get(2).equals(CATEGORIA_FAMILIA)) ? "checked" : "";%>
                            <tr>
								<td style="border-right: 1px solid #59B3D9;" align="center" class="contenido"><input type="checkbox" name="recorrido<%=i%>" onclick="document.formFamiliasEstaticas.selectAll.checked=false;"></td>
								<input type="hidden" value="<%=((Vector)categoriasElegidas.get(i)).get(0)%>" name="<%=BuscadorHelper.CATEGORIA_SECCION%><%=i%>">
								<input type="hidden" value="<%=((Vector)categoriasElegidas.get(i)).get(1)%>" name="<%=BuscadorHelper.CATEGORIA_GRUPO%><%=i%>">
								<input type="hidden" value="<%=((Vector)categoriasElegidas.get(i)).get(2)%>" name="<%=BuscadorHelper.CATEGORIA_FAMILIA%><%=i%>">
								
                                <td style="border-right: 1px solid #59B3D9;" align="left" class="contenido">&nbsp;<%=Convert.corregir(Convert.toString(((Vector)categoriasElegidas.get(i)).get(3),""),true)%></td>
								<td style="border-right: 1px solid #59B3D9;" align="left" class="contenido">&nbsp;<%=Convert.corregir(Convert.toString(((Vector)categoriasElegidas.get(i)).get(4),""),true)%></td>
								<td style="border-right: 1px solid #59B3D9;" align="left" class="contenido">&nbsp;<%=Convert.corregir(Convert.toString(((Vector)categoriasElegidas.get(i)).get(5),""),true)%></td>
							</tr>
						<% } %>
						</table>
						<%  if( maxResults < categoriasElegidas.size() ){%>
                                    <br><CENTER><font style="font-size: 13px; color:green">&nbsp;&nbsp;<b>La cantidad de resultados excede la cantidad máxima de <%=maxResults%>.</b></font></CENTER>
                            <% }
                    } else {%>
                    <CENTER><font style="font-size: 13px; color:red">&nbsp;&nbsp;<b>
                            <%if(error == null){%>
                        No se encontraron categorías para la búsqueda.
                    <%	}else{
                                out.println(error);
                            }%>
                            </b></font></CENTER>
                    <%}
                }
                    %>

				<table width="600" align="center">
				  <tr>
					<td width="600" align="right">
						<br><br>
						<div align="right">
                        <%if(senal==1 && !categoriasElegidas.isEmpty()){%>
                            
                            <script language="javascript">   				
							
							function generarRecorridoFamilia(cat_seccion,cat_grupo,cat_familia){							
    							document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_SECCION%>.value =  cat_seccion ;
        	                    document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_GRUPO%>.value = document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_GRUPO%>.value + cat_grupo + ";" ;
            	                document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_FAMILIA%>.value = document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_FAMILIA%>.value +  cat_familia + ";" ;
							}
						                                             
							function estaChecked(cantidadRecorridos){

								document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_SECCION%>.value = "" ;
		        	            document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_GRUPO%>.value = "";
        		    	        document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_FAMILIA%>.value = "";

								for(i = 0; i < cantidadRecorridos;i++ ){
									if ( eval('document.formFamiliasEstaticas.recorrido'+i+'.checked == true')){
										var seccion = eval('document.formFamiliasEstaticas.seccion'+i+'.value') ;
										var grupo = eval('document.formFamiliasEstaticas.grupo'+i+'.value') ;
										var familia = eval('document.formFamiliasEstaticas.familia'+i+'.value');
										generarRecorridoFamilia(seccion,grupo,familia);										
									} 
								}
							}							                                                  
							
                            function comenzarGeneracion(obj){ 
                                if(document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_SECCION%>.value!=""){
                                   // obj.onclick='';
                                    //alert(document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_SECCION%>.value);
                                   // alert(document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_GRUPO%>.value);
                                   // alert(document.formFamiliasEstaticas.<%=BuscadorHelper.CATEGORIA_FAMILIA%>.value);
                                   document.formFamiliasEstaticas.submit();
                                } else {
                                    alert("Debe seleccionar la categoría a generar.");
                                }
                            }
                            </script>
                            
                            <a style="cursor:hand;" onclick="estaChecked(<%=categoriasElegidas.size()%>);comenzarGeneracion(this);return;"><img name="btnGeneracion" src="/imagenes/boton_Generar_Contenido_Estatico.gif" border="0"></a>&nbsp;&nbsp;
                        <%}%>
                            <a href="/236-TMK/generacion/"><img src="/imagenes/botonVolver.gif" border="0"></a>
						</div>
					</td>
				  </tr>
				</table>
                </form>
			</td>
		</tr>
	</table>
</body>