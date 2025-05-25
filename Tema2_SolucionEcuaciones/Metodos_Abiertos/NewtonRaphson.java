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

        scanner.close();
    }
}
