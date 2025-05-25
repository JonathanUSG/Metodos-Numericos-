# 📊 Métodos de Pasos Múltiples

Esta carpeta contiene información teórica, fórmulas y código en Java para el método de **Adams-Bashforth**, un método numérico de pasos múltiples utilizado para resolver ecuaciones diferenciales ordinarias (EDOs).

---

## 📚 Información Teórica

### 🔹 Adams-Bashforth

El método de **Adams-Bashforth** es un método explícito de pasos múltiples que utiliza valores previos de la solución y la derivada para predecir el siguiente punto en la solución de una EDO de la forma:

$$
\frac{dy}{dt} = f(t, y), \quad y(t_0) = y_0
$$

La variante más común, **Adams-Bashforth de orden 4**, usa cuatro puntos previos para calcular el siguiente valor.

#### Fórmulas

Para un paso de $t_i$ a $t_{i+1} = t_i + h$, la solución $y_{i+1}$ se calcula como:

$$
y_{i+1} = y_i + \frac{h}{24} \left( 55f(t_i, y_i) - 59f(t_{i-1}, y_{i-1}) + 37f(t_{i-2}, y_{i-2}) - 9f(t_{i-3}, y_{i-3}) \right)
$$

Donde $f(t_i, y_i)$ son las evaluaciones de la derivada en los puntos previos.

✅ **Ventajas**:
- Eficiente, ya que solo requiere una evaluación de $f(t, y)$ por paso.
- Aprovecha puntos previos para mejorar la precisión.

⚠️ **Limitaciones**:
- Requiere puntos iniciales adicionales (puede generarse con métodos de un paso como Runge-Kutta).
- Menos estable para EDOs rígidas o con cambios bruscos.

---

## 📂 Contenido de la Carpeta

Esta carpeta incluye:

- 📄 Código en Java para implementar el método **Adams-Bashforth de orden 4** para resolver EDOs.
