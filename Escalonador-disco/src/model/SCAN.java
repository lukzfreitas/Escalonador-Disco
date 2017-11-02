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
public class SCAN implements DiskScheduler {

    private int[] referenceString;
    private int numCilindros;
    private int initCilindro;    

    public SCAN(int[] referenceString, int numCilindros, int initCilindro) {
        this.referenceString = referenceString;
        this.numCilindros = numCilindros;
        this.initCilindro = initCilindro;
    }
    
    private ArrayList<Integer> retonaListaDeMenoresQueInitCilindro() {        
        ArrayList<Integer> arrayList = new ArrayList<>();                
        for(int i = 0; i < referenceString.length; i++) {
            if (referenceString[i] < initCilindro) {
               arrayList.add(referenceString[i]);
            }
        }
        arrayList.add(0);
        arrayList.sort(Collections.reverseOrder());        
        return arrayList;
    }   
    
    
   private ArrayList<Integer> retonaListaDeMaioresQueInitCilindro() {
        ArrayList<Integer> arrayList = new ArrayList<>();        
        for(int i = 0; i < referenceString.length; i++) {
            if (referenceString[i] > initCilindro) {
               arrayList.add(referenceString[i]);
            }
        }        
        Collections.sort(arrayList);
        return arrayList;
   }
    
    @Override
    public int serviceRequests() {
        ArrayList<Integer> menoresQueInit = retonaListaDeMenoresQueInitCilindro();                        
        ArrayList<Integer> maioresQueInit = retonaListaDeMaioresQueInitCilindro();        
        menoresQueInit.addAll(maioresQueInit);        
        referenceString = new int[menoresQueInit.size()];
        for (int i = 0; i < menoresQueInit.size(); i++) {            
            referenceString[i] = menoresQueInit.get(i);
        }        
        return MovimentosDoCilindro.retornaQuantidade(initCilindro, referenceString);
    }

    @Override
    public void printGraph(String filename) {
        Grafico.criar("SCAN", filename, referenceString, initCilindro);
    }
    
}
