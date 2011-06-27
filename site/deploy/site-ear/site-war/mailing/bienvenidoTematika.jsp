<%@ page import="com.tmk.src.socio.SocioPK,                 
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.bus.socio.SocioTMK,
                 java.sql.Connection"%>

<%--
                 //com.tmk.kernel.DBUtil,
                 //com.tmk.socio.SocioLocal,
                // com.tmk.socio.SocioLocalHome,
--%>

<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.soa.exceptions.DBOInexistenteException"%>
<%@page import="com.tmk.kernel.TmkLogger"%>

<%	
	SocioPK socioPK = new SocioPK();
	
	socioPK.ID_SUCURSAL = new Integer(request.getParameter("CAMPO_SUCURSAL"));
	socioPK.ID_SOCIO = new Integer(request.getParameter("CAMPO_SOCIO"));
	//SocioLocalHome socioHome = (SocioLocalHome)DBUtil.getHome("Socio");
	//SocioLocal socio = null;
	Socios2 socio = null;
	SocioTMK socioTMK = null;
	try {
		//socio = socioHome.findByPrimaryKey(socioPK);
		socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
	//} catch (Exception e) {
	} catch (DBOInexistenteException e) {
		/*socioTMK = new SocioTMK (socioPK.ID_SOCIO, socioPK.ID_SUCURSAL);
		Connection conn = DBUtil.buildConnection();
		try {
			socioTMK.select(conn);
		} finally {
			conn.close();
		}*/
		socioTMK = ServiceLocator.getSociosTMKService().findSocioTMKByPK(socioPK);
	} catch (Exception e) {
		TmkLogger.error(e.getMessage());
	}
	
	//String nombreCompleto = (socio!= null)? Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS()): (socioTMK!=null)?Convert.nombreCompleto(socioTMK.getNombres(), socioTMK.getApellidos()):"";
	String nombreCompleto = (socio!= null)? Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()): (socioTMK!=null)?Convert.nombreCompleto(socioTMK.getNombres(), socioTMK.getApellidos()):"";
%>

<b><font color="#004B85">Acaba de registrarse en</font><a href="<%=Globals.PAGINA_SITIO%>"><%=Globals.NOMBRE_DEL_SITIO%></a><font color="#004B85">!</font></b>
<br>
<br>
<b><font color="#004B85">Bienvenido/a <%= nombreCompleto %></font></b><br>
<b><font color="#004B85">En nuestro sitio encontrar&aacute; la oferta m&aacute;s
amplia y variada de libros, m&uacute;sica y pel&iacute;culas.</font></b><br>
<b><br>
</b>
<%@include file="/leyendas/promociones.htm"%><br>
<%--<font color="#004B85">Ante cualquier consulta contáctese con nuestro Departamento
de Servicios al Cliente a través de <a href="mailto:<%=Globals.MAIL_CALL_CENTER%>" style="text-decoration:underline"><%=Globals.MAIL_CALL_CENTER%></a> o por teléfono
al <%=Globals.TELEFONO_CALL_CENTER%> desde la Argentina o al <%=Globals.TELEFONO_EXTERIOR_CALL_CENTER%>
desde el exterior de <%=Globals.HORARIO_CALL_CENTER%>.</font><br>
<font color="#004B85">Esperamos que su estad&iacute;a en nuestro sitio sea placentera
y enriquecedora</font><br>
--%>
<br>
<%--<font color="#004B85">CONSULTE LAS NUEVAS PROMOCIONES:</font><br>--%>

<%--<%@include file="/leyendas/promociones.htm"%><br>--%>
<br>

<br>
<a href="<%=Globals.PAGINA_SITIO%>"><strong>GRUPO ILHSA S.A.</strong></a><br>
