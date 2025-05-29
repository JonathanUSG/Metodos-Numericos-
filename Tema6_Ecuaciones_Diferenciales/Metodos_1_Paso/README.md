# 📊 Métodos de 1 Paso

Esta carpeta contiene información teórica, fórmulas y código en Java para el método de **Runge-Kutta**, un método numérico de un solo paso utilizado para resolver ecuaciones diferenciales ordinarias (EDOs).

---

## 📚 Información Teórica

### 🔹 Runge-Kutta

El método de **Runge-Kutta** es un enfoque numérico para resolver EDOs de la forma:

$$
\frac{dy}{dt} = f(t, y), \quad y(t_0) = y_0
$$

El método más común, **Runge-Kutta de orden 4 (RK4)**, aproxima la solución evaluando la función $f(t, y)$ en cuatro puntos intermedios dentro de un intervalo $h$ (tamaño del paso). Es conocido por su alta precisión y estabilidad.

#### Fórmulas

Para un paso de $t_i$ a $t_{i+1} = t_i + h$, la solución $y_{i+1}$ se calcula como:

$$
y_{i+1} = y_i + \frac{h}{6} (k_1 + 2k_2 + 2k_3 + k_4)
$$

Donde los términos $k_1$, $k_2$, $k_3$ y $k_4$ son:

$$
k_1 = f(t_i, y_i)
$$

$$
k_2 = f\left(t_i + \frac{h}{2}, y_i + \frac{h}{2}k_1\right)
$$

$$
k_3 = f\left(t_i + \frac{h}{2}, y_i + \frac{h}{2}k_2\right)
$$

$$
k_4 = f(t_i + h, y_i + hk_3)
$$

✅ **Ventajas**:
- Alta precisión (error de orden $O(h^5)$ por paso).
- Estable para una amplia gama de problemas.
- No requiere puntos previos adicionales.

⚠️ **Limitaciones**:
- Computacionalmente más costoso que métodos más simples como Euler.
- Requiere evaluar la función $f(t, y)$ cuatro veces por paso.

---

## 📂 Contenido de la Carpeta

Esta carpeta incluye:

- 📄 Código en Java para implementar el método **Runge-Kutta de orden 4** para resolver EDOs.

---

### 💻 Código Java - Runge-Kutta de Orden 4

```java
import java.util.Scanner;

public class RungeKutta{
    // Método para evaluar la función f(x,y) que el usuario ingresa
    public static double evaluarFuncion(String funcion, double x, double y) {
        // Convertimos la función a minúsculas y quitamos espacios
        funcion = funcion.toLowerCase().replace(" ", "");
        
        // Reemplazamos funciones matemáticas con sus valores calculados
        funcion = funcion.replaceAll("sin\\(x\\)", Double.toString(Math.sin(x)));
        funcion = funcion.replaceAll("cos\\(x\\)", Double.toString(Math.cos(x)));
        funcion = funcion.replaceAll("exp\\(x\\)", Double.toString(Math.exp(x)));
        funcion = funcion.replaceAll("log\\(x\\)", Double.toString(Math.log(x)));
        
        // Lo mismo pero para la variable y
        funcion = funcion.replaceAll("sin\\(y\\)", Double.toString(Math.sin(y)));
        funcion = funcion.replaceAll("cos\\(y\\)", Double.toString(Math.cos(y)));
        funcion = funcion.replaceAll("exp\\(y\\)", Double.toString(Math.exp(y)));
        funcion = funcion.replaceAll("log\\(y\\)", Double.toString(Math.log(y)));
        
        // Sustituimos x e y por sus valores numéricos
        funcion = funcion.replaceAll("x", Double.toString(x));
        funcion = funcion.replaceAll("y", Double.toString(y));
        
        // Evaluamos la expresión resultante
        return evaluarExpresionSimple(funcion);
    }
    // Método para evaluar expresiones con sumas y restas
    public static double evaluarExpresionSimple(String expr) {
        double resultado = 0;
        // Cambiamos dobles negativos por suma para evitar errores
        expr = expr.replaceAll("--", "+");

        // Separamos la expresión en partes según los signos + o -
        String[] sumandos = expr.split("(?=[+-])");

        // Sumamos o restamos cada parte
        for (String sumando : sumandos) {
            resultado += evaluarProducto(sumando);
        }
        return resultado;
    }

    // Método para evaluar productos y divisiones dentro de un sumando
    public static double evaluarProducto(String expr) {
        String[] factores;
        double resultado = 1;

        // Si hay división, la procesamos con prioridad
        if (expr.contains("/")) {
            factores = expr.split("/");
            // Evaluamos el primer factor
            resultado = evaluarFactor(factores[0]);
            // Dividimos por los factores siguientes
            for (int i = 1; i < factores.length; i++) {
                resultado /= evaluarFactor(factores[i]);
            }
        } else if (expr.contains("*")) {
            // Si hay multiplicación, procesamos cada factor
            factores = expr.split("\\*");
            for (String f : factores) {
                resultado *= evaluarFactor(f);
            }
        } else {
            // Si no hay * ni /, evaluamos directamente
            resultado = evaluarFactor(expr);
        }
        return resultado;
    }
    // Método para evaluar un factor (número o expresión simple)
    public static double evaluarFactor(String expr) {
        // Quitamos espacios al inicio y final
        expr = expr.trim();
        
        // Eliminamos paréntesis externos si los hay
        while (expr.startsWith("(") && expr.endsWith(")")) {
            expr = expr.substring(1, expr.length() - 1).trim();
        }
        
        // Quitamos signos + al inicio si son redundantes
        while (expr.startsWith("+")) {
            expr = expr.substring(1).trim();
        }
        
        // Si la expresión está vacía, devolvemos 0
        if (expr.isEmpty()) return 0;
        
        // Intentamos convertir la expresión a número
        try {
            return Double.parseDouble(expr);
        } catch (NumberFormatException e) {
            // Si falla, mostramos error y devolvemos 0
            System.out.println("Error al evaluar factor: " + expr);
            return 0;
        }
    }
    // Método que implementa el algoritmo de Runge-Kutta de 4to orden
    public static double rungeKutta(String funcion, double x0, double y0, double h, int pasos) {
        double x = x0;
        double y = y0;

        // Iteramos según el número de pasos
        for (int i = 0; i < pasos; i++) {
            // Calculamos los coeficientes k1, k2, k3, k4
            double k1 = h * evaluarFuncion(funcion, x, y);
            double k2 = h * evaluarFuncion(funcion, x + h / 2.0, y + k1 / 2.0);
            double k3 = h * evaluarFuncion(funcion, x + h / 2.0, y + k2 / 2.0);
            double k4 = h * evaluarFuncion(funcion, x + h, y + k3);

            // Actualizamos y con la fórmula de Runge-Kutta
            y += (k1 + 2*k2 + 2*k3 + k4) / 6.0;
            // Avanzamos x según el tamaño del paso
            x += h;

            // Mostramos el resultado de cada paso
            System.out.printf("Paso %d: x = %.5f, y = %.5f\n", i + 1, x, y);
        }
        return y;
    }
    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos al usuario los datos de entrada
        System.out.println("Método Runge-Kutta sin ScriptEngine, funciones básicas");
        System.out.print("Ingresa la función f(x,y) (ejemplo: x + y, sin(x) - y, x * y): ");
        String funcion = sc.nextLine();

        System.out.print("Ingresa x0: ");
        double x0 = sc.nextDouble();

        System.out.print("Ingresa y0: ");
        double y0 = sc.nextDouble();

        System.out.print("Ingresa paso h: ");
        double h = sc.nextDouble();

        System.out.print("Número de pasos: ");
        int pasos = sc.nextInt();

        // Ejecutamos Runge-Kutta y mostramos el resultado final
        double resultado = rungeKutta(funcion, x0, y0, h, pasos);
        System.out.printf("Resultado final: y(%.5f) = %.5f\n", x0 + pasos * h, resultado);
        
        // Cerramos el scanner
        sc.close();
    }
}
```
---

## 📝 Recomendaciones

- 📌 Ajuste el tamaño del paso $h$ para equilibrar precisión y costo computacional.
- ✅ Verifique la estabilidad del método para EDOs rígidas.
- 📊 Compare los resultados con soluciones analíticas cuando estén disponibles.
- ⚠️ Evite tamaños de paso grandes en problemas no lineales para minimizar errores.
