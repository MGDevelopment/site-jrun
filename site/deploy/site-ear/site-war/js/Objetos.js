
function Pais(id, nombre)
{
	this.id = id;
	this.nombre = nombre;

	this.provincias = new Array();
	this.addProvincia = Pais_addProvincia;
}

function Pais_addProvincia(provincia)
{
	this.provincias[this.provincias.length] = provincia;
}

function Provincia(id, nombre)
{
	this.id = id;
	this.nombre = nombre;

	this.localidades = new Array();
	this.addLocalidad = Provincia_addLocalidad;
}

function Provincia_addLocalidad(localidad)
{
	this.localidades[this.localidades.length] = localidad;
}

function Localidad(id, nombre)
{
	this.id = id;
	this.nombre = nombre;
}
