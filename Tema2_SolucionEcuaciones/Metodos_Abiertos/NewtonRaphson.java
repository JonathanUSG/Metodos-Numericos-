package Tema2_SolucionEcuaciones.Metodos_Abiertos;

import java.util.Scanner;

public class NewtonRaphson {

   // Esta es la función f(x) para la que queremos encontrar la raíz
    // En este caso: f(x) = x^3 - x - 2
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    // Aquí definimos la derivada de f(x), necesaria para el método de Newton-Raphson
    // Derivada: f'(x) = 3x^2 - 1
    public static double fDerivada(double x) {
        return 3 * Math.pow(x, 2) - 1;
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Método de Newton-Raphson");

        // Pedimos al usuario un valor inicial para empezar el método
        System.out.print("Ingrese el valor inicial x0: ");
        double x0 = scanner.nextDouble();

        // Pedimos también la precisión deseada para detener la iteración
        System.out.print("Ingrese el error tolerado (por ejemplo 0.0001): ");
        double epsilon = scanner.nextDouble();

        double x1;          // Variable para guardar la siguiente aproximación
        int iteraciones = 0; // Contador de iteraciones

        // Imprimimos una cabecera para que se vea la tabla de resultados
        System.out.printf("%-5s %-12s %-12s %-12s%n", "Iter", "x0", "f(x0)", "x1");

        // Empezamos a iterar hasta que el valor de f(x1) sea menor que el error deseado
        do {
            double fx0 = f(x0);          // Calculamos f(x0)
            double dfx0 = fDerivada(x0); // Calculamos f'(x0)

            // Si la derivada es cero, no podemos continuar porque dividiríamos entre cero
            if (dfx0 == 0) {
                System.out.println("La derivada es cero. El método falla.");
                return;
            }

            // Aplicamos la fórmula de Newton-Raphson para obtener la nueva aproximación
            x1 = x0 - fx0 / dfx0;

            // Imprimimos los datos de la iteración actual
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f%n",
                    iteraciones, x0, fx0, x1);

            x0 = x1;       // Actualizamos x0 para la siguiente iteración
            iteraciones++; // Sumamos una iteración
        } while (Math.abs(f(x1)) > epsilon); // Repetimos hasta alcanzar la precisión deseada

        // Mostramos la raíz aproximada encontrada
        System.out.printf("%nLa raíz aproximada es: %.4f%n", x1);
        
        scanner.close();
    }
}
