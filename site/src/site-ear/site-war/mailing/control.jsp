<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.common.RevitalizerDaemon,
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert"%>

CONTROL OPERACION JRUN <br><br>

<%=Convert.toString(RevitalizerDaemon.getControl(), "Este archivo se usa para asegurar que la aplicacion esta respondiendo")%></br>

