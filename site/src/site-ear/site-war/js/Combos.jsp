<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.PaisDAO,
                 com.tmk.kernel.ProvinciaDAO,
                 com.tmk.kernel.LocalidadDAO"%>

<script type="text/javascript">
<!--
	var paises = new Array();
<%	for (int i = 0; i < Globals.PAISES.length; i++) {
		PaisDAO paisDAO = Globals.PAISES[i]; %>
		paises[paises.length] = new Combo(<%= paisDAO.getId() %>, '<%= paisDAO.getNombre() %>');
<%		ProvinciaDAO provincias[] = paisDAO.getProvincias();

		for (int j = 0; j < provincias.length; j++) {
			ProvinciaDAO provinciaDAO = provincias[j];
			//chequeo para que no mustre el sitio la pronvicia "No informada"
			if((paisDAO!=null && paisDAO.getId() == 300) && (provinciaDAO != null && provinciaDAO.getId() == 424)){
				 continue;
			}
%>
			paises[paises.length-1].addComboDependiente(new Combo(<%= provinciaDAO.getId() %>, '<%= provinciaDAO.getNombre() %>'));
<%			LocalidadDAO localidades[] = provinciaDAO.getLocalidades();

			for (int k = 0; k < localidades.length; k++) {
				LocalidadDAO localidadDAO = localidades[k]; %>
				paises[paises.length-1].comboDependiente[paises[paises.length-1].comboDependiente.length-1].addComboDependiente(new Combo(<%= localidadDAO.getId() %>, '<%= localidadDAO.getNombre() %>'));
<%			}
		}
	} %>

var INDEX_PAIS = 0;
var INDEX_PROVINCIA = 0;


function activarOtraProvincia() {
	if (document.formDomicilio.ID_PROVINCIA.value == 99999) {
		document.formDomicilio.PROVINCIA_EXTERNA.disabled = false;
		document.formDomicilio.PROVINCIA_EXTERNA.focus;
	} else {
		document.formDomicilio.PROVINCIA_EXTERNA.value = "";
		document.formDomicilio.PROVINCIA_EXTERNA.disabled = true;
	}
}

function activarOtraLocalidad() {
	if (document.formDomicilio.ID_LOCALIDAD.value == 99999) {
		document.formDomicilio.LOCALIDAD_EXTERNA.disabled = false;
		document.formDomicilio.LOCALIDAD_EXTERNA.focus;
	} else {
		document.formDomicilio.LOCALIDAD_EXTERNA.value = "";
		document.formDomicilio.LOCALIDAD_EXTERNA.disabled = true;
	}
}


-->
</script>
