<%@ page import="com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.categoria.CategGrupoLocalHome,
                 java.util.Iterator,
                 com.tmk.kernel.Globals,
                 com.tmk.categoria.CategGrupoLocal,
                 com.tmk.setup.Contenido,
                 com.tmk.categoria.CategFamiliaLocalHome,
                 com.tmk.categoria.CategFamiliaLocal,
                 com.tmk.kernel.DBUtil,
                 java.util.Vector,
                 com.tmk.kernel.AtributoDinamicoDAO,
                 com.tmk.controllers.buscador.BusquedaGenerica,
                 com.tmk.controllers.buscador.BusquedaPorAtributosDinamicos,
                 com.tmk.kernel.Convert"
               %>

    <script src="/js/Combo.js" type="text/javascript"></script>
	<script type="text/javascript">
	function getAtributos() {
		var f = document.formSearch;
		if (f.<%= BuscadorHelper.CATEGORIA_FAMILIA%>.options[f.<%= BuscadorHelper.CATEGORIA_FAMILIA%>.selectedIndex].value!='') {
			f.action='<%= BuscadorHelper.PAGINA_ATRIBUTOS_DINAMICOS%>';
			f.submit()
		}
	}



	var catGrupo = new Array();
<%
    Integer paramGrupo = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_GRUPO), new Integer(-1));
	Integer paramFamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_FAMILIA), new Integer(-1));
	Vector atributos = (Vector)session.getAttribute("BusquedaAvanzada.atributos");
    session.removeAttribute("BusquedaAvanzada.atributos");

	CategGrupoLocalHome grupoLocalHome = (CategGrupoLocalHome) DBUtil.getHome("CategGrupo");
	Iterator grupos = grupoLocalHome.findByCategoria(new Integer(Globals.SECCION_ACCESORIOS)).iterator();
	while (grupos.hasNext()) {
		CategGrupoLocal grupo = (CategGrupoLocal) grupos.next();
%>      catGrupo [catGrupo.length] = new Combo('<%=grupo.getCATEGORIA_GRUPO()%>', '<%=Convert.corregir(grupo.getDESCRIPCION().replaceAll("'", ""), true)%>');
<%
		CategFamiliaLocalHome familiaLocalHome = (CategFamiliaLocalHome) DBUtil.getHome("CategFamilia");
		Iterator familias = familiaLocalHome.findByCategoria(new Integer (Globals.SECCION_ACCESORIOS), grupo.getCATEGORIA_GRUPO()).iterator();
%>
		catGrupo[catGrupo.length-1].addComboDependiente(new Combo('', 'Seleccione'));
<%
		while (familias.hasNext()) {
			CategFamiliaLocal familia = (CategFamiliaLocal) familias.next();
%>          catGrupo[catGrupo.length-1].addComboDependiente(new Combo('<%= familia.getCATEGORIA_FAMILIA() %>', '<%=Convert.corregir(familia.getDESCRIPCION().replaceAll("'", ""), true)%>'));
<%		}
	}
%>
    </script>


	<table width="616" align="center">
		<tr>
			<td colspan="2"><h3><br><b>Busqueda Avanzada de Accesorios</b></h3></td>
		</tr>
		<tr>
			<td colspan="2"><b>Ingrese los Criterios de Busqueda</b><br>&nbsp;</td>
		</tr>

	</table>
	<br>
	<table width="90%" align="center" border="0">
		<tr>
			<td width="35%">
				Clasificación
			</td>
			<td width="65%">
				<select name = "<%= BuscadorHelper.CATEGORIA_GRUPO%>" onchange="actualizarCombo(this, formSearch.familia, catGrupo);">
	                <script>
					var indiceGrupo = 0
					var grupoActual = <%= paramGrupo%>
	                for(i = 0; i < catGrupo.length; i++) {
	                    if (grupoActual == catGrupo[i].id) {
							document.write('<option value="' + catGrupo[i].id + '" selected>');
							indiceGrupo = i;
						} else {
	                        document.write('<option value="' + catGrupo[i].id + '">');
	                    }
						document.write(catGrupo[i].descripcion);
						document.write('</option>');
					}
					</script>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				Tipo de Producto
			</td>
			<td>
				<select name = "<%= BuscadorHelper.CATEGORIA_FAMILIA%>" onchange = "getAtributos()" Style="width:150;">

					<script>
					var familiaActual = <%= paramFamilia%>

					for(i = 0; i < catGrupo[indiceGrupo].comboDependiente.length; i++) {
						if (familiaActual == catGrupo[indiceGrupo].comboDependiente[i].id) {
							document.write('<option value="' + catGrupo[indiceGrupo].comboDependiente[i].id + '" selected>');
						} else {
							document.write('<option value="' + catGrupo[indiceGrupo].comboDependiente[i].id + '">');
						}
						document.write(catGrupo[indiceGrupo].comboDependiente[i].descripcion);
						document.write('</option>');
					}
					</script>
				</select>
			</td>
		</tr>
<%
	if (atributos != null) {
		for (int i = 0; i < atributos.size(); i++) {
			AtributoDinamicoDAO item = (AtributoDinamicoDAO) atributos.get(i);
%>

		<tr>
			<td>
				<%= item.getTexto() %>
				<input type="hidden" name="<%=BuscadorHelper.NOMBRE_ATRIBUTO + i%>" value="<%= item.getCampo() %>">
			</td>
			<td>
				<select name="<%=BuscadorHelper.VALOR_ATRIBUTO + i%>">
					<option value=""> No Filtrar </option>
<%
			for (int j = 0; j < item.getValores().size(); j++) {
%>
            	    <option value="<%= item.getValores().get(j) %>"><%= item.getValores().get(j) %></option>
<%
			}
%>
                </select>
			</td>
		</tr>
<%
		}
		BusquedaGenerica	busqueda = new BusquedaPorAtributosDinamicos(
		        new Integer (Globals.SECCION_ACCESORIOS), paramGrupo, paramFamilia, null,
		        null, null, null, false, new Vector());


%>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan=2 align = "right">
				<input src="/imagenes/buscar.gif"  type = "image" onclick="formSearch.action = '<%=busqueda.salto()%>'; formSearch.submit();" value="Buscar">
			</td>
		</tr>
<%
	}
%>
	</table>

