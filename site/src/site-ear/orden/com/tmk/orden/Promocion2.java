package com.tmk.orden;

import com.tmk.kernel.*;
import com.tmk.socio.SocioPK;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;

public class Promocion2 {
	private int idPromo;
	private String nombre;
	private String comentarios;
	private Date fInicio;
	private Date fFin;
	
	Promocion2(int idPromo, String nombre, String comentarios, Date fInicio, Date fFin) {
		this.idPromo = idPromo;
		this.nombre = nombre;
		this.comentarios = comentarios;
		this.fInicio = fInicio;
		this.fFin = fFin;
	}
	
	public int getIdPromo() {
		return this.idPromo;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public String getComentarios() {
		return this.comentarios;
	}

	public Date getFInicio() {
		return this.fInicio;
	}
	
	public Date getFFin() {
		return this.fFin;
	}
	
	public static void aplicarPromocion(OrdenDAO ordenDAO, SocioPK socioPK) {
		// valida si debe aplicar el importe
		if (ordenDAO == null) return;
		if (socioPK == null) return;
		if (ordenDAO.isReadOnly()) return;
		if (!ordenDAO.tieneArticulos()) return;
		if (ordenDAO.getMedioDeCobro() == null) return;
		if (ordenDAO.getAlgunDomicilioEnvio() == null) return;

		TmkLogger.debug("Recalcula promociones...");

		int [] idsArticulosConPapel = new int[ordenDAO.getArticulos().size()]; 
		int [] idsPapel = new int[ordenDAO.getArticulos().size()]; 
		int [] idsArticulosConNota = new int[ordenDAO.getArticulos().size()];
		String [] notaDeRegalo = new String[ordenDAO.getArticulos().size()];
		double precioOriginalGastoBasico = 0.0;
		double precioOriginalGastoAdicional = 0.0;
		
		
		// cancela las promociones anteriores.
		/*Vector articulos = ordenDAO.todosLosArticulos();


		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO articulo = (ArticuloDAO) articulos.get(i);
			articulo.borrarPromocion();
		}*/

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				
				init(conn);

				cargarSocDom(conn, ordenDAO.getAlgunDomicilioEnvio().getIdPais().intValue()
						, ordenDAO.getAlgunDomicilioEnvio().getIdProvincia().intValue() 
						, ordenDAO.getAlgunDomicilioEnvio().getIdLocalidad().intValue());

				if (ordenDAO.getMedioDeCobro().esTarjeta()) {
					cargarMecob(conn, ordenDAO.getMedioDeCobro().getId(), checkTC(conn,
							ordenDAO.get_NumeroTarjetaCompletoDesencriptado(), ordenDAO.getMedioDeCobro().getId()),
							ordenDAO.getCuotas());
				} else {
					cargarMecob(conn, ordenDAO.getMedioDeCobro().getId(), 0,
							0);
				}
				//todos los articulos a enviar al calculo de promociones
				Collection articulos = new Vector();
				
				//articulos.addAll(ordenDAO.getArticulos());
				
				if (ordenDAO.getInteresCobradoDAO() != null) articulos.add(ordenDAO.getInteresCobradoDAO());
				
				int j=0;
				int x=0;
				for (int i=0; i<ordenDAO.getArticulos().size(); i++) {
						articulos.add((ArticuloDAO) ordenDAO.getArticulos().get(i));
					
						ArticuloDAO papel = ((ArticuloDAO) ordenDAO.getArticulos().get(i)).getPapelDeRegalo();
						
						if (papel != null) {
							articulos.add(papel);
							idsArticulosConPapel[j] = ((ArticuloDAO) ordenDAO.getArticulos().get(i)).getId();
							idsPapel[j] = ((ArticuloDAO) ordenDAO.getArticulos().get(i)).getPapelDeRegalo().getId();
							j++;
						}
						if (((ArticuloDAO) ordenDAO.getArticulos().get(i)).getGastoDeEvio() != null) {
							GastosEnvioDAO gasto  = ((ArticuloDAO) ordenDAO.getArticulos().get(i)).getGastoDeEvio();
							precioOriginalGastoBasico = (gasto.esGastoBasico())? gasto.getPrecioOriginal(): precioOriginalGastoBasico;
							precioOriginalGastoAdicional = (!gasto.esGastoBasico())? gasto.getPrecioOriginal(): precioOriginalGastoAdicional;
							articulos.add(gasto);
						}
						String nota = ((ArticuloDAO) ordenDAO.getArticulos().get(i)).getNota();
						
						if (nota != null) {
							idsArticulosConNota[x] = ((ArticuloDAO) ordenDAO.getArticulos().get(i)).getId();
							notaDeRegalo[x] = nota;
							x++;
						}
						
				}
				
				Iterator todosLosArticulos = articulos.iterator();
				
				/*for (int w=0; w<idsPapel.length; w++) {
					TmkLogger.debug("idPapel " + idsPapel[w]);
					TmkLogger.debug("idArts con " + idsArticulosConPapel[w]);
				}*/
					
				while (todosLosArticulos.hasNext()) {
					ArticuloDAO articulo = (ArticuloDAO)todosLosArticulos.next();
					cargarArticulo(conn, articulo.getId(), articulo.getCantidad(), articulo.getPrecioSinImpuestoConDescuento(),
							articulo.getCantidad() * articulo.getTotalImpuestosSobrePrecioConDescuento(), Globals.ID_CANAL_ALTERNATIVO);
				}
				
				if (calcular(conn, Globals.ID_SUCURSAL_TEMATIKA, Globals.ID_CANAL_ALTERNATIVO, socioPK.ID_SOCIO.intValue()
						, socioPK.ID_SUCURSAL.intValue(), ordenDAO.getCupon())) {
					TmkLogger.debug("PROMOII] aplicarPromocion APLICA");

					aplicarAOrden(conn, socioPK, ordenDAO, idsArticulosConPapel, idsPapel, precioOriginalGastoBasico, precioOriginalGastoAdicional, idsArticulosConNota, notaDeRegalo);
					

				} else {
					
					TmkLogger.debug("PROMOII] aplicarPromocion NO APLICA");
				}
			
			} finally {
				conn.close();
			}

		} catch (Exception e) {
			TmkLogger.error("No se pudieron aplicar las promociones. Error: " + e.getMessage());
		}
	}
	
	private static void init(Connection conn) throws Exception {

		TmkLogger.debug("PROMOII] Comienzo Init...");
		
		CallableStatement cs = conn.prepareCall("{call Pck_Promo.Init}");
		try {
			cs.execute();
		
		} finally {
			cs.close();
		}
		TmkLogger.debug("PROMOII] Fin Init...");
	}
	
	private static void cargarSocDom(Connection conn, int idPais, int idProvincia, int idLocalidad) throws Exception {
		TmkLogger.debug("PROMOII] Comienzo Cargar_SocDom(" + idPais + ", " + idProvincia + ", " + idLocalidad + ")...");
		
		CallableStatement cs = conn.prepareCall("{call Pck_Promo.Cargar_SocDom(?, ?, ?)}");
		try {
			cs.setInt(1, idPais);
			cs.setInt(2, idProvincia);
			cs.setInt(3, idLocalidad);
			cs.execute();
		} finally {
			cs.close();
		} 
		TmkLogger.debug("PROMOII] Fin Cargar_SocDom...");
	}
	
	private static void cargarMecob(Connection conn, String idMecob, int idBanco, int cuotas) throws Exception{
		TmkLogger.debug("PROMOII] Comienzo Cargar_Mecob(" + idMecob + ", " + idBanco + ", " + cuotas + ")...");
		 
		CallableStatement cs = conn.prepareCall("{call Pck_Promo.Cargar_Mecob(?, ?, ?)}");
		try {
			cs.setString(1, idMecob);
			cs.setInt(2, idBanco);
			cs.setInt(3, cuotas);
			cs.execute();
		} catch (Exception e) {
			TmkLogger.error("PROMOII] Cargar_Mecob... " + e.toString());
			throw e;
		} finally {
			cs.close();
		} 
		TmkLogger.debug("PROMOII] Fin Cargar_Mecob...");
	}
	
	
	private static void cargarArticulo(Connection conn, int idArticulo, int cantidad, double precio, double impuesto, int idVendedor) throws Exception{
		TmkLogger.debug("PROMOII] Comienzo Cargar_Articulo(" + idArticulo + ", " + cantidad + ", " + precio + ", " + impuesto + ", " + idVendedor + ")...");
		
		CallableStatement cs = conn.prepareCall("{call Pck_Promo.Cargar_Articulo(?, ?, ?, ?, ?)}");
		try {
			cs.setInt(1, idArticulo);
			cs.setInt(2, cantidad);
			cs.setDouble(3, precio);
			cs.setDouble(4, impuesto);
			cs.setInt(5, idVendedor);
			cs.execute();
		} finally {
			cs.close();
		}
		TmkLogger.debug("PROMOII] Fin Cargar_Articulo...");
	}
	
	
	private static boolean calcular(Connection conn, int idSucursal, int idCAAL, int idSocio, int idSucSocio,
			String cupon) throws Exception{
		boolean retorno = false;
		Timestamp fecha = new java.sql.Timestamp(new Date().getTime());
		TmkLogger.debug("PROMOII] Comienzo Calcular(" + idSucursal + ", " + idCAAL + ", " + idSocio + ", " + idSucSocio + ","  + fecha + ", " + cupon + ")...");
		
		CallableStatement cs = conn.prepareCall("{? = call Pck_Promo.Calcular(?,?,?,?,?,?)}");
		try {
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, idSucursal);
			cs.setInt(3, idCAAL);
			cs.setInt(4, idSocio);
			cs.setInt(5, idSucSocio);
			cs.setTimestamp(6, fecha);
			cs.setString(7, cupon);
			cs.execute();
			retorno = (cs.getString(1).equals("S"))? true:false;
		} catch (Exception e) {
			TmkLogger.error("PROMOII] Calcular. Error: " + e.getMessage());
			throw e;
		} finally {
			cs.close();
		}
		TmkLogger.debug("PROMOII] Fin Calcular...");
		return retorno;
	}

	
	private static int checkTC(Connection conn, String nroTarjeta, String idMedioCobro) throws Exception {
		TmkLogger.debug("PROMOII] Comienzo Check_Tc(" + nroTarjeta.substring(0, 6) + "..., " + idMedioCobro + ")...");
		int idBanco = 0;
		CallableStatement cs = conn.prepareCall("{? = call CHECK_TC(?, ?, ?, ?, ?, ?, ?)}");
		
		try {
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			cs.setString(2, nroTarjeta);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR); //permite offline
			cs.registerOutParameter(4, java.sql.Types.VARCHAR); //permite cuotas
			cs.registerOutParameter(5, java.sql.Types.INTEGER);	//idBanco
			cs.registerOutParameter(6, java.sql.Types.INTEGER); //idPais
			cs.registerOutParameter(7, java.sql.Types.VARCHAR); //categ_tarjeta
			cs.setString(8, idMedioCobro);
			cs.execute();
			idBanco = cs.getInt(5);
		} catch (Exception e) {
			TmkLogger.error("PROMOII] Check_Tc..." + e.toString());
			throw e;
		} finally {
			cs.close();
		}
		TmkLogger.debug("PROMOII] Fin Check_Tc...");
		return idBanco;
	}
	
	public static void aplicarAOrden(Connection conn, SocioPK socioPK, OrdenDAO ordenDAO, int idsArticulosConPapel[], int idsPapel[], double precioGastoBasico, double precioGastoAdicional, int idsArticulosConNota[], String notaDeRegalo[]) {
		try {
			TmkLogger.debug("PROMOII] Aplicando Promos a Orden...");
			StringBuffer qry = new StringBuffer();
			qry.append(" select cp.id_articulo, cp.item, cp.precio_unitario precio, cp.id_campaign idcmp, ca.descripcion ncmp,");
			qry.append(" pc.id_promocion idp1, pc.nombre np1,");
			qry.append(" pc2.id_promocion idp2, pc2.nombre np2,");
			qry.append(" pc3.id_promocion idp3, pc3.nombre np3,");
			qry.append(" pc4.id_promocion idp4, pc4.nombre np4,");
			qry.append(" pc5.id_promocion idp5, pc5.nombre np5");
			qry.append(" from carrito_promo2 cp,");
	        qry.append(" campaigns ca,");
	        qry.append(" promo2_cabecera pc,");
	        qry.append(" promo2_cabecera pc2,");
	        qry.append(" promo2_cabecera pc3,");
	        qry.append(" promo2_cabecera pc4,");
	        qry.append(" promo2_cabecera pc5");
	        qry.append(" where");      		
	        qry.append(" cp.id_campaign = ca.id_campaign(+)");
	        qry.append(" and cp.id_promocion = pc.id_promocion(+)");
	        qry.append(" and cp.id_promocion2 = pc2.id_promocion(+)");
	        qry.append(" and cp.id_promocion3 = pc3.id_promocion(+)");
	        qry.append(" and cp.id_promocion4 = pc4.id_promocion(+)");
	        qry.append(" and cp.id_promocion5 = pc5.id_promocion(+)");
	        qry.append(" and id_socio = ?");      		
	        qry.append(" and id_sucursal_socio = ?");        

	        
	        PreparedStatement ps = conn.prepareStatement(qry.toString());
			try {
				ps.setInt(1, socioPK.ID_SOCIO.intValue());
				ps.setInt(2, socioPK.ID_SUCURSAL.intValue());
				ResultSet rs = ps.executeQuery();
	
				try {
					
					Vector articulos = new Vector();
					Vector gastosDeEnvio = new Vector();
					Vector papeles = new Vector();
					//ArticuloDAO interes;
					while (rs.next()) {
						TmkLogger.debug("PROMOII] Aplicando Promos - >ARTICULO:" + rs.getInt("id_articulo") + " PRECIO:" + rs.getDouble("precio"));
						//ES INTERES
						if (rs.getInt("id_articulo") == Globals.ID_ARTICULO_INTERES_COBRADO) {
							InteresCobradoDAO articulo = new InteresCobradoDAO(rs.getInt("id_articulo"));
							articulo.setIdCampaign(rs.getInt("idcmp"));
							articulo.setNombreCampaign(rs.getString("ncmp"));
							articulo.setIdPromo1(rs.getInt("idp1"));
							articulo.setNombrePromo1(rs.getString("np1"));
							articulo.setIdPromo2(rs.getInt("idp2"));
							articulo.setNombrePromo2(rs.getString("np2"));
							articulo.setIdPromo3(rs.getInt("idp3"));
							articulo.setNombrePromo3(rs.getString("np3"));
							articulo.setIdPromo4(rs.getInt("idp4"));
							articulo.setNombrePromo4(rs.getString("np4"));
							articulo.setIdPromo5(rs.getInt("idp5"));
							articulo.setNombrePromo5(rs.getString("np5"));
							articulo.setPrecioPromocionSinImpuestos(rs.getDouble("precio"));
							//lo seteo directamente en la orden porque es un solo articulo de su tipo y no
							//esta relacionado con otro
							ordenDAO.setInteresCobradoDAO(articulo);
							TmkLogger.debug("INTERES SETEADO " + articulo.getId() + " " + articulo.getPrecioPromocion());
						} else {
							//ES GASTO DE ENVIO
							if (rs.getInt("id_articulo") == Globals.GASTO_ENVIO_ADICIONAL_MERC_EXTERIOR ||
									rs.getInt("id_articulo") == Globals.GASTO_ENVIO_ADICIONAL_MERC_LOCAL ||
									rs.getInt("id_articulo") == Globals.GASTO_ENVIO_BASICO_MERC_EXTERIOR ||
									rs.getInt("id_articulo") == Globals.GASTO_ENVIO_BASICO_MERC_LOCAL||
									rs.getInt("id_articulo") == Globals.GASTO_ENVIO_BASICO_MERC_LOCAL_QUID){
								GastosEnvioDAO articulo = new  GastosEnvioDAO(rs.getInt("id_articulo"), 1);
								articulo.setIdCampaign(rs.getInt("idcmp"));
								articulo.setNombreCampaign(rs.getString("ncmp"));
								//TmkLogger.debug("PROMO: " + rs.getString("ncmp"));
								articulo.setIdPromo1(rs.getInt("idp1"));
								articulo.setNombrePromo1(rs.getString("np1"));
								//TmkLogger.debug("PROMO: " + rs.getString("np1"));
								articulo.setIdPromo2(rs.getInt("idp2"));
								articulo.setNombrePromo2(rs.getString("np2"));
								//TmkLogger.debug("PROMO: " + rs.getString("np2"));
								articulo.setIdPromo3(rs.getInt("idp3"));
								articulo.setNombrePromo3(rs.getString("np3"));
								//TmkLogger.debug("PROMO: " + rs.getString("np3"));
								articulo.setIdPromo4(rs.getInt("idp4"));
								articulo.setNombrePromo4(rs.getString("np4"));
								//TmkLogger.debug("PROMO: " + rs.getString("np4"));
								articulo.setIdPromo5(rs.getInt("idp5"));
								articulo.setNombrePromo5(rs.getString("np5"));
								//TmkLogger.debug("PROMO: " + rs.getString("np5"));
								articulo.setPrecio((articulo.esGastoBasico())? precioGastoBasico: precioGastoAdicional);
								articulo.setPrecioPromocionSinImpuestos(rs.getDouble("precio"));
								gastosDeEnvio.add(articulo);
								TmkLogger.debug("GASTO SETEADO " + articulo.getId() + " " + articulo.getPrecioPromocion());
							} else {
								ArticuloDAO articulo = new  ArticuloDAO(rs.getInt("id_articulo"), 1);
								articulo.setIdCampaign(rs.getInt("idcmp"));
								articulo.setNombreCampaign(rs.getString("ncmp"));
								articulo.setIdPromo1(rs.getInt("idp1"));
								articulo.setNombrePromo1(rs.getString("np1"));
								articulo.setIdPromo2(rs.getInt("idp2"));
								articulo.setNombrePromo2(rs.getString("np2"));
								articulo.setIdPromo3(rs.getInt("idp3"));
								articulo.setNombrePromo3(rs.getString("np3"));
								articulo.setIdPromo4(rs.getInt("idp4"));
								articulo.setNombrePromo4(rs.getString("np4"));
								articulo.setIdPromo5(rs.getInt("idp5"));
								articulo.setNombrePromo5(rs.getString("np5"));
								articulo.setPrecioPromocionSinImpuestos(rs.getDouble("precio"));
								boolean esPapel = false;
								for (int i=0; i<idsPapel.length; i++) {
									if (idsPapel[i] == rs.getInt("id_articulo")) {
										esPapel = true;
										break;
									}
								}
								if (esPapel) {
									//	ES PAPEL
									papeles.add(articulo);
									TmkLogger.debug("PAPEL SETEADO" + articulo.getId() + " " + articulo.getPrecioPromocion());
								} else {
									//	ES PRODUCTO
									articulos.add(articulo);
									TmkLogger.debug("ARTICULO SETEADO " + articulo.getId() + " " + articulo.getPrecioPromocion());
								}
							}
						}		
					}
					TmkLogger.debug("PROMOII] Aplicando Promos -> Articulos:" + articulos.size() + " gastos:" +
										gastosDeEnvio.size() + " papeles:" + papeles.size());
					
					if (articulos.size()>0) {

						ordenDAO.getArticulos().clear();
						

						//ordenDAO.setGastoDeEnvioBasico()
						for (int i=0; i<articulos.size(); i++) {
							ArticuloDAO articulo = (ArticuloDAO)articulos.get(i);
							boolean tienePapel = false;
							for (int j=0; j<idsArticulosConPapel.length && !tienePapel; j++) {
								if (articulo.getId() == idsArticulosConPapel[j]) {
									//encuentro un articulo con papel
									idsArticulosConPapel[j] = -1;
									tienePapel = true;
									for (int k=0; k<papeles.size(); k++) {
										//busco el papel 
										if (((ArticuloDAO)papeles.get(k)).getId() == idsPapel[j]) {
											//encuentro el papel
											//lo seteo al articulo //quito el papel de la lista
											articulo.setPapelDeRegalo((ArticuloDAO)papeles.remove(k));
											idsPapel [j] = -1;
											break;
										}
									}
								}
							}
							//Asignacion de Nota de regalo
							boolean tieneNota =false;
							for (int x=0; x<idsArticulosConNota.length && !tieneNota; x++) {
								if (idsArticulosConNota[x] == articulo.getId()) {
									articulo.setNota(notaDeRegalo[x]);
									tieneNota = true;
								}
							}
							
							//ACA HAY QUE ARMAR ALGO PARA NO SETEAR EL GASTO AL QUE TENGA CANTIDAD 2
							//Le asigno el gasto de envio
							articulo.setGastoDeEvio((GastosEnvioDAO)gastosDeEnvio.get(0));
							gastosDeEnvio.remove(0);
							ordenDAO.addArticuloConPromo(articulo);
						}
						
					
					}	
						
				} catch(Exception e) {
					TmkLogger.error("PROMOII] Aplicando Promos. Error en recorrido de rs " + e.toString());
				} finally {
					rs.close();
				}
	
			} catch(Exception e) {
					TmkLogger.error("PROMOII] Aplicando Promos. Error en ejecucion de qry " + e.toString());
			} finally {
				ps.close();
			}
			
			

		} catch (Exception e) {
			TmkLogger.error("PROMOII] Aplicando Promos. Error en creacion de qry " + e.toString());
		}
		TmkLogger.debug("PROMOII] FIN Aplicando Promos a Orden...");
	}
	
	
//	 Busca el nombre de la promocion
	public static String consultaNombreDePromocion(int idPromocion) {

		try {
			Connection connection = DBUtil.buildConnection();

			try {
				PreparedStatement promociones = connection.prepareStatement(
						"SELECT p.nombre FROM promo2_cabecera p WHERE p.id_promocion = ?");
				try {
					int index = 0;
					promociones.setInt(++index, idPromocion);

					ResultSet resultSet = promociones.executeQuery();
					try {
						return (resultSet.next()) ? resultSet.getString("nombre") : null;

					} finally {
						resultSet.close();
					}

				} finally {
					promociones.close();
				}

			} finally {
				connection.close();
			}

		} catch (Exception e) {
			// No encontro el nombre
			return null;
		}
	}
	
	
	
	public static String consultaNombreDeCampaign(int idCampaign) {

		try {
			Connection connection = DBUtil.buildConnection();

			try {
				PreparedStatement promociones = connection.prepareStatement(
						"SELECT c.descripcion FROM campaigns c WHERE c.id_campaign = ?");
				try {
					int index = 0;
					promociones.setInt(++index, idCampaign);

					ResultSet resultSet = promociones.executeQuery();
					try {
						return (resultSet.next()) ? resultSet.getString("descripcion") : null;

					} finally {
						resultSet.close();
					}

				} finally {
					promociones.close();
				}

			} finally {
				connection.close();
			}

		} catch (Exception e) {
			// No encontro el nombre
			return null;
		}
	}
	
	public static Vector consultarPromocionesAVencer(int dias) {

		try {
			Connection connection = DBUtil.buildConnection();

			try {
				CallableStatement statement = connection.prepareCall(
				        " select id_promocion, nombre, comentarios, f_inicio, f_fin"
					+	" from promo2_cabecera"
					+	" where estado = 'A'"
					+	" and f_fin >= sysdate"
					+	" and f_fin <= sysdate + ?"
					+	" order by f_fin"
						);
				try {
					int index = 0;
					statement.setInt(++index, dias);
					ResultSet resultSet = statement.executeQuery();
					try {
						Vector vencen = new Vector();
						while (resultSet.next()) {
							// articulo en promocion
							Promocion2 promocion = new Promocion2(
									resultSet.getInt("id_promocion"),
							        resultSet.getString("nombre"),
							        resultSet.getString("comentarios"),
							        resultSet.getDate("f_inicio"),
							        resultSet.getDate("f_fin"));
							// la agrega
							vencen.add(promocion);
						}
						// las devuelve
						return vencen;

					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}

		} catch (Exception e) {
			TmkLogger.error("No se pueden encontrar las promociones que vencen");
			return null;
		}
	}


	public static Vector consultarPromocionesHistoricas(int idUsuario, int idSucursalUsuario) {

		try {
			Connection connection = DBUtil.buildConnection();

			try {
				CallableStatement statement = connection.prepareCall(
				        " select distinct prom.id_promocion, prom.nombre, prom.comentarios, prom.f_inicio, prom.f_fin"
					+	" from item_orden ior, orden ord, promo2_cabecera prom"
					+	" where ior.id_orden = ord.id_orden"
					+	" and ord.id_socio = ?"
					+	" and ord.id_sucursal_socio = ?"
					+	" and prom.id_promocion = ior.id_promocion"
					+	" order by prom.f_fin desc");
				try {
					int index = 0;
					statement.setInt(++index, idUsuario);
					statement.setInt(++index, idSucursalUsuario);
					ResultSet resultSet = statement.executeQuery();
					try {
						Vector historicas = new Vector();
						while (resultSet.next()) {
							// articulo en promocion
							Promocion2 promocion = new Promocion2(
									resultSet.getInt("id_Promocion"),
							        resultSet.getString("nombre"),
							        resultSet.getString("comentarios"),
							        resultSet.getDate("f_inicio"),
							        resultSet.getDate("f_fin"));
							// la agrega
							historicas.add(promocion);
						}
						// las devuelve
						return historicas;

					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}

		} catch (Exception e) {
			TmkLogger.error("No se puede mostrar las promociones. Error" + e.getMessage());
			return new Vector();
		}
	}
	

}	
	
