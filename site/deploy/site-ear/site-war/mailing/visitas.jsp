<%@ page import="com.tmk.kernel.Convert,
                 java.sql.Connection,
                 java.sql.PreparedStatement,
                 java.sql.ResultSet,
                 com.tmk.kernel.DBUtil,
                 java.util.Vector,
                 com.tmk.kernel.Pair,
                 java.sql.Timestamp,
                 com.tmk.controllers.alianza.EstadisticaVisitas"%>

<% boolean mostrarEnMeses = false; %>

<%// com.tmk.controllers.alianza.EstadisticaVisitas.flush(); %>

<br><b>Visitas del d�a</b><br>
<%  Vector resultados = DBUtil.calcularVisitas(true, true, true, 0, 24); %>
<%@include file="/mailing/detalleVisitas.jsp"%>

<br><b>Horarios m�s visitados</b><br>
<%  resultados = DBUtil.calcularVisitas(true, false, false, 30, 4); %>
<%@include file="/mailing/detalleVisitas.jsp"%>

<br><b>Horarios menos visitados</b><br>
<% resultados = DBUtil.calcularVisitas(true, false, true, 30, 2); %>
<%@include file="/mailing/detalleVisitas.jsp"%>

<%  mostrarEnMeses = true; %>

<br><b>Visitas por mes</b><br>
<%  resultados = DBUtil.calcularVisitas(false, true, false, 365 + 31, 12 + 1 /* Para comparar con el mes del a�o pasado*/); %>
<%@include file="/mailing/detalleVisitas.jsp"%>
