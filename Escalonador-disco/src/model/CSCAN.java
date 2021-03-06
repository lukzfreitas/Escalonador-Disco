/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lucas
 */
public class CSCAN implements DiskScheduler{

    private int[] referenceString;
    private int numCilindros;
    private int initCilindro;

    public CSCAN(int[] referenceString, int numCilindros, int initCilindro) {
        this.referenceString = referenceString;
        this.numCilindros = numCilindros;
        this.initCilindro = initCilindro;
    }    
    
    private ArrayList<Integer> retonaListaDeMenoresQueInitCilindro() {        
        ArrayList<Integer> arrayList = new ArrayList<>();                
        arrayList.add(0);
        for(int i = 0; i < referenceString.length; i++) {
            if (referenceString[i] < initCilindro) {
               arrayList.add(referenceString[i]);
            }
        }        
        Collections.sort(arrayList);        
        return arrayList;
    }
    
   private ArrayList<Integer> retonaListaDeMaioresQueInitCilindro() {
        ArrayList<Integer> arrayList = new ArrayList<>();                
        for(int i = 0; i < referenceString.length; i++) {
            if (referenceString[i] > initCilindro) {
               arrayList.add(referenceString[i]);
            }
        }        
        arrayList.add(numCilindros - 1);
        Collections.sort(arrayList);
        return arrayList;
   }
    
    @Override
    public int serviceRequests() {
        ArrayList<Integer> maioresQueInit = retonaListaDeMaioresQueInitCilindro();        
        ArrayList<Integer> menoresQueInit = retonaListaDeMenoresQueInitCilindro();
        maioresQueInit.addAll(menoresQueInit);
        referenceString = new int[maioresQueInit.size()];
        for (int i = 0; i < maioresQueInit.size(); i++) {
            referenceString[i] = maioresQueInit.get(i);
        }        
        return MovimentosDoCilindro.retornaQuantidade(
                initCilindro,
                referenceString
        ) - (numCilindros - 1);        
    }

    @Override
    public void printGraph(String filename) {
        Grafico.criar("CSCAN", filename, referenceString, initCilindro);
    }
    
}
