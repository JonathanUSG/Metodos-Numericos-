# ✅ Casos de Prueba para Métodos de Análisis
Este documento presenta dos casos de prueba: uno válido y uno inválido, aplicados al método de Adams-Bashforth:

---
### ✅ Ejercicio de prueba válido (funciona correctamente)

**Planteamiento:**

Utiliza el método de Adams-Bashforth para aproximar la solución de la ecuación diferencial:

$$
\frac{dy}{dx} = -2xy
$$

Con condiciones iniciales:

* $x_0 = 0$
* $y_0 = 1$
* $x_f = 0.4$
* $h = 0.1$

**Entrada esperada por el usuario (por teclado):**

```
Ingresa el valor inicial de x (x0): 0
Ingresa el valor inicial de y (y0): 1
Ingresa el valor final de x (xf): 0.4
Ingresa el tamaño del paso (h): 0.1
```

**Salida (formato tabla):**

```
         x          y
     0.0000     1.0000
     0.1000     0.9802
     0.2000     0.9227
     0.3000     0.8351
     0.4000     0.7276
```

Esto **funciona** porque el método obtiene los tres primeros puntos con Runge-Kutta y luego usa Adams-Bashforth en el último paso (desde x=0.3 a x=0.4).

---

### ❌ Ejercicio de prueba inválido (no funciona)

**Planteamiento:**

Intentar usar el método con un número de pasos menor al requerido por Adams-Bashforth (es decir, que no se puedan calcular los tres primeros puntos con Runge-Kutta).

**Entrada:**

```
Ingresa el valor inicial de x (x0): 0
Ingresa el valor inicial de y (y0): 1
Ingresa el valor final de x (xf): 0.2
Ingresa el tamaño del paso (h): 0.1
```

**Explicación del fallo:**

El código requiere **mínimo 4 valores de `y`** para poder aplicar Adams-Bashforth (los tres primeros con Runge-Kutta y el resto con el método). Si solo hay dos pasos (`x = 0.0, 0.1, 0.2`), el método Runge-Kutta **no alcanza a generar 3 valores completos** y por lo tanto el código:

* **no entra al bucle de Adams-Bashforth**
* **solo imprime los tres puntos calculados con Runge-Kutta**
* o puede causar **un error por acceder a índices fuera de rango en el arreglo** en algunas versiones más exigentes del compilador.

**Salida de consola:**

```
         x          y
     0.0000     1.0000
     0.1000     0.9802
     0.2000     0.9227
```

Pero **no se aplica el método Adams-Bashforth**. Si el paso fuera aún más grande (por ejemplo, `xf = 0.1`), podría **lanzar error o comportamiento inesperado**.

---
