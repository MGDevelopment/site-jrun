/**
 * $Log: TarjetaPlanDAO.java,v $
 * Revision 1.12  2006/12/27 15:47:51  omsartori
 * -Rediseño: Atributos de articulo, metaTags.
 * -Correccion de planes de tarjetas para quedarme con el de vigencia mas nueva
 * -Site Map correccion de secciones
 *
 * Revision 1.11  2006/11/27 13:03:36  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.10  2006/06/22 18:26:39  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.9  2006/03/06 15:38:06  omsartori
 * - Medios de cobro VMA y MNA
 * - Indice de contenidos
 * - URL configurable para generacion
 *
 * Revision 1.8  2006/01/11 17:37:11  omsartori
 * -Dromo
 *    -Se quito el campo fabricante
 *    -Se filtra la seleccion de papel de regalo para articulos (6,7,8)
 *    -Estetica en seleccion de medio de pago
 * -Empro doc 11 (parte 1)
 * -Intranet TMK
 *    -Generacion en otro equipo configurable
 *    -Correccion y configuracion de procesos de generacion de Detalle y recorrido de categorias
 *
 * Revision 1.7  2005/12/29 17:45:11  omsartori
 * * Cambios Dromo
 *    Se quitaron los datos distribuidor, proveedor e isbn.
 *    Se agregaron los datos marca y fabricante.
 *    Se agregaron los buscadores por marca y fabricante, tanto por código como por palabra.
 *    Se modificó el orden de las tarjetas en el plan de pago del detalle artículo, ahora es VIS, AME, MAS, DIN.
 *    Se agregaron los campos:
 *    Tipo de documento.
 *    Nro de Documento.
 *    Rango horario de recepción del pedido.
 *    Estos campos son visibles en la orden del cliente y en el detalle de orden de la intranet de TMK. Y deben completarse obligatoriamente para órdenes que contengan artículos de Dromo.
 *
 * * Se filtró la localidad “ciudad autónoma de Buenos Aires” del listado de localidades válidas para tmk.
 *
 * * Doc Empro 10
 *
 * Revision 1.6  2005/12/13 16:16:38  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.5  2005/09/15 19:19:12  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.4  2005/03/17 12:48:45  omsartori
 * - se restringió a un máximo de 12 cuotas los planes de las tarjetas.
 *
 * Revision 1.3  2004/10/05 21:27:59  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.2  2004/09/30 14:17:09  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.1  2004/08/03 15:47:02  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 */
package com.tmk.kernel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TarjetaPlanDAO {

	private static int PESO = 32;
	private static int DOLLAR = 840;

	private String idMedioDeCobro;
	private int plan;
	private String descripcion;
	private int cuotas;
	private int monedaGPay;
	private double coeficiente;
	private double montoMinimo;
    private double tna;

	public TarjetaPlanDAO(String idMedioDeCobro, int plan, String descripcion,
	                      int cuotas, int monedaGPay, double coeficiente, double montoMinimo, double tna) {
		super();
		this.idMedioDeCobro = idMedioDeCobro;
		this.plan = plan;
		this.descripcion = descripcion;
		this.cuotas = cuotas;
		this.monedaGPay = monedaGPay;
		this.coeficiente = coeficiente;
		this.montoMinimo = montoMinimo;
		this.tna = tna;
	}

	/* Usado para cuando la ordenes historicas */
	public TarjetaPlanDAO(String idMedioDeCobro, int cuotas, int moneda, double coeficiente) {
		this(idMedioDeCobro, 0, "Pago en cuotas", cuotas, ((moneda == Globals.MONEDA_DOLLAR) ? DOLLAR : PESO), coeficiente, 0.0, 0.0);
	}

	/* Usado para cuando no esta habilitado GPAY */
	public TarjetaPlanDAO(String idMedioDeCobro) {
		this(idMedioDeCobro, 0, "Pago en cuotas", 1, PESO, 1, 0.0, 0.0);
	}

	public String toString() {
		return "Plan " + plan + " - " + descripcion +
		        ", cuotas: " + cuotas + ", moneda: " + monedaGPay + ", coeficiente: " + coeficiente +
		        ", minimo: " + montoMinimo;
	}

	public boolean equals(Object other) {
		return (this == other) ||
		        ((other instanceof TarjetaPlanDAO) &&
		        (idMedioDeCobro.equals(((TarjetaPlanDAO) other).idMedioDeCobro) &&
		        (plan == ((TarjetaPlanDAO) other).plan) &&
		        (cuotas == ((TarjetaPlanDAO) other).cuotas) &&
		        (monedaGPay == ((TarjetaPlanDAO) other).monedaGPay) &&
		        (coeficiente == ((TarjetaPlanDAO) other).coeficiente) &&
		        (montoMinimo == ((TarjetaPlanDAO) other).montoMinimo)
		        ));
	}

	public String getIdMedioDeCobro() {
		return idMedioDeCobro;
	}

	public int getPlan() {
		return plan;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCuotas() {
		return cuotas;
	}

	public int getMonedaGPay() {
		return monedaGPay;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public double getMontoMinimo() {
		return montoMinimo;
	}

	public int getMonedaComercial() {
		return (monedaGPay == DOLLAR) ? Globals.MONEDA_DOLLAR : Globals.MONEDA_PESO;
	}

	public double getCambio() {
		return (monedaGPay == DOLLAR) ? Globals.TASA_DOLLAR : Globals.TASA_PESO;
	}

	public double calculaTotalConIntereses(double total) {
		return total * coeficiente;
	}

	public double getTNA() {
		return this.tna;
	}

	public double calculaCuota(double total) {
		return calculaTotalConIntereses(total) / cuotas;
	}

	/* No tiene PK la tabla, asi que la inventé */
	public String getClave() {
		StringBuffer clave = new StringBuffer();
		clave.append(idMedioDeCobro).append(',');
		clave.append(plan).append(',');
		clave.append(descripcion).append(',');
		clave.append(cuotas).append(',');
		clave.append(monedaGPay).append(',');
		clave.append(coeficiente).append(',');
		clave.append(montoMinimo).append('.');
		return clave.toString();
	}

	/* Busca el plan que corresponde */
	public static final TarjetaPlanDAO get(String clave) {
		for (int i = 0; (Globals.TARJETAS_PLANES != null) && (i < Globals.TARJETAS_PLANES.length); i++) {
			TarjetaPlanDAO temp = Globals.TARJETAS_PLANES[i];
			if (temp.getClave().equals(clave)) {
				return temp;
			}
		}
		return null;
	}

	public static final TarjetaPlanDAO[] getParaMedio(MedioDeCobroDAO medioDeCobroDAO) {
		Vector temp = new Vector();
		for (int i = 0; (Globals.TARJETAS_PLANES != null) && (i < Globals.TARJETAS_PLANES.length); i++) {
			TarjetaPlanDAO plan = Globals.TARJETAS_PLANES[i];
			if (plan.getIdMedioDeCobro().equals(medioDeCobroDAO.getId())) {
				temp.add(plan);
			}
		}
		return (TarjetaPlanDAO[]) temp.toArray(new TarjetaPlanDAO[temp.size()]);
	}

	static {
		new Daemon(Daemon.DIEZ_SEGUNDOS * 2, Daemon.UNA_HORA) {
			
			//Trae el plan generico luego se agrega el particular reemplazando el generico cuando corresponda
			protected void ejecutarTarea() throws Exception {
				final Vector temp = new Vector();
				final Vector temp2 = new Vector();
				DBUtil.getIdDescripcion("SELECT tp.id_medio_cobro, tp.plan, tp.plan_descri, tp.cuotas, tp.moneda, tp.coeficiente," +
										" tp.monto_minimo, tp.tna, tp.fecha_vigencia" +			       
										" FROM tarjeta_planes tp," +
										" medios_de_cobros mdc" +
										" WHERE" + 
										" mdc.id_medio_cobro = tp.id_medio_cobro" +
										" AND tp.id_empresa IS NULL" +
										" AND tp.id_unidad_negocio IS NULL" + 
										" AND tp.id_region IS NULL" +
										" AND tp.id_sucursal IS NULL" +
										" AND tp.id_caal  IS NULL" + 
										" AND tp.id_banco IS NULL" +
										" AND tp.CUOTAS<=12" +
										" AND mdc.habilitado_tematika = 'S'" +
										" ORDER BY tp.id_medio_cobro, tp.cuotas, tp.fecha_vigencia desc",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        String idMedioDeCobro = resultSet.getString("id_medio_cobro");
						        int plan = resultSet.getInt("plan");
						        String descripcion = resultSet.getString("plan_descri");
						        int cuotas = resultSet.getInt("cuotas");
						        int moneda = resultSet.getInt("moneda");
						        double coeficiente = resultSet.getDouble("coeficiente");
						        double montoMinimo = resultSet.getDouble("monto_minimo");
						        double tna = resultSet.getDouble("tna");
						        temp.add(new TarjetaPlanDAO(idMedioDeCobro, plan, descripcion, cuotas, moneda, coeficiente, montoMinimo, tna));
					        }
				        });
				
				    TarjetaPlanDAO planAnterior = null;
					if (temp.size()>0) {
						planAnterior = (TarjetaPlanDAO) temp.get(0);
					}	
					//elimina planes que sean iguales
					for (int w=1; w<temp.size(); w++) {
						TarjetaPlanDAO plan = (TarjetaPlanDAO) temp.get(w);
						if (planAnterior.getIdMedioDeCobro().equals(plan.getIdMedioDeCobro()) &&
								planAnterior.getCuotas() == plan.getCuotas()) {
							temp.remove(w);
							w--;
						} else {
							planAnterior = plan;
						}
					}
					
					TarjetaPlanDAO tmp[] = (TarjetaPlanDAO[]) temp.toArray(new TarjetaPlanDAO[temp.size()]); 
					//Globals.TARJETAS_PLANES = 
					DBUtil.getIdDescripcion("SELECT 1 prioridad, tp.id_medio_cobro, tp.plan, tp.plan_descri, tp.cuotas, tp.moneda, tp.coeficiente," +
											" tp.monto_minimo, tp.tna" + 
											" FROM tarjeta_planes tp," +
											" medios_de_cobros mdc" +  
											" WHERE id_empresa = '00001'" +
											" AND tp.id_medio_cobro = mdc.id_medio_cobro" +
											" AND MONEDA IN ( 32, 840)" + 
											" AND CUOTAS<=12" +
											" AND mdc.habilitado_tematika = 'S'" +
											" UNION" +
											" SELECT 2 prioridad, tp.id_medio_cobro, tp.plan, tp.plan_descri, tp.cuotas, tp.moneda, tp.coeficiente," +
											" tp.monto_minimo, tp.tna" +
											" FROM tarjeta_planes tp," +
											" medios_de_cobros mdc  " +
											" WHERE id_unidad_negocio = '3'" +
											" AND tp.id_medio_cobro = mdc.id_medio_cobro" +
											" AND MONEDA IN ( 32, 840)" +
											" AND CUOTAS<=12" +
											" AND mdc.habilitado_tematika = 'S'" +
											" UNION" +
											" SELECT 3 prioridad, tp.id_medio_cobro, tp.plan, tp.plan_descri, tp.cuotas, tp.moneda, tp.coeficiente," +
											" tp.monto_minimo, tp.tna " +
											" FROM tarjeta_planes tp," +
											" medios_de_cobros mdc " +
											" WHERE id_region = '005'" +
											" AND tp.id_medio_cobro = mdc.id_medio_cobro" +
											" AND MONEDA IN ( 32, 840)" + 
											" AND CUOTAS<=12" +
											" AND mdc.habilitado_tematika = 'S'" +
											" UNION" +
											" SELECT 4 prioridad, tp.id_medio_cobro, tp.plan, tp.plan_descri, tp.cuotas, tp.moneda, tp.coeficiente," +
											" tp.monto_minimo, tp.tna " +
											" FROM tarjeta_planes tp," +
											" medios_de_cobros mdc " +
											" WHERE id_sucursal =201" +
											" AND tp.id_medio_cobro = mdc.id_medio_cobro" +
											" AND MONEDA IN ( 32, 840)" + 
											" AND CUOTAS<=12" +	
											" AND mdc.habilitado_tematika = 'S'" +
											" UNION" +
											" SELECT 5 prioridad, tp.id_medio_cobro, tp.plan, tp.plan_descri, tp.cuotas, tp.moneda, tp.coeficiente," +
											" tp.monto_minimo, tp.tna " +
											" FROM tarjeta_planes  tp," +
											" medios_de_cobros mdc " +
											" WHERE id_caal = 4473" +
											" AND tp.id_medio_cobro = mdc.id_medio_cobro" +
											" AND MONEDA IN ( 32, 840)" + 	
											" AND CUOTAS<=12" +
											" AND mdc.habilitado_tematika = 'S'" +
											" ORDER BY prioridad, id_medio_cobro",
					new DBUtil.ResultSetObserver() {
						public void onRow(ResultSet resultSet) throws SQLException {
				        String idMedioDeCobro = resultSet.getString("id_medio_cobro");
				        int plan = resultSet.getInt("plan");
				        String descripcion = resultSet.getString("plan_descri");
				        int cuotas = resultSet.getInt("cuotas");
				        int moneda = resultSet.getInt("moneda");
				        double coeficiente = resultSet.getDouble("coeficiente");
				        double montoMinimo = resultSet.getDouble("monto_minimo");
				        double tna = resultSet.getDouble("tna");
				        temp2.add(new TarjetaPlanDAO(idMedioDeCobro, plan, descripcion, cuotas, moneda, coeficiente, montoMinimo, tna));
			        }
		        });
					TarjetaPlanDAO tmp2[] = (TarjetaPlanDAO[]) temp2.toArray(new TarjetaPlanDAO[temp2.size()]);
					
						for (int j=0; j<tmp2.length; j++) {
							//boolean encontro = false;
							for (int i=0; i<tmp.length; i++) {
								if (tmp2[j].getIdMedioDeCobro().equals(tmp[i].getIdMedioDeCobro())
					        			&& tmp2[j].getCuotas() == tmp[i].getCuotas()){
					        		tmp[i] = tmp2[j];
					        		//encontro = true;
					        		break;
					        	}	
						}
							/*if (!encontro){
								for (int w=0; w<temp.size(); w++) { 
									if (((TarjetaPlanDAO)temp.get(w)).getIdMedioDeCobro().equals(tmp2[j].getIdMedioDeCobro())) {
										if (((TarjetaPlanDAO)temp.get(w)).getCuotas() > tmp2[j].getCuotas()) {
											temp.add(w-1, tmp2[j]);
											break;
										} else {
											if (temp.size() > w+1){
												if (!((TarjetaPlanDAO)temp.get(w+1)).getIdMedioDeCobro().equals(tmp2[j].getIdMedioDeCobro())) {
													temp.add(w+1, tmp2[j]);
												}
											} else {
												temp.add(tmp2[j]);
												//agrego adelante
											}
										}
									}
								}
							}*/
						}
				//workflow 707->agrego los planes de pago para vpat y ampat
				for(int i=0;i<temp2.size();i++){
					//si la tajetaplan en el vector temp2 es de la promocion
					if(((TarjetaPlanDAO)temp2.get(i)).getIdMedioDeCobro().equals("VPAT") ||
							((TarjetaPlanDAO)temp2.get(i)).getIdMedioDeCobro().equals("AMPAT")) {
						temp.add(temp2.get(i));
					}
				}
				tmp =  (TarjetaPlanDAO[]) temp.toArray(new TarjetaPlanDAO[temp.size()]);
				//fin work flow 707
				
				Globals.TARJETAS_PLANES =tmp; //(TarjetaPlanDAO[]) temp.toArray(new TarjetaPlanDAO[temp.size()]);
					
				//Calculo de cuotas y precios
				Globals.TARJETAS_DETALLE_ARTICULO.clear();
				Vector tarjetas = new Vector();
				Vector tarjetasPlanes = new Vector();
				while (Globals.MEDIOS_DE_COBRO == null) {
					sleep(1000);
				}
				for (int i=0; i<Globals.MEDIOS_DE_COBRO.length; i++) {
					//if (Globals.MEDIOS_DE_COBRO[i].esTarjeta() && Globals.MEDIOS_DE_COBRO[i].estaHabilitado()) {
					if (Globals.MEDIOS_DE_COBRO[i].esTarjeta()) {
				        if (Globals.MEDIOS_DE_COBRO[i].getId().equals("VIS")) {
					        tarjetas.add(0,Globals.MEDIOS_DE_COBRO[i]);
				            i = Globals.MEDIOS_DE_COBRO.length;
				        }
					}
				}
				for (int i=0; i<Globals.MEDIOS_DE_COBRO.length; i++) {
					//if (Globals.MEDIOS_DE_COBRO[i].esTarjeta() && Globals.MEDIOS_DE_COBRO[i].estaHabilitado()) {
					if (Globals.MEDIOS_DE_COBRO[i].esTarjeta()) {
						if (Globals.MEDIOS_DE_COBRO[i].getId().equals("AME")) {
							tarjetas.add(1,Globals.MEDIOS_DE_COBRO[i]);
							i = Globals.MEDIOS_DE_COBRO.length;
						}
					}
				}

				for (int i=0; i<Globals.MEDIOS_DE_COBRO.length; i++) {
					//if (Globals.MEDIOS_DE_COBRO[i].esTarjeta() && Globals.MEDIOS_DE_COBRO[i].estaHabilitado()) {
					if (Globals.MEDIOS_DE_COBRO[i].esTarjeta()) {
						if (Globals.MEDIOS_DE_COBRO[i].getId().equals("MAS")) {
							tarjetas.add(2,Globals.MEDIOS_DE_COBRO[i]);
							i = Globals.MEDIOS_DE_COBRO.length;
						}
					}
				}

				for (int i=0; i<Globals.MEDIOS_DE_COBRO.length; i++) {
					//if (Globals.MEDIOS_DE_COBRO[i].esTarjeta() && Globals.MEDIOS_DE_COBRO[i].estaHabilitado()) {
					if (Globals.MEDIOS_DE_COBRO[i].esTarjeta()) {
						if (Globals.MEDIOS_DE_COBRO[i].getId().equals("DIN")) {
							tarjetas.add(3,Globals.MEDIOS_DE_COBRO[i]);
							i = Globals.MEDIOS_DE_COBRO.length;
						}
					}
				}

				for (int i=0; i<Globals.MEDIOS_DE_COBRO.length; i++) {
					//if (Globals.MEDIOS_DE_COBRO[i].esTarjeta() && Globals.MEDIOS_DE_COBRO[i].estaHabilitado()) {
					if (Globals.MEDIOS_DE_COBRO[i].esTarjeta()) {
						if (!Globals.MEDIOS_DE_COBRO[i].getId().equals("VIS") && !Globals.MEDIOS_DE_COBRO[i].getId().equals("AME") &&
							!Globals.MEDIOS_DE_COBRO[i].getId().equals("MAS") && !Globals.MEDIOS_DE_COBRO[i].getId().equals("DIN") &&
						     !Globals.MEDIOS_DE_COBRO[i].getId().equals("VNA") && !Globals.MEDIOS_DE_COBRO[i].getId().equals("MNA") && 
						     !Globals.MEDIOS_DE_COBRO[i].getId().equals("VRIO") && !Globals.MEDIOS_DE_COBRO[i].getId().equals("ARIO")) {
							tarjetas.add(Globals.MEDIOS_DE_COBRO[i]);
						}
					}
				}



				if (tarjetas.get(0) != null) {
					TarjetaPlanDAO planes[] = TarjetaPlanDAO.getParaMedio((MedioDeCobroDAO) tarjetas.get(0));
					int cuotas = 0;

					for (int i=planes.length-1; i>=0 && cuotas == 0; i--) {
						if (planes[i].getCoeficiente() == 1) {
					        cuotas = planes[i].getCuotas();
						}
					}
					tarjetasPlanes.add("" + cuotas + "");
					tarjetasPlanes.add(tarjetas.get(0));
					for (int i=1; i<tarjetas.size(); i++) {

						planes = TarjetaPlanDAO.getParaMedio((MedioDeCobroDAO)tarjetas.get(i));
						for (int w=planes.length-1; w>=0; w--) {
							if (planes[w].getCoeficiente() == 1 && planes[w].getCuotas() == cuotas) {
				                tarjetasPlanes.add(tarjetas.get(i));
							}
						}
					}
					Globals.TARJETAS_DETALLE_ARTICULO = tarjetasPlanes;
				}
				//Calculo de cuotas y precios
			}

			protected String getMensaje() {
				return Globals.TARJETAS_PLANES.length + " tarjetas-planes.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento() || (!Globals.HABILITA_CUOTAS);
			}
		};
	}

}
