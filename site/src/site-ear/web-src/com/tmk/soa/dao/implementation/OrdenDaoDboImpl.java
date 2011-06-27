package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.util.Collection;
import java.util.TreeSet;

import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.orden.AlianzaSeccion;
import com.tmk.bus.orden.CuponDePago;
import com.tmk.bus.orden.DireccionOrden;
import com.tmk.bus.orden.DominioSite;
import com.tmk.bus.orden.EstadoItemOrden;
import com.tmk.bus.orden.EstadoOrden;
import com.tmk.bus.orden.ItemOrden;
import com.tmk.bus.orden.ItemOrdenImpuesto;
import com.tmk.bus.orden.MediosDeCobros;
import com.tmk.bus.orden.NivelDeRiesgo;
import com.tmk.bus.orden.NotaRegalo;
import com.tmk.bus.orden.Orden;
import com.tmk.bus.orden.PagoOrden;
import com.tmk.bus.orden.TarjetaOrden;
import com.tmk.bus.socio.Localidad;
import com.tmk.bus.socio.Pais;
import com.tmk.bus.socio.Provincia;
import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.bus.socio.Socios2;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.dbo.sql.OrderBYDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.interfaces.OrdenDAO;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.persistencia.ConnectionProvider;

public class OrdenDaoDboImpl implements OrdenDAO {

	public Collection findAll() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Orden findByPrimaryKey(Integer pk) throws AplicationException {
		CamposABuscarDBO camposABuscar = new CamposABuscarDBO();	
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".id_orden");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".fecha");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".neto");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".total");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".telefono");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".hr_contacto");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".comentarios");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".total");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".motivo_riesgo");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".nombres_receptor");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".apellidos_receptor");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".cupon");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".cpf_cnpj");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".nro_doc_receptor");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".tipo_doc_receptor");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".rango_horario_receptor");
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".fac_elc_env");		
		//ESTADO_ORDEN
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".estado");
		camposABuscar.agregarCampoABusqueda(EstadoOrden.getAlias() + ".estado");
		camposABuscar.agregarCampoABusqueda(EstadoOrden.getAlias() + ".descripcion");
		camposABuscar.agregarCampoABusqueda(EstadoOrden.getAlias() + ".descripcion_extendida");
		//PAGO_ORDEN
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".pago_orden");
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".id_orden");
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".id_medio_cobro");
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".importe");
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".cuotas");
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".coeficiente");
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".moneda");
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".cambio");		
		//medios_de_cobros
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".mediosDeCobro");
		camposABuscar.agregarCampoABusqueda(MediosDeCobros.getAlias() + ".id_medio_cobro");
		camposABuscar.agregarCampoABusqueda(MediosDeCobros.getAlias() + ".descripcion");
		camposABuscar.agregarCampoABusqueda(MediosDeCobros.getAlias() + ".cuenta_mascara");
		camposABuscar.agregarCampoABusqueda(MediosDeCobros.getAlias() + ".tipo");
		//tarjeta_orden
		camposABuscar.agregarCampoABusqueda(PagoOrden.getAlias() + ".tarjeta_orden");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".id_orden");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".id_medio_cobro");		
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".nro_tarjeta");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".codigo_respuesta");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".codigo_autorizacion");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".mensaje_gpay");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".tipo_doc");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".direccion_resumen");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".p1");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".p2");
		camposABuscar.agregarCampoABusqueda(TarjetaOrden.getAlias() + ".p3");
		
		
		//DIRECCION_ORDEN
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".direccion_orden");
		camposABuscar.agregarCampoABusqueda(DireccionOrden.getAlias() + ".id_orden");
		camposABuscar.agregarCampoABusqueda(DireccionOrden.getAlias() + ".id_sucursal_socio");
		camposABuscar.agregarCampoABusqueda(DireccionOrden.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(DireccionOrden.getAlias() + ".tipo_domicilio");
		
		camposABuscar.agregarCampoABusqueda(DireccionOrden.getAlias() + ".domicilio_orden");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".tipo_domicilio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".calle");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".numero");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".edificio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".piso");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".dpto");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".cp");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".descripcion_provincia_inex");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".descripcion_localidad_inex");
		
		//pais,provincia,localidad
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".pais");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
		//socios_domicilio->provincia
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".provincia");
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_provincia");
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".descripcion");
		//pais->provincia->localidad
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".localidad");
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_provincia");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_localidad");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".descripcion");
		
		//CUPON_DE_PAGO
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".cupon_pago");
		camposABuscar.agregarCampoABusqueda(CuponDePago.getAlias() + ".id_orden");
		camposABuscar.agregarCampoABusqueda(CuponDePago.getAlias() + ".codigo");
		//ALIANZA_SECCION
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".alianza_seccion");
		camposABuscar.agregarCampoABusqueda(AlianzaSeccion.getAlias() + ".id_alianza");
		camposABuscar.agregarCampoABusqueda(AlianzaSeccion.getAlias() + ".id_seccion");
		camposABuscar.agregarCampoABusqueda(AlianzaSeccion.getAlias() + ".seccion_nombre");
		//DOMINIO_SITE
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".dominio_site");
		camposABuscar.agregarCampoABusqueda(DominioSite.getAlias() + ".id_dominio");
		camposABuscar.agregarCampoABusqueda(DominioSite.getAlias() + ".dominio");
		//camposABuscar.agregarCampoABusqueda(DominioSite.getAlias() + ".seccion_nombre");
		//SOCIO2
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".socio");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".login");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".e_mail1");
		//NIVEL DE RIEGO
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".nivel_riesgo");
		camposABuscar.agregarCampoABusqueda(NivelDeRiesgo.getAlias() + ".nivel_riesgo");
		camposABuscar.agregarCampoABusqueda(NivelDeRiesgo.getAlias() + ".descripcion");				
		//ITEM ORDEN
		camposABuscar.agregarCampoABusqueda(Orden.getAlias() + ".item_orden");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_orden");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_articulo");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".item");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".cantidad");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".precio_original");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_papel_regalo");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".precio_descuento");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".precio_promocion");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".precio_unitario");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_lista_pvp;");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_promocion");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".precio_promocion_sin_impuestos");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_promocion2");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_promocion3");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_promocion4");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_promocion5");
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".id_campaing");
		//item_orden_impuesto
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".item_orden_impuesto");
		camposABuscar.agregarCampoABusqueda(ItemOrdenImpuesto.getAlias() + ".id_orden");
		camposABuscar.agregarCampoABusqueda(ItemOrdenImpuesto.getAlias() + ".id_articulo");
		camposABuscar.agregarCampoABusqueda(ItemOrdenImpuesto.getAlias() + ".tasa_gral");
		camposABuscar.agregarCampoABusqueda(ItemOrdenImpuesto.getAlias() + ".tasa_percep_video");
		camposABuscar.agregarCampoABusqueda(ItemOrdenImpuesto.getAlias() + ".valor_percep_video");
		camposABuscar.agregarCampoABusqueda(ItemOrdenImpuesto.getAlias() + ".item");
		//estado_item_orden
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".estado_item_orden");
		camposABuscar.agregarCampoABusqueda(EstadoItemOrden.getAlias() + ".estado");
		camposABuscar.agregarCampoABusqueda(EstadoItemOrden.getAlias() + ".descripcion");
		//nota_regalo
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".nota_regalo");
		camposABuscar.agregarCampoABusqueda(NotaRegalo.getAlias() + ".id_orden");
		camposABuscar.agregarCampoABusqueda(NotaRegalo.getAlias() + ".id_articulo");
		camposABuscar.agregarCampoABusqueda(NotaRegalo.getAlias() + ".item");
		camposABuscar.agregarCampoABusqueda(NotaRegalo.getAlias() + ".nota_regalo");
		//item->articulo
		camposABuscar.agregarCampoABusqueda(ItemOrden.getAlias() + ".articulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_grupo");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_familia");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_subfamilia");
		camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".precio_venta_vigente");

		//CAMPOS LEFT-JOIN
		CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
		//camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".socio");
		//camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".estado");
		camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".cupon_pago");
		camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".alianza_seccion");
		camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".dominio_site");
		camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".direccion_orden");
		camposLeftJoin.setCampoDBOLeftJoin(DireccionOrden.getAlias()+".domicilio_orden");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".pais");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".provincia");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".localidad");
		
		camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".pago_orden");		
		camposLeftJoin.setCampoDBOLeftJoin(PagoOrden.getAlias()+".mediosDeCobro");
		camposLeftJoin.setCampoDBOLeftJoin(PagoOrden.getAlias()+".tarjeta_orden");
		
		camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".nivel_riesgo");
		
		camposLeftJoin.setCampoDBOLeftJoin(Orden.getAlias()+".item_orden");
		camposLeftJoin.setCampoDBOLeftJoin(ItemOrden.getAlias()+".estado_item_orden");
		camposLeftJoin.setCampoDBOLeftJoin(ItemOrden.getAlias()+".item_orden_impuesto");
		camposLeftJoin.setCampoDBOLeftJoin(ItemOrden.getAlias()+".nota_regalo");
		
		//WHERE
		Condicion condicionIdSocio = new Condicion(Orden.getAlias()+".id_orden",
		Comparador.IGUAL,pk.toString());	
		
		WhereDBO where = new WhereDBO();
		where.add(condicionIdSocio);
		
		OrderBYDBO order = new OrderBYDBO();
		order.agregarCampoAOrden(Orden.getAlias()+".id_orden desc ");
		order.agregarCampoAOrden(ItemOrden.getAlias()+".item");
		
		Connection con = null;
		TreeSet<DBO> colDomicilio = null;
		try {
			con = DBUtil.buildConnection();
			colDomicilio = (TreeSet<DBO>)DBO.select2(Orden.class,con,camposABuscar,camposLeftJoin,where,order, new ComparadorPorDefecto());			
			return (Orden)colDomicilio.iterator().next();
		}catch(Exception e) {
			throw new AplicationException(e);			
		}
		finally {
			camposABuscar = null;
			camposLeftJoin = null;
			condicionIdSocio = null;
			colDomicilio = null;
			where = null;
			try {
				con.close();
			} catch (Exception e) {				
				throw new AplicationException(e);
			}
		}
	}

	public Collection findOrdenesDelDia() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesEnEstado(Integer desdeOrden, String estado,
			Integer cantidad, String medioDeCobro) throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesEnEstadoParaEfectivo(Integer desdeOrden,
			String estado, Integer cantidad, String medioDeCobro)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesEnProceso(Integer param1, Integer param2)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesFraudulentas() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesParecidas() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesPorSocio(Integer idSucursal, Integer idSocio)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesProcesadas(Integer param1, Integer param2)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesRelacionadas(Integer idOrden)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesRetrasadas() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findUltimasOrdenes() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Graba losd datos en la tabla orden.
	 */
	public void create(Orden orden) throws AplicationException {
		Connection con = null;
		try {
			con = ConnectionProvider.getConection();
			orden.insert(con);
		} catch (Exception e) {
			if(orden!=null){
				String error="";
				if((orden.getAlianza_seccion()!=null)&&(orden.getAlianza_seccion().getId_alianza()!=null))
					error+=" idAlianza:["+orden.getAlianza_seccion().getId_alianza().toString()+"] ";
				if(orden.getApellidos_receptor()!=null)
					error+=" apellidoReceptor:["+orden.getApellidos_receptor()+"] ";
				if(orden.getComentarios()!=null)
					error+=" comentarios:["+orden.getComentarios()+"] ";
				if(orden.getCpf_cnpj()!=null)
					error+=" cpf_cnpj:["+orden.getCpf_cnpj()+"] ";
				if(orden.getCupon()!=null)
					error+=" cupon:["+orden.getCupon()+"] ";
				if((orden.getCupon_pago()!=null)&&(orden.getCupon_pago().getCodigo()!=null))
					error+=" cupon de pago:["+orden.getCupon_pago().getCodigo()+"] ";
				if((orden.getDominio_site()!=null)&&(orden.getDominio_site().getDomiinio()!=null))
					error+=" dominio:["+orden.getDominio_site().getDomiinio()+"] ";
				if((orden.getEstado()!=null)&&(orden.getEstado().getEstado()!=null))
					error+=" estado:["+orden.getEstado().getEstado()+"] ";
				
				if(orden.getFac_elc_env()!=null)
					error+=" fac_elc_env:["+orden.getFac_elc_env()+"] ";
				if(orden.getFecha()!=null)
					error+=" fecha:["+orden.getFecha().toGMTString()+"] ";
				if(orden.getHr_contacto()!=null)
					error+=" hr_contacto:["+orden.getHr_contacto()+"] ";
				if(orden.getId_orden()!=null)
					error+=" idOrden:["+orden.getId_orden().toString()+"] ";
				
				if(orden.getId_orden_motivo_riesgo()!=null)
					error+=" motivoOrden:["+orden.getId_orden_motivo_riesgo()+"] ";
				if(orden.getMotivo_riesgo()!=null)
					error+=" motivoRiesgo:["+orden.getMotivo_riesgo()+"] ";
				if(orden.getNeto()!=null)
					error+=" neto:["+orden.getNeto().toString()+"] ";
				if(orden.getNivel_riesgo()!=null)
					error+=" nivel_riesgo:["+orden.getNivel_riesgo().getDescripcion()+"] ";
				if(orden.getNombres_receptor()!=null)
					error+=" nombres_receptor:["+orden.getNombres_receptor()+"] ";
				if(orden.getNro_doc_receptort()!=null)
					error+=" nro_doc_receptor:["+orden.getNro_doc_receptort().toString()+"] ";
				if(orden.getTotal()!=null)
					error+=" total:["+orden.getTotal()+"] ";
			
				TmkLogger.error("Error procesando orden,  "+error);
				
				if(orden.getItem_orden()!=null){
					for(int i=0; i<orden.getItem_orden().length; i++){
						ItemOrden item=orden.getItem_orden()[i];
						error="";
						if(item.getArticulo()!=null)
							error+=" articulo:["+item.getArticulo().getPK()+"] ";
						if(item.getCantidad()!=null)
							error+=" cantidad:["+item.getCantidad().toString()+"] ";
						if((item.getEstado_item_orden()!=null)&&(item.getEstado_item_orden().getEstado()!=null))
							error+=" getEstado_item_orden:["+item.getEstado_item_orden().getEstado()+"] ";
						if((item.getEstadoItemOrden()!=null)&&(item.getEstadoItemOrden().getEstado()!=null))
							error+=" getEstadoItemOrden:["+item.getEstadoItemOrden().getEstado()+"] ";
						//if(item.getGastoDeEnvio()!=null)
						//	error+=" articulo:["+item.getArticulo()+"] ";
						if(item.getId_articulo()!=null)
							error+=" articulo:["+item.getId_articulo().toString()+"] ";
						if(item.getId_campaign()!=null)
							error+=" getId_campaign:["+item.getId_campaign().toString()+"] ";
						if(item.getId_lista_pvp()!=null)
							error+=" getId_lista_pvp:["+item.getId_lista_pvp().toString()+"] ";
						if(item.getId_orden()!=null)
							error+=" getId_orden:["+item.getId_orden().toString()+"] ";
						if(item.getId_papel_regalo()!=null)
							error+=" getId_papel_regalo:["+item.getId_papel_regalo().toString()+"] ";
						if(item.getId_promocion()!=null)
							error+=" getId_promocion:["+item.getId_promocion()+"] ";
						if(item.getId_promocion2()!=null)
							error+=" getId_promocion2:["+item.getId_promocion2()+"] ";
						if(item.getId_promocion3()!=null)
							error+=" getId_promocion3:["+item.getId_promocion3()+"] ";
						if(item.getId_promocion4()!=null)
							error+=" getId_promocion4:["+item.getId_promocion4()+"] ";
						if(item.getId_promocion5()!=null)
							error+=" getId_promocion5:["+item.getId_promocion5()+"] ";
						if(item.getItem_orden_impuesto()!=null)
							error+=" getItem_orden_impuesto:["+item.getItem_orden_impuesto().getPK()+"] ";
						if(item.getNota_regalo()!=null)
							error+=" getNota_regalo:["+item.getNota_regalo().getNota_regalo()+"] ";
						if(item.getPrecio_descuento()!=null)
							error+=" getPrecio_descuento:["+item.getPrecio_descuento().toString()+"] ";
						if(item.getPrecio_original()!=null)
							error+=" getPrecio_original:["+item.getPrecio_original().toString()+"] ";
						if(item.getPrecio_promocion()!=null)
							error+=" getPrecio_promocion:["+item.getPrecio_promocion().toString()+"] ";
						if(item.getPrecio_promocion_sin_impuestos()!=null)
							error+=" getPrecio_promocion_sin_impuestos:["+item.getPrecio_promocion_sin_impuestos().toString()+"] ";
						if(item.getPrecio_unitario()!=null)
							error+=" getPrecio_unitario:["+item.getPrecio_unitario().toString()+"] ";
						error+=" idOrden:["+orden.getId_orden().toString()+"] ";
						TmkLogger.error("ItemOrden,  "+error);
					}
				}
				
				if(orden.getPago_orden()!=null){
					error="";
					if(orden.getPago_orden().getCambio()!=null)
						error+=" getCambio:["+orden.getPago_orden().getCambio().toString()+"] ";
					if(orden.getPago_orden().getCoeficiente()!=null)
						error+=" getCoeficiente:["+orden.getPago_orden().getCoeficiente().toString()+"] ";
					if(orden.getPago_orden().getCuotas()!=null)
						error+=" getCuotas:["+orden.getPago_orden().getCuotas().toString()+"] ";
					if(orden.getPago_orden().getId_medio_cobro()!=null)
						error+=" getId_medio_cobro:["+orden.getPago_orden().getId_medio_cobro().toString()+"] ";
					if(orden.getPago_orden().getImporte()!=null)
						error+=" getImporte:["+orden.getPago_orden().getImporte().toString()+"] ";
					if(orden.getPago_orden().getMediosDeCobro()!=null)
						error+=" getMediosDeCobro:["+orden.getPago_orden().getMediosDeCobro().getId_medio_cobro()+"] ";
					if(orden.getPago_orden().getMoneda()!=null)
						error+=" getMoneda:["+orden.getPago_orden().getMoneda().toString()+"] ";
					if(orden.getPago_orden().getTarjeta_orden()!=null)
						error+=" getTarjeta_orden:["+orden.getPago_orden().getTarjeta_orden().getPK()+"] ";
						TmkLogger.error("ordenPago,  "+error);
				}
			}
			throw new AplicationException(e);
		} 
		finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new AplicationException(e);
			}
		}
	}

}
