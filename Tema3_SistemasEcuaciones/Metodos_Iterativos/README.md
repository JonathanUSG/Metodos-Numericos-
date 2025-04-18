# Métodos Iterativos para Sistemas de Ecuaciones Lineales

A diferencia de los métodos directos, los métodos iterativos calculan una sucesión de aproximaciones que convergen a la solución deseada. Son útiles para sistemas grandes y dispersos.

---

## Métodos estudiados

### Método de Jacobi
Parte de un valor inicial para cada incógnita y repite cálculos usando exclusivamente los valores de la iteración anterior.

### Método de Gauss-Seidel
Al igual que Jacobi, pero utiliza los nuevos valores a medida que se van obteniendo dentro de la misma iteración.

---

## Requisitos de convergencia

Para garantizar la convergencia de estos métodos, se recomienda que el sistema sea diagonalmente dominante o cumpla ciertos criterios de estabilidad.

---

## 📂 Archivos incluidos

- Implementación en Java de ambos métodos.
- Comentarios explicativos en el código.

---

## Aplicación

Útiles cuando el sistema tiene muchas incógnitas y no se desea realizar operaciones directas que consuman demasiada memoria.

