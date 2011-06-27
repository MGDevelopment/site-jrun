package com.tmk.report;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import java.util.Vector;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import com.tmk.controllers.MainHelper;

public final class Chart {

	public static DefaultPieDataset getDefaultPieDataset(Vector datos) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		for (int i=0; i<datos.size(); i++) {
			Hashtable h = (Hashtable)datos.get(i);
			pieDataset.setValue(h.get("ROW1").toString(), new Double(h.get("ROW2").toString()));
		}
		return pieDataset;
	}

	public static JFreeChart getPieChart(String titulo, boolean leyenda, boolean tooltips,
									boolean urls, boolean sinLabels,
									DefaultPieDataset defaultPieDataSet) throws Exception {
		JFreeChart objGrafico = ChartFactory.createPieChart //Cambielo por un = ChartFactory.createPieChart3D
		( titulo, // Título de la gráfica
		defaultPieDataSet, // Vector de datos
		leyenda, // Mostrar la leyenda en la gráfica
		tooltips, // Mostrar los tooltips
		urls // Configurar el grafico para generar URLs
		);
		objGrafico.setBorderVisible(false);
		objGrafico.setBackgroundPaint(java.awt.Color.white);
		PiePlot plot = (PiePlot) objGrafico.getPlot();
		if (sinLabels) {
			plot.setLabelGenerator(null);
		}
		plot.setOutlineVisible(false);
		plot.setInteriorGap(0.0);
		return objGrafico;

	}

	public static void saveChart(String fileName, JFreeChart objGrafico, int ancho, int alto) throws Exception {
        //ContenidosEstaticos.inicioMapeo();

        //File file = new File(Globals.GENERACION_DIRECTORIO + MainHelper.RES_REPORTING_IMG_PATH + "\\" + fileName);
		BufferedImage img = objGrafico.createBufferedImage(ancho, alto);
		File file = new File(fileName);
		ImageIO.write(img, "jpg", file);
		MainHelper.saveExistingFileNet(MainHelper.RES_REPORTING_IMG_PATH + "/" + fileName, fileName, "recursos");

	}


}
