package com.tmk.bus.articulo;
import com.tmk.bus.fk.TasaFK;
import com.tmk.dbo.DBO;
import com.tmk.kernel.Globals;

public class Tasa extends DBO{
	private static final TasaFK cls_fk = TasaFK.getInstance();

	private Double tasa_general;
	private Double tasa_adicional;
	private Double tasa_percep_video;

	public Tasa() {
		 
	}

	public static String getAlias() {
		return "TAS";
	}

	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public static String getFiltro() {
		final StringBuffer filtro = new StringBuffer("");
		filtro.append(getAlias()).append(".id_tipo_contribuyente(+) = ").append(Globals.ID_TIPO_CONTRIBUYENTE );
		filtro.append(" and ");
		filtro.append(" nvl(fecha_vigencia, sysdate) = (SELECT nvl(MAX (fecha_vigencia), sysdate)");
		filtro.append(" FROM TASAS ");
		filtro.append(" WHERE " );
		filtro.append(" tasas.id_impuesto =").append(getAlias()).append(".id_impuesto");
		filtro.append(" and ");
		filtro.append(" tasas.id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE );
		filtro.append(" and ");
		filtro.append(" tasas.fecha_vigencia <= SYSDATE)");
		return filtro.toString();
	}

	public static String getOrden() {
		return "";
	}

	public String getPK() {
		return null;
	}

	public static String getTabla() {
		return "TASAS";
	}

	public Double getTasa_adicional() {
		return tasa_adicional;
	}

	public Double getTasa_general() {
		return tasa_general;
	}

	public Double getTasa_percep_video() {
		return tasa_percep_video;
	}

	public boolean tieneDBO() {
		
		return false;
	}



}
