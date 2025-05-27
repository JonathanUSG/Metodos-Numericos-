package Tema6_Ecuaciones_Diferenciales.Metodos_Pasos_Multiples;

import java.util.Scanner;

public class AdamsBashforth {
    // Método principal para arrancar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedimos los datos iniciales al usuario
        System.out.println("Método de Adams-Bashforth de orden 4");
        System.out.print("Ingresa el valor inicial de x (x0): ");
        double x0 = scanner.nextDouble();
        System.out.print("Ingresa el valor inicial de y (y0): ");
        double y0 = scanner.nextDouble();
        System.out.print("Ingresa el valor final de x (xf): ");
        double xf = scanner.nextDouble();
        System.out.print("Ingresa el tamaño del paso (h): ");
        double h = scanner.nextDouble();

        // Llamamos al método Adams-Bashforth
        adamsBashforth(x0, y0, xf, h);

        // Cerramos el scanner
        scanner.close();
    }
    // Método principal de Adams-Bashforth
    public static void adamsBashforth(double x0, double y0, double xf, double h) {
        // Calculamos cuántos pasos necesitamos
        int n = (int) Math.ceil((xf - x0) / h);
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] f = new double[n + 1]; // Para almacenar los valores de f(x, y)

        // Inicializamos el primer punto
        x[0] = x0;
        y[0] = y0;
        f[0] = f(x[0], y[0]);
    }
}
