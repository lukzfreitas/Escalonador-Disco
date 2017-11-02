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
public class CLOOK implements DiskScheduler{
    
    private int[] referenceString;
    private int numCilindros;
    private int initCilindro;

    public CLOOK(int[] referenceString, int numCilindros, int initCilindro) {
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
        Collections.sort(arrayList);        
        return arrayList;
   }

    @Override
    public int serviceRequests() {
        ArrayList<Integer> maioresQueInit = retonaListaDeMaioresQueInitCilindro();
        int ultimoValor = maioresQueInit.get(maioresQueInit.size()-1);
        ArrayList<Integer> menoresQueInit = retonaListaDeMenoresQueInitCilindro();
        int primeiroValor = menoresQueInit.get(0);
        maioresQueInit.addAll(menoresQueInit);        
        referenceString = new int[maioresQueInit.size()];
        for (int i = 0; i < maioresQueInit.size(); i++) {
            referenceString[i] = maioresQueInit.get(i);
        }                
        return MovimentosDoCilindro.retornaQuantidade(
                initCilindro, 
                referenceString
        ) - (ultimoValor - primeiroValor);
        
    }

    @Override
    public void printGraph(String filename) {
        Grafico.criar("CLOOK", filename, referenceString, initCilindro);
    }
}
