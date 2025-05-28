
# 🧮 Casos de Prueba para Métodos de Interpolación

---

## ✅ Interpolación Lineal

### Función evaluada (implícita):

> Entre puntos (2, 4) y (4, 16), interpolamos en x = 3.

---

### ✔ Caso de prueba válido

#### Parámetros:

* Puntos conocidos: (x0, y0) = (2, 4), (x1, y1) = (4, 16)
* Valor a interpolar: xBuscado = 3
* Valor real: 9 (asumiendo f(x) = x²)

#### Cálculo:

Interpolación lineal:

$$
y = y_0 + \frac{y_1 - y_0}{x_1 - x_0} (x - x_0) = 4 + \frac{16 - 4}{4 - 2} (3 - 2) = 4 + 6 = 10
$$

Errores:

* Error absoluto = |9 - 10| = 1
* Error porcentual = (1/9) \* 100 ≈ 11.11%

**📤 Salida en consola:**

```
Valor interpolado en x = 3.0: 10.0000
Error Absoluto: 1.0000
Error Porcentual: 11.11%
Puntos Utilizados:
x0 = 2.0, y0 = 4.0
x1 = 4.0, y1 = 16.0
```

---

### ❌ Caso que no funciona (x0 = x1)

> Los puntos conocidos tienen la misma x, lo que provoca división por cero y no permite la interpolación lineal.

#### Parámetros:

* (x0, y0) = (2, 4), (x1, y1) = (2, 16)
* xBuscado = 3

#### Comportamiento esperado:

El cálculo

$$
\frac{y_1 - y_0}{x_1 - x_0} = \frac{16 - 4}{2 - 2} = \frac{12}{0}
$$

es una división por cero que lanzará excepción o error en tiempo de ejecución, sin resultado numérico.

**📤 Salida de consola:**

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

O el programa se detiene sin imprimir resultado.

---

## ✅ Interpolación Polinómica (Lagrange)

### Función evaluada (implícita):

> Para puntos (1, 1), (2, 8), (3, 27) que parecen seguir f(x) = x³, interpolamos en x = 2.5.

---

### ✔ Caso de prueba válido

#### Parámetros:

* Puntos conocidos: (1, 1), (2, 8), (3, 27)
* Valor a interpolar: xBuscado = 2.5
* Valor real: 15.625 (2.5³)

#### Cálculo (aproximado):

El polinomio pasa por los puntos, por lo que la interpolación en 2.5 debe dar muy cercano a 15.625.

Errores:

* Error absoluto: valor real - interpolado (muy cercano a 0)
* Error porcentual: cercano a 0%

**📤 Salida de consola:**

```
Valor Interpolado en x = 2.5: 15.6250
Cuota de error estimada: 0.0000
Error Porcentual: 0.00%
Puntos Utilizados:
x = 1.0, y = 1.0
x = 2.0, y = 8.0
x = 3.0, y = 27.0
```

---

### ❌ Caso que no funciona (puntos con x repetidos)

> Si existen puntos con la misma x pero distinto y, la fórmula del polinomio de Lagrange genera división por cero.

#### Parámetros:

* x = {1, 2, 2}
* y = {1, 8, 16}
* xBuscado = 2.5

#### Comportamiento esperado:

El cálculo para i=1 o i=2 tendrá denominadores (x\[i] - x\[j]) = (2 - 2) = 0, lo que provoca división por cero y no se puede evaluar.

**📤 Salida de consola:**

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```
---
