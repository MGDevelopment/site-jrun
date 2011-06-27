/**
 * Created by IntelliJ IDEA.
 * User: odzurita
 * Date: Nov 9, 2005
 * Time: 3:48:37 PM
 * To change this template use Options | File Templates.
 */
package com.tmk.controllers.intranet.contenido;

import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Globals;
import com.tmk.articulo.EditorLocalHome;
import com.tmk.articulo.EditorLocal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.ejb.FinderException;
import java.io.IOException;

public class ModificarEditor  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer idEditor = Convert.toNumber(request.getParameter("idEditor"),(Integer)null);
        String urlEditor = Convert.toString(request.getParameter("urlEditor"),null);
        /*parametros de la busqueda*/
        int idEditorial = Convert.toNumber(request.getParameter("idEditorial"),0);
        String nombre = Convert.toString(request.getParameter("nombre"),"");
        /*parametros de la busqueda*/
        if(idEditor == null){
            response.sendRedirect("urlEditoriales.jsp");
        }
        try{
            EditorLocalHome editorHome = (EditorLocalHome) DBUtil.getHome("Editor");
            EditorLocal editorLocal = editorHome.findByPrimaryKey(idEditor);
            if(urlEditor!=null){
                urlEditor = "http://" + urlEditor;
            }
            editorLocal.setURL(urlEditor);
            session.setAttribute("edicionEditorOk", "Se actualizó la editorial correctamente.");
        }
        catch (FinderException fe){
            TmkLogger.debug("No se pudo encontrar el Editor solicitado");
            session.setAttribute("edicionEditorError", "No se pudo actualizar la editorial.");
        }
        catch (Exception e){
            TmkLogger.debug("Error al acceder a la tabla EDITORES");
        }
        response.sendRedirect(Globals.PAGINA_SITIO + "/236-TMK/contenido/urlEditoriales.jsp?senal=1&idEditorial=" + idEditorial + "&nombre=" + nombre);
    }
}
