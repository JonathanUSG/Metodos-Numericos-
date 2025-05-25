import java.util.Scanner;

public class Biseccion{

    // Esta es la función que queremos analizar. En este caso es f(x) = x^3 - x - 2
    // Si quieres probar con otra función, puedes cambiar esta línea.
    public static double f(double x){
        return Math.pow(x,3) - x - 2;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);

        System.out.println("Método de Bisección");

        // Pedimos al usuario los valores iniciales del intervalo [a, b] y el error permitido
        System.out.print("Ingrese el límite inferior a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior b: ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese el error tolerado (por ejemplo 0.0001): ");
        double epsilon = scanner.nextDouble();

        // Validamos si la función cambia de signo entre a y b
        // Esto es importante, porque si f(a)*f(b) >= 0, entonces no hay garantía de que haya una raíz en ese intervalo
        if (f(a) * f(b) >= 0) {
            System.out.println("No se cumple el criterio f(a)*f(b) < 0. Cambie los valores de a y b.");
        }
    }
}