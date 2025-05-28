# 📂 Métodos de Interpolación

Esta carpeta contiene **información teórica** y **código en Java** para los métodos de interpolación:  
**Interpolación Lineal** e **Interpolación Polinómica**.  
Estos métodos permiten estimar valores de una función en puntos intermedios a partir de **datos discretos**.

---

## 📘 Información Teórica

### 🔹 Interpolación Lineal

La interpolación lineal conecta dos puntos consecutivos $(x_0, y_0)$ y $(x_1, y_1)$ con una **recta**.  
La fórmula para estimar $f(x)$ en un punto $x$ entre $x_0$ y $x_1$ es:

$$
P(x) = y_0 + \frac{(y_1 - y_0)}{(x_1 - x_0)} (x - x_0)
$$

**✅ Ventajas:**
- Simple.
- Rápida.
- Adecuada para datos con comportamiento lineal.

**⚠️ Limitaciones:**
- No captura curvaturas.
- No representa comportamientos complejos.

---

### 🔹 Interpolación Polinómica

Construye un **polinomio de grado $n$** que pasa por $n+1$ puntos conocidos.  
Uno de los métodos comunes es el **polinomio de Lagrange**, que usa una combinación de polinomios base.  
La forma general es:

$$
P(x) = \sum_{i=0}^n y_i \prod_{\substack{j=0 \\ j \neq i}}^n \frac{x - x_j}{x_i - x_j}
$$

**✅ Ventajas:**
- Precisa para datos con patrones no lineales.

**⚠️ Limitaciones:**
- Polinomios de alto grado pueden generar oscilaciones (**fenómeno de Runge**).

---

## 📁 Contenido de la Carpeta

Esta carpeta incluye:

- ✅ **Código en Java** para implementar la **Interpolación Lineal**:
```java
public class InterpolacionLineal {
    public static void main(String[] args) {
        double x0 = 2, y0 = 4;
        double x1 = 4, y1 = 16;
        double xBuscado = 3;
        double valorReal = 9;

        double resultado = interpolarLinealmente(x0, y0, x1, y1, xBuscado);

        System.out.printf("Valor interpolado en x = %.1f: %.4f\n", xBuscado, resultado);

        double errorAbsoluto = calcularErrorAbsoluto(valorReal, resultado);
        double errorPorcentual = calcularErrorPorcentual(valorReal, resultado);

        System.out.printf("Error Absoluto: %.4f\n", errorAbsoluto);
        System.out.printf("Error Porcentual: %.2f%%\n", errorPorcentual);

        System.out.println("\nPuntos Utilizados:");
        System.out.printf("x0 = %.1f, y0 = %.1f\n", x0, y0);
        System.out.printf("x1 = %.1f, y1 = %.1f\n", x1, y1);
    }

    public static double interpolarLinealmente(double x0, double y0, double x1, double y1, double x) {
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    public static double calcularErrorAbsoluto(double valorReal, double valorInterpolado) {
        return Math.abs(valorReal - valorInterpolado);
    }

    public static double calcularErrorPorcentual(double valorReal, double valorInterpolado) {
        return (Math.abs(valorReal - valorInterpolado) / valorReal) * 100;
    }
}
````

* ✅ **Código en Java** para implementar la **Interpolación Polinómica** (Lagrange):

```java
public class InterpolacionPolinomica {
    public static void main(String[] args) {
        double[] x = {1, 2, 3};
        double[] y = {1, 8, 27};
        double xBuscado = 2.5;
        double valorReal = 15.625;

        double resultado = interpolarPolinomio(x, y, xBuscado);

        System.out.printf("Valor Interpolado en x = %.1f: %.4f\n", xBuscado, resultado);

        double errorAbsoluto = calcularError(valorReal, resultado);
        double errorPorcentual = calcularErrorPorcentual(valorReal, resultado);

        System.out.printf("Cuota de error estimada: %.4f\n", errorAbsoluto);
        System.out.printf("Error Porcentual: %.2f%%\n", errorPorcentual);

        System.out.println("\nPuntos Utilizados:");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("x = %.1f, y = %.1f\n", x[i], y[i]);
        }
    }

    public static double interpolarPolinomio(double[] x, double[] y, double xBuscado) {
        double resultado = 0;
        for (int i = 0; i < x.length; i++) {
            double termino = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    termino *= (xBuscado - x[j]) / (x[i] - x[j]);
                }
            }
            resultado += termino;
        }
        return resultado;
    }

    public static double calcularError(double valorReal, double valorInterpolado) {
        return Math.abs(valorReal - valorInterpolado);
    }

    public static double calcularErrorPorcentual(double valorReal, double valorInterpolado) {
        return (Math.abs(valorInterpolado - valorReal) / Math.abs(valorReal)) * 100;
    }
}
```

---
