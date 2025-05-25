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
        } else{
            double c = a; // c será el punto medio del intervalo
            int iteraciones = 0;

            // Imprimimos un encabezado bonito para la tabla de iteraciones
            System.out.printf("%-5s %-12s %-12s %-12s %-12s%n", "Iter", "a", "b", "c", "f(c)");

            // Aquí va el ciclo principal del método de bisección
            do {
                c = (a + b) / 2;        // Calculamos el punto medio
                double fc = f(c);       // Evaluamos la función en ese punto

                // Imprimimos los valores actuales de cada iteración
                System.out.printf("%-5d %-12.6f %-12.6f %-12.6f %-12.6f%n",
                        iteraciones, a, b, c, fc);

                // Si f(c) es exactamente 0, ya encontramos la raíz
                if (fc == 0.0)
                    break;
                // Si f(a) y f(c) tienen signos opuestos, la raíz está entre a y c
                else if (f(a) * fc < 0)
                    b = c;
                // Si no, la raíz está entre c y b
                else
                    a = c;

                iteraciones++;
            } while ((b - a) / 2 > epsilon); // El ciclo se repite hasta que el intervalo sea suficientemente pequeño

            // Mostramos la raíz aproximada
            System.out.printf("%nLa raíz aproximada es: %.4f%n", c);
        }

        scanner.close(); // Cerramos el escáner para liberar recursos
        }
    }