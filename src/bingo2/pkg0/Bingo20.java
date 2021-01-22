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
import java.util.Scanner;

/**
 *
 * @author Milen Ortega Hp
 */
public class Bingo20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int n= (int) Math.floor(Math.random()*(9999999-1000000+1)+1000000);
  
        
        
        
        System.out.println("*******BINGO 2.0********");
        Scanner sc= new Scanner(System.in);  
        System.out.println("Ingrese la ruta del archivo de los cartones");
        String ruta= sc.nextLine(); 
        
        HashMap<String,TreeAVL> Amarillo= Creartabla("Amarillo");
        HashMap<String,TreeAVL> Azul= Creartabla("Azul");
        HashMap<String,TreeAVL> Rojo= Creartabla("Rojo");
        
        System.out.println("Empecemos con la ronda de los cartones Amarillos");
        System.out.println("Ingrese números entre 0-20");
        boolean cierto=true;
        while(cierto){
            
            int i=1;
            if(i<15){
                System.out.println("Número ["+i+"]:");
                Integer numero= sc.nextInt(); 
                if(numero<=20){
                    String tmp=buscarNumeros(Amarillo, numero);
                    if(tmp!=null){
                        System.out.println("El ganador de esta ronda es: "+tmp);
                        cierto=false;
                    }

                    i++;
                }
                else{
                    System.out.println("El número que ingreso es mayor a 20 ingrese otro por favor");
                     i--;
                }
            }
            
            else if(i==15){
                System.out.println("Como no se ha encontrado ganador, vamos a la ronda extra");
                System.out.println("Ingresa un número: ");
                Integer numero= sc.nextInt(); 
                if(numero<=20){
                    String tmp=buscarNumeros(Amarillo, numero);
                    if(tmp!=null){
                        System.out.println("El ganador de esta ronda es: "+tmp);
                        cierto=false;
                    }
                    
                    System.out.println("Lo sentimos, no existe tabla ganadora en la ronda de los Amarillos");
                    cierto=false;
                }
                else{
                    System.out.println("El número que ingreso es mayor a 20 ingrese otro por favor");
                     i--;
                }
                
            }
                
            }

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
    
    public static String buscarNumeros(HashMap<String, TreeAVL> map, Integer numBuscar){
        
        
        
        for (String key : map.keySet()) {
            TreeAVL tmpArbol=map.get(key);
            tmpArbol.remove(numBuscar);
            if(tmpArbol.getSize()==0){
                return key;
            }
        
        }
        return null;
        
    
        
    }
}
