package com.tmk.controllers.micuenta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;
//import com.tmk.setup.Contenido;
import com.tmk.src.socio.SocioPK;
import com.tmk.xml.Resultado;

/**
 * DESAROOLLADO PARA EL WORK FLOW 707
 * @author oCLopez
 *
 */
public class GetBinesValidos extends HttpServlet {
	private HashMap<String, Vector<String>> mapaDeBinesValidosPorTtarjeta = null;
	private HashMap<String,String> mapaDeClave = null;
	
	public GetBinesValidos() {
		mapaDeBinesValidosPorTtarjeta = new HashMap<String, Vector<String>>();
		mapaDeClave = new HashMap<String, String>();
		
		//cargo los CODIGOS DE BINES
		mapaDeClave.put("VPAT", "VPAT");
		mapaDeClave.put("AMPAT", "AMPAT");
		
		//cargo los bines para cafa codigo, primero vpat
		Vector<String> vecBin = new Vector<String>();
		vecBin.add("450833");
		vecBin.add("450832");
		vecBin.add("450994");
		vecBin.add("454644");
		vecBin.add("454643");
		vecBin.add("454645");		
		mapaDeBinesValidosPorTtarjeta.put("VPAT", vecBin);
		
		//cargo los bines para cafa codigo, primero vpat
		Vector<String> vecBin2 = new Vector<String>();
		vecBin2.add("376713");
		vecBin2.add("376714");				
		mapaDeBinesValidosPorTtarjeta.put("AMPAT", vecBin2);
	}	
	/*
	@Override
	public void init() throws ServletException {
		synchronized(this) {
		try {
			//el archivo tiene las claves de los medios de cobros que se desean aregar
			String path =  Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH		
					+ "/templates/clavesDeTarjetas.txt");
			BufferedReader br = new BufferedReader(new java.io.FileReader(path));
			String line = null; 
			while((line=br.readLine()) != null) {
				mapaDeClave.put(line.toUpperCase(), line.toUpperCase());
			}
			br.close();

			if(mapaDeBinesValidosPorTtarjeta.size() ==0) {
				
				Iterator<String> itClaves = mapaDeClave.keySet().iterator(); 
				while(itClaves.hasNext()) {
					String clave = itClaves.next();
					if(!mapaDeBinesValidosPorTtarjeta.containsKey(clave)) {
						path =  Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH		
								+ "/templates/binesValidos"+clave+".txt");
						Vector<String> vecBin = new Vector<String>();
						cargarBinesPorTarjeta(path, mapaDeBinesValidosPorTtarjeta, vecBin);
						mapaDeBinesValidosPorTtarjeta.put(clave, vecBin);
					}
				}
			}			
		}catch(Exception e) {
			TmkLogger.info(MainHelper.getMessage(e));
		}
		}
	}
	*/
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");

		
		//MainHelper.controlDeModo(request, response);
		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");			
		OrdenDAO ordenDAO = (OrdenDAO)request.getSession().getAttribute("ordenDAO");
				
		if(ordenDAO == null || socioPK == null) {
			request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
			return;
		}
		
		String tipoTarjeta = Convert.toString(request.getParameter("TIPO_TARJETA_BIN"));
		String bin = Convert.toString(request.getParameter("BIN"));
		Resultado res = null;
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Resultado",Resultado.class);
		try {
			Vector<String> vecDeBinesValidos = mapaDeBinesValidosPorTtarjeta.get(tipoTarjeta);			
			boolean esBinValido = false;
			for(int i=0;i < vecDeBinesValidos.size() && !esBinValido;i++) {
				esBinValido = vecDeBinesValidos.get(i).equals(bin.substring(0,6));			
			}
			res = new Resultado(esBinValido,null,null);
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
		}catch (Exception e) {
			TmkLogger.debug(MainHelper.getMessage(e));
			res = new Resultado(false,null,null);
			res.setFallaSistema(true);
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
		}/*finally {
			bin = null;
			tipoTarjeta = null;
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
		}*/
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		response.setHeader("cache-Control","no-cache");
		request.setCharacterEncoding("UTF-8");

		
		MainHelper.controlDeModo(request, response);
		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");			
		OrdenDAO ordenDAO = (OrdenDAO)request.getSession().getAttribute("ordenDAO");
				
		if(ordenDAO == null || socioPK == null) {
			request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
			return;
		}
		
		String tipoTarjeta = Convert.toString(request.getParameter("TIPO_TARJETA_BIN"));
		String bin = Convert.toString(request.getParameter("BIN"));
		Resultado res = null;
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("Resultado",Resultado.class);
		try {
			Vector<String> vecDeBinesValidos = mapaDeBinesValidosPorTtarjeta.get(tipoTarjeta);			
			boolean esBinValido = false;
			for(int i=0;i < vecDeBinesValidos.size() && !esBinValido;i++) {
				esBinValido = vecDeBinesValidos.get(i).equals(bin.substring(0,6));			
			}
			res = new Resultado(esBinValido,null,null);
		}catch (Exception e) {
			TmkLogger.debug(MainHelper.getMessage(e));
			res = new Resultado(false,null,null);
			res.setFallaSistema(true);
		}finally {
			bin = null;
			tipoTarjeta = null;
			response.getWriter().print(xstream.toXML(res).replaceAll("\n", ""));
		}
	}
	
	private void cargarBinesPorTarjeta(String path,HashMap<String,Vector<String>> mapa, Vector<String> vector) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.FileReader(path));
		String line = null; 
		while((line=br.readLine()) != null) {
			vector.add(line.toUpperCase());			
		}
		br.close();		
	}
}
