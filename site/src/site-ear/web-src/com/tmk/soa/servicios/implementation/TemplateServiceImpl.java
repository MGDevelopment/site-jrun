package com.tmk.soa.servicios.implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import com.tmk.controllers.MainHelper;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.interfaces.TemplateService;
import com.tmk.util.ByteArrayWarpper;
import com.tmk.util.HTML.Template;

public class TemplateServiceImpl implements TemplateService {
	
	private static Map<String,String[]> reders = new HashMap<String, String[]>();
	private static Map<String,Boolean> excepciones = new HashMap<String, Boolean>();
	
	/**
	 * Agrego las temaplates que no quiero que se guarden en reader.
	 */
	public TemplateServiceImpl() {
		excepciones.put("tmpLinksMesa", true);
		excepciones.put("tmpMensajesModuloExtra", true);
		excepciones.put("tmpCarrito", true);
		excepciones.put("tmpListasDeUnUsuario", true);
		
		//escepciones de template usadas en reportes.
		excepciones.put("reporteDeProductosPorSocios2", true);
		excepciones.put("reporteDeProductosPorSocios", true);		
		excepciones.put("reporteDeActualizacionMailExtra", true);
		excepciones.put("reporteDeClientesNuevosYRepetitivos", true);
		excepciones.put("reporteDeCarritoDeSociosRegistradosAyerSinCompras", true);
		excepciones.put("reporteDeSociosRegistradosXSemanaPopego", true);
		excepciones.put("tmpTiemposDeCompra", true);
		//templates usadas en mi cuenta.
		excepciones.put("tmpDomiciliosMiCuenta", true);
		excepciones.put("tmpModificarSocio", true);
		excepciones.put("tmpPromocionesHistoricas", true);
		
		
	}
	
	/**
	 * Crea una template en base al nombre que recibe por parametros.	 * 
	 * @param nombre
	 * @return Object, debe ser castedo al tipo de template a usar
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws FileNotFoundException 
	 */
	public synchronized Object getTemplate(String nombre) throws FileNotFoundException, IllegalStateException, IOException {			
		if(reders.containsKey(nombre) && Globals.esModoRelease()) {
			return new Template(reders.get(nombre));
		}else {
				String path = Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH
						+ "/templates/"+nombre+".htm");
				BufferedReader br = new BufferedReader(new FileReader(path));
				String line = null;
				StringBuffer str = new StringBuffer("");
				while((line=br.readLine()) != null) {
					str.append(line).append("LINE_SPLITER");
				}
				br.close();
				//si la tempalte esta excluida, no se agrega al los reader
				if(excepciones.containsKey(nombre)) { 					
					return new Template(str.toString().split("LINE_SPLITER"));
				}else {
					reders.put(nombre, str.toString().split("LINE_SPLITER"));
					return new Template(reders.get(nombre));	
				}				
			}			
	}
	
	public Object getTemplateOld(String nombre) {
		Hashtable<String, String> path = new Hashtable<String, String>();		
		path.put("filename", Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH
					+ "/templates/"+nombre+".htm"));
		
		try{
			return  new Template(path);
		}catch(Exception e) {
			TmkLogger.error("No se pudo crear la template para:"+ nombre + e);
			return null;
		}
	}
	
	/**
	 * Setea en una template los datos de un 
	 * @param camposAAgregar
	 * @param clase
	 * @param tempalte
	 */
	public void setSemplate(CamposABuscarDBO camposAAgregar,Class<?> clase,Object o,Template template) throws Exception{
		Field[] fields = o.getClass().getDeclaredFields();
		if(camposAAgregar!=null){
			for(int i=0;i < fields.length && camposAAgregar.size()> 0;i++){
				Field campo = fields[i];
				campo.setAccessible(true);
				if(camposAAgregar.incluirEnBusqueda(campo.getName())){
					if(campo.getType().toString().endsWith("ByteArrayWarpper")) {
						template.setParam(campo.getName(),  new String(CryptUtil.desEncriptar(((ByteArrayWarpper)campo.get(o)).getArray())));
					}else {
						//en caso de dbo que tengas propiedades byte[][
						if(campo.getType().isArray() && "byte".equals(campo.getType().getComponentType().toString())){
							template.setParam(campo.getName(),new String(CryptUtil.desEncriptar((byte[])campo.get(o))));	
						}else{
							template.setParam(campo.getName(),campo.get(o).toString());
						}
					}
					camposAAgregar.remove(campo.getName());
				}
			}
		}/*else {
			for(int i=0;i < fields.length && camposAAgregar.size()> 0;i++){
				Field campo = fields[i];
				campo.setAccessible(true);
				if(campo.get(o)!=null){
					if(campo.getType().toString().endsWith("ByteArrayWarpper")) {
						template.setParam(campo.getName(),  new String(CryptUtil.desEncriptar(((ByteArrayWarpper)campo.get(o)).getArray())));
					}else {
						//en caso de dbo que tengas propiedades byte[][
						if(campo.getType().isArray() && "byte".equals(campo.getType().getComponentType().toString())){
							template.setParam(campo.getName(),new String(CryptUtil.desEncriptar((byte[])campo.get(o))));	
						}else{
							template.setParam(campo.getName(),campo.get(o).toString());
						}
					}
					camposAAgregar.remove(campo.getName());
				}
			}
		}*/
	}
}
