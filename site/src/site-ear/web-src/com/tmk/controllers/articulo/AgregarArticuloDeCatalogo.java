package com.tmk.controllers.articulo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.site.Claves;
import com.tmk.kernel.site.Producto;
import com.tmk.kernel.site.RecorridoFamilia;
import com.tmk.kernel.site.RecorridoFamilias;
import com.tmk.kernel.site.RecorridoGrupo;
import com.tmk.kernel.site.RecorridoGrupos;
import com.tmk.kernel.site.RecorridoSeccion;
import com.tmk.kernel.site.RecorridoSecciones;
import com.tmk.setup.Contenido;

public class AgregarArticuloDeCatalogo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION), (Integer)null);
		Integer idGrupo = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_GRUPO), (Integer)null);
		Integer idFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_FAMILIA), (Integer)null);
		//Integer idSubFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SUB_FAMILIA), (Integer)null);
		Integer idArticulo = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_ARTICULO), (Integer)null);
		Timestamp vencimiento = Convert.toTimestampFromDDMMYYYY(request.getParameter(MainHelper.FIELD_VENCIMIENTO));
		String msgSuccess = "<success><msg>Se ha agregado con exito el articulo: " + idArticulo + " al catálogo: " + idSeccion + " " + idGrupo + " " + idFamilia + "</msg></success>";
		String msg = "";
		response.setContentType("text/xml"); 
		PrintWriter out = response.getWriter(); 
		out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");

		try {
			RecorridoSecciones recSec = Contenido.getSite().getRecorridoPorTemas().getRecorridoSecciones();
			RecorridoSeccion recorridoSeccion = null;
			RecorridoGrupos recGru = null;
			RecorridoGrupo recorridoGrupo = null;
			RecorridoFamilias recFam = null;
			RecorridoFamilia recorridoFamilia = null;
			Claves claves = null;
			Producto producto = new Producto();
			producto.setId(idArticulo.intValue());
			producto.setVencimiento(vencimiento);
			
			for (int i=0; i<recSec.getRecorridoSeccion().length; i++) {
				if (recSec.getRecorridoSeccion()[i].getId() == idSeccion.intValue()) {
					recorridoSeccion = recSec.getRecorridoSeccion()[i];
				}
			}	
			if (recorridoSeccion == null) {
				recorridoSeccion = new RecorridoSeccion();
				recorridoSeccion.setId(idSeccion.intValue());
				recSec.addRecorridoSeccion(recorridoSeccion);
				recGru = new RecorridoGrupos();
				recorridoGrupo = new RecorridoGrupo();
				recorridoGrupo.setId(idGrupo.intValue());
				recGru.addRecorridoGrupo(recorridoGrupo);
				recorridoSeccion.setRecorridoGrupos(recGru);
				if (idFamilia == null) {
					claves = new Claves();  
					claves.addProducto(producto);
					recorridoGrupo.setClaves(claves);
					msg = msgSuccess;
				} else {
					recFam = new RecorridoFamilias();
					recorridoFamilia = new RecorridoFamilia();
					recorridoFamilia.setId(idFamilia.intValue());
					recFam.addRecorridoFamilia(recorridoFamilia);
					recorridoGrupo.setRecorridoFamilias(recFam);
					claves = new Claves();  
					claves.addProducto(producto);
					recorridoFamilia.setClaves(claves);
					msg = msgSuccess;
				}
			} else {
				if (recorridoSeccion.getRecorridoGrupos() == null) {
					recorridoSeccion.setRecorridoGrupos(new RecorridoGrupos());
				}
				recGru = recorridoSeccion.getRecorridoGrupos();
				for (int j=0; j<recGru.getRecorridoGrupo().length; j++) {
					if (recGru.getRecorridoGrupo()[j].getId() == idGrupo.intValue()) {
						recorridoGrupo = recGru.getRecorridoGrupo()[j];
					}
				}
				if (recorridoGrupo == null) {
					recorridoGrupo = new RecorridoGrupo();
					recorridoGrupo.setId(idGrupo.intValue());
					recGru.addRecorridoGrupo(recorridoGrupo);
					recorridoSeccion.setRecorridoGrupos(recGru);
					if (idFamilia == null) {
						claves = new Claves();  
						claves.addProducto(producto);
						recorridoGrupo.setClaves(claves);
						msg = msgSuccess;
					} else {
						recFam = new RecorridoFamilias();
						recorridoFamilia = new RecorridoFamilia();
						recorridoFamilia.setId(idFamilia.intValue());
						recFam.addRecorridoFamilia(recorridoFamilia);
						recorridoGrupo.setRecorridoFamilias(recFam);
						claves = new Claves();  
						claves.addProducto(producto);
						recorridoFamilia.setClaves(claves);
						msg = msgSuccess;
					}
				} else {
					if (idFamilia != null) {
						if (recorridoGrupo.getRecorridoFamilias() == null){
							recorridoGrupo.setRecorridoFamilias(new RecorridoFamilias());
						}
						recFam = recorridoGrupo.getRecorridoFamilias();
						if (recFam != null) {
							for (int k=0; k<recFam.getRecorridoFamilia().length; k++) {
								if (recFam.getRecorridoFamilia()[k].getId() == idFamilia.intValue()) {
									recorridoFamilia = recFam.getRecorridoFamilia()[k];
								}
							}
							if (recorridoFamilia == null) {
								recorridoFamilia = new RecorridoFamilia();
								recorridoFamilia.setId(idFamilia.intValue());
								recFam.addRecorridoFamilia(recorridoFamilia);
								recorridoGrupo.setRecorridoFamilias(recFam);
								claves = new Claves();  
								claves.addProducto(producto);
								recorridoFamilia.setClaves(claves);
								msg = msgSuccess;
							} else {
								if (recorridoFamilia.getClaves()!= null) {
									claves = recorridoFamilia.getClaves();
									for (int l=0; l<claves.getProducto().length; l++) {
										if (claves.getProducto()[l].getId() == producto.getId()) {
											producto = null;
										}
									}
								} else {
									claves = new Claves();
								}
								if (producto == null) {
									msg = "<error><msg>El articulo id:" + idArticulo + " ya existe en el catálogo: " + idSeccion + " " + idGrupo + " " + idFamilia + "</msg></error>";
								} else {
									claves.addProducto(producto);
									msg = msgSuccess;
								}	
							}
						}
					} else {
						if (recorridoGrupo.getClaves() != null) {
							claves = recorridoGrupo.getClaves();
							for (int l=0; l<claves.getProducto().length; l++) {
								if (claves.getProducto()[l].getId() == producto.getId()) {
									producto = null;
								}
							}
						} else {
							claves = new Claves();
						}
						if (producto == null) {
							msg = "<error><msg>El articulo id:" + idArticulo + " ya existe en el catálogo: " + idSeccion + " " + idGrupo + " " + idFamilia + "</msg></error>";
						} else {
							claves.addProducto(producto);
							msg = msgSuccess;
						}	
					}
				}	
			}
			out.print(msg);	
		} catch (Exception e) {
			out.print("<error><msg>Se produjo un error contacte al administrador</msg></error>");
			TmkLogger.debug(this.getClass().toString() + "] " + e.toString() + MainHelper.getMessage(e));
		}
		out.close();
	}
}
