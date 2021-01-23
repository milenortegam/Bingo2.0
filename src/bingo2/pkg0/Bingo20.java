/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo2.pkg0;

import bingo2.pkg0.avl.TreeAVL;
import java.io.File;
import java.io.FileNotFoundException;
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
        
        
        //int n= (int) Math.floor(Math.random()*(9999999-1000000+1)+1000000);
  
        System.out.println("*******BINGO 2.0********");
        Scanner sc= new Scanner(System.in);  
        System.out.println("Ingrese la ruta del archivo de los cartones");
        //String ruta= sc.nextLine(); 
        String ruta= "C:\\Users\\hp\\Desktop\\6to Semestre\\Análisis de Algoritmos\\Proyecto Final\\proyectoAnalisis\\Bingo2.0\\src\\bingo2\\pkg0\\generado.txt";
        HashMap<String,TreeAVL> Amarillo= Creartabla("Amarillo",ruta);
        HashMap<String,TreeAVL> Azul= Creartabla("Azul", ruta);
        HashMap<String,TreeAVL> Rojo= Creartabla("Rojo", ruta);
        
        System.out.println("Empecemos con la ronda de los cartones Amarillos");
        System.out.println("Ingrese números entre 0-20");
        boolean cierto=true;
        int i=1;
        while(cierto){
            
            
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
                        break;
                    }
                    
                    System.out.println("Lo sentimos, no existe tabla ganadora en la ronda de los Amarillos");
                    cierto=false;
                }
                else{
                    System.out.println("El número que ingreso es mayor a 20 ingrese otro por favor");
                }
                
            }
            else{
                cierto=false;
            }  
            }

    }
    
    public static HashMap<String, TreeAVL> Creartabla(String color, String ruta){
       
       
       
        HashMap<String, TreeAVL> tabla = new HashMap<>();
        Comparator<Integer> g = (n1, n2) -> n1.compareTo(n2);

        
        
         switch(color){
             case "Amarillo":
                 try {
                File cartones = new File(ruta);
                Scanner lector = new Scanner(cartones);
                while (lector.hasNextLine()) {
                  TreeAVL miArbol = new TreeAVL(g);
                  String linea = lector.nextLine();
                  String[] datos=linea.split(",");
                  if(datos[0].contains("Amarillo")){
                      
                      for(int i=1; i<15;i++){
                          miArbol.add(Integer. parseInt(datos[i]));
                          
                      }
                      tabla.put(datos[0], miArbol);
                      
                  }
                  
        }
                lector.close();
        } catch (FileNotFoundException e) {
                System.out.println("Ocurrió un error");
                e.printStackTrace();
        }
        case "Azul":
                 try {
                File cartones = new File(ruta);
                Scanner lector = new Scanner(cartones);
                while (lector.hasNextLine()) {
                  TreeAVL miArbol = new TreeAVL(g);
                  String linea = lector.nextLine();
                  String[] datos=linea.split(",");
                  if(datos[0].contains("Azul")){
                      
                      for(int i=1; i<15;i++){
                          miArbol.add(Integer. parseInt(datos[i]));
                          
                      }
                      tabla.put(datos[0], miArbol);
                      
                  }
                  
        }
                lector.close();
        } catch (FileNotFoundException e) {
                System.out.println("Ocurrió un error");
                e.printStackTrace();
        }
        case "Rojo":
                 try {
                File cartones = new File(ruta);
                Scanner lector = new Scanner(cartones);
                while (lector.hasNextLine()) {
                  TreeAVL miArbol = new TreeAVL(g);
                  String linea = lector.nextLine();
                  String[] datos=linea.split(",");
                  if(datos[0].contains("Rojo")){
                      
                      for(int i=1; i<12;i++){
                          miArbol.add(Integer. parseInt(datos[i]));
                          
                      }
                      tabla.put(datos[0], miArbol);
                      
                  }
                  
        }
                lector.close();
        } catch (FileNotFoundException e) {
                System.out.println("Ocurrió un error");
                e.printStackTrace();
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
