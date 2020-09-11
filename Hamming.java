package implementacion_marioperez;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        //Matriz generadora
        int mGeneradora[][] = {{1, 1, 1, 0, 0, 0, 0}, {1, 0, 0, 1, 1, 0, 0}, {0, 1, 0, 1, 0, 1, 0}, {1, 1, 0, 1, 0, 0, 1}};
        
        //Matriz control de paridad
        int mParidad[][] = {{0, 0, 0, 1, 1, 1, 1}, {0, 1, 1, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 1}};
        int mParidadTraspuesta[][] = {{0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
        
        int dimension = 4;

        System.out.println("=====================================");
        System.out.println("Descodificacion - Codigo Hamming(3,2)");
        System.out.println("=====================================");
        
        //Usuario introduce la palabra binaria
        System.out.println("Introducir palabra binaria");
        int palabra[] = new int[dimension];
        
        for (int i = 0; i < dimension; i++){
            
            System.out.println("Bit " + i + ": ");
            int bit = scan.nextInt();
            
            while(bit != 0 && bit != 1){
                System.out.println("Bit " + i + " - Introduzca un 0 o un 1:");
                bit = scan.nextInt();
            }
            
            palabra[i] = bit;
        }
        
        System.out.print("Palabra binaria = ");
        for (int i = 0; i < dimension; i++){
            System.out.print(palabra[i]);
        }
        System.out.println();
        
        //Obtener vector codigo, multiplicando por la generadora
        int vectorCodigo[] = producto(palabra, mGeneradora);
        
        
        //a1, a2, a3, a4, a5, a6, a7
        System.out.print("Vector codigo generado = ");
        
        int longitud = vectorCodigo.length;
        for(int i = 0; i < longitud; i++){
            System.out.print(vectorCodigo[i]);
        }
        System.out.println();
        
        //Cambiar un bit
        System.out.println("¿Posicion del bit a cambiar? (De 1 a 7)");
        int pos = scan.nextInt();
        while(pos < 1 || pos > 7){
                System.out.println("¿Posicion del bit a cambiar? (De 1 a 7)");
                pos = scan.nextInt();
        }
        
        pos -= 1;
        
        if(vectorCodigo[pos] == 1)
            vectorCodigo[pos] = 0;
        
        else
            vectorCodigo[pos] = 1;
        
        System.out.print("Vector codigo alterado = ");
        for(int i = 0; i < longitud; i++){
            System.out.print(vectorCodigo[i]);
        }
        System.out.println();
        
        /*
            ALGORITMO DE CORRECCION/DETECCION DE ERRORES
        */
        //Calcular sindrome
        int sindrome[] = producto(vectorCodigo, mParidadTraspuesta);
        
        System.out.print("Sindrome = ");
        for(int i = 0; i < 3; i++){
            System.out.print(sindrome[i]);
        }
        System.out.println();
        
       //Conversion sindrome a binario
       int sinBinario = 0;
       
       if(sindrome[0] == 1)
           sinBinario += 4;
                   
       if(sindrome[1] == 1)
           sinBinario += 2;
       
       if(sindrome[2] == 1)
           sinBinario += 1;
       
       System.out.println("Posicion del error = " + sinBinario);
       
       sinBinario -= 1;
       
       /*
            ALGORITMO DE RECUPERACION
        */
       if (vectorCodigo[sinBinario] == 0)
           vectorCodigo[sinBinario] = 1;
       
        else
           vectorCodigo[sinBinario] = 0;
       
        System.out.print("Vector codigo corregido = ");
        for(int i = 0; i < longitud; i++){
            System.out.print(vectorCodigo[i]);
        }
        System.out.println();
        
    }
    
    //Funcion para multiplicar un vector por una matriz
    public static int[] producto(int vector[], int matriz[][]){
        
        //Tamanho vector
        int sizeVect = vector.length;
        
        //Columnas matriz
        int columnas = matriz[0].length;
        
        int resultado[] = new int[columnas];
      
        for(int i = 0; i < columnas; i++){
            
            int prod = 0;
            
            for(int j = 0; j < sizeVect; j++){
                
                prod += vector[j] * matriz[j][i];
            }
            
            //0, 2, 4, 6 -> 0
            if(prod % 2 == 0){
                prod = 0;
            
            //1, 3, 5, 7 -> 1
            }else{
                prod = 1;
            }
            
            resultado[i] = prod;
        }
        
        return resultado;
    }
    
}
