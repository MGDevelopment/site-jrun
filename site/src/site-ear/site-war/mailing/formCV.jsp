<%@ page import="com.tmk.categoria.CategGrupoLocalHome,
                 java.util.Iterator,
                 com.tmk.categoria.CategGrupoLocal,
                 java.util.Vector,
                 com.tmk.kernel.*"%>
<%
	String nombre = Convert.toString(request.getParameter("nombre"), "");
	String apellido = Convert.toString(request.getParameter("apellido"), "");
	String fechaNac = Convert.toString(request.getParameter("fechaNac"), "");
	String edad = Convert.toString(request.getParameter("edad"), "");
	String tipoDocumento = Convert.toString(request.getParameter("tipoDocumento"), "");
    String nroDocumento = Convert.toString(request.getParameter("nroDocumento"), "");
    String sexo = Convert.toString(request.getParameter("sexo"), "");
	String direccion = Convert.toString(request.getParameter("direccion"), "");


	PaisDAO paisDAO = Globals.ARGENTINA;
	int idProvincia = Convert.toNumber(request.getParameter("provincia"), 0);

	ProvinciaDAO provinciaDAO = paisDAO.getProvincia(idProvincia);
    String provincia = provinciaDAO.getNombre();

	int idLocalidad = Convert.toNumber(request.getParameter("localidad"), 0);

	String localidad = "";
	if (Globals.CODIGO_OTRA_LOCALIDAD == idLocalidad) {
		localidad = Convert.toString(request.getParameter("otraLocalidad"), "");
	} else {
		LocalidadDAO localidadDAO = provinciaDAO.getLocalidad(idLocalidad);
		localidad = localidadDAO.getNombre();
	}


	String codigoPostal = Convert.toString(request.getParameter("codigoPostal"), "");
    String telContacto1 = Convert.toString(request.getParameter("telContacto1"), "");
	String telContacto2 = Convert.toString(request.getParameter("telContacto2"), "");
	String email = Convert.toString(request.getParameter("email"), "");
	String nivelEstudio = Convert.toString(request.getParameter("nivelEstudio"), "");
	String estadoEstudio = Convert.toString(request.getParameter("estadoEstudio"), "");
    String institucion = Convert.toString(request.getParameter("institucion"), "");
	String ultimoCursado = Convert.toString(request.getParameter("ultimoCursado"), "");
    String areaEstudio = Convert.toString(request.getParameter("areaEstudio"), "");
    String idioma1 = Convert.toString(request.getParameter("idioma1"), "");
	String idioma2 = Convert.toString(request.getParameter("idioma2"), "");
	String idioma3 = Convert.toString(request.getParameter("idioma3"), "");
	String nivelIdioma1 = Convert.toString(request.getParameter("nivelIdioma1"), "");
	String nivelIdioma2 = Convert.toString(request.getParameter("nivelIdioma2"), "");
	String nivelIdioma3 = Convert.toString(request.getParameter("nivelIdioma3"), "");
    String otroIdioma = Convert.toString(request.getParameter("otroIdioma"), "");

	int cantExp = Convert.toNumber(request.getParameter("cantExp"), 0);

	String [] fechaDesde = new String [cantExp];
	for (int i=0; i<cantExp; i++) {
		fechaDesde[i] = Convert.toString(request.getParameter("fechaDesde" + (i+1)), "");
	}

	String [] fechaHasta = new String [cantExp];
	for (int i=0; i<cantExp; i++) {
		fechaHasta[i] = Convert.toString(request.getParameter("fechaHasta" + (i+1)), "");
	}

	String [] empresa = new String [cantExp];
    for (int i=0; i<cantExp; i++) {
		empresa[i] = Convert.toString(request.getParameter("empresa" + (i+1)), "");
	}

	String [] actividad = new String [cantExp];
    for (int i=0; i<cantExp; i++) {
		actividad[i] = Convert.toString(request.getParameter("actividad" + (i+1)), "");
	}

	String [] tipoCargo = new String [cantExp];
	for (int i=0; i<cantExp; i++) {
		tipoCargo[i] = Convert.toString(request.getParameter("tipoCargo" + (i+1)), "");
	}

	String [] cargo = new String [cantExp];
	for (int i=0; i<cantExp; i++) {
		cargo[i] = Convert.toString(request.getParameter("cargo" + (i+1)), "");
	}

	String [] funcion = new String [cantExp];
	for (int i=0; i<cantExp; i++) {
		funcion[i] = Convert.toString(request.getParameter("funcion" + (i+1)), "");
	}

    String [] ocupacion = new String [cantExp];
	for (int i=0; i<cantExp; i++) {
		ocupacion[i] = Convert.toString(request.getParameter("ocupacion" + (i+1)), "");
	}

    String [] motivoEgreso = new String [cantExp];
	for (int i=0; i<cantExp; i++) {
		motivoEgreso[i] = Convert.toString(request.getParameter("motivoEgreso" + (i+1)), "");
	}

    String puestoPostulado = Convert.toString(request.getParameter("puestoPostulado"), "");

	String puestoVendedor = "";
	if (puestoPostulado.equals("Vendedor")) {
    	int cantTipoVendedor = Convert.toNumber(request.getParameter("cantTipoVendedor"), 0);
		for (int i=0; i<cantTipoVendedor; i++) {
			if ("on".equals(request.getParameter("tipoVendedor" + (i+1)))) {
                puestoVendedor = puestoVendedor + Convert.toString(request.getParameter("tipoVendedorDesc" + (i+1)), "") + "<br>";
			}
		}
	}


	//AHORA A MOSTRAR

%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<style>
		body
		{
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 10px;
		}

		td
		{
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 11px;

		}

		select
		{
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 11px;
		}

		input
		{
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 11px;
		}

		a
		{
			color: #000000;
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 10px;
		}

		.textoSolapa
		{
			font-weight: bold;
			font-size: 11px;
			text-decoration: none;
		}

		.textoTitulo
		{
			color: #990000;
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 12px;
		}
		</style>
	</head>
	<body>

		<table width="600" style="border: 1px solid #59B3D9; border-top: 20px solid #59B3D9; border-bottom: 5px solid #59B3D9;">
			<tr>
				<td colspan="2" class="textoTitulo">
					<br><b>&nbsp;&nbsp;&nbsp;Datos personales</b><br><br>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Nombre</b>
				</td>
				<td>
					<%=nombre%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Apellido</b>
				</td>
				<td>
					<%=apellido%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Fecha de Nacimiento</b>
				</td>
				<td>
					<%=fechaNac%>&nbsp;(<%=edad%>)
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Tipo y Número de documento</b>
				</td>
				<td>
					<%=tipoDocumento%>&nbsp;<%=nroDocumento%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Sexo</b>
				</td>
				<td>
					<%=sexo%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Direccion</b>
				</td>
				<td>
					<%=direccion%>&nbsp;<%=localidad%>&nbsp;(<%=codigoPostal%>),&nbsp;<%=provincia%>,&nbsp;Argentina
				</td>
			</tr>
			<tr>
				<td colspan="2"class="textoTitulo">
					<hr color="#59B3D9" size="1"><br>
					<b>&nbsp;&nbsp;&nbsp;Datos Contacto<b><br><br>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Teléfonos</b>
				</td>
				<td>
					<%=telContacto1%><br>
					<%=telContacto2%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;e-Mail</b>
				</td>
				<td>
					<%=email%>
				</td>
			</tr>
			<tr>
				<td colspan="2"  class="textoTitulo">
					<hr color="#59B3D9" size="1" ><BR>
					<b>&nbsp;&nbsp;&nbsp;Estudios</b><br><br>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Maximo nivel alcanzado</b>
				</td>
				<td>
					<%=nivelEstudio%>&nbsp;<%=estadoEstudio%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Institución</b>
				</td>
				<td>
					<%=institucion%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Ultimo año cursado</b>
				</td>
				<td>
					<%=ultimoCursado%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Area de Estudios</b>
				</td>
				<td>
					<%=areaEstudio%>
				</td>
			</tr>
			<tr>
				<td>
					<b>&nbsp;&nbsp;&nbsp;Idioma</b>
				</td>
				<td>
					<%=idioma1%>&nbsp;<%=nivelIdioma1%>
				</td>
			</tr>
			<% if (!idioma2.equals("")) {%>
			<tr>
				<td>

				</td>
				<td>
					<%=idioma2%>&nbsp;<%=nivelIdioma2%>
				</td>
			</tr>
			<%}%>
			<% if (!idioma3.equals("")) {%>
			<tr>
				<td>

				</td>
				<td>
					<%=idioma3%>&nbsp;<%=nivelIdioma3%>
				</td>
			</tr>
			<%}%>
			<%if (!otroIdioma.equals("")) {%>
			<tr>
				<td>

				</td>
				<td>
					<%=otroIdioma%>
				</td>
			</tr>
			<%}%>
			<%if (cantExp > 0){%>
			<tr>
				<td colspan="2" class="textoTitulo">
					<hr color="#59B3D9" size="1"><BR>
					<b>&nbsp;&nbsp;&nbsp;Experiencia laboral</b><BR>
				</td>
			</tr>
			<%}%>
			<tr>
				<td colspan=2>
					<%for (int i=0; i<cantExp; i++) {%>
					<table width="90%" cellpadding=1 cellspacing=1 style="border: 1px solid #59B3D9;"  align="center">
						<tr>

							<td colspan=2>
								<table>
									<tr>
										<td>
											&nbsp;&nbsp;&nbsp;Desde el
										</td>
										<td>
											<span style="text-decoration:underline"><%=fechaDesde[i]%></span>
										</td>

										<td>
											&nbsp; &nbsp;Hasta el
										</td>

										<td>
											<span style="text-decoration:underline"><%=fechaHasta[i]%></span>
										</td>

										<%if (i==0) {%>

										<td>

										</td>
										<%}%>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td width="230"><b>&nbsp;&nbsp;&nbsp;Nombre de la empresa</b></td>
							<td><%=empresa[i]%></td>
						</tr>

						<tr>
							<td><b>&nbsp;&nbsp;&nbsp;Actividad de la empresa</b></td>
							<td>
								<%=actividad[i]%>
							</td>
						</tr>
						<tr heigth="35">
							<td>
								<b>&nbsp;&nbsp;&nbsp;Cargo desempeñado</b>
							</td>
							<td>
								<%=tipoCargo[i]%>
								<%if (tipoCargo[i].equals("Cargo ejecutivo")) {%>
									<br>Cargo<%=cargo[i]%><br>Función&nbsp;<%=funcion[i]%>
								<%} else {%>
									<br>Ocupación&nbsp;<%=ocupacion[i]%>
								<%}%>
							</td>
						</tr>

						<tr>
							<td>

							</td>
						</tr>

						<tr>
							<td valign="top" colspan="2">
								&nbsp;&nbsp;&nbsp;<b>Motivo de Egreso</b>
							</td>
						</tr>
						<tr>
							<td  colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=motivoEgreso[i]%>
							</td>
						</tr>
						<tr>
							<td colspan="2" Style="font-size:5">
							&nbsp;
							</td>
						</tr>

					</table>
					<%}%>
				</td>
			</tr>
			<tr>
				<td>
					Puesto para el que se postula
				</td>
				<td>
					<%=puestoPostulado%>
				</td>

			</tr>
			<%if (!puestoVendedor.equals("")){%>
			<tr>
				<td>
				</td>
				<td>
					<%=puestoVendedor%>
				</td>
			</tr>
			<%}%>
		</table>
	</body>
</html>















