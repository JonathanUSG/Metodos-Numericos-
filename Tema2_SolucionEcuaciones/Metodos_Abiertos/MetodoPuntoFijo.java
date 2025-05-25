package Tema2_SolucionEcuaciones.Metodos_Abiertos;

import java.util.Scanner;

public class MetodoPuntoFijo {

    // Esta es la función original f(x) = x^3 - x - 2
    // En el método del punto fijo, normalmente no se usa directamente,
    // pero sirve para verificar el error o la convergencia.
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }
    
    // Esta es la función g(x), que es una versión "reorganizada" de f(x)=0
    // En este caso: x = g(x) = raíz cúbica de (x + 2)
    // Ojo: hay que tener cuidado de que g(x) realmente sea convergente
    public static double g(double x) {
        return Math.cbrt(x + 2);
    }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        System.out.println("Método del Punto Fijo");

        // Se pide al usuario un valor inicial (x0) desde donde empezar
        System.out.print("Ingrese el valor inicial x0: ");
        double x0 = scanner.nextDouble();

        // Y también se pide un valor de error tolerado (epsilon)
        System.out.print("Ingrese el error tolerado (por ejemplo 0.0001): ");
        double epsilon = scanner.nextDouble();

        int iteraciones = 0;
        double x1;

        // Se imprime el encabezado de la tabla con las columnas:
        // Iteración, valor anterior (x0), g(x0), y el error
        System.out.printf("%-5s %-12s %-12s %-12s%n", "Iter", "x0", "g(x0)", "Error");

        // Bucle principal: se repite hasta que el error sea menor que el tolerado
        do {
            x1 = g(x0);  // Se calcula el nuevo valor aplicando g(x)
            double error = Math.abs(x1 - x0);  // Se calcula el error como la diferencia entre x0 y x1

            // Se imprime la información de esta iteración
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f%n",
                    iteraciones, x0, x1, error);

            // Se actualiza x0 con el nuevo valor para la próxima vuelta
            x0 = x1;
            iteraciones++;

            // Si pasa de 1000 iteraciones, se cancela por seguridad
            if (iteraciones > 1000) {
                System.out.println("Demasiadas iteraciones. El método puede no converger.");
                return;
            }

        // El ciclo sigue mientras f(x1) esté lejos de 0 (es decir, aún no se ha encontrado raíz)
        } while (Math.abs(f(x1)) > epsilon);

        // Cuando se cumple la condición de error, se muestra la raíz aproximada
        System.out.printf("%nLa raíz aproximada es: %.4f%n", x1);

        scanner.close();
    }
}
