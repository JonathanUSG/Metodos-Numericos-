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
        
        // Cerramos el scanner
        scanner.close();
    }

}
