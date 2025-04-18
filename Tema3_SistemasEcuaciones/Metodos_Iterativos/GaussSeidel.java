package Tema3_SistemasEcuaciones.Metodos_Iterativos;
import java.util.*;
public class GaussSeidel{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Solicitar el número de ecuaciones
        System.out.print("Ingrese el número de ecuaciones (n): ");
        int n = scanner.nextInt();

        double [][] matriz = new double[n][n];
        double [] soluciones = new double[n];
        double [] x = new double[n];
        double [] anterior = new double[n];
        
        //Lee matriz aumentada
        System.out.println("Ingrese la matriz aumentada (coeficientes y términos independientes):");
        for(int i = 0; i< n; i++){  
            System.out.println("Ecuación " + (i + 1) + ":");
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

        for(int i = 0; i < n; i++){
            x[i] = 0;
            anterior[i] = 0;
        }

        //Método de Gauss - Seidel 
        System.out.println("\nIniciando Iteraciones de Gauss - Seidel");
        int iteracion = 0;
        while (iteracion < maxIteraciones){
            for(int i = 0; i < n; i++){
                anterior[i] = x[i];
            }
            //Calcular nuevos valores de x
            for(int i = 0; i < n; i++){
                double suma = soluciones[i];
                for(int j = 0; j < n; j++){
                    if(j != i){
                        suma -= matriz[i][j] * x [j];
                    }
                }
                x[i] = suma / matriz [i][i];
            }
            //Verificar convergencia
            boolean convergencia = true;
            for(int j = 0; j < n; j++){
                if(Math.abs(x[j] - anterior[j]) > tolerancia){
                    convergencia = false;
                    break;
                }
            }
            //Mostrar resultados de la Iteración
            System.out.printf("Iteración %d:\n", iteracion + 1);
            for(int j = 0; j < n; j++){
            System.out.printf("x[%d] = %.3f\n", j, x[j]);
            }
            //Si converge, muestra la solución final y sale
            if(convergencia){
                System.out.println("\nConvergencia alcanzada");
                System.out.println("Solución Final:");
                for(int j = 0; j < n; j++){
                    System.out.printf("x[%d] = %.3f\n", j, x[j]);
                }
                break;
            } 
            iteracion++;
        }
        // Si no converge, se imprime el mensaje
        if(iteracion >= maxIteraciones){
            System.out.println("\nNo se alcanzó convergencia dentro del número máximo de iteraciones");
        } 
        scanner.close();
    }
}