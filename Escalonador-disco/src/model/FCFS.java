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
 * @author 13205039
 */
public class FCFS implements DiskScheduler{
    private int[] referenceString;
    private int numCilindros;
    private int initCilindro;
    private int array[];

    public FCFS(int[] referenceString, int numCilindros, int initCilindro) {
        this.referenceString = referenceString;
        this.numCilindros = numCilindros;
        this.initCilindro = initCilindro;
    }
    
    @Override
    public int serviceRequests() {        
        array = new int[referenceString.length];
        for (int i = 0; i < referenceString.length; i++) {                       
            array[i] = referenceString[i];
        }        
        return MovimentosDoCilindro.retornaQuantidade(
                initCilindro, 
                referenceString
        );
    }

    @Override
    public void printGraph(String filename) {
        Grafico.criar("FCFS", filename, array, initCilindro);
    }
}
