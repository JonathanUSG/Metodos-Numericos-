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

        scanner.close();
    }
}
