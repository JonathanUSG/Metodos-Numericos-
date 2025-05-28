# 📊 Análisis de Datos

Esta carpeta contiene información teórica y código en Java para los métodos de análisis de datos: **Correlación**, **Regresión Lineal** y **Mínimos Cuadrados**. Estos métodos se utilizan para modelar relaciones y tendencias en conjuntos de datos.

---

## 📚 Información Teórica

### 🔗 Correlación

La correlación mide la relación lineal entre dos variables. El **coeficiente de correlación de Pearson** $r$ se calcula como:

$$
r = \frac{n\sum xy - \sum x \sum y}{\sqrt{(n\sum x^2 - (\sum x)^2)(n\sum y^2 - (\sum y)^2)}}
$$

✅ **Ventajas**:

* Indica la fuerza y dirección de la relación.

⚠️ **Limitaciones**:

* Solo mide relaciones lineales.

---

### 📈 Regresión Lineal

La regresión ajusta una función (lineal o no lineal) para modelar la relación entre variables. Para **regresión lineal simple**, la ecuación es:

$$
y = a + bx
$$

donde $a$ es la **intersección** y $b$ la **pendiente**.

✅ **Ventajas**:

* Predice valores basándose en tendencias.

⚠️ **Limitaciones**:

* Sensible a valores atípicos.

---

### 📉 Mínimos Cuadrados

Es un método para encontrar la mejor línea que minimice la suma de los cuadrados de las diferencias entre los valores observados y los predichos. Los parámetros se calculan igual que en regresión lineal simple.

---

## 💻 Código Java

### 1. Correlación

```java
package Tema5_Interpolacion.Metodos_Analisis_Datos;

public class Correlacion {
    public static void main(String[] args) {
        double [] x = {1, 2, 3, 4, 5};
        double [] y = {2, 4, 6, 8, 10};

        System.out.println("Puntos Utilizados:");
        for(int i = 0; i < x.length; i++){
            System.out.printf("x = %.1f, y = %.1f\n", x[i], y[i]);
        }

        double r = calcularCorrelacion(x,y);
        System.out.printf("\nCoeficiente de correlación: %.4f\n", r);

        double errorAbsoluto = calcularErrorAbsoluto(r);
        double errorPorcentual = calcularErrorPorcentual(r);

        System.out.printf("Error Absoluto: %.4f\n", errorAbsoluto);
        System.out.printf("Error Porcentual: %.2f%%\n", errorPorcentual);

        if (r == 1) 
            System.out.println("Correlación Perfecta Positiva");
         else if(r == -1)
            System.out.println("Correlación Perfecta Negativa");
         else if(r > 0)
            System.out.println("Correlación Positiva");
         else if(r < 0)
            System.out.println("Correlación Negativa");
         else 
            System.out.println("Sin correlación");
    }

    public static double calcularCorrelacion(double []x, double []y){
        int n = x.length;
        double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0, sumaY2 = 0;

        for(int i = 0; i < n; i++){
            sumaX += x[i];
            sumaY += y[i];
            sumaXY += x[i] * y[i];
            sumaX2 += x[i] * x[i];
            sumaY2 += y[i] * y[i];  
        }

        double numerador = (n * sumaXY) - (sumaX * sumaY);
        double denominador = Math.sqrt((n * sumaX2 - sumaX * sumaX) * (n * sumaY2 - sumaY * sumaY));

        if (denominador == 0) {
            System.out.println("Error: División entre cero");
            return 0;
        }
        return numerador / denominador;
    }

    public static double calcularErrorAbsoluto(double r){
        return 1 - Math.abs(r);
    }

    public static double calcularErrorPorcentual(double r){
        return (1 - Math.abs(r)) * 100;
    }
}
```

---

### 2. Mínimos Cuadrados

```java
package Tema5_Interpolacion.Metodos_Analisis_Datos;

public class MinimosCuadrados {
    public static void main(String[] args) {
       double [] x = {1, 2, 3, 4, 5};
       double [] y = {2, 3, 5, 4, 6};

       mostrarDatos(x, y);

       double resultados [] = calcularMinimosCuadrados(x, y);
       double pendiente = resultados[0];
       double interseccion = resultados[1];

       System.out.printf("Ecuación ajustada: y = %.4fx + %.4f\n\n", pendiente, interseccion);

       calcularErrores(x, y, pendiente, interseccion);
    }

    public static void mostrarDatos(double []x, double []y){
        System.out.println(" x\t y");
        System.out.println("-----------");
        for(int i = 0; i < x.length; i++){
            System.out.printf("%.1f\t%.1f\n", x[i], y[i]);
        }
        System.out.println();
    }

    public static double[] calcularMinimosCuadrados(double []x, double []y){
        int n = x.length;
        double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0;

        for(int i = 0; i < n; i++){
            sumaX += x[i];
            sumaY += y[i];
            sumaXY += x[i] * y[i];
            sumaX2 += x[i] * x[i];
        }

        double pendiente = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX);
        double interseccion = (sumaY - pendiente * sumaX) / n;

        return new double[]{pendiente, interseccion};
    }

    public static double calcularErrorAbsoluto(double real, double estimado){
        return Math.abs(real - estimado);
    }

    public static double calcularErrorPorcentual(double real, double errorAbsoluto){
        return (errorAbsoluto / real) * 100;
    }

    public static void calcularErrores(double[] x, double[] y, double pendiente, double interseccion){
        int n = x.length;
        double sumaErroresPorcentuales = 0;

        System.out.println(" x\t y real\t y estimado\t Error abs\t Error %");
        System.out.println("-----------------------------------------------------");

        for(int i = 0; i < n; i++){
            double yEstimado = pendiente * x[i] + interseccion;
            double errorAbsoluto = calcularErrorAbsoluto(y[i], yEstimado);
            double errorPorcentual = calcularErrorPorcentual(y[i], errorAbsoluto);

            sumaErroresPorcentuales += errorPorcentual;

            System.out.printf("%.1f\t %.1f\t   %.2f\t\t %.2f\t\t %.2f%%\n",
                    x[i], y[i], yEstimado, errorAbsoluto, errorPorcentual);
        }

        double promedioError = sumaErroresPorcentuales / n;
        System.out.printf("\nError Porcentual promedio: %.2f%%\n", promedioError);
    }
}
```

---

### 3. Regresión Lineal

```java
package Tema5_Interpolacion.Metodos_Analisis_Datos;

public class RegresionLineal {
    public static void main(String[] args) {
        double [] x = {1, 2, 3, 4, 5};
        double [] y = {2, 3, 5, 4, 6};

        mostrarDatos(x, y);

        double[] coeficientes = calcularRegresionLineal(x, y);
        double pendiente = coeficientes[0];
        double interseccion = coeficientes[1];

        System.out.printf("Ecuación ajustada: y = %.4fx + %.4f\n\n", pendiente, interseccion);

        calcularErrores(x, y, pendiente, interseccion);
    }

    public static void mostrarDatos(double []x, double []y){
        System.out.println(" x\t y");
        System.out.println("------------");
        for(int i = 0; i < x.length; i++){
            System.out.printf("%.1f\t%.1f\n", x[i], y[i]);
        }
        System.out.println();
    }

    public static double[] calcularRegresionLineal(double[] x, double[] y){
        int n = x.length;
        double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0;

        for(int i = 0; i < n; i++){
            sumaX += x[i];
            sumaY += y\[i];
            sumaXY += x\[i] \* y\[i];
            sumaX2 += x\[i] \* x\[i];
            }

    double pendiente = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX);
    double interseccion = (sumaY - pendiente * sumaX) / n;

    return new double[]{pendiente, interseccion};
    }

public static double calcularErrorAbsoluto(double real, double estimado){
    return Math.abs(real - estimado);
}

public static double calcularErrorPorcentual(double real, double errorAbsoluto){
    return (errorAbsoluto / real) * 100;
}

public static void calcularErrores(double[] x, double[] y, double pendiente, double interseccion){
    int n = x.length;
    double sumaErroresPorcentuales = 0;

    System.out.println(" x\t y real\t y estimado\t Error abs\t Error %");
    System.out.println("-----------------------------------------------------");

    for(int i = 0; i < n; i++){
        double yEstimado = pendiente * x[i] + interseccion;
        double errorAbsoluto = calcularErrorAbsoluto(y[i], yEstimado);
        double errorPorcentual = calcularErrorPorcentual(y[i], errorAbsoluto);

        sumaErroresPorcentuales += errorPorcentual;

        System.out.printf("%.1f\t %.1f\t   %.2f\t\t %.2f\t\t %.2f%%\n",
                x[i], y[i], yEstimado, errorAbsoluto, errorPorcentual);
    }

    double promedioError = sumaErroresPorcentuales / n;
    System.out.printf("\nError Porcentual promedio: %.2f%%\n", promedioError);
    }
}

```

---
