# Métodos de Integración Numérica

Esta carpeta contiene los métodos numéricos para **aproximar integrales definidas**, especialmente útiles cuando la integral no puede resolverse de manera exacta o se trabaja con datos discretos.

---

## Métodos incluidos

* **Regla del Trapecio**
* **Simpson 1/3**
* **Simpson 3/8**
* **Cuadratura Gaussiana**

Cada uno de estos métodos aproxima el área bajo la curva mediante sumas ponderadas, variando en precisión y complejidad según el número de puntos utilizados.

---

## Archivos en esta carpeta

Cada método cuenta con:

* Código fuente en Java.
* Documentación en formato Markdown.

---

## Aplicaciones

Se usan ampliamente para:

* Cálculo de áreas.
* Solución de problemas de física e ingeniería.
* Integración de funciones donde no existe primitiva exacta.

---

> Todos los métodos fueron aplicados a funciones conocidas y verificados con resultados gráficos para validar su precisión.

---

## Regla del Trapecio

### Teoría

La **Regla del Trapecio** aproxima el área bajo una curva dividiendo el intervalo de integración en segmentos pequeños y aproximando el área de cada uno como un trapecio. Es un método sencillo que asume que la función se comporta linealmente entre cada par de puntos.

**Fórmula:**

$$
\int_a^b f(x)\,dx \approx \frac{h}{2} \left[f(x_0) + 2\sum_{i=1}^{n-1} f(x_i) + f(x_n)\right]
$$

### Código Java

```java
package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class Trapecio {
    public static void main(String[] args) {
         double a = 0;
         double b = 2;
         int n = 4;
         double resultado = trapecio(a, b, n);

         System.out.println("Función: x * sin(x)");
         System.out.println("Límite Inferior: " + (int) a);
         System.out.println("Límite Superior: " + (int) b);
         System.out.println("Número de Segmentos: " + n);
         System.out.printf("Resultado de la integral por el método del Trapecio: %.4g%n", resultado);
    }

    public static double funcion(double x){
        return x * Math.sin(x);
    }  

    public static double trapecio(double a, double b, int n){
        double h = (b - a) / n;
        double suma = (funcion(a) + funcion(b)) / 2;

        for(int i = 0; i < n; i++ ){
            double x = a + i * h;
            suma += funcion(x);
        }
        return h * suma;
    }
}
```

---

## Método de Simpson 1/3

### Teoría

El **Método de Simpson 1/3** utiliza parábolas (en lugar de líneas rectas) para aproximar el área bajo la curva. Requiere que el número de segmentos sea **par**. Tiene mejor precisión que la Regla del Trapecio para funciones suaves.

**Fórmula:**

$$
\int_a^b f(x)\,dx \approx \frac{h}{3} \left[f(x_0) + 4 \sum_{\text{impares}} f(x_i) + 2 \sum_{\text{pares}} f(x_i) + f(x_n)\right]
$$

### Código Java

```java
package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class Simpson13 {
    public static void main(String[] args) {
        double a = 0;
        double b = 2;
        int n = 4;

        double resultado = simpson13(a, b, n); 

        System.out.println("Función; x * sin(x)");
        System.out.println("Límite inferior " + (int) a);
        System.out.println("Límite Superior: " + (int) b);
        System.out.println("Número de Segementos: " + n);
        System.out.printf("Resultado de la Integral por el método de Simpson 1/3: %.4g%n", resultado);
    }

    public static double funcion(double x){
        return x * Math.sin(x);
    }

    public static double simpson13(double a, double b, int n){
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n debe ser un número par");
        }

        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);

        for(int i = 0; i < n; i++){
            double x = a + i * h;
            suma += (i % 2 == 0) ? 2 * funcion(x) : 4 * funcion(x);
        }
        return (h / 3) * suma;
    }
}
```

---

## Método de Simpson 3/8

### Teoría

El **Método de Simpson 3/8** es similar al 1/3, pero usa una aproximación cúbica (tres puntos) en cada segmento. Requiere que el número de intervalos sea múltiplo de **3**. Ofrece mejor precisión para ciertas funciones complejas.

**Fórmula:**

$$
\int_a^b f(x)\,dx \approx \frac{3h}{8} \left[f(x_0) + 3f(x_1) + 3f(x_2) + 2f(x_3) + \dots + f(x_n)\right]
$$

### Código Java

```java
package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class Simpson38 {
    public static void main(String[] args) {
        double a = 0;
        double b = 2;
        int n = 6;
        
        double resultado = simpson38(a, b, n);

        System.out.println("Función: x * sin(x)");
        System.out.println("Límite Inferior: " + (int) a);
        System.out.println("Límite Superior: " + (int) b);
        System.out.println("Número de Segmentos: " + n);
        System.out.printf("Resultado de la Integral por el método de Simpson 3/8: %.4g%n", resultado);
    }    

    public static double funcion(double x){
        return x * Math.sin(x);
    }

    public static double simpson38(double a, double b, int n){
        if (n % 3 != 0) {
            throw new IllegalArgumentException("n debe ser múltiplo de 3");
        }

        double h = (b - a) / n;
        double suma = funcion(a) + funcion(b);
        
        for(int i = 1; i < n; i++){
            double x = a + i * h;
            suma += (i % 3 == 0) ? 2 * funcion(x) : 3 * funcion(x);
        }
        return (3 * h / 8) * suma;
    }
}
```

---

## Cuadratura Gaussiana

### Teoría

La **Cuadratura Gaussiana** es un método avanzado que elige inteligentemente los puntos y los pesos dentro del intervalo para obtener una mayor precisión con menos evaluaciones de la función. Es útil especialmente cuando la función tiene un comportamiento irregular o los extremos no son tan representativos.

**Fórmula general (n=2):**

$$
\int_a^b f(x)\,dx \approx \frac{b-a}{2} \left[f\left(x_1\right) + f\left(x_2\right)\right]
$$

donde $x_1$ y $x_2$ son puntos transformados desde el intervalo $[-1,1]$ a $[a,b]$, usando pesos de Gauss.

### Código Java

```java
package Tema4_DiferenciacionIntegracion.Metodos_Integracion;

public class CuadraturaGaussiana {
    public static void main(String[] args) {
        double a = 0;
        double b = 2;
        int n = 4;

        double resultado = cuadraturaGaussiana(a, b);

        System.out.println("Función: x * sin(x)");
        System.out.println("Límite Inferior: " + (int) a);
        System.out.println("Límite Superior: " + (int) b );
        System.out.println("Número de Segementos: " + n);
        System.out.printf("Resultado de la Integral por el método de Cuadratura Gaussiana: %.4g%n", resultado);
    }

    public static double funcion(double x){
        return x * Math.sin(x);
    }

    public static double cuadraturaGaussiana(double a, double b){
        double t1 = -0.577350269;
        double t2 = 0.577350269;
        double w = 1.0;
        
        double x1 = ((b - a) * t1 + (b + a)) / 2;
        double x2 = ((b - a) * t2 + (b + a)) / 2;

        double fx1 = funcion(x1);
        double fx2 = funcion(x2);
        
        return (b - a) / 2 * (w * fx1 + w * fx2);
    }
}
```

---
