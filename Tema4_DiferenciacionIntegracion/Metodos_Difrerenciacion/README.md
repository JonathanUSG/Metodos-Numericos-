# Métodos de Diferenciación Numérica 

Esta carpeta contiene los métodos numéricos utilizados para **aproximar derivadas** de una función, cuando no es posible obtener una derivada analítica o se requiere una aproximación basada en datos discretos.

---

## Métodos incluidos

- **Método de los 3 puntos**
- **Método de los 5 puntos**

Ambos métodos permiten calcular la primera y segunda derivada utilizando fórmulas de diferencias finitas, tomando como referencia valores de la función en puntos igualmente espaciados.

---

## Archivos en esta carpeta

Cada método cuenta con:

- Explicación teórica en formato Markdown.
- Código fuente en Java.

---

## Aplicaciones

Los métodos de diferenciación numérica son esenciales para problemas de:

- Análisis de señales.
- Modelado físico y matemático.
- Ingeniería y simulación de sistemas dinámicos.

---

> Cada implementación fue probada con funciones comunes para verificar su exactitud.

---

## Explicación Teórica

### Método de los Tres Puntos

Este método se basa en una aproximación de la derivada utilizando una fórmula de diferencias centradas de segundo orden.

La fórmula es:

$$
f'(x) \approx \frac{f(x+h) - f(x-h)}{2h}
$$

Donde:

* $h$ es el tamaño del paso.
* Se requiere evaluar la función en $x+h$ y $x-h$.

**Ventajas:**

* Buena precisión con pocos puntos.
* Sencillo de implementar.

**Limitaciones:**

* Requiere que los puntos estén espaciados uniformemente.
* No se puede usar en los extremos de un intervalo de datos.

---

### Método de los Cinco Puntos

Este método proporciona una mejor aproximación que el de tres puntos, utilizando más valores alrededor del punto de interés.

La fórmula es:

$$
f'(x) \approx \frac{-f(x+2h) + 8f(x+h) - 8f(x-h) + f(x-2h)}{12h}
$$

**Ventajas:**

* Mayor precisión (orden de error $O(h^4)$).
* Adecuado para funciones suaves.

**Limitaciones:**

* Necesita más puntos alrededor de $x$.
* Puede no ser aplicable cerca de los bordes de los datos.

---


## Código

### Método de los Tres Puntos

```java
package Tema4_DiferenciacionIntegracion.Metodos_Difrerenciacion;

public class TresPuntos {
    public static void main(String[] args) {
        double x = 1; // Punto donde se calcula la derivada.
        double h = 0.1; // Tamaño del Paso
        int n = 4;  // Número Fijo para compatibilidad 

        // Calcular la derivada usando el método de tres puntos
        double resultado = tresPuntos(x, h);

        //Imprimir Información de la Función 
        System.out.println("Función: x * sin(x)");  // Función Evaluada
        System.out.println("Punto de derivación: " + x); // Punto de Evaluación
        System.out.println("Tamaño del Paso: " + h);    // Tamaño del Paso
        System.out.printf("Resultado de la derivada por el método de los Tres puntos: %.3g%n", resultado);
    }

    // Definir la función a derivar, puede modificarse
    public static double funcion(double x){
        return x * Math.sin(x); // Función f(x) = x * sin(x)
    }

    // Calcula la derivada numérica usando la fórmula de tres puntos
    public static double tresPuntos(double x, double h){
        double fx1 = funcion(x + h); // f(x + h)
        double fx2 = funcion(x - h); // f(x - h)

        //Aplicando la fórmula: [f(x + h) - f(x - h)] / (2h)
        return (fx1 - fx2) / (2 * h);
    }
}
````

---

### Método de los Cinco Puntos

```java
package Tema4_DiferenciacionIntegracion.Metodos_Difrerenciacion;

public class CincoPuntos {
    public static void main(String[] args) {
        // Definir Parámetros fijos para la derivación
        double x = 1;
        double h = 0.1;
        int n = 4;

        // Calcular la derivada usando el método de cinco puntos
        double resultado = cincoPuntos(x, h);

        //Imprimir Información
        System.out.println("Función: x * sin(x)");
        System.out.println("Punto de Derivación: " + x);
        System.out.printf("Resultado de la Derivada por el método de los Cinco Puntos: %.4g%n", resultado);
    }

    public static double funcion(double x){
        return x * Math.sin(x);
    }

    public static double cincoPuntos(double x, double h){
        //Evaluar la función en los puntos necesarios
        double fx1 = funcion(x + 2 * h); // f(x + 2h)
        double fx2 = funcion(x + h);     // f(x + h)
        double fx3 = funcion(x - h);     // f(x - h)
        double fx4 = funcion(x - 2 * h); // f(x - 2h)

        //Aplicar la fórmula de los Cinco Puntos: [- f(x + 2h) + 8f(x + h) - 8f(x - h) + f(x - 2h)] / (12h)
        return (-fx1 + 8 * fx2 - 8 * fx3 + fx4) / (12 * h);
    }
}
```
---
