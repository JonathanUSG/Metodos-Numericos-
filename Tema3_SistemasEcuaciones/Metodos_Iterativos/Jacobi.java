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

        //Método de Jacobi
        System.out.println("\nIniciando iteraciones de Jacobi....");
        int iteracion = 0;
        while(iteracion < maxIteraciones){
            iteracion++;

            //Calcular nuevos valores de x
            for(int i = 0; i < n; i++){
                double suma = soluciones [i];
                for(int j = 0; j < n; j++){
                    if(j != i){
                        suma -= matriz[i][j] * anterior[j];
                    }
                }
                x[i] = suma / matriz [i][i];
            }
            double maxDiferencia = 0;
            for(int i = 0; i < n; i++){
                maxDiferencia = Math.max(maxDiferencia, Math.abs(x[i] - anterior[i]));
            }
            //Imprimir resultados
            System.out.printf("Iteración %d (Diferencia Máxima: %.3f):\n", iteracion, maxDiferencia);
            for(int i = 0; i < n; i++){
                System.out.printf("x[%d] = %.3f\n", i, x[i]);
            }

            //Verificar convergencia
            boolean convergencia = true;
            for(int  i = 0; i < n; i++){
                if (Math.abs(x[i] - anterior[i]) > tolerancia) {
                    convergencia = false;
                    break;
                }
            }

            // Si converge, mostrar solución y salir
            if(convergencia){
                System.out.println("\nConvergencia alcanzada en la iteración " + iteracion + "!");
                break;
            }
            //Copiar valores para lasiguiente iteración
            for(int i = 0; i < n; i++){
                anterior[i] = x[i];
            }
        }
        if (iteracion >= maxIteraciones) {
            System.out.println("\nAdvertencia: No se alcanzó convergencia dentro del número de iteraciones establecidas");
        }
        //Mostrar solución final
        System.out.println("\nSolución Final:");
        for(int i = 0; i < n; i++){
            System.out.printf("x[%d] = %.3f\n", i, x[i]);
        }
        scanner.close();
    }
}