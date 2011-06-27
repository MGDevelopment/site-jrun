/**
 * $Log: ComentarioHelper.java,v $
 * Revision 1.7  2008/08/06 14:15:58  msartori
 * Cambio manual de uso extranet
 * Comentarios visibles en articulo con ajax
 * Carga de comentarios fuera de https
 * Correcciones en generadores de feed de wishlist y comentarios
 * Metodos getALL y getALL con params en DBO
 *
 * Revision 1.6  2004/09/24 20:19:44  omsartori
 * - Capitalización de titulo en reporte de comentarios
 * - Mailto en reporte de comentarios
 * - Edición de comentarios por parte del socio autor
 * - Nickname para firmar comentarios
 *
 * Revision 1.5  2004/09/23 18:45:08  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.4  2004/09/14 17:22:23  omsartori
 * Bug de imagenes con tam erroneos
 * Bug de direcciones (otra localidad, otra provincia)
 * Bug de inicio de sesion (link a pagina null)
 *
 * Revision 1.3  2004/09/10 15:13:18  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.2  2004/09/07 16:15:37  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.1  2004/08/09 13:41:49  omsartori
 * - Comentario para articulos desde la web
 * - Aprobación de comentarios desde la intranet
 * - Ancla para extensiones en detalle de articulo
 *
 */

package com.tmk.controllers.comentario;

public class ComentarioHelper {

    //public static String CAMPO_ARTICULO = "ID_ARTICULO";
	public static String CAMPO_ARTICULO = "id_articulo";
    public static String CAMPO_COMENTARIO = "COMENTARIO";
    public static String CAMPO_EVALUACION = "EVALUACION";

    public static String CAMPO_SUCURSAL = "SUCURSAL";
    public static String CAMPO_SOCIO = "SOCIO";

    public static String SERVLET = "/Comentario";
    public static String SERVLET_ = SERVLET + "?" + CAMPO_ARTICULO + "=";
    public static String PAGINA_DATOS_ = "/comentario/agregarComentario.jsp?" + CAMPO_ARTICULO + "=";
    public static String PAGINA_CONFIRMACION = "/comentario/comentarioConfirmado.jsp";
    public static String PAGINA_ANTERIOR = "/articulo/detalleArticulo.jsp?idArticulo=";

    public static String APROBADO = "A";
    public static String RECHAZADO = "R";
    public static String PENDIENTE = "N";

    //public static String CAMPO_ID_COMENTARIO = "ID_COMENTARIO";
    public static String CAMPO_ID_COMENTARIO = "id_comentario";
    //public static String CAMPO_ESTADO = "ESTADO";
    public static String CAMPO_ESTADO = "estado";
    //public static String CAMPO_CANTIDAD_COMENTARIO = "CANTIDAD_COMENTARIO";
    public static String CAMPO_CANTIDAD_COMENTARIO = "totalCount";
    public static String CAMPO_NICKNAME = "NICKNAME";
    public static String CAMPO_USO_NICKNAME = "USO_NICKNAME";

	public static final int MINIMO_EVALUACION = 1;
	public static final int MAXIMO_EVALUACION = 5;
	public static final String TEXTOS[] =
	        { "Malo, no recomendado",
	          "Regular",
	          "Bueno",
	          "Muy Bueno",
	          "Excelente"};

}
