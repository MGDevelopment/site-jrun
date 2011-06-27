package com.tmk.articulo;

import com.tmk.kernel.*;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.EJBException;
import javax.ejb.CreateException;
//import javax.ejb.FinderException;
import java.util.Vector;
import java.util.Iterator;

public abstract class ArticuloReducidoBean implements EntityBean
{
	private EntityContext context;

	private double tasaImpuestoGeneral;
	private double tasaImpuestoVideo;
	private double porcentaje;
	private int listaPVP;

	private Vector idAtributoPrincipal = null;
	private Vector descAtributoPrincipal = null;
	private String textoAtributoPrincipal = null;
	private String textoAtributoPrincipalDetallado = null;
	private String nombreAtributoPrincipal = null;

    private String nombreEditorial;

	private String seccion;
	private String grupo;
	private String familia;
	private String subFamilia;


	public void ejbLoad() {
		tasaImpuestoGeneral = 0.0;
		tasaImpuestoVideo = 0.0;
		porcentaje = 0.0;
		listaPVP = 0;

		// consulta de tasas
		try {
			if (getID_IMPUESTO() != null) {
				Pair tasas = DBUtil.calculaTasas(getID_IMPUESTO());
				tasaImpuestoGeneral = Convert.round(((Number) tasas.getValue1()).doubleValue());
				tasaImpuestoVideo = Convert.round(((Number) tasas.getValue2()).doubleValue());
			}
		} catch (Exception e) {
			TmkLogger.warn("No se pudo cargar las tasas del articulo " + getID_ARTICULO() + ". Error " + e.getMessage());
		}

		// pricing
		try {
			Pair pair = DBUtil.calculaPricing(getID_ARTICULO());
			listaPVP = ((Integer) pair.getValue1()).intValue();
			porcentaje = Convert.round(((Double) pair.getValue2()).doubleValue());

		} catch (Exception e) {
			TmkLogger.warn("No se pudo calcular pricing para articulo " + getID_ARTICULO() + ". Error " + e.getMessage());
		}

        Vector atributos = new Vector();
		try {

			switch(getCATEGORIA_SECCION().intValue()) {

			case Globals.SECCION_LIBRO:         // Continua abajo para no repetir lo mismo
			case Globals.SECCION_REVISTAS: {
				atributos = getAUTOR();
				idAtributoPrincipal = (atributos == null || atributos.isEmpty())? null: (Vector)atributos.get(0);
				descAtributoPrincipal = (atributos == null || atributos.isEmpty())? null: (Vector)atributos.get(1);
				textoAtributoPrincipal = (descAtributoPrincipal == null || descAtributoPrincipal.isEmpty()) ? "" :
				        (descAtributoPrincipal.size() == 1) ? descAtributoPrincipal.firstElement().toString(): "Autores varios";

				        nombreAtributoPrincipal = (idAtributoPrincipal ==null || idAtributoPrincipal.isEmpty())? "":
				        (idAtributoPrincipal.size() == 1)? "Autor": "Autores";
				nombreEditorial = "Editorial";

			} break;

			case Globals.SECCION_MUSICA: {
				atributos = getAUTOR();
				idAtributoPrincipal = (atributos == null || atributos.isEmpty())? null: (Vector)atributos.get(0);
				descAtributoPrincipal = (atributos == null || atributos.isEmpty())? null: (Vector)atributos.get(1);
				textoAtributoPrincipal = (descAtributoPrincipal == null || descAtributoPrincipal.isEmpty()) ? "" :
				        (descAtributoPrincipal.size() == 1) ? descAtributoPrincipal.firstElement().toString(): "Intérpretes varios";
				nombreAtributoPrincipal = (idAtributoPrincipal ==null || idAtributoPrincipal.isEmpty())? "":
				        (idAtributoPrincipal.size() == 1)? "Intérprete": "Intérpretes";
				nombreEditorial = "Discográfica";

			} break;

			case Globals.SECCION_PELICULA: {
				atributos = getDIRECTOR();
				idAtributoPrincipal = (atributos == null || atributos.isEmpty())? null: (Vector)atributos.get(0);
				descAtributoPrincipal = (atributos == null || atributos.isEmpty())? null: (Vector)atributos.get(1);
				textoAtributoPrincipal = (descAtributoPrincipal == null || descAtributoPrincipal.isEmpty()) ? "" :
				        (descAtributoPrincipal.size() == 1) ? descAtributoPrincipal.firstElement().toString(): "Directores varios";

				nombreAtributoPrincipal = (idAtributoPrincipal ==null || idAtributoPrincipal.isEmpty())? "":
				        (idAtributoPrincipal.size() == 1)? "Director": "Directores";
                nombreEditorial = "Productora";

			} 	break;

			case Globals.SECCION_JUGUETES: {
				ProveedorLocalHome proveedorHome = (ProveedorLocalHome) DBUtil.getHome("Proveedor");
				ProveedorLocal proveedor = proveedorHome.findByPrimaryKey(getID_PROVEEDOR());
				idAtributoPrincipal = new Vector();
				idAtributoPrincipal.add(proveedor.getID_PROVEEDOR());
				textoAtributoPrincipal = Convert.nombrePropio(proveedor.getNOMBRE());
				descAtributoPrincipal = new Vector();
				descAtributoPrincipal.add(textoAtributoPrincipal);
				nombreAtributoPrincipal = "Proveedor";

                nombreEditorial = "Editorial";

			}   break;

			default: {
				TmkLogger.error("ATRIBUTO_PRINCIPAL: Se esta mostrando un producto de una caterogia no registrada. Categoria: " + getCATEGORIA_SECCION() + " Articulo:" + getID_ARTICULO());
			}
		}
			if (descAtributoPrincipal != null) {
				StringBuffer str = new StringBuffer ();
				for (int i = 0; i<descAtributoPrincipal.size(); i++) {
						str.append(descAtributoPrincipal.get(i)).append(" / ");
				} if (str.length()>0) {
					 textoAtributoPrincipalDetallado = str.substring(0, str.length()-3);
				} else {
					textoAtributoPrincipalDetallado= "";
				}
			}


			} catch (Exception e) {
				TmkLogger.warn("No se pudo cargar el atributo principal del articulo " + getID_ARTICULO() + ". Error " + e.getMessage());
			}

			try {
				if (atributos != null) {
					Vector categ = DBUtil.categorizacionDeArticulo(getCATEGORIA_SECCION(), getCATEGORIA_GRUPO(), getCATEGORIA_FAMILIA(), getCATEGORIA_SUBFAMILIA());
					seccion = (String)categ.get(0);
					grupo = (getCATEGORIA_GRUPO().intValue() == 0)? "" : (String)categ.get(1);
					familia = (getCATEGORIA_FAMILIA().intValue() == 0)? "" : (String)categ.get(2);
					subFamilia = (getCATEGORIA_SUBFAMILIA().intValue() == 0)? "" : (String)categ.get(3);
				}

			} catch (Exception e) {
				TmkLogger.warn("No se pudo cargar la categorizacion del articulo " + getID_ARTICULO() + ". Error " + e.getMessage());
			}
		//TmkLogger.debug("Articulo " + getID_ARTICULO() + ", imp. " + getID_IMPUESTO() + " %gral. " + tasaImpuestoGeneral + " %video "  + tasaImpuestoVideo + ", lista " + listaPVP + ", %desc " + porcentaje);
	}


	public void ejbStore() {
	}

	public void setEntityContext(EntityContext context) {
		this.context = context;
	}

	public void unsetEntityContext() throws EJBException {
		this.context = null;
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public Integer ejbCreate()throws CreateException {
		return null;
	}

	public void ejbPostCreate() {
	}

	// cmp field methods
	public abstract Integer getID_ARTICULO();

	public abstract String getTITULO();

	public abstract Double getPRECIO_VENTA_VIGENTE();

	public abstract Integer getID_DISPONIBILIDAD();

	public abstract String getHABILITADO_TEMATIKA();

	public abstract String getID_IMPUESTO();

	public abstract Integer getCATEGORIA_SECCION();

	public abstract Integer getCATEGORIA_GRUPO();

	public abstract Integer getCATEGORIA_FAMILIA();

	public abstract Integer getCATEGORIA_SUBFAMILIA();

	public abstract Integer getID_EDITOR();

	public abstract Integer getID_PROVEEDOR();

	public abstract String getCOD_EXT_VISUAL();

	public abstract String getID_TIPO_ARTICULO();

	public abstract Integer getAUXNUMBER03();

    public abstract String getDESCRIPCION();

	public int getListaPVP() {
		return listaPVP;
	}

	public Double getPRECIO_ORIGINAL() {
		Double pvp = getPRECIO_VENTA_VIGENTE();
		double importe = Math.max((pvp == null) ? 0.0 : pvp.doubleValue(), Globals.IMPORTE_MINIMO_AFIP);
		return new Double(Convert.round(importe));
	}

	public Double getPRECIO_CON_IMPUESTOS() {
		double importe = Convert.aplicarPorcentaje(getPRECIO_ORIGINAL().doubleValue(), tasaImpuestoGeneral + tasaImpuestoVideo);
		return new Double(Convert.round(importe));
	}

	public boolean getTIENE_DESCUENTO() {
		return (porcentaje < 0.0);
	}

	public Double getPORCENTAJE_DESCUENTO() {
		return new Double(porcentaje);
	}

	public Double getPRECIO_CON_DESCUENTO() {
		double importe = Convert.aplicarPorcentaje(getPRECIO_CON_IMPUESTOS().doubleValue(), porcentaje);
		return new Double(Convert.round(importe));
	}

	public Double getPRECIO_SITIO() {
		return getPRECIO_CON_DESCUENTO();
	}

	public DisponibilidadDAO getDISPONIBILIDAD_SITIO() {
		return DisponibilidadDAO.buscaDisponibilidad(getID_DISPONIBILIDAD());
	}

	public boolean getESTA_HABILITADO_TEMATIKA() {
		return "S".equalsIgnoreCase(getHABILITADO_TEMATIKA());
	}


	public String getEDITOR() {
		try {
			EditorLocalHome editorLH = (EditorLocalHome) DBUtil.getHome("Editor");
			EditorLocal editor = editorLH.findByPrimaryKey(getID_EDITOR());
			return editor.getNOMBRE();
		} catch(Exception e) {
			TmkLogger.debug("ARTICULO REDUCIDO] No se pudo cargar el editor" + getID_ARTICULO());
			return null;
		}
	}



	private Vector getAUTOR() {
        return getRol("A01");
	}

	private Vector getDIRECTOR() {
       return getRol("D02");
	}

	public String getProtagonista() {
		Vector vec = getRol("E01");
		if (vec!= null) {
			StringBuffer str = new StringBuffer();
			Vector prot = (Vector) vec.get(1);
			for (int i=0; i<prot.size(); i++) {
				str.append(prot.get(i)).append(" / ");
			}
			if (str.length()>0) {
				 return str.substring(0, str.length()-3);
			} else {
				return null;
			}
		}  else {
			return null;
		}
	}


	private Vector getRol(String rol) {
		try {
			Vector result = new Vector(2);
			Vector id = new Vector();
			Vector nombre = new Vector();
			ArticuloAutoresLocalHome articuloAutoresLocalHome = (ArticuloAutoresLocalHome) DBUtil.getHome("ArticuloAutores");
			AutorLocalHome autorLocalHome = (AutorLocalHome) DBUtil.getHome("Autor");

			Iterator iterator = articuloAutoresLocalHome.findAutores(getID_ARTICULO(), rol).iterator();

			while (iterator.hasNext()) {

				ArticuloAutoresLocal articuloAutores = (ArticuloAutoresLocal) iterator.next();
				AutorLocal autorLocal = autorLocalHome.findByPrimaryKey(articuloAutores.getID_AUTOR());
				id.add(autorLocal.getID_AUTOR());
				//nombre.add(Convert.nombrePropio(autorLocal.getDESCRIPCION()));
				if (getCATEGORIA_SECCION().intValue() == Globals.SECCION_MUSICA) {

					nombre.add(Convert.capitalizar(autorLocal.getDESCRIPCION().toUpperCase().replaceFirst("\\[MUS]", ""), true));
				}
				else {
					nombre.add(Convert.nombrePropio(autorLocal.getDESCRIPCION()));
				}
				//result.add(fila);
			}
			result.add(id);
			result.add(nombre);
			return result;

		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar el rol para el articulo " + getID_ARTICULO() + " y rol " + rol);
			return null;
		}
	}

	public Vector getID_ATRIBUTO_PRINCIPAL() {
		return idAtributoPrincipal;
	}

	public Vector getDESC_ATRIBUTO_PRINCIPAL() {
		return descAtributoPrincipal;
	}

	public String getTEXTO_ATRIBUTO_PRINCIPAL() {
		return textoAtributoPrincipal;
	}

	public String getTEXTO_ATRIBUTO_PRINCIPAL_DETALLADO() {
		return textoAtributoPrincipalDetallado;
	}

	public String getTITULO_CORTO() {
		String titulo = Convert.corregir(getTITULO(), true);
		int tope = 19;
		titulo = (titulo.length() > tope)? titulo.substring(0, 19) + "...": titulo;
		return titulo;
	}

	public String getCategorizacion() {
		return Convert.corregir(Convert.toString(familia, Convert.toString(grupo, seccion)), true);
	}

	public String getSinopsis() {
		String temp = null;

		if (temp == null) temp = getArticuloTexto("01", "ES");
		if (temp == null) temp = getArticuloTexto("02", "ES");
		return temp;
	}

	private String getArticuloTexto(String tipo, String idioma) {
		try {
			StringBuffer buffer = new StringBuffer();
			ArticuloTextoLocalHome articuloTextoLocalHome = (ArticuloTextoLocalHome) DBUtil.getHome("ArticuloTexto");
			Iterator iterator = articuloTextoLocalHome.findTextos(getID_ARTICULO(), tipo).iterator();
			while (iterator.hasNext()) {
			ArticuloTextoLocal articuloTextoLocal = (ArticuloTextoLocal) iterator.next();
				if ((idioma == null) || (idioma.equalsIgnoreCase(articuloTextoLocal.getIDIOMA()))) {
					buffer.append(articuloTextoLocal.getTEXTO());
				}
			}

			return (buffer.length() > 0) ? buffer.toString() : null;

		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar el texto para el articulo " + getID_ARTICULO() + " y tipo " + tipo);
			return null;
		}
	}

	public String getNombreAtributoPrincipal() {
		return nombreAtributoPrincipal;
	}

	public String getNombreEditorial() {
		return nombreEditorial;
	}

	public String getISBN() {
		return getCOD_EXT_VISUAL();
	}

	public String getFormato () {
		try {
			return DBUtil.getTipoDeArticulo(getID_TIPO_ARTICULO());
		} catch (Exception e) {
			return null;
		}

	}

	public Double getAHORRO() {
		double importe = Convert.porcentajeResultante(getPRECIO_CON_IMPUESTOS().doubleValue(), porcentaje);
		return new Double(Convert.round(importe));
	}

	public Double getTASA_IMPUESTO_GENERAL() {
		return new Double(tasaImpuestoGeneral);
	}

    public Double getTASA_IMPUESTO_VIDEO() {
		return new Double(tasaImpuestoVideo);
	}

    /*recorrido familias*/
    public String getSeccion(){
        return seccion;
    }
    public String getGrupo(){
        return grupo;
    }
    public String getFamilia(){
        return familia;
    }
    /*recorrido familias*/

    /*busquedas*/
    public Vector getTEMAS() {
		return DBUtil.getTemasMusicales(getID_ARTICULO().intValue());
	}
    /*busquedas*/
}


