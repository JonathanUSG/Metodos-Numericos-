package Tema3_SistemasEcuaciones.Metodos_Iterativos;
import java.util.*;
public class Jacobi{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de ecuaciones (n): ");
        int n = scanner.nextInt();
        double [][] matriz = new double[n][n];
        double [] soluciones = new double[n];
        double [] x = new double[n];
        double[] anterior = new double[n];

        //Leer la matriz Aumentada
        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for(int i = 0; i < n; i++){
            System.out.println("Ecuación " + (i + 1) + ":");
            for(int j = 0; j < n; j++){
                System.out.printf("Coeficiente [%d][%d]: ", i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
            System.out.printf("Término Independiente [%d]: ", i + 1);
            soluciones[i] = scanner.nextDouble();
        }

        //Validar elementos diagonales
        for(int i = 0; i < n; i++){
            if (Math.abs(matriz[i][i]) < 1e-10) {
                System.out.println("Error: El elemento diagonal matriz [" + i + "][" + (i + 1) + "] es cero o es muy pequeño");
                scanner.close();
                return;
            }
        }
        // Tolerancia e Iteraciones máximas
        System.out.print("Ingrese la tolerancia deseada (Por ejemplo: 0.00001): ");
        double tolerancia = scanner.nextDouble();
        System.out.print("Ingrese el número máximo de iteraciones (Por ejemplo: 100): ");
        int maxIteraciones = scanner.nextInt();

        //Inicializar x y anterior en 0
        for(int i = 0; i < n; i++){
            x[i] = 0;
            anterior[i] = 0;
        }
    }
}