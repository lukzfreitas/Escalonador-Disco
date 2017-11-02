/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.BasicStroke;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Lucas
 */
public class Grafico {
    public static void criar(
            String titulo, 
            String filename,
            int[] referenceString, 
            int initCilindro            
    ) {
        int i;
        int y_axis = referenceString.length * 10;        
        XYSeries series = new XYSeries("FCFS");                
        series.add(y_axis, initCilindro);        
        for (i=0; i<referenceString.length; i++){
            series.add(y_axis-((i+1)*10), referenceString[i]);
        }                
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        
        /* Gera o gráfico */
        JFreeChart chart = ChartFactory.createXYLineChart(            
            titulo,            
            "",            
            "Cilindro",
            dataset,            
            PlotOrientation.HORIZONTAL,            
            false,            
            false,            
            false
        );        
        
        XYPlot plot = chart.getXYPlot();
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        plot.setRenderer(renderer);
        
        try {
            ChartUtilities.saveChartAsJPEG(new File(filename), chart, 500, 300);
        } catch (IOException ex) {
            Logger.getLogger(FCFS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
}
