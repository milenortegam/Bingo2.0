/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo2.pkg0;

import bingo2.pkg0.avl.TreeAVL;
import java.util.Comparator;

/**
 *
 * @author Milen Ortega Hp
 */
public class Bingo20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        //oedir al usuario que suba ruta de archivo donde estan cartillas
        //cargar archivo en un listas de diccionario {id, avlNumerosCartones}
        //pedir al usuario que ingrese numeros de bola para rondaAmarillos, rondaAzul, rondaRoja 
        //imprimir ganadores por ronda
        
        Comparator<Integer> g = (n1, n2) -> n1.compareTo(n2);

        TreeAVL miArbol = new TreeAVL(g);
        boolean x=miArbol.add(15);
        System.out.println(x);
    }
    
}
