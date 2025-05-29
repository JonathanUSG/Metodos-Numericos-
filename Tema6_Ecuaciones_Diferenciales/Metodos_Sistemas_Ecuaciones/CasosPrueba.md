# ✅ Casos de Prueba para Método de Euler para resolver Ecuaciones Diferenciales:
Este documento presenta dos casos de prueba: uno válido y uno inválido, aplicados al método de Euler para resolver ecuaciones diferenciales:

---
## ✅ Ejercicio donde **sí funciona** el método

Este ejercicio usa un intervalo pequeño y un sistema suave, lo cual favorece la estabilidad del método de Euler.

### **Planteamiento:**

Resolver el sistema:

$$
\frac{dy}{dx} = -2xy
$$

$$
\frac{dy}{dx} = y₁ - y₂
$$

Con condiciones iniciales:

* `x₀ = 0`
* `y₁(0) = 1`
* `y₂(0) = 0`
* Paso `h = 0.1`
* Hasta `x_f = 0.4`

### **Entrada del usuario:**

```
x0 = 0
y1_0 = 1
y2_0 = 0
xf = 0.4
h = 0.1
```

### **Salida de consola:**

```
       x        y1        y2
    0.0000    1.0000    0.0000
    0.1000    1.0000    1.0000
    0.2000    0.9800    1.0000
    0.3000    0.9216    0.9800
    0.4000    0.8301    0.9432
```

🔎 **Por qué sí funciona:**
El paso es pequeño (`h = 0.1`) y el sistema no es rígido ni tiene variaciones abruptas, lo que permite que el método de Euler dé resultados razonablemente precisos.

---

## ❌ Ejercicio donde **no funciona bien** el método

En este ejercicio usamos un paso muy grande, lo que causa inestabilidad y errores numéricos crecientes.

### **Planteamiento:**

Usamos el mismo sistema:

$$
\frac{dy}{dx} = -2xy
$$

$$
\frac{dy}{dx} = y₁ - y₂
$$

Con condiciones iniciales:

* `x₀ = 0`
* `y₁(0) = 1`
* `y₂(0) = 0`
* Paso `h = 1.0`
* Hasta `x_f = 4.0`

### **Entrada del usuario:**

```
x0 = 0
y1_0 = 1
y2_0 = 0
xf = 4
h = 1
```

### **Salida de consola (poco confiable):**

```
       x        y1        y2
    0.0000    1.0000    0.0000
    1.0000   -1.0000    1.0000
    2.0000    3.0000   -1.0000
    3.0000  -15.0000    4.0000
    4.0000   75.0000  -11.0000
```

🚫 **Por qué no funciona bien:**

* El paso grande (`h = 1.0`) hace que el método acumule errores rápidamente.
* La solución empieza a oscilar o divergir.
* Este comportamiento no refleja la verdadera solución del sistema.

---
