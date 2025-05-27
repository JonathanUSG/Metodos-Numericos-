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

        // Usamos Runge-Kutta para calcular los primeros 3 puntos adicionales
        for (int i = 0; i < 3; i++) {
            double k1 = f(x[i], y[i]);
            double k2 = f(x[i] + h/2, y[i] + (h * k1)/2);
            double k3 = f(x[i] + h/2, y[i] + (h * k2)/2);
            double k4 = f(x[i] + h, y[i] + h * k3);

            x[i + 1] = x[i] + h;
            y[i + 1] = y[i] + (h/6) * (k1 + 2*k2 + 2*k3 + k4);
            f[i + 1] = f(x[i + 1], y[i + 1]);
        }
    }
    // Función que define la ecuación diferencial dy/dx = f(x, y)
    // En este ejemplo, usamos dy/dx = -2x*y (puedes cambiarla según necesites)
    public static double f(double x, double y) {
        return -2 * x * y;
    }
}
