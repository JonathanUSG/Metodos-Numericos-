package Tema3_SistemasEcuaciones.Metodos_Directos;
import java.util.*;
public class GaussJordan{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Solicitar el tamaño de la matriz
        System.out.print("Introduce el número de ecuaciones (n): ");
        int n = scanner.nextInt();

        //Declaración de la matriz
        double [][] matriz = new double[n][n];
        double [] soluciones = new double[n];
        double [] x = new double[n];

        //Lee la matriz aumentada
        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for(int i = 0; i < n; i++){
            System.out.println("Ecuación " + (i + 1) + ": ");
            for(int j = 0; j < n; j++){
                System.out.printf("Coeficiente [%d][%d]: " , i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.printf("Término independiente [%d]: ", i + 1);
            soluciones[i] = scanner.nextDouble();
        }
         // Mostrar matriz aumentada inicial
        System.out.println("\nMatriz aumentada ingresada:");
        mostrarMatriz(matriz, soluciones, n);

    } 

    public static void mostrarMatriz(double [][]matriz, double [] soluciones, int n){
        for(int i = 0; i < n; i++){
            System.out.print("| ");
            for(int j = 0; j < n; j++){
                System.out.printf("%8.3f ", matriz[i][j]);
            }
            System.out.printf("| %8.3f |\n", soluciones[i]);
        }
        System.out.println();
    }  
}