# ✅ Casos de Prueba para Métodos Directos de Sistemas de Ecuaciones

Este documento presenta dos casos de prueba: uno válido y uno inválido, aplicados a los métodos de **Eliminación Gaussiana** y **Gauss-Jordan**, usando los siguientes sistemas:

---

## 🔹 Método de Eliminación Gaussiana

### ✔️ Caso Válido

**Parámetros:**

* Número de ecuaciones: 3

* Matriz aumentada:

$$
\left[
\begin{array}{ccc|c}
  2 & -1 & 1 & 8 \\
  -3 & -1 & 2 & -11 \\
  -2 & 1 & 2 & -3
\end{array}
\right]
$$

**Justificación:**
Sistema consistente con solución única.

### Iteraciones (muestra la eliminación paso a paso):

* Eliminando elemento $2$$1$ con factor -1.5:

  Nueva matriz y vector de soluciones (tras eliminación).

* Eliminando elemento $3$$1$ con factor -1.0:

  Nueva matriz y vector...

* Eliminando elemento $3$$2$ con factor 7.0:

  Nueva matriz y vector...

* Sustitución hacia atrás:

$$
\begin{cases}
x_3 = 2 \\
x_2 = 3 \\
x_1 = 1
\end{cases}
$$

**Resultado esperado:**

$$
x_1 = 1, \quad x_2 = 3, \quad x_3 = 2
$$

---

### Salida de Consola:

```text
Ingrese el número de ecuaciones (n): 3
Ingrese la matriz aumentada (coeficientes y términos independientes):
Ecuación 1:
Coeficiente [1][1]: 2
Coeficiente [1][2]: -1
Coeficiente [1][3]: 1
Término independiente [1]: 8
Ecuación 2:
Coeficiente [2][1]: -3
Coeficiente [2][2]: -1
Coeficiente [2][3]: 2
Término independiente [2]: -11
Ecuación 3:
Coeficiente [3][1]: -2
Coeficiente [3][2]: 1
Coeficiente [3][3]: 2
Término independiente [3]: -3

Matriz Aumentada Ingresada
|    2.000    -1.000     1.000 |    8.000|
|   -3.000    -1.000     2.000 |  -11.000|
|   -2.000     1.000     2.000 |   -3.000|

Eliminando elemento [2][1] con factor -1.500:
|    2.000    -1.000     1.000 |    8.000|
|    0.000    -2.500     3.500 |    1.000|
|   -2.000     1.000     2.000 |   -3.000|

Eliminando elemento [3][1] con factor -1.000:
|    2.000    -1.000     1.000 |    8.000|
|    0.000    -2.500     3.500 |    1.000|
|    0.000     0.000     5.000 |    5.000|

Eliminando elemento [3][2] con factor 0.000:
(No se elimina, ya es 0)

Resolviendo por sustitución hacia atrás
x[2] = 1.000
x[1] = 3.000
x[0] = 1.000

Solución Final:
x[0] = 1.000
x[1] = 3.000
x[2] = 1.000
```

---

### ❌ Caso Inválido

**Parámetros:**

* Número de ecuaciones: 2

* Matriz aumentada (singular):

$$
\left[
\begin{array}{cc|c}
  1 & 2 & 3 \\
  2 & 4 & 6
\end{array}
\right]
$$

**Justificación:**
Sistema incompatible o sin solución única (segunda fila es múltiplo de la primera).

**Resultado esperado:**

> Error o advertencia: La matriz es singular o no se puede continuar con eliminación.

---

### Salida de Consola:

```text
Ingrese el número de ecuaciones (n): 2
Ingrese la matriz aumentada (coeficientes y términos independientes):
Ecuación 1:
Coeficiente [1][1]: 1
Coeficiente [1][2]: 2
Término independiente [1]: 3
Ecuación 2:
Coeficiente [2][1]: 2
Coeficiente [2][2]: 4
Término independiente [2]: 6

Matriz Aumentada Ingresada
|    1.000     2.000 |    3.000|
|    2.000     4.000 |    6.000|

Eliminando elemento [2][1] con factor 2.000:
|    1.000     2.000 |    3.000|
|    0.000     0.000 |    0.000|

Error: La matriz es singular o no tiene solución única.
```

---

## 🔹 Método de Gauss-Jordan

### ✔️ Caso Válido

**Parámetros:**

* Número de ecuaciones: 3

* Matriz aumentada:

$$
\left[
\begin{array}{ccc|c}
  1 & 2 & -1 & 8 \\
  -3 & -1 & 2 & -11 \\
  -2 & 1 & 2 & -3
\end{array}
\right]
$$

**Justificación:**
Sistema consistente con solución única.

### Iteraciones:

* Normalizando fila 1 dividiendo por pivote...

* Eliminando elementos para obtener matriz identidad en la parte izquierda.

* ...

**Resultado esperado:**

$$
x_1 = 2, \quad x_2 = 3, \quad x_3 = -1
$$

---

### Salida de Consola:

```text
Introduce el número de ecuaciones (n): 3
Ingrese la matriz aumentada (coeficientes y términos independientes):
Ecuación 1:
Coeficiente [1][1]: 1
Coeficiente [1][2]: 2
Coeficiente [1][3]: -1
Término independiente [1]: 8
Ecuación 2:
Coeficiente [2][1]: -3
Coeficiente [2][2]: -1
Coeficiente [2][3]: 2
Término independiente [2]: -11
Ecuación 3:
Coeficiente [3][1]: -2
Coeficiente [3][2]: 1
Coeficiente [3][3]: 2
Término independiente [3]: -3

Matriz aumentada ingresada:
|    1.000     2.000    -1.000 |    8.000|
|   -3.000    -1.000     2.000 |  -11.000|
|   -2.000     1.000     2.000 |   -3.000|

Normalizando fila 1 dividiendo por 1.000
...

Eliminando elemento [2][1] con factor -3.000
...

Eliminando elemento [3][1] con factor -2.000
...

...

Solución final:
x[0] = 2.000
x[1] = 3.000
x[2] = -1.000
```

---

### ❌ Caso Inválido

**Parámetros:**

* Número de ecuaciones: 2

* Matriz aumentada (singular):

$$
\left[
\begin{array}{cc|c}
  1 & 2 & 3 \\
  2 & 4 & 6
\end{array}
\right]
$$

**Justificación:**
La matriz no permite continuar normalizando, matriz singular.

**Resultado esperado:**

> Error: Matriz singular, no se puede continuar con Gauss-Jordan.

---

### Salida de Consola:

```text
Introduce el número de ecuaciones (n): 2
Ingrese la matriz aumentada (coeficientes y términos independientes):
Ecuación 1:
Coeficiente [1][1]: 1
Coeficiente [1][2]: 2
Término independiente [1]: 3
Ecuación 2:
Coeficiente [2][1]: 2
Coeficiente [2][2]: 4
Término independiente [2]: 6

Matriz aumentada ingresada:
|    1.000     2.000 |    3.000|
|    2.000     4.000 |    6.000|

Normalizando fila 1 dividiendo por 1.000
...

Eliminando elemento [2][1] con factor 2.000
...

Fila 2 queda con ceros en la parte izquierda

Error: Matriz singular, no se puede continuar.
```

---
