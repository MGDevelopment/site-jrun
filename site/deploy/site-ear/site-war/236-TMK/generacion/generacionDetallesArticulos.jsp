<%@ page import="com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.common.SucursalLocalHome,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.site.Eventos,
                 com.tmk.kernel.site.Evento,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.Paginas,
                 com.tmk.kernel.site.Pagina,
                 java.sql.Connection,
                 java.sql.PreparedStatement,
                 java.sql.ResultSet,
                 java.util.Vector,
                 com.tmk.kernel.TmkLogger,
                 com.tmk.generacion.ContenidosEstaticos" %>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
    if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("GENERAR_DETALLES_DE_ARTICULOS_ESTATICOS"))) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}

    int senal = (Convert.toNumber(request.getParameter("senal"), new Integer(0))).intValue();

    String titulo = "";
	String ISBN = "";
	String idArticulo = "";
    Integer idArticuloEstatico = null;
    int maxResult = 25;
    String error = null;

    Vector articulosElegidos = new Vector();

	if (senal == 1) {
        titulo = Convert.toString(request.getParameter("titulo"), "");
        ISBN = Convert.toString(request.getParameter("ISBN"), "");
        idArticulo = Convert.toString(request.getParameter("idArticulo"), "");
        idArticuloEstatico = Convert.toNumber(request.getParameter("idArticuloEstatico"), (Integer)null);
        try{
            articulosElegidos = DBUtil.articulosBuscados(idArticulo,ISBN,titulo,maxResult);
        } catch( Exception e ) {
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

				<font style="font-size: 18px; color:#003366">&nbsp;&nbsp;Detalles Estáticos de los artículos</font><br><br>

                <%
                    if(session.getAttribute("generacionDetalleError") != null){
                %>
                        <CENTER><font style="font-size: 13px; color:red">&nbsp;&nbsp;<b><%=session.getAttribute("generacionDetalleError")%></b></font></CENTER>
                <%      session.removeAttribute("generacionDetalleError");
                    }
                %>

                <%
	                if(session.getAttribute("generacionDetalleOK") != null){
                %>
                        <CENTER><font style="font-size: 13px; color:green">&nbsp;&nbsp;<b><%=session.getAttribute("generacionDetalleOK")%></b></font></CENTER>
                <%      session.removeAttribute("generacionDetalleOK");
	                }
                %>

				<script language="javascript">
				function consultar(){
					if(document.formBuscador.idArticulo.value!=""
                        || document.formBuscador.ISBN.value!=""
                        || document.formBuscador.titulo.value!=""){
                        document.formBuscador.senal.value = 1;
					    document.formBuscador.submit();
                    }else{
                        alert("Debe indicar algún criterio para la búsqueda.");
                    }
				}
				</script>

				<form name="formBuscador" action="generacionDetallesArticulos.jsp" method="post">
				<input type="hidden" value="" name="senal">

				    <table width="600" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
				        <tr class="titulos" >
						    <td bgcolor="#59B3D9" align="center">IdArticulo</td>
							<td bgcolor="#59B3D9" align="center">ISBN</td>
							<td bgcolor="#59B3D9" align="center">Titulo</td>
						</tr>
				        <tr>
				            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="center"><input type="text" value="<%=idArticulo%>" onkeydown="if(event.keyCode<48 || event.keyCode>57)event.keyCode='';" name="idArticulo" size="10"></td>
				            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="center"><input type="text" value="<%=ISBN%>" name="ISBN" size="30"></td>
				            <td style="border-right: 1px solid #59B3D9;"  class="contenido" align="center"><input type="text" value="<%=titulo%>" name="titulo" size="50"></td>
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
                    String selected = "";
					if(!articulosElegidos.isEmpty()){ %>
						<script language="javascript">
						function generarDetalle(idArticulo,catSeccion){
    						document.formDetallesEstaticos.idArticuloEstatico.value = idArticulo;
	    					document.formDetallesEstaticos.idSeccion.value = catSeccion;
						}
						</script>
                        <form action="/GenerarDetallesDeArticulosEstaticos" name="formDetallesEstaticos" method="post">
						<input type="hidden" value="" name="idArticuloEstatico">
						<input type="hidden" value="" name="idSeccion">
                        <input type="hidden" value="<%=idArticulo%>" name="idArticulo">
                        <input type="hidden" value="<%=titulo%>" name="titulo">
                        <input type="hidden" value="<%=ISBN%>" name="ISBN">
                        <input type="hidden" value="<%=senal%>" name="senal">
                        <input type="hidden" value="1" name="generacion">
						<table width="600" border="1" cellpadding="2" cellspacing="0" style="border: 1px solid #59B3D9; border-collapse: collapse; " align="center">
							<tr class="titulos" >
							    <td bgcolor="#59B3D9" align="center">&nbsp;</td>
                                <td bgcolor="#59B3D9" align="center">IdArticulo</td>
						    	<td bgcolor="#59B3D9" align="center">ISBN</td>
								<td bgcolor="#59B3D9" align="center">Titulo</td>
							</tr>
						<%for(i=0;i<maxResult && i<articulosElegidos.size();i++){
                            selected = (((Vector)articulosElegidos.get(i)).get(0).equals(idArticuloEstatico)) ? "checked" : "";%>
                            <tr>
								<td style="border-right: 1px solid #59B3D9;" align="center" class="contenido"><input type="radio" <%=selected%> name="detalleArticulo" onclick="generarDetalle(<%=((Vector)articulosElegidos.get(i)).get(0)%>,<%=((Vector)articulosElegidos.get(i)).get(1)%>)"></td>
                                <td style="border-right: 1px solid #59B3D9;" align="left" class="contenido">&nbsp;<%=(Integer)((Vector)articulosElegidos.get(i)).get(0)%></td>
								<td style="border-right: 1px solid #59B3D9;" align="left" class="contenido">&nbsp;<%=Convert.toString(((Vector)articulosElegidos.get(i)).get(2),"")%></td>
								<td style="border-right: 1px solid #59B3D9;" align="left" class="contenido">&nbsp;<%=Convert.nombrePropio((String)((Vector)articulosElegidos.get(i)).get(3))%></td>
							</tr>
						<% } %>
						</table>
						<%  if( maxResult < articulosElegidos.size() ){%>
                                    <br><CENTER><font style="font-size: 13px; color:green">&nbsp;&nbsp;<b>La cantidad de resultados excede la cantidad máxima de <%=maxResult%>.</b></font></CENTER>
                            <% }
                    } else {%>
                    <CENTER><font style="font-size: 13px; color:red">&nbsp;&nbsp;<b>
                            <%if(error == null){%>
                        No se encontraron artículos para la búsqueda.
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
                        <%if(senal==1 && !articulosElegidos.isEmpty()){%>
                            <script language="javascript">
                            function comenzarGeneracion(obj){
                                if(document.formDetallesEstaticos.idArticuloEstatico.value!=""){
                                    obj.onclick='';
                                    document.formDetallesEstaticos.submit();
                                } else {
                                    alert("Debe seleccionar el articulo a generar.");
                                }
                            }
                            </script>
                            <a style="cursor:hand;" onclick="javascript:comenzarGeneracion(this);"><img name="btnGeneracion" src="/imagenes/boton_Generar_Contenido_Estatico.gif" border="0"></a>&nbsp;&nbsp;
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