/**
 * $Log: PuntajeWrapper.java,v $
 * Revision 1.5  2008/04/09 20:19:05  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.4  2007/09/03 13:41:21  msartori
 * no message
 *
 * Revision 1.3  2004/11/01 16:31:41  oGPistoia
 * - Cambios para evitar bloqueos en comercial por la unificacion de socios duplicados que tienen nueva cuenta eXtra
 * - Cambios en el controler de Clientes Institucionales
 * - Generadores de clases de java para parser de xmls.
 *
 * Revision 1.2  2004/09/10 15:12:50  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.1  2004/08/03 15:46:58  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.1  2004/05/04 18:11:07  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 */
package com.tmk.fidelizacion;

import com.tmk.kernel.Convert;

public class PuntajeWrapper {

	private String nombreSocio;
	private String apellidoSocio;
	private String eMail;
	private int puntos;
    private int componente;

	private int idCuenta;
	private int idSucursalCuenta;
	private int idCuso;

	private int idSocio;
	private int idSucursalSocio;

	private String numeroDeTarjeta;

	private String sexo;
	private String tipoDeDocumento;
	private long numeroDeDocumento;
	private int nacionalidad;
	private boolean esGold;

	private VencimientoPuntos vencimientoPuntos[] = {};

	public PuntajeWrapper(String numeroDeTarjeta) {
		super();
		this.numeroDeTarjeta = numeroDeTarjeta;
	}

	public PuntajeWrapper(String sexo, String tipoDeDocumento, long numeroDeDocumento, int nacionalidad) {
		super();
		this.sexo = sexo;
		this.tipoDeDocumento = tipoDeDocumento;
		this.numeroDeDocumento = numeroDeDocumento;
		this.nacionalidad = nacionalidad;
	}

	public PuntajeWrapper(int idSocio, int idSucursalSocio) {
		super();
		this.idSocio = idSocio;
		this.idSucursalSocio = idSucursalSocio;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	public String getApellidoSocio() {
		return apellidoSocio;
	}

	public void setApellidoSocio(String apellidoSocio) {
		this.apellidoSocio = apellidoSocio;
	}

	public String getEMail() {
		return eMail;
	}
	
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public boolean getEsTitular() {
		return (componente == 0);
	}

	public void setComponente(int componente) {
		this.componente = componente;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getIdSucursalCuenta() {
		return idSucursalCuenta;
	}

	public void setIdSucursalCuenta(int idSucursalCuenta) {
		this.idSucursalCuenta = idSucursalCuenta;
	}

	public int getIdCuso() {
		return idCuso;
	}

	public void setIdCuso(int idCuso) {
		this.idCuso = idCuso;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public int getIdSucursalSocio() {
		return idSucursalSocio;
	}

	public void setIdSucursalSocio(int idSucursalSocio) {
		this.idSucursalSocio = idSucursalSocio;
	}

	public String getNumeroDeTarjeta() {
		return numeroDeTarjeta;
	}

	public String getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public long getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	public String getSexo() {
		return sexo;
	}

	public int getNacionalidad() {
		return nacionalidad;
	}

	public void setNumeroDeTarjeta(String numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}
	
	public boolean esGold() {
		return this.esGold;
	}
	
	public void setGold(boolean esGold) {
		this.esGold = esGold;
	}

	public void addVencimiento(VencimientoPuntos item) {
		VencimientoPuntos temp[] = new VencimientoPuntos[vencimientoPuntos.length + 1];
		System.arraycopy(vencimientoPuntos, 0, temp, 0, vencimientoPuntos.length);
		vencimientoPuntos = temp;
		vencimientoPuntos[vencimientoPuntos.length - 1] = item;
	}

	public VencimientoPuntos[] getVencimientosPuntos() {
		return vencimientoPuntos;
	}

	public String toString() {

		StringBuffer result = new StringBuffer();

		if ((nombreSocio != null) && (apellidoSocio != null)) {
			result.append("Cuenta de ").append(Convert.nombreCompleto(nombreSocio, apellidoSocio)).append(" con ");
		}

		result.append(Convert.toString(puntos)).append(" puntos, ");
		result.append((getEsTitular()) ? "titular, " : "adicional, ");

		result.append("creada en sucursal ").append(idSucursalCuenta).append(" cuenta ").append(idCuenta).append(". ");

		if (numeroDeTarjeta != null) {
			result.append("Tarjeta ").append(numeroDeTarjeta).append(". ");
		}

		for (int i = 0; i < vencimientoPuntos.length; i++) {
			VencimientoPuntos item = vencimientoPuntos[i];
			result.append(item.toString());
		}

		return result.toString();

	}

	//agregados para poder copiar los datos e el proceso de remplazao de ejb por dbo
	public int getComponente() {
		return componente;
	}

	public boolean isEsGold() {
		return esGold;
	}

	public VencimientoPuntos[] getVencimientoPuntos() {
		return vencimientoPuntos;
	}

	public void setTipoDeDocumento(String tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	public void setNumeroDeDocumento(long numeroDeDocumento) {
		this.numeroDeDocumento = numeroDeDocumento;
	}

	public void setNacionalidad(int nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setEsGold(boolean esGold) {
		this.esGold = esGold;
	}

	public void setVencimientoPuntos(VencimientoPuntos[] vencimientoPuntos) {
		this.vencimientoPuntos = vencimientoPuntos;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	//hasta aca
}
