<%@ page import="java.sql.Connection,
                 com.tmk.kernel.DBUtil"%>
<%
    try {
		Connection connection = DBUtil.buildConnection();
	    connection.close();
	    out.println("BASE OK");
    } catch (Exception e) {

	}

%>