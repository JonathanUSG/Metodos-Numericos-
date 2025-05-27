package Tema6_Ecuaciones_Diferenciales.Metodos_Sistemas_Ecuaciones;

import java.util.Scanner;

public class EulerSystem {
    // Método principal para arrancar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedimos los datos iniciales al usuario
        System.out.println("Método de Euler para un sistema de 2 ecuaciones diferenciales");
        System.out.print("Ingresa el valor inicial de x (x0): ");
        double x0 = scanner.nextDouble();
        System.out.print("Ingresa el valor inicial de y1 (y1_0): ");
        double y1_0 = scanner.nextDouble();
        System.out.print("Ingresa el valor inicial de y2 (y2_0): ");
        double y2_0 = scanner.nextDouble();
        System.out.print("Ingresa el valor final de x (xf): ");
        double xf = scanner.nextDouble();
        System.out.print("Ingresa el tamaño del paso (h): ");
        double h = scanner.nextDouble();

        // Llamamos al método de Euler
        eulerMethod(x0, y1_0, y2_0, xf, h);

        // Cerramos el scanner
        scanner.close();
    }

    // Método que implementa el método de Euler para un sistema de 2 ecuaciones
    public static void eulerMethod(double x0, double y1_0, double y2_0, double xf, double h) {
        // Calculamos cuántos pasos necesitamos
        int n = (int) Math.ceil((xf - x0) / h);
        double[] x = new double[n + 1];
        double[] y1 = new double[n + 1];
        double[] y2 = new double[n + 1];

        // Inicializamos los valores iniciales
        x[0] = x0;
        y1[0] = y1_0;
        y2[0] = y2_0;
        
        // Imprimimos el encabezado de la tabla de resultados
        System.out.printf("%10s %10s %10s%n", "x", "y1", "y2");
        System.out.printf("%10.4f %10.4f %10.4f%n", x[0], y1[0], y2
    }
}
