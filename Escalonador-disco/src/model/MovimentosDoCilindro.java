/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas
 */
public class MovimentosDoCilindro {
    public static int retornaQuantidade(
            int initCilindro, 
            int[] referenceString
    ) {
        int mov = Math.abs(initCilindro - referenceString[0]);
        for(int i = 0; i < referenceString.length - 1; i++) {            
            mov += Math.abs(referenceString[i] - referenceString[i+1]);            
        }
        return mov;
    }
}
