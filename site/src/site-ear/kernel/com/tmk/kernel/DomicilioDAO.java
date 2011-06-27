/**
 * $Log: DomicilioDAO.java,v $
 * Revision 1.16  2004/02/16 20:22:53  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.15  2003/12/04 17:19:10  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.14  2003/11/19 18:55:26  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.13  2003/10/07 14:52:16  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.12  2003/10/03 16:29:03  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.11  2003/09/25 19:17:12  GPistoia
 * -Soporte Orden migrada
 * -Metodos en Articulo (sinopsis y directores)
 * -Funciones de presentacion
 *
 * Revision 1.10  2003/09/11 18:08:42  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.9  2003/08/22 14:03:55  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.8  2003/08/21 17:48:26  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.7  2003/08/12 16:25:25  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.6  2003/08/11 14:26:41  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.5  2003/08/09 22:54:56  SLizardo
 * no message
 *
 * Revision 1.4  2003/08/09 18:22:01  GPistoia
 * -Autores en el articulo
 *
 * Revision 1.3  2003/08/04 22:17:51  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.2  2003/08/02 16:58:06  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.1  2003/07/26 19:06:06  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel;

import com.tmk.socio.SocioDomicilioLocal;
import com.tmk.socio.SocioDomicilioLocalHome;
import com.tmk.socio.SocioDomicilioPK;

import java.io.Serializable;

public class DomicilioDAO implements Serializable {

	public static String HEADER_ENVIO = "EN";
	public static String HEADER_FACTURACION = "TF";

	private Integer idSucursal;
	private Integer idSocio;
	private String tipoDomicilio = null; // Es nueva

	private String calle;
	private Integer numero;
	private String edificio;
	private Integer piso;
	private String depto;
	private String codigoPostal;
	private Integer pais;
	private Integer provincia;
	private Integer localidad;
	private String provinciaExterna;
	private String localidadExterna;

	public DomicilioDAO() {
		super();
	}

	public DomicilioDAO(
	        Integer idSucursal, Integer idSocio, String tipoDomicilio,
	        String calle, Integer numero, String edificio, Integer piso,
	        String depto, String codigoPostal,
	        Integer pais, Integer provincia, Integer localidad,
	        String provinciaExterna, String localidadExterna) {
		super();
		this.idSucursal = idSucursal;
		this.idSocio = idSocio;
		this.tipoDomicilio = tipoDomicilio;
		this.calle = calle;
		this.numero = numero;
		this.edificio = edificio;
		this.piso = piso;
		this.depto = depto;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.provinciaExterna = provinciaExterna;
		this.localidadExterna = localidadExterna;
	}

	public boolean esNueva() {
		return (tipoDomicilio == null);
	}

	public Integer getSucursal() {
		return idSucursal;
	}

	public Integer getSocio() {
		return idSocio;
	}

	public String getTipoDomicilio() {
		return tipoDomicilio;
	}

	public String getCalle() {
		return calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getEdificio() {
		return edificio;
	}

	public Integer getPiso() {
		return piso;
	}

	public String getDepto() {
		return depto;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public Integer getIdPais() {
		return pais;
	}

	public Integer getIdProvincia() {
		return provincia;
	}

	public Integer getIdLocalidad() {
		return localidad;
	}

	public PaisDAO getPais() {
		return PaisDAO.getPais(pais);
	}

	public ProvinciaDAO getProvincia() {
		return getPais().getProvincia(provincia);
	}

	public LocalidadDAO getLocalidad() {
		return getProvincia().getLocalidad(localidad);
	}

	public String getProvinciaExterna() {
		return provinciaExterna;
	}

	public String getLocalidadExterna() {
		return localidadExterna;
	}

	public boolean equals(Object object) {
		DomicilioDAO domicilio = (DomicilioDAO) object;
		return (this == object) ||
		        ((object instanceof DomicilioDAO) &&
		        compare(tipoDomicilio, domicilio.tipoDomicilio) &&
		        compare(calle, domicilio.calle) &&
		        compare(numero, domicilio.numero) &&
		        compare(edificio, domicilio.edificio) &&
		        compare(piso, domicilio.piso) &&
		        compare(depto, domicilio.depto) &&
		        compare(codigoPostal, domicilio.codigoPostal) &&
		        compare(pais, domicilio.pais) &&
		        compare(provincia, domicilio.provincia) &&
		        compare(localidad, domicilio.localidad) &&
		        compare(provinciaExterna, domicilio.provinciaExterna) &&
		        compare(localidadExterna, domicilio.localidadExterna));
	}

	/**
	 * equals2 compara todos los campos excepto el  "tipo_domcilio"
	 * @param object
	 * @return boolean
	 */
	public boolean equals2(Object object) {
		DomicilioDAO domicilio = (DomicilioDAO) object;
		return (this == object) ||
		        ((object instanceof DomicilioDAO) &&
		        compare(calle, domicilio.calle) &&
		        compare(numero, domicilio.numero) &&
		        compare(edificio, domicilio.edificio) &&
		        compare(piso, domicilio.piso) &&
		        compare(depto, domicilio.depto) &&
		        compare(codigoPostal, domicilio.codigoPostal) &&
		        compare(pais, domicilio.pais) &&
		        compare(provincia, domicilio.provincia) &&
		        compare(localidad, domicilio.localidad) &&
		        compare(provinciaExterna, domicilio.provinciaExterna) &&
		        compare(localidadExterna, domicilio.localidadExterna));
	}
	public static boolean compare(int s1, int s2) {
		return (s1 == s2);
	}

	public static boolean compare(String s1, String s2) {
		return (s1 == s2) || ((s1 != null && s2 != null) && (s1.trim().toLowerCase().equals(s2.trim().toLowerCase())));
	}

	public static boolean compare(Integer i1, Integer i2) {
		return (i1 == i2) || ((i1 != null) && (i1.equals(i2)));
	}

	public boolean esEnvio() {
		return esEnvio(tipoDomicilio);
	}

	public static boolean esEnvio(String tipo) {
		return (tipo == null) || (tipo.indexOf(HEADER_ENVIO) >= 0);
	}

	public boolean esFacturacion() {
		return esFacturacion(tipoDomicilio);
	}
	public static boolean esFacturacion(String tipo) {
		return (tipo == null) || (tipo.indexOf(HEADER_FACTURACION) >= 0);
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer("Domicilio ");
		buffer.append(" tipo ").append(tipoDomicilio);
		buffer.append(", calle ").append(calle);
		buffer.append(", numero ").append(numero);
		buffer.append(", edificio ").append(edificio);
		buffer.append(", piso ").append(piso);
		buffer.append(", depto ").append(depto);
		buffer.append(", codigoPostal ").append(codigoPostal);
		buffer.append(", ").append(getLocalidad());
		buffer.append(", ").append(getProvincia());
		buffer.append(", ").append(getPais());
		buffer.append(", Prov Ext ").append(provinciaExterna);
		buffer.append(", Local Ext ").append(localidadExterna);
		return buffer.toString();
	}

	
	public static final DomicilioDAO load(Integer idSucursal, Integer idSocio, String tipoDomicilio) throws Exception {
		/*SocioPK socioPk = new SocioPK(idSucursal,idSocio);  
		SocioDomicilios domicilio = ServiceLocator.getSocioService().getByPKYTipoDomicilio(socioPk, tipoDomicilio);
		*/
		
		SocioDomicilioPK socioDomicilioPK = new SocioDomicilioPK(idSucursal, idSocio, tipoDomicilio);
		SocioDomicilioLocalHome socioDomicilioLocalHome = (SocioDomicilioLocalHome) DBUtil.getHome("SocioDomicilio");
		SocioDomicilioLocal socioDomicilioLocal = socioDomicilioLocalHome.findByPrimaryKey(socioDomicilioPK);
		
		DomicilioDAO domicilioDAO = new DomicilioDAO(
		        socioDomicilioLocal.getID_SUCURSAL(),
		        socioDomicilioLocal.getID_SOCIO(),
		        socioDomicilioLocal.getTIPO_DOMICILIO(),
		        socioDomicilioLocal.getCALLE(),
		        socioDomicilioLocal.getNUMERO(),
		        socioDomicilioLocal.getEDIFICIO(),
		        socioDomicilioLocal.getPISO(),
		        socioDomicilioLocal.getDEPTO(),
		        socioDomicilioLocal.getCP(),
		        socioDomicilioLocal.getID_PAIS(),
		        socioDomicilioLocal.getID_PROVINCIA(),
		        socioDomicilioLocal.getID_LOCALIDAD(),
		        socioDomicilioLocal.getDESCRIPCION_PROVINCIA_INEX(),
		        socioDomicilioLocal.getDESCRIPCION_LOCALIDAD_INEX());
		 
		/*DomicilioDAO domicilioDAO = new DomicilioDAO(
		        domicilio.getId_sucursal(),
		        domicilio.getId_socio(),
		        domicilio.getTipo_domicilio(),
		        domicilio.getCalle(),
		        domicilio.getNumero(),
		        domicilio.getEdificio(),
		        domicilio.getPiso(),
		        domicilio.getDepto(),
		        domicilio.getCp(),
		        domicilio.getPais().getIdPais(),
		        domicilio.getProvincia().getId_provincia(),
		        domicilio.getLocalidad().getId_localidad(),
		        domicilio.getDescripcion_provincia_inex(),
		        domicilio.getDescripcion_localidad_inex());*/
		return domicilioDAO;
	}

}
