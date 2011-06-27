<%@ page import="com.tmk.src.socio.SocioPK,                 
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert,
                 com.tmk.articulo.ArticuloLocal,
                 com.tmk.setup.Contenido,
                 com.tmk.controllers.pedidoEspecial.PedidoEspecialHelper,
                 com.tmk.kernel.Globals"%>
<%--
                 /com.tmk.socio.SocioLocal,
                 com.tmk.socio.// 
--%>

<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>

<%	SocioPK socioPK = new SocioPK();
	socioPK.ID_SUCURSAL = new Integer(request.getParameter(PedidoEspecialHelper.CAMPO_SUCURSAL));
	socioPK.ID_SOCIO = new Integer(request.getParameter(PedidoEspecialHelper.CAMPO_SOCIO));
	//SocioLocalHome socioHome = (SocioLocalHome)DBUtil.getHome("Socio");
	//SocioLocal socio = socioHome.findByPrimaryKey(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
	Socios2 socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
	//String nombreCompleto = Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS());
	String nombreCompleto = Convert.nombreCompleto(socio.getNombres(), socio.getApellidos());

	ArticuloLocal articuloLocal = Contenido.getArticulo(Convert.toNumber(request.getParameter(PedidoEspecialHelper.CAMPO_ARTICULO), Globals.ARTICULO_DEFAULT));
	String telefono = Convert.toString(request.getParameter(PedidoEspecialHelper.CAMPO_TELEFONO));
	String horario = Convert.toString(request.getParameter(PedidoEspecialHelper.CAMPO_HORARIO));
	String comentario = Convert.toString(request.getParameter(PedidoEspecialHelper.CAMPO_COMENTARIO));
%>

<b>Estimado/a <%=nombreCompleto%>:</b><br><br>

El producto que usted ha solicitado se encuentra actualmente sin stock, haremos todo lo posible para satisfacer su pedido.<br>
El precio está sujeto a variaciones determinadas por el proveedor.<br><br>

-----------------------------------------------------------------------------------------------------------------------<br>
<%=articuloLocal.getISBN()%> : <b><%=Convert.corregir(articuloLocal.getTITULO(), true)%></b><br>
-----------------------------------------------------------------------------------------------------------------------<br>
Teléfono: <%=telefono%><br>
Hora de contacto: <%=horario%><br>
Comentarios: <%=comentario%><br>
-----------------------------------------------------------------------------------------------------------------------<br><br>

Ante cualquier consulta contáctese con nuestro Departamento de Servicios al<br>
Cliente a través de <a href="mailto:<%=Globals.MAIL_CALL_CENTER%>" style="text-decoration:underline"><%=Globals.MAIL_CALL_CENTER%></a> o por teléfono al <%=Globals.TELEFONO_CALL_CENTER%><br>
desde la Argentina o al <%=Globals.TELEFONO_EXTERIOR_CALL_CENTER%> desde el exterior de <%=Globals.HORARIO_CALL_CENTER%>.<br><br>


<b>Muchas gracias.</b>
