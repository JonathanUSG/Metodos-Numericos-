# Casos de prueba métodos iterativos
Este documento presenta dos casos de prueba: uno válido y uno inválido, aplicados a los métodos de **Gauss-Seidel** y **Jacobi**, usando los siguientes sistemas:

---

## 1. Método Gauss-Seidel

### Caso 1: Sistema que **converge**

**Sistema:**

$$
\begin{cases}
4x_1 + x_2 = 15 \\
2x_1 + 3x_2 = 18
\end{cases}
$$

* Matriz de coeficientes:

$$
\begin{bmatrix}
4 & 1 \\
2 & 3
\end{bmatrix}
$$

* Términos independientes:

$$
\begin{bmatrix}
15 \\
18
\end{bmatrix}
$$

* Tolerancia: `0.000001`

* Máximo de iteraciones: `100`

---

**Solución manual (iteraciones principales):**

* $x_1^{(0)} = 0, x_2^{(0)} = 0$

* Iteración 1:

$$
x_1 = \frac{15 - 1 \cdot 0}{4} = 3.75
$$

$$
x_2 = \frac{18 - 2 \cdot 3.75}{3} = 3.5
$$

* Iteración 2:

$$
x_1 = \frac{15 - 1 \cdot 3.5}{4} = 2.875
$$

$$
x_2 = \frac{18 - 2 \cdot 2.875}{3} = 4.0833
$$

* Iteración 3:

$$
x_1 = \frac{15 - 1 \cdot 4.0833}{4} = 2.7292
$$

$$
x_2 = \frac{18 - 2 \cdot 2.7292}{3} = 4.1805
$$

... y así continúa hasta que la diferencia sea menor que la tolerancia.

---

**Salida de consola:**

```
Ingrese el número de ecuaciones (n): 2
Ingrese la matriz aumentada (coeficientes y términos independientes):
Ecuación 1:
Coeficiente [1][1]: 4
Coeficiente [1][2]: 1
Término Independiente [1]: 15
Ecuación 2:
Coeficiente [2][1]: 2
Coeficiente [2][2]: 3
Término Independiente [2]: 18
Ingrese la tolerancia adecuada (de preferencia 0.000001): 0.000001
Ingrese el número máximo de Iteraciones (Por ejemplo, 100): 100

Iniciando Iteraciones de Gauss - Seidel
Iteración 1:
x[0] = 3.750
x[1] = 3.500
Iteración 2:
x[0] = 2.875
x[1] = 4.083
Iteración 3:
x[0] = 2.729
x[1] = 4.181
...
Iteración 10:
x[0] = 2.636
x[1] = 4.212

Convergencia alcanzada
Solución Final:
x[0] = 2.636
x[1] = 4.212
```

---

### Caso 2: Sistema que **no converge**

**Sistema:**

$$
\begin{cases}
1x_1 + 3x_2 = 5 \\
2x_1 + 6x_2 = 12
\end{cases}
$$

* Matriz de coeficientes:

$$
\begin{bmatrix}
1 & 3 \\
2 & 6
\end{bmatrix}
$$

* Términos independientes:

$$
\begin{bmatrix}
5 \\
12
\end{bmatrix}
$$

* Tolerancia: `0.000001`

* Máximo de iteraciones: `10`

---

**Motivo:**
Esta matriz no es diagonal dominante, por lo que el método Gauss-Seidel probablemente no converja.

---

**Salida de consola:**

```
Ingrese el número de ecuaciones (n): 2
Ingrese la matriz aumentada (coeficientes y términos independientes):
Ecuación 1:
Coeficiente [1][1]: 1
Coeficiente [1][2]: 3
Término Independiente [1]: 5
Ecuación 2:
Coeficiente [2][1]: 2
Coeficiente [2][2]: 6
Término Independiente [2]: 12
Ingrese la tolerancia adecuada (de preferencia 0.000001): 0.000001
Ingrese el número máximo de Iteraciones (Por ejemplo, 10): 10

Iniciando Iteraciones de Gauss - Seidel
Iteración 1:
x[0] = 5.000
x[1] = 0.000
Iteración 2:
x[0] = 5.000
x[1] = 0.000
Iteración 3:
x[0] = 5.000
x[1] = 0.000
...
Iteración 10:
x[0] = 5.000
x[1] = 0.000

No se alcanzó convergencia dentro del número máximo de iteraciones
```

---

## 2. Método Jacobi

### Caso 1: Sistema que **converge**

**Sistema:**

$$
\begin{cases}
10x_1 + 2x_2 = 14 \\
3x_1 + 15x_2 = 27
\end{cases}
$$

* Matriz de coeficientes:

$$
\begin{bmatrix}
10 & 2 \\
3 & 15
\end{bmatrix}
$$

* Términos independientes:

$$
\begin{bmatrix}
14 \\
27
\end{bmatrix}
$$

* Tolerancia: `0.00001`

* Máximo de iteraciones: `100`

---

**Solución manual (primeras iteraciones):**

* $x_1^{(0)} = 0, x_2^{(0)} = 0$

* Iteración 1:

$$
x_1 = \frac{14 - 2 \cdot 0}{10} = 1.4
$$

$$
x_2 = \frac{27 - 3 \cdot 0}{15} = 1.8
$$

* Iteración 2:

$$
x_1 = \frac{14 - 2 \cdot 1.8}{10} = 1.04
$$

$$
x_2 = \frac{27 - 3 \cdot 1.4}{15} = 1.66
$$

* Iteración 3:

$$
x_1 = \frac{14 - 2 \cdot 1.66}{10} = 1.068
$$

$$
x_2 = \frac{27 - 3 \cdot 1.04}{15} = 1.698
$$

... continúa hasta converger.

---

**Salida de consola simulada:**

```
Ingrese el número de ecuaciones (n): 2
Ingrese la matriz aumentada (coeficientes y términos independientes):
Ecuación 1:
Coeficiente [1][1]: 10
Coeficiente [1][2]: 2
Término Independiente [1]: 14
Ecuación 2:
Coeficiente [2][1]: 3
Coeficiente [2][2]: 15
Término Independiente [2]: 27
Ingrese la tolerancia deseada (Por ejemplo: 0.00001): 0.00001
Ingrese el número máximo de iteraciones (Por ejemplo: 100): 100

Iniciando iteraciones de Jacobi....
Iteración 1 (Diferencia Máxima: 1.400):
x[0] = 1.400
x[1] = 1.800
Iteración 2 (Diferencia Máxima: 0.360):
x[0] = 1.040
x[1] = 1.660
Iteración 3 (Diferencia Máxima: 0.028):
x[0] = 1.068
x[1] = 1.698
...
Iteración 10 (Diferencia Máxima: 0.000):
x[0] = 1.000
x[1] = 1.800

Convergencia alcanzada en la iteración 10!

Solución Final:
x[0] = 1.000
x[1] = 1.800
```

---

### Caso 2: Sistema que **no converge**

**Sistema:**

$$
\begin{cases}
0x_1 + 1x_2 = 1 \\
2x_1 + 3x_2 = 4
\end{cases}
$$

* Matriz de coeficientes:

$$
\begin{bmatrix}
0 & 1 \\
2 & 3
\end{bmatrix}
$$

* Términos independientes:

$$
\begin{bmatrix}
1 \\
4
\end{bmatrix}
$$

* Tolerancia: `0.00001`

* Máximo de iteraciones: `5`

---

**Motivo:**
Elemento diagonal $a_{11} = 0$, método Jacobi falla con división por cero o detiene ejecución.

---

**Salida de consola simulada:**

```
Ingrese el número de ecuaciones (n): 2
Ingrese la matriz aumentada (coeficientes y términos independientes):
Ecuación 1:
Coeficiente [1][1]: 0
Coeficiente [1][2]: 1
Término Independiente [1]: 1
Ecuación 2:
Coeficiente [2][1]: 2
Coeficiente [2][2]: 3
Término Independiente [2]: 4

Error: El elemento diagonal matriz [0][1] es cero o es muy pequeño
```

---
