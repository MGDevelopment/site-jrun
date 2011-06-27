<%@ page import="java.sql.Connection,
                 com.tmk.kernel.DBUtil,
                 java.sql.Statement,
                 java.sql.ResultSet,
                 javax.naming.NamingException,
                 java.sql.SQLException,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.TmkLogger"%>
<%
	StringBuffer sql = new StringBuffer();
	sql.append("select cse.descripcion   producto, ");
	sql.append("sum(ior.cantidad) cantidad, ");
	sql.append("sum(ior.cantidad * ior.precio_promocion) ventas ");
	sql.append("from categ_secciones       cse, ");
	sql.append("articulos             art, ");
	sql.append("item_orden            ior, ");
	sql.append("orden                 ord ");
	sql.append("where (art.categoria_seccion, art.categoria_grupo, art.categoria_familia) not in ((99, 1, 4), (99, 3, 1)) ");
	sql.append("and cse.categoria_seccion = art.categoria_seccion ");
	sql.append("and art.id_articulo       = ior.id_articulo ");
	sql.append("and ior.estado            = 'F' ");
	sql.append("and ior.id_orden          = ord.id_orden ");
	sql.append("and ord.id_seccion      = ").append(request.getParameter("ID_SECCION")).append(" ");
	sql.append("and ord.id_alianza        = ").append(request.getParameter("ID_ALIANZA")).append(" ");
	sql.append("and ord.fecha            >= to_date('01.07.2003','dd.mm.rrrr') ");
	sql.append("and ord.fecha             < sysdate + 1 ");
	sql.append("group by cse.descripcion ");
	%>
	<table align="center" cellspacing="0" cellpadding="3">
	<tr bgcolor="#CECFCE" align="center">
		<td>Producto</td>
		<td>Cantidad</td>
		<td>Ventas</td>
	</tr>
	<%

	int cantidadTotal = 0;
	double ventasTotales = 0;

	try
	{
		Connection conn = DBUtil.buildConnection();
		try {
			Statement statement = conn.createStatement();
	
			ResultSet resultSet = statement.executeQuery(sql.toString());
	
			while(resultSet.next())
			{
				String producto = resultSet.getString("producto");
				int cantidad = resultSet.getInt("cantidad");
				double ventas = resultSet.getDouble("ventas");
	
				ventasTotales += ventas;
	
				%>
				<tr align="center">
					<td align="left"><%= producto %></td>
					<td><%= cantidad %></td>
					<td> $ <%= ventas %>.-</td>
				</tr>
				<%
			}
	
			resultSet.close();
	
			statement.close();
	
		} catch (Exception e) {	
			TmkLogger.error(e.toString());
		} finally {
			conn.close();
		}	
	}
	catch (NamingException ne)
	{
		TmkLogger.error(ne.getMessage());
	}
	catch (SQLException se)
	{
		TmkLogger.error(se.getMessage());
	}

	%>
	<tr bgcolor="#9C9A9C" align="center">
		<td>TOTALES</td>
		<td><%= cantidadTotal %></td>
		<td> $ <%= ventasTotales %>.-</td>
	</tr>
	</table>
	<%
%>