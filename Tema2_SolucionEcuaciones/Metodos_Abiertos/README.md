# Métodos Abiertos para la Solución de Ecuaciones

Los métodos abiertos no necesitan un intervalo inicial que contenga la raíz. Solo requieren una o dos aproximaciones iniciales. **Son más rápidos pero menos estables** que los métodos cerrados.

---

## Método del Punto Fijo

### Descripción
Reescribe la ecuación $f(x) = 0$ como $x = g(x)$ y usa iteraciones con:

### Fórmula
$$
x_{n+1} = g(x_n)
$$

### Ventajas
- Simple implementación.

### Desventajas
- Convergencia no garantizada.
- Requiere que $|g'(x)| < 1$ para converger.

---

## Método de Newton-Raphson

### Descripción
Utiliza una aproximación lineal a la función usando su derivada.

### Fórmula
$$
x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}
$$

### Ventajas
- Rápida convergencia cerca de la raíz.

### Desventajas
- Requiere calcular derivadas.
- Puede divergir si la aproximación inicial no es buena.

---

## Método de la Secante

### Descripción
Aproxima la derivada de $f(x)$ usando dos puntos anteriores. Es una alternativa a Newton sin derivada explícita.

### Fórmula
$$
x_{n+1} = x_n - f(x_n) \cdot \frac{x_n - x_{n-1}}{f(x_n) - f(x_{n-1})}
$$

### Ventajas
- No requiere derivada.
- Mejor convergencia que el punto fijo.

### Desventajas
- Necesita dos valores iniciales.
- Puede ser inestable en algunos casos.
