package com.tmk.controllers.intranet.usuario;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import com.tmk.controllers.intranet.usuario.UsuarioHelper;

public class EliminarUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String idUsuario = request.getParameter(UsuarioHelper.IDUSUARIO);
        System.out.println("usuario dado de baja: " + idUsuario);

        response.sendRedirect(UsuarioHelper.PAGINA_PRINCIPAL_USUARIO);

    }
}