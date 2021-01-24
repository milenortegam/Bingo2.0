package bingo2.pkg0;
import bingo2.pkg0.avl.TreeAVL;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Milen Ortega Hp
 */
public class Bingo20 {
    
    public static void main(String[] args) {
        System.out.println("*******BINGO 2.0********"); 
        System.out.println("Ingrese la ruta del archivo de los cartones");
        //String ruta= sc.nextLine(); 
        String ruta= "src\\bingo2\\pkg0\\generado.txt";
        HashMap<String,TreeAVL> Amarillo= Creartabla("Amarillo",ruta);
        HashMap<String,TreeAVL> Azul= Creartabla("Azul", ruta);
        HashMap<String,TreeAVL> Rojo= Creartabla("Rojo", ruta);
        
        System.out.println("\n Empecemos con la ronda de los cartones Amarillos");
        ingresoNumeros(14, Amarillo);
          
        System.out.println("\n Ahora la ronda de los cartones Azules");
        ingresoNumeros(14, Azul);
             
        System.out.println("\n Ahora la ronda de los cartones Rojos");
        ingresoNumeros (11, Rojo);
        
        System.out.println("\n El juego ha acabado, gracias por participar");
    }
    
    public static HashMap<String, TreeAVL> Creartabla(String color, String ruta){    
        HashMap<String, TreeAVL> tabla = new HashMap<>();
        Comparator<Integer> g = (n1, n2) -> n1.compareTo(n2);    
        
         switch(color){
            case "Amarillo":
                formarArbol(ruta, g, tabla, color, 15);                
            case "Azul":
                formarArbol(ruta, g, tabla, color, 15 );
            case "Rojo":
                formarArbol(ruta, g, tabla, color,12 );                
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
    
    public static void ingresoNumeros(int maximo, HashMap<String,TreeAVL> color){
        Scanner sc= new Scanner(System.in); 
        System.out.println("Ingrese números entre 0-20");
        boolean cierto=true;
        int i=1;
        while(cierto){          
            if(i<=maximo){
                System.out.println("Número ["+i+"]:");
                Integer numero= sc.nextInt(); 
                if(numero<=20&&numero>0){
                    String tmp=buscarNumeros(color, numero);
                    if(tmp!=null){
                        System.out.println("El ganador de esta ronda es: "+tmp);
                        cierto=false;
                    }
                    i++; 
                }
                else{
                    System.out.println("El número que ingreso se encuentra fuera del rango. Ingrese otro por favor");                    
                }
            }           
            else if(i==maximo+1){
                System.out.println("\n Como no se ha encontrado ganador, vamos a la ronda extra");
                System.out.println("Ingresa un número: ");
                Integer numero= sc.nextInt(); 
                if(numero<=20&& numero>0){
                    String tmp=buscarNumeros(color, numero);
                    if(tmp!=null){
                        System.out.println("El ganador de esta ronda es: "+tmp);
                        break;
                    }                    
                    System.out.println("Lo sentimos, no existe tabla ganadora en esta ronda");
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
    
   public static void formarArbol(String ruta, Comparator<Integer> g, HashMap<String, TreeAVL> tabla, String color, int Max ){
       try {
            File cartones = new File(ruta);
            Scanner lector = new Scanner(cartones);
            while (lector.hasNextLine()) {
                TreeAVL miArbol = new TreeAVL(g);
                String linea = lector.nextLine();
                String[] datos=linea.split(",");
                if(datos[0].contains(color)){                      
                    for(int i=1; i<Max;i++){
                        miArbol.add(Integer. parseInt(datos[i]));                          
                    }
                    tabla.put(datos[0], miArbol);                      
                }                 
            }
            lector.close();
        } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado");  
        }       
   }     
}