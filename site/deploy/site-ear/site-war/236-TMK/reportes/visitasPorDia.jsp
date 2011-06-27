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
	sql.append("select alz.razon_social, ");
	sql.append("als.seccion_nombre, ");
	sql.append("to_char(vas.fecha_visita, 'dd') dia, ");
	sql.append("min(decode(to_char(vas.fecha_visita, 'mm'), '01', 'Enero', ");
	sql.append("'02', 'Febrero', ");
	sql.append("'03', 'Marzo', ");
	sql.append("'04', 'Abril', ");
	sql.append("'05', 'Mayo', ");
	sql.append("'06', 'Junio', ");
	sql.append("'07', 'Julio', ");
	sql.append("'08', 'Agosto', ");
	sql.append("'09', 'Septiembre', ");
	sql.append("'10', 'Octubre', ");
	sql.append("'11', 'Noviembre', ");
	sql.append("'Diciembre' )) mes, ");
	sql.append("to_char(vas.fecha_visita, 'rrrr') anio, ");
	sql.append("sum(vas.cant_visitas) visitas ");
	sql.append("from alianza                  alz, ");
	sql.append("alianza_seccion          als, ");
	sql.append("visita_x_alianza_seccion vas ");
	sql.append("where alz.id_alianza  = als.id_alianza ");
	sql.append("and als.id_seccion  = vas.id_seccion ");
	sql.append("and als.id_alianza  = vas.id_alianza ");
	sql.append("and vas.id_seccion  = ").append(request.getParameter("ID_SECCION"));
	sql.append("and vas.id_alianza  = ").append(request.getParameter("ID_ALIANZA"));
	sql.append("and vas.fecha_visita >= sysdate - 180");
	sql.append("and vas.fecha_visita  < sysdate + 1");
	sql.append("group by alz.razon_social, ");
	sql.append("als.seccion_nombre, ");
	sql.append("to_char(vas.fecha_visita, 'rrrr'), ");
	sql.append("to_char(vas.fecha_visita, 'mm'), ");
	sql.append("to_char(vas.fecha_visita, 'dd') ");
	sql.append("order by 1, 2, ");
	sql.append("to_char(vas.fecha_visita, 'rrrr'), ");
	sql.append("to_char(vas.fecha_visita, 'mm'), ");
	sql.append("to_char(vas.fecha_visita, 'dd') ");

	%>
	<table align="center" cellspacing="0" cellpadding="3">
	<tr bgcolor="#CECFCE" align="center">
		<td>Año</td>
		<td>Mes</td>
		<td>Dia</td>
		<td>Visitas</td>
	</tr>
	<%

	int ultimo_anio = 0;
	String ultimo_mes = null;
	int visitasMes = 0;
	int total = 0;

	try
	{
		Connection conn = DBUtil.buildConnection();
		try {
			Statement statement = conn.createStatement();
	
			ResultSet resultSet = statement.executeQuery(sql.toString());
	
			while(resultSet.next())
			{
				int anio = resultSet.getInt("anio");
				String mes = resultSet.getString("mes");
				int dia = resultSet.getInt("dia");
				int visitas = resultSet.getInt("visitas");
	
				if(mes.equals(ultimo_mes) == false && ultimo_mes != null)
				{
					%>
					<tr align="center">
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td bgcolor="#CECFCE">SUBTOTAL</td>
						<td bgcolor="#CECFCE"><%= visitasMes %></td>
					</tr>
					<%
	
					total += visitasMes;
					visitasMes = 0;
				}
	
				visitasMes += visitas;
	
				%>
				<tr align="center">
					<td>
					<%
					if(ultimo_anio == 0 || ultimo_anio != anio)
					{
						ultimo_anio = anio;
	
						%><%= ultimo_anio %><%
					}
					else
					{
						%>&nbsp;<%
					}
					%>
					</td>
					<td align="left">
					<%
					if(ultimo_mes == null || ultimo_mes.equals(mes) == false)
					{
						ultimo_mes = mes;
	
						%><%= ultimo_mes %><%
					}
					else
					{
						%>&nbsp;<%
					}
					%>
	                </td>
					<td><%= dia %></td>
					<td><%= visitas %></td>
				</tr>
				<%
			}
			%>
			<tr align="center">
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td bgcolor="#CECFCE">SUBTOTAL</td>
				<td bgcolor="#CECFCE"><%= visitasMes %></td>
			</tr>
			<%
	
	
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
		<td>&nbsp;</td>
		<td>TOTAL</td>
		<td><%= total %></td>
	</tr>
	</table>
	<%
%>