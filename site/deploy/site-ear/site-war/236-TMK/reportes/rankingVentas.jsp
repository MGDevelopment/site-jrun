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
	sql.append("select ais.isbn isbn, ");
	sql.append("art.titulo titulo, ");
	sql.append("sum(ior.cantidad) cantidad, ");
	sql.append("ior.precio_promocion precio_unitario, ");
	sql.append("sum(ior.cantidad * ior.precio_promocion) precio_total ");
	sql.append("from articulos_isbn        ais, ");
	sql.append("articulos             art, ");
	sql.append("item_orden            ior, ");
	sql.append("orden                 ord ");
	sql.append("where ais.tipo_codigo (+) = 'I' ");
	sql.append("and ais.id_articulo (+) = ior.id_articulo ");
	sql.append("and art.id_articulo     = ior.id_articulo ");
	sql.append("and ior.estado          = 'F' ");
	sql.append("and ior.id_orden        = ord.id_orden ");
	sql.append("and ord.id_seccion      = ").append(request.getParameter("ID_SECCION")).append(" ");
	sql.append("and ord.id_alianza      = ").append(request.getParameter("ID_ALIANZA")).append(" ");
	sql.append("and ord.fecha          >= to_date('01.07.2003','dd.mm.rrrr') ");
	sql.append("and ord.fecha           < ( sysdate ) + 1 ");
	sql.append("group by art.id_articulo, ");
	sql.append("ais.isbn, ");
	sql.append("art.titulo, ");
	sql.append("ior.precio_promocion ");
	sql.append("order by 1, 2, 3 ");

	%>
	<table align="center" cellspacing="0" cellpadding="3">
	<tr bgcolor="#CECFCE" align="center">
		<td>ISBN - Código</td>
		<td>Título</td>
		<td>Cantidad</td>
		<td>Precio Unitario</td>
		<td>Precio Total</td>
	</tr>
	<%

	int cantidadTotal = 0;
	double precioTotal = 0;

	try
	{
		Connection conn = DBUtil.buildConnection();
		try {
			Statement statement = conn.createStatement();
	
			ResultSet resultSet = statement.executeQuery(sql.toString());
	
			while(resultSet.next())
			{
				String isbn = resultSet.getString("isbn");
				String titulo = resultSet.getString("titulo");
				int cantidad = resultSet.getInt("cantidad");
				double precio_unitario = resultSet.getDouble("precio_unitario");
				double precio_total = resultSet.getDouble("precio_total");
	
				cantidadTotal += cantidad;
				precioTotal += precio_total;
	
				%>
				<tr align="center">
					<td><%= isbn %></td>
					<td align="left"><%= Convert.corregir(titulo, true) %></td>
					<td><%= cantidad %></td>
					<td> $ <%= precio_unitario %>.-</td>
					<td> $ <%= precio_total %>.-</td>
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
		<td>&nbsp;</td>
		<td>TOTAL</td>
		<td><%= cantidadTotal %></td>
		<td>&nbsp;</td>
		<td><%= precioTotal %></td>
	</tr>
	</table>
	<%
%>