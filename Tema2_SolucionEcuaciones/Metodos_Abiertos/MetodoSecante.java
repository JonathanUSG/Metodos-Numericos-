package Tema2_SolucionEcuaciones.Metodos_Abiertos;

import java.util.Scanner;

public class MetodoSecante {
    // Esta es la función f(x) que se quiere igualar a 0
    // Puedes cambiarla según el problema que quieras resolver
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;  // En este ejemplo: f(x) = x^3 - x - 2
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Método de la Secante");

        // Se piden dos valores iniciales al usuario (x0 y x1)
        // El método no necesita que f(x0) y f(x1) tengan signos opuestos como la bisección,
        // pero sí deben estar cerca de la raíz
        System.out.print("Ingrese el primer valor x0: ");
        double x0 = scanner.nextDouble();

        System.out.print("Ingrese el segundo valor x1: ");
        double x1 = scanner.nextDouble();

        // También se pide el error tolerado (qué tan precisa queremos la raíz)
        System.out.print("Ingrese el error tolerado (por ejemplo 0.0001): ");
        double epsilon = scanner.nextDouble();

        double x2;
        int iteraciones = 0;

        // Se imprime la cabecera de la tabla para mostrar el proceso iterativo
        System.out.printf("%-5s %-12s %-12s %-12s %-12s%n", "Iter", "x0", "x1", "x2", "f(x2)");

        // Aquí empieza el ciclo del método de la secante
        do {
            double f0 = f(x0);  // f(x0)
            double f1 = f(x1);  // f(x1)

            // Si el denominador se hace cero, la fórmula falla
            if (f1 - f0 == 0) {
                System.out.println("División por cero en la fórmula. El método falla.");
                return;
            }

            // Fórmula del método de la secante
            x2 = x1 - f1 * (x1 - x0) / (f1 - f0);  // Aproximación siguiente
            double fx2 = f(x2);  // Evaluamos f(x2)

            // Se imprime la iteración actual
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f %-12.6f%n",
                    iteraciones, x0, x1, x2, fx2);

            // Se actualizan los valores para la siguiente vuelta
            x0 = x1;
            x1 = x2;
            iteraciones++;

        // El ciclo se repite hasta que f(x1) sea suficientemente cercano a 0
        } while (Math.abs(f(x1)) > epsilon);

        // Al final se muestra la raíz encontrada
        System.out.printf("%nLa raíz aproximada es: %.4f%n", x1);

        scanner.close();
    }
}
