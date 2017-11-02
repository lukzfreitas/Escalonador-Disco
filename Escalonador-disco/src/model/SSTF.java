/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class SSTF implements DiskScheduler{

    private int[] referenceString;
    private int numCilindros;
    private int initCilindro;

    public SSTF(int[] referenceString, int numCilindros, int initCilindro) {
        this.referenceString = referenceString;
        this.numCilindros = numCilindros;
        this.initCilindro = initCilindro;
    }
    
    private void ordenaArray() {                             
        int value = initCilindro;        
        int j = 0, k = j, sub = j, compare = j;        
        while (j < referenceString.length) {            
            sub = Math.abs(value - referenceString[j]);                        
            for(int i = k + 1; i < referenceString.length; i++) {                
                compare = Math.abs(value - referenceString[i]);
                if (sub > compare) {
                    sub = compare;
                    int aux = referenceString[j];
                    referenceString[j] = referenceString[i];
                    referenceString[i] = aux;                    
                }
            }
            value = referenceString[j];            
            j++;            
            k = j;                        
        }             
    }
    
    @Override
    public int serviceRequests() {      
        ordenaArray();
        return MovimentosDoCilindro.retornaQuantidade(
                initCilindro, 
                referenceString
        );       
    }

    @Override
    public void printGraph(String filename) {
        Grafico.criar("SSTF", filename, referenceString, initCilindro);
    }
    
}
