# ✅ Casos de Prueba para Métodos de Integración de Sistemas de Ecuaciones

Este documento presenta dos casos de prueba: uno válido y uno inválido, aplicados a los métodos de **Trapecio**, **Simpson 1/3**, **Simpson 3/8** y **Cuadratura Gaussiana** usando los siguientes ejercicios:

---
## ✅ Método del Trapecio

### ✔️ Caso válido:

* Función: `x * sin(x)`
* Intervalo: \[0, 2]
* Segmentos: 4

#### 🧠 Resolución Manual:

* `h = (2 - 0) / 4 = 0.5`
* `x: 0, 0.5, 1.0, 1.5, 2.0`
* f(x):
  `f(0) = 0`
  `f(0.5) ≈ 0.2397`
  `f(1.0) ≈ 0.8414`
  `f(1.5) ≈ 1.4975`
  `f(2.0) ≈ 1.8186`
* suma ≈ `(0 + 1.8186)/2 + 0.2397 + 0.8414 + 1.4975 ≈ 0.9093 + 0.2397 + 0.8414 + 1.4975 ≈ 3.4879`
* Resultado ≈ `h \* suma = 0.5 \* 3.4879 = **1.7439** `

#### 💻 Salida esperada:

```plaintext
Función: x * sin(x)
Límite Inferior: 0
Límite Superior: 2
Número de Segmentos: 4
Resultado de la integral por el método del Trapecio: 1.744
```

### ❌ Caso erróneo:

* Cambiar `n = 0` (segmentos = 0)

#### 💥 Error:

```plaintext
ArithmeticException: / by zero
```

---

## ✅ Método de Simpson 1/3

### ✔️ Caso válido:

* Intervalo: \[0, 2], Segmentos: 4

#### 🧠 Resolución Manual:

* h = 0.5
* Puntos x: 0, 0.5, 1.0, 1.5, 2.0
* f(x):
  f(0) = 0
  f(0.5) ≈ 0.2397
  f(1.0) ≈ 0.8414
  f(1.5) ≈ 1.4975
  f(2.0) ≈ 1.8186
* Fórmula:
  suma = `f(0) + 4f(0.5) + 2f(1.0) + 4f(1.5) + f(2.0)`
  `≈ 0 + 4(0.2397) + 2(0.8414) + 4(1.4975) + 1.8186`
  `≈ 0 + 0.9588 + 1.6828 + 5.99 + 1.8186 = 10.45`
* Resultado ≈ `(h/3) \* suma = (0.5/3)\*10.45 ≈ **1.7417**`

#### 💻 Salida esperada:

```plaintext
Función; x * sin(x)
Límite inferior 0
Límite Superior: 2
Número deSegementos: 4
Resultado de la Integral por el método de Simpson 1/3: 1.742
```

### ❌ Caso erróneo:

* Usar `n = 5` (impar)

#### 💥 Error:

```plaintext
IllegalArgumentException: n debe ser un número par
```

---

## ✅ Método de Simpson 3/8

### ✔️ Caso válido:

* Intervalo: \[0, 2], Segmentos: 6 (múltiplo de 3)

#### 🧠 Resolución Manual:

* `h = (2 - 0) / 6 = 0.3333`
* `x: 0, 0.333, 0.667, 1, 1.333, 1.667, 2`
* f(x) evaluada y con coeficientes:
  `f(0) + 3f(0.333) + 3f(0.667) + 2f(1) + 3f(1.333) + 3f(1.667) + f(2) ≈ 11.634`
* `Resultado ≈ (3h/8) \* suma = (1/8) \* 11.634 = **1.4542**`

#### 💻 Salida esperada:

```plaintext
Función: x * sin(x)
Límite Inferior: 0
Límite Superior: 2
Número de Segmentos: 6
Resultado de la Integral por el método de Simpson 3/8: 1.454
```

### ❌ Caso erróneo:

* Usar `n = 5` (no múltiplo de 3)

#### 💥 Error:

```plaintext
IllegalArgumentException: n debe ser múltiplo de 3
```

---

## ✅ Método de Cuadratura Gaussiana (2 puntos)

### ✔️ Caso válido:

* Intervalo: \[0, 2]

#### 🧠 Resolución Manual:

* t1 = -0.577350269, t2 = 0.577350269
* Transformación a \[0, 2]:
  x1 = `(2-0)/2 \* t1 + (2+0)/2 ≈ 0.4226`
  `x2 ≈ 1.5774`
* Evaluar f(x):
  `f(0.4226) ≈ 0.1732`
  `f(1.5774) ≈ 1.566`
* Resultado ≈ `(b-a)/2 \* (f(x1) + f(x2)) ≈ 1 \* (0.1732 + 1.566) = **1.739**`

#### 💻 Salida esperada:

```plaintext
Función: x * sin(x)
Límite Inferior: 0
Límite Superior: 2
Número de Segementos: 4
Resultado de la Integral por el método de Cuadratura Gaussiana: 1.739
```

### ❌ Caso erróneo:

* No hay validación de segmentos `n`, aunque en consola se menciona, **no se usa en el método**, así que cambiar `n = -2` no afectará el cálculo pero **sí es inconsistente** con la impresión.
