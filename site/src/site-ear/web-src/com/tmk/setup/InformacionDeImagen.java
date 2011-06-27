/**
 * $Log: InformacionDeImagen.java,v $
 * Revision 1.2  2004/07/05 15:44:18  oGPistoia
 * - Release 1.80 (y cambios menores)
 *
 * Revision 1.1  2004/05/14 19:19:14  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 */
package com.tmk.setup;

import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.site.types.PosicionesType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Intenta ser un simple y rapido wrapper
 */
public class InformacionDeImagen {

	public BufferedImage icono;
	public PosicionesType posicion;
	public float porcentaje;

	public InformacionDeImagen(File archivoIcono, PosicionesType posicion, int porcentaje) {
		super();
		this.icono = null;
		this.posicion = posicion;
		this.porcentaje = Math.max(0f, Math.min(porcentaje, 100f)) / 100f;  // El valor tiene que ser entre 0.0 y 1.0
		try {
			// Intenta generar el archivo
			icono = ImageIO.read(archivoIcono);
			// Notifica que cargo la imagen
			TmkLogger.debug("Icono " + archivoIcono.getName() + " cargado.");

		} catch (Exception e) {
			// deja el logo sin asignar
			TmkLogger.info("No se pudo cargar la imagen " + archivoIcono.getName());
		}
	}

}
