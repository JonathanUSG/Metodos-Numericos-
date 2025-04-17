package Tema3_SistemasEcuaciones.Metodos_Directos;
import java.util.*;
public class EliminacionGaussiana{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Solicitar tamaño de la matriz
        System.out.print("Ingrese el número de ecuaciones (n): ");
        int n = scanner.nextInt();
        
        double [][] matriz = new double[n][n];
        double [] soluciones = new double [n];
        double [] x = new double [n];
        //Leer la matriz aumentada
        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for(int i = 0; i < n; i++){
            System.out.println("Ecuación " + (i + 1) + ":");
            for(int j = 0; j < n; j++){
                System.out.printf("Coeficiente [%d][%d]: ", i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.printf("Término independiente [%d]: ", i + 1);
            soluciones [i] = scanner.nextDouble();
        } 
        System.out.println("\nMatriz Aumentada Ingresada");
        mostrarMatriz(matriz, soluciones, n);
        
        for(int j = 0; j < n; j++){
            for(int i = j + 1; i < n; i++){
                double factor = matriz [i][j] / matriz[j][j];
                for(int k = 0; k < n; k++){
                    matriz [i][k] -= factor * matriz[j][k];
                } 
                soluciones[i] -= factor * soluciones[j];
                System.out.printf("\nEliminando elemento [%d][%d] con factor %.3f:\n", i + 1, j + 1, factor);
                mostrarMatriz(matriz, soluciones, n);
            }
        }

            //Sustitución Hacia Atrás
            System.out.println("\nResolviendo por sustitución hacia atrás");
            for(int i = n - 1; i >=0; i--){
                double suma = 0;
                for(int j = i + 1; j < n; j++){
                    suma += matriz[i][j] * x[j];
                }
                x[i] = (soluciones[i]-suma) / matriz[i][i];
                System.out.printf("x[%d] = %.3f\n", i, x[i]);
            }

            //Mostrar Solución Final
            System.out.println("\nSolución Final:");
            for(int i = 0; i < n; i++){
                System.out.printf("x[%d] = %.3f\n", i, x[i]);
            }


            scanner.close();
        }

    public static void mostrarMatriz(double [][]matriz, double [] soluciones, int n){
        for(int i = 0; i < n; i++){
            System.out.print("|");
            for(int j = 0; j < n; j++){
                System.out.printf("%8.3f ", matriz[i][j]);
            }
            System.out.printf(" | %8.3f|\n", soluciones[i]);
        }
        System.out.println();
    }
    
}