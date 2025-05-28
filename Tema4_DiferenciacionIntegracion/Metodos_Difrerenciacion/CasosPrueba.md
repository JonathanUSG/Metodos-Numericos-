---

# 🧮 Pruebas para Métodos de Diferenciación Numérica

---

## ✅ Método de los **Cinco Puntos**

### Función evaluada:

> **f(x) = x · sin(x)**

### Parámetros:

* x = 1
* h = 0.1

---

### ✔ Caso de prueba válido

#### Paso 1: Evaluaciones

* f(x + 2h) = f(1.2) ≈ 1.2 · sin(1.2) ≈ 1.2 · 0.9320 ≈ **1.1184**
* f(x + h)  = f(1.1) ≈ 1.1 · sin(1.1) ≈ 1.1 · 0.8912 ≈ **0.9803**
* f(x − h)  = f(0.9) ≈ 0.9 · sin(0.9) ≈ 0.9 · 0.7833 ≈ **0.7050**
* f(x − 2h) = f(0.8) ≈ 0.8 · sin(0.8) ≈ 0.8 · 0.7174 ≈ **0.5739**

#### Paso 2: Sustitución en la fórmula

$$
f'(x) ≈ \frac{-f(x+2h) + 8f(x+h) - 8f(x-h) + f(x-2h)}{12h}
$$

* Numerador:
  −1.1184 + 8(0.9803) − 8(0.7050) + 0.5739
  \= −1.1184 + 7.8424 − 5.6400 + 0.5739
  \= **1.6579**

* Denominador:
  12 · 0.1 = **1.2**

#### Resultado final:

$$
f'(1) ≈ \frac{1.6579}{1.2} ≈ \mathbf{1.3816}
$$

**📤 Salida esperada en consola:**

```
Función: x * sin(x)
Punto de Derivación: 1.0
Resultado de la Derivada por el método de los Cinco Puntos: 1.382
```

---

### ❌ Caso que no funciona (x = 0.05)

> Muy cercano a cero: no hay suficientes valores "anteriores" para evaluar la fórmula con x − 2h.

* h = 0.1
* x − 2h = 0.05 − 0.2 = **−0.15** → fuera de dominio si no se permite x < 0
* Resultado: Puede producir errores o resultados inexactos por aproximación asimétrica

**📤 Salida incorrecta esperada en consola:**

```
Función: x * sin(x)
Punto de Derivación: 0.05
Resultado de la Derivada por el método de los Cinco Puntos: [valor impreciso o error]
```

---

## ✅ Método de los **Tres Puntos**

### Función evaluada:

> **f(x) = x · sin(x)**

### Parámetros:

* x = 1
* h = 0.1

---

### ✔ Caso de prueba válido

#### Paso 1: Evaluaciones

* f(x + h) = f(1.1) ≈ 1.1 · sin(1.1) ≈ 1.1 · 0.8912 ≈ **0.9803**
* f(x − h) = f(0.9) ≈ 0.9 · sin(0.9) ≈ 0.9 · 0.7833 ≈ **0.7050**

#### Paso 2: Aplicación de la fórmula

$$
f'(x) ≈ \frac{f(x + h) - f(x - h)}{2h}
$$

* Numerador:
  0.9803 − 0.7050 = **0.2753**

* Denominador:
  2 · 0.1 = **0.2**

#### Resultado final:

$$
f'(1) ≈ \frac{0.2753}{0.2} ≈ \mathbf{1.3765}
$$

**📤 Salida esperada en consola:**

```
Función: x * sin(x)
Punto de derivación: 1.0
Tamaño del Paso: 0.1
Resultado de la derivada por el método de los Tres puntos: 1.38
```

---

### ❌ Caso que no funciona (h muy grande: h = 1)

> h = 1 separa los puntos demasiado, lo que da una aproximación muy pobre

* f(2) ≈ 2 · sin(2) ≈ 2 · 0.9093 ≈ **1.8186**
* f(0) = 0 · sin(0) = **0**

$$
f'(1) ≈ \frac{1.8186 - 0}{2 \cdot 1} = 0.9093
$$

> El valor esperado real de la derivada es ≈ 1.3817 → Error alto

**📤 Salida incorrecta esperada en consola:**

```
Función: x * sin(x)
Punto de derivación: 1.0
Tamaño del Paso: 1.0
Resultado de la derivada por el método de los Tres puntos: 0.909
```

---
