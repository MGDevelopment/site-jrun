/**
 * $Log: ContenidoHelper.java,v $
 * Revision 1.1  2003/10/28 00:22:02  NRodriguez
 * Correncion intranet/extranet
 *
 * Revision 1.5  2003/10/07 15:29:31  NRodriguez
 * - Administracion de contenido - Ranking
 *
 * Revision 1.4  2003/10/03 16:30:22  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.3  2003/10/02 17:39:37  NRodriguez
 * - Nueva version de administrador de contenidos
 *
 * Revision 1.2  2003/09/30 20:17:09  GPistoia
 * -Cambios en site.xml para mejorar la configurabilidad.
 *
 * Revision 1.1  2003/09/26 23:27:19  NRodriguez
 * - Administrador de contenido, primera version. Solo productos
 *
 */
package com.tmk.controllers.intranet.contenido;

public class ContenidoHelper {

	public static final int LINK = 1;
	public static final int PRODUCTO = 2;
	public static final int PAPEL_REGALO = 3;
	public static final int RECOMENDADO = 4;
	public static final int EDITORIALES = 5;
	public static final int RANKING = 6;

	public static final String CAMPO_SECCION = "SECCION";
	public static final String CAMPO_TIPO = "TIPO";
	public static final String CAMPO_INDICE = "INDICE";

	public static final String CAMPO_ID = "ID";
	public static final String CAMPO_HINT = "HINT";
	public static final String CAMPO_TEXTO = "TEXTO";
	public static final String CAMPO_ICONO = "ICONO";

	public static final int HOME = 1;
	public static final int PRIMER_LISTA = 2;
	public static final int SEGUNDA_LISTA = 3;

	public static final String CAMPO_COMPONENTE = "COMPONENTE";
}
