import java.util.Scanner; 

public class ReglaFalsa{
     // Esta es la función que se quiere analizar
    // En este caso: f(x) = x^3 - x - 2
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in); // Objeto para leer entradas desde consola

        System.out.println("Método de la Regla Falsa");

        // Se piden los datos necesarios para comenzar
        System.out.print("Ingrese el límite inferior a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior b: ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese el error tolerado (por ejemplo 0.0001): ");
        double epsilon = scanner.nextDouble();

        scanner.close();
    }
}