<%@page import="com.tmk.bus.categoria.CategoriaPK"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.service.categoria.CategoriaService"%>
<%@page import="com.tmk.bus.categoria.Categoria"%>
<%@page import="com.tmk.kernel.Globals"%>

<%
	String codePK = (String)request.getParameter("categoriapk");
	int cantNivMaxAMos = 5;
%>

<div class="arbolCat">

<%
	CategoriaPK p1 = CategoriaPK.codeToPK(codePK);
	Integer[] pk = p1.getPK();
	String pathTemplate = "/templates/arbolTemplate.htm";

	if (pk[0].intValue() ==  0){
		//si es inicio, seteo todos los arboles
		out.println(CategoriaService.getCategoriaRediseno (
		new CategoriaPK(
			new Integer[]{new Integer(Globals.SECCION_LIBRO)}
			),pathTemplate,cantNivMaxAMos,0));

		out.println(CategoriaService.getCategoriaRediseno (
		new CategoriaPK(
				new Integer[]{new Integer(Globals.SECCION_MUSICA)}
			),pathTemplate,cantNivMaxAMos,0));

		out.println(CategoriaService.getCategoriaRediseno (
		new CategoriaPK(
				new Integer[]
					{new Integer(Globals.SECCION_PELICULA)}
			),pathTemplate,cantNivMaxAMos,0));

		out.println(CategoriaService.getCategoriaRediseno (
				new CategoriaPK(
						new Integer[]{new Integer(Globals.SECCION_JUGUETES)}
					),pathTemplate,cantNivMaxAMos,0));

	} else {
		out.println(CategoriaService.getCategoriaRediseno (new CategoriaPK(pk),pathTemplate,cantNivMaxAMos,1));
	}
%>
</div>