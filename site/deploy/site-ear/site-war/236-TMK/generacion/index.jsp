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
                 com.tmk.controllers.intranet.contenido.ContenidoHelper" %>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
    if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("GENERAR_CONTENIDOS_ESTATICOS"))) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>

<html>
	<head>
	<%= Globals.estiloBasico() %>

		<style type="text/css" rel="stylesheet">
		font.TituloBordo
		{
			color: #990000;
			font-size: 14px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}

		font.TextoBordo
		{
			color: #990000;
			font-size: 12px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}

		a.EnlaceNegro
		{
			font-size: 11px;
			font-family: verdana;
			color: #000000;
			text-decoration: none;
		}

		table.BordeFino
		{
			border-collapse: collapse;
			border: 2px solid;
			border-color: #5AB5DE;
		}
	</style>

	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
        <table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" width="770" height="100%">
        <tr>
            <td valign="top">
                <table cellpadding="0" cellspacing="0" width="770">
                <tr>
                    <td>
                        <table width="100%" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <jsp:include page="/236-TMK/comunes/header.jsp"/>
                                </td>
                            </tr>
                        </table>
                        <br>
                        <table width="650" align="center">
                        <tr>
                            <td>
                                <table width="100%" border=0>
                                <tr valign="top">

                                    <td width="50%">
                                        <br>
                                        <font class="TextoBordo">
                                            Generación de Contenidos Estáticos
                                        </font>
                                        <br><br>                                        
                                        <img src="/imagenes/intranet/vineta.gif">
                                        <a href="/236-TMK/generacion/generacionDetallesArticulosNuevo.jsp" class="EnlaceNegro">
                                            Detalles de Artículos
                                        </a>
                                        <br><br>
                                        <img src="/imagenes/intranet/vineta.gif">
                                        <a href="/236-TMK/generacion/generacionRecorridoDeFamilias.jsp" class="EnlaceNegro">
                                            Recorrido de las Familias
                                        </a>
                                         <br><br>
                                        <img src="/imagenes/intranet/vineta.gif">
                                        <a href="/236-TMK/generacion/generacionRankings.jsp" class="EnlaceNegro">
                                            Rankings
                                        </a>
                                        <br><br>
                                        <!-- generacion de templates -->
                                        <img src="/imagenes/intranet/vineta.gif">
                                        <a href="/236-TMK/disponibilidad/buscadorArticulo.jsp" class="EnlaceNegro">
                                            Generar Template
                                        </a>
                                        <br><br>
                                        <img src="/imagenes/intranet/vineta.gif">
                                        <a href="/236-TMK/comentario/generarMesaRecomendada.jsp" class="EnlaceNegro">
                                            Generar Mesa Recomedada por Tematika
                                        </a>
                                        <br><br>
                                    </td>
                                    <td width="50%">
                                        <br>
                                        <font class="TextoBordo">
                                            Disponibilidad y habilitacion de Articulos
                                        </font>
                                        <br><br>
                                        <img src="/imagenes/intranet/vineta.gif">
                                        <a href="/236-TMK/disponibilidad/porArticulo.jsp" class="EnlaceNegro">
                                            Por Articulo
                                        </a>
                                        <br><br>
                                    </td>
                                </tr>
                                </table>
                            </td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
            </td>
        </tr>
        </table>
    </body>
</html>
