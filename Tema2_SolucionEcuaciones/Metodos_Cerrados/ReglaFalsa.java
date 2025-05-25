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

        // Verificamos que se cumpla la condición inicial: f(a) y f(b) deben tener signos opuestos
        if (f(a) * f(b) >= 0) {
            System.out.println("No se cumple el criterio f(a)*f(b) < 0. Cambie los valores de a y b.");
        } else {
            double c = a; // Inicializamos la variable c que va a ir almacenando la raíz aproximada
            int iteraciones = 0; // Contador de iteraciones

            // Imprime encabezado de la tabla
            System.out.printf("%-5s %-12s %-12s %-12s %-12s%n", "Iter", "a", "b", "c", "f(c)");
        }

        scanner.close();
    }
}