/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo2.pkg0;

import bingo2.pkg0.avl.TreeAVL;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        
        int n= (int) Math.floor(Math.random()*(9999999-1000000+1)+1000000);
  
        
        HashMap<String,TreeAVL> Amarillo= Creartabla("Amarillo");
        HashMap<String,TreeAVL> Azul= Creartabla("Azul");
        HashMap<String,TreeAVL> Rojo= Creartabla("Rojo");
        
        System.out.println("Amarillo");
        System.out.println(Amarillo.size());
        System.out.println("Azul");
        System.out.println(Azul.size());
        System.out.println("Rojo");
        System.out.println(Rojo.size());

    }
    
    public static HashMap<String, TreeAVL> Creartabla(String color){
       
       Random numero= new Random();
       
       HashMap<String, TreeAVL> tabla = new HashMap<String, TreeAVL>();
   Comparator<Integer> g = (n1, n2) -> n1.compareTo(n2);

        TreeAVL miArbol = new TreeAVL(g);
       int x=0;
        for(int i=0; i<5000; i++){
            // Amarillo1234567
            String codigo= color;
            
            int n= (int) Math.floor(Math.random()*(9999999-1000000+1)+1000000);
            String id= String.valueOf(n);
            codigo=codigo+id;
            
            
            //AQUI VA EL ARBOL
            
            
            
            
            if(!tabla.containsKey(codigo)){
                tabla.put(codigo, miArbol);
            }        
    }
        return tabla;
    }
}
