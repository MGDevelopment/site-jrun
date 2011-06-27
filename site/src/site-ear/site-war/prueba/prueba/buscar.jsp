
<%@page import="java.util.Collection"%>
<%@page import="com.tmk.dbo.DBO"%>
<%@page import="java.util.TreeSet"%>
<%@page import="com.tmk.kernel.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.tmk.dbo.sql.OrderBYDBO"%>
<%@page import="com.tmk.dbo.sql.condicion.Operador"%>
<%@page import="com.tmk.dbo.sql.WhereDBO"%>
<%@page import="com.tmk.dbo.sql.condicion.Comparador"%>
<%@page import="com.tmk.dbo.sql.condicion.Condicion"%>
<%@page import="com.tmk.dbo.sql.CamposLeftJoinDBO"%>
<%@page import="com.tmk.bus.socio.Pais"%>
<%@page import="com.tmk.bus.socio.SocioDomicilios"%>
<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.dbo.sql.CamposABuscarDBO"%>
<%
	/*CamposABuscarDBO camposABuscar = new CamposABuscarDBO();	
	camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
	camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
	camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".sociosDomicilios");
	
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_socio");
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_sucursal");
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".tipo_domicilio");
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".calle");
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".numero");
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".edificio");
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".piso");
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".depto");
	
	camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".pais");
	
	camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
	camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
	camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".habilitado_tematika");
	
	//
	CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
	camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+".socioDomicilios");
	camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".pais");
	camposLeftJoin.setCampoDBOLeftJoin(Pais.getAlias()+".provincia");
	
	Condicion condicionIdSocio = new Condicion(Socios2.getAlias()+".id_socio",
			Comparador.IGUAL,"85750");	
	Condicion condicionIdSucursal= new Condicion(Socios2.getAlias()+".id_sucursal",
			Comparador.IGUAL,"201");
										
	WhereDBO where = new WhereDBO();
	where.add(condicionIdSocio);
	where.add(Operador.AND,condicionIdSucursal);
	
	//OrderBYDBO order = new OrderBYDBO();
	
	Connection con = null;
	try {
		try {
			con = DBUtil.buildConnection();
			Collection<DBO> socio = null;
			DBO.select2(Socios2.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());
			//out.print(socio.iterator().next().toString());
		} catch(SQLException e) {
			throw e;
		}
	}catch(Exception a) {
		a.printStackTrace();
	}
	finally {
		con.close();
	}*/
%>

<a href=/ServletTest.do">Link</a>