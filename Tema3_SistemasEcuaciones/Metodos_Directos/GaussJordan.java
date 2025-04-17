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

        for(int i = 0; i < n; i++){
            double pivote = matriz[i][i];
            System.out.printf("Normalizando fila %d dividiendo por %.3f\n", i + 1, pivote);
            for(int j = 0; j < n; j++){
                matriz[i][j] /= pivote;  
            }
            soluciones[i] /= pivote;
            mostrarMatriz(matriz, soluciones, n);

            for(int k = 0; k < n; k++){
                if(k != i){
                    double factor = matriz[k][i];
                    System.out.printf("Eliminando elemento [%d][%d] con factor %.3f\n", k + 1, i + 1, factor);
                    for(int j = 0; j < n; j++){
                        matriz[k][j] -= factor * matriz[i][j]; 
                    }
                    soluciones[k] -= factor * soluciones[i];
                    mostrarMatriz(matriz, soluciones, n); 
                }
            }
        }
        System.out.println("Solución final:");
        for(int i = 0; i < n; i++){
            x[i] = soluciones[i];
            System.out.printf("x[%d] = %.3f\n", i, x[i]);
        }
        scanner.close();
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