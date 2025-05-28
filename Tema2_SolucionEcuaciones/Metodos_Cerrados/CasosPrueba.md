---
# ✅ Casos de Prueba para Métodos Cerrados

Este documento presenta dos casos de prueba: uno válido y uno inválido, aplicados a los métodos de **Bisección** y **Regla Falsa**, usando la función:

$$
f(x) = x^3 - x - 2
$$

---

## 🔹 Método de Bisección

### ✔️ Caso Válido

**Parámetros:**

- Intervalo: \$([1, 2]\$)
- Tolerancia: \$( \varepsilon = 0.01 \$)

**Justificación:**

$$
f(1) = -2,\quad f(2) = 4,\quad f(1) \cdot f(2) < 0 \Rightarrow \text{Sí hay raíz en } [1, 2]
$$

### Iteraciones:

| Iter | a     | b     | c     | f(c)     |
|------|-------|-------|-------|----------|
| 0    | 1.000 | 2.000 | 1.500 | -0.125   |
| 1    | 1.500 | 2.000 | 1.750 | 1.609375 |
| 2    | 1.500 | 1.750 | 1.625 | 0.666016 |
| 3    | 1.500 | 1.625 | 1.562 | 0.252197 |
| 4    | 1.500 | 1.562 | 1.531 | 0.059112 |
| 5    | 1.500 | 1.531 | 1.516 | -0.03435 |
| 6    | 1.516 | 1.531 | 1.523 | 0.01225  |

**Resultado esperado:**  
Raíz aproximada en \$( x \approx 1.523 \$) con \$( \varepsilon = 0.01 \$)

---
### Salida de Consola:
```java
Método de Bisección
Ingrese el límite inferior a: 1
Ingrese el límite superior b: 2
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
Iter  a            b            c            f(c)        
0     1.000000     2.000000     1.500000     -0.125000  
1     1.500000     2.000000     1.750000     1.609375   
2     1.500000     1.750000     1.625000     0.666016   
3     1.500000     1.625000     1.562500     0.252197   
4     1.500000     1.562500     1.531250     0.059112   
5     1.500000     1.531250     1.515625     -0.034351  
6     1.515625     1.531250     1.523438     0.012250   

La raíz aproximada es: 1.5234
```

---

### ❌ Caso Inválido

**Parámetros:**

- Intervalo: $\([1, 1]\$)

**Justificación:**

$$
f(1) = -2,\quad f(1) \cdot f(1) = 4 \not< 0 \Rightarrow \text{No se cumple el criterio}
$$

**Resultado esperado:**  
> Error: No se cumple \$( f(a) \cdot f(b) < 0 \$). No se puede aplicar el método.

---
### Salida de Consola: 
```java
Método de Bisección
Ingrese el límite inferior a: 1
Ingrese el límite superior b: 1
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
No se cumple el criterio f(a)*f(b) < 0. Cambie los valores de a y b.
```
---

## 🔹 Método de Regla Falsa

### ✔️ Caso Válido

**Parámetros:**

- Intervalo: \$([1, 2]\$)
- Tolerancia: \$( \varepsilon = 0.01 \$)

### Iteraciones (fórmula: \$( x_r = b - \frac{f(b)(a - b)}{f(a) - f(b)} \$)):

1.  
$$
x_r = 2 - \frac{4(1 - 2)}{-2 - 4} = 2 - \frac{-4}{-6} = 2 - 0.6667 = 1.3333,\quad f(1.3333) \approx -0.9629
$$

2.  
Nuevo intervalo: \$([1.3333, 2]\$)

$$
x_r = 2 - \frac{4(1.3333 - 2)}{-0.9629 - 4} \approx 1.4627,\quad f(1.4627) \approx -0.3333
$$

3.  
$$
x_r \approx 1.5040,\quad f(x_r) \approx -0.1007
$$

4.  
$$
x_r \approx 1.5192,\quad f(x_r) \approx -0.0276
$$

5.  
$$
x_r \approx 1.5236,\quad f(x_r) \approx -0.0079
$$

**Resultado esperado:**  
Raíz aproximada en \$( x \approx 1.5236 \$) con \$( \varepsilon = 0.01 \$)

---


### Salida de Consola:

```java
Método de la Regla Falsa
Ingrese el límite inferior a: 1
Ingrese el límite superior b: 2
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
Iter  a            b            c            f(c)        
0     1.000000     2.000000     1.333333     -0.962963  
1     1.333333     2.000000     1.462687     -0.333302  
2     1.462687     2.000000     1.504045     -0.100693  
3     1.504045     2.000000     1.519171     -0.027583  
4     1.519171     2.000000     1.523611     -0.007857  

La raíz aproximada es: 1.5236
```

### ❌ Caso Inválido

**Parámetros:**

- Intervalo: \$([1, 1]\$)

**Justificación:**

$$
f(1) = -2,\quad f(1) \cdot f(1) = 4 \not< 0
$$

**Resultado esperado:**  
> Error: No se cumple \$( f(a) \cdot f(b) < 0 \$). No se puede aplicar el método.

---

### Salida de Consola: 
```java
Método de la Regla Falsa
Ingrese el límite inferior a: 1
Ingrese el límite superior b: 1
Ingrese el error tolerado (por ejemplo 0.0001): 0.01
No se cumple el criterio f(a)*f(b) < 0. Cambie los valores de a y b.
```
---
