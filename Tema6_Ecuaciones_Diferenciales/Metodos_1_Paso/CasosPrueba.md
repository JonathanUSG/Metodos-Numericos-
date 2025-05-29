# ✅ Casos de Prueba para el Método de Runge-Kutta 4to Orden

Este documento presenta dos casos de prueba aplicados al método de Runge-Kutta de cuarto orden con evaluación manual de expresiones.

---

## 🔹 Método Runge-Kutta

---

### ✔️ Caso Válido

**Parámetros:**

* Función: `x + y`
* Valor inicial: `x0 = 0`, `y0 = 1`
* Paso: `h = 0.1`
* Número de pasos: `5`

**Justificación:**

La función es válida, está compuesta por operaciones compatibles con el evaluador (`+`, `x`, `y`). No contiene paréntesis mal balanceados, ni funciones no soportadas.

---

### Iteraciones (salida paso a paso):

```text
Método Runge-Kutta sin ScriptEngine, funciones básicas
Ingresa la función f(x,y) (ejemplo: x + y, sin(x) - y, x * y): x + y
Ingresa x0: 0
Ingresa y0: 1
Ingresa paso h: 0.1
Número de pasos: 5
Paso 1: x = 0.10000, y = 1.11034
Paso 2: x = 0.20000, y = 1.23277
Paso 3: x = 0.30000, y = 1.36803
Paso 4: x = 0.40000, y = 1.51697
Paso 5: x = 0.50000, y = 1.68044
Resultado final: y(0.50000) = 1.68044
```

**Resultado esperado:**

Una aproximación válida a la solución de la EDO usando Runge-Kutta para la función `f(x,y) = x + y`.

---

### ❌ Caso Inválido

**Parámetros:**

* Función: `x ++ y`
* Valor inicial: `x0 = 0`, `y0 = 1`
* Paso: `h = 0.1`
* Número de pasos: `5`

**Justificación:**

La función ingresada tiene una **sintaxis inválida** debido al uso incorrecto del operador `++`. Esto no es interpretado correctamente por el evaluador manual y genera un valor no numérico o una evaluación incorrecta, afectando los resultados.

---

### Salida de Consola:

```text
Método Runge-Kutta sin ScriptEngine, funciones básicas
Ingresa la función f(x,y) (ejemplo: x + y, sin(x) - y, x * y): x ++ y
Ingresa x0: 0
Ingresa y0: 1
Ingresa paso h: 0.1
Número de pasos: 5
Error al evaluar factor: 
Paso 1: x = 0.10000, y = 1.00000
Error al evaluar factor: 
Paso 2: x = 0.20000, y = 1.00000
...
Resultado final: y(0.50000) = 1.00000
```

**Observaciones:**

* El evaluador no detecta el error como una excepción, pero interpreta el factor vacío como 0, afectando toda la evaluación.
* La salida de consola muestra repetidamente el mensaje: `Error al evaluar factor:` sin indicar claramente el origen del error.

---

### ✅ Recomendación

Agregar validaciones más robustas o un parser más completo (como exp4j o un sistema propio con gramática y árbol de sintaxis) para manejar errores semánticos y sintácticos antes de la evaluación.

---
