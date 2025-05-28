# ✅ Casos de Prueba para Métodos Abiertos

Este documento presenta dos casos de prueba: uno válido y uno inválido, aplicados a los métodos de **Punto Fijo**, **Secante** y **Newton-Raphson**, usando la función:

$$
f(x) = x^3 - x - 2
$$

---

## 🔹 Método de Punto Fijo

### ✔️ Caso Válido

**Parámetros:**

* Valor inicial: \$( x\_0 = 1.5 \$)
* Tolerancia: \$( \varepsilon = 0.01 \$)
* Función \$g(x)\$: \$g(x) = \sqrt\[3]{x + 2}\$

**Justificación:**

$$
g'(x) = \frac{1}{3(x + 2)^{2/3}},\quad g'(1.523) \approx 0.18 < 1 \Rightarrow \text{Converge}
$$

### Iteraciones:

| Iter | xₙ    | xₙ₊₁  | f(xₙ₊₁) |
| ---- | ----- | ----- | ------- |
| 0    | 1.500 | 1.516 | -0.034  |
| 1    | 1.516 | 1.523 | 0.012   |
| 2    | 1.523 | 1.521 | -0.003  |

**Resultado esperado:**
Raíz aproximada en \$( x \approx 1.521 \$) con \$( \varepsilon = 0.01 \$)

---

### Salida de Consola:

```java
Método de Punto Fijo
Ingrese el valor inicial x0: 1.5
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
Iteración 0: x = 1.500000, x1 = 1.515717, f(x1) = -0.034283
Iteración 1: x = 1.515717, x1 = 1.523409, f(x1) = 0.012250
Iteración 2: x = 1.523409, x1 = 1.521203, f(x1) = -0.003105
Raíz aproximada: 1.5212
```

---

### ❌ Caso Inválido

**Parámetros:**

* Valor inicial: \$( x\_0 = 0 \$)
* Función \$g(x)\$: \$g(x) = x^2 + 2\$

**Justificación:**

$$
g'(x) = 2x,\quad g'(0) = 0,\quad \text{pero }\lim_{x \to \infty} g(x) \to \infty \Rightarrow \text{No converge}
$$

**Resultado esperado:**

> Error: No se garantiza convergencia. El método no debe usarse con esta \$g(x)\$.

---

### Salida de Consola:

```java
Método de Punto Fijo
Ingrese el valor inicial x0: 0
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
Iteración 0: x = 0.000000, x1 = 2.000000, f(x1) = 2.000000
Iteración 1: x = 2.000000, x1 = 6.000000, f(x1) = 42.000000
Iteración 2: x = 6.000000, x1 = 38.000000, f(x1) = 54716.000000
...
El método diverge. No se puede encontrar la raíz.
```

---

## 🔹 Método de la Secante

### ✔️ Caso Válido

**Parámetros:**

* Valores iniciales: \$( x\_0 = 1,\ x\_1 = 2 \$)
* Tolerancia: \$( \varepsilon = 0.01 \$)

### Iteraciones (fórmula: \$( x\_n = x\_1 - f(x\_1)\cdot\frac{x\_1 - x\_0}{f(x\_1) - f(x\_0)} \$)):

| Iter | xₙ₋₁  | xₙ    | xₙ₊₁  | f(xₙ₊₁) |
| ---- | ----- | ----- | ----- | ------- |
| 0    | 1.000 | 2.000 | 1.333 | -0.963  |
| 1    | 2.000 | 1.333 | 1.463 | -0.333  |
| 2    | 1.333 | 1.463 | 1.504 | -0.101  |
| 3    | 1.463 | 1.504 | 1.519 | -0.027  |
| 4    | 1.504 | 1.519 | 1.523 | -0.008  |

**Resultado esperado:**
Raíz aproximada en \$( x \approx 1.523 \$) con \$( \varepsilon = 0.01 \$)

---

### Salida de Consola:

```java
Método de la Secante
Ingrese x0: 1
Ingrese x1: 2
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
Iteración 0: x = 1.333333, f(x) = -0.962963
Iteración 1: x = 1.462687, f(x) = -0.333302
Iteración 2: x = 1.504045, f(x) = -0.100693
Iteración 3: x = 1.519171, f(x) = -0.027583
Iteración 4: x = 1.523611, f(x) = -0.007857
Raíz aproximada: 1.5236
```

---

### ❌ Caso Inválido

**Parámetros:**

* Valores iniciales: \$( x\_0 = 1,\ x\_1 = 1 \$)

**Justificación:**

$$
x_0 = x_1 \Rightarrow \text{Denominador cero en fórmula. No se puede aplicar.}
$$

**Resultado esperado:**

> Error: División por cero. Los valores iniciales deben ser distintos.

---

### Salida de Consola:

```java
Método de la Secante
Ingrese x0: 1
Ingrese x1: 1
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
Error: División por cero. x0 y x1 no deben ser iguales.
```

---

## 🔹 Método de Newton-Raphson

### ✔️ Caso Válido

**Parámetros:**

* Valor inicial: \$( x\_0 = 1.5 \$)
* Tolerancia: \$( \varepsilon = 0.01 \$)
* \$f(x) = x^3 - x - 2,\quad f'(x) = 3x^2 - 1\$

### Iteraciones (fórmula: \$( x\_{n+1} = x\_n - \frac{f(x\_n)}{f'(x\_n)} \$)):

| Iter | xₙ     | f(xₙ)  | f'(xₙ) | xₙ₊₁   |
| ---- | ------ | ------ | ------ | ------ |
| 0    | 1.500  | -0.125 | 5.75   | 1.5217 |
| 1    | 1.5217 | 0.0021 | 5.948  | 1.5214 |

**Resultado esperado:**
Raíz aproximada en \$( x \approx 1.521 \$) con \$( \varepsilon = 0.01 \$)

---

### Salida de Consola:

```java
Método de Newton-Raphson
Ingrese el valor inicial x0: 1.5
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
Iteración 0: x = 1.500000, f(x) = -0.125000, f'(x) = 5.750000, x1 = 1.521739
Iteración 1: x = 1.521739, f(x) = 0.002058, f'(x) = 5.948520, x1 = 1.521379
Raíz aproximada: 1.5214
```

---

### ❌ Caso Inválido

**Parámetros:**

* Valor inicial: \$( x\_0 = 0.577 \$)

**Justificación:**

$$
f'(x) = 3x^2 - 1,\quad f'(0.577) \approx 0 \Rightarrow \text{División por cero}
$$

**Resultado esperado:**

> Error: Derivada cercana a cero. No se puede aplicar el método.

---

### Salida de Consola:

```java
Método de Newton-Raphson
Ingrese el valor inicial x0: 0.577
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
Error: f'(x) muy cercano a cero. No se puede aplicar el método.
```

---
