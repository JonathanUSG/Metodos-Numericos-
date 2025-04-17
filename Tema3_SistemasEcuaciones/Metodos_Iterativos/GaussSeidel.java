package Tema3_SistemasEcuaciones.Metodos_Iterativos;
import java.util.*;
public class GaussSeidel{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar el número de ecuaciones
        System.out.print("Ingrese el número de ecuaciones (n: ");
        int n = scanner.nextInt();

        double [][] matriz = new double[n][n];
        double [] soluciones = new double[n];
        double [] x = new double[n];
        double [] anterior = new double[n];
        
        //Lee matriz aumentada
        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for(int i = 0; i< n; i++){  
            System.out.printf("Ecuación " + (i + 1) + ":");
            for(int j = 0; j < n; j++){
                System.out.printf("Coeficiente [%d][%d]: ", i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.printf("Término Independiente [%d]: ", i + 1);
            soluciones[i] = scanner.nextDouble();
        }
        System.out.print("Ingrese la tolerancia adecuada (de preferencia 0.000001): ");
        double tolerancia = scanner.nextDouble();
        System.out.print("\nIngrese el número máximo de Iteraciones (Por ejemplo, 100): ");
        int maxIteraciones = scanner.nextInt();
    }
}