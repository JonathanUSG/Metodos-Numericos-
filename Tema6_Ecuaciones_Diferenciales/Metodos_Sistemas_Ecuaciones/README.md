# 📊 Métodos para Sistemas de Ecuaciones

Esta carpeta contiene información teórica, fórmulas y código en Java para el método de **Euler**, un método numérico simple utilizado para resolver sistemas de ecuaciones diferenciales ordinarias (EDOs).

---

## 📚 Información Teórica

### 🔹 Euler

El método de **Euler** es un método numérico de un paso para resolver sistemas de EDOs de la form:

$$
\frac{d\mathbf{y}}{dt} = \mathbf{f}(t, \mathbf{y}), \quad \mathbf{y}(t_0) = \mathbf{y}_0
$$

Donde $\mathbf{y}$ es un vector de variables dependientes y $\mathbf{f}$ es un vector de funciones. El método aproxima la solución usando la derivada en el punto actual.

#### Fórmulas

Para un paso de $t_i$ a $t_{i+1} = t_i + h$, la solución $\mathbf{y}_{i+1}$ se calcula como:

$$
\mathbf{y}_{i+1} = \mathbf{y}_i + h \cdot \mathbf{f}(t_i, \mathbf{y}_i)
$$

✅ **Ventajas**:
- Simple de implementar y entender.
- Adecuado para sistemas de EDOs con comportamiento suave.

⚠️ **Limitaciones**:
- Baja precisión (error de orden $O(h^2)$ por paso).
- Puede ser inestable para tamaños de paso grandes o EDOs rígidas.

---

## 📂 Contenido de la Carpeta

Esta carpeta incluye:

- 📄 Código en Java para implementar el método **Euler** para resolver sistemas de EDOs.

---

### 💻 Código Java - Método de Euler Para resolver Sistemas de Ecuaciones Diferenciales 

```java
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
        System.out.printf("%10.4f %10.4f %10.4f%n", x[0], y1[0], y2[0]);

        // Bucle para cada paso del método de Euler
        for (int i = 0; i < n; i++) {
            // Calculamos las derivadas en el punto actual
            double[] derivatives = f(x[i], y1[i], y2[i]);

            // Actualizamos los valores de x, y1 y y2 usando la fórmula de Euler
            x[i + 1] = x[i] + h;
            y1[i + 1] = y1[i] + h * derivatives[0];
            y2[i + 1] = y2[i] + h * derivatives[1];

            // Mostramos los resultados de este paso
            System.out.printf("%10.4f %10.4f %10.4f%n", x[i + 1], y1[i + 1], y2[i + 1]);
        }
    }
    
    // Función que define el sistema de ecuaciones diferenciales
    // En este ejemplo: dy1/dx = -2x*y1, dy2/dx = y1 - y2
    // Retorna un arreglo con las derivadas [dy1/dx, dy2/dx]
    public static double[] f(double x, double y1, double y2) {
        double[] derivatives = new double[2];
        derivatives[0] = -2 * x * y1; // dy1/dx
        derivatives[1] = y1 - y2;     // dy2/dx
        return derivatives;
    }
}
```
---

## 📝 Recomendaciones

- 📌 Use tamaños de paso pequeños para mejorar la precisión.
- ✅ Valide los resultados con métodos más precisos (como Runge-Kutta) para sistemas complejos.
- 📊 Verifique la estabilidad del método en sistemas rígidos.
- ⚠️ Evite su uso en problemas con soluciones que crecen rápidamente.
