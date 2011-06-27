package com.tmk.controllers.intranet.usuario;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;

public class UsuarioHelper extends HttpServlet {

    public static String IDUSUARIO = "IDUSUARIO";
    public static String NOMBRE = "NOMBRE";
    public static String APELLIDO = "APELLIDO";
    public static String LOGIN = "LOGIN";
    public static String PASSWORD = "PASSWORD";

    public static String PAGINA_LOGIN_INTRANET = "/236-TMK/index.jsp";
    public static String PAGINA_INICIO_INTRANET = "/236-TMK/inicio.jsp";
    public static String PAGINA_PRINCIPAL_USUARIO = "/236-TMK/usuarios/index.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}