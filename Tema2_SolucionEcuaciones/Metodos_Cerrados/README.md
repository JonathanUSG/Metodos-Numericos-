# 📌 Métodos Cerrados para la Solución de Ecuaciones

Los métodos cerrados requieren un intervalo $[a, b]$ donde se garantice que exista una raíz, es decir, que $f(a) \cdot f(b) < 0$. Son conocidos por su **convergencia segura**, aunque lenta.

---

## Método de Bisección

### Descripción
Consiste en dividir a la mitad el intervalo $[a, b]$ y seleccionar la subparte donde cambie el signo de la función.

### 📐 Fórmula
$$
x_r = \frac{a + b}{2}
$$

### Ventajas
- Convergencia garantizada si $f(a) \cdot f(b) < 0$.
- Método robusto y fácil de implementar.

### Desventajas
- Convergencia lenta.
- No considera la forma de la función.

---

## Método de Regla Falsa (Falsa Posición)

### Descripción
Similar al de bisección, pero usa una línea recta para aproximar la raíz entre los puntos extremos del intervalo.

### Fórmula
$$
x_r = b - \frac{f(b)(a - b)}{f(a) - f(b)}
$$

### Ventajas
- Más rápido que la bisección en muchos casos.
- Requiere mismo criterio de $f(a) \cdot f(b) < 0$.

### Desventajas
- Puede estancarse si la forma de la función es desfavorable.
