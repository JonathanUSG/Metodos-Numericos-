# Métodos Abiertos para la Solución de Ecuaciones

Los **métodos abiertos** son técnicas numéricas que **no requieren un intervalo inicial cerrado**, sino uno o dos valores de inicio. Ofrecen **mayor velocidad** que los métodos cerrados, pero **pueden divergir** si no se usan adecuadamente.

---

## 1. Método del Punto Fijo

### Descripción

Reescribe \$f(x)=0\$ como \$x = g(x)\$ y usa la iteración:

$x_{n+1} = g(x_n)$

### Ventajas

* Simple implementación.

### Desventajas

* Puede no converger si \$|g'(x)| \geq 1\$.

### Código

```java
public class MetodoPuntoFijo {
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }
    public static double g(double x) {
        return Math.cbrt(x + 2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Método del Punto Fijo");
        System.out.print("Ingrese el valor inicial x0: ");
        double x0 = scanner.nextDouble();
        System.out.print("Ingrese el error tolerado: ");
        double epsilon = scanner.nextDouble();

        int iteraciones = 0;
        double x1;
        System.out.printf("%-5s %-12s %-12s %-12s%n", "Iter", "x0", "g(x0)", "Error");
        do {
            x1 = g(x0);
            double error = Math.abs(x1 - x0);
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f%n", iteraciones, x0, x1, error);
            x0 = x1;
            iteraciones++;
            if (iteraciones > 1000) {
                System.out.println("Demasiadas iteraciones.");
                return;
            }
        } while (Math.abs(f(x1)) > epsilon);
        System.out.printf("\nRaíz aproximada: %.4f%n", x1);
        scanner.close();
    }
}
```

---

## 2. Método de Newton-Raphson

### Descripción

Usa derivadas para hacer una aproximación lineal:

$x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}$

### Ventajas

* Convergencia rápida si está cerca de la raíz.

### Desventajas

* Requiere derivadas.
* Puede fallar si \$f'(x)\$ es cero o cercano a cero.

### Código

```java
public class NewtonRaphson {
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }
    public static double fDerivada(double x) {
        return 3 * Math.pow(x, 2) - 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Método de Newton-Raphson");
        System.out.print("Ingrese x0: ");
        double x0 = scanner.nextDouble();
        System.out.print("Ingrese el error tolerado: ");
        double epsilon = scanner.nextDouble();

        double x1;
        int iteraciones = 0;
        System.out.printf("%-5s %-12s %-12s %-12s%n", "Iter", "x0", "f(x0)", "x1");
        do {
            double fx0 = f(x0);
            double dfx0 = fDerivada(x0);
            if (dfx0 == 0) {
                System.out.println("Derivada cero. El método falla.");
                return;
            }
            x1 = x0 - fx0 / dfx0;
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f%n", iteraciones, x0, fx0, x1);
            x0 = x1;
            iteraciones++;
        } while (Math.abs(f(x1)) > epsilon);
        System.out.printf("\nRaíz aproximada: %.4f%n", x1);
        scanner.close();
    }
}
```

---

## 3. Método de la Secante

### Descripción

Aproxima la derivada con dos puntos:

$x_{n+1} = x_n - f(x_n) \cdot \frac{x_n - x_{n-1}}{f(x_n) - f(x_{n-1})}$

### Ventajas

* No necesita derivadas.
* Mejora la convergencia frente al punto fijo.

### Desventajas

* Requiere dos valores iniciales.
* Puede fallar si \$f(x\_n) = f(x\_{n-1})\$.

### Código

```java
public class MetodoSecante {
    public static double f(double x) {
        return Math.pow(x, 3) - x - 2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Método de la Secante");
        System.out.print("Ingrese x0: ");
        double x0 = scanner.nextDouble();
        System.out.print("Ingrese x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Ingrese error tolerado: ");
        double epsilon = scanner.nextDouble();

        double x2;
        int iteraciones = 0;
        System.out.printf("%-5s %-12s %-12s %-12s %-12s%n", "Iter", "x0", "x1", "x2", "f(x2)");
        do {
            double f0 = f(x0);
            double f1 = f(x1);
            if (f1 - f0 == 0) {
                System.out.println("División por cero. El método falla.");
                return;
            }
            x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            double fx2 = f(x2);
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f %-12.6f%n",
                    iteraciones, x0, x1, x2, fx2);
            x0 = x1;
            x1 = x2;
            iteraciones++;
        } while (Math.abs(f(x1)) > epsilon);
        System.out.printf("\nRaíz aproximada: %.4f%n", x1);
        scanner.close();
    }
}
```

---

Cada método tendrá su archivo `.md` correspondiente con dos casos de prueba.
