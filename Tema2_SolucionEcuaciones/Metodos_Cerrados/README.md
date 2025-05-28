# 📌 Métodos Cerrados para la Solución de Ecuaciones

Los métodos cerrados requieren un intervalo $\[a, b]\$ donde se garantice que exista una raíz, es decir, que \$f(a) \cdot f(b) < 0\$. Son conocidos por su **convergencia segura**, aunque lenta.

---

## Método de Bisección

### Descripción

Consiste en dividir a la mitad el intervalo $\[a, b]\$ y seleccionar la subparte donde cambie el signo de la función.

### 🖐️ Fórmula

$$
x_r = \frac{a + b}{2}
$$

### Ventajas

* Convergencia garantizada si \$f(a) \cdot f(b) < 0\$.
* Método robusto y fácil de implementar.

### Desventajas

* Convergencia lenta.
* No considera la forma de la función.

### 📂 Código en Java

```java
import java.util.Scanner;

public class Biseccion{
    public static double f(double x){
        return Math.pow(x,3) - x - 2;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);

        System.out.println("Método de Bisección");

        System.out.print("Ingrese el límite inferior a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior b: ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese el error tolerado (por ejemplo 0.0001): ");
        double epsilon = scanner.nextDouble();

        if (f(a) * f(b) >= 0) {
            System.out.println("No se cumple el criterio f(a)*f(b) < 0. Cambie los valores de a y b.");
        } else{
            double c = a;
            int iteraciones = 0;

            System.out.printf("%-5s %-12s %-12s %-12s %-12s%n", "Iter", "a", "b", "c", "f(c)");

            do {
                c = (a + b) / 2;
                double fc = f(c);

                System.out.printf("%-5d %-12.6f %-12.6f %-12.6f %-12.6f%n",
                        iteraciones, a, b, c, fc);

                if (fc == 0.0)
                    break;
                else if (f(a) * fc < 0)
                    b = c;
                else
                    a = c;

                iteraciones++;
            } while ((b - a) / 2 > epsilon);

            System.out.printf("%nLa raíz aproximada es: %.4f%n", c);
        }

        scanner.close();
    }
}
```

---

## Método de Regla Falsa (Falsa Posición)

### Descripción

Similar al de bisección, pero usa una línea recta para aproximar la raíz entre los puntos extremos del intervalo.

### Fórmula

$$
x_r = b - \frac{f(b)(a - b)}{f(a) - f(b)}
$$

### Ventajas

* Más rápido que la bisección en muchos casos.
* Requiere mismo criterio de \$f(a) \cdot f(b) < 0\$.

### Desventajas

* Puede estancarse si la forma de la función es desfavorable.

### 📂 Código en Java

```java
import java.util.Scanner; 

public class ReglaFalsa{
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Método de la Regla Falsa");

        System.out.print("Ingrese el límite inferior a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior b: ");
        double b = scanner.nextDouble();

        System.out.print("Ingrese el error tolerado (por ejemplo 0.0001): ");
        double epsilon = scanner.nextDouble();

        if (f(a) * f(b) >= 0) {
            System.out.println("No se cumple el criterio f(a)*f(b) < 0. Cambie los valores de a y b.");
        } else {
            double c = a;
            int iteraciones = 0;

            System.out.printf("%-5s %-12s %-12s %-12s %-12s%n", "Iter", "a", "b", "c", "f(c)");

            do {
                c = b - (f(b) * (a - b)) / (f(a) - f(b));
                double fc = f(c);

                System.out.printf("%-5d %-12.6f %-12.6f %-12.6f %-12.6f%n",
                        iteraciones, a, b, c, fc);

                if (fc == 0.0)
                    break;
                else if (f(a) * fc < 0)
                    b = c;
                else
                    a = c;

                iteraciones++;
            } while (Math.abs(f(c)) > epsilon);

            System.out.printf("%nLa raíz aproximada es: %.4f%n", c);
        }
        scanner.close();
    }
}
```
