# ✅ Casos de Prueba para Métodos de Análisis

Este documento presenta dos casos de prueba: uno válido y uno inválido, aplicados a los métodos de **Correlación**, **Mínimos Cuadrados**, y **Regresión Lineal** usando los siguientes ejercicios:

---

## ✅ Método: Correlación

### Caso válido (funciona correctamente)

```java
double[] x = {1, 2, 3, 4, 5};
double[] y = {2, 4, 6, 8, 10}; // relación perfecta lineal
```

#### Salida de consola:

```
Coeficiente de correlación: 1.0000
Error Absoluto: 0.0000
Error Porcentual: 0.00%
Correlación Perfecta Positiva
```

---

### ❌ Caso inválido (no debe dar resultado por división entre cero)

```java
double[] x = {1, 1, 1, 1, 1}; // todos los valores iguales
double[] y = {2, 3, 4, 5, 6};
```

#### Salida de consola:

```
Puntos Utilizados:
x = 1.0, y = 2.0
...
Error: División entre cero
Coeficiente de correlación: 0.0000
```

---

## ✅ Método: Mínimos Cuadrados

### Caso válido (funciona correctamente)

```java
double[] x = {1, 2, 3, 4, 5};
double[] y = {2, 3, 5, 4, 6}; // dispersión normal
```

#### Salida de consola:

```
Ecuación ajustada: y = 0.8000x + 1.4000
Error Porcentual promedio: [valor positivo]
```

---

### ❌ Caso inválido (no debe dar resultado por división entre cero)

```java
double[] x = {2, 2, 2, 2, 2}; // todos los valores iguales
double[] y = {1, 2, 3, 4, 5};
```

#### Resultado:

* Al llegar a la línea:

```java
double pendiente = (n * sumaXY - sumaX * sumaY) / (n * sumaX2 - sumaX * sumaX);
```

* El denominador será cero, provocando:

```
ArithmeticException: / by zero
```

> **Nota:** este código no tiene manejo de excepción, por lo tanto el programa truena al intentar dividir.

---

## ✅ Método: Regresión Lineal

### Caso válido (funciona correctamente)

```java
double[] x = {1, 2, 3, 4, 5};
double[] y = {2, 3, 5, 4, 6};
```

#### Salida de consola:

```
Ecuación ajustada: y = 0.8000x + 1.4000
Error Porcentual promedio: [valor positivo]
```

---

### ❌ Caso inválido (no debe dar resultado por división entre cero)

```java
double[] x = {3, 3, 3, 3, 3}; // todos los valores iguales
double[] y = {2, 3, 4, 5, 6};
```

#### Resultado:

* El programa intentará calcular:

```java
(n * sumaX2 - sumaX * sumaX)
```

* Lo cual da `0`, entonces lanza:

```
ArithmeticException: / by zero
```

---
